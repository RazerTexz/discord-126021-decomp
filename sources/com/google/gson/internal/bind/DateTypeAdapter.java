package com.google.gson.internal.bind;

import b.i.a.f.e.o.f;
import b.i.d.o;
import b.i.d.q.x.d.a;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class DateTypeAdapter extends TypeAdapter<Date> {
    public static final o a = new DateTypeAdapter$1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<DateFormat> f3119b;

    public DateTypeAdapter() {
        ArrayList arrayList = new ArrayList();
        this.f3119b = arrayList;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (b.i.d.q.o.a >= 9) {
            arrayList.add(f.r0(2, 2));
        }
    }

    @Override // com.google.gson.TypeAdapter
    public Date read(JsonReader jsonReader) throws IOException {
        if (jsonReader.N() == JsonToken.NULL) {
            jsonReader.H();
            return null;
        }
        String strJ = jsonReader.J();
        synchronized (this) {
            try {
                Iterator<DateFormat> it = this.f3119b.iterator();
                while (it.hasNext()) {
                    try {
                        return it.next().parse(strJ);
                    } catch (ParseException unused) {
                    }
                }
                try {
                    return a.b(strJ, new ParsePosition(0));
                } catch (ParseException e) {
                    throw new JsonSyntaxException(strJ, e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Date date) throws IOException {
        Date date2 = date;
        synchronized (this) {
            try {
                if (date2 == null) {
                    jsonWriter.s();
                } else {
                    jsonWriter.H(this.f3119b.get(0).format(date2));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
