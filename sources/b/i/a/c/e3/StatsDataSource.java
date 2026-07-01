package b.i.a.c.e3;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.e3.y, reason: use source file name */
/* JADX INFO: compiled from: StatsDataSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class StatsDataSource implements DataSource3 {
    public final DataSource3 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f956b;
    public Uri c;
    public Map<String, List<String>> d;

    public StatsDataSource(DataSource3 dataSource3) {
        Objects.requireNonNull(dataSource3);
        this.a = dataSource3;
        this.c = Uri.EMPTY;
        this.d = Collections.emptyMap();
    }

    @Override // b.i.a.c.e3.DataSource3
    public long a(DataSpec dataSpec) throws IOException {
        this.c = dataSpec.a;
        this.d = Collections.emptyMap();
        long jA = this.a.a(dataSpec);
        Uri uriN = n();
        Objects.requireNonNull(uriN);
        this.c = uriN;
        this.d = j();
        return jA;
    }

    @Override // b.i.a.c.e3.DataSource3
    public void close() throws IOException {
        this.a.close();
    }

    @Override // b.i.a.c.e3.DataSource3
    public void d(TransferListener transferListener) {
        Objects.requireNonNull(transferListener);
        this.a.d(transferListener);
    }

    @Override // b.i.a.c.e3.DataSource3
    public Map<String, List<String>> j() {
        return this.a.j();
    }

    @Override // b.i.a.c.e3.DataSource3
    @Nullable
    public Uri n() {
        return this.a.n();
    }

    @Override // b.i.a.c.e3.DataReader
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.a.read(bArr, i, i2);
        if (i3 != -1) {
            this.f956b += (long) i3;
        }
        return i3;
    }
}
