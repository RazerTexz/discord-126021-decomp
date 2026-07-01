package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.f.j.b.e.d;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class zzad extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzad> CREATOR = new d();
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
            if (AnimatableValueParser.h0(this.k, zzadVar.k) && AnimatableValueParser.h0(this.l, zzadVar.l)) {
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
        return outline.l(outline.b(str2, outline.b(str, 17)), "namespace=", str, ", type=", str2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        AnimatableValueParser.t2(parcel, 1, this.k, false);
        AnimatableValueParser.t2(parcel, 2, this.l, false);
        int i2 = this.j;
        parcel.writeInt(263144);
        parcel.writeInt(i2);
        AnimatableValueParser.A2(parcel, iY2);
    }
}
