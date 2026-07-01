package com.discord.widgets.hubs;

import com.discord.api.hubs.EmailVerification;
import com.discord.stores.utilities.Success;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAuthentication$configureUi$2 extends o implements Function1<Success<? extends EmailVerification>, Unit> {
    public final /* synthetic */ WidgetHubAuthentication this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAuthentication$configureUi$2(WidgetHubAuthentication widgetHubAuthentication) {
        super(1);
        this.this$0 = widgetHubAuthentication;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Success<? extends EmailVerification> success) {
        invoke2((Success<EmailVerification>) success);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Success<EmailVerification> success) {
        m.checkNotNullParameter(success, "it");
        b.a.d.m.i(this.this$0, 2131892830, 0, 4);
    }
}
