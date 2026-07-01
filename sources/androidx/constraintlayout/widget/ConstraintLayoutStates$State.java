package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Xml;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayoutStates$State {
    public int mConstraintID;
    public ConstraintSet mConstraintSet;
    public int mId;
    public ArrayList<ConstraintLayoutStates$Variant> mVariants = new ArrayList<>();

    public ConstraintLayoutStates$State(Context context, XmlPullParser xmlPullParser) {
        this.mConstraintID = -1;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.State);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == R$styleable.State_android_id) {
                this.mId = typedArrayObtainStyledAttributes.getResourceId(index, this.mId);
            } else if (index == R$styleable.State_constraints) {
                this.mConstraintID = typedArrayObtainStyledAttributes.getResourceId(index, this.mConstraintID);
                String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                context.getResources().getResourceName(this.mConstraintID);
                if ("layout".equals(resourceTypeName)) {
                    ConstraintSet constraintSet = new ConstraintSet();
                    this.mConstraintSet = constraintSet;
                    constraintSet.clone(context, this.mConstraintID);
                }
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void add(ConstraintLayoutStates$Variant constraintLayoutStates$Variant) {
        this.mVariants.add(constraintLayoutStates$Variant);
    }

    public int findMatch(float f, float f2) {
        for (int i = 0; i < this.mVariants.size(); i++) {
            if (this.mVariants.get(i).match(f, f2)) {
                return i;
            }
        }
        return -1;
    }
}
