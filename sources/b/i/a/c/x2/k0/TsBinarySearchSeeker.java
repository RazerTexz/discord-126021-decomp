package b.i.a.c.x2.k0;

import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.TimestampAdjuster;
import b.i.a.c.f3.Util2;
import b.i.a.c.x2.BinarySearchSeeker;
import b.i.a.c.x2.ExtractorInput;
import java.io.IOException;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.f0, reason: use source file name */
/* JADX INFO: compiled from: TsBinarySearchSeeker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TsBinarySearchSeeker extends BinarySearchSeeker {

    /* JADX INFO: renamed from: b.i.a.c.x2.k0.f0$a */
    /* JADX INFO: compiled from: TsBinarySearchSeeker.java */
    public static final class a implements BinarySearchSeeker.f {
        public final TimestampAdjuster a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ParsableByteArray f1248b = new ParsableByteArray();
        public final int c;
        public final int d;

        public a(int i, TimestampAdjuster timestampAdjuster, int i2) {
            this.c = i;
            this.a = timestampAdjuster;
            this.d = i2;
        }

        @Override // b.i.a.c.x2.BinarySearchSeeker.f
        public void a() {
            this.f1248b.B(Util2.f);
        }

        @Override // b.i.a.c.x2.BinarySearchSeeker.f
        public BinarySearchSeeker.e b(ExtractorInput extractorInput, long j) throws IOException {
            long position = extractorInput.getPosition();
            int iMin = (int) Math.min(this.d, extractorInput.b() - position);
            this.f1248b.A(iMin);
            extractorInput.o(this.f1248b.a, 0, iMin);
            ParsableByteArray parsableByteArray = this.f1248b;
            int i = parsableByteArray.c;
            long j2 = -1;
            long j3 = -1;
            long j4 = -9223372036854775807L;
            while (parsableByteArray.a() >= 188) {
                byte[] bArr = parsableByteArray.a;
                int i2 = parsableByteArray.f984b;
                while (i2 < i && bArr[i2] != 71) {
                    i2++;
                }
                int i3 = i2 + Opcodes.NEWARRAY;
                if (i3 > i) {
                    break;
                }
                long jK1 = AnimatableValueParser.K1(parsableByteArray, i2, this.c);
                if (jK1 != -9223372036854775807L) {
                    long jB = this.a.b(jK1);
                    if (jB > j) {
                        return j4 == -9223372036854775807L ? BinarySearchSeeker.e.a(jB, position) : BinarySearchSeeker.e.b(position + j3);
                    }
                    if (100000 + jB > j) {
                        return BinarySearchSeeker.e.b(position + ((long) i2));
                    }
                    j4 = jB;
                    j3 = i2;
                }
                parsableByteArray.E(i3);
                j2 = i3;
            }
            return j4 != -9223372036854775807L ? BinarySearchSeeker.e.c(j4, position + j2) : BinarySearchSeeker.e.a;
        }
    }

    public TsBinarySearchSeeker(TimestampAdjuster timestampAdjuster, long j, long j2, int i, int i2) {
        super(new BinarySearchSeeker.b(), new a(i, timestampAdjuster, i2), j, 0L, j + 1, 0L, j2, 188L, 940);
    }
}
