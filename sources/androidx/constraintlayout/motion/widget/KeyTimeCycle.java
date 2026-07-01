package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R$styleable;
import b.d.b.a.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class KeyTimeCycle extends Key {
    public static final int KEY_TYPE = 3;
    public static final String NAME = "KeyTimeCycle";
    private static final String TAG = "KeyTimeCycle";
    private String mTransitionEasing;
    private int mCurveFit = -1;
    private float mAlpha = Float.NaN;
    private float mElevation = Float.NaN;
    private float mRotation = Float.NaN;
    private float mRotationX = Float.NaN;
    private float mRotationY = Float.NaN;
    private float mTransitionPathRotate = Float.NaN;
    private float mScaleX = Float.NaN;
    private float mScaleY = Float.NaN;
    private float mTranslationX = Float.NaN;
    private float mTranslationY = Float.NaN;
    private float mTranslationZ = Float.NaN;
    private float mProgress = Float.NaN;
    private int mWaveShape = 0;
    private float mWavePeriod = Float.NaN;
    private float mWaveOffset = 0.0f;

    public KeyTimeCycle() {
        this.mType = 3;
        this.mCustomConstraints = new HashMap<>();
    }

    public static /* synthetic */ float access$000(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mAlpha;
    }

    public static /* synthetic */ float access$002(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mAlpha = f;
        return f;
    }

    public static /* synthetic */ float access$100(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mElevation;
    }

    public static /* synthetic */ String access$1002(KeyTimeCycle keyTimeCycle, String str) {
        keyTimeCycle.mTransitionEasing = str;
        return str;
    }

    public static /* synthetic */ float access$102(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mElevation = f;
        return f;
    }

    public static /* synthetic */ float access$1100(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mScaleY;
    }

    public static /* synthetic */ float access$1102(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mScaleY = f;
        return f;
    }

    public static /* synthetic */ float access$1200(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mTransitionPathRotate;
    }

    public static /* synthetic */ float access$1202(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mTransitionPathRotate = f;
        return f;
    }

    public static /* synthetic */ float access$1300(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mTranslationX;
    }

    public static /* synthetic */ float access$1302(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mTranslationX = f;
        return f;
    }

    public static /* synthetic */ float access$1400(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mTranslationY;
    }

    public static /* synthetic */ float access$1402(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mTranslationY = f;
        return f;
    }

    public static /* synthetic */ float access$1500(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mTranslationZ;
    }

    public static /* synthetic */ float access$1502(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mTranslationZ = f;
        return f;
    }

    public static /* synthetic */ float access$1600(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mProgress;
    }

    public static /* synthetic */ float access$1602(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mProgress = f;
        return f;
    }

    public static /* synthetic */ float access$200(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mRotation;
    }

    public static /* synthetic */ float access$202(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mRotation = f;
        return f;
    }

    public static /* synthetic */ int access$300(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mCurveFit;
    }

    public static /* synthetic */ int access$302(KeyTimeCycle keyTimeCycle, int i) {
        keyTimeCycle.mCurveFit = i;
        return i;
    }

    public static /* synthetic */ int access$400(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mWaveShape;
    }

    public static /* synthetic */ int access$402(KeyTimeCycle keyTimeCycle, int i) {
        keyTimeCycle.mWaveShape = i;
        return i;
    }

    public static /* synthetic */ float access$500(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mWavePeriod;
    }

    public static /* synthetic */ float access$502(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mWavePeriod = f;
        return f;
    }

    public static /* synthetic */ float access$600(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mWaveOffset;
    }

    public static /* synthetic */ float access$602(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mWaveOffset = f;
        return f;
    }

    public static /* synthetic */ float access$700(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mScaleX;
    }

    public static /* synthetic */ float access$702(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mScaleX = f;
        return f;
    }

    public static /* synthetic */ float access$800(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mRotationX;
    }

    public static /* synthetic */ float access$802(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mRotationX = f;
        return f;
    }

    public static /* synthetic */ float access$900(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mRotationY;
    }

    public static /* synthetic */ float access$902(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mRotationY = f;
        return f;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:12:0x004a  */
    public void addTimeValues(HashMap<String, TimeCycleSplineSet> map) {
        for (String str : map.keySet()) {
            TimeCycleSplineSet timeCycleSplineSet = map.get(str);
            if (!str.startsWith(Key.CUSTOM)) {
                switch (str) {
                    case "rotationX":
                        if (Float.isNaN(this.mRotationX)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mRotationX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                        break;
                    case "rotationY":
                        if (Float.isNaN(this.mRotationY)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mRotationY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                        break;
                    case "translationX":
                        if (Float.isNaN(this.mTranslationX)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mTranslationX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                        break;
                    case "translationY":
                        if (Float.isNaN(this.mTranslationY)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mTranslationY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                        break;
                    case "translationZ":
                        if (Float.isNaN(this.mTranslationZ)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mTranslationZ, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                        break;
                    case "progress":
                        if (Float.isNaN(this.mProgress)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mProgress, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                        break;
                    case "scaleX":
                        if (Float.isNaN(this.mScaleX)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mScaleX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                        break;
                    case "scaleY":
                        if (Float.isNaN(this.mScaleY)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mScaleY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                        break;
                    case "rotation":
                        if (Float.isNaN(this.mRotation)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mRotation, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                        break;
                    case "elevation":
                        if (Float.isNaN(this.mElevation)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mElevation, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                        break;
                    case "transitionPathRotate":
                        if (Float.isNaN(this.mTransitionPathRotate)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mTransitionPathRotate, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                        break;
                    case "alpha":
                        if (Float.isNaN(this.mAlpha)) {
                            break;
                        } else {
                            timeCycleSplineSet.setPoint(this.mFramePosition, this.mAlpha, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                            break;
                        }
                        break;
                    default:
                        Log.e("KeyTimeCycles", "UNKNOWN addValues \"" + str + "\"");
                        break;
                }
            } else {
                ConstraintAttribute constraintAttribute = this.mCustomConstraints.get(str.substring(7));
                if (constraintAttribute != null) {
                    ((TimeCycleSplineSet$CustomSet) timeCycleSplineSet).setPoint(this.mFramePosition, constraintAttribute, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, SplineSet> map) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> hashSet) {
        if (!Float.isNaN(this.mAlpha)) {
            hashSet.add(Key.ALPHA);
        }
        if (!Float.isNaN(this.mElevation)) {
            hashSet.add(Key.ELEVATION);
        }
        if (!Float.isNaN(this.mRotation)) {
            hashSet.add(Key.ROTATION);
        }
        if (!Float.isNaN(this.mRotationX)) {
            hashSet.add(Key.ROTATION_X);
        }
        if (!Float.isNaN(this.mRotationY)) {
            hashSet.add(Key.ROTATION_Y);
        }
        if (!Float.isNaN(this.mTranslationX)) {
            hashSet.add(Key.TRANSLATION_X);
        }
        if (!Float.isNaN(this.mTranslationY)) {
            hashSet.add(Key.TRANSLATION_Y);
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            hashSet.add(Key.TRANSLATION_Z);
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            hashSet.add(Key.TRANSITION_PATH_ROTATE);
        }
        if (!Float.isNaN(this.mScaleX)) {
            hashSet.add(Key.SCALE_X);
        }
        if (!Float.isNaN(this.mScaleY)) {
            hashSet.add(Key.SCALE_Y);
        }
        if (!Float.isNaN(this.mProgress)) {
            hashSet.add("progress");
        }
        if (this.mCustomConstraints.size() > 0) {
            Iterator<String> it = this.mCustomConstraints.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        KeyTimeCycle$Loader.read(this, context.obtainStyledAttributes(attributeSet, R$styleable.KeyTimeCycle));
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setInterpolation(HashMap<String, Integer> map) {
        if (this.mCurveFit == -1) {
            return;
        }
        if (!Float.isNaN(this.mAlpha)) {
            map.put(Key.ALPHA, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mElevation)) {
            map.put(Key.ELEVATION, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotation)) {
            map.put(Key.ROTATION, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotationX)) {
            map.put(Key.ROTATION_X, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mRotationY)) {
            map.put(Key.ROTATION_Y, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationX)) {
            map.put(Key.TRANSLATION_X, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationY)) {
            map.put(Key.TRANSLATION_Y, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            map.put(Key.TRANSLATION_Z, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            map.put(Key.TRANSITION_PATH_ROTATE, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mScaleX)) {
            map.put(Key.SCALE_X, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mScaleX)) {
            map.put(Key.SCALE_Y, Integer.valueOf(this.mCurveFit));
        }
        if (!Float.isNaN(this.mProgress)) {
            map.put("progress", Integer.valueOf(this.mCurveFit));
        }
        if (this.mCustomConstraints.size() > 0) {
            Iterator<String> it = this.mCustomConstraints.keySet().iterator();
            while (it.hasNext()) {
                map.put(a.w("CUSTOM,", it.next()), Integer.valueOf(this.mCurveFit));
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String str, Object obj) {
        str.hashCode();
        switch (str) {
            case "transitionEasing":
                this.mTransitionEasing = obj.toString();
                break;
            case "rotationX":
                this.mRotationX = toFloat(obj);
                break;
            case "rotationY":
                this.mRotationY = toFloat(obj);
                break;
            case "translationX":
                this.mTranslationX = toFloat(obj);
                break;
            case "translationY":
                this.mTranslationY = toFloat(obj);
                break;
            case "progress":
                this.mProgress = toFloat(obj);
                break;
            case "scaleX":
                this.mScaleX = toFloat(obj);
                break;
            case "scaleY":
                this.mScaleY = toFloat(obj);
                break;
            case "rotation":
                this.mRotation = toFloat(obj);
                break;
            case "elevation":
                this.mElevation = toFloat(obj);
                break;
            case "transitionPathRotate":
                this.mTransitionPathRotate = toFloat(obj);
                break;
            case "alpha":
                this.mAlpha = toFloat(obj);
                break;
            case "curveFit":
                this.mCurveFit = toInt(obj);
                break;
            case "mTranslationZ":
                this.mTranslationZ = toFloat(obj);
                break;
        }
    }
}
