package com.discord.widgets.hubs;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetHubAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAuthentication$viewModel$2 extends o implements Function0<WidgetHubAuthenticationViewModel> {
    public final /* synthetic */ WidgetHubAuthentication this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAuthentication$viewModel$2(WidgetHubAuthentication widgetHubAuthentication) {
        super(0);
        this.this$0 = widgetHubAuthentication;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetHubAuthenticationViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetHubAuthenticationViewModel invoke() {
        return new WidgetHubAuthenticationViewModel(this.this$0.getArgs().getEmail(), this.this$0.getArgs().getGuildId(), null, false, 12, null);
    }
}
