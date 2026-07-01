package com.discord.widgets.voice.controls;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AnchoredVoiceControlsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AnchoredVoiceControlsView$configureUI$3 implements View$OnClickListener {
    public final /* synthetic */ Function0 $onMutePressed;

    public AnchoredVoiceControlsView$configureUI$3(Function0 function0) {
        this.$onMutePressed = function0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onMutePressed.invoke();
    }
}
