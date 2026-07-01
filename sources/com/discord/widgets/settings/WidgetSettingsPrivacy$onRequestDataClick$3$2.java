package com.discord.widgets.settings;

import com.discord.models.domain.Harvest;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$onRequestDataClick$3$2 extends o implements Function1<Harvest, Unit> {
    public final /* synthetic */ WidgetSettingsPrivacy$onRequestDataClick$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsPrivacy$onRequestDataClick$3$2(WidgetSettingsPrivacy$onRequestDataClick$3 widgetSettingsPrivacy$onRequestDataClick$3) {
        super(1);
        this.this$0 = widgetSettingsPrivacy$onRequestDataClick$3;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Harvest harvest) {
        invoke2(harvest);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Harvest harvest) {
        if (harvest != null) {
            this.this$0.$handleRequestSuccess$1.invoke2(harvest);
        } else {
            WidgetSettingsPrivacy$onRequestDataClick$2.invoke$default(this.this$0.$handleRequestError$2, null, 1, null);
        }
    }
}
