package com.discord.stores;

import android.content.Context;
import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.models.domain.ModelPayload;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import d0.z.d.m;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import rx.Observable;

/* JADX INFO: compiled from: StoreCollapsedChannelCategories.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreCollapsedChannelCategories extends StoreV2 {
    private static final String CACHE_KEY_COLLAPSED_CATEGORIES = "STORE_COLLAPSED_CATEGORIES_V2";
    public static final StoreCollapsedChannelCategories$Companion Companion = new StoreCollapsedChannelCategories$Companion(null);
    private Map<Long, Set<Long>> collapsedCategories;
    private Map<Long, Set<Long>> collapsedCategoriesSnapshot;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;

    public StoreCollapsedChannelCategories(Dispatcher dispatcher, ObservationDeck observationDeck) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.collapsedCategories = new HashMap();
        this.collapsedCategoriesSnapshot = new HashMap();
    }

    public static final /* synthetic */ void access$setCollapsedState(StoreCollapsedChannelCategories storeCollapsedChannelCategories, long j, long j2, boolean z2) {
        storeCollapsedChannelCategories.setCollapsedState(j, j2, z2);
    }

    private final void setCollapsedState(long guildId, long categoryId, boolean collapsed) {
        Map<Long, Set<Long>> map = this.collapsedCategories;
        Long lValueOf = Long.valueOf(guildId);
        Set<Long> hashSet = map.get(lValueOf);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            map.put(lValueOf, hashSet);
        }
        Set<Long> set = hashSet;
        if (collapsed) {
            set.add(Long.valueOf(categoryId));
        } else {
            set.remove(Long.valueOf(categoryId));
            if (set.isEmpty()) {
                this.collapsedCategories.remove(Long.valueOf(guildId));
            }
        }
        markChanged();
    }

    public final Map<Long, Set<Long>> getCollapsedCategories() {
        return this.collapsedCategoriesSnapshot;
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        HashSet hashSet = new HashSet(this.collapsedCategories.keySet());
        List<Guild> guilds = payload.getGuilds();
        m.checkNotNullExpressionValue(guilds, "payload.guilds");
        for (Guild guild : guilds) {
            Set<Long> set = this.collapsedCategories.get(Long.valueOf(guild.getId()));
            if (set != null) {
                HashSet<Long> hashSet2 = new HashSet(set);
                List<Channel> listG = guild.g();
                if (listG != null) {
                    Iterator<T> it = listG.iterator();
                    while (it.hasNext()) {
                        hashSet2.remove(Long.valueOf(((Channel) it.next()).getId()));
                    }
                }
                for (Long l : hashSet2) {
                    long id2 = guild.getId();
                    m.checkNotNullExpressionValue(l, "channelId");
                    setCollapsedState(id2, l.longValue(), false);
                }
                hashSet.remove(Long.valueOf(guild.getId()));
            }
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            this.collapsedCategories.remove((Long) it2.next());
            markChanged();
        }
    }

    @Override // com.discord.stores.Store
    @StoreThread
    public void init(Context context) {
        m.checkNotNullParameter(context, "context");
        super.init(context);
        this.collapsedCategories = StoreCollapsedChannelCategories$Companion.access$fromCache(Companion, getPrefs());
        markChanged();
    }

    public final Observable<Set<Long>> observeCollapsedCategories(long guildId) {
        Observable<Set<Long>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreCollapsedChannelCategories$observeCollapsedCategories$1(this, guildId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final void setCollapsedCategory(long guildId, long categoryId, boolean collapsed) {
        this.dispatcher.schedule(new StoreCollapsedChannelCategories$setCollapsedCategory$1(this, guildId, categoryId, collapsed));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        StoreCollapsedChannelCategories$Companion.access$toCache(Companion, getPrefs(), this.collapsedCategories);
        HashMap map = new HashMap(this.collapsedCategories);
        Iterator<T> it = this.collapsedCategories.entrySet().iterator();
        while (it.hasNext()) {
            Map$Entry map$Entry = (Map$Entry) it.next();
            map.put(map$Entry.getKey(), new HashSet((Set) map$Entry.getValue()));
        }
        this.collapsedCategoriesSnapshot = map;
    }
}
