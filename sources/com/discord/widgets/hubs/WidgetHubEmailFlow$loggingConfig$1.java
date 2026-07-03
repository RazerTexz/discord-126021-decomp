package com.discord.widgets.hubs;

import com.discord.analytics.generated.events.impression.TrackImpressionHubEmailSignup;
import com.discord.api.science.AnalyticsSchema;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetHubEmailFlow.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEmailFlow$loggingConfig$1 extends AbstractC12240o implements Function0<AnalyticsSchema> {
    public final /* synthetic */ WidgetHubEmailFlow this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubEmailFlow$loggingConfig$1(WidgetHubEmailFlow widgetHubEmailFlow) {
        super(0);
        this.this$0 = widgetHubEmailFlow;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        return new TrackImpressionHubEmailSignup(Boolean.valueOf(this.this$0.getArgs().getEntryPoint() == HubEmailEntryPoint.Invite));
    }
}
