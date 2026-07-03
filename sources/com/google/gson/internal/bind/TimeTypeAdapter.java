package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import p007b.p225i.p408d.InterfaceC4911o;

/* JADX INFO: loaded from: classes3.dex */
public final class TimeTypeAdapter extends TypeAdapter<Time> {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC4911o f21539a = new InterfaceC4911o() { // from class: com.google.gson.internal.bind.TimeTypeAdapter.1
        @Override // p007b.p225i.p408d.InterfaceC4911o
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Time.class) {
                return new TimeTypeAdapter();
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: b */
    public final DateFormat f21540b = new SimpleDateFormat("hh:mm:ss a");

    @Override // com.google.gson.TypeAdapter
    public Time read(JsonReader jsonReader) throws IOException {
        synchronized (this) {
            if (jsonReader.mo6878N() == JsonToken.NULL) {
                jsonReader.mo6876H();
                return null;
            }
            try {
                return new Time(this.f21540b.parse(jsonReader.mo6877J()).getTime());
            } catch (ParseException e) {
                throw new JsonSyntaxException(e);
            }
        }
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Time time) throws IOException {
        Time time2 = time;
        synchronized (this) {
            jsonWriter.mo6895H(time2 == null ? null : this.f21540b.format((Date) time2));
        }
    }
}
