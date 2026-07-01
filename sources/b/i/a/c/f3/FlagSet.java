package b.i.a.c.f3;

import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;

/* JADX INFO: renamed from: b.i.a.c.f3.n, reason: use source file name */
/* JADX INFO: compiled from: FlagSet.java */
/* JADX INFO: loaded from: classes3.dex */
public final class FlagSet {
    public final SparseBooleanArray a;

    /* JADX INFO: renamed from: b.i.a.c.f3.n$b */
    /* JADX INFO: compiled from: FlagSet.java */
    public static final class b {
        public final SparseBooleanArray a = new SparseBooleanArray();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f972b;

        public b a(int i) {
            AnimatableValueParser.D(!this.f972b);
            this.a.append(i, true);
            return this;
        }

        public FlagSet b() {
            AnimatableValueParser.D(!this.f972b);
            this.f972b = true;
            return new FlagSet(this.a, null);
        }
    }

    public FlagSet(SparseBooleanArray sparseBooleanArray, a aVar) {
        this.a = sparseBooleanArray;
    }

    public boolean a(int i) {
        return this.a.get(i);
    }

    public int b(int i) {
        AnimatableValueParser.t(i, 0, c());
        return this.a.keyAt(i);
    }

    public int c() {
        return this.a.size();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlagSet)) {
            return false;
        }
        FlagSet flagSet = (FlagSet) obj;
        if (Util2.a >= 24) {
            return this.a.equals(flagSet.a);
        }
        if (c() != flagSet.c()) {
            return false;
        }
        for (int i = 0; i < c(); i++) {
            if (b(i) != flagSet.b(i)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (Util2.a >= 24) {
            return this.a.hashCode();
        }
        int iC = c();
        for (int i = 0; i < c(); i++) {
            iC = (iC * 31) + b(i);
        }
        return iC;
    }
}
