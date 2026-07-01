package com.discord.api.guildscheduledevent;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.m;
import java.io.IOException;

/* JADX INFO: compiled from: GuildScheduledEventEntityType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildScheduledEventEntityTypeTypeAdapter extends TypeAdapter<GuildScheduledEventEntityType> {
    @Override // com.google.gson.TypeAdapter
    public GuildScheduledEventEntityType read(JsonReader jsonReader) {
        m.checkNotNullParameter(jsonReader, "in");
        return GuildScheduledEventEntityType.Companion.a(jsonReader.y());
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, GuildScheduledEventEntityType guildScheduledEventEntityType) throws IOException {
        GuildScheduledEventEntityType guildScheduledEventEntityType2 = guildScheduledEventEntityType;
        m.checkNotNullParameter(jsonWriter, "out");
        if (guildScheduledEventEntityType2 != null) {
            jsonWriter.D(Integer.valueOf(guildScheduledEventEntityType2.getApiValue()));
        } else {
            jsonWriter.s();
        }
    }
}
