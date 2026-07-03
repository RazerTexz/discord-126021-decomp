package com.discord.widgets.settings.premium;

import android.content.Context;
import com.discord.i18n.RenderContext;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.widgets.settings.premium.WidgetSettingsGiftingAdapter;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSettingsGiftingAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGiftingAdapter$SkuListItem$onConfigure$1 extends AbstractC12240o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ WidgetSettingsGiftingAdapter.GiftItem $data;
    public final /* synthetic */ int $numMonthsOrYears;
    public final /* synthetic */ int $quantityString;
    public final /* synthetic */ WidgetSettingsGiftingAdapter.SkuListItem this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsGiftingAdapter$SkuListItem$onConfigure$1(WidgetSettingsGiftingAdapter.SkuListItem skuListItem, WidgetSettingsGiftingAdapter.GiftItem giftItem, int i, int i2) {
        super(1);
        this.this$0 = skuListItem;
        this.$data = giftItem;
        this.$quantityString = i;
        this.$numMonthsOrYears = i2;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        C12238m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.args.put("skuName", this.$data.getSku().getName());
        Map<String, String> map = renderContext.args;
        Context contextM885x = C1643a.m885x(this.this$0.itemView, "itemView", "itemView.context");
        int i = this.$quantityString;
        int i2 = this.$numMonthsOrYears;
        map.put("intervalCount", StringResourceUtilsKt.getI18nPluralString(contextM885x, i, i2, Integer.valueOf(i2)).toString());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.f27425a;
    }
}
