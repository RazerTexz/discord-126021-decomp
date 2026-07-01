package com.discord.widgets.settings.premium;

import com.discord.i18n.RenderContext;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsGiftingAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$4 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ WidgetSettingsGiftingAdapter$GiftItem $data;
    public final /* synthetic */ WidgetSettingsGiftingAdapter$EntitlementListItem this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$4(WidgetSettingsGiftingAdapter$EntitlementListItem widgetSettingsGiftingAdapter$EntitlementListItem, WidgetSettingsGiftingAdapter$GiftItem widgetSettingsGiftingAdapter$GiftItem) {
        super(1);
        this.this$0 = widgetSettingsGiftingAdapter$EntitlementListItem;
        this.$data = widgetSettingsGiftingAdapter$GiftItem;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.b("revokeHook", new WidgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$4$1(this));
    }
}
