package com.discord.api.guildscheduledevent;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildScheduledEventEntityType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildScheduledEventEntityTypeTypeAdapter extends TypeAdapter<GuildScheduledEventEntityType> {
    @Override // com.google.gson.TypeAdapter
    public GuildScheduledEventEntityType read(JsonReader jsonReader) {
        C12238m.checkNotNullParameter(jsonReader, "in");
        return GuildScheduledEventEntityType.INSTANCE.m7993a(jsonReader.mo6891y());
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, GuildScheduledEventEntityType guildScheduledEventEntityType) throws IOException {
        GuildScheduledEventEntityType guildScheduledEventEntityType2 = guildScheduledEventEntityType;
        C12238m.checkNotNullParameter(jsonWriter, "out");
        if (guildScheduledEventEntityType2 != null) {
            jsonWriter.mo6894D(Integer.valueOf(guildScheduledEventEntityType2.getApiValue()));
        } else {
            jsonWriter.mo6905s();
        }
    }
}
