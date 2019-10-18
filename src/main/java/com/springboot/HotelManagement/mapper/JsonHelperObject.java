package com.springboot.HotelManagement.mapper;

import java.util.LinkedHashMap;

public class JsonHelperObject extends LinkedHashMap<String, Object> {

/**
*
*/
private static final long serialVersionUID = 1L;

public JsonHelperObject(boolean error, String message) {
this.put("error", error);
this.put("message", message);
}

public JsonHelperObject(boolean error, String message, Object object) {
this.put("error", error);
this.put("message", message);
this.put("Data", object);
}

}
