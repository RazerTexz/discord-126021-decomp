package com.discord.widgets.guilds.profile;

import androidx.fragment.app.FragmentActivity;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChangeGuildIdentity.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChangeGuildIdentity$onViewBoundOrOnResume$2 extends o implements Function1<WidgetChangeGuildIdentityViewModel$Event, Unit> {
    public final /* synthetic */ WidgetChangeGuildIdentity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChangeGuildIdentity$onViewBoundOrOnResume$2(WidgetChangeGuildIdentity widgetChangeGuildIdentity) {
        super(1);
        this.this$0 = widgetChangeGuildIdentity;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChangeGuildIdentityViewModel$Event widgetChangeGuildIdentityViewModel$Event) {
        invoke2(widgetChangeGuildIdentityViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChangeGuildIdentityViewModel$Event widgetChangeGuildIdentityViewModel$Event) {
        m.checkNotNullParameter(widgetChangeGuildIdentityViewModel$Event, "event");
        boolean z2 = true;
        if (!(widgetChangeGuildIdentityViewModel$Event instanceof WidgetChangeGuildIdentityViewModel$Event$MemberUpdateFailed)) {
            if (widgetChangeGuildIdentityViewModel$Event instanceof WidgetChangeGuildIdentityViewModel$Event$MemberUpdateSucceeded) {
                WidgetChangeGuildIdentity.access$showToast(this.this$0, 2131893761);
                WidgetChangeGuildIdentity.access$getDiscardConfirmed$p(this.this$0).set(true);
                FragmentActivity activity = this.this$0.getActivity();
                if (activity != null) {
                    activity.onBackPressed();
                    return;
                }
                return;
            }
            return;
        }
        WidgetChangeGuildIdentityViewModel$Event$MemberUpdateFailed widgetChangeGuildIdentityViewModel$Event$MemberUpdateFailed = (WidgetChangeGuildIdentityViewModel$Event$MemberUpdateFailed) widgetChangeGuildIdentityViewModel$Event;
        String errorMessage = widgetChangeGuildIdentityViewModel$Event$MemberUpdateFailed.getErrorMessage();
        if (errorMessage != null && errorMessage.length() != 0) {
            z2 = false;
        }
        if (z2) {
            WidgetChangeGuildIdentity.access$showToast(this.this$0, 2131887502);
        } else {
            WidgetChangeGuildIdentity.access$showToast(this.this$0, widgetChangeGuildIdentityViewModel$Event$MemberUpdateFailed.getErrorMessage());
        }
    }
}
