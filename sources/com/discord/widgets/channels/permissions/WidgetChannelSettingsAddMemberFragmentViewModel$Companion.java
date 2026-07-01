package com.discord.widgets.channels.permissions;

import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragmentViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsAddMemberFragmentViewModel$Companion {
    private WidgetChannelSettingsAddMemberFragmentViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(WidgetChannelSettingsAddMemberFragmentViewModel$Companion widgetChannelSettingsAddMemberFragmentViewModel$Companion, long j, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreUser storeUser) {
        return widgetChannelSettingsAddMemberFragmentViewModel$Companion.observeStoreState(j, storeChannels, storeGuilds, storeUser);
    }

    private final Observable<WidgetChannelSettingsAddMemberFragmentViewModel$StoreState> observeStoreState(long channelId, StoreChannels channelsStore, StoreGuilds guildsStore, StoreUser userStore) {
        Observable<R> observableG = channelsStore.observeChannel(channelId).y(ObservableExtensionsKt$filterNull$1.INSTANCE).G(ObservableExtensionsKt$filterNull$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable<WidgetChannelSettingsAddMemberFragmentViewModel$StoreState> observableY = observableG.r().Y(new WidgetChannelSettingsAddMemberFragmentViewModel$Companion$observeStoreState$1(guildsStore, userStore));
        m.checkNotNullExpressionValue(observableY, "channelsStore.observeCha…          }\n            }");
        return observableY;
    }

    public /* synthetic */ WidgetChannelSettingsAddMemberFragmentViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
