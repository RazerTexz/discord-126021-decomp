package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class TypeAdapters$9 extends TypeAdapter<AtomicBoolean> {
    @Override // com.google.gson.TypeAdapter
    public AtomicBoolean read(JsonReader jsonReader) throws IOException {
        return new AtomicBoolean(jsonReader.u());
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, AtomicBoolean atomicBoolean) throws IOException {
        jsonWriter.I(atomicBoolean.get());
    }
}
