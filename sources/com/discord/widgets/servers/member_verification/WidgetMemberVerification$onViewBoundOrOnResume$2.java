package com.discord.widgets.servers.member_verification;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetMemberVerification.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMemberVerification$onViewBoundOrOnResume$2 extends o implements Function1<WidgetMemberVerificationViewModel$Event, Unit> {
    public final /* synthetic */ WidgetMemberVerification this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetMemberVerification$onViewBoundOrOnResume$2(WidgetMemberVerification widgetMemberVerification) {
        super(1);
        this.this$0 = widgetMemberVerification;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetMemberVerificationViewModel$Event widgetMemberVerificationViewModel$Event) {
        invoke2(widgetMemberVerificationViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetMemberVerificationViewModel$Event widgetMemberVerificationViewModel$Event) {
        m.checkNotNullParameter(widgetMemberVerificationViewModel$Event, "event");
        if (!(widgetMemberVerificationViewModel$Event instanceof WidgetMemberVerificationViewModel$Event$Success)) {
            if (widgetMemberVerificationViewModel$Event instanceof WidgetMemberVerificationViewModel$Event$Error) {
                b.a.d.m.i(this.this$0, 2131891378, 0, 4);
                return;
            }
            return;
        }
        this.this$0.requireActivity().finish();
        WidgetMemberVerificationViewModel$Event$Success widgetMemberVerificationViewModel$Event$Success = (WidgetMemberVerificationViewModel$Event$Success) widgetMemberVerificationViewModel$Event;
        int iOrdinal = widgetMemberVerificationViewModel$Event$Success.getApplicationStatus().ordinal();
        if (iOrdinal == 1) {
            if (widgetMemberVerificationViewModel$Event$Success.getGuildId() == null || widgetMemberVerificationViewModel$Event$Success.getGuildName() == null) {
                return;
            }
            MemberVerificationPendingDialog.Companion.enqueue(widgetMemberVerificationViewModel$Event$Success.getGuildId().longValue(), MemberVerificationPendingViewModel$DialogState.PENDING);
            return;
        }
        if (iOrdinal == 3 && widgetMemberVerificationViewModel$Event$Success.getGuildId() != null && widgetMemberVerificationViewModel$Event$Success.getGuildName() != null && widgetMemberVerificationViewModel$Event$Success.getLastSeen() == null) {
            MemberVerificationSuccessDialog.Companion.enqueue(widgetMemberVerificationViewModel$Event$Success.getGuildId().longValue());
        }
    }
}
