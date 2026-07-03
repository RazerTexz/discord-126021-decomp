package com.discord.widgets.channels.threads.browser;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetThreadBrowser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowser$viewModel$2 extends AbstractC12240o implements Function0<WidgetThreadBrowserViewModel> {
    public final /* synthetic */ WidgetThreadBrowser this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowser$viewModel$2(WidgetThreadBrowser widgetThreadBrowser) {
        super(0);
        this.this$0 = widgetThreadBrowser;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetThreadBrowserViewModel invoke() {
        return new WidgetThreadBrowserViewModel(this.this$0.getGuildId(), this.this$0.getChannelId(), null, null, null, null, 60, null);
    }
}
