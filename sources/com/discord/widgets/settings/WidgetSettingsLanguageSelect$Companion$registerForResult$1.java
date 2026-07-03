package com.discord.widgets.settings;

import android.os.Bundle;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSettingsLanguageSelect.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsLanguageSelect$Companion$registerForResult$1 extends AbstractC12240o implements Function2<String, Bundle, Unit> {
    public final /* synthetic */ Function1 $onLocaleSelected;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsLanguageSelect$Companion$registerForResult$1(Function1 function1) {
        super(2);
        this.$onLocaleSelected = function1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, Bundle bundle) {
        invoke2(str, bundle);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str, Bundle bundle) {
        C12238m.checkNotNullParameter(str, "requestKey");
        C12238m.checkNotNullParameter(bundle, "bundle");
        if (C12238m.areEqual("REQUEST_KEY_USER_LOCALE", str)) {
            String string = bundle.getString("INTENT_EXTRA_LOCALE", "");
            Function1 function1 = this.$onLocaleSelected;
            C12238m.checkNotNullExpressionValue(string, "locale");
            function1.invoke(string);
        }
    }
}
