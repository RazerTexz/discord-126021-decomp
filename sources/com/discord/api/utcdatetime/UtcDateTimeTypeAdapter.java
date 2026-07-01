package com.discord.api.utcdatetime;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import d0.z.d.m;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: UtcDateTime.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UtcDateTimeTypeAdapter extends TypeAdapter<UtcDateTime> {
    public static final UtcDateTimeTypeAdapter$Companion Companion = new UtcDateTimeTypeAdapter$Companion(null);
    private static final String FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

    @Override // com.google.gson.TypeAdapter
    public UtcDateTime read(JsonReader jsonReader) throws IOException {
        m.checkNotNullParameter(jsonReader, "in");
        if (jsonReader.N() == JsonToken.NULL) {
            jsonReader.H();
            return null;
        }
        String strJ = jsonReader.J();
        long time = 0;
        if (strJ != null) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ROOT);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                Date date = simpleDateFormat.parse(strJ);
                if (date != null) {
                    time = date.getTime();
                }
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException | ParseException unused) {
            }
        }
        return new UtcDateTime(time);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, UtcDateTime utcDateTime) throws IOException {
        UtcDateTime utcDateTime2 = utcDateTime;
        m.checkNotNullParameter(jsonWriter, "out");
        if (utcDateTime2 == null) {
            jsonWriter.s();
            return;
        }
        long dateTimeMillis = utcDateTime2.getDateTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ROOT);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        jsonWriter.H(simpleDateFormat.format(new Date(dateTimeMillis)));
    }
}
