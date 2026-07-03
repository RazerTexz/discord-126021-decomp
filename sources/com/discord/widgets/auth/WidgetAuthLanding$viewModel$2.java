package com.discord.widgets.auth;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetAuthLanding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLanding$viewModel$2 extends AbstractC12240o implements Function0<WidgetAuthLandingViewModel> {
    public final /* synthetic */ WidgetAuthLanding this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthLanding$viewModel$2(WidgetAuthLanding widgetAuthLanding) {
        super(0);
        this.this$0 = widgetAuthLanding;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetAuthLandingViewModel invoke() {
        return new WidgetAuthLandingViewModel(this.this$0.requireContext(), null, null, null, null, null, 62, null);
    }
}
