package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class Credential$a {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public String f2995b;

    @Nullable
    public Uri c;

    @Nullable
    public String d;

    public Credential$a(String str) {
        this.a = str;
    }

    public Credential a() {
        return new Credential(this.a, this.f2995b, this.c, null, this.d, null, null, null);
    }
}
