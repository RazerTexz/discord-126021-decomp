package com.discord.widgets.voice.controls;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.stage.StageRoles;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: VoiceControlsSheetView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VoiceControlsSheetView$configureUI$$inlined$apply$lambda$2 implements View$OnClickListener {
    public final /* synthetic */ Function0 $onDisconnectClick$inlined;
    public final /* synthetic */ boolean $showDisconnect$inlined;
    public final /* synthetic */ StageRoles $stageRoles$inlined;

    public VoiceControlsSheetView$configureUI$$inlined$apply$lambda$2(StageRoles stageRoles, boolean z2, Function0 function0) {
        this.$stageRoles$inlined = stageRoles;
        this.$showDisconnect$inlined = z2;
        this.$onDisconnectClick$inlined = function0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onDisconnectClick$inlined.invoke();
    }
}
