package com.google.gson.internal.bind;

import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/* JADX INFO: loaded from: classes3.dex */
public class TypeAdapters$22 extends TypeAdapter<URI> {
    @Override // com.google.gson.TypeAdapter
    public URI read(JsonReader jsonReader) throws IOException {
        if (jsonReader.N() == JsonToken.NULL) {
            jsonReader.H();
            return null;
        }
        try {
            String strJ = jsonReader.J();
            if ("null".equals(strJ)) {
                return null;
            }
            return new URI(strJ);
        } catch (URISyntaxException e) {
            throw new JsonIOException(e);
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, URI uri) throws IOException {
        URI uri2 = uri;
        jsonWriter.H(uri2 == null ? null : uri2.toASCIIString());
    }
}
