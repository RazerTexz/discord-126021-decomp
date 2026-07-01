package com.fasterxml.jackson.core;

import b.g.a.b.JsonParser;
import com.fasterxml.jackson.core.exc.StreamReadException;

/* JADX INFO: loaded from: classes3.dex */
public class JsonParseException extends StreamReadException {
    private static final long serialVersionUID = 2;

    @Override // com.fasterxml.jackson.core.exc.StreamReadException, com.fasterxml.jackson.core.JsonProcessingException
    public /* bridge */ /* synthetic */ Object c() {
        return null;
    }

    @Override // com.fasterxml.jackson.core.exc.StreamReadException
    /* JADX INFO: renamed from: d */
    public JsonParser c() {
        return null;
    }

    @Override // com.fasterxml.jackson.core.exc.StreamReadException, com.fasterxml.jackson.core.JsonProcessingException, java.lang.Throwable
    public String getMessage() {
        return super.getMessage();
    }
}
