package com.discord.widgets.channels.threads.browser;

import android.os.Bundle;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserFilterSheet$channelId$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetThreadBrowserFilterSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserFilterSheet3 extends Lambda implements Function0<Long> {
    public final /* synthetic */ WidgetThreadBrowserFilterSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserFilterSheet3(WidgetThreadBrowserFilterSheet widgetThreadBrowserFilterSheet) {
        super(0);
        this.this$0 = widgetThreadBrowserFilterSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        Bundle arguments = this.this$0.getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        return arguments.getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID");
    }
}
