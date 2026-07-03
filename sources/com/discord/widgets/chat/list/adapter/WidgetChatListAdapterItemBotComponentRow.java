package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.api.botuikit.SelectItem;
import com.discord.databinding.WidgetChatListAdapterItemBotComponentRowBinding;
import com.discord.models.botuikit.MessageComponent;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.message.Message;
import com.discord.restapi.RestAPIParams;
import com.discord.widgets.botuikit.ComponentProvider;
import com.discord.widgets.botuikit.views.ComponentActionListener;
import com.discord.widgets.botuikit.views.select.ComponentContext;
import com.discord.widgets.botuikit.views.select.SelectComponentBottomSheet;
import com.discord.widgets.chat.list.entries.BotUiComponentEntry;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import java.util.ArrayList;
import java.util.List;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemBotComponentRow.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemBotComponentRow extends WidgetChatListItem implements ComponentActionListener {
    private final WidgetChatListAdapterItemBotComponentRowBinding binding;
    public BotUiComponentEntry entry;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemBotComponentRow(WidgetChatListAdapter widgetChatListAdapter) {
        super(C5419R.layout.widget_chat_list_adapter_item_bot_component_row, widgetChatListAdapter);
        C12238m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = C5419R.id.chat_list_adapter_item_component_root;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.chat_list_adapter_item_component_root);
        if (linearLayout != null) {
            i = C5419R.id.chat_list_adapter_item_gutter_bg;
            View viewFindViewById = view.findViewById(C5419R.id.chat_list_adapter_item_gutter_bg);
            if (viewFindViewById != null) {
                i = C5419R.id.chat_list_adapter_item_highlighted_bg;
                View viewFindViewById2 = view.findViewById(C5419R.id.chat_list_adapter_item_highlighted_bg);
                if (viewFindViewById2 != null) {
                    WidgetChatListAdapterItemBotComponentRowBinding widgetChatListAdapterItemBotComponentRowBinding = new WidgetChatListAdapterItemBotComponentRowBinding((ConstraintLayout) view, linearLayout, viewFindViewById, viewFindViewById2);
                    C12238m.checkNotNullExpressionValue(widgetChatListAdapterItemBotComponentRowBinding, "WidgetChatListAdapterIte…RowBinding.bind(itemView)");
                    this.binding = widgetChatListAdapterItemBotComponentRowBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public final BotUiComponentEntry getEntry() {
        BotUiComponentEntry botUiComponentEntry = this.entry;
        if (botUiComponentEntry == null) {
            C12238m.throwUninitializedPropertyAccessException("entry");
        }
        return botUiComponentEntry;
    }

    @Override // com.discord.widgets.botuikit.views.ComponentActionListener
    public void onButtonComponentClick(int componentIndex, String customId) {
        C12238m.checkNotNullParameter(customId, "customId");
        WidgetChatListAdapter widgetChatListAdapter = (WidgetChatListAdapter) this.adapter;
        BotUiComponentEntry botUiComponentEntry = this.entry;
        if (botUiComponentEntry == null) {
            C12238m.throwUninitializedPropertyAccessException("entry");
        }
        long applicationId = botUiComponentEntry.getApplicationId();
        BotUiComponentEntry botUiComponentEntry2 = this.entry;
        if (botUiComponentEntry2 == null) {
            C12238m.throwUninitializedPropertyAccessException("entry");
        }
        long id2 = botUiComponentEntry2.getMessage().getId();
        BotUiComponentEntry botUiComponentEntry3 = this.entry;
        if (botUiComponentEntry3 == null) {
            C12238m.throwUninitializedPropertyAccessException("entry");
        }
        widgetChatListAdapter.onBotUiComponentClicked(applicationId, id2, botUiComponentEntry3.getMessage().getFlags(), componentIndex, new RestAPIParams.ComponentInteractionData.ButtonComponentInteractionData(null, customId, 1, null));
    }

    @Override // com.discord.widgets.botuikit.views.ComponentActionListener
    public void onSelectComponentClick(int componentIndex, String customId, String placeholder, List<SelectItem> options, List<SelectItem> selectedItems, int minOptionsToSelect, int maxOptionsToSelect, boolean emojiAnimationsEnabled) {
        C12238m.checkNotNullParameter(customId, "customId");
        C12238m.checkNotNullParameter(options, "options");
        C12238m.checkNotNullParameter(selectedItems, "selectedItems");
        SelectComponentBottomSheet.Companion companion = SelectComponentBottomSheet.INSTANCE;
        FragmentManager fragmentManager = ((WidgetChatListAdapter) this.adapter).getFragmentManager();
        BotUiComponentEntry botUiComponentEntry = this.entry;
        if (botUiComponentEntry == null) {
            C12238m.throwUninitializedPropertyAccessException("entry");
        }
        Long guildId = botUiComponentEntry.getGuildId();
        BotUiComponentEntry botUiComponentEntry2 = this.entry;
        if (botUiComponentEntry2 == null) {
            C12238m.throwUninitializedPropertyAccessException("entry");
        }
        long id2 = botUiComponentEntry2.getMessage().getId();
        BotUiComponentEntry botUiComponentEntry3 = this.entry;
        if (botUiComponentEntry3 == null) {
            C12238m.throwUninitializedPropertyAccessException("entry");
        }
        long channelId = botUiComponentEntry3.getMessage().getChannelId();
        BotUiComponentEntry botUiComponentEntry4 = this.entry;
        if (botUiComponentEntry4 == null) {
            C12238m.throwUninitializedPropertyAccessException("entry");
        }
        Long flags = botUiComponentEntry4.getMessage().getFlags();
        BotUiComponentEntry botUiComponentEntry5 = this.entry;
        if (botUiComponentEntry5 == null) {
            C12238m.throwUninitializedPropertyAccessException("entry");
        }
        companion.show(fragmentManager, new ComponentContext(guildId, id2, channelId, flags, botUiComponentEntry5.getApplicationId()), componentIndex, customId, placeholder, minOptionsToSelect, maxOptionsToSelect, options, selectedItems, emojiAnimationsEnabled);
    }

    public final void setEntry(BotUiComponentEntry botUiComponentEntry) {
        C12238m.checkNotNullParameter(botUiComponentEntry, "<set-?>");
        this.entry = botUiComponentEntry;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, ChatListEntry data) {
        C12238m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        BotUiComponentEntry botUiComponentEntry = (BotUiComponentEntry) data;
        this.entry = botUiComponentEntry;
        if (botUiComponentEntry == null) {
            C12238m.throwUninitializedPropertyAccessException("entry");
        }
        Message message = botUiComponentEntry.getMessage();
        View view = this.binding.f16171c;
        C12238m.checkNotNullExpressionValue(view, "binding.chatListAdapterItemGutterBg");
        View view2 = this.binding.f16172d;
        C12238m.checkNotNullExpressionValue(view2, "binding.chatListAdapterItemHighlightedBg");
        configureCellHighlight(message, view2, view);
        BotUiComponentEntry botUiComponentEntry2 = this.entry;
        if (botUiComponentEntry2 == null) {
            C12238m.throwUninitializedPropertyAccessException("entry");
        }
        List<MessageComponent> messageComponents = botUiComponentEntry2.getMessageComponents();
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(messageComponents, 10));
        int i = 0;
        for (Object obj : messageComponents) {
            int i2 = i + 1;
            if (i < 0) {
                C12147n.throwIndexOverflow();
            }
            ComponentProvider botUiComponentProvider = ((WidgetChatListAdapter) this.adapter).getBotUiComponentProvider();
            LinearLayout linearLayout = this.binding.f16170b;
            C12238m.checkNotNullExpressionValue(linearLayout, "binding.chatListAdapterItemComponentRoot");
            arrayList.add(botUiComponentProvider.getConfiguredComponentView(this, (MessageComponent) obj, linearLayout, i));
            i = i2;
        }
        LinearLayout linearLayout2 = this.binding.f16170b;
        C12238m.checkNotNullExpressionValue(linearLayout2, "binding.chatListAdapterItemComponentRoot");
        WidgetChatListAdapterItemBotComponentRowKt.replaceViews(linearLayout2, C12163u.filterNotNull(arrayList));
    }
}
