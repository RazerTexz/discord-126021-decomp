package com.discord.widgets.voice.controls;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: VoiceControlsSheetView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VoiceControlsSheetView$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ Function0 $onStopWatchingClick;

    public VoiceControlsSheetView$configureUI$1(Function0 function0) {
        this.$onStopWatchingClick = function0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onStopWatchingClick.invoke();
    }
}
