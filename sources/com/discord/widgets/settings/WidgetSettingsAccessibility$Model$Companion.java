package com.discord.widgets.settings;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetSettingsAccessibility.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccessibility$Model$Companion {
    private WidgetSettingsAccessibility$Model$Companion() {
    }

    public final Observable<WidgetSettingsAccessibility$Model> get() {
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<WidgetSettingsAccessibility$Model> observableH = Observable.h(storeStream$Companion.getAccessibility().observeReducedMotionEnabled(), storeStream$Companion.getUserSettings().observeIsAnimatedEmojisEnabled(false), storeStream$Companion.getUserSettings().observeIsAutoPlayGifsEnabled(false), storeStream$Companion.getUserSettings().observeStickerAnimationSettings(false), WidgetSettingsAccessibility$Model$Companion$get$1.INSTANCE);
        m.checkNotNullExpressionValue(observableH, "Observable.combineLatest…ngs\n          )\n        }");
        return observableH;
    }

    public /* synthetic */ WidgetSettingsAccessibility$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
