package com.discord.api.localizedstring;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import d0.t.h0;
import d0.z.d.m;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map$Entry;

/* JADX INFO: compiled from: LocalizedString.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LocalizedStringTypeAdapter extends TypeAdapter<LocalizedString> {
    @Override // com.google.gson.TypeAdapter
    public LocalizedString read(JsonReader jsonReader) throws IOException {
        m.checkNotNullParameter(jsonReader, "in");
        JsonToken jsonTokenN = jsonReader.N();
        if (jsonTokenN != null) {
            int iOrdinal = jsonTokenN.ordinal();
            if (iOrdinal == 2) {
                jsonReader.b();
                HashMap map = new HashMap();
                String strJ = "";
                while (jsonReader.q()) {
                    String strC = jsonReader.C();
                    if (strC != null) {
                        int iHashCode = strC.hashCode();
                        if (iHashCode != 597626106) {
                            if (iHashCode == 1544803905 && strC.equals("default")) {
                                strJ = jsonReader.J();
                                m.checkNotNullExpressionValue(strJ, "`in`.nextString()");
                            }
                        } else if (strC.equals("localizations")) {
                            jsonReader.b();
                            while (jsonReader.q()) {
                                String strC2 = jsonReader.C();
                                String strJ2 = jsonReader.J();
                                m.checkNotNullExpressionValue(strC2, "locale");
                                m.checkNotNullExpressionValue(strJ2, "localization");
                                map.put(strC2, strJ2);
                            }
                            jsonReader.f();
                        }
                    }
                }
                jsonReader.f();
                return new LocalizedString(strJ, map);
            }
            if (iOrdinal == 5) {
                String strJ3 = jsonReader.J();
                m.checkNotNullExpressionValue(strJ3, "default");
                return new LocalizedString(strJ3, h0.emptyMap());
            }
        }
        throw new IllegalArgumentException("could not parse localized string. token was: " + jsonTokenN);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, LocalizedString localizedString) throws IOException {
        LocalizedString localizedString2 = localizedString;
        m.checkNotNullParameter(jsonWriter, "out");
        if (localizedString2 == null) {
            jsonWriter.s();
            return;
        }
        jsonWriter.c();
        jsonWriter.n("default");
        jsonWriter.H(localizedString2.getDefault());
        jsonWriter.n("localizations");
        jsonWriter.c();
        for (Map$Entry<String, String> map$Entry : localizedString2.b().entrySet()) {
            String key = map$Entry.getKey();
            String value = map$Entry.getValue();
            jsonWriter.n(key);
            jsonWriter.H(value);
        }
        jsonWriter.f();
        jsonWriter.f();
    }
}
