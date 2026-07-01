package com.discord.widgets.settings;

import android.os.Bundle;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsLanguageSelect$Companion$registerForResult$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsLanguageSelect.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsLanguageSelect3 extends Lambda implements Function2<String, Bundle, Unit> {
    public final /* synthetic */ Function1 $onLocaleSelected;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsLanguageSelect3(Function1 function1) {
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
        Intrinsics3.checkNotNullParameter(str, "requestKey");
        Intrinsics3.checkNotNullParameter(bundle, "bundle");
        if (Intrinsics3.areEqual("REQUEST_KEY_USER_LOCALE", str)) {
            String string = bundle.getString("INTENT_EXTRA_LOCALE", "");
            Function1 function1 = this.$onLocaleSelected;
            Intrinsics3.checkNotNullExpressionValue(string, "locale");
            function1.invoke(string);
        }
    }
}
