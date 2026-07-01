package com.google.gson.internal.bind;

import b.i.d.o;
import b.i.d.q.a;
import b.i.d.q.g;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Properties;

/* JADX INFO: loaded from: classes3.dex */
public final class MapTypeAdapterFactory implements o {
    public final g j;
    public final boolean k;

    public MapTypeAdapterFactory(g gVar, boolean z2) {
        this.j = gVar;
        this.k = z2;
    }

    @Override // b.i.d.o
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Type[] actualTypeArguments;
        Type type = typeToken.getType();
        if (!Map.class.isAssignableFrom(typeToken.getRawType())) {
            return null;
        }
        Class<?> clsE = a.e(type);
        if (type == Properties.class) {
            actualTypeArguments = new Type[]{String.class, String.class};
        } else {
            Type typeF = a.f(type, clsE, Map.class);
            actualTypeArguments = typeF instanceof ParameterizedType ? ((ParameterizedType) typeF).getActualTypeArguments() : new Type[]{Object.class, Object.class};
        }
        Type type2 = actualTypeArguments[0];
        return new MapTypeAdapterFactory$Adapter(this, gson, actualTypeArguments[0], (type2 == Boolean.TYPE || type2 == Boolean.class) ? TypeAdapters.f : gson.h(TypeToken.get(type2)), actualTypeArguments[1], gson.h(TypeToken.get(actualTypeArguments[1])), this.j.a(typeToken));
    }
}
