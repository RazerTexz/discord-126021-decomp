package com.discord.widgets.botuikit;

import android.widget.LinearLayout;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;

/* JADX INFO: compiled from: ModalComponent.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ModalComponent$onViewBound$2$3$1 implements Runnable {
    public final /* synthetic */ ModalComponent$onViewBound$2$3 this$0;

    public ModalComponent$onViewBound$2$3$1(ModalComponent$onViewBound$2$3 modalComponent$onViewBound$2$3) {
        this.this$0 = modalComponent$onViewBound$2$3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ModalComponent.access$setSentNonce$p(this.this$0.this$0.this$0, null);
        LinearLayout linearLayout = ModalComponent.access$getBinding$p(this.this$0.this$0.this$0).d;
        m.checkNotNullExpressionValue(linearLayout, "binding.error");
        linearLayout.setVisibility(0);
        MaterialButton materialButton = ModalComponent.access$getBinding$p(this.this$0.this$0.this$0).f;
        m.checkNotNullExpressionValue(materialButton, "binding.submit");
        materialButton.setEnabled(true);
    }
}
