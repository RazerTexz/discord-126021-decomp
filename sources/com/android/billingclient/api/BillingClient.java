package com.android.billingclient.api;

import android.app.Activity;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.UiThread;
import b.d.a.a.b;
import b.d.a.a.d;
import b.d.a.a.e;
import b.d.a.a.f;
import b.d.a.a.h;
import b.d.a.a.i;

/* JADX INFO: compiled from: com.android.billingclient:billing@@4.0.0 */
/* JADX INFO: loaded from: classes.dex */
public abstract class BillingClient {
    @AnyThread
    public abstract void a(@NonNull d dVar, @NonNull e eVar);

    @AnyThread
    public abstract void b();

    @AnyThread
    public abstract int c();

    @AnyThread
    public abstract boolean d();

    @NonNull
    @UiThread
    public abstract BillingResult e(@NonNull Activity activity, @NonNull BillingFlowParams billingFlowParams);

    @AnyThread
    public abstract void f(@NonNull String str, @NonNull f fVar);

    @AnyThread
    public abstract void g(@NonNull h hVar, @NonNull i iVar);

    @AnyThread
    public abstract void h(@NonNull b bVar);
}
