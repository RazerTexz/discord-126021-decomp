package com.discord.widgets.settings.premium;

import android.content.Context;
import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGifting$onViewBound$7$1 extends o implements Function1<View, Unit> {
    public static final WidgetSettingsGifting$onViewBound$7$1 INSTANCE = new WidgetSettingsGifting$onViewBound$7$1();

    public WidgetSettingsGifting$onViewBound$7$1() {
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
        WidgetSettingsPremium$Companion widgetSettingsPremium$Companion = WidgetSettingsPremium.Companion;
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, "view.context");
        WidgetSettingsPremium$Companion.launch$default(widgetSettingsPremium$Companion, context, 0, null, 4, null);
    }
}
