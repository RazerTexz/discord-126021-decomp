package com.discord.widgets.user.usersheet;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheet$onViewCreated$16 extends o implements Function1<TextView, Unit> {
    public final /* synthetic */ View $view;
    public final /* synthetic */ WidgetUserSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserSheet$onViewCreated$16(WidgetUserSheet widgetUserSheet, View view) {
        super(1);
        this.this$0 = widgetUserSheet;
        this.$view = view;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
        invoke2(textView);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(TextView textView) {
        m.checkNotNullParameter(textView, "it");
        WidgetUserSheetViewModel widgetUserSheetViewModelAccess$getViewModel$p = WidgetUserSheet.access$getViewModel$p(this.this$0);
        Context context = this.this$0.getContext();
        TextInputLayout textInputLayout = WidgetUserSheet.access$getBinding$p(this.this$0).B;
        m.checkNotNullExpressionValue(textInputLayout, "binding.userSheetNoteTextFieldWrap");
        widgetUserSheetViewModelAccess$getViewModel$p.saveUserNote(context, ViewExtensions.getTextOrEmpty(textInputLayout));
        WidgetUserSheet.access$getBinding$p(this.this$0).B.clearFocus();
        this.this$0.hideKeyboard(this.$view);
    }
}
