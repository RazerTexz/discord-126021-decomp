package com.discord.widgets.notice;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import com.discord.R;
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
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.DiscordParser;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.notice.NoticePopup;
import com.facebook.drawee.span.DraweeSpanStringBuilder;
import d0.Tuples;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function9;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func9;

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
            Intrinsics3.checkNotNullParameter(charSequence, "noticeTitle");
            Intrinsics3.checkNotNullParameter(draweeSpanStringBuilder, "noticeBody");
            Intrinsics3.checkNotNullParameter(function1, "onClickTopRightIcon");
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
            Intrinsics3.checkNotNullParameter(noticeTitle, "noticeTitle");
            Intrinsics3.checkNotNullParameter(noticeBody, "noticeBody");
            Intrinsics3.checkNotNullParameter(onClickTopRightIcon, "onClickTopRightIcon");
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
            return Intrinsics3.areEqual(this.noticeTitle, model.noticeTitle) && Intrinsics3.areEqual(this.noticeSubtitle, model.noticeSubtitle) && Intrinsics3.areEqual(this.noticeBody, model.noticeBody) && Intrinsics3.areEqual(this.noticeIconUrl, model.noticeIconUrl) && Intrinsics3.areEqual(this.noticeBodyBackgroundDrawable, model.noticeBodyBackgroundDrawable) && Intrinsics3.areEqual(this.noticeBodyImageUrl, model.noticeBodyImageUrl) && Intrinsics3.areEqual(this.noticeBodyImageDrawable, model.noticeBodyImageDrawable) && Intrinsics3.areEqual(this.noticeIconTopRight, model.noticeIconTopRight) && Intrinsics3.areEqual(this.onClickTopRightIcon, model.onClickTopRightIcon) && Intrinsics3.areEqual(this.noticeStickers, model.noticeStickers);
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
            StringBuilder sbU = outline.U("Model(noticeTitle=");
            sbU.append(this.noticeTitle);
            sbU.append(", noticeSubtitle=");
            sbU.append(this.noticeSubtitle);
            sbU.append(", noticeBody=");
            sbU.append((Object) this.noticeBody);
            sbU.append(", noticeIconUrl=");
            sbU.append(this.noticeIconUrl);
            sbU.append(", noticeBodyBackgroundDrawable=");
            sbU.append(this.noticeBodyBackgroundDrawable);
            sbU.append(", noticeBodyImageUrl=");
            sbU.append(this.noticeBodyImageUrl);
            sbU.append(", noticeBodyImageDrawable=");
            sbU.append(this.noticeBodyImageDrawable);
            sbU.append(", noticeIconTopRight=");
            sbU.append(this.noticeIconTopRight);
            sbU.append(", onClickTopRightIcon=");
            sbU.append(this.onClickTopRightIcon);
            sbU.append(", noticeStickers=");
            return outline.L(sbU, this.noticeStickers, ")");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.notice.NoticePopupChannel$enqueue$1, reason: invalid class name */
    /* JADX INFO: compiled from: NoticePopupChannel.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function9<Context, Message, Guild, Channel, Map<Long, ? extends GuildMember>, Long, User, Map<Long, ? extends String>, Map<Long, ? extends GuildRole>, Model> {
        public AnonymousClass1(NoticePopupChannel noticePopupChannel) {
            super(9, noticePopupChannel, NoticePopupChannel.class, "createModel", "createModel(Landroid/content/Context;Lcom/discord/models/message/Message;Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;Ljava/util/Map;Ljava/lang/Long;Lcom/discord/models/user/User;Ljava/util/Map;Ljava/util/Map;)Lcom/discord/widgets/notice/NoticePopupChannel$Model;", 0);
        }

        @Override // kotlin.jvm.functions.Function9
        public /* bridge */ /* synthetic */ Model invoke(Context context, Message message, Guild guild, Channel channel, Map<Long, ? extends GuildMember> map, Long l, User user, Map<Long, ? extends String> map2, Map<Long, ? extends GuildRole> map3) {
            return invoke2(context, message, guild, channel, (Map<Long, GuildMember>) map, l, user, (Map<Long, String>) map2, (Map<Long, GuildRole>) map3);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Model invoke2(Context context, Message message, Guild guild, Channel channel, Map<Long, GuildMember> map, Long l, User user, Map<Long, String> map2, Map<Long, GuildRole> map3) {
            Intrinsics3.checkNotNullParameter(context, "p1");
            Intrinsics3.checkNotNullParameter(message, "p2");
            Intrinsics3.checkNotNullParameter(map, "p5");
            Intrinsics3.checkNotNullParameter(user, "p7");
            Intrinsics3.checkNotNullParameter(map2, "p8");
            Intrinsics3.checkNotNullParameter(map3, "p9");
            return ((NoticePopupChannel) this.receiver).createModel(context, message, guild, channel, map, l, user, map2, map3);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.notice.NoticePopupChannel$enqueue$2, reason: invalid class name */
    /* JADX INFO: compiled from: NoticePopupChannel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Model, Unit> {
        public final /* synthetic */ String $noticeName;
        public final /* synthetic */ Function1 $onClick;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, Function1 function1) {
            super(1);
            this.$noticeName = str;
            this.$onClick = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            if (model != null) {
                NoticePopup noticePopup = NoticePopup.INSTANCE;
                String str = this.$noticeName;
                CharSequence noticeTitle = model.getNoticeTitle();
                CharSequence noticeSubtitle = model.getNoticeSubtitle();
                noticePopup.enqueue(str, noticeTitle, (16116 & 4) != 0 ? null : noticeSubtitle, model.getNoticeBody(), (16116 & 16) != 0 ? null : model.getNoticeBodyBackgroundDrawable(), (16116 & 32) != 0 ? null : model.getNoticeBodyImageUrl(), (16116 & 64) != 0 ? null : model.getNoticeBodyImageDrawable(), (16116 & 128) != 0 ? null : model.getNoticeStickers(), (16116 & 256) != 0 ? null : model.getNoticeIconUrl(), (16116 & 512) != 0 ? null : null, (16116 & 1024) != 0 ? null : model.getNoticeIconTopRight(), (16116 & 2048) != 0 ? 5 : null, (16116 & 4096) != 0 ? CollectionsJVM.listOf(Reflection2.getOrCreateKotlinClass(WidgetHome.class)) : null, (16116 & 8192) != 0 ? NoticePopup.AnonymousClass1.INSTANCE : model.getOnClickTopRightIcon(), this.$onClick);
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
        Tuples2 tuples2;
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
                MessageRenderContext messageRenderContext = new MessageRenderContext(context, meUser.getId(), true, MessageUtils.getNickOrUsernames$default(message, channel, members, null, 8, null), channelNames, roles, 0, null, NoticePopupChannel2.INSTANCE, ColorCompat.getThemedColor(context, R.attr.theme_chat_spoiler_inapp_bg), 0, null, null, null, 15552, null);
                String content = message.getContent();
                if (content == null || (draweeSpanStringBuilder = AstRenderer.render(Parser.parse$default(DiscordParser.createParser$default(false, true, false, false, false, 28, null), content, MessageParseState.INSTANCE.getInitialState(), null, 4, null), messageRenderContext)) == null) {
                    draweeSpanStringBuilder = new DraweeSpanStringBuilder();
                }
                DraweeSpanStringBuilder draweeSpanStringBuilder2 = draweeSpanStringBuilder;
                if (StringsJVM.isBlank(draweeSpanStringBuilder2)) {
                    List<MessageEmbed> embeds = message.getEmbeds();
                    String title = (embeds == null || (messageEmbed = (MessageEmbed) _Collections.firstOrNull((List) embeds)) == null) ? null : messageEmbed.getTitle();
                    if (title == null) {
                        title = "";
                    }
                    draweeSpanStringBuilder2.append((CharSequence) title);
                }
                long guildId = channel.getGuildId();
                if (guildId == -1 || guildId == 0) {
                    tuples2 = Tuples.to(ChannelUtils.c(channel), null);
                    num = null;
                } else {
                    String name = guild != null ? guild.getName() : null;
                    String str = name != null ? name : "";
                    StringBuilder sbQ = outline.Q(MentionUtils.CHANNELS_CHAR);
                    sbQ.append(ChannelUtils.c(channel));
                    num = null;
                    tuples2 = Tuples.to(str, sbQ.toString());
                }
                String str2 = (String) tuples2.component1();
                String str3 = (String) tuples2.component2();
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
                    Intrinsics3.checkNotNull(author);
                    CoreUser coreUser = new CoreUser(author);
                    i = 2;
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(outline.w(GuildMember.Companion.getNickOrUsername$default(GuildMember.INSTANCE, coreUser, members.get(Long.valueOf(coreUser.getId())), channel, null, 8, null), ": "));
                    context2 = context;
                    Iterator it = Collections2.listOf(new ForegroundColorSpan(ColorCompat.getThemedColor(context2, R.attr.primary_000)), new StyleSpan(1)).iterator();
                    while (it.hasNext()) {
                        spannableStringBuilder.setSpan(it.next(), 0, spannableStringBuilder.length(), 33);
                    }
                    draweeSpanStringBuilder2.insert(0, (CharSequence) spannableStringBuilder);
                }
                List<MessageAttachment> attachments = message.getAttachments();
                if (attachments != null) {
                    messageAttachment = (MessageAttachment) _Collections.firstOrNull((List) attachments);
                } else {
                    r0 = num;
                }
                if (r0 == 0 || !r0.h()) {
                    if ((r0 != 0 ? r0.e() : num) == MessageAttachmentType.IMAGE) {
                        proxyUrl = r0.getProxyUrl();
                    } else {
                        if ((r0 != 0 ? r0.e() : num) == MessageAttachmentType.VIDEO) {
                            drawable$default = DrawableCompat.getDrawable$default(context, R.drawable.rounded_rectangle_4dp_radius, ColorCompat.getThemedColor(context2, R.attr.colorBackgroundSecondary), false, 4, null);
                            drawable$default2 = DrawableCompat.getDrawable$default(context, R.drawable.ic_play_circle_outline_white_24dp, ColorCompat.getThemedColor(context2, R.attr.colorInteractiveActive), false, 4, null);
                            proxyUrl = num;
                        } else {
                            proxyUrl = num;
                        }
                    }
                    drawable$default2 = num;
                    drawable$default = drawable$default2;
                } else {
                    r0 = messageAttachment;
                    drawable$default2 = ContextCompat.getDrawable(context2, DrawableCompat.getThemedDrawableRes$default(context2, R.attr.theme_chat_spoiler_inapp_bg, 0, i, num));
                    proxyUrl = num;
                    drawable$default = proxyUrl;
                }
                return new Model(str2, str3, draweeSpanStringBuilder2, str4, drawable$default, proxyUrl, drawable$default2, ContextCompat.getDrawable(context2, DrawableCompat.getThemedDrawableRes$default(context2, ChannelUtils.B(channel) ? R.attr.ic_close_24dp : R.attr.ic_settings, 0, i, num)), new NoticePopupChannel3(channel2, context2), message.getStickers());
            }
        }
        return null;
    }

    public final void enqueue(Context context, String noticeName, Message message, Function1<? super View, Unit> onClick) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(noticeName, "noticeName");
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(onClick, "onClick");
        ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(context);
        ScalarSynchronousObservable scalarSynchronousObservable2 = new ScalarSynchronousObservable(message);
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
        final AnonymousClass1 anonymousClass1 = new AnonymousClass1(this);
        Observable observableC = Observable.c(scalarSynchronousObservable, scalarSynchronousObservable2, observableObserveFromChannelId, observableObserveChannel, observableObserveComputed, observableObserveId, observableObserveMe$default, observableObserveNames, observableObserveRoles, new Func9() { // from class: com.discord.widgets.notice.NoticePopupChannel$sam$rx_functions_Func9$0
            @Override // rx.functions.Func9
            public final /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
                return anonymousClass1.invoke(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableC, "Observable\n        .comb…is::createModel\n        )");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui(ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableC, 0L, false, 3, null))), (Class<?>) NoticePopupChannel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(noticeName, onClick));
    }
}
