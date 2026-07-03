package com.discord.widgets.hubs;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetHubWaitlist.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubWaitlist$viewModel$2 extends AbstractC12240o implements Function0<WidgetHubWaitlistViewModel> {
    public final /* synthetic */ WidgetHubWaitlist this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubWaitlist$viewModel$2(WidgetHubWaitlist widgetHubWaitlist) {
        super(0);
        this.this$0 = widgetHubWaitlist;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetHubWaitlistViewModel invoke() {
        return new WidgetHubWaitlistViewModel(this.this$0.getArgs().getEmail(), null, 2, 0 == true ? 1 : 0);
    }
}
