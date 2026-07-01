package com.discord.widgets.stage.sheet;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;

/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheetAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheetAdapter$ViewHolderParticipant$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ StoreVoiceParticipants$VoiceUser $participant;
    public final /* synthetic */ WidgetStageRaisedHandsBottomSheetAdapter$ViewHolderParticipant this$0;

    public WidgetStageRaisedHandsBottomSheetAdapter$ViewHolderParticipant$onConfigure$1(WidgetStageRaisedHandsBottomSheetAdapter$ViewHolderParticipant widgetStageRaisedHandsBottomSheetAdapter$ViewHolderParticipant, StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser) {
        this.this$0 = widgetStageRaisedHandsBottomSheetAdapter$ViewHolderParticipant;
        this.$participant = storeVoiceParticipants$VoiceUser;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetStageRaisedHandsBottomSheetAdapter$ViewHolderParticipant.access$getAdapter$p(this.this$0).getOnViewProfile().invoke(this.$participant);
    }
}
