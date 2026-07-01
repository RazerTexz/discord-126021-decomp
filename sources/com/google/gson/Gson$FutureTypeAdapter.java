package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class Gson$FutureTypeAdapter<T> extends TypeAdapter<T> {
    public TypeAdapter<T> a;

    @Override // com.google.gson.TypeAdapter
    public T read(JsonReader jsonReader) throws IOException {
        TypeAdapter<T> typeAdapter = this.a;
        if (typeAdapter != null) {
            return typeAdapter.read(jsonReader);
        }
        throw new IllegalStateException();
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, T t) throws IOException {
        TypeAdapter<T> typeAdapter = this.a;
        if (typeAdapter == null) {
            throw new IllegalStateException();
        }
        typeAdapter.write(jsonWriter, t);
    }
}
