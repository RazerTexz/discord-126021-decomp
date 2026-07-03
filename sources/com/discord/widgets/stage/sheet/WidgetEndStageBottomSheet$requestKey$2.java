package com.discord.widgets.stage.sheet;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetEndStageBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEndStageBottomSheet$requestKey$2 extends AbstractC12240o implements Function0<String> {
    public final /* synthetic */ WidgetEndStageBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEndStageBottomSheet$requestKey$2(WidgetEndStageBottomSheet widgetEndStageBottomSheet) {
        super(0);
        this.this$0 = widgetEndStageBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return this.this$0.requireArguments().getString("INTENT_EXTRA_REQUEST_KEY", "");
    }
}
