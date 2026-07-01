package com.discord.widgets.settings.premium;

import android.content.Context;
import b.d.b.a.a;
import com.discord.i18n.RenderContext;
import com.discord.utilities.resources.StringResourceUtilsKt;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsGiftingAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGiftingAdapter$SkuListItem$onConfigure$1 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ WidgetSettingsGiftingAdapter$GiftItem $data;
    public final /* synthetic */ int $numMonthsOrYears;
    public final /* synthetic */ int $quantityString;
    public final /* synthetic */ WidgetSettingsGiftingAdapter$SkuListItem this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsGiftingAdapter$SkuListItem$onConfigure$1(WidgetSettingsGiftingAdapter$SkuListItem widgetSettingsGiftingAdapter$SkuListItem, WidgetSettingsGiftingAdapter$GiftItem widgetSettingsGiftingAdapter$GiftItem, int i, int i2) {
        super(1);
        this.this$0 = widgetSettingsGiftingAdapter$SkuListItem;
        this.$data = widgetSettingsGiftingAdapter$GiftItem;
        this.$quantityString = i;
        this.$numMonthsOrYears = i2;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.args.put("skuName", this.$data.getSku().getName());
        Map<String, String> map = renderContext.args;
        Context contextX = a.x(this.this$0.itemView, "itemView", "itemView.context");
        int i = this.$quantityString;
        int i2 = this.$numMonthsOrYears;
        map.put("intervalCount", StringResourceUtilsKt.getI18nPluralString(contextX, i, i2, Integer.valueOf(i2)).toString());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }
}
