package com.google.gson.internal.bind;

import b.i.d.q.q;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class TypeAdapters$14 extends TypeAdapter<Number> {
    @Override // com.google.gson.TypeAdapter
    public Number read(JsonReader jsonReader) throws IOException {
        JsonToken jsonTokenN = jsonReader.N();
        int iOrdinal = jsonTokenN.ordinal();
        if (iOrdinal == 5 || iOrdinal == 6) {
            return new q(jsonReader.J());
        }
        if (iOrdinal == 8) {
            jsonReader.H();
            return null;
        }
        throw new JsonSyntaxException("Expecting number, got: " + jsonTokenN);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Number number) throws IOException {
        jsonWriter.D(number);
    }
}
