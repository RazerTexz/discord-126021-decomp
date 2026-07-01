package com.discord.utilities.auth;

import b.a.k.b;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.validators.InputValidator;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.s;
import d0.z.d.m;

/* JADX INFO: compiled from: AuthUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AuthUtils$createDiscriminatorInputValidator$1 implements InputValidator<TextInputLayout> {
    public final /* synthetic */ int $invalidFormatResId;
    public final /* synthetic */ int $invalidValueResId;

    public AuthUtils$createDiscriminatorInputValidator$1(int i, int i2) {
        this.$invalidFormatResId = i;
        this.$invalidValueResId = i2;
    }

    @Override // com.discord.utilities.view.validators.InputValidator
    public /* bridge */ /* synthetic */ CharSequence getErrorMessage(TextInputLayout textInputLayout) {
        return getErrorMessage2(textInputLayout);
    }

    /* JADX INFO: renamed from: getErrorMessage, reason: avoid collision after fix types in other method */
    public CharSequence getErrorMessage2(TextInputLayout view) {
        m.checkNotNullParameter(view, "view");
        String textOrEmpty = ViewExtensions.getTextOrEmpty(view);
        Integer intOrNull = s.toIntOrNull(textOrEmpty);
        if (intOrNull == null || textOrEmpty.length() != 4) {
            return b.j(view, this.$invalidFormatResId, new Object[0], null, 4);
        }
        if (intOrNull.intValue() <= 0) {
            return b.j(view, this.$invalidValueResId, new Object[0], null, 4);
        }
        return null;
    }
}
