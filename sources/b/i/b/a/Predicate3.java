package b.i.b.a;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: renamed from: b.i.b.a.h, reason: use source file name */
/* JADX INFO: compiled from: Predicate.java */
/* JADX INFO: loaded from: classes3.dex */
public interface Predicate3<T> {
    @CanIgnoreReturnValue
    boolean apply(@NullableDecl T t);
}
