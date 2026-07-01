package com.google.gson.internal.bind;

import b.i.d.o;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: classes3.dex */
public class TypeAdapters$31 implements o {
    public final /* synthetic */ TypeToken j;
    public final /* synthetic */ TypeAdapter k;

    public TypeAdapters$31(TypeToken typeToken, TypeAdapter typeAdapter) {
        this.j = typeToken;
        this.k = typeAdapter;
    }

    @Override // b.i.d.o
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        if (typeToken.equals(this.j)) {
            return this.k;
        }
        return null;
    }
}
