package com.discord.widgets.settings;

import android.widget.TextView;
import com.discord.R;
import com.discord.i18n.RenderContext;
import com.discord.utilities.color.ColorCompat;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.settings.WidgetMuteSettingsSheet$configureUnmuteButton$boldRenderContext$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetMuteSettingsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMuteSettingsSheet3 extends Lambda implements Function1<RenderContext, Unit> {
    public final /* synthetic */ WidgetMuteSettingsSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetMuteSettingsSheet3(WidgetMuteSettingsSheet widgetMuteSettingsSheet) {
        super(1);
        this.this$0 = widgetMuteSettingsSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
        TextView textView = this.this$0.getBinding().q;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.unmuteButtonLabel");
        renderContext.boldColor = Integer.valueOf(ColorCompat.getThemedColor(textView, R.attr.colorHeaderPrimary));
    }
}
