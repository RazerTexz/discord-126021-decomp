package kotlin.collections;

import com.esotericsoftware.kryo.io.Util;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ArrayDeque.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ArrayDeque$a {
    public ArrayDeque$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final int newCapacity$kotlin_stdlib(int i, int i2) {
        int i3 = i + (i >> 1);
        if (i3 - i2 < 0) {
            i3 = i2;
        }
        if (i3 - Util.MAX_SAFE_ARRAY_SIZE <= 0) {
            return i3;
        }
        if (i2 > 2147483639) {
            return Integer.MAX_VALUE;
        }
        return Util.MAX_SAFE_ARRAY_SIZE;
    }
}
