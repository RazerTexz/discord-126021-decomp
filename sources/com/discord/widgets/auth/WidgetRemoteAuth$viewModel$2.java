package com.discord.widgets.auth;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetRemoteAuth.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetRemoteAuth$viewModel$2 extends o implements Function0<WidgetRemoteAuthViewModel> {
    public final /* synthetic */ WidgetRemoteAuth this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetRemoteAuth$viewModel$2(WidgetRemoteAuth widgetRemoteAuth) {
        super(0);
        this.this$0 = widgetRemoteAuth;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetRemoteAuthViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetRemoteAuthViewModel invoke() {
        String stringExtra = this.this$0.getMostRecentIntent().getStringExtra("REMOTE_AUTH_FINGERPRINT");
        if (stringExtra == null) {
            stringExtra = "";
        }
        return new WidgetRemoteAuthViewModel(stringExtra, null, 2, null);
    }
}
