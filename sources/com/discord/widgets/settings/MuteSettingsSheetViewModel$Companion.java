package com.discord.widgets.settings;

import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreThreadsJoined;
import com.discord.stores.StoreUserGuildSettings;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: MuteSettingsSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MuteSettingsSheetViewModel$Companion {
    private MuteSettingsSheetViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(MuteSettingsSheetViewModel$Companion muteSettingsSheetViewModel$Companion, long j, long j2, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreUserGuildSettings storeUserGuildSettings, StoreThreadsJoined storeThreadsJoined) {
        return muteSettingsSheetViewModel$Companion.observeStoreState(j, j2, storeGuilds, storeChannels, storeUserGuildSettings, storeThreadsJoined);
    }

    private final Observable<MuteSettingsSheetViewModel$StoreState> observeStoreState(long guildId, long channelId, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreUserGuildSettings storeUserGuildSettings, StoreThreadsJoined storeThreadsJoined) {
        Observable<MuteSettingsSheetViewModel$StoreState> observableH = Observable.h(storeGuilds.observeGuild(guildId), storeChannels.observeChannel(channelId), storeUserGuildSettings.observeGuildSettings(), storeThreadsJoined.observeJoinedThread(channelId), MuteSettingsSheetViewModel$Companion$observeStoreState$1.INSTANCE);
        m.checkNotNullExpressionValue(observableH, "Observable.combineLatest…dThread\n        )\n      }");
        return observableH;
    }

    public /* synthetic */ MuteSettingsSheetViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
