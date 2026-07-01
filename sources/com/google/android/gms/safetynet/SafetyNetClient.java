package com.google.android.gms.safetynet;

import android.app.Activity;
import android.os.Looper;
import androidx.annotation.NonNull;
import b.c.a.a0.d;
import b.i.a.f.e.h.a;
import b.i.a.f.e.h.a$d;
import b.i.a.f.e.h.a$d$c;
import b.i.a.f.e.h.b;
import b.i.a.f.e.h.b$a;

/* JADX INFO: loaded from: classes3.dex */
public class SafetyNetClient extends b<a$d$c> {
    public SafetyNetClient(@NonNull Activity activity) {
        a<a$d$c> aVar = b.i.a.f.k.a.c;
        b.i.a.f.e.h.j.a aVar2 = new b.i.a.f.e.h.j.a();
        d.z(aVar2, "StatusExceptionMapper must not be null.");
        Looper mainLooper = activity.getMainLooper();
        d.z(mainLooper, "Looper must not be null.");
        super(activity, (a<a$d>) aVar, (a$d) null, new b$a(aVar2, null, mainLooper));
    }
}
