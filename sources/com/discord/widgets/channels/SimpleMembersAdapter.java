package com.discord.widgets.channels;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.models.user.User;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: SimpleMembersAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SimpleMembersAdapter extends MGRecyclerAdapterSimple<SimpleMembersAdapter$MemberItem> {
    private Function1<? super User, Unit> onUserClickedListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleMembersAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
    }

    public static final /* synthetic */ Function1 access$getOnUserClickedListener$p(SimpleMembersAdapter simpleMembersAdapter) {
        return simpleMembersAdapter.onUserClickedListener;
    }

    public static final /* synthetic */ void access$setOnUserClickedListener$p(SimpleMembersAdapter simpleMembersAdapter, Function1 function1) {
        simpleMembersAdapter.onUserClickedListener = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setData(List<SimpleMembersAdapter$MemberItem> data, Function1<? super User, Unit> onUserClickedListener) {
        m.checkNotNullParameter(data, "data");
        m.checkNotNullParameter(onUserClickedListener, "onUserClickedListener");
        super.setData(data);
        this.onUserClickedListener = onUserClickedListener;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public SimpleMembersAdapter$MemberAdapterItem onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new SimpleMembersAdapter$MemberAdapterItem(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
