package com.discord.widgets.servers.settings.invites;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.models.domain.ModelInvite;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetServerSettingsInstantInvites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsInstantInvites$Adapter extends MGRecyclerAdapterSimple<WidgetServerSettingsInstantInvites$Model$InviteItem> {
    private Function1<? super ModelInvite, Unit> onInviteExpiredListener;
    private Function1<? super ModelInvite, Unit> onInviteSelectedListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsInstantInvites$Adapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        this.onInviteSelectedListener = WidgetServerSettingsInstantInvites$Adapter$onInviteSelectedListener$1.INSTANCE;
        this.onInviteExpiredListener = WidgetServerSettingsInstantInvites$Adapter$onInviteExpiredListener$1.INSTANCE;
    }

    public final void configure(List<WidgetServerSettingsInstantInvites$Model$InviteItem> data, Function1<? super ModelInvite, Unit> onInviteSelectedListener, Function1<? super ModelInvite, Unit> onInviteExpiredListener) {
        m.checkNotNullParameter(data, "data");
        m.checkNotNullParameter(onInviteSelectedListener, "onInviteSelectedListener");
        m.checkNotNullParameter(onInviteExpiredListener, "onInviteExpiredListener");
        this.onInviteSelectedListener = onInviteSelectedListener;
        this.onInviteExpiredListener = onInviteExpiredListener;
        setData(data);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void onInviteExpired(ModelInvite invite) {
        m.checkNotNullParameter(invite, "invite");
        this.onInviteExpiredListener.invoke(invite);
    }

    public final void onInviteSelected(ModelInvite invite) {
        m.checkNotNullParameter(invite, "invite");
        this.onInviteSelectedListener.invoke(invite);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<?, WidgetServerSettingsInstantInvites$Model$InviteItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new WidgetServerSettingsInstantInvitesListItem(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
