package com.discord.widgets.guilds.contextmenu;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetFolderContextMenu.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFolderContextMenu$doCircularRemove$1 extends AnimatorListenerAdapter {
    public final /* synthetic */ WidgetFolderContextMenu this$0;

    public WidgetFolderContextMenu$doCircularRemove$1(WidgetFolderContextMenu widgetFolderContextMenu) {
        this.this$0 = widgetFolderContextMenu;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator$AnimatorListener
    public void onAnimationEnd(Animator animation) {
        super.onAnimationEnd(animation);
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            WidgetFolderContextMenu$Companion widgetFolderContextMenu$Companion = WidgetFolderContextMenu.Companion;
            m.checkNotNullExpressionValue(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            widgetFolderContextMenu$Companion.hide(activity, false);
        }
    }
}
