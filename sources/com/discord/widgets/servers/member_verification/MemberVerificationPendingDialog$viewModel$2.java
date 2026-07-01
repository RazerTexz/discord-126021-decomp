package com.discord.widgets.servers.member_verification;

import android.os.Bundle;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import d0.z.d.o;
import java.util.Objects;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: MemberVerificationPendingDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationPendingDialog$viewModel$2 extends o implements Function0<MemberVerificationPendingViewModel> {
    public final /* synthetic */ MemberVerificationPendingDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MemberVerificationPendingDialog$viewModel$2(MemberVerificationPendingDialog memberVerificationPendingDialog) {
        super(0);
        this.this$0 = memberVerificationPendingDialog;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ MemberVerificationPendingViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final MemberVerificationPendingViewModel invoke() {
        Bundle arguments = this.this$0.getArguments();
        Long lValueOf = arguments != null ? Long.valueOf(arguments.getLong(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID)) : null;
        Objects.requireNonNull(lValueOf, "null cannot be cast to non-null type com.discord.primitives.GuildId /* = kotlin.Long */");
        long jLongValue = lValueOf.longValue();
        Bundle arguments2 = this.this$0.getArguments();
        return new MemberVerificationPendingViewModel(jLongValue, (MemberVerificationPendingViewModel$DialogState) (arguments2 != null ? arguments2.getSerializable("INTENT_EXTRA_DIALOG_STATE") : null), null, null, 12, null);
    }
}
