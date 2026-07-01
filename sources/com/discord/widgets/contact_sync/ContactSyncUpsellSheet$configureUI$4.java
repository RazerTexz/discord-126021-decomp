package com.discord.widgets.contact_sync;

import android.view.View;
import android.view.View$OnClickListener;
import b.d.b.a.a;

/* JADX INFO: compiled from: ContactSyncUpsellSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContactSyncUpsellSheet$configureUI$4 implements View$OnClickListener {
    public final /* synthetic */ WidgetContactSyncViewModel$ViewState $viewState;
    public final /* synthetic */ ContactSyncUpsellSheet this$0;

    public ContactSyncUpsellSheet$configureUI$4(ContactSyncUpsellSheet contactSyncUpsellSheet, WidgetContactSyncViewModel$ViewState widgetContactSyncViewModel$ViewState) {
        this.this$0 = contactSyncUpsellSheet;
        this.$viewState = widgetContactSyncViewModel$ViewState;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.this$0.dismiss();
        WidgetContactSync$Companion.launch$default(WidgetContactSync.Companion, a.x(view, "it", "it.context"), null, true, this.$viewState.getAllowPhone(), this.$viewState.getAllowEmail(), 2, null);
    }
}
