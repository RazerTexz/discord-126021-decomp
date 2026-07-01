package com.discord.widgets.channels.permissions;

import b.d.b.a.a;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsOverview$configureTabs$1 extends o implements Function1<Integer, Unit> {
    public final /* synthetic */ WidgetChannelSettingsPermissionsOverview this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsPermissionsOverview$configureTabs$1(WidgetChannelSettingsPermissionsOverview widgetChannelSettingsPermissionsOverview) {
        super(1);
        this.this$0 = widgetChannelSettingsPermissionsOverview;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        WidgetChannelSettingsPermissionsOverviewViewModel$Tab widgetChannelSettingsPermissionsOverviewViewModel$Tab;
        if (i == 0) {
            widgetChannelSettingsPermissionsOverviewViewModel$Tab = WidgetChannelSettingsPermissionsOverviewViewModel$Tab.MODERATOR;
        } else {
            if (i != 1) {
                throw new IllegalArgumentException(a.q("illegal index: ", i));
            }
            widgetChannelSettingsPermissionsOverviewViewModel$Tab = WidgetChannelSettingsPermissionsOverviewViewModel$Tab.ADVANCED;
        }
        WidgetChannelSettingsPermissionsOverview.access$getViewModel$p(this.this$0).selectTab(widgetChannelSettingsPermissionsOverviewViewModel$Tab);
    }
}
