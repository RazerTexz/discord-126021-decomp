package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreChat$InteractionState;
import d0.z.d.m;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetChatOverlay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatOverlay$OldMessageModel$Companion$get$1$isViewingOldMessagesObs$2<T1, T2, R> implements Func2<Boolean, StoreChat$InteractionState, Boolean> {
    public static final WidgetChatOverlay$OldMessageModel$Companion$get$1$isViewingOldMessagesObs$2 INSTANCE = new WidgetChatOverlay$OldMessageModel$Companion$get$1$isViewingOldMessagesObs$2();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ Boolean call(Boolean bool, StoreChat$InteractionState storeChat$InteractionState) {
        return call2(bool, storeChat$InteractionState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Boolean call2(Boolean bool, StoreChat$InteractionState storeChat$InteractionState) {
        m.checkNotNullExpressionValue(bool, "isDetached");
        return Boolean.valueOf(bool.booleanValue() || !(storeChat$InteractionState.isAtBottomIgnoringTouch() || storeChat$InteractionState.isNearBottomIgnoringTouch()));
    }
}
