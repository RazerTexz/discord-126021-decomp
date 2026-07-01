package com.discord.widgets.notice;

import com.discord.stores.StoreNotices$Notice;
import com.discord.stores.StoreStream;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetNoticeNuxOverlay.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNoticeNuxOverlay$Companion {
    private WidgetNoticeNuxOverlay$Companion() {
    }

    public final void enqueue() {
        StoreStream.Companion.getNotices().requestToShow(new StoreNotices$Notice("NUX/Overlay", null, 0L, 0, true, null, 0L, false, 0L, WidgetNoticeNuxOverlay$Companion$enqueue$notice$1.INSTANCE, 486, null));
    }

    public /* synthetic */ WidgetNoticeNuxOverlay$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
