package com.discord.widgets.chat.list.utils;

import android.content.Context;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.role.GuildRole;
import com.discord.api.user.User;
import com.discord.models.message.Message;
import com.discord.stores.StoreMessageState;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessagePreprocessor;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.uri.UriHandler;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.text.Regex;

/* JADX INFO: compiled from: EmbeddedMessageParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmbeddedMessageParser {
    public static final EmbeddedMessageParser INSTANCE = new EmbeddedMessageParser();

    /* JADX INFO: compiled from: EmbeddedMessageParser.kt */
    public static final /* data */ class ParserData {
        private final WidgetChatListAdapter adapter;
        private final boolean animateEmojis;
        private final Context context;
        private final Integer maxNodes;
        private final Message message;
        private final StoreMessageState.State messageState;
        private final Map<Long, String> nickOrUsernames;
        private final Map<Long, GuildRole> roleMentions;

        public ParserData(Context context, Map<Long, GuildRole> map, Map<Long, String> map2, boolean z2, StoreMessageState.State state, Integer num, Message message, WidgetChatListAdapter widgetChatListAdapter) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(map2, "nickOrUsernames");
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
            this.context = context;
            this.roleMentions = map;
            this.nickOrUsernames = map2;
            this.animateEmojis = z2;
            this.messageState = state;
            this.maxNodes = num;
            this.message = message;
            this.adapter = widgetChatListAdapter;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Context getContext() {
            return this.context;
        }

        public final Map<Long, GuildRole> component2() {
            return this.roleMentions;
        }

        public final Map<Long, String> component3() {
            return this.nickOrUsernames;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getAnimateEmojis() {
            return this.animateEmojis;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final StoreMessageState.State getMessageState() {
            return this.messageState;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Integer getMaxNodes() {
            return this.maxNodes;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Message getMessage() {
            return this.message;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final WidgetChatListAdapter getAdapter() {
            return this.adapter;
        }

        public final ParserData copy(Context context, Map<Long, GuildRole> roleMentions, Map<Long, String> nickOrUsernames, boolean animateEmojis, StoreMessageState.State messageState, Integer maxNodes, Message message, WidgetChatListAdapter adapter) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(nickOrUsernames, "nickOrUsernames");
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(adapter, "adapter");
            return new ParserData(context, roleMentions, nickOrUsernames, animateEmojis, messageState, maxNodes, message, adapter);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ParserData)) {
                return false;
            }
            ParserData parserData = (ParserData) other;
            return Intrinsics3.areEqual(this.context, parserData.context) && Intrinsics3.areEqual(this.roleMentions, parserData.roleMentions) && Intrinsics3.areEqual(this.nickOrUsernames, parserData.nickOrUsernames) && this.animateEmojis == parserData.animateEmojis && Intrinsics3.areEqual(this.messageState, parserData.messageState) && Intrinsics3.areEqual(this.maxNodes, parserData.maxNodes) && Intrinsics3.areEqual(this.message, parserData.message) && Intrinsics3.areEqual(this.adapter, parserData.adapter);
        }

        public final WidgetChatListAdapter getAdapter() {
            return this.adapter;
        }

        public final boolean getAnimateEmojis() {
            return this.animateEmojis;
        }

        public final Context getContext() {
            return this.context;
        }

        public final Integer getMaxNodes() {
            return this.maxNodes;
        }

        public final Message getMessage() {
            return this.message;
        }

        public final StoreMessageState.State getMessageState() {
            return this.messageState;
        }

        public final Map<Long, String> getNickOrUsernames() {
            return this.nickOrUsernames;
        }

        public final Map<Long, GuildRole> getRoleMentions() {
            return this.roleMentions;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r2v21 */
        /* JADX WARN: Type inference failed for: r2v24 */
        /* JADX WARN: Type inference failed for: r2v7, types: [int] */
        public int hashCode() {
            Context context = this.context;
            int iHashCode = (context != null ? context.hashCode() : 0) * 31;
            Map<Long, GuildRole> map = this.roleMentions;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, String> map2 = this.nickOrUsernames;
            int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
            boolean z2 = this.animateEmojis;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode3 + r2) * 31;
            StoreMessageState.State state = this.messageState;
            int iHashCode4 = (i + (state != null ? state.hashCode() : 0)) * 31;
            Integer num = this.maxNodes;
            int iHashCode5 = (iHashCode4 + (num != null ? num.hashCode() : 0)) * 31;
            Message message = this.message;
            int iHashCode6 = (iHashCode5 + (message != null ? message.hashCode() : 0)) * 31;
            WidgetChatListAdapter widgetChatListAdapter = this.adapter;
            return iHashCode6 + (widgetChatListAdapter != null ? widgetChatListAdapter.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ParserData(context=");
            sbU.append(this.context);
            sbU.append(", roleMentions=");
            sbU.append(this.roleMentions);
            sbU.append(", nickOrUsernames=");
            sbU.append(this.nickOrUsernames);
            sbU.append(", animateEmojis=");
            sbU.append(this.animateEmojis);
            sbU.append(", messageState=");
            sbU.append(this.messageState);
            sbU.append(", maxNodes=");
            sbU.append(this.maxNodes);
            sbU.append(", message=");
            sbU.append(this.message);
            sbU.append(", adapter=");
            sbU.append(this.adapter);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.utils.EmbeddedMessageParser$getMessageRenderContext$1, reason: invalid class name */
    /* JADX INFO: compiled from: EmbeddedMessageParser.kt */
    public static final class AnonymousClass1 extends Lambda implements Function3<Context, String, String, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Context context, String str, String str2) {
            invoke2(context, str, str2);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Context context, String str, String str2) {
            Intrinsics3.checkNotNullParameter(context, "clickContext");
            Intrinsics3.checkNotNullParameter(str, "url");
            UriHandler.handleOrUntrusted(context, str, str2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.utils.EmbeddedMessageParser$getMessageRenderContext$2, reason: invalid class name */
    /* JADX INFO: compiled from: EmbeddedMessageParser.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ ParserData $parserData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ParserData parserData) {
            super(1);
            this.$parserData = parserData;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "url");
            this.$parserData.getAdapter().getEventHandler().onUrlLongClicked(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.utils.EmbeddedMessageParser$getMessageRenderContext$3, reason: invalid class name */
    /* JADX INFO: compiled from: EmbeddedMessageParser.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ ParserData $parserData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(ParserData parserData) {
            super(1);
            this.$parserData = parserData;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            WidgetChatListAdapter.Data data = this.$parserData.getAdapter().getData();
            this.$parserData.getAdapter().getEventHandler().onUserMentionClicked(j, data.getChannelId(), data.getGuildId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.utils.EmbeddedMessageParser$getMessageRenderContext$4, reason: invalid class name */
    /* JADX INFO: compiled from: EmbeddedMessageParser.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ ParserData $parserData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(ParserData parserData) {
            super(1);
            this.$parserData = parserData;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            ChannelSelector.INSTANCE.getInstance().findAndSet(this.$parserData.getContext(), j);
        }
    }

    private EmbeddedMessageParser() {
    }

    private final MessagePreprocessor getMessagePreprocessor(long userId, Message message, StoreMessageState.State messageState, Integer maxNodes) {
        StoreUserSettings userSettings = StoreStream.INSTANCE.getUserSettings();
        return new MessagePreprocessor(userId, messageState, (userSettings.getIsEmbedMediaInlined() && userSettings.getIsRenderEmbedsEnabled()) ? message.getEmbeds() : null, false, maxNodes);
    }

    private final MessageRenderContext getMessageRenderContext(ParserData parserData) {
        return new MessageRenderContext(parserData.getContext(), parserData.getAdapter().getData().getUserId(), parserData.getAnimateEmojis(), parserData.getNickOrUsernames(), parserData.getAdapter().getData().getChannelNames(), parserData.getRoleMentions(), R.attr.colorTextLink, AnonymousClass1.INSTANCE, new AnonymousClass2(parserData), ColorCompat.getThemedColor(parserData.getContext(), R.attr.theme_chat_spoiler_bg), ColorCompat.getThemedColor(parserData.getContext(), R.attr.theme_chat_spoiler_bg_visible), null, new AnonymousClass3(parserData), new AnonymousClass4(parserData));
    }

    public final DraweeSpanStringBuilder parse(ParserData parserData) {
        Intrinsics3.checkNotNullParameter(parserData, "parserData");
        MessageRenderContext messageRenderContext = getMessageRenderContext(parserData);
        User author = parserData.getMessage().getAuthor();
        MessagePreprocessor messagePreprocessor = getMessagePreprocessor(author != null ? author.getId() : 0L, parserData.getMessage(), parserData.getMessageState(), parserData.getMaxNodes());
        String content = parserData.getMessage().getContent();
        if (content == null) {
            content = "";
        }
        Context context = parserData.getContext();
        String property = System.getProperty("line.separator");
        Objects.requireNonNull(property);
        Intrinsics3.checkNotNullExpressionValue(property, "Objects.requireNonNull(S…operty(\"line.separator\"))");
        return DiscordParser.parseChannelMessage(context, new Regex(property).replace(content, " "), messageRenderContext, messagePreprocessor, DiscordParser.ParserOptions.REPLY, false);
    }
}
