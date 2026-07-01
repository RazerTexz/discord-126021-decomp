package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.R$styleable;
import b.d.b.a.a;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public class KeyTrigger extends Key {
    public static final int KEY_TYPE = 5;
    public static final String NAME = "KeyTrigger";
    private static final String TAG = "KeyTrigger";
    public RectF mCollisionRect;
    private Method mFireCross;
    private boolean mFireCrossReset;
    private float mFireLastPos;
    private Method mFireNegativeCross;
    private boolean mFireNegativeReset;
    private Method mFirePositiveCross;
    private boolean mFirePositiveReset;
    private float mFireThreshold;
    private String mNegativeCross;
    private String mPositiveCross;
    private boolean mPostLayout;
    public RectF mTargetRect;
    private int mTriggerCollisionId;
    private View mTriggerCollisionView;
    private int mTriggerID;
    private int mTriggerReceiver;
    public float mTriggerSlack;
    private int mCurveFit = -1;
    private String mCross = null;

    public KeyTrigger() {
        int i = Key.UNSET;
        this.mTriggerReceiver = i;
        this.mNegativeCross = null;
        this.mPositiveCross = null;
        this.mTriggerID = i;
        this.mTriggerCollisionId = i;
        this.mTriggerCollisionView = null;
        this.mTriggerSlack = 0.1f;
        this.mFireCrossReset = true;
        this.mFireNegativeReset = true;
        this.mFirePositiveReset = true;
        this.mFireThreshold = Float.NaN;
        this.mPostLayout = false;
        this.mCollisionRect = new RectF();
        this.mTargetRect = new RectF();
        this.mType = 5;
        this.mCustomConstraints = new HashMap<>();
    }

    public static /* synthetic */ float access$002(KeyTrigger keyTrigger, float f) {
        keyTrigger.mFireThreshold = f;
        return f;
    }

    public static /* synthetic */ String access$102(KeyTrigger keyTrigger, String str) {
        keyTrigger.mNegativeCross = str;
        return str;
    }

    public static /* synthetic */ String access$202(KeyTrigger keyTrigger, String str) {
        keyTrigger.mPositiveCross = str;
        return str;
    }

    public static /* synthetic */ String access$302(KeyTrigger keyTrigger, String str) {
        keyTrigger.mCross = str;
        return str;
    }

    public static /* synthetic */ int access$400(KeyTrigger keyTrigger) {
        return keyTrigger.mTriggerID;
    }

    public static /* synthetic */ int access$402(KeyTrigger keyTrigger, int i) {
        keyTrigger.mTriggerID = i;
        return i;
    }

    public static /* synthetic */ int access$500(KeyTrigger keyTrigger) {
        return keyTrigger.mTriggerCollisionId;
    }

    public static /* synthetic */ int access$502(KeyTrigger keyTrigger, int i) {
        keyTrigger.mTriggerCollisionId = i;
        return i;
    }

    public static /* synthetic */ boolean access$600(KeyTrigger keyTrigger) {
        return keyTrigger.mPostLayout;
    }

    public static /* synthetic */ boolean access$602(KeyTrigger keyTrigger, boolean z2) {
        keyTrigger.mPostLayout = z2;
        return z2;
    }

    public static /* synthetic */ int access$700(KeyTrigger keyTrigger) {
        return keyTrigger.mTriggerReceiver;
    }

    public static /* synthetic */ int access$702(KeyTrigger keyTrigger, int i) {
        keyTrigger.mTriggerReceiver = i;
        return i;
    }

    private void setUpRect(RectF rectF, View view, boolean z2) {
        rectF.top = view.getTop();
        rectF.bottom = view.getBottom();
        rectF.left = view.getLeft();
        rectF.right = view.getRight();
        if (z2) {
            view.getMatrix().mapRect(rectF);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, SplineSet> map) {
    }

    /* JADX WARN: Code duplicated, block: B:38:0x008d  */
    /* JADX WARN: Code duplicated, block: B:43:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:45:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:49:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:51:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:54:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:56:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:58:0x00dd  */
    public void conditionallyFire(float f, View view) {
        boolean z2;
        boolean z3;
        boolean z4;
        float f2;
        float f3;
        boolean z5;
        float f4;
        float f5;
        boolean z6;
        boolean z7 = true;
        if (this.mTriggerCollisionId != Key.UNSET) {
            if (this.mTriggerCollisionView == null) {
                this.mTriggerCollisionView = ((ViewGroup) view.getParent()).findViewById(this.mTriggerCollisionId);
            }
            setUpRect(this.mCollisionRect, this.mTriggerCollisionView, this.mPostLayout);
            setUpRect(this.mTargetRect, view, this.mPostLayout);
            if (this.mCollisionRect.intersect(this.mTargetRect)) {
                if (this.mFireCrossReset) {
                    this.mFireCrossReset = false;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (this.mFirePositiveReset) {
                    this.mFirePositiveReset = false;
                    z5 = true;
                } else {
                    z5 = false;
                }
                this.mFireNegativeReset = true;
                z4 = false;
            } else {
                if (this.mFireCrossReset) {
                    z2 = false;
                } else {
                    this.mFireCrossReset = true;
                    z2 = true;
                }
                if (this.mFireNegativeReset) {
                    this.mFireNegativeReset = false;
                    z6 = true;
                } else {
                    z6 = false;
                }
                this.mFirePositiveReset = true;
                z4 = z6;
                z5 = false;
            }
        } else {
            if (this.mFireCrossReset) {
                float f6 = this.mFireThreshold;
                if ((this.mFireLastPos - f6) * (f - f6) < 0.0f) {
                    this.mFireCrossReset = false;
                    z2 = true;
                }
                if (this.mFireNegativeReset) {
                    f4 = this.mFireThreshold;
                    f5 = f - f4;
                    if ((this.mFireLastPos - f4) * f5 >= 0.0f && f5 < 0.0f) {
                        this.mFireNegativeReset = false;
                        z3 = true;
                    }
                    if (this.mFirePositiveReset) {
                        f2 = this.mFireThreshold;
                        f3 = f - f2;
                        if ((this.mFireLastPos - f2) * f3 < 0.0f || f3 <= 0.0f) {
                            z7 = false;
                        } else {
                            this.mFirePositiveReset = false;
                        }
                        z5 = z7;
                        z4 = z3;
                    } else {
                        if (Math.abs(f - this.mFireThreshold) > this.mTriggerSlack) {
                            this.mFirePositiveReset = true;
                        }
                        z4 = z3;
                        z5 = false;
                    }
                } else if (Math.abs(f - this.mFireThreshold) > this.mTriggerSlack) {
                    this.mFireNegativeReset = true;
                }
                z3 = false;
                if (this.mFirePositiveReset) {
                    f2 = this.mFireThreshold;
                    f3 = f - f2;
                    if ((this.mFireLastPos - f2) * f3 < 0.0f) {
                        z7 = false;
                    } else {
                        z7 = false;
                    }
                    z5 = z7;
                    z4 = z3;
                } else {
                    if (Math.abs(f - this.mFireThreshold) > this.mTriggerSlack) {
                        this.mFirePositiveReset = true;
                    }
                    z4 = z3;
                    z5 = false;
                }
            } else if (Math.abs(f - this.mFireThreshold) > this.mTriggerSlack) {
                this.mFireCrossReset = true;
            }
            z2 = false;
            if (this.mFireNegativeReset) {
                f4 = this.mFireThreshold;
                f5 = f - f4;
                if ((this.mFireLastPos - f4) * f5 >= 0.0f) {
                }
                if (this.mFirePositiveReset) {
                    f2 = this.mFireThreshold;
                    f3 = f - f2;
                    if ((this.mFireLastPos - f2) * f3 < 0.0f) {
                        z7 = false;
                    } else {
                        z7 = false;
                    }
                    z5 = z7;
                    z4 = z3;
                } else {
                    if (Math.abs(f - this.mFireThreshold) > this.mTriggerSlack) {
                        this.mFirePositiveReset = true;
                    }
                    z4 = z3;
                    z5 = false;
                }
            } else if (Math.abs(f - this.mFireThreshold) > this.mTriggerSlack) {
                this.mFireNegativeReset = true;
            }
            z3 = false;
            if (this.mFirePositiveReset) {
                f2 = this.mFireThreshold;
                f3 = f - f2;
                if ((this.mFireLastPos - f2) * f3 < 0.0f) {
                    z7 = false;
                } else {
                    z7 = false;
                }
                z5 = z7;
                z4 = z3;
            } else {
                if (Math.abs(f - this.mFireThreshold) > this.mTriggerSlack) {
                    this.mFirePositiveReset = true;
                }
                z4 = z3;
                z5 = false;
            }
        }
        this.mFireLastPos = f;
        if (z4 || z2 || z5) {
            ((MotionLayout) view.getParent()).fireTrigger(this.mTriggerID, z5, f);
        }
        if (this.mTriggerReceiver != Key.UNSET) {
            view = ((MotionLayout) view.getParent()).findViewById(this.mTriggerReceiver);
        }
        if (z4 && this.mNegativeCross != null) {
            if (this.mFireNegativeCross == null) {
                try {
                    this.mFireNegativeCross = view.getClass().getMethod(this.mNegativeCross, new Class[0]);
                } catch (NoSuchMethodException unused) {
                    StringBuilder sbU = a.U("Could not find method \"");
                    sbU.append(this.mNegativeCross);
                    sbU.append("\"on class ");
                    sbU.append(view.getClass().getSimpleName());
                    sbU.append(" ");
                    sbU.append(Debug.getName(view));
                    Log.e("KeyTrigger", sbU.toString());
                }
            }
            try {
                this.mFireNegativeCross.invoke(view, new Object[0]);
            } catch (Exception unused2) {
                StringBuilder sbU2 = a.U("Exception in call \"");
                sbU2.append(this.mNegativeCross);
                sbU2.append("\"on class ");
                sbU2.append(view.getClass().getSimpleName());
                sbU2.append(" ");
                sbU2.append(Debug.getName(view));
                Log.e("KeyTrigger", sbU2.toString());
            }
        }
        if (z5 && this.mPositiveCross != null) {
            if (this.mFirePositiveCross == null) {
                try {
                    this.mFirePositiveCross = view.getClass().getMethod(this.mPositiveCross, new Class[0]);
                } catch (NoSuchMethodException unused3) {
                    StringBuilder sbU3 = a.U("Could not find method \"");
                    sbU3.append(this.mPositiveCross);
                    sbU3.append("\"on class ");
                    sbU3.append(view.getClass().getSimpleName());
                    sbU3.append(" ");
                    sbU3.append(Debug.getName(view));
                    Log.e("KeyTrigger", sbU3.toString());
                }
            }
            try {
                this.mFirePositiveCross.invoke(view, new Object[0]);
            } catch (Exception unused4) {
                StringBuilder sbU4 = a.U("Exception in call \"");
                sbU4.append(this.mPositiveCross);
                sbU4.append("\"on class ");
                sbU4.append(view.getClass().getSimpleName());
                sbU4.append(" ");
                sbU4.append(Debug.getName(view));
                Log.e("KeyTrigger", sbU4.toString());
            }
        }
        if (!z2 || this.mCross == null) {
            return;
        }
        if (this.mFireCross == null) {
            try {
                this.mFireCross = view.getClass().getMethod(this.mCross, new Class[0]);
            } catch (NoSuchMethodException unused5) {
                StringBuilder sbU5 = a.U("Could not find method \"");
                sbU5.append(this.mCross);
                sbU5.append("\"on class ");
                sbU5.append(view.getClass().getSimpleName());
                sbU5.append(" ");
                sbU5.append(Debug.getName(view));
                Log.e("KeyTrigger", sbU5.toString());
            }
        }
        try {
            this.mFireCross.invoke(view, new Object[0]);
        } catch (Exception unused6) {
            StringBuilder sbU6 = a.U("Exception in call \"");
            sbU6.append(this.mCross);
            sbU6.append("\"on class ");
            sbU6.append(view.getClass().getSimpleName());
            sbU6.append(" ");
            sbU6.append(Debug.getName(view));
            Log.e("KeyTrigger", sbU6.toString());
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> hashSet) {
    }

    public int getCurveFit() {
        return this.mCurveFit;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        KeyTrigger$Loader.read(this, context.obtainStyledAttributes(attributeSet, R$styleable.KeyTrigger), context);
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String str, Object obj) {
    }
}
