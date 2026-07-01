package com.discord.widgets.contact_sync;

import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ContactSyncPermissionsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContactSyncPermissionsSheet$Companion {
    private ContactSyncPermissionsSheet$Companion() {
    }

    public final ContactSyncPermissionsSheet show(FragmentManager fragmentManager) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        ContactSyncPermissionsSheet contactSyncPermissionsSheet = new ContactSyncPermissionsSheet();
        contactSyncPermissionsSheet.show(fragmentManager, ContactSyncPermissionsSheet.class.getSimpleName());
        return contactSyncPermissionsSheet;
    }

    public /* synthetic */ ContactSyncPermissionsSheet$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
