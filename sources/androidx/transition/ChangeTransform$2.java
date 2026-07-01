package androidx.transition;

import android.graphics.PointF;
import android.util.Property;

/* JADX INFO: loaded from: classes.dex */
public class ChangeTransform$2 extends Property<ChangeTransform$PathAnimatorMatrix, PointF> {
    public ChangeTransform$2(Class cls, String str) {
        super(cls, str);
    }

    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public PointF get2(ChangeTransform$PathAnimatorMatrix changeTransform$PathAnimatorMatrix) {
        return null;
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ PointF get(ChangeTransform$PathAnimatorMatrix changeTransform$PathAnimatorMatrix) {
        return get2(changeTransform$PathAnimatorMatrix);
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(ChangeTransform$PathAnimatorMatrix changeTransform$PathAnimatorMatrix, PointF pointF) {
        set2(changeTransform$PathAnimatorMatrix, pointF);
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(ChangeTransform$PathAnimatorMatrix changeTransform$PathAnimatorMatrix, PointF pointF) {
        changeTransform$PathAnimatorMatrix.setTranslation(pointF);
    }
}
