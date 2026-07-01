package com.google.gson.internal.bind;

import b.i.d.o;
import b.i.d.q.a;
import b.i.d.q.g;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
public final class CollectionTypeAdapterFactory implements o {
    public final g j;

    public CollectionTypeAdapterFactory(g gVar) {
        this.j = gVar;
    }

    @Override // b.i.d.o
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        if (!Collection.class.isAssignableFrom(rawType)) {
            return null;
        }
        Type typeF = a.f(type, rawType, Collection.class);
        if (typeF instanceof WildcardType) {
            typeF = ((WildcardType) typeF).getUpperBounds()[0];
        }
        Type type2 = typeF instanceof ParameterizedType ? ((ParameterizedType) typeF).getActualTypeArguments()[0] : Object.class;
        return new CollectionTypeAdapterFactory$Adapter(gson, type2, gson.h(TypeToken.get(type2)), this.j.a(typeToken));
    }
}
