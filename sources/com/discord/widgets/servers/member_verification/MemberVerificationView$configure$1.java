package com.discord.widgets.servers.member_verification;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: MemberVerificationView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationView$configure$1 implements View$OnClickListener {
    public final /* synthetic */ Function0 $verificationCallback;

    public MemberVerificationView$configure$1(Function0 function0) {
        this.$verificationCallback = function0;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Function0 function0 = this.$verificationCallback;
        if (function0 != null) {
        }
    }
}
