package com.discord.widgets.chat.list.sheet;

import android.text.style.StyleSpan;
import com.discord.i18n.Hook;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheet$configureCommandTitle$content$1$3 extends o implements Function1<Hook, Unit> {
    public static final WidgetApplicationCommandBottomSheet$configureCommandTitle$content$1$3 INSTANCE = new WidgetApplicationCommandBottomSheet$configureCommandTitle$content$1$3();

    public WidgetApplicationCommandBottomSheet$configureCommandTitle$content$1$3() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Hook hook) {
        m.checkNotNullParameter(hook, "$receiver");
        hook.styles.add(new StyleSpan(1));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
        invoke2(hook);
        return Unit.a;
    }
}
