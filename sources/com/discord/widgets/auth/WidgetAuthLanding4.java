package com.discord.widgets.auth;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthLanding$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetAuthLanding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLanding4 extends Lambda implements Function0<WidgetAuthLandingViewModel> {
    public final /* synthetic */ WidgetAuthLanding this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthLanding4(WidgetAuthLanding widgetAuthLanding) {
        super(0);
        this.this$0 = widgetAuthLanding;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetAuthLandingViewModel invoke() {
        return new WidgetAuthLandingViewModel(this.this$0.requireContext(), null, null, null, null, null, 62, null);
    }
}
