package com.discord.widgets.guilds.profile;

import android.content.Context;
import android.view.View;
import com.discord.widgets.servers.WidgetServerSettingsEmojis;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildProfileSheet$configureBottomActions$$inlined$apply$lambda$1 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ long $guildId$inlined;
    public final /* synthetic */ boolean $showUploadEmoji$inlined;
    public final /* synthetic */ WidgetGuildProfileSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildProfileSheet$configureBottomActions$$inlined$apply$lambda$1(WidgetGuildProfileSheet widgetGuildProfileSheet, boolean z2, long j) {
        super(1);
        this.this$0 = widgetGuildProfileSheet;
        this.$showUploadEmoji$inlined = z2;
        this.$guildId$inlined = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "v");
        WidgetServerSettingsEmojis.Companion companion = WidgetServerSettingsEmojis.INSTANCE;
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "v.context");
        companion.create(context, this.$guildId$inlined);
    }
}
