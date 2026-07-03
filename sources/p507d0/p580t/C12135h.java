package p507d0.p580t;

import java.lang.reflect.Array;
import java.util.Objects;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.t.h */
/* JADX INFO: compiled from: ArraysJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12135h {
    public static final <T> T[] arrayOfNulls(T[] tArr, int i) {
        C12238m.checkNotNullParameter(tArr, "reference");
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
