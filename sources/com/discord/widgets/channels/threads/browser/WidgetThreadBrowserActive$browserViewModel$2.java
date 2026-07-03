package com.discord.widgets.channels.threads.browser;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetThreadBrowserActive.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserActive$browserViewModel$2 extends AbstractC12240o implements Function0<WidgetThreadBrowserViewModel> {
    public final /* synthetic */ WidgetThreadBrowserActive this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserActive$browserViewModel$2(WidgetThreadBrowserActive widgetThreadBrowserActive) {
        super(0);
        this.this$0 = widgetThreadBrowserActive;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetThreadBrowserViewModel invoke() {
        return new WidgetThreadBrowserViewModel(this.this$0.getGuildId(), this.this$0.getChannelId(), null, null, null, null, 60, null);
    }
}
