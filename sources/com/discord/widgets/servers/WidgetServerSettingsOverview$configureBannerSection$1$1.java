package com.discord.widgets.servers;

import android.content.Context;
import android.view.View;
import com.discord.widgets.servers.guildboost.WidgetGuildBoost;
import com.discord.widgets.servers.guildboost.WidgetGuildBoost$Companion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsOverview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsOverview$configureBannerSection$1$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetServerSettingsOverview$configureBannerSection$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsOverview$configureBannerSection$1$1(WidgetServerSettingsOverview$configureBannerSection$1 widgetServerSettingsOverview$configureBannerSection$1) {
        super(1);
        this.this$0 = widgetServerSettingsOverview$configureBannerSection$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "view");
        WidgetGuildBoost$Companion widgetGuildBoost$Companion = WidgetGuildBoost.Companion;
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "view.context");
        widgetGuildBoost$Companion.create(context, this.this$0.$guild.getId());
    }
}
