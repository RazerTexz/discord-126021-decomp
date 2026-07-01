package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* JADX INFO: loaded from: classes3.dex */
public class TypeAdapters$10 extends TypeAdapter<AtomicIntegerArray> {
    @Override // com.google.gson.TypeAdapter
    public AtomicIntegerArray read(JsonReader jsonReader) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.a();
        while (jsonReader.q()) {
            try {
                arrayList.add(Integer.valueOf(jsonReader.y()));
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }
        jsonReader.e();
        int size = arrayList.size();
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
        for (int i = 0; i < size; i++) {
            atomicIntegerArray.set(i, ((Integer) arrayList.get(i)).intValue());
        }
        return atomicIntegerArray;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, AtomicIntegerArray atomicIntegerArray) throws IOException {
        AtomicIntegerArray atomicIntegerArray2 = atomicIntegerArray;
        jsonWriter.b();
        int length = atomicIntegerArray2.length();
        for (int i = 0; i < length; i++) {
            jsonWriter.A(atomicIntegerArray2.get(i));
        }
        jsonWriter.e();
    }
}
