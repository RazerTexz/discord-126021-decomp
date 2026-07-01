package com.discord.api.guildscheduledevent;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.m;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: GuildScheduledEventStatus.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildScheduledEventStatusTypeAdapter extends TypeAdapter<GuildScheduledEventStatus> {
    @Override // com.google.gson.TypeAdapter
    public GuildScheduledEventStatus read(JsonReader jsonReader) throws IOException {
        m.checkNotNullParameter(jsonReader, "in");
        GuildScheduledEventStatus$Companion guildScheduledEventStatus$Companion = GuildScheduledEventStatus.Companion;
        int iY = jsonReader.y();
        Objects.requireNonNull(guildScheduledEventStatus$Companion);
        if (iY == 1) {
            return GuildScheduledEventStatus.SCHEDULED;
        }
        if (iY == 2) {
            return GuildScheduledEventStatus.ACTIVE;
        }
        if (iY != 3) {
            return iY != 4 ? GuildScheduledEventStatus.UNKNOWN : GuildScheduledEventStatus.CANCELED;
        }
        return GuildScheduledEventStatus.COMPLETED;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, GuildScheduledEventStatus guildScheduledEventStatus) throws IOException {
        GuildScheduledEventStatus guildScheduledEventStatus2 = guildScheduledEventStatus;
        m.checkNotNullParameter(jsonWriter, "out");
        if (guildScheduledEventStatus2 != null) {
            jsonWriter.D(Integer.valueOf(guildScheduledEventStatus2.getApiValue()));
        } else {
            jsonWriter.s();
        }
    }
}
