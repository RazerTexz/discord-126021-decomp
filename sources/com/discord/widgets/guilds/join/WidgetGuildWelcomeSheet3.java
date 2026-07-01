package com.discord.widgets.guilds.join;

import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.guilds.join.WidgetGuildWelcomeSheet$configureWelcomeChannels$dismissSheet$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildWelcomeSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildWelcomeSheet3 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ WidgetGuildWelcomeSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildWelcomeSheet3(WidgetGuildWelcomeSheet widgetGuildWelcomeSheet) {
        super(0);
        this.this$0 = widgetGuildWelcomeSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.dismiss();
    }
}
