package p007b.p225i.p226a.p288f.p299e;

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
import p007b.p225i.p226a.p288f.p299e.p304k.AbstractBinderC3350d0;
import p007b.p225i.p226a.p288f.p299e.p304k.C3348c0;
import p007b.p225i.p226a.p288f.p299e.p304k.InterfaceC3352e0;
import p007b.p225i.p226a.p288f.p299e.p308o.C3399a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3402d;
import p007b.p225i.p226a.p288f.p311f.BinderC3423b;

/* JADX INFO: renamed from: b.i.a.f.e.b0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3255b0 {

    /* JADX INFO: renamed from: a */
    public static final AbstractBinderC3421z f9301a;

    /* JADX INFO: renamed from: b */
    public static final AbstractBinderC3421z f9302b;

    /* JADX INFO: renamed from: c */
    public static volatile InterfaceC3352e0 f9303c;

    /* JADX INFO: renamed from: d */
    public static final Object f9304d;

    /* JADX INFO: renamed from: e */
    public static Context f9305e;

    static {
        new BinderC3415t(AbstractBinderC3419x.m4378i("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));
        new BinderC3416u(AbstractBinderC3419x.m4378i("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));
        f9301a = new BinderC3417v(AbstractBinderC3419x.m4378i("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));
        f9302b = new BinderC3418w(AbstractBinderC3419x.m4378i("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));
        f9304d = new Object();
    }

    /* JADX INFO: renamed from: a */
    public static void m4015a() throws DynamiteModule.LoadingException {
        InterfaceC3352e0 c3348c0;
        if (f9303c != null) {
            return;
        }
        Objects.requireNonNull(f9305e, "null reference");
        synchronized (f9304d) {
            try {
                if (f9303c == null) {
                    IBinder iBinderM9050b = DynamiteModule.m9043c(f9305e, DynamiteModule.f20572b, "com.google.android.gms.googlecertificates").m9050b("com.google.android.gms.common.GoogleCertificatesImpl");
                    int i = AbstractBinderC3350d0.f9516a;
                    if (iBinderM9050b == null) {
                        c3348c0 = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinderM9050b.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
                        c3348c0 = iInterfaceQueryLocalInterface instanceof InterfaceC3352e0 ? (InterfaceC3352e0) iInterfaceQueryLocalInterface : new C3348c0(iBinderM9050b);
                    }
                    f9303c = c3348c0;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static C3265g0 m4016b(final String str, final AbstractBinderC3419x abstractBinderC3419x, final boolean z2, boolean z3) {
        try {
            m4015a();
            Objects.requireNonNull(f9305e, "null reference");
            try {
                return f9303c.mo4150V(new zzs(str, abstractBinderC3419x, z2, z3), new BinderC3423b(f9305e.getPackageManager())) ? C3265g0.f9319a : new C3263f0(new Callable(z2, str, abstractBinderC3419x) { // from class: b.i.a.f.e.s

                    /* JADX INFO: renamed from: j */
                    public final boolean f9608j;

                    /* JADX INFO: renamed from: k */
                    public final String f9609k;

                    /* JADX INFO: renamed from: l */
                    public final AbstractBinderC3419x f9610l;

                    {
                        this.f9608j = z2;
                        this.f9609k = str;
                        this.f9610l = abstractBinderC3419x;
                    }

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        boolean z4 = this.f9608j;
                        String str2 = this.f9609k;
                        AbstractBinderC3419x abstractBinderC3419x2 = this.f9610l;
                        Object[] objArr = new Object[5];
                        objArr[0] = true != (!z4 && C3255b0.m4016b(str2, abstractBinderC3419x2, true, false).f9320b) ? "not allowed" : "debug cert rejected";
                        objArr[1] = str2;
                        MessageDigest messageDigestM4185a = C3399a.m4185a(Constants.SHA1);
                        Objects.requireNonNull(messageDigestM4185a, "null reference");
                        byte[] bArrDigest = messageDigestM4185a.digest(abstractBinderC3419x2.mo4379g());
                        int length = bArrDigest.length;
                        char[] cArr = new char[length + length];
                        int i = 0;
                        for (byte b2 : bArrDigest) {
                            int i2 = b2 & 255;
                            int i3 = i + 1;
                            char[] cArr2 = C3402d.f9586b;
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
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
                return C3265g0.m4027c("module call", e);
            }
        } catch (DynamiteModule.LoadingException e2) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            String strValueOf = String.valueOf(e2.getMessage());
            return C3265g0.m4027c(strValueOf.length() != 0 ? "module init: ".concat(strValueOf) : new String("module init: "), e2);
        }
    }
}
