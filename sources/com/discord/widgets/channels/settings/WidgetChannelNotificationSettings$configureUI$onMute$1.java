package com.discord.widgets.channels.settings;

import androidx.fragment.app.FragmentManager;
import com.discord.widgets.settings.WidgetMuteSettingsSheet;
import com.discord.widgets.settings.WidgetMuteSettingsSheet$Companion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChannelNotificationSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelNotificationSettings$configureUI$onMute$1 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetChannelNotificationSettings$Model $this_configureUI;
    public final /* synthetic */ WidgetChannelNotificationSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelNotificationSettings$configureUI$onMute$1(WidgetChannelNotificationSettings widgetChannelNotificationSettings, WidgetChannelNotificationSettings$Model widgetChannelNotificationSettings$Model) {
        super(0);
        this.this$0 = widgetChannelNotificationSettings;
        this.$this_configureUI = widgetChannelNotificationSettings$Model;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetMuteSettingsSheet$Companion widgetMuteSettingsSheet$Companion = WidgetMuteSettingsSheet.Companion;
        long id2 = this.$this_configureUI.getChannel().getId();
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetMuteSettingsSheet$Companion.showForChannel(id2, parentFragmentManager);
    }
}
