package com.discord.widgets.voice.feedback;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: FeedbackView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FeedbackView$updateView$3 implements View$OnClickListener {
    public final /* synthetic */ Function0 $onHappyRatingClick;

    public FeedbackView$updateView$3(Function0 function0) {
        this.$onHappyRatingClick = function0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onHappyRatingClick.invoke();
    }
}
