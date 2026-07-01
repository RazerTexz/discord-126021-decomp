package com.discord.api.guild;

import b.c.a.a0.AnimatableValueParser;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;

/* JADX INFO: renamed from: com.discord.api.guild.GuildHubTypeTypeAdapter, reason: use source file name */
/* JADX INFO: compiled from: GuildHubType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildHubType2 extends TypeAdapter<GuildHubType> {
    @Override // com.google.gson.TypeAdapter
    public GuildHubType read(JsonReader jsonReader) throws IOException {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        Integer numN1 = AnimatableValueParser.n1(jsonReader);
        GuildHubType[] guildHubTypeArrValues = GuildHubType.values();
        for (int i = 0; i < 3; i++) {
            GuildHubType guildHubType = guildHubTypeArrValues[i];
            if (numN1 != null && guildHubType.getApiValue() == numN1.intValue()) {
                return guildHubType;
            }
        }
        return null;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, GuildHubType guildHubType) throws IOException {
        GuildHubType guildHubType2 = guildHubType;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (guildHubType2 == null) {
            jsonWriter.s();
        } else {
            jsonWriter.D(Integer.valueOf(guildHubType2.getApiValue()));
        }
    }
}
