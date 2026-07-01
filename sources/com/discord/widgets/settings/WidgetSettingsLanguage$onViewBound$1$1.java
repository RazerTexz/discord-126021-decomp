package com.discord.widgets.settings;

import com.discord.restapi.RestAPIParams$UserSettings;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsLanguage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsLanguage$onViewBound$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ String $locale;
    public final /* synthetic */ WidgetSettingsLanguage$onViewBound$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsLanguage$onViewBound$1$1(WidgetSettingsLanguage$onViewBound$1 widgetSettingsLanguage$onViewBound$1, String str) {
        super(0);
        this.this$0 = widgetSettingsLanguage$onViewBound$1;
        this.$locale = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().updateUserSettings(RestAPIParams$UserSettings.Companion.createWithLocale(this.$locale)), false, 1, null), this.this$0.this$0, null, 2, null), StoreUserSettings.class, this.this$0.this$0.requireContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettingsLanguage$onViewBound$1$1$1(this), 60, (Object) null);
    }
}
