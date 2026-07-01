package com.discord.widgets.voice.fullscreen;

import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreMentions;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreVoiceChannelSelected;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetCallPreviewFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallPreviewFullscreenViewModel$Companion {
    private WidgetCallPreviewFullscreenViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(WidgetCallPreviewFullscreenViewModel$Companion widgetCallPreviewFullscreenViewModel$Companion, long j, StoreUser storeUser, StoreChannels storeChannels, StoreChannelsSelected storeChannelsSelected, StoreMentions storeMentions, StoreVoiceChannelSelected storeVoiceChannelSelected) {
        return widgetCallPreviewFullscreenViewModel$Companion.observeStoreState(j, storeUser, storeChannels, storeChannelsSelected, storeMentions, storeVoiceChannelSelected);
    }

    private final Observable<WidgetCallPreviewFullscreenViewModel$StoreState> observeStoreState(long voiceChannelId, StoreUser storeUser, StoreChannels storeChannels, StoreChannelsSelected storeChannelsSelected, StoreMentions storeMentions, StoreVoiceChannelSelected storeVoiceChannelSelected) {
        Observable observableY = storeChannels.observeChannel(voiceChannelId).Y(new WidgetCallPreviewFullscreenViewModel$Companion$observeStoreState$1(storeUser, storeChannelsSelected, storeMentions, voiceChannelId, storeVoiceChannelSelected));
        m.checkNotNullExpressionValue(observableY, "storeChannels.observeCha…  }\n          }\n        }");
        return observableY;
    }

    public /* synthetic */ WidgetCallPreviewFullscreenViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
