package com.discord.widgets.contact_sync;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: ContactSyncPermissionsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContactSyncPermissionsSheet$configureUI$3 implements View$OnClickListener {
    public final /* synthetic */ WidgetContactSyncViewModel$ViewState $viewState;
    public final /* synthetic */ ContactSyncPermissionsSheet this$0;

    public ContactSyncPermissionsSheet$configureUI$3(ContactSyncPermissionsSheet contactSyncPermissionsSheet, WidgetContactSyncViewModel$ViewState widgetContactSyncViewModel$ViewState) {
        this.this$0 = contactSyncPermissionsSheet;
        this.$viewState = widgetContactSyncViewModel$ViewState;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ContactSyncPermissionsSheet.access$getViewModel$p(this.this$0).onPermissionsToggle(!this.$viewState.getAllowPhone(), this.$viewState.getAllowEmail());
    }
}
