package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import p007b.p225i.p408d.InterfaceC4911o;

/* JADX INFO: loaded from: classes3.dex */
public final class SqlDateTypeAdapter extends TypeAdapter<Date> {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC4911o f21537a = new InterfaceC4911o() { // from class: com.google.gson.internal.bind.SqlDateTypeAdapter.1
        @Override // p007b.p225i.p408d.InterfaceC4911o
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Date.class) {
                return new SqlDateTypeAdapter();
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: b */
    public final DateFormat f21538b = new SimpleDateFormat("MMM d, yyyy");

    @Override // com.google.gson.TypeAdapter
    public Date read(JsonReader jsonReader) throws IOException {
        Date date;
        synchronized (this) {
            try {
                if (jsonReader.mo6878N() == JsonToken.NULL) {
                    jsonReader.mo6876H();
                    date = null;
                } else {
                    try {
                        date = new Date(this.f21538b.parse(jsonReader.mo6877J()).getTime());
                    } catch (ParseException e) {
                        throw new JsonSyntaxException(e);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return date;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Date date) throws IOException {
        Date date2 = date;
        synchronized (this) {
            jsonWriter.mo6895H(date2 == null ? null : this.f21538b.format((java.util.Date) date2));
        }
    }
}
