package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class GoogleSignInOptions$a {
    public Set<Scope> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3001b;
    public boolean c;
    public boolean d;

    @Nullable
    public String e;

    @Nullable
    public Account f;

    @Nullable
    public String g;
    public Map<Integer, GoogleSignInOptionsExtensionParcelable> h;

    @Nullable
    public String i;

    public GoogleSignInOptions$a() {
        this.a = new HashSet();
        this.h = new HashMap();
    }

    public final GoogleSignInOptions a() {
        if (this.a.contains(GoogleSignInOptions.m)) {
            Set<Scope> set = this.a;
            Scope scope = GoogleSignInOptions.l;
            if (set.contains(scope)) {
                this.a.remove(scope);
            }
        }
        if (this.d && (this.f == null || !this.a.isEmpty())) {
            this.a.add(GoogleSignInOptions.k);
        }
        return new GoogleSignInOptions(3, new ArrayList(this.a), this.f, this.d, this.f3001b, this.c, this.e, this.g, this.h, this.i);
    }

    public GoogleSignInOptions$a(@NonNull GoogleSignInOptions googleSignInOptions) {
        this.a = new HashSet();
        this.h = new HashMap();
        this.a = new HashSet(googleSignInOptions.q);
        this.f3001b = googleSignInOptions.t;
        this.c = googleSignInOptions.u;
        this.d = googleSignInOptions.f2997s;
        this.e = googleSignInOptions.v;
        this.f = googleSignInOptions.r;
        this.g = googleSignInOptions.w;
        this.h = GoogleSignInOptions.y0(googleSignInOptions.f2998x);
        this.i = googleSignInOptions.f2999y;
    }
}
