package br.com.witzler.clientes.domain.datas;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class QuantidadeDiasPorMes {
	
	public static int getQuantidadeDiasPorMes(int mes) {
		
		Calendar datas = new GregorianCalendar();
		datas.set(Calendar.MONTH, mes-1);
		int quantidadeDias = datas.getActualMaximum(Calendar.DAY_OF_MONTH);
		return quantidadeDias;
		
	}

}
