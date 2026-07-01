package com.discord.widgets.chat.list.sheet;

import android.text.style.StyleSpan;
import com.discord.i18n.Hook;
import com.discord.utilities.textprocessing.FontColorSpan;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheet$configureCommandTitle$content$1$2 extends o implements Function1<Hook, Unit> {
    public final /* synthetic */ WidgetApplicationCommandBottomSheet$configureCommandTitle$content$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetApplicationCommandBottomSheet$configureCommandTitle$content$1$2(WidgetApplicationCommandBottomSheet$configureCommandTitle$content$1 widgetApplicationCommandBottomSheet$configureCommandTitle$content$1) {
        super(1);
        this.this$0 = widgetApplicationCommandBottomSheet$configureCommandTitle$content$1;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Hook hook) {
        m.checkNotNullParameter(hook, "$receiver");
        hook.styles.add(new FontColorSpan(this.this$0.$cmdColor));
        hook.styles.add(new StyleSpan(1));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
        invoke2(hook);
        return Unit.a;
    }
}
