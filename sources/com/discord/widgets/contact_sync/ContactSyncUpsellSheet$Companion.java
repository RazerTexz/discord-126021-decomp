package com.discord.widgets.contact_sync;

import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ContactSyncUpsellSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContactSyncUpsellSheet$Companion {
    private ContactSyncUpsellSheet$Companion() {
    }

    public final ContactSyncUpsellSheet show(FragmentManager fragmentManager) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        ContactSyncUpsellSheet contactSyncUpsellSheet = new ContactSyncUpsellSheet();
        contactSyncUpsellSheet.show(fragmentManager, ContactSyncUpsellSheet.class.getSimpleName());
        return contactSyncUpsellSheet;
    }

    public /* synthetic */ ContactSyncUpsellSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
