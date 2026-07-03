package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p300h.InterfaceC3273h;
import p007b.p225i.p226a.p288f.p313h.p324k.C3573r;

/* JADX INFO: compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzo extends AbstractSafeParcelable implements InterfaceC3273h {
    public static final Parcelable.Creator<zzo> CREATOR = new C3573r();

    /* JADX INFO: renamed from: j */
    public Status f20599j;

    /* JADX INFO: renamed from: k */
    public List<zzw> f20600k;

    /* JADX INFO: renamed from: l */
    @Deprecated
    public String[] f20601l;

    public zzo() {
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.InterfaceC3273h
    /* JADX INFO: renamed from: b0 */
    public final Status mo4053b0() {
        return this.f20599j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        C1460d.m570s2(parcel, 1, this.f20599j, i, false);
        C1460d.m586w2(parcel, 2, this.f20600k, false);
        C1460d.m578u2(parcel, 3, this.f20601l, false);
        C1460d.m418A2(parcel, iM594y2);
    }

    public zzo(Status status, List<zzw> list, String[] strArr) {
        this.f20599j = status;
        this.f20600k = list;
        this.f20601l = strArr;
    }
}
