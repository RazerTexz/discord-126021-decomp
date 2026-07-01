package com.discord.widgets.hubs;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAuthentication$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAuthentication4 extends Lambda implements Function0<WidgetHubAuthenticationlViewModel4> {
    public final /* synthetic */ WidgetHubAuthentication this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAuthentication4(WidgetHubAuthentication widgetHubAuthentication) {
        super(0);
        this.this$0 = widgetHubAuthentication;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetHubAuthenticationlViewModel4 invoke() {
        return new WidgetHubAuthenticationlViewModel4(this.this$0.getArgs().getEmail(), this.this$0.getArgs().getGuildId(), null, false, 12, null);
    }
}
