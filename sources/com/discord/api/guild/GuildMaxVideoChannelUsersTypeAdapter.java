package com.discord.api.guild;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.m;
import java.io.IOException;

/* JADX INFO: compiled from: GuildMaxVideoChannelUsers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildMaxVideoChannelUsersTypeAdapter extends TypeAdapter<GuildMaxVideoChannelUsers> {
    @Override // com.google.gson.TypeAdapter
    public GuildMaxVideoChannelUsers read(JsonReader jsonReader) throws IOException {
        m.checkNotNullParameter(jsonReader, "in");
        int iY = jsonReader.y();
        return iY != -1 ? new GuildMaxVideoChannelUsers$Limited(iY) : GuildMaxVideoChannelUsers$Unlimited.INSTANCE;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, GuildMaxVideoChannelUsers guildMaxVideoChannelUsers) throws IOException {
        GuildMaxVideoChannelUsers guildMaxVideoChannelUsers2 = guildMaxVideoChannelUsers;
        m.checkNotNullParameter(jsonWriter, "out");
        if (guildMaxVideoChannelUsers2 instanceof GuildMaxVideoChannelUsers$Limited) {
            jsonWriter.D(Integer.valueOf(((GuildMaxVideoChannelUsers$Limited) guildMaxVideoChannelUsers2).getLimit()));
        } else if (m.areEqual(guildMaxVideoChannelUsers2, GuildMaxVideoChannelUsers$Unlimited.INSTANCE)) {
            jsonWriter.A(-1L);
        } else if (guildMaxVideoChannelUsers2 == null) {
            jsonWriter.s();
        }
    }
}
