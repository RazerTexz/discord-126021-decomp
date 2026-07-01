package com.discord.widgets.hubs;

import com.discord.api.hubs.EmailVerificationCode;
import com.discord.stores.utilities.RestCallState;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubAuthenticationlViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAuthenticationViewModel$verifyCode$2 extends o implements Function1<RestCallState<? extends EmailVerificationCode>, Unit> {
    public final /* synthetic */ WidgetHubAuthenticationViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAuthenticationViewModel$verifyCode$2(WidgetHubAuthenticationViewModel widgetHubAuthenticationViewModel) {
        super(1);
        this.this$0 = widgetHubAuthenticationViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RestCallState<? extends EmailVerificationCode> restCallState) {
        invoke2((RestCallState<EmailVerificationCode>) restCallState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RestCallState<EmailVerificationCode> restCallState) {
        m.checkNotNullParameter(restCallState, "response");
        WidgetHubAuthenticationViewModel widgetHubAuthenticationViewModel = this.this$0;
        WidgetHubAuthenticationViewModel.access$updateViewState(widgetHubAuthenticationViewModel, HubAuthenticationState.copy$default(WidgetHubAuthenticationViewModel.access$requireViewState(widgetHubAuthenticationViewModel), null, null, restCallState, 3, null));
    }
}
