package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public class TypeAdapters$24 extends TypeAdapter<UUID> {
    @Override // com.google.gson.TypeAdapter
    public UUID read(JsonReader jsonReader) throws IOException {
        if (jsonReader.N() != JsonToken.NULL) {
            return UUID.fromString(jsonReader.J());
        }
        jsonReader.H();
        return null;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, UUID uuid) throws IOException {
        UUID uuid2 = uuid;
        jsonWriter.H(uuid2 == null ? null : uuid2.toString());
    }
}
