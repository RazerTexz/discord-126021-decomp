package com.fasterxml.jackson.core;

import b.g.a.b.d;
import b.g.a.b.e;

/* JADX INFO: loaded from: classes3.dex */
public class JsonGenerationException extends JsonProcessingException {
    private static final long serialVersionUID = 123;
    public transient d j;

    public JsonGenerationException(String str, d dVar) {
        super(str, (e) null);
        this.j = dVar;
    }

    @Override // com.fasterxml.jackson.core.JsonProcessingException
    public Object c() {
        return this.j;
    }
}
