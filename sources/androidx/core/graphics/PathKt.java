package androidx.core.graphics;

import android.graphics.Path;
import androidx.annotation.RequiresApi;
import java.util.Collection;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Path.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PathKt {
    @RequiresApi(19)
    public static final Path and(Path path, Path path2) {
        C12238m.checkNotNullParameter(path, "<this>");
        C12238m.checkNotNullParameter(path2, "p");
        Path path3 = new Path();
        path3.op(path, path2, Path.Op.INTERSECT);
        return path3;
    }

    @RequiresApi(26)
    public static final Iterable<PathSegment> flatten(Path path, float f) {
        C12238m.checkNotNullParameter(path, "<this>");
        Collection<PathSegment> collectionFlatten = PathUtils.flatten(path, f);
        C12238m.checkNotNullExpressionValue(collectionFlatten, "flatten(this, error)");
        return collectionFlatten;
    }

    public static /* synthetic */ Iterable flatten$default(Path path, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.5f;
        }
        return flatten(path, f);
    }

    @RequiresApi(19)
    public static final Path minus(Path path, Path path2) {
        C12238m.checkNotNullParameter(path, "<this>");
        C12238m.checkNotNullParameter(path2, "p");
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.DIFFERENCE);
        return path3;
    }

    @RequiresApi(19)
    /* JADX INFO: renamed from: or */
    public static final Path m84or(Path path, Path path2) {
        C12238m.checkNotNullParameter(path, "<this>");
        C12238m.checkNotNullParameter(path2, "p");
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.UNION);
        return path3;
    }

    @RequiresApi(19)
    public static final Path plus(Path path, Path path2) {
        C12238m.checkNotNullParameter(path, "<this>");
        C12238m.checkNotNullParameter(path2, "p");
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.UNION);
        return path3;
    }

    @RequiresApi(19)
    public static final Path xor(Path path, Path path2) {
        C12238m.checkNotNullParameter(path, "<this>");
        C12238m.checkNotNullParameter(path2, "p");
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.XOR);
        return path3;
    }
}
