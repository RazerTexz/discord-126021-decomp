package com.discord.utilities.auth;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.utilities.auth.RegistrationFlowRepo$Companion$INSTANCE$2, reason: use source file name */
/* JADX INFO: compiled from: RegistrationFlowRepo.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RegistrationFlowRepo2 extends Lambda implements Function0<RegistrationFlowRepo> {
    public static final RegistrationFlowRepo2 INSTANCE = new RegistrationFlowRepo2();

    public RegistrationFlowRepo2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final RegistrationFlowRepo invoke() {
        return new RegistrationFlowRepo();
    }
}
