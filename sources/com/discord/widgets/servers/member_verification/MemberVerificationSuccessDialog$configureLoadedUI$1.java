package com.discord.widgets.servers.member_verification;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.channel.ChannelSelector;

/* JADX INFO: compiled from: MemberVerificationSuccessDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationSuccessDialog$configureLoadedUI$1 implements View$OnClickListener {
    public final /* synthetic */ MemberVerificationSuccessDialog this$0;

    public MemberVerificationSuccessDialog$configureLoadedUI$1(MemberVerificationSuccessDialog memberVerificationSuccessDialog) {
        this.this$0 = memberVerificationSuccessDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ChannelSelector.selectChannel$default(ChannelSelector.Companion.getInstance(), MemberVerificationSuccessDialog.access$getViewModel$p(this.this$0).getGuildId(), 0L, null, null, 12, null);
        MemberVerificationSuccessDialog.access$getViewModel$p(this.this$0).ackGuildJoinRequest();
    }
}
