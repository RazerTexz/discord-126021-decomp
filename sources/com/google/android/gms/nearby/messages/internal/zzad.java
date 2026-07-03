package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p333j.p334b.p335e.C4276d;

/* JADX INFO: loaded from: classes3.dex */
public final class zzad extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzad> CREATOR = new C4276d();

    /* JADX INFO: renamed from: j */
    public final int f20774j;

    /* JADX INFO: renamed from: k */
    @Nullable
    public final String f20775k;

    /* JADX INFO: renamed from: l */
    @Nullable
    public final String f20776l;

    public zzad(int i, @Nullable String str, @Nullable String str2) {
        this.f20774j = i;
        this.f20775k = str;
        this.f20776l = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof zzad) && hashCode() == obj.hashCode()) {
            zzad zzadVar = (zzad) obj;
            if (C1460d.m524h0(this.f20775k, zzadVar.f20775k) && C1460d.m524h0(this.f20776l, zzadVar.f20776l)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f20775k, this.f20776l});
    }

    public final String toString() {
        String str = this.f20775k;
        String str2 = this.f20776l;
        return C1643a.m861l(C1643a.m841b(str2, C1643a.m841b(str, 17)), "namespace=", str, ", type=", str2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        C1460d.m574t2(parcel, 1, this.f20775k, false);
        C1460d.m574t2(parcel, 2, this.f20776l, false);
        int i2 = this.f20774j;
        parcel.writeInt(263144);
        parcel.writeInt(i2);
        C1460d.m418A2(parcel, iM594y2);
    }
}
