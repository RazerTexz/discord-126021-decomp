package com.discord.widgets.channels.memberlist.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetChannelMembersListItemAddOrLeaveBinding;
import com.discord.databinding.WidgetChannelMembersListItemHeaderBinding;
import com.discord.databinding.WidgetChannelMembersListItemLoadingBinding;
import com.discord.databinding.WidgetChannelMembersListItemPlaceholderHeaderBinding;
import com.discord.databinding.WidgetChannelMembersListItemUserBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.utilities.views.StickyHeaderItemDecoration$StickyHeaderAdapter;
import com.discord.views.StatusView;
import com.discord.views.UsernameView;
import com.discord.widgets.channels.memberlist.WidgetChannelMembersListViewModel$MemberList;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: ChannelMembersListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelMembersListAdapter extends RecyclerView$Adapter<RecyclerView$ViewHolder> implements StickyHeaderItemDecoration$StickyHeaderAdapter {
    private WidgetChannelMembersListViewModel$MemberList memberList;
    private Function0<Unit> onAddMemberClicked;
    private Function0<Unit> onJoinLeaveThreadClicked;
    private Function1<? super Long, Unit> onUserClicked;
    private ChannelMembersListAdapter$StickyHeadersManager stickyHeadersManager;
    private final PublishSubject<ChannelMembersListAdapter$ListUpdateRequest> updatesSubject;
    private Subscription updatesSubscription;

    public ChannelMembersListAdapter() {
        PublishSubject<ChannelMembersListAdapter$ListUpdateRequest> publishSubjectK0 = PublishSubject.k0();
        this.updatesSubject = publishSubjectK0;
        WidgetChannelMembersListViewModel$MemberList empty = WidgetChannelMembersListViewModel$MemberList.Companion.getEMPTY();
        this.memberList = empty;
        ChannelMembersListAdapter$ListUpdateOperation$OverwriteUpdate channelMembersListAdapter$ListUpdateOperation$OverwriteUpdate = new ChannelMembersListAdapter$ListUpdateOperation$OverwriteUpdate(new ChannelMembersListAdapter$ListUpdateRequest("", empty, false));
        ChannelMembersListAdapter$1 channelMembersListAdapter$1 = ChannelMembersListAdapter$1.INSTANCE;
        m.checkNotNullExpressionValue(publishSubjectK0, "updatesSubject");
        Observable observableS = ObservableExtensionsKt.computationLatest(publishSubjectK0).Q(channelMembersListAdapter$ListUpdateOperation$OverwriteUpdate, ChannelMembersListAdapter$2.INSTANCE).S(1);
        m.checkNotNullExpressionValue(observableS, "updatesSubject\n        .…      })\n        .skip(1)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observableS), ChannelMembersListAdapter.class, (Context) null, new ChannelMembersListAdapter$4(this), (Function1) null, (Function0) null, (Function0) null, new ChannelMembersListAdapter$3(this), 58, (Object) null);
    }

    public static final /* synthetic */ WidgetChannelMembersListViewModel$MemberList access$getMemberList$p(ChannelMembersListAdapter channelMembersListAdapter) {
        return channelMembersListAdapter.memberList;
    }

    public static final /* synthetic */ Function0 access$getOnAddMemberClicked$p(ChannelMembersListAdapter channelMembersListAdapter) {
        return channelMembersListAdapter.onAddMemberClicked;
    }

    public static final /* synthetic */ Function0 access$getOnJoinLeaveThreadClicked$p(ChannelMembersListAdapter channelMembersListAdapter) {
        return channelMembersListAdapter.onJoinLeaveThreadClicked;
    }

    public static final /* synthetic */ Function1 access$getOnUserClicked$p(ChannelMembersListAdapter channelMembersListAdapter) {
        return channelMembersListAdapter.onUserClicked;
    }

    public static final /* synthetic */ ChannelMembersListAdapter$StickyHeadersManager access$getStickyHeadersManager$p(ChannelMembersListAdapter channelMembersListAdapter) {
        ChannelMembersListAdapter$StickyHeadersManager channelMembersListAdapter$StickyHeadersManager = channelMembersListAdapter.stickyHeadersManager;
        if (channelMembersListAdapter$StickyHeadersManager == null) {
            m.throwUninitializedPropertyAccessException("stickyHeadersManager");
        }
        return channelMembersListAdapter$StickyHeadersManager;
    }

    public static final /* synthetic */ Subscription access$getUpdatesSubscription$p(ChannelMembersListAdapter channelMembersListAdapter) {
        return channelMembersListAdapter.updatesSubscription;
    }

    public static final /* synthetic */ void access$setMemberList$p(ChannelMembersListAdapter channelMembersListAdapter, WidgetChannelMembersListViewModel$MemberList widgetChannelMembersListViewModel$MemberList) {
        channelMembersListAdapter.memberList = widgetChannelMembersListViewModel$MemberList;
    }

    public static final /* synthetic */ void access$setOnAddMemberClicked$p(ChannelMembersListAdapter channelMembersListAdapter, Function0 function0) {
        channelMembersListAdapter.onAddMemberClicked = function0;
    }

    public static final /* synthetic */ void access$setOnJoinLeaveThreadClicked$p(ChannelMembersListAdapter channelMembersListAdapter, Function0 function0) {
        channelMembersListAdapter.onJoinLeaveThreadClicked = function0;
    }

    public static final /* synthetic */ void access$setOnUserClicked$p(ChannelMembersListAdapter channelMembersListAdapter, Function1 function1) {
        channelMembersListAdapter.onUserClicked = function1;
    }

    public static final /* synthetic */ void access$setStickyHeadersManager$p(ChannelMembersListAdapter channelMembersListAdapter, ChannelMembersListAdapter$StickyHeadersManager channelMembersListAdapter$StickyHeadersManager) {
        channelMembersListAdapter.stickyHeadersManager = channelMembersListAdapter$StickyHeadersManager;
    }

    public static final /* synthetic */ void access$setUpdatesSubscription$p(ChannelMembersListAdapter channelMembersListAdapter, Subscription subscription) {
        channelMembersListAdapter.updatesSubscription = subscription;
    }

    public final Unit dispose() {
        Subscription subscription = this.updatesSubscription;
        if (subscription == null) {
            return null;
        }
        subscription.unsubscribe();
        return Unit.a;
    }

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration$StickyHeaderAdapter
    public View getAndBindHeaderView(int position) {
        ChannelMembersListAdapter$Item channelMembersListAdapter$Item = this.memberList.get(position);
        try {
            try {
                ChannelMembersListAdapter$StickyHeadersManager channelMembersListAdapter$StickyHeadersManager = this.stickyHeadersManager;
                if (channelMembersListAdapter$StickyHeadersManager == null) {
                    m.throwUninitializedPropertyAccessException("stickyHeadersManager");
                }
                channelMembersListAdapter$StickyHeadersManager.bindStickyHeaderView(channelMembersListAdapter$Item);
                ChannelMembersListAdapter$StickyHeadersManager channelMembersListAdapter$StickyHeadersManager2 = this.stickyHeadersManager;
                if (channelMembersListAdapter$StickyHeadersManager2 == null) {
                    m.throwUninitializedPropertyAccessException("stickyHeadersManager");
                }
                return channelMembersListAdapter$StickyHeadersManager2.getCurrentStickyHeaderView();
            } catch (ClassCastException unused) {
                Logger.e$default(AppLog.g, "Failed to cast header", null, null, 6, null);
                ChannelMembersListAdapter$StickyHeadersManager channelMembersListAdapter$StickyHeadersManager3 = this.stickyHeadersManager;
                if (channelMembersListAdapter$StickyHeadersManager3 == null) {
                    m.throwUninitializedPropertyAccessException("stickyHeadersManager");
                }
                return channelMembersListAdapter$StickyHeadersManager3.getCurrentStickyHeaderView();
            }
        } catch (Throwable unused2) {
            ChannelMembersListAdapter$StickyHeadersManager channelMembersListAdapter$StickyHeadersManager4 = this.stickyHeadersManager;
            if (channelMembersListAdapter$StickyHeadersManager4 == null) {
                m.throwUninitializedPropertyAccessException("stickyHeadersManager");
            }
            return channelMembersListAdapter$StickyHeadersManager4.getCurrentStickyHeaderView();
        }
    }

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration$StickyHeaderAdapter
    public Integer getHeaderPositionForItem(int itemPosition) {
        return this.memberList.getHeaderPositionForItem(itemPosition);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemCount() {
        return this.memberList.getSize();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public long getItemId(int position) {
        ChannelMembersListAdapter$Item channelMembersListAdapter$Item = this.memberList.get(position);
        if (channelMembersListAdapter$Item instanceof ChannelMembersListAdapter$Item$Member) {
            return ((ChannelMembersListAdapter$Item$Member) channelMembersListAdapter$Item).getUserId();
        }
        if (channelMembersListAdapter$Item instanceof ChannelMembersListAdapter$Item$RoleHeader) {
            return ((ChannelMembersListAdapter$Item$RoleHeader) channelMembersListAdapter$Item).getRoleId();
        }
        if ((channelMembersListAdapter$Item instanceof ChannelMembersListAdapter$Item$AddMember) || (channelMembersListAdapter$Item instanceof ChannelMembersListAdapter$Item$JoinLeaveThread)) {
            return -1L;
        }
        if (!(channelMembersListAdapter$Item instanceof ChannelMembersListAdapter$Item$Header)) {
            if (channelMembersListAdapter$Item instanceof ChannelMembersListAdapter$Item$PlaceholderHeader) {
                return -5L;
            }
            if (channelMembersListAdapter$Item instanceof ChannelMembersListAdapter$Item$PlaceholderMember) {
                return (-1) * ((long) (position + 6));
            }
            throw new NoWhenBranchMatchedException();
        }
        int iOrdinal = ((ChannelMembersListAdapter$Item$Header) channelMembersListAdapter$Item).getHeaderType().ordinal();
        if (iOrdinal == 0) {
            return -2L;
        }
        if (iOrdinal == 1) {
            return -3L;
        }
        if (iOrdinal == 2) {
            return -4L;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemViewType(int position) {
        return this.memberList.get(position).getType().ordinal();
    }

    @Override // com.discord.utilities.views.StickyHeaderItemDecoration$StickyHeaderAdapter
    public boolean isHeader(int position) {
        ChannelMembersListAdapter$Item channelMembersListAdapter$Item = this.memberList.get(position);
        return (channelMembersListAdapter$Item instanceof ChannelMembersListAdapter$Item$Header) || (channelMembersListAdapter$Item instanceof ChannelMembersListAdapter$Item$RoleHeader) || (channelMembersListAdapter$Item instanceof ChannelMembersListAdapter$Item$PlaceholderHeader);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        m.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        WidgetChannelMembersListItemHeaderBinding widgetChannelMembersListItemHeaderBindingA = WidgetChannelMembersListItemHeaderBinding.a(LayoutInflater.from(recyclerView.getContext()), recyclerView, false);
        m.checkNotNullExpressionValue(widgetChannelMembersListItemHeaderBindingA, "WidgetChannelMembersList…View,\n        false\n    )");
        WidgetChannelMembersListItemPlaceholderHeaderBinding widgetChannelMembersListItemPlaceholderHeaderBindingA = WidgetChannelMembersListItemPlaceholderHeaderBinding.a(LayoutInflater.from(recyclerView.getContext()), recyclerView, false);
        m.checkNotNullExpressionValue(widgetChannelMembersListItemPlaceholderHeaderBindingA, "WidgetChannelMembersList…View,\n        false\n    )");
        this.stickyHeadersManager = new ChannelMembersListAdapter$StickyHeadersManager(widgetChannelMembersListItemHeaderBindingA, widgetChannelMembersListItemPlaceholderHeaderBindingA);
        recyclerView.addOnLayoutChangeListener(new ChannelMembersListAdapter$onAttachedToRecyclerView$1(this, recyclerView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public void onBindViewHolder(RecyclerView$ViewHolder holder, int position) {
        m.checkNotNullParameter(holder, "holder");
        if (holder instanceof ChannelMembersListViewHolderHeader) {
            ChannelMembersListAdapter$Item channelMembersListAdapter$Item = this.memberList.get(position);
            Objects.requireNonNull(channelMembersListAdapter$Item, "null cannot be cast to non-null type com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter.Item.Header");
            ((ChannelMembersListViewHolderHeader) holder).bind((ChannelMembersListAdapter$Item$Header) channelMembersListAdapter$Item);
            return;
        }
        if (holder instanceof ChannelMembersListViewHolderMember) {
            ChannelMembersListAdapter$Item channelMembersListAdapter$Item2 = this.memberList.get(position);
            Objects.requireNonNull(channelMembersListAdapter$Item2, "null cannot be cast to non-null type com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter.Item.Member");
            ChannelMembersListAdapter$Item$Member channelMembersListAdapter$Item$Member = (ChannelMembersListAdapter$Item$Member) channelMembersListAdapter$Item2;
            ((ChannelMembersListViewHolderMember) holder).bind(channelMembersListAdapter$Item$Member, new ChannelMembersListAdapter$onBindViewHolder$1(this, channelMembersListAdapter$Item$Member));
            return;
        }
        if (holder instanceof ChannelMembersListViewHolderLoading) {
            ((ChannelMembersListViewHolderLoading) holder).bind(position);
            return;
        }
        if (holder instanceof ChannelMembersListViewHolderRoleHeader) {
            ChannelMembersListAdapter$Item channelMembersListAdapter$Item3 = this.memberList.get(position);
            Objects.requireNonNull(channelMembersListAdapter$Item3, "null cannot be cast to non-null type com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter.Item.RoleHeader");
            ((ChannelMembersListViewHolderRoleHeader) holder).bind((ChannelMembersListAdapter$Item$RoleHeader) channelMembersListAdapter$Item3);
        } else if (holder instanceof ChannelMembersListViewHolderAdd) {
            ChannelMembersListAdapter$Item channelMembersListAdapter$Item4 = this.memberList.get(position);
            Objects.requireNonNull(channelMembersListAdapter$Item4, "null cannot be cast to non-null type com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter.Item.AddMember");
            ((ChannelMembersListViewHolderAdd) holder).bind(new ChannelMembersListAdapter$onBindViewHolder$2(this), ((ChannelMembersListAdapter$Item$AddMember) channelMembersListAdapter$Item4).getTitle());
        } else if (holder instanceof ChannelMembersListViewHolderJoinLeaveThread) {
            ChannelMembersListAdapter$Item channelMembersListAdapter$Item5 = this.memberList.get(position);
            Objects.requireNonNull(channelMembersListAdapter$Item5, "null cannot be cast to non-null type com.discord.widgets.channels.memberlist.adapter.ChannelMembersListAdapter.Item.JoinLeaveThread");
            ((ChannelMembersListViewHolderJoinLeaveThread) holder).bind(new ChannelMembersListAdapter$onBindViewHolder$3(this), ((ChannelMembersListAdapter$Item$JoinLeaveThread) channelMembersListAdapter$Item5).isThreadJoined());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public RecyclerView$ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(parent.getContext());
        switch (ChannelMembersListAdapter$ViewType.Companion.fromOrdinal(viewType)) {
            case ROLE_HEADER:
                WidgetChannelMembersListItemHeaderBinding widgetChannelMembersListItemHeaderBindingA = WidgetChannelMembersListItemHeaderBinding.a(layoutInflaterFrom, parent, false);
                m.checkNotNullExpressionValue(widgetChannelMembersListItemHeaderBindingA, "WidgetChannelMembersList…(inflater, parent, false)");
                return new ChannelMembersListViewHolderRoleHeader(widgetChannelMembersListItemHeaderBindingA);
            case PLACEHOLDER_HEADER:
                WidgetChannelMembersListItemPlaceholderHeaderBinding widgetChannelMembersListItemPlaceholderHeaderBindingA = WidgetChannelMembersListItemPlaceholderHeaderBinding.a(layoutInflaterFrom, parent, false);
                m.checkNotNullExpressionValue(widgetChannelMembersListItemPlaceholderHeaderBindingA, "WidgetChannelMembersList…(inflater, parent, false)");
                return new ChannelMembersListViewHolderPlaceholderHeader(widgetChannelMembersListItemPlaceholderHeaderBindingA);
            case HEADER:
                WidgetChannelMembersListItemHeaderBinding widgetChannelMembersListItemHeaderBindingA2 = WidgetChannelMembersListItemHeaderBinding.a(layoutInflaterFrom, parent, false);
                m.checkNotNullExpressionValue(widgetChannelMembersListItemHeaderBindingA2, "WidgetChannelMembersList…(inflater, parent, false)");
                return new ChannelMembersListViewHolderHeader(widgetChannelMembersListItemHeaderBindingA2);
            case MEMBER:
                View viewInflate = layoutInflaterFrom.inflate(R$layout.widget_channel_members_list_item_user, parent, false);
                int i = R$id.channel_members_list_item_avatar;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R$id.channel_members_list_item_avatar);
                if (simpleDraweeView != null) {
                    i = R$id.channel_members_list_item_boosted_indicator;
                    ImageView imageView = (ImageView) viewInflate.findViewById(R$id.channel_members_list_item_boosted_indicator);
                    if (imageView != null) {
                        i = R$id.channel_members_list_item_game;
                        SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) viewInflate.findViewById(R$id.channel_members_list_item_game);
                        if (simpleDraweeSpanTextView != null) {
                            i = R$id.channel_members_list_item_group_owner_indicator;
                            ImageView imageView2 = (ImageView) viewInflate.findViewById(R$id.channel_members_list_item_group_owner_indicator);
                            if (imageView2 != null) {
                                i = R$id.channel_members_list_item_name;
                                UsernameView usernameView = (UsernameView) viewInflate.findViewById(R$id.channel_members_list_item_name);
                                if (usernameView != null) {
                                    i = R$id.channel_members_list_item_presence;
                                    StatusView statusView = (StatusView) viewInflate.findViewById(R$id.channel_members_list_item_presence);
                                    if (statusView != null) {
                                        i = R$id.channel_members_list_item_rich_presence_iv;
                                        ImageView imageView3 = (ImageView) viewInflate.findViewById(R$id.channel_members_list_item_rich_presence_iv);
                                        if (imageView3 != null) {
                                            WidgetChannelMembersListItemUserBinding widgetChannelMembersListItemUserBinding = new WidgetChannelMembersListItemUserBinding((ConstraintLayout) viewInflate, simpleDraweeView, imageView, simpleDraweeSpanTextView, imageView2, usernameView, statusView, imageView3);
                                            m.checkNotNullExpressionValue(widgetChannelMembersListItemUserBinding, "WidgetChannelMembersList…(inflater, parent, false)");
                                            return new ChannelMembersListViewHolderMember(widgetChannelMembersListItemUserBinding);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
            case ADD_MEMBER:
                WidgetChannelMembersListItemAddOrLeaveBinding widgetChannelMembersListItemAddOrLeaveBindingA = WidgetChannelMembersListItemAddOrLeaveBinding.a(layoutInflaterFrom, parent, false);
                m.checkNotNullExpressionValue(widgetChannelMembersListItemAddOrLeaveBindingA, "WidgetChannelMembersList…(inflater, parent, false)");
                return new ChannelMembersListViewHolderAdd(widgetChannelMembersListItemAddOrLeaveBindingA);
            case LOADING:
                View viewInflate2 = layoutInflaterFrom.inflate(R$layout.widget_channel_members_list_item_loading, parent, false);
                int i2 = R$id.blank_item_avatar_placeholder;
                View viewFindViewById = viewInflate2.findViewById(R$id.blank_item_avatar_placeholder);
                if (viewFindViewById != null) {
                    i2 = R$id.blank_item_username_placeholder;
                    View viewFindViewById2 = viewInflate2.findViewById(R$id.blank_item_username_placeholder);
                    if (viewFindViewById2 != null) {
                        i2 = R$id.username_placeholder_end_guideline;
                        Guideline guideline = (Guideline) viewInflate2.findViewById(R$id.username_placeholder_end_guideline);
                        if (guideline != null) {
                            WidgetChannelMembersListItemLoadingBinding widgetChannelMembersListItemLoadingBinding = new WidgetChannelMembersListItemLoadingBinding((ConstraintLayout) viewInflate2, viewFindViewById, viewFindViewById2, guideline);
                            m.checkNotNullExpressionValue(widgetChannelMembersListItemLoadingBinding, "WidgetChannelMembersList…(inflater, parent, false)");
                            return new ChannelMembersListViewHolderLoading(widgetChannelMembersListItemLoadingBinding);
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i2)));
            case JOIN_LEAVE_THREAD:
                WidgetChannelMembersListItemAddOrLeaveBinding widgetChannelMembersListItemAddOrLeaveBindingA2 = WidgetChannelMembersListItemAddOrLeaveBinding.a(layoutInflaterFrom, parent, false);
                m.checkNotNullExpressionValue(widgetChannelMembersListItemAddOrLeaveBindingA2, "WidgetChannelMembersList…(inflater, parent, false)");
                return new ChannelMembersListViewHolderJoinLeaveThread(widgetChannelMembersListItemAddOrLeaveBindingA2);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final void setData(String listId, WidgetChannelMembersListViewModel$MemberList rows, boolean forceOverwrite) {
        m.checkNotNullParameter(listId, "listId");
        m.checkNotNullParameter(rows, "rows");
        PublishSubject<ChannelMembersListAdapter$ListUpdateRequest> publishSubject = this.updatesSubject;
        publishSubject.k.onNext(new ChannelMembersListAdapter$ListUpdateRequest(listId, rows, forceOverwrite));
    }

    public final void setOnAddMemberClicked(Function0<Unit> addMember) {
        m.checkNotNullParameter(addMember, "addMember");
        this.onAddMemberClicked = addMember;
    }

    public final void setOnJoinLeaveThreadClicked(Function0<Unit> joinLeaveThread) {
        m.checkNotNullParameter(joinLeaveThread, "joinLeaveThread");
        this.onJoinLeaveThreadClicked = joinLeaveThread;
    }

    public final void setOnUserClicked(Function1<? super Long, Unit> onUserClicked) {
        this.onUserClicked = onUserClicked;
    }
}
