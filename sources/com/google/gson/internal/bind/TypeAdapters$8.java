package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
public class TypeAdapters$8 extends TypeAdapter<AtomicInteger> {
    @Override // com.google.gson.TypeAdapter
    public AtomicInteger read(JsonReader jsonReader) throws IOException {
        try {
            return new AtomicInteger(jsonReader.y());
        } catch (NumberFormatException e) {
            throw new JsonSyntaxException(e);
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, AtomicInteger atomicInteger) throws IOException {
        jsonWriter.A(atomicInteger.get());
    }
}
