package com.discord.widgets.voice.controls;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AnchoredVoiceControlsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AnchoredVoiceControlsView$configureUI$4 implements View$OnClickListener {
    public final /* synthetic */ Function0 $onScreenSharePressed;

    public AnchoredVoiceControlsView$configureUI$4(Function0 function0) {
        this.$onScreenSharePressed = function0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onScreenSharePressed.invoke();
    }
}
