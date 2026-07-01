package com.discord.widgets.settings.premium;

import com.discord.i18n.RenderContext;
import d0.z.d.m;
import d0.z.d.o;
import java.text.NumberFormat;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsPremium.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPremium$onViewBound$3 extends o implements Function1<RenderContext, Unit> {
    public static final WidgetSettingsPremium$onViewBound$3 INSTANCE = new WidgetSettingsPremium$onViewBound$3();

    public WidgetSettingsPremium$onViewBound$3() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.args.put("numBoosts", String.valueOf(2));
        Map<String, String> map = renderContext.args;
        String str = NumberFormat.getPercentInstance().format(Float.valueOf(0.3f));
        m.checkNotNullExpressionValue(str, "NumberFormat.getPercentI…_DISCOUNT_PERCENT\n      )");
        map.put("discountPercentage", str);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }
}
