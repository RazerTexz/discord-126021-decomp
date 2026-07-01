package com.discord.widgets.chat.overlay;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import j0.k.b;

/* JADX INFO: compiled from: WidgetChatOverlay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatOverlay$OldMessageModel$Companion$get$1$1<T, R> implements b<Boolean, WidgetChatOverlay$OldMessageModel> {
    public final /* synthetic */ Long $selectedChannelId;

    public WidgetChatOverlay$OldMessageModel$Companion$get$1$1(Long l) {
        this.$selectedChannelId = l;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ WidgetChatOverlay$OldMessageModel call(Boolean bool) {
        return call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatOverlay$OldMessageModel call2(Boolean bool) {
        Long l = this.$selectedChannelId;
        m.checkNotNullExpressionValue(l, "selectedChannelId");
        long jLongValue = l.longValue();
        m.checkNotNullExpressionValue(bool, "isViewingOldMessages");
        return new WidgetChatOverlay$OldMessageModel(jLongValue, bool.booleanValue());
    }
}
