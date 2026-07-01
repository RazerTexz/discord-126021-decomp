package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import b.a.i.ReactionQuickAddBinding;
import com.discord.R;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.databinding.WidgetChatListAdapterItemReactionsBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.message.Message;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.ReactionView;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.ReactionsEntry;
import com.google.android.flexbox.FlexboxLayout;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemReactions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemReactions extends WidgetChatListItem {
    private static final int REACTION_LIMIT = 20;
    private final WidgetChatListAdapterItemReactionsBinding binding;
    private final ImageView quickAddReactionView;
    private static final int REACTION_HORIZONTAL_PADDING = DimenUtils.dpToPixels(6);
    private static final int REACTION_VIEW_HEIGHT = DimenUtils.dpToPixels(26);

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemReactions$displayReactions$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemReactions.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ MessageReaction $reaction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j, MessageReaction messageReaction) {
            super(1);
            this.$messageId = j;
            this.$reaction = messageReaction;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetChatListAdapterItemReactions.access$getAdapter$p(WidgetChatListAdapterItemReactions.this).onReactionLongClicked(this.$messageId, this.$reaction);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemReactions(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_reactions, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.chat_list_adapter_item_gutter_bg;
        View viewFindViewById = view.findViewById(R.id.chat_list_adapter_item_gutter_bg);
        if (viewFindViewById != null) {
            i = R.id.chat_list_adapter_item_highlighted_bg;
            View viewFindViewById2 = view.findViewById(R.id.chat_list_adapter_item_highlighted_bg);
            if (viewFindViewById2 != null) {
                i = R.id.chat_list_item_reactions;
                FlexboxLayout flexboxLayout = (FlexboxLayout) view.findViewById(R.id.chat_list_item_reactions);
                if (flexboxLayout != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    WidgetChatListAdapterItemReactionsBinding widgetChatListAdapterItemReactionsBinding = new WidgetChatListAdapterItemReactionsBinding(constraintLayout, viewFindViewById, viewFindViewById2, flexboxLayout);
                    Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemReactionsBinding, "WidgetChatListAdapterIte…onsBinding.bind(itemView)");
                    this.binding = widgetChatListAdapterItemReactionsBinding;
                    Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
                    View viewInflate = LayoutInflater.from(constraintLayout.getContext()).inflate(R.layout.reaction_quick_add, (ViewGroup) null, false);
                    Objects.requireNonNull(viewInflate, "rootView");
                    ImageView imageView = (ImageView) viewInflate;
                    Intrinsics3.checkNotNullExpressionValue(new ReactionQuickAddBinding(imageView, imageView), "ReactionQuickAddBinding.…ot.context), null, false)");
                    Intrinsics3.checkNotNullExpressionValue(imageView, "ReactionQuickAddBinding.…ntext), null, false).root");
                    this.quickAddReactionView = imageView;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemReactions widgetChatListAdapterItemReactions) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemReactions.adapter;
    }

    private final void displayReactions(Collection<MessageReaction> reactions, final long messageId, final boolean canAddReactions, boolean canCreateReactions, boolean animateEmojis) {
        ReactionView reactionView;
        removeQuickAddReactionView();
        FlexboxLayout flexboxLayout = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(flexboxLayout, "binding.chatListItemReactions");
        int childCount = flexboxLayout.getChildCount();
        for (int size = reactions.size(); size < childCount; size++) {
            View childAt = this.binding.d.getChildAt(size);
            Intrinsics3.checkNotNullExpressionValue(childAt, "binding.chatListItemReactions.getChildAt(i)");
            childAt.setVisibility(8);
        }
        FlexboxLayout flexboxLayout2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(flexboxLayout2, "binding.chatListItemReactions");
        int childCount2 = flexboxLayout2.getChildCount();
        int i = 0;
        int i2 = 0;
        for (final MessageReaction messageReaction : reactions) {
            if (i2 < childCount2) {
                View childAt2 = this.binding.d.getChildAt(i2);
                Objects.requireNonNull(childAt2, "null cannot be cast to non-null type com.discord.views.ReactionView");
                reactionView = (ReactionView) childAt2;
                reactionView.setVisibility(i);
                i2++;
            } else {
                FlexboxLayout flexboxLayout3 = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(flexboxLayout3, "binding.chatListItemReactions");
                Context context = flexboxLayout3.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "binding.chatListItemReactions.context");
                reactionView = new ReactionView(context, null, i, 6);
                int i3 = REACTION_HORIZONTAL_PADDING;
                reactionView.setPadding(i3, reactionView.getPaddingTop(), i3, reactionView.getPaddingBottom());
                Context context2 = reactionView.getContext();
                Context context3 = reactionView.getContext();
                Intrinsics3.checkNotNullExpressionValue(context3, "view.context");
                reactionView.setBackground(ContextCompat.getDrawable(context2, DrawableCompat.getThemedDrawableRes$default(context3, R.attr.theme_chat_reaction_background, i, 2, (Object) null)));
                reactionView.setGravity(17);
                this.binding.d.addView(reactionView);
                reactionView.getLayoutParams().height = REACTION_VIEW_HEIGHT;
            }
            ReactionView reactionView2 = reactionView;
            reactionView2.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemReactions.displayReactions.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetChatListAdapterItemReactions.access$getAdapter$p(WidgetChatListAdapterItemReactions.this).onReactionClicked(messageId, messageReaction, canAddReactions);
                }
            });
            ViewExtensions.setOnLongClickListenerConsumeClick(reactionView2, new AnonymousClass2(messageId, messageReaction));
            reactionView2.a(messageReaction, messageId, animateEmojis);
            i2 = i2;
            i = 0;
        }
        if (reactions.size() >= 20 || !canCreateReactions) {
            return;
        }
        this.quickAddReactionView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemReactions.displayReactions.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatListAdapterItemReactions.access$getAdapter$p(WidgetChatListAdapterItemReactions.this).onQuickAddReactionClicked(messageId);
            }
        });
        this.binding.d.addView(this.quickAddReactionView);
    }

    private final void processReactions(ReactionsEntry data) {
        Message message = data.getMessage();
        View view = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.chatListAdapterItemHighlightedBg");
        View view2 = this.binding.f2329b;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.chatListAdapterItemGutterBg");
        configureCellHighlight(message, view, view2);
        displayReactions(data.getMessage().getReactionsMap().values(), data.getMessage().getId(), data.getCanAddReactions(), data.getCanCreateReactions(), data.getAnimateEmojis());
    }

    private final void removeQuickAddReactionView() {
        FlexboxLayout flexboxLayout = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(flexboxLayout, "binding.chatListItemReactions");
        int childCount = flexboxLayout.getChildCount();
        if (childCount > 0) {
            int i = childCount - 1;
            if (this.binding.d.getChildAt(i) == this.quickAddReactionView) {
                this.binding.d.removeViewAt(i);
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        processReactions((ReactionsEntry) data);
    }
}
