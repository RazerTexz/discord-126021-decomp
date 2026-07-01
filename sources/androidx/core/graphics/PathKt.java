package androidx.core.graphics;

import android.graphics.Path;
import android.graphics.Path$Op;
import androidx.annotation.RequiresApi;
import d0.z.d.m;
import java.util.Collection;

/* JADX INFO: compiled from: Path.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PathKt {
    @RequiresApi(19)
    public static final Path and(Path path, Path path2) {
        m.checkNotNullParameter(path, "<this>");
        m.checkNotNullParameter(path2, "p");
        Path path3 = new Path();
        path3.op(path, path2, Path$Op.INTERSECT);
        return path3;
    }

    @RequiresApi(26)
    public static final Iterable<PathSegment> flatten(Path path, float f) {
        m.checkNotNullParameter(path, "<this>");
        Collection<PathSegment> collectionFlatten = PathUtils.flatten(path, f);
        m.checkNotNullExpressionValue(collectionFlatten, "flatten(this, error)");
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
        m.checkNotNullParameter(path, "<this>");
        m.checkNotNullParameter(path2, "p");
        Path path3 = new Path(path);
        path3.op(path2, Path$Op.DIFFERENCE);
        return path3;
    }

    @RequiresApi(19)
    public static final Path or(Path path, Path path2) {
        m.checkNotNullParameter(path, "<this>");
        m.checkNotNullParameter(path2, "p");
        Path path3 = new Path(path);
        path3.op(path2, Path$Op.UNION);
        return path3;
    }

    @RequiresApi(19)
    public static final Path plus(Path path, Path path2) {
        m.checkNotNullParameter(path, "<this>");
        m.checkNotNullParameter(path2, "p");
        Path path3 = new Path(path);
        path3.op(path2, Path$Op.UNION);
        return path3;
    }

    @RequiresApi(19)
    public static final Path xor(Path path, Path path2) {
        m.checkNotNullParameter(path, "<this>");
        m.checkNotNullParameter(path2, "p");
        Path path3 = new Path(path);
        path3.op(path2, Path$Op.XOR);
        return path3;
    }
}
