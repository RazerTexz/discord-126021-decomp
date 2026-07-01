package com.discord.widgets.botuikit;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: compiled from: ModalComponent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ModalComponent$onViewBound$1 implements View$OnClickListener {
    public final /* synthetic */ ModalComponent this$0;

    public ModalComponent$onViewBound$1(ModalComponent modalComponent) {
        this.this$0 = modalComponent;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
