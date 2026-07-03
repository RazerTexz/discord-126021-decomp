package com.google.firebase;

import androidx.annotation.RecentlyNonNull;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class FirebaseException extends Exception {
    @Deprecated
    public FirebaseException() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FirebaseException(@RecentlyNonNull String str) {
        super(str);
        C1460d.m579v(str, "Detail message must not be empty");
    }
}
