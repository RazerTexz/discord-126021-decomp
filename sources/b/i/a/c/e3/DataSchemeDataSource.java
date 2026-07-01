package b.i.a.c.e3;

import android.net.Uri;
import android.util.Base64;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.f3.Util2;
import b.i.b.a.Charsets;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.DataSourceException;
import java.io.IOException;
import java.net.URLDecoder;

/* JADX INFO: renamed from: b.i.a.c.e3.i, reason: use source file name */
/* JADX INFO: compiled from: DataSchemeDataSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DataSchemeDataSource extends BaseDataSource {

    @Nullable
    public DataSpec e;

    @Nullable
    public byte[] f;
    public int g;
    public int h;

    public DataSchemeDataSource() {
        super(false);
    }

    @Override // b.i.a.c.e3.DataSource3
    public long a(DataSpec dataSpec) throws IOException {
        r(dataSpec);
        this.e = dataSpec;
        Uri uri = dataSpec.a;
        String scheme = uri.getScheme();
        boolean zEquals = "data".equals(scheme);
        String strValueOf = String.valueOf(scheme);
        AnimatableValueParser.m(zEquals, strValueOf.length() != 0 ? "Unsupported scheme: ".concat(strValueOf) : new String("Unsupported scheme: "));
        String[] strArrH = Util2.H(uri.getSchemeSpecificPart(), ",");
        if (strArrH.length != 2) {
            String strValueOf2 = String.valueOf(uri);
            throw new ParserException(outline.j(strValueOf2.length() + 23, "Unexpected URI format: ", strValueOf2), null, true, 0);
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
            this.f = Util2.w(URLDecoder.decode(str, Charsets.a.name()));
        }
        long j = dataSpec.f;
        byte[] bArr = this.f;
        if (j > bArr.length) {
            this.f = null;
            throw new DataSourceException(2008);
        }
        int i = (int) j;
        this.g = i;
        int length = bArr.length - i;
        this.h = length;
        long j2 = dataSpec.g;
        if (j2 != -1) {
            this.h = (int) Math.min(length, j2);
        }
        s(dataSpec);
        long j3 = dataSpec.g;
        return j3 != -1 ? j3 : this.h;
    }

    @Override // b.i.a.c.e3.DataSource3
    public void close() {
        if (this.f != null) {
            this.f = null;
            q();
        }
        this.e = null;
    }

    @Override // b.i.a.c.e3.DataSource3
    @Nullable
    public Uri n() {
        DataSpec dataSpec = this.e;
        if (dataSpec != null) {
            return dataSpec.a;
        }
        return null;
    }

    @Override // b.i.a.c.e3.DataReader
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
        int i4 = Util2.a;
        System.arraycopy(bArr2, this.g, bArr, i, iMin);
        this.g += iMin;
        this.h -= iMin;
        p(iMin);
        return iMin;
    }
}
