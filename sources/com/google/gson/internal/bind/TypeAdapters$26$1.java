package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public class TypeAdapters$26$1 extends TypeAdapter<Timestamp> {
    public final /* synthetic */ TypeAdapter a;

    public TypeAdapters$26$1(TypeAdapters$26 typeAdapters$26, TypeAdapter typeAdapter) {
        this.a = typeAdapter;
    }

    @Override // com.google.gson.TypeAdapter
    public Timestamp read(JsonReader jsonReader) throws IOException {
        Date date = (Date) this.a.read(jsonReader);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Timestamp timestamp) throws IOException {
        this.a.write(jsonWriter, timestamp);
    }
}
