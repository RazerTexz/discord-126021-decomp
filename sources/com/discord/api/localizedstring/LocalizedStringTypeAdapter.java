package com.discord.api.localizedstring;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: LocalizedString.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LocalizedStringTypeAdapter extends TypeAdapter<LocalizedString> {

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            JsonToken.values();
            int[] iArr = new int[10];
            $EnumSwitchMapping$0 = iArr;
            iArr[2] = 1;
            iArr[5] = 2;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public LocalizedString read(JsonReader jsonReader) throws IOException {
        C12238m.checkNotNullParameter(jsonReader, "in");
        JsonToken jsonTokenMo6878N = jsonReader.mo6878N();
        if (jsonTokenMo6878N != null) {
            int iOrdinal = jsonTokenMo6878N.ordinal();
            if (iOrdinal == 2) {
                jsonReader.mo6883b();
                HashMap map = new HashMap();
                String strMo6877J = "";
                while (jsonReader.mo6888q()) {
                    String strMo6875C = jsonReader.mo6875C();
                    if (strMo6875C != null) {
                        int iHashCode = strMo6875C.hashCode();
                        if (iHashCode != 597626106) {
                            if (iHashCode == 1544803905 && strMo6875C.equals("default")) {
                                strMo6877J = jsonReader.mo6877J();
                                C12238m.checkNotNullExpressionValue(strMo6877J, "`in`.nextString()");
                            }
                        } else if (strMo6875C.equals("localizations")) {
                            jsonReader.mo6883b();
                            while (jsonReader.mo6888q()) {
                                String strMo6875C2 = jsonReader.mo6875C();
                                String strMo6877J2 = jsonReader.mo6877J();
                                C12238m.checkNotNullExpressionValue(strMo6875C2, "locale");
                                C12238m.checkNotNullExpressionValue(strMo6877J2, "localization");
                                map.put(strMo6875C2, strMo6877J2);
                            }
                            jsonReader.mo6887f();
                        }
                    }
                }
                jsonReader.mo6887f();
                return new LocalizedString(strMo6877J, map);
            }
            if (iOrdinal == 5) {
                String strMo6877J3 = jsonReader.mo6877J();
                C12238m.checkNotNullExpressionValue(strMo6877J3, "default");
                return new LocalizedString(strMo6877J3, C12136h0.emptyMap());
            }
        }
        throw new IllegalArgumentException("could not parse localized string. token was: " + jsonTokenMo6878N);
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, LocalizedString localizedString) throws IOException {
        LocalizedString localizedString2 = localizedString;
        C12238m.checkNotNullParameter(jsonWriter, "out");
        if (localizedString2 == null) {
            jsonWriter.mo6905s();
            return;
        }
        jsonWriter.mo6901c();
        jsonWriter.mo6904n("default");
        jsonWriter.mo6895H(localizedString2.getDefault());
        jsonWriter.mo6904n("localizations");
        jsonWriter.mo6901c();
        for (Map.Entry<String, String> entry : localizedString2.m8017b().entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            jsonWriter.mo6904n(key);
            jsonWriter.mo6895H(value);
        }
        jsonWriter.mo6903f();
        jsonWriter.mo6903f();
    }
}
