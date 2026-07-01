package b.c.a.y;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import b.c.a.c0.LottieValueCallback;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.y.g, reason: use source file name */
/* JADX INFO: compiled from: KeyPathElement.java */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public interface KeyPathElement {
    void c(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2);

    <T> void g(T t, @Nullable LottieValueCallback<T> lottieValueCallback);
}
