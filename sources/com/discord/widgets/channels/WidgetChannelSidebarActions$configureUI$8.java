package com.discord.widgets.channels;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.settings.WidgetMuteSettingsSheet;
import com.discord.widgets.settings.WidgetMuteSettingsSheet$Companion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelSidebarActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSidebarActions$configureUI$8 extends o implements Function1<View, Unit> {
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ WidgetChannelSidebarActions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSidebarActions$configureUI$8(WidgetChannelSidebarActions widgetChannelSidebarActions, long j) {
        super(1);
        this.this$0 = widgetChannelSidebarActions;
        this.$channelId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        WidgetMuteSettingsSheet$Companion widgetMuteSettingsSheet$Companion = WidgetMuteSettingsSheet.Companion;
        long j = this.$channelId;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetMuteSettingsSheet$Companion.showForChannel(j, parentFragmentManager);
    }
}
