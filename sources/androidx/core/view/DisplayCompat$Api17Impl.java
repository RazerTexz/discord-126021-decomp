package androidx.core.view;

import android.graphics.Point;
import android.view.Display;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(17)
public class DisplayCompat$Api17Impl {
    private DisplayCompat$Api17Impl() {
    }

    public static void getRealSize(Display display, Point point) {
        display.getRealSize(point);
    }
}
