package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Iterator;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p330i.p332b.C4120n;
import p007b.p225i.p226a.p288f.p330i.p332b.C4131o;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzap extends AbstractSafeParcelable implements Iterable<String> {
    public static final Parcelable.Creator<zzap> CREATOR = new C4131o();

    /* JADX INFO: renamed from: j */
    public final Bundle f20665j;

    public zzap(Bundle bundle) {
        this.f20665j = bundle;
    }

    /* JADX INFO: renamed from: A0 */
    public final String m9112A0(String str) {
        return this.f20665j.getString(str);
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return new C4120n(this);
    }

    public final String toString() {
        return this.f20665j.toString();
    }

    /* JADX INFO: renamed from: w0 */
    public final Object m9113w0(String str) {
        return this.f20665j.get(str);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        C1460d.m558p2(parcel, 2, m9114x0(), false);
        C1460d.m418A2(parcel, iM594y2);
    }

    /* JADX INFO: renamed from: x0 */
    public final Bundle m9114x0() {
        return new Bundle(this.f20665j);
    }

    /* JADX INFO: renamed from: y0 */
    public final Long m9115y0(String str) {
        return Long.valueOf(this.f20665j.getLong(str));
    }

    /* JADX INFO: renamed from: z0 */
    public final Double m9116z0(String str) {
        return Double.valueOf(this.f20665j.getDouble(str));
    }
}
