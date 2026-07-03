package com.discord.widgets.feedback;

import com.discord.widgets.voice.feedback.stream.StreamFeedbackSheetViewModel;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetFeedbackSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFeedbackSheet$viewModelStreamFeedbackSheet$2 extends AbstractC12240o implements Function0<StreamFeedbackSheetViewModel> {
    public final /* synthetic */ WidgetFeedbackSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFeedbackSheet$viewModelStreamFeedbackSheet$2(WidgetFeedbackSheet widgetFeedbackSheet) {
        super(0);
        this.this$0 = widgetFeedbackSheet;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final StreamFeedbackSheetViewModel invoke() {
        String string = this.this$0.getArgumentsOrDefault().getString(WidgetFeedbackSheet.ARG_STREAM_FEEDBACK_STREAM_KEY);
        if (string == null) {
            string = "";
        }
        String str = string;
        C12238m.checkNotNullExpressionValue(str, "argumentsOrDefault.getSt…EEDBACK_STREAM_KEY) ?: \"\"");
        return new StreamFeedbackSheetViewModel(str, this.this$0.getArgumentsOrDefault().getString(WidgetFeedbackSheet.ARG_STREAM_FEEDBACK_MEDIA_SESSION_ID), null, null, null, 28, null);
    }
}
