package com.discord.widgets.channels.settings;

import androidx.fragment.app.FragmentActivity;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelNotificationSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelNotificationSettings$onViewBoundOrOnResume$2 extends o implements Function1<WidgetChannelNotificationSettings$Model, Unit> {
    public final /* synthetic */ WidgetChannelNotificationSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelNotificationSettings$onViewBoundOrOnResume$2(WidgetChannelNotificationSettings widgetChannelNotificationSettings) {
        super(1);
        this.this$0 = widgetChannelNotificationSettings;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelNotificationSettings$Model widgetChannelNotificationSettings$Model) {
        invoke2(widgetChannelNotificationSettings$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChannelNotificationSettings$Model widgetChannelNotificationSettings$Model) {
        if (widgetChannelNotificationSettings$Model != null) {
            WidgetChannelNotificationSettings.access$configureUI(this.this$0, widgetChannelNotificationSettings$Model);
            return;
        }
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
