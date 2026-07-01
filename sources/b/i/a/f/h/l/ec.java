package b.i.a.f.h.l;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzae;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface ec extends IInterface {
    void beginAdUnitExposure(String str, long j) throws RemoteException;

    void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException;

    void clearMeasurementEnabled(long j) throws RemoteException;

    void endAdUnitExposure(String str, long j) throws RemoteException;

    void generateEventId(fc fcVar) throws RemoteException;

    void getAppInstanceId(fc fcVar) throws RemoteException;

    void getCachedAppInstanceId(fc fcVar) throws RemoteException;

    void getConditionalUserProperties(String str, String str2, fc fcVar) throws RemoteException;

    void getCurrentScreenClass(fc fcVar) throws RemoteException;

    void getCurrentScreenName(fc fcVar) throws RemoteException;

    void getGmpAppId(fc fcVar) throws RemoteException;

    void getMaxUserProperties(String str, fc fcVar) throws RemoteException;

    void getTestFlag(fc fcVar, int i) throws RemoteException;

    void getUserProperties(String str, String str2, boolean z2, fc fcVar) throws RemoteException;

    void initForTests(Map map) throws RemoteException;

    void initialize(b.i.a.f.f.a aVar, zzae zzaeVar, long j) throws RemoteException;

    void isDataCollectionEnabled(fc fcVar) throws RemoteException;

    void logEvent(String str, String str2, Bundle bundle, boolean z2, boolean z3, long j) throws RemoteException;

    void logEventAndBundle(String str, String str2, Bundle bundle, fc fcVar, long j) throws RemoteException;

    void logHealthData(int i, String str, b.i.a.f.f.a aVar, b.i.a.f.f.a aVar2, b.i.a.f.f.a aVar3) throws RemoteException;

    void onActivityCreated(b.i.a.f.f.a aVar, Bundle bundle, long j) throws RemoteException;

    void onActivityDestroyed(b.i.a.f.f.a aVar, long j) throws RemoteException;

    void onActivityPaused(b.i.a.f.f.a aVar, long j) throws RemoteException;

    void onActivityResumed(b.i.a.f.f.a aVar, long j) throws RemoteException;

    void onActivitySaveInstanceState(b.i.a.f.f.a aVar, fc fcVar, long j) throws RemoteException;

    void onActivityStarted(b.i.a.f.f.a aVar, long j) throws RemoteException;

    void onActivityStopped(b.i.a.f.f.a aVar, long j) throws RemoteException;

    void performAction(Bundle bundle, fc fcVar, long j) throws RemoteException;

    void registerOnMeasurementEventListener(c cVar) throws RemoteException;

    void resetAnalyticsData(long j) throws RemoteException;

    void setConditionalUserProperty(Bundle bundle, long j) throws RemoteException;

    void setConsent(Bundle bundle, long j) throws RemoteException;

    void setConsentThirdParty(Bundle bundle, long j) throws RemoteException;

    void setCurrentScreen(b.i.a.f.f.a aVar, String str, String str2, long j) throws RemoteException;

    void setDataCollectionEnabled(boolean z2) throws RemoteException;

    void setDefaultEventParameters(Bundle bundle) throws RemoteException;

    void setEventInterceptor(c cVar) throws RemoteException;

    void setInstanceIdProvider(d dVar) throws RemoteException;

    void setMeasurementEnabled(boolean z2, long j) throws RemoteException;

    void setMinimumSessionDuration(long j) throws RemoteException;

    void setSessionTimeoutDuration(long j) throws RemoteException;

    void setUserId(String str, long j) throws RemoteException;

    void setUserProperty(String str, String str2, b.i.a.f.f.a aVar, boolean z2, long j) throws RemoteException;

    void unregisterOnMeasurementEventListener(c cVar) throws RemoteException;
}
