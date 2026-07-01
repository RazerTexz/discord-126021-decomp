package b.i.b.a;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: renamed from: b.i.b.a.e, reason: use source file name */
/* JADX INFO: compiled from: Function.java */
/* JADX INFO: loaded from: classes3.dex */
public interface Function2<F, T> {
    @CanIgnoreReturnValue
    @NullableDecl
    T apply(@NullableDecl F f);
}
