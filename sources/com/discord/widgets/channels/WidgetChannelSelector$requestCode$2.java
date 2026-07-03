package com.discord.widgets.channels;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetChannelSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSelector$requestCode$2 extends AbstractC12240o implements Function0<String> {
    public final /* synthetic */ WidgetChannelSelector this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSelector$requestCode$2(WidgetChannelSelector widgetChannelSelector) {
        super(0);
        this.this$0 = widgetChannelSelector;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return this.this$0.getArgumentsOrDefault().getString("INTENT_EXTRA_REQUEST_CODE", "");
    }
}
