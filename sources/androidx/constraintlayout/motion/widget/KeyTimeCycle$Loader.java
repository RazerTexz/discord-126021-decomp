package androidx.constraintlayout.motion.widget;

import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.R$styleable;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class KeyTimeCycle$Loader {
    private static final int ANDROID_ALPHA = 1;
    private static final int ANDROID_ELEVATION = 2;
    private static final int ANDROID_ROTATION = 4;
    private static final int ANDROID_ROTATION_X = 5;
    private static final int ANDROID_ROTATION_Y = 6;
    private static final int ANDROID_SCALE_X = 7;
    private static final int ANDROID_SCALE_Y = 14;
    private static final int ANDROID_TRANSLATION_X = 15;
    private static final int ANDROID_TRANSLATION_Y = 16;
    private static final int ANDROID_TRANSLATION_Z = 17;
    private static final int CURVE_FIT = 13;
    private static final int FRAME_POSITION = 12;
    private static final int PROGRESS = 18;
    private static final int TARGET_ID = 10;
    private static final int TRANSITION_EASING = 9;
    private static final int TRANSITION_PATH_ROTATE = 8;
    private static final int WAVE_OFFSET = 21;
    private static final int WAVE_PERIOD = 20;
    private static final int WAVE_SHAPE = 19;
    private static SparseIntArray mAttrMap;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        mAttrMap = sparseIntArray;
        sparseIntArray.append(R$styleable.KeyTimeCycle_android_alpha, 1);
        mAttrMap.append(R$styleable.KeyTimeCycle_android_elevation, 2);
        mAttrMap.append(R$styleable.KeyTimeCycle_android_rotation, 4);
        mAttrMap.append(R$styleable.KeyTimeCycle_android_rotationX, 5);
        mAttrMap.append(R$styleable.KeyTimeCycle_android_rotationY, 6);
        mAttrMap.append(R$styleable.KeyTimeCycle_android_scaleX, 7);
        mAttrMap.append(R$styleable.KeyTimeCycle_transitionPathRotate, 8);
        mAttrMap.append(R$styleable.KeyTimeCycle_transitionEasing, 9);
        mAttrMap.append(R$styleable.KeyTimeCycle_motionTarget, 10);
        mAttrMap.append(R$styleable.KeyTimeCycle_framePosition, 12);
        mAttrMap.append(R$styleable.KeyTimeCycle_curveFit, 13);
        mAttrMap.append(R$styleable.KeyTimeCycle_android_scaleY, 14);
        mAttrMap.append(R$styleable.KeyTimeCycle_android_translationX, 15);
        mAttrMap.append(R$styleable.KeyTimeCycle_android_translationY, 16);
        mAttrMap.append(R$styleable.KeyTimeCycle_android_translationZ, 17);
        mAttrMap.append(R$styleable.KeyTimeCycle_motionProgress, 18);
        mAttrMap.append(R$styleable.KeyTimeCycle_wavePeriod, 20);
        mAttrMap.append(R$styleable.KeyTimeCycle_waveOffset, 21);
        mAttrMap.append(R$styleable.KeyTimeCycle_waveShape, 19);
    }

    private KeyTimeCycle$Loader() {
    }

    public static void read(KeyTimeCycle keyTimeCycle, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            switch (mAttrMap.get(index)) {
                case 1:
                    KeyTimeCycle.access$002(keyTimeCycle, typedArray.getFloat(index, KeyTimeCycle.access$000(keyTimeCycle)));
                    break;
                case 2:
                    KeyTimeCycle.access$102(keyTimeCycle, typedArray.getDimension(index, KeyTimeCycle.access$100(keyTimeCycle)));
                    break;
                case 3:
                case 11:
                default:
                    StringBuilder sbU = a.U("unused attribute 0x");
                    sbU.append(Integer.toHexString(index));
                    sbU.append("   ");
                    sbU.append(mAttrMap.get(index));
                    Log.e(KeyTimeCycle.NAME, sbU.toString());
                    break;
                case 4:
                    KeyTimeCycle.access$202(keyTimeCycle, typedArray.getFloat(index, KeyTimeCycle.access$200(keyTimeCycle)));
                    break;
                case 5:
                    KeyTimeCycle.access$802(keyTimeCycle, typedArray.getFloat(index, KeyTimeCycle.access$800(keyTimeCycle)));
                    break;
                case 6:
                    KeyTimeCycle.access$902(keyTimeCycle, typedArray.getFloat(index, KeyTimeCycle.access$900(keyTimeCycle)));
                    break;
                case 7:
                    KeyTimeCycle.access$702(keyTimeCycle, typedArray.getFloat(index, KeyTimeCycle.access$700(keyTimeCycle)));
                    break;
                case 8:
                    KeyTimeCycle.access$1202(keyTimeCycle, typedArray.getFloat(index, KeyTimeCycle.access$1200(keyTimeCycle)));
                    break;
                case 9:
                    KeyTimeCycle.access$1002(keyTimeCycle, typedArray.getString(index));
                    break;
                case 10:
                    if (MotionLayout.IS_IN_EDIT_MODE) {
                        int resourceId = typedArray.getResourceId(index, keyTimeCycle.mTargetId);
                        keyTimeCycle.mTargetId = resourceId;
                        if (resourceId == -1) {
                            keyTimeCycle.mTargetString = typedArray.getString(index);
                        }
                    } else if (typedArray.peekValue(index).type == 3) {
                        keyTimeCycle.mTargetString = typedArray.getString(index);
                    } else {
                        keyTimeCycle.mTargetId = typedArray.getResourceId(index, keyTimeCycle.mTargetId);
                    }
                    break;
                case 12:
                    keyTimeCycle.mFramePosition = typedArray.getInt(index, keyTimeCycle.mFramePosition);
                    break;
                case 13:
                    KeyTimeCycle.access$302(keyTimeCycle, typedArray.getInteger(index, KeyTimeCycle.access$300(keyTimeCycle)));
                    break;
                case 14:
                    KeyTimeCycle.access$1102(keyTimeCycle, typedArray.getFloat(index, KeyTimeCycle.access$1100(keyTimeCycle)));
                    break;
                case 15:
                    KeyTimeCycle.access$1302(keyTimeCycle, typedArray.getDimension(index, KeyTimeCycle.access$1300(keyTimeCycle)));
                    break;
                case 16:
                    KeyTimeCycle.access$1402(keyTimeCycle, typedArray.getDimension(index, KeyTimeCycle.access$1400(keyTimeCycle)));
                    break;
                case 17:
                    KeyTimeCycle.access$1502(keyTimeCycle, typedArray.getDimension(index, KeyTimeCycle.access$1500(keyTimeCycle)));
                    break;
                case 18:
                    KeyTimeCycle.access$1602(keyTimeCycle, typedArray.getFloat(index, KeyTimeCycle.access$1600(keyTimeCycle)));
                    break;
                case 19:
                    KeyTimeCycle.access$402(keyTimeCycle, typedArray.getInt(index, KeyTimeCycle.access$400(keyTimeCycle)));
                    break;
                case 20:
                    KeyTimeCycle.access$502(keyTimeCycle, typedArray.getFloat(index, KeyTimeCycle.access$500(keyTimeCycle)));
                    break;
                case 21:
                    if (typedArray.peekValue(index).type == 5) {
                        KeyTimeCycle.access$602(keyTimeCycle, typedArray.getDimension(index, KeyTimeCycle.access$600(keyTimeCycle)));
                    } else {
                        KeyTimeCycle.access$602(keyTimeCycle, typedArray.getFloat(index, KeyTimeCycle.access$600(keyTimeCycle)));
                    }
                    break;
            }
        }
    }
}
