package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import androidx.core.view.PointerIconCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import p007b.p225i.p226a.p242c.p257e3.C2712n;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: loaded from: classes3.dex */
public class HttpDataSource$HttpDataSourceException extends DataSourceException {
    public final C2712n dataSpec;
    public final int type;

    public HttpDataSource$HttpDataSourceException(C2712n c2712n, int i, int i2) {
        super(m8937a(i, i2));
        this.dataSpec = c2712n;
        this.type = i2;
    }

    /* JADX INFO: renamed from: a */
    public static int m8937a(int i, int i2) {
        if (i == 2000 && i2 == 1) {
            return 2001;
        }
        return i;
    }

    /* JADX INFO: renamed from: b */
    public static HttpDataSource$HttpDataSourceException m8938b(final IOException iOException, final C2712n c2712n, int i) {
        int i2;
        String message = iOException.getMessage();
        if (iOException instanceof SocketTimeoutException) {
            i2 = 2002;
        } else if (iOException instanceof InterruptedIOException) {
            i2 = PointerIconCompat.TYPE_WAIT;
        } else {
            i2 = (message == null || !C3404f.m4349u1(message).matches("cleartext.*not permitted.*")) ? 2001 : 2007;
        }
        return i2 == 2007 ? new HttpDataSource$HttpDataSourceException(iOException, c2712n) { // from class: com.google.android.exoplayer2.upstream.HttpDataSource$CleartextNotPermittedException
        } : new HttpDataSource$HttpDataSourceException(iOException, c2712n, i2, i);
    }

    public HttpDataSource$HttpDataSourceException(String str, C2712n c2712n, int i, int i2) {
        super(str, m8937a(i, i2));
        this.dataSpec = c2712n;
        this.type = i2;
    }

    public HttpDataSource$HttpDataSourceException(IOException iOException, C2712n c2712n, int i, int i2) {
        super(iOException, m8937a(i, i2));
        this.dataSpec = c2712n;
        this.type = i2;
    }

    public HttpDataSource$HttpDataSourceException(String str, @Nullable IOException iOException, C2712n c2712n, int i, int i2) {
        super(str, iOException, m8937a(i, i2));
        this.dataSpec = c2712n;
        this.type = i2;
    }
}
