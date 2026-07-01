package com.discord.widgets.guilds.contextmenu;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: compiled from: WidgetGuildContextMenu.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildContextMenu$doCircularReveal$1 extends AnimatorListenerAdapter {
    public final /* synthetic */ WidgetGuildContextMenu this$0;

    public WidgetGuildContextMenu$doCircularReveal$1(WidgetGuildContextMenu widgetGuildContextMenu) {
        this.this$0 = widgetGuildContextMenu;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animation) {
        super.onAnimationEnd(animation);
        WidgetGuildContextMenu.access$setAnimationState$p(this.this$0, null);
    }
}
