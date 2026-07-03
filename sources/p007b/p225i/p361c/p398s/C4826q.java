package p007b.p225i.p361c.p398s;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import java.util.List;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p361c.C4542c;

/* JADX INFO: renamed from: b.i.c.s.q */
/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C4826q {

    /* JADX INFO: renamed from: a */
    public final Context f12885a;

    /* JADX INFO: renamed from: b */
    public String f12886b;

    /* JADX INFO: renamed from: c */
    public String f12887c;

    /* JADX INFO: renamed from: d */
    public int f12888d;

    /* JADX INFO: renamed from: e */
    public int f12889e = 0;

    public C4826q(Context context) {
        this.f12885a = context;
    }

    /* JADX INFO: renamed from: b */
    public static String m6730b(C4542c c4542c) {
        c4542c.m6330a();
        String str = c4542c.f12120f.f12138e;
        if (str != null) {
            return str;
        }
        c4542c.m6330a();
        String str2 = c4542c.f12120f.f12135b;
        if (!str2.startsWith("1:")) {
            return str2;
        }
        String[] strArrSplit = str2.split(":");
        if (strArrSplit.length < 2) {
            return null;
        }
        String str3 = strArrSplit[1];
        if (str3.isEmpty()) {
            return null;
        }
        return str3;
    }

    /* JADX INFO: renamed from: a */
    public synchronized String m6731a() {
        if (this.f12886b == null) {
            m6734e();
        }
        return this.f12886b;
    }

    /* JADX INFO: renamed from: c */
    public final PackageInfo m6732c(String str) {
        try {
            return this.f12885a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            String strValueOf = String.valueOf(e);
            C1643a.m854h0(strValueOf.length() + 23, "Failed to find package ", strValueOf, "FirebaseInstanceId");
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0048 A[Catch: all -> 0x007f, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x000a, B:10:0x001b, B:13:0x0025, B:15:0x002b, B:17:0x003d, B:19:0x0043, B:22:0x0048, B:24:0x005b, B:26:0x0061, B:29:0x0066, B:31:0x0073, B:33:0x0078, B:32:0x0076), top: B:41:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0066 A[Catch: all -> 0x007f, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x000a, B:10:0x001b, B:13:0x0025, B:15:0x002b, B:17:0x003d, B:19:0x0043, B:22:0x0048, B:24:0x005b, B:26:0x0061, B:29:0x0066, B:31:0x0073, B:33:0x0078, B:32:0x0076), top: B:41:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0073 A[Catch: all -> 0x007f, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x000a, B:10:0x001b, B:13:0x0025, B:15:0x002b, B:17:0x003d, B:19:0x0043, B:22:0x0048, B:24:0x005b, B:26:0x0061, B:29:0x0066, B:31:0x0073, B:33:0x0078, B:32:0x0076), top: B:41:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x0076 A[Catch: all -> 0x007f, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x000a, B:10:0x001b, B:13:0x0025, B:15:0x002b, B:17:0x003d, B:19:0x0043, B:22:0x0048, B:24:0x005b, B:26:0x0061, B:29:0x0066, B:31:0x0073, B:33:0x0078, B:32:0x0076), top: B:41:0x0001 }] */
    /* JADX INFO: renamed from: d */
    public boolean m6733d() {
        int i;
        List<ResolveInfo> listQueryBroadcastReceivers;
        synchronized (this) {
            i = this.f12889e;
            if (i == 0) {
                PackageManager packageManager = this.f12885a.getPackageManager();
                if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
                    Log.e("FirebaseInstanceId", "Google Play services missing or without correct permission.");
                    i = 0;
                } else if (C3404f.m4190A0()) {
                    Intent intent = new Intent("com.google.iid.TOKEN_REQUEST");
                    intent.setPackage("com.google.android.gms");
                    listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 0);
                    if (listQueryBroadcastReceivers != null) {
                        Log.w("FirebaseInstanceId", "Failed to resolve IID implementation package, falling back");
                        if (C3404f.m4190A0()) {
                            this.f12889e = 2;
                        } else {
                            this.f12889e = 1;
                        }
                        i = this.f12889e;
                    } else {
                        Log.w("FirebaseInstanceId", "Failed to resolve IID implementation package, falling back");
                        if (C3404f.m4190A0()) {
                            this.f12889e = 2;
                        } else {
                            this.f12889e = 1;
                        }
                        i = this.f12889e;
                    }
                } else {
                    Intent intent2 = new Intent("com.google.android.c2dm.intent.REGISTER");
                    intent2.setPackage("com.google.android.gms");
                    List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent2, 0);
                    if (listQueryIntentServices == null || listQueryIntentServices.size() <= 0) {
                        Intent intent3 = new Intent("com.google.iid.TOKEN_REQUEST");
                        intent3.setPackage("com.google.android.gms");
                        listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent3, 0);
                        if (listQueryBroadcastReceivers != null || listQueryBroadcastReceivers.size() <= 0) {
                            Log.w("FirebaseInstanceId", "Failed to resolve IID implementation package, falling back");
                            if (C3404f.m4190A0()) {
                                this.f12889e = 2;
                            } else {
                                this.f12889e = 1;
                            }
                            i = this.f12889e;
                        } else {
                            this.f12889e = 2;
                            i = 2;
                        }
                    } else {
                        this.f12889e = 1;
                        i = 1;
                    }
                }
            }
        }
        return i != 0;
    }

    /* JADX INFO: renamed from: e */
    public final synchronized void m6734e() {
        PackageInfo packageInfoM6732c = m6732c(this.f12885a.getPackageName());
        if (packageInfoM6732c != null) {
            this.f12886b = Integer.toString(packageInfoM6732c.versionCode);
            this.f12887c = packageInfoM6732c.versionName;
        }
    }
}
