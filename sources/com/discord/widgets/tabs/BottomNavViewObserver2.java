package com.discord.widgets.tabs;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.tabs.BottomNavViewObserver$Companion$INSTANCE$2, reason: use source file name */
/* JADX INFO: compiled from: BottomNavViewObserver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BottomNavViewObserver2 extends Lambda implements Function0<BottomNavViewObserver> {
    public static final BottomNavViewObserver2 INSTANCE = new BottomNavViewObserver2();

    public BottomNavViewObserver2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final BottomNavViewObserver invoke() {
        return new BottomNavViewObserver();
    }
}
