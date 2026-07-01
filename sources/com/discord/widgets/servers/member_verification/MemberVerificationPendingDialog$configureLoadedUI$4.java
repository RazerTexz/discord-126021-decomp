package com.discord.widgets.servers.member_verification;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: MemberVerificationPendingDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationPendingDialog$configureLoadedUI$4 implements View$OnClickListener {
    public final /* synthetic */ MemberVerificationPendingDialog this$0;

    public MemberVerificationPendingDialog$configureLoadedUI$4(MemberVerificationPendingDialog memberVerificationPendingDialog) {
        this.this$0 = memberVerificationPendingDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        MemberVerificationPendingDialog.access$getViewModel$p(this.this$0).resetGuildJoinRequest();
        this.this$0.dismiss();
    }
}
