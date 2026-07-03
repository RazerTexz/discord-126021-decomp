package com.discord.api.guild;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildVerificationLevel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildVerificationLevelTypeAdapter extends TypeAdapter<GuildVerificationLevel> {
    /* JADX WARN: Code duplicated, block: B:15:0x0027  */
    /* JADX WARN: Code duplicated, block: B:19:? A[RETURN, SYNTHETIC] */
    @Override // com.google.gson.TypeAdapter
    public GuildVerificationLevel read(JsonReader jsonReader) throws IOException {
        GuildVerificationLevel guildVerificationLevel;
        C12238m.checkNotNullParameter(jsonReader, "in");
        int iMo6891y = jsonReader.mo6891y();
        GuildVerificationLevel[] guildVerificationLevelArrValues = GuildVerificationLevel.values();
        for (int i = 0; i < 5; i++) {
            guildVerificationLevel = guildVerificationLevelArrValues[i];
            if (guildVerificationLevel.getApiValue() == iMo6891y) {
                if (guildVerificationLevel != null) {
                    return guildVerificationLevel;
                }
                return GuildVerificationLevel.NONE;
            }
        }
        guildVerificationLevel = null;
        if (guildVerificationLevel != null) {
            return guildVerificationLevel;
        }
        return GuildVerificationLevel.NONE;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, GuildVerificationLevel guildVerificationLevel) throws IOException {
        GuildVerificationLevel guildVerificationLevel2 = guildVerificationLevel;
        C12238m.checkNotNullParameter(jsonWriter, "out");
        if (guildVerificationLevel2 != null) {
            jsonWriter.mo6894D(Integer.valueOf(guildVerificationLevel2.getApiValue()));
        } else {
            jsonWriter.mo6905s();
        }
    }
}
