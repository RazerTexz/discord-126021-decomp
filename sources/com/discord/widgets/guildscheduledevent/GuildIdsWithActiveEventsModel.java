package com.discord.widgets.guildscheduledevent;

import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import d0.z.d.m;
import java.util.Set;
import rx.Observable;

/* JADX INFO: compiled from: GuildIdsWithActiveEventsModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildIdsWithActiveEventsModel {
    public static final GuildIdsWithActiveEventsModel INSTANCE = new GuildIdsWithActiveEventsModel();

    private GuildIdsWithActiveEventsModel() {
    }

    public static /* synthetic */ Observable observe$default(GuildIdsWithActiveEventsModel guildIdsWithActiveEventsModel, StoreGuildScheduledEvents storeGuildScheduledEvents, ObservationDeck observationDeck, int i, Object obj) {
        if ((i & 1) != 0) {
            storeGuildScheduledEvents = StoreStream.Companion.getGuildScheduledEvents();
        }
        if ((i & 2) != 0) {
            observationDeck = ObservationDeckProvider.get();
        }
        return guildIdsWithActiveEventsModel.observe(storeGuildScheduledEvents, observationDeck);
    }

    public final Observable<Set<Long>> observe(StoreGuildScheduledEvents storeGuildScheduledEvents, ObservationDeck observationDeck) {
        m.checkNotNullParameter(storeGuildScheduledEvents, "storeGuildScheduledEvents");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck$UpdateSource[]{storeGuildScheduledEvents}, false, null, null, new GuildIdsWithActiveEventsModel$observe$1(storeGuildScheduledEvents), 14, null);
    }
}
