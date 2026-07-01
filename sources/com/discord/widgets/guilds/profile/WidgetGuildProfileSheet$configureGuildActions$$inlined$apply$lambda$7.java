package com.discord.widgets.guilds.profile;

import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildProfileSheet$configureGuildActions$$inlined$apply$lambda$7 extends o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetGuildProfileSheetViewModel$Actions $actions$inlined;
    public final /* synthetic */ long $guildId$inlined;
    public final /* synthetic */ WidgetGuildProfileSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildProfileSheet$configureGuildActions$$inlined$apply$lambda$7(WidgetGuildProfileSheet widgetGuildProfileSheet, WidgetGuildProfileSheetViewModel$Actions widgetGuildProfileSheetViewModel$Actions, long j) {
        super(1);
        this.this$0 = widgetGuildProfileSheet;
        this.$actions$inlined = widgetGuildProfileSheetViewModel$Actions;
        this.$guildId$inlined = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        WidgetGuildProfileSheet.access$showLeaveServerDialog(this.this$0, this.$guildId$inlined);
    }
}
