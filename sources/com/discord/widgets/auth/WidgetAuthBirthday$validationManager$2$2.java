package com.discord.widgets.auth;

import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.checkbox.MaterialCheckBox;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetAuthBirthday.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthBirthday$validationManager$2$2 extends o implements Function2<MaterialCheckBox, CharSequence, Boolean> {
    public static final WidgetAuthBirthday$validationManager$2$2 INSTANCE = new WidgetAuthBirthday$validationManager$2$2();

    public WidgetAuthBirthday$validationManager$2$2() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(MaterialCheckBox materialCheckBox, CharSequence charSequence) {
        return Boolean.valueOf(invoke2(materialCheckBox, charSequence));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(MaterialCheckBox materialCheckBox, CharSequence charSequence) {
        m.checkNotNullParameter(materialCheckBox, "checkBox");
        m.checkNotNullParameter(charSequence, "errorMessage");
        b.a.d.m.h(materialCheckBox.getContext(), charSequence, 0, null, 12);
        ViewExtensions.hintWithRipple$default(materialCheckBox, 0L, 1, null);
        return true;
    }
}
