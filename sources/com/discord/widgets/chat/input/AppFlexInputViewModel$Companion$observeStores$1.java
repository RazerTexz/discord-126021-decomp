package com.discord.widgets.chat.input;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import j0.k.b;
import rx.Observable;

/* JADX INFO: compiled from: AppFlexInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppFlexInputViewModel$Companion$observeStores$1<T, R> implements b<StoreChannelsSelected$ResolvedSelectedChannel, Observable<? extends AppFlexInputViewModel$StoreState>> {
    public static final AppFlexInputViewModel$Companion$observeStores$1 INSTANCE = new AppFlexInputViewModel$Companion$observeStores$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends AppFlexInputViewModel$StoreState> call(StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel) {
        return call2(storeChannelsSelected$ResolvedSelectedChannel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends AppFlexInputViewModel$StoreState> call2(StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel) {
        Channel channelOrParent = storeChannelsSelected$ResolvedSelectedChannel.getChannelOrParent();
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        return Observable.f(storeStream$Companion.getNavigation().observeLeftPanelState(), storeStream$Companion.getNavigation().observeRightPanelState(), storeStream$Companion.getPermissions().observePermissionsForChannel(channelOrParent != null ? channelOrParent.getId() : 0L), storeStream$Companion.getNotices().getNotices(), storeStream$Companion.getUserSettings().observeIsStickerSuggestionsEnabled(), storeStream$Companion.getExpressionSuggestions().observeSuggestionsEnabled(), new AppFlexInputViewModel$Companion$observeStores$1$1(channelOrParent, storeChannelsSelected$ResolvedSelectedChannel));
    }
}
