package com.discord.widgets.servers.guildboost;

import android.content.Context;
import android.view.View;
import com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost;
import com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost$Companion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildBoost.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildBoost$onViewBound$3$1 extends o implements Function1<View, Unit> {
    public static final WidgetGuildBoost$onViewBound$3$1 INSTANCE = new WidgetGuildBoost$onViewBound$3$1();

    public WidgetGuildBoost$onViewBound$3$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "view");
        WidgetSettingsGuildBoost$Companion widgetSettingsGuildBoost$Companion = WidgetSettingsGuildBoost.Companion;
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "view.context");
        widgetSettingsGuildBoost$Companion.launch(context);
    }
}
