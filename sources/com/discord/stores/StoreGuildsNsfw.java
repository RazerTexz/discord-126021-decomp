package com.discord.stores;

import android.content.Context;
import android.content.SharedPreferences;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.g0.StringNumberConversions;
import d0.t.Iterables2;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

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

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildsNsfw$allow$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildsNsfw.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildsNsfw.this.guildIdsAllowed.add(Long.valueOf(this.$guildId));
            StoreGuildsNsfw.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildsNsfw$deny$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildsNsfw.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
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

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildsNsfw$observeIsGuildNsfwGateAgreed$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildsNsfw.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Boolean> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
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
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.storeChannels = storeChannels;
        this.observationDeck = observationDeck;
        this.guildIdsAllowed = new LinkedHashSet();
        this.guildIdsAllowedSnapshot = Sets5.emptySet();
    }

    private final Set<Long> toGuildIdSet(Set<String> set) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            Long longOrNull = StringNumberConversions.toLongOrNull((String) it.next());
            if (longOrNull != null) {
                arrayList.add(longOrNull);
            }
        }
        return _Collections.toSet(arrayList);
    }

    private final Set<String> toStringSet(Set<Long> set) {
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((Number) it.next()).longValue()));
        }
        return _Collections.toSet(arrayList);
    }

    public final void allow(long guildId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId));
    }

    public final void deny(long guildId) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.takeSingleUntilTimeout$default(this.storeChannels.observeDefaultChannel(guildId), 0L, false, 3, null), (Class<?>) StoreGuildsNsfw.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), AnonymousClass1.INSTANCE);
    }

    @Override // com.discord.stores.Store
    @Store3
    public void init(Context context) {
        Set<Long> setEmptySet;
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        Set<String> stringSet = getPrefs().getStringSet(GUILDS_ALLOWED_KEY, Sets5.emptySet());
        if (stringSet == null || (setEmptySet = toGuildIdSet(stringSet)) == null) {
            setEmptySet = Sets5.emptySet();
        }
        this.guildIdsAllowed.addAll(setEmptySet);
        markChanged();
    }

    public final boolean isGuildNsfwGateAgreed(long guildId) {
        return this.guildIdsAllowedSnapshot.contains(Long.valueOf(guildId));
    }

    public final Observable<Boolean> observeIsGuildNsfwGateAgreed(long guildId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        this.guildIdsAllowedSnapshot = new HashSet(this.guildIdsAllowed);
        SharedPreferences.Editor editorEdit = getPrefs().edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
        editorEdit.putStringSet(GUILDS_ALLOWED_KEY, toStringSet(this.guildIdsAllowed));
        editorEdit.apply();
    }
}
