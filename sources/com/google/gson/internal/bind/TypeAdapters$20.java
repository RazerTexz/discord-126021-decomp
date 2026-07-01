package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class TypeAdapters$20 extends TypeAdapter<StringBuffer> {
    @Override // com.google.gson.TypeAdapter
    public StringBuffer read(JsonReader jsonReader) throws IOException {
        if (jsonReader.N() != JsonToken.NULL) {
            return new StringBuffer(jsonReader.J());
        }
        jsonReader.H();
        return null;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, StringBuffer stringBuffer) throws IOException {
        StringBuffer stringBuffer2 = stringBuffer;
        jsonWriter.H(stringBuffer2 == null ? null : stringBuffer2.toString());
    }
}
