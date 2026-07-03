package com.discord.utilities.contacts;

import android.content.Context;
import java.util.Set;
import p507d0.p580t.C12148n0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ContactsFetcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContactsFetcher {
    private final Context context;

    public ContactsFetcher(Context context) {
        C12238m.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final Set<String> fetchContacts() {
        ContactsProviderUtils contactsProviderUtils = ContactsProviderUtils.INSTANCE;
        return !contactsProviderUtils.hasContactPermissions(this.context) ? C12148n0.emptySet() : contactsProviderUtils.getAllContactPhoneNumbers(this.context);
    }

    public final Context getContext() {
        return this.context;
    }
}
