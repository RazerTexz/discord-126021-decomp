package com.discord.api.application;

import b.c.a.a0.d;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.m;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: ApplicationType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ApplicationTypeAdapter extends TypeAdapter<ApplicationType> {
    @Override // com.google.gson.TypeAdapter
    public ApplicationType read(JsonReader jsonReader) throws IOException {
        m.checkNotNullParameter(jsonReader, "in");
        ApplicationType$Companion applicationType$Companion = ApplicationType.Companion;
        Integer numN1 = d.n1(jsonReader);
        Objects.requireNonNull(applicationType$Companion);
        if (numN1 != null && numN1.intValue() == 1) {
            return ApplicationType.GAME;
        }
        if (numN1 != null && numN1.intValue() == 2) {
            return ApplicationType.MUSIC;
        }
        if (numN1 != null && numN1.intValue() == 3) {
            return ApplicationType.TICKETED_EVENTS;
        }
        return (numN1 != null && numN1.intValue() == 4) ? ApplicationType.GUILD_ROLE_SUBSCRIPTIONS : ApplicationType.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, ApplicationType applicationType) throws IOException {
        ApplicationType applicationType2 = applicationType;
        m.checkNotNullParameter(jsonWriter, "out");
        if (applicationType2 != null) {
            jsonWriter.D(applicationType2.ordinal() != 0 ? Integer.valueOf(applicationType2.getApiValue()) : null);
        } else {
            jsonWriter.s();
        }
    }
}
