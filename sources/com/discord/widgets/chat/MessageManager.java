package com.discord.widgets.chat;

import android.content.Context;
import android.content.pm.ShortcutManager;
import android.os.Build;
import androidx.core.content.p004pm.ShortcutInfoCompat;
import androidx.core.content.p004pm.ShortcutManagerCompat;
import com.discord.api.message.MessageReference;
import com.discord.api.message.allowedmentions.MessageAllowedMentions;
import com.discord.api.message.allowedmentions.MessageAllowedMentionsTypes;
import com.discord.api.sticker.BaseSticker;
import com.discord.api.user.User;
import com.discord.models.guild.Guild;
import com.discord.models.message.Message;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreApplicationInteractions;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreMessageReplies;
import com.discord.stores.StoreMessages;
import com.discord.stores.StorePendingReplies;
import com.discord.stores.StoreSlowMode;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.messagesend.MessageResult;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.SendUtils;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.chat.input.models.ApplicationCommandData;
import com.lytefast.flexinput.model.Attachment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12141k;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;

/* JADX INFO: compiled from: MessageManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageManager {
    private final Context context;
    private final Function1<MessageSendResult, Unit> defaultMessageResultHandler;
    private final StoreApplicationInteractions storeApplicationInteractions;
    private final StoreChannelsSelected storeChannelsSelected;
    private final StoreGuilds storeGuilds;
    private final StoreMessageReplies storeMessageReplies;
    private final StoreMessages storeMessages;
    private final StorePendingReplies storePendingReplies;
    private final StoreSlowMode storeSlowMode;
    private final StoreUser storeUser;

    /* JADX INFO: compiled from: MessageManager.kt */
    public static abstract class AttachmentValidationResult {

        /* JADX INFO: compiled from: MessageManager.kt */
        public static final class EmptyAttachments extends AttachmentValidationResult {
            public static final EmptyAttachments INSTANCE = new EmptyAttachments();

            private EmptyAttachments() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: MessageManager.kt */
        public static final /* data */ class FilesTooLarge extends AttachmentValidationResult {
            private final AttachmentsRequest attachmentsRequest;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public FilesTooLarge(AttachmentsRequest attachmentsRequest) {
                super(null);
                C12238m.checkNotNullParameter(attachmentsRequest, "attachmentsRequest");
                this.attachmentsRequest = attachmentsRequest;
            }

            public static /* synthetic */ FilesTooLarge copy$default(FilesTooLarge filesTooLarge, AttachmentsRequest attachmentsRequest, int i, Object obj) {
                if ((i & 1) != 0) {
                    attachmentsRequest = filesTooLarge.attachmentsRequest;
                }
                return filesTooLarge.copy(attachmentsRequest);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final AttachmentsRequest getAttachmentsRequest() {
                return this.attachmentsRequest;
            }

            public final FilesTooLarge copy(AttachmentsRequest attachmentsRequest) {
                C12238m.checkNotNullParameter(attachmentsRequest, "attachmentsRequest");
                return new FilesTooLarge(attachmentsRequest);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof FilesTooLarge) && C12238m.areEqual(this.attachmentsRequest, ((FilesTooLarge) other).attachmentsRequest);
                }
                return true;
            }

            public final AttachmentsRequest getAttachmentsRequest() {
                return this.attachmentsRequest;
            }

            public int hashCode() {
                AttachmentsRequest attachmentsRequest = this.attachmentsRequest;
                if (attachmentsRequest != null) {
                    return attachmentsRequest.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("FilesTooLarge(attachmentsRequest=");
                sbM833U.append(this.attachmentsRequest);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: compiled from: MessageManager.kt */
        public static final class Success extends AttachmentValidationResult {
            public static final Success INSTANCE = new Success();

            private Success() {
                super(null);
            }
        }

        private AttachmentValidationResult() {
        }

        public /* synthetic */ AttachmentValidationResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: MessageManager.kt */
    public static final class AttachmentsRequest {
        private final List<Attachment<?>> attachments;
        private final float currentFileSizeMB;
        private final int maxFileSizeMB;

        /* JADX WARN: Multi-variable type inference failed */
        public AttachmentsRequest(float f, int i, List<? extends Attachment<?>> list) {
            this.currentFileSizeMB = f;
            this.maxFileSizeMB = i;
            this.attachments = list;
        }

        public final List<Attachment<?>> getAttachments() {
            return this.attachments;
        }

        public final float getCurrentFileSizeMB() {
            return this.currentFileSizeMB;
        }

        public final int getMaxFileSizeMB() {
            return this.maxFileSizeMB;
        }

        public /* synthetic */ AttachmentsRequest(float f, int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, i, (i2 & 4) != 0 ? null : list);
        }
    }

    /* JADX INFO: compiled from: MessageManager.kt */
    public static abstract class ContentValidationResult {

        /* JADX INFO: compiled from: MessageManager.kt */
        public static final class EmptyContent extends ContentValidationResult {
            public static final EmptyContent INSTANCE = new EmptyContent();

            private EmptyContent() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: MessageManager.kt */
        public static final /* data */ class MessageTooLong extends ContentValidationResult {
            private final int maxMessageLength;

            public MessageTooLong(int i) {
                super(null);
                this.maxMessageLength = i;
            }

            public static /* synthetic */ MessageTooLong copy$default(MessageTooLong messageTooLong, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = messageTooLong.maxMessageLength;
                }
                return messageTooLong.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getMaxMessageLength() {
                return this.maxMessageLength;
            }

            public final MessageTooLong copy(int maxMessageLength) {
                return new MessageTooLong(maxMessageLength);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof MessageTooLong) && this.maxMessageLength == ((MessageTooLong) other).maxMessageLength;
                }
                return true;
            }

            public final int getMaxMessageLength() {
                return this.maxMessageLength;
            }

            public int hashCode() {
                return this.maxMessageLength;
            }

            public String toString() {
                return C1643a.m814B(C1643a.m833U("MessageTooLong(maxMessageLength="), this.maxMessageLength, ")");
            }
        }

        /* JADX INFO: compiled from: MessageManager.kt */
        public static final class Success extends ContentValidationResult {
            public static final Success INSTANCE = new Success();

            private Success() {
                super(null);
            }
        }

        private ContentValidationResult() {
        }

        public /* synthetic */ ContentValidationResult(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: MessageManager.kt */
    public static final /* data */ class MessageSendResult {
        private final Guild guild;
        private final MessageResult messageResult;

        public MessageSendResult(MessageResult messageResult, Guild guild) {
            C12238m.checkNotNullParameter(messageResult, "messageResult");
            this.messageResult = messageResult;
            this.guild = guild;
        }

        public static /* synthetic */ MessageSendResult copy$default(MessageSendResult messageSendResult, MessageResult messageResult, Guild guild, int i, Object obj) {
            if ((i & 1) != 0) {
                messageResult = messageSendResult.messageResult;
            }
            if ((i & 2) != 0) {
                guild = messageSendResult.guild;
            }
            return messageSendResult.copy(messageResult, guild);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final MessageResult getMessageResult() {
            return this.messageResult;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final MessageSendResult copy(MessageResult messageResult, Guild guild) {
            C12238m.checkNotNullParameter(messageResult, "messageResult");
            return new MessageSendResult(messageResult, guild);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MessageSendResult)) {
                return false;
            }
            MessageSendResult messageSendResult = (MessageSendResult) other;
            return C12238m.areEqual(this.messageResult, messageSendResult.messageResult) && C12238m.areEqual(this.guild, messageSendResult.guild);
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final MessageResult getMessageResult() {
            return this.messageResult;
        }

        public int hashCode() {
            MessageResult messageResult = this.messageResult;
            int iHashCode = (messageResult != null ? messageResult.hashCode() : 0) * 31;
            Guild guild = this.guild;
            return iHashCode + (guild != null ? guild.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("MessageSendResult(messageResult=");
            sbM833U.append(this.messageResult);
            sbM833U.append(", guild=");
            sbM833U.append(this.guild);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.MessageManager$sendCommand$1 */
    /* JADX INFO: compiled from: MessageManager.kt */
    public static final class C76701 extends AbstractC12240o implements Function0<Unit> {
        public static final C76701 INSTANCE = new C76701();

        public C76701() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.MessageManager$sendCommand$2 */
    /* JADX INFO: compiled from: MessageManager.kt */
    public static final class C76712 extends AbstractC12240o implements Function1<Error, Unit> {
        public static final C76712 INSTANCE = new C76712();

        public C76712() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.MessageManager$sendMessage$2 */
    /* JADX INFO: compiled from: MessageManager.kt */
    public static final class C76732 extends AbstractC12240o implements Function1<MessageSendResult, Unit> {
        public final /* synthetic */ Function1 $messageSendResultHandler;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C76732(Function1 function1) {
            super(1);
            this.$messageSendResultHandler = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MessageSendResult messageSendResult) {
            invoke2(messageSendResult);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MessageSendResult messageSendResult) {
            Function1 function1 = this.$messageSendResultHandler;
            C12238m.checkNotNullExpressionValue(messageSendResult, "messageSendResult");
            function1.invoke(messageSendResult);
        }
    }

    public MessageManager(Context context, StoreMessages storeMessages, StoreApplicationInteractions storeApplicationInteractions, StoreUser storeUser, StoreChannelsSelected storeChannelsSelected, StoreSlowMode storeSlowMode, StoreGuilds storeGuilds, StorePendingReplies storePendingReplies, StoreMessageReplies storeMessageReplies) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(storeMessages, "storeMessages");
        C12238m.checkNotNullParameter(storeApplicationInteractions, "storeApplicationInteractions");
        C12238m.checkNotNullParameter(storeUser, "storeUser");
        C12238m.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        C12238m.checkNotNullParameter(storeSlowMode, "storeSlowMode");
        C12238m.checkNotNullParameter(storeGuilds, "storeGuilds");
        C12238m.checkNotNullParameter(storePendingReplies, "storePendingReplies");
        C12238m.checkNotNullParameter(storeMessageReplies, "storeMessageReplies");
        this.context = context;
        this.storeMessages = storeMessages;
        this.storeApplicationInteractions = storeApplicationInteractions;
        this.storeUser = storeUser;
        this.storeChannelsSelected = storeChannelsSelected;
        this.storeSlowMode = storeSlowMode;
        this.storeGuilds = storeGuilds;
        this.storePendingReplies = storePendingReplies;
        this.storeMessageReplies = storeMessageReplies;
        this.defaultMessageResultHandler = new MessageManager$defaultMessageResultHandler$1(this);
    }

    private final MessageAllowedMentions getAllowedMentionsForMessageEdit(long channelId, long messageId) {
        Integer type;
        MessageReference messageReference;
        Long messageId2;
        Message message = this.storeMessages.getMessage(channelId, messageId);
        if (message != null && (type = message.getType()) != null && type.intValue() == 19 && (messageReference = message.getMessageReference()) != null && (messageId2 = messageReference.getMessageId()) != null) {
            StoreMessageReplies.MessageState messageState = this.storeMessageReplies.getAllMessageReferences().get(Long.valueOf(messageId2.longValue()));
            if (messageState == null || !(messageState instanceof StoreMessageReplies.MessageState.Loaded)) {
                return null;
            }
            List<User> mentions = message.getMentions();
            if (mentions != null) {
                boolean z2 = false;
                if (!mentions.isEmpty()) {
                    Iterator<T> it = mentions.iterator();
                    while (it.hasNext()) {
                        long id2 = ((User) it.next()).getId();
                        User author = ((StoreMessageReplies.MessageState.Loaded) messageState).getMessage().getAuthor();
                        if (author != null && id2 == author.getId()) {
                            z2 = true;
                            break;
                        }
                    }
                }
                if (z2) {
                    return null;
                }
            }
            return new MessageAllowedMentions(C12141k.toList(MessageAllowedMentionsTypes.values()), null, null, Boolean.FALSE, 6);
        }
        return null;
    }

    public static /* synthetic */ boolean isValidForumPostFirstMessage$default(MessageManager messageManager, String str, AttachmentsRequest attachmentsRequest, Function2 function2, Function2 function3, int i, Object obj) {
        if ((i & 2) != 0) {
            attachmentsRequest = null;
        }
        return messageManager.isValidForumPostFirstMessage(str, attachmentsRequest, function2, function3);
    }

    private final AttachmentValidationResult validateAttachments(AttachmentsRequest attachmentsRequest) {
        if (attachmentsRequest == null) {
            return AttachmentValidationResult.EmptyAttachments.INSTANCE;
        }
        List<Attachment<?>> attachments = attachmentsRequest.getAttachments();
        if (attachments == null || attachments.isEmpty()) {
            return AttachmentValidationResult.EmptyAttachments.INSTANCE;
        }
        return attachmentsRequest.getCurrentFileSizeMB() >= ((float) attachmentsRequest.getMaxFileSizeMB()) ? new AttachmentValidationResult.FilesTooLarge(attachmentsRequest) : AttachmentValidationResult.Success.INSTANCE;
    }

    private final ContentValidationResult validateMessageContent(String content, List<? extends BaseSticker> stickers, MeUser meUser, boolean isEditing, Integer previousMessageLength) {
        boolean z2 = true;
        int i = (UserUtils.INSTANCE.isPremiumTier2(meUser) || (isEditing && previousMessageLength != null && previousMessageLength.intValue() > 2000)) ? SendUtils.MAX_MESSAGE_CHARACTER_COUNT_PREMIUM : 2000;
        if (content.length() == 0) {
            if (stickers != null && !stickers.isEmpty()) {
                z2 = false;
            }
            if (z2) {
                return ContentValidationResult.EmptyContent.INSTANCE;
            }
        }
        return content.length() > i ? new ContentValidationResult.MessageTooLong(i) : ContentValidationResult.Success.INSTANCE;
    }

    public static /* synthetic */ ContentValidationResult validateMessageContent$default(MessageManager messageManager, String str, List list, MeUser meUser, boolean z2, Integer num, int i, Object obj) {
        if ((i & 16) != 0) {
            num = null;
        }
        return messageManager.validateMessageContent(str, list, meUser, z2, num);
    }

    public final boolean editMessage(long messageId, long channelId, String content, Function2<? super Integer, ? super Integer, Unit> onMessageTooLong, Integer previousMessageLength) {
        C12238m.checkNotNullParameter(content, "content");
        ContentValidationResult contentValidationResultValidateMessageContent = validateMessageContent(content, C12147n.emptyList(), this.storeUser.getMeSnapshot(), true, previousMessageLength);
        if (contentValidationResultValidateMessageContent instanceof ContentValidationResult.MessageTooLong) {
            if (onMessageTooLong != null) {
                onMessageTooLong.invoke(Integer.valueOf(content.length()), Integer.valueOf(((ContentValidationResult.MessageTooLong) contentValidationResultValidateMessageContent).getMaxMessageLength()));
            }
            return false;
        }
        if (C12238m.areEqual(contentValidationResultValidateMessageContent, ContentValidationResult.EmptyContent.INSTANCE)) {
            return false;
        }
        C12238m.areEqual(contentValidationResultValidateMessageContent, ContentValidationResult.Success.INSTANCE);
        this.storeMessages.editMessage(messageId, channelId, content, getAllowedMentionsForMessageEdit(channelId, messageId));
        return true;
    }

    public final boolean isValidForumPostFirstMessage(String content, AttachmentsRequest attachmentsRequest, Function2<? super Integer, ? super Integer, Unit> onMessageTooLong, Function2<? super Integer, ? super Boolean, Unit> onFilesTooLarge) {
        C12238m.checkNotNullParameter(content, "content");
        MeUser meSnapshot = this.storeUser.getMeSnapshot();
        ContentValidationResult contentValidationResultValidateMessageContent$default = validateMessageContent$default(this, content, C12147n.emptyList(), meSnapshot, false, null, 16, null);
        if (contentValidationResultValidateMessageContent$default instanceof ContentValidationResult.MessageTooLong) {
            if (onMessageTooLong != null) {
                onMessageTooLong.invoke(Integer.valueOf(content.length()), Integer.valueOf(((ContentValidationResult.MessageTooLong) contentValidationResultValidateMessageContent$default).getMaxMessageLength()));
            }
            return false;
        }
        AttachmentValidationResult attachmentValidationResultValidateAttachments = validateAttachments(attachmentsRequest);
        if (!(attachmentValidationResultValidateAttachments instanceof AttachmentValidationResult.FilesTooLarge)) {
            return true;
        }
        if (onFilesTooLarge != null) {
            onFilesTooLarge.invoke(Integer.valueOf(((AttachmentValidationResult.FilesTooLarge) attachmentValidationResultValidateAttachments).getAttachmentsRequest().getMaxFileSizeMB()), Boolean.valueOf(UserUtils.INSTANCE.isPremium(meSnapshot)));
        }
        return false;
    }

    public final boolean sendCommand(long channelId, Long guildId, String version, ApplicationCommandData data, AttachmentsRequest attachmentRequest, Function0<Unit> onSuccess, Function1<? super Error, Unit> onFail, Function2<? super Integer, ? super Boolean, Unit> onFilesTooLarge) {
        C12238m.checkNotNullParameter(data, "data");
        C12238m.checkNotNullParameter(onSuccess, "onSuccess");
        C12238m.checkNotNullParameter(onFail, "onFail");
        MeUser meSnapshot = this.storeUser.getMeSnapshot();
        AttachmentValidationResult attachmentValidationResultValidateAttachments = validateAttachments(attachmentRequest);
        if (!(attachmentValidationResultValidateAttachments instanceof AttachmentValidationResult.FilesTooLarge)) {
            this.storeApplicationInteractions.sendApplicationCommand(channelId, guildId, version, data, attachmentRequest != null ? attachmentRequest.getAttachments() : null, C76701.INSTANCE, C76712.INSTANCE);
            return true;
        }
        AttachmentsRequest attachmentsRequest = ((AttachmentValidationResult.FilesTooLarge) attachmentValidationResultValidateAttachments).getAttachmentsRequest();
        if (onFilesTooLarge == null) {
            return false;
        }
        onFilesTooLarge.invoke(Integer.valueOf(attachmentsRequest.getMaxFileSizeMB()), Boolean.valueOf(UserUtils.INSTANCE.isPremium(meSnapshot)));
        return false;
    }

    public final boolean sendMessage(final String content, final List<? extends com.discord.models.user.User> mentions, AttachmentsRequest attachmentsRequest, Long channelId, final List<? extends BaseSticker> stickers, boolean consumePendingReply, Function2<? super Integer, ? super Integer, Unit> onMessageTooLong, Function2<? super Integer, ? super Boolean, Unit> onFilesTooLarge, Function1<? super MessageSendResult, Unit> messageSendResultHandler) {
        ShortcutManager shortcutManager;
        C12238m.checkNotNullParameter(content, "content");
        C12238m.checkNotNullParameter(stickers, "stickers");
        C12238m.checkNotNullParameter(messageSendResultHandler, "messageSendResultHandler");
        final MeUser meSnapshot = this.storeUser.getMeSnapshot();
        ContentValidationResult contentValidationResultValidateMessageContent$default = validateMessageContent$default(this, content, stickers, meSnapshot, false, null, 16, null);
        if (contentValidationResultValidateMessageContent$default instanceof ContentValidationResult.MessageTooLong) {
            if (onMessageTooLong != null) {
                onMessageTooLong.invoke(Integer.valueOf(content.length()), Integer.valueOf(((ContentValidationResult.MessageTooLong) contentValidationResultValidateMessageContent$default).getMaxMessageLength()));
            }
            return false;
        }
        AttachmentValidationResult attachmentValidationResultValidateAttachments = validateAttachments(attachmentsRequest);
        if (attachmentValidationResultValidateAttachments instanceof AttachmentValidationResult.FilesTooLarge) {
            AttachmentsRequest attachmentsRequest2 = ((AttachmentValidationResult.FilesTooLarge) attachmentValidationResultValidateAttachments).getAttachmentsRequest();
            if (onFilesTooLarge != null) {
                onFilesTooLarge.invoke(Integer.valueOf(attachmentsRequest2.getMaxFileSizeMB()), Boolean.valueOf(UserUtils.INSTANCE.isPremium(meSnapshot)));
            }
            return false;
        }
        final List<Attachment<?>> attachments = attachmentsRequest != null ? attachmentsRequest.getAttachments() : null;
        final long jLongValue = channelId != null ? channelId.longValue() : this.storeChannelsSelected.getId();
        if (Build.VERSION.SDK_INT >= 25) {
            List<ShortcutInfoCompat> dynamicShortcuts = ShortcutManagerCompat.getDynamicShortcuts(this.context);
            C12238m.checkNotNullExpressionValue(dynamicShortcuts, "ShortcutManagerCompat.getDynamicShortcuts(context)");
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(dynamicShortcuts, 10));
            for (ShortcutInfoCompat shortcutInfoCompat : dynamicShortcuts) {
                C12238m.checkNotNullExpressionValue(shortcutInfoCompat, "it");
                arrayList.add(shortcutInfoCompat.getId());
            }
            if (C12163u.toSet(arrayList).contains(String.valueOf(jLongValue)) && (shortcutManager = (ShortcutManager) this.context.getSystemService(ShortcutManager.class)) != null) {
                shortcutManager.reportShortcutUsed(String.valueOf(jLongValue));
            }
        }
        final StorePendingReplies.PendingReply pendingReply = consumePendingReply ? this.storePendingReplies.getPendingReply(jLongValue) : null;
        final MessageAllowedMentions messageAllowedMentions = (pendingReply == null || pendingReply.getShouldMention()) ? null : new MessageAllowedMentions(C12141k.toList(MessageAllowedMentionsTypes.values()), null, null, Boolean.FALSE, 6);
        Observable observableM11100Z = Observable.m11076j(this.storeSlowMode.observeCooldownSecs(channelId, StoreSlowMode.Type.MessageSend.INSTANCE).m11100Z(1).m11099Y(new InterfaceC12589b<Integer, Observable<? extends MessageResult>>() { // from class: com.discord.widgets.chat.MessageManager$sendMessage$messageResultObservable$1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends MessageResult> call(Integer num) {
                if (num.intValue() > 0) {
                    return new C12721k(new MessageResult.Slowmode(((long) num.intValue()) * 1000));
                }
                if (pendingReply != null) {
                    this.this$0.storePendingReplies.onDeletePendingReply(jLongValue);
                }
                StoreMessages storeMessages = this.this$0.storeMessages;
                long j = jLongValue;
                MeUser meUser = meSnapshot;
                String str = content;
                List list = mentions;
                List list2 = attachments;
                List list3 = stickers;
                StorePendingReplies.PendingReply pendingReply2 = pendingReply;
                return StoreMessages.sendMessage$default(storeMessages, j, meUser, str, list, list2, list3, pendingReply2 != null ? pendingReply2.getMessageReference() : null, messageAllowedMentions, null, null, null, null, null, null, null, 32512, null);
            }
        }), this.storeGuilds.observeFromChannelId(jLongValue), new Func2<MessageResult, Guild, MessageSendResult>() { // from class: com.discord.widgets.chat.MessageManager.sendMessage.1
            @Override // p658rx.functions.Func2
            public final MessageSendResult call(MessageResult messageResult, Guild guild) {
                C12238m.checkNotNullExpressionValue(messageResult, "messageResult");
                return new MessageSendResult(messageResult, guild);
            }
        }).m11100Z(1);
        C12238m.checkNotNullExpressionValue(observableM11100Z, "Observable.combineLatest…d)\n    }\n        .take(1)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8518ui(ObservableExtensionsKt.restSubscribeOn$default(observableM11100Z, false, 1, null)), (Class<?>) MessageManager.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C76732(messageSendResultHandler));
        return true;
    }

    public /* synthetic */ MessageManager(Context context, StoreMessages storeMessages, StoreApplicationInteractions storeApplicationInteractions, StoreUser storeUser, StoreChannelsSelected storeChannelsSelected, StoreSlowMode storeSlowMode, StoreGuilds storeGuilds, StorePendingReplies storePendingReplies, StoreMessageReplies storeMessageReplies, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? StoreStream.INSTANCE.getMessages() : storeMessages, (i & 4) != 0 ? StoreStream.INSTANCE.getInteractions() : storeApplicationInteractions, (i & 8) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 16) != 0 ? StoreStream.INSTANCE.getChannelsSelected() : storeChannelsSelected, (i & 32) != 0 ? StoreStream.INSTANCE.getSlowMode() : storeSlowMode, (i & 64) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 128) != 0 ? StoreStream.INSTANCE.getPendingReplies() : storePendingReplies, (i & 256) != 0 ? StoreStream.INSTANCE.getRepliedMessages() : storeMessageReplies);
    }
}
