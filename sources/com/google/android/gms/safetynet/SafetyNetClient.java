package com.google.android.gms.safetynet;

import android.app.Activity;
import android.os.Looper;
import androidx.annotation.NonNull;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p300h.C3266a;
import p007b.p225i.p226a.p288f.p299e.p300h.C3267b;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3275a;
import p007b.p225i.p226a.p288f.p336k.C4327a;

/* JADX INFO: loaded from: classes3.dex */
public class SafetyNetClient extends C3267b<C3266a.d.c> {
    public SafetyNetClient(@NonNull Activity activity) {
        C3266a<C3266a.d.c> c3266a = C4327a.f11445c;
        C3275a c3275a = new C3275a();
        C1460d.m595z(c3275a, "StatusExceptionMapper must not be null.");
        Looper mainLooper = activity.getMainLooper();
        C1460d.m595z(mainLooper, "Looper must not be null.");
        super(activity, (C3266a<C3266a.d>) c3266a, (C3266a.d) null, new C3267b.a(c3275a, null, mainLooper));
    }
}
