package com.fasterxml.jackson.core;

import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p198b.C2109e;

/* JADX INFO: loaded from: classes3.dex */
public class JsonGenerationException extends JsonProcessingException {
    private static final long serialVersionUID = 123;

    /* JADX INFO: renamed from: j */
    public transient AbstractC2108d f19660j;

    public JsonGenerationException(String str, AbstractC2108d abstractC2108d) {
        super(str, (C2109e) null);
        this.f19660j = abstractC2108d;
    }

    @Override // com.fasterxml.jackson.core.JsonProcessingException
    /* JADX INFO: renamed from: c */
    public Object mo8737c() {
        return this.f19660j;
    }
}
