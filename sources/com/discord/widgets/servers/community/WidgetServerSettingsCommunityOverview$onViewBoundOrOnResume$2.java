package com.discord.widgets.servers.community;

import androidx.fragment.app.FragmentActivity;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsCommunityOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCommunityOverview$onViewBoundOrOnResume$2 extends o implements Function1<WidgetServerSettingsCommunityOverviewViewModel$Event, Unit> {
    public final /* synthetic */ WidgetServerSettingsCommunityOverview this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsCommunityOverview$onViewBoundOrOnResume$2(WidgetServerSettingsCommunityOverview widgetServerSettingsCommunityOverview) {
        super(1);
        this.this$0 = widgetServerSettingsCommunityOverview;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsCommunityOverviewViewModel$Event widgetServerSettingsCommunityOverviewViewModel$Event) {
        invoke2(widgetServerSettingsCommunityOverviewViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetServerSettingsCommunityOverviewViewModel$Event widgetServerSettingsCommunityOverviewViewModel$Event) {
        m.checkNotNullParameter(widgetServerSettingsCommunityOverviewViewModel$Event, "event");
        if (m.areEqual(widgetServerSettingsCommunityOverviewViewModel$Event, WidgetServerSettingsCommunityOverviewViewModel$Event$DisableCommunitySuccess.INSTANCE)) {
            this.this$0.requireActivity().finish();
            WidgetServerSettingsEnableCommunitySteps$Companion widgetServerSettingsEnableCommunitySteps$Companion = WidgetServerSettingsEnableCommunitySteps.Companion;
            FragmentActivity fragmentActivityRequireActivity = this.this$0.requireActivity();
            m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            widgetServerSettingsEnableCommunitySteps$Companion.create(fragmentActivityRequireActivity, this.this$0.getGuildId());
            return;
        }
        if (m.areEqual(widgetServerSettingsCommunityOverviewViewModel$Event, WidgetServerSettingsCommunityOverviewViewModel$Event$SaveSuccess.INSTANCE)) {
            b.a.d.m.i(this.this$0, 2131895592, 0, 4);
        } else if (m.areEqual(widgetServerSettingsCommunityOverviewViewModel$Event, WidgetServerSettingsCommunityOverviewViewModel$Event$Error.INSTANCE)) {
            b.a.d.m.i(this.this$0, 2131891378, 0, 4);
        }
    }
}
