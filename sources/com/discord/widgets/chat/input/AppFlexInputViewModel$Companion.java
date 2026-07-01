package com.discord.widgets.chat.input;

import com.discord.stores.StoreStream;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: AppFlexInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppFlexInputViewModel$Companion {
    private AppFlexInputViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeStores(AppFlexInputViewModel$Companion appFlexInputViewModel$Companion) {
        return appFlexInputViewModel$Companion.observeStores();
    }

    private final Observable<AppFlexInputViewModel$StoreState> observeStores() {
        Observable observableY = StoreStream.Companion.getChannelsSelected().observeResolvedSelectedChannel().Y(AppFlexInputViewModel$Companion$observeStores$1.INSTANCE);
        m.checkNotNullExpressionValue(observableY, "StoreStream\n          .g…            }\n          }");
        return observableY;
    }

    public /* synthetic */ AppFlexInputViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
