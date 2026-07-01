package com.discord.widgets.channels.threads.browser;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserFilterSheet$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetThreadBrowserFilterSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserFilterSheet5 extends Lambda implements Function0<WidgetThreadBrowserArchivedViewModel> {
    public final /* synthetic */ WidgetThreadBrowserFilterSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserFilterSheet5(WidgetThreadBrowserFilterSheet widgetThreadBrowserFilterSheet) {
        super(0);
        this.this$0 = widgetThreadBrowserFilterSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetThreadBrowserArchivedViewModel invoke() {
        return new WidgetThreadBrowserArchivedViewModel(this.this$0.getGuildId(), this.this$0.getChannelId(), null, null, null, null, null, null, 252, null);
    }
}
