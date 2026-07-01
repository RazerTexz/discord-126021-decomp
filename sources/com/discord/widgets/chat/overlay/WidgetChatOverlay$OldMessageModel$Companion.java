package com.discord.widgets.chat.overlay;

import com.discord.stores.StoreStream;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChatOverlay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatOverlay$OldMessageModel$Companion {
    private WidgetChatOverlay$OldMessageModel$Companion() {
    }

    public final Observable<WidgetChatOverlay$OldMessageModel> get() {
        Observable observableY = StoreStream.Companion.getChannelsSelected().observeId().r().Y(WidgetChatOverlay$OldMessageModel$Companion$get$1.INSTANCE);
        m.checkNotNullExpressionValue(observableY, "StoreStream\n            …          }\n            }");
        return observableY;
    }

    public /* synthetic */ WidgetChatOverlay$OldMessageModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
