package com.discord.widgets.settings;

import com.discord.models.domain.ModelUserSettings;
import com.discord.restapi.RestAPIParams$UserSettings;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsAppearance.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAppearance$updateTheme$1 extends o implements Function0<Unit> {
    public final /* synthetic */ String $theme;
    public final /* synthetic */ WidgetSettingsAppearance this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsAppearance$updateTheme$1(WidgetSettingsAppearance widgetSettingsAppearance, String str) {
        super(0);
        this.this$0 = widgetSettingsAppearance;
        this.$theme = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().updateUserSettings(RestAPIParams$UserSettings.Companion.createWithTheme(m.areEqual(this.$theme, ModelUserSettings.THEME_PURE_EVIL) ? ModelUserSettings.THEME_DARK : this.$theme)), false, 1, null), this.this$0, null, 2, null), StoreUserSettings.class, this.this$0.getActivity(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettingsAppearance$updateTheme$1$1(this), 60, (Object) null);
    }
}
