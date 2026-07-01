package com.discord.restapi;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import f0.OkHttpClient;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.discord.restapi.RestAPIBuilder$Companion$clientCallback$1, reason: use source file name */
/* JADX INFO: compiled from: RestAPIBuilder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIBuilder2 extends Lambda implements Function2<String, OkHttpClient, Unit> {
    public static final RestAPIBuilder2 INSTANCE = new RestAPIBuilder2();

    public RestAPIBuilder2() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, OkHttpClient okHttpClient) {
        invoke2(str, okHttpClient);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str, OkHttpClient okHttpClient) {
        Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 0>");
        Intrinsics3.checkNotNullParameter(okHttpClient, "<anonymous parameter 1>");
    }
}
