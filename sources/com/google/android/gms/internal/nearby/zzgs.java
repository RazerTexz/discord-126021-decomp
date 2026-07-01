package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.f.h.m.f;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class zzgs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgs> CREATOR = new f();
    public static final zzgs j = new zzgs(1, "", null);
    public final int k;
    public final String l;

    @Nullable
    public final String m;

    public zzgs(int i, @Nullable String str, @Nullable String str2) {
        Integer numValueOf = Integer.valueOf(i);
        Objects.requireNonNull(numValueOf, "null reference");
        this.k = numValueOf.intValue();
        this.l = str == null ? "" : str;
        this.m = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgs)) {
            return false;
        }
        zzgs zzgsVar = (zzgs) obj;
        return AnimatableValueParser.h0(this.l, zzgsVar.l) && AnimatableValueParser.h0(this.m, zzgsVar.m);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.l, this.m});
    }

    public final String toString() {
        String str = this.l;
        String str2 = this.m;
        StringBuilder sbS = outline.S(outline.b(str2, outline.b(str, 40)), "NearbyDevice{handle=", str, ", bluetoothAddress=", str2);
        sbS.append("}");
        return sbS.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        AnimatableValueParser.t2(parcel, 3, this.l, false);
        AnimatableValueParser.t2(parcel, 6, this.m, false);
        int i2 = this.k;
        parcel.writeInt(263144);
        parcel.writeInt(i2);
        AnimatableValueParser.A2(parcel, iY2);
    }
}
