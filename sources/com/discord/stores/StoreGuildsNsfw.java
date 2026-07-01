package com.discord.stores;

import android.content.Context;
import android.content.SharedPreferences$Editor;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.g0.s;
import d0.t.n0;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: StoreGuildsNsfw.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildsNsfw extends StoreV2 {
    private static final StoreGuildsNsfw$Companion Companion = new StoreGuildsNsfw$Companion(null);

    @Deprecated
    private static final String GUILDS_ALLOWED_KEY = "GUILDS_ALLOWED_KEY";
    private final Dispatcher dispatcher;
    private final Set<Long> guildIdsAllowed;
    private Set<Long> guildIdsAllowedSnapshot;
    private final ObservationDeck observationDeck;
    private final StoreChannels storeChannels;

    public StoreGuildsNsfw(Dispatcher dispatcher, StoreChannels storeChannels, ObservationDeck observationDeck) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.storeChannels = storeChannels;
        this.observationDeck = observationDeck;
        this.guildIdsAllowed = new LinkedHashSet();
        this.guildIdsAllowedSnapshot = n0.emptySet();
    }

    public static final /* synthetic */ Set access$getGuildIdsAllowed$p(StoreGuildsNsfw storeGuildsNsfw) {
        return storeGuildsNsfw.guildIdsAllowed;
    }

    private final Set<Long> toGuildIdSet(Set<String> set) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            Long longOrNull = s.toLongOrNull((String) it.next());
            if (longOrNull != null) {
                arrayList.add(longOrNull);
            }
        }
        return u.toSet(arrayList);
    }

    private final Set<String> toStringSet(Set<Long> set) {
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((Number) it.next()).longValue()));
        }
        return u.toSet(arrayList);
    }

    public final void allow(long guildId) {
        this.dispatcher.schedule(new StoreGuildsNsfw$allow$1(this, guildId));
    }

    public final void deny(long guildId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(this.storeChannels.observeDefaultChannel(guildId), 0L, false, 3, null), StoreGuildsNsfw.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, StoreGuildsNsfw$deny$1.INSTANCE, 62, (Object) null);
    }

    @Override // com.discord.stores.Store
    @StoreThread
    public void init(Context context) {
        Set<Long> setEmptySet;
        m.checkNotNullParameter(context, "context");
        super.init(context);
        Set<String> stringSet = getPrefs().getStringSet(GUILDS_ALLOWED_KEY, n0.emptySet());
        if (stringSet == null || (setEmptySet = toGuildIdSet(stringSet)) == null) {
            setEmptySet = n0.emptySet();
        }
        this.guildIdsAllowed.addAll(setEmptySet);
        markChanged();
    }

    public final boolean isGuildNsfwGateAgreed(long guildId) {
        return this.guildIdsAllowedSnapshot.contains(Long.valueOf(guildId));
    }

    public final Observable<Boolean> observeIsGuildNsfwGateAgreed(long guildId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreGuildsNsfw$observeIsGuildNsfwGateAgreed$1(this, guildId), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        this.guildIdsAllowedSnapshot = new HashSet(this.guildIdsAllowed);
        SharedPreferences$Editor sharedPreferences$EditorEdit = getPrefs().edit();
        m.checkNotNullExpressionValue(sharedPreferences$EditorEdit, "editor");
        sharedPreferences$EditorEdit.putStringSet(GUILDS_ALLOWED_KEY, toStringSet(this.guildIdsAllowed));
        sharedPreferences$EditorEdit.apply();
    }
}
