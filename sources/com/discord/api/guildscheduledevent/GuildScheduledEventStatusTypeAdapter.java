package com.discord.api.guildscheduledevent;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.Objects;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildScheduledEventStatus.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildScheduledEventStatusTypeAdapter extends TypeAdapter<GuildScheduledEventStatus> {
    @Override // com.google.gson.TypeAdapter
    public GuildScheduledEventStatus read(JsonReader jsonReader) throws IOException {
        C12238m.checkNotNullParameter(jsonReader, "in");
        GuildScheduledEventStatus.Companion companion = GuildScheduledEventStatus.INSTANCE;
        int iMo6891y = jsonReader.mo6891y();
        Objects.requireNonNull(companion);
        if (iMo6891y == 1) {
            return GuildScheduledEventStatus.SCHEDULED;
        }
        if (iMo6891y == 2) {
            return GuildScheduledEventStatus.ACTIVE;
        }
        if (iMo6891y != 3) {
            return iMo6891y != 4 ? GuildScheduledEventStatus.UNKNOWN : GuildScheduledEventStatus.CANCELED;
        }
        return GuildScheduledEventStatus.COMPLETED;
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, GuildScheduledEventStatus guildScheduledEventStatus) throws IOException {
        GuildScheduledEventStatus guildScheduledEventStatus2 = guildScheduledEventStatus;
        C12238m.checkNotNullParameter(jsonWriter, "out");
        if (guildScheduledEventStatus2 != null) {
            jsonWriter.mo6894D(Integer.valueOf(guildScheduledEventStatus2.getApiValue()));
        } else {
            jsonWriter.mo6905s();
        }
    }
}
