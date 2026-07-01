package com.discord.utilities.auth;

import com.discord.utilities.phone.PhoneUtils;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AuthUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AuthUtils$createPhoneInputValidator$1 extends o implements Function1<String, Boolean> {
    public static final AuthUtils$createPhoneInputValidator$1 INSTANCE = new AuthUtils$createPhoneInputValidator$1();

    public AuthUtils$createPhoneInputValidator$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(String str) {
        return Boolean.valueOf(invoke2(str));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(String str) {
        m.checkNotNullParameter(str, "it");
        return PhoneUtils.INSTANCE.isValidPhoneFragment(str);
    }
}
