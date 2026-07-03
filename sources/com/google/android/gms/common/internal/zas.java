package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p304k.C3387w;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zas extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zas> CREATOR = new C3387w();

    /* JADX INFO: renamed from: j */
    public final int f20546j;

    /* JADX INFO: renamed from: k */
    public final Account f20547k;

    /* JADX INFO: renamed from: l */
    public final int f20548l;

    /* JADX INFO: renamed from: m */
    @Nullable
    public final GoogleSignInAccount f20549m;

    public zas(int i, Account account, int i2, @Nullable GoogleSignInAccount googleSignInAccount) {
        this.f20546j = i;
        this.f20547k = account;
        this.f20548l = i2;
        this.f20549m = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        int i2 = this.f20546j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        C1460d.m570s2(parcel, 2, this.f20547k, i, false);
        int i3 = this.f20548l;
        parcel.writeInt(262147);
        parcel.writeInt(i3);
        C1460d.m570s2(parcel, 4, this.f20549m, i, false);
        C1460d.m418A2(parcel, iM594y2);
    }

    public zas(Account account, int i, @Nullable GoogleSignInAccount googleSignInAccount) {
        this.f20546j = 2;
        this.f20547k = account;
        this.f20548l = i;
        this.f20549m = googleSignInAccount;
    }
}
