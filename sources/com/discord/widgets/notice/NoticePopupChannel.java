package com.discord.widgets.notice;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.message.attachment.MessageAttachment;
import com.discord.api.message.attachment.MessageAttachmentType;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.member.GuildMember$Companion;
import com.discord.models.message.Message;
import com.discord.models.user.CoreUser;
import com.discord.models.user.User;
import com.discord.simpleast.core.parser.Parser;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.message.MessageUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.g0.t;
import d0.o;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import j0.l.e.k;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: NoticePopupChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NoticePopupChannel {
    public static final NoticePopupChannel INSTANCE = new NoticePopupChannel();

    private NoticePopupChannel() {
    }

    public static final /* synthetic */ NoticePopupChannel$Model access$createModel(NoticePopupChannel noticePopupChannel, Context context, Message message, Guild guild, Channel channel, Map map, Long l, User user, Map map2, Map map3) {
        return noticePopupChannel.createModel(context, message, guild, channel, map, l, user, map2, map3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16, types: [com.discord.api.message.attachment.MessageAttachment] */
    /* JADX WARN: Type inference failed for: r0v61 */
    /* JADX WARN: Type inference failed for: r6v5, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v3, types: [android.graphics.drawable.Drawable] */
    private final NoticePopupChannel$Model createModel(Context context, Message message, Guild guild, Channel channel, Map<Long, GuildMember> members, Long selectedChannel, User meUser, Map<Long, String> channelNames, Map<Long, GuildRole> roles) {
        DraweeSpanStringBuilder draweeSpanStringBuilder;
        Pair pair;
        Integer num;
        Channel channel2;
        String forChannel$default;
        Context context2;
        int i;
        ?? r0;
        Object proxyUrl;
        Object drawable$default;
        Object drawable$default2;
        MessageAttachment messageAttachment;
        MessageEmbed messageEmbed;
        if (channel != null) {
            long id2 = channel.getId();
            if (selectedChannel == null || selectedChannel.longValue() != id2) {
                MessageRenderContext messageRenderContext = new MessageRenderContext(context, meUser.getId(), true, MessageUtils.getNickOrUsernames$default(message, channel, members, null, 8, null), channelNames, roles, 0, null, NoticePopupChannel$createModel$messageRenderContext$1.INSTANCE, ColorCompat.getThemedColor(context, 2130970293), 0, null, null, null, 15552, null);
                String content = message.getContent();
                if (content == null || (draweeSpanStringBuilder = AstRenderer.render(Parser.parse$default(DiscordParser.createParser$default(false, true, false, false, false, 28, null), content, MessageParseState.Companion.getInitialState(), null, 4, null), messageRenderContext)) == null) {
                    draweeSpanStringBuilder = new DraweeSpanStringBuilder();
                }
                DraweeSpanStringBuilder draweeSpanStringBuilder2 = draweeSpanStringBuilder;
                if (t.isBlank(draweeSpanStringBuilder2)) {
                    List<MessageEmbed> embeds = message.getEmbeds();
                    String title = (embeds == null || (messageEmbed = (MessageEmbed) u.firstOrNull((List) embeds)) == null) ? null : messageEmbed.getTitle();
                    if (title == null) {
                        title = "";
                    }
                    draweeSpanStringBuilder2.append((CharSequence) title);
                }
                long guildId = channel.getGuildId();
                if (guildId == -1 || guildId == 0) {
                    pair = o.to(ChannelUtils.c(channel), null);
                    num = null;
                } else {
                    String name = guild != null ? guild.getName() : null;
                    String str = name != null ? name : "";
                    StringBuilder sbQ = a.Q(MentionUtilsKt.CHANNELS_CHAR);
                    sbQ.append(ChannelUtils.c(channel));
                    num = null;
                    pair = o.to(str, sbQ.toString());
                }
                String str2 = (String) pair.component1();
                String str3 = (String) pair.component2();
                if (ChannelUtils.v(channel)) {
                    forChannel$default = IconUtils.getForGuild$default(guild, IconUtils.DEFAULT_ICON_BLURPLE, false, null, 12, null);
                    channel2 = channel;
                } else {
                    channel2 = channel;
                    forChannel$default = IconUtils.getForChannel$default(channel2, num, 2, num);
                }
                String str4 = forChannel$default;
                if (ChannelUtils.m(channel)) {
                    context2 = context;
                    i = 2;
                } else {
                    com.discord.api.user.User author = message.getAuthor();
                    m.checkNotNull(author);
                    CoreUser coreUser = new CoreUser(author);
                    i = 2;
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a.w(GuildMember$Companion.getNickOrUsername$default(GuildMember.Companion, coreUser, members.get(Long.valueOf(coreUser.getId())), channel, null, 8, null), ": "));
                    context2 = context;
                    Iterator it = n.listOf(new ForegroundColorSpan(ColorCompat.getThemedColor(context2, 2130969970)), new StyleSpan(1)).iterator();
                    while (it.hasNext()) {
                        spannableStringBuilder.setSpan(it.next(), 0, spannableStringBuilder.length(), 33);
                    }
                    draweeSpanStringBuilder2.insert(0, (CharSequence) spannableStringBuilder);
                }
                List<MessageAttachment> attachments = message.getAttachments();
                if (attachments != null) {
                    messageAttachment = (MessageAttachment) u.firstOrNull((List) attachments);
                } else {
                    r0 = num;
                }
                if (r0 == 0 || !r0.h()) {
                    if ((r0 != 0 ? r0.e() : num) == MessageAttachmentType.IMAGE) {
                        proxyUrl = r0.getProxyUrl();
                    } else {
                        if ((r0 != 0 ? r0.e() : num) == MessageAttachmentType.VIDEO) {
                            drawable$default = DrawableCompat.getDrawable$default(context, 2131232520, ColorCompat.getThemedColor(context2, 2130968912), false, 4, null);
                            drawable$default2 = DrawableCompat.getDrawable$default(context, 2131232035, ColorCompat.getThemedColor(context2, 2130969005), false, 4, null);
                            proxyUrl = num;
                        } else {
                            proxyUrl = num;
                        }
                    }
                    drawable$default2 = num;
                    drawable$default = drawable$default2;
                } else {
                    r0 = messageAttachment;
                    drawable$default2 = ContextCompat.getDrawable(context2, DrawableCompat.getThemedDrawableRes$default(context2, 2130970293, 0, i, num));
                    proxyUrl = num;
                    drawable$default = proxyUrl;
                }
                return new NoticePopupChannel$Model(str2, str3, draweeSpanStringBuilder2, str4, drawable$default, proxyUrl, drawable$default2, ContextCompat.getDrawable(context2, DrawableCompat.getThemedDrawableRes$default(context2, ChannelUtils.B(channel) ? 2130969481 : 2130969539, 0, i, num)), new NoticePopupChannel$createModel$onClickTopRightIcon$1(channel2, context2), message.getStickers());
            }
        }
        return null;
    }

    public final void enqueue(Context context, String noticeName, Message message, Function1<? super View, Unit> onClick) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(noticeName, "noticeName");
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(onClick, "onClick");
        k kVar = new k(context);
        k kVar2 = new k(message);
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable<Guild> observableObserveFromChannelId = storeStream$Companion.getGuilds().observeFromChannelId(message.getChannelId());
        Observable<Channel> observableObserveChannel = storeStream$Companion.getChannels().observeChannel(message.getChannelId());
        StoreGuilds guilds = storeStream$Companion.getGuilds();
        Long guildId = message.getGuildId();
        Observable<Map<Long, GuildMember>> observableObserveComputed = guilds.observeComputed(guildId != null ? guildId.longValue() : 0L);
        Observable<Long> observableObserveId = storeStream$Companion.getChannelsSelected().observeId();
        Observable observableObserveMe$default = StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null);
        Observable<Map<Long, String>> observableObserveNames = storeStream$Companion.getChannels().observeNames();
        StoreGuilds guilds2 = storeStream$Companion.getGuilds();
        Long guildId2 = message.getGuildId();
        Observable observableC = Observable.c(kVar, kVar2, observableObserveFromChannelId, observableObserveChannel, observableObserveComputed, observableObserveId, observableObserveMe$default, observableObserveNames, guilds2.observeRoles(guildId2 != null ? guildId2.longValue() : 0L), new NoticePopupChannel$sam$rx_functions_Func9$0(new NoticePopupChannel$enqueue$1(this)));
        m.checkNotNullExpressionValue(observableC, "Observable\n        .comb…is::createModel\n        )");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableC, 0L, false, 3, null))), NoticePopupChannel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new NoticePopupChannel$enqueue$2(noticeName, onClick), 62, (Object) null);
    }
}
