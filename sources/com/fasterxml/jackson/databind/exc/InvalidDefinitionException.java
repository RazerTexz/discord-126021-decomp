package com.fasterxml.jackson.databind.exc;

import com.fasterxml.jackson.databind.JsonMappingException;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p198b.AbstractC2110f;
import p007b.p195g.p196a.p205c.AbstractC2172c;
import p007b.p195g.p196a.p205c.AbstractC2360j;
import p007b.p195g.p196a.p205c.p210c0.AbstractC2198s;

/* JADX INFO: loaded from: classes3.dex */
public class InvalidDefinitionException extends JsonMappingException {
    public final AbstractC2360j _type;

    public InvalidDefinitionException(AbstractC2110f abstractC2110f, String str, AbstractC2360j abstractC2360j) {
        super(abstractC2110f, str);
        this._type = abstractC2360j;
    }

    public InvalidDefinitionException(AbstractC2108d abstractC2108d, String str, AbstractC2360j abstractC2360j) {
        super(abstractC2108d, str);
        this._type = abstractC2360j;
    }

    public InvalidDefinitionException(AbstractC2108d abstractC2108d, String str, AbstractC2172c abstractC2172c, AbstractC2198s abstractC2198s) {
        super(abstractC2108d, str);
        this._type = abstractC2172c == null ? null : abstractC2172c.f4626a;
    }
}
