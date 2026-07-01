package com.discord.gsonutils;

import b.i.d.o;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map$Entry;

/* JADX INFO: loaded from: classes.dex */
public final class RuntimeTypeAdapterFactory<T> implements o {
    public final Class<?> j;
    public final String k;
    public final Map<String, Class<?>> l = new LinkedHashMap();
    public final Map<Class<?>, String> m = new LinkedHashMap();
    public final boolean n;
    public final Class<?> o;

    public RuntimeTypeAdapterFactory(Class<?> cls, String str, boolean z2, Class<?> cls2) {
        if (str == null || cls == null) {
            throw null;
        }
        this.j = cls;
        this.k = str;
        this.n = z2;
        this.o = cls2;
    }

    @Override // b.i.d.o
    public <R> TypeAdapter<R> create(Gson gson, TypeToken<R> typeToken) {
        if (typeToken.getRawType() != this.j) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        Class<?> cls = this.o;
        TypeAdapter<T> typeAdapterJ = cls != null ? gson.j(this, TypeToken.get((Class) cls)) : null;
        for (Map$Entry<String, Class<?>> map$Entry : this.l.entrySet()) {
            TypeAdapter<T> typeAdapterJ2 = gson.j(this, TypeToken.get((Class) map$Entry.getValue()));
            linkedHashMap.put(map$Entry.getKey(), typeAdapterJ2);
            linkedHashMap2.put(map$Entry.getValue(), typeAdapterJ2);
        }
        return new RuntimeTypeAdapterFactory$1(this, linkedHashMap, typeAdapterJ, linkedHashMap2).nullSafe();
    }
}
