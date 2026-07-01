package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.Nullable;
import b.c.a.a0.d;
import b.i.a.f.e.h.h;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zag extends AbstractSafeParcelable implements h {
    public static final Parcelable$Creator<zag> CREATOR = new b.i.a.f.l.b.h();
    public final List<String> j;

    @Nullable
    public final String k;

    public zag(List<String> list, @Nullable String str) {
        this.j = list;
        this.k = str;
    }

    @Override // b.i.a.f.e.h.h
    public final Status b0() {
        return this.k != null ? Status.j : Status.n;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = d.y2(parcel, 20293);
        List<String> list = this.j;
        if (list != null) {
            int iY3 = d.y2(parcel, 1);
            parcel.writeStringList(list);
            d.A2(parcel, iY3);
        }
        d.t2(parcel, 2, this.k, false);
        d.A2(parcel, iY2);
    }
}
