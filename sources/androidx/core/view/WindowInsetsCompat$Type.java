package androidx.core.view;

import android.annotation.SuppressLint;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public final class WindowInsetsCompat$Type {
    public static final int CAPTION_BAR = 4;
    public static final int DISPLAY_CUTOUT = 128;
    public static final int FIRST = 1;
    public static final int IME = 8;
    public static final int LAST = 256;
    public static final int MANDATORY_SYSTEM_GESTURES = 32;
    public static final int NAVIGATION_BARS = 2;
    public static final int SIZE = 9;
    public static final int STATUS_BARS = 1;
    public static final int SYSTEM_GESTURES = 16;
    public static final int TAPPABLE_ELEMENT = 64;
    public static final int WINDOW_DECOR = 256;

    private WindowInsetsCompat$Type() {
    }

    @SuppressLint({"WrongConstant"})
    @RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
    public static int all() {
        return -1;
    }

    public static int captionBar() {
        return 4;
    }

    public static int displayCutout() {
        return 128;
    }

    public static int ime() {
        return 8;
    }

    public static int indexOf(int i) {
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 4) {
            return 2;
        }
        if (i == 8) {
            return 3;
        }
        if (i == 16) {
            return 4;
        }
        if (i == 32) {
            return 5;
        }
        if (i == 64) {
            return 6;
        }
        if (i == 128) {
            return 7;
        }
        if (i == 256) {
            return 8;
        }
        throw new IllegalArgumentException(a.q("type needs to be >= FIRST and <= LAST, type=", i));
    }

    public static int mandatorySystemGestures() {
        return 32;
    }

    public static int navigationBars() {
        return 2;
    }

    public static int statusBars() {
        return 1;
    }

    public static int systemBars() {
        return 7;
    }

    public static int systemGestures() {
        return 16;
    }

    public static int tappableElement() {
        return 64;
    }
}
