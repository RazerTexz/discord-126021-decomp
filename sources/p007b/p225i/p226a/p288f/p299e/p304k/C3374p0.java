package p007b.p225i.p226a.p288f.p299e.p304k;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.GetServiceRequest;
import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.e.k.p0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3374p0 implements Parcelable.Creator<GetServiceRequest> {
    /* JADX INFO: renamed from: a */
    public static void m4174a(GetServiceRequest getServiceRequest, Parcel parcel, int i) {
        int iM594y2 = C1460d.m594y2(parcel, 20293);
        int i2 = getServiceRequest.f20527j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        int i3 = getServiceRequest.f20528k;
        parcel.writeInt(262146);
        parcel.writeInt(i3);
        int i4 = getServiceRequest.f20529l;
        parcel.writeInt(262147);
        parcel.writeInt(i4);
        C1460d.m574t2(parcel, 4, getServiceRequest.f20530m, false);
        C1460d.m566r2(parcel, 5, getServiceRequest.f20531n, false);
        C1460d.m582v2(parcel, 6, getServiceRequest.f20532o, i, false);
        C1460d.m558p2(parcel, 7, getServiceRequest.f20533p, false);
        C1460d.m570s2(parcel, 8, getServiceRequest.f20534q, i, false);
        C1460d.m582v2(parcel, 10, getServiceRequest.f20535r, i, false);
        C1460d.m582v2(parcel, 11, getServiceRequest.f20536s, i, false);
        boolean z2 = getServiceRequest.f20537t;
        parcel.writeInt(262156);
        parcel.writeInt(z2 ? 1 : 0);
        int i5 = getServiceRequest.f20538u;
        parcel.writeInt(262157);
        parcel.writeInt(i5);
        boolean z3 = getServiceRequest.f20539v;
        parcel.writeInt(262158);
        parcel.writeInt(z3 ? 1 : 0);
        C1460d.m574t2(parcel, 15, getServiceRequest.f20540w, false);
        C1460d.m418A2(parcel, iM594y2);
    }

    @Override // android.os.Parcelable.Creator
    public final GetServiceRequest createFromParcel(Parcel parcel) {
        int iM546m2 = C1460d.m546m2(parcel);
        String strM468R = null;
        IBinder iBinderM434F1 = null;
        Scope[] scopeArr = null;
        Bundle bundleM453M = null;
        Account account = null;
        Feature[] featureArr = null;
        Feature[] featureArr2 = null;
        String strM468R2 = null;
        int iM437G1 = 0;
        int iM437G2 = 0;
        int iM437G3 = 0;
        boolean zM431E1 = false;
        int iM437G4 = 0;
        boolean zM431E2 = false;
        while (parcel.dataPosition() < iM546m2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    iM437G1 = C1460d.m437G1(parcel, i);
                    break;
                case 2:
                    iM437G2 = C1460d.m437G1(parcel, i);
                    break;
                case 3:
                    iM437G3 = C1460d.m437G1(parcel, i);
                    break;
                case 4:
                    strM468R = C1460d.m468R(parcel, i);
                    break;
                case 5:
                    iBinderM434F1 = C1460d.m434F1(parcel, i);
                    break;
                case 6:
                    scopeArr = (Scope[]) C1460d.m477U(parcel, i, Scope.CREATOR);
                    break;
                case 7:
                    bundleM453M = C1460d.m453M(parcel, i);
                    break;
                case '\b':
                    account = (Account) C1460d.m465Q(parcel, i, Account.CREATOR);
                    break;
                case '\t':
                default:
                    C1460d.m510d2(parcel, i);
                    break;
                case '\n':
                    featureArr = (Feature[]) C1460d.m477U(parcel, i, Feature.CREATOR);
                    break;
                case 11:
                    featureArr2 = (Feature[]) C1460d.m477U(parcel, i, Feature.CREATOR);
                    break;
                case '\f':
                    zM431E1 = C1460d.m431E1(parcel, i);
                    break;
                case '\r':
                    iM437G4 = C1460d.m437G1(parcel, i);
                    break;
                case 14:
                    zM431E2 = C1460d.m431E1(parcel, i);
                    break;
                case 15:
                    strM468R2 = C1460d.m468R(parcel, i);
                    break;
            }
        }
        C1460d.m516f0(parcel, iM546m2);
        return new GetServiceRequest(iM437G1, iM437G2, iM437G3, strM468R, iBinderM434F1, scopeArr, bundleM453M, account, featureArr, featureArr2, zM431E1, iM437G4, zM431E2, strM468R2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ GetServiceRequest[] newArray(int i) {
        return new GetServiceRequest[i];
    }
}
