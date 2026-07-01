package com.discord.widgets.chat.list.sheet;

import com.discord.i18n.RenderContext;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheet$configureCommandTitle$content$1 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ int $cmdColor;
    public final /* synthetic */ WidgetApplicationCommandBottomSheetViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ WidgetApplicationCommandBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetApplicationCommandBottomSheet$configureCommandTitle$content$1(WidgetApplicationCommandBottomSheet widgetApplicationCommandBottomSheet, WidgetApplicationCommandBottomSheetViewModel$ViewState$Loaded widgetApplicationCommandBottomSheetViewModel$ViewState$Loaded, int i) {
        super(1);
        this.this$0 = widgetApplicationCommandBottomSheet;
        this.$viewState = widgetApplicationCommandBottomSheetViewModel$ViewState$Loaded;
        this.$cmdColor = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.a("usernameOnClick", new WidgetApplicationCommandBottomSheet$configureCommandTitle$content$1$1(this));
        renderContext.a("commandName", new WidgetApplicationCommandBottomSheet$configureCommandTitle$content$1$2(this));
        renderContext.a("applicationName", WidgetApplicationCommandBottomSheet$configureCommandTitle$content$1$3.INSTANCE);
    }
}
