package com.discord.widgets.voice.controls;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.widgets.stage.StageRoles;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: VoiceControlsSheetView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VoiceControlsSheetView$configureMoveToAudienceButton$$inlined$apply$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ Function0 $onMoveToAudienceClick$inlined;
    public final /* synthetic */ StageRoles $stageRoles$inlined;
    public final /* synthetic */ VoiceControlsSheetView this$0;

    public VoiceControlsSheetView$configureMoveToAudienceButton$$inlined$apply$lambda$1(VoiceControlsSheetView voiceControlsSheetView, StageRoles stageRoles, Function0 function0) {
        this.this$0 = voiceControlsSheetView;
        this.$stageRoles$inlined = stageRoles;
        this.$onMoveToAudienceClick$inlined = function0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$onMoveToAudienceClick$inlined.invoke();
    }
}
