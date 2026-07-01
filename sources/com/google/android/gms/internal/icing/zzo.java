package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.e.h.h;
import b.i.a.f.h.k.r;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzo extends AbstractSafeParcelable implements h {
    public static final Parcelable.Creator<zzo> CREATOR = new r();
    public Status j;
    public List<zzw> k;

    @Deprecated
    public String[] l;

    public zzo() {
    }

    @Override // b.i.a.f.e.h.h
    public final Status b0() {
        return this.j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        AnimatableValueParser.s2(parcel, 1, this.j, i, false);
        AnimatableValueParser.w2(parcel, 2, this.k, false);
        AnimatableValueParser.u2(parcel, 3, this.l, false);
        AnimatableValueParser.A2(parcel, iY2);
    }

    public zzo(Status status, List<zzw> list, String[] strArr) {
        this.j = status;
        this.k = list;
        this.l = strArr;
    }
}
