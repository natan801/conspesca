package br.com.conspesca.utils;

import java.util.List;

import org.primefaces.json.JSONArray;
import org.primefaces.json.JSONObject;
import org.primefaces.model.map.LatLng;

public class JsonParser {
	
	public String parserArrayToJson(List<LatLng> coordenadas){
		JSONArray jsonArray = new JSONArray();
		
		for(LatLng coordenada:coordenadas){
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("lat", coordenada.getLat());
			jsonObject.put("lng", coordenada.getLng());
			
			jsonArray.put(jsonObject);
		}
		

		return jsonArray.toString();
	}
	
}
