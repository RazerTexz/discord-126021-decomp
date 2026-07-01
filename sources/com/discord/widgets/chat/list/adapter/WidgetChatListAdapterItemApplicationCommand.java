package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.app.NotificationCompat;
import b.a.d.AppToast;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.databinding.WidgetChatListAdapterItemApplicationCommandBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.time.TimeUtils;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.MessageEntry;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemApplicationCommand.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemApplicationCommand extends WidgetChatListItem {
    private final WidgetChatListAdapterItemApplicationCommandBinding binding;

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemApplicationCommand$onConfigure$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemApplicationCommand.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<TextView, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(TextView textView) {
            invoke2(textView);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(final TextView textView) {
            Intrinsics3.checkNotNullParameter(textView, "$this$copyTextOnLongPress");
            textView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemApplicationCommand.onConfigure.1.1
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    Context context = textView.getContext();
                    Intrinsics3.checkNotNullExpressionValue(context, "context");
                    CharSequence text = textView.getText();
                    Intrinsics3.checkNotNullExpressionValue(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                    AppToast.c(context, text, 0, 4);
                    return false;
                }
            });
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemApplicationCommand(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_application_command, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.chat_list_adapter_item_text_avatar;
        ImageView imageView = (ImageView) view.findViewById(R.id.chat_list_adapter_item_text_avatar);
        if (imageView != null) {
            i = R.id.chat_list_adapter_item_text_command;
            TextView textView = (TextView) view.findViewById(R.id.chat_list_adapter_item_text_command);
            if (textView != null) {
                i = R.id.chat_list_adapter_item_text_decorator;
                CardView cardView = (CardView) view.findViewById(R.id.chat_list_adapter_item_text_decorator);
                if (cardView != null) {
                    i = R.id.chat_list_adapter_item_text_decorator_reply_link_icon;
                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.chat_list_adapter_item_text_decorator_reply_link_icon);
                    if (frameLayout != null) {
                        i = R.id.chat_list_adapter_item_text_header;
                        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.chat_list_adapter_item_text_header);
                        if (constraintLayout != null) {
                            i = R.id.chat_list_adapter_item_text_name;
                            TextView textView2 = (TextView) view.findViewById(R.id.chat_list_adapter_item_text_name);
                            if (textView2 != null) {
                                i = R.id.chat_list_adapter_item_text_timestamp;
                                TextView textView3 = (TextView) view.findViewById(R.id.chat_list_adapter_item_text_timestamp);
                                if (textView3 != null) {
                                    i = R.id.uikit_chat_guideline;
                                    Guideline guideline = (Guideline) view.findViewById(R.id.uikit_chat_guideline);
                                    if (guideline != null) {
                                        WidgetChatListAdapterItemApplicationCommandBinding widgetChatListAdapterItemApplicationCommandBinding = new WidgetChatListAdapterItemApplicationCommandBinding((ConstraintLayout) view, imageView, textView, cardView, frameLayout, constraintLayout, textView2, textView3, guideline);
                                        Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemApplicationCommandBinding, "WidgetChatListAdapterIte…andBinding.bind(itemView)");
                                        this.binding = widgetChatListAdapterItemApplicationCommandBinding;
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

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemApplicationCommand widgetChatListAdapterItemApplicationCommand) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemApplicationCommand.adapter;
    }

    private final int getAuthorTextColor(GuildMember member) {
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        return GuildMember.INSTANCE.getColor(member, ColorCompat.getThemedColor(view.getContext(), R.attr.colorHeaderPrimary));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Code duplicated, block: B:19:0x0054  */
    /* JADX WARN: Code duplicated, block: B:20:0x005d  */
    /* JADX WARN: Code duplicated, block: B:24:0x0067  */
    /* JADX WARN: Code duplicated, block: B:27:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:28:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:31:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:40:0x013c  */
    /* JADX WARN: Code duplicated, block: B:41:0x0141  */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, ChatListEntry data) {
        String strGroup;
        String strGroup2;
        User author;
        Long lValueOf;
        String str;
        boolean z2;
        int i;
        Integer type;
        UtcDateTime timestamp;
        long dateTimeMillis;
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        MessageEntry messageEntry = (MessageEntry) data;
        Message message = messageEntry.getMessage();
        GuildMember author2 = messageEntry.getAuthor();
        Map<Long, String> nickOrUsernames = messageEntry.getNickOrUsernames();
        int authorTextColor = getAuthorTextColor(author2);
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        Pattern patternCompile = Pattern.compile("^<(/[^:]+):([0-9]*)>(.*)");
        String content = message.getContent();
        String str2 = "";
        if (content == null) {
            content = "";
        }
        Matcher matcher = patternCompile.matcher(content);
        if (matcher.matches()) {
            strGroup = matcher.group(1);
            if (strGroup == null) {
                strGroup = "";
            }
            strGroup2 = matcher.group(3);
            if (strGroup2 == null) {
            }
            author = message.getAuthor();
            if (author != null) {
                lValueOf = Long.valueOf(author.getId());
            } else {
                lValueOf = null;
            }
            str = nickOrUsernames.get(lValueOf);
            if (str == null) {
                str = "";
            }
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            int themedColor = ColorCompat.getThemedColor(view, R.attr.color_brand_500);
            TextView textView = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.chatListAdapterItemTextName");
            CharSequence charSequenceD = FormatUtils.d(textView, R.string.system_message_application_command_used_short_mobile, new Object[]{str, strGroup}, new WidgetChatListAdapterItemApplicationCommand2(this, authorTextColor, message, themedColor));
            TextView textView2 = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.chatListAdapterItemTextName");
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
            TextView textView3 = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.chatListAdapterItemTextName");
            textView3.setText(charSequenceD);
            TextView textView4 = this.binding.f2308b;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.chatListAdapterItemTextCommand");
            textView4.setMaxLines(1);
            this.binding.f2308b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemApplicationCommand.onConfigure.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    TextView textView5 = WidgetChatListAdapterItemApplicationCommand.this.binding.f2308b;
                    Intrinsics3.checkNotNullExpressionValue(textView5, "binding.chatListAdapterItemTextCommand");
                    if (textView5.getMaxLines() == 1) {
                        TextView textView6 = WidgetChatListAdapterItemApplicationCommand.this.binding.f2308b;
                        Intrinsics3.checkNotNullExpressionValue(textView6, "binding.chatListAdapterItemTextCommand");
                        textView6.setMaxLines(Integer.MAX_VALUE);
                    } else {
                        TextView textView7 = WidgetChatListAdapterItemApplicationCommand.this.binding.f2308b;
                        Intrinsics3.checkNotNullExpressionValue(textView7, "binding.chatListAdapterItemTextCommand");
                        textView7.setMaxLines(1);
                    }
                }
            });
            z2 = !StringsJVM.isBlank(strGroup2);
            CardView cardView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(cardView, "binding.chatListAdapterItemTextDecorator");
            if (z2) {
                i = 0;
            } else {
                i = 8;
            }
            cardView.setVisibility(i);
            FrameLayout frameLayout = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.chatListAdapterI…extDecoratorReplyLinkIcon");
            frameLayout.setVisibility(z2 ? 0 : 8);
            TextView textView5 = this.binding.f2308b;
            Intrinsics3.checkNotNullExpressionValue(textView5, "binding.chatListAdapterItemTextCommand");
            Context contextX = outline.x(this.itemView, "itemView", "itemView.context");
            Object[] objArr = new Object[2];
            type = message.getType();
            if (type != null && type.intValue() == 20) {
                str2 = strGroup;
            }
            objArr[0] = str2;
            objArr[1] = strGroup2;
            textView5.setText(FormatUtils.b(contextX, R.string.command_display_string, objArr, (4 & 4) != 0 ? FormatUtils.b.j : null));
            TextView textView6 = this.binding.f2308b;
            Intrinsics3.checkNotNullExpressionValue(textView6, "binding.chatListAdapterItemTextCommand");
            anonymousClass1.invoke2(textView6);
            TextView textView7 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(textView7, "binding.chatListAdapterItemTextTimestamp");
            Context contextX2 = outline.x(this.itemView, "itemView", "itemView.context");
            timestamp = message.getTimestamp();
            if (timestamp != null) {
                dateTimeMillis = timestamp.getDateTimeMillis();
            } else {
                dateTimeMillis = 0;
            }
            textView7.setText(TimeUtils.toReadableTimeString$default(contextX2, dateTimeMillis, null, 4, null));
        }
        strGroup = AutocompleteViewModel.COMMAND_DISCOVER_TOKEN;
        strGroup2 = "";
        author = message.getAuthor();
        if (author != null) {
            lValueOf = Long.valueOf(author.getId());
        } else {
            lValueOf = null;
        }
        str = nickOrUsernames.get(lValueOf);
        if (str == null) {
            str = "";
        }
        View view2 = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
        int themedColor2 = ColorCompat.getThemedColor(view2, R.attr.color_brand_500);
        TextView textView8 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView8, "binding.chatListAdapterItemTextName");
        CharSequence charSequenceD2 = FormatUtils.d(textView8, R.string.system_message_application_command_used_short_mobile, new Object[]{str, strGroup}, new WidgetChatListAdapterItemApplicationCommand2(this, authorTextColor, message, themedColor2));
        TextView textView9 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView9, "binding.chatListAdapterItemTextName");
        textView9.setMovementMethod(LinkMovementMethod.getInstance());
        TextView textView10 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView10, "binding.chatListAdapterItemTextName");
        textView10.setText(charSequenceD2);
        TextView textView11 = this.binding.f2308b;
        Intrinsics3.checkNotNullExpressionValue(textView11, "binding.chatListAdapterItemTextCommand");
        textView11.setMaxLines(1);
        this.binding.f2308b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemApplicationCommand.onConfigure.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                TextView textView12 = WidgetChatListAdapterItemApplicationCommand.this.binding.f2308b;
                Intrinsics3.checkNotNullExpressionValue(textView12, "binding.chatListAdapterItemTextCommand");
                if (textView12.getMaxLines() == 1) {
                    TextView textView13 = WidgetChatListAdapterItemApplicationCommand.this.binding.f2308b;
                    Intrinsics3.checkNotNullExpressionValue(textView13, "binding.chatListAdapterItemTextCommand");
                    textView13.setMaxLines(Integer.MAX_VALUE);
                } else {
                    TextView textView14 = WidgetChatListAdapterItemApplicationCommand.this.binding.f2308b;
                    Intrinsics3.checkNotNullExpressionValue(textView14, "binding.chatListAdapterItemTextCommand");
                    textView14.setMaxLines(1);
                }
            }
        });
        z2 = !StringsJVM.isBlank(strGroup2);
        CardView cardView2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(cardView2, "binding.chatListAdapterItemTextDecorator");
        if (z2) {
            i = 0;
        } else {
            i = 8;
        }
        cardView2.setVisibility(i);
        FrameLayout frameLayout2 = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(frameLayout2, "binding.chatListAdapterI…extDecoratorReplyLinkIcon");
        frameLayout2.setVisibility(z2 ? 0 : 8);
        TextView textView12 = this.binding.f2308b;
        Intrinsics3.checkNotNullExpressionValue(textView12, "binding.chatListAdapterItemTextCommand");
        Context contextX3 = outline.x(this.itemView, "itemView", "itemView.context");
        Object[] objArr2 = new Object[2];
        type = message.getType();
        if (type != null) {
            str2 = strGroup;
        }
        objArr2[0] = str2;
        objArr2[1] = strGroup2;
        textView12.setText(FormatUtils.b(contextX3, R.string.command_display_string, objArr2, (4 & 4) != 0 ? FormatUtils.b.j : null));
        TextView textView13 = this.binding.f2308b;
        Intrinsics3.checkNotNullExpressionValue(textView13, "binding.chatListAdapterItemTextCommand");
        anonymousClass1.invoke2(textView13);
        TextView textView14 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(textView14, "binding.chatListAdapterItemTextTimestamp");
        Context contextX4 = outline.x(this.itemView, "itemView", "itemView.context");
        timestamp = message.getTimestamp();
        if (timestamp != null) {
            dateTimeMillis = timestamp.getDateTimeMillis();
        } else {
            dateTimeMillis = 0;
        }
        textView14.setText(TimeUtils.toReadableTimeString$default(contextX4, dateTimeMillis, null, 4, null));
    }
}
