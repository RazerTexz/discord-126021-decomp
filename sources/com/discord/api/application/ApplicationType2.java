package com.discord.api.application;

import b.c.a.a0.AnimatableValueParser;
import com.discord.api.application.ApplicationType;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: renamed from: com.discord.api.application.ApplicationTypeAdapter, reason: use source file name */
/* JADX INFO: compiled from: ApplicationType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ApplicationType2 extends TypeAdapter<ApplicationType> {

    /* JADX INFO: renamed from: com.discord.api.application.ApplicationTypeAdapter$WhenMappings */
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
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        ApplicationType.Companion companion = ApplicationType.INSTANCE;
        Integer numN1 = AnimatableValueParser.n1(jsonReader);
        Objects.requireNonNull(companion);
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
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (applicationType2 != null) {
            jsonWriter.D(applicationType2.ordinal() != 0 ? Integer.valueOf(applicationType2.getApiValue()) : null);
        } else {
            jsonWriter.s();
        }
    }
}
