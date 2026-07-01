package com.google.gson.internal.bind;

import b.i.d.o;
import b.i.d.q.a;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes3.dex */
public class ArrayTypeAdapter$1 implements o {
    @Override // b.i.d.o
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Type type = typeToken.getType();
        boolean z2 = type instanceof GenericArrayType;
        if (!z2 && (!(type instanceof Class) || !((Class) type).isArray())) {
            return null;
        }
        Type genericComponentType = z2 ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
        return new ArrayTypeAdapter(gson, gson.h(TypeToken.get(genericComponentType)), a.e(genericComponentType));
    }
}
