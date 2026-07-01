package com.discord.restapi;

import d0.z.d.m;
import d0.z.d.o;
import f0.x;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: RestAPIBuilder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIBuilder$Companion$clientCallback$1 extends o implements Function2<String, x, Unit> {
    public static final RestAPIBuilder$Companion$clientCallback$1 INSTANCE = new RestAPIBuilder$Companion$clientCallback$1();

    public RestAPIBuilder$Companion$clientCallback$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, x xVar) {
        invoke2(str, xVar);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str, x xVar) {
        m.checkNotNullParameter(str, "<anonymous parameter 0>");
        m.checkNotNullParameter(xVar, "<anonymous parameter 1>");
    }
}
