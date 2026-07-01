package com.discord.widgets.settings.premium;

import com.discord.i18n.RenderContext;
import com.discord.utilities.rest.SendUtils;
import d0.z.d.m;
import d0.z.d.o;
import java.text.NumberFormat;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsPremium.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPremium$onViewBound$6 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ NumberFormat $numberFormat;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsPremium$onViewBound$6(NumberFormat numberFormat) {
        super(1);
        this.$numberFormat = numberFormat;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        Map<String, String> map = renderContext.args;
        String str = this.$numberFormat.format((Object) 2000);
        m.checkNotNullExpressionValue(str, "numberFormat.format(Send…_MESSAGE_CHARACTER_COUNT)");
        map.put("nonPremiumMaxMessageLength", str);
        Map<String, String> map2 = renderContext.args;
        String str2 = this.$numberFormat.format(Integer.valueOf(SendUtils.MAX_MESSAGE_CHARACTER_COUNT_PREMIUM));
        m.checkNotNullExpressionValue(str2, "numberFormat.format(Send…_CHARACTER_COUNT_PREMIUM)");
        map2.put("premiumMaxMessageLength", str2);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }
}
