package com.discord.widgets.notice;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.View$OnTouchListener;
import d0.z.d.m;

/* JADX INFO: compiled from: NoticePopup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NoticePopup$enqueue$notice$1$3$1 implements View$OnTouchListener {
    public final /* synthetic */ ValueAnimator $viewAutoDismissAnimator;

    public NoticePopup$enqueue$notice$1$3$1(ValueAnimator valueAnimator) {
        this.$viewAutoDismissAnimator = valueAnimator;
    }

    @Override // android.view.View$OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        m.checkNotNullExpressionValue(motionEvent, "event");
        if (motionEvent.getAction() != 0) {
            return false;
        }
        NoticePopup.access$cancelCountdown(NoticePopup.INSTANCE, this.$viewAutoDismissAnimator);
        return false;
    }
}
