package com.discord.api.guild;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;

/* JADX INFO: renamed from: com.discord.api.guild.GuildVerificationLevelTypeAdapter, reason: use source file name */
/* JADX INFO: compiled from: GuildVerificationLevel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildVerificationLevel2 extends TypeAdapter<GuildVerificationLevel> {
    /* JADX WARN: Code duplicated, block: B:15:0x0027  */
    /* JADX WARN: Code duplicated, block: B:19:? A[RETURN, SYNTHETIC] */
    @Override // com.google.gson.TypeAdapter
    public GuildVerificationLevel read(JsonReader jsonReader) throws IOException {
        GuildVerificationLevel guildVerificationLevel;
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        int iY = jsonReader.y();
        GuildVerificationLevel[] guildVerificationLevelArrValues = GuildVerificationLevel.values();
        for (int i = 0; i < 5; i++) {
            guildVerificationLevel = guildVerificationLevelArrValues[i];
            if (guildVerificationLevel.getApiValue() == iY) {
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
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (guildVerificationLevel2 != null) {
            jsonWriter.D(Integer.valueOf(guildVerificationLevel2.getApiValue()));
        } else {
            jsonWriter.s();
        }
    }
}
