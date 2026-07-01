package b.i.a.c.x2;

import androidx.annotation.Nullable;
import b.i.a.c.Format2;
import b.i.a.c.e3.DataReader;
import b.i.a.c.f3.ParsableByteArray;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: renamed from: b.i.a.c.x2.w, reason: use source file name */
/* JADX INFO: compiled from: TrackOutput.java */
/* JADX INFO: loaded from: classes3.dex */
public interface TrackOutput2 {

    /* JADX INFO: renamed from: b.i.a.c.x2.w$a */
    /* JADX INFO: compiled from: TrackOutput.java */
    public static final class a {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f1299b;
        public final int c;
        public final int d;

        public a(int i, byte[] bArr, int i2, int i3) {
            this.a = i;
            this.f1299b = bArr;
            this.c = i2;
            this.d = i3;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.a == aVar.a && this.c == aVar.c && this.d == aVar.d && Arrays.equals(this.f1299b, aVar.f1299b);
        }

        public int hashCode() {
            return ((((Arrays.hashCode(this.f1299b) + (this.a * 31)) * 31) + this.c) * 31) + this.d;
        }
    }

    int a(DataReader dataReader, int i, boolean z2, int i2) throws IOException;

    int b(DataReader dataReader, int i, boolean z2) throws IOException;

    void c(ParsableByteArray parsableByteArray, int i);

    void d(long j, int i, int i2, int i3, @Nullable a aVar);

    void e(Format2 format2);

    void f(ParsableByteArray parsableByteArray, int i, int i2);
}
