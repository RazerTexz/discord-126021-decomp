package b.i.a.c.e3;

import android.net.Uri;
import android.util.Base64;
import androidx.annotation.Nullable;
import b.i.a.c.f3.e0;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.DataSourceException;
import java.io.IOException;
import java.net.URLDecoder;

/* JADX INFO: compiled from: DataSchemeDataSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends g {

    @Nullable
    public n e;

    @Nullable
    public byte[] f;
    public int g;
    public int h;

    public i() {
        super(false);
    }

    @Override // b.i.a.c.e3.l
    public long a(n nVar) throws IOException {
        r(nVar);
        this.e = nVar;
        Uri uri = nVar.a;
        String scheme = uri.getScheme();
        boolean zEquals = "data".equals(scheme);
        String strValueOf = String.valueOf(scheme);
        b.c.a.a0.d.m(zEquals, strValueOf.length() != 0 ? "Unsupported scheme: ".concat(strValueOf) : new String("Unsupported scheme: "));
        String[] strArrH = e0.H(uri.getSchemeSpecificPart(), ",");
        if (strArrH.length != 2) {
            String strValueOf2 = String.valueOf(uri);
            throw new ParserException(b.d.b.a.a.j(strValueOf2.length() + 23, "Unexpected URI format: ", strValueOf2), null, true, 0);
        }
        String str = strArrH[1];
        if (strArrH[0].contains(";base64")) {
            try {
                this.f = Base64.decode(str, 0);
            } catch (IllegalArgumentException e) {
                String strValueOf3 = String.valueOf(str);
                throw new ParserException(strValueOf3.length() != 0 ? "Error while parsing Base64 encoded string: ".concat(strValueOf3) : new String("Error while parsing Base64 encoded string: "), e, true, 0);
            }
        } else {
            this.f = e0.w(URLDecoder.decode(str, b.i.b.a.c.a.name()));
        }
        long j = nVar.f;
        byte[] bArr = this.f;
        if (j > bArr.length) {
            this.f = null;
            throw new DataSourceException(2008);
        }
        int i = (int) j;
        this.g = i;
        int length = bArr.length - i;
        this.h = length;
        long j2 = nVar.g;
        if (j2 != -1) {
            this.h = (int) Math.min(length, j2);
        }
        s(nVar);
        long j3 = nVar.g;
        return j3 != -1 ? j3 : this.h;
    }

    @Override // b.i.a.c.e3.l
    public void close() {
        if (this.f != null) {
            this.f = null;
            q();
        }
        this.e = null;
    }

    @Override // b.i.a.c.e3.l
    @Nullable
    public Uri n() {
        n nVar = this.e;
        if (nVar != null) {
            return nVar.a;
        }
        return null;
    }

    @Override // b.i.a.c.e3.h
    public int read(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return 0;
        }
        int i3 = this.h;
        if (i3 == 0) {
            return -1;
        }
        int iMin = Math.min(i2, i3);
        byte[] bArr2 = this.f;
        int i4 = e0.a;
        System.arraycopy(bArr2, this.g, bArr, i, iMin);
        this.g += iMin;
        this.h -= iMin;
        p(iMin);
        return iMin;
    }
}
