package com.discord.widgets.voice.sheet;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;

/* JADX INFO: compiled from: CallParticipantsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CallParticipantsAdapter$ViewHolderUser$onConfigure$3 implements View$OnClickListener {
    public final /* synthetic */ StoreVoiceParticipants$VoiceUser $voiceUser;
    public final /* synthetic */ CallParticipantsAdapter$ViewHolderUser this$0;

    public CallParticipantsAdapter$ViewHolderUser$onConfigure$3(CallParticipantsAdapter$ViewHolderUser callParticipantsAdapter$ViewHolderUser, StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser) {
        this.this$0 = callParticipantsAdapter$ViewHolderUser;
        this.$voiceUser = storeVoiceParticipants$VoiceUser;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        CallParticipantsAdapter$ViewHolderUser.access$getAdapter$p(this.this$0).getOnToggleRingingClicked().invoke(this.$voiceUser);
    }
}
