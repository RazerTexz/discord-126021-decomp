package com.discord.widgets.hubs;

import androidx.fragment.app.FragmentActivity;
import b.c.a.a0.d;
import com.discord.api.hubs.WaitlistSignup;
import com.discord.stores.utilities.Success;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubWaitlist.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubWaitlist$configureUI$1 extends o implements Function1<Success<? extends WaitlistSignup>, Unit> {
    public final /* synthetic */ WidgetHubWaitlist this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubWaitlist$configureUI$1(WidgetHubWaitlist widgetHubWaitlist) {
        super(1);
        this.this$0 = widgetHubWaitlist;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Success<? extends WaitlistSignup> success) {
        invoke2((Success<WaitlistSignup>) success);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Success<WaitlistSignup> success) {
        m.checkNotNullParameter(success, "it");
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.setResult(-1, d.g2(new HubWaitlistResult(success.invoke().getSchool())));
            activity.finish();
        }
    }
}
