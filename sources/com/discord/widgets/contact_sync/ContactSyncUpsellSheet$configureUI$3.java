package com.discord.widgets.contact_sync;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: ContactSyncUpsellSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContactSyncUpsellSheet$configureUI$3 implements View$OnClickListener {
    public final /* synthetic */ ContactSyncUpsellSheet this$0;

    public ContactSyncUpsellSheet$configureUI$3(ContactSyncUpsellSheet contactSyncUpsellSheet) {
        this.this$0 = contactSyncUpsellSheet;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ContactSyncUpsellSheet.access$getViewModel$p(this.this$0).skip();
        this.this$0.dismiss();
    }
}
