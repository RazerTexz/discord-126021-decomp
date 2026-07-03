package p007b.p225i.p226a.p288f.p299e;

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
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p311f.BinderC3423b;

/* JADX INFO: renamed from: b.i.a.f.e.f */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C3262f {

    /* JADX INFO: renamed from: a */
    public static C3262f f9313a;

    /* JADX INFO: renamed from: b */
    public final Context f9314b;

    /* JADX INFO: renamed from: c */
    public volatile String f9315c;

    public C3262f(@RecentlyNonNull Context context) {
        this.f9314b = context.getApplicationContext();
    }

    @RecentlyNonNull
    /* JADX INFO: renamed from: a */
    public static C3262f m4021a(@RecentlyNonNull Context context) {
        Objects.requireNonNull(context, "null reference");
        synchronized (C3262f.class) {
            if (f9313a == null) {
                AbstractBinderC3421z abstractBinderC3421z = C3255b0.f9301a;
                synchronized (C3255b0.class) {
                    if (C3255b0.f9305e == null) {
                        C3255b0.f9305e = context.getApplicationContext();
                    } else {
                        Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
                    }
                }
                f9313a = new C3262f(context);
            }
        }
        return f9313a;
    }

    /* JADX INFO: renamed from: c */
    public static final AbstractBinderC3419x m4022c(PackageInfo packageInfo, AbstractBinderC3419x... abstractBinderC3419xArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        BinderC3420y binderC3420y = new BinderC3420y(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < abstractBinderC3419xArr.length; i++) {
            if (abstractBinderC3419xArr[i].equals(binderC3420y)) {
                return abstractBinderC3419xArr[i];
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    public static final boolean m4023d(@RecentlyNonNull PackageInfo packageInfo, boolean z2) {
        if (packageInfo != null && packageInfo.signatures != null) {
            if ((z2 ? m4022c(packageInfo, C3253a0.f9298a) : m4022c(packageInfo, C3253a0.f9298a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:78:0x013d  */
    /* JADX INFO: renamed from: b */
    public boolean m4024b(int i) {
        C3265g0 c3265g0M4026b;
        int length;
        boolean zMo4151h;
        C3265g0 c3265g0M4026b2;
        ApplicationInfo applicationInfo;
        String[] packagesForUid = this.f9314b.getPackageManager().getPackagesForUid(i);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            c3265g0M4026b = null;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    Objects.requireNonNull(c3265g0M4026b, "null reference");
                    break;
                }
                String str = packagesForUid[i2];
                if (str == null) {
                    c3265g0M4026b = C3265g0.m4026b("null pkg");
                } else if (str.equals(this.f9315c)) {
                    c3265g0M4026b = C3265g0.f9319a;
                } else {
                    AbstractBinderC3421z abstractBinderC3421z = C3255b0.f9301a;
                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        try {
                            C3255b0.m4015a();
                            zMo4151h = C3255b0.f9303c.mo4151h();
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        } catch (Throwable th) {
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                            throw th;
                        }
                    } catch (RemoteException | DynamiteModule.LoadingException e) {
                        Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        zMo4151h = false;
                    }
                    if (zMo4151h) {
                        boolean zM4019a = C3260e.m4019a(this.f9314b);
                        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads2 = StrictMode.allowThreadDiskReads();
                        try {
                            Objects.requireNonNull(C3255b0.f9305e, "null reference");
                            try {
                                C3255b0.m4015a();
                                try {
                                    zzq zzqVarMo4149H = C3255b0.f9303c.mo4149H(new zzn(str, zM4019a, false, new BinderC3423b(C3255b0.f9305e), false));
                                    if (zzqVarMo4149H.f20564j) {
                                        c3265g0M4026b2 = C3265g0.f9319a;
                                    } else {
                                        String str2 = zzqVarMo4149H.f20565k;
                                        if (str2 == null) {
                                            str2 = "error checking package certificate";
                                        }
                                        c3265g0M4026b2 = C3404f.m4310k2(zzqVarMo4149H.f20566l) == 4 ? C3265g0.m4027c(str2, new PackageManager.NameNotFoundException()) : C3265g0.m4026b(str2);
                                    }
                                } catch (RemoteException e2) {
                                    Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                                    c3265g0M4026b2 = C3265g0.m4027c("module call", e2);
                                }
                            } catch (DynamiteModule.LoadingException e3) {
                                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
                                String strValueOf = String.valueOf(e3.getMessage());
                                c3265g0M4026b2 = C3265g0.m4027c(strValueOf.length() != 0 ? "module init: ".concat(strValueOf) : new String("module init: "), e3);
                            }
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads2);
                        } catch (Throwable th2) {
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads2);
                            throw th2;
                        }
                    } else {
                        try {
                            PackageInfo packageInfo = this.f9314b.getPackageManager().getPackageInfo(str, 64);
                            boolean zM4019a2 = C3260e.m4019a(this.f9314b);
                            if (packageInfo == null) {
                                c3265g0M4026b2 = C3265g0.m4026b("null pkg");
                            } else {
                                Signature[] signatureArr = packageInfo.signatures;
                                if (signatureArr == null || signatureArr.length != 1) {
                                    c3265g0M4026b2 = C3265g0.m4026b("single cert required");
                                } else {
                                    BinderC3420y binderC3420y = new BinderC3420y(packageInfo.signatures[0].toByteArray());
                                    String str3 = packageInfo.packageName;
                                    StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads3 = StrictMode.allowThreadDiskReads();
                                    try {
                                        C3265g0 c3265g0M4016b = C3255b0.m4016b(str3, binderC3420y, zM4019a2, false);
                                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads3);
                                        if (!c3265g0M4016b.f9320b || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 2) == 0) {
                                            c3265g0M4026b2 = c3265g0M4016b;
                                        } else {
                                            StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads4 = StrictMode.allowThreadDiskReads();
                                            try {
                                                C3265g0 c3265g0M4016b2 = C3255b0.m4016b(str3, binderC3420y, false, true);
                                                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads4);
                                                if (c3265g0M4016b2.f9320b) {
                                                    c3265g0M4026b2 = C3265g0.m4026b("debuggable release cert app rejected");
                                                } else {
                                                    c3265g0M4026b2 = c3265g0M4016b;
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
                            c3265g0M4026b = C3265g0.m4027c(str.length() != 0 ? "no pkg ".concat(str) : new String("no pkg "), e4);
                        }
                    }
                    if (c3265g0M4026b2.f9320b) {
                        this.f9315c = str;
                    }
                    c3265g0M4026b = c3265g0M4026b2;
                }
                if (c3265g0M4026b.f9320b) {
                    break;
                }
                i2++;
            }
        } else {
            c3265g0M4026b = C3265g0.m4026b("no pkgs");
        }
        if (!c3265g0M4026b.f9320b && Log.isLoggable("GoogleCertificatesRslt", 3)) {
            if (c3265g0M4026b.f9322d != null) {
                Log.d("GoogleCertificatesRslt", c3265g0M4026b.mo4025a(), c3265g0M4026b.f9322d);
            } else {
                Log.d("GoogleCertificatesRslt", c3265g0M4026b.mo4025a());
            }
        }
        return c3265g0M4026b.f9320b;
    }
}
