package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: classes3.dex */
public final class TypeAdapterRuntimeTypeWrapper<T> extends TypeAdapter<T> {

    /* JADX INFO: renamed from: a */
    public final Gson f21553a;

    /* JADX INFO: renamed from: b */
    public final TypeAdapter<T> f21554b;

    /* JADX INFO: renamed from: c */
    public final Type f21555c;

    public TypeAdapterRuntimeTypeWrapper(Gson gson, TypeAdapter<T> typeAdapter, Type type) {
        this.f21553a = gson;
        this.f21554b = typeAdapter;
        this.f21555c = type;
    }

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader jsonReader) throws IOException {
        return this.f21554b.read(jsonReader);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, T t) throws IOException {
        TypeAdapter<T> typeAdapterM9204h = this.f21554b;
        Type type = this.f21555c;
        if (t != null && (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class))) {
            type = t.getClass();
        }
        if (type != this.f21555c) {
            typeAdapterM9204h = this.f21553a.m9204h(TypeToken.get(type));
            if (typeAdapterM9204h instanceof ReflectiveTypeAdapterFactory.Adapter) {
                TypeAdapter<T> typeAdapter = this.f21554b;
                if (!(typeAdapter instanceof ReflectiveTypeAdapterFactory.Adapter)) {
                    typeAdapterM9204h = typeAdapter;
                }
            }
        }
        typeAdapterM9204h.write(jsonWriter, t);
    }
}
