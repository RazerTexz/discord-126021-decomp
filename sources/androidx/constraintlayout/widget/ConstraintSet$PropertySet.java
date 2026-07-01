package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintSet$PropertySet {
    public boolean mApply = false;
    public int visibility = 0;
    public int mVisibilityMode = 0;
    public float alpha = 1.0f;
    public float mProgress = Float.NaN;

    public void copyFrom(ConstraintSet$PropertySet constraintSet$PropertySet) {
        this.mApply = constraintSet$PropertySet.mApply;
        this.visibility = constraintSet$PropertySet.visibility;
        this.alpha = constraintSet$PropertySet.alpha;
        this.mProgress = constraintSet$PropertySet.mProgress;
        this.mVisibilityMode = constraintSet$PropertySet.mVisibilityMode;
    }

    public void fillFromAttributeList(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PropertySet);
        this.mApply = true;
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == R$styleable.PropertySet_android_alpha) {
                this.alpha = typedArrayObtainStyledAttributes.getFloat(index, this.alpha);
            } else if (index == R$styleable.PropertySet_android_visibility) {
                this.visibility = typedArrayObtainStyledAttributes.getInt(index, this.visibility);
                this.visibility = ConstraintSet.access$200()[this.visibility];
            } else if (index == R$styleable.PropertySet_visibilityMode) {
                this.mVisibilityMode = typedArrayObtainStyledAttributes.getInt(index, this.mVisibilityMode);
            } else if (index == R$styleable.PropertySet_motionProgress) {
                this.mProgress = typedArrayObtainStyledAttributes.getFloat(index, this.mProgress);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
