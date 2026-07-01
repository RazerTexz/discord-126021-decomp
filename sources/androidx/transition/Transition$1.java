package androidx.transition;

import android.graphics.Path;

/* JADX INFO: loaded from: classes.dex */
public class Transition$1 extends PathMotion {
    @Override // androidx.transition.PathMotion
    public Path getPath(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(f, f2);
        path.lineTo(f3, f4);
        return path;
    }
}
