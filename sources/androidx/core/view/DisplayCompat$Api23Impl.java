package androidx.core.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.Display$Mode;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
public class DisplayCompat$Api23Impl {
    private DisplayCompat$Api23Impl() {
    }

    @NonNull
    public static DisplayCompat$ModeCompat getMode(@NonNull Context context, @NonNull Display display) {
        Display$Mode mode = display.getMode();
        Point currentDisplaySizeFromWorkarounds = DisplayCompat.getCurrentDisplaySizeFromWorkarounds(context, display);
        return (currentDisplaySizeFromWorkarounds == null || physicalSizeEquals(mode, currentDisplaySizeFromWorkarounds)) ? new DisplayCompat$ModeCompat(mode, true) : new DisplayCompat$ModeCompat(mode, currentDisplaySizeFromWorkarounds);
    }

    @NonNull
    @SuppressLint({"ArrayReturn"})
    public static DisplayCompat$ModeCompat[] getSupportedModes(@NonNull Context context, @NonNull Display display) {
        Display$Mode[] supportedModes = display.getSupportedModes();
        DisplayCompat$ModeCompat[] displayCompat$ModeCompatArr = new DisplayCompat$ModeCompat[supportedModes.length];
        Display$Mode mode = display.getMode();
        Point currentDisplaySizeFromWorkarounds = DisplayCompat.getCurrentDisplaySizeFromWorkarounds(context, display);
        if (currentDisplaySizeFromWorkarounds == null || physicalSizeEquals(mode, currentDisplaySizeFromWorkarounds)) {
            for (int i = 0; i < supportedModes.length; i++) {
                displayCompat$ModeCompatArr[i] = new DisplayCompat$ModeCompat(supportedModes[i], physicalSizeEquals(supportedModes[i], mode));
            }
        } else {
            for (int i2 = 0; i2 < supportedModes.length; i2++) {
                displayCompat$ModeCompatArr[i2] = physicalSizeEquals(supportedModes[i2], mode) ? new DisplayCompat$ModeCompat(supportedModes[i2], currentDisplaySizeFromWorkarounds) : new DisplayCompat$ModeCompat(supportedModes[i2], false);
            }
        }
        return displayCompat$ModeCompatArr;
    }

    public static boolean isCurrentModeTheLargestMode(@NonNull Display display) {
        Display$Mode mode = display.getMode();
        Display$Mode[] supportedModes = display.getSupportedModes();
        for (int i = 0; i < supportedModes.length; i++) {
            if (mode.getPhysicalHeight() < supportedModes[i].getPhysicalHeight() || mode.getPhysicalWidth() < supportedModes[i].getPhysicalWidth()) {
                return false;
            }
        }
        return true;
    }

    public static boolean physicalSizeEquals(Display$Mode display$Mode, Point point) {
        return (display$Mode.getPhysicalWidth() == point.x && display$Mode.getPhysicalHeight() == point.y) || (display$Mode.getPhysicalWidth() == point.y && display$Mode.getPhysicalHeight() == point.x);
    }

    public static boolean physicalSizeEquals(Display$Mode display$Mode, Display$Mode display$Mode2) {
        return display$Mode.getPhysicalWidth() == display$Mode2.getPhysicalWidth() && display$Mode.getPhysicalHeight() == display$Mode2.getPhysicalHeight();
    }
}
