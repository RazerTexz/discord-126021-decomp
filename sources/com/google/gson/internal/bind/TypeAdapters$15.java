package com.google.gson.internal.bind;

import b.d.b.a.a;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class TypeAdapters$15 extends TypeAdapter<Character> {
    @Override // com.google.gson.TypeAdapter
    public Character read(JsonReader jsonReader) throws IOException {
        if (jsonReader.N() == JsonToken.NULL) {
            jsonReader.H();
            return null;
        }
        String strJ = jsonReader.J();
        if (strJ.length() == 1) {
            return Character.valueOf(strJ.charAt(0));
        }
        throw new JsonSyntaxException(a.w("Expecting character, got: ", strJ));
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Character ch) throws IOException {
        Character ch2 = ch;
        jsonWriter.H(ch2 == null ? null : String.valueOf(ch2));
    }
}
