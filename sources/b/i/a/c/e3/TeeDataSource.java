package b.i.a.c.e3;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.e3.z, reason: use source file name */
/* JADX INFO: compiled from: TeeDataSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TeeDataSource implements DataSource3 {
    public final DataSource3 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataSink f957b;
    public boolean c;
    public long d;

    public TeeDataSource(DataSource3 dataSource3, DataSink dataSink) {
        this.a = dataSource3;
        this.f957b = dataSink;
    }

    @Override // b.i.a.c.e3.DataSource3
    public long a(DataSpec dataSpec) throws IOException {
        DataSpec dataSpec2 = dataSpec;
        long jA = this.a.a(dataSpec2);
        this.d = jA;
        if (jA == 0) {
            return 0L;
        }
        long j = dataSpec2.g;
        if (j == -1 && jA != -1) {
            dataSpec2 = j == jA ? dataSpec2 : new DataSpec(dataSpec2.a, dataSpec2.f942b, dataSpec2.c, dataSpec2.d, dataSpec2.e, dataSpec2.f + 0, jA, dataSpec2.h, dataSpec2.i, dataSpec2.j);
        }
        this.c = true;
        this.f957b.a(dataSpec2);
        return this.d;
    }

    @Override // b.i.a.c.e3.DataSource3
    public void close() throws IOException {
        try {
            this.a.close();
        } finally {
            if (this.c) {
                this.c = false;
                this.f957b.close();
            }
        }
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
        if (this.d == 0) {
            return -1;
        }
        int i3 = this.a.read(bArr, i, i2);
        if (i3 > 0) {
            this.f957b.write(bArr, i, i3);
            long j = this.d;
            if (j != -1) {
                this.d = j - ((long) i3);
            }
        }
        return i3;
    }
}
