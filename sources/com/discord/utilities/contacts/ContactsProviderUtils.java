package com.discord.utilities.contacts;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import androidx.core.content.ContextCompat;
import d0.z.d.Intrinsics3;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: ContactsProviderUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContactsProviderUtils {
    private static final String CONTACTS_PERMISSION = "android.permission.READ_CONTACTS";
    public static final ContactsProviderUtils INSTANCE = new ContactsProviderUtils();

    private ContactsProviderUtils() {
    }

    public final Set<String> getAllContactPhoneNumbers(Context ctx) {
        Intrinsics3.checkNotNullParameter(ctx, "ctx");
        ContentResolver contentResolver = ctx.getContentResolver();
        HashSet hashSet = new HashSet();
        Cursor cursorQuery = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("data4"));
                if (string != null) {
                    hashSet.add(string);
                }
            }
            cursorQuery.close();
        }
        return hashSet;
    }

    public final String getOwnName(Context ctx, String number) {
        Intrinsics3.checkNotNullParameter(ctx, "ctx");
        Intrinsics3.checkNotNullParameter(number, "number");
        ContentResolver contentResolver = ctx.getContentResolver();
        Uri uriWithAppendedPath = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(number));
        Intrinsics3.checkNotNullExpressionValue(uriWithAppendedPath, "Uri.withAppendedPath(Pho…_URI, Uri.encode(number))");
        Cursor cursorQuery = contentResolver.query(uriWithAppendedPath, new String[]{"display_name"}, null, null, null);
        if (cursorQuery != null) {
            Intrinsics3.checkNotNullExpressionValue(cursorQuery, "contentResolver.query(ur…ull, null) ?: return null");
            while (cursorQuery.moveToNext()) {
                String string = cursorQuery.getString(0);
                if (string != null) {
                    return string;
                }
            }
            cursorQuery.close();
        }
        return null;
    }

    public final boolean hasContactPermissions(Context ctx) {
        Intrinsics3.checkNotNullParameter(ctx, "ctx");
        return ContextCompat.checkSelfPermission(ctx, CONTACTS_PERMISSION) == 0;
    }
}
