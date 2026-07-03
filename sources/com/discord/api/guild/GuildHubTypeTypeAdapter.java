package com.discord.api.guild;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import p007b.p085c.p086a.p087a0.C1460d;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildHubType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildHubTypeTypeAdapter extends TypeAdapter<GuildHubType> {
    @Override // com.google.gson.TypeAdapter
    public GuildHubType read(JsonReader jsonReader) throws IOException {
        C12238m.checkNotNullParameter(jsonReader, "in");
        Integer numM549n1 = C1460d.m549n1(jsonReader);
        GuildHubType[] guildHubTypeArrValues = GuildHubType.values();
        for (int i = 0; i < 3; i++) {
            GuildHubType guildHubType = guildHubTypeArrValues[i];
            if (numM549n1 != null && guildHubType.getApiValue() == numM549n1.intValue()) {
                return guildHubType;
            }
        }
        return null;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, GuildHubType guildHubType) throws IOException {
        GuildHubType guildHubType2 = guildHubType;
        C12238m.checkNotNullParameter(jsonWriter, "out");
        if (guildHubType2 == null) {
            jsonWriter.mo6905s();
        } else {
            jsonWriter.mo6894D(Integer.valueOf(guildHubType2.getApiValue()));
        }
    }
}
