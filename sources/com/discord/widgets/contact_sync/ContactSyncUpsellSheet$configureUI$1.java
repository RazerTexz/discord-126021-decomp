package com.discord.widgets.contact_sync;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: ContactSyncUpsellSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContactSyncUpsellSheet$configureUI$1 implements View$OnClickListener {
    public final /* synthetic */ boolean $discoverable;
    public final /* synthetic */ ContactSyncUpsellSheet this$0;

    public ContactSyncUpsellSheet$configureUI$1(ContactSyncUpsellSheet contactSyncUpsellSheet, boolean z2) {
        this.this$0 = contactSyncUpsellSheet;
        this.$discoverable = z2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetContactSyncViewModel widgetContactSyncViewModelAccess$getViewModel$p = ContactSyncUpsellSheet.access$getViewModel$p(this.this$0);
        boolean z2 = this.$discoverable;
        widgetContactSyncViewModelAccess$getViewModel$p.onPermissionsToggle(!z2, !z2);
    }
}
