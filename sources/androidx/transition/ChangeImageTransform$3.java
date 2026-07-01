package androidx.transition;

import android.widget.ImageView$ScaleType;

/* JADX INFO: loaded from: classes.dex */
public /* synthetic */ class ChangeImageTransform$3 {
    public static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;

    static {
        int[] iArr = new int[ImageView$ScaleType.values().length];
        $SwitchMap$android$widget$ImageView$ScaleType = iArr;
        try {
            iArr[ImageView$ScaleType.FIT_XY.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            $SwitchMap$android$widget$ImageView$ScaleType[ImageView$ScaleType.CENTER_CROP.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
