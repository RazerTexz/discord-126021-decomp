package com.google.firebase.appindexing.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.c.k.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zza extends AbstractSafeParcelable implements a {
    public static final Parcelable.Creator<zza> CREATOR = new b.i.c.k.d.a();
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final zzc n;
    public final String o;
    public final Bundle p;

    public zza(String str, String str2, String str3, String str4, zzc zzcVar, String str5, Bundle bundle) {
        this.j = str;
        this.k = str2;
        this.l = str3;
        this.m = str4;
        this.n = zzcVar;
        this.o = str5;
        if (bundle != null) {
            this.p = bundle;
        } else {
            this.p = Bundle.EMPTY;
        }
        this.p.setClassLoader(zza.class.getClassLoader());
    }

    public final String toString() {
        StringBuilder sbX = outline.X("ActionImpl { ", "{ actionType: '");
        sbX.append(this.j);
        sbX.append("' } ");
        sbX.append("{ objectName: '");
        sbX.append(this.k);
        sbX.append("' } ");
        sbX.append("{ objectUrl: '");
        sbX.append(this.l);
        sbX.append("' } ");
        if (this.m != null) {
            sbX.append("{ objectSameAs: '");
            sbX.append(this.m);
            sbX.append("' } ");
        }
        if (this.n != null) {
            sbX.append("{ metadata: '");
            sbX.append(this.n.toString());
            sbX.append("' } ");
        }
        if (this.o != null) {
            sbX.append("{ actionStatus: '");
            sbX.append(this.o);
            sbX.append("' } ");
        }
        if (!this.p.isEmpty()) {
            sbX.append("{ ");
            sbX.append(this.p);
            sbX.append(" } ");
        }
        sbX.append("}");
        return sbX.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        AnimatableValueParser.t2(parcel, 1, this.j, false);
        AnimatableValueParser.t2(parcel, 2, this.k, false);
        AnimatableValueParser.t2(parcel, 3, this.l, false);
        AnimatableValueParser.t2(parcel, 4, this.m, false);
        AnimatableValueParser.s2(parcel, 5, this.n, i, false);
        AnimatableValueParser.t2(parcel, 6, this.o, false);
        AnimatableValueParser.p2(parcel, 7, this.p, false);
        AnimatableValueParser.A2(parcel, iY2);
    }
}
