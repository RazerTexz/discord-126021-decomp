package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p300h.InterfaceC3273h;
import p007b.p225i.p226a.p288f.p337l.p338b.C4343h;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zag extends AbstractSafeParcelable implements InterfaceC3273h {
    public static final Parcelable.Creator<zag> CREATOR = new C4343h();

    /* JADX INFO: renamed from: j */
    public final List<String> f20837j;

    /* JADX INFO: renamed from: k */
    @Nullable
    public final String f20838k;

    public zag(List<String> list, @Nullable String str) {
        this.f20837j = list;
        this.f20838k = str;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p300h.InterfaceC3273h
    /* JADX INFO: renamed from: b0 */
    public final Status mo4053b0() {
        return this.f20838k != null ? Status.f20489j : Status.f20493n;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        List<String> list = this.f20837j;
        if (list != null) {
            int iM594y3 = C1460d.m594y2(parcel, 1);
            parcel.writeStringList(list);
            C1460d.m418A2(parcel, iM594y3);
        }
        C1460d.m574t2(parcel, 2, this.f20838k, false);
        C1460d.m418A2(parcel, iM594y2);
    }
}
