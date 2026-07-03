package com.discord.widgets.bugreports;

import com.discord.api.bugreport.Feature;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetBugReport.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetBugReport$featuresAdapter$1 extends C12236k implements Function1<Feature, Unit> {
    public WidgetBugReport$featuresAdapter$1(WidgetBugReport widgetBugReport) {
        super(1, widgetBugReport, WidgetBugReport.class, "onFeatureClickListener", "onFeatureClickListener(Lcom/discord/api/bugreport/Feature;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Feature feature) {
        invoke2(feature);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Feature feature) {
        C12238m.checkNotNullParameter(feature, "p1");
        ((WidgetBugReport) this.receiver).onFeatureClickListener(feature);
    }
}
