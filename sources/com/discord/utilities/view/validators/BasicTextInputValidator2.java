package com.discord.utilities.view.validators;

import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.utilities.view.validators.BasicTextInputValidator$Companion$createRequiredInputValidator$1, reason: use source file name */
/* JADX INFO: compiled from: BasicTextInputValidator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BasicTextInputValidator2 extends Lambda implements Function1<String, Boolean> {
    public static final BasicTextInputValidator2 INSTANCE = new BasicTextInputValidator2();

    public BasicTextInputValidator2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(String str) {
        return Boolean.valueOf(invoke2(str));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(String str) {
        Intrinsics3.checkNotNullParameter(str, "it");
        return str.length() > 0;
    }
}
