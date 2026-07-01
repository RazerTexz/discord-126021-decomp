package com.discord.widgets.home;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.presence.Presence;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreThreadsActive;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableWithLeadingEdgeThrottle;
import com.discord.widgets.chat.list.CreateThreadsFeatureFlag;
import d0.z.d.m;
import j0.k.b;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import rx.Observable;

/* JADX INFO: compiled from: WidgetHomeModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHomeModel$Companion$get$2<T, R> implements b<Pair<? extends Long, ? extends StoreChannelsSelected$ResolvedSelectedChannel>, Observable<? extends WidgetHomeModel>> {
    public static final WidgetHomeModel$Companion$get$2 INSTANCE = new WidgetHomeModel$Companion$get$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetHomeModel> call(Pair<? extends Long, ? extends StoreChannelsSelected$ResolvedSelectedChannel> pair) {
        return call2((Pair<Long, ? extends StoreChannelsSelected$ResolvedSelectedChannel>) pair);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetHomeModel> call2(Pair<Long, ? extends StoreChannelsSelected$ResolvedSelectedChannel> pair) {
        Long lValueOf;
        long id2;
        Long lComponent1 = pair.component1();
        StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannelComponent2 = pair.component2();
        Channel maybeChannel = storeChannelsSelected$ResolvedSelectedChannelComponent2.getMaybeChannel();
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableObserveMe$default = StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null);
        Observable<Map<Long, Presence>> observableObserveAllPresences = storeStream$Companion.getPresences().observeAllPresences();
        Observable<Channel> observableObserveSelectedChannel = storeStream$Companion.getVoiceChannelSelected().observeSelectedChannel();
        Observable<Integer> observableObserveTotalMentions = storeStream$Companion.getMentions().observeTotalMentions();
        Observable<Map<Long, Integer>> observableObserve = storeStream$Companion.getUserRelationships().observe();
        StoreThreadsActive threadsActive = storeStream$Companion.getThreadsActive();
        m.checkNotNullExpressionValue(lComponent1, "selectedGuildId");
        long jLongValue = lComponent1.longValue();
        if (maybeChannel == null || !ChannelUtils.H(maybeChannel)) {
            if (maybeChannel != null) {
                id2 = maybeChannel.getId();
            } else {
                lValueOf = null;
            }
            return ObservableWithLeadingEdgeThrottle.combineLatest(observableObserveMe$default, observableObserveAllPresences, observableObserveSelectedChannel, observableObserveTotalMentions, observableObserve, threadsActive.observeActiveThreadsForChannel(jLongValue, lValueOf), WidgetHomeModel.Companion.getParentChannelObservable(maybeChannel), new CreateThreadsFeatureFlag(null, null, 3, null).observeEnabled(lComponent1.longValue()), new WidgetHomeModel$Companion$get$2$1(maybeChannel, storeChannelsSelected$ResolvedSelectedChannelComponent2), 350L, TimeUnit.MILLISECONDS);
        }
        id2 = maybeChannel.getParentId();
        lValueOf = Long.valueOf(id2);
        return ObservableWithLeadingEdgeThrottle.combineLatest(observableObserveMe$default, observableObserveAllPresences, observableObserveSelectedChannel, observableObserveTotalMentions, observableObserve, threadsActive.observeActiveThreadsForChannel(jLongValue, lValueOf), WidgetHomeModel.Companion.getParentChannelObservable(maybeChannel), new CreateThreadsFeatureFlag(null, null, 3, null).observeEnabled(lComponent1.longValue()), new WidgetHomeModel$Companion$get$2$1(maybeChannel, storeChannelsSelected$ResolvedSelectedChannelComponent2), 350L, TimeUnit.MILLISECONDS);
    }
}
