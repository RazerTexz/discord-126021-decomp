package com.discord.widgets.servers.member_verification;

import com.discord.widgets.servers.WidgetServerSettingsChannels;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetMemberVerification.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMemberVerification$viewModel$2 extends o implements Function0<WidgetMemberVerificationViewModel> {
    public final /* synthetic */ WidgetMemberVerification this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetMemberVerification$viewModel$2(WidgetMemberVerification widgetMemberVerification) {
        super(0);
        this.this$0 = widgetMemberVerification;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetMemberVerificationViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetMemberVerificationViewModel invoke() {
        long longExtra = this.this$0.getMostRecentIntent().getLongExtra(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, -1L);
        String stringExtra = this.this$0.getMostRecentIntent().getStringExtra("INTENT_EXTRA_LOCATION");
        if (stringExtra == null) {
            stringExtra = "";
        }
        String str = stringExtra;
        m.checkNotNullExpressionValue(str, "mostRecentIntent.getStri…ENT_EXTRA_LOCATION) ?: \"\"");
        return new WidgetMemberVerificationViewModel(longExtra, str, WidgetMemberVerification.access$parseInviteGuild(this.this$0), null, null, null, null, 120, null);
    }
}
