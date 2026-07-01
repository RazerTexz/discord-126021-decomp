package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.UiThread;

/* JADX INFO: loaded from: classes.dex */
public abstract class AsyncListUtil$ViewCallback {
    public static final int HINT_SCROLL_ASC = 2;
    public static final int HINT_SCROLL_DESC = 1;
    public static final int HINT_SCROLL_NONE = 0;

    @UiThread
    public void extendRangeInto(@NonNull int[] iArr, @NonNull int[] iArr2, int i) {
        int i2 = (iArr[1] - iArr[0]) + 1;
        int i3 = i2 / 2;
        iArr2[0] = iArr[0] - (i == 1 ? i2 : i3);
        int i4 = iArr[1];
        if (i != 2) {
            i2 = i3;
        }
        iArr2[1] = i4 + i2;
    }

    @UiThread
    public abstract void getItemRangeInto(@NonNull int[] iArr);

    @UiThread
    public abstract void onDataRefresh();

    @UiThread
    public abstract void onItemLoaded(int i);
}
