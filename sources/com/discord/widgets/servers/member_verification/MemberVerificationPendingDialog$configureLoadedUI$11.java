package com.discord.widgets.servers.member_verification;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.uri.UriHandler;
import d0.z.d.m;

/* JADX INFO: compiled from: MemberVerificationPendingDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationPendingDialog$configureLoadedUI$11 implements View$OnClickListener {
    public final /* synthetic */ MemberVerificationPendingDialog this$0;

    public MemberVerificationPendingDialog$configureLoadedUI$11(MemberVerificationPendingDialog memberVerificationPendingDialog) {
        this.this$0 = memberVerificationPendingDialog;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Context contextRequireContext = this.this$0.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        UriHandler.directToPlayStore$default(contextRequireContext, null, null, 6, null);
    }
}
