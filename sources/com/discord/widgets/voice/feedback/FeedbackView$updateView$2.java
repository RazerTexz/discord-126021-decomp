package com.discord.widgets.voice.feedback;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: FeedbackView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FeedbackView$updateView$2 implements View$OnClickListener {
    public final /* synthetic */ Function0 $onNeutralRatingClick;

    public FeedbackView$updateView$2(Function0 function0) {
        this.$onNeutralRatingClick = function0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onNeutralRatingClick.invoke();
    }
}
