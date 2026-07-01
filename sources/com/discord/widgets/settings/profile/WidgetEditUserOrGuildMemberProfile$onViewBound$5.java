package com.discord.widgets.settings.profile;

import androidx.fragment.app.FragmentManager;
import com.discord.widgets.user.Badge;
import com.discord.widgets.user.Badge$Companion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEditUserOrGuildMemberProfile$onViewBound$5 extends o implements Function1<Badge, Unit> {
    public final /* synthetic */ WidgetEditUserOrGuildMemberProfile this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEditUserOrGuildMemberProfile$onViewBound$5(WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile) {
        super(1);
        this.this$0 = widgetEditUserOrGuildMemberProfile;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Badge badge) {
        invoke2(badge);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Badge badge) {
        m.checkNotNullParameter(badge, "it");
        Badge$Companion badge$Companion = Badge.Companion;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        badge$Companion.onBadgeClick(parentFragmentManager, this.this$0.requireContext());
    }
}
