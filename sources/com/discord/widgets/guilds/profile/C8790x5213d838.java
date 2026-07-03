package com.discord.widgets.guilds.profile;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.discord.widgets.servers.WidgetServerNotifications;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheet$configureGuildHubActions$$inlined$apply$lambda$2 */
/* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8790x5213d838 extends AbstractC12240o implements Function1<View, Unit> {
    public final /* synthetic */ long $guildId$inlined;
    public final /* synthetic */ TextView $this_apply;
    public final /* synthetic */ WidgetGuildProfileSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8790x5213d838(TextView textView, WidgetGuildProfileSheet widgetGuildProfileSheet, long j) {
        super(1);
        this.$this_apply = textView;
        this.this$0 = widgetGuildProfileSheet;
        this.$guildId$inlined = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        C12238m.checkNotNullParameter(view, "it");
        WidgetServerNotifications.Companion companion = WidgetServerNotifications.INSTANCE;
        long j = this.$guildId$inlined;
        Context context = this.$this_apply.getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        companion.launch(j, context);
    }
}
