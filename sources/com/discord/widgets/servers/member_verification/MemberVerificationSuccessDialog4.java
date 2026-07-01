package com.discord.widgets.servers.member_verification;

import com.discord.widgets.servers.WidgetServerSettingsChannels;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationSuccessDialog$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: MemberVerificationSuccessDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationSuccessDialog4 extends Lambda implements Function0<MemberVerificationSuccessViewModel> {
    public final /* synthetic */ MemberVerificationSuccessDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberVerificationSuccessDialog4(MemberVerificationSuccessDialog memberVerificationSuccessDialog) {
        super(0);
        this.this$0 = memberVerificationSuccessDialog;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final MemberVerificationSuccessViewModel invoke() {
        return new MemberVerificationSuccessViewModel(this.this$0.getArgumentsOrDefault().getLong(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID), null, null, 6, null);
    }
}
