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
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p225i.p226a.p288f.p299e.C3256c;
import p007b.p225i.p226a.p288f.p299e.p304k.BinderC3343a;
import p007b.p225i.p226a.p288f.p299e.p304k.C3374p0;
import p007b.p225i.p226a.p288f.p299e.p304k.InterfaceC3355g;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class GetServiceRequest extends AbstractSafeParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new C3374p0();

    /* JADX INFO: renamed from: j */
    public final int f20527j;

    /* JADX INFO: renamed from: k */
    public final int f20528k;

    /* JADX INFO: renamed from: l */
    public int f20529l;

    /* JADX INFO: renamed from: m */
    public String f20530m;

    /* JADX INFO: renamed from: n */
    public IBinder f20531n;

    /* JADX INFO: renamed from: o */
    public Scope[] f20532o;

    /* JADX INFO: renamed from: p */
    public Bundle f20533p;

    /* JADX INFO: renamed from: q */
    @Nullable
    public Account f20534q;

    /* JADX INFO: renamed from: r */
    public Feature[] f20535r;

    /* JADX INFO: renamed from: s */
    public Feature[] f20536s;

    /* JADX INFO: renamed from: t */
    public boolean f20537t;

    /* JADX INFO: renamed from: u */
    public int f20538u;

    /* JADX INFO: renamed from: v */
    public boolean f20539v;

    /* JADX INFO: renamed from: w */
    @Nullable
    public final String f20540w;

    public GetServiceRequest(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, Feature[] featureArr, Feature[] featureArr2, boolean z2, int i4, boolean z3, @Nullable String str2) {
        this.f20527j = i;
        this.f20528k = i2;
        this.f20529l = i3;
        if ("com.google.android.gms".equals(str)) {
            this.f20530m = "com.google.android.gms";
        } else {
            this.f20530m = str;
        }
        if (i < 2) {
            Account accountMo4156b = null;
            if (iBinder != null) {
                InterfaceC3355g interfaceC3355gM4157g = InterfaceC3355g.a.m4157g(iBinder);
                int i5 = BinderC3343a.f9475a;
                if (interfaceC3355gM4157g != null) {
                    long jClearCallingIdentity = Binder.clearCallingIdentity();
                    try {
                        try {
                            accountMo4156b = interfaceC3355gM4157g.mo4156b();
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
            this.f20534q = accountMo4156b;
        } else {
            this.f20531n = iBinder;
            this.f20534q = account;
        }
        this.f20532o = scopeArr;
        this.f20533p = bundle;
        this.f20535r = featureArr;
        this.f20536s = featureArr2;
        this.f20537t = z2;
        this.f20538u = i4;
        this.f20539v = z3;
        this.f20540w = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        C3374p0.m4174a(this, parcel, i);
    }

    public GetServiceRequest(int i, @Nullable String str) {
        this.f20527j = 6;
        this.f20529l = C3256c.f9306a;
        this.f20528k = i;
        this.f20537t = true;
        this.f20540w = null;
    }
}
