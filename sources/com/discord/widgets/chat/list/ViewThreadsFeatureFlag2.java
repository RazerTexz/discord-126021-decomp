package com.discord.widgets.chat.list;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.ViewThreadsFeatureFlag$Companion$INSTANCE$2, reason: use source file name */
/* JADX INFO: compiled from: ViewThreadsFeatureFlag.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewThreadsFeatureFlag2 extends Lambda implements Function0<ViewThreadsFeatureFlag> {
    public static final ViewThreadsFeatureFlag2 INSTANCE = new ViewThreadsFeatureFlag2();

    public ViewThreadsFeatureFlag2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewThreadsFeatureFlag invoke() {
        return new ViewThreadsFeatureFlag(null, 1, null);
    }
}
