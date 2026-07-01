package com.discord.widgets.voice.fullscreen;

import android.graphics.Typeface;
import android.text.style.ForegroundColorSpan;
import com.discord.i18n.Hook;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.spans.TypefaceSpanCompat;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$configureStageUi$3$1 extends o implements Function1<Hook, Unit> {
    public final /* synthetic */ WidgetCallFullscreen$configureStageUi$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreen$configureStageUi$3$1(WidgetCallFullscreen$configureStageUi$3 widgetCallFullscreen$configureStageUi$3) {
        super(1);
        this.this$0 = widgetCallFullscreen$configureStageUi$3;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
        invoke2(hook);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Hook hook) {
        m.checkNotNullParameter(hook, "$receiver");
        Typeface themedFont = FontUtils.INSTANCE.getThemedFont(this.this$0.this$0.requireContext(), 2130969396);
        if (themedFont != null) {
            hook.styles.add(new TypefaceSpanCompat(themedFont));
        }
        hook.styles.add(new ForegroundColorSpan(ColorCompat.getThemedColor(this.this$0.this$0.getContext(), 2130969970)));
    }
}
