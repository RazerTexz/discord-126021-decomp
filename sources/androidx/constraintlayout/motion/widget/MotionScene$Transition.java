package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R$styleable;
import b.d.b.a.a;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class MotionScene$Transition {
    public static final int AUTO_ANIMATE_TO_END = 4;
    public static final int AUTO_ANIMATE_TO_START = 3;
    public static final int AUTO_JUMP_TO_END = 2;
    public static final int AUTO_JUMP_TO_START = 1;
    public static final int AUTO_NONE = 0;
    public static final int TRANSITION_FLAG_FIRST_DRAW = 1;
    private int mAutoTransition;
    private int mConstraintSetEnd;
    private int mConstraintSetStart;
    private int mDefaultInterpolator;
    private int mDefaultInterpolatorID;
    private String mDefaultInterpolatorString;
    private boolean mDisable;
    private int mDuration;
    private int mId;
    private boolean mIsAbstract;
    private ArrayList<KeyFrames> mKeyFramesList;
    private int mLayoutDuringTransition;
    private final MotionScene mMotionScene;
    private ArrayList<MotionScene$Transition$TransitionOnClick> mOnClicks;
    private int mPathMotionArc;
    private float mStagger;
    private TouchResponse mTouchResponse;
    private int mTransitionFlags;

    public MotionScene$Transition(MotionScene motionScene, MotionScene$Transition motionScene$Transition) {
        this.mId = -1;
        this.mIsAbstract = false;
        this.mConstraintSetEnd = -1;
        this.mConstraintSetStart = -1;
        this.mDefaultInterpolator = 0;
        this.mDefaultInterpolatorString = null;
        this.mDefaultInterpolatorID = -1;
        this.mDuration = 400;
        this.mStagger = 0.0f;
        this.mKeyFramesList = new ArrayList<>();
        this.mTouchResponse = null;
        this.mOnClicks = new ArrayList<>();
        this.mAutoTransition = 0;
        this.mDisable = false;
        this.mPathMotionArc = -1;
        this.mLayoutDuringTransition = 0;
        this.mTransitionFlags = 0;
        this.mMotionScene = motionScene;
        if (motionScene$Transition != null) {
            this.mPathMotionArc = motionScene$Transition.mPathMotionArc;
            this.mDefaultInterpolator = motionScene$Transition.mDefaultInterpolator;
            this.mDefaultInterpolatorString = motionScene$Transition.mDefaultInterpolatorString;
            this.mDefaultInterpolatorID = motionScene$Transition.mDefaultInterpolatorID;
            this.mDuration = motionScene$Transition.mDuration;
            this.mKeyFramesList = motionScene$Transition.mKeyFramesList;
            this.mStagger = motionScene$Transition.mStagger;
            this.mLayoutDuringTransition = motionScene$Transition.mLayoutDuringTransition;
        }
    }

    public static /* synthetic */ int access$000(MotionScene$Transition motionScene$Transition) {
        return motionScene$Transition.mConstraintSetEnd;
    }

    public static /* synthetic */ int access$002(MotionScene$Transition motionScene$Transition, int i) {
        motionScene$Transition.mConstraintSetEnd = i;
        return i;
    }

    public static /* synthetic */ int access$100(MotionScene$Transition motionScene$Transition) {
        return motionScene$Transition.mConstraintSetStart;
    }

    public static /* synthetic */ int access$102(MotionScene$Transition motionScene$Transition, int i) {
        motionScene$Transition.mConstraintSetStart = i;
        return i;
    }

    public static /* synthetic */ boolean access$1200(MotionScene$Transition motionScene$Transition) {
        return motionScene$Transition.mIsAbstract;
    }

    public static /* synthetic */ ArrayList access$1300(MotionScene$Transition motionScene$Transition) {
        return motionScene$Transition.mKeyFramesList;
    }

    public static /* synthetic */ int access$1400(MotionScene$Transition motionScene$Transition) {
        return motionScene$Transition.mDefaultInterpolator;
    }

    public static /* synthetic */ String access$1500(MotionScene$Transition motionScene$Transition) {
        return motionScene$Transition.mDefaultInterpolatorString;
    }

    public static /* synthetic */ int access$1600(MotionScene$Transition motionScene$Transition) {
        return motionScene$Transition.mDefaultInterpolatorID;
    }

    public static /* synthetic */ int access$1700(MotionScene$Transition motionScene$Transition) {
        return motionScene$Transition.mDuration;
    }

    public static /* synthetic */ int access$1800(MotionScene$Transition motionScene$Transition) {
        return motionScene$Transition.mPathMotionArc;
    }

    public static /* synthetic */ float access$1900(MotionScene$Transition motionScene$Transition) {
        return motionScene$Transition.mStagger;
    }

    public static /* synthetic */ TouchResponse access$200(MotionScene$Transition motionScene$Transition) {
        return motionScene$Transition.mTouchResponse;
    }

    public static /* synthetic */ TouchResponse access$202(MotionScene$Transition motionScene$Transition, TouchResponse touchResponse) {
        motionScene$Transition.mTouchResponse = touchResponse;
        return touchResponse;
    }

    public static /* synthetic */ int access$300(MotionScene$Transition motionScene$Transition) {
        return motionScene$Transition.mId;
    }

    public static /* synthetic */ ArrayList access$400(MotionScene$Transition motionScene$Transition) {
        return motionScene$Transition.mOnClicks;
    }

    public static /* synthetic */ boolean access$500(MotionScene$Transition motionScene$Transition) {
        return motionScene$Transition.mDisable;
    }

    public static /* synthetic */ int access$600(MotionScene$Transition motionScene$Transition) {
        return motionScene$Transition.mAutoTransition;
    }

    public static /* synthetic */ MotionScene access$700(MotionScene$Transition motionScene$Transition) {
        return motionScene$Transition.mMotionScene;
    }

    private void fill(MotionScene motionScene, Context context, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            if (index == R$styleable.Transition_constraintSetEnd) {
                this.mConstraintSetEnd = typedArray.getResourceId(index, this.mConstraintSetEnd);
                if ("layout".equals(context.getResources().getResourceTypeName(this.mConstraintSetEnd))) {
                    ConstraintSet constraintSet = new ConstraintSet();
                    constraintSet.load(context, this.mConstraintSetEnd);
                    MotionScene.access$1100(motionScene).append(this.mConstraintSetEnd, constraintSet);
                }
            } else if (index == R$styleable.Transition_constraintSetStart) {
                this.mConstraintSetStart = typedArray.getResourceId(index, this.mConstraintSetStart);
                if ("layout".equals(context.getResources().getResourceTypeName(this.mConstraintSetStart))) {
                    ConstraintSet constraintSet2 = new ConstraintSet();
                    constraintSet2.load(context, this.mConstraintSetStart);
                    MotionScene.access$1100(motionScene).append(this.mConstraintSetStart, constraintSet2);
                }
            } else if (index == R$styleable.Transition_motionInterpolator) {
                int i2 = typedArray.peekValue(index).type;
                if (i2 == 1) {
                    int resourceId = typedArray.getResourceId(index, -1);
                    this.mDefaultInterpolatorID = resourceId;
                    if (resourceId != -1) {
                        this.mDefaultInterpolator = -2;
                    }
                } else if (i2 == 3) {
                    String string = typedArray.getString(index);
                    this.mDefaultInterpolatorString = string;
                    if (string.indexOf(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN) > 0) {
                        this.mDefaultInterpolatorID = typedArray.getResourceId(index, -1);
                        this.mDefaultInterpolator = -2;
                    } else {
                        this.mDefaultInterpolator = -1;
                    }
                } else {
                    this.mDefaultInterpolator = typedArray.getInteger(index, this.mDefaultInterpolator);
                }
            } else if (index == R$styleable.Transition_duration) {
                this.mDuration = typedArray.getInt(index, this.mDuration);
            } else if (index == R$styleable.Transition_staggered) {
                this.mStagger = typedArray.getFloat(index, this.mStagger);
            } else if (index == R$styleable.Transition_autoTransition) {
                this.mAutoTransition = typedArray.getInteger(index, this.mAutoTransition);
            } else if (index == R$styleable.Transition_android_id) {
                this.mId = typedArray.getResourceId(index, this.mId);
            } else if (index == R$styleable.Transition_transitionDisable) {
                this.mDisable = typedArray.getBoolean(index, this.mDisable);
            } else if (index == R$styleable.Transition_pathMotionArc) {
                this.mPathMotionArc = typedArray.getInteger(index, -1);
            } else if (index == R$styleable.Transition_layoutDuringTransition) {
                this.mLayoutDuringTransition = typedArray.getInteger(index, 0);
            } else if (index == R$styleable.Transition_transitionFlags) {
                this.mTransitionFlags = typedArray.getInteger(index, 0);
            }
        }
        if (this.mConstraintSetStart == -1) {
            this.mIsAbstract = true;
        }
    }

    private void fillFromAttributeList(MotionScene motionScene, Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Transition);
        fill(motionScene, context, typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void addOnClick(Context context, XmlPullParser xmlPullParser) {
        this.mOnClicks.add(new MotionScene$Transition$TransitionOnClick(context, this, xmlPullParser));
    }

    public String debugString(Context context) {
        String resourceEntryName = this.mConstraintSetStart == -1 ? "null" : context.getResources().getResourceEntryName(this.mConstraintSetStart);
        if (this.mConstraintSetEnd == -1) {
            return a.w(resourceEntryName, " -> null");
        }
        StringBuilder sbX = a.X(resourceEntryName, " -> ");
        sbX.append(context.getResources().getResourceEntryName(this.mConstraintSetEnd));
        return sbX.toString();
    }

    public int getAutoTransition() {
        return this.mAutoTransition;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public int getEndConstraintSetId() {
        return this.mConstraintSetEnd;
    }

    public int getId() {
        return this.mId;
    }

    public List<KeyFrames> getKeyFrameList() {
        return this.mKeyFramesList;
    }

    public int getLayoutDuringTransition() {
        return this.mLayoutDuringTransition;
    }

    public List<MotionScene$Transition$TransitionOnClick> getOnClickList() {
        return this.mOnClicks;
    }

    public int getPathMotionArc() {
        return this.mPathMotionArc;
    }

    public float getStagger() {
        return this.mStagger;
    }

    public int getStartConstraintSetId() {
        return this.mConstraintSetStart;
    }

    public TouchResponse getTouchResponse() {
        return this.mTouchResponse;
    }

    public boolean isEnabled() {
        return !this.mDisable;
    }

    public boolean isTransitionFlag(int i) {
        return (i & this.mTransitionFlags) != 0;
    }

    public void setAutoTransition(int i) {
        this.mAutoTransition = i;
    }

    public void setDuration(int i) {
        this.mDuration = i;
    }

    public void setEnable(boolean z2) {
        this.mDisable = !z2;
    }

    public void setPathMotionArc(int i) {
        this.mPathMotionArc = i;
    }

    public void setStagger(float f) {
        this.mStagger = f;
    }

    public MotionScene$Transition(int i, MotionScene motionScene, int i2, int i3) {
        this.mId = -1;
        this.mIsAbstract = false;
        this.mConstraintSetEnd = -1;
        this.mConstraintSetStart = -1;
        this.mDefaultInterpolator = 0;
        this.mDefaultInterpolatorString = null;
        this.mDefaultInterpolatorID = -1;
        this.mDuration = 400;
        this.mStagger = 0.0f;
        this.mKeyFramesList = new ArrayList<>();
        this.mTouchResponse = null;
        this.mOnClicks = new ArrayList<>();
        this.mAutoTransition = 0;
        this.mDisable = false;
        this.mPathMotionArc = -1;
        this.mLayoutDuringTransition = 0;
        this.mTransitionFlags = 0;
        this.mId = i;
        this.mMotionScene = motionScene;
        this.mConstraintSetStart = i2;
        this.mConstraintSetEnd = i3;
        this.mDuration = MotionScene.access$900(motionScene);
        this.mLayoutDuringTransition = MotionScene.access$1000(motionScene);
    }

    public MotionScene$Transition(MotionScene motionScene, Context context, XmlPullParser xmlPullParser) {
        this.mId = -1;
        this.mIsAbstract = false;
        this.mConstraintSetEnd = -1;
        this.mConstraintSetStart = -1;
        this.mDefaultInterpolator = 0;
        this.mDefaultInterpolatorString = null;
        this.mDefaultInterpolatorID = -1;
        this.mDuration = 400;
        this.mStagger = 0.0f;
        this.mKeyFramesList = new ArrayList<>();
        this.mTouchResponse = null;
        this.mOnClicks = new ArrayList<>();
        this.mAutoTransition = 0;
        this.mDisable = false;
        this.mPathMotionArc = -1;
        this.mLayoutDuringTransition = 0;
        this.mTransitionFlags = 0;
        this.mDuration = MotionScene.access$900(motionScene);
        this.mLayoutDuringTransition = MotionScene.access$1000(motionScene);
        this.mMotionScene = motionScene;
        fillFromAttributeList(motionScene, context, Xml.asAttributeSet(xmlPullParser));
    }
}
