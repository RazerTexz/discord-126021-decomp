package com.discord.utilities.channel;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.rx.ObservableWithLeadingEdgeThrottle;
import d0.z.d.m;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: GuildChannelsInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildChannelsInfo$Companion {
    private GuildChannelsInfo$Companion() {
    }

    public final Observable<GuildChannelsInfo> get(long guildId) {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<GuildChannelsInfo> observableR = ObservableWithLeadingEdgeThrottle.combineLatest(storeStream$Companion.getUsers().observeMe(true), storeStream$Companion.getGuilds().observeGuild(guildId), storeStream$Companion.getUserGuildSettings().observeGuildSettings(guildId), storeStream$Companion.getUserGuildSettings().observeHideMutedChannels(guildId), storeStream$Companion.getGuilds().observeRoles(guildId), storeStream$Companion.getPermissions().observePermissionsForGuild(guildId), storeStream$Companion.getPermissions().observeChannelPermissionsForGuild(guildId), storeStream$Companion.getChannels().observeChannelCategories(guildId), GuildChannelsInfo$Companion$get$1.INSTANCE, 500L, TimeUnit.MILLISECONDS).r();
        m.checkNotNullExpressionValue(observableR, "ObservableWithLeadingEdg…  .distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ GuildChannelsInfo$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
