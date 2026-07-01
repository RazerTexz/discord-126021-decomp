package com.discord.widgets.servers.community;

import androidx.fragment.app.FragmentActivity;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsEnableCommunitySteps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$3 extends o implements Function1<WidgetServerSettingsEnableCommunityViewModel$Event, Unit> {
    public final /* synthetic */ WidgetServerSettingsEnableCommunitySteps this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEnableCommunitySteps$onViewBoundOrOnResume$3(WidgetServerSettingsEnableCommunitySteps widgetServerSettingsEnableCommunitySteps) {
        super(1);
        this.this$0 = widgetServerSettingsEnableCommunitySteps;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsEnableCommunityViewModel$Event widgetServerSettingsEnableCommunityViewModel$Event) {
        invoke2(widgetServerSettingsEnableCommunityViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetServerSettingsEnableCommunityViewModel$Event widgetServerSettingsEnableCommunityViewModel$Event) {
        m.checkNotNullParameter(widgetServerSettingsEnableCommunityViewModel$Event, "event");
        if (!m.areEqual(widgetServerSettingsEnableCommunityViewModel$Event, WidgetServerSettingsEnableCommunityViewModel$Event$SaveSuccess.INSTANCE)) {
            if (m.areEqual(widgetServerSettingsEnableCommunityViewModel$Event, WidgetServerSettingsEnableCommunityViewModel$Event$Error.INSTANCE)) {
                b.a.d.m.i(this.this$0, 2131891378, 0, 4);
            }
        } else {
            this.this$0.requireActivity().finish();
            WidgetServerSettingsCommunityOverview$Companion widgetServerSettingsCommunityOverview$Companion = WidgetServerSettingsCommunityOverview.Companion;
            FragmentActivity fragmentActivityRequireActivity = this.this$0.requireActivity();
            m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            widgetServerSettingsCommunityOverview$Companion.create(fragmentActivityRequireActivity, this.this$0.getGuildId());
        }
    }
}
