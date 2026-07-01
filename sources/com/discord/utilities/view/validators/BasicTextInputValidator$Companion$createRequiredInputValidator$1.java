package com.discord.utilities.view.validators;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: BasicTextInputValidator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BasicTextInputValidator$Companion$createRequiredInputValidator$1 extends o implements Function1<String, Boolean> {
    public static final BasicTextInputValidator$Companion$createRequiredInputValidator$1 INSTANCE = new BasicTextInputValidator$Companion$createRequiredInputValidator$1();

    public BasicTextInputValidator$Companion$createRequiredInputValidator$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(String str) {
        return Boolean.valueOf(invoke2(str));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(String str) {
        m.checkNotNullParameter(str, "it");
        return str.length() > 0;
    }
}
