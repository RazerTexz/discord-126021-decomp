package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import b.i.a.f.h.l.c;
import b.i.a.f.i.b.z5;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-sdk@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class AppMeasurementDynamiteService$b implements z5 {
    public c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppMeasurementDynamiteService f3011b;

    public AppMeasurementDynamiteService$b(AppMeasurementDynamiteService appMeasurementDynamiteService, c cVar) {
        this.f3011b = appMeasurementDynamiteService;
        this.a = cVar;
    }

    @Override // b.i.a.f.i.b.z5
    public final void a(String str, String str2, Bundle bundle, long j) {
        try {
            this.a.Z(str, str2, bundle, j);
        } catch (RemoteException e) {
            this.f3011b.a.g().i.b("Event listener threw exception", e);
        }
    }
}
