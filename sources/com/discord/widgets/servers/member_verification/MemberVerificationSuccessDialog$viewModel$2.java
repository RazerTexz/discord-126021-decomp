package com.discord.widgets.servers.member_verification;

import com.discord.widgets.servers.WidgetServerSettingsChannels;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: MemberVerificationSuccessDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationSuccessDialog$viewModel$2 extends o implements Function0<MemberVerificationSuccessViewModel> {
    public final /* synthetic */ MemberVerificationSuccessDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberVerificationSuccessDialog$viewModel$2(MemberVerificationSuccessDialog memberVerificationSuccessDialog) {
        super(0);
        this.this$0 = memberVerificationSuccessDialog;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ MemberVerificationSuccessViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final MemberVerificationSuccessViewModel invoke() {
        return new MemberVerificationSuccessViewModel(MemberVerificationSuccessDialog.access$getArgumentsOrDefault$p(this.this$0).getLong(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID), null, null, 6, null);
    }
}
