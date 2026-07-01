package com.discord.widgets.voice.sheet;

import com.discord.stores.StoreChannels;
import com.discord.stores.StorePermissions;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetVoiceBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceBottomSheetViewModel$Companion {
    private WidgetVoiceBottomSheetViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStoreState(WidgetVoiceBottomSheetViewModel$Companion widgetVoiceBottomSheetViewModel$Companion, long j, StorePermissions storePermissions, StoreChannels storeChannels) {
        return widgetVoiceBottomSheetViewModel$Companion.observeStoreState(j, storePermissions, storeChannels);
    }

    private final Observable<WidgetVoiceBottomSheetViewModel$StoreState> observeStoreState(long channelId, StorePermissions permissionsStore, StoreChannels channelsStore) {
        Observable observableY = channelsStore.observeChannel(channelId).Y(new WidgetVoiceBottomSheetViewModel$Companion$observeStoreState$1(channelId, permissionsStore));
        m.checkNotNullExpressionValue(observableY, "channelsStore.observeCha…      }\n        }\n      }");
        return observableY;
    }

    public /* synthetic */ WidgetVoiceBottomSheetViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
