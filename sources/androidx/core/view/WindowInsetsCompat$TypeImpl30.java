package androidx.core.view;

import android.view.WindowInsets$Type;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(30)
public final class WindowInsetsCompat$TypeImpl30 {
    private WindowInsetsCompat$TypeImpl30() {
    }

    public static int toPlatformType(int i) {
        int iStatusBars;
        int i2 = 0;
        for (int i3 = 1; i3 <= 256; i3 <<= 1) {
            if ((i & i3) != 0) {
                if (i3 == 1) {
                    iStatusBars = WindowInsets$Type.statusBars();
                } else if (i3 == 2) {
                    iStatusBars = WindowInsets$Type.navigationBars();
                } else if (i3 == 4) {
                    iStatusBars = WindowInsets$Type.captionBar();
                } else if (i3 == 8) {
                    iStatusBars = WindowInsets$Type.ime();
                } else if (i3 == 16) {
                    iStatusBars = WindowInsets$Type.systemGestures();
                } else if (i3 == 32) {
                    iStatusBars = WindowInsets$Type.mandatorySystemGestures();
                } else if (i3 == 64) {
                    iStatusBars = WindowInsets$Type.tappableElement();
                } else if (i3 == 128) {
                    iStatusBars = WindowInsets$Type.displayCutout();
                }
                i2 |= iStatusBars;
            }
        }
        return i2;
    }
}
