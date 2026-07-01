package com.discord.widgets.guilds.contextmenu;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: compiled from: WidgetFolderContextMenu.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFolderContextMenu$doCircularReveal$1 extends AnimatorListenerAdapter {
    public final /* synthetic */ WidgetFolderContextMenu this$0;

    public WidgetFolderContextMenu$doCircularReveal$1(WidgetFolderContextMenu widgetFolderContextMenu) {
        this.this$0 = widgetFolderContextMenu;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animation) {
        super.onAnimationEnd(animation);
        WidgetFolderContextMenu.access$setAnimationState$p(this.this$0, null);
    }
}
