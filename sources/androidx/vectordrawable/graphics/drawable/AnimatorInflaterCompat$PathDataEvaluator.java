package androidx.vectordrawable.graphics.drawable;

import android.animation.TypeEvaluator;
import androidx.core.graphics.PathParser;
import androidx.core.graphics.PathParser$PathDataNode;

/* JADX INFO: loaded from: classes.dex */
public class AnimatorInflaterCompat$PathDataEvaluator implements TypeEvaluator<PathParser$PathDataNode[]> {
    private PathParser$PathDataNode[] mNodeArray;

    public AnimatorInflaterCompat$PathDataEvaluator() {
    }

    @Override // android.animation.TypeEvaluator
    public /* bridge */ /* synthetic */ PathParser$PathDataNode[] evaluate(float f, PathParser$PathDataNode[] pathParser$PathDataNodeArr, PathParser$PathDataNode[] pathParser$PathDataNodeArr2) {
        return evaluate2(f, pathParser$PathDataNodeArr, pathParser$PathDataNodeArr2);
    }

    public AnimatorInflaterCompat$PathDataEvaluator(PathParser$PathDataNode[] pathParser$PathDataNodeArr) {
        this.mNodeArray = pathParser$PathDataNodeArr;
    }

    /* JADX INFO: renamed from: evaluate, reason: avoid collision after fix types in other method */
    public PathParser$PathDataNode[] evaluate2(float f, PathParser$PathDataNode[] pathParser$PathDataNodeArr, PathParser$PathDataNode[] pathParser$PathDataNodeArr2) {
        if (!PathParser.canMorph(pathParser$PathDataNodeArr, pathParser$PathDataNodeArr2)) {
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
        if (!PathParser.canMorph(this.mNodeArray, pathParser$PathDataNodeArr)) {
            this.mNodeArray = PathParser.deepCopyNodes(pathParser$PathDataNodeArr);
        }
        for (int i = 0; i < pathParser$PathDataNodeArr.length; i++) {
            this.mNodeArray[i].interpolatePathDataNode(pathParser$PathDataNodeArr[i], pathParser$PathDataNodeArr2[i], f);
        }
        return this.mNodeArray;
    }
}
