package com.discord.widgets.voice.controls;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: VoiceControlsSheetView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VoiceControlsSheetView$configureOutputSelectors$2 implements View$OnClickListener {
    public final /* synthetic */ Function0 $onAudioOutputClick;

    public VoiceControlsSheetView$configureOutputSelectors$2(Function0 function0) {
        this.$onAudioOutputClick = function0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onAudioOutputClick.invoke();
    }
}
