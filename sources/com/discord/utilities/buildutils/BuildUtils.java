package com.discord.utilities.buildutils;

import d0.z.d.Intrinsics3;
import kotlin.text.Regex;

/* JADX INFO: compiled from: BuildUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BuildUtils {
    public static final BuildUtils INSTANCE = new BuildUtils();

    private BuildUtils() {
    }

    public final boolean isValidBuildVersionName(String versionName) {
        Intrinsics3.checkNotNullParameter(versionName, "versionName");
        return new Regex("^\\d+[.]\\d+ - (Dev|Alpha|Beta|Stable)$").matches(versionName);
    }
}
