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
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p313h.p325l.C3661g;
import p007b.p225i.p226a.p288f.p313h.p325l.C3742m;
import p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC3988b7;
import p007b.p225i.p361c.p362j.C4559b;
import p007b.p225i.p361c.p401u.C4842f;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class FirebaseAnalytics {

    /* JADX INFO: renamed from: a */
    public static volatile FirebaseAnalytics f21403a;

    /* JADX INFO: renamed from: b */
    public final C3661g f21404b;

    public FirebaseAnalytics(C3661g c3661g) {
        Objects.requireNonNull(c3661g, "null reference");
        this.f21404b = c3661g;
    }

    @NonNull
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    @Keep
    public static FirebaseAnalytics getInstance(@NonNull Context context) {
        if (f21403a == null) {
            synchronized (FirebaseAnalytics.class) {
                if (f21403a == null) {
                    f21403a = new FirebaseAnalytics(C3661g.m4882a(context, null, null, null, null));
                }
            }
        }
        return f21403a;
    }

    @Keep
    public static InterfaceC3988b7 getScionFrontendApiImplementation(Context context, Bundle bundle) {
        C3661g c3661gM4882a = C3661g.m4882a(context, null, null, null, bundle);
        if (c3661gM4882a == null) {
            return null;
        }
        return new C4559b(c3661gM4882a);
    }

    @Keep
    public final String getFirebaseInstanceId() {
        try {
            return (String) C3404f.m4307k(C4842f.m6755f().getId(), 30000L, TimeUnit.MILLISECONDS);
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
        C3661g c3661g = this.f21404b;
        Objects.requireNonNull(c3661g);
        c3661g.f9950e.execute(new C3742m(c3661g, activity, str, str2));
    }
}
