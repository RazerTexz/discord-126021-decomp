package d0.t;

import d0.z.d.Intrinsics3;
import java.lang.reflect.Array;
import java.util.Objects;

/* JADX INFO: renamed from: d0.t.h, reason: use source file name */
/* JADX INFO: compiled from: ArraysJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public class ArraysJVM {
    public static final <T> T[] arrayOfNulls(T[] tArr, int i) {
        Intrinsics3.checkNotNullParameter(tArr, "reference");
        Object objNewInstance = Array.newInstance(tArr.getClass().getComponentType(), i);
        Objects.requireNonNull(objNewInstance, "null cannot be cast to non-null type kotlin.Array<T>");
        return (T[]) ((Object[]) objNewInstance);
    }

    public static final void copyOfRangeToIndexCheck(int i, int i2) {
        if (i <= i2) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i + ") is greater than size (" + i2 + ").");
    }
}
