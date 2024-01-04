package br.com.witzler.clientes.api.controller;

import br.com.witzler.clientes.domain.datas.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.witzler.clientes.domain.dto.MediaFatorPotenciaDTO;
import br.com.witzler.clientes.domain.dto.MedidasDTO;
import br.com.witzler.clientes.domain.dto.MedidasForaPontaDTO;
import br.com.witzler.clientes.domain.dto.MedidasForaPontaDiarioDTO;
import br.com.witzler.clientes.domain.dto.MedidasPeriodoAtivoCDTO;
import br.com.witzler.clientes.domain.dto.MedidasPeriodoDTO;
import br.com.witzler.clientes.domain.dto.MedidasPeriodoFatorPotenciaHoraDTO;
import br.com.witzler.clientes.domain.entity.Medidas;
import br.com.witzler.clientes.domain.entity.Medidas2;
import br.com.witzler.clientes.domain.entity.PerformanceUnidades;
import br.com.witzler.clientes.domain.repositorio.MedidasRepositorio;
import br.com.witzler.clientes.domain.repositorio.UnidadesRepositorio;
import br.com.witzler.clientes.security.jwt.JwtSecurityValidateToken;

@RestController
@RequestMapping("/api/")
public class MedidasController {

	@Autowired
	private MedidasRepositorio medidasRepositorio;
	
	@Autowired
	private UnidadesRepositorio unidadesRepositorio;

	@Value("${security.jwt.chave-assinatura}")
	private String chaveAssinatura;

	/**
	 * 27/05/2020 TI Witzler Team Rota que retorna todas as medidas SELECT * FROM
	 * pc.web_listar_medidas W
	 * 
	 * Comentado por joao.jacomo em 10/11/2023 porque este endpoint não estava sendo utilizado.<br>
	 */
//	@GetMapping("/medidas") // DONE
//	public List<Medidas> listaMedidas() {
//		// return medidasRepositorio.findAll();
//		return medidasRepositorio.listarMedidasTudo();
//	}

	/**
	 * 27/05/2020 TI Witzler Team Rota que retorna medidas de um periodo mostrando
	 * valores de ponta e fora ponta 'Select t1.foraPonta,t2.ponta,t1.data_medicao
	 * From ((SELECT Sum(ativo_c) AS foraPonta, data_medicao FROM
	 * pc.web_listar_medidas WHERE unidade_id = $$' + data.unidade_id + '$$ AND
	 * (data_medicao >= $$' + data.dataInicial + '$$ AND data_medicao <= $$' +
	 * data.dataFinal + '$$) AND (hora_do_dia >=18 and hora_do_dia <= 20) GROUP BY
	 * data_medicao ORDER BY data_medicao ASC)) AS t1,((SELECT Sum(ativo_c) as
	 * Ponta, data_medicao FROM pc.web_listar_medidas WHERE unidade_id = $$' +
	 * data.unidade_id + '$$ AND (data_medicao >= $$' + data.dataInicial + '$$ AND
	 * data_medicao <= $$' + data.dataFinal + '$$) AND ((hora_do_dia >=0 and
	 * hora_do_dia <=17) or (hora_do_dia >=21 and hora_do_dia <=23)) GROUP BY
	 * data_medicao ORDER BY data_medicao ASC)) AS t2 WHERE t2.data_medicao =
	 * t1.data_medicao ORDER BY t2.data_medicao ASC;
	 */
	@GetMapping("/medidas/periodo/fora/ponta")
	MedidasForaPontaDTO listaMedidasPeriodoForaPonta(@RequestParam("unidade_id") Integer unidade_id,
			// @RequestParam("dataInicial") @DateTimeFormat(pattern="yyyy/MM/dd") Date
			// dateReceived
			@RequestParam("dataInicial") String dataInicial, @RequestParam("dataFinal") String dataFinal) {
		System.out.println(dataInicial);
		String[] datai = dataInicial.split("-");
		String[] dataf = dataFinal.split("-");
		Date dataIni = new Date((Integer.valueOf(datai[0]) - 1900), Integer.valueOf(datai[1]) - 1,
				Integer.valueOf(datai[2]));
		Date dataFin = new Date((Integer.valueOf(dataf[0]) - 1900), Integer.valueOf(dataf[1]) - 1,
				Integer.valueOf(dataf[2]));

		/*VALIDAÇÃO DO TOKEN PELO UNIT ID*/
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		List<Medidas> medidas = new ArrayList<>();
		if(decriptToken.isUnidadeFromClient(unidadesRepositorio, unidade_id)) {
			medidas = medidasRepositorio.listarMedidasPeriodoForaPonta(unidade_id, dataIni, dataFin); // REQUEST
		}
		/*FIM VALIDAÇÃO DO TOKEN PELO UNIT ID*/

		MedidasForaPontaDTO mfp = new MedidasForaPontaDTO();
		double a = 0;
		for (int i = 0; i < medidas.size(); i++) {
			if (medidas.get(i).getDia_da_semana() == 6 || medidas.get(i).getDia_da_semana() == 7) {
				a = a + medidas.get(i).getAtivo_c();
				// System.out.println(medidas.get(i).getAtivo_c());
				mfp.setForaPonta(mfp.getForaPonta() + medidas.get(i).getAtivo_c());
//					System.out.println(mfp.getForaPonta() + medidas.get(i).getAtivo_c());
			} else {
				if (medidas.get(i).getHora_do_dia() >= 18 && medidas.get(i).getHora_do_dia() <= 20) {
					// System.out.println(medidas.get(i).getAtivo_c());
					a = a + medidas.get(i).getAtivo_c();
					mfp.setPonta(mfp.getPonta() + medidas.get(i).getAtivo_c());
					mfp.setData_medicao(medidas.get(i).getData_medicao());
				} else {
					a = a + medidas.get(i).getAtivo_c();
					// System.out.println(medidas.get(i).getAtivo_c());
					mfp.setForaPonta(mfp.getForaPonta() + medidas.get(i).getAtivo_c());
					// System.out.println(mfp.getForaPonta() + medidas.get(i).getAtivo_c());
				}
			}
		}
		// System.out.println("Soma do ativo no dia é : " + a);

		// return medidas;
		return mfp;

		// return mfp.getForaPonta();
	}

	/**
	 * 27/05/2020 TI Witzler Team Rota que retorna medidas de ponta e fora ponta
	 * diario 'Select t1.foraPonta,t2.ponta,t1.data_medicao From ((SELECT
	 * Sum(ativo_c) AS foraPonta, data_medicao FROM pc.web_listar_medidas WHERE
	 * unidade_id = $$' + data.unidade_id + '$$ AND (data_medicao >= $$' +
	 * data.dataInicial + '$$ AND data_medicao <= $$' + data.dataFinal + '$$) AND
	 * (hora_do_dia >=18 and hora_do_dia <= 20) GROUP BY data_medicao ORDER BY
	 * data_medicao ASC)) AS t1,((SELECT Sum(ativo_c) as Ponta, data_medicao FROM
	 * pc.web_listar_medidas WHERE unidade_id = $$' + data.unidade_id + '$$ AND
	 * (data_medicao >= $$' + data.dataInicial + '$$ AND data_medicao <= $$' +
	 * data.dataFinal + '$$) AND ((hora_do_dia >=0 and hora_do_dia <=17) or
	 * (hora_do_dia >=21 and hora_do_dia <=23)) GROUP BY data_medicao ORDER BY
	 * data_medicao ASC)) AS t2 WHERE t2.data_medicao = t1.data_medicao ORDER BY
	 * t2.data_medicao ASC;
	 */
	@GetMapping("/medidas/periodo/fora/ponta/diario")
	ArrayList<MedidasForaPontaDiarioDTO> listaPontaForaPontaDiario(@RequestParam("unidade_id") Integer unidade_id,
			@RequestParam("dataInicial") String dataInicial, @RequestParam("dataFinal") String dataFinal) {

		// Realizando tratamento das datas
		String[] datai = dataInicial.split("-");
		String[] dataf = dataFinal.split("-");
		Date dataIni = new Date((Integer.valueOf(datai[0]) - 1900), Integer.valueOf(datai[1]) - 1,
				Integer.valueOf(datai[2]));
		Date dataFin = new Date((Integer.valueOf(dataf[0]) - 1900), Integer.valueOf(dataf[1]) - 1,
				Integer.valueOf(dataf[2]));

		/*VALIDAÇÃO DO TOKEN PELO UNIT ID*/
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		List<Medidas> medidas = new ArrayList<>();
		if(decriptToken.isUnidadeFromClient(unidadesRepositorio, unidade_id)) {
			medidas = medidasRepositorio.listarMedidasPeriodoForaPontaDiario(unidade_id, dataIni, dataFin); // REQUEST
		}
		/*FIM VALIDAÇÃO DO TOKEN PELO UNIT ID*/
		
		// MedidasForaPontaDiarioDTO mfp = new MedidasForaPontaDiarioDTO();

		Calendar mesAtual = Calendar.getInstance();
		int mesatual = mesAtual.get(Calendar.MONTH);

		int qDias = getQuantidadeDiasPorMes(mesatual);

		Date datax = new Date(medidas.get(0).getData_medicao().getYear(), medidas.get(0).getData_medicao().getMonth(),
				medidas.get(0).getData_medicao().getDay());

		// System.out.println("Data é " + datax);

		ArrayList<MedidasForaPontaDiarioDTO> ConjuntoDeMedicoes = new ArrayList<>();
		for (int i = 0; i < medidas.size(); i++) {
			boolean jaExisteAData = false;
			for (int j = 0; j < ConjuntoDeMedicoes.size(); j++) {
				if (medidas.get(i).getData_medicao().equals(ConjuntoDeMedicoes.get(j).getData_medicao())) {
					jaExisteAData = true;
				}
			}
			if (!jaExisteAData) {
				MedidasForaPontaDiarioDTO mfp = new MedidasForaPontaDiarioDTO();
				mfp.setData_medicao(medidas.get(i).getData_medicao());
				ConjuntoDeMedicoes.add(mfp);
			}

		}
		System.out.println("numero de objs dentro do vetor " + ConjuntoDeMedicoes.size());

		ArrayList<MedidasForaPontaDiarioDTO> ConjuntoMedicoes = new ArrayList<>();
		for (int i = 0; i < medidas.size(); i++) {
			for (int j = 0; j < ConjuntoDeMedicoes.size(); j++) {
				if (medidas.get(i).getData_medicao().equals(ConjuntoDeMedicoes.get(j).getData_medicao())) {
					if (medidas.get(i).getDia_da_semana() == 6 || medidas.get(i).getDia_da_semana() == 7) {
						ConjuntoDeMedicoes.get(j)
								.setForaPonta(ConjuntoDeMedicoes.get(j).getForaPonta() + medidas.get(i).getAtivo_c());
					} else {
						if (medidas.get(i).getHora_do_dia() >= 18 && medidas.get(i).getHora_do_dia() <= 20) {
							ConjuntoDeMedicoes.get(j)
									.setPonta(ConjuntoDeMedicoes.get(j).getPonta() + medidas.get(i).getAtivo_c());
						} else {
							ConjuntoDeMedicoes.get(j).setForaPonta(
									ConjuntoDeMedicoes.get(j).getForaPonta() + medidas.get(i).getAtivo_c());
						}
					}
				}
			}
		}

		for (int j = 0; j < ConjuntoDeMedicoes.size(); j++) {
			MedidasForaPontaDiarioDTO mfpd = new MedidasForaPontaDiarioDTO();
			mfpd.setPonta(ConjuntoDeMedicoes.get(j).getPonta());
			mfpd.setForaPonta(ConjuntoDeMedicoes.get(j).getForaPonta());
			System.out.println("Para esta data " + ConjuntoDeMedicoes.get(j).getData_medicao() + " este valor ponta "
					+ ConjuntoDeMedicoes.get(j).getPonta());
			System.out.println("Para esta data " + ConjuntoDeMedicoes.get(j).getData_medicao()
					+ " este valor fora ponta " + ConjuntoDeMedicoes.get(j).getForaPonta());
		}

		return ConjuntoDeMedicoes;
	}

	@GetMapping("/media/fator/potencia/capacitivo")
	ArrayList<MediaFatorPotenciaDTO> listaMediaFatorPontenciaCapacitivo(@RequestParam("unidade_id") Integer unidade_id,
			@RequestParam("data_inicial") String data_inicial, @RequestParam("data_final") String data_final) {

		String[] datai = data_inicial.split("-");
		String[] dataf = data_final.split("-");
		Date dataIni = new Date((Integer.valueOf(datai[0]) - 1900), Integer.valueOf(datai[1]) - 1,
				Integer.valueOf(datai[2]));
		Date dataFin = new Date((Integer.valueOf(dataf[0]) - 1900), Integer.valueOf(dataf[1]) - 1,
				Integer.valueOf(dataf[2]));
		
		/*VALIDAÇÃO DO TOKEN PELO UNIT ID*/
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		List<Medidas> medidas = new ArrayList<>();
		if(decriptToken.isUnidadeFromClient(unidadesRepositorio, unidade_id)) {
			medidas = medidasRepositorio.listarMediaFatorPotenciaCapacitivo(unidade_id, dataIni, dataFin); // REQUEST
		}
		/*FIM VALIDAÇÃO DO TOKEN PELO UNIT ID*/

		// System.out.println("Medidas: " + medidas);

		// MediaFatorPotenciaDTO mfpdto = new MediaFatorPotenciaDTO();
		// double media = 0;

		ArrayList<MediaFatorPotenciaDTO> ConjuntoMediaFatorPotenciaCapacitivo = new ArrayList<>();

		for (int i = 0; i < medidas.size(); i++) {
			MediaFatorPotenciaDTO mfpdto = new MediaFatorPotenciaDTO();
			mfpdto.setAtivo_c(medidas.get(i).getAtivo_c());
			mfpdto.setReativo_c(medidas.get(i).getReativo_c());

			ConjuntoMediaFatorPotenciaCapacitivo.add(mfpdto);

			// System.out.println("Printando medidas: " + medidas);
			// mfpdto.setReativo_c(medidas.get(i).getReativo_c());
			// mfpdto.setAtivo_c(medidas.get(i).getAtivo_c());

			// mfpdto.setCapacitivo(medidas.get(i).getCapacitivo());
			// mfpdto.setIndutivo(medidas.get(i).getIndutivo());
		}
		System.out.println("Printando o conjunto: " + ConjuntoMediaFatorPotenciaCapacitivo);
		// System.out.println("Valor Capacitivo: " + media);
		// media = Math.cos(atan(ConjuntoMediaFatorPotenciaCapacitivo));
		return ConjuntoMediaFatorPotenciaCapacitivo;

	}

	@GetMapping("/media/fator/potencia/indutivo")
	ArrayList<MediaFatorPotenciaDTO> listaMediaFatorPontenciaIndutivo(@RequestParam("unidade_id") Integer unidade_id,
			@RequestParam("data_inicial") String data_inicial, @RequestParam("data_final") String data_final) {

		String[] datai = data_inicial.split("-");
		String[] dataf = data_final.split("-");
		Date dataIni = new Date((Integer.valueOf(datai[0]) - 1900), Integer.valueOf(datai[1]) - 1,
				Integer.valueOf(datai[2]));
		Date dataFin = new Date((Integer.valueOf(dataf[0]) - 1900), Integer.valueOf(dataf[1]) - 1,
				Integer.valueOf(dataf[2]));

//		System.out.println(unidade_id);
//		System.out.println(data_inicial);
//		System.out.println(data_final);
		
		/*VALIDAÇÃO DO TOKEN PELO UNIT ID*/
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		List<Medidas> medidas = new ArrayList<>();
		if(decriptToken.isUnidadeFromClient(unidadesRepositorio, unidade_id)) {
			medidas = medidasRepositorio.listarMediaFatorPotenciaIndutivo(unidade_id, dataIni, dataFin); // REQUEST
		}
		/*FIM VALIDAÇÃO DO TOKEN PELO UNIT ID*/

		// System.out.println("Medidas: " + medidas);

		// MediaFatorPotenciaDTO mfpdto = new MediaFatorPotenciaDTO();
		// double media = 0;

		ArrayList<MediaFatorPotenciaDTO> ConjuntoMediaFatorPotenciaIndutivo = new ArrayList<>();

		for (int i = 0; i < medidas.size(); i++) {
			MediaFatorPotenciaDTO mfpdto = new MediaFatorPotenciaDTO();
			mfpdto.setAtivo_c(medidas.get(i).getAtivo_c());
			mfpdto.setReativo_c(medidas.get(i).getReativo_c());
			// mfpdto.setIndutivo(medidas.get(i).get);

			// System.out.println(medidas);

			ConjuntoMediaFatorPotenciaIndutivo.add(mfpdto);

			// System.out.println("Printando medidas: " + medidas);
			// mfpdto.setReativo_c(medidas.get(i).getReativo_c());
			// mfpdto.setAtivo_c(medidas.get(i).getAtivo_c());

			// mfpdto.setCapacitivo(medidas.get(i).getCapacitivo());
			// mfpdto.setIndutivo(medidas.get(i).getIndutivo());
		}
		System.out.println("Printando o conjunto: " + ConjuntoMediaFatorPotenciaIndutivo);
		// System.out.println("Valor Capacitivo: " + media);
		// media = Math.cos(atan(ConjuntoMediaFatorPotenciaCapacitivo));
		return ConjuntoMediaFatorPotenciaIndutivo;

	}

	// medidas/periodo
	@GetMapping("/medidas/periodo")
	ArrayList<MedidasPeriodoDTO> listaMedidasPeriodo(@RequestParam("unidade_id") Integer unidade_id,
			@RequestParam("data_inicial") String data_inicial, @RequestParam("data_final") String data_final) {
		String[] datai = data_inicial.split("-");
		String[] dataf = data_final.split("-");
		Date dataIni = new Date((Integer.valueOf(datai[0]) - 1900), Integer.valueOf(datai[1]) - 1,
				Integer.valueOf(datai[2]));
		Date dataFin = new Date((Integer.valueOf(dataf[0]) - 1900), Integer.valueOf(dataf[1]) - 1,
				Integer.valueOf(dataf[2]));
		
		/*VALIDAÇÃO DO TOKEN PELO UNIT ID*/
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		List<Medidas> medidas = new ArrayList<>();
		if(decriptToken.isUnidadeFromClient(unidadesRepositorio, unidade_id)) {
			medidas = medidasRepositorio.listarMedidasPeriodo(unidade_id, dataIni, dataFin); // REQUEST
		}
		/*FIM VALIDAÇÃO DO TOKEN PELO UNIT ID*/

		ArrayList<MedidasPeriodoDTO> ConjuntoMedidasPeriodo = new ArrayList<>();

		for (int i = 0; i < medidas.size(); i++) {
			MedidasPeriodoDTO mpdto = new MedidasPeriodoDTO();
			mpdto.setAtivo_c(medidas.get(i).getAtivo_c());
			mpdto.setAtivo_g(medidas.get(i).getAtivo_g());
			mpdto.setData_medicao(medidas.get(i).getData_medicao());
			mpdto.setDia_da_semana(medidas.get(i).getDia_da_semana());
			mpdto.setHora_do_dia(medidas.get(i).getHora_do_dia());
			mpdto.setId_medidas(medidas.get(i).getId_medidas());
			mpdto.setReativo_c(medidas.get(i).getReativo_c());
			mpdto.setReativo_g(medidas.get(i).getReativo_g());
			mpdto.setStatus(medidas.get(i).getStatus());
			mpdto.setTipo_medida(medidas.get(i).getTipo_medida());
			mpdto.setUnidade_id(medidas.get(i).getUnidade_id());
			ConjuntoMedidasPeriodo.add(mpdto);
		}

		return ConjuntoMedidasPeriodo;
	}

	/*
	@PostMapping("/medidas/periodoPost")
	ArrayList<MedidasPeriodoDTO> listaMedidasPeriodoPost(@RequestBody ) {
		
		return null;
	}*/

	@GetMapping("/periodo/ativoc")
	ArrayList<MedidasPeriodoAtivoCDTO> listaMedidasPeriodoC(@RequestParam("unidade_id") Integer unidade_id,
			@RequestParam("data_busca") String data_busca) {

		String[] dataB = data_busca.split("-");
		Date datab = new Date((Integer.valueOf(dataB[0]) - 1900), Integer.valueOf(dataB[1]) - 1,
				Integer.valueOf(dataB[2]));
		
		/*VALIDAÇÃO DO TOKEN PELO UNIT ID*/
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		List<Medidas> medidas = new ArrayList<>();
		if(decriptToken.isUnidadeFromClient(unidadesRepositorio, unidade_id)) {
			medidas = medidasRepositorio.listarPeriodoAtivoC(unidade_id, datab); // REQUEST
		}
		/*FIM VALIDAÇÃO DO TOKEN PELO UNIT ID*/

		ArrayList<MedidasPeriodoAtivoCDTO> ConjuntoAtivoC = new ArrayList<>();

		for (int i = 0; i < medidas.size(); i++) {
			MedidasPeriodoAtivoCDTO mpac = new MedidasPeriodoAtivoCDTO();

			mpac.setAtivo_c(medidas.get(i).getAtivo_c());

			ConjuntoAtivoC.add(mpac);

		}

		return ConjuntoAtivoC;

	}

	@GetMapping("/ativoc/co2")
	double listaAtivoCCO2(@RequestParam("id_unidades") Integer id_unidades) {

		/*VALIDAÇÃO DO TOKEN PELO UNIT ID*/
		JwtSecurityValidateToken decriptToken = new JwtSecurityValidateToken(chaveAssinatura);
		List<Medidas> medidas = new ArrayList<>();
		if(decriptToken.isUnidadeFromClient(unidadesRepositorio, id_unidades)) {
			medidas = medidasRepositorio.listandoCO2(id_unidades); // REQUEST
		}
		/*FIM VALIDAÇÃO DO TOKEN PELO UNIT ID*/

		// ArrayList<MedidasDTO> Conjunto = new ArrayList<>();

		double somando = 0;

		for (int i = 0; i < medidas.size(); i++) {
			// MedidasDTO mdto = new MedidasDTO();

			somando = somando + medidas.get(i).getAtivo_c();

			// Conjunto.add(mdto);

			// System.out.println("Total Ativo_C: "+somando);

		}

		return somando;

	}

	public static int getQuantidadeDiasPorMes(int mes) {

		Calendar datas = new GregorianCalendar();
		datas.set(Calendar.MONTH, mes - 1);
		int quantidadeDias = datas.getActualMaximum(Calendar.DAY_OF_MONTH);
		System.out.println(quantidadeDias);
		return quantidadeDias;

	}

}
