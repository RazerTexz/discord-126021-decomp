package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import b.c.a.a0.d;
import b.i.a.f.e.k.o0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class ConnectionTelemetryConfiguration extends AbstractSafeParcelable {

    @RecentlyNonNull
    public static final Parcelable$Creator<ConnectionTelemetryConfiguration> CREATOR = new o0();
    public final RootTelemetryConfiguration j;
    public final boolean k;
    public final boolean l;

    @Nullable
    public final int[] m;
    public final int n;

    @Nullable
    public final int[] o;

    public ConnectionTelemetryConfiguration(@RecentlyNonNull RootTelemetryConfiguration rootTelemetryConfiguration, boolean z2, boolean z3, @Nullable int[] iArr, int i, @Nullable int[] iArr2) {
        this.j = rootTelemetryConfiguration;
        this.k = z2;
        this.l = z3;
        this.m = iArr;
        this.n = i;
        this.o = iArr2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@RecentlyNonNull Parcel parcel, int i) {
        int iY2 = d.y2(parcel, 20293);
        d.s2(parcel, 1, this.j, i, false);
        boolean z2 = this.k;
        parcel.writeInt(262146);
        parcel.writeInt(z2 ? 1 : 0);
        boolean z3 = this.l;
        parcel.writeInt(262147);
        parcel.writeInt(z3 ? 1 : 0);
        int[] iArr = this.m;
        if (iArr != null) {
            int iY3 = d.y2(parcel, 4);
            parcel.writeIntArray(iArr);
            d.A2(parcel, iY3);
        }
        int i2 = this.n;
        parcel.writeInt(262149);
        parcel.writeInt(i2);
        int[] iArr2 = this.o;
        if (iArr2 != null) {
            int iY4 = d.y2(parcel, 6);
            parcel.writeIntArray(iArr2);
            d.A2(parcel, iY4);
        }
        d.A2(parcel, iY2);
    }
}
