package com.google.gson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: loaded from: classes3.dex */
public class Gson$5 extends TypeAdapter<AtomicLongArray> {
    public final /* synthetic */ TypeAdapter a;

    public Gson$5(TypeAdapter typeAdapter) {
        this.a = typeAdapter;
    }

    @Override // com.google.gson.TypeAdapter
    public AtomicLongArray read(JsonReader jsonReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.a();
        while (jsonReader.q()) {
            arrayList.add(Long.valueOf(((Number) this.a.read(jsonReader)).longValue()));
        }
        jsonReader.e();
        int size = arrayList.size();
        AtomicLongArray atomicLongArray = new AtomicLongArray(size);
        for (int i = 0; i < size; i++) {
            atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
        }
        return atomicLongArray;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, AtomicLongArray atomicLongArray) throws IOException {
        AtomicLongArray atomicLongArray2 = atomicLongArray;
        jsonWriter.b();
        int length = atomicLongArray2.length();
        for (int i = 0; i < length; i++) {
            this.a.write(jsonWriter, Long.valueOf(atomicLongArray2.get(i)));
        }
        jsonWriter.e();
    }
}
