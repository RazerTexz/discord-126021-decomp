package com.discord.widgets.settings;

import android.content.Context;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$onRequestDataClick$3 extends o implements Function0<Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ WidgetSettingsPrivacy$onRequestDataClick$2 $handleRequestError$2;
    public final /* synthetic */ WidgetSettingsPrivacy$onRequestDataClick$1 $handleRequestSuccess$1;
    public final /* synthetic */ WidgetSettingsPrivacy this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsPrivacy$onRequestDataClick$3(WidgetSettingsPrivacy widgetSettingsPrivacy, Context context, WidgetSettingsPrivacy$onRequestDataClick$2 widgetSettingsPrivacy$onRequestDataClick$2, WidgetSettingsPrivacy$onRequestDataClick$1 widgetSettingsPrivacy$onRequestDataClick$1) {
        super(0);
        this.this$0 = widgetSettingsPrivacy;
        this.$context = context;
        this.$handleRequestError$2 = widgetSettingsPrivacy$onRequestDataClick$2;
        this.$handleRequestSuccess$1 = widgetSettingsPrivacy$onRequestDataClick$1;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.withDimmer(ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn(RestAPI.Companion.getApi().requestHarvest(), false)), WidgetSettingsPrivacy.access$getBinding$p(this.this$0).g, 100L), this.this$0.getClass(), this.$context, (Function1) null, new WidgetSettingsPrivacy$onRequestDataClick$3$1(this), (Function0) null, (Function0) null, new WidgetSettingsPrivacy$onRequestDataClick$3$2(this), 52, (Object) null);
    }
}
