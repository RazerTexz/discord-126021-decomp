package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import b.d.b.a.a;
import b.i.a.f.h.e.c;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"HandlerLeak"})
public class GoogleApiAvailability$a extends c {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GoogleApiAvailability f3002b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoogleApiAvailability$a(GoogleApiAvailability googleApiAvailability, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.f3002b = googleApiAvailability;
        this.a = context.getApplicationContext();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i != 1) {
            a.g0(50, "Don't know how to handle this message: ", i, "GoogleApiAvailability");
            return;
        }
        int iC = this.f3002b.c(this.a);
        if (this.f3002b.d(iC)) {
            GoogleApiAvailability googleApiAvailability = this.f3002b;
            Context context = this.a;
            Intent intentA = googleApiAvailability.a(context, iC, "n");
            googleApiAvailability.i(context, iC, intentA == null ? null : PendingIntent.getActivity(context, 0, intentA, 134217728));
        }
    }
}
