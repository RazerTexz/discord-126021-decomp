package com.discord.widgets.contact_sync;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetContactSync.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetContactSync$configureUI$5 implements View$OnClickListener {
    public final /* synthetic */ WidgetContactSync this$0;

    public WidgetContactSync$configureUI$5(WidgetContactSync widgetContactSync) {
        this.this$0 = widgetContactSync;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetContactSyncViewModel widgetContactSyncViewModelAccess$getViewModel$p = WidgetContactSync.access$getViewModel$p(this.this$0);
        TextInputLayout textInputLayout = WidgetContactSync.access$getBinding$p(this.this$0).f.c;
        m.checkNotNullExpressionValue(textInputLayout, "binding.contactSyncName.contactSyncNameInputWrap");
        widgetContactSyncViewModelAccess$getViewModel$p.onNameSubmitted(ViewExtensions.getTextOrEmpty(textInputLayout));
    }
}
