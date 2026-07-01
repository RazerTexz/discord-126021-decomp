package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class StateSet {
    private static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";
    public ConstraintSet mDefaultConstraintSet;
    public int mDefaultState = -1;
    public int mCurrentStateId = -1;
    public int mCurrentConstraintNumber = -1;
    private SparseArray<StateSet$State> mStateList = new SparseArray<>();
    private SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray<>();
    private ConstraintsChangedListener mConstraintsChangedListener = null;

    public StateSet(Context context, XmlPullParser xmlPullParser) {
        load(context, xmlPullParser);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void load(Context context, XmlPullParser xmlPullParser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.StateSet);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == R$styleable.StateSet_defaultState) {
                this.mDefaultState = typedArrayObtainStyledAttributes.getResourceId(index, this.mDefaultState);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        StateSet$State stateSet$State = null;
        try {
            int eventType = xmlPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 0) {
                    xmlPullParser.getName();
                } else if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    byte b2 = -1;
                    switch (name.hashCode()) {
                        case 80204913:
                            if (name.equals("State")) {
                                b2 = 2;
                            }
                            break;
                        case 1301459538:
                            if (name.equals("LayoutDescription")) {
                                b2 = 0;
                            }
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                b2 = 1;
                            }
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                b2 = 3;
                            }
                            break;
                    }
                    if (b2 != 0 && b2 != 1) {
                        if (b2 == 2) {
                            stateSet$State = new StateSet$State(context, xmlPullParser);
                            this.mStateList.put(stateSet$State.mId, stateSet$State);
                        } else if (b2 != 3) {
                            Log.v("ConstraintLayoutStates", "unknown tag " + name);
                        } else {
                            StateSet$Variant stateSet$Variant = new StateSet$Variant(context, xmlPullParser);
                            if (stateSet$State != null) {
                                stateSet$State.add(stateSet$Variant);
                            }
                        }
                    }
                } else if (eventType == 3 && "StateSet".equals(xmlPullParser.getName())) {
                    return;
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    public int convertToConstraintSet(int i, int i2, float f, float f2) {
        StateSet$State stateSet$State = this.mStateList.get(i2);
        if (stateSet$State == null) {
            return i2;
        }
        if (f == -1.0f || f2 == -1.0f) {
            if (stateSet$State.mConstraintID == i) {
                return i;
            }
            Iterator<StateSet$Variant> it = stateSet$State.mVariants.iterator();
            while (it.hasNext()) {
                if (i == it.next().mConstraintID) {
                    return i;
                }
            }
            return stateSet$State.mConstraintID;
        }
        StateSet$Variant stateSet$Variant = null;
        for (StateSet$Variant stateSet$Variant2 : stateSet$State.mVariants) {
            if (stateSet$Variant2.match(f, f2)) {
                if (i == stateSet$Variant2.mConstraintID) {
                    return i;
                }
                stateSet$Variant = stateSet$Variant2;
            }
        }
        return stateSet$Variant != null ? stateSet$Variant.mConstraintID : stateSet$State.mConstraintID;
    }

    public boolean needsToChange(int i, float f, float f2) {
        int i2 = this.mCurrentStateId;
        if (i2 != i) {
            return true;
        }
        StateSet$State stateSet$StateValueAt = i == -1 ? this.mStateList.valueAt(0) : this.mStateList.get(i2);
        int i3 = this.mCurrentConstraintNumber;
        return (i3 == -1 || !stateSet$StateValueAt.mVariants.get(i3).match(f, f2)) && this.mCurrentConstraintNumber != stateSet$StateValueAt.findMatch(f, f2);
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
    }

    public int stateGetConstraintID(int i, int i2, int i3) {
        return updateConstraints(-1, i, i2, i3);
    }

    public int updateConstraints(int i, int i2, float f, float f2) {
        int iFindMatch;
        if (i != i2) {
            StateSet$State stateSet$State = this.mStateList.get(i2);
            if (stateSet$State == null) {
                return -1;
            }
            int iFindMatch2 = stateSet$State.findMatch(f, f2);
            return iFindMatch2 == -1 ? stateSet$State.mConstraintID : stateSet$State.mVariants.get(iFindMatch2).mConstraintID;
        }
        StateSet$State stateSet$StateValueAt = i2 == -1 ? this.mStateList.valueAt(0) : this.mStateList.get(this.mCurrentStateId);
        if (stateSet$StateValueAt == null) {
            return -1;
        }
        if ((this.mCurrentConstraintNumber == -1 || !stateSet$StateValueAt.mVariants.get(i).match(f, f2)) && i != (iFindMatch = stateSet$StateValueAt.findMatch(f, f2))) {
            return iFindMatch == -1 ? stateSet$StateValueAt.mConstraintID : stateSet$StateValueAt.mVariants.get(iFindMatch).mConstraintID;
        }
        return i;
    }
}
