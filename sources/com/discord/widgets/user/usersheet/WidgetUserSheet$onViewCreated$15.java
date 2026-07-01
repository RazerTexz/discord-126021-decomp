package com.discord.widgets.user.usersheet;

import android.content.Context;
import android.view.View;
import android.view.View$OnFocusChangeListener;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetUserSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheet$onViewCreated$15 implements View$OnFocusChangeListener {
    public final /* synthetic */ WidgetUserSheet this$0;

    public WidgetUserSheet$onViewCreated$15(WidgetUserSheet widgetUserSheet) {
        this.this$0 = widgetUserSheet;
    }

    @Override // android.view.View$OnFocusChangeListener
    public final void onFocusChange(View view, boolean z2) {
        if (z2) {
            return;
        }
        WidgetUserSheetViewModel widgetUserSheetViewModelAccess$getViewModel$p = WidgetUserSheet.access$getViewModel$p(this.this$0);
        Context context = this.this$0.getContext();
        TextInputLayout textInputLayout = WidgetUserSheet.access$getBinding$p(this.this$0).B;
        m.checkNotNullExpressionValue(textInputLayout, "binding.userSheetNoteTextFieldWrap");
        widgetUserSheetViewModelAccess$getViewModel$p.saveUserNote(context, ViewExtensions.getTextOrEmpty(textInputLayout));
    }
}
