package com.discord.widgets.servers.community;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEnableCommunitySteps$viewModel$2 extends AbstractC12240o implements Function0<WidgetServerSettingsEnableCommunityViewModel> {
    public final /* synthetic */ WidgetServerSettingsEnableCommunitySteps this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEnableCommunitySteps$viewModel$2(WidgetServerSettingsEnableCommunitySteps widgetServerSettingsEnableCommunitySteps) {
        super(0);
        this.this$0 = widgetServerSettingsEnableCommunitySteps;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetServerSettingsEnableCommunityViewModel invoke() {
        return new WidgetServerSettingsEnableCommunityViewModel(this.this$0.getGuildId(), null, 2, null);
    }
}
