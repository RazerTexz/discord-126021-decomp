package com.discord.widgets.auth;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetRemoteAuth.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetRemoteAuth$viewModel$2 extends AbstractC12240o implements Function0<WidgetRemoteAuthViewModel> {
    public final /* synthetic */ WidgetRemoteAuth this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetRemoteAuth$viewModel$2(WidgetRemoteAuth widgetRemoteAuth) {
        super(0);
        this.this$0 = widgetRemoteAuth;
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
