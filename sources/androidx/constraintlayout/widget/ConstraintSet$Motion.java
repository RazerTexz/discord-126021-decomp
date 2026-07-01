package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.utils.Easing;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintSet$Motion {
    private static final int ANIMATE_RELATIVE_TO = 5;
    private static final int MOTION_DRAW_PATH = 4;
    private static final int MOTION_STAGGER = 6;
    private static final int PATH_MOTION_ARC = 2;
    private static final int TRANSITION_EASING = 3;
    private static final int TRANSITION_PATH_ROTATE = 1;
    private static SparseIntArray mapToConstant;
    public boolean mApply = false;
    public int mAnimateRelativeTo = -1;
    public String mTransitionEasing = null;
    public int mPathMotionArc = -1;
    public int mDrawPath = 0;
    public float mMotionStagger = Float.NaN;
    public float mPathRotate = Float.NaN;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        mapToConstant = sparseIntArray;
        sparseIntArray.append(R$styleable.Motion_motionPathRotate, 1);
        mapToConstant.append(R$styleable.Motion_pathMotionArc, 2);
        mapToConstant.append(R$styleable.Motion_transitionEasing, 3);
        mapToConstant.append(R$styleable.Motion_drawPath, 4);
        mapToConstant.append(R$styleable.Motion_animate_relativeTo, 5);
        mapToConstant.append(R$styleable.Motion_motionStagger, 6);
    }

    public void copyFrom(ConstraintSet$Motion constraintSet$Motion) {
        this.mApply = constraintSet$Motion.mApply;
        this.mAnimateRelativeTo = constraintSet$Motion.mAnimateRelativeTo;
        this.mTransitionEasing = constraintSet$Motion.mTransitionEasing;
        this.mPathMotionArc = constraintSet$Motion.mPathMotionArc;
        this.mDrawPath = constraintSet$Motion.mDrawPath;
        this.mPathRotate = constraintSet$Motion.mPathRotate;
        this.mMotionStagger = constraintSet$Motion.mMotionStagger;
    }

    public void fillFromAttributeList(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Motion);
        this.mApply = true;
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            switch (mapToConstant.get(index)) {
                case 1:
                    this.mPathRotate = typedArrayObtainStyledAttributes.getFloat(index, this.mPathRotate);
                    break;
                case 2:
                    this.mPathMotionArc = typedArrayObtainStyledAttributes.getInt(index, this.mPathMotionArc);
                    break;
                case 3:
                    if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                        this.mTransitionEasing = typedArrayObtainStyledAttributes.getString(index);
                    } else {
                        this.mTransitionEasing = Easing.NAMED_EASING[typedArrayObtainStyledAttributes.getInteger(index, 0)];
                    }
                    break;
                case 4:
                    this.mDrawPath = typedArrayObtainStyledAttributes.getInt(index, 0);
                    break;
                case 5:
                    this.mAnimateRelativeTo = ConstraintSet.access$100(typedArrayObtainStyledAttributes, index, this.mAnimateRelativeTo);
                    break;
                case 6:
                    this.mMotionStagger = typedArrayObtainStyledAttributes.getFloat(index, this.mMotionStagger);
                    break;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
