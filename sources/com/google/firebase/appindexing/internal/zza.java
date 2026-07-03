package com.google.firebase.appindexing.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p361c.p365k.InterfaceC4560a;
import p007b.p225i.p361c.p365k.p367d.C4563a;

/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zza extends AbstractSafeParcelable implements InterfaceC4560a {
    public static final Parcelable.Creator<zza> CREATOR = new C4563a();

    /* JADX INFO: renamed from: j */
    public final String f21405j;

    /* JADX INFO: renamed from: k */
    public final String f21406k;

    /* JADX INFO: renamed from: l */
    public final String f21407l;

    /* JADX INFO: renamed from: m */
    public final String f21408m;

    /* JADX INFO: renamed from: n */
    public final zzc f21409n;

    /* JADX INFO: renamed from: o */
    public final String f21410o;

    /* JADX INFO: renamed from: p */
    public final Bundle f21411p;

    public zza(String str, String str2, String str3, String str4, zzc zzcVar, String str5, Bundle bundle) {
        this.f21405j = str;
        this.f21406k = str2;
        this.f21407l = str3;
        this.f21408m = str4;
        this.f21409n = zzcVar;
        this.f21410o = str5;
        if (bundle != null) {
            this.f21411p = bundle;
        } else {
            this.f21411p = Bundle.EMPTY;
        }
        this.f21411p.setClassLoader(zza.class.getClassLoader());
    }

    public final String toString() {
        StringBuilder sbM836X = C1643a.m836X("ActionImpl { ", "{ actionType: '");
        sbM836X.append(this.f21405j);
        sbM836X.append("' } ");
        sbM836X.append("{ objectName: '");
        sbM836X.append(this.f21406k);
        sbM836X.append("' } ");
        sbM836X.append("{ objectUrl: '");
        sbM836X.append(this.f21407l);
        sbM836X.append("' } ");
        if (this.f21408m != null) {
            sbM836X.append("{ objectSameAs: '");
            sbM836X.append(this.f21408m);
            sbM836X.append("' } ");
        }
        if (this.f21409n != null) {
            sbM836X.append("{ metadata: '");
            sbM836X.append(this.f21409n.toString());
            sbM836X.append("' } ");
        }
        if (this.f21410o != null) {
            sbM836X.append("{ actionStatus: '");
            sbM836X.append(this.f21410o);
            sbM836X.append("' } ");
        }
        if (!this.f21411p.isEmpty()) {
            sbM836X.append("{ ");
            sbM836X.append(this.f21411p);
            sbM836X.append(" } ");
        }
        sbM836X.append("}");
        return sbM836X.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        C1460d.m574t2(parcel, 1, this.f21405j, false);
        C1460d.m574t2(parcel, 2, this.f21406k, false);
        C1460d.m574t2(parcel, 3, this.f21407l, false);
        C1460d.m574t2(parcel, 4, this.f21408m, false);
        C1460d.m570s2(parcel, 5, this.f21409n, i, false);
        C1460d.m574t2(parcel, 6, this.f21410o, false);
        C1460d.m558p2(parcel, 7, this.f21411p, false);
        C1460d.m418A2(parcel, iM594y2);
    }
}
