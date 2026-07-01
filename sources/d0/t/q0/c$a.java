package d0.t.q0;

import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MapBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c$a {
    public c$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public static final int access$computeHashSize(c$a c_a, int i) {
        Objects.requireNonNull(c_a);
        return Integer.highestOneBit(d0.d0.f.coerceAtLeast(i, 1) * 3);
    }

    public static final int access$computeShift(c$a c_a, int i) {
        Objects.requireNonNull(c_a);
        return Integer.numberOfLeadingZeros(i) + 1;
    }
}
