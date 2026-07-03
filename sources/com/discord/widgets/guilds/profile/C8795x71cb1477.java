package com.discord.widgets.guilds.profile;

import android.content.Context;
import android.view.View;
import com.discord.widgets.servers.WidgetServerSettings;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheet$configureTabItems$$inlined$apply$lambda$3 */
/* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8795x71cb1477 extends AbstractC12240o implements Function1<View, Unit> {
    public final /* synthetic */ boolean $canSeeGuildSettings$inlined;
    public final /* synthetic */ long $guildId$inlined;
    public final /* synthetic */ int $iconColor$inlined;
    public final /* synthetic */ WidgetGuildProfileSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8795x71cb1477(WidgetGuildProfileSheet widgetGuildProfileSheet, boolean z2, int i, long j) {
        super(1);
        this.this$0 = widgetGuildProfileSheet;
        this.$canSeeGuildSettings$inlined = z2;
        this.$iconColor$inlined = i;
        this.$guildId$inlined = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        C12238m.checkNotNullParameter(view, "view");
        WidgetServerSettings.Companion companion = WidgetServerSettings.INSTANCE;
        Context context = view.getContext();
        C12238m.checkNotNullExpressionValue(context, "view.context");
        companion.create(context, this.$guildId$inlined);
    }
}
