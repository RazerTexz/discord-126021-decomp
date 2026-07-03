package p507d0.p580t;

import java.util.List;
import kotlin.ranges.IntRange;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.t.s */
/* JADX INFO: compiled from: ReversedViews.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12161s extends C12160r {
    public static final int access$reverseElementIndex(List list, int i) {
        int lastIndex = C12147n.getLastIndex(list);
        if (i >= 0 && lastIndex >= i) {
            return C12147n.getLastIndex(list) - i;
        }
        StringBuilder sbM834V = C1643a.m834V("Element index ", i, " must be in range [");
        sbM834V.append(new IntRange(0, C12147n.getLastIndex(list)));
        sbM834V.append("].");
        throw new IndexOutOfBoundsException(sbM834V.toString());
    }

    public static final int access$reversePositionIndex(List list, int i) {
        int size = list.size();
        if (i >= 0 && size >= i) {
            return list.size() - i;
        }
        StringBuilder sbM834V = C1643a.m834V("Position index ", i, " must be in range [");
        sbM834V.append(new IntRange(0, list.size()));
        sbM834V.append("].");
        throw new IndexOutOfBoundsException(sbM834V.toString());
    }

    public static final <T> List<T> asReversed(List<? extends T> list) {
        C12238m.checkNotNullParameter(list, "$this$asReversed");
        return new C12142k0(list);
    }

    public static final <T> List<T> asReversedMutable(List<T> list) {
        C12238m.checkNotNullParameter(list, "$this$asReversed");
        return new C12140j0(list);
    }
}
