package com.discord.api.guild;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildMaxVideoChannelUsers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildMaxVideoChannelUsersTypeAdapter extends TypeAdapter<GuildMaxVideoChannelUsers> {
    @Override // com.google.gson.TypeAdapter
    public GuildMaxVideoChannelUsers read(JsonReader jsonReader) throws IOException {
        C12238m.checkNotNullParameter(jsonReader, "in");
        int iMo6891y = jsonReader.mo6891y();
        return iMo6891y != -1 ? new GuildMaxVideoChannelUsers.Limited(iMo6891y) : GuildMaxVideoChannelUsers.Unlimited.INSTANCE;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, GuildMaxVideoChannelUsers guildMaxVideoChannelUsers) throws IOException {
        GuildMaxVideoChannelUsers guildMaxVideoChannelUsers2 = guildMaxVideoChannelUsers;
        C12238m.checkNotNullParameter(jsonWriter, "out");
        if (guildMaxVideoChannelUsers2 instanceof GuildMaxVideoChannelUsers.Limited) {
            jsonWriter.mo6894D(Integer.valueOf(((GuildMaxVideoChannelUsers.Limited) guildMaxVideoChannelUsers2).getLimit()));
        } else if (C12238m.areEqual(guildMaxVideoChannelUsers2, GuildMaxVideoChannelUsers.Unlimited.INSTANCE)) {
            jsonWriter.mo6892A(-1L);
        } else if (guildMaxVideoChannelUsers2 == null) {
            jsonWriter.mo6905s();
        }
    }
}
