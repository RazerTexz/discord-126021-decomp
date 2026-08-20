package com.discord.widgets.notice;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.message.attachment.MessageAttachment;
import com.discord.api.message.attachment.MessageAttachmentType;
import com.discord.api.message.embed.MessageEmbed;
import com.discord.api.role.GuildRole;
import com.discord.api.sticker.Sticker;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.CoreUser;
import com.discord.models.user.User;
import com.discord.simpleast.core.parser.Parser;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.message.MessageUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.home.WidgetHome;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function9;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func9;

/* JADX INFO: compiled from: NoticePopupChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NoticePopupChannel {
    public static final NoticePopupChannel INSTANCE = new NoticePopupChannel();

    /* JADX INFO: compiled from: NoticePopupChannel.kt */
    public static final /* data */ class Model {
        private final DraweeSpanStringBuilder noticeBody;
        private Drawable noticeBodyBackgroundDrawable;
        private Drawable noticeBodyImageDrawable;
        private String noticeBodyImageUrl;
        private final Drawable noticeIconTopRight;
        private final String noticeIconUrl;
        private final List<Sticker> noticeStickers;
        private final CharSequence noticeSubtitle;
        private final CharSequence noticeTitle;
        private final Function1<View, Unit> onClickTopRightIcon;

        /* JADX WARN: Multi-variable type inference failed */
        public Model(CharSequence charSequence, CharSequence charSequence2, DraweeSpanStringBuilder draweeSpanStringBuilder, String str, Drawable drawable, String str2, Drawable drawable2, Drawable drawable3, Function1<? super View, Unit> function1, List<Sticker> list) {
            C12238m.checkNotNullParameter(charSequence, "noticeTitle");
            C12238m.checkNotNullParameter(draweeSpanStringBuilder, "noticeBody");
            C12238m.checkNotNullParameter(function1, "onClickTopRightIcon");
            this.noticeTitle = charSequence;
            this.noticeSubtitle = charSequence2;
            this.noticeBody = draweeSpanStringBuilder;
            this.noticeIconUrl = str;
            this.noticeBodyBackgroundDrawable = drawable;
            this.noticeBodyImageUrl = str2;
            this.noticeBodyImageDrawable = drawable2;
            this.noticeIconTopRight = drawable3;
            this.onClickTopRightIcon = function1;
            this.noticeStickers = list;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CharSequence getNoticeTitle() {
            return this.noticeTitle;
        }

        public final List<Sticker> component10() {
            return this.noticeStickers;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final CharSequence getNoticeSubtitle() {
            return this.noticeSubtitle;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final DraweeSpanStringBuilder getNoticeBody() {
            return this.noticeBody;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getNoticeIconUrl() {
            return this.noticeIconUrl;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Drawable getNoticeBodyBackgroundDrawable() {
            return this.noticeBodyBackgroundDrawable;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final String getNoticeBodyImageUrl() {
            return this.noticeBodyImageUrl;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Drawable getNoticeBodyImageDrawable() {
            return this.noticeBodyImageDrawable;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Drawable getNoticeIconTopRight() {
            return this.noticeIconTopRight;
        }

        public final Function1<View, Unit> component9() {
            return this.onClickTopRightIcon;
        }

        public final Model copy(CharSequence noticeTitle, CharSequence noticeSubtitle, DraweeSpanStringBuilder noticeBody, String noticeIconUrl, Drawable noticeBodyBackgroundDrawable, String noticeBodyImageUrl, Drawable noticeBodyImageDrawable, Drawable noticeIconTopRight, Function1<? super View, Unit> onClickTopRightIcon, List<Sticker> noticeStickers) {
            C12238m.checkNotNullParameter(noticeTitle, "noticeTitle");
            C12238m.checkNotNullParameter(noticeBody, "noticeBody");
            C12238m.checkNotNullParameter(onClickTopRightIcon, "onClickTopRightIcon");
            return new Model(noticeTitle, noticeSubtitle, noticeBody, noticeIconUrl, noticeBodyBackgroundDrawable, noticeBodyImageUrl, noticeBodyImageDrawable, noticeIconTopRight, onClickTopRightIcon, noticeStickers);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return C12238m.areEqual(this.noticeTitle, model.noticeTitle) && C12238m.areEqual(this.noticeSubtitle, model.noticeSubtitle) && C12238m.areEqual(this.noticeBody, model.noticeBody) && C12238m.areEqual(this.noticeIconUrl, model.noticeIconUrl) && C12238m.areEqual(this.noticeBodyBackgroundDrawable, model.noticeBodyBackgroundDrawable) && C12238m.areEqual(this.noticeBodyImageUrl, model.noticeBodyImageUrl) && C12238m.areEqual(this.noticeBodyImageDrawable, model.noticeBodyImageDrawable) && C12238m.areEqual(this.noticeIconTopRight, model.noticeIconTopRight) && C12238m.areEqual(this.onClickTopRightIcon, model.onClickTopRightIcon) && C12238m.areEqual(this.noticeStickers, model.noticeStickers);
        }

        public final DraweeSpanStringBuilder getNoticeBody() {
            return this.noticeBody;
        }

        public final Drawable getNoticeBodyBackgroundDrawable() {
            return this.noticeBodyBackgroundDrawable;
        }

        public final Drawable getNoticeBodyImageDrawable() {
            return this.noticeBodyImageDrawable;
        }

        public final String getNoticeBodyImageUrl() {
            return this.noticeBodyImageUrl;
        }

        public final Drawable getNoticeIconTopRight() {
            return this.noticeIconTopRight;
        }

        public final String getNoticeIconUrl() {
            return this.noticeIconUrl;
        }

        public final List<Sticker> getNoticeStickers() {
            return this.noticeStickers;
        }

        public final CharSequence getNoticeSubtitle() {
            return this.noticeSubtitle;
        }

        public final CharSequence getNoticeTitle() {
            return this.noticeTitle;
        }

        public final Function1<View, Unit> getOnClickTopRightIcon() {
            return this.onClickTopRightIcon;
        }

        public int hashCode() {
            CharSequence charSequence = this.noticeTitle;
            int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
            CharSequence charSequence2 = this.noticeSubtitle;
            int iHashCode2 = (iHashCode + (charSequence2 != null ? charSequence2.hashCode() : 0)) * 31;
            DraweeSpanStringBuilder draweeSpanStringBuilder = this.noticeBody;
            int iHashCode3 = (iHashCode2 + (draweeSpanStringBuilder != null ? draweeSpanStringBuilder.hashCode() : 0)) * 31;
            String str = this.noticeIconUrl;
            int iHashCode4 = (iHashCode3 + (str != null ? str.hashCode() : 0)) * 31;
            Drawable drawable = this.noticeBodyBackgroundDrawable;
            int iHashCode5 = (iHashCode4 + (drawable != null ? drawable.hashCode() : 0)) * 31;
            String str2 = this.noticeBodyImageUrl;
            int iHashCode6 = (iHashCode5 + (str2 != null ? str2.hashCode() : 0)) * 31;
            Drawable drawable2 = this.noticeBodyImageDrawable;
            int iHashCode7 = (iHashCode6 + (drawable2 != null ? drawable2.hashCode() : 0)) * 31;
            Drawable drawable3 = this.noticeIconTopRight;
            int iHashCode8 = (iHashCode7 + (drawable3 != null ? drawable3.hashCode() : 0)) * 31;
            Function1<View, Unit> function1 = this.onClickTopRightIcon;
            int iHashCode9 = (iHashCode8 + (function1 != null ? function1.hashCode() : 0)) * 31;
            List<Sticker> list = this.noticeStickers;
            return iHashCode9 + (list != null ? list.hashCode() : 0);
        }

        public final void setNoticeBodyBackgroundDrawable(Drawable drawable) {
            this.noticeBodyBackgroundDrawable = drawable;
        }

        public final void setNoticeBodyImageDrawable(Drawable drawable) {
            this.noticeBodyImageDrawable = drawable;
        }

        public final void setNoticeBodyImageUrl(String str) {
            this.noticeBodyImageUrl = str;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Model(noticeTitle=");
            sbM833U.append(this.noticeTitle);
            sbM833U.append(", noticeSubtitle=");
            sbM833U.append(this.noticeSubtitle);
            sbM833U.append(", noticeBody=");
            sbM833U.append((Object) this.noticeBody);
            sbM833U.append(", noticeIconUrl=");
            sbM833U.append(this.noticeIconUrl);
            sbM833U.append(", noticeBodyBackgroundDrawable=");
            sbM833U.append(this.noticeBodyBackgroundDrawable);
            sbM833U.append(", noticeBodyImageUrl=");
            sbM833U.append(this.noticeBodyImageUrl);
            sbM833U.append(", noticeBodyImageDrawable=");
            sbM833U.append(this.noticeBodyImageDrawable);
            sbM833U.append(", noticeIconTopRight=");
            sbM833U.append(this.noticeIconTopRight);
            sbM833U.append(", onClickTopRightIcon=");
            sbM833U.append(this.onClickTopRightIcon);
            sbM833U.append(", noticeStickers=");
            return C1643a.m824L(sbM833U, this.noticeStickers, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.notice.NoticePopupChannel$enqueue$1 */
    /* JADX INFO: compiled from: NoticePopupChannel.kt */
    public static final /* synthetic */ class C90931 extends C12236k implements Function9<Context, Message, Guild, Channel, Map<Long, ? extends GuildMember>, Long, User, Map<Long, ? extends String>, Map<Long, ? extends GuildRole>, Model> {
        public C90931(NoticePopupChannel noticePopupChannel) {
            super(9, noticePopupChannel, NoticePopupChannel.class, "createModel", "createModel(Landroid/content/Context;Lcom/discord/models/message/Message;Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;Ljava/util/Map;Ljava/lang/Long;Lcom/discord/models/user/User;Ljava/util/Map;Ljava/util/Map;)Lcom/discord/widgets/notice/NoticePopupChannel$Model;", 0);
        }

        @Override // kotlin.jvm.functions.Function9
        public /* bridge */ /* synthetic */ Model invoke(Context context, Message message, Guild guild, Channel channel, Map<Long, ? extends GuildMember> map, Long l, User user, Map<Long, ? extends String> map2, Map<Long, ? extends GuildRole> map3) {
            return invoke2(context, message, guild, channel, (Map<Long, GuildMember>) map, l, user, (Map<Long, String>) map2, (Map<Long, GuildRole>) map3);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Model invoke2(Context context, Message message, Guild guild, Channel channel, Map<Long, GuildMember> map, Long l, User user, Map<Long, String> map2, Map<Long, GuildRole> map3) {
            C12238m.checkNotNullParameter(context, "p1");
            C12238m.checkNotNullParameter(message, "p2");
            C12238m.checkNotNullParameter(map, "p5");
            C12238m.checkNotNullParameter(user, "p7");
            C12238m.checkNotNullParameter(map2, "p8");
            C12238m.checkNotNullParameter(map3, "p9");
            return ((NoticePopupChannel) this.receiver).createModel(context, message, guild, channel, map, l, user, map2, map3);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.notice.NoticePopupChannel$enqueue$2 */
    /* JADX INFO: compiled from: NoticePopupChannel.kt */
    public static final class C90942 extends AbstractC12240o implements Function1<Model, Unit> {
        public final /* synthetic */ String $noticeName;
        public final /* synthetic */ Function1 $onClick;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C90942(String str, Function1 function1) {
            super(1);
            this.$noticeName = str;
            this.$onClick = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            if (model != null) {
                NoticePopup noticePopup = NoticePopup.INSTANCE;
                String str = this.$noticeName;
                CharSequence noticeTitle = model.getNoticeTitle();
                CharSequence noticeSubtitle = model.getNoticeSubtitle();
                noticePopup.enqueue(str, noticeTitle, (16116 & 4) != 0 ? null : noticeSubtitle, model.getNoticeBody(), (16116 & 16) != 0 ? null : model.getNoticeBodyBackgroundDrawable(), (16116 & 32) != 0 ? null : model.getNoticeBodyImageUrl(), (16116 & 64) != 0 ? null : model.getNoticeBodyImageDrawable(), (16116 & 128) != 0 ? null : model.getNoticeStickers(), (16116 & 256) != 0 ? null : model.getNoticeIconUrl(), (16116 & 512) != 0 ? null : null, (16116 & 1024) != 0 ? null : model.getNoticeIconTopRight(), (16116 & 2048) != 0 ? 5 : null, (16116 & 4096) != 0 ? C12145m.listOf(C12216a0.getOrCreateKotlinClass(WidgetHome.class)) : null, (16116 & 8192) != 0 ? NoticePopup.C90901.INSTANCE : model.getOnClickTopRightIcon(), this.$onClick);
            }
        }
    }

    private NoticePopupChannel() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16, types: [com.discord.api.message.attachment.MessageAttachment] */
    /* JADX WARN: Type inference failed for: r0v61 */
    /* JADX WARN: Type inference failed for: r6v5, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v3, types: [android.graphics.drawable.Drawable] */
    private final Model createModel(Context context, Message message, Guild guild, Channel channel, Map<Long, GuildMember> members, Long selectedChannel, User meUser, Map<Long, String> channelNames, Map<Long, GuildRole> roles) {
        DraweeSpanStringBuilder draweeSpanStringBuilder;
        Pair pairM10073to;
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
                MessageRenderContext messageRenderContext = new MessageRenderContext(context, meUser.getId(), true, MessageUtils.getNickOrUsernames$default(message, channel, members, null, 8, null), channelNames, roles, 0, null, NoticePopupChannel$createModel$messageRenderContext$1.INSTANCE, ColorCompat.getThemedColor(context, C5419R.attr.theme_chat_spoiler_inapp_bg), 0, null, null, null, 15552, null);
                String content = message.getContent();
                if (content == null || (draweeSpanStringBuilder = AstRenderer.render(Parser.parse$default(DiscordParser.createParser$default(false, true, false, false, false, 28, null), content, MessageParseState.INSTANCE.getInitialState(), null, 4, null), messageRenderContext)) == null) {
                    draweeSpanStringBuilder = new DraweeSpanStringBuilder();
                }
                DraweeSpanStringBuilder draweeSpanStringBuilder2 = draweeSpanStringBuilder;
                if (C12103t.isBlank(draweeSpanStringBuilder2)) {
                    List<MessageEmbed> embeds = message.getEmbeds();
                    String title = (embeds == null || (messageEmbed = (MessageEmbed) C12163u.firstOrNull((List) embeds)) == null) ? null : messageEmbed.getTitle();
                    if (title == null) {
                        title = "";
                    }
                    draweeSpanStringBuilder2.append((CharSequence) title);
                }
                long guildId = channel.getGuildId();
                if (guildId == -1 || guildId == 0) {
                    pairM10073to = C12116o.m10073to(ChannelUtils.m7679c(channel), null);
                    num = null;
                } else {
                    String name = guild != null ? guild.getName() : null;
                    String str = name != null ? name : "";
                    StringBuilder sbM829Q = C1643a.m829Q(MentionUtilsKt.CHANNELS_CHAR);
                    sbM829Q.append(ChannelUtils.m7679c(channel));
                    num = null;
                    pairM10073to = C12116o.m10073to(str, sbM829Q.toString());
                }
                String str2 = (String) pairM10073to.component1();
                String str3 = (String) pairM10073to.component2();
                if (ChannelUtils.m7698v(channel)) {
                    forChannel$default = IconUtils.getForGuild$default(guild, IconUtils.DEFAULT_ICON_BLURPLE, false, null, 12, null);
                    channel2 = channel;
                } else {
                    channel2 = channel;
                    forChannel$default = IconUtils.getForChannel$default(channel2, num, 2, num);
                }
                String str4 = forChannel$default;
                if (ChannelUtils.m7689m(channel)) {
                    context2 = context;
                    i = 2;
                } else {
                    com.discord.api.user.User author = message.getAuthor();
                    C12238m.checkNotNull(author);
                    CoreUser coreUser = new CoreUser(author);
                    i = 2;
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(C1643a.m883w(GuildMember.Companion.getNickOrUsername$default(GuildMember.INSTANCE, coreUser, members.get(Long.valueOf(coreUser.getId())), channel, null, 8, null), ": "));
                    context2 = context;
                    Iterator it = C12147n.listOf(new ForegroundColorSpan(ColorCompat.getThemedColor(context2, C5419R.attr.primary_000)), new StyleSpan(1)).iterator();
                    while (it.hasNext()) {
                        spannableStringBuilder.setSpan(it.next(), 0, spannableStringBuilder.length(), 33);
                    }
                    draweeSpanStringBuilder2.insert(0, (CharSequence) spannableStringBuilder);
                }
                List<MessageAttachment> attachments = message.getAttachments();
                if (attachments != null) {
                    messageAttachment = (MessageAttachment) C12163u.firstOrNull((List) attachments);
                } else {
                    r0 = num;
                }
                if (r0 == 0 || !r0.m8071h()) {
                    if ((r0 != 0 ? r0.m8068e() : num) == MessageAttachmentType.IMAGE) {
                        proxyUrl = r0.getProxyUrl();
                    } else {
                        if ((r0 != 0 ? r0.m8068e() : num) == MessageAttachmentType.VIDEO) {
                            drawable$default = DrawableCompat.getDrawable$default(context, C5419R.drawable.rounded_rectangle_4dp_radius, ColorCompat.getThemedColor(context2, C5419R.attr.colorBackgroundSecondary), false, 4, null);
                            drawable$default2 = DrawableCompat.getDrawable$default(context, C5419R.drawable.ic_play_circle_outline_white_24dp, ColorCompat.getThemedColor(context2, C5419R.attr.colorInteractiveActive), false, 4, null);
                            proxyUrl = num;
                        } else {
                            proxyUrl = num;
                        }
                    }
                    drawable$default2 = num;
                    drawable$default = drawable$default2;
                } else {
                    r0 = messageAttachment;
                    drawable$default2 = ContextCompat.getDrawable(context2, DrawableCompat.getThemedDrawableRes$default(context2, C5419R.attr.theme_chat_spoiler_inapp_bg, 0, i, num));
                    proxyUrl = num;
                    drawable$default = proxyUrl;
                }
                return new Model(str2, str3, draweeSpanStringBuilder2, str4, drawable$default, proxyUrl, drawable$default2, ContextCompat.getDrawable(context2, DrawableCompat.getThemedDrawableRes$default(context2, ChannelUtils.m7667B(channel) ? C5419R.attr.ic_close_24dp : C5419R.attr.ic_settings, 0, i, num)), new NoticePopupChannel$createModel$onClickTopRightIcon$1(channel2, context2), message.getStickers());
            }
        }
        return null;
    }

    public final void enqueue(Context context, String noticeName, Message message, Function1<? super View, Unit> onClick) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(noticeName, "noticeName");
        C12238m.checkNotNullParameter(message, "message");
        C12238m.checkNotNullParameter(onClick, "onClick");
        C12721k c12721k = new C12721k(context);
        C12721k c12721k2 = new C12721k(message);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<Guild> observableObserveFromChannelId = companion.getGuilds().observeFromChannelId(message.getChannelId());
        Observable<Channel> observableObserveChannel = companion.getChannels().observeChannel(message.getChannelId());
        StoreGuilds guilds = companion.getGuilds();
        Long guildId = message.getGuildId();
        Observable<Map<Long, GuildMember>> observableObserveComputed = guilds.observeComputed(guildId != null ? guildId.longValue() : 0L);
        Observable<Long> observableObserveId = companion.getChannelsSelected().observeId();
        Observable observableObserveMe$default = StoreUser.observeMe$default(companion.getUsers(), false, 1, null);
        Observable<Map<Long, String>> observableObserveNames = companion.getChannels().observeNames();
        StoreGuilds guilds2 = companion.getGuilds();
        Long guildId2 = message.getGuildId();
        Observable<Map<Long, GuildRole>> observableObserveRoles = guilds2.observeRoles(guildId2 != null ? guildId2.longValue() : 0L);
        final C90931 c90931 = new C90931(this);
        Observable observableM11066c = Observable.m11066c(c12721k, c12721k2, observableObserveFromChannelId, observableObserveChannel, observableObserveComputed, observableObserveId, observableObserveMe$default, observableObserveNames, observableObserveRoles, new Func9() { // from class: com.discord.widgets.notice.NoticePopupChannel$sam$rx_functions_Func9$0
            @Override // p658rx.functions.Func9
            public final /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
                return c90931.invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11066c, "Observable\n        .comb…is::createModel\n        )");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8518ui(ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11066c, 0L, false, 3, null))), (Class<?>) NoticePopupChannel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C90942(noticeName, onClick));
    }
}
