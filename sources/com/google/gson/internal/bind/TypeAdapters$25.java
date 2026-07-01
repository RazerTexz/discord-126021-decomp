package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Currency;

/* JADX INFO: loaded from: classes3.dex */
public class TypeAdapters$25 extends TypeAdapter<Currency> {
    @Override // com.google.gson.TypeAdapter
    public Currency read(JsonReader jsonReader) throws IOException {
        return Currency.getInstance(jsonReader.J());
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Currency currency) throws IOException {
        jsonWriter.H(currency.getCurrencyCode());
    }
}
