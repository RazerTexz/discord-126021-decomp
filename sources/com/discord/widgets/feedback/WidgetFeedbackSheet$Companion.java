package com.discord.widgets.feedback;

import android.os.Bundle;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetFeedbackSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFeedbackSheet$Companion {
    private WidgetFeedbackSheet$Companion() {
    }

    public final WidgetFeedbackSheet newInstance(WidgetFeedbackSheet$FeedbackType feedbackType) {
        m.checkNotNullParameter(feedbackType, "feedbackType");
        WidgetFeedbackSheet widgetFeedbackSheet = new WidgetFeedbackSheet();
        Bundle bundle = new Bundle();
        bundle.putSerializable(WidgetFeedbackSheet.ARG_FEEDBACK_TYPE, feedbackType);
        widgetFeedbackSheet.setArguments(bundle);
        return widgetFeedbackSheet;
    }

    public /* synthetic */ WidgetFeedbackSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
