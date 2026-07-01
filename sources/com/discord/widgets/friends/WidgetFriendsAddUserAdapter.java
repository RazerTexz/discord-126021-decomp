package com.discord.widgets.friends;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import d0.z.d.m;
import java.util.Collection;
import java.util.HashSet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetFriendsAddUserAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsAddUserAdapter extends MGRecyclerAdapterSimple<WidgetFriendsAddUserAdapter$ItemUser> {
    public static final WidgetFriendsAddUserAdapter$Companion Companion = new WidgetFriendsAddUserAdapter$Companion(null);
    private static final int TYPE_USER = 1;
    private Function1<? super Long, Unit> acceptHandler;
    private Function2<? super Long, ? super Boolean, Unit> declineHandler;
    private final HashSet<Long> incomingRequestUserIds;
    private Function1<? super Long, Unit> onItemClick;
    private final HashSet<Long> outgoingRequestUserIds;
    private Function2<? super String, ? super Integer, Unit> sendHandler;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsAddUserAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        this.outgoingRequestUserIds = new HashSet<>();
        this.incomingRequestUserIds = new HashSet<>();
        this.onItemClick = WidgetFriendsAddUserAdapter$onItemClick$1.INSTANCE;
    }

    public static final /* synthetic */ Function1 access$getAcceptHandler$p(WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter) {
        return widgetFriendsAddUserAdapter.acceptHandler;
    }

    public static final /* synthetic */ Function2 access$getDeclineHandler$p(WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter) {
        return widgetFriendsAddUserAdapter.declineHandler;
    }

    public static final /* synthetic */ HashSet access$getIncomingRequestUserIds$p(WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter) {
        return widgetFriendsAddUserAdapter.incomingRequestUserIds;
    }

    public static final /* synthetic */ Function1 access$getOnItemClick$p(WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter) {
        return widgetFriendsAddUserAdapter.onItemClick;
    }

    public static final /* synthetic */ HashSet access$getOutgoingRequestUserIds$p(WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter) {
        return widgetFriendsAddUserAdapter.outgoingRequestUserIds;
    }

    public static final /* synthetic */ Function2 access$getSendHandler$p(WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter) {
        return widgetFriendsAddUserAdapter.sendHandler;
    }

    public static final /* synthetic */ void access$setAcceptHandler$p(WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter, Function1 function1) {
        widgetFriendsAddUserAdapter.acceptHandler = function1;
    }

    public static final /* synthetic */ void access$setDeclineHandler$p(WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter, Function2 function2) {
        widgetFriendsAddUserAdapter.declineHandler = function2;
    }

    public static final /* synthetic */ void access$setOnItemClick$p(WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter, Function1 function1) {
        widgetFriendsAddUserAdapter.onItemClick = function1;
    }

    public static final /* synthetic */ void access$setSendHandler$p(WidgetFriendsAddUserAdapter widgetFriendsAddUserAdapter, Function2 function2) {
        widgetFriendsAddUserAdapter.sendHandler = function2;
    }

    public final void addFriendRequestUserIds(Collection<Long> outgoingIds, Collection<Long> incomingIds) {
        m.checkNotNullParameter(outgoingIds, "outgoingIds");
        m.checkNotNullParameter(incomingIds, "incomingIds");
        this.outgoingRequestUserIds.clear();
        this.outgoingRequestUserIds.addAll(outgoingIds);
        this.incomingRequestUserIds.clear();
        this.incomingRequestUserIds.addAll(incomingIds);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setAcceptHandler(Function1<? super Long, Unit> handler) {
        m.checkNotNullParameter(handler, "handler");
        this.acceptHandler = handler;
    }

    public final void setDeclineHandler(Function2<? super Long, ? super Boolean, Unit> handler) {
        m.checkNotNullParameter(handler, "handler");
        this.declineHandler = handler;
    }

    public final void setOnItemClick(Function1<? super Long, Unit> onItemClick) {
        m.checkNotNullParameter(onItemClick, "onItemClick");
        this.onItemClick = onItemClick;
    }

    public final void setSendHandler(Function2<? super String, ? super Integer, Unit> handler) {
        m.checkNotNullParameter(handler, "handler");
        this.sendHandler = handler;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public WidgetFriendsAddUserAdapter$UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            return new WidgetFriendsAddUserAdapter$UserViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
