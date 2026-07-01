package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.net.InetAddress;

/* JADX INFO: loaded from: classes3.dex */
public class TypeAdapters$23 extends TypeAdapter<InetAddress> {
    @Override // com.google.gson.TypeAdapter
    public InetAddress read(JsonReader jsonReader) throws IOException {
        if (jsonReader.N() != JsonToken.NULL) {
            return InetAddress.getByName(jsonReader.J());
        }
        jsonReader.H();
        return null;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, InetAddress inetAddress) throws IOException {
        InetAddress inetAddress2 = inetAddress;
        jsonWriter.H(inetAddress2 == null ? null : inetAddress2.getHostAddress());
    }
}
