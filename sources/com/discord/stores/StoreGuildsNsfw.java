package com.discord.stores;

import android.content.Context;
import android.content.SharedPreferences;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p579g0.C12102s;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: StoreGuildsNsfw.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildsNsfw extends StoreV2 {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    private static final String GUILDS_ALLOWED_KEY = "GUILDS_ALLOWED_KEY";
    private final Dispatcher dispatcher;
    private final Set<Long> guildIdsAllowed;
    private Set<Long> guildIdsAllowedSnapshot;
    private final ObservationDeck observationDeck;
    private final StoreChannels storeChannels;

    /* JADX INFO: compiled from: StoreGuildsNsfw.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildsNsfw$allow$1 */
    /* JADX INFO: compiled from: StoreGuildsNsfw.kt */
    public static final class C61151 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C61151(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildsNsfw.this.guildIdsAllowed.add(Long.valueOf(this.$guildId));
            StoreGuildsNsfw.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildsNsfw$deny$1 */
    /* JADX INFO: compiled from: StoreGuildsNsfw.kt */
    public static final class C61161 extends AbstractC12240o implements Function1<Channel, Unit> {
        public static final C61161 INSTANCE = new C61161();

        public C61161() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            if (channel == null || channel.getNsfw()) {
                ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), 0L, 0L, null, null, 12, null);
            } else {
                ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), channel, null, null, 6, null);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildsNsfw$observeIsGuildNsfwGateAgreed$1 */
    /* JADX INFO: compiled from: StoreGuildsNsfw.kt */
    public static final class C61171 extends AbstractC12240o implements Function0<Boolean> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C61171(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            return StoreGuildsNsfw.this.isGuildNsfwGateAgreed(this.$guildId);
        }
    }

    public StoreGuildsNsfw(Dispatcher dispatcher, StoreChannels storeChannels, ObservationDeck observationDeck) {
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(storeChannels, "storeChannels");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.storeChannels = storeChannels;
        this.observationDeck = observationDeck;
        this.guildIdsAllowed = new LinkedHashSet();
        this.guildIdsAllowedSnapshot = C12148n0.emptySet();
    }

    private final Set<Long> toGuildIdSet(Set<String> set) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            Long longOrNull = C12102s.toLongOrNull((String) it.next());
            if (longOrNull != null) {
                arrayList.add(longOrNull);
            }
        }
        return C12163u.toSet(arrayList);
    }

    private final Set<String> toStringSet(Set<Long> set) {
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((Number) it.next()).longValue()));
        }
        return C12163u.toSet(arrayList);
    }

    public final void allow(long guildId) {
        this.dispatcher.schedule(new C61151(guildId));
    }

    public final void deny(long guildId) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.takeSingleUntilTimeout$default(this.storeChannels.observeDefaultChannel(guildId), 0L, false, 3, null), (Class<?>) StoreGuildsNsfw.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), C61161.INSTANCE);
    }

    @Override // com.discord.stores.Store
    @StoreThread
    public void init(Context context) {
        Set<Long> setEmptySet;
        C12238m.checkNotNullParameter(context, "context");
        super.init(context);
        Set<String> stringSet = getPrefs().getStringSet(GUILDS_ALLOWED_KEY, C12148n0.emptySet());
        if (stringSet == null || (setEmptySet = toGuildIdSet(stringSet)) == null) {
            setEmptySet = C12148n0.emptySet();
        }
        this.guildIdsAllowed.addAll(setEmptySet);
        markChanged();
    }

    public final boolean isGuildNsfwGateAgreed(long guildId) {
        return this.guildIdsAllowedSnapshot.contains(Long.valueOf(guildId));
    }

    public final Observable<Boolean> observeIsGuildNsfwGateAgreed(long guildId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C61171(guildId), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        this.guildIdsAllowedSnapshot = new HashSet(this.guildIdsAllowed);
        SharedPreferences.Editor editorEdit = getPrefs().edit();
        C12238m.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putStringSet(GUILDS_ALLOWED_KEY, toStringSet(this.guildIdsAllowed));
        editorEdit.apply();
    }
}
