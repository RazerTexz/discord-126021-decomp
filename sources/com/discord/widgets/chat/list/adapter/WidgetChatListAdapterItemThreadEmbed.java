package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.LeadingMarginSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.content.ContextCompat;
import com.discord.C5419R;
import com.discord.api.role.GuildRole;
import com.discord.api.thread.ThreadMetadata;
import com.discord.databinding.WidgetChatListAdapterItemThreadEmbedBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.CoreUser;
import com.discord.stores.StoreMessageState;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.widgets.chat.list.ViewReplySpline;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.ThreadEmbedEntry;
import com.discord.widgets.chat.list.utils.EmbeddedMessageParser;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Map;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemThreadEmbed.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemThreadEmbed extends WidgetChatListItem {
    public static final int MAX_THREAD_MESSAGE_AST_NODES = 50;
    private final WidgetChatListAdapterItemThreadEmbedBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemThreadEmbed(WidgetChatListAdapter widgetChatListAdapter) {
        super(C5419R.layout.widget_chat_list_adapter_item_thread_embed, widgetChatListAdapter);
        C12238m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = C5419R.id.chat_list_adapter_item_gutter_bg;
        View viewFindViewById = view.findViewById(C5419R.id.chat_list_adapter_item_gutter_bg);
        if (viewFindViewById != null) {
            i = C5419R.id.chat_list_adapter_item_highlighted_bg;
            View viewFindViewById2 = view.findViewById(C5419R.id.chat_list_adapter_item_highlighted_bg);
            if (viewFindViewById2 != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = C5419R.id.thread_embed_icon;
                ImageView imageView = (ImageView) view.findViewById(C5419R.id.thread_embed_icon);
                if (imageView != null) {
                    i = C5419R.id.thread_embed_message_center_guideline;
                    View viewFindViewById3 = view.findViewById(C5419R.id.thread_embed_message_center_guideline);
                    if (viewFindViewById3 != null) {
                        i = C5419R.id.thread_embed_messages_count;
                        TextView textView = (TextView) view.findViewById(C5419R.id.thread_embed_messages_count);
                        if (textView != null) {
                            i = C5419R.id.thread_embed_messages_count_chevron;
                            ImageView imageView2 = (ImageView) view.findViewById(C5419R.id.thread_embed_messages_count_chevron);
                            if (imageView2 != null) {
                                i = C5419R.id.thread_embed_most_recent_message_avatar;
                                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.thread_embed_most_recent_message_avatar);
                                if (simpleDraweeView != null) {
                                    i = C5419R.id.thread_embed_most_recent_message_content;
                                    SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) view.findViewById(C5419R.id.thread_embed_most_recent_message_content);
                                    if (simpleDraweeSpanTextView != null) {
                                        i = C5419R.id.thread_embed_most_recent_message_header;
                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) view.findViewById(C5419R.id.thread_embed_most_recent_message_header);
                                        if (constraintLayout2 != null) {
                                            i = C5419R.id.thread_embed_most_recent_message_name;
                                            TextView textView2 = (TextView) view.findViewById(C5419R.id.thread_embed_most_recent_message_name);
                                            if (textView2 != null) {
                                                i = C5419R.id.thread_embed_name;
                                                TextView textView3 = (TextView) view.findViewById(C5419R.id.thread_embed_name);
                                                if (textView3 != null) {
                                                    i = C5419R.id.thread_embed_selectable_background;
                                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) view.findViewById(C5419R.id.thread_embed_selectable_background);
                                                    if (constraintLayout3 != null) {
                                                        i = C5419R.id.thread_embed_spine;
                                                        ViewReplySpline viewReplySpline = (ViewReplySpline) view.findViewById(C5419R.id.thread_embed_spine);
                                                        if (viewReplySpline != null) {
                                                            i = C5419R.id.uikit_chat_guideline;
                                                            Guideline guideline = (Guideline) view.findViewById(C5419R.id.uikit_chat_guideline);
                                                            if (guideline != null) {
                                                                WidgetChatListAdapterItemThreadEmbedBinding widgetChatListAdapterItemThreadEmbedBinding = new WidgetChatListAdapterItemThreadEmbedBinding(constraintLayout, viewFindViewById, viewFindViewById2, constraintLayout, imageView, viewFindViewById3, textView, imageView2, simpleDraweeView, simpleDraweeSpanTextView, constraintLayout2, textView2, textView3, constraintLayout3, viewReplySpline, guideline);
                                                                C12238m.checkNotNullExpressionValue(widgetChatListAdapterItemThreadEmbedBinding, "WidgetChatListAdapterIte…bedBinding.bind(itemView)");
                                                                this.binding = widgetChatListAdapterItemThreadEmbedBinding;
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemThreadEmbed widgetChatListAdapterItemThreadEmbed) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemThreadEmbed.adapter;
    }

    private final void configureMessageCount(int count) {
        TextView textView = this.binding.f16341f;
        if (count == 0) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
            textView.setText(count >= 50 ? "50+" : String.valueOf(count));
        }
        ImageView imageView = this.binding.f16342g;
        imageView.setImageTintList(count == 0 ? ColorStateList.valueOf(ColorCompat.getThemedColor(imageView.getContext(), C5419R.attr.colorInteractiveNormal)) : ColorStateList.valueOf(ColorCompat.getThemedColor(imageView.getContext(), C5419R.attr.colorTextLink)));
    }

    private final void configureMostRecentMessageText(ThreadEmbedEntry data) {
        ConstraintLayout constraintLayout = this.binding.f16339d;
        C12238m.checkNotNullExpressionValue(constraintLayout, "binding.threadEmbedContainer");
        Context context = constraintLayout.getContext();
        Message mostRecentMessage = data.getMostRecentMessage();
        ConstraintLayout constraintLayout2 = this.binding.f16345j;
        C12238m.checkNotNullExpressionValue(constraintLayout2, "binding.threadEmbedMostRecentMessageHeader");
        constraintLayout2.setVisibility(8);
        ThreadMetadata threadMetadata = data.getThread().getThreadMetadata();
        if (threadMetadata != null && threadMetadata.getArchived()) {
            C12238m.checkNotNullExpressionValue(context, "context");
            Drawable drawable = ContextCompat.getDrawable(context, DrawableCompat.getThemedDrawableRes(context, C5419R.attr.ic_thread_archived_clock, 0));
            View view = this.itemView;
            C12238m.checkNotNullExpressionValue(view, "itemView");
            String string = view.getResources().getString(C5419R.string.thread_archived);
            C12238m.checkNotNullExpressionValue(string, "itemView.resources.getSt…R.string.thread_archived)");
            setNoMostRecentMessage$default(this, string, null, data.getNickOrUsernames(), null, drawable, 10, null);
            return;
        }
        if (data.getThreadMessageCount() == 0) {
            View view2 = this.itemView;
            C12238m.checkNotNullExpressionValue(view2, "itemView");
            String string2 = view2.getResources().getString(C5419R.string.no_thread_messages);
            C12238m.checkNotNullExpressionValue(string2, "itemView.resources.getSt…tring.no_thread_messages)");
            setNoMostRecentMessage$default(this, string2, null, data.getNickOrUsernames(), null, null, 26, null);
            return;
        }
        if ((mostRecentMessage != null ? mostRecentMessage.getContent() : null) == null || mostRecentMessage.getAuthor() == null || data.getMostRecentMessageGuildMember() == null) {
            View view3 = this.itemView;
            C12238m.checkNotNullExpressionValue(view3, "itemView");
            String string3 = view3.getResources().getString(C5419R.string.no_recent_thread_messages);
            C12238m.checkNotNullExpressionValue(string3, "itemView.resources.getSt…o_recent_thread_messages)");
            setNoMostRecentMessage$default(this, string3, null, data.getNickOrUsernames(), null, null, 26, null);
            return;
        }
        if (mostRecentMessage.hasStickers()) {
            View view4 = this.itemView;
            C12238m.checkNotNullExpressionValue(view4, "itemView");
            String string4 = view4.getResources().getString(C5419R.string.reply_quote_sticker_mobile);
            C12238m.checkNotNullExpressionValue(string4, "itemView.resources.getSt…ply_quote_sticker_mobile)");
            setNoMostRecentMessage$default(this, string4, mostRecentMessage, data.getNickOrUsernames(), data.getMostRecentMessageGuildMember(), null, 16, null);
            return;
        }
        if (!mostRecentMessage.hasAttachments() && !mostRecentMessage.hasEmbeds()) {
            setMostRecentMessage(mostRecentMessage, data.getRoleMentions(), data.getNickOrUsernames(), data.getAnimateEmojis(), data.getMostRecentMessageGuildMember());
            return;
        }
        C12238m.checkNotNullExpressionValue(context, "context");
        Drawable drawable2 = ContextCompat.getDrawable(context, DrawableCompat.getThemedDrawableRes(context, C5419R.attr.ic_flex_input_image, 0));
        View view5 = this.itemView;
        C12238m.checkNotNullExpressionValue(view5, "itemView");
        String string5 = view5.getResources().getString(C5419R.string.reply_quote_no_text_content_mobile);
        C12238m.checkNotNullExpressionValue(string5, "itemView.resources.getSt…e_no_text_content_mobile)");
        setNoMostRecentMessage(string5, mostRecentMessage, data.getNickOrUsernames(), data.getMostRecentMessageGuildMember(), drawable2);
    }

    private final int getAuthorTextColor(GuildMember member) {
        View view = this.itemView;
        C12238m.checkNotNullExpressionValue(view, "itemView");
        return GuildMember.INSTANCE.getColor(member, ColorCompat.getThemedColor(view.getContext(), C5419R.attr.colorHeaderPrimary));
    }

    private final LeadingMarginSpan getLeadingMarginSpan(boolean showAuthor) {
        int measuredWidth;
        this.binding.f16345j.measure(0, 0);
        if (showAuthor) {
            ConstraintLayout constraintLayout = this.binding.f16345j;
            C12238m.checkNotNullExpressionValue(constraintLayout, "binding.threadEmbedMostRecentMessageHeader");
            measuredWidth = constraintLayout.getMeasuredWidth();
        } else {
            measuredWidth = 0;
        }
        return new LeadingMarginSpan.Standard(measuredWidth, 0);
    }

    public static /* synthetic */ LeadingMarginSpan getLeadingMarginSpan$default(WidgetChatListAdapterItemThreadEmbed widgetChatListAdapterItemThreadEmbed, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        return widgetChatListAdapterItemThreadEmbed.getLeadingMarginSpan(z2);
    }

    private final void setAuthorAndAvatar(Message mostRecentMessage, Map<Long, String> nickOrUsernames, GuildMember mostRecentMessageAuthorGuildMember) {
        if (mostRecentMessage == null || mostRecentMessage.getAuthor() == null || mostRecentMessageAuthorGuildMember == null) {
            return;
        }
        ConstraintLayout constraintLayout = this.binding.f16345j;
        C12238m.checkNotNullExpressionValue(constraintLayout, "binding.threadEmbedMostRecentMessageHeader");
        constraintLayout.setVisibility(0);
        TextView textView = this.binding.f16346k;
        C12238m.checkNotNullExpressionValue(textView, "binding.threadEmbedMostRecentMessageName");
        textView.setText(nickOrUsernames.get(Long.valueOf(mostRecentMessage.getAuthor().getId())));
        this.binding.f16346k.setTextColor(getAuthorTextColor(mostRecentMessageAuthorGuildMember));
        CoreUser coreUser = new CoreUser(mostRecentMessage.getAuthor());
        SimpleDraweeView simpleDraweeView = this.binding.f16343h;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.threadEmbedMostRecentMessageAvatar");
        IconUtils.setIcon$default(simpleDraweeView, coreUser, C5419R.dimen.avatar_size_small, null, null, mostRecentMessageAuthorGuildMember, 24, null);
    }

    private final void setIcon(Drawable icon) {
        ImageView imageView = this.binding.f16340e;
        C12238m.checkNotNullExpressionValue(imageView, "binding.threadEmbedIcon");
        imageView.setVisibility(icon != null ? 0 : 8);
        this.binding.f16340e.setImageDrawable(icon);
    }

    public static /* synthetic */ void setIcon$default(WidgetChatListAdapterItemThreadEmbed widgetChatListAdapterItemThreadEmbed, Drawable drawable, int i, Object obj) {
        if ((i & 1) != 0) {
            drawable = null;
        }
        widgetChatListAdapterItemThreadEmbed.setIcon(drawable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setMostRecentMessage(Message mostRecentMessage, Map<Long, GuildRole> roleMentions, Map<Long, String> nickOrUsernames, boolean animateEmojis, GuildMember mostRecentMessageAuthorGuildMember) {
        DraweeSpanStringBuilder draweeSpanStringBuilder = EmbeddedMessageParser.INSTANCE.parse(new EmbeddedMessageParser.ParserData(C1643a.m885x(this.itemView, "itemView", "itemView.context"), roleMentions, nickOrUsernames, animateEmojis, new StoreMessageState.State(null, null == true ? 1 : 0, 3, null == true ? 1 : 0), 50, mostRecentMessage, (WidgetChatListAdapter) this.adapter));
        setAuthorAndAvatar(mostRecentMessage, nickOrUsernames, mostRecentMessageAuthorGuildMember);
        draweeSpanStringBuilder.setSpan(getLeadingMarginSpan$default(this, false, 1, null), 0, draweeSpanStringBuilder.length(), 33);
        this.binding.f16344i.setDraweeSpanStringBuilder(draweeSpanStringBuilder);
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.f16344i;
        FontUtils fontUtils = FontUtils.INSTANCE;
        Context context = simpleDraweeSpanTextView.getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        simpleDraweeSpanTextView.setTypeface(fontUtils.getThemedFont(context, C5419R.attr.font_primary_normal), 0);
        setIcon$default(this, null, 1, null);
    }

    private final void setNoMostRecentMessage(String messageText, Message mostRecentMessage, Map<Long, String> nickOrUsernames, GuildMember mostRecentMessageAuthorGuildMember, Drawable icon) {
        SpannableString spannableString = new SpannableString(messageText + (char) 160);
        setAuthorAndAvatar(mostRecentMessage, nickOrUsernames, mostRecentMessageAuthorGuildMember);
        spannableString.setSpan(getLeadingMarginSpan((mostRecentMessage == null || mostRecentMessageAuthorGuildMember == null) ? false : true), 0, spannableString.length(), 33);
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.f16344i;
        C12238m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.threadEmbedMostRecentMessageContent");
        simpleDraweeSpanTextView.setText(spannableString);
        SimpleDraweeSpanTextView simpleDraweeSpanTextView2 = this.binding.f16344i;
        FontUtils fontUtils = FontUtils.INSTANCE;
        Context context = simpleDraweeSpanTextView2.getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        simpleDraweeSpanTextView2.setTypeface(fontUtils.getThemedFont(context, C5419R.attr.font_primary_normal), 2);
        setIcon(icon);
    }

    public static /* synthetic */ void setNoMostRecentMessage$default(WidgetChatListAdapterItemThreadEmbed widgetChatListAdapterItemThreadEmbed, String str, Message message, Map map, GuildMember guildMember, Drawable drawable, int i, Object obj) {
        widgetChatListAdapterItemThreadEmbed.setNoMostRecentMessage(str, (i & 2) != 0 ? null : message, map, (i & 8) != 0 ? null : guildMember, (i & 16) != 0 ? null : drawable);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, final ChatListEntry data) {
        C12238m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        if (data instanceof ThreadEmbedEntry) {
            TextView textView = this.binding.f16347l;
            C12238m.checkNotNullExpressionValue(textView, "binding.threadEmbedName");
            ThreadEmbedEntry threadEmbedEntry = (ThreadEmbedEntry) data;
            textView.setText(threadEmbedEntry.getThread().getName());
            this.binding.f16339d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemThreadEmbed.onConfigure.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetChatListAdapterItemThreadEmbed.access$getAdapter$p(WidgetChatListAdapterItemThreadEmbed.this).onThreadClicked(((ThreadEmbedEntry) data).getThread());
                }
            });
            this.binding.f16336a.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemThreadEmbed.onConfigure.2
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    WidgetChatListAdapterItemThreadEmbed.access$getAdapter$p(WidgetChatListAdapterItemThreadEmbed.this).onThreadLongClicked(((ThreadEmbedEntry) data).getThread());
                    return true;
                }
            });
            configureMessageCount(threadEmbedEntry.getThreadMessageCount());
            configureMostRecentMessageText(threadEmbedEntry);
            Message parentMessage = threadEmbedEntry.getParentMessage();
            View view = this.binding.f16338c;
            C12238m.checkNotNullExpressionValue(view, "binding.chatListAdapterItemHighlightedBg");
            View view2 = this.binding.f16337b;
            C12238m.checkNotNullExpressionValue(view2, "binding.chatListAdapterItemGutterBg");
            configureCellHighlight(parentMessage, view, view2);
        }
    }
}
