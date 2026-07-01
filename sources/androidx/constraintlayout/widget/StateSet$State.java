package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Xml;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class StateSet$State {
    public int mConstraintID;
    public int mId;
    public boolean mIsLayout;
    public ArrayList<StateSet$Variant> mVariants = new ArrayList<>();

    public StateSet$State(Context context, XmlPullParser xmlPullParser) {
        this.mConstraintID = -1;
        this.mIsLayout = false;
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
                    this.mIsLayout = true;
                }
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void add(StateSet$Variant stateSet$Variant) {
        this.mVariants.add(stateSet$Variant);
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
