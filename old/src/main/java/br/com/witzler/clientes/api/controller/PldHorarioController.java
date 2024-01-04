package br.com.witzler.clientes.api.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.witzler.clientes.domain.dto.PldHorarioDTO;
import br.com.witzler.clientes.domain.entity.PldHorario;
import br.com.witzler.clientes.domain.repositorio.PldHorarioRepositorio;

@RestController
@RequestMapping("/api/")
public class PldHorarioController {
	
	@Autowired
	private PldHorarioRepositorio pldRepositorio;
	
	@GetMapping("pldhorario")
	ArrayList<PldHorarioDTO> listaPldHorario( @RequestParam("date_ref") String date_ref,
											  @RequestParam("region") Integer region)	{
		
		
		String[] dataB = date_ref.split("-");
		Date datab = new Date((Integer.valueOf(dataB[0])-1900),
				Integer.valueOf(dataB[1])-1,
				Integer.valueOf(dataB[2]));
		
		List<PldHorario> pldhorario = pldRepositorio.listandoPld(datab, region);
		
		ArrayList<PldHorarioDTO> ConjuntoPldHorario = new ArrayList<>();
		
		for (int i=0; i<pldhorario.size(); i++)
		{
			PldHorarioDTO pld = new PldHorarioDTO();
			pld.setId(pldhorario.get(i).getId());
			pld.setDate_ref(pldhorario.get(i).getDate_ref());
			pld.setDate_updated(pldhorario.get(i).getDate_updated());
			pld.setHour(pldhorario.get(i).getHour());
			pld.setRegion(pldhorario.get(i).getRegion());
			pld.setValue(pldhorario.get(i).getValue());
			
			ConjuntoPldHorario.add(pld);
		}
		
		return ConjuntoPldHorario;
		
	}
	

}
