package com.juanp.principal;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public final class ConvertidorJson {

	public static String convertirObjetoAString(Object obj) {
		String str = new Gson().toJson(obj);
		return str;
	}

	public static JsonObject convertirObjectoAJsonObject(Object obj) {
		JsonObject jsobj = new Gson().toJsonTree(obj).getAsJsonObject();
		return jsobj;
	}
}
