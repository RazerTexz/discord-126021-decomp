package com.discord.widgets.feedback;

import com.discord.widgets.voice.feedback.call.CallFeedbackSheetViewModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.feedback.WidgetFeedbackSheet$viewModelCallFeedbackSheet$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetFeedbackSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFeedbackSheet4 extends Lambda implements Function0<CallFeedbackSheetViewModel> {
    public final /* synthetic */ WidgetFeedbackSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFeedbackSheet4(WidgetFeedbackSheet widgetFeedbackSheet) {
        super(0);
        this.this$0 = widgetFeedbackSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final CallFeedbackSheetViewModel invoke() {
        CallFeedbackSheetViewModel.Config config = (CallFeedbackSheetViewModel.Config) this.this$0.getArgumentsOrDefault().getParcelable(WidgetFeedbackSheet.ARG_CALL_FEEDBACK_CONFIG);
        Intrinsics3.checkNotNull(config);
        return new CallFeedbackSheetViewModel(config, null, null, null, 14, null);
    }
}
