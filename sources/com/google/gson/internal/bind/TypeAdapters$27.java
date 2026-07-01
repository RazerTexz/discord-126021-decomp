package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: loaded from: classes3.dex */
public class TypeAdapters$27 extends TypeAdapter<Calendar> {
    @Override // com.google.gson.TypeAdapter
    public Calendar read(JsonReader jsonReader) throws IOException {
        if (jsonReader.N() == JsonToken.NULL) {
            jsonReader.H();
            return null;
        }
        jsonReader.b();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (jsonReader.N() != JsonToken.END_OBJECT) {
            String strC = jsonReader.C();
            int iY = jsonReader.y();
            if ("year".equals(strC)) {
                i = iY;
            } else if ("month".equals(strC)) {
                i2 = iY;
            } else if ("dayOfMonth".equals(strC)) {
                i3 = iY;
            } else if ("hourOfDay".equals(strC)) {
                i4 = iY;
            } else if ("minute".equals(strC)) {
                i5 = iY;
            } else if ("second".equals(strC)) {
                i6 = iY;
            }
        }
        jsonReader.f();
        return new GregorianCalendar(i, i2, i3, i4, i5, i6);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Calendar calendar) throws IOException {
        Calendar calendar2 = calendar;
        if (calendar2 == null) {
            jsonWriter.s();
            return;
        }
        jsonWriter.c();
        jsonWriter.n("year");
        jsonWriter.A(calendar2.get(1));
        jsonWriter.n("month");
        jsonWriter.A(calendar2.get(2));
        jsonWriter.n("dayOfMonth");
        jsonWriter.A(calendar2.get(5));
        jsonWriter.n("hourOfDay");
        jsonWriter.A(calendar2.get(11));
        jsonWriter.n("minute");
        jsonWriter.A(calendar2.get(12));
        jsonWriter.n("second");
        jsonWriter.A(calendar2.get(13));
        jsonWriter.f();
    }
}
