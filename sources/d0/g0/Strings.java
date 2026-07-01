package d0.g0;

import d0.d0._Ranges;
import d0.z.d.Intrinsics3;
import d0.z.d.g0.KMarkers;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.Ranges2;
import kotlin.sequences.Sequence;

/* JADX INFO: renamed from: d0.g0.d, reason: use source file name */
/* JADX INFO: compiled from: Strings.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Strings implements Sequence<Ranges2> {
    public final CharSequence a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3580b;
    public final int c;
    public final Function2<CharSequence, Integer, Tuples2<Integer, Integer>> d;

    /* JADX INFO: renamed from: d0.g0.d$a */
    /* JADX INFO: compiled from: Strings.kt */
    public static final class a implements Iterator<Ranges2>, KMarkers {
        public int j = -1;
        public int k;
        public int l;
        public Ranges2 m;
        public int n;

        public a() {
            int iCoerceIn = _Ranges.coerceIn(Strings.this.f3580b, 0, Strings.this.a.length());
            this.k = iCoerceIn;
            this.l = iCoerceIn;
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0031 A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:17:0x0098  */
        /* JADX WARN: Code duplicated, block: B:9:0x0023  */
        public final void a() {
            Tuples2 tuples2;
            if (this.l < 0) {
                this.j = 0;
                this.m = null;
                return;
            }
            if (Strings.this.c > 0) {
                int i = this.n + 1;
                this.n = i;
                if (i >= Strings.this.c) {
                    this.m = new Ranges2(this.k, Strings4.getLastIndex(Strings.this.a));
                    this.l = -1;
                } else if (this.l > Strings.this.a.length() && (tuples2 = (Tuples2) Strings.this.d.invoke(Strings.this.a, Integer.valueOf(this.l))) != null) {
                    int iIntValue = ((Number) tuples2.component1()).intValue();
                    int iIntValue2 = ((Number) tuples2.component2()).intValue();
                    this.m = _Ranges.until(this.k, iIntValue);
                    int i2 = iIntValue + iIntValue2;
                    this.k = i2;
                    this.l = i2 + (iIntValue2 == 0 ? 1 : 0);
                } else {
                    this.m = new Ranges2(this.k, Strings4.getLastIndex(Strings.this.a));
                    this.l = -1;
                }
            } else if (this.l > Strings.this.a.length()) {
                this.m = new Ranges2(this.k, Strings4.getLastIndex(Strings.this.a));
                this.l = -1;
            } else {
                int iIntValue3 = ((Number) tuples2.component1()).intValue();
                int iIntValue4 = ((Number) tuples2.component2()).intValue();
                this.m = _Ranges.until(this.k, iIntValue3);
                int i3 = iIntValue3 + iIntValue4;
                this.k = i3;
                this.l = i3 + (iIntValue4 == 0 ? 1 : 0);
            }
            this.j = 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.j == -1) {
                a();
            }
            return this.j == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public Ranges2 next() {
            if (this.j == -1) {
                a();
            }
            if (this.j == 0) {
                throw new NoSuchElementException();
            }
            Ranges2 ranges2 = this.m;
            Objects.requireNonNull(ranges2, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.m = null;
            this.j = -1;
            return ranges2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Strings(CharSequence charSequence, int i, int i2, Function2<? super CharSequence, ? super Integer, Tuples2<Integer, Integer>> function2) {
        Intrinsics3.checkNotNullParameter(charSequence, "input");
        Intrinsics3.checkNotNullParameter(function2, "getNextMatch");
        this.a = charSequence;
        this.f3580b = i;
        this.c = i2;
        this.d = function2;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<Ranges2> iterator() {
        return new a();
    }
}
