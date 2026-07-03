package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzn;
import com.google.android.gms.measurement.internal.zzz;
import java.util.ArrayList;
import java.util.List;
import p007b.p225i.p226a.p288f.p313h.p325l.C3577a;
import p007b.p225i.p226a.p288f.p313h.p325l.C3859v;

/* JADX INFO: renamed from: b.i.a.f.i.b.k3 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4091k3 extends C3577a implements InterfaceC4068i3 {
    public C4091k3(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4068i3
    /* JADX INFO: renamed from: A */
    public final String mo5666A(zzn zznVar) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        C3859v.m5328c(parcelM4518c, zznVar);
        Parcel parcelM4519g = m4519g(11, parcelM4518c);
        String string = parcelM4519g.readString();
        parcelM4519g.recycle();
        return string;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4068i3
    /* JADX INFO: renamed from: G */
    public final void mo5667G(long j, String str, String str2, String str3) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        parcelM4518c.writeLong(j);
        parcelM4518c.writeString(str);
        parcelM4518c.writeString(str2);
        parcelM4518c.writeString(str3);
        m4520i(10, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4068i3
    /* JADX INFO: renamed from: I */
    public final void mo5668I(zzn zznVar) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        C3859v.m5328c(parcelM4518c, zznVar);
        m4520i(18, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4068i3
    /* JADX INFO: renamed from: J */
    public final List<zzz> mo5669J(String str, String str2, String str3) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        parcelM4518c.writeString(str);
        parcelM4518c.writeString(str2);
        parcelM4518c.writeString(str3);
        Parcel parcelM4519g = m4519g(17, parcelM4518c);
        ArrayList arrayListCreateTypedArrayList = parcelM4519g.createTypedArrayList(zzz.CREATOR);
        parcelM4519g.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4068i3
    /* JADX INFO: renamed from: K */
    public final List<zzz> mo5670K(String str, String str2, zzn zznVar) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        parcelM4518c.writeString(str);
        parcelM4518c.writeString(str2);
        C3859v.m5328c(parcelM4518c, zznVar);
        Parcel parcelM4519g = m4519g(16, parcelM4518c);
        ArrayList arrayListCreateTypedArrayList = parcelM4519g.createTypedArrayList(zzz.CREATOR);
        parcelM4519g.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4068i3
    /* JADX INFO: renamed from: R */
    public final List<zzku> mo5671R(String str, String str2, boolean z2, zzn zznVar) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        parcelM4518c.writeString(str);
        parcelM4518c.writeString(str2);
        ClassLoader classLoader = C3859v.f10357a;
        parcelM4518c.writeInt(z2 ? 1 : 0);
        C3859v.m5328c(parcelM4518c, zznVar);
        Parcel parcelM4519g = m4519g(14, parcelM4518c);
        ArrayList arrayListCreateTypedArrayList = parcelM4519g.createTypedArrayList(zzku.CREATOR);
        parcelM4519g.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4068i3
    /* JADX INFO: renamed from: T */
    public final void mo5672T(zzn zznVar) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        C3859v.m5328c(parcelM4518c, zznVar);
        m4520i(4, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4068i3
    /* JADX INFO: renamed from: d0 */
    public final void mo5673d0(zzn zznVar) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        C3859v.m5328c(parcelM4518c, zznVar);
        m4520i(6, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4068i3
    /* JADX INFO: renamed from: j */
    public final byte[] mo5674j(zzaq zzaqVar, String str) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        C3859v.m5328c(parcelM4518c, zzaqVar);
        parcelM4518c.writeString(str);
        Parcel parcelM4519g = m4519g(9, parcelM4518c);
        byte[] bArrCreateByteArray = parcelM4519g.createByteArray();
        parcelM4519g.recycle();
        return bArrCreateByteArray;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4068i3
    /* JADX INFO: renamed from: l0 */
    public final void mo5675l0(zzaq zzaqVar, zzn zznVar) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        C3859v.m5328c(parcelM4518c, zzaqVar);
        C3859v.m5328c(parcelM4518c, zznVar);
        m4520i(1, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4068i3
    /* JADX INFO: renamed from: m */
    public final void mo5676m(zzn zznVar) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        C3859v.m5328c(parcelM4518c, zznVar);
        m4520i(20, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4068i3
    /* JADX INFO: renamed from: m0 */
    public final void mo5677m0(Bundle bundle, zzn zznVar) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        C3859v.m5328c(parcelM4518c, bundle);
        C3859v.m5328c(parcelM4518c, zznVar);
        m4520i(19, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4068i3
    /* JADX INFO: renamed from: p0 */
    public final void mo5678p0(zzku zzkuVar, zzn zznVar) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        C3859v.m5328c(parcelM4518c, zzkuVar);
        C3859v.m5328c(parcelM4518c, zznVar);
        m4520i(2, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4068i3
    /* JADX INFO: renamed from: q0 */
    public final void mo5679q0(zzz zzzVar, zzn zznVar) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        C3859v.m5328c(parcelM4518c, zzzVar);
        C3859v.m5328c(parcelM4518c, zznVar);
        m4520i(12, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4068i3
    /* JADX INFO: renamed from: u */
    public final List<zzku> mo5680u(String str, String str2, String str3, boolean z2) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        parcelM4518c.writeString(str);
        parcelM4518c.writeString(str2);
        parcelM4518c.writeString(str3);
        ClassLoader classLoader = C3859v.f10357a;
        parcelM4518c.writeInt(z2 ? 1 : 0);
        Parcel parcelM4519g = m4519g(15, parcelM4518c);
        ArrayList arrayListCreateTypedArrayList = parcelM4519g.createTypedArrayList(zzku.CREATOR);
        parcelM4519g.recycle();
        return arrayListCreateTypedArrayList;
    }
}
