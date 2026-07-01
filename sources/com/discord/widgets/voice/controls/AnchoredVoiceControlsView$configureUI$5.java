package com.discord.widgets.voice.controls;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AnchoredVoiceControlsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AnchoredVoiceControlsView$configureUI$5 implements View$OnClickListener {
    public final /* synthetic */ Function0 $onDisconnectPressed;

    public AnchoredVoiceControlsView$configureUI$5(Function0 function0) {
        this.$onDisconnectPressed = function0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onDisconnectPressed.invoke();
    }
}
