package com.discord.api.guild;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.m;
import java.io.IOException;

/* JADX INFO: compiled from: GuildExplicitContentFilter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExplicitContentFilterTypeAdapter extends TypeAdapter<GuildExplicitContentFilter> {
    /* JADX WARN: Code duplicated, block: B:15:0x0027  */
    /* JADX WARN: Code duplicated, block: B:19:? A[RETURN, SYNTHETIC] */
    @Override // com.google.gson.TypeAdapter
    public GuildExplicitContentFilter read(JsonReader jsonReader) throws IOException {
        GuildExplicitContentFilter guildExplicitContentFilter;
        m.checkNotNullParameter(jsonReader, "in");
        int iY = jsonReader.y();
        GuildExplicitContentFilter[] guildExplicitContentFilterArrValues = GuildExplicitContentFilter.values();
        for (int i = 0; i < 3; i++) {
            guildExplicitContentFilter = guildExplicitContentFilterArrValues[i];
            if (guildExplicitContentFilter.getApiValue() == iY) {
                if (guildExplicitContentFilter != null) {
                    return guildExplicitContentFilter;
                }
                return GuildExplicitContentFilter.NONE;
            }
        }
        guildExplicitContentFilter = null;
        if (guildExplicitContentFilter != null) {
            return guildExplicitContentFilter;
        }
        return GuildExplicitContentFilter.NONE;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, GuildExplicitContentFilter guildExplicitContentFilter) throws IOException {
        GuildExplicitContentFilter guildExplicitContentFilter2 = guildExplicitContentFilter;
        m.checkNotNullParameter(jsonWriter, "out");
        if (guildExplicitContentFilter2 != null) {
            jsonWriter.D(Integer.valueOf(guildExplicitContentFilter2.getApiValue()));
        } else {
            jsonWriter.s();
        }
    }
}
