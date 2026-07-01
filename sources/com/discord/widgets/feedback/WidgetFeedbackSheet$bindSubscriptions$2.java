package com.discord.widgets.feedback;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetFeedbackSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetFeedbackSheet$bindSubscriptions$2 extends k implements Function1<FeedbackSheetViewModel$Event, Unit> {
    public WidgetFeedbackSheet$bindSubscriptions$2(WidgetFeedbackSheet widgetFeedbackSheet) {
        super(1, widgetFeedbackSheet, WidgetFeedbackSheet.class, "handleEvent", "handleEvent(Lcom/discord/widgets/feedback/FeedbackSheetViewModel$Event;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FeedbackSheetViewModel$Event feedbackSheetViewModel$Event) {
        invoke2(feedbackSheetViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FeedbackSheetViewModel$Event feedbackSheetViewModel$Event) {
        m.checkNotNullParameter(feedbackSheetViewModel$Event, "p1");
        WidgetFeedbackSheet.access$handleEvent((WidgetFeedbackSheet) this.receiver, feedbackSheetViewModel$Event);
    }
}
