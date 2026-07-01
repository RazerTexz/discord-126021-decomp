package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.annotation.Size;
import b.i.a.f.e.o.f;
import b.i.a.f.h.l.g;
import b.i.a.f.h.l.m;
import b.i.a.f.i.b.b7;
import b.i.c.j.b;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class FirebaseAnalytics {
    public static volatile FirebaseAnalytics a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f3109b;

    public FirebaseAnalytics(g gVar) {
        Objects.requireNonNull(gVar, "null reference");
        this.f3109b = gVar;
    }

    @NonNull
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @Keep
    public static FirebaseAnalytics getInstance(@NonNull Context context) {
        if (a == null) {
            synchronized (FirebaseAnalytics.class) {
                if (a == null) {
                    a = new FirebaseAnalytics(g.a(context, null, null, null, null));
                }
            }
        }
        return a;
    }

    @Keep
    public static b7 getScionFrontendApiImplementation(Context context, Bundle bundle) {
        g gVarA = g.a(context, null, null, null, bundle);
        if (gVarA == null) {
            return null;
        }
        return new b(gVarA);
    }

    @Keep
    public final String getFirebaseInstanceId() {
        try {
            return (String) f.k(b.i.c.u.f.f().getId(), 30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        } catch (ExecutionException e2) {
            throw new IllegalStateException(e2.getCause());
        } catch (TimeoutException unused) {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        }
    }

    @Keep
    @MainThread
    @Deprecated
    public final void setCurrentScreen(@NonNull Activity activity, @Nullable @Size(max = 36, min = 1) String str, @Nullable @Size(max = 36, min = 1) String str2) {
        g gVar = this.f3109b;
        Objects.requireNonNull(gVar);
        gVar.e.execute(new m(gVar, activity, str, str2));
    }
}
