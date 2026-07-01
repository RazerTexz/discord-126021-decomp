package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.view.View$OnClickListener;
import androidx.constraintlayout.widget.R$styleable;
import b.d.b.a.a;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes.dex */
public class MotionScene$Transition$TransitionOnClick implements View$OnClickListener {
    public static final int ANIM_TOGGLE = 17;
    public static final int ANIM_TO_END = 1;
    public static final int ANIM_TO_START = 16;
    public static final int JUMP_TO_END = 256;
    public static final int JUMP_TO_START = 4096;
    public int mMode;
    public int mTargetId;
    private final MotionScene$Transition mTransition;

    public MotionScene$Transition$TransitionOnClick(Context context, MotionScene$Transition motionScene$Transition, XmlPullParser xmlPullParser) {
        this.mTargetId = -1;
        this.mMode = 17;
        this.mTransition = motionScene$Transition;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.OnClick);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == R$styleable.OnClick_targetId) {
                this.mTargetId = typedArrayObtainStyledAttributes.getResourceId(index, this.mTargetId);
            } else if (index == R$styleable.OnClick_clickAction) {
                this.mMode = typedArrayObtainStyledAttributes.getInt(index, this.mMode);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public void addOnClickListeners(MotionLayout motionLayout, int i, MotionScene$Transition motionScene$Transition) {
        boolean z2;
        View viewFindViewById;
        int i2 = this.mTargetId;
        View view = motionLayout;
        if (i2 != -1) {
            viewFindViewById = motionLayout.findViewById(i2);
        }
        if (view == null) {
            view = viewFindViewById;
            StringBuilder sbU = a.U("OnClick could not find id ");
            sbU.append(this.mTargetId);
            Log.e(MotionScene.TAG, sbU.toString());
            return;
        }
        int iAccess$100 = MotionScene$Transition.access$100(motionScene$Transition);
        int iAccess$000 = MotionScene$Transition.access$000(motionScene$Transition);
        if (iAccess$100 == -1) {
            view = viewFindViewById;
            view.setOnClickListener(this);
            return;
        }
        int i3 = this.mMode;
        boolean z3 = false;
        if ((i3 & 1) == 0 || i != iAccess$100) {
            view = viewFindViewById;
            z2 = false;
        } else {
            z2 = true;
        }
        boolean z4 = ((i3 & 1) != 0 && i == iAccess$100) | z2 | ((i3 & 256) != 0 && i == iAccess$100) | ((i3 & 16) != 0 && i == iAccess$000);
        if ((i3 & 4096) != 0 && i == iAccess$000) {
            z3 = true;
        }
        if (z4 || z3) {
            view.setOnClickListener(this);
        }
    }

    public boolean isTransitionViable(MotionScene$Transition motionScene$Transition, MotionLayout motionLayout) {
        MotionScene$Transition motionScene$Transition2 = this.mTransition;
        if (motionScene$Transition2 == motionScene$Transition) {
            return true;
        }
        int iAccess$000 = MotionScene$Transition.access$000(motionScene$Transition2);
        int iAccess$100 = MotionScene$Transition.access$100(this.mTransition);
        if (iAccess$100 == -1) {
            return motionLayout.mCurrentState != iAccess$000;
        }
        int i = motionLayout.mCurrentState;
        return i == iAccess$100 || i == iAccess$000;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        MotionLayout motionLayoutAccess$800 = MotionScene.access$800(MotionScene$Transition.access$700(this.mTransition));
        if (motionLayoutAccess$800.isInteractionEnabled()) {
            if (MotionScene$Transition.access$100(this.mTransition) == -1) {
                int currentState = motionLayoutAccess$800.getCurrentState();
                if (currentState == -1) {
                    motionLayoutAccess$800.transitionToState(MotionScene$Transition.access$000(this.mTransition));
                    return;
                }
                MotionScene$Transition motionScene$Transition = new MotionScene$Transition(MotionScene$Transition.access$700(this.mTransition), this.mTransition);
                MotionScene$Transition.access$102(motionScene$Transition, currentState);
                MotionScene$Transition.access$002(motionScene$Transition, MotionScene$Transition.access$000(this.mTransition));
                motionLayoutAccess$800.setTransition(motionScene$Transition);
                motionLayoutAccess$800.transitionToEnd();
                return;
            }
            MotionScene$Transition motionScene$Transition2 = MotionScene$Transition.access$700(this.mTransition).mCurrentTransition;
            int i = this.mMode;
            boolean z2 = false;
            boolean z3 = ((i & 1) == 0 && (i & 256) == 0) ? false : true;
            boolean z4 = ((i & 16) == 0 && (i & 4096) == 0) ? false : true;
            if (z3 && z4) {
                MotionScene$Transition motionScene$Transition3 = MotionScene$Transition.access$700(this.mTransition).mCurrentTransition;
                MotionScene$Transition motionScene$Transition4 = this.mTransition;
                if (motionScene$Transition3 != motionScene$Transition4) {
                    motionLayoutAccess$800.setTransition(motionScene$Transition4);
                }
                if (motionLayoutAccess$800.getCurrentState() != motionLayoutAccess$800.getEndState() && motionLayoutAccess$800.getProgress() <= 0.5f) {
                    z2 = z3;
                    z4 = false;
                }
            } else {
                z2 = z3;
            }
            if (isTransitionViable(motionScene$Transition2, motionLayoutAccess$800)) {
                if (z2 && (this.mMode & 1) != 0) {
                    motionLayoutAccess$800.setTransition(this.mTransition);
                    motionLayoutAccess$800.transitionToEnd();
                    return;
                }
                if (z4 && (this.mMode & 16) != 0) {
                    motionLayoutAccess$800.setTransition(this.mTransition);
                    motionLayoutAccess$800.transitionToStart();
                } else if (z2 && (this.mMode & 256) != 0) {
                    motionLayoutAccess$800.setTransition(this.mTransition);
                    motionLayoutAccess$800.setProgress(1.0f);
                } else {
                    if (!z4 || (this.mMode & 4096) == 0) {
                        return;
                    }
                    motionLayoutAccess$800.setTransition(this.mTransition);
                    motionLayoutAccess$800.setProgress(0.0f);
                }
            }
        }
    }

    public void removeOnClickListeners(MotionLayout motionLayout) {
        int i = this.mTargetId;
        if (i == -1) {
            return;
        }
        View viewFindViewById = motionLayout.findViewById(i);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(null);
            return;
        }
        StringBuilder sbU = a.U(" (*)  could not find id ");
        sbU.append(this.mTargetId);
        Log.e(MotionScene.TAG, sbU.toString());
    }
}
