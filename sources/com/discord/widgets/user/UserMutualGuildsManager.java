package com.discord.widgets.user;

import com.discord.models.guild.Guild;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreGuildsSorted;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import d0.z.d.m;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: UserMutualGuildsManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserMutualGuildsManager {
    private final ObservationDeck observationDeck;
    private final StoreGuilds storeGuilds;
    private final StoreGuildsSorted storeGuildsSorted;

    public UserMutualGuildsManager() {
        this(null, null, null, 7, null);
    }

    public UserMutualGuildsManager(StoreGuildsSorted storeGuildsSorted, StoreGuilds storeGuilds, ObservationDeck observationDeck) {
        m.checkNotNullParameter(storeGuildsSorted, "storeGuildsSorted");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.storeGuildsSorted = storeGuildsSorted;
        this.storeGuilds = storeGuilds;
        this.observationDeck = observationDeck;
    }

    public static final /* synthetic */ StoreGuilds access$getStoreGuilds$p(UserMutualGuildsManager userMutualGuildsManager) {
        return userMutualGuildsManager.storeGuilds;
    }

    public static final /* synthetic */ StoreGuildsSorted access$getStoreGuildsSorted$p(UserMutualGuildsManager userMutualGuildsManager) {
        return userMutualGuildsManager.storeGuildsSorted;
    }

    public final Observable<Map<Long, List<Guild>>> observeMutualGuilds(Collection<Long> userIds) {
        m.checkNotNullParameter(userIds, "userIds");
        Observable<Map<Long, List<Guild>>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this.storeGuildsSorted, this.storeGuilds}, false, null, null, new UserMutualGuildsManager$observeMutualGuilds$1(this, userIds), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ UserMutualGuildsManager(StoreGuildsSorted storeGuildsSorted, StoreGuilds storeGuilds, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? StoreStream.Companion.getGuildsSorted() : storeGuildsSorted, (i & 2) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds, (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }
}
