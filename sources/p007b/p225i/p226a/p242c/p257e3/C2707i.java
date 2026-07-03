package p007b.p225i.p226a.p242c.p257e3;

import android.net.Uri;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.DataSourceException;
import java.io.IOException;
import java.net.URLDecoder;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p355b.p356a.C4483c;

/* JADX INFO: renamed from: b.i.a.c.e3.i */
/* JADX INFO: compiled from: DataSchemeDataSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2707i extends AbstractC2705g {

    /* JADX INFO: renamed from: e */
    @Nullable
    public C2712n f6532e;

    /* JADX INFO: renamed from: f */
    @Nullable
    public byte[] f6533f;

    /* JADX INFO: renamed from: g */
    public int f6534g;

    /* JADX INFO: renamed from: h */
    public int f6535h;

    public C2707i() {
        super(false);
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    /* JADX INFO: renamed from: a */
    public long mo2586a(C2712n c2712n) throws IOException {
        m2850r(c2712n);
        this.f6532e = c2712n;
        Uri uri = c2712n.f6542a;
        String scheme = uri.getScheme();
        boolean zEquals = "data".equals(scheme);
        String strValueOf = String.valueOf(scheme);
        C1460d.m543m(zEquals, strValueOf.length() != 0 ? "Unsupported scheme: ".concat(strValueOf) : new String("Unsupported scheme: "));
        String[] strArrM2987H = C2738e0.m2987H(uri.getSchemeSpecificPart(), ",");
        if (strArrM2987H.length != 2) {
            String strValueOf2 = String.valueOf(uri);
            throw new ParserException(C1643a.m857j(strValueOf2.length() + 23, "Unexpected URI format: ", strValueOf2), null, true, 0);
        }
        String str = strArrM2987H[1];
        if (strArrM2987H[0].contains(";base64")) {
            try {
                this.f6533f = Base64.decode(str, 0);
            } catch (IllegalArgumentException e) {
                String strValueOf3 = String.valueOf(str);
                throw new ParserException(strValueOf3.length() != 0 ? "Error while parsing Base64 encoded string: ".concat(strValueOf3) : new String("Error while parsing Base64 encoded string: "), e, true, 0);
            }
        } else {
            this.f6533f = C2738e0.m3015w(URLDecoder.decode(str, C4483c.f11943a.name()));
        }
        long j = c2712n.f6547f;
        byte[] bArr = this.f6533f;
        if (j > bArr.length) {
            this.f6533f = null;
            throw new DataSourceException(2008);
        }
        int i = (int) j;
        this.f6534g = i;
        int length = bArr.length - i;
        this.f6535h = length;
        long j2 = c2712n.f6548g;
        if (j2 != -1) {
            this.f6535h = (int) Math.min(length, j2);
        }
        m2851s(c2712n);
        long j3 = c2712n.f6548g;
        return j3 != -1 ? j3 : this.f6535h;
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    public void close() {
        if (this.f6533f != null) {
            this.f6533f = null;
            m2849q();
        }
        this.f6532e = null;
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l
    @Nullable
    /* JADX INFO: renamed from: n */
    public Uri mo2589n() {
        C2712n c2712n = this.f6532e;
        if (c2712n != null) {
            return c2712n.f6542a;
        }
        return null;
    }

    @Override // p007b.p225i.p226a.p242c.p257e3.InterfaceC2706h
    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.f6535h;
        if (i3 == 0) {
            return -1;
        }
        int iMin = Math.min(i2, i3);
        byte[] bArr2 = this.f6533f;
        int i4 = C2738e0.f6708a;
        System.arraycopy(bArr2, this.f6534g, bArr, i, iMin);
        this.f6534g += iMin;
        this.f6535h -= iMin;
        m2848p(iMin);
        return iMin;
    }
}
