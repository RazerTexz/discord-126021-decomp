package com.discord.widgets.hubs;

import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.k.b;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetHubDescription.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDescription$validationManager$2$2 extends o implements Function2<LinearLayout, CharSequence, Boolean> {
    public final /* synthetic */ WidgetHubDescription$validationManager$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDescription$validationManager$2$2(WidgetHubDescription$validationManager$2 widgetHubDescription$validationManager$2) {
        super(2);
        this.this$0 = widgetHubDescription$validationManager$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(LinearLayout linearLayout, CharSequence charSequence) {
        return Boolean.valueOf(invoke2(linearLayout, charSequence));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(LinearLayout linearLayout, CharSequence charSequence) {
        m.checkNotNullParameter(linearLayout, "<anonymous parameter 0>");
        m.checkNotNullParameter(charSequence, "errorMessage");
        TextView textView = this.this$0.this$0.getBinding().d;
        m.checkNotNullExpressionValue(textView, "binding.categoryError");
        b.a(textView, charSequence);
        return true;
    }
}
