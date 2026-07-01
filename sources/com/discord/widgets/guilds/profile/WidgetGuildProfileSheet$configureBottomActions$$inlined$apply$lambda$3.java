package com.discord.widgets.guilds.profile;

import android.view.View;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildProfileSheet$configureBottomActions$$inlined$apply$lambda$3 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ Long $channelId$inlined;
    public final /* synthetic */ long $guildId$inlined;
    public final /* synthetic */ boolean $showViewServer$inlined;
    public final /* synthetic */ WidgetGuildProfileSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildProfileSheet$configureBottomActions$$inlined$apply$lambda$3(WidgetGuildProfileSheet widgetGuildProfileSheet, boolean z2, long j, Long l) {
        super(1);
        this.this$0 = widgetGuildProfileSheet;
        this.$showViewServer$inlined = z2;
        this.$guildId$inlined = j;
        this.$channelId$inlined = l;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
        this.this$0.getViewModel().onClickViewServer(this.$guildId$inlined, this.$channelId$inlined);
    }
}
