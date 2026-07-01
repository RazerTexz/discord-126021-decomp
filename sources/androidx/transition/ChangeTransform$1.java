package androidx.transition;

import android.util.Property;

/* JADX INFO: loaded from: classes.dex */
public class ChangeTransform$1 extends Property<ChangeTransform$PathAnimatorMatrix, float[]> {
    public ChangeTransform$1(Class cls, String str) {
        super(cls, str);
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ float[] get(ChangeTransform$PathAnimatorMatrix changeTransform$PathAnimatorMatrix) {
        return get2(changeTransform$PathAnimatorMatrix);
    }

    /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
    public float[] get2(ChangeTransform$PathAnimatorMatrix changeTransform$PathAnimatorMatrix) {
        return null;
    }

    @Override // android.util.Property
    public /* bridge */ /* synthetic */ void set(ChangeTransform$PathAnimatorMatrix changeTransform$PathAnimatorMatrix, float[] fArr) {
        set2(changeTransform$PathAnimatorMatrix, fArr);
    }

    /* JADX INFO: renamed from: set, reason: avoid collision after fix types in other method */
    public void set2(ChangeTransform$PathAnimatorMatrix changeTransform$PathAnimatorMatrix, float[] fArr) {
        changeTransform$PathAnimatorMatrix.setValues(fArr);
    }
}
