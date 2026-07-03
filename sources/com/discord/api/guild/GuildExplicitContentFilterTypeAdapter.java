package com.discord.api.guild;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildExplicitContentFilter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExplicitContentFilterTypeAdapter extends TypeAdapter<GuildExplicitContentFilter> {
    /* JADX WARN: Code duplicated, block: B:15:0x0027  */
    /* JADX WARN: Code duplicated, block: B:19:? A[RETURN, SYNTHETIC] */
    @Override // com.google.gson.TypeAdapter
    public GuildExplicitContentFilter read(JsonReader jsonReader) throws IOException {
        GuildExplicitContentFilter guildExplicitContentFilter;
        C12238m.checkNotNullParameter(jsonReader, "in");
        int iMo6891y = jsonReader.mo6891y();
        GuildExplicitContentFilter[] guildExplicitContentFilterArrValues = GuildExplicitContentFilter.values();
        for (int i = 0; i < 3; i++) {
            guildExplicitContentFilter = guildExplicitContentFilterArrValues[i];
            if (guildExplicitContentFilter.getApiValue() == iMo6891y) {
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
        C12238m.checkNotNullParameter(jsonWriter, "out");
        if (guildExplicitContentFilter2 != null) {
            jsonWriter.mo6894D(Integer.valueOf(guildExplicitContentFilter2.getApiValue()));
        } else {
            jsonWriter.mo6905s();
        }
    }
}
