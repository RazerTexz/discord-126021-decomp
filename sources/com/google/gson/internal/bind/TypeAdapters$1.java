package com.google.gson.internal.bind;

import b.d.b.a.a;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class TypeAdapters$1 extends TypeAdapter<Class> {
    public Class a() throws IOException {
        throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
    }

    public void b(Class cls) throws IOException {
        throw new UnsupportedOperationException(a.o(cls, a.U("Attempted to serialize java.lang.Class: "), ". Forgot to register a type adapter?"));
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Class read(JsonReader jsonReader) throws IOException {
        return a();
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void write(JsonWriter jsonWriter, Class cls) throws IOException {
        b(cls);
    }
}
