package b.i.a.f.e.k;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import b.c.a.a0.AnimatableValueParser;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.GetServiceRequest;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class p0 implements Parcelable.Creator<GetServiceRequest> {
    public static void a(GetServiceRequest getServiceRequest, Parcel parcel, int i) {
        int iY2 = AnimatableValueParser.y2(parcel, 20293);
        int i2 = getServiceRequest.j;
        parcel.writeInt(262145);
        parcel.writeInt(i2);
        int i3 = getServiceRequest.k;
        parcel.writeInt(262146);
        parcel.writeInt(i3);
        int i4 = getServiceRequest.l;
        parcel.writeInt(262147);
        parcel.writeInt(i4);
        AnimatableValueParser.t2(parcel, 4, getServiceRequest.m, false);
        AnimatableValueParser.r2(parcel, 5, getServiceRequest.n, false);
        AnimatableValueParser.v2(parcel, 6, getServiceRequest.o, i, false);
        AnimatableValueParser.p2(parcel, 7, getServiceRequest.p, false);
        AnimatableValueParser.s2(parcel, 8, getServiceRequest.q, i, false);
        AnimatableValueParser.v2(parcel, 10, getServiceRequest.r, i, false);
        AnimatableValueParser.v2(parcel, 11, getServiceRequest.f3005s, i, false);
        boolean z2 = getServiceRequest.t;
        parcel.writeInt(262156);
        parcel.writeInt(z2 ? 1 : 0);
        int i5 = getServiceRequest.u;
        parcel.writeInt(262157);
        parcel.writeInt(i5);
        boolean z3 = getServiceRequest.v;
        parcel.writeInt(262158);
        parcel.writeInt(z3 ? 1 : 0);
        AnimatableValueParser.t2(parcel, 15, getServiceRequest.w, false);
        AnimatableValueParser.A2(parcel, iY2);
    }

    @Override // android.os.Parcelable.Creator
    public final GetServiceRequest createFromParcel(Parcel parcel) {
        int iM2 = AnimatableValueParser.m2(parcel);
        String strR = null;
        IBinder iBinderF1 = null;
        Scope[] scopeArr = null;
        Bundle bundleM = null;
        Account account = null;
        Feature[] featureArr = null;
        Feature[] featureArr2 = null;
        String strR2 = null;
        int iG1 = 0;
        int iG2 = 0;
        int iG3 = 0;
        boolean zE1 = false;
        int iG4 = 0;
        boolean zE2 = false;
        while (parcel.dataPosition() < iM2) {
            int i = parcel.readInt();
            switch ((char) i) {
                case 1:
                    iG1 = AnimatableValueParser.G1(parcel, i);
                    break;
                case 2:
                    iG2 = AnimatableValueParser.G1(parcel, i);
                    break;
                case 3:
                    iG3 = AnimatableValueParser.G1(parcel, i);
                    break;
                case 4:
                    strR = AnimatableValueParser.R(parcel, i);
                    break;
                case 5:
                    iBinderF1 = AnimatableValueParser.F1(parcel, i);
                    break;
                case 6:
                    scopeArr = (Scope[]) AnimatableValueParser.U(parcel, i, Scope.CREATOR);
                    break;
                case 7:
                    bundleM = AnimatableValueParser.M(parcel, i);
                    break;
                case '\b':
                    account = (Account) AnimatableValueParser.Q(parcel, i, Account.CREATOR);
                    break;
                case '\t':
                default:
                    AnimatableValueParser.d2(parcel, i);
                    break;
                case '\n':
                    featureArr = (Feature[]) AnimatableValueParser.U(parcel, i, Feature.CREATOR);
                    break;
                case 11:
                    featureArr2 = (Feature[]) AnimatableValueParser.U(parcel, i, Feature.CREATOR);
                    break;
                case '\f':
                    zE1 = AnimatableValueParser.E1(parcel, i);
                    break;
                case '\r':
                    iG4 = AnimatableValueParser.G1(parcel, i);
                    break;
                case 14:
                    zE2 = AnimatableValueParser.E1(parcel, i);
                    break;
                case 15:
                    strR2 = AnimatableValueParser.R(parcel, i);
                    break;
            }
        }
        AnimatableValueParser.f0(parcel, iM2);
        return new GetServiceRequest(iG1, iG2, iG3, strR, iBinderF1, scopeArr, bundleM, account, featureArr, featureArr2, zE1, iG4, zE2, strR2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ GetServiceRequest[] newArray(int i) {
        return new GetServiceRequest[i];
    }
}
