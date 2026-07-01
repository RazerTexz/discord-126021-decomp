package com.discord.widgets.channels.threads.browser;

import a0.a.a.b;
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
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.role.GuildRole;
import com.discord.api.thread.ThreadMetadata;
import com.discord.databinding.ThreadBrowserThreadViewBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.CoreUser;
import com.discord.models.user.User;
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
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemGuildWelcome2;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ThreadBrowserThreadView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ThreadBrowserThreadView extends FrameLayout {
    private final ThreadBrowserThreadViewBinding binding;

    /* JADX INFO: compiled from: ThreadBrowserThreadView.kt */
    public static abstract class ThreadData {
        private final Channel channel;
        private final Map<Long, GuildMember> guildMembers;
        private final User owner;

        /* JADX INFO: compiled from: ThreadBrowserThreadView.kt */
        public static final /* data */ class ActiveThread extends ThreadData {
            private final Channel channel;
            private final Map<Long, String> channelNames;
            private final Map<Long, GuildMember> guildMembers;
            private final Map<Long, GuildRole> guildRoles;
            private final boolean isMessageBlocked;
            private final Message message;
            private final long myUserId;
            private final User owner;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ActiveThread(Channel channel, User user, Message message, long j, Map<Long, GuildMember> map, Map<Long, GuildRole> map2, Map<Long, String> map3, boolean z2) {
                super(channel, user, map, null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(map, "guildMembers");
                Intrinsics3.checkNotNullParameter(map2, "guildRoles");
                Intrinsics3.checkNotNullParameter(map3, "channelNames");
                this.channel = channel;
                this.owner = user;
                this.message = message;
                this.myUserId = j;
                this.guildMembers = map;
                this.guildRoles = map2;
                this.channelNames = map3;
                this.isMessageBlocked = z2;
            }

            public final Channel component1() {
                return getChannel();
            }

            public final User component2() {
                return getOwner();
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final Message getMessage() {
                return this.message;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final long getMyUserId() {
                return this.myUserId;
            }

            public final Map<Long, GuildMember> component5() {
                return getGuildMembers();
            }

            public final Map<Long, GuildRole> component6() {
                return this.guildRoles;
            }

            public final Map<Long, String> component7() {
                return this.channelNames;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final boolean getIsMessageBlocked() {
                return this.isMessageBlocked;
            }

            public final ActiveThread copy(Channel channel, User owner, Message message, long myUserId, Map<Long, GuildMember> guildMembers, Map<Long, GuildRole> guildRoles, Map<Long, String> channelNames, boolean isMessageBlocked) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
                Intrinsics3.checkNotNullParameter(guildRoles, "guildRoles");
                Intrinsics3.checkNotNullParameter(channelNames, "channelNames");
                return new ActiveThread(channel, owner, message, myUserId, guildMembers, guildRoles, channelNames, isMessageBlocked);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ActiveThread)) {
                    return false;
                }
                ActiveThread activeThread = (ActiveThread) other;
                return Intrinsics3.areEqual(getChannel(), activeThread.getChannel()) && Intrinsics3.areEqual(getOwner(), activeThread.getOwner()) && Intrinsics3.areEqual(this.message, activeThread.message) && this.myUserId == activeThread.myUserId && Intrinsics3.areEqual(getGuildMembers(), activeThread.getGuildMembers()) && Intrinsics3.areEqual(this.guildRoles, activeThread.guildRoles) && Intrinsics3.areEqual(this.channelNames, activeThread.channelNames) && this.isMessageBlocked == activeThread.isMessageBlocked;
            }

            @Override // com.discord.widgets.channels.threads.browser.ThreadBrowserThreadView.ThreadData
            public Channel getChannel() {
                return this.channel;
            }

            public final Map<Long, String> getChannelNames() {
                return this.channelNames;
            }

            @Override // com.discord.widgets.channels.threads.browser.ThreadBrowserThreadView.ThreadData
            public Map<Long, GuildMember> getGuildMembers() {
                return this.guildMembers;
            }

            public final Map<Long, GuildRole> getGuildRoles() {
                return this.guildRoles;
            }

            public final Message getMessage() {
                return this.message;
            }

            public final long getMyUserId() {
                return this.myUserId;
            }

            @Override // com.discord.widgets.channels.threads.browser.ThreadBrowserThreadView.ThreadData
            public User getOwner() {
                return this.owner;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v16, types: [int] */
            /* JADX WARN: Type inference failed for: r0v17 */
            /* JADX WARN: Type inference failed for: r0v21 */
            /* JADX WARN: Type inference failed for: r2v16, types: [int] */
            public int hashCode() {
                Channel channel = getChannel();
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                User owner = getOwner();
                int iHashCode2 = (iHashCode + (owner != null ? owner.hashCode() : 0)) * 31;
                Message message = this.message;
                int iA = (b.a(this.myUserId) + ((iHashCode2 + (message != null ? message.hashCode() : 0)) * 31)) * 31;
                Map<Long, GuildMember> guildMembers = getGuildMembers();
                int iHashCode3 = (iA + (guildMembers != null ? guildMembers.hashCode() : 0)) * 31;
                Map<Long, GuildRole> map = this.guildRoles;
                int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
                Map<Long, String> map2 = this.channelNames;
                int iHashCode5 = (iHashCode4 + (map2 != null ? map2.hashCode() : 0)) * 31;
                boolean z2 = this.isMessageBlocked;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                return iHashCode5 + r0;
            }

            public final boolean isMessageBlocked() {
                return this.isMessageBlocked;
            }

            public String toString() {
                StringBuilder sbU = outline.U("ActiveThread(channel=");
                sbU.append(getChannel());
                sbU.append(", owner=");
                sbU.append(getOwner());
                sbU.append(", message=");
                sbU.append(this.message);
                sbU.append(", myUserId=");
                sbU.append(this.myUserId);
                sbU.append(", guildMembers=");
                sbU.append(getGuildMembers());
                sbU.append(", guildRoles=");
                sbU.append(this.guildRoles);
                sbU.append(", channelNames=");
                sbU.append(this.channelNames);
                sbU.append(", isMessageBlocked=");
                return outline.O(sbU, this.isMessageBlocked, ")");
            }
        }

        /* JADX INFO: compiled from: ThreadBrowserThreadView.kt */
        public static final /* data */ class ArchivedThread extends ThreadData {
            private final Channel channel;
            private final Map<Long, GuildMember> guildMembers;
            private final User owner;
            private final TimestampMode timestampMode;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ArchivedThread(Channel channel, Map<Long, GuildMember> map, User user, TimestampMode timestampMode) {
                super(channel, user, map, null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(map, "guildMembers");
                Intrinsics3.checkNotNullParameter(timestampMode, "timestampMode");
                this.channel = channel;
                this.guildMembers = map;
                this.owner = user;
                this.timestampMode = timestampMode;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ ArchivedThread copy$default(ArchivedThread archivedThread, Channel channel, Map map, User user, TimestampMode timestampMode, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = archivedThread.getChannel();
                }
                if ((i & 2) != 0) {
                    map = archivedThread.getGuildMembers();
                }
                if ((i & 4) != 0) {
                    user = archivedThread.getOwner();
                }
                if ((i & 8) != 0) {
                    timestampMode = archivedThread.timestampMode;
                }
                return archivedThread.copy(channel, map, user, timestampMode);
            }

            public final Channel component1() {
                return getChannel();
            }

            public final Map<Long, GuildMember> component2() {
                return getGuildMembers();
            }

            public final User component3() {
                return getOwner();
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final TimestampMode getTimestampMode() {
                return this.timestampMode;
            }

            public final ArchivedThread copy(Channel channel, Map<Long, GuildMember> guildMembers, User owner, TimestampMode timestampMode) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
                Intrinsics3.checkNotNullParameter(timestampMode, "timestampMode");
                return new ArchivedThread(channel, guildMembers, owner, timestampMode);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ArchivedThread)) {
                    return false;
                }
                ArchivedThread archivedThread = (ArchivedThread) other;
                return Intrinsics3.areEqual(getChannel(), archivedThread.getChannel()) && Intrinsics3.areEqual(getGuildMembers(), archivedThread.getGuildMembers()) && Intrinsics3.areEqual(getOwner(), archivedThread.getOwner()) && Intrinsics3.areEqual(this.timestampMode, archivedThread.timestampMode);
            }

            @Override // com.discord.widgets.channels.threads.browser.ThreadBrowserThreadView.ThreadData
            public Channel getChannel() {
                return this.channel;
            }

            @Override // com.discord.widgets.channels.threads.browser.ThreadBrowserThreadView.ThreadData
            public Map<Long, GuildMember> getGuildMembers() {
                return this.guildMembers;
            }

            @Override // com.discord.widgets.channels.threads.browser.ThreadBrowserThreadView.ThreadData
            public User getOwner() {
                return this.owner;
            }

            public final TimestampMode getTimestampMode() {
                return this.timestampMode;
            }

            public int hashCode() {
                Channel channel = getChannel();
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                Map<Long, GuildMember> guildMembers = getGuildMembers();
                int iHashCode2 = (iHashCode + (guildMembers != null ? guildMembers.hashCode() : 0)) * 31;
                User owner = getOwner();
                int iHashCode3 = (iHashCode2 + (owner != null ? owner.hashCode() : 0)) * 31;
                TimestampMode timestampMode = this.timestampMode;
                return iHashCode3 + (timestampMode != null ? timestampMode.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("ArchivedThread(channel=");
                sbU.append(getChannel());
                sbU.append(", guildMembers=");
                sbU.append(getGuildMembers());
                sbU.append(", owner=");
                sbU.append(getOwner());
                sbU.append(", timestampMode=");
                sbU.append(this.timestampMode);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private ThreadData(Channel channel, User user, Map<Long, GuildMember> map) {
            this.channel = channel;
            this.owner = user;
            this.guildMembers = map;
        }

        public Channel getChannel() {
            return this.channel;
        }

        public Map<Long, GuildMember> getGuildMembers() {
            return this.guildMembers;
        }

        public User getOwner() {
            return this.owner;
        }

        public /* synthetic */ ThreadData(Channel channel, User user, Map map, DefaultConstructorMarker defaultConstructorMarker) {
            this(channel, user, map);
        }
    }

    /* JADX INFO: compiled from: ThreadBrowserThreadView.kt */
    public enum TimestampMode {
        ArchivedAt,
        CreatedAt
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            TimestampMode.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            TimestampMode timestampMode = TimestampMode.ArchivedAt;
            iArr[timestampMode.ordinal()] = 1;
            TimestampMode timestampMode2 = TimestampMode.CreatedAt;
            iArr[timestampMode2.ordinal()] = 2;
            TimestampMode.values();
            int[] iArr2 = new int[2];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[timestampMode.ordinal()] = 1;
            iArr2[timestampMode2.ordinal()] = 2;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.threads.browser.ThreadBrowserThreadView$setThreadData$1, reason: invalid class name */
    /* JADX INFO: compiled from: ThreadBrowserThreadView.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ GuildMember $creatorMember;
        public final /* synthetic */ String $creatorName;

        /* JADX INFO: renamed from: com.discord.widgets.channels.threads.browser.ThreadBrowserThreadView$setThreadData$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: ThreadBrowserThreadView.kt */
        public static final class C02511 extends Lambda implements Function1<Hook, Unit> {
            public C02511() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                Intrinsics3.checkNotNullParameter(hook, "$receiver");
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                hook.replacementText = anonymousClass1.$creatorName;
                hook.styles.addAll(ThreadBrowserThreadView.this.getMemberCharacterStyles(anonymousClass1.$creatorMember));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, GuildMember guildMember) {
            super(1);
            this.$creatorName = str;
            this.$creatorMember = guildMember;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.a("authorHook", new C02511());
        }
    }

    public ThreadBrowserThreadView(Context context) {
        this(context, null, 0, 6, null);
    }

    public ThreadBrowserThreadView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ThreadBrowserThreadView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0116  */
    /* JADX WARN: Code duplicated, block: B:34:0x0158 A[LOOP:0: B:32:0x0152->B:34:0x0158, LOOP_END] */
    private final void configureActiveThreadUI(ThreadData.ActiveThread threadData) {
        String string;
        DraweeSpanStringBuilder draweeSpanStringBuilderRender;
        String nickOrUsername$default;
        Iterator<T> it;
        Message message = threadData.getMessage();
        DraweeSpanStringBuilder draweeSpanStringBuilder = null;
        String content = message != null ? message.getContent() : null;
        if (message == null || content == null) {
            TextView textView = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.threadTimestampSeparator");
            textView.setVisibility(8);
            TextView textView2 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.threadTimestamp");
            textView2.setVisibility(8);
            if (threadData.getOwner() == null) {
                SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.threadMessage");
                simpleDraweeSpanTextView.setText(getContext().getString(R.string.thread_browser_no_recent_messages));
                configureAvatar$default(this, null, null, 2, null);
                return;
            }
            return;
        }
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        MessageRenderContext messageRenderContext = new MessageRenderContext(context, threadData.getMyUserId(), true, MessageUtils.getNickOrUsernames$default(message, threadData.getChannel(), threadData.getGuildMembers(), null, 8, null), threadData.getChannelNames(), threadData.getGuildRoles(), 0, null, null, ColorCompat.getThemedColor(getContext(), R.attr.theme_chat_spoiler_inapp_bg), 0, null, null, null, 15808, null);
        com.discord.api.user.User author = threadData.getMessage().getAuthor();
        Intrinsics3.checkNotNull(author);
        CoreUser coreUser = new CoreUser(author);
        if (threadData.isMessageBlocked()) {
            string = getContext().getString(R.string.reply_quote_message_blocked);
        } else if (message.hasStickers()) {
            string = getContext().getString(R.string.reply_quote_sticker_mobile);
        } else {
            string = (message.hasAttachments() || message.hasEmbeds()) ? getContext().getString(R.string.reply_quote_no_text_content_mobile) : null;
        }
        if (string == null) {
            if (!StringsJVM.isBlank(content)) {
                draweeSpanStringBuilderRender = AstRenderer.render(Parser.parse$default(DiscordParser.createParser$default(false, true, false, false, false, 28, null), content, MessageParseState.INSTANCE.getInitialState(), null, 4, null), messageRenderContext);
            }
            if (draweeSpanStringBuilderRender != null) {
                GuildMember guildMember = threadData.getGuildMembers().get(Long.valueOf(coreUser.getId()));
                nickOrUsername$default = GuildMember.Companion.getNickOrUsername$default(GuildMember.INSTANCE, coreUser, guildMember, threadData.getChannel(), null, 8, null);
                draweeSpanStringBuilderRender.insert(0, (CharSequence) new SpannableStringBuilder(outline.w(nickOrUsername$default, ": ")));
                it = getMemberCharacterStyles(guildMember).iterator();
                while (it.hasNext()) {
                    draweeSpanStringBuilderRender.setSpan((CharacterStyle) it.next(), 0, nickOrUsername$default.length(), 33);
                }
                this.binding.d.setDraweeSpanStringBuilder(draweeSpanStringBuilderRender);
            }
            TextView textView3 = this.binding.g;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.threadTimestampSeparator");
            textView3.setVisibility(0);
            TextView textView4 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(textView4, r14);
            textView4.setVisibility(0);
            configureAvatar(coreUser, threadData.getGuildMembers().get(Long.valueOf(coreUser.getId())));
            TextView textView5 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(textView5, "binding.threadTimestamp");
            textView5.setText(formatActivityTimestamp((message.getId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH));
        }
        draweeSpanStringBuilder = new DraweeSpanStringBuilder();
        draweeSpanStringBuilder.append((CharSequence) (string + (char) 160));
        draweeSpanStringBuilder.setSpan(new StyleSpan(2), 0, string.length(), 33);
        draweeSpanStringBuilderRender = draweeSpanStringBuilder;
        if (draweeSpanStringBuilderRender != null) {
            GuildMember guildMember2 = threadData.getGuildMembers().get(Long.valueOf(coreUser.getId()));
            nickOrUsername$default = GuildMember.Companion.getNickOrUsername$default(GuildMember.INSTANCE, coreUser, guildMember2, threadData.getChannel(), null, 8, null);
            draweeSpanStringBuilderRender.insert(0, (CharSequence) new SpannableStringBuilder(outline.w(nickOrUsername$default, ": ")));
            it = getMemberCharacterStyles(guildMember2).iterator();
            while (it.hasNext()) {
                draweeSpanStringBuilderRender.setSpan((CharacterStyle) it.next(), 0, nickOrUsername$default.length(), 33);
            }
            this.binding.d.setDraweeSpanStringBuilder(draweeSpanStringBuilderRender);
        }
        TextView textView6 = this.binding.g;
        Intrinsics3.checkNotNullExpressionValue(textView6, "binding.threadTimestampSeparator");
        textView6.setVisibility(0);
        TextView textView7 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(textView7, r14);
        textView7.setVisibility(0);
        configureAvatar(coreUser, threadData.getGuildMembers().get(Long.valueOf(coreUser.getId())));
        TextView textView8 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(textView8, "binding.threadTimestamp");
        textView8.setText(formatActivityTimestamp((message.getId() >>> 22) + SnowflakeUtils.DISCORD_EPOCH));
    }

    private final void configureArchivedThreadUI(ThreadData.ArchivedThread threadData) {
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
                i = R.string.thread_browser_archive_time;
            } else {
                if (iOrdinal2 != 1) {
                    throw new NoWhenBranchMatchedException();
                }
                i = R.string.thread_browser_creation_time;
            }
            TextView textView = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.threadTimestamp");
            Context context = getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            textView.setText(FormatUtils.b(context, i, new Object[]{formatDateTimestamp(uTCDate)}, (4 & 4) != 0 ? FormatUtils.b.j : null));
            User owner = threadData.getOwner();
            Map<Long, GuildMember> guildMembers = threadData.getGuildMembers();
            User owner2 = threadData.getOwner();
            configureAvatar(owner, guildMembers.get(owner2 != null ? Long.valueOf(owner2.getId()) : null));
        }
    }

    private final void configureAvatar(User user, GuildMember guildMember) {
        if (user == null) {
            ImageView imageView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.threadIcon");
            imageView.setVisibility(0);
            SimpleDraweeView simpleDraweeView = this.binding.f2161b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.threadAvatar");
            simpleDraweeView.setVisibility(8);
            return;
        }
        ImageView imageView2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.threadIcon");
        imageView2.setVisibility(8);
        SimpleDraweeView simpleDraweeView2 = this.binding.f2161b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.threadAvatar");
        simpleDraweeView2.setVisibility(0);
        SimpleDraweeView simpleDraweeView3 = this.binding.f2161b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.threadAvatar");
        IconUtils.setIcon$default(simpleDraweeView3, user, R.dimen.avatar_size_small, null, null, guildMember, 24, null);
    }

    public static /* synthetic */ void configureAvatar$default(ThreadBrowserThreadView threadBrowserThreadView, User user, GuildMember guildMember, int i, Object obj) {
        if ((i & 2) != 0) {
            guildMember = null;
        }
        threadBrowserThreadView.configureAvatar(user, guildMember);
    }

    private final CharSequence formatActivityTimestamp(long timestamp) {
        long jCurrentTimeMillis = ClockFactory.get().currentTimeMillis() - timestamp;
        if (jCurrentTimeMillis < 60000) {
            Context context = getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            return FormatUtils.b(context, R.string.thread_browser_timestamp_minutes, new Object[]{1}, (4 & 4) != 0 ? FormatUtils.b.j : null);
        }
        if (jCurrentTimeMillis < 3600000) {
            Context context2 = getContext();
            Intrinsics3.checkNotNullExpressionValue(context2, "context");
            return FormatUtils.b(context2, R.string.thread_browser_timestamp_minutes, new Object[]{Long.valueOf(jCurrentTimeMillis / 60000)}, (4 & 4) != 0 ? FormatUtils.b.j : null);
        }
        if (jCurrentTimeMillis < 86400000) {
            Context context3 = getContext();
            Intrinsics3.checkNotNullExpressionValue(context3, "context");
            return FormatUtils.b(context3, R.string.thread_browser_timestamp_hours, new Object[]{Long.valueOf(jCurrentTimeMillis / 3600000)}, (4 & 4) != 0 ? FormatUtils.b.j : null);
        }
        if (jCurrentTimeMillis < WidgetChatListAdapterItemGuildWelcome2.OLD_GUILD_AGE_THRESHOLD) {
            Context context4 = getContext();
            Intrinsics3.checkNotNullExpressionValue(context4, "context");
            return FormatUtils.b(context4, R.string.thread_browser_timestamp_days, new Object[]{Long.valueOf(jCurrentTimeMillis / 86400000)}, (4 & 4) != 0 ? FormatUtils.b.j : null);
        }
        String string = getContext().getString(R.string.thread_browser_timestamp_more_than_month);
        Intrinsics3.checkNotNullExpressionValue(string, "context.getString(R.stri…imestamp_more_than_month)");
        return string;
    }

    private final CharSequence formatDateTimestamp(long timestamp) {
        long jCurrentTimeMillis = ClockFactory.get().currentTimeMillis() - timestamp;
        if (jCurrentTimeMillis < 60000) {
            Context context = getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            return FormatUtils.b(context, R.string.thread_browser_timestamp_minutes, new Object[]{1}, (4 & 4) != 0 ? FormatUtils.b.j : null);
        }
        if (jCurrentTimeMillis < 3600000) {
            Context context2 = getContext();
            Intrinsics3.checkNotNullExpressionValue(context2, "context");
            return FormatUtils.b(context2, R.string.thread_browser_timestamp_minutes, new Object[]{Long.valueOf(jCurrentTimeMillis / 60000)}, (4 & 4) != 0 ? FormatUtils.b.j : null);
        }
        if (jCurrentTimeMillis < 86400000) {
            Context context3 = getContext();
            Intrinsics3.checkNotNullExpressionValue(context3, "context");
            return FormatUtils.b(context3, R.string.thread_browser_timestamp_hours, new Object[]{Long.valueOf(jCurrentTimeMillis / 3600000)}, (4 & 4) != 0 ? FormatUtils.b.j : null);
        }
        String dateTime = DateUtils.formatDateTime(getContext(), timestamp, 131076);
        Intrinsics3.checkNotNullExpressionValue(dateTime, "DateUtils.formatDateTime…teUtils.FORMAT_SHOW_YEAR)");
        return dateTime;
    }

    private final List<CharacterStyle> getMemberCharacterStyles(GuildMember member) {
        ArrayList arrayList = new ArrayList();
        FontUtils fontUtils = FontUtils.INSTANCE;
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        Typeface themedFont = fontUtils.getThemedFont(context, R.attr.font_primary_semibold);
        if (themedFont != null) {
            arrayList.add(new TypefaceSpanCompat(themedFont));
        }
        if (member != null) {
            arrayList.add(new ForegroundColorSpan(GuildMember.INSTANCE.getColor(member, ColorCompat.getThemedColor(getContext(), R.attr.colorHeaderPrimary))));
        }
        return arrayList;
    }

    public final void setThreadData(ThreadData threadData) {
        Intrinsics3.checkNotNullParameter(threadData, "threadData");
        TextView textView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.threadName");
        Channel channel = threadData.getChannel();
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        textView.setText(ChannelUtils.d(channel, context, false));
        User owner = threadData.getOwner();
        if (owner == null) {
            owner = new CoreUser(threadData.getChannel().getOwnerId(), null, null, null, false, false, 0, null, 0, 0, null, null, 4094, null);
        }
        GuildMember guildMember = (GuildMember) outline.f(owner, threadData.getGuildMembers());
        String nickOrUsername$default = GuildMember.Companion.getNickOrUsername$default(GuildMember.INSTANCE, owner, guildMember, threadData.getChannel(), null, 8, null);
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.threadMessage");
        FormatUtils.m(simpleDraweeSpanTextView, R.string.thread_browser_started_by, new Object[0], new AnonymousClass1(nickOrUsername$default, guildMember));
        if (threadData instanceof ThreadData.ActiveThread) {
            configureActiveThreadUI((ThreadData.ActiveThread) threadData);
        } else if (threadData instanceof ThreadData.ArchivedThread) {
            configureArchivedThreadUI((ThreadData.ArchivedThread) threadData);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThreadBrowserThreadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.thread_browser_thread_view, this);
        int i2 = R.id.thread_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.thread_avatar);
        if (simpleDraweeView != null) {
            i2 = R.id.thread_icon;
            ImageView imageView = (ImageView) findViewById(R.id.thread_icon);
            if (imageView != null) {
                i2 = R.id.thread_image;
                FrameLayout frameLayout = (FrameLayout) findViewById(R.id.thread_image);
                if (frameLayout != null) {
                    i2 = R.id.thread_message;
                    SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) findViewById(R.id.thread_message);
                    if (simpleDraweeSpanTextView != null) {
                        i2 = R.id.thread_name;
                        TextView textView = (TextView) findViewById(R.id.thread_name);
                        if (textView != null) {
                            i2 = R.id.thread_timestamp;
                            TextView textView2 = (TextView) findViewById(R.id.thread_timestamp);
                            if (textView2 != null) {
                                i2 = R.id.thread_timestamp_separator;
                                TextView textView3 = (TextView) findViewById(R.id.thread_timestamp_separator);
                                if (textView3 != null) {
                                    ThreadBrowserThreadViewBinding threadBrowserThreadViewBinding = new ThreadBrowserThreadViewBinding(this, simpleDraweeView, imageView, frameLayout, simpleDraweeSpanTextView, textView, textView2, textView3);
                                    Intrinsics3.checkNotNullExpressionValue(threadBrowserThreadViewBinding, "ThreadBrowserThreadViewB…ater.from(context), this)");
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
