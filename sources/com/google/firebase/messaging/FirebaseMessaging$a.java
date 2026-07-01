package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import android.os.Bundle;
import androidx.annotation.Nullable;
import b.i.c.a;
import b.i.c.c;
import b.i.c.q.b;
import b.i.c.q.d;
import b.i.c.w.j;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class FirebaseMessaging$a {
    public final d a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3113b;

    @Nullable
    public b<a> c;

    @Nullable
    public Boolean d;
    public final /* synthetic */ FirebaseMessaging e;

    public FirebaseMessaging$a(FirebaseMessaging firebaseMessaging, d dVar) {
        this.e = firebaseMessaging;
        this.a = dVar;
    }

    public synchronized void a() {
        if (this.f3113b) {
            return;
        }
        Boolean boolC = c();
        this.d = boolC;
        if (boolC == null) {
            j jVar = new j(this);
            this.c = jVar;
            this.a.a(a.class, jVar);
        }
        this.f3113b = true;
    }

    public synchronized boolean b() {
        a();
        Boolean bool = this.d;
        if (bool != null) {
            return bool.booleanValue();
        }
        return this.e.c.g();
    }

    @Nullable
    public final Boolean c() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        c cVar = this.e.c;
        cVar.a();
        Context context = cVar.d;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.firebase.messaging", 0);
        if (sharedPreferences.contains("auto_init")) {
            return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                return null;
            }
            return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
        } catch (PackageManager$NameNotFoundException unused) {
            return null;
        }
    }
}
