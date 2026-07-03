package com.discord.widgets.feedback;

import com.discord.widgets.voice.feedback.call.CallFeedbackSheetViewModel;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetFeedbackSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFeedbackSheet$viewModelCallFeedbackSheet$2 extends AbstractC12240o implements Function0<CallFeedbackSheetViewModel> {
    public final /* synthetic */ WidgetFeedbackSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFeedbackSheet$viewModelCallFeedbackSheet$2(WidgetFeedbackSheet widgetFeedbackSheet) {
        super(0);
        this.this$0 = widgetFeedbackSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final CallFeedbackSheetViewModel invoke() {
        CallFeedbackSheetViewModel.Config config = (CallFeedbackSheetViewModel.Config) this.this$0.getArgumentsOrDefault().getParcelable(WidgetFeedbackSheet.ARG_CALL_FEEDBACK_CONFIG);
        C12238m.checkNotNull(config);
        return new CallFeedbackSheetViewModel(config, null, null, null, 14, null);
    }
}
