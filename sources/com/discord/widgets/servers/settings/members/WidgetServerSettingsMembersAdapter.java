package com.discord.widgets.servers.settings.members;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetServerSettingsMembersAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsMembersAdapter extends MGRecyclerAdapterSimple<WidgetServerSettingsMembersModel$MemberItem> {
    private Function2<? super Long, ? super List<Long>, Unit> memberSelectedListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsMembersAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        this.memberSelectedListener = WidgetServerSettingsMembersAdapter$memberSelectedListener$1.INSTANCE;
    }

    public static final /* synthetic */ Function2 access$getMemberSelectedListener$p(WidgetServerSettingsMembersAdapter widgetServerSettingsMembersAdapter) {
        return widgetServerSettingsMembersAdapter.memberSelectedListener;
    }

    public static final /* synthetic */ void access$setMemberSelectedListener$p(WidgetServerSettingsMembersAdapter widgetServerSettingsMembersAdapter, Function2 function2) {
        widgetServerSettingsMembersAdapter.memberSelectedListener = function2;
    }

    public final void configure(WidgetServerSettingsMembersModel model, Function2<? super Long, ? super List<Long>, Unit> memberSelectedListener) {
        m.checkNotNullParameter(model, "model");
        m.checkNotNullParameter(memberSelectedListener, "memberSelectedListener");
        this.memberSelectedListener = memberSelectedListener;
        setData(model.getMemberItems());
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public WidgetServerSettingsMembersAdapter$MemberListItem onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            return new WidgetServerSettingsMembersAdapter$MemberListItem(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
