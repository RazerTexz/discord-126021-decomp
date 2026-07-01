package com.fasterxml.jackson.core;

import b.g.a.b.JsonGenerator;
import b.g.a.b.JsonLocation;

/* JADX INFO: loaded from: classes3.dex */
public class JsonGenerationException extends JsonProcessingException {
    private static final long serialVersionUID = 123;
    public transient JsonGenerator j;

    public JsonGenerationException(String str, JsonGenerator jsonGenerator) {
        super(str, (JsonLocation) null);
        this.j = jsonGenerator;
    }

    @Override // com.fasterxml.jackson.core.JsonProcessingException
    public Object c() {
        return this.j;
    }
}
