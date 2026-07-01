package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class TypeAdapters$19 extends TypeAdapter<StringBuilder> {
    @Override // com.google.gson.TypeAdapter
    public StringBuilder read(JsonReader jsonReader) throws IOException {
        if (jsonReader.N() != JsonToken.NULL) {
            return new StringBuilder(jsonReader.J());
        }
        jsonReader.H();
        return null;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, StringBuilder sb) throws IOException {
        StringBuilder sb2 = sb;
        jsonWriter.H(sb2 == null ? null : sb2.toString());
    }
}
