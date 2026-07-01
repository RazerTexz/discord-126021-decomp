package com.discord.gateway;

import com.discord.api.activity.Activity;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GatewaySocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewaySocket$presenceUpdate$1$1 extends o implements Function1<Activity, CharSequence> {
    public static final GatewaySocket$presenceUpdate$1$1 INSTANCE = new GatewaySocket$presenceUpdate$1$1();

    public GatewaySocket$presenceUpdate$1$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(Activity activity) {
        return invoke2(activity);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(Activity activity) {
        m.checkNotNullParameter(activity, "it");
        return activity.getName();
    }
}
