package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class TypeAdapters$4 extends TypeAdapter<Boolean> {
    @Override // com.google.gson.TypeAdapter
    public Boolean read(JsonReader jsonReader) throws IOException {
        if (jsonReader.N() != JsonToken.NULL) {
            return Boolean.valueOf(jsonReader.J());
        }
        jsonReader.H();
        return null;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
        Boolean bool2 = bool;
        jsonWriter.H(bool2 == null ? "null" : bool2.toString());
    }
}
