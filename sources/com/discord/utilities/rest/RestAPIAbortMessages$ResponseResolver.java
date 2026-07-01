package com.discord.utilities.rest;

import android.content.Context;
import b.a.k.b;
import d0.z.d.m;

/* JADX INFO: compiled from: RestAPIAbortMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestAPIAbortMessages$ResponseResolver {
    public static final RestAPIAbortMessages$ResponseResolver INSTANCE = new RestAPIAbortMessages$ResponseResolver();

    private RestAPIAbortMessages$ResponseResolver() {
    }

    public final CharSequence getRelationshipResponse(Context context, int abortCode, String username) {
        m.checkNotNullParameter(username, "username");
        Integer abortCodeMessageResId = RestAPIAbortMessages.getAbortCodeMessageResId(abortCode);
        int iIntValue = abortCodeMessageResId != null ? abortCodeMessageResId.intValue() : 2131886334;
        if (abortCode != 80000) {
            if (context != null) {
                return b.h(context, iIntValue, new Object[0], null, 4);
            }
            return null;
        }
        if (context != null) {
            return b.h(context, iIntValue, new Object[]{username}, null, 4);
        }
        return null;
    }
}
