package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.net.URL;

/* JADX INFO: loaded from: classes3.dex */
public class TypeAdapters$21 extends TypeAdapter<URL> {
    @Override // com.google.gson.TypeAdapter
    public URL read(JsonReader jsonReader) throws IOException {
        if (jsonReader.N() == JsonToken.NULL) {
            jsonReader.H();
            return null;
        }
        String strJ = jsonReader.J();
        if ("null".equals(strJ)) {
            return null;
        }
        return new URL(strJ);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, URL url) throws IOException {
        URL url2 = url;
        jsonWriter.H(url2 == null ? null : url2.toExternalForm());
    }
}
