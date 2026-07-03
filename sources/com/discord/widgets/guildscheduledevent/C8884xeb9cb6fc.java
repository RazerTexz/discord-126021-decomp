package com.discord.widgets.guildscheduledevent;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet$previewLauncher$1 */
/* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8884xeb9cb6fc extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ WidgetGuildScheduledEventDetailsExtrasBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8884xeb9cb6fc(WidgetGuildScheduledEventDetailsExtrasBottomSheet widgetGuildScheduledEventDetailsExtrasBottomSheet) {
        super(0);
        this.this$0 = widgetGuildScheduledEventDetailsExtrasBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.dismissWithActionTaken();
    }
}
