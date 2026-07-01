package com.discord.widgets.voice.controls;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AnchoredVoiceControlsView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AnchoredVoiceControlsView$configureUI$2 implements View$OnClickListener {
    public final /* synthetic */ Function0 $onSpeakerButtonPressed;

    public AnchoredVoiceControlsView$configureUI$2(Function0 function0) {
        this.$onSpeakerButtonPressed = function0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onSpeakerButtonPressed.invoke();
    }
}
