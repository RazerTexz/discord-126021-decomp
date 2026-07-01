package com.discord.widgets.playstation;

import com.discord.i18n.RenderContext;
import com.discord.utilities.platform.Platform;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetPlaystationIntegrationUpsellBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPlaystationIntegrationUpsellBottomSheet$onViewCreated$1 extends o implements Function1<RenderContext, Unit> {
    public static final WidgetPlaystationIntegrationUpsellBottomSheet$onViewCreated$1 INSTANCE = new WidgetPlaystationIntegrationUpsellBottomSheet$onViewCreated$1();

    public WidgetPlaystationIntegrationUpsellBottomSheet$onViewCreated$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.args.put("platform", Platform.PLAYSTATION.getProperName());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }
}
