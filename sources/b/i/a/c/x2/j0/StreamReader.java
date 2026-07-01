package b.i.a.c.x2.j0;

import b.i.a.c.Format2;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.x2.ExtractorInput;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.SeekMap;
import b.i.a.c.x2.TrackOutput2;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: renamed from: b.i.a.c.x2.j0.i, reason: use source file name */
/* JADX INFO: compiled from: StreamReader.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class StreamReader {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TrackOutput2 f1239b;
    public ExtractorOutput c;
    public OggSeeker d;
    public long e;
    public long f;
    public long g;
    public int h;
    public int i;
    public long k;
    public boolean l;
    public boolean m;
    public final OggPacket a = new OggPacket();
    public b j = new b();

    /* JADX INFO: renamed from: b.i.a.c.x2.j0.i$b */
    /* JADX INFO: compiled from: StreamReader.java */
    public static class b {
        public Format2 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public OggSeeker f1240b;
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.j0.i$c */
    /* JADX INFO: compiled from: StreamReader.java */
    public static final class c implements OggSeeker {
        public c(a aVar) {
        }

        @Override // b.i.a.c.x2.j0.OggSeeker
        public SeekMap a() {
            return new SeekMap.b(-9223372036854775807L, 0L);
        }

        @Override // b.i.a.c.x2.j0.OggSeeker
        public long b(ExtractorInput extractorInput) {
            return -1L;
        }

        @Override // b.i.a.c.x2.j0.OggSeeker
        public void c(long j) {
        }
    }

    public long a(long j) {
        return (((long) this.i) * j) / 1000000;
    }

    public void b(long j) {
        this.g = j;
    }

    public abstract long c(ParsableByteArray parsableByteArray);

    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public abstract boolean d(ParsableByteArray parsableByteArray, long j, b bVar) throws IOException;

    public void e(boolean z2) {
        if (z2) {
            this.j = new b();
            this.f = 0L;
            this.h = 0;
        } else {
            this.h = 1;
        }
        this.e = -1L;
        this.g = 0L;
    }
}
