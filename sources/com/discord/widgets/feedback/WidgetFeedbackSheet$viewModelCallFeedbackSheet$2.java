package com.discord.widgets.feedback;

import com.discord.widgets.voice.feedback.call.CallFeedbackSheetViewModel;
import com.discord.widgets.voice.feedback.call.CallFeedbackSheetViewModel$Config;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetFeedbackSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFeedbackSheet$viewModelCallFeedbackSheet$2 extends o implements Function0<CallFeedbackSheetViewModel> {
    public final /* synthetic */ WidgetFeedbackSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFeedbackSheet$viewModelCallFeedbackSheet$2(WidgetFeedbackSheet widgetFeedbackSheet) {
        super(0);
        this.this$0 = widgetFeedbackSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ CallFeedbackSheetViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final CallFeedbackSheetViewModel invoke() {
        CallFeedbackSheetViewModel$Config callFeedbackSheetViewModel$Config = (CallFeedbackSheetViewModel$Config) WidgetFeedbackSheet.access$getArgumentsOrDefault$p(this.this$0).getParcelable(WidgetFeedbackSheet.ARG_CALL_FEEDBACK_CONFIG);
        m.checkNotNull(callFeedbackSheetViewModel$Config);
        return new CallFeedbackSheetViewModel(callFeedbackSheetViewModel$Config, null, null, null, 14, null);
    }
}
