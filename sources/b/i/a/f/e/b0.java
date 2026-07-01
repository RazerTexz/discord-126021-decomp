package b.i.a.f.e;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.zzs;
import com.google.android.gms.dynamite.DynamiteModule;
import java.security.MessageDigest;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class b0 {
    public static final z a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final z f1345b;
    public static volatile b.i.a.f.e.k.e0 c;
    public static final Object d;
    public static Context e;

    static {
        new t(x.i("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));
        new u(x.i("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));
        a = new v(x.i("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));
        f1345b = new w(x.i("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));
        d = new Object();
    }

    public static void a() throws DynamiteModule.LoadingException {
        b.i.a.f.e.k.e0 c0Var;
        if (c != null) {
            return;
        }
        Objects.requireNonNull(e, "null reference");
        synchronized (d) {
            try {
                if (c == null) {
                    IBinder iBinderB = DynamiteModule.c(e, DynamiteModule.f3006b, "com.google.android.gms.googlecertificates").b("com.google.android.gms.common.GoogleCertificatesImpl");
                    int i = b.i.a.f.e.k.d0.a;
                    if (iBinderB == null) {
                        c0Var = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinderB.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
                        c0Var = iInterfaceQueryLocalInterface instanceof b.i.a.f.e.k.e0 ? (b.i.a.f.e.k.e0) iInterfaceQueryLocalInterface : new b.i.a.f.e.k.c0(iBinderB);
                    }
                    c = c0Var;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static g0 b(final String str, final x xVar, final boolean z2, boolean z3) {
        try {
            a();
            Objects.requireNonNull(e, "null reference");
            try {
                return c.V(new zzs(str, xVar, z2, z3), new b.i.a.f.f.b(e.getPackageManager())) ? g0.a : new f0(new Callable(z2, str, xVar) { // from class: b.i.a.f.e.s
                    public final boolean j;
                    public final String k;
                    public final x l;

                    {
                        this.j = z2;
                        this.k = str;
                        this.l = xVar;
                    }

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        boolean z4 = this.j;
                        String str2 = this.k;
                        x xVar2 = this.l;
                        Object[] objArr = new Object[5];
                        objArr[0] = true != (!z4 && b0.b(str2, xVar2, true, false).f1349b) ? "not allowed" : "debug cert rejected";
                        objArr[1] = str2;
                        MessageDigest messageDigestA = b.i.a.f.e.o.a.a(Constants.SHA1);
                        Objects.requireNonNull(messageDigestA, "null reference");
                        byte[] bArrDigest = messageDigestA.digest(xVar2.g());
                        int length = bArrDigest.length;
                        char[] cArr = new char[length + length];
                        int i = 0;
                        for (byte b2 : bArrDigest) {
                            int i2 = b2 & 255;
                            int i3 = i + 1;
                            char[] cArr2 = b.i.a.f.e.o.d.f1396b;
                            cArr[i] = cArr2[i2 >>> 4];
                            i = i3 + 1;
                            cArr[i3] = cArr2[i2 & 15];
                        }
                        objArr[2] = new String(cArr);
                        objArr[3] = Boolean.valueOf(z4);
                        objArr[4] = "12451000.false";
                        return String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", objArr);
                    }
                });
            } catch (RemoteException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                return g0.c("module call", e2);
            }
        } catch (DynamiteModule.LoadingException e3) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
            String strValueOf = String.valueOf(e3.getMessage());
            return g0.c(strValueOf.length() != 0 ? "module init: ".concat(strValueOf) : new String("module init: "), e3);
        }
    }
}
