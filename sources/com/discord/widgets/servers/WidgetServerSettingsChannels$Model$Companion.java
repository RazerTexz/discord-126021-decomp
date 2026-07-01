package com.discord.widgets.servers;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.f0.q;
import d0.t.u;
import d0.z.d.m;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsChannels$Model$Companion {
    private WidgetServerSettingsChannels$Model$Companion() {
    }

    public final Observable<WidgetServerSettingsChannels$Model> get(long guildId, Observable<Integer> channelTypeObservable) {
        m.checkNotNullParameter(channelTypeObservable, "channelTypeObservable");
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableE = Observable.e(StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null), storeStream$Companion.getPermissions().observePermissionsForGuild(guildId), storeStream$Companion.getGuilds().observeGuild(guildId), StoreChannels.observeChannelsForGuild$default(storeStream$Companion.getChannels(), guildId, null, 2, null), storeStream$Companion.getChannels().observeChannelCategories(guildId), storeStream$Companion.getPermissions().observeChannelPermissionsForGuild(guildId), channelTypeObservable, WidgetServerSettingsChannels$Model$Companion$get$1.INSTANCE);
        m.checkNotNullExpressionValue(observableE, "Observable\n            .…ermissions)\n            }");
        Observable<WidgetServerSettingsChannels$Model> observableR = ObservableExtensionsKt.computationLatest(observableE).r();
        m.checkNotNullExpressionValue(observableR, "Observable\n            .…  .distinctUntilChanged()");
        return observableR;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final LinkedHashMap<Long, Channel> getSortedGuildChannels(Map<Long, Channel> guildChannels, int channelType) {
        m.checkNotNullParameter(guildChannels, "guildChannels");
        LinkedHashMap<Long, Channel> linkedHashMap = new LinkedHashMap<>();
        for (Object obj : q.sortedWith(q.filter(u.asSequence(guildChannels.values()), new WidgetServerSettingsChannels$Model$Companion$getSortedGuildChannels$$inlined$also$lambda$1(guildChannels, channelType)), ChannelUtils.h(Channel.Companion))) {
            linkedHashMap.put(Long.valueOf(((Channel) obj).getId()), obj);
        }
        return linkedHashMap;
    }

    public /* synthetic */ WidgetServerSettingsChannels$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
