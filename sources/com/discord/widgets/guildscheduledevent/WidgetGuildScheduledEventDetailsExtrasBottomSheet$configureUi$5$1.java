package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildScheduledEventDetailsExtrasBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$5$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$5 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$5$1(WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$5 widgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$5) {
        super(1);
        this.this$0 = widgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$5;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        GuildScheduledEventDetailsViewModel guildScheduledEventDetailsViewModelAccess$getViewModel$p = WidgetGuildScheduledEventDetailsExtrasBottomSheet.access$getViewModel$p(this.this$0.this$0);
        Context contextRequireContext = this.this$0.this$0.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        guildScheduledEventDetailsViewModelAccess$getViewModel$p.onDeleteButtonClicked(contextRequireContext, new WidgetGuildScheduledEventDetailsExtrasBottomSheet$configureUi$5$1$1(this));
    }
}
