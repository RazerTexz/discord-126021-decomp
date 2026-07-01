package com.discord.utilities.simple_pager;

import androidx.fragment.app.Fragment;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: SimplePager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SimplePager$Adapter$Item {
    private final Function0<Fragment> creator;
    private final String title;

    /* JADX WARN: Multi-variable type inference failed */
    public SimplePager$Adapter$Item(String str, Function0<? extends Fragment> function0) {
        m.checkNotNullParameter(str, "title");
        m.checkNotNullParameter(function0, "creator");
        this.title = str;
        this.creator = function0;
    }

    public final Function0<Fragment> getCreator$utils_release() {
        return this.creator;
    }

    /* JADX INFO: renamed from: getTitle$utils_release, reason: from getter */
    public final String getTitle() {
        return this.title;
    }
}
