package com.google.gson.internal.bind;

import b.i.d.o;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class ArrayTypeAdapter<E> extends TypeAdapter<Object> {
    public static final o a = new ArrayTypeAdapter$1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<E> f3117b;
    public final TypeAdapter<E> c;

    public ArrayTypeAdapter(Gson gson, TypeAdapter<E> typeAdapter, Class<E> cls) {
        this.c = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, cls);
        this.f3117b = cls;
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader jsonReader) throws IOException {
        if (jsonReader.N() == JsonToken.NULL) {
            jsonReader.H();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        jsonReader.a();
        while (jsonReader.q()) {
            arrayList.add(this.c.read(jsonReader));
        }
        jsonReader.e();
        int size = arrayList.size();
        Object objNewInstance = Array.newInstance((Class<?>) this.f3117b, size);
        for (int i = 0; i < size; i++) {
            Array.set(objNewInstance, i, arrayList.get(i));
        }
        return objNewInstance;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.s();
            return;
        }
        jsonWriter.b();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.c.write(jsonWriter, (E) Array.get(obj, i));
        }
        jsonWriter.e();
    }
}
