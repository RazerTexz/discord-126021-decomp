package com.discord.widgets.guilds.profile;

import android.view.View;
import androidx.fragment.app.ViewKt;
import com.google.android.material.button.MaterialButton;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildProfileSheet$configureBottomActions$$inlined$apply$lambda$2 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ long $guildId$inlined;
    public final /* synthetic */ boolean $showJoinServer$inlined;
    public final /* synthetic */ MaterialButton $this_apply;
    public final /* synthetic */ WidgetGuildProfileSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildProfileSheet$configureBottomActions$$inlined$apply$lambda$2(MaterialButton materialButton, WidgetGuildProfileSheet widgetGuildProfileSheet, boolean z2, long j) {
        super(1);
        this.$this_apply = materialButton;
        this.this$0 = widgetGuildProfileSheet;
        this.$showJoinServer$inlined = z2;
        this.$guildId$inlined = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
        WidgetGuildProfileSheetViewModel viewModel = this.this$0.getViewModel();
        long j = this.$guildId$inlined;
        MaterialButton materialButton = this.$this_apply;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "this");
        viewModel.onClickJoinServer(j, ViewKt.findFragment(materialButton));
    }
}
