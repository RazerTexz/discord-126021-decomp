package com.discord.restapi;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p600f0.C12380x;

/* JADX INFO: compiled from: RestAPIBuilder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RestAPIBuilder$Companion$clientCallback$1 extends AbstractC12240o implements Function2<String, C12380x, Unit> {
    public static final RestAPIBuilder$Companion$clientCallback$1 INSTANCE = new RestAPIBuilder$Companion$clientCallback$1();

    public RestAPIBuilder$Companion$clientCallback$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, C12380x c12380x) {
        invoke2(str, c12380x);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str, C12380x c12380x) {
        C12238m.checkNotNullParameter(str, "<anonymous parameter 0>");
        C12238m.checkNotNullParameter(c12380x, "<anonymous parameter 1>");
    }
}
