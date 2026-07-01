package com.discord.widgets.guilds.profile;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.discord.widgets.channels.WidgetCreateChannel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildProfileSheet$configureGuildActions$$inlined$apply$lambda$1 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ boolean $canManageChannels$inlined;
    public final /* synthetic */ long $guildId$inlined;
    public final /* synthetic */ TextView $this_apply;
    public final /* synthetic */ WidgetGuildProfileSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildProfileSheet$configureGuildActions$$inlined$apply$lambda$1(TextView textView, WidgetGuildProfileSheet widgetGuildProfileSheet, boolean z2, long j) {
        super(1);
        this.$this_apply = textView;
        this.this$0 = widgetGuildProfileSheet;
        this.$canManageChannels$inlined = z2;
        this.$guildId$inlined = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
        WidgetCreateChannel.Companion companion = WidgetCreateChannel.INSTANCE;
        Context context = this.$this_apply.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        WidgetCreateChannel.Companion.show$default(companion, context, this.$guildId$inlined, 4, null, 8, null);
    }
}
