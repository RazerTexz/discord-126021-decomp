package com.discord.api.utcdatetime;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: UtcDateTime.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UtcDateTimeTypeAdapter extends TypeAdapter<UtcDateTime> {
    private static final String FORMAT = "yyyy-MM-dd'T'HH:mm:ss";

    @Override // com.google.gson.TypeAdapter
    public UtcDateTime read(JsonReader jsonReader) throws IOException {
        C12238m.checkNotNullParameter(jsonReader, "in");
        if (jsonReader.mo6878N() == JsonToken.NULL) {
            jsonReader.mo6876H();
            return null;
        }
        String strMo6877J = jsonReader.mo6877J();
        long time = 0;
        if (strMo6877J != null) {
            try {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ROOT);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                Date date = simpleDateFormat.parse(strMo6877J);
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
        C12238m.checkNotNullParameter(jsonWriter, "out");
        if (utcDateTime2 == null) {
            jsonWriter.mo6905s();
            return;
        }
        long dateTimeMillis = utcDateTime2.getDateTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ROOT);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        jsonWriter.mo6895H(simpleDateFormat.format(new Date(dateTimeMillis)));
    }
}
