package com.discord.widgets.status;

import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGlobalStatusIndicatorViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGlobalStatusIndicatorViewModel$ackStageInvitationToSpeak$1 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ boolean $accept;
    public final /* synthetic */ WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing $stageState;
    public final /* synthetic */ WidgetGlobalStatusIndicatorViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalStatusIndicatorViewModel$ackStageInvitationToSpeak$1(WidgetGlobalStatusIndicatorViewModel widgetGlobalStatusIndicatorViewModel, boolean z2, WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing) {
        super(1);
        this.this$0 = widgetGlobalStatusIndicatorViewModel;
        this.$accept = z2;
        this.$stageState = widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r14) {
        if (this.$accept) {
            AnalyticsTracker.INSTANCE.promotedToSpeaker(this.$stageState.getSelectedVoiceChannel().getId());
        }
        WidgetGlobalStatusIndicatorViewModel$ViewState widgetGlobalStatusIndicatorViewModel$ViewStateAccess$getViewState$p = WidgetGlobalStatusIndicatorViewModel.access$getViewState$p(this.this$0);
        if (!(widgetGlobalStatusIndicatorViewModel$ViewStateAccess$getViewState$p instanceof WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing)) {
            widgetGlobalStatusIndicatorViewModel$ViewStateAccess$getViewState$p = null;
        }
        WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing = (WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing) widgetGlobalStatusIndicatorViewModel$ViewStateAccess$getViewState$p;
        if (widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing != null) {
            WidgetGlobalStatusIndicatorViewModel.access$updateViewState(this.this$0, WidgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing.copy$default(widgetGlobalStatusIndicatorViewModel$ViewState$StageChannelOngoing, null, null, null, null, null, false, null, false, false, 0, 767, null));
        }
    }
}
