package com.discord.widgets.servers.community;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEnableCommunitySteps5 extends Lambda implements Function0<WidgetServerSettingsEnableCommunityViewModel> {
    public final /* synthetic */ WidgetServerSettingsEnableCommunitySteps this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEnableCommunitySteps5(WidgetServerSettingsEnableCommunitySteps widgetServerSettingsEnableCommunitySteps) {
        super(0);
        this.this$0 = widgetServerSettingsEnableCommunitySteps;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetServerSettingsEnableCommunityViewModel invoke() {
        return new WidgetServerSettingsEnableCommunityViewModel(this.this$0.getGuildId(), null, 2, null);
    }
}
