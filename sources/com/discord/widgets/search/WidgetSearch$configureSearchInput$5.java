package com.discord.widgets.search;

import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearch$configureSearchInput$5 extends o implements Function1<String, Unit> {
    public final /* synthetic */ WidgetSearch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSearch$configureSearchInput$5(WidgetSearch widgetSearch) {
        super(1);
        this.this$0 = widgetSearch;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        TextInputLayout textInputLayout = WidgetSearch.access$getBinding$p(this.this$0).c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.widgetSearchInput");
        ViewExtensions.setText(textInputLayout, str);
        TextInputLayout textInputLayout2 = WidgetSearch.access$getBinding$p(this.this$0).c;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.widgetSearchInput");
        ViewExtensions.setSelectionEnd(textInputLayout2);
    }
}
