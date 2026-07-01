package b.i.a.f.h.l;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import b.i.a.f.f.a;
import com.google.android.gms.internal.measurement.zzae;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class dc extends s0 implements ec {
    public dc() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static ec asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        return iInterfaceQueryLocalInterface instanceof ec ? (ec) iInterfaceQueryLocalInterface : new gc(iBinder);
    }

    @Override // b.i.a.f.h.l.s0
    public final boolean c(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        fc hcVar = null;
        fc hcVar2 = null;
        fc hcVar3 = null;
        c eVar = null;
        c eVar2 = null;
        c eVar3 = null;
        fc hcVar4 = null;
        fc hcVar5 = null;
        fc hcVar6 = null;
        fc hcVar7 = null;
        fc hcVar8 = null;
        fc hcVar9 = null;
        d fVar = null;
        fc hcVar10 = null;
        fc hcVar11 = null;
        fc hcVar12 = null;
        fc hcVar13 = null;
        fc hcVar14 = null;
        switch (i) {
            case 1:
                initialize(a.AbstractBinderC0040a.g(parcel.readStrongBinder()), (zzae) v.a(parcel, zzae.CREATOR), parcel.readLong());
                break;
            case 2:
                logEvent(parcel.readString(), parcel.readString(), (Bundle) v.a(parcel, Bundle.CREATOR), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readLong());
                break;
            case 3:
                String string = parcel.readString();
                String string2 = parcel.readString();
                Bundle bundle = (Bundle) v.a(parcel, Bundle.CREATOR);
                IBinder strongBinder = parcel.readStrongBinder();
                if (strongBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    hcVar = iInterfaceQueryLocalInterface instanceof fc ? (fc) iInterfaceQueryLocalInterface : new hc(strongBinder);
                }
                logEventAndBundle(string, string2, bundle, hcVar, parcel.readLong());
                break;
            case 4:
                String string3 = parcel.readString();
                String string4 = parcel.readString();
                b.i.a.f.f.a aVarG = a.AbstractBinderC0040a.g(parcel.readStrongBinder());
                ClassLoader classLoader = v.a;
                setUserProperty(string3, string4, aVarG, parcel.readInt() != 0, parcel.readLong());
                break;
            case 5:
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                ClassLoader classLoader2 = v.a;
                boolean z2 = parcel.readInt() != 0;
                IBinder strongBinder2 = parcel.readStrongBinder();
                if (strongBinder2 != null) {
                    IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    hcVar14 = iInterfaceQueryLocalInterface2 instanceof fc ? (fc) iInterfaceQueryLocalInterface2 : new hc(strongBinder2);
                }
                getUserProperties(string5, string6, z2, hcVar14);
                break;
            case 6:
                String string7 = parcel.readString();
                IBinder strongBinder3 = parcel.readStrongBinder();
                if (strongBinder3 != null) {
                    IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    hcVar13 = iInterfaceQueryLocalInterface3 instanceof fc ? (fc) iInterfaceQueryLocalInterface3 : new hc(strongBinder3);
                }
                getMaxUserProperties(string7, hcVar13);
                break;
            case 7:
                setUserId(parcel.readString(), parcel.readLong());
                break;
            case 8:
                setConditionalUserProperty((Bundle) v.a(parcel, Bundle.CREATOR), parcel.readLong());
                break;
            case 9:
                clearConditionalUserProperty(parcel.readString(), parcel.readString(), (Bundle) v.a(parcel, Bundle.CREATOR));
                break;
            case 10:
                String string8 = parcel.readString();
                String string9 = parcel.readString();
                IBinder strongBinder4 = parcel.readStrongBinder();
                if (strongBinder4 != null) {
                    IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    hcVar12 = iInterfaceQueryLocalInterface4 instanceof fc ? (fc) iInterfaceQueryLocalInterface4 : new hc(strongBinder4);
                }
                getConditionalUserProperties(string8, string9, hcVar12);
                break;
            case 11:
                ClassLoader classLoader3 = v.a;
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
                setCurrentScreen(a.AbstractBinderC0040a.g(parcel.readStrongBinder()), parcel.readString(), parcel.readString(), parcel.readLong());
                break;
            case 16:
                IBinder strongBinder5 = parcel.readStrongBinder();
                if (strongBinder5 != null) {
                    IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    hcVar11 = iInterfaceQueryLocalInterface5 instanceof fc ? (fc) iInterfaceQueryLocalInterface5 : new hc(strongBinder5);
                }
                getCurrentScreenName(hcVar11);
                break;
            case 17:
                IBinder strongBinder6 = parcel.readStrongBinder();
                if (strongBinder6 != null) {
                    IInterface iInterfaceQueryLocalInterface6 = strongBinder6.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    hcVar10 = iInterfaceQueryLocalInterface6 instanceof fc ? (fc) iInterfaceQueryLocalInterface6 : new hc(strongBinder6);
                }
                getCurrentScreenClass(hcVar10);
                break;
            case 18:
                IBinder strongBinder7 = parcel.readStrongBinder();
                if (strongBinder7 != null) {
                    IInterface iInterfaceQueryLocalInterface7 = strongBinder7.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
                    fVar = iInterfaceQueryLocalInterface7 instanceof d ? (d) iInterfaceQueryLocalInterface7 : new f(strongBinder7);
                }
                setInstanceIdProvider(fVar);
                break;
            case 19:
                IBinder strongBinder8 = parcel.readStrongBinder();
                if (strongBinder8 != null) {
                    IInterface iInterfaceQueryLocalInterface8 = strongBinder8.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    hcVar9 = iInterfaceQueryLocalInterface8 instanceof fc ? (fc) iInterfaceQueryLocalInterface8 : new hc(strongBinder8);
                }
                getCachedAppInstanceId(hcVar9);
                break;
            case 20:
                IBinder strongBinder9 = parcel.readStrongBinder();
                if (strongBinder9 != null) {
                    IInterface iInterfaceQueryLocalInterface9 = strongBinder9.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    hcVar8 = iInterfaceQueryLocalInterface9 instanceof fc ? (fc) iInterfaceQueryLocalInterface9 : new hc(strongBinder9);
                }
                getAppInstanceId(hcVar8);
                break;
            case 21:
                IBinder strongBinder10 = parcel.readStrongBinder();
                if (strongBinder10 != null) {
                    IInterface iInterfaceQueryLocalInterface10 = strongBinder10.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    hcVar7 = iInterfaceQueryLocalInterface10 instanceof fc ? (fc) iInterfaceQueryLocalInterface10 : new hc(strongBinder10);
                }
                getGmpAppId(hcVar7);
                break;
            case 22:
                IBinder strongBinder11 = parcel.readStrongBinder();
                if (strongBinder11 != null) {
                    IInterface iInterfaceQueryLocalInterface11 = strongBinder11.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    hcVar6 = iInterfaceQueryLocalInterface11 instanceof fc ? (fc) iInterfaceQueryLocalInterface11 : new hc(strongBinder11);
                }
                generateEventId(hcVar6);
                break;
            case 23:
                beginAdUnitExposure(parcel.readString(), parcel.readLong());
                break;
            case 24:
                endAdUnitExposure(parcel.readString(), parcel.readLong());
                break;
            case 25:
                onActivityStarted(a.AbstractBinderC0040a.g(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 26:
                onActivityStopped(a.AbstractBinderC0040a.g(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 27:
                onActivityCreated(a.AbstractBinderC0040a.g(parcel.readStrongBinder()), (Bundle) v.a(parcel, Bundle.CREATOR), parcel.readLong());
                break;
            case 28:
                onActivityDestroyed(a.AbstractBinderC0040a.g(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 29:
                onActivityPaused(a.AbstractBinderC0040a.g(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 30:
                onActivityResumed(a.AbstractBinderC0040a.g(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 31:
                b.i.a.f.f.a aVarG2 = a.AbstractBinderC0040a.g(parcel.readStrongBinder());
                IBinder strongBinder12 = parcel.readStrongBinder();
                if (strongBinder12 != null) {
                    IInterface iInterfaceQueryLocalInterface12 = strongBinder12.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    hcVar5 = iInterfaceQueryLocalInterface12 instanceof fc ? (fc) iInterfaceQueryLocalInterface12 : new hc(strongBinder12);
                }
                onActivitySaveInstanceState(aVarG2, hcVar5, parcel.readLong());
                break;
            case 32:
                Bundle bundle2 = (Bundle) v.a(parcel, Bundle.CREATOR);
                IBinder strongBinder13 = parcel.readStrongBinder();
                if (strongBinder13 != null) {
                    IInterface iInterfaceQueryLocalInterface13 = strongBinder13.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    hcVar4 = iInterfaceQueryLocalInterface13 instanceof fc ? (fc) iInterfaceQueryLocalInterface13 : new hc(strongBinder13);
                }
                performAction(bundle2, hcVar4, parcel.readLong());
                break;
            case 33:
                logHealthData(parcel.readInt(), parcel.readString(), a.AbstractBinderC0040a.g(parcel.readStrongBinder()), a.AbstractBinderC0040a.g(parcel.readStrongBinder()), a.AbstractBinderC0040a.g(parcel.readStrongBinder()));
                break;
            case 34:
                IBinder strongBinder14 = parcel.readStrongBinder();
                if (strongBinder14 != null) {
                    IInterface iInterfaceQueryLocalInterface14 = strongBinder14.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    eVar3 = iInterfaceQueryLocalInterface14 instanceof c ? (c) iInterfaceQueryLocalInterface14 : new e(strongBinder14);
                }
                setEventInterceptor(eVar3);
                break;
            case 35:
                IBinder strongBinder15 = parcel.readStrongBinder();
                if (strongBinder15 != null) {
                    IInterface iInterfaceQueryLocalInterface15 = strongBinder15.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    eVar2 = iInterfaceQueryLocalInterface15 instanceof c ? (c) iInterfaceQueryLocalInterface15 : new e(strongBinder15);
                }
                registerOnMeasurementEventListener(eVar2);
                break;
            case 36:
                IBinder strongBinder16 = parcel.readStrongBinder();
                if (strongBinder16 != null) {
                    IInterface iInterfaceQueryLocalInterface16 = strongBinder16.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
                    eVar = iInterfaceQueryLocalInterface16 instanceof c ? (c) iInterfaceQueryLocalInterface16 : new e(strongBinder16);
                }
                unregisterOnMeasurementEventListener(eVar);
                break;
            case 37:
                initForTests(parcel.readHashMap(v.a));
                break;
            case 38:
                IBinder strongBinder17 = parcel.readStrongBinder();
                if (strongBinder17 != null) {
                    IInterface iInterfaceQueryLocalInterface17 = strongBinder17.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    hcVar3 = iInterfaceQueryLocalInterface17 instanceof fc ? (fc) iInterfaceQueryLocalInterface17 : new hc(strongBinder17);
                }
                getTestFlag(hcVar3, parcel.readInt());
                break;
            case 39:
                ClassLoader classLoader4 = v.a;
                setDataCollectionEnabled(parcel.readInt() != 0);
                break;
            case 40:
                IBinder strongBinder18 = parcel.readStrongBinder();
                if (strongBinder18 != null) {
                    IInterface iInterfaceQueryLocalInterface18 = strongBinder18.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
                    hcVar2 = iInterfaceQueryLocalInterface18 instanceof fc ? (fc) iInterfaceQueryLocalInterface18 : new hc(strongBinder18);
                }
                isDataCollectionEnabled(hcVar2);
                break;
            case 41:
            default:
                return false;
            case 42:
                setDefaultEventParameters((Bundle) v.a(parcel, Bundle.CREATOR));
                break;
            case 43:
                clearMeasurementEnabled(parcel.readLong());
                break;
            case 44:
                setConsent((Bundle) v.a(parcel, Bundle.CREATOR), parcel.readLong());
                break;
            case 45:
                setConsentThirdParty((Bundle) v.a(parcel, Bundle.CREATOR), parcel.readLong());
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
