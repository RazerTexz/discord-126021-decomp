package com.fasterxml.jackson.databind.deser;

import com.fasterxml.jackson.databind.JsonMappingException;
import java.util.Iterator;
import java.util.List;
import p007b.p195g.p196a.p205c.p206a0.C2161i;
import p007b.p195g.p196a.p205c.p206a0.p207k.C2163a;

/* JADX INFO: loaded from: classes3.dex */
public class UnresolvedForwardReference extends JsonMappingException {
    private static final long serialVersionUID = 1;
    private C2163a _roid;
    private List<C2161i> _unresolvedIds;

    @Override // com.fasterxml.jackson.databind.JsonMappingException, com.fasterxml.jackson.core.JsonProcessingException, java.lang.Throwable
    public String getMessage() {
        String strM8742d = m8742d();
        if (this._unresolvedIds == null) {
            return strM8742d;
        }
        StringBuilder sb = new StringBuilder(strM8742d);
        Iterator<C2161i> it = this._unresolvedIds.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append('.');
        return sb.toString();
    }
}
