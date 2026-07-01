package com.discord.widgets.settings.premium;

import android.widget.TextView;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.t;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGifting$onViewBound$2 extends o implements Function1<TextView, Unit> {
    public final /* synthetic */ WidgetSettingsGifting this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsGifting$onViewBound$2(WidgetSettingsGifting widgetSettingsGifting) {
        super(1);
        this.this$0 = widgetSettingsGifting;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
        invoke2(textView);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(TextView textView) {
        m.checkNotNullParameter(textView, "it");
        TextInputLayout textInputLayout = WidgetSettingsGifting.access$getBinding$p(this.this$0).k;
        m.checkNotNullExpressionValue(textInputLayout, "binding.settingsGiftingGiftCodeInputWrap");
        WidgetSettingsGifting.access$getViewModel$p(this.this$0).redeemGiftCode(t.replace$default(t.replace$default(ViewExtensions.getTextOrEmpty(textInputLayout), "https://discord.gift/", "", false, 4, (Object) null), "-", "", false, 4, (Object) null), this.this$0);
    }
}
