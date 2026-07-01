package com.discord.stores;

import androidx.annotation.RecentlyNonNull;
import b.i.a.f.n.d;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreDynamicLink.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreDynamicLink$sam$com_google_android_gms_tasks_OnFailureListener$0 implements d {
    private final /* synthetic */ Function1 function;

    public StoreDynamicLink$sam$com_google_android_gms_tasks_OnFailureListener$0(Function1 function1) {
        this.function = function1;
    }

    @Override // b.i.a.f.n.d
    public final /* synthetic */ void onFailure(@RecentlyNonNull Exception exc) {
        m.checkNotNullExpressionValue(this.function.invoke(exc), "invoke(...)");
    }
}
