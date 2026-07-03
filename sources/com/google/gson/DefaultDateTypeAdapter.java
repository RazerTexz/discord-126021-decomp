package com.google.gson;

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
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p408d.p410q.C4930o;
import p007b.p225i.p408d.p410q.p411x.p412d.C4942a;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultDateTypeAdapter extends TypeAdapter<Date> {

    /* JADX INFO: renamed from: a */
    public final Class<? extends Date> f21462a;

    /* JADX INFO: renamed from: b */
    public final List<DateFormat> f21463b;

    public DefaultDateTypeAdapter(Class<? extends Date> cls, int i, int i2) {
        ArrayList arrayList = new ArrayList();
        this.f21463b = arrayList;
        m9196a(cls);
        this.f21462a = cls;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i, i2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i, i2));
        }
        if (C4930o.f13123a >= 9) {
            arrayList.add(C3404f.m4336r0(i, i2));
        }
    }

    /* JADX INFO: renamed from: a */
    public static Class<? extends Date> m9196a(Class<? extends Date> cls) {
        if (cls == Date.class || cls == java.sql.Date.class || cls == Timestamp.class) {
            return cls;
        }
        throw new IllegalArgumentException("Date type must be one of " + Date.class + ", " + Timestamp.class + ", or " + java.sql.Date.class + " but was " + cls);
    }

    @Override // com.google.gson.TypeAdapter
    public Date read(JsonReader jsonReader) throws IOException {
        Date dateM6910b;
        Date date;
        if (jsonReader.mo6878N() == JsonToken.NULL) {
            jsonReader.mo6876H();
            return null;
        }
        String strMo6877J = jsonReader.mo6877J();
        synchronized (this.f21463b) {
            Iterator<DateFormat> it = this.f21463b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    try {
                        dateM6910b = C4942a.m6910b(strMo6877J, new ParsePosition(0));
                        break;
                    } catch (ParseException e) {
                        throw new JsonSyntaxException(strMo6877J, e);
                    }
                }
                try {
                    dateM6910b = it.next().parse(strMo6877J);
                    break;
                } catch (ParseException unused) {
                }
            }
        }
        Class<? extends Date> cls = this.f21462a;
        if (cls == Date.class) {
            return dateM6910b;
        }
        if (cls == Timestamp.class) {
            date = new Timestamp(dateM6910b.getTime());
        } else {
            if (cls != java.sql.Date.class) {
                throw new AssertionError();
            }
            date = new java.sql.Date(dateM6910b.getTime());
        }
        return date;
    }

    public String toString() {
        DateFormat dateFormat = this.f21463b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            StringBuilder sbM833U = C1643a.m833U("DefaultDateTypeAdapter(");
            sbM833U.append(((SimpleDateFormat) dateFormat).toPattern());
            sbM833U.append(')');
            return sbM833U.toString();
        }
        StringBuilder sbM833U2 = C1643a.m833U("DefaultDateTypeAdapter(");
        sbM833U2.append(dateFormat.getClass().getSimpleName());
        sbM833U2.append(')');
        return sbM833U2.toString();
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Date date) throws IOException {
        Date date2 = date;
        if (date2 == null) {
            jsonWriter.mo6905s();
            return;
        }
        synchronized (this.f21463b) {
            jsonWriter.mo6895H(this.f21463b.get(0).format(date2));
        }
    }
}
