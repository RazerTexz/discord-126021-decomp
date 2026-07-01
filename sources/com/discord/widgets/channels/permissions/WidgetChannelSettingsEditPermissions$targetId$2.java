package com.discord.widgets.channels.permissions;

import com.discord.widgets.search.WidgetSearch;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChannelSettingsEditPermissions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsEditPermissions$targetId$2 extends o implements Function0<Long> {
    public final /* synthetic */ WidgetChannelSettingsEditPermissions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsEditPermissions$targetId$2(WidgetChannelSettingsEditPermissions widgetChannelSettingsEditPermissions) {
        super(0);
        this.this$0 = widgetChannelSettingsEditPermissions;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return this.this$0.getMostRecentIntent().getLongExtra(WidgetSearch.INTENT_EXTRA_TARGET_ID, -1L);
    }
}
