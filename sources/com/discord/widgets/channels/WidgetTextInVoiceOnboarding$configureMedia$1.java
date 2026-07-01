package com.discord.widgets.channels;

import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup$LayoutParams;

/* JADX INFO: compiled from: WidgetTextInVoiceOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetTextInVoiceOnboarding$configureMedia$1 implements Runnable {
    public final /* synthetic */ WidgetTextInVoiceOnboarding this$0;

    public WidgetTextInVoiceOnboarding$configureMedia$1(WidgetTextInVoiceOnboarding widgetTextInVoiceOnboarding) {
        this.this$0 = widgetTextInVoiceOnboarding;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View view = this.this$0.getView();
        Integer numValueOf = view != null ? Integer.valueOf(view.getMeasuredHeight()) : null;
        Dialog dialog = this.this$0.getDialog();
        View viewFindViewById = dialog != null ? dialog.findViewById(2131363003) : null;
        ViewGroup$LayoutParams layoutParams = viewFindViewById != null ? viewFindViewById.getLayoutParams() : null;
        if (numValueOf == null || numValueOf.intValue() <= 0) {
            return;
        }
        if (layoutParams != null) {
            layoutParams.height = numValueOf.intValue() + 1;
        }
        if (viewFindViewById != null) {
            viewFindViewById.setLayoutParams(layoutParams);
        }
    }
}
