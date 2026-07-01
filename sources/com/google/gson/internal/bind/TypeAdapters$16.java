package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class TypeAdapters$16 extends TypeAdapter<String> {
    @Override // com.google.gson.TypeAdapter
    public String read(JsonReader jsonReader) throws IOException {
        JsonToken jsonTokenN = jsonReader.N();
        if (jsonTokenN != JsonToken.NULL) {
            return jsonTokenN == JsonToken.BOOLEAN ? Boolean.toString(jsonReader.u()) : jsonReader.J();
        }
        jsonReader.H();
        return null;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, String str) throws IOException {
        jsonWriter.H(str);
    }
}
