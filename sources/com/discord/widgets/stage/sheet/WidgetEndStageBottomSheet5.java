package com.discord.widgets.stage.sheet;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetEndStageBottomSheet$requestKey$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetEndStageBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEndStageBottomSheet5 extends Lambda implements Function0<String> {
    public final /* synthetic */ WidgetEndStageBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEndStageBottomSheet5(WidgetEndStageBottomSheet widgetEndStageBottomSheet) {
        super(0);
        this.this$0 = widgetEndStageBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return this.this$0.requireArguments().getString("INTENT_EXTRA_REQUEST_KEY", "");
    }
}
