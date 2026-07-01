package com.discord.stores;

import com.discord.api.emoji.GuildEmojisUpdate;
import com.discord.models.domain.emoji.ModelEmojiGuild;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: StoreEmojiGuild.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreEmojiGuild extends StoreV2 {
    private long activeGuildId;
    private final Dispatcher dispatcher;
    private final Map<Long, List<ModelEmojiGuild>> guildEmoji;
    private Map<Long, ? extends List<ModelEmojiGuild>> guildEmojiSnapshot;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;

    /* JADX INFO: renamed from: com.discord.stores.StoreEmojiGuild$activate$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreEmojiGuild.kt */
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
            StoreEmojiGuild.this.activeGuildId = this.$guildId;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreEmojiGuild$deactivate$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreEmojiGuild.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreEmojiGuild.this.activeGuildId = -1L;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreEmojiGuild$deleteEmoji$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreEmojiGuild.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $emojiId;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$emojiId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Map map = StoreEmojiGuild.this.guildEmoji;
            Long lValueOf = Long.valueOf(this.$guildId);
            List listEmptyList = (List) StoreEmojiGuild.this.guildEmoji.get(Long.valueOf(this.$guildId));
            if (listEmptyList == null) {
                listEmptyList = Collections2.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : listEmptyList) {
                if (this.$emojiId != ((ModelEmojiGuild) obj).getId()) {
                    arrayList.add(obj);
                }
            }
            map.put(lValueOf, arrayList);
            StoreEmojiGuild.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreEmojiGuild$fetchGuildEmoji$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreEmojiGuild.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends ModelEmojiGuild>, Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelEmojiGuild> list) {
            invoke2((List<ModelEmojiGuild>) list);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ModelEmojiGuild> list) {
            Intrinsics3.checkNotNullParameter(list, "emojis");
            StoreEmojiGuild.this.handleGuildEmojisLoaded(this.$guildId, list);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreEmojiGuild$handleGuildEmojisLoaded$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreEmojiGuild.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ List $emojis;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list, long j) {
            super(0);
            this.$emojis = list;
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreEmojiGuild.this.guildEmoji.put(Long.valueOf(this.$guildId), this.$emojis);
            StoreEmojiGuild.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreEmojiGuild$observeGuildEmoji$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreEmojiGuild.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<List<? extends ModelEmojiGuild>> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends ModelEmojiGuild> invoke() {
            return StoreEmojiGuild.this.getGuildEmoji(this.$guildId);
        }
    }

    public StoreEmojiGuild(ObservationDeck observationDeck, Dispatcher dispatcher, RestAPI restAPI) {
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        this.guildEmoji = new LinkedHashMap();
        this.guildEmojiSnapshot = Maps6.emptyMap();
        this.activeGuildId = -1L;
    }

    @Store3
    private final void handleGuildEmojisLoaded(long guildId, List<ModelEmojiGuild> emojis) {
        this.dispatcher.schedule(new AnonymousClass1(emojis, guildId));
    }

    public final void activate(long guildId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId));
    }

    public final void deactivate() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public final void deleteEmoji(long guildId, long emojiId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId, emojiId));
    }

    public final void fetchGuildEmoji(long guildId) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getGuildEmojis(guildId), false, 1, null), (Class<?>) StoreEmojiGuild.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(guildId));
    }

    public final List<ModelEmojiGuild> getGuildEmoji(long guildId) {
        return this.guildEmojiSnapshot.get(Long.valueOf(guildId));
    }

    @Store3
    public final void handleEmojiUpdate(GuildEmojisUpdate emojiUpdate) {
        Intrinsics3.checkNotNullParameter(emojiUpdate, "emojiUpdate");
        long guildId = emojiUpdate.getGuildId();
        long j = this.activeGuildId;
        if (guildId == j) {
            fetchGuildEmoji(j);
        }
    }

    public final Observable<List<ModelEmojiGuild>> observeGuildEmoji(long guildId) {
        Observable<List<ModelEmojiGuild>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.guildEmojiSnapshot = new HashMap(this.guildEmoji);
    }
}
