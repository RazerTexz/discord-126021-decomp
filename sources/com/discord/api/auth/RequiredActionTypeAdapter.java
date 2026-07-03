package com.discord.api.auth;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Locale;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: RequiredAction.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RequiredActionTypeAdapter extends TypeAdapter<RequiredAction> {
    @Override // com.google.gson.TypeAdapter
    public RequiredAction read(JsonReader jsonReader) throws IOException {
        C12238m.checkNotNullParameter(jsonReader, "in");
        String strMo6877J = jsonReader.mo6877J();
        return (strMo6877J != null && strMo6877J.hashCode() == 509052241 && strMo6877J.equals("update_password")) ? RequiredAction.UPDATE_PASSWORD : RequiredAction.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, RequiredAction requiredAction) throws IOException {
        String lowerCase;
        String strName;
        RequiredAction requiredAction2 = requiredAction;
        C12238m.checkNotNullParameter(jsonWriter, "out");
        if (requiredAction2 == null || (strName = requiredAction2.name()) == null) {
            lowerCase = null;
        } else {
            Locale locale = Locale.ROOT;
            C12238m.checkNotNullExpressionValue(locale, "Locale.ROOT");
            lowerCase = strName.toLowerCase(locale);
            C12238m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        }
        jsonWriter.mo6895H(lowerCase);
    }
}
