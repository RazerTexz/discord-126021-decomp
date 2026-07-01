package com.discord.utilities.contacts;

import android.content.Context;
import d0.t.n0;
import d0.z.d.m;
import java.util.Set;

/* JADX INFO: compiled from: ContactsFetcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContactsFetcher {
    private final Context context;

    public ContactsFetcher(Context context) {
        m.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final Set<String> fetchContacts() {
        ContactsProviderUtils contactsProviderUtils = ContactsProviderUtils.INSTANCE;
        return !contactsProviderUtils.hasContactPermissions(this.context) ? n0.emptySet() : contactsProviderUtils.getAllContactPhoneNumbers(this.context);
    }

    public final Context getContext() {
        return this.context;
    }
}
