package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintSet$Transform {
    private static final int ELEVATION = 11;
    private static final int ROTATION = 1;
    private static final int ROTATION_X = 2;
    private static final int ROTATION_Y = 3;
    private static final int SCALE_X = 4;
    private static final int SCALE_Y = 5;
    private static final int TRANSFORM_PIVOT_X = 6;
    private static final int TRANSFORM_PIVOT_Y = 7;
    private static final int TRANSLATION_X = 8;
    private static final int TRANSLATION_Y = 9;
    private static final int TRANSLATION_Z = 10;
    private static SparseIntArray mapToConstant;
    public boolean mApply = false;
    public float rotation = 0.0f;
    public float rotationX = 0.0f;
    public float rotationY = 0.0f;
    public float scaleX = 1.0f;
    public float scaleY = 1.0f;
    public float transformPivotX = Float.NaN;
    public float transformPivotY = Float.NaN;
    public float translationX = 0.0f;
    public float translationY = 0.0f;
    public float translationZ = 0.0f;
    public boolean applyElevation = false;
    public float elevation = 0.0f;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        mapToConstant = sparseIntArray;
        sparseIntArray.append(R$styleable.Transform_android_rotation, 1);
        mapToConstant.append(R$styleable.Transform_android_rotationX, 2);
        mapToConstant.append(R$styleable.Transform_android_rotationY, 3);
        mapToConstant.append(R$styleable.Transform_android_scaleX, 4);
        mapToConstant.append(R$styleable.Transform_android_scaleY, 5);
        mapToConstant.append(R$styleable.Transform_android_transformPivotX, 6);
        mapToConstant.append(R$styleable.Transform_android_transformPivotY, 7);
        mapToConstant.append(R$styleable.Transform_android_translationX, 8);
        mapToConstant.append(R$styleable.Transform_android_translationY, 9);
        mapToConstant.append(R$styleable.Transform_android_translationZ, 10);
        mapToConstant.append(R$styleable.Transform_android_elevation, 11);
    }

    public void copyFrom(ConstraintSet$Transform constraintSet$Transform) {
        this.mApply = constraintSet$Transform.mApply;
        this.rotation = constraintSet$Transform.rotation;
        this.rotationX = constraintSet$Transform.rotationX;
        this.rotationY = constraintSet$Transform.rotationY;
        this.scaleX = constraintSet$Transform.scaleX;
        this.scaleY = constraintSet$Transform.scaleY;
        this.transformPivotX = constraintSet$Transform.transformPivotX;
        this.transformPivotY = constraintSet$Transform.transformPivotY;
        this.translationX = constraintSet$Transform.translationX;
        this.translationY = constraintSet$Transform.translationY;
        this.translationZ = constraintSet$Transform.translationZ;
        this.applyElevation = constraintSet$Transform.applyElevation;
        this.elevation = constraintSet$Transform.elevation;
    }

    public void fillFromAttributeList(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Transform);
        this.mApply = true;
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            switch (mapToConstant.get(index)) {
                case 1:
                    this.rotation = typedArrayObtainStyledAttributes.getFloat(index, this.rotation);
                    break;
                case 2:
                    this.rotationX = typedArrayObtainStyledAttributes.getFloat(index, this.rotationX);
                    break;
                case 3:
                    this.rotationY = typedArrayObtainStyledAttributes.getFloat(index, this.rotationY);
                    break;
                case 4:
                    this.scaleX = typedArrayObtainStyledAttributes.getFloat(index, this.scaleX);
                    break;
                case 5:
                    this.scaleY = typedArrayObtainStyledAttributes.getFloat(index, this.scaleY);
                    break;
                case 6:
                    this.transformPivotX = typedArrayObtainStyledAttributes.getDimension(index, this.transformPivotX);
                    break;
                case 7:
                    this.transformPivotY = typedArrayObtainStyledAttributes.getDimension(index, this.transformPivotY);
                    break;
                case 8:
                    this.translationX = typedArrayObtainStyledAttributes.getDimension(index, this.translationX);
                    break;
                case 9:
                    this.translationY = typedArrayObtainStyledAttributes.getDimension(index, this.translationY);
                    break;
                case 10:
                    this.translationZ = typedArrayObtainStyledAttributes.getDimension(index, this.translationZ);
                    break;
                case 11:
                    this.applyElevation = true;
                    this.elevation = typedArrayObtainStyledAttributes.getDimension(index, this.elevation);
                    break;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
