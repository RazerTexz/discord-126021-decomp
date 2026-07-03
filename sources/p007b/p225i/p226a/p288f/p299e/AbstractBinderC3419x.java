package p007b.p225i.p226a.p288f.p299e;

import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p299e.p304k.AbstractBinderC3392y0;
import p007b.p225i.p226a.p288f.p299e.p304k.InterfaceC3394z0;
import p007b.p225i.p226a.p288f.p311f.BinderC3423b;
import p007b.p225i.p226a.p288f.p311f.InterfaceC3422a;

/* JADX INFO: renamed from: b.i.a.f.e.x */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractBinderC3419x extends AbstractBinderC3392y0 {

    /* JADX INFO: renamed from: b */
    public final int f9611b;

    public AbstractBinderC3419x(byte[] bArr) {
        C1460d.m539l(bArr.length == 25);
        this.f9611b = Arrays.hashCode(bArr);
    }

    /* JADX INFO: renamed from: i */
    public static byte[] m4378i(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.InterfaceC3394z0
    /* JADX INFO: renamed from: d */
    public final InterfaceC3422a mo4177d() {
        return new BinderC3423b(mo4379g());
    }

    @Override // p007b.p225i.p226a.p288f.p299e.p304k.InterfaceC3394z0
    /* JADX INFO: renamed from: e */
    public final int mo4178e() {
        return this.f9611b;
    }

    public final boolean equals(@Nullable Object obj) {
        InterfaceC3422a interfaceC3422aMo4177d;
        if (obj != null && (obj instanceof InterfaceC3394z0)) {
            try {
                InterfaceC3394z0 interfaceC3394z0 = (InterfaceC3394z0) obj;
                if (interfaceC3394z0.mo4178e() == this.f9611b && (interfaceC3422aMo4177d = interfaceC3394z0.mo4177d()) != null) {
                    return Arrays.equals(mo4379g(), (byte[]) BinderC3423b.m4381i(interfaceC3422aMo4177d));
                }
                return false;
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: g */
    public abstract byte[] mo4379g();

    public final int hashCode() {
        return this.f9611b;
    }
}
