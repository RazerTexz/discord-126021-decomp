package com.discord.widgets.settings;

import android.os.Bundle;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetSettingsLanguageSelect.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsLanguageSelect$Companion$registerForResult$1 extends o implements Function2<String, Bundle, Unit> {
    public final /* synthetic */ Function1 $onLocaleSelected;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsLanguageSelect$Companion$registerForResult$1(Function1 function1) {
        super(2);
        this.$onLocaleSelected = function1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, Bundle bundle) {
        invoke2(str, bundle);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str, Bundle bundle) {
        m.checkNotNullParameter(str, "requestKey");
        m.checkNotNullParameter(bundle, "bundle");
        if (m.areEqual("REQUEST_KEY_USER_LOCALE", str)) {
            String string = bundle.getString("INTENT_EXTRA_LOCALE", "");
            Function1 function1 = this.$onLocaleSelected;
            m.checkNotNullExpressionValue(string, "locale");
            function1.invoke(string);
        }
    }
}
