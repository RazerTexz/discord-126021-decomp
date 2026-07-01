package androidx.transition;

import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class ChangeTransform$Transforms {
    public final float mRotationX;
    public final float mRotationY;
    public final float mRotationZ;
    public final float mScaleX;
    public final float mScaleY;
    public final float mTranslationX;
    public final float mTranslationY;
    public final float mTranslationZ;

    public ChangeTransform$Transforms(View view) {
        this.mTranslationX = view.getTranslationX();
        this.mTranslationY = view.getTranslationY();
        this.mTranslationZ = ViewCompat.getTranslationZ(view);
        this.mScaleX = view.getScaleX();
        this.mScaleY = view.getScaleY();
        this.mRotationX = view.getRotationX();
        this.mRotationY = view.getRotationY();
        this.mRotationZ = view.getRotation();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ChangeTransform$Transforms)) {
            return false;
        }
        ChangeTransform$Transforms changeTransform$Transforms = (ChangeTransform$Transforms) obj;
        return changeTransform$Transforms.mTranslationX == this.mTranslationX && changeTransform$Transforms.mTranslationY == this.mTranslationY && changeTransform$Transforms.mTranslationZ == this.mTranslationZ && changeTransform$Transforms.mScaleX == this.mScaleX && changeTransform$Transforms.mScaleY == this.mScaleY && changeTransform$Transforms.mRotationX == this.mRotationX && changeTransform$Transforms.mRotationY == this.mRotationY && changeTransform$Transforms.mRotationZ == this.mRotationZ;
    }

    public int hashCode() {
        float f = this.mTranslationX;
        int iFloatToIntBits = (f != 0.0f ? Float.floatToIntBits(f) : 0) * 31;
        float f2 = this.mTranslationY;
        int iFloatToIntBits2 = (iFloatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31;
        float f3 = this.mTranslationZ;
        int iFloatToIntBits3 = (iFloatToIntBits2 + (f3 != 0.0f ? Float.floatToIntBits(f3) : 0)) * 31;
        float f4 = this.mScaleX;
        int iFloatToIntBits4 = (iFloatToIntBits3 + (f4 != 0.0f ? Float.floatToIntBits(f4) : 0)) * 31;
        float f5 = this.mScaleY;
        int iFloatToIntBits5 = (iFloatToIntBits4 + (f5 != 0.0f ? Float.floatToIntBits(f5) : 0)) * 31;
        float f6 = this.mRotationX;
        int iFloatToIntBits6 = (iFloatToIntBits5 + (f6 != 0.0f ? Float.floatToIntBits(f6) : 0)) * 31;
        float f7 = this.mRotationY;
        int iFloatToIntBits7 = (iFloatToIntBits6 + (f7 != 0.0f ? Float.floatToIntBits(f7) : 0)) * 31;
        float f8 = this.mRotationZ;
        return iFloatToIntBits7 + (f8 != 0.0f ? Float.floatToIntBits(f8) : 0);
    }

    public void restore(View view) {
        ChangeTransform.setTransforms(view, this.mTranslationX, this.mTranslationY, this.mTranslationZ, this.mScaleX, this.mScaleY, this.mRotationX, this.mRotationY, this.mRotationZ);
    }
}
