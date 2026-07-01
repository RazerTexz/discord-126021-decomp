package com.discord.widgets.guilds.profile;

import android.content.Context;
import android.view.View;
import com.discord.widgets.servers.WidgetServerSettings;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildProfileSheet$configureTabItems$$inlined$apply$lambda$3 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ boolean $canSeeGuildSettings$inlined;
    public final /* synthetic */ long $guildId$inlined;
    public final /* synthetic */ int $iconColor$inlined;
    public final /* synthetic */ WidgetGuildProfileSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildProfileSheet$configureTabItems$$inlined$apply$lambda$3(WidgetGuildProfileSheet widgetGuildProfileSheet, boolean z2, int i, long j) {
        super(1);
        this.this$0 = widgetGuildProfileSheet;
        this.$canSeeGuildSettings$inlined = z2;
        this.$iconColor$inlined = i;
        this.$guildId$inlined = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        WidgetServerSettings.Companion companion = WidgetServerSettings.INSTANCE;
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "view.context");
        companion.create(context, this.$guildId$inlined);
    }
}
