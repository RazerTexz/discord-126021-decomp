package com.discord.stores;

import android.content.Context;
import com.discord.api.emoji.GuildEmojisUpdate;
import com.discord.models.domain.emoji.ModelEmojiGuild;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.h0;
import d0.z.d.m;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: StoreEmojiGuild.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreEmojiGuild extends StoreV2 {
    private long activeGuildId;
    private final Dispatcher dispatcher;
    private final Map<Long, List<ModelEmojiGuild>> guildEmoji;
    private Map<Long, ? extends List<ModelEmojiGuild>> guildEmojiSnapshot;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;

    public StoreEmojiGuild(ObservationDeck observationDeck, Dispatcher dispatcher, RestAPI restAPI) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(restAPI, "restAPI");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        this.guildEmoji = new LinkedHashMap();
        this.guildEmojiSnapshot = h0.emptyMap();
        this.activeGuildId = -1L;
    }

    public static final /* synthetic */ long access$getActiveGuildId$p(StoreEmojiGuild storeEmojiGuild) {
        return storeEmojiGuild.activeGuildId;
    }

    public static final /* synthetic */ Map access$getGuildEmoji$p(StoreEmojiGuild storeEmojiGuild) {
        return storeEmojiGuild.guildEmoji;
    }

    public static final /* synthetic */ void access$handleGuildEmojisLoaded(StoreEmojiGuild storeEmojiGuild, long j, List list) {
        storeEmojiGuild.handleGuildEmojisLoaded(j, list);
    }

    public static final /* synthetic */ void access$setActiveGuildId$p(StoreEmojiGuild storeEmojiGuild, long j) {
        storeEmojiGuild.activeGuildId = j;
    }

    @StoreThread
    private final void handleGuildEmojisLoaded(long guildId, List<ModelEmojiGuild> emojis) {
        this.dispatcher.schedule(new StoreEmojiGuild$handleGuildEmojisLoaded$1(this, emojis, guildId));
    }

    public final void activate(long guildId) {
        this.dispatcher.schedule(new StoreEmojiGuild$activate$1(this, guildId));
    }

    public final void deactivate() {
        this.dispatcher.schedule(new StoreEmojiGuild$deactivate$1(this));
    }

    public final void deleteEmoji(long guildId, long emojiId) {
        this.dispatcher.schedule(new StoreEmojiGuild$deleteEmoji$1(this, guildId, emojiId));
    }

    public final void fetchGuildEmoji(long guildId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getGuildEmojis(guildId), false, 1, null), StoreEmojiGuild.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreEmojiGuild$fetchGuildEmoji$1(this, guildId), 62, (Object) null);
    }

    public final List<ModelEmojiGuild> getGuildEmoji(long guildId) {
        return this.guildEmojiSnapshot.get(Long.valueOf(guildId));
    }

    @StoreThread
    public final void handleEmojiUpdate(GuildEmojisUpdate emojiUpdate) {
        m.checkNotNullParameter(emojiUpdate, "emojiUpdate");
        long guildId = emojiUpdate.getGuildId();
        long j = this.activeGuildId;
        if (guildId == j) {
            fetchGuildEmoji(j);
        }
    }

    public final Observable<List<ModelEmojiGuild>> observeGuildEmoji(long guildId) {
        Observable<List<ModelEmojiGuild>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreEmojiGuild$observeGuildEmoji$1(this, guildId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.guildEmojiSnapshot = new HashMap(this.guildEmoji);
    }
}
