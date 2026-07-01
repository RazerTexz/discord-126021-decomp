package com.google.gson.internal.bind;

import b.d.b.a.a;
import b.i.d.o;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: classes3.dex */
public class TypeAdapters$32 implements o {
    public final /* synthetic */ Class j;
    public final /* synthetic */ TypeAdapter k;

    public TypeAdapters$32(Class cls, TypeAdapter typeAdapter) {
        this.j = cls;
        this.k = typeAdapter;
    }

    @Override // b.i.d.o
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        if (typeToken.getRawType() == this.j) {
            return this.k;
        }
        return null;
    }

    public String toString() {
        StringBuilder sbU = a.U("Factory[type=");
        a.k0(this.j, sbU, ",adapter=");
        sbU.append(this.k);
        sbU.append("]");
        return sbU.toString();
    }
}
