package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class TypeAdapters$3 extends TypeAdapter<Boolean> {
    @Override // com.google.gson.TypeAdapter
    public Boolean read(JsonReader jsonReader) throws IOException {
        JsonToken jsonTokenN = jsonReader.N();
        if (jsonTokenN != JsonToken.NULL) {
            return jsonTokenN == JsonToken.STRING ? Boolean.valueOf(Boolean.parseBoolean(jsonReader.J())) : Boolean.valueOf(jsonReader.u());
        }
        jsonReader.H();
        return null;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
        jsonWriter.C(bool);
    }
}
