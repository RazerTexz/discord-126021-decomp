package com.discord.widgets.chat.list;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.CreateThreadsFeatureFlag$Companion$INSTANCE$2, reason: use source file name */
/* JADX INFO: compiled from: CreateThreadsFeatureFlag.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CreateThreadsFeatureFlag2 extends Lambda implements Function0<CreateThreadsFeatureFlag> {
    public static final CreateThreadsFeatureFlag2 INSTANCE = new CreateThreadsFeatureFlag2();

    public CreateThreadsFeatureFlag2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final CreateThreadsFeatureFlag invoke() {
        return new CreateThreadsFeatureFlag(null, null, 3, null);
    }
}
