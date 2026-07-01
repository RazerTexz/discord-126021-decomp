package d0.t;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.ranges.Ranges2;

/* JADX INFO: renamed from: d0.t.s, reason: use source file name */
/* JADX INFO: compiled from: ReversedViews.kt */
/* JADX INFO: loaded from: classes3.dex */
public class ReversedViews3 extends MutableCollections {
    public static final int access$reverseElementIndex(List list, int i) {
        int lastIndex = Collections2.getLastIndex(list);
        if (i >= 0 && lastIndex >= i) {
            return Collections2.getLastIndex(list) - i;
        }
        StringBuilder sbV = outline.V("Element index ", i, " must be in range [");
        sbV.append(new Ranges2(0, Collections2.getLastIndex(list)));
        sbV.append("].");
        throw new IndexOutOfBoundsException(sbV.toString());
    }

    public static final int access$reversePositionIndex(List list, int i) {
        int size = list.size();
        if (i >= 0 && size >= i) {
            return list.size() - i;
        }
        StringBuilder sbV = outline.V("Position index ", i, " must be in range [");
        sbV.append(new Ranges2(0, list.size()));
        sbV.append("].");
        throw new IndexOutOfBoundsException(sbV.toString());
    }

    public static final <T> List<T> asReversed(List<? extends T> list) {
        Intrinsics3.checkNotNullParameter(list, "$this$asReversed");
        return new ReversedViews2(list);
    }

    public static final <T> List<T> asReversedMutable(List<T> list) {
        Intrinsics3.checkNotNullParameter(list, "$this$asReversed");
        return new ReversedViews(list);
    }
}
