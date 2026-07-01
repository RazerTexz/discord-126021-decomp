package com.discord.widgets.settings;

import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$onRequestDataClick$3$1 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ WidgetSettingsPrivacy$onRequestDataClick$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsPrivacy$onRequestDataClick$3$1(WidgetSettingsPrivacy$onRequestDataClick$3 widgetSettingsPrivacy$onRequestDataClick$3) {
        super(1);
        this.this$0 = widgetSettingsPrivacy$onRequestDataClick$3;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "it");
        WidgetSettingsPrivacy$onRequestDataClick$2 widgetSettingsPrivacy$onRequestDataClick$2 = this.this$0.$handleRequestError$2;
        Error$Response response = error.getResponse();
        m.checkNotNullExpressionValue(response, "it.response");
        widgetSettingsPrivacy$onRequestDataClick$2.invoke2(response.getMessage());
        error.setShowErrorToasts(false);
    }
}
