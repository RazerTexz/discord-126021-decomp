package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import p007b.p225i.p408d.InterfaceC4911o;
import p007b.p225i.p408d.p410q.C4916a;

/* JADX INFO: loaded from: classes3.dex */
public final class ArrayTypeAdapter<E> extends TypeAdapter<Object> {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC4911o f21510a = new InterfaceC4911o() { // from class: com.google.gson.internal.bind.ArrayTypeAdapter.1
        @Override // p007b.p225i.p408d.InterfaceC4911o
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            Type type = typeToken.getType();
            boolean z2 = type instanceof GenericArrayType;
            if (!z2 && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type genericComponentType = z2 ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
            return new ArrayTypeAdapter(gson, gson.m9204h(TypeToken.get(genericComponentType)), C4916a.m6864e(genericComponentType));
        }
    };

    /* JADX INFO: renamed from: b */
    public final Class<E> f21511b;

    /* JADX INFO: renamed from: c */
    public final TypeAdapter<E> f21512c;

    public ArrayTypeAdapter(Gson gson, TypeAdapter<E> typeAdapter, Class<E> cls) {
        this.f21512c = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, cls);
        this.f21511b = cls;
    }

    @Override // com.google.gson.TypeAdapter
    public Object read(JsonReader jsonReader) throws IOException {
        if (jsonReader.mo6878N() == JsonToken.NULL) {
            jsonReader.mo6876H();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        jsonReader.mo6882a();
        while (jsonReader.mo6888q()) {
            arrayList.add(this.f21512c.read(jsonReader));
        }
        jsonReader.mo6886e();
        int size = arrayList.size();
        Object objNewInstance = Array.newInstance((Class<?>) this.f21511b, size);
        for (int i = 0; i < size; i++) {
            Array.set(objNewInstance, i, arrayList.get(i));
        }
        return objNewInstance;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.mo6905s();
            return;
        }
        jsonWriter.mo6900b();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.f21512c.write(jsonWriter, (E) Array.get(obj, i));
        }
        jsonWriter.mo6902e();
    }
}
