package com.discord.api.application;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ApplicationType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ApplicationTypeAdapter extends TypeAdapter<ApplicationType> {

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ApplicationType.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[ApplicationType.UNKNOWN.ordinal()] = 1;
        }
    }

    @Override // com.google.gson.TypeAdapter
    public ApplicationType read(JsonReader jsonReader) throws IOException {
        C12238m.checkNotNullParameter(jsonReader, "in");
        ApplicationType.Companion companion = ApplicationType.INSTANCE;
        Integer numM549n1 = C1460d.m549n1(jsonReader);
        Objects.requireNonNull(companion);
        if (numM549n1 != null && numM549n1.intValue() == 1) {
            return ApplicationType.GAME;
        }
        if (numM549n1 != null && numM549n1.intValue() == 2) {
            return ApplicationType.MUSIC;
        }
        if (numM549n1 != null && numM549n1.intValue() == 3) {
            return ApplicationType.TICKETED_EVENTS;
        }
        return (numM549n1 != null && numM549n1.intValue() == 4) ? ApplicationType.GUILD_ROLE_SUBSCRIPTIONS : ApplicationType.UNKNOWN;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, ApplicationType applicationType) throws IOException {
        ApplicationType applicationType2 = applicationType;
        C12238m.checkNotNullParameter(jsonWriter, "out");
        if (applicationType2 != null) {
            jsonWriter.mo6894D(applicationType2.ordinal() != 0 ? Integer.valueOf(applicationType2.getApiValue()) : null);
        } else {
            jsonWriter.mo6905s();
        }
    }
}
