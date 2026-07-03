package com.discord.widgets.guilds.profile;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheet$configureBottomActions$$inlined$apply$lambda$3 */
/* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8779xf99beb30 extends AbstractC12240o implements Function1<View, Unit> {
    public final /* synthetic */ Long $channelId$inlined;
    public final /* synthetic */ long $guildId$inlined;
    public final /* synthetic */ boolean $showViewServer$inlined;
    public final /* synthetic */ WidgetGuildProfileSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8779xf99beb30(WidgetGuildProfileSheet widgetGuildProfileSheet, boolean z2, long j, Long l) {
        super(1);
        this.this$0 = widgetGuildProfileSheet;
        this.$showViewServer$inlined = z2;
        this.$guildId$inlined = j;
        this.$channelId$inlined = l;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        C12238m.checkNotNullParameter(view, "it");
        this.this$0.getViewModel().onClickViewServer(this.$guildId$inlined, this.$channelId$inlined);
    }
}
