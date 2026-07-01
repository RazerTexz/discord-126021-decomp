package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.Nullable;
import b.c.a.a0.d;
import b.i.a.f.c.a.d.g;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class CredentialRequest extends AbstractSafeParcelable {
    public static final Parcelable$Creator<CredentialRequest> CREATOR = new g();
    public final int j;
    public final boolean k;
    public final String[] l;
    public final CredentialPickerConfig m;
    public final CredentialPickerConfig n;
    public final boolean o;

    @Nullable
    public final String p;

    @Nullable
    public final String q;
    public final boolean r;

    public CredentialRequest(int i, boolean z2, String[] strArr, @Nullable CredentialPickerConfig credentialPickerConfig, @Nullable CredentialPickerConfig credentialPickerConfig2, boolean z3, @Nullable String str, @Nullable String str2, boolean z4) {
        this.j = i;
        this.k = z2;
        Objects.requireNonNull(strArr, "null reference");
        this.l = strArr;
        this.m = credentialPickerConfig == null ? new CredentialPickerConfig(2, false, true, false, 1) : credentialPickerConfig;
        this.n = credentialPickerConfig2 == null ? new CredentialPickerConfig(2, false, true, false, 1) : credentialPickerConfig2;
        if (i < 3) {
            this.o = true;
            this.p = null;
            this.q = null;
        } else {
            this.o = z3;
            this.p = str;
            this.q = str2;
        }
        this.r = z4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = d.y2(parcel, 20293);
        boolean z2 = this.k;
        parcel.writeInt(262145);
        parcel.writeInt(z2 ? 1 : 0);
        d.u2(parcel, 2, this.l, false);
        d.s2(parcel, 3, this.m, i, false);
        d.s2(parcel, 4, this.n, i, false);
        boolean z3 = this.o;
        parcel.writeInt(262149);
        parcel.writeInt(z3 ? 1 : 0);
        d.t2(parcel, 6, this.p, false);
        d.t2(parcel, 7, this.q, false);
        boolean z4 = this.r;
        parcel.writeInt(262152);
        parcel.writeInt(z4 ? 1 : 0);
        int i2 = this.j;
        parcel.writeInt(263144);
        parcel.writeInt(i2);
        d.A2(parcel, iY2);
    }
}
