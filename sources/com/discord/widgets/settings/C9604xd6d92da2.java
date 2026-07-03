package com.discord.widgets.settings;

import android.widget.TextView;
import com.discord.C5419R;
import com.discord.i18n.RenderContext;
import com.discord.utilities.color.ColorCompat;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.settings.WidgetMuteSettingsSheet$configureUnmuteButton$boldRenderContext$1 */
/* JADX INFO: compiled from: WidgetMuteSettingsSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C9604xd6d92da2 extends AbstractC12240o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ WidgetMuteSettingsSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C9604xd6d92da2(WidgetMuteSettingsSheet widgetMuteSettingsSheet) {
        super(1);
        this.this$0 = widgetMuteSettingsSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        C12238m.checkNotNullParameter(renderContext, "$receiver");
        TextView textView = this.this$0.getBinding().f17290q;
        C12238m.checkNotNullExpressionValue(textView, "binding.unmuteButtonLabel");
        renderContext.boldColor = Integer.valueOf(ColorCompat.getThemedColor(textView, C5419R.attr.colorHeaderPrimary));
    }
}
