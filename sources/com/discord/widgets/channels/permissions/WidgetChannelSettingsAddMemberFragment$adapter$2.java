package com.discord.widgets.channels.permissions;

import androidx.recyclerview.widget.RecyclerView;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsAddMemberFragment$adapter$2 extends AbstractC12240o implements Function0<AddMemberAdapter> {
    public final /* synthetic */ WidgetChannelSettingsAddMemberFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsAddMemberFragment$adapter$2(WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment) {
        super(0);
        this.this$0 = widgetChannelSettingsAddMemberFragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AddMemberAdapter invoke() {
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = this.this$0.getBinding().f15896b;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.recycler");
        return (AddMemberAdapter) companion.configure(new AddMemberAdapter(recyclerView));
    }
}
