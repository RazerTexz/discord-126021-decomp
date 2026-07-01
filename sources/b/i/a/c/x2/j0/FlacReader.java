package b.i.a.c.x2.j0;

import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.Util2;
import b.i.a.c.x2.ExtractorInput;
import b.i.a.c.x2.FlacFrameReader;
import b.i.a.c.x2.FlacSeekTableSeekMap;
import b.i.a.c.x2.FlacStreamMetadata;
import b.i.a.c.x2.SeekMap;
import b.i.a.c.x2.j0.StreamReader;
import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: renamed from: b.i.a.c.x2.j0.c, reason: use source file name */
/* JADX INFO: compiled from: FlacReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class FlacReader extends StreamReader {

    @Nullable
    public FlacStreamMetadata n;

    @Nullable
    public a o;

    /* JADX INFO: renamed from: b.i.a.c.x2.j0.c$a */
    /* JADX INFO: compiled from: FlacReader.java */
    public static final class a implements OggSeeker {
        public FlacStreamMetadata a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public FlacStreamMetadata.a f1235b;
        public long c = -1;
        public long d = -1;

        public a(FlacStreamMetadata flacStreamMetadata, FlacStreamMetadata.a aVar) {
            this.a = flacStreamMetadata;
            this.f1235b = aVar;
        }

        @Override // b.i.a.c.x2.j0.OggSeeker
        public SeekMap a() {
            AnimatableValueParser.D(this.c != -1);
            return new FlacSeekTableSeekMap(this.a, this.c);
        }

        @Override // b.i.a.c.x2.j0.OggSeeker
        public long b(ExtractorInput extractorInput) {
            long j = this.d;
            if (j < 0) {
                return -1L;
            }
            long j2 = -(j + 2);
            this.d = -1L;
            return j2;
        }

        @Override // b.i.a.c.x2.j0.OggSeeker
        public void c(long j) {
            long[] jArr = this.f1235b.a;
            this.d = jArr[Util2.e(jArr, j, true, true)];
        }
    }

    @Override // b.i.a.c.x2.j0.StreamReader
    public long c(ParsableByteArray parsableByteArray) {
        byte[] bArr = parsableByteArray.a;
        if (!(bArr[0] == -1)) {
            return -1L;
        }
        int i = (bArr[2] & 255) >> 4;
        if (i == 6 || i == 7) {
            parsableByteArray.F(4);
            parsableByteArray.z();
        }
        int iC = FlacFrameReader.c(parsableByteArray, i);
        parsableByteArray.E(0);
        return iC;
    }

    @Override // b.i.a.c.x2.j0.StreamReader
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public boolean d(ParsableByteArray parsableByteArray, long j, StreamReader.b bVar) {
        byte[] bArr = parsableByteArray.a;
        FlacStreamMetadata flacStreamMetadata = this.n;
        if (flacStreamMetadata == null) {
            FlacStreamMetadata flacStreamMetadata2 = new FlacStreamMetadata(bArr, 17);
            this.n = flacStreamMetadata2;
            bVar.a = flacStreamMetadata2.e(Arrays.copyOfRange(bArr, 9, parsableByteArray.c), null);
            return true;
        }
        if ((bArr[0] & 127) == 3) {
            FlacStreamMetadata.a aVarL1 = AnimatableValueParser.L1(parsableByteArray);
            FlacStreamMetadata flacStreamMetadataB = flacStreamMetadata.b(aVarL1);
            this.n = flacStreamMetadataB;
            this.o = new a(flacStreamMetadataB, aVarL1);
            return true;
        }
        if (!(bArr[0] == -1)) {
            return true;
        }
        a aVar = this.o;
        if (aVar != null) {
            aVar.c = j;
            bVar.f1240b = aVar;
        }
        Objects.requireNonNull(bVar.a);
        return false;
    }

    @Override // b.i.a.c.x2.j0.StreamReader
    public void e(boolean z2) {
        super.e(z2);
        if (z2) {
            this.n = null;
            this.o = null;
        }
    }
}
