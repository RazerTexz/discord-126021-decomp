package com.discord.widgets.guilds.profile;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheet$configureGuildActions$$inlined$apply$lambda$3 */
/* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8782x6f508c56 extends AbstractC12240o implements Function1<View, Unit> {
    public final /* synthetic */ boolean $canManageEvents$inlined;
    public final /* synthetic */ long $guildId$inlined;
    public final /* synthetic */ ConstraintLayout $this_apply;
    public final /* synthetic */ WidgetGuildProfileSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8782x6f508c56(ConstraintLayout constraintLayout, WidgetGuildProfileSheet widgetGuildProfileSheet, boolean z2, long j) {
        super(1);
        this.$this_apply = constraintLayout;
        this.this$0 = widgetGuildProfileSheet;
        this.$canManageEvents$inlined = z2;
        this.$guildId$inlined = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        C12238m.checkNotNullParameter(view, "it");
        WidgetGuildScheduledEventLocationSelect.Companion companion = WidgetGuildScheduledEventLocationSelect.INSTANCE;
        Context context = this.$this_apply.getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        WidgetGuildScheduledEventLocationSelect.Companion.launch$default(companion, context, this.$guildId$inlined, null, 4, null);
    }
}
