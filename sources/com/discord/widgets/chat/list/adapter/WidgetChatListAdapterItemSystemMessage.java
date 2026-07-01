package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.api.message.role_subscription.RoleSubscriptionData;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.databinding.WidgetChatListAdapterItemSystemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.member.GuildMember$Companion;
import com.discord.models.message.Message;
import com.discord.models.user.CoreUser;
import com.discord.utilities.analytics.Traits$Payment$Type;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.guildautomod.AutoModUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.sticker.StickerView;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.MessageEntry;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.t.u;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetChatListAdapterItemSystemMessage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSystemMessage extends WidgetChatListItem {
    private final WidgetChatListAdapterItemSystemBinding binding;
    private Subscription subscription;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemSystemMessage(WidgetChatListAdapter widgetChatListAdapter) {
        super(R$layout.widget_chat_list_adapter_item_system, widgetChatListAdapter);
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.chat_list_adapter_item_thread_embed_spine;
        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R$id.chat_list_adapter_item_thread_embed_spine);
        if (appCompatImageView != null) {
            i = R$id.role_subscription_badge_dummy_view;
            View viewFindViewById = view.findViewById(R$id.role_subscription_badge_dummy_view);
            if (viewFindViewById != null) {
                i = R$id.role_subscription_purchase_badge;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) view.findViewById(R$id.role_subscription_purchase_badge);
                if (appCompatImageView2 != null) {
                    i = R$id.role_subscription_purchase_lanyard;
                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) view.findViewById(R$id.role_subscription_purchase_lanyard);
                    if (appCompatImageView3 != null) {
                        i = R$id.role_subscription_purchase_welcome;
                        TextView textView = (TextView) view.findViewById(R$id.role_subscription_purchase_welcome);
                        if (textView != null) {
                            i = R$id.role_subscription_purchase_welcome_card;
                            ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R$id.role_subscription_purchase_welcome_card);
                            if (constraintLayout != null) {
                                i = R$id.role_subscription_purchaser_avatar;
                                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R$id.role_subscription_purchaser_avatar);
                                if (simpleDraweeView != null) {
                                    i = R$id.role_subscription_purchaser_username;
                                    TextView textView2 = (TextView) view.findViewById(R$id.role_subscription_purchaser_username);
                                    if (textView2 != null) {
                                        i = R$id.system_icon;
                                        ImageView imageView = (ImageView) view.findViewById(R$id.system_icon);
                                        if (imageView != null) {
                                            i = R$id.system_icon_automod;
                                            ImageView imageView2 = (ImageView) view.findViewById(R$id.system_icon_automod);
                                            if (imageView2 != null) {
                                                i = R$id.system_text;
                                                LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(R$id.system_text);
                                                if (linkifiedTextView != null) {
                                                    i = R$id.system_timestamp;
                                                    TextView textView3 = (TextView) view.findViewById(R$id.system_timestamp);
                                                    if (textView3 != null) {
                                                        i = R$id.system_welcome_cta_button;
                                                        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.system_welcome_cta_button);
                                                        if (linearLayout != null) {
                                                            i = R$id.system_welcome_cta_button_sticker;
                                                            StickerView stickerView = (StickerView) view.findViewById(R$id.system_welcome_cta_button_sticker);
                                                            if (stickerView != null) {
                                                                i = 2131365922;
                                                                Guideline guideline = (Guideline) view.findViewById(2131365922);
                                                                if (guideline != null) {
                                                                    WidgetChatListAdapterItemSystemBinding widgetChatListAdapterItemSystemBinding = new WidgetChatListAdapterItemSystemBinding((ConstraintLayout) view, appCompatImageView, viewFindViewById, appCompatImageView2, appCompatImageView3, textView, constraintLayout, simpleDraweeView, textView2, imageView, imageView2, linkifiedTextView, textView3, linearLayout, stickerView, guideline);
                                                                    m.checkNotNullExpressionValue(widgetChatListAdapterItemSystemBinding, "WidgetChatListAdapterIte…temBinding.bind(itemView)");
                                                                    this.binding = widgetChatListAdapterItemSystemBinding;
                                                                    return;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
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

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemSystemMessage widgetChatListAdapterItemSystemMessage) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemSystemMessage.adapter;
    }

    public static final /* synthetic */ WidgetChatListAdapterItemSystemBinding access$getBinding$p(WidgetChatListAdapterItemSystemMessage widgetChatListAdapterItemSystemMessage) {
        return widgetChatListAdapterItemSystemMessage.binding;
    }

    private final int getIcon(Message message) {
        Integer type = message.getType();
        if (type == null || type.intValue() != 1) {
            if (type != null && type.intValue() == 2) {
                return 2131231826;
            }
            if ((type != null && type.intValue() == 4) || (type != null && type.intValue() == 5)) {
                return 2131231824;
            }
            if (type != null && type.intValue() == 6) {
                return 2131231623;
            }
            if ((type == null || type.intValue() != 7) && (type == null || type.intValue() != 25)) {
                if ((type != null && type.intValue() == 8) || ((type != null && type.intValue() == 9) || ((type != null && type.intValue() == 10) || (type != null && type.intValue() == 11)))) {
                    return 2131232231;
                }
                if (type == null || type.intValue() != 12) {
                    if (type == null || type.intValue() != 14) {
                        if (type != null && type.intValue() == 15) {
                            return 2131231658;
                        }
                        if (type != null && type.intValue() == 16) {
                            return 2131232266;
                        }
                        if (type != null && type.intValue() == 17) {
                            return 2131232266;
                        }
                        if (type != null && type.intValue() == 18) {
                            return 2131232193;
                        }
                        if (type != null) {
                            type.intValue();
                        }
                    }
                    return 2131232267;
                }
            }
        }
        return 2131231825;
    }

    private final CharSequence getSystemMessage(Message message, Context context, String str, int i, Long l, String str2, int i2, String str3, boolean z2, Long l2, Long l3) {
        int i3;
        if (z2) {
            i3 = 2131889944;
        } else {
            if (z2) {
                throw new NoWhenBranchMatchedException();
            }
            i3 = 2131889943;
        }
        return new WidgetChatListAdapterItemSystemMessage$getSystemMessage$1(message, str, str2, new WidgetChatListAdapterItemSystemMessage$getSystemMessage$usernameRenderContext$1(i, i2), l, context, str3, new WidgetChatListAdapterItemSystemMessage$getSystemMessage$actorRenderContext$1(i), i3, new WidgetChatListAdapterItemSystemMessage$getSystemMessage$autoModRenderContext$1(context), new WidgetChatListAdapterItemSystemMessage$getSystemMessage$roleSubscriptionPurchaseContext$1(this, message, i, context, l3)).invoke2(context);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.subscription;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        MessageEmbed messageEmbed;
        User user;
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        MessageEntry messageEntry = (MessageEntry) data;
        Message message = messageEntry.getMessage();
        GuildMember author = messageEntry.getAuthor();
        GuildMember firstMentionedUser = messageEntry.getFirstMentionedUser();
        Map<Long, String> mapComponent6 = messageEntry.component6();
        User author2 = message.getAuthor();
        String str = mapComponent6.get(author2 != null ? Long.valueOf(author2.getId()) : null);
        Guild guild = ((WidgetChatListAdapter) this.adapter).getData().getGuild();
        String name = guild != null ? guild.getName() : null;
        List<User> mentions = message.getMentions();
        Long lValueOf = (mentions == null || (user = (User) u.firstOrNull((List) mentions)) == null) ? null : Long.valueOf(user.getId());
        String str2 = lValueOf != null ? mapComponent6.get(Long.valueOf(lValueOf.longValue())) : null;
        LinkifiedTextView linkifiedTextView = this.binding.h;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.systemText");
        int themedColor = ColorCompat.getThemedColor(linkifiedTextView.getContext(), 2130968989);
        GuildMember$Companion guildMember$Companion = GuildMember.Companion;
        int color = guildMember$Companion.getColor(author, themedColor);
        int color2 = guildMember$Companion.getColor(firstMentionedUser, themedColor);
        List<MessageEmbed> embeds = message.getEmbeds();
        boolean z2 = (embeds == null || (messageEmbed = (MessageEmbed) u.firstOrNull((List) embeds)) == null) ? false : !m.areEqual(AutoModUtils.INSTANCE.getEmbedFieldValue(messageEmbed, WidgetChatListAdapterItemAutoModSystemMessageEmbedKt.getAUTOMOD_EMBED_FLAGGED_MESSAGE_ID()), "");
        RoleSubscriptionData roleSubscriptionData = message.getRoleSubscriptionData();
        Long lValueOf2 = roleSubscriptionData != null ? Long.valueOf(roleSubscriptionData.getRoleSubscriptionListingId()) : null;
        Guild guild2 = ((WidgetChatListAdapter) this.adapter).getData().getGuild();
        Long lValueOf3 = guild2 != null ? Long.valueOf(guild2.getId()) : null;
        LinkifiedTextView linkifiedTextView2 = this.binding.h;
        m.checkNotNullExpressionValue(linkifiedTextView2, "binding.systemText");
        Context context = linkifiedTextView2.getContext();
        m.checkNotNullExpressionValue(context, "binding.systemText.context");
        Long l = lValueOf3;
        CharSequence systemMessage = getSystemMessage(message, context, str, color, lValueOf, str2, color2, name, z2, l, lValueOf2);
        this.binding.a.setOnClickListener(new WidgetChatListAdapterItemSystemMessage$onConfigure$1(this, message));
        ConstraintLayout constraintLayout = this.binding.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        ViewExtensions.setOnLongClickListenerConsumeClick(constraintLayout, new WidgetChatListAdapterItemSystemMessage$onConfigure$2(this, message));
        TextView textView = this.binding.i;
        m.checkNotNullExpressionValue(textView, "binding.systemTimestamp");
        Context contextX = a.x(this.itemView, "itemView", "itemView.context");
        UtcDateTime timestamp = message.getTimestamp();
        textView.setText(TimeUtils.toReadableTimeString$default(contextX, timestamp != null ? timestamp.getDateTimeMillis() : 0L, null, 4, null));
        LinkifiedTextView linkifiedTextView3 = this.binding.h;
        m.checkNotNullExpressionValue(linkifiedTextView3, "binding.systemText");
        linkifiedTextView3.setText(systemMessage);
        this.binding.f.setImageResource(getIcon(message));
        ImageView imageView = this.binding.g;
        m.checkNotNullExpressionValue(imageView, "binding.systemIconAutomod");
        Integer type = messageEntry.getMessage().getType();
        imageView.setVisibility(type != null && type.intValue() == 24 ? 0 : 8);
        AppCompatImageView appCompatImageView = this.binding.f2337b;
        m.checkNotNullExpressionValue(appCompatImageView, "binding.chatListAdapterItemThreadEmbedSpine");
        appCompatImageView.setVisibility(message.hasThread() && !messageEntry.isThreadStarterMessage() ? 0 : 8);
        LinearLayout linearLayout = this.binding.j;
        m.checkNotNullExpressionValue(linearLayout, "binding.systemWelcomeCtaButton");
        linearLayout.setVisibility(messageEntry.getCtaData() != null ? 0 : 8);
        if (messageEntry.getCtaData() != null) {
            StickerView.e(this.binding.k, messageEntry.getCtaData().getSticker(), null, 2);
            this.binding.k.b();
            this.binding.j.setOnClickListener(new WidgetChatListAdapterItemSystemMessage$onConfigure$3(this, message, data));
        }
        boolean z3 = message.getRoleSubscriptionData() != null && message.getRoleSubscriptionData().getTotalMonthsSubscribed() <= 1;
        ConstraintLayout constraintLayout2 = this.binding.c;
        m.checkNotNullExpressionValue(constraintLayout2, "binding.roleSubscriptionPurchaseWelcomeCard");
        constraintLayout2.setVisibility(z3 ? 0 : 8);
        if (z3) {
            TextView textView2 = this.binding.e;
            m.checkNotNullExpressionValue(textView2, "binding.roleSubscriptionPurchaserUsername");
            textView2.setText(str);
            if (message.getAuthor() != null) {
                SimpleDraweeView simpleDraweeView = this.binding.d;
                m.checkNotNullExpressionValue(simpleDraweeView, "binding.roleSubscriptionPurchaserAvatar");
                IconUtils.setIcon$default(simpleDraweeView, new CoreUser(message.getAuthor()), 2131165293, null, null, messageEntry.getAuthor(), 24, null);
                this.binding.d.setOnClickListener(new WidgetChatListAdapterItemSystemMessage$onConfigure$4(this, l, message));
            }
        }
    }
}
