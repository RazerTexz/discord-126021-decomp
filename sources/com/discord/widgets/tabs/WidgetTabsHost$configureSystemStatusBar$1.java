package com.discord.widgets.tabs;

import androidx.fragment.app.Fragment;
import com.discord.utilities.color.ColorCompat;
import com.discord.widgets.status.WidgetGlobalStatusIndicatorState$State;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetTabsHost.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetTabsHost$configureSystemStatusBar$1 extends o implements Function1<WidgetGlobalStatusIndicatorState$State, Unit> {
    public final /* synthetic */ int $defaultStatusBarColor;
    public final /* synthetic */ WidgetTabsHost this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetTabsHost$configureSystemStatusBar$1(WidgetTabsHost widgetTabsHost, int i) {
        super(1);
        this.this$0 = widgetTabsHost;
        this.$defaultStatusBarColor = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetGlobalStatusIndicatorState$State widgetGlobalStatusIndicatorState$State) {
        invoke2(widgetGlobalStatusIndicatorState$State);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetGlobalStatusIndicatorState$State widgetGlobalStatusIndicatorState$State) {
        m.checkNotNullParameter(widgetGlobalStatusIndicatorState$State, "state");
        WidgetTabsHost.access$setPanelWindowInsetsListeners(this.this$0, widgetGlobalStatusIndicatorState$State.isVisible());
        int color = ColorCompat.getColor(this.this$0, 2131100438);
        if (!widgetGlobalStatusIndicatorState$State.isVisible()) {
            color = this.$defaultStatusBarColor;
        }
        ColorCompat.setStatusBarColor$default((Fragment) this.this$0, color, false, 4, (Object) null);
    }
}
