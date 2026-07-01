package com.discord.app;

import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.lifecycle.ActivityProvider;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: App.kt */
/* JADX INFO: loaded from: classes.dex */
public final class App$c extends o implements Function0<Integer> {
    public static final App$c j = new App$c();

    public App$c() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public Integer invoke() {
        return Integer.valueOf(ColorCompat.getThemedColor(ActivityProvider.Companion.getActivity(), 2130969054));
    }
}
