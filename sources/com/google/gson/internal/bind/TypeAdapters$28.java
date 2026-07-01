package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes3.dex */
public class TypeAdapters$28 extends TypeAdapter<Locale> {
    @Override // com.google.gson.TypeAdapter
    public Locale read(JsonReader jsonReader) throws IOException {
        if (jsonReader.N() == JsonToken.NULL) {
            jsonReader.H();
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(jsonReader.J(), "_");
        String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        if (strNextToken2 == null && strNextToken3 == null) {
            return new Locale(strNextToken);
        }
        return strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Locale locale) throws IOException {
        Locale locale2 = locale;
        jsonWriter.H(locale2 == null ? null : locale2.toString());
    }
}
