package com.discord.utilities.device;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.provider.Settings;
import d0.g0.Strings4;
import d0.t.SetsJVM;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: DeviceUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DeviceUtils {
    public static final DeviceUtils INSTANCE = new DeviceUtils();
    private static final int SMALL_SCREEN_WIDTH_DP = 360;

    private DeviceUtils() {
    }

    public static /* synthetic */ boolean isDevice$default(DeviceUtils deviceUtils, String str, Integer num, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            str2 = null;
        }
        return deviceUtils.isDevice(str, num, str2);
    }

    public final boolean canDrawOverlays(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        return Build.VERSION.SDK_INT <= 22 || Settings.canDrawOverlays(context);
    }

    public final boolean isDevice(String manufacturer, Integer versionCode, String model) {
        return isDevice(manufacturer != null ? SetsJVM.setOf(manufacturer) : null, versionCode != null ? SetsJVM.setOf(Integer.valueOf(versionCode.intValue())) : null, model != null ? SetsJVM.setOf(model) : null);
    }

    public final boolean isSmallScreen(Resources resources) {
        Intrinsics3.checkNotNullParameter(resources, "resources");
        return ((float) resources.getDisplayMetrics().widthPixels) <= ((float) SMALL_SCREEN_WIDTH_DP) * resources.getDisplayMetrics().density;
    }

    public final boolean isTablet(Resources resources) {
        Intrinsics3.checkNotNullParameter(resources, "resources");
        return (resources.getConfiguration().screenLayout & 15) >= 3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean isDevice$default(DeviceUtils deviceUtils, Set set, Set set2, Set set3, int i, Object obj) {
        if ((i & 1) != 0) {
            set = null;
        }
        if ((i & 2) != 0) {
            set2 = null;
        }
        if ((i & 4) != 0) {
            set3 = null;
        }
        return deviceUtils.isDevice((Set<String>) set, (Set<Integer>) set2, (Set<String>) set3);
    }

    public final boolean isDevice(Set<String> manufacturers, Set<Integer> versionCodes, Set<String> models) {
        boolean z2;
        boolean z3;
        boolean z4;
        if (manufacturers == null) {
            z2 = true;
        } else {
            if (!manufacturers.isEmpty()) {
                Iterator<T> it = manufacturers.iterator();
                while (true) {
                    if (it.hasNext()) {
                        String str = (String) it.next();
                        String str2 = Build.MANUFACTURER;
                        Intrinsics3.checkNotNullExpressionValue(str2, "Build.MANUFACTURER");
                        if (Strings4.contains((CharSequence) str2, (CharSequence) str, true)) {
                            z2 = true;
                        }
                    }
                }
            }
            z2 = false;
        }
        if (versionCodes == null) {
            z3 = true;
        } else {
            if (!versionCodes.isEmpty()) {
                Iterator<T> it2 = versionCodes.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (Build.VERSION.SDK_INT == ((Number) it2.next()).intValue()) {
                            z3 = true;
                        }
                    }
                }
            }
            z3 = false;
        }
        if (models == null) {
            z4 = true;
        } else {
            if (!models.isEmpty()) {
                Iterator<T> it3 = models.iterator();
                while (true) {
                    if (it3.hasNext()) {
                        String str3 = (String) it3.next();
                        String str4 = Build.MODEL;
                        Intrinsics3.checkNotNullExpressionValue(str4, "Build.MODEL");
                        if (Strings4.contains((CharSequence) str4, (CharSequence) str3, true)) {
                            z4 = true;
                        }
                    }
                }
            }
            z4 = false;
        }
        return z2 && z3 && z4;
    }
}
