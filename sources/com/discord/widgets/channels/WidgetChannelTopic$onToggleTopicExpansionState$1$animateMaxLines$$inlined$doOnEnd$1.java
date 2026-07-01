package com.discord.widgets.channels;

import android.animation.Animator;
import android.animation.Animator$AnimatorListener;
import d0.z.d.m;

/* JADX INFO: compiled from: Animator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelTopic$onToggleTopicExpansionState$1$animateMaxLines$$inlined$doOnEnd$1 implements Animator$AnimatorListener {
    public final /* synthetic */ WidgetChannelTopic$onToggleTopicExpansionState$1 this$0;

    public WidgetChannelTopic$onToggleTopicExpansionState$1$animateMaxLines$$inlined$doOnEnd$1(WidgetChannelTopic$onToggleTopicExpansionState$1 widgetChannelTopic$onToggleTopicExpansionState$1) {
        this.this$0 = widgetChannelTopic$onToggleTopicExpansionState$1;
    }

    @Override // android.animation.Animator$AnimatorListener
    public void onAnimationCancel(Animator animator) {
        m.checkNotNullParameter(animator, "animator");
    }

    @Override // android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animator) {
        m.checkNotNullParameter(animator, "animator");
        WidgetChannelTopic.access$configureEllipsis(this.this$0.this$0);
    }

    @Override // android.animation.Animator$AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        m.checkNotNullParameter(animator, "animator");
    }

    @Override // android.animation.Animator$AnimatorListener
    public void onAnimationStart(Animator animator) {
        m.checkNotNullParameter(animator, "animator");
    }
}
