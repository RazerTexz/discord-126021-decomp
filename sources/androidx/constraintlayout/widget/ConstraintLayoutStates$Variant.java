package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayoutStates$Variant {
    public int mConstraintID;
    public ConstraintSet mConstraintSet;
    public int mId;
    public float mMaxHeight;
    public float mMaxWidth;
    public float mMinHeight;
    public float mMinWidth;

    public ConstraintLayoutStates$Variant(Context context, XmlPullParser xmlPullParser) {
        this.mMinWidth = Float.NaN;
        this.mMinHeight = Float.NaN;
        this.mMaxWidth = Float.NaN;
        this.mMaxHeight = Float.NaN;
        this.mConstraintID = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.Variant);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == R$styleable.Variant_constraints) {
                this.mConstraintID = typedArrayObtainStyledAttributes.getResourceId(index, this.mConstraintID);
                String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                context.getResources().getResourceName(this.mConstraintID);
                if ("layout".equals(resourceTypeName)) {
                    ConstraintSet constraintSet = new ConstraintSet();
                    this.mConstraintSet = constraintSet;
                    constraintSet.clone(context, this.mConstraintID);
                }
            } else if (index == R$styleable.Variant_region_heightLessThan) {
                this.mMaxHeight = typedArrayObtainStyledAttributes.getDimension(index, this.mMaxHeight);
            } else if (index == R$styleable.Variant_region_heightMoreThan) {
                this.mMinHeight = typedArrayObtainStyledAttributes.getDimension(index, this.mMinHeight);
            } else if (index == R$styleable.Variant_region_widthLessThan) {
                this.mMaxWidth = typedArrayObtainStyledAttributes.getDimension(index, this.mMaxWidth);
            } else if (index == R$styleable.Variant_region_widthMoreThan) {
                this.mMinWidth = typedArrayObtainStyledAttributes.getDimension(index, this.mMinWidth);
            } else {
                Log.v("ConstraintLayoutStates", "Unknown tag");
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public boolean match(float f, float f2) {
        if (!Float.isNaN(this.mMinWidth) && f < this.mMinWidth) {
            return false;
        }
        if (!Float.isNaN(this.mMinHeight) && f2 < this.mMinHeight) {
            return false;
        }
        if (Float.isNaN(this.mMaxWidth) || f <= this.mMaxWidth) {
            return Float.isNaN(this.mMaxHeight) || f2 <= this.mMaxHeight;
        }
        return false;
    }
}
