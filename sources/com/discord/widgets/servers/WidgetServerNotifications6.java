package com.discord.widgets.servers;

import androidx.fragment.app.FragmentManager;
import com.discord.widgets.settings.WidgetMuteSettingsSheet;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerNotifications$configureUI$onMute$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerNotifications.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerNotifications6 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ WidgetServerNotifications this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerNotifications6(WidgetServerNotifications widgetServerNotifications, long j) {
        super(0);
        this.this$0 = widgetServerNotifications;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetMuteSettingsSheet.Companion companion = WidgetMuteSettingsSheet.INSTANCE;
        long j = this.$guildId;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.showForGuild(j, parentFragmentManager);
    }
}
