package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetChatListAdapterItemGuildInviteReminderBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.message.Message;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.MessageEntry;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import com.google.android.material.button.MaterialButton;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGuildInviteReminder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGuildInviteReminder extends WidgetChatListItem {
    private final WidgetChatListAdapterItemGuildInviteReminderBinding binding;

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildInviteReminder$onConfigure$2 */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemGuildInviteReminder.kt */
    public static final class C80752 extends AbstractC12240o implements Function1<View, Unit> {
        public final /* synthetic */ ChatListEntry $data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C80752(ChatListEntry chatListEntry) {
            super(1);
            this.$data = chatListEntry;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "it");
            WidgetChatListAdapter.EventHandler eventHandler = WidgetChatListAdapterItemGuildInviteReminder.access$getAdapter$p(WidgetChatListAdapterItemGuildInviteReminder.this).getEventHandler();
            Message message = ((MessageEntry) this.$data).getMessage();
            View view2 = WidgetChatListAdapterItemGuildInviteReminder.this.itemView;
            C12238m.checkNotNullExpressionValue(view2, "itemView");
            String string = view2.getContext().getString(C5419R.string.system_message_invite_users_owner);
            C12238m.checkNotNullExpressionValue(string, "itemView.context.getStri…ssage_invite_users_owner)");
            eventHandler.onMessageLongClicked(message, string, false);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemGuildInviteReminder(WidgetChatListAdapter widgetChatListAdapter) {
        super(C5419R.layout.widget_chat_list_adapter_item_guild_invite_reminder, widgetChatListAdapter);
        C12238m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = C5419R.id.chat_action_item_button;
        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.chat_action_item_button);
        if (materialButton != null) {
            i = C5419R.id.chat_action_item_image;
            ImageView imageView = (ImageView) view.findViewById(C5419R.id.chat_action_item_image);
            if (imageView != null) {
                i = C5419R.id.chat_action_item_subtext;
                TextView textView = (TextView) view.findViewById(C5419R.id.chat_action_item_subtext);
                if (textView != null) {
                    i = C5419R.id.chat_action_item_text;
                    TextView textView2 = (TextView) view.findViewById(C5419R.id.chat_action_item_text);
                    if (textView2 != null) {
                        WidgetChatListAdapterItemGuildInviteReminderBinding widgetChatListAdapterItemGuildInviteReminderBinding = new WidgetChatListAdapterItemGuildInviteReminderBinding((ConstraintLayout) view, materialButton, imageView, textView, textView2);
                        C12238m.checkNotNullExpressionValue(widgetChatListAdapterItemGuildInviteReminderBinding, "WidgetChatListAdapterIte…derBinding.bind(itemView)");
                        this.binding = widgetChatListAdapterItemGuildInviteReminderBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemGuildInviteReminder widgetChatListAdapterItemGuildInviteReminder) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemGuildInviteReminder.adapter;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, ChatListEntry data) {
        C12238m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        if (data instanceof MessageEntry) {
            Guild guild = ((WidgetChatListAdapter) this.adapter).getData().getGuild();
            boolean zIsOwner = guild != null ? guild.isOwner(((WidgetChatListAdapter) this.adapter).getData().getUserId()) : false;
            int i = zIsOwner ? C5419R.string.system_message_invite_users_owner : C5419R.string.system_message_invite_users;
            int i2 = zIsOwner ? C5419R.string.system_message_invite_users_description_owner : C5419R.string.system_message_invite_users_description;
            this.binding.f16225d.setText(i);
            this.binding.f16224c.setText(i2);
            this.binding.f16223b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildInviteReminder.onConfigure.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetGuildInviteShare.INSTANCE.launch(C1643a.m885x(view, "view", "view.context"), WidgetChatListAdapterItemGuildInviteReminder.access$getAdapter$p(WidgetChatListAdapterItemGuildInviteReminder.this).getFragmentManager(), WidgetChatListAdapterItemGuildInviteReminder.access$getAdapter$p(WidgetChatListAdapterItemGuildInviteReminder.this).getData().getGuildId(), (16 & 8) != 0 ? null : null, (16 & 16) != 0 ? false : false, (16 & 32) != 0 ? null : null, (16 & 64) != 0 ? null : null, "Welcome Message");
                }
            });
            View view = this.itemView;
            C12238m.checkNotNullExpressionValue(view, "itemView");
            ViewExtensions.setOnLongClickListenerConsumeClick(view, new C80752(data));
        }
    }
}
