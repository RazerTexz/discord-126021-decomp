package com.discord.widgets.channels.settings;

import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserGuildSettings;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: ChannelGroupDMSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelGroupDMSettingsViewModel$Companion {
    private ChannelGroupDMSettingsViewModel$Companion() {
    }

    private final Observable<ChannelGroupDMSettingsViewModel$StoreState> observeStoreState(long channelId, StoreChannels storeChannels, StoreUserGuildSettings storeUserGuildSettings) {
        Observable observableY = storeChannels.observeChannel(channelId).Y(new ChannelGroupDMSettingsViewModel$Companion$observeStoreState$1(storeUserGuildSettings));
        m.checkNotNullExpressionValue(observableY, "storeChannels\n          …            }\n          }");
        return observableY;
    }

    public static /* synthetic */ Observable observeStoreState$default(ChannelGroupDMSettingsViewModel$Companion channelGroupDMSettingsViewModel$Companion, long j, StoreChannels storeChannels, StoreUserGuildSettings storeUserGuildSettings, int i, Object obj) {
        if ((i & 2) != 0) {
            storeChannels = StoreStream.Companion.getChannels();
        }
        if ((i & 4) != 0) {
            storeUserGuildSettings = StoreStream.Companion.getUserGuildSettings();
        }
        return channelGroupDMSettingsViewModel$Companion.observeStoreState(j, storeChannels, storeUserGuildSettings);
    }

    public /* synthetic */ ChannelGroupDMSettingsViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
