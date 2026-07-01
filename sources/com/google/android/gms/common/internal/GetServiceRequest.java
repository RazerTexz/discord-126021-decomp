package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import b.i.a.f.e.c;
import b.i.a.f.e.k.a;
import b.i.a.f.e.k.g;
import b.i.a.f.e.k.p0;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class GetServiceRequest extends AbstractSafeParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new p0();
    public final int j;
    public final int k;
    public int l;
    public String m;
    public IBinder n;
    public Scope[] o;
    public Bundle p;

    @Nullable
    public Account q;
    public Feature[] r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Feature[] f3005s;
    public boolean t;
    public int u;
    public boolean v;

    @Nullable
    public final String w;

    public GetServiceRequest(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, Feature[] featureArr, Feature[] featureArr2, boolean z2, int i4, boolean z3, @Nullable String str2) {
        this.j = i;
        this.k = i2;
        this.l = i3;
        if ("com.google.android.gms".equals(str)) {
            this.m = "com.google.android.gms";
        } else {
            this.m = str;
        }
        if (i < 2) {
            Account accountB = null;
            if (iBinder != null) {
                g gVarG = g.a.g(iBinder);
                int i5 = a.a;
                if (gVarG != null) {
                    long jClearCallingIdentity = Binder.clearCallingIdentity();
                    try {
                        try {
                            accountB = gVarG.b();
                        } catch (RemoteException unused) {
                            Log.w("AccountAccessor", "Remote account accessor probably died");
                        }
                        Binder.restoreCallingIdentity(jClearCallingIdentity);
                    } catch (Throwable th) {
                        Binder.restoreCallingIdentity(jClearCallingIdentity);
                        throw th;
                    }
                }
            }
            this.q = accountB;
        } else {
            this.n = iBinder;
            this.q = account;
        }
        this.o = scopeArr;
        this.p = bundle;
        this.r = featureArr;
        this.f3005s = featureArr2;
        this.t = z2;
        this.u = i4;
        this.v = z3;
        this.w = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        p0.a(this, parcel, i);
    }

    public GetServiceRequest(int i, @Nullable String str) {
        this.j = 6;
        this.l = c.a;
        this.k = i;
        this.t = true;
        this.w = null;
    }
}
