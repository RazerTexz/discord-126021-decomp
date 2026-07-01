package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R$id;
import androidx.constraintlayout.widget.R$styleable;
import androidx.constraintlayout.widget.StateSet;
import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map$Entry;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class MotionScene {
    public static final int ANTICIPATE = 4;
    public static final int BOUNCE = 5;
    private static final boolean DEBUG = false;
    public static final int EASE_IN = 1;
    public static final int EASE_IN_OUT = 0;
    public static final int EASE_OUT = 2;
    private static final int INTERPOLATOR_REFRENCE_ID = -2;
    public static final int LAYOUT_HONOR_REQUEST = 1;
    public static final int LAYOUT_IGNORE_REQUEST = 0;
    public static final int LINEAR = 3;
    private static final int SPLINE_STRING = -1;
    public static final String TAG = "MotionScene";
    public static final int TRANSITION_BACKWARD = 0;
    public static final int TRANSITION_FORWARD = 1;
    public static final int UNSET = -1;
    private MotionEvent mLastTouchDown;
    public float mLastTouchX;
    public float mLastTouchY;
    private final MotionLayout mMotionLayout;
    private boolean mRtl;
    private MotionLayout$MotionTracker mVelocityTracker;
    public StateSet mStateSet = null;
    public MotionScene$Transition mCurrentTransition = null;
    private boolean mDisableAutoTransition = false;
    private ArrayList<MotionScene$Transition> mTransitionList = new ArrayList<>();
    private MotionScene$Transition mDefaultTransition = null;
    private ArrayList<MotionScene$Transition> mAbstractTransitionList = new ArrayList<>();
    private SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray<>();
    private HashMap<String, Integer> mConstraintSetIdMap = new HashMap<>();
    private SparseIntArray mDeriveMap = new SparseIntArray();
    private boolean DEBUG_DESKTOP = false;
    private int mDefaultDuration = 400;
    private int mLayoutDuringTransition = 0;
    private boolean mIgnoreTouch = false;
    private boolean mMotionOutsideRegion = false;

    public MotionScene(MotionLayout motionLayout) {
        this.mMotionLayout = motionLayout;
    }

    public static /* synthetic */ int access$1000(MotionScene motionScene) {
        return motionScene.mLayoutDuringTransition;
    }

    public static /* synthetic */ SparseArray access$1100(MotionScene motionScene) {
        return motionScene.mConstraintSetMap;
    }

    public static /* synthetic */ MotionLayout access$800(MotionScene motionScene) {
        return motionScene.mMotionLayout;
    }

    public static /* synthetic */ int access$900(MotionScene motionScene) {
        return motionScene.mDefaultDuration;
    }

    private int getId(Context context, String str) {
        int identifier;
        if (str.contains(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN)) {
            identifier = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), ModelAuditLogEntry.CHANGE_KEY_ID, context.getPackageName());
            if (this.DEBUG_DESKTOP) {
                System.out.println("id getMap res = " + identifier);
            }
        } else {
            identifier = -1;
        }
        if (identifier != -1) {
            return identifier;
        }
        if (str.length() > 1) {
            return Integer.parseInt(str.substring(1));
        }
        Log.e(TAG, "error in parsing id");
        return identifier;
    }

    private int getIndex(MotionScene$Transition motionScene$Transition) {
        int iAccess$300 = MotionScene$Transition.access$300(motionScene$Transition);
        if (iAccess$300 == -1) {
            throw new IllegalArgumentException("The transition must have an id");
        }
        for (int i = 0; i < this.mTransitionList.size(); i++) {
            if (MotionScene$Transition.access$300(this.mTransitionList.get(i)) == iAccess$300) {
                return i;
            }
        }
        return -1;
    }

    private int getRealID(int i) {
        int iStateGetConstraintID;
        StateSet stateSet = this.mStateSet;
        return (stateSet == null || (iStateGetConstraintID = stateSet.stateGetConstraintID(i, -1, -1)) == -1) ? i : iStateGetConstraintID;
    }

    private boolean hasCycleDependency(int i) {
        int i2 = this.mDeriveMap.get(i);
        int size = this.mDeriveMap.size();
        while (i2 > 0) {
            if (i2 == i) {
                return true;
            }
            int i3 = size - 1;
            if (size < 0) {
                return true;
            }
            i2 = this.mDeriveMap.get(i2);
            size = i3;
        }
        return false;
    }

    private boolean isProcessingTouch() {
        return this.mVelocityTracker != null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:38:0x0084  */
    private void load(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        MotionScene$Transition motionScene$Transition = null;
        try {
            int eventType = xml.getEventType();
            while (true) {
                if (eventType == 1) {
                    return;
                }
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    if (this.DEBUG_DESKTOP) {
                        System.out.println("parsing = " + name);
                    }
                    switch (name) {
                        case "MotionScene":
                            parseMotionSceneTags(context, xml);
                            break;
                        case "Transition":
                            ArrayList<MotionScene$Transition> arrayList = this.mTransitionList;
                            MotionScene$Transition motionScene$Transition2 = new MotionScene$Transition(this, context, xml);
                            arrayList.add(motionScene$Transition2);
                            if (this.mCurrentTransition == null && !MotionScene$Transition.access$1200(motionScene$Transition2)) {
                                this.mCurrentTransition = motionScene$Transition2;
                                if (MotionScene$Transition.access$200(motionScene$Transition2) != null) {
                                    MotionScene$Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
                                }
                            }
                            if (MotionScene$Transition.access$1200(motionScene$Transition2)) {
                                if (MotionScene$Transition.access$000(motionScene$Transition2) == -1) {
                                    this.mDefaultTransition = motionScene$Transition2;
                                } else {
                                    this.mAbstractTransitionList.add(motionScene$Transition2);
                                }
                                this.mTransitionList.remove(motionScene$Transition2);
                            }
                            motionScene$Transition = motionScene$Transition2;
                            break;
                        case "OnSwipe":
                            if (motionScene$Transition == null) {
                                Log.v(TAG, " OnSwipe (" + context.getResources().getResourceEntryName(i) + ".xml:" + xml.getLineNumber() + ")");
                            }
                            MotionScene$Transition.access$202(motionScene$Transition, new TouchResponse(context, this.mMotionLayout, xml));
                            break;
                        case "OnClick":
                            motionScene$Transition.addOnClick(context, xml);
                            break;
                        case "StateSet":
                            this.mStateSet = new StateSet(context, xml);
                            break;
                        case "ConstraintSet":
                            parseConstraintSet(context, xml);
                            break;
                        case "KeyFrameSet":
                            MotionScene$Transition.access$1300(motionScene$Transition).add(new KeyFrames(context, xml));
                            break;
                        default:
                            Log.v(TAG, "WARNING UNKNOWN ATTRIBUTE " + name);
                            break;
                    }
                }
                eventType = xml.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    private void parseConstraintSet(Context context, XmlPullParser xmlPullParser) {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.setForceId(false);
        int attributeCount = xmlPullParser.getAttributeCount();
        int id2 = -1;
        int id3 = -1;
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            if (this.DEBUG_DESKTOP) {
                System.out.println("id string = " + attributeValue);
            }
            attributeName.hashCode();
            if (attributeName.equals("deriveConstraintsFrom")) {
                id3 = getId(context, attributeValue);
            } else if (attributeName.equals(ModelAuditLogEntry.CHANGE_KEY_ID)) {
                id2 = getId(context, attributeValue);
                this.mConstraintSetIdMap.put(stripID(attributeValue), Integer.valueOf(id2));
            }
        }
        if (id2 != -1) {
            if (this.mMotionLayout.mDebugPath != 0) {
                constraintSet.setValidateOnParse(true);
            }
            constraintSet.load(context, xmlPullParser);
            if (id3 != -1) {
                this.mDeriveMap.put(id2, id3);
            }
            this.mConstraintSetMap.put(id2, constraintSet);
        }
    }

    private void parseMotionSceneTags(Context context, XmlPullParser xmlPullParser) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.MotionScene);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i);
            if (index == R$styleable.MotionScene_defaultDuration) {
                this.mDefaultDuration = typedArrayObtainStyledAttributes.getInt(index, this.mDefaultDuration);
            } else if (index == R$styleable.MotionScene_layoutDuringTransition) {
                this.mLayoutDuringTransition = typedArrayObtainStyledAttributes.getInteger(index, 0);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    private void readConstraintChain(int i) {
        int i2 = this.mDeriveMap.get(i);
        if (i2 > 0) {
            readConstraintChain(this.mDeriveMap.get(i));
            ConstraintSet constraintSet = this.mConstraintSetMap.get(i);
            ConstraintSet constraintSet2 = this.mConstraintSetMap.get(i2);
            if (constraintSet2 != null) {
                constraintSet.readFallback(constraintSet2);
                this.mDeriveMap.put(i, -1);
            } else {
                StringBuilder sbU = a.U("ERROR! invalid deriveConstraintsFrom: @id/");
                sbU.append(Debug.getName(this.mMotionLayout.getContext(), i2));
                Log.e(TAG, sbU.toString());
            }
        }
    }

    public static String stripID(String str) {
        if (str == null) {
            return "";
        }
        int iIndexOf = str.indexOf(47);
        return iIndexOf < 0 ? str : str.substring(iIndexOf + 1);
    }

    public void addOnClickListeners(MotionLayout motionLayout, int i) {
        for (MotionScene$Transition motionScene$Transition : this.mTransitionList) {
            if (MotionScene$Transition.access$400(motionScene$Transition).size() > 0) {
                Iterator it = MotionScene$Transition.access$400(motionScene$Transition).iterator();
                while (it.hasNext()) {
                    ((MotionScene$Transition$TransitionOnClick) it.next()).removeOnClickListeners(motionLayout);
                }
            }
        }
        for (MotionScene$Transition motionScene$Transition2 : this.mAbstractTransitionList) {
            if (MotionScene$Transition.access$400(motionScene$Transition2).size() > 0) {
                Iterator it2 = MotionScene$Transition.access$400(motionScene$Transition2).iterator();
                while (it2.hasNext()) {
                    ((MotionScene$Transition$TransitionOnClick) it2.next()).removeOnClickListeners(motionLayout);
                }
            }
        }
        for (MotionScene$Transition motionScene$Transition3 : this.mTransitionList) {
            if (MotionScene$Transition.access$400(motionScene$Transition3).size() > 0) {
                Iterator it3 = MotionScene$Transition.access$400(motionScene$Transition3).iterator();
                while (it3.hasNext()) {
                    ((MotionScene$Transition$TransitionOnClick) it3.next()).addOnClickListeners(motionLayout, i, motionScene$Transition3);
                }
            }
        }
        for (MotionScene$Transition motionScene$Transition4 : this.mAbstractTransitionList) {
            if (MotionScene$Transition.access$400(motionScene$Transition4).size() > 0) {
                Iterator it4 = MotionScene$Transition.access$400(motionScene$Transition4).iterator();
                while (it4.hasNext()) {
                    ((MotionScene$Transition$TransitionOnClick) it4.next()).addOnClickListeners(motionLayout, i, motionScene$Transition4);
                }
            }
        }
    }

    public void addTransition(MotionScene$Transition motionScene$Transition) {
        int index = getIndex(motionScene$Transition);
        if (index == -1) {
            this.mTransitionList.add(motionScene$Transition);
        } else {
            this.mTransitionList.set(index, motionScene$Transition);
        }
    }

    public boolean autoTransition(MotionLayout motionLayout, int i) {
        if (isProcessingTouch() || this.mDisableAutoTransition) {
            return false;
        }
        for (MotionScene$Transition motionScene$Transition : this.mTransitionList) {
            if (MotionScene$Transition.access$600(motionScene$Transition) != 0 && this.mCurrentTransition != motionScene$Transition) {
                if (i == MotionScene$Transition.access$100(motionScene$Transition) && (MotionScene$Transition.access$600(motionScene$Transition) == 4 || MotionScene$Transition.access$600(motionScene$Transition) == 2)) {
                    MotionLayout$TransitionState motionLayout$TransitionState = MotionLayout$TransitionState.FINISHED;
                    motionLayout.setState(motionLayout$TransitionState);
                    motionLayout.setTransition(motionScene$Transition);
                    if (MotionScene$Transition.access$600(motionScene$Transition) == 4) {
                        motionLayout.transitionToEnd();
                        motionLayout.setState(MotionLayout$TransitionState.SETUP);
                        motionLayout.setState(MotionLayout$TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.evaluate(true);
                        motionLayout.setState(MotionLayout$TransitionState.SETUP);
                        motionLayout.setState(MotionLayout$TransitionState.MOVING);
                        motionLayout.setState(motionLayout$TransitionState);
                        motionLayout.onNewStateAttachHandlers();
                    }
                    return true;
                }
                if (i == MotionScene$Transition.access$000(motionScene$Transition) && (MotionScene$Transition.access$600(motionScene$Transition) == 3 || MotionScene$Transition.access$600(motionScene$Transition) == 1)) {
                    MotionLayout$TransitionState motionLayout$TransitionState2 = MotionLayout$TransitionState.FINISHED;
                    motionLayout.setState(motionLayout$TransitionState2);
                    motionLayout.setTransition(motionScene$Transition);
                    if (MotionScene$Transition.access$600(motionScene$Transition) == 3) {
                        motionLayout.transitionToStart();
                        motionLayout.setState(MotionLayout$TransitionState.SETUP);
                        motionLayout.setState(MotionLayout$TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(0.0f);
                        motionLayout.evaluate(true);
                        motionLayout.setState(MotionLayout$TransitionState.SETUP);
                        motionLayout.setState(MotionLayout$TransitionState.MOVING);
                        motionLayout.setState(motionLayout$TransitionState2);
                        motionLayout.onNewStateAttachHandlers();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public MotionScene$Transition bestTransitionFor(int i, float f, float f2, MotionEvent motionEvent) {
        if (i == -1) {
            return this.mCurrentTransition;
        }
        List<MotionScene$Transition> transitionsWithState = getTransitionsWithState(i);
        float f3 = 0.0f;
        MotionScene$Transition motionScene$Transition = null;
        RectF rectF = new RectF();
        for (MotionScene$Transition motionScene$Transition2 : transitionsWithState) {
            if (!MotionScene$Transition.access$500(motionScene$Transition2) && MotionScene$Transition.access$200(motionScene$Transition2) != null) {
                MotionScene$Transition.access$200(motionScene$Transition2).setRTL(this.mRtl);
                RectF touchRegion = MotionScene$Transition.access$200(motionScene$Transition2).getTouchRegion(this.mMotionLayout, rectF);
                if (touchRegion == null || motionEvent == null || touchRegion.contains(motionEvent.getX(), motionEvent.getY())) {
                    RectF touchRegion2 = MotionScene$Transition.access$200(motionScene$Transition2).getTouchRegion(this.mMotionLayout, rectF);
                    if (touchRegion2 == null || motionEvent == null || touchRegion2.contains(motionEvent.getX(), motionEvent.getY())) {
                        float fDot = MotionScene$Transition.access$200(motionScene$Transition2).dot(f, f2) * (MotionScene$Transition.access$000(motionScene$Transition2) == i ? -1.0f : 1.1f);
                        if (fDot > f3) {
                            motionScene$Transition = motionScene$Transition2;
                            f3 = fDot;
                        }
                    }
                }
            }
        }
        return motionScene$Transition;
    }

    public void disableAutoTransition(boolean z2) {
        this.mDisableAutoTransition = z2;
    }

    public int gatPathMotionArc() {
        MotionScene$Transition motionScene$Transition = this.mCurrentTransition;
        if (motionScene$Transition != null) {
            return MotionScene$Transition.access$1800(motionScene$Transition);
        }
        return -1;
    }

    public ConstraintSet getConstraintSet(Context context, String str) {
        if (this.DEBUG_DESKTOP) {
            System.out.println("id " + str);
            PrintStream printStream = System.out;
            StringBuilder sbU = a.U("size ");
            sbU.append(this.mConstraintSetMap.size());
            printStream.println(sbU.toString());
        }
        for (int i = 0; i < this.mConstraintSetMap.size(); i++) {
            int iKeyAt = this.mConstraintSetMap.keyAt(i);
            String resourceName = context.getResources().getResourceName(iKeyAt);
            if (this.DEBUG_DESKTOP) {
                System.out.println("Id for <" + i + "> is <" + resourceName + "> looking for <" + str + ">");
            }
            if (str.equals(resourceName)) {
                return this.mConstraintSetMap.get(iKeyAt);
            }
        }
        return null;
    }

    public int[] getConstraintSetIds() {
        int size = this.mConstraintSetMap.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = this.mConstraintSetMap.keyAt(i);
        }
        return iArr;
    }

    public ArrayList<MotionScene$Transition> getDefinedTransitions() {
        return this.mTransitionList;
    }

    public int getDuration() {
        MotionScene$Transition motionScene$Transition = this.mCurrentTransition;
        return motionScene$Transition != null ? MotionScene$Transition.access$1700(motionScene$Transition) : this.mDefaultDuration;
    }

    public int getEndId() {
        MotionScene$Transition motionScene$Transition = this.mCurrentTransition;
        if (motionScene$Transition == null) {
            return -1;
        }
        return MotionScene$Transition.access$000(motionScene$Transition);
    }

    public Interpolator getInterpolator() {
        int iAccess$1400 = MotionScene$Transition.access$1400(this.mCurrentTransition);
        if (iAccess$1400 == -2) {
            return AnimationUtils.loadInterpolator(this.mMotionLayout.getContext(), MotionScene$Transition.access$1600(this.mCurrentTransition));
        }
        if (iAccess$1400 == -1) {
            return new MotionScene$1(this, Easing.getInterpolator(MotionScene$Transition.access$1500(this.mCurrentTransition)));
        }
        if (iAccess$1400 == 0) {
            return new AccelerateDecelerateInterpolator();
        }
        if (iAccess$1400 == 1) {
            return new AccelerateInterpolator();
        }
        if (iAccess$1400 == 2) {
            return new DecelerateInterpolator();
        }
        if (iAccess$1400 == 4) {
            return new AnticipateInterpolator();
        }
        if (iAccess$1400 != 5) {
            return null;
        }
        return new BounceInterpolator();
    }

    public Key getKeyFrame(Context context, int i, int i2, int i3) {
        MotionScene$Transition motionScene$Transition = this.mCurrentTransition;
        if (motionScene$Transition == null) {
            return null;
        }
        for (KeyFrames keyFrames : MotionScene$Transition.access$1300(motionScene$Transition)) {
            for (Integer num : keyFrames.getKeys()) {
                if (i2 == num.intValue()) {
                    for (Key key : keyFrames.getKeyFramesForView(num.intValue())) {
                        if (key.mFramePosition == i3 && key.mType == i) {
                            return key;
                        }
                    }
                }
            }
        }
        return null;
    }

    public void getKeyFrames(MotionController motionController) {
        MotionScene$Transition motionScene$Transition = this.mCurrentTransition;
        if (motionScene$Transition != null) {
            Iterator it = MotionScene$Transition.access$1300(motionScene$Transition).iterator();
            while (it.hasNext()) {
                ((KeyFrames) it.next()).addFrames(motionController);
            }
        } else {
            MotionScene$Transition motionScene$Transition2 = this.mDefaultTransition;
            if (motionScene$Transition2 != null) {
                Iterator it2 = MotionScene$Transition.access$1300(motionScene$Transition2).iterator();
                while (it2.hasNext()) {
                    ((KeyFrames) it2.next()).addFrames(motionController);
                }
            }
        }
    }

    public float getMaxAcceleration() {
        MotionScene$Transition motionScene$Transition = this.mCurrentTransition;
        if (motionScene$Transition == null || MotionScene$Transition.access$200(motionScene$Transition) == null) {
            return 0.0f;
        }
        return MotionScene$Transition.access$200(this.mCurrentTransition).getMaxAcceleration();
    }

    public float getMaxVelocity() {
        MotionScene$Transition motionScene$Transition = this.mCurrentTransition;
        if (motionScene$Transition == null || MotionScene$Transition.access$200(motionScene$Transition) == null) {
            return 0.0f;
        }
        return MotionScene$Transition.access$200(this.mCurrentTransition).getMaxVelocity();
    }

    public boolean getMoveWhenScrollAtTop() {
        MotionScene$Transition motionScene$Transition = this.mCurrentTransition;
        if (motionScene$Transition == null || MotionScene$Transition.access$200(motionScene$Transition) == null) {
            return false;
        }
        return MotionScene$Transition.access$200(this.mCurrentTransition).getMoveWhenScrollAtTop();
    }

    public float getPathPercent(View view, int i) {
        return 0.0f;
    }

    public float getProgressDirection(float f, float f2) {
        MotionScene$Transition motionScene$Transition = this.mCurrentTransition;
        if (motionScene$Transition == null || MotionScene$Transition.access$200(motionScene$Transition) == null) {
            return 0.0f;
        }
        return MotionScene$Transition.access$200(this.mCurrentTransition).getProgressDirection(f, f2);
    }

    public float getStaggered() {
        MotionScene$Transition motionScene$Transition = this.mCurrentTransition;
        if (motionScene$Transition != null) {
            return MotionScene$Transition.access$1900(motionScene$Transition);
        }
        return 0.0f;
    }

    public int getStartId() {
        MotionScene$Transition motionScene$Transition = this.mCurrentTransition;
        if (motionScene$Transition == null) {
            return -1;
        }
        return MotionScene$Transition.access$100(motionScene$Transition);
    }

    public MotionScene$Transition getTransitionById(int i) {
        for (MotionScene$Transition motionScene$Transition : this.mTransitionList) {
            if (MotionScene$Transition.access$300(motionScene$Transition) == i) {
                return motionScene$Transition;
            }
        }
        return null;
    }

    public int getTransitionDirection(int i) {
        Iterator<MotionScene$Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            if (MotionScene$Transition.access$100(it.next()) == i) {
                return 0;
            }
        }
        return 1;
    }

    public List<MotionScene$Transition> getTransitionsWithState(int i) {
        int realID = getRealID(i);
        ArrayList arrayList = new ArrayList();
        for (MotionScene$Transition motionScene$Transition : this.mTransitionList) {
            if (MotionScene$Transition.access$100(motionScene$Transition) == realID || MotionScene$Transition.access$000(motionScene$Transition) == realID) {
                arrayList.add(motionScene$Transition);
            }
        }
        return arrayList;
    }

    public boolean hasKeyFramePosition(View view, int i) {
        MotionScene$Transition motionScene$Transition = this.mCurrentTransition;
        if (motionScene$Transition == null) {
            return false;
        }
        Iterator it = MotionScene$Transition.access$1300(motionScene$Transition).iterator();
        while (it.hasNext()) {
            Iterator<Key> it2 = ((KeyFrames) it.next()).getKeyFramesForView(view.getId()).iterator();
            while (it2.hasNext()) {
                if (it2.next().mFramePosition == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public int lookUpConstraintId(String str) {
        return this.mConstraintSetIdMap.get(str).intValue();
    }

    public String lookUpConstraintName(int i) {
        for (Map$Entry<String, Integer> map$Entry : this.mConstraintSetIdMap.entrySet()) {
            if (map$Entry.getValue().intValue() == i) {
                return map$Entry.getKey();
            }
        }
        return null;
    }

    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
    }

    public void processScrollMove(float f, float f2) {
        MotionScene$Transition motionScene$Transition = this.mCurrentTransition;
        if (motionScene$Transition == null || MotionScene$Transition.access$200(motionScene$Transition) == null) {
            return;
        }
        MotionScene$Transition.access$200(this.mCurrentTransition).scrollMove(f, f2);
    }

    public void processScrollUp(float f, float f2) {
        MotionScene$Transition motionScene$Transition = this.mCurrentTransition;
        if (motionScene$Transition == null || MotionScene$Transition.access$200(motionScene$Transition) == null) {
            return;
        }
        MotionScene$Transition.access$200(this.mCurrentTransition).scrollUp(f, f2);
    }

    public void processTouchEvent(MotionEvent motionEvent, int i, MotionLayout motionLayout) {
        MotionLayout$MotionTracker motionLayout$MotionTracker;
        MotionEvent motionEvent2;
        RectF rectF = new RectF();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = this.mMotionLayout.obtainVelocityTracker();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (i != -1) {
            int action = motionEvent.getAction();
            boolean z2 = false;
            if (action == 0) {
                this.mLastTouchX = motionEvent.getRawX();
                this.mLastTouchY = motionEvent.getRawY();
                this.mLastTouchDown = motionEvent;
                this.mIgnoreTouch = false;
                if (MotionScene$Transition.access$200(this.mCurrentTransition) != null) {
                    RectF limitBoundsTo = MotionScene$Transition.access$200(this.mCurrentTransition).getLimitBoundsTo(this.mMotionLayout, rectF);
                    if (limitBoundsTo != null && !limitBoundsTo.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                        this.mLastTouchDown = null;
                        this.mIgnoreTouch = true;
                        return;
                    }
                    RectF touchRegion = MotionScene$Transition.access$200(this.mCurrentTransition).getTouchRegion(this.mMotionLayout, rectF);
                    if (touchRegion == null || touchRegion.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                        this.mMotionOutsideRegion = false;
                    } else {
                        this.mMotionOutsideRegion = true;
                    }
                    MotionScene$Transition.access$200(this.mCurrentTransition).setDown(this.mLastTouchX, this.mLastTouchY);
                    return;
                }
                return;
            }
            if (action == 2 && !this.mIgnoreTouch) {
                float rawY = motionEvent.getRawY() - this.mLastTouchY;
                float rawX = motionEvent.getRawX() - this.mLastTouchX;
                if ((rawX == 0.0d && rawY == 0.0d) || (motionEvent2 = this.mLastTouchDown) == null) {
                    return;
                }
                MotionScene$Transition motionScene$TransitionBestTransitionFor = bestTransitionFor(i, rawX, rawY, motionEvent2);
                if (motionScene$TransitionBestTransitionFor != null) {
                    motionLayout.setTransition(motionScene$TransitionBestTransitionFor);
                    RectF touchRegion2 = MotionScene$Transition.access$200(this.mCurrentTransition).getTouchRegion(this.mMotionLayout, rectF);
                    if (touchRegion2 != null && !touchRegion2.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                        z2 = true;
                    }
                    this.mMotionOutsideRegion = z2;
                    MotionScene$Transition.access$200(this.mCurrentTransition).setUpTouchEvent(this.mLastTouchX, this.mLastTouchY);
                }
            }
        }
        if (this.mIgnoreTouch) {
            return;
        }
        MotionScene$Transition motionScene$Transition = this.mCurrentTransition;
        if (motionScene$Transition != null && MotionScene$Transition.access$200(motionScene$Transition) != null && !this.mMotionOutsideRegion) {
            MotionScene$Transition.access$200(this.mCurrentTransition).processTouchEvent(motionEvent, this.mVelocityTracker, i, this);
        }
        this.mLastTouchX = motionEvent.getRawX();
        this.mLastTouchY = motionEvent.getRawY();
        if (motionEvent.getAction() != 1 || (motionLayout$MotionTracker = this.mVelocityTracker) == null) {
            return;
        }
        motionLayout$MotionTracker.recycle();
        this.mVelocityTracker = null;
        int i2 = motionLayout.mCurrentState;
        if (i2 != -1) {
            autoTransition(motionLayout, i2);
        }
    }

    public void readFallback(MotionLayout motionLayout) {
        for (int i = 0; i < this.mConstraintSetMap.size(); i++) {
            int iKeyAt = this.mConstraintSetMap.keyAt(i);
            if (hasCycleDependency(iKeyAt)) {
                Log.e(TAG, "Cannot be derived from yourself");
                return;
            }
            readConstraintChain(iKeyAt);
        }
        for (int i2 = 0; i2 < this.mConstraintSetMap.size(); i2++) {
            this.mConstraintSetMap.valueAt(i2).readFallback(motionLayout);
        }
    }

    public void removeTransition(MotionScene$Transition motionScene$Transition) {
        int index = getIndex(motionScene$Transition);
        if (index != -1) {
            this.mTransitionList.remove(index);
        }
    }

    public void setConstraintSet(int i, ConstraintSet constraintSet) {
        this.mConstraintSetMap.put(i, constraintSet);
    }

    public void setDuration(int i) {
        MotionScene$Transition motionScene$Transition = this.mCurrentTransition;
        if (motionScene$Transition != null) {
            motionScene$Transition.setDuration(i);
        } else {
            this.mDefaultDuration = i;
        }
    }

    public void setKeyframe(View view, int i, String str, Object obj) {
        MotionScene$Transition motionScene$Transition = this.mCurrentTransition;
        if (motionScene$Transition == null) {
            return;
        }
        Iterator it = MotionScene$Transition.access$1300(motionScene$Transition).iterator();
        while (it.hasNext()) {
            Iterator<Key> it2 = ((KeyFrames) it.next()).getKeyFramesForView(view.getId()).iterator();
            while (it2.hasNext()) {
                if (it2.next().mFramePosition == i) {
                    int i2 = ((obj != null ? ((Float) obj).floatValue() : 0.0f) > 0.0f ? 1 : ((obj != null ? ((Float) obj).floatValue() : 0.0f) == 0.0f ? 0 : -1));
                    str.equalsIgnoreCase("app:PerpendicularPath_percent");
                }
            }
        }
    }

    public void setRtl(boolean z2) {
        this.mRtl = z2;
        MotionScene$Transition motionScene$Transition = this.mCurrentTransition;
        if (motionScene$Transition == null || MotionScene$Transition.access$200(motionScene$Transition) == null) {
            return;
        }
        MotionScene$Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0024  */
    /* JADX WARN: Code duplicated, block: B:33:0x0066  */
    /* JADX WARN: Code duplicated, block: B:38:0x0081  */
    /* JADX WARN: Code duplicated, block: B:43:0x0058 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x0072 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x0060 A[SYNTHETIC] */
    public void setTransition(int i, int i2) {
        int iStateGetConstraintID;
        int iStateGetConstraintID2;
        Iterator<MotionScene$Transition> it;
        MotionScene$Transition motionScene$Transition;
        MotionScene$Transition motionScene$Transition2;
        MotionScene$Transition next;
        StateSet stateSet = this.mStateSet;
        if (stateSet != null) {
            iStateGetConstraintID = stateSet.stateGetConstraintID(i, -1, -1);
            if (iStateGetConstraintID == -1) {
                iStateGetConstraintID = i;
            }
            iStateGetConstraintID2 = this.mStateSet.stateGetConstraintID(i2, -1, -1);
            if (iStateGetConstraintID2 == -1) {
            }
            it = this.mTransitionList.iterator();
            while (true) {
                if (it.hasNext()) {
                    motionScene$Transition = this.mDefaultTransition;
                    for (MotionScene$Transition motionScene$Transition3 : this.mAbstractTransitionList) {
                        if (MotionScene$Transition.access$000(motionScene$Transition3) == i2) {
                            motionScene$Transition = motionScene$Transition3;
                        }
                    }
                    motionScene$Transition2 = new MotionScene$Transition(this, motionScene$Transition);
                    MotionScene$Transition.access$102(motionScene$Transition2, iStateGetConstraintID);
                    MotionScene$Transition.access$002(motionScene$Transition2, iStateGetConstraintID2);
                    if (iStateGetConstraintID != -1) {
                        this.mTransitionList.add(motionScene$Transition2);
                    }
                    this.mCurrentTransition = motionScene$Transition2;
                    return;
                }
                next = it.next();
                if ((MotionScene$Transition.access$000(next) != iStateGetConstraintID2 && MotionScene$Transition.access$100(next) == iStateGetConstraintID) || (MotionScene$Transition.access$000(next) == i2 && MotionScene$Transition.access$100(next) == i)) {
                    break;
                }
            }
            this.mCurrentTransition = next;
            if (next != null || MotionScene$Transition.access$200(next) == null) {
            }
            MotionScene$Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
            return;
        }
        iStateGetConstraintID = i;
        iStateGetConstraintID2 = i2;
        it = this.mTransitionList.iterator();
        while (true) {
            if (it.hasNext()) {
                motionScene$Transition = this.mDefaultTransition;
                while (r3.hasNext()) {
                    if (MotionScene$Transition.access$000(motionScene$Transition3) == i2) {
                        motionScene$Transition = motionScene$Transition3;
                    }
                }
                motionScene$Transition2 = new MotionScene$Transition(this, motionScene$Transition);
                MotionScene$Transition.access$102(motionScene$Transition2, iStateGetConstraintID);
                MotionScene$Transition.access$002(motionScene$Transition2, iStateGetConstraintID2);
                if (iStateGetConstraintID != -1) {
                    this.mTransitionList.add(motionScene$Transition2);
                }
                this.mCurrentTransition = motionScene$Transition2;
                return;
            }
            next = it.next();
            if (MotionScene$Transition.access$000(next) != iStateGetConstraintID2) {
            }
        }
        this.mCurrentTransition = next;
        if (next != null) {
        }
    }

    public void setupTouch() {
        MotionScene$Transition motionScene$Transition = this.mCurrentTransition;
        if (motionScene$Transition == null || MotionScene$Transition.access$200(motionScene$Transition) == null) {
            return;
        }
        MotionScene$Transition.access$200(this.mCurrentTransition).setupTouch();
    }

    public boolean supportTouch() {
        Iterator<MotionScene$Transition> it = this.mTransitionList.iterator();
        while (it.hasNext()) {
            if (MotionScene$Transition.access$200(it.next()) != null) {
                return true;
            }
        }
        MotionScene$Transition motionScene$Transition = this.mCurrentTransition;
        return (motionScene$Transition == null || MotionScene$Transition.access$200(motionScene$Transition) == null) ? false : true;
    }

    public boolean validateLayout(MotionLayout motionLayout) {
        return motionLayout == this.mMotionLayout && motionLayout.mScene == this;
    }

    public ConstraintSet getConstraintSet(int i) {
        return getConstraintSet(i, -1, -1);
    }

    public ConstraintSet getConstraintSet(int i, int i2, int i3) {
        int iStateGetConstraintID;
        if (this.DEBUG_DESKTOP) {
            System.out.println("id " + i);
            PrintStream printStream = System.out;
            StringBuilder sbU = a.U("size ");
            sbU.append(this.mConstraintSetMap.size());
            printStream.println(sbU.toString());
        }
        StateSet stateSet = this.mStateSet;
        if (stateSet != null && (iStateGetConstraintID = stateSet.stateGetConstraintID(i, i2, i3)) != -1) {
            i = iStateGetConstraintID;
        }
        if (this.mConstraintSetMap.get(i) == null) {
            StringBuilder sbU2 = a.U("Warning could not find ConstraintSet id/");
            sbU2.append(Debug.getName(this.mMotionLayout.getContext(), i));
            sbU2.append(" In MotionScene");
            Log.e(TAG, sbU2.toString());
            SparseArray<ConstraintSet> sparseArray = this.mConstraintSetMap;
            return sparseArray.get(sparseArray.keyAt(0));
        }
        return this.mConstraintSetMap.get(i);
    }

    public MotionScene(Context context, MotionLayout motionLayout, int i) {
        this.mMotionLayout = motionLayout;
        load(context, i);
        SparseArray<ConstraintSet> sparseArray = this.mConstraintSetMap;
        int i2 = R$id.motion_base;
        sparseArray.put(i2, new ConstraintSet());
        this.mConstraintSetIdMap.put("motion_base", Integer.valueOf(i2));
    }

    public void setTransition(MotionScene$Transition motionScene$Transition) {
        this.mCurrentTransition = motionScene$Transition;
        if (motionScene$Transition == null || MotionScene$Transition.access$200(motionScene$Transition) == null) {
            return;
        }
        MotionScene$Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
    }
}
