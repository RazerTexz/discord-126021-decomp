package com.discord.widgets.servers.member_verification;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: MemberVerificationPendingDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationPendingDialog$configureLoadedUI$9 implements View$OnClickListener {
    public final /* synthetic */ MemberVerificationPendingViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ MemberVerificationPendingDialog this$0;

    public MemberVerificationPendingDialog$configureLoadedUI$9(MemberVerificationPendingDialog memberVerificationPendingDialog, MemberVerificationPendingViewModel$ViewState$Loaded memberVerificationPendingViewModel$ViewState$Loaded) {
        this.this$0 = memberVerificationPendingDialog;
        this.$viewState = memberVerificationPendingViewModel$ViewState$Loaded;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        if (this.$viewState.isPreviewEnabled()) {
            MemberVerificationPendingDialog.access$getViewModel$p(this.this$0).deleteGuildJoinRequest();
        } else {
            MemberVerificationPendingDialog.access$getViewModel$p(this.this$0).leaveGuild();
        }
        this.this$0.dismiss();
    }
}
