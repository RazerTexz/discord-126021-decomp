package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import androidx.annotation.Nullable;
import b.c.a.a0.d;
import b.i.a.f.e.k.w;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zas extends AbstractSafeParcelable {
    public static final Parcelable$Creator<zas> CREATOR = new w();
    public final int j;
    public final Account k;
    public final int l;

    @Nullable
    public final GoogleSignInAccount m;

    public zas(int i, Account account, int i2, @Nullable GoogleSignInAccount googleSignInAccount) {
        this.j = i;
        this.k = account;
        this.l = i2;
        this.m = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iY2 = d.y2(parcel, 20293);
        int i2 = this.j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        d.s2(parcel, 2, this.k, i, false);
        int i3 = this.l;
        parcel.writeInt(262147);
        parcel.writeInt(i3);
        d.s2(parcel, 4, this.m, i, false);
        d.A2(parcel, iY2);
    }

    public zas(Account account, int i, @Nullable GoogleSignInAccount googleSignInAccount) {
        this.j = 2;
        this.k = account;
        this.l = i;
        this.m = googleSignInAccount;
    }
}
