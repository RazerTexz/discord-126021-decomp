package com.discord.utilities.networking;

import d0.z.d.m;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: Backoff.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Backoff$sam$java_lang_Runnable$0 implements Runnable {
    private final /* synthetic */ Function0 function;

    public Backoff$sam$java_lang_Runnable$0(Function0 function0) {
        this.function = function0;
    }

    @Override // java.lang.Runnable
    public final /* synthetic */ void run() {
        m.checkNotNullExpressionValue(this.function.invoke(), "invoke(...)");
    }
}
