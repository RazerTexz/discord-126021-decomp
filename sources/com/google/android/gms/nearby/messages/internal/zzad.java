package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.Nullable;
import b.d.b.a.a;
import b.i.a.f.j.b.e.d;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class zzad extends AbstractSafeParcelable {
    public static final Parcelable$Creator<zzad> CREATOR = new d();
    public final int j;

    @Nullable
    public final String k;

    @Nullable
    public final String l;

    public zzad(int i, @Nullable String str, @Nullable String str2) {
        this.j = i;
        this.k = str;
        this.l = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof zzad) && hashCode() == obj.hashCode()) {
            zzad zzadVar = (zzad) obj;
            if (b.c.a.a0.d.h0(this.k, zzadVar.k) && b.c.a.a0.d.h0(this.l, zzadVar.l)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.k, this.l});
    }

    public final String toString() {
        String str = this.k;
        String str2 = this.l;
        return a.l(a.b(str2, a.b(str, 17)), "namespace=", str, ", type=", str2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = b.c.a.a0.d.y2(parcel, 20293);
        b.c.a.a0.d.t2(parcel, 1, this.k, false);
        b.c.a.a0.d.t2(parcel, 2, this.l, false);
        int i2 = this.j;
        parcel.writeInt(263144);
        parcel.writeInt(i2);
        b.c.a.a0.d.A2(parcel, iY2);
    }
}
