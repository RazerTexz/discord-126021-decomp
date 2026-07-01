package com.discord.widgets.guilds.contextmenu;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildContextMenu.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildContextMenu$doCircularRemove$1 extends AnimatorListenerAdapter {
    public final /* synthetic */ WidgetGuildContextMenu this$0;

    public WidgetGuildContextMenu$doCircularRemove$1(WidgetGuildContextMenu widgetGuildContextMenu) {
        this.this$0 = widgetGuildContextMenu;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animation) {
        super.onAnimationEnd(animation);
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            WidgetGuildContextMenu$Companion widgetGuildContextMenu$Companion = WidgetGuildContextMenu.Companion;
            m.checkNotNullExpressionValue(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            widgetGuildContextMenu$Companion.hide(activity, false);
        }
    }
}
