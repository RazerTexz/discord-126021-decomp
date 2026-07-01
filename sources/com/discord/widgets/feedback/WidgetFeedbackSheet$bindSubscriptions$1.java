package com.discord.widgets.feedback;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetFeedbackSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetFeedbackSheet$bindSubscriptions$1 extends k implements Function1<FeedbackSheetViewModel$ViewState, Unit> {
    public WidgetFeedbackSheet$bindSubscriptions$1(WidgetFeedbackSheet widgetFeedbackSheet) {
        super(1, widgetFeedbackSheet, WidgetFeedbackSheet.class, "updateView", "updateView(Lcom/discord/widgets/feedback/FeedbackSheetViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FeedbackSheetViewModel$ViewState feedbackSheetViewModel$ViewState) {
        invoke2(feedbackSheetViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FeedbackSheetViewModel$ViewState feedbackSheetViewModel$ViewState) {
        m.checkNotNullParameter(feedbackSheetViewModel$ViewState, "p1");
        WidgetFeedbackSheet.access$updateView((WidgetFeedbackSheet) this.receiver, feedbackSheetViewModel$ViewState);
    }
}
