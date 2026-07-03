package com.discord.widgets.guilds.profile;

import android.view.View;
import androidx.fragment.app.ViewKt;
import com.google.android.material.button.MaterialButton;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.guilds.profile.WidgetGuildProfileSheet$configureBottomActions$$inlined$apply$lambda$2 */
/* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8778xf99beb2f extends AbstractC12240o implements Function1<View, Unit> {
    public final /* synthetic */ long $guildId$inlined;
    public final /* synthetic */ boolean $showJoinServer$inlined;
    public final /* synthetic */ MaterialButton $this_apply;
    public final /* synthetic */ WidgetGuildProfileSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8778xf99beb2f(MaterialButton materialButton, WidgetGuildProfileSheet widgetGuildProfileSheet, boolean z2, long j) {
        super(1);
        this.$this_apply = materialButton;
        this.this$0 = widgetGuildProfileSheet;
        this.$showJoinServer$inlined = z2;
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
        WidgetGuildProfileSheetViewModel viewModel = this.this$0.getViewModel();
        long j = this.$guildId$inlined;
        MaterialButton materialButton = this.$this_apply;
        C12238m.checkNotNullExpressionValue(materialButton, "this");
        viewModel.onClickJoinServer(j, ViewKt.findFragment(materialButton));
    }
}
