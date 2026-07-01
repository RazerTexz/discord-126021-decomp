package com.discord.widgets.servers.settings.members;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.servers.settings.members.WidgetServerSettingsMembers$guildId$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsMembers3 extends Lambda implements Function0<Long> {
    public final /* synthetic */ WidgetServerSettingsMembers this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsMembers3(WidgetServerSettingsMembers widgetServerSettingsMembers) {
        super(0);
        this.this$0 = widgetServerSettingsMembers;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return this.this$0.getMostRecentIntent().getLongExtra("GUILD_ID", -1L);
    }
}
