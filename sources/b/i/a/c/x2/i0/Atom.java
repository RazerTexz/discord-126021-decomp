package b.i.a.c.x2.i0;

import androidx.annotation.Nullable;
import b.d.b.a.outline;
import b.i.a.c.f3.ParsableByteArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: b.i.a.c.x2.i0.d, reason: use source file name */
/* JADX INFO: compiled from: Atom.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Atom {
    public final int a;

    /* JADX INFO: renamed from: b.i.a.c.x2.i0.d$a */
    /* JADX INFO: compiled from: Atom.java */
    public static final class a extends Atom {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f1209b;
        public final List<b> c;
        public final List<a> d;

        public a(int i, long j) {
            super(i);
            this.f1209b = j;
            this.c = new ArrayList();
            this.d = new ArrayList();
        }

        @Nullable
        public a b(int i) {
            int size = this.d.size();
            for (int i2 = 0; i2 < size; i2++) {
                a aVar = this.d.get(i2);
                if (aVar.a == i) {
                    return aVar;
                }
            }
            return null;
        }

        @Nullable
        public b c(int i) {
            int size = this.c.size();
            for (int i2 = 0; i2 < size; i2++) {
                b bVar = this.c.get(i2);
                if (bVar.a == i) {
                    return bVar;
                }
            }
            return null;
        }

        @Override // b.i.a.c.x2.i0.Atom
        public String toString() {
            String strA = Atom.a(this.a);
            String string = Arrays.toString(this.c.toArray());
            String string2 = Arrays.toString(this.d.toArray());
            StringBuilder sbS = outline.S(outline.b(string2, outline.b(string, outline.b(strA, 22))), strA, " leaves: ", string, " containers: ");
            sbS.append(string2);
            return sbS.toString();
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.i0.d$b */
    /* JADX INFO: compiled from: Atom.java */
    public static final class b extends Atom {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ParsableByteArray f1210b;

        public b(int i, ParsableByteArray parsableByteArray) {
            super(i);
            this.f1210b = parsableByteArray;
        }
    }

    public Atom(int i) {
        this.a = i;
    }

    public static String a(int i) {
        StringBuilder sb = new StringBuilder(4);
        sb.append((char) ((i >> 24) & 255));
        sb.append((char) ((i >> 16) & 255));
        sb.append((char) ((i >> 8) & 255));
        sb.append((char) (i & 255));
        return sb.toString();
    }

    public String toString() {
        return a(this.a);
    }
}
