package p007b.p225i.p226a.p288f.p313h.p325l;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzae;
import java.util.Map;
import p007b.p225i.p226a.p288f.p311f.InterfaceC3422a;

/* JADX INFO: renamed from: b.i.a.f.h.l.ec */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC3646ec extends IInterface {
    void beginAdUnitExposure(String str, long j) throws RemoteException;

    void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException;

    void clearMeasurementEnabled(long j) throws RemoteException;

    void endAdUnitExposure(String str, long j) throws RemoteException;

    void generateEventId(InterfaceC3660fc interfaceC3660fc) throws RemoteException;

    void getAppInstanceId(InterfaceC3660fc interfaceC3660fc) throws RemoteException;

    void getCachedAppInstanceId(InterfaceC3660fc interfaceC3660fc) throws RemoteException;

    void getConditionalUserProperties(String str, String str2, InterfaceC3660fc interfaceC3660fc) throws RemoteException;

    void getCurrentScreenClass(InterfaceC3660fc interfaceC3660fc) throws RemoteException;

    void getCurrentScreenName(InterfaceC3660fc interfaceC3660fc) throws RemoteException;

    void getGmpAppId(InterfaceC3660fc interfaceC3660fc) throws RemoteException;

    void getMaxUserProperties(String str, InterfaceC3660fc interfaceC3660fc) throws RemoteException;

    void getTestFlag(InterfaceC3660fc interfaceC3660fc, int i) throws RemoteException;

    void getUserProperties(String str, String str2, boolean z2, InterfaceC3660fc interfaceC3660fc) throws RemoteException;

    void initForTests(Map map) throws RemoteException;

    void initialize(InterfaceC3422a interfaceC3422a, zzae zzaeVar, long j) throws RemoteException;

    void isDataCollectionEnabled(InterfaceC3660fc interfaceC3660fc) throws RemoteException;

    void logEvent(String str, String str2, Bundle bundle, boolean z2, boolean z3, long j) throws RemoteException;

    void logEventAndBundle(String str, String str2, Bundle bundle, InterfaceC3660fc interfaceC3660fc, long j) throws RemoteException;

    void logHealthData(int i, String str, InterfaceC3422a interfaceC3422a, InterfaceC3422a interfaceC3422a2, InterfaceC3422a interfaceC3422a3) throws RemoteException;

    void onActivityCreated(InterfaceC3422a interfaceC3422a, Bundle bundle, long j) throws RemoteException;

    void onActivityDestroyed(InterfaceC3422a interfaceC3422a, long j) throws RemoteException;

    void onActivityPaused(InterfaceC3422a interfaceC3422a, long j) throws RemoteException;

    void onActivityResumed(InterfaceC3422a interfaceC3422a, long j) throws RemoteException;

    void onActivitySaveInstanceState(InterfaceC3422a interfaceC3422a, InterfaceC3660fc interfaceC3660fc, long j) throws RemoteException;

    void onActivityStarted(InterfaceC3422a interfaceC3422a, long j) throws RemoteException;

    void onActivityStopped(InterfaceC3422a interfaceC3422a, long j) throws RemoteException;

    void performAction(Bundle bundle, InterfaceC3660fc interfaceC3660fc, long j) throws RemoteException;

    void registerOnMeasurementEventListener(InterfaceC3605c interfaceC3605c) throws RemoteException;

    void resetAnalyticsData(long j) throws RemoteException;

    void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException;

    void setConsent(Bundle bundle, long j) throws RemoteException;

    void setConsentThirdParty(Bundle bundle, long j) throws RemoteException;

    void setCurrentScreen(InterfaceC3422a interfaceC3422a, String str, String str2, long j) throws RemoteException;

    void setDataCollectionEnabled(boolean z2) throws RemoteException;

    void setDefaultEventParameters(Bundle bundle) throws RemoteException;

    void setEventInterceptor(InterfaceC3605c interfaceC3605c) throws RemoteException;

    void setInstanceIdProvider(InterfaceC3619d interfaceC3619d) throws RemoteException;

    void setMeasurementEnabled(boolean z2, long j) throws RemoteException;

    void setMinimumSessionDuration(long j) throws RemoteException;

    void setSessionTimeoutDuration(long j) throws RemoteException;

    void setUserId(String str, long j) throws RemoteException;

    void setUserProperty(String str, String str2, InterfaceC3422a interfaceC3422a, boolean z2, long j) throws RemoteException;

    void unregisterOnMeasurementEventListener(InterfaceC3605c interfaceC3605c) throws RemoteException;
}
