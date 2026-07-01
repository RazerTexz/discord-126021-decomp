package com.discord.widgets.channels.settings;

import androidx.fragment.app.FragmentManager;
import com.discord.widgets.settings.WidgetMuteSettingsSheet;
import com.discord.widgets.settings.WidgetMuteSettingsSheet$Companion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChannelGroupDMSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelGroupDMSettings$configureUi$3 extends o implements Function0<Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ WidgetChannelGroupDMSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelGroupDMSettings$configureUi$3(WidgetChannelGroupDMSettings widgetChannelGroupDMSettings, long j) {
        super(0);
        this.this$0 = widgetChannelGroupDMSettings;
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetMuteSettingsSheet$Companion widgetMuteSettingsSheet$Companion = WidgetMuteSettingsSheet.Companion;
        long j = this.$channelId;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetMuteSettingsSheet$Companion.showForChannel(j, parentFragmentManager);
    }
}
