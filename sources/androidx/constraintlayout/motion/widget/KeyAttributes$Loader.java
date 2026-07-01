package androidx.constraintlayout.motion.widget;

import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.R$styleable;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class KeyAttributes$Loader {
    private static final int ANDROID_ALPHA = 1;
    private static final int ANDROID_ELEVATION = 2;
    private static final int ANDROID_PIVOT_X = 19;
    private static final int ANDROID_PIVOT_Y = 20;
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
    private static SparseIntArray mAttrMap;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        mAttrMap = sparseIntArray;
        sparseIntArray.append(R$styleable.KeyAttribute_android_alpha, 1);
        mAttrMap.append(R$styleable.KeyAttribute_android_elevation, 2);
        mAttrMap.append(R$styleable.KeyAttribute_android_rotation, 4);
        mAttrMap.append(R$styleable.KeyAttribute_android_rotationX, 5);
        mAttrMap.append(R$styleable.KeyAttribute_android_rotationY, 6);
        mAttrMap.append(R$styleable.KeyAttribute_android_transformPivotX, 19);
        mAttrMap.append(R$styleable.KeyAttribute_android_transformPivotY, 20);
        mAttrMap.append(R$styleable.KeyAttribute_android_scaleX, 7);
        mAttrMap.append(R$styleable.KeyAttribute_transitionPathRotate, 8);
        mAttrMap.append(R$styleable.KeyAttribute_transitionEasing, 9);
        mAttrMap.append(R$styleable.KeyAttribute_motionTarget, 10);
        mAttrMap.append(R$styleable.KeyAttribute_framePosition, 12);
        mAttrMap.append(R$styleable.KeyAttribute_curveFit, 13);
        mAttrMap.append(R$styleable.KeyAttribute_android_scaleY, 14);
        mAttrMap.append(R$styleable.KeyAttribute_android_translationX, 15);
        mAttrMap.append(R$styleable.KeyAttribute_android_translationY, 16);
        mAttrMap.append(R$styleable.KeyAttribute_android_translationZ, 17);
        mAttrMap.append(R$styleable.KeyAttribute_motionProgress, 18);
    }

    private KeyAttributes$Loader() {
    }

    public static void read(KeyAttributes keyAttributes, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            switch (mAttrMap.get(index)) {
                case 1:
                    KeyAttributes.access$002(keyAttributes, typedArray.getFloat(index, KeyAttributes.access$000(keyAttributes)));
                    break;
                case 2:
                    KeyAttributes.access$102(keyAttributes, typedArray.getDimension(index, KeyAttributes.access$100(keyAttributes)));
                    break;
                case 3:
                case 11:
                default:
                    StringBuilder sbU = a.U("unused attribute 0x");
                    sbU.append(Integer.toHexString(index));
                    sbU.append("   ");
                    sbU.append(mAttrMap.get(index));
                    Log.e(KeyAttributes.NAME, sbU.toString());
                    break;
                case 4:
                    KeyAttributes.access$202(keyAttributes, typedArray.getFloat(index, KeyAttributes.access$200(keyAttributes)));
                    break;
                case 5:
                    KeyAttributes.access$502(keyAttributes, typedArray.getFloat(index, KeyAttributes.access$500(keyAttributes)));
                    break;
                case 6:
                    KeyAttributes.access$602(keyAttributes, typedArray.getFloat(index, KeyAttributes.access$600(keyAttributes)));
                    break;
                case 7:
                    KeyAttributes.access$402(keyAttributes, typedArray.getFloat(index, KeyAttributes.access$400(keyAttributes)));
                    break;
                case 8:
                    KeyAttributes.access$1102(keyAttributes, typedArray.getFloat(index, KeyAttributes.access$1100(keyAttributes)));
                    break;
                case 9:
                    KeyAttributes.access$902(keyAttributes, typedArray.getString(index));
                    break;
                case 10:
                    if (MotionLayout.IS_IN_EDIT_MODE) {
                        int resourceId = typedArray.getResourceId(index, keyAttributes.mTargetId);
                        keyAttributes.mTargetId = resourceId;
                        if (resourceId == -1) {
                            keyAttributes.mTargetString = typedArray.getString(index);
                        }
                    } else if (typedArray.peekValue(index).type == 3) {
                        keyAttributes.mTargetString = typedArray.getString(index);
                    } else {
                        keyAttributes.mTargetId = typedArray.getResourceId(index, keyAttributes.mTargetId);
                    }
                    break;
                case 12:
                    keyAttributes.mFramePosition = typedArray.getInt(index, keyAttributes.mFramePosition);
                    break;
                case 13:
                    KeyAttributes.access$302(keyAttributes, typedArray.getInteger(index, KeyAttributes.access$300(keyAttributes)));
                    break;
                case 14:
                    KeyAttributes.access$1002(keyAttributes, typedArray.getFloat(index, KeyAttributes.access$1000(keyAttributes)));
                    break;
                case 15:
                    KeyAttributes.access$1202(keyAttributes, typedArray.getDimension(index, KeyAttributes.access$1200(keyAttributes)));
                    break;
                case 16:
                    KeyAttributes.access$1302(keyAttributes, typedArray.getDimension(index, KeyAttributes.access$1300(keyAttributes)));
                    break;
                case 17:
                    KeyAttributes.access$1402(keyAttributes, typedArray.getDimension(index, KeyAttributes.access$1400(keyAttributes)));
                    break;
                case 18:
                    KeyAttributes.access$1502(keyAttributes, typedArray.getFloat(index, KeyAttributes.access$1500(keyAttributes)));
                    break;
                case 19:
                    KeyAttributes.access$702(keyAttributes, typedArray.getDimension(index, KeyAttributes.access$700(keyAttributes)));
                    break;
                case 20:
                    KeyAttributes.access$802(keyAttributes, typedArray.getDimension(index, KeyAttributes.access$800(keyAttributes)));
                    break;
            }
        }
    }
}
