package com.discord.widgets.guildscheduledevent;

import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.rest.RestAPI;
import kotlin.Unit;
import p658rx.Observable;

/* JADX INFO: compiled from: GuildScheduledEventAPI.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventAPI {
    public static final GuildScheduledEventAPI INSTANCE = new GuildScheduledEventAPI();

    private GuildScheduledEventAPI() {
    }

    public final Observable<Unit> endEvent(long guildId, long guildScheduledEventId) {
        return RestAPI.INSTANCE.getApi().updateGuildScheduledEvent(guildId, guildScheduledEventId, new RestAPIParams.UpdateGuildScheduledEventBody(null, null, null, null, null, null, null, null, GuildScheduledEventStatus.COMPLETED, null, 767, null));
    }

    public final Observable<Unit> startEvent(long guildId, long guildScheduledEventId) {
        return RestAPI.INSTANCE.getApi().updateGuildScheduledEvent(guildId, guildScheduledEventId, new RestAPIParams.UpdateGuildScheduledEventBody(null, null, null, null, null, null, null, null, GuildScheduledEventStatus.ACTIVE, null, 767, null));
    }
}
