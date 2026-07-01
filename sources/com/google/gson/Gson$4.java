package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public class Gson$4 extends TypeAdapter<AtomicLong> {
    public final /* synthetic */ TypeAdapter a;

    public Gson$4(TypeAdapter typeAdapter) {
        this.a = typeAdapter;
    }

    @Override // com.google.gson.TypeAdapter
    public AtomicLong read(JsonReader jsonReader) throws IOException {
        return new AtomicLong(((Number) this.a.read(jsonReader)).longValue());
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, AtomicLong atomicLong) throws IOException {
        this.a.write(jsonWriter, Long.valueOf(atomicLong.get()));
    }
}
