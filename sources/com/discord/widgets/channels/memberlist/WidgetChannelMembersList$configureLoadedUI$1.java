package com.discord.widgets.channels.memberlist;

import androidx.fragment.app.FragmentManager;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.discord.widgets.user.usersheet.WidgetUserSheet$Companion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelMembersList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelMembersList$configureLoadedUI$1 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ WidgetChannelMembersListViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ WidgetChannelMembersList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelMembersList$configureLoadedUI$1(WidgetChannelMembersList widgetChannelMembersList, WidgetChannelMembersListViewModel$ViewState$Loaded widgetChannelMembersListViewModel$ViewState$Loaded) {
        super(1);
        this.this$0 = widgetChannelMembersList;
        this.$viewState = widgetChannelMembersListViewModel$ViewState$Loaded;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.a;
    }

    public final void invoke(long j) {
        WidgetUserSheet$Companion widgetUserSheet$Companion = WidgetUserSheet.Companion;
        Long lValueOf = Long.valueOf(this.$viewState.getChannel().getId());
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetUserSheet$Companion.show$default(widgetUserSheet$Companion, j, lValueOf, parentFragmentManager, Long.valueOf(this.$viewState.getChannel().getGuildId()), null, null, null, 112, null);
    }
}
