package com.fasterxml.jackson.databind.exc;

import b.g.a.b.JsonGenerator;
import b.g.a.b.JsonParser;
import b.g.a.c.BeanDescription;
import b.g.a.c.JavaType;
import b.g.a.c.c0.BeanPropertyDefinition;
import com.fasterxml.jackson.databind.JsonMappingException;

/* JADX INFO: loaded from: classes3.dex */
public class InvalidDefinitionException extends JsonMappingException {
    public final JavaType _type;

    public InvalidDefinitionException(JsonParser jsonParser, String str, JavaType javaType) {
        super(jsonParser, str);
        this._type = javaType;
    }

    public InvalidDefinitionException(JsonGenerator jsonGenerator, String str, JavaType javaType) {
        super(jsonGenerator, str);
        this._type = javaType;
    }

    public InvalidDefinitionException(JsonGenerator jsonGenerator, String str, BeanDescription beanDescription, BeanPropertyDefinition beanPropertyDefinition) {
        super(jsonGenerator, str);
        this._type = beanDescription == null ? null : beanDescription.a;
    }
}
