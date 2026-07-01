package b.i.a.c.a3;

import android.net.Uri;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.a3.ProgressiveMediaPeriod;
import b.i.a.c.e3.DataSource3;
import b.i.a.c.e3.DataSpec;
import b.i.a.c.e3.TransferListener;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.x2.TrackOutput2;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.a3.s, reason: use source file name */
/* JADX INFO: compiled from: IcyDataSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class IcyDataSource implements DataSource3 {
    public final DataSource3 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f832b;
    public final a c;
    public final byte[] d;
    public int e;

    /* JADX INFO: renamed from: b.i.a.c.a3.s$a */
    /* JADX INFO: compiled from: IcyDataSource.java */
    public interface a {
    }

    public IcyDataSource(DataSource3 dataSource3, int i, a aVar) {
        AnimatableValueParser.j(i > 0);
        this.a = dataSource3;
        this.f832b = i;
        this.c = aVar;
        this.d = new byte[1];
        this.e = i;
    }

    @Override // b.i.a.c.e3.DataSource3
    public long a(DataSpec dataSpec) {
        throw new UnsupportedOperationException();
    }

    @Override // b.i.a.c.e3.DataSource3
    public void close() {
        throw new UnsupportedOperationException();
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
        long jMax;
        if (this.e == 0) {
            boolean z2 = true;
            if (this.a.read(this.d, 0, 1) == -1) {
                z2 = false;
                break;
            }
            int i3 = (this.d[0] & 255) << 4;
            if (i3 != 0) {
                byte[] bArr2 = new byte[i3];
                int i4 = i3;
                int i5 = 0;
                while (true) {
                    if (i4 <= 0) {
                        while (i3 > 0) {
                            int i6 = i3 - 1;
                            if (bArr2[i6] != 0) {
                                break;
                            }
                            i3 = i6;
                        }
                        if (i3 <= 0) {
                            break;
                        }
                        a aVar = this.c;
                        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr2, i3);
                        ProgressiveMediaPeriod.a aVar2 = (ProgressiveMediaPeriod.a) aVar;
                        if (aVar2.n) {
                            ProgressiveMediaPeriod progressiveMediaPeriod = ProgressiveMediaPeriod.this;
                            Map<String, String> map = ProgressiveMediaPeriod.j;
                            jMax = Math.max(progressiveMediaPeriod.v(), aVar2.j);
                        } else {
                            jMax = aVar2.j;
                        }
                        int iA = parsableByteArray.a();
                        TrackOutput2 trackOutput2 = aVar2.m;
                        Objects.requireNonNull(trackOutput2);
                        trackOutput2.c(parsableByteArray, iA);
                        trackOutput2.d(jMax, 1, iA, 0, null);
                        aVar2.n = true;
                        break;
                    }
                    int i7 = this.a.read(bArr2, i5, i4);
                    if (i7 == -1) {
                        z2 = false;
                        break;
                    }
                    i5 += i7;
                    i4 -= i7;
                }
            }
            if (!z2) {
                return -1;
            }
            this.e = this.f832b;
        }
        int i8 = this.a.read(bArr, i, Math.min(this.e, i2));
        if (i8 != -1) {
            this.e -= i8;
        }
        return i8;
    }
}
