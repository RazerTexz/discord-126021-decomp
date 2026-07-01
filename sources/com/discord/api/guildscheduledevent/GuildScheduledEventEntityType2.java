package com.discord.api.guildscheduledevent;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;

/* JADX INFO: renamed from: com.discord.api.guildscheduledevent.GuildScheduledEventEntityTypeTypeAdapter, reason: use source file name */
/* JADX INFO: compiled from: GuildScheduledEventEntityType.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildScheduledEventEntityType2 extends TypeAdapter<GuildScheduledEventEntityType> {
    @Override // com.google.gson.TypeAdapter
    public GuildScheduledEventEntityType read(JsonReader jsonReader) {
        Intrinsics3.checkNotNullParameter(jsonReader, "in");
        return GuildScheduledEventEntityType.INSTANCE.a(jsonReader.y());
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, GuildScheduledEventEntityType guildScheduledEventEntityType) throws IOException {
        GuildScheduledEventEntityType guildScheduledEventEntityType2 = guildScheduledEventEntityType;
        Intrinsics3.checkNotNullParameter(jsonWriter, "out");
        if (guildScheduledEventEntityType2 != null) {
            jsonWriter.D(Integer.valueOf(guildScheduledEventEntityType2.getApiValue()));
        } else {
            jsonWriter.s();
        }
    }
}
