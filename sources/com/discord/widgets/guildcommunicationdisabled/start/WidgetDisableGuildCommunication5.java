package com.discord.widgets.guildcommunicationdisabled.start;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.guildcommunicationdisabled.start.WidgetDisableGuildCommunication$userId$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetDisableGuildCommunication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDisableGuildCommunication5 extends Lambda implements Function0<Long> {
    public final /* synthetic */ WidgetDisableGuildCommunication this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDisableGuildCommunication5(WidgetDisableGuildCommunication widgetDisableGuildCommunication) {
        super(0);
        this.this$0 = widgetDisableGuildCommunication;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return this.this$0.getMostRecentIntent().getLongExtra("INTENT_EXTRA_USER_ID", -1L);
    }
}
