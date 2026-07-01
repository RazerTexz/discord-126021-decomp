package androidx.core.graphics;

import android.graphics.Path;
import androidx.annotation.RequiresApi;
import d0.z.d.Intrinsics3;
import java.util.Collection;

/* JADX INFO: renamed from: androidx.core.graphics.PathKt, reason: use source file name */
/* JADX INFO: compiled from: Path.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Path {
    @RequiresApi(19)
    public static final android.graphics.Path and(android.graphics.Path path, android.graphics.Path path2) {
        Intrinsics3.checkNotNullParameter(path, "<this>");
        Intrinsics3.checkNotNullParameter(path2, "p");
        android.graphics.Path path3 = new android.graphics.Path();
        path3.op(path, path2, Path.Op.INTERSECT);
        return path3;
    }

    @RequiresApi(26)
    public static final Iterable<PathSegment> flatten(android.graphics.Path path, float f) {
        Intrinsics3.checkNotNullParameter(path, "<this>");
        Collection<PathSegment> collectionFlatten = PathUtils.flatten(path, f);
        Intrinsics3.checkNotNullExpressionValue(collectionFlatten, "flatten(this, error)");
        return collectionFlatten;
    }

    public static /* synthetic */ Iterable flatten$default(android.graphics.Path path, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.5f;
        }
        return flatten(path, f);
    }

    @RequiresApi(19)
    public static final android.graphics.Path minus(android.graphics.Path path, android.graphics.Path path2) {
        Intrinsics3.checkNotNullParameter(path, "<this>");
        Intrinsics3.checkNotNullParameter(path2, "p");
        android.graphics.Path path3 = new android.graphics.Path(path);
        path3.op(path2, Path.Op.DIFFERENCE);
        return path3;
    }

    @RequiresApi(19)
    public static final android.graphics.Path or(android.graphics.Path path, android.graphics.Path path2) {
        Intrinsics3.checkNotNullParameter(path, "<this>");
        Intrinsics3.checkNotNullParameter(path2, "p");
        android.graphics.Path path3 = new android.graphics.Path(path);
        path3.op(path2, Path.Op.UNION);
        return path3;
    }

    @RequiresApi(19)
    public static final android.graphics.Path plus(android.graphics.Path path, android.graphics.Path path2) {
        Intrinsics3.checkNotNullParameter(path, "<this>");
        Intrinsics3.checkNotNullParameter(path2, "p");
        android.graphics.Path path3 = new android.graphics.Path(path);
        path3.op(path2, Path.Op.UNION);
        return path3;
    }

    @RequiresApi(19)
    public static final android.graphics.Path xor(android.graphics.Path path, android.graphics.Path path2) {
        Intrinsics3.checkNotNullParameter(path, "<this>");
        Intrinsics3.checkNotNullParameter(path2, "p");
        android.graphics.Path path3 = new android.graphics.Path(path);
        path3.op(path2, Path.Op.XOR);
        return path3;
    }
}
