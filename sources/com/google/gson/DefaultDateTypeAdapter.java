package com.google.gson;

import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import b.i.d.q.JavaVersion;
import b.i.d.q.x.d.ISO8601Utils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultDateTypeAdapter extends TypeAdapter<Date> {
    public final Class<? extends Date> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<DateFormat> f3114b;

    public DefaultDateTypeAdapter(Class<? extends Date> cls, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        this.f3114b = arrayList;
        a(cls);
        this.a = cls;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i, i2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i, i2));
        }
        if (JavaVersion.a >= 9) {
            arrayList.add(f.r0(i, i2));
        }
    }

    public static Class<? extends Date> a(Class<? extends Date> cls) {
        if (cls == Date.class || cls == java.sql.Date.class || cls == Timestamp.class) {
            return cls;
        }
        throw new IllegalArgumentException("Date type must be one of " + Date.class + ", " + Timestamp.class + ", or " + java.sql.Date.class + " but was " + cls);
    }

    @Override // com.google.gson.TypeAdapter
    public Date read(JsonReader jsonReader) throws IOException {
        Date dateB;
        Date date;
        if (jsonReader.N() == JsonToken.NULL) {
            jsonReader.H();
            return null;
        }
        String strJ = jsonReader.J();
        synchronized (this.f3114b) {
            Iterator<DateFormat> it = this.f3114b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    try {
                        dateB = ISO8601Utils.b(strJ, new ParsePosition(0));
                        break;
                    } catch (ParseException e) {
                        throw new JsonSyntaxException(strJ, e);
                    }
                }
                try {
                    dateB = it.next().parse(strJ);
                    break;
                } catch (ParseException unused) {
                }
            }
        }
        Class<? extends Date> cls = this.a;
        if (cls == Date.class) {
            return dateB;
        }
        if (cls == Timestamp.class) {
            date = new Timestamp(dateB.getTime());
        } else {
            if (cls != java.sql.Date.class) {
                throw new AssertionError();
            }
            date = new java.sql.Date(dateB.getTime());
        }
        return date;
    }

    public String toString() {
        DateFormat dateFormat = this.f3114b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            StringBuilder sbU = outline.U("DefaultDateTypeAdapter(");
            sbU.append(((SimpleDateFormat) dateFormat).toPattern());
            sbU.append(')');
            return sbU.toString();
        }
        StringBuilder sbU2 = outline.U("DefaultDateTypeAdapter(");
        sbU2.append(dateFormat.getClass().getSimpleName());
        sbU2.append(')');
        return sbU2.toString();
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Date date) throws IOException {
        Date date2 = date;
        if (date2 == null) {
            jsonWriter.s();
            return;
        }
        synchronized (this.f3114b) {
            jsonWriter.H(this.f3114b.get(0).format(date2));
        }
    }
}
