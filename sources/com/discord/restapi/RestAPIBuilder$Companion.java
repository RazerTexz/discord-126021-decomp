package com.discord.restapi;

import androidx.annotation.VisibleForTesting;
import d0.z.d.m;
import f0.x;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RestAPIBuilder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIBuilder$Companion {
    private RestAPIBuilder$Companion() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getClientCallback$annotations() {
    }

    public final Function2<String, x, Unit> getClientCallback() {
        return RestAPIBuilder.access$getClientCallback$cp();
    }

    public final void setClientCallback(Function2<? super String, ? super x, Unit> function2) {
        m.checkNotNullParameter(function2, "<set-?>");
        RestAPIBuilder.access$setClientCallback$cp(function2);
    }

    public /* synthetic */ RestAPIBuilder$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
