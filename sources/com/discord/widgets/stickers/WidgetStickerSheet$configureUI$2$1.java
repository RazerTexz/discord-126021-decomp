package com.discord.widgets.stickers;

import android.content.Context;
import android.view.View;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.discord.widgets.settings.premium.WidgetSettingsPremium$Companion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetStickerSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetStickerSheet$configureUI$2$1 extends o implements Function1<View, Unit> {
    public static final WidgetStickerSheet$configureUI$2$1 INSTANCE = new WidgetStickerSheet$configureUI$2$1();

    public WidgetStickerSheet$configureUI$2$1() {
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
        WidgetSettingsPremium$Companion.launch$default(widgetSettingsPremium$Companion, context, null, "Sticker Nitro Upsell Popout", 2, null);
    }
}
