package com.discord.widgets.channels.settings;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelGroupDMSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelGroupDMSettings$onViewBoundOrOnResume$2 extends o implements Function1<ChannelGroupDMSettingsViewModel$Event, Unit> {
    public final /* synthetic */ WidgetChannelGroupDMSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelGroupDMSettings$onViewBoundOrOnResume$2(WidgetChannelGroupDMSettings widgetChannelGroupDMSettings) {
        super(1);
        this.this$0 = widgetChannelGroupDMSettings;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ChannelGroupDMSettingsViewModel$Event channelGroupDMSettingsViewModel$Event) {
        invoke2(channelGroupDMSettingsViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ChannelGroupDMSettingsViewModel$Event channelGroupDMSettingsViewModel$Event) {
        m.checkNotNullParameter(channelGroupDMSettingsViewModel$Event, "event");
        this.this$0.handleEvent(channelGroupDMSettingsViewModel$Event);
    }
}
