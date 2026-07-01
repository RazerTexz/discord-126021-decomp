package com.discord.widgets.contact_sync;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: ContactSyncPermissionsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContactSyncPermissionsSheet$configureUI$2 implements View$OnClickListener {
    public final /* synthetic */ boolean $discoverable;
    public final /* synthetic */ ContactSyncPermissionsSheet this$0;

    public ContactSyncPermissionsSheet$configureUI$2(ContactSyncPermissionsSheet contactSyncPermissionsSheet, boolean z2) {
        this.this$0 = contactSyncPermissionsSheet;
        this.$discoverable = z2;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetContactSyncViewModel widgetContactSyncViewModelAccess$getViewModel$p = ContactSyncPermissionsSheet.access$getViewModel$p(this.this$0);
        boolean z2 = this.$discoverable;
        widgetContactSyncViewModelAccess$getViewModel$p.onPermissionsToggle(!z2, !z2);
    }
}
