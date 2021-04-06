package com.deadsystem.apievoluum.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.deadsystem.apievoluum.dto.CidadeDto;

public class GeradorCsv {

	public static void gerarCsvDownload(HttpServletResponse response, List<CidadeDto> listaEstados) {
		response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=states_and_cities_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);
        ICsvBeanWriter csvWriter;
		try {
			csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
			String[] csvHeader   = {"idEstado", "siglaEstado", "regiaoNome", "nomeCidade", "nomeMesorregiao", "nomeFormatado"};
	        String[] nameMapping = {"idEstado", "siglaEstado", "regiaoNome", "nomeCidade", "nomeMesorregiao", "nomeFormatado"};
	         
	        csvWriter.writeHeader(csvHeader);
	         
	        for (CidadeDto estado : listaEstados) {
	            csvWriter.write(estado, nameMapping);
	        }
	        csvWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
}
