package b.i.a.f.e;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.zzn;
import com.google.android.gms.common.zzq;
import com.google.android.gms.dynamite.DynamiteModule;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class f {
    public static f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f1348b;
    public volatile String c;

    public f(@RecentlyNonNull Context context) {
        this.f1348b = context.getApplicationContext();
    }

    @RecentlyNonNull
    public static f a(@RecentlyNonNull Context context) {
        Objects.requireNonNull(context, "null reference");
        synchronized (f.class) {
            if (a == null) {
                z zVar = b0.a;
                synchronized (b0.class) {
                    if (b0.e == null) {
                        b0.e = context.getApplicationContext();
                    } else {
                        Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
                    }
                }
                a = new f(context);
            }
        }
        return a;
    }

    public static final x c(PackageInfo packageInfo, x... xVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        y yVar = new y(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < xVarArr.length; i++) {
            if (xVarArr[i].equals(yVar)) {
                return xVarArr[i];
            }
        }
        return null;
    }

    public static final boolean d(@RecentlyNonNull PackageInfo packageInfo, boolean z2) {
        if (packageInfo != null && packageInfo.signatures != null) {
            if ((z2 ? c(packageInfo, a0.a) : c(packageInfo, a0.a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:78:0x013d  */
    public boolean b(int i) {
        g0 g0VarB;
        int length;
        boolean zH;
        g0 g0VarB2;
        ApplicationInfo applicationInfo;
        String[] packagesForUid = this.f1348b.getPackageManager().getPackagesForUid(i);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            g0VarB = null;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    Objects.requireNonNull(g0VarB, "null reference");
                    break;
                }
                String str = packagesForUid[i2];
                if (str == null) {
                    g0VarB = g0.b("null pkg");
                } else if (str.equals(this.c)) {
                    g0VarB = g0.a;
                } else {
                    z zVar = b0.a;
                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        try {
                            b0.a();
                            zH = b0.c.h();
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        } catch (Throwable th) {
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                            throw th;
                        }
                    } catch (RemoteException | DynamiteModule.LoadingException e) {
                        Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        zH = false;
                    }
                    if (zH) {
                        boolean zA = e.a(this.f1348b);
                        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads2 = StrictMode.allowThreadDiskReads();
                        try {
                            Objects.requireNonNull(b0.e, "null reference");
                            try {
                                b0.a();
                                try {
                                    zzq zzqVarH = b0.c.H(new zzn(str, zA, false, new b.i.a.f.f.b(b0.e), false));
                                    if (zzqVarH.j) {
                                        g0VarB2 = g0.a;
                                    } else {
                                        String str2 = zzqVarH.k;
                                        if (str2 == null) {
                                            str2 = "error checking package certificate";
                                        }
                                        g0VarB2 = b.i.a.f.e.o.f.k2(zzqVarH.l) == 4 ? g0.c(str2, new PackageManager.NameNotFoundException()) : g0.b(str2);
                                    }
                                } catch (RemoteException e2) {
                                    Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                                    g0VarB2 = g0.c("module call", e2);
                                }
                            } catch (DynamiteModule.LoadingException e3) {
                                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
                                String strValueOf = String.valueOf(e3.getMessage());
                                g0VarB2 = g0.c(strValueOf.length() != 0 ? "module init: ".concat(strValueOf) : new String("module init: "), e3);
                            }
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads2);
                        } catch (Throwable th2) {
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads2);
                            throw th2;
                        }
                    } else {
                        try {
                            PackageInfo packageInfo = this.f1348b.getPackageManager().getPackageInfo(str, 64);
                            boolean zA2 = e.a(this.f1348b);
                            if (packageInfo == null) {
                                g0VarB2 = g0.b("null pkg");
                            } else {
                                Signature[] signatureArr = packageInfo.signatures;
                                if (signatureArr == null || signatureArr.length != 1) {
                                    g0VarB2 = g0.b("single cert required");
                                } else {
                                    y yVar = new y(packageInfo.signatures[0].toByteArray());
                                    String str3 = packageInfo.packageName;
                                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads3 = StrictMode.allowThreadDiskReads();
                                    try {
                                        g0 g0VarB3 = b0.b(str3, yVar, zA2, false);
                                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads3);
                                        if (!g0VarB3.f1349b || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 2) == 0) {
                                            g0VarB2 = g0VarB3;
                                        } else {
                                            StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads4 = StrictMode.allowThreadDiskReads();
                                            try {
                                                g0 g0VarB4 = b0.b(str3, yVar, false, true);
                                                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads4);
                                                if (g0VarB4.f1349b) {
                                                    g0VarB2 = g0.b("debuggable release cert app rejected");
                                                } else {
                                                    g0VarB2 = g0VarB3;
                                                }
                                            } catch (Throwable th3) {
                                                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads4);
                                                throw th3;
                                            }
                                        }
                                    } catch (Throwable th4) {
                                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads3);
                                        throw th4;
                                    }
                                }
                            }
                        } catch (PackageManager.NameNotFoundException e4) {
                            g0VarB = g0.c(str.length() != 0 ? "no pkg ".concat(str) : new String("no pkg "), e4);
                        }
                    }
                    if (g0VarB2.f1349b) {
                        this.c = str;
                    }
                    g0VarB = g0VarB2;
                }
                if (g0VarB.f1349b) {
                    break;
                }
                i2++;
            }
        } else {
            g0VarB = g0.b("no pkgs");
        }
        if (!g0VarB.f1349b && Log.isLoggable("GoogleCertificatesRslt", 3)) {
            if (g0VarB.d != null) {
                Log.d("GoogleCertificatesRslt", g0VarB.a(), g0VarB.d);
            } else {
                Log.d("GoogleCertificatesRslt", g0VarB.a());
            }
        }
        return g0VarB.f1349b;
    }
}
