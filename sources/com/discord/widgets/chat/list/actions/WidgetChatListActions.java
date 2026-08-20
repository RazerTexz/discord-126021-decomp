package com.discord.widgets.chat.list.actions;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.thread.ThreadMetadata;
import com.discord.api.user.User;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetChatListActionsBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreChat;
import com.discord.stores.StoreMessages;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.messagesend.MessageResult;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.ManageMessageContext;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.SendUtils;
import com.discord.utilities.textprocessing.MessageUnparser;
import com.discord.utilities.textprocessing.node.EditedMessageNode;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.utilities.view.recycler.PaddedItemDecorator;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.chat.input.emoji.EmojiPickerContextType;
import com.discord.widgets.chat.input.emoji.EmojiPickerListener;
import com.discord.widgets.chat.input.emoji.EmojiPickerNavigator;
import com.discord.widgets.chat.managereactions.WidgetManageReactions;
import com.discord.widgets.mobile_reports.ReportsFeatureFlag;
import com.discord.widgets.mobile_reports.WidgetMobileReports;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.tos.WidgetTosReportViolation;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0876m;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12145m;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;
import p658rx.functions.Func3;
import p658rx.functions.Func5;

/* JADX INFO: compiled from: WidgetChatListActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListActions extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetChatListActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChatListActionsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_MESSAGE_CHANNEL_ID = "INTENT_EXTRA_MESSAGE_CHANNEL_ID";
    private static final String INTENT_EXTRA_MESSAGE_CONTENT = "INTENT_EXTRA_MESSAGE_CONTENT";
    private static final String INTENT_EXTRA_MESSAGE_ID = "INTENT_EXTRA_MESSAGE_ID";
    private static final String INTENT_EXTRA_TYPE = "INTENT_EXTRA_TYPE";
    private static final int TYPE_CHAT = 0;
    private static final int TYPE_PINS = 1;
    private WidgetChatListActionsEmojisAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private long channelId;
    private PaddedItemDecorator itemDecorator;
    private long messageId;

    /* JADX INFO: compiled from: WidgetChatListActions.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void showForChat(FragmentManager fragmentManager, long channelId, long messageId, CharSequence messageContent) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(messageContent, "messageContent");
            WidgetChatListActions widgetChatListActions = new WidgetChatListActions();
            Bundle bundleM832T = C1643a.m832T(WidgetChatListActions.INTENT_EXTRA_MESSAGE_CHANNEL_ID, channelId);
            bundleM832T.putLong(WidgetChatListActions.INTENT_EXTRA_MESSAGE_ID, messageId);
            bundleM832T.putCharSequence(WidgetChatListActions.INTENT_EXTRA_MESSAGE_CONTENT, messageContent);
            bundleM832T.putInt(WidgetChatListActions.INTENT_EXTRA_TYPE, 0);
            widgetChatListActions.setArguments(bundleM832T);
            widgetChatListActions.show(fragmentManager, WidgetChatListActions.class.getName());
        }

        public final void showForPin(FragmentManager fragmentManager, long channelId, long messageId, CharSequence messageContent) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(messageContent, "messageContent");
            Bundle bundle = new Bundle();
            bundle.putLong(WidgetChatListActions.INTENT_EXTRA_MESSAGE_CHANNEL_ID, channelId);
            bundle.putLong(WidgetChatListActions.INTENT_EXTRA_MESSAGE_ID, messageId);
            bundle.putCharSequence(WidgetChatListActions.INTENT_EXTRA_MESSAGE_CONTENT, messageContent);
            bundle.putInt(WidgetChatListActions.INTENT_EXTRA_TYPE, 1);
            WidgetChatListActions widgetChatListActions = new WidgetChatListActions();
            widgetChatListActions.setArguments(bundle);
            widgetChatListActions.show(fragmentManager, WidgetChatListActions.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetChatListActions.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Channel channel;
        private final Guild guild;
        private final boolean isDeveloper;
        private final ManageMessageContext manageMessageContext;
        private final MeUser me;
        private final Message message;
        private final String messageAuthorName;
        private final CharSequence messageContent;
        private final Long permissions;
        private final List<Emoji> recentEmojis;
        private final int type;

        /* JADX INFO: compiled from: WidgetChatListActions.kt */
        public static final class Companion {
            private Companion() {
            }

            private final Model create(Message message, Guild guild, Long permissions, MeUser meUser, GuildMember member, Channel channel, CharSequence messageContent, int type, EmojiSet emojis) {
                String nick;
                ThreadMetadata threadMetadata;
                String username = null;
                if (message == null) {
                    return null;
                }
                ManageMessageContext manageMessageContextFrom = ManageMessageContext.INSTANCE.from(message, permissions, meUser, guild != null ? Integer.valueOf(guild.getMfaLevel()) : null, channel != null && ChannelUtils.m7667B(channel), channel != null && ChannelUtils.m7670E(channel), (channel == null || (threadMetadata = channel.getThreadMetadata()) == null || !threadMetadata.getArchived()) ? false : true);
                if (member == null || (nick = member.getNick()) == null) {
                    User author = message.getAuthor();
                    if (author != null) {
                        username = author.getUsername();
                    }
                } else {
                    username = nick;
                }
                if (username == null) {
                    username = "";
                }
                String str = username;
                boolean isDeveloperMode = StoreStream.INSTANCE.getUserSettings().getIsDeveloperMode();
                List<Emoji> list = emojis.recentEmojis;
                C12238m.checkNotNullExpressionValue(list, "emojis.recentEmojis");
                return new Model(message, guild, str, messageContent, manageMessageContextFrom, type, isDeveloperMode, list, channel, permissions, meUser);
            }

            public final Observable<Model> get(final long channelId, long messageId, final CharSequence messageContent, final int type) {
                Observable<Message> observableObserveMessagesForChannel;
                if (type != 0) {
                    observableObserveMessagesForChannel = type != 1 ? new C12721k<>(null) : StoreStream.INSTANCE.getPinnedMessages().observePinnedMessage(channelId, messageId);
                } else {
                    observableObserveMessagesForChannel = StoreStream.INSTANCE.getMessages().observeMessagesForChannel(channelId, messageId);
                }
                Observable<Model> observableM11099Y = Observable.m11076j(observableObserveMessagesForChannel, StoreStream.INSTANCE.getChannels().observeChannel(channelId), new Func2<Message, Channel, Pair<? extends Message, ? extends Channel>>() { // from class: com.discord.widgets.chat.list.actions.WidgetChatListActions$Model$Companion$get$1
                    @Override // p658rx.functions.Func2
                    public final Pair<Message, Channel> call(Message message, Channel channel) {
                        return C12116o.m10073to(message, channel);
                    }
                }).m11099Y(new InterfaceC12589b<Pair<? extends Message, ? extends Channel>, Observable<? extends Model>>() { // from class: com.discord.widgets.chat.list.actions.WidgetChatListActions$Model$Companion$get$2
                    @Override // p637j0.p641k.InterfaceC12589b
                    public /* bridge */ /* synthetic */ Observable<? extends WidgetChatListActions.Model> call(Pair<? extends Message, ? extends Channel> pair) {
                        return call2((Pair<Message, Channel>) pair);
                    }

                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final Observable<? extends WidgetChatListActions.Model> call2(Pair<Message, Channel> pair) {
                        User author;
                        final Message messageComponent1 = pair.component1();
                        final Channel channelComponent2 = pair.component2();
                        final long id2 = (messageComponent1 == null || (author = messageComponent1.getAuthor()) == null) ? 0L : author.getId();
                        if (channelComponent2 == null) {
                            return new C12721k(null);
                        }
                        StoreStream.Companion companion = StoreStream.INSTANCE;
                        return Observable.m11072g(companion.getPermissions().observePermissionsForChannel(channelId), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getGuilds().observeComputed(channelComponent2.getGuildId(), C12145m.listOf(Long.valueOf(id2))).m11083G(new InterfaceC12589b<Map<Long, ? extends GuildMember>, GuildMember>() { // from class: com.discord.widgets.chat.list.actions.WidgetChatListActions$Model$Companion$get$2.1
                            @Override // p637j0.p641k.InterfaceC12589b
                            public /* bridge */ /* synthetic */ GuildMember call(Map<Long, ? extends GuildMember> map) {
                                return call2((Map<Long, GuildMember>) map);
                            }

                            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                            public final GuildMember call2(Map<Long, GuildMember> map) {
                                return map.get(Long.valueOf(id2));
                            }
                        }), companion.getGuilds().observeGuild(channelComponent2.getGuildId()).m11112r(), companion.getEmojis().getEmojiSet(channelComponent2.getGuildId(), channelComponent2.getId(), (12 & 4) != 0 ? false : false, (12 & 8) != 0 ? false : false), new Func5<Long, MeUser, GuildMember, Guild, EmojiSet, WidgetChatListActions.Model>() { // from class: com.discord.widgets.chat.list.actions.WidgetChatListActions$Model$Companion$get$2.2
                            @Override // p658rx.functions.Func5
                            public final WidgetChatListActions.Model call(Long l, MeUser meUser, GuildMember guildMember, Guild guild, EmojiSet emojiSet) {
                                WidgetChatListActions.Model.Companion companion2 = WidgetChatListActions.Model.INSTANCE;
                                Message message = messageComponent1;
                                C12238m.checkNotNullExpressionValue(meUser, "meUser");
                                Channel channel = channelComponent2;
                                WidgetChatListActions$Model$Companion$get$2 widgetChatListActions$Model$Companion$get$2 = WidgetChatListActions$Model$Companion$get$2.this;
                                CharSequence charSequence = messageContent;
                                int i = type;
                                C12238m.checkNotNullExpressionValue(emojiSet, "emojis");
                                return companion2.create(message, guild, l, meUser, guildMember, channel, charSequence, i, emojiSet);
                            }
                        });
                    }
                });
                C12238m.checkNotNullExpressionValue(observableM11099Y, "Observable\n            .…          }\n            }");
                return observableM11099Y;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model(Message message, Guild guild, String str, CharSequence charSequence, ManageMessageContext manageMessageContext, int i, boolean z2, List<? extends Emoji> list, Channel channel, Long l, MeUser meUser) {
            C12238m.checkNotNullParameter(message, "message");
            C12238m.checkNotNullParameter(str, "messageAuthorName");
            C12238m.checkNotNullParameter(manageMessageContext, "manageMessageContext");
            C12238m.checkNotNullParameter(list, "recentEmojis");
            C12238m.checkNotNullParameter(meUser, "me");
            this.message = message;
            this.guild = guild;
            this.messageAuthorName = str;
            this.messageContent = charSequence;
            this.manageMessageContext = manageMessageContext;
            this.type = i;
            this.isDeveloper = z2;
            this.recentEmojis = list;
            this.channel = channel;
            this.permissions = l;
            this.me = meUser;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Message getMessage() {
            return this.message;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Long getPermissions() {
            return this.permissions;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final MeUser getMe() {
            return this.me;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getMessageAuthorName() {
            return this.messageAuthorName;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final CharSequence getMessageContent() {
            return this.messageContent;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final ManageMessageContext getManageMessageContext() {
            return this.manageMessageContext;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final int getType() {
            return this.type;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getIsDeveloper() {
            return this.isDeveloper;
        }

        public final List<Emoji> component8() {
            return this.recentEmojis;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        public final Model copy(Message message, Guild guild, String messageAuthorName, CharSequence messageContent, ManageMessageContext manageMessageContext, int type, boolean isDeveloper, List<? extends Emoji> recentEmojis, Channel channel, Long permissions, MeUser me2) {
            C12238m.checkNotNullParameter(message, "message");
            C12238m.checkNotNullParameter(messageAuthorName, "messageAuthorName");
            C12238m.checkNotNullParameter(manageMessageContext, "manageMessageContext");
            C12238m.checkNotNullParameter(recentEmojis, "recentEmojis");
            C12238m.checkNotNullParameter(me2, "me");
            return new Model(message, guild, messageAuthorName, messageContent, manageMessageContext, type, isDeveloper, recentEmojis, channel, permissions, me2);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return C12238m.areEqual(this.message, model.message) && C12238m.areEqual(this.guild, model.guild) && C12238m.areEqual(this.messageAuthorName, model.messageAuthorName) && C12238m.areEqual(this.messageContent, model.messageContent) && C12238m.areEqual(this.manageMessageContext, model.manageMessageContext) && this.type == model.type && this.isDeveloper == model.isDeveloper && C12238m.areEqual(this.recentEmojis, model.recentEmojis) && C12238m.areEqual(this.channel, model.channel) && C12238m.areEqual(this.permissions, model.permissions) && C12238m.areEqual(this.me, model.me);
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final ManageMessageContext getManageMessageContext() {
            return this.manageMessageContext;
        }

        public final MeUser getMe() {
            return this.me;
        }

        public final Message getMessage() {
            return this.message;
        }

        public final String getMessageAuthorName() {
            return this.messageAuthorName;
        }

        public final CharSequence getMessageContent() {
            return this.messageContent;
        }

        public final Long getPermissions() {
            return this.permissions;
        }

        public final List<Emoji> getRecentEmojis() {
            return this.recentEmojis;
        }

        public final int getType() {
            return this.type;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v14, types: [int] */
        /* JADX WARN: Type inference failed for: r2v14, types: [int] */
        /* JADX WARN: Type inference failed for: r2v28 */
        /* JADX WARN: Type inference failed for: r2v33 */
        public int hashCode() {
            Message message = this.message;
            int iHashCode = (message != null ? message.hashCode() : 0) * 31;
            Guild guild = this.guild;
            int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
            String str = this.messageAuthorName;
            int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
            CharSequence charSequence = this.messageContent;
            int iHashCode4 = (iHashCode3 + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
            ManageMessageContext manageMessageContext = this.manageMessageContext;
            int iHashCode5 = (((iHashCode4 + (manageMessageContext != null ? manageMessageContext.hashCode() : 0)) * 31) + this.type) * 31;
            boolean z2 = this.isDeveloper;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode5 + r2) * 31;
            List<Emoji> list = this.recentEmojis;
            int iHashCode6 = (i + (list != null ? list.hashCode() : 0)) * 31;
            Channel channel = this.channel;
            int iHashCode7 = (iHashCode6 + (channel != null ? channel.hashCode() : 0)) * 31;
            Long l = this.permissions;
            int iHashCode8 = (iHashCode7 + (l != null ? l.hashCode() : 0)) * 31;
            MeUser meUser = this.me;
            return iHashCode8 + (meUser != null ? meUser.hashCode() : 0);
        }

        public final boolean isDeveloper() {
            return this.isDeveloper;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Model(message=");
            sbM833U.append(this.message);
            sbM833U.append(", guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", messageAuthorName=");
            sbM833U.append(this.messageAuthorName);
            sbM833U.append(", messageContent=");
            sbM833U.append(this.messageContent);
            sbM833U.append(", manageMessageContext=");
            sbM833U.append(this.manageMessageContext);
            sbM833U.append(", type=");
            sbM833U.append(this.type);
            sbM833U.append(", isDeveloper=");
            sbM833U.append(this.isDeveloper);
            sbM833U.append(", recentEmojis=");
            sbM833U.append(this.recentEmojis);
            sbM833U.append(", channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", permissions=");
            sbM833U.append(this.permissions);
            sbM833U.append(", me=");
            sbM833U.append(this.me);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$addReaction$1 */
    /* JADX INFO: compiled from: WidgetChatListActions.kt */
    public static final class C79631 extends AbstractC12240o implements Function1<Void, Unit> {
        public final /* synthetic */ Emoji $emoji;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C79631(Emoji emoji) {
            super(1);
            this.$emoji = emoji;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            StoreStream.INSTANCE.getEmojis().onEmojiUsed(this.$emoji);
            WidgetChatListActions.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$confirmPublishMessage$1 */
    /* JADX INFO: compiled from: WidgetChatListActions.kt */
    public static final /* synthetic */ class C79791 extends C12236k implements Function0<Unit> {
        public C79791(WidgetChatListActions widgetChatListActions) {
            super(0, widgetChatListActions, WidgetChatListActions.class, "dismiss", "dismiss()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((WidgetChatListActions) this.receiver).dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$deleteMessage$1 */
    /* JADX INFO: compiled from: WidgetChatListActions.kt */
    public static final /* synthetic */ class C79801 extends C12236k implements Function0<Unit> {
        public C79801(WidgetChatListActions widgetChatListActions) {
            super(0, widgetChatListActions, WidgetChatListActions.class, "dismiss", "dismiss()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((WidgetChatListActions) this.receiver).dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$editMessage$2 */
    /* JADX INFO: compiled from: WidgetChatListActions.kt */
    public static final class C79822 extends AbstractC12240o implements Function1<CharSequence, Unit> {
        public final /* synthetic */ Message $message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C79822(Message message) {
            super(1);
            this.$message = message;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(CharSequence charSequence) {
            invoke2(charSequence);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CharSequence charSequence) {
            StoreChat chat = StoreStream.INSTANCE.getChat();
            Message message = this.$message;
            C12238m.checkNotNullExpressionValue(charSequence, "unparsedMessageContent");
            chat.setEditingMessage(new StoreChat.EditingMessage(message, charSequence));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$onResume$1 */
    /* JADX INFO: compiled from: WidgetChatListActions.kt */
    public static final class C79831 extends AbstractC12240o implements Function1<Model, Unit> {
        public C79831() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetChatListActions.this.configureUI(model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$onViewCreated$1 */
    /* JADX INFO: compiled from: WidgetChatListActions.kt */
    public static final class C79841 extends AbstractC12240o implements Function1<Emoji, Unit> {
        public C79841() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Emoji emoji) {
            invoke2(emoji);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Emoji emoji) {
            C12238m.checkNotNullParameter(emoji, "emoji");
            WidgetChatListActions.this.addReaction(emoji);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$onViewCreated$2 */
    /* JADX INFO: compiled from: WidgetChatListActions.kt */
    public static final class C79852 extends AbstractC12240o implements Function0<Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$onViewCreated$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetChatListActions.kt */
        public static final class AnonymousClass2 extends AbstractC12240o implements Function0<Unit> {
            public AnonymousClass2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetChatListActions.this.dismiss();
            }
        }

        public C79852() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            FragmentManager parentFragmentManager = WidgetChatListActions.this.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            EmojiPickerNavigator.launchBottomSheet(parentFragmentManager, new EmojiPickerListener() { // from class: com.discord.widgets.chat.list.actions.WidgetChatListActions.onViewCreated.2.1
                @Override // com.discord.widgets.chat.input.emoji.EmojiPickerListener
                public void onEmojiPicked(Emoji emoji) {
                    C12238m.checkNotNullParameter(emoji, "emoji");
                    WidgetChatListActions.this.addReaction(emoji);
                }
            }, EmojiPickerContextType.Chat.INSTANCE, new AnonymousClass2());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$removeAllReactions$1 */
    /* JADX INFO: compiled from: WidgetChatListActions.kt */
    public static final class C79861 extends AbstractC12240o implements Function1<View, Unit> {
        public final /* synthetic */ Model $model;

        /* JADX INFO: renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$removeAllReactions$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetChatListActions.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Void, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r1) {
                WidgetChatListActions.this.dismiss();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C79861(Model model) {
            super(1);
            this.$model = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "view");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().removeAllReactions(this.$model.getMessage().getChannelId(), this.$model.getMessage().getId()), false, 1, null), WidgetChatListActions.this, null, 2, null), (117 & 1) != 0 ? null : view.getContext(), "REST: removeAllReactions", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new AnonymousClass1(), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.C68813.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.C68824.INSTANCE : null));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$toggleMessagePin$1 */
    /* JADX INFO: compiled from: WidgetChatListActions.kt */
    public static final /* synthetic */ class C79871 extends C12236k implements Function0<Unit> {
        public C79871(WidgetChatListActions widgetChatListActions) {
            super(0, widgetChatListActions, WidgetChatListActions.class, "dismiss", "dismiss()V", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((WidgetChatListActions) this.receiver).dismiss();
        }
    }

    public WidgetChatListActions() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChatListActions$binding$2.INSTANCE, null, 2, null);
    }

    private final void addReaction(Emoji emoji) {
        RestAPI api = RestAPI.INSTANCE.getApi();
        long j = this.channelId;
        long j2 = this.messageId;
        String reactionKey = emoji.getReactionKey();
        C12238m.checkNotNullExpressionValue(reactionKey, "emoji.reactionKey");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(api.addReaction(j, j2, reactionKey), false, 1, null), this, null, 2, null), (117 & 1) != 0 ? null : getContext(), "REST: addReaction", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new C79631(emoji), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.C68813.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.C68824.INSTANCE : null));
    }

    private final void configureAddReactionEmojisList(List<? extends Emoji> recentEmojis, boolean isLocalMessage, boolean canAddReactions) {
        if (recentEmojis.isEmpty() || isLocalMessage || !canAddReactions) {
            RecyclerView recyclerView = getBinding().f16122b;
            C12238m.checkNotNullExpressionValue(recyclerView, "binding.dialogChatActionsAddReactionEmojisList");
            recyclerView.setVisibility(8);
            return;
        }
        RecyclerView recyclerView2 = getBinding().f16122b;
        C12238m.checkNotNullExpressionValue(recyclerView2, "binding.dialogChatActionsAddReactionEmojisList");
        recyclerView2.setVisibility(0);
        RecyclerView recyclerView3 = getBinding().f16122b;
        C12238m.checkNotNullExpressionValue(recyclerView3, "binding.dialogChatActionsAddReactionEmojisList");
        int width = recyclerView3.getWidth();
        RecyclerView recyclerView4 = getBinding().f16122b;
        C12238m.checkNotNullExpressionValue(recyclerView4, "binding.dialogChatActionsAddReactionEmojisList");
        int paddingStart = recyclerView4.getPaddingStart();
        RecyclerView recyclerView5 = getBinding().f16122b;
        C12238m.checkNotNullExpressionValue(recyclerView5, "binding.dialogChatActionsAddReactionEmojisList");
        int paddingEnd = recyclerView5.getPaddingEnd() + paddingStart;
        int dimensionPixelSize = getResources().getDimensionPixelSize(C5419R.dimen.chat_input_emoji_size);
        int iDpToPixels = DimenUtils.dpToPixels(8);
        int i = width - paddingEnd;
        int iMin = Math.min(recentEmojis.size() + 1, (i + iDpToPixels) / (dimensionPixelSize + iDpToPixels));
        int i2 = iMin - 1;
        int iMax = Math.max(i - ((i2 * iDpToPixels) + (dimensionPixelSize * iMin)), 0);
        PaddedItemDecorator paddedItemDecorator = this.itemDecorator;
        if (paddedItemDecorator != null) {
            getBinding().f16122b.removeItemDecoration(paddedItemDecorator);
        }
        PaddedItemDecorator paddedItemDecorator2 = new PaddedItemDecorator(0, (iMax / i2) + iDpToPixels, 0, true);
        getBinding().f16122b.addItemDecoration(paddedItemDecorator2);
        this.itemDecorator = paddedItemDecorator2;
        WidgetChatListActionsEmojisAdapter widgetChatListActionsEmojisAdapter = this.adapter;
        if (widgetChatListActionsEmojisAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChatListActionsEmojisAdapter.setData(recentEmojis, iMin);
    }

    /* JADX WARN: Code duplicated, block: B:79:0x01e1  */
    private final void configureUI(final Model data) {
        Channel channel;
        Integer type;
        if (data == null) {
            dismiss();
            return;
        }
        Guild guild = data.getGuild();
        final long id2 = guild != null ? guild.getId() : 0L;
        boolean zIsLocal = data.getMessage().isLocal();
        boolean zIsCrossposted = data.getMessage().isCrossposted();
        boolean z2 = true;
        boolean z3 = data.getManageMessageContext().getCanEdit() || data.getManageMessageContext().getCanManageMessages();
        configureAddReactionEmojisList(data.getRecentEmojis(), zIsLocal, data.getManageMessageContext().getCanAddReactions());
        int type2 = data.getType();
        if (type2 == 0) {
            TextView textView = getBinding().f16126f;
            C12238m.checkNotNullExpressionValue(textView, "binding.dialogChatActionsEdit");
            textView.setVisibility(data.getManageMessageContext().getCanEdit() ? 0 : 8);
            getBinding().f16126f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.actions.WidgetChatListActions.configureUI.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetChatListActions.this.editMessage(data.getMessage());
                    WidgetChatListActions.this.dismiss();
                }
            });
        } else if (type2 == 1) {
            TextView textView2 = getBinding().f16126f;
            C12238m.checkNotNullExpressionValue(textView2, "binding.dialogChatActionsEdit");
            textView2.setVisibility(8);
        }
        TextView textView3 = getBinding().f16131k;
        C12238m.checkNotNullExpressionValue(textView3, "binding.dialogChatActionsPublish");
        textView3.setVisibility(z3 && (channel = data.getChannel()) != null && channel.getType() == 5 && (type = data.getMessage().getType()) != null && type.intValue() == 0 && !zIsCrossposted ? 0 : 8);
        getBinding().f16131k.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.actions.WidgetChatListActions.configureUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatListActions.this.confirmPublishMessage(data.getMessage());
            }
        });
        TextView textView4 = getBinding().f16127g;
        C12238m.checkNotNullExpressionValue(textView4, "binding.dialogChatActionsManageReactions");
        textView4.setVisibility(data.getMessage().getReactionsMap().isEmpty() ^ true ? 0 : 8);
        getBinding().f16127g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.actions.WidgetChatListActions.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetManageReactions.Companion companion = WidgetManageReactions.INSTANCE;
                long j = WidgetChatListActions.this.channelId;
                long j2 = WidgetChatListActions.this.messageId;
                Context contextRequireContext = WidgetChatListActions.this.requireContext();
                C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                WidgetManageReactions.Companion.create$default(companion, j, j2, contextRequireContext, null, 8, null);
            }
        });
        TextView textView5 = getBinding().f16132l;
        C12238m.checkNotNullExpressionValue(textView5, "binding.dialogChatActionsRemoveAllReactions");
        textView5.setVisibility((data.getMessage().getReactionsMap().isEmpty() ^ true) && data.getManageMessageContext().getCanManageMessages() ? 0 : 8);
        getBinding().f16132l.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.actions.WidgetChatListActions.configureUI.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatListActions.this.removeAllReactions(data);
            }
        });
        TextView textView6 = getBinding().f16135o;
        C12238m.checkNotNullExpressionValue(textView6, "binding.dialogChatActionsResend");
        textView6.setVisibility(data.getMessage().canResend() ? 0 : 8);
        getBinding().f16135o.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.actions.WidgetChatListActions.configureUI.5

            /* JADX INFO: renamed from: com.discord.widgets.chat.list.actions.WidgetChatListActions$configureUI$5$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetChatListActions.kt */
            public static final class AnonymousClass1 extends AbstractC12240o implements Function1<MessageResult, Unit> {
                public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                public AnonymousClass1() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(MessageResult messageResult) {
                    invoke2(messageResult);
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(MessageResult messageResult) {
                    C12238m.checkNotNullParameter(messageResult, "messageResult");
                    if (messageResult instanceof MessageResult.CaptchaRequired) {
                        SendUtils.INSTANCE.handleCaptchaRequired((MessageResult.CaptchaRequired) messageResult);
                    }
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Integer type3 = data.getMessage().getType();
                if (type3 != null && type3.intValue() == -4) {
                    StoreStream.INSTANCE.getInteractions().resendApplicationCommand(data.getMessage());
                } else {
                    ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8518ui(StoreMessages.resendMessage$default(StoreStream.INSTANCE.getMessages(), data.getMessage(), false, null, 6, null)), (Class<?>) WidgetChatListActions.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), AnonymousClass1.INSTANCE);
                }
                WidgetChatListActions.this.dismiss();
            }
        });
        TextView textView7 = getBinding().f16128h;
        C12238m.checkNotNullExpressionValue(textView7, "binding.dialogChatActionsMarkUnread");
        textView7.setVisibility(!data.getMessage().isFailed() && data.getManageMessageContext().getCanMarkUnread() ? 0 : 8);
        getBinding().f16128h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.actions.WidgetChatListActions.configureUI.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StoreStream.INSTANCE.getMessageAck().markUnread(data.getMessage().getChannelId(), data.getMessage().getId());
                WidgetChatListActions.this.dismiss();
            }
        });
        if (data.getMessageContent() == null) {
            TextView textView8 = getBinding().f16123c;
            C12238m.checkNotNullExpressionValue(textView8, "binding.dialogChatActionsCopy");
            textView8.setVisibility(8);
        } else {
            if (!(data.getMessageContent().length() > 0) || data.getMessage().isLocalApplicationCommand()) {
                TextView textView9 = getBinding().f16123c;
                C12238m.checkNotNullExpressionValue(textView9, "binding.dialogChatActionsCopy");
                textView9.setVisibility(8);
            } else {
                TextView textView10 = getBinding().f16123c;
                C12238m.checkNotNullExpressionValue(textView10, "binding.dialogChatActionsCopy");
                textView10.setVisibility(0);
                getBinding().f16123c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.actions.WidgetChatListActions.configureUI.7
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Context contextRequireContext = WidgetChatListActions.this.requireContext();
                        C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                        String string = data.getMessageContent().toString();
                        EditedMessageNode.Companion companion = EditedMessageNode.INSTANCE;
                        C12238m.checkNotNullExpressionValue(view, "it");
                        Context context = view.getContext();
                        C12238m.checkNotNullExpressionValue(context, "it.context");
                        C0876m.m165c(contextRequireContext, C12103t.replace$default(string, companion.getEditedString(context), "", false, 4, (Object) null), 0, 4);
                        WidgetChatListActions.this.dismiss();
                    }
                });
            }
        }
        TextView textView11 = getBinding().f16124d;
        C12238m.checkNotNullExpressionValue(textView11, "binding.dialogChatActionsCopyId");
        textView11.setVisibility(data.isDeveloper() && !zIsLocal ? 0 : 8);
        getBinding().f16124d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.actions.WidgetChatListActions.configureUI.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Context contextRequireContext = WidgetChatListActions.this.requireContext();
                C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                C0876m.m165c(contextRequireContext, String.valueOf(data.getMessage().getId()), 0, 4);
                WidgetChatListActions.this.dismiss();
            }
        });
        TextView textView12 = getBinding().f16134n;
        C12238m.checkNotNullExpressionValue(textView12, "binding.dialogChatActionsReport");
        User author = data.getMessage().getAuthor();
        textView12.setVisibility(author == null || (author.getId() > data.getMe().getId() ? 1 : (author.getId() == data.getMe().getId() ? 0 : -1)) != 0 ? 0 : 8);
        getBinding().f16134n.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.actions.WidgetChatListActions.configureUI.9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (ReportsFeatureFlag.INSTANCE.isEnabled()) {
                    WidgetMobileReports.INSTANCE.launchMessageReport(C1643a.m885x(view, "view", "view.context"), data.getMessage().getId(), WidgetChatListActions.this.channelId);
                } else {
                    WidgetTosReportViolation.INSTANCE.show(C1643a.m885x(view, "view", "view.context"), data.getMessageAuthorName(), Long.valueOf(data.getMessage().getChannelId()), Long.valueOf(data.getMessage().getId()));
                }
                WidgetChatListActions.this.dismiss();
            }
        });
        TextView textView13 = getBinding().f16136p;
        C12238m.checkNotNullExpressionValue(textView13, "binding.dialogChatActionsShare");
        textView13.setVisibility(data.isDeveloper() && !zIsLocal ? 0 : 8);
        getBinding().f16136p.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.actions.WidgetChatListActions.configureUI.10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatListActions.this.requireContext().startActivity(Intent.createChooser(IntentUtils.INSTANCE.toExternalizedSend(IntentUtils.RouteBuilders.selectChannel(data.getMessage().getChannelId(), id2, Long.valueOf(data.getMessage().getId()))), WidgetChatListActions.this.getString(C5419R.string.share_to)));
                WidgetChatListActions.this.dismiss();
            }
        });
        TextView textView14 = getBinding().f16129i;
        C12238m.checkNotNullExpressionValue(textView14, "binding.dialogChatActionsPin");
        textView14.setVisibility(data.getManageMessageContext().getCanTogglePinned() ? 0 : 8);
        getBinding().f16129i.setText(C12238m.areEqual(data.getMessage().getPinned(), Boolean.TRUE) ? C5419R.string.unpin : C5419R.string.pin);
        getBinding().f16129i.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.actions.WidgetChatListActions.configureUI.11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatListActions.this.toggleMessagePin(data.getMessage());
            }
        });
        TextView textView15 = getBinding().f16125e;
        C12238m.checkNotNullExpressionValue(textView15, "binding.dialogChatActionsDelete");
        textView15.setVisibility(data.getManageMessageContext().getCanDelete() ? 0 : 8);
        getBinding().f16125e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.actions.WidgetChatListActions.configureUI.12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatListActions.this.deleteMessage(data.getMessage());
            }
        });
        getBinding().f16130j.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.actions.WidgetChatListActions.configureUI.13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatListActions.this.dismiss();
                User author2 = data.getMessage().getAuthor();
                if (author2 != null) {
                    long id3 = author2.getId();
                    WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
                    FragmentManager parentFragmentManager = WidgetChatListActions.this.getParentFragmentManager();
                    C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    WidgetUserSheet.Companion.show$default(companion, id3, null, parentFragmentManager, null, null, null, null, 122, null);
                }
            }
        });
        boolean z4 = (data.getChannel() == null || !ChannelUtils.m7667B(data.getChannel()) || ChannelUtils.m7670E(data.getChannel())) ? false : true;
        boolean z5 = data.getMessage().isUserMessage() || data.getMessage().isApplicationMessage();
        if (zIsLocal || data.getType() != 0 || !z5 || (!z4 && !PermissionUtils.can(67584L, data.getPermissions()))) {
            z2 = false;
        }
        TextView textView16 = getBinding().f16133m;
        C12238m.checkNotNullExpressionValue(textView16, "binding.dialogChatActionsReply");
        textView16.setVisibility(z2 ? 0 : 8);
        getBinding().f16133m.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.actions.WidgetChatListActions.configureUI.14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatListActions.this.dismiss();
                if (data.getChannel() != null) {
                    WidgetChatListActions.this.replyMessage(data.getMessage(), data.getChannel());
                }
            }
        });
        TextView textView17 = getBinding().f16137q;
        C12238m.checkNotNullExpressionValue(textView17, "binding.dialogChatActionsStartThread");
        textView17.setVisibility(ThreadUtils.INSTANCE.canCreatePublicThread(data.getPermissions(), data.getChannel(), data.getMessage(), data.getGuild()) ? 0 : 8);
        getBinding().f16137q.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.actions.WidgetChatListActions.configureUI.15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatListActions.this.dismiss();
                ChannelSelector.INSTANCE.getInstance().openCreateThread(id2, data.getMessage().getChannelId(), Long.valueOf(data.getMessage().getId()), "Message");
            }
        });
    }

    @MainThread
    private final void confirmPublishMessage(Message message) {
        MessageActionDialogs messageActionDialogs = MessageActionDialogs.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        messageActionDialogs.showPublishMessageConfirmation(parentFragmentManager, message, new C79791(this));
    }

    @MainThread
    private final void deleteMessage(Message message) {
        MessageActionDialogs messageActionDialogs = MessageActionDialogs.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        messageActionDialogs.showDeleteMessageConfirmation(parentFragmentManager, contextRequireContext, message, new C79801(this));
    }

    private final void editMessage(final Message message) {
        Observable<R> observableM11099Y = StoreStream.INSTANCE.getChannels().observeGuildAndPrivateChannels().m11099Y(new InterfaceC12589b<Map<Long, ? extends Channel>, Observable<? extends CharSequence>>() { // from class: com.discord.widgets.chat.list.actions.WidgetChatListActions.editMessage.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Observable<? extends CharSequence> call(Map<Long, ? extends Channel> map) {
                return call2((Map<Long, Channel>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends CharSequence> call2(final Map<Long, Channel> map) {
                Channel channel = map.get(Long.valueOf(message.getChannelId()));
                final long guildId = channel != null ? channel.getGuildId() : 0L;
                StoreStream.Companion companion = StoreStream.INSTANCE;
                return Observable.m11075i(companion.getUsers().observeAllUsers(), companion.getGuilds().observeGuilds(), companion.getEmojis().getEmojiSet(guildId, message.getChannelId(), (12 & 4) != 0 ? false : false, (12 & 8) != 0 ? false : false), new Func3<Map<Long, ? extends com.discord.models.user.User>, Map<Long, ? extends Guild>, EmojiSet, CharSequence>() { // from class: com.discord.widgets.chat.list.actions.WidgetChatListActions.editMessage.1.1
                    @Override // p658rx.functions.Func3
                    public /* bridge */ /* synthetic */ CharSequence call(Map<Long, ? extends com.discord.models.user.User> map2, Map<Long, ? extends Guild> map3, EmojiSet emojiSet) {
                        return call2(map2, (Map<Long, Guild>) map3, emojiSet);
                    }

                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final CharSequence call2(Map<Long, ? extends com.discord.models.user.User> map2, Map<Long, Guild> map3, EmojiSet emojiSet) {
                        String content = message.getContent();
                        if (content == null) {
                            content = "";
                        }
                        Guild guild = map3.get(Long.valueOf(guildId));
                        Map map4 = map;
                        C12238m.checkNotNullExpressionValue(map4, "channels");
                        C12238m.checkNotNullExpressionValue(map2, "users");
                        C12238m.checkNotNullExpressionValue(emojiSet, "emojiSet");
                        return MessageUnparser.unparse(content, guild, map4, map2, emojiSet);
                    }
                });
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n        .get…              }\n        }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.takeSingleUntilTimeout$default(ObservableExtensionsKt.computationBuffered(observableM11099Y), 0L, false, 3, null), (117 & 1) != 0 ? null : null, "editMessage", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), new C79822(message), (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.C68813.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.C68824.INSTANCE : null));
    }

    private final WidgetChatListActionsBinding getBinding() {
        return (WidgetChatListActionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @MainThread
    private final void removeAllReactions(Model model) {
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        String string = getString(C5419R.string.remove_all_reactions_confirm_title);
        String string2 = getString(C5419R.string.remove_all_reactions_confirm_body);
        C12238m.checkNotNullExpressionValue(string2, "getString(R.string.remov…l_reactions_confirm_body)");
        WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, string, string2, getString(C5419R.string.yes_text), getString(C5419R.string.no_text), C12134g0.mapOf(C12116o.m10073to(Integer.valueOf(C5419R.id.notice_ok), new C79861(model))), null, null, null, null, null, null, 0, null, 16320, null);
    }

    private final void replyMessage(Message message, Channel channel) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        long id2 = companion.getUsers().getMeSnapshot().getId();
        boolean zM7667B = ChannelUtils.m7667B(channel);
        boolean zIsWebhook = message.isWebhook();
        User author = message.getAuthor();
        boolean z2 = author != null && author.getId() == id2;
        companion.getPendingReplies().onCreatePendingReply(channel, message, (zIsWebhook || z2) ? false : true, (zM7667B || zIsWebhook || z2) ? false : true);
    }

    public static final void showForChat(FragmentManager fragmentManager, long j, long j2, CharSequence charSequence) {
        INSTANCE.showForChat(fragmentManager, j, j2, charSequence);
    }

    public static final void showForPin(FragmentManager fragmentManager, long j, long j2, CharSequence charSequence) {
        INSTANCE.showForPin(fragmentManager, j, j2, charSequence);
    }

    @MainThread
    private final void toggleMessagePin(Message message) {
        MessageActionDialogs messageActionDialogs = MessageActionDialogs.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Context contextRequireContext = requireContext();
        C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        messageActionDialogs.showPinMessageConfirmation(parentFragmentManager, contextRequireContext, message, this, new C79871(this));
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_chat_list_actions;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        AppBottomSheet.hideKeyboard$default(this, null, 1, null);
        Observable observableM11112r = ObservableExtensionsKt.computationLatest(Model.INSTANCE.get(this.channelId, this.messageId, getArgumentsOrDefault().getCharSequence(INTENT_EXTRA_MESSAGE_CONTENT), getArgumentsOrDefault().getInt(INTENT_EXTRA_TYPE))).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "Model.get(channelId, mes…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11112r, this, null, 2, null), (Class<?>) WidgetChatListActions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C79831());
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.channelId = getArgumentsOrDefault().getLong(INTENT_EXTRA_MESSAGE_CHANNEL_ID);
        this.messageId = getArgumentsOrDefault().getLong(INTENT_EXTRA_MESSAGE_ID);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f16122b;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.dialogChatActionsAddReactionEmojisList");
        WidgetChatListActionsEmojisAdapter widgetChatListActionsEmojisAdapter = (WidgetChatListActionsEmojisAdapter) companion.configure(new WidgetChatListActionsEmojisAdapter(recyclerView));
        this.adapter = widgetChatListActionsEmojisAdapter;
        if (widgetChatListActionsEmojisAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChatListActionsEmojisAdapter.setOnClickEmoji(new C79841());
        WidgetChatListActionsEmojisAdapter widgetChatListActionsEmojisAdapter2 = this.adapter;
        if (widgetChatListActionsEmojisAdapter2 == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChatListActionsEmojisAdapter2.setOnClickMoreEmojis(new C79852());
        RecyclerView recyclerView2 = getBinding().f16122b;
        C12238m.checkNotNullExpressionValue(recyclerView2, "binding.dialogChatActionsAddReactionEmojisList");
        WidgetChatListActionsEmojisAdapter widgetChatListActionsEmojisAdapter3 = this.adapter;
        if (widgetChatListActionsEmojisAdapter3 == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.setAdapter(widgetChatListActionsEmojisAdapter3);
        getBinding().f16122b.setHasFixedSize(true);
    }
}
