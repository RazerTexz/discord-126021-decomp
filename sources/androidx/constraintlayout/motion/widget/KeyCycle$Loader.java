package androidx.constraintlayout.motion.widget;

import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.R$styleable;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class KeyCycle$Loader {
    private static final int ANDROID_ALPHA = 9;
    private static final int ANDROID_ELEVATION = 10;
    private static final int ANDROID_ROTATION = 11;
    private static final int ANDROID_ROTATION_X = 12;
    private static final int ANDROID_ROTATION_Y = 13;
    private static final int ANDROID_SCALE_X = 15;
    private static final int ANDROID_SCALE_Y = 16;
    private static final int ANDROID_TRANSLATION_X = 17;
    private static final int ANDROID_TRANSLATION_Y = 18;
    private static final int ANDROID_TRANSLATION_Z = 19;
    private static final int CURVE_FIT = 4;
    private static final int FRAME_POSITION = 2;
    private static final int PROGRESS = 20;
    private static final int TARGET_ID = 1;
    private static final int TRANSITION_EASING = 3;
    private static final int TRANSITION_PATH_ROTATE = 14;
    private static final int WAVE_OFFSET = 7;
    private static final int WAVE_PERIOD = 6;
    private static final int WAVE_SHAPE = 5;
    private static final int WAVE_VARIES_BY = 8;
    private static SparseIntArray mAttrMap;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        mAttrMap = sparseIntArray;
        sparseIntArray.append(R$styleable.KeyCycle_motionTarget, 1);
        mAttrMap.append(R$styleable.KeyCycle_framePosition, 2);
        mAttrMap.append(R$styleable.KeyCycle_transitionEasing, 3);
        mAttrMap.append(R$styleable.KeyCycle_curveFit, 4);
        mAttrMap.append(R$styleable.KeyCycle_waveShape, 5);
        mAttrMap.append(R$styleable.KeyCycle_wavePeriod, 6);
        mAttrMap.append(R$styleable.KeyCycle_waveOffset, 7);
        mAttrMap.append(R$styleable.KeyCycle_waveVariesBy, 8);
        mAttrMap.append(R$styleable.KeyCycle_android_alpha, 9);
        mAttrMap.append(R$styleable.KeyCycle_android_elevation, 10);
        mAttrMap.append(R$styleable.KeyCycle_android_rotation, 11);
        mAttrMap.append(R$styleable.KeyCycle_android_rotationX, 12);
        mAttrMap.append(R$styleable.KeyCycle_android_rotationY, 13);
        mAttrMap.append(R$styleable.KeyCycle_transitionPathRotate, 14);
        mAttrMap.append(R$styleable.KeyCycle_android_scaleX, 15);
        mAttrMap.append(R$styleable.KeyCycle_android_scaleY, 16);
        mAttrMap.append(R$styleable.KeyCycle_android_translationX, 17);
        mAttrMap.append(R$styleable.KeyCycle_android_translationY, 18);
        mAttrMap.append(R$styleable.KeyCycle_android_translationZ, 19);
        mAttrMap.append(R$styleable.KeyCycle_motionProgress, 20);
    }

    private KeyCycle$Loader() {
    }

    public static /* synthetic */ void access$000(KeyCycle keyCycle, TypedArray typedArray) {
        read(keyCycle, typedArray);
    }

    private static void read(KeyCycle keyCycle, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            switch (mAttrMap.get(index)) {
                case 1:
                    if (MotionLayout.IS_IN_EDIT_MODE) {
                        int resourceId = typedArray.getResourceId(index, keyCycle.mTargetId);
                        keyCycle.mTargetId = resourceId;
                        if (resourceId == -1) {
                            keyCycle.mTargetString = typedArray.getString(index);
                        }
                    } else if (typedArray.peekValue(index).type == 3) {
                        keyCycle.mTargetString = typedArray.getString(index);
                    } else {
                        keyCycle.mTargetId = typedArray.getResourceId(index, keyCycle.mTargetId);
                    }
                    break;
                case 2:
                    keyCycle.mFramePosition = typedArray.getInt(index, keyCycle.mFramePosition);
                    break;
                case 3:
                    KeyCycle.access$102(keyCycle, typedArray.getString(index));
                    break;
                case 4:
                    KeyCycle.access$202(keyCycle, typedArray.getInteger(index, KeyCycle.access$200(keyCycle)));
                    break;
                case 5:
                    KeyCycle.access$302(keyCycle, typedArray.getInt(index, KeyCycle.access$300(keyCycle)));
                    break;
                case 6:
                    KeyCycle.access$402(keyCycle, typedArray.getFloat(index, KeyCycle.access$400(keyCycle)));
                    break;
                case 7:
                    if (typedArray.peekValue(index).type == 5) {
                        KeyCycle.access$502(keyCycle, typedArray.getDimension(index, KeyCycle.access$500(keyCycle)));
                    } else {
                        KeyCycle.access$502(keyCycle, typedArray.getFloat(index, KeyCycle.access$500(keyCycle)));
                    }
                    break;
                case 8:
                    KeyCycle.access$602(keyCycle, typedArray.getInt(index, KeyCycle.access$600(keyCycle)));
                    break;
                case 9:
                    KeyCycle.access$702(keyCycle, typedArray.getFloat(index, KeyCycle.access$700(keyCycle)));
                    break;
                case 10:
                    KeyCycle.access$802(keyCycle, typedArray.getDimension(index, KeyCycle.access$800(keyCycle)));
                    break;
                case 11:
                    KeyCycle.access$902(keyCycle, typedArray.getFloat(index, KeyCycle.access$900(keyCycle)));
                    break;
                case 12:
                    KeyCycle.access$1002(keyCycle, typedArray.getFloat(index, KeyCycle.access$1000(keyCycle)));
                    break;
                case 13:
                    KeyCycle.access$1102(keyCycle, typedArray.getFloat(index, KeyCycle.access$1100(keyCycle)));
                    break;
                case 14:
                    KeyCycle.access$1202(keyCycle, typedArray.getFloat(index, KeyCycle.access$1200(keyCycle)));
                    break;
                case 15:
                    KeyCycle.access$1302(keyCycle, typedArray.getFloat(index, KeyCycle.access$1300(keyCycle)));
                    break;
                case 16:
                    KeyCycle.access$1402(keyCycle, typedArray.getFloat(index, KeyCycle.access$1400(keyCycle)));
                    break;
                case 17:
                    KeyCycle.access$1502(keyCycle, typedArray.getDimension(index, KeyCycle.access$1500(keyCycle)));
                    break;
                case 18:
                    KeyCycle.access$1602(keyCycle, typedArray.getDimension(index, KeyCycle.access$1600(keyCycle)));
                    break;
                case 19:
                    KeyCycle.access$1702(keyCycle, typedArray.getDimension(index, KeyCycle.access$1700(keyCycle)));
                    break;
                case 20:
                    KeyCycle.access$1802(keyCycle, typedArray.getFloat(index, KeyCycle.access$1800(keyCycle)));
                    break;
                default:
                    StringBuilder sbU = a.U("unused attribute 0x");
                    sbU.append(Integer.toHexString(index));
                    sbU.append("   ");
                    sbU.append(mAttrMap.get(index));
                    Log.e(KeyCycle.NAME, sbU.toString());
                    break;
            }
        }
    }
}
