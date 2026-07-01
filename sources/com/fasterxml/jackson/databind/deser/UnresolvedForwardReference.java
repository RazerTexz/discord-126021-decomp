package com.fasterxml.jackson.databind.deser;

import b.g.a.c.a0.i;
import b.g.a.c.a0.k.a;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class UnresolvedForwardReference extends JsonMappingException {
    private static final long serialVersionUID = 1;
    private a _roid;
    private List<i> _unresolvedIds;

    @Override // com.fasterxml.jackson.databind.JsonMappingException, com.fasterxml.jackson.core.JsonProcessingException, java.lang.Throwable
    public String getMessage() {
        String strD = d();
        if (this._unresolvedIds == null) {
            return strD;
        }
        StringBuilder sb = new StringBuilder(strD);
        Iterator<i> it = this._unresolvedIds.iterator();
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
