package b.i.a.f.h.l;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzae;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class gc extends a implements ec {
    public gc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // b.i.a.f.h.l.ec
    public final void beginAdUnitExposure(String str, long j) throws RemoteException {
        Parcel parcelC = c();
        parcelC.writeString(str);
        parcelC.writeLong(j);
        i(23, parcelC);
    }

    @Override // b.i.a.f.h.l.ec
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        Parcel parcelC = c();
        parcelC.writeString(str);
        parcelC.writeString(str2);
        v.c(parcelC, bundle);
        i(9, parcelC);
    }

    @Override // b.i.a.f.h.l.ec
    public final void endAdUnitExposure(String str, long j) throws RemoteException {
        Parcel parcelC = c();
        parcelC.writeString(str);
        parcelC.writeLong(j);
        i(24, parcelC);
    }

    @Override // b.i.a.f.h.l.ec
    public final void generateEventId(fc fcVar) throws RemoteException {
        Parcel parcelC = c();
        v.b(parcelC, fcVar);
        i(22, parcelC);
    }

    @Override // b.i.a.f.h.l.ec
    public final void getCachedAppInstanceId(fc fcVar) throws RemoteException {
        Parcel parcelC = c();
        v.b(parcelC, fcVar);
        i(19, parcelC);
    }

    @Override // b.i.a.f.h.l.ec
    public final void getConditionalUserProperties(String str, String str2, fc fcVar) throws RemoteException {
        Parcel parcelC = c();
        parcelC.writeString(str);
        parcelC.writeString(str2);
        v.b(parcelC, fcVar);
        i(10, parcelC);
    }

    @Override // b.i.a.f.h.l.ec
    public final void getCurrentScreenClass(fc fcVar) throws RemoteException {
        Parcel parcelC = c();
        v.b(parcelC, fcVar);
        i(17, parcelC);
    }

    @Override // b.i.a.f.h.l.ec
    public final void getCurrentScreenName(fc fcVar) throws RemoteException {
        Parcel parcelC = c();
        v.b(parcelC, fcVar);
        i(16, parcelC);
    }

    @Override // b.i.a.f.h.l.ec
    public final void getGmpAppId(fc fcVar) throws RemoteException {
        Parcel parcelC = c();
        v.b(parcelC, fcVar);
        i(21, parcelC);
    }

    @Override // b.i.a.f.h.l.ec
    public final void getMaxUserProperties(String str, fc fcVar) throws RemoteException {
        Parcel parcelC = c();
        parcelC.writeString(str);
        v.b(parcelC, fcVar);
        i(6, parcelC);
    }

    @Override // b.i.a.f.h.l.ec
    public final void getUserProperties(String str, String str2, boolean z2, fc fcVar) throws RemoteException {
        Parcel parcelC = c();
        parcelC.writeString(str);
        parcelC.writeString(str2);
        ClassLoader classLoader = v.a;
        parcelC.writeInt(z2 ? 1 : 0);
        v.b(parcelC, fcVar);
        i(5, parcelC);
    }

    @Override // b.i.a.f.h.l.ec
    public final void initialize(b.i.a.f.f.a aVar, zzae zzaeVar, long j) throws RemoteException {
        Parcel parcelC = c();
        v.b(parcelC, aVar);
        v.c(parcelC, zzaeVar);
        parcelC.writeLong(j);
        i(1, parcelC);
    }

    @Override // b.i.a.f.h.l.ec
    public final void logEvent(String str, String str2, Bundle bundle, boolean z2, boolean z3, long j) throws RemoteException {
        Parcel parcelC = c();
        parcelC.writeString(str);
        parcelC.writeString(str2);
        v.c(parcelC, bundle);
        parcelC.writeInt(z2 ? 1 : 0);
        parcelC.writeInt(z3 ? 1 : 0);
        parcelC.writeLong(j);
        i(2, parcelC);
    }

    @Override // b.i.a.f.h.l.ec
    public final void logHealthData(int i, String str, b.i.a.f.f.a aVar, b.i.a.f.f.a aVar2, b.i.a.f.f.a aVar3) throws RemoteException {
        Parcel parcelC = c();
        parcelC.writeInt(i);
        parcelC.writeString(str);
        v.b(parcelC, aVar);
        v.b(parcelC, aVar2);
        v.b(parcelC, aVar3);
        i(33, parcelC);
    }

    @Override // b.i.a.f.h.l.ec
    public final void onActivityCreated(b.i.a.f.f.a aVar, Bundle bundle, long j) throws RemoteException {
        Parcel parcelC = c();
        v.b(parcelC, aVar);
        v.c(parcelC, bundle);
        parcelC.writeLong(j);
        i(27, parcelC);
    }

    @Override // b.i.a.f.h.l.ec
    public final void onActivityDestroyed(b.i.a.f.f.a aVar, long j) throws RemoteException {
        Parcel parcelC = c();
        v.b(parcelC, aVar);
        parcelC.writeLong(j);
        i(28, parcelC);
    }

    @Override // b.i.a.f.h.l.ec
    public final void onActivityPaused(b.i.a.f.f.a aVar, long j) throws RemoteException {
        Parcel parcelC = c();
        v.b(parcelC, aVar);
        parcelC.writeLong(j);
        i(29, parcelC);
    }

    @Override // b.i.a.f.h.l.ec
    public final void onActivityResumed(b.i.a.f.f.a aVar, long j) throws RemoteException {
        Parcel parcelC = c();
        v.b(parcelC, aVar);
        parcelC.writeLong(j);
        i(30, parcelC);
    }

    @Override // b.i.a.f.h.l.ec
    public final void onActivitySaveInstanceState(b.i.a.f.f.a aVar, fc fcVar, long j) throws RemoteException {
        Parcel parcelC = c();
        v.b(parcelC, aVar);
        v.b(parcelC, fcVar);
        parcelC.writeLong(j);
        i(31, parcelC);
    }

    @Override // b.i.a.f.h.l.ec
    public final void onActivityStarted(b.i.a.f.f.a aVar, long j) throws RemoteException {
        Parcel parcelC = c();
        v.b(parcelC, aVar);
        parcelC.writeLong(j);
        i(25, parcelC);
    }

    @Override // b.i.a.f.h.l.ec
    public final void onActivityStopped(b.i.a.f.f.a aVar, long j) throws RemoteException {
        Parcel parcelC = c();
        v.b(parcelC, aVar);
        parcelC.writeLong(j);
        i(26, parcelC);
    }

    @Override // b.i.a.f.h.l.ec
    public final void registerOnMeasurementEventListener(c cVar) throws RemoteException {
        Parcel parcelC = c();
        v.b(parcelC, cVar);
        i(35, parcelC);
    }

    @Override // b.i.a.f.h.l.ec
    public final void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException {
        Parcel parcelC = c();
        v.c(parcelC, bundle);
        parcelC.writeLong(j);
        i(8, parcelC);
    }

    @Override // b.i.a.f.h.l.ec
    public final void setCurrentScreen(b.i.a.f.f.a aVar, String str, String str2, long j) throws RemoteException {
        Parcel parcelC = c();
        v.b(parcelC, aVar);
        parcelC.writeString(str);
        parcelC.writeString(str2);
        parcelC.writeLong(j);
        i(15, parcelC);
    }

    @Override // b.i.a.f.h.l.ec
    public final void setDataCollectionEnabled(boolean z2) throws RemoteException {
        Parcel parcelC = c();
        ClassLoader classLoader = v.a;
        parcelC.writeInt(z2 ? 1 : 0);
        i(39, parcelC);
    }

    @Override // b.i.a.f.h.l.ec
    public final void setUserId(String str, long j) throws RemoteException {
        Parcel parcelC = c();
        parcelC.writeString(str);
        parcelC.writeLong(j);
        i(7, parcelC);
    }

    @Override // b.i.a.f.h.l.ec
    public final void setUserProperty(String str, String str2, b.i.a.f.f.a aVar, boolean z2, long j) throws RemoteException {
        Parcel parcelC = c();
        parcelC.writeString(str);
        parcelC.writeString(str2);
        v.b(parcelC, aVar);
        parcelC.writeInt(z2 ? 1 : 0);
        parcelC.writeLong(j);
        i(4, parcelC);
    }
}
