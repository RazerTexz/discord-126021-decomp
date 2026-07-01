package b.i.a.f.e;

import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.f.e.k.y0;
import b.i.a.f.e.k.z0;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class x extends y0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1401b;

    public x(byte[] bArr) {
        AnimatableValueParser.l(bArr.length == 25);
        this.f1401b = Arrays.hashCode(bArr);
    }

    public static byte[] i(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    @Override // b.i.a.f.e.k.z0
    public final b.i.a.f.f.a d() {
        return new b.i.a.f.f.b(g());
    }

    @Override // b.i.a.f.e.k.z0
    public final int e() {
        return this.f1401b;
    }

    public final boolean equals(@Nullable Object obj) {
        b.i.a.f.f.a aVarD;
        if (obj != null && (obj instanceof z0)) {
            try {
                z0 z0Var = (z0) obj;
                if (z0Var.e() == this.f1401b && (aVarD = z0Var.d()) != null) {
                    return Arrays.equals(g(), (byte[]) b.i.a.f.f.b.i(aVarD));
                }
                return false;
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            }
        }
        return false;
    }

    public abstract byte[] g();

    public final int hashCode() {
        return this.f1401b;
    }
}
