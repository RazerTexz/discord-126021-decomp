package com.discord.widgets.guildcommunicationdisabled.start;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.m;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: WidgetDisableGuildCommunication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDisableGuildCommunication$configureUI$2 implements View$OnClickListener {
    public final /* synthetic */ DisableGuildCommunicationViewModel$ViewState $viewState;
    public final /* synthetic */ WidgetDisableGuildCommunication this$0;

    public WidgetDisableGuildCommunication$configureUI$2(WidgetDisableGuildCommunication widgetDisableGuildCommunication, DisableGuildCommunicationViewModel$ViewState disableGuildCommunicationViewModel$ViewState) {
        this.this$0 = widgetDisableGuildCommunication;
        this.$viewState = disableGuildCommunicationViewModel$ViewState;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WeakReference<Context> weakReference = new WeakReference<>(this.this$0.requireContext());
        DisableGuildCommunicationViewModel disableGuildCommunicationViewModelAccess$getViewModel$p = WidgetDisableGuildCommunication.access$getViewModel$p(this.this$0);
        TextInputLayout textInputLayout = WidgetDisableGuildCommunication.access$getBinding$p(this.this$0).d;
        m.checkNotNullExpressionValue(textInputLayout, "binding.disableGuildCommunicationReason");
        disableGuildCommunicationViewModelAccess$getViewModel$p.onDisableCommunicationConfirm(weakReference, ViewExtensions.getTextOrEmpty(textInputLayout), new WidgetDisableGuildCommunication$configureUI$2$1(this));
    }
}
