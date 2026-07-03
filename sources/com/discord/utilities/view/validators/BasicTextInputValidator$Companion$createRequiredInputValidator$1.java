package com.discord.utilities.view.validators;

import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: BasicTextInputValidator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BasicTextInputValidator$Companion$createRequiredInputValidator$1 extends AbstractC12240o implements Function1<String, Boolean> {
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
        C12238m.checkNotNullParameter(str, "it");
        return str.length() > 0;
    }
}
