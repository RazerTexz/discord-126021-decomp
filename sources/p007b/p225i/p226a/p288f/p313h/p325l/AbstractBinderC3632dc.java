package p007b.p225i.p226a.p288f.p313h.p325l;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzae;
import p007b.p225i.p226a.p288f.p311f.InterfaceC3422a;

/* JADX INFO: renamed from: b.i.a.f.h.l.dc */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractBinderC3632dc extends BinderC3821s0 implements InterfaceC3646ec {
    public AbstractBinderC3632dc() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static InterfaceC3646ec asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        return iInterfaceQueryLocalInterface instanceof InterfaceC3646ec ? (InterfaceC3646ec) iInterfaceQueryLocalInterface : new C3674gc(iBinder);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.BinderC3821s0
    /* JADX INFO: renamed from: c */
    public final boolean mo4565c(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        InterfaceC3660fc c3688hc = null;
        InterfaceC3660fc c3688hc2 = null;
        InterfaceC3660fc c3688hc3 = null;
        InterfaceC3605c c3633e = null;
        InterfaceC3605c c3633e2 = null;
        InterfaceC3605c c3633e3 = null;
        InterfaceC3660fc c3688hc4 = null;
        InterfaceC3660fc c3688hc5 = null;
        InterfaceC3660fc c3688hc6 = null;
        InterfaceC3660fc c3688hc7 = null;
        InterfaceC3660fc c3688hc8 = null;
        InterfaceC3660fc c3688hc9 = null;
        InterfaceC3619d c3647f = null;
        InterfaceC3660fc c3688hc10 = null;
        InterfaceC3660fc c3688hc11 = null;
        InterfaceC3660fc c3688hc12 = null;
        InterfaceC3660fc c3688hc13 = null;
        InterfaceC3660fc c3688hc14 = null;
        switch (i) {
            case 1:
                initialize(InterfaceC3422a.a.m4380g(parcel.readStrongBinder()), (zzae) C3859v.m5326a(parcel, zzae.CREATOR), parcel.readLong());
                break;
            case 2:
                logEvent(parcel.readString(), parcel.readString(), (Bundle) C3859v.m5326a(parcel, Bundle.CREATOR), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readLong());
                break;
            case 3:
                String string = parcel.readString();
                String string2 = parcel.readString();
                Bundle bundle = (Bundle) C3859v.m5326a(parcel, Bundle.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c3688hc = iInterfaceQueryLocalInterface instanceof InterfaceC3660fc ? (InterfaceC3660fc) iInterfaceQueryLocalInterface : new C3688hc(strongBinder);
                }
                logEventAndBundle(string, string2, bundle, c3688hc, parcel.readLong());
                break;
            case 4:
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                InterfaceC3422a interfaceC3422aM4380g = InterfaceC3422a.a.m4380g(parcel.readStrongBinder());
                ClassLoader classLoader = C3859v.f10357a;
                setUserProperty(string3, string4, interfaceC3422aM4380g, parcel.readInt() != 0, parcel.readLong());
                break;
            case 5:
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                ClassLoader classLoader2 = C3859v.f10357a;
                boolean z2 = parcel.readInt() != 0;
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c3688hc14 = iInterfaceQueryLocalInterface2 instanceof InterfaceC3660fc ? (InterfaceC3660fc) iInterfaceQueryLocalInterface2 : new C3688hc(strongBinder2);
                }
                getUserProperties(string5, string6, z2, c3688hc14);
                break;
            case 6:
                String string7 = parcel.readString();
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c3688hc13 = iInterfaceQueryLocalInterface3 instanceof InterfaceC3660fc ? (InterfaceC3660fc) iInterfaceQueryLocalInterface3 : new C3688hc(strongBinder3);
                }
                getMaxUserProperties(string7, c3688hc13);
                break;
            case 7:
                setUserId(parcel.readString(), parcel.readLong());
                break;
            case 8:
                setConditionalUserProperty((Bundle) C3859v.m5326a(parcel, Bundle.CREATOR), parcel.readLong());
                break;
            case 9:
                clearConditionalUserProperty(parcel.readString(), parcel.readString(), (Bundle) C3859v.m5326a(parcel, Bundle.CREATOR));
                break;
            case 10:
                String string8 = parcel.readString();
                String string9 = parcel.readString();
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c3688hc12 = iInterfaceQueryLocalInterface4 instanceof InterfaceC3660fc ? (InterfaceC3660fc) iInterfaceQueryLocalInterface4 : new C3688hc(strongBinder4);
                }
                getConditionalUserProperties(string8, string9, c3688hc12);
                break;
            case 11:
                ClassLoader classLoader3 = C3859v.f10357a;
                setMeasurementEnabled(parcel.readInt() != 0, parcel.readLong());
                break;
            case 12:
                resetAnalyticsData(parcel.readLong());
                break;
            case 13:
                setMinimumSessionDuration(parcel.readLong());
                break;
            case 14:
                setSessionTimeoutDuration(parcel.readLong());
                break;
            case 15:
                setCurrentScreen(InterfaceC3422a.a.m4380g(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readLong());
                break;
            case 16:
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c3688hc11 = iInterfaceQueryLocalInterface5 instanceof InterfaceC3660fc ? (InterfaceC3660fc) iInterfaceQueryLocalInterface5 : new C3688hc(strongBinder5);
                }
                getCurrentScreenName(c3688hc11);
                break;
            case 17:
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c3688hc10 = iInterfaceQueryLocalInterface6 instanceof InterfaceC3660fc ? (InterfaceC3660fc) iInterfaceQueryLocalInterface6 : new C3688hc(strongBinder6);
                }
                getCurrentScreenClass(c3688hc10);
                break;
            case 18:
                IBinder strongBinder7 = parcel.readStrongBinder();
                if (strongBinder7 != null) {
                    IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    c3647f = iInterfaceQueryLocalInterface7 instanceof InterfaceC3619d ? (InterfaceC3619d) iInterfaceQueryLocalInterface7 : new C3647f(strongBinder7);
                }
                setInstanceIdProvider(c3647f);
                break;
            case 19:
                IBinder strongBinder8 = parcel.readStrongBinder();
                if (strongBinder8 != null) {
                    IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c3688hc9 = iInterfaceQueryLocalInterface8 instanceof InterfaceC3660fc ? (InterfaceC3660fc) iInterfaceQueryLocalInterface8 : new C3688hc(strongBinder8);
                }
                getCachedAppInstanceId(c3688hc9);
                break;
            case 20:
                IBinder strongBinder9 = parcel.readStrongBinder();
                if (strongBinder9 != null) {
                    IInterface iInterfaceQueryLocalInterface9 = strongBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c3688hc8 = iInterfaceQueryLocalInterface9 instanceof InterfaceC3660fc ? (InterfaceC3660fc) iInterfaceQueryLocalInterface9 : new C3688hc(strongBinder9);
                }
                getAppInstanceId(c3688hc8);
                break;
            case 21:
                IBinder strongBinder10 = parcel.readStrongBinder();
                if (strongBinder10 != null) {
                    IInterface iInterfaceQueryLocalInterface10 = strongBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c3688hc7 = iInterfaceQueryLocalInterface10 instanceof InterfaceC3660fc ? (InterfaceC3660fc) iInterfaceQueryLocalInterface10 : new C3688hc(strongBinder10);
                }
                getGmpAppId(c3688hc7);
                break;
            case 22:
                IBinder strongBinder11 = parcel.readStrongBinder();
                if (strongBinder11 != null) {
                    IInterface iInterfaceQueryLocalInterface11 = strongBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c3688hc6 = iInterfaceQueryLocalInterface11 instanceof InterfaceC3660fc ? (InterfaceC3660fc) iInterfaceQueryLocalInterface11 : new C3688hc(strongBinder11);
                }
                generateEventId(c3688hc6);
                break;
            case 23:
                beginAdUnitExposure(parcel.readString(), parcel.readLong());
                break;
            case 24:
                endAdUnitExposure(parcel.readString(), parcel.readLong());
                break;
            case 25:
                onActivityStarted(InterfaceC3422a.a.m4380g(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 26:
                onActivityStopped(InterfaceC3422a.a.m4380g(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 27:
                onActivityCreated(InterfaceC3422a.a.m4380g(parcel.readStrongBinder()), (Bundle) C3859v.m5326a(parcel, Bundle.CREATOR), parcel.readLong());
                break;
            case 28:
                onActivityDestroyed(InterfaceC3422a.a.m4380g(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 29:
                onActivityPaused(InterfaceC3422a.a.m4380g(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 30:
                onActivityResumed(InterfaceC3422a.a.m4380g(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 31:
                InterfaceC3422a interfaceC3422aM4380g2 = InterfaceC3422a.a.m4380g(parcel.readStrongBinder());
                IBinder strongBinder12 = parcel.readStrongBinder();
                if (strongBinder12 != null) {
                    IInterface iInterfaceQueryLocalInterface12 = strongBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c3688hc5 = iInterfaceQueryLocalInterface12 instanceof InterfaceC3660fc ? (InterfaceC3660fc) iInterfaceQueryLocalInterface12 : new C3688hc(strongBinder12);
                }
                onActivitySaveInstanceState(interfaceC3422aM4380g2, c3688hc5, parcel.readLong());
                break;
            case 32:
                Bundle bundle2 = (Bundle) C3859v.m5326a(parcel, Bundle.CREATOR);
                IBinder strongBinder13 = parcel.readStrongBinder();
                if (strongBinder13 != null) {
                    IInterface iInterfaceQueryLocalInterface13 = strongBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c3688hc4 = iInterfaceQueryLocalInterface13 instanceof InterfaceC3660fc ? (InterfaceC3660fc) iInterfaceQueryLocalInterface13 : new C3688hc(strongBinder13);
                }
                performAction(bundle2, c3688hc4, parcel.readLong());
                break;
            case 33:
                logHealthData(parcel.readInt(), parcel.readString(), InterfaceC3422a.a.m4380g(parcel.readStrongBinder()), InterfaceC3422a.a.m4380g(parcel.readStrongBinder()), InterfaceC3422a.a.m4380g(parcel.readStrongBinder()));
                break;
            case 34:
                IBinder strongBinder14 = parcel.readStrongBinder();
                if (strongBinder14 != null) {
                    IInterface iInterfaceQueryLocalInterface14 = strongBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    c3633e3 = iInterfaceQueryLocalInterface14 instanceof InterfaceC3605c ? (InterfaceC3605c) iInterfaceQueryLocalInterface14 : new C3633e(strongBinder14);
                }
                setEventInterceptor(c3633e3);
                break;
            case 35:
                IBinder strongBinder15 = parcel.readStrongBinder();
                if (strongBinder15 != null) {
                    IInterface iInterfaceQueryLocalInterface15 = strongBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    c3633e2 = iInterfaceQueryLocalInterface15 instanceof InterfaceC3605c ? (InterfaceC3605c) iInterfaceQueryLocalInterface15 : new C3633e(strongBinder15);
                }
                registerOnMeasurementEventListener(c3633e2);
                break;
            case 36:
                IBinder strongBinder16 = parcel.readStrongBinder();
                if (strongBinder16 != null) {
                    IInterface iInterfaceQueryLocalInterface16 = strongBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    c3633e = iInterfaceQueryLocalInterface16 instanceof InterfaceC3605c ? (InterfaceC3605c) iInterfaceQueryLocalInterface16 : new C3633e(strongBinder16);
                }
                unregisterOnMeasurementEventListener(c3633e);
                break;
            case 37:
                initForTests(parcel.readHashMap(C3859v.f10357a));
                break;
            case 38:
                IBinder strongBinder17 = parcel.readStrongBinder();
                if (strongBinder17 != null) {
                    IInterface iInterfaceQueryLocalInterface17 = strongBinder17.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c3688hc3 = iInterfaceQueryLocalInterface17 instanceof InterfaceC3660fc ? (InterfaceC3660fc) iInterfaceQueryLocalInterface17 : new C3688hc(strongBinder17);
                }
                getTestFlag(c3688hc3, parcel.readInt());
                break;
            case 39:
                ClassLoader classLoader4 = C3859v.f10357a;
                setDataCollectionEnabled(parcel.readInt() != 0);
                break;
            case 40:
                IBinder strongBinder18 = parcel.readStrongBinder();
                if (strongBinder18 != null) {
                    IInterface iInterfaceQueryLocalInterface18 = strongBinder18.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    c3688hc2 = iInterfaceQueryLocalInterface18 instanceof InterfaceC3660fc ? (InterfaceC3660fc) iInterfaceQueryLocalInterface18 : new C3688hc(strongBinder18);
                }
                isDataCollectionEnabled(c3688hc2);
                break;
            case 41:
            default:
                return false;
            case 42:
                setDefaultEventParameters((Bundle) C3859v.m5326a(parcel, Bundle.CREATOR));
                break;
            case 43:
                clearMeasurementEnabled(parcel.readLong());
                break;
            case 44:
                setConsent((Bundle) C3859v.m5326a(parcel, Bundle.CREATOR), parcel.readLong());
                break;
            case 45:
                setConsentThirdParty((Bundle) C3859v.m5326a(parcel, Bundle.CREATOR), parcel.readLong());
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
