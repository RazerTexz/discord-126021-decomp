package com.discord.widgets.chat;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetUrlActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetUrlActions$url$2 extends AbstractC12240o implements Function0<String> {
    public final /* synthetic */ WidgetUrlActions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUrlActions$url$2(WidgetUrlActions widgetUrlActions) {
        super(0);
        this.this$0 = widgetUrlActions;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return this.this$0.getArgumentsOrDefault().getString("INTENT_URL", "");
    }
}
