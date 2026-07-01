package com.fasterxml.jackson.databind.exc;

import b.g.a.b.d;
import b.g.a.b.f;
import b.g.a.c.c;
import b.g.a.c.c0.s;
import b.g.a.c.j;
import com.fasterxml.jackson.databind.JsonMappingException;

/* JADX INFO: loaded from: classes3.dex */
public class InvalidDefinitionException extends JsonMappingException {
    public final j _type;

    public InvalidDefinitionException(f fVar, String str, j jVar) {
        super(fVar, str);
        this._type = jVar;
    }

    public InvalidDefinitionException(d dVar, String str, j jVar) {
        super(dVar, str);
        this._type = jVar;
    }

    public InvalidDefinitionException(d dVar, String str, c cVar, s sVar) {
        super(dVar, str);
        this._type = cVar == null ? null : cVar.a;
    }
}
