package com.discord.widgets.friends;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetFriendsListAdapterItemFriendBinding;
import com.discord.databinding.WidgetFriendsListAdapterItemHeaderBinding;
import com.discord.databinding.WidgetFriendsListAdapterItemPendingBinding;
import com.discord.databinding.WidgetFriendsListAdapterSuggestedFriendBinding;
import com.discord.databinding.WidgetFriendsListContactSyncUpsellBinding;
import com.discord.databinding.WidgetFriendsListExpandableHeaderBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.views.StatusView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.card.MaterialCardView;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p027k.C1107b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetFriendsListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetFriendsListAdapter extends MGRecyclerAdapterSimple<FriendsListViewModel.Item> {
    private Function1<? super User, Unit> onClickAcceptFriend;
    private Function1<? super User, Unit> onClickApproveSuggestion;
    private Function1<? super User, Unit> onClickCall;
    private Function1<? super User, Unit> onClickChat;
    private Function0<Unit> onClickContactSyncUpsell;
    private Function1<? super View, Unit> onClickContactSyncUpsellLongClick;
    private Function2<? super User, ? super Integer, Unit> onClickDeclineFriend;
    private Function0<Unit> onClickPendingHeaderExpand;
    private Function1<? super Long, Unit> onClickRemoveSuggestion;
    private Function0<Unit> onClickSuggestedHeaderExpandCollapse;
    private Function2<? super View, ? super User, Unit> onClickUserProfile;

    /* JADX INFO: compiled from: WidgetFriendsListAdapter.kt */
    public static abstract class Item extends MGRecyclerViewHolder<WidgetFriendsListAdapter, FriendsListViewModel.Item> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Item(@LayoutRes int i, WidgetFriendsListAdapter widgetFriendsListAdapter) {
            super(i, widgetFriendsListAdapter);
            C12238m.checkNotNullParameter(widgetFriendsListAdapter, "adapter");
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Item(View view, WidgetFriendsListAdapter widgetFriendsListAdapter) {
            super(view, widgetFriendsListAdapter);
            C12238m.checkNotNullParameter(view, "view");
            C12238m.checkNotNullParameter(widgetFriendsListAdapter, "adapter");
        }
    }

    /* JADX INFO: compiled from: WidgetFriendsListAdapter.kt */
    public static final class ItemContactSyncUpsell extends Item {
        private final WidgetFriendsListContactSyncUpsellBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemContactSyncUpsell(WidgetFriendsListAdapter widgetFriendsListAdapter) {
            super(C5419R.layout.widget_friends_list_contact_sync_upsell, widgetFriendsListAdapter);
            C12238m.checkNotNullParameter(widgetFriendsListAdapter, "adapter");
            View view = this.itemView;
            int i = C5419R.id.friends_list_contact_sync_upsell_arrow;
            ImageView imageView = (ImageView) view.findViewById(C5419R.id.friends_list_contact_sync_upsell_arrow);
            if (imageView != null) {
                MaterialCardView materialCardView = (MaterialCardView) view;
                i = C5419R.id.friends_list_contact_sync_upsell_icon;
                ImageView imageView2 = (ImageView) view.findViewById(C5419R.id.friends_list_contact_sync_upsell_icon);
                if (imageView2 != null) {
                    i = C5419R.id.friends_list_contact_sync_upsell_subtitle;
                    TextView textView = (TextView) view.findViewById(C5419R.id.friends_list_contact_sync_upsell_subtitle);
                    if (textView != null) {
                        i = C5419R.id.friends_list_contact_sync_upsell_title;
                        TextView textView2 = (TextView) view.findViewById(C5419R.id.friends_list_contact_sync_upsell_title);
                        if (textView2 != null) {
                            WidgetFriendsListContactSyncUpsellBinding widgetFriendsListContactSyncUpsellBinding = new WidgetFriendsListContactSyncUpsellBinding(materialCardView, imageView, materialCardView, imageView2, textView, textView2);
                            C12238m.checkNotNullExpressionValue(widgetFriendsListContactSyncUpsellBinding, "WidgetFriendsListContact…ellBinding.bind(itemView)");
                            this.binding = widgetFriendsListContactSyncUpsellBinding;
                            return;
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ WidgetFriendsListAdapter access$getAdapter$p(ItemContactSyncUpsell itemContactSyncUpsell) {
            return (WidgetFriendsListAdapter) itemContactSyncUpsell.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, FriendsListViewModel.Item data) {
            C12238m.checkNotNullParameter(data, "data");
            this.binding.f16682b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.friends.WidgetFriendsListAdapter$ItemContactSyncUpsell$onConfigure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetFriendsListAdapter.ItemContactSyncUpsell.access$getAdapter$p(this.this$0).getOnClickContactSyncUpsell().invoke();
                }
            });
            this.binding.f16682b.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.discord.widgets.friends.WidgetFriendsListAdapter$ItemContactSyncUpsell$onConfigure$2
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    Function1<View, Unit> onClickContactSyncUpsellLongClick = WidgetFriendsListAdapter.ItemContactSyncUpsell.access$getAdapter$p(this.this$0).getOnClickContactSyncUpsellLongClick();
                    C12238m.checkNotNullExpressionValue(view, "it");
                    onClickContactSyncUpsellLongClick.invoke(view);
                    return true;
                }
            });
        }
    }

    /* JADX INFO: compiled from: WidgetFriendsListAdapter.kt */
    public static final class ItemHeader extends Item {
        private final WidgetFriendsListAdapterItemHeaderBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemHeader(WidgetFriendsListAdapter widgetFriendsListAdapter) {
            super(C5419R.layout.widget_friends_list_adapter_item_header, widgetFriendsListAdapter);
            C12238m.checkNotNullParameter(widgetFriendsListAdapter, "adapter");
            View view = this.itemView;
            TextView textView = (TextView) view.findViewById(C5419R.id.friends_list_item_header_text);
            if (textView == null) {
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.friends_list_item_header_text)));
            }
            WidgetFriendsListAdapterItemHeaderBinding widgetFriendsListAdapterItemHeaderBinding = new WidgetFriendsListAdapterItemHeaderBinding((FrameLayout) view, textView);
            C12238m.checkNotNullExpressionValue(widgetFriendsListAdapterItemHeaderBinding, "WidgetFriendsListAdapter…derBinding.bind(itemView)");
            this.binding = widgetFriendsListAdapterItemHeaderBinding;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, FriendsListViewModel.Item data) {
            C12238m.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            FriendsListViewModel.Item.Header header = (FriendsListViewModel.Item.Header) data;
            TextView textView = this.binding.f16665b;
            C12238m.checkNotNullExpressionValue(textView, "binding.friendsListItemHeaderText");
            C1107b.m221m(textView, header.getTitleStringResId(), new Object[]{Integer.valueOf(header.getCount())}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        }
    }

    /* JADX INFO: compiled from: WidgetFriendsListAdapter.kt */
    public static final class ItemPendingHeader extends Item {
        private final WidgetFriendsListExpandableHeaderBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemPendingHeader(WidgetFriendsListAdapter widgetFriendsListAdapter) {
            super(C5419R.layout.widget_friends_list_expandable_header, widgetFriendsListAdapter);
            C12238m.checkNotNullParameter(widgetFriendsListAdapter, "adapter");
            WidgetFriendsListExpandableHeaderBinding widgetFriendsListExpandableHeaderBindingM8415a = WidgetFriendsListExpandableHeaderBinding.m8415a(this.itemView);
            C12238m.checkNotNullExpressionValue(widgetFriendsListExpandableHeaderBindingM8415a, "WidgetFriendsListExpanda…derBinding.bind(itemView)");
            this.binding = widgetFriendsListExpandableHeaderBindingM8415a;
        }

        public static final /* synthetic */ WidgetFriendsListAdapter access$getAdapter$p(ItemPendingHeader itemPendingHeader) {
            return (WidgetFriendsListAdapter) itemPendingHeader.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, FriendsListViewModel.Item data) {
            C12238m.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            FriendsListViewModel.Item.PendingHeader pendingHeader = (FriendsListViewModel.Item.PendingHeader) data;
            TextView textView = this.binding.f16685c;
            C12238m.checkNotNullExpressionValue(textView, "binding.friendsListPendingItemHeaderText");
            C1107b.m221m(textView, pendingHeader.getTitleStringResId(), new Object[]{Integer.valueOf(pendingHeader.getCount())}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
            if (!pendingHeader.getShowExpandButton()) {
                TextView textView2 = this.binding.f16684b;
                C12238m.checkNotNullExpressionValue(textView2, "binding.friendsListExpandableHeaderButton");
                textView2.setVisibility(8);
                return;
            }
            TextView textView3 = this.binding.f16684b;
            C12238m.checkNotNullExpressionValue(textView3, "binding.friendsListExpandableHeaderButton");
            textView3.setVisibility(0);
            int i = pendingHeader.isPendingSectionExpanded() ? C5419R.string.friends_pending_request_expand_collapse : C5419R.string.friends_pending_request_expand;
            TextView textView4 = this.binding.f16684b;
            C12238m.checkNotNullExpressionValue(textView4, "binding.friendsListExpandableHeaderButton");
            C1107b.m221m(textView4, i, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
            int i2 = pendingHeader.isPendingSectionExpanded() ? C5419R.drawable.ic_arrow_up_24dp : C5419R.drawable.ic_arrow_right_24dp;
            TextView textView5 = this.binding.f16684b;
            C12238m.checkNotNullExpressionValue(textView5, "binding.friendsListExpandableHeaderButton");
            Drawable drawable = ContextCompat.getDrawable(textView5.getContext(), i2);
            TextView textView6 = this.binding.f16684b;
            C12238m.checkNotNullExpressionValue(textView6, "binding.friendsListExpandableHeaderButton");
            DrawableCompat.setCompoundDrawablesCompat$default(textView6, (Drawable) null, (Drawable) null, drawable, (Drawable) null, 11, (Object) null);
            this.binding.f16684b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.friends.WidgetFriendsListAdapter$ItemPendingHeader$onConfigure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetFriendsListAdapter.ItemPendingHeader.access$getAdapter$p(this.this$0).getOnClickPendingHeaderExpand().invoke();
                }
            });
        }
    }

    /* JADX INFO: compiled from: WidgetFriendsListAdapter.kt */
    public static final class ItemPendingUser extends Item {
        private final WidgetFriendsListAdapterItemPendingBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemPendingUser(WidgetFriendsListAdapter widgetFriendsListAdapter) {
            super(C5419R.layout.widget_friends_list_adapter_item_pending, widgetFriendsListAdapter);
            C12238m.checkNotNullParameter(widgetFriendsListAdapter, "adapter");
            View view = this.itemView;
            int i = C5419R.id.friends_list_item_accept_button;
            AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(C5419R.id.friends_list_item_accept_button);
            if (appCompatImageView != null) {
                i = C5419R.id.friends_list_item_activity;
                SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) view.findViewById(C5419R.id.friends_list_item_activity);
                if (simpleDraweeSpanTextView != null) {
                    i = C5419R.id.friends_list_item_avatar;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.friends_list_item_avatar);
                    if (simpleDraweeView != null) {
                        i = C5419R.id.friends_list_item_buttons_wrap;
                        LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.friends_list_item_buttons_wrap);
                        if (linearLayout != null) {
                            i = C5419R.id.friends_list_item_decline_button;
                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) view.findViewById(C5419R.id.friends_list_item_decline_button);
                            if (appCompatImageView2 != null) {
                                i = C5419R.id.friends_list_item_name;
                                TextView textView = (TextView) view.findViewById(C5419R.id.friends_list_item_name);
                                if (textView != null) {
                                    i = C5419R.id.friends_list_item_status;
                                    StatusView statusView = (StatusView) view.findViewById(C5419R.id.friends_list_item_status);
                                    if (statusView != null) {
                                        i = C5419R.id.friends_list_item_text;
                                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(C5419R.id.friends_list_item_text);
                                        if (linearLayout2 != null) {
                                            WidgetFriendsListAdapterItemPendingBinding widgetFriendsListAdapterItemPendingBinding = new WidgetFriendsListAdapterItemPendingBinding((RelativeLayout) view, appCompatImageView, simpleDraweeSpanTextView, simpleDraweeView, linearLayout, appCompatImageView2, textView, statusView, linearLayout2);
                                            C12238m.checkNotNullExpressionValue(widgetFriendsListAdapterItemPendingBinding, "WidgetFriendsListAdapter…ingBinding.bind(itemView)");
                                            this.binding = widgetFriendsListAdapterItemPendingBinding;
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ WidgetFriendsListAdapter access$getAdapter$p(ItemPendingUser itemPendingUser) {
            return (WidgetFriendsListAdapter) itemPendingUser.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, final FriendsListViewModel.Item data) {
            C12238m.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            final FriendsListViewModel.Item.PendingFriendRequest pendingFriendRequest = (FriendsListViewModel.Item.PendingFriendRequest) data;
            this.binding.f16667a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.friends.WidgetFriendsListAdapter$ItemPendingUser$onConfigure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Function2<View, User, Unit> onClickUserProfile = WidgetFriendsListAdapter.ItemPendingUser.access$getAdapter$p(this.this$0).getOnClickUserProfile();
                    C12238m.checkNotNullExpressionValue(view, "view");
                    onClickUserProfile.invoke(view, ((FriendsListViewModel.Item.PendingFriendRequest) data).getUser());
                }
            });
            TextView textView = this.binding.f16672f;
            C12238m.checkNotNullExpressionValue(textView, "binding.friendsListItemName");
            textView.setText(pendingFriendRequest.getUser().getUsername());
            this.binding.f16673g.setPresence(pendingFriendRequest.getPresence());
            int relationshipType = pendingFriendRequest.getRelationshipType();
            if (relationshipType == 3) {
                SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.f16669c;
                C12238m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.friendsListItemActivity");
                SimpleDraweeSpanTextView simpleDraweeSpanTextView2 = this.binding.f16669c;
                C12238m.checkNotNullExpressionValue(simpleDraweeSpanTextView2, "binding.friendsListItemActivity");
                ViewExtensions.setTextAndVisibilityBy(simpleDraweeSpanTextView, C1107b.m212d(simpleDraweeSpanTextView2, C5419R.string.incoming_friend_request, new Object[0], (4 & 4) != 0 ? C1107b.c.f1492j : null));
                AppCompatImageView appCompatImageView = this.binding.f16668b;
                C12238m.checkNotNullExpressionValue(appCompatImageView, "binding.friendsListItemAcceptButton");
                appCompatImageView.setVisibility(0);
            } else if (relationshipType == 4) {
                SimpleDraweeSpanTextView simpleDraweeSpanTextView3 = this.binding.f16669c;
                C12238m.checkNotNullExpressionValue(simpleDraweeSpanTextView3, "binding.friendsListItemActivity");
                SimpleDraweeSpanTextView simpleDraweeSpanTextView4 = this.binding.f16669c;
                C12238m.checkNotNullExpressionValue(simpleDraweeSpanTextView4, "binding.friendsListItemActivity");
                ViewExtensions.setTextAndVisibilityBy(simpleDraweeSpanTextView3, C1107b.m212d(simpleDraweeSpanTextView4, C5419R.string.outgoing_friend_request, new Object[0], (4 & 4) != 0 ? C1107b.c.f1492j : null));
                AppCompatImageView appCompatImageView2 = this.binding.f16668b;
                C12238m.checkNotNullExpressionValue(appCompatImageView2, "binding.friendsListItemAcceptButton");
                appCompatImageView2.setVisibility(8);
            }
            SimpleDraweeView simpleDraweeView = this.binding.f16670d;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.friendsListItemAvatar");
            IconUtils.setIcon$default(simpleDraweeView, pendingFriendRequest.getUser(), C5419R.dimen.avatar_size_standard, null, null, null, 56, null);
            this.binding.f16668b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.friends.WidgetFriendsListAdapter$ItemPendingUser$onConfigure$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetFriendsListAdapter.ItemPendingUser.access$getAdapter$p(this.this$0).getOnClickAcceptFriend().invoke(pendingFriendRequest.getUser());
                }
            });
            this.binding.f16671e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.friends.WidgetFriendsListAdapter$ItemPendingUser$onConfigure$3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetFriendsListAdapter.ItemPendingUser.access$getAdapter$p(this.this$0).getOnClickDeclineFriend().invoke(pendingFriendRequest.getUser(), Integer.valueOf(pendingFriendRequest.getRelationshipType()));
                }
            });
        }
    }

    /* JADX INFO: compiled from: WidgetFriendsListAdapter.kt */
    public static final class ItemSuggestedFriend extends Item {
        private final WidgetFriendsListAdapterSuggestedFriendBinding viewBinding;

        /* JADX WARN: Illegal instructions before constructor call */
        public ItemSuggestedFriend(WidgetFriendsListAdapterSuggestedFriendBinding widgetFriendsListAdapterSuggestedFriendBinding, WidgetFriendsListAdapter widgetFriendsListAdapter) {
            C12238m.checkNotNullParameter(widgetFriendsListAdapterSuggestedFriendBinding, "viewBinding");
            C12238m.checkNotNullParameter(widgetFriendsListAdapter, "adapter");
            SuggestedFriendView suggestedFriendView = widgetFriendsListAdapterSuggestedFriendBinding.f16674a;
            C12238m.checkNotNullExpressionValue(suggestedFriendView, "viewBinding.root");
            super(suggestedFriendView, widgetFriendsListAdapter);
            this.viewBinding = widgetFriendsListAdapterSuggestedFriendBinding;
        }

        public static final /* synthetic */ WidgetFriendsListAdapter access$getAdapter$p(ItemSuggestedFriend itemSuggestedFriend) {
            return (WidgetFriendsListAdapter) itemSuggestedFriend.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, final FriendsListViewModel.Item data) {
            C12238m.checkNotNullParameter(data, "data");
            FriendsListViewModel.Item.SuggestedFriend suggestedFriend = (FriendsListViewModel.Item.SuggestedFriend) data;
            this.viewBinding.f16674a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.friends.WidgetFriendsListAdapter$ItemSuggestedFriend$onConfigure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Function2<View, User, Unit> onClickUserProfile = WidgetFriendsListAdapter.ItemSuggestedFriend.access$getAdapter$p(this.this$0).getOnClickUserProfile();
                    C12238m.checkNotNullExpressionValue(view, "view");
                    onClickUserProfile.invoke(view, ((FriendsListViewModel.Item.SuggestedFriend) data).getSuggestion().getUser());
                }
            });
            this.viewBinding.f16675b.setAvatarUrl(suggestedFriend.getSuggestion().getUser().getId(), Integer.valueOf(suggestedFriend.getSuggestion().getUser().getDiscriminator()), suggestedFriend.getSuggestion().getUser().getAvatar());
            this.viewBinding.f16675b.setUsername(suggestedFriend.getSuggestion().getUser().getUsername());
            this.viewBinding.f16675b.setPublicName(suggestedFriend.getSuggestion().getPublicName());
            this.viewBinding.f16675b.setOnSendClicked(new WidgetFriendsListAdapter$ItemSuggestedFriend$onConfigure$2(this, data));
            this.viewBinding.f16675b.setOnDeclineClicked(new WidgetFriendsListAdapter$ItemSuggestedFriend$onConfigure$3(this, data));
        }
    }

    /* JADX INFO: compiled from: WidgetFriendsListAdapter.kt */
    public static final class ItemSuggestedFriendHeader extends Item {
        private final WidgetFriendsListExpandableHeaderBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemSuggestedFriendHeader(WidgetFriendsListAdapter widgetFriendsListAdapter) {
            super(C5419R.layout.widget_friends_list_expandable_header, widgetFriendsListAdapter);
            C12238m.checkNotNullParameter(widgetFriendsListAdapter, "adapter");
            WidgetFriendsListExpandableHeaderBinding widgetFriendsListExpandableHeaderBindingM8415a = WidgetFriendsListExpandableHeaderBinding.m8415a(this.itemView);
            C12238m.checkNotNullExpressionValue(widgetFriendsListExpandableHeaderBindingM8415a, "WidgetFriendsListExpanda…derBinding.bind(itemView)");
            this.binding = widgetFriendsListExpandableHeaderBindingM8415a;
        }

        public static final /* synthetic */ WidgetFriendsListAdapter access$getAdapter$p(ItemSuggestedFriendHeader itemSuggestedFriendHeader) {
            return (WidgetFriendsListAdapter) itemSuggestedFriendHeader.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, FriendsListViewModel.Item data) {
            CharSequence charSequenceM212d;
            C12238m.checkNotNullParameter(data, "data");
            FriendsListViewModel.Item.SuggestedFriendsHeader suggestedFriendsHeader = (FriendsListViewModel.Item.SuggestedFriendsHeader) data;
            TextView textView = this.binding.f16685c;
            C12238m.checkNotNullExpressionValue(textView, "binding.friendsListPendingItemHeaderText");
            C1107b.m221m(textView, C5419R.string.friends_friend_suggestions_header, new Object[0], new WidgetFriendsListAdapter$ItemSuggestedFriendHeader$onConfigure$1(data));
            if (!suggestedFriendsHeader.getShowExpandButton()) {
                TextView textView2 = this.binding.f16684b;
                C12238m.checkNotNullExpressionValue(textView2, "binding.friendsListExpandableHeaderButton");
                textView2.setVisibility(8);
                return;
            }
            TextView textView3 = this.binding.f16684b;
            C12238m.checkNotNullExpressionValue(textView3, "binding.friendsListExpandableHeaderButton");
            textView3.setVisibility(0);
            TextView textView4 = this.binding.f16684b;
            C12238m.checkNotNullExpressionValue(textView4, "binding.friendsListExpandableHeaderButton");
            if (suggestedFriendsHeader.isExpanded()) {
                TextView textView5 = this.binding.f16684b;
                C12238m.checkNotNullExpressionValue(textView5, "binding.friendsListExpandableHeaderButton");
                charSequenceM212d = C1107b.m212d(textView5, C5419R.string.friends_pending_request_expand_collapse, new Object[0], (4 & 4) != 0 ? C1107b.c.f1492j : null);
            } else {
                TextView textView6 = this.binding.f16684b;
                C12238m.checkNotNullExpressionValue(textView6, "binding.friendsListExpandableHeaderButton");
                charSequenceM212d = C1107b.m212d(textView6, C5419R.string.friends_pending_request_expand, new Object[0], (4 & 4) != 0 ? C1107b.c.f1492j : null);
            }
            textView4.setText(charSequenceM212d);
            int i = suggestedFriendsHeader.isExpanded() ? C5419R.drawable.ic_arrow_up_24dp : C5419R.drawable.ic_arrow_right_24dp;
            TextView textView7 = this.binding.f16684b;
            C12238m.checkNotNullExpressionValue(textView7, "binding.friendsListExpandableHeaderButton");
            Drawable drawable = ContextCompat.getDrawable(textView7.getContext(), i);
            TextView textView8 = this.binding.f16684b;
            C12238m.checkNotNullExpressionValue(textView8, "binding.friendsListExpandableHeaderButton");
            DrawableCompat.setCompoundDrawablesCompat$default(textView8, (Drawable) null, (Drawable) null, drawable, (Drawable) null, 11, (Object) null);
            this.binding.f16684b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.friends.WidgetFriendsListAdapter$ItemSuggestedFriendHeader$onConfigure$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetFriendsListAdapter.ItemSuggestedFriendHeader.access$getAdapter$p(this.this$0).getOnClickSuggestedHeaderExpandCollapse().invoke();
                }
            });
        }
    }

    /* JADX INFO: compiled from: WidgetFriendsListAdapter.kt */
    public static final class ItemUser extends Item {
        private final WidgetFriendsListAdapterItemFriendBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ItemUser(WidgetFriendsListAdapter widgetFriendsListAdapter) {
            super(C5419R.layout.widget_friends_list_adapter_item_friend, widgetFriendsListAdapter);
            C12238m.checkNotNullParameter(widgetFriendsListAdapter, "adapter");
            View view = this.itemView;
            int i = C5419R.id.friends_list_item_activity;
            SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) view.findViewById(C5419R.id.friends_list_item_activity);
            if (simpleDraweeSpanTextView != null) {
                i = C5419R.id.friends_list_item_avatar;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.friends_list_item_avatar);
                if (simpleDraweeView != null) {
                    i = C5419R.id.friends_list_item_buttons_wrap;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.friends_list_item_buttons_wrap);
                    if (linearLayout != null) {
                        i = C5419R.id.friends_list_item_call_button;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(C5419R.id.friends_list_item_call_button);
                        if (appCompatImageView != null) {
                            i = C5419R.id.friends_list_item_chat_button;
                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) view.findViewById(C5419R.id.friends_list_item_chat_button);
                            if (appCompatImageView2 != null) {
                                i = C5419R.id.friends_list_item_name;
                                TextView textView = (TextView) view.findViewById(C5419R.id.friends_list_item_name);
                                if (textView != null) {
                                    i = C5419R.id.friends_list_item_status;
                                    StatusView statusView = (StatusView) view.findViewById(C5419R.id.friends_list_item_status);
                                    if (statusView != null) {
                                        i = C5419R.id.friends_list_item_text;
                                        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(C5419R.id.friends_list_item_text);
                                        if (linearLayout2 != null) {
                                            WidgetFriendsListAdapterItemFriendBinding widgetFriendsListAdapterItemFriendBinding = new WidgetFriendsListAdapterItemFriendBinding((RelativeLayout) view, simpleDraweeSpanTextView, simpleDraweeView, linearLayout, appCompatImageView, appCompatImageView2, textView, statusView, linearLayout2);
                                            C12238m.checkNotNullExpressionValue(widgetFriendsListAdapterItemFriendBinding, "WidgetFriendsListAdapter…endBinding.bind(itemView)");
                                            this.binding = widgetFriendsListAdapterItemFriendBinding;
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ WidgetFriendsListAdapter access$getAdapter$p(ItemUser itemUser) {
            return (WidgetFriendsListAdapter) itemUser.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, final FriendsListViewModel.Item data) {
            C12238m.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            final FriendsListViewModel.Item.Friend friend = (FriendsListViewModel.Item.Friend) data;
            this.binding.f16657a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.friends.WidgetFriendsListAdapter$ItemUser$onConfigure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Function2<View, User, Unit> onClickUserProfile = WidgetFriendsListAdapter.ItemUser.access$getAdapter$p(this.this$0).getOnClickUserProfile();
                    C12238m.checkNotNullExpressionValue(view, "view");
                    onClickUserProfile.invoke(view, ((FriendsListViewModel.Item.Friend) data).getUser());
                }
            });
            TextView textView = this.binding.f16662f;
            C12238m.checkNotNullExpressionValue(textView, "binding.friendsListItemName");
            textView.setText(friend.getUser().getUsername());
            this.binding.f16663g.setPresence(friend.getPresence());
            Presence presence = friend.getPresence();
            boolean zIsApplicationStreaming = friend.isApplicationStreaming();
            SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.f16658b;
            C12238m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.friendsListItemActivity");
            PresenceUtils.setPresenceText$default(presence, zIsApplicationStreaming, simpleDraweeSpanTextView, true, false, 16, null);
            SimpleDraweeView simpleDraweeView = this.binding.f16659c;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.friendsListItemAvatar");
            IconUtils.setIcon$default(simpleDraweeView, friend.getUser(), C5419R.dimen.avatar_size_standard, null, null, null, 56, null);
            this.binding.f16660d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.friends.WidgetFriendsListAdapter$ItemUser$onConfigure$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetFriendsListAdapter.ItemUser.access$getAdapter$p(this.this$0).getOnClickCall().invoke(friend.getUser());
                }
            });
            this.binding.f16661e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.friends.WidgetFriendsListAdapter$ItemUser$onConfigure$3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetFriendsListAdapter.ItemUser.access$getAdapter$p(this.this$0).getOnClickChat().invoke(friend.getUser());
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetFriendsListAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        C12238m.checkNotNullParameter(recyclerView, "recycler");
        this.onClickSuggestedHeaderExpandCollapse = WidgetFriendsListAdapter$onClickSuggestedHeaderExpandCollapse$1.INSTANCE;
        this.onClickPendingHeaderExpand = WidgetFriendsListAdapter$onClickPendingHeaderExpand$1.INSTANCE;
        this.onClickUserProfile = WidgetFriendsListAdapter$onClickUserProfile$1.INSTANCE;
        this.onClickCall = WidgetFriendsListAdapter$onClickCall$1.INSTANCE;
        this.onClickChat = WidgetFriendsListAdapter$onClickChat$1.INSTANCE;
        this.onClickAcceptFriend = WidgetFriendsListAdapter$onClickAcceptFriend$1.INSTANCE;
        this.onClickDeclineFriend = WidgetFriendsListAdapter$onClickDeclineFriend$1.INSTANCE;
        this.onClickApproveSuggestion = WidgetFriendsListAdapter$onClickApproveSuggestion$1.INSTANCE;
        this.onClickRemoveSuggestion = WidgetFriendsListAdapter$onClickRemoveSuggestion$1.INSTANCE;
        this.onClickContactSyncUpsell = WidgetFriendsListAdapter$onClickContactSyncUpsell$1.INSTANCE;
        this.onClickContactSyncUpsellLongClick = WidgetFriendsListAdapter$onClickContactSyncUpsellLongClick$1.INSTANCE;
    }

    public final Function1<User, Unit> getOnClickAcceptFriend() {
        return this.onClickAcceptFriend;
    }

    public final Function1<User, Unit> getOnClickApproveSuggestion() {
        return this.onClickApproveSuggestion;
    }

    public final Function1<User, Unit> getOnClickCall() {
        return this.onClickCall;
    }

    public final Function1<User, Unit> getOnClickChat() {
        return this.onClickChat;
    }

    public final Function0<Unit> getOnClickContactSyncUpsell() {
        return this.onClickContactSyncUpsell;
    }

    public final Function1<View, Unit> getOnClickContactSyncUpsellLongClick() {
        return this.onClickContactSyncUpsellLongClick;
    }

    public final Function2<User, Integer, Unit> getOnClickDeclineFriend() {
        return this.onClickDeclineFriend;
    }

    public final Function0<Unit> getOnClickPendingHeaderExpand() {
        return this.onClickPendingHeaderExpand;
    }

    public final Function1<Long, Unit> getOnClickRemoveSuggestion() {
        return this.onClickRemoveSuggestion;
    }

    public final Function0<Unit> getOnClickSuggestedHeaderExpandCollapse() {
        return this.onClickSuggestedHeaderExpandCollapse;
    }

    public final Function2<View, User, Unit> getOnClickUserProfile() {
        return this.onClickUserProfile;
    }

    public final void setOnClickAcceptFriend(Function1<? super User, Unit> function1) {
        C12238m.checkNotNullParameter(function1, "<set-?>");
        this.onClickAcceptFriend = function1;
    }

    public final void setOnClickApproveSuggestion(Function1<? super User, Unit> function1) {
        C12238m.checkNotNullParameter(function1, "<set-?>");
        this.onClickApproveSuggestion = function1;
    }

    public final void setOnClickCall(Function1<? super User, Unit> function1) {
        C12238m.checkNotNullParameter(function1, "<set-?>");
        this.onClickCall = function1;
    }

    public final void setOnClickChat(Function1<? super User, Unit> function1) {
        C12238m.checkNotNullParameter(function1, "<set-?>");
        this.onClickChat = function1;
    }

    public final void setOnClickContactSyncUpsell(Function0<Unit> function0) {
        C12238m.checkNotNullParameter(function0, "<set-?>");
        this.onClickContactSyncUpsell = function0;
    }

    public final void setOnClickContactSyncUpsellLongClick(Function1<? super View, Unit> function1) {
        C12238m.checkNotNullParameter(function1, "<set-?>");
        this.onClickContactSyncUpsellLongClick = function1;
    }

    public final void setOnClickDeclineFriend(Function2<? super User, ? super Integer, Unit> function2) {
        C12238m.checkNotNullParameter(function2, "<set-?>");
        this.onClickDeclineFriend = function2;
    }

    public final void setOnClickPendingHeaderExpand(Function0<Unit> function0) {
        C12238m.checkNotNullParameter(function0, "<set-?>");
        this.onClickPendingHeaderExpand = function0;
    }

    public final void setOnClickRemoveSuggestion(Function1<? super Long, Unit> function1) {
        C12238m.checkNotNullParameter(function1, "<set-?>");
        this.onClickRemoveSuggestion = function1;
    }

    public final void setOnClickSuggestedHeaderExpandCollapse(Function0<Unit> function0) {
        C12238m.checkNotNullParameter(function0, "<set-?>");
        this.onClickSuggestedHeaderExpandCollapse = function0;
    }

    public final void setOnClickUserProfile(Function2<? super View, ? super User, Unit> function2) {
        C12238m.checkNotNullParameter(function2, "<set-?>");
        this.onClickUserProfile = function2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, FriendsListViewModel.Item> onCreateViewHolder(ViewGroup parent, int viewType) {
        C12238m.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 0:
                return new ItemUser(this);
            case 1:
                return new ItemPendingUser(this);
            case 2:
                return new ItemPendingHeader(this);
            case 3:
                return new ItemHeader(this);
            case 4:
                return new ItemSuggestedFriendHeader(this);
            case 5:
                View viewInflate = LayoutInflater.from(parent.getContext()).inflate(C5419R.layout.widget_friends_list_adapter_suggested_friend, parent, false);
                Objects.requireNonNull(viewInflate, "rootView");
                SuggestedFriendView suggestedFriendView = (SuggestedFriendView) viewInflate;
                WidgetFriendsListAdapterSuggestedFriendBinding widgetFriendsListAdapterSuggestedFriendBinding = new WidgetFriendsListAdapterSuggestedFriendBinding(suggestedFriendView, suggestedFriendView);
                C12238m.checkNotNullExpressionValue(widgetFriendsListAdapterSuggestedFriendBinding, "WidgetFriendsListAdapter…          false\n        )");
                return new ItemSuggestedFriend(widgetFriendsListAdapterSuggestedFriendBinding, this);
            case 6:
                return new ItemContactSyncUpsell(this);
            default:
                throw invalidViewTypeException(viewType);
        }
    }
}
