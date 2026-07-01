package com.discord.widgets.chat.list.sheet;

import android.text.style.StyleSpan;
import com.discord.i18n.Hook;
import com.discord.models.member.GuildMember;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.utilities.textprocessing.FontColorSpan;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheet$configureCommandTitle$content$1$1 extends o implements Function1<Hook, Unit> {
    public final /* synthetic */ WidgetApplicationCommandBottomSheet$configureCommandTitle$content$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetApplicationCommandBottomSheet$configureCommandTitle$content$1$1(WidgetApplicationCommandBottomSheet$configureCommandTitle$content$1 widgetApplicationCommandBottomSheet$configureCommandTitle$content$1) {
        super(1);
        this.this$0 = widgetApplicationCommandBottomSheet$configureCommandTitle$content$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
        invoke2(hook);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Hook hook) {
        m.checkNotNullParameter(hook, "$receiver");
        GuildMember interactionUser = this.this$0.$viewState.getInteractionUser();
        if (interactionUser != null) {
            hook.styles.add(new FontColorSpan(interactionUser.getColor()));
        }
        hook.styles.add(new ClickableSpan(null, false, null, new WidgetApplicationCommandBottomSheet$configureCommandTitle$content$1$1$2(this), 4, null));
        hook.styles.add(new StyleSpan(1));
    }
}
