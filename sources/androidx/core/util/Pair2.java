package androidx.core.util;

import android.annotation.SuppressLint;
import androidx.exifinterface.media.ExifInterface;
import d0.z.d.Intrinsics3;
import kotlin.Tuples2;

/* JADX INFO: renamed from: androidx.core.util.PairKt, reason: use source file name */
/* JADX INFO: compiled from: Pair.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Pair2 {
    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(Pair<F, S> pair) {
        Intrinsics3.checkNotNullParameter(pair, "<this>");
        return pair.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(Pair<F, S> pair) {
        Intrinsics3.checkNotNullParameter(pair, "<this>");
        return pair.second;
    }

    public static final <F, S> android.util.Pair<F, S> toAndroidPair(Tuples2<? extends F, ? extends S> tuples2) {
        Intrinsics3.checkNotNullParameter(tuples2, "<this>");
        return new android.util.Pair<>(tuples2.getFirst(), tuples2.getSecond());
    }

    public static final <F, S> Pair<F, S> toAndroidXPair(Tuples2<? extends F, ? extends S> tuples2) {
        Intrinsics3.checkNotNullParameter(tuples2, "<this>");
        return new Pair<>(tuples2.getFirst(), tuples2.getSecond());
    }

    public static final <F, S> Tuples2<F, S> toKotlinPair(Pair<F, S> pair) {
        Intrinsics3.checkNotNullParameter(pair, "<this>");
        return new Tuples2<>(pair.first, pair.second);
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(android.util.Pair<F, S> pair) {
        Intrinsics3.checkNotNullParameter(pair, "<this>");
        return (F) pair.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(android.util.Pair<F, S> pair) {
        Intrinsics3.checkNotNullParameter(pair, "<this>");
        return (S) pair.second;
    }

    public static final <F, S> Tuples2<F, S> toKotlinPair(android.util.Pair<F, S> pair) {
        Intrinsics3.checkNotNullParameter(pair, "<this>");
        return new Tuples2<>(pair.first, pair.second);
    }
}
