package d0.t;

import java.util.List;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: ReversedViews.kt */
/* JADX INFO: loaded from: classes3.dex */
public class s extends r {
    public static final int access$reverseElementIndex(List list, int i) {
        int lastIndex = n.getLastIndex(list);
        if (i >= 0 && lastIndex >= i) {
            return n.getLastIndex(list) - i;
        }
        StringBuilder sbV = b.d.b.a.a.V("Element index ", i, " must be in range [");
        sbV.append(new IntRange(0, n.getLastIndex(list)));
        sbV.append("].");
        throw new IndexOutOfBoundsException(sbV.toString());
    }

    public static final int access$reversePositionIndex(List list, int i) {
        int size = list.size();
        if (i >= 0 && size >= i) {
            return list.size() - i;
        }
        StringBuilder sbV = b.d.b.a.a.V("Position index ", i, " must be in range [");
        sbV.append(new IntRange(0, list.size()));
        sbV.append("].");
        throw new IndexOutOfBoundsException(sbV.toString());
    }

    public static final <T> List<T> asReversed(List<? extends T> list) {
        d0.z.d.m.checkNotNullParameter(list, "$this$asReversed");
        return new k0(list);
    }

    public static final <T> List<T> asReversedMutable(List<T> list) {
        d0.z.d.m.checkNotNullParameter(list, "$this$asReversed");
        return new j0(list);
    }
}
