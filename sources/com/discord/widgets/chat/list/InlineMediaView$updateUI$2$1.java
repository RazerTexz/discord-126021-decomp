package com.discord.widgets.chat.list;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: InlineMediaView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InlineMediaView$updateUI$2$1 implements View$OnClickListener {
    public final /* synthetic */ boolean $isVolumeOn;
    public final /* synthetic */ InlineMediaView$updateUI$2 this$0;

    public InlineMediaView$updateUI$2$1(InlineMediaView$updateUI$2 inlineMediaView$updateUI$2, boolean z2) {
        this.this$0 = inlineMediaView$updateUI$2;
        this.$isVolumeOn = z2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.$player.d(this.$isVolumeOn ? 0.0f : 1.0f);
    }
}
