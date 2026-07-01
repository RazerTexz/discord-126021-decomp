package com.google.gson.internal.bind;

import b.d.b.a.a;
import b.i.d.o;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: classes3.dex */
public class TypeAdapters$35 implements o {
    public final /* synthetic */ Class j;
    public final /* synthetic */ TypeAdapter k;

    public TypeAdapters$35(Class cls, TypeAdapter typeAdapter) {
        this.j = cls;
        this.k = typeAdapter;
    }

    @Override // b.i.d.o
    public <T2> TypeAdapter<T2> create(Gson gson, TypeToken<T2> typeToken) {
        Class<? super T2> rawType = typeToken.getRawType();
        if (this.j.isAssignableFrom(rawType)) {
            return new TypeAdapters$35$1(this, rawType);
        }
        return null;
    }

    public String toString() {
        StringBuilder sbU = a.U("Factory[typeHierarchy=");
        a.k0(this.j, sbU, ",adapter=");
        sbU.append(this.k);
        sbU.append("]");
        return sbU.toString();
    }
}
