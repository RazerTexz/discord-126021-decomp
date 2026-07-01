package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.R$styleable;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class KeyTrigger$Loader {
    private static final int COLLISION = 9;
    private static final int CROSS = 4;
    private static final int FRAME_POS = 8;
    private static final int NEGATIVE_CROSS = 1;
    private static final int POSITIVE_CROSS = 2;
    private static final int POST_LAYOUT = 10;
    private static final int TARGET_ID = 7;
    private static final int TRIGGER_ID = 6;
    private static final int TRIGGER_RECEIVER = 11;
    private static final int TRIGGER_SLACK = 5;
    private static SparseIntArray mAttrMap;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        mAttrMap = sparseIntArray;
        sparseIntArray.append(R$styleable.KeyTrigger_framePosition, 8);
        mAttrMap.append(R$styleable.KeyTrigger_onCross, 4);
        mAttrMap.append(R$styleable.KeyTrigger_onNegativeCross, 1);
        mAttrMap.append(R$styleable.KeyTrigger_onPositiveCross, 2);
        mAttrMap.append(R$styleable.KeyTrigger_motionTarget, 7);
        mAttrMap.append(R$styleable.KeyTrigger_triggerId, 6);
        mAttrMap.append(R$styleable.KeyTrigger_triggerSlack, 5);
        mAttrMap.append(R$styleable.KeyTrigger_motion_triggerOnCollision, 9);
        mAttrMap.append(R$styleable.KeyTrigger_motion_postLayoutCollision, 10);
        mAttrMap.append(R$styleable.KeyTrigger_triggerReceiver, 11);
    }

    private KeyTrigger$Loader() {
    }

    public static void read(KeyTrigger keyTrigger, TypedArray typedArray, Context context) {
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            switch (mAttrMap.get(index)) {
                case 1:
                    KeyTrigger.access$102(keyTrigger, typedArray.getString(index));
                    continue;
                    break;
                case 2:
                    KeyTrigger.access$202(keyTrigger, typedArray.getString(index));
                    continue;
                    break;
                case 4:
                    KeyTrigger.access$302(keyTrigger, typedArray.getString(index));
                    continue;
                    break;
                case 5:
                    keyTrigger.mTriggerSlack = typedArray.getFloat(index, keyTrigger.mTriggerSlack);
                    continue;
                    break;
                case 6:
                    KeyTrigger.access$402(keyTrigger, typedArray.getResourceId(index, KeyTrigger.access$400(keyTrigger)));
                    continue;
                    break;
                case 7:
                    if (MotionLayout.IS_IN_EDIT_MODE) {
                        int resourceId = typedArray.getResourceId(index, keyTrigger.mTargetId);
                        keyTrigger.mTargetId = resourceId;
                        if (resourceId == -1) {
                            keyTrigger.mTargetString = typedArray.getString(index);
                        } else {
                            continue;
                        }
                    } else if (typedArray.peekValue(index).type == 3) {
                        keyTrigger.mTargetString = typedArray.getString(index);
                    } else {
                        keyTrigger.mTargetId = typedArray.getResourceId(index, keyTrigger.mTargetId);
                    }
                    break;
                case 8:
                    int integer = typedArray.getInteger(index, keyTrigger.mFramePosition);
                    keyTrigger.mFramePosition = integer;
                    KeyTrigger.access$002(keyTrigger, (integer + 0.5f) / 100.0f);
                    continue;
                    break;
                case 9:
                    KeyTrigger.access$502(keyTrigger, typedArray.getResourceId(index, KeyTrigger.access$500(keyTrigger)));
                    continue;
                    break;
                case 10:
                    KeyTrigger.access$602(keyTrigger, typedArray.getBoolean(index, KeyTrigger.access$600(keyTrigger)));
                    continue;
                    break;
                case 11:
                    KeyTrigger.access$702(keyTrigger, typedArray.getResourceId(index, KeyTrigger.access$700(keyTrigger)));
                    break;
            }
            StringBuilder sbU = a.U("unused attribute 0x");
            sbU.append(Integer.toHexString(index));
            sbU.append("   ");
            sbU.append(mAttrMap.get(index));
            Log.e(KeyTrigger.NAME, sbU.toString());
        }
    }
}
