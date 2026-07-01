package com.discord.widgets.guildcommunicationdisabled.start;

import android.view.View;
import android.view.View$OnFocusChangeListener;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetDisableGuildCommunication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDisableGuildCommunication$configureUI$$inlined$apply$lambda$1 implements View$OnFocusChangeListener {
    public final /* synthetic */ WidgetDisableGuildCommunication this$0;

    public WidgetDisableGuildCommunication$configureUI$$inlined$apply$lambda$1(WidgetDisableGuildCommunication widgetDisableGuildCommunication) {
        this.this$0 = widgetDisableGuildCommunication;
    }

    @Override // android.view.View$OnFocusChangeListener
    public final void onFocusChange(View view, boolean z2) {
        if (!z2) {
            WidgetDisableGuildCommunication.access$getBinding$p(this.this$0).d.setHint(2131889994);
            return;
        }
        TextInputLayout textInputLayout = WidgetDisableGuildCommunication.access$getBinding$p(this.this$0).d;
        m.checkNotNullExpressionValue(textInputLayout, "binding.disableGuildCommunicationReason");
        textInputLayout.setHint("");
    }
}
