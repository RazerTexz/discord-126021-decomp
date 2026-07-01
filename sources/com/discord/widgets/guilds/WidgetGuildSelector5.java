package com.discord.widgets.guilds;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.guilds.WidgetGuildSelector$requestKey$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildSelector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildSelector5 extends Lambda implements Function0<String> {
    public final /* synthetic */ WidgetGuildSelector this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildSelector5(WidgetGuildSelector widgetGuildSelector) {
        super(0);
        this.this$0 = widgetGuildSelector;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return this.this$0.getArgumentsOrDefault().getString("INTENT_EXTRA_REQUEST_CODE", "");
    }
}
