package com.discord.stores;

import com.discord.api.emoji.GuildEmojisUpdate;
import com.discord.models.domain.emoji.ModelEmojiGuild;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: StoreEmojiGuild.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreEmojiGuild extends StoreV2 {
    private long activeGuildId;
    private final Dispatcher dispatcher;
    private final Map<Long, List<ModelEmojiGuild>> guildEmoji;
    private Map<Long, ? extends List<ModelEmojiGuild>> guildEmojiSnapshot;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;

    /* JADX INFO: renamed from: com.discord.stores.StoreEmojiGuild$activate$1 */
    /* JADX INFO: compiled from: StoreEmojiGuild.kt */
    public static final class C58991 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C58991(long j) {
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
            StoreEmojiGuild.this.activeGuildId = this.$guildId;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreEmojiGuild$deactivate$1 */
    /* JADX INFO: compiled from: StoreEmojiGuild.kt */
    public static final class C59001 extends AbstractC12240o implements Function0<Unit> {
        public C59001() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreEmojiGuild.this.activeGuildId = -1L;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreEmojiGuild$deleteEmoji$1 */
    /* JADX INFO: compiled from: StoreEmojiGuild.kt */
    public static final class C59011 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $emojiId;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59011(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$emojiId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Map map = StoreEmojiGuild.this.guildEmoji;
            Long lValueOf = Long.valueOf(this.$guildId);
            List listEmptyList = (List) StoreEmojiGuild.this.guildEmoji.get(Long.valueOf(this.$guildId));
            if (listEmptyList == null) {
                listEmptyList = C12147n.emptyList();
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

    /* JADX INFO: renamed from: com.discord.stores.StoreEmojiGuild$fetchGuildEmoji$1 */
    /* JADX INFO: compiled from: StoreEmojiGuild.kt */
    public static final class C59021 extends AbstractC12240o implements Function1<List<? extends ModelEmojiGuild>, Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59021(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelEmojiGuild> list) {
            invoke2((List<ModelEmojiGuild>) list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<ModelEmojiGuild> list) {
            C12238m.checkNotNullParameter(list, "emojis");
            StoreEmojiGuild.this.handleGuildEmojisLoaded(this.$guildId, list);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreEmojiGuild$handleGuildEmojisLoaded$1 */
    /* JADX INFO: compiled from: StoreEmojiGuild.kt */
    public static final class C59031 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ List $emojis;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59031(List list, long j) {
            super(0);
            this.$emojis = list;
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreEmojiGuild.this.guildEmoji.put(Long.valueOf(this.$guildId), this.$emojis);
            StoreEmojiGuild.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreEmojiGuild$observeGuildEmoji$1 */
    /* JADX INFO: compiled from: StoreEmojiGuild.kt */
    public static final class C59041 extends AbstractC12240o implements Function0<List<? extends ModelEmojiGuild>> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C59041(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends ModelEmojiGuild> invoke() {
            return StoreEmojiGuild.this.getGuildEmoji(this.$guildId);
        }
    }

    public StoreEmojiGuild(ObservationDeck observationDeck, Dispatcher dispatcher, RestAPI restAPI) {
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        this.guildEmoji = new LinkedHashMap();
        this.guildEmojiSnapshot = C12136h0.emptyMap();
        this.activeGuildId = -1L;
    }

    @StoreThread
    private final void handleGuildEmojisLoaded(long guildId, List<ModelEmojiGuild> emojis) {
        this.dispatcher.schedule(new C59031(emojis, guildId));
    }

    public final void activate(long guildId) {
        this.dispatcher.schedule(new C58991(guildId));
    }

    public final void deactivate() {
        this.dispatcher.schedule(new C59001());
    }

    public final void deleteEmoji(long guildId, long emojiId) {
        this.dispatcher.schedule(new C59011(guildId, emojiId));
    }

    public final void fetchGuildEmoji(long guildId) {
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getGuildEmojis(guildId), false, 1, null), (Class<?>) StoreEmojiGuild.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C59021(guildId));
    }

    public final List<ModelEmojiGuild> getGuildEmoji(long guildId) {
        return this.guildEmojiSnapshot.get(Long.valueOf(guildId));
    }

    @StoreThread
    public final void handleEmojiUpdate(GuildEmojisUpdate emojiUpdate) {
        C12238m.checkNotNullParameter(emojiUpdate, "emojiUpdate");
        long guildId = emojiUpdate.getGuildId();
        long j = this.activeGuildId;
        if (guildId == j) {
            fetchGuildEmoji(j);
        }
    }

    public final Observable<List<ModelEmojiGuild>> observeGuildEmoji(long guildId) {
        Observable<List<ModelEmojiGuild>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C59041(guildId), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.guildEmojiSnapshot = new HashMap(this.guildEmoji);
    }
}
