package com.discord.widgets.chat.managereactions;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.databinding.WidgetManageReactionsEmojiBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.widgets.chat.managereactions.ManageReactionsEmojisAdapter;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ManageReactionsEmojisAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ManageReactionsEmojisAdapter extends MGRecyclerAdapterSimple<ReactionEmojiItem> {
    private static final int TYPE_REACTION_EMOJI_ITEM = 0;
    private Function1<? super String, Unit> onEmojiSelectedListener;

    /* JADX INFO: compiled from: ManageReactionsEmojisAdapter.kt */
    public static final /* data */ class ReactionEmojiItem implements MGRecyclerDataPayload {
        private final boolean isSelected;
        private final String key;
        private final MessageReaction reaction;
        private final int type;

        public ReactionEmojiItem(MessageReaction messageReaction, boolean z2) {
            Intrinsics3.checkNotNullParameter(messageReaction, "reaction");
            this.reaction = messageReaction;
            this.isSelected = z2;
            this.key = messageReaction.getEmoji().c();
        }

        public static /* synthetic */ ReactionEmojiItem copy$default(ReactionEmojiItem reactionEmojiItem, MessageReaction messageReaction, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                messageReaction = reactionEmojiItem.reaction;
            }
            if ((i & 2) != 0) {
                z2 = reactionEmojiItem.isSelected;
            }
            return reactionEmojiItem.copy(messageReaction, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final MessageReaction getReaction() {
            return this.reaction;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsSelected() {
            return this.isSelected;
        }

        public final ReactionEmojiItem copy(MessageReaction reaction, boolean isSelected) {
            Intrinsics3.checkNotNullParameter(reaction, "reaction");
            return new ReactionEmojiItem(reaction, isSelected);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ReactionEmojiItem)) {
                return false;
            }
            ReactionEmojiItem reactionEmojiItem = (ReactionEmojiItem) other;
            return Intrinsics3.areEqual(this.reaction, reactionEmojiItem.reaction) && this.isSelected == reactionEmojiItem.isSelected;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final MessageReaction getReaction() {
            return this.reaction;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public int hashCode() {
            MessageReaction messageReaction = this.reaction;
            int iHashCode = (messageReaction != null ? messageReaction.hashCode() : 0) * 31;
            boolean z2 = this.isSelected;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode + r1;
        }

        public final boolean isSelected() {
            return this.isSelected;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ReactionEmojiItem(reaction=");
            sbU.append(this.reaction);
            sbU.append(", isSelected=");
            return outline.O(sbU, this.isSelected, ")");
        }
    }

    /* JADX INFO: compiled from: ManageReactionsEmojisAdapter.kt */
    public static final class ReactionEmojiViewHolder extends MGRecyclerViewHolder<ManageReactionsEmojisAdapter, ReactionEmojiItem> {
        private static final int emojiSizePx = DimenUtils.dpToPixels(20);
        private final WidgetManageReactionsEmojiBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ReactionEmojiViewHolder(ManageReactionsEmojisAdapter manageReactionsEmojisAdapter) {
            super(R.layout.widget_manage_reactions_emoji, manageReactionsEmojisAdapter);
            Intrinsics3.checkNotNullParameter(manageReactionsEmojisAdapter, "adapter");
            View view = this.itemView;
            int i = R.id.manage_reactions_emoji_container;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.manage_reactions_emoji_container);
            if (linearLayout != null) {
                i = R.id.manage_reactions_emoji_counter;
                TextView textView = (TextView) view.findViewById(R.id.manage_reactions_emoji_counter);
                if (textView != null) {
                    i = R.id.manage_reactions_emoji_emoji_textview;
                    SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) view.findViewById(R.id.manage_reactions_emoji_emoji_textview);
                    if (simpleDraweeSpanTextView != null) {
                        i = R.id.manage_reactions_emoji_selected_indicator;
                        View viewFindViewById = view.findViewById(R.id.manage_reactions_emoji_selected_indicator);
                        if (viewFindViewById != null) {
                            WidgetManageReactionsEmojiBinding widgetManageReactionsEmojiBinding = new WidgetManageReactionsEmojiBinding((RelativeLayout) view, linearLayout, textView, simpleDraweeSpanTextView, viewFindViewById);
                            Intrinsics3.checkNotNullExpressionValue(widgetManageReactionsEmojiBinding, "WidgetManageReactionsEmojiBinding.bind(itemView)");
                            this.binding = widgetManageReactionsEmojiBinding;
                            return;
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        public static final /* synthetic */ ManageReactionsEmojisAdapter access$getAdapter$p(ReactionEmojiViewHolder reactionEmojiViewHolder) {
            return (ManageReactionsEmojisAdapter) reactionEmojiViewHolder.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, final ReactionEmojiItem data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            EmojiNode.Companion companion = EmojiNode.INSTANCE;
            SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.manageReactionsEmojiEmojiTextview");
            companion.renderEmoji(simpleDraweeSpanTextView, data.getReaction().getEmoji(), true, emojiSizePx);
            TextView textView = this.binding.f2483b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.manageReactionsEmojiCounter");
            textView.setText(String.valueOf(data.getReaction().getCount()));
            View view = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(view, "binding.manageReactionsEmojiSelectedIndicator");
            view.setVisibility(data.isSelected() ? 0 : 4);
            this.binding.a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.managereactions.ManageReactionsEmojisAdapter$ReactionEmojiViewHolder$onConfigure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Function1<String, Unit> onEmojiSelectedListener = ManageReactionsEmojisAdapter.ReactionEmojiViewHolder.access$getAdapter$p(this.this$0).getOnEmojiSelectedListener();
                    if (onEmojiSelectedListener != null) {
                        onEmojiSelectedListener.invoke(data.getReaction().getEmoji().c());
                    }
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManageReactionsEmojisAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
    }

    public final Function1<String, Unit> getOnEmojiSelectedListener() {
        return this.onEmojiSelectedListener;
    }

    public final void setOnEmojiSelectedListener(Function1<? super String, Unit> function1) {
        this.onEmojiSelectedListener = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, ReactionEmojiItem> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new ReactionEmojiViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
