package com.discord.widgets.servers.member_verification;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetMemberVerification.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetMemberVerification$onViewBoundOrOnResume$1 extends k implements Function1<WidgetMemberVerificationViewModel$ViewState, Unit> {
    public WidgetMemberVerification$onViewBoundOrOnResume$1(WidgetMemberVerification widgetMemberVerification) {
        super(1, widgetMemberVerification, WidgetMemberVerification.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetMemberVerificationViewModel$ViewState widgetMemberVerificationViewModel$ViewState) {
        invoke2(widgetMemberVerificationViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetMemberVerificationViewModel$ViewState widgetMemberVerificationViewModel$ViewState) {
        m.checkNotNullParameter(widgetMemberVerificationViewModel$ViewState, "p1");
        WidgetMemberVerification.access$configureUI((WidgetMemberVerification) this.receiver, widgetMemberVerificationViewModel$ViewState);
    }
}
