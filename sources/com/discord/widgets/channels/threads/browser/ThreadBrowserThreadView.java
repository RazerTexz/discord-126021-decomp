package com.discord.widgets.channels.threads.browser;

import android.content.Context;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.format.DateUtils;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.thread.ThreadMetadata;
import com.discord.api.user.User;
import com.discord.databinding.ThreadBrowserThreadViewBinding;
import com.discord.models.member.GuildMember;
import com.discord.models.member.GuildMember$Companion;
import com.discord.models.message.Message;
import com.discord.models.user.CoreUser;
import com.discord.simpleast.core.parser.Parser;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.message.MessageUtils;
import com.discord.utilities.spans.TypefaceSpanCompat;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildWelcomeKt;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g0.t;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ThreadBrowserThreadView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ThreadBrowserThreadView extends FrameLayout {
    private final ThreadBrowserThreadViewBinding binding;

    public ThreadBrowserThreadView(Context context) {
        this(context, null, 0, 6, null);
    }

    public ThreadBrowserThreadView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ThreadBrowserThreadView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final /* synthetic */ List access$getMemberCharacterStyles(ThreadBrowserThreadView threadBrowserThreadView, GuildMember guildMember) {
        return threadBrowserThreadView.getMemberCharacterStyles(guildMember);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0116  */
    /* JADX WARN: Code duplicated, block: B:34:0x0158 A[LOOP:0: B:32:0x0152->B:34:0x0158, LOOP_END] */
    private final void configureActiveThreadUI(ThreadBrowserThreadView$ThreadData$ActiveThread threadData) {
        String string;
        DraweeSpanStringBuilder draweeSpanStringBuilderRender;
        String nickOrUsername$default;
        Iterator<T> it;
        Message message = threadData.getMessage();
        DraweeSpanStringBuilder draweeSpanStringBuilder = null;
        String content = message != null ? message.getContent() : null;
        if (message == null || content == null) {
            TextView textView = this.binding.g;
            m.checkNotNullExpressionValue(textView, "binding.threadTimestampSeparator");
            textView.setVisibility(8);
            TextView textView2 = this.binding.f;
            m.checkNotNullExpressionValue(textView2, "binding.threadTimestamp");
            textView2.setVisibility(8);
            if (threadData.getOwner() == null) {
                SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.d;
                m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.threadMessage");
                simpleDraweeSpanTextView.setText(getContext().getString(2131896361));
                configureAvatar$default(this, null, null, 2, null);
                return;
            }
            return;
        }
        Context context = getContext();
        m.checkNotNullExpressionValue(context, "context");
        MessageRenderContext messageRenderContext = new MessageRenderContext(context, threadData.getMyUserId(), true, MessageUtils.getNickOrUsernames$default(message, threadData.getChannel(), threadData.getGuildMembers(), null, 8, null), threadData.getChannelNames(), threadData.getGuildRoles(), 0, null, null, ColorCompat.getThemedColor(getContext(), 2130970293), 0, null, null, null, 15808, null);
        User author = threadData.getMessage().getAuthor();
        m.checkNotNull(author);
        CoreUser coreUser = new CoreUser(author);
        if (threadData.isMessageBlocked()) {
            string = getContext().getString(2131894770);
        } else if (message.hasStickers()) {
            string = getContext().getString(2131894776);
        } else {
            string = (message.hasAttachments() || message.hasEmbeds()) ? getContext().getString(2131894774) : null;
        }
        if (string == null) {
            if (!t.isBlank(content)) {
                draweeSpanStringBuilderRender = AstRenderer.render(Parser.parse$default(DiscordParser.createParser$default(false, true, false, false, false, 28, null), content, MessageParseState.Companion.getInitialState(), null, 4, null), messageRenderContext);
            }
            if (draweeSpanStringBuilderRender != null) {
                GuildMember guildMember = threadData.getGuildMembers().get(Long.valueOf(coreUser.getId()));
                nickOrUsername$default = GuildMember$Companion.getNickOrUsername$default(GuildMember.Companion, coreUser, guildMember, threadData.getChannel(), null, 8, null);
                draweeSpanStringBuilderRender.insert(0, (CharSequence) new SpannableStringBuilder(a.w(nickOrUsername$default, ": ")));
                it = getMemberCharacterStyles(guildMember).iterator();
                while (it.hasNext()) {
                    draweeSpanStringBuilderRender.setSpan((CharacterStyle) it.next(), 0, nickOrUsername$default.length(), 33);
                }
                this.binding.d.setDraweeSpanStringBuilder(draweeSpanStringBuilderRender);
            }
            TextView textView3 = this.binding.g;
            m.checkNotNullExpressionValue(textView3, "binding.threadTimestampSeparator");
            textView3.setVisibility(0);
            TextView textView4 = this.binding.f;
            m.checkNotNullExpressionValue(textView4, r14);
            textView4.setVisibility(0);
            configureAvatar(coreUser, threadData.getGuildMembers().get(Long.valueOf(coreUser.getId())));
            TextView textView5 = this.binding.f;
            m.checkNotNullExpressionValue(textView5, "binding.threadTimestamp");
            textView5.setText(formatActivityTimestamp((message.getId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH));
        }
        draweeSpanStringBuilder = new DraweeSpanStringBuilder();
        draweeSpanStringBuilder.append((CharSequence) (string + (char) 160));
        draweeSpanStringBuilder.setSpan(new StyleSpan(2), 0, string.length(), 33);
        draweeSpanStringBuilderRender = draweeSpanStringBuilder;
        if (draweeSpanStringBuilderRender != null) {
            GuildMember guildMember2 = threadData.getGuildMembers().get(Long.valueOf(coreUser.getId()));
            nickOrUsername$default = GuildMember$Companion.getNickOrUsername$default(GuildMember.Companion, coreUser, guildMember2, threadData.getChannel(), null, 8, null);
            draweeSpanStringBuilderRender.insert(0, (CharSequence) new SpannableStringBuilder(a.w(nickOrUsername$default, ": ")));
            it = getMemberCharacterStyles(guildMember2).iterator();
            while (it.hasNext()) {
                draweeSpanStringBuilderRender.setSpan((CharacterStyle) it.next(), 0, nickOrUsername$default.length(), 33);
            }
            this.binding.d.setDraweeSpanStringBuilder(draweeSpanStringBuilderRender);
        }
        TextView textView6 = this.binding.g;
        m.checkNotNullExpressionValue(textView6, "binding.threadTimestampSeparator");
        textView6.setVisibility(0);
        TextView textView7 = this.binding.f;
        m.checkNotNullExpressionValue(textView7, r14);
        textView7.setVisibility(0);
        configureAvatar(coreUser, threadData.getGuildMembers().get(Long.valueOf(coreUser.getId())));
        TextView textView8 = this.binding.f;
        m.checkNotNullExpressionValue(textView8, "binding.threadTimestamp");
        textView8.setText(formatActivityTimestamp((message.getId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH));
    }

    private final void configureArchivedThreadUI(ThreadBrowserThreadView$ThreadData$ArchivedThread threadData) {
        long uTCDate;
        int i;
        ThreadMetadata threadMetadata = threadData.getChannel().getThreadMetadata();
        if (threadMetadata != null) {
            int iOrdinal = threadData.getTimestampMode().ordinal();
            if (iOrdinal == 0) {
                uTCDate = TimeUtils.parseUTCDate(threadMetadata.getArchiveTimestamp());
            } else {
                if (iOrdinal != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                uTCDate = (threadData.getChannel().getId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH;
            }
            int iOrdinal2 = threadData.getTimestampMode().ordinal();
            if (iOrdinal2 == 0) {
                i = 2131896347;
            } else {
                if (iOrdinal2 != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                i = 2131896350;
            }
            TextView textView = this.binding.f;
            m.checkNotNullExpressionValue(textView, "binding.threadTimestamp");
            Context context = getContext();
            m.checkNotNullExpressionValue(context, "context");
            textView.setText(b.h(context, i, new Object[]{formatDateTimestamp(uTCDate)}, null, 4));
            com.discord.models.user.User owner = threadData.getOwner();
            Map<Long, GuildMember> guildMembers = threadData.getGuildMembers();
            com.discord.models.user.User owner2 = threadData.getOwner();
            configureAvatar(owner, guildMembers.get(owner2 != null ? Long.valueOf(owner2.getId()) : null));
        }
    }

    private final void configureAvatar(com.discord.models.user.User user, GuildMember guildMember) {
        if (user == null) {
            ImageView imageView = this.binding.c;
            m.checkNotNullExpressionValue(imageView, "binding.threadIcon");
            imageView.setVisibility(0);
            SimpleDraweeView simpleDraweeView = this.binding.f2161b;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.threadAvatar");
            simpleDraweeView.setVisibility(8);
            return;
        }
        ImageView imageView2 = this.binding.c;
        m.checkNotNullExpressionValue(imageView2, "binding.threadIcon");
        imageView2.setVisibility(8);
        SimpleDraweeView simpleDraweeView2 = this.binding.f2161b;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.threadAvatar");
        simpleDraweeView2.setVisibility(0);
        SimpleDraweeView simpleDraweeView3 = this.binding.f2161b;
        m.checkNotNullExpressionValue(simpleDraweeView3, "binding.threadAvatar");
        IconUtils.setIcon$default(simpleDraweeView3, user, 2131165299, null, null, guildMember, 24, null);
    }

    public static /* synthetic */ void configureAvatar$default(ThreadBrowserThreadView threadBrowserThreadView, com.discord.models.user.User user, GuildMember guildMember, int i, Object obj) {
        if ((i & 2) != 0) {
            guildMember = null;
        }
        threadBrowserThreadView.configureAvatar(user, guildMember);
    }

    private final CharSequence formatActivityTimestamp(long timestamp) {
        long jCurrentTimeMillis = ClockFactory.get().currentTimeMillis() - timestamp;
        if (jCurrentTimeMillis < 60000) {
            Context context = getContext();
            m.checkNotNullExpressionValue(context, "context");
            return b.h(context, 2131896370, new Object[]{1}, null, 4);
        }
        if (jCurrentTimeMillis < 3600000) {
            Context context2 = getContext();
            m.checkNotNullExpressionValue(context2, "context");
            return b.h(context2, 2131896370, new Object[]{Long.valueOf(jCurrentTimeMillis / 60000)}, null, 4);
        }
        if (jCurrentTimeMillis < 86400000) {
            Context context3 = getContext();
            m.checkNotNullExpressionValue(context3, "context");
            return b.h(context3, 2131896369, new Object[]{Long.valueOf(jCurrentTimeMillis / 3600000)}, null, 4);
        }
        if (jCurrentTimeMillis < WidgetChatListAdapterItemGuildWelcomeKt.OLD_GUILD_AGE_THRESHOLD) {
            Context context4 = getContext();
            m.checkNotNullExpressionValue(context4, "context");
            return b.h(context4, 2131896368, new Object[]{Long.valueOf(jCurrentTimeMillis / 86400000)}, null, 4);
        }
        String string = getContext().getString(2131896371);
        m.checkNotNullExpressionValue(string, "context.getString(R.stri…imestamp_more_than_month)");
        return string;
    }

    private final CharSequence formatDateTimestamp(long timestamp) {
        long jCurrentTimeMillis = ClockFactory.get().currentTimeMillis() - timestamp;
        if (jCurrentTimeMillis < 60000) {
            Context context = getContext();
            m.checkNotNullExpressionValue(context, "context");
            return b.h(context, 2131896370, new Object[]{1}, null, 4);
        }
        if (jCurrentTimeMillis < 3600000) {
            Context context2 = getContext();
            m.checkNotNullExpressionValue(context2, "context");
            return b.h(context2, 2131896370, new Object[]{Long.valueOf(jCurrentTimeMillis / 60000)}, null, 4);
        }
        if (jCurrentTimeMillis < 86400000) {
            Context context3 = getContext();
            m.checkNotNullExpressionValue(context3, "context");
            return b.h(context3, 2131896369, new Object[]{Long.valueOf(jCurrentTimeMillis / 3600000)}, null, 4);
        }
        String dateTime = DateUtils.formatDateTime(getContext(), timestamp, 131076);
        m.checkNotNullExpressionValue(dateTime, "DateUtils.formatDateTime…teUtils.FORMAT_SHOW_YEAR)");
        return dateTime;
    }

    private final List<CharacterStyle> getMemberCharacterStyles(GuildMember member) {
        ArrayList arrayList = new ArrayList();
        FontUtils fontUtils = FontUtils.INSTANCE;
        Context context = getContext();
        m.checkNotNullExpressionValue(context, "context");
        Typeface themedFont = fontUtils.getThemedFont(context, 2130969396);
        if (themedFont != null) {
            arrayList.add(new TypefaceSpanCompat(themedFont));
        }
        if (member != null) {
            arrayList.add(new ForegroundColorSpan(GuildMember.Companion.getColor(member, ColorCompat.getThemedColor(getContext(), 2130968989))));
        }
        return arrayList;
    }

    public final void setThreadData(ThreadBrowserThreadView$ThreadData threadData) {
        m.checkNotNullParameter(threadData, "threadData");
        TextView textView = this.binding.e;
        m.checkNotNullExpressionValue(textView, "binding.threadName");
        Channel channel = threadData.getChannel();
        Context context = getContext();
        m.checkNotNullExpressionValue(context, "context");
        textView.setText(ChannelUtils.d(channel, context, false));
        com.discord.models.user.User owner = threadData.getOwner();
        if (owner == null) {
            owner = new CoreUser(threadData.getChannel().getOwnerId(), null, null, null, false, false, 0, null, 0, 0, null, null, 4094, null);
        }
        GuildMember guildMember = (GuildMember) a.f(owner, threadData.getGuildMembers());
        String nickOrUsername$default = GuildMember$Companion.getNickOrUsername$default(GuildMember.Companion, owner, guildMember, threadData.getChannel(), null, 8, null);
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.d;
        m.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.threadMessage");
        b.m(simpleDraweeSpanTextView, 2131896367, new Object[0], new ThreadBrowserThreadView$setThreadData$1(this, nickOrUsername$default, guildMember));
        if (threadData instanceof ThreadBrowserThreadView$ThreadData$ActiveThread) {
            configureActiveThreadUI((ThreadBrowserThreadView$ThreadData$ActiveThread) threadData);
        } else if (threadData instanceof ThreadBrowserThreadView$ThreadData$ArchivedThread) {
            configureArchivedThreadUI((ThreadBrowserThreadView$ThreadData$ArchivedThread) threadData);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadBrowserThreadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R$layout.thread_browser_thread_view, this);
        int i2 = R$id.thread_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R$id.thread_avatar);
        if (simpleDraweeView != null) {
            i2 = R$id.thread_icon;
            ImageView imageView = (ImageView) findViewById(R$id.thread_icon);
            if (imageView != null) {
                i2 = R$id.thread_image;
                FrameLayout frameLayout = (FrameLayout) findViewById(R$id.thread_image);
                if (frameLayout != null) {
                    i2 = R$id.thread_message;
                    SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) findViewById(R$id.thread_message);
                    if (simpleDraweeSpanTextView != null) {
                        i2 = R$id.thread_name;
                        TextView textView = (TextView) findViewById(R$id.thread_name);
                        if (textView != null) {
                            i2 = R$id.thread_timestamp;
                            TextView textView2 = (TextView) findViewById(R$id.thread_timestamp);
                            if (textView2 != null) {
                                i2 = R$id.thread_timestamp_separator;
                                TextView textView3 = (TextView) findViewById(R$id.thread_timestamp_separator);
                                if (textView3 != null) {
                                    ThreadBrowserThreadViewBinding threadBrowserThreadViewBinding = new ThreadBrowserThreadViewBinding(this, simpleDraweeView, imageView, frameLayout, simpleDraweeSpanTextView, textView, textView2, textView3);
                                    m.checkNotNullExpressionValue(threadBrowserThreadViewBinding, "ThreadBrowserThreadViewB…ater.from(context), this)");
                                    this.binding = threadBrowserThreadViewBinding;
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i2)));
    }
}
