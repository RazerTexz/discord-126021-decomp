package b.i.b.b;

import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: ComparisonChain.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j {
    public static final j a = new j$a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f1646b = new j$b(-1);
    public static final j c = new j$b(1);

    public j(j$a j_a) {
    }

    public abstract j a(int i, int i2);

    public abstract <T> j b(@NullableDecl T t, @NullableDecl T t2, Comparator<T> comparator);

    public abstract j c(boolean z2, boolean z3);

    public abstract j d(boolean z2, boolean z3);

    public abstract int e();
}
