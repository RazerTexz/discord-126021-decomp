package d0.g0;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.Pair;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: Strings.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$a implements Iterator<IntRange>, d0.z.d.g0.a {
    public int j = -1;
    public int k;
    public int l;
    public IntRange m;
    public int n;
    public final /* synthetic */ d o;

    public d$a(d dVar) {
        this.o = dVar;
        int iCoerceIn = d0.d0.f.coerceIn(d.access$getStartIndex$p(dVar), 0, d.access$getInput$p(dVar).length());
        this.k = iCoerceIn;
        this.l = iCoerceIn;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0031 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:17:0x0098  */
    /* JADX WARN: Code duplicated, block: B:9:0x0023  */
    public final void a() {
        Pair pair;
        if (this.l < 0) {
            this.j = 0;
            this.m = null;
            return;
        }
        if (d.access$getLimit$p(this.o) > 0) {
            int i = this.n + 1;
            this.n = i;
            if (i >= d.access$getLimit$p(this.o)) {
                this.m = new IntRange(this.k, w.getLastIndex(d.access$getInput$p(this.o)));
                this.l = -1;
            } else if (this.l > d.access$getInput$p(this.o).length() && (pair = (Pair) d.access$getGetNextMatch$p(this.o).invoke(d.access$getInput$p(this.o), Integer.valueOf(this.l))) != null) {
                int iIntValue = ((Number) pair.component1()).intValue();
                int iIntValue2 = ((Number) pair.component2()).intValue();
                this.m = d0.d0.f.until(this.k, iIntValue);
                int i2 = iIntValue + iIntValue2;
                this.k = i2;
                this.l = i2 + (iIntValue2 == 0 ? 1 : 0);
            } else {
                this.m = new IntRange(this.k, w.getLastIndex(d.access$getInput$p(this.o)));
                this.l = -1;
            }
        } else if (this.l > d.access$getInput$p(this.o).length()) {
            this.m = new IntRange(this.k, w.getLastIndex(d.access$getInput$p(this.o)));
            this.l = -1;
        } else {
            int iIntValue3 = ((Number) pair.component1()).intValue();
            int iIntValue4 = ((Number) pair.component2()).intValue();
            this.m = d0.d0.f.until(this.k, iIntValue3);
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
    public /* bridge */ /* synthetic */ IntRange next() {
        return next2();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: next, reason: avoid collision after fix types in other method */
    public IntRange next2() {
        if (this.j == -1) {
            a();
        }
        if (this.j == 0) {
            throw new NoSuchElementException();
        }
        IntRange intRange = this.m;
        Objects.requireNonNull(intRange, "null cannot be cast to non-null type kotlin.ranges.IntRange");
        this.m = null;
        this.j = -1;
        return intRange;
    }
}
