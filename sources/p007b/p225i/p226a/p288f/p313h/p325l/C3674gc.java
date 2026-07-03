package p007b.p225i.p226a.p288f.p313h.p325l;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzae;
import p007b.p225i.p226a.p288f.p311f.InterfaceC3422a;

/* JADX INFO: renamed from: b.i.a.f.h.l.gc */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3674gc extends C3577a implements InterfaceC3646ec {
    public C3674gc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public final void beginAdUnitExposure(String str, long j) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        parcelM4518c.writeString(str);
        parcelM4518c.writeLong(j);
        m4520i(23, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        parcelM4518c.writeString(str);
        parcelM4518c.writeString(str2);
        C3859v.m5328c(parcelM4518c, bundle);
        m4520i(9, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public final void endAdUnitExposure(String str, long j) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        parcelM4518c.writeString(str);
        parcelM4518c.writeLong(j);
        m4520i(24, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public final void generateEventId(InterfaceC3660fc interfaceC3660fc) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        C3859v.m5327b(parcelM4518c, interfaceC3660fc);
        m4520i(22, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public final void getCachedAppInstanceId(InterfaceC3660fc interfaceC3660fc) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        C3859v.m5327b(parcelM4518c, interfaceC3660fc);
        m4520i(19, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public final void getConditionalUserProperties(String str, String str2, InterfaceC3660fc interfaceC3660fc) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        parcelM4518c.writeString(str);
        parcelM4518c.writeString(str2);
        C3859v.m5327b(parcelM4518c, interfaceC3660fc);
        m4520i(10, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public final void getCurrentScreenClass(InterfaceC3660fc interfaceC3660fc) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        C3859v.m5327b(parcelM4518c, interfaceC3660fc);
        m4520i(17, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public final void getCurrentScreenName(InterfaceC3660fc interfaceC3660fc) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        C3859v.m5327b(parcelM4518c, interfaceC3660fc);
        m4520i(16, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public final void getGmpAppId(InterfaceC3660fc interfaceC3660fc) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        C3859v.m5327b(parcelM4518c, interfaceC3660fc);
        m4520i(21, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public final void getMaxUserProperties(String str, InterfaceC3660fc interfaceC3660fc) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        parcelM4518c.writeString(str);
        C3859v.m5327b(parcelM4518c, interfaceC3660fc);
        m4520i(6, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public final void getUserProperties(String str, String str2, boolean z2, InterfaceC3660fc interfaceC3660fc) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        parcelM4518c.writeString(str);
        parcelM4518c.writeString(str2);
        ClassLoader classLoader = C3859v.f10357a;
        parcelM4518c.writeInt(z2 ? 1 : 0);
        C3859v.m5327b(parcelM4518c, interfaceC3660fc);
        m4520i(5, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public final void initialize(InterfaceC3422a interfaceC3422a, zzae zzaeVar, long j) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        C3859v.m5327b(parcelM4518c, interfaceC3422a);
        C3859v.m5328c(parcelM4518c, zzaeVar);
        parcelM4518c.writeLong(j);
        m4520i(1, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public final void logEvent(String str, String str2, Bundle bundle, boolean z2, boolean z3, long j) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        parcelM4518c.writeString(str);
        parcelM4518c.writeString(str2);
        C3859v.m5328c(parcelM4518c, bundle);
        parcelM4518c.writeInt(z2 ? 1 : 0);
        parcelM4518c.writeInt(z3 ? 1 : 0);
        parcelM4518c.writeLong(j);
        m4520i(2, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public final void logHealthData(int i, String str, InterfaceC3422a interfaceC3422a, InterfaceC3422a interfaceC3422a2, InterfaceC3422a interfaceC3422a3) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        parcelM4518c.writeInt(i);
        parcelM4518c.writeString(str);
        C3859v.m5327b(parcelM4518c, interfaceC3422a);
        C3859v.m5327b(parcelM4518c, interfaceC3422a2);
        C3859v.m5327b(parcelM4518c, interfaceC3422a3);
        m4520i(33, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public final void onActivityCreated(InterfaceC3422a interfaceC3422a, Bundle bundle, long j) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        C3859v.m5327b(parcelM4518c, interfaceC3422a);
        C3859v.m5328c(parcelM4518c, bundle);
        parcelM4518c.writeLong(j);
        m4520i(27, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public final void onActivityDestroyed(InterfaceC3422a interfaceC3422a, long j) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        C3859v.m5327b(parcelM4518c, interfaceC3422a);
        parcelM4518c.writeLong(j);
        m4520i(28, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public final void onActivityPaused(InterfaceC3422a interfaceC3422a, long j) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        C3859v.m5327b(parcelM4518c, interfaceC3422a);
        parcelM4518c.writeLong(j);
        m4520i(29, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public final void onActivityResumed(InterfaceC3422a interfaceC3422a, long j) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        C3859v.m5327b(parcelM4518c, interfaceC3422a);
        parcelM4518c.writeLong(j);
        m4520i(30, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public final void onActivitySaveInstanceState(InterfaceC3422a interfaceC3422a, InterfaceC3660fc interfaceC3660fc, long j) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        C3859v.m5327b(parcelM4518c, interfaceC3422a);
        C3859v.m5327b(parcelM4518c, interfaceC3660fc);
        parcelM4518c.writeLong(j);
        m4520i(31, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public final void onActivityStarted(InterfaceC3422a interfaceC3422a, long j) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        C3859v.m5327b(parcelM4518c, interfaceC3422a);
        parcelM4518c.writeLong(j);
        m4520i(25, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public final void onActivityStopped(InterfaceC3422a interfaceC3422a, long j) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        C3859v.m5327b(parcelM4518c, interfaceC3422a);
        parcelM4518c.writeLong(j);
        m4520i(26, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public final void registerOnMeasurementEventListener(InterfaceC3605c interfaceC3605c) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        C3859v.m5327b(parcelM4518c, interfaceC3605c);
        m4520i(35, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public final void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        C3859v.m5328c(parcelM4518c, bundle);
        parcelM4518c.writeLong(j);
        m4520i(8, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public final void setCurrentScreen(InterfaceC3422a interfaceC3422a, String str, String str2, long j) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        C3859v.m5327b(parcelM4518c, interfaceC3422a);
        parcelM4518c.writeString(str);
        parcelM4518c.writeString(str2);
        parcelM4518c.writeLong(j);
        m4520i(15, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public final void setDataCollectionEnabled(boolean z2) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        ClassLoader classLoader = C3859v.f10357a;
        parcelM4518c.writeInt(z2 ? 1 : 0);
        m4520i(39, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public final void setUserId(String str, long j) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        parcelM4518c.writeString(str);
        parcelM4518c.writeLong(j);
        m4520i(7, parcelM4518c);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3646ec
    public final void setUserProperty(String str, String str2, InterfaceC3422a interfaceC3422a, boolean z2, long j) throws RemoteException {
        Parcel parcelM4518c = m4518c();
        parcelM4518c.writeString(str);
        parcelM4518c.writeString(str2);
        C3859v.m5327b(parcelM4518c, interfaceC3422a);
        parcelM4518c.writeInt(z2 ? 1 : 0);
        parcelM4518c.writeLong(j);
        m4520i(4, parcelM4518c);
    }
}
