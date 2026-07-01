package com.discord.widgets.channels.settings;

import androidx.fragment.app.FragmentManager;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;
import com.discord.widgets.settings.WidgetMuteSettingsSheet;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetChannelNotificationSettings$configureUI$onMute$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelNotificationSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelNotificationSettings5 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ WidgetChannelNotificationSettings.Model $this_configureUI;
    public final /* synthetic */ WidgetChannelNotificationSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelNotificationSettings5(WidgetChannelNotificationSettings widgetChannelNotificationSettings, WidgetChannelNotificationSettings.Model model) {
        super(0);
        this.this$0 = widgetChannelNotificationSettings;
        this.$this_configureUI = model;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetMuteSettingsSheet.Companion companion = WidgetMuteSettingsSheet.INSTANCE;
        long id2 = this.$this_configureUI.getChannel().getId();
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.showForChannel(id2, parentFragmentManager);
    }
}
