package com.discord.widgets.channels.permissions;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetChannelSettingsEditPermissions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsEditPermissions$type$2 extends AbstractC12240o implements Function0<Integer> {
    public final /* synthetic */ WidgetChannelSettingsEditPermissions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsEditPermissions$type$2(WidgetChannelSettingsEditPermissions widgetChannelSettingsEditPermissions) {
        super(0);
        this.this$0 = widgetChannelSettingsEditPermissions;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2() {
        return this.this$0.getMostRecentIntent().getIntExtra("INTENT_EXTRA_TYPE", -1);
    }
}
