package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class TypeAdapters$18 extends TypeAdapter<BigInteger> {
    @Override // com.google.gson.TypeAdapter
    public BigInteger read(JsonReader jsonReader) throws IOException {
        if (jsonReader.N() == JsonToken.NULL) {
            jsonReader.H();
            return null;
        }
        try {
            return new BigInteger(jsonReader.J());
        } catch (NumberFormatException e) {
            throw new JsonSyntaxException(e);
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, BigInteger bigInteger) throws IOException {
        jsonWriter.D(bigInteger);
    }
}
