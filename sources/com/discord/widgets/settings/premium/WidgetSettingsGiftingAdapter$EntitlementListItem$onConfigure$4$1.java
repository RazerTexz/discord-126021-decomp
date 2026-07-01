package com.discord.widgets.settings.premium;

import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsGiftingAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$4$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$4 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$4$1(WidgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$4 widgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$4) {
        super(1);
        this.this$0 = widgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$4;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        WidgetSettingsGiftingAdapter.access$getOnRevokeClickListener$p(WidgetSettingsGiftingAdapter$EntitlementListItem.access$getAdapter$p(this.this$0.this$0)).invoke(this.this$0.$data.getGift());
    }
}
