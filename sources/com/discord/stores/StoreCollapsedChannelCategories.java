package com.discord.stores;

import android.content.Context;
import android.content.SharedPreferences;
import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.models.domain.ModelPayload;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.cache.SharedPreferenceExtensions;
import d0.t.Sets5;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: StoreCollapsedChannelCategories.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreCollapsedChannelCategories extends StoreV2 {
    private static final String CACHE_KEY_COLLAPSED_CATEGORIES = "STORE_COLLAPSED_CATEGORIES_V2";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Map<Long, Set<Long>> collapsedCategories;
    private Map<Long, Set<Long>> collapsedCategoriesSnapshot;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;

    /* JADX INFO: compiled from: StoreCollapsedChannelCategories.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Map<Long, Set<Long>> fromCache(SharedPreferences prefs) {
            return SharedPreferenceExtensions.getStringEntrySetAsMap$default(prefs, StoreCollapsedChannelCategories.CACHE_KEY_COLLAPSED_CATEGORIES, null, StoreCollapsedChannelCategories2.INSTANCE, 2, null);
        }

        private final void toCache(SharedPreferences prefs, Map<Long, Set<Long>> collapsedCategories) {
            SharedPreferences.Editor editorEdit = prefs.edit();
            Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
            SharedPreferenceExtensions.putStringEntrySetAsMap$default(editorEdit, StoreCollapsedChannelCategories.CACHE_KEY_COLLAPSED_CATEGORIES, collapsedCategories, null, StoreCollapsedChannelCategories4.INSTANCE, 4, null);
            editorEdit.apply();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreCollapsedChannelCategories$observeCollapsedCategories$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreCollapsedChannelCategories.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Set<? extends Long>> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Set<? extends Long> invoke() {
            Set<Long> setEmptySet = StoreCollapsedChannelCategories.this.getCollapsedCategories().get(Long.valueOf(this.$guildId));
            if (setEmptySet == null) {
                setEmptySet = Sets5.emptySet();
            }
            return setEmptySet;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreCollapsedChannelCategories$setCollapsedCategory$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreCollapsedChannelCategories.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $categoryId;
        public final /* synthetic */ boolean $collapsed;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2, boolean z2) {
            super(0);
            this.$guildId = j;
            this.$categoryId = j2;
            this.$collapsed = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreCollapsedChannelCategories.this.setCollapsedState(this.$guildId, this.$categoryId, this.$collapsed);
        }
    }

    public StoreCollapsedChannelCategories(Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.collapsedCategories = new HashMap();
        this.collapsedCategoriesSnapshot = new HashMap();
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

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        HashSet hashSet = new HashSet(this.collapsedCategories.keySet());
        List<Guild> guilds = payload.getGuilds();
        Intrinsics3.checkNotNullExpressionValue(guilds, "payload.guilds");
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
                    Intrinsics3.checkNotNullExpressionValue(l, "channelId");
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
    @Store3
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        this.collapsedCategories = INSTANCE.fromCache(getPrefs());
        markChanged();
    }

    public final Observable<Set<Long>> observeCollapsedCategories(long guildId) {
        Observable<Set<Long>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        return observableR;
    }

    public final void setCollapsedCategory(long guildId, long categoryId, boolean collapsed) {
        this.dispatcher.schedule(new AnonymousClass1(guildId, categoryId, collapsed));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        INSTANCE.toCache(getPrefs(), this.collapsedCategories);
        HashMap map = new HashMap(this.collapsedCategories);
        Iterator<T> it = this.collapsedCategories.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            map.put(entry.getKey(), new HashSet((Set) entry.getValue()));
        }
        this.collapsedCategoriesSnapshot = map;
    }
}
