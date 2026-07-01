package com.discord.widgets.voice.feedback;

import android.content.Context;
import android.content.Intent;
import b.a.d.j;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetIssueDetailsForm.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetIssueDetailsForm$Companion {
    private WidgetIssueDetailsForm$Companion() {
    }

    public final void launch(Context context, PendingFeedback pendingFeedback, boolean showCxPrompt) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(pendingFeedback, "pendingFeedback");
        Intent intent = new Intent();
        intent.putExtra(WidgetIssueDetailsForm.ARG_PENDING_VOICE_FEEDBACK, pendingFeedback);
        intent.putExtra(WidgetIssueDetailsForm.ARG_SHOW_CX_PROMPT, showCxPrompt);
        j.d(context, WidgetIssueDetailsForm.class, intent);
    }

    public /* synthetic */ WidgetIssueDetailsForm$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
