package com.discord.api.auth;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.m;
import java.io.IOException;
import java.util.Locale;

/* JADX INFO: compiled from: RequiredAction.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RequiredActionTypeAdapter extends TypeAdapter<RequiredAction> {
    @Override // com.google.gson.TypeAdapter
    public RequiredAction read(JsonReader jsonReader) throws IOException {
        m.checkNotNullParameter(jsonReader, "in");
        String strJ = jsonReader.J();
        return (strJ != null && strJ.hashCode() == 509052241 && strJ.equals("update_password")) ? RequiredAction.UPDATE_PASSWORD : RequiredAction.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, RequiredAction requiredAction) throws IOException {
        String lowerCase;
        String strName;
        RequiredAction requiredAction2 = requiredAction;
        m.checkNotNullParameter(jsonWriter, "out");
        if (requiredAction2 == null || (strName = requiredAction2.name()) == null) {
            lowerCase = null;
        } else {
            Locale locale = Locale.ROOT;
            m.checkNotNullExpressionValue(locale, "Locale.ROOT");
            lowerCase = strName.toLowerCase(locale);
            m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        }
        jsonWriter.H(lowerCase);
    }
}
