package com.discord.widgets.servers.settings.members;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsMembers$onViewBoundOrOnResume$3 extends o implements Function1<WidgetServerSettingsMembersModel, Unit> {
    public final /* synthetic */ WidgetServerSettingsMembers this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsMembers$onViewBoundOrOnResume$3(WidgetServerSettingsMembers widgetServerSettingsMembers) {
        super(1);
        this.this$0 = widgetServerSettingsMembers;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsMembersModel widgetServerSettingsMembersModel) throws Exception {
        invoke2(widgetServerSettingsMembersModel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetServerSettingsMembersModel widgetServerSettingsMembersModel) throws Exception {
        WidgetServerSettingsMembers.access$configureUI(this.this$0, widgetServerSettingsMembersModel);
    }
}
