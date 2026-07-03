package p507d0.p579g0;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;
import kotlin.sequences.Sequence;
import p507d0.p512d0.C11226f;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;

/* JADX INFO: renamed from: d0.g0.d */
/* JADX INFO: compiled from: Strings.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12087d implements Sequence<IntRange> {

    /* JADX INFO: renamed from: a */
    public final CharSequence f25140a;

    /* JADX INFO: renamed from: b */
    public final int f25141b;

    /* JADX INFO: renamed from: c */
    public final int f25142c;

    /* JADX INFO: renamed from: d */
    public final Function2<CharSequence, Integer, Pair<Integer, Integer>> f25143d;

    /* JADX INFO: renamed from: d0.g0.d$a */
    /* JADX INFO: compiled from: Strings.kt */
    public static final class a implements Iterator<IntRange>, InterfaceC12228a {

        /* JADX INFO: renamed from: j */
        public int f25144j = -1;

        /* JADX INFO: renamed from: k */
        public int f25145k;

        /* JADX INFO: renamed from: l */
        public int f25146l;

        /* JADX INFO: renamed from: m */
        public IntRange f25147m;

        /* JADX INFO: renamed from: n */
        public int f25148n;

        public a() {
            int iCoerceIn = C11226f.coerceIn(C12087d.this.f25141b, 0, C12087d.this.f25140a.length());
            this.f25145k = iCoerceIn;
            this.f25146l = iCoerceIn;
        }

        /* JADX WARN: Code duplicated, block: B:11:0x0031 A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:17:0x0098  */
        /* JADX WARN: Code duplicated, block: B:9:0x0023  */
        /* JADX INFO: renamed from: a */
        public final void m10067a() {
            Pair pair;
            if (this.f25146l < 0) {
                this.f25144j = 0;
                this.f25147m = null;
                return;
            }
            if (C12087d.this.f25142c > 0) {
                int i = this.f25148n + 1;
                this.f25148n = i;
                if (i >= C12087d.this.f25142c) {
                    this.f25147m = new IntRange(this.f25145k, C12106w.getLastIndex(C12087d.this.f25140a));
                    this.f25146l = -1;
                } else if (this.f25146l > C12087d.this.f25140a.length() && (pair = (Pair) C12087d.this.f25143d.invoke(C12087d.this.f25140a, Integer.valueOf(this.f25146l))) != null) {
                    int iIntValue = ((Number) pair.component1()).intValue();
                    int iIntValue2 = ((Number) pair.component2()).intValue();
                    this.f25147m = C11226f.until(this.f25145k, iIntValue);
                    int i2 = iIntValue + iIntValue2;
                    this.f25145k = i2;
                    this.f25146l = i2 + (iIntValue2 == 0 ? 1 : 0);
                } else {
                    this.f25147m = new IntRange(this.f25145k, C12106w.getLastIndex(C12087d.this.f25140a));
                    this.f25146l = -1;
                }
            } else if (this.f25146l > C12087d.this.f25140a.length()) {
                this.f25147m = new IntRange(this.f25145k, C12106w.getLastIndex(C12087d.this.f25140a));
                this.f25146l = -1;
            } else {
                int iIntValue3 = ((Number) pair.component1()).intValue();
                int iIntValue4 = ((Number) pair.component2()).intValue();
                this.f25147m = C11226f.until(this.f25145k, iIntValue3);
                int i3 = iIntValue3 + iIntValue4;
                this.f25145k = i3;
                this.f25146l = i3 + (iIntValue4 == 0 ? 1 : 0);
            }
            this.f25144j = 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f25144j == -1) {
                m10067a();
            }
            return this.f25144j == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.Iterator
        public IntRange next() {
            if (this.f25144j == -1) {
                m10067a();
            }
            if (this.f25144j == 0) {
                throw new NoSuchElementException();
            }
            IntRange intRange = this.f25147m;
            Objects.requireNonNull(intRange, "null cannot be cast to non-null type kotlin.ranges.IntRange");
            this.f25147m = null;
            this.f25144j = -1;
            return intRange;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C12087d(CharSequence charSequence, int i, int i2, Function2<? super CharSequence, ? super Integer, Pair<Integer, Integer>> function2) {
        C12238m.checkNotNullParameter(charSequence, "input");
        C12238m.checkNotNullParameter(function2, "getNextMatch");
        this.f25140a = charSequence;
        this.f25141b = i;
        this.f25142c = i2;
        this.f25143d = function2;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<IntRange> iterator() {
        return new a();
    }
}
