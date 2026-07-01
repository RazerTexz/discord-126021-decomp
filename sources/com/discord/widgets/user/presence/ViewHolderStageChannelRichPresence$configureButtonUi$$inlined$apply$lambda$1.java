package com.discord.widgets.user.presence;

import android.view.View;
import android.view.View$OnClickListener;
import android.widget.Button;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.utilities.presence.StageCallRichPresencePartyData;
import com.discord.utilities.views.ViewCoroutineScopeKt;
import com.discord.widgets.stage.StageChannelJoinHelper;

/* JADX INFO: compiled from: ViewHolderStageChannelRichPresence.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewHolderStageChannelRichPresence$configureButtonUi$$inlined$apply$lambda$1 implements View$OnClickListener {
    public final /* synthetic */ FragmentManager $fragmentManager$inlined;
    public final /* synthetic */ boolean $isMe$inlined;
    public final /* synthetic */ StageCallRichPresencePartyData $partyDerivedData$inlined;
    public final /* synthetic */ Button $this_apply;
    public final /* synthetic */ boolean $userInSameVoiceChannel$inlined;

    public ViewHolderStageChannelRichPresence$configureButtonUi$$inlined$apply$lambda$1(Button button, boolean z2, boolean z3, FragmentManager fragmentManager, StageCallRichPresencePartyData stageCallRichPresencePartyData) {
        this.$this_apply = button;
        this.$isMe$inlined = z2;
        this.$userInSameVoiceChannel$inlined = z3;
        this.$fragmentManager$inlined = fragmentManager;
        this.$partyDerivedData$inlined = stageCallRichPresencePartyData;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        StageChannelJoinHelper.lurkAndJoinStage$default(StageChannelJoinHelper.INSTANCE, a.x(view, "it", "it.context"), this.$fragmentManager$inlined, ViewCoroutineScopeKt.getCoroutineScope(this.$this_apply), this.$partyDerivedData$inlined.getGuildId(), this.$partyDerivedData$inlined.getChannelId(), true, null, null, null, 448, null);
    }
}
