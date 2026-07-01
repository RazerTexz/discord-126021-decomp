package com.google.gson.internal.bind;

import b.i.a.f.e.o.f;
import b.i.d.i;
import b.i.d.m;
import b.i.d.o;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: classes3.dex */
public final class TreeTypeAdapter$SingleTypeFactory implements o {
    public final TypeToken<?> j;
    public final boolean k;
    public final Class<?> l;
    public final m<?> m;
    public final i<?> n;

    public TreeTypeAdapter$SingleTypeFactory(Object obj, TypeToken<?> typeToken, boolean z2, Class<?> cls) {
        m<?> mVar = obj instanceof m ? (m) obj : null;
        this.m = mVar;
        i<?> iVar = obj instanceof i ? (i) obj : null;
        this.n = iVar;
        f.w((mVar == null && iVar == null) ? false : true);
        this.j = typeToken;
        this.k = z2;
        this.l = null;
    }

    @Override // b.i.d.o
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        boolean zIsAssignableFrom;
        TypeToken<?> typeToken2 = this.j;
        if (typeToken2 != null) {
            zIsAssignableFrom = typeToken2.equals(typeToken) || (this.k && this.j.getType() == typeToken.getRawType());
        } else {
            zIsAssignableFrom = this.l.isAssignableFrom(typeToken.getRawType());
        }
        if (zIsAssignableFrom) {
            return new TreeTypeAdapter(this.m, this.n, gson, typeToken, this);
        }
        return null;
    }
}
