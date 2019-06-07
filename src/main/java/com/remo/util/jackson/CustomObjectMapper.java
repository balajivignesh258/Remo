package com.remo.util.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.DefaultSerializerProvider;

public class CustomObjectMapper extends ObjectMapper {

	private static final long serialVersionUID = 5889397446644413574L;

	public CustomObjectMapper() {
		super();

		DefaultSerializerProvider.Impl sp = new DefaultSerializerProvider.Impl();
		sp.setNullValueSerializer(new NullSerializer());
		this.setSerializerProvider(sp);
	}
}