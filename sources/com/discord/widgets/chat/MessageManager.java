package com.discord.widgets.chat;

import android.content.Context;
import android.content.pm.ShortcutManager;
import android.os.Build$VERSION;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutManagerCompat;
import com.discord.api.message.MessageReference;
import com.discord.api.message.allowedmentions.MessageAllowedMentions;
import com.discord.api.message.allowedmentions.MessageAllowedMentionsTypes;
import com.discord.api.sticker.BaseSticker;
import com.discord.api.user.User;
import com.discord.models.message.Message;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreApplicationInteractions;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreMessageReplies;
import com.discord.stores.StoreMessageReplies$MessageState;
import com.discord.stores.StoreMessageReplies$MessageState$Loaded;
import com.discord.stores.StoreMessages;
import com.discord.stores.StorePendingReplies;
import com.discord.stores.StorePendingReplies$PendingReply;
import com.discord.stores.StoreSlowMode;
import com.discord.stores.StoreSlowMode$Type$MessageSend;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.SendUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.chat.input.models.ApplicationCommandData;
import com.lytefast.flexinput.model.Attachment;
import d0.t.k;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: MessageManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageManager {
    private final Context context;
    private final Function1<MessageManager$MessageSendResult, Unit> defaultMessageResultHandler;
    private final StoreApplicationInteractions storeApplicationInteractions;
    private final StoreChannelsSelected storeChannelsSelected;
    private final StoreGuilds storeGuilds;
    private final StoreMessageReplies storeMessageReplies;
    private final StoreMessages storeMessages;
    private final StorePendingReplies storePendingReplies;
    private final StoreSlowMode storeSlowMode;
    private final StoreUser storeUser;

    public MessageManager(Context context, StoreMessages storeMessages, StoreApplicationInteractions storeApplicationInteractions, StoreUser storeUser, StoreChannelsSelected storeChannelsSelected, StoreSlowMode storeSlowMode, StoreGuilds storeGuilds, StorePendingReplies storePendingReplies, StoreMessageReplies storeMessageReplies) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(storeMessages, "storeMessages");
        m.checkNotNullParameter(storeApplicationInteractions, "storeApplicationInteractions");
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        m.checkNotNullParameter(storeSlowMode, "storeSlowMode");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storePendingReplies, "storePendingReplies");
        m.checkNotNullParameter(storeMessageReplies, "storeMessageReplies");
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

    public static final /* synthetic */ Context access$getContext$p(MessageManager messageManager) {
        return messageManager.context;
    }

    public static final /* synthetic */ StoreMessages access$getStoreMessages$p(MessageManager messageManager) {
        return messageManager.storeMessages;
    }

    public static final /* synthetic */ StorePendingReplies access$getStorePendingReplies$p(MessageManager messageManager) {
        return messageManager.storePendingReplies;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean editMessage$default(MessageManager messageManager, long j, long j2, String str, Function2 function2, Integer num, int i, Object obj) {
        return messageManager.editMessage(j, j2, str, (i & 8) != 0 ? null : function2, (i & 16) != 0 ? null : num);
    }

    private final MessageAllowedMentions getAllowedMentionsForMessageEdit(long channelId, long messageId) {
        Integer type;
        MessageReference messageReference;
        Long messageId2;
        Message message = this.storeMessages.getMessage(channelId, messageId);
        if (message != null && (type = message.getType()) != null && type.intValue() == 19 && (messageReference = message.getMessageReference()) != null && (messageId2 = messageReference.getMessageId()) != null) {
            StoreMessageReplies$MessageState storeMessageReplies$MessageState = this.storeMessageReplies.getAllMessageReferences().get(Long.valueOf(messageId2.longValue()));
            if (storeMessageReplies$MessageState == null || !(storeMessageReplies$MessageState instanceof StoreMessageReplies$MessageState$Loaded)) {
                return null;
            }
            List<User> mentions = message.getMentions();
            if (mentions != null) {
                boolean z2 = false;
                if (!mentions.isEmpty()) {
                    Iterator<T> it = mentions.iterator();
                    while (it.hasNext()) {
                        long id2 = ((User) it.next()).getId();
                        User author = ((StoreMessageReplies$MessageState$Loaded) storeMessageReplies$MessageState).getMessage().getAuthor();
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
            return new MessageAllowedMentions(k.toList(MessageAllowedMentionsTypes.values()), null, null, Boolean.FALSE, 6);
        }
        return null;
    }

    public static /* synthetic */ boolean isValidForumPostFirstMessage$default(MessageManager messageManager, String str, MessageManager$AttachmentsRequest messageManager$AttachmentsRequest, Function2 function2, Function2 function3, int i, Object obj) {
        if ((i & 2) != 0) {
            messageManager$AttachmentsRequest = null;
        }
        return messageManager.isValidForumPostFirstMessage(str, messageManager$AttachmentsRequest, function2, function3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean sendCommand$default(MessageManager messageManager, long j, Long l, String str, ApplicationCommandData applicationCommandData, MessageManager$AttachmentsRequest messageManager$AttachmentsRequest, Function0 function0, Function1 function1, Function2 function2, int i, Object obj) {
        return messageManager.sendCommand(j, l, str, applicationCommandData, (i & 16) != 0 ? null : messageManager$AttachmentsRequest, function0, function1, (i & 128) != 0 ? null : function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean sendMessage$default(MessageManager messageManager, String str, List list, MessageManager$AttachmentsRequest messageManager$AttachmentsRequest, Long l, List list2, boolean z2, Function2 function2, Function2 function3, Function1 function1, int i, Object obj) {
        return messageManager.sendMessage((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : messageManager$AttachmentsRequest, (i & 8) != 0 ? null : l, (i & 16) != 0 ? n.emptyList() : list2, (i & 32) != 0 ? true : z2, (i & 64) != 0 ? null : function2, (i & 128) == 0 ? function3 : null, (i & 256) != 0 ? messageManager.defaultMessageResultHandler : function1);
    }

    private final MessageManager$AttachmentValidationResult validateAttachments(MessageManager$AttachmentsRequest attachmentsRequest) {
        if (attachmentsRequest == null) {
            return MessageManager$AttachmentValidationResult$EmptyAttachments.INSTANCE;
        }
        List<Attachment<?>> attachments = attachmentsRequest.getAttachments();
        if (attachments == null || attachments.isEmpty()) {
            return MessageManager$AttachmentValidationResult$EmptyAttachments.INSTANCE;
        }
        return attachmentsRequest.getCurrentFileSizeMB() >= ((float) attachmentsRequest.getMaxFileSizeMB()) ? new MessageManager$AttachmentValidationResult$FilesTooLarge(attachmentsRequest) : MessageManager$AttachmentValidationResult$Success.INSTANCE;
    }

    private final MessageManager$ContentValidationResult validateMessageContent(String content, List<? extends BaseSticker> stickers, MeUser meUser, boolean isEditing, Integer previousMessageLength) {
        boolean z2 = true;
        int i = (UserUtils.INSTANCE.isPremiumTier2(meUser) || (isEditing && previousMessageLength != null && previousMessageLength.intValue() > 2000)) ? SendUtils.MAX_MESSAGE_CHARACTER_COUNT_PREMIUM : 2000;
        if (content.length() == 0) {
            if (stickers != null && !stickers.isEmpty()) {
                z2 = false;
            }
            if (z2) {
                return MessageManager$ContentValidationResult$EmptyContent.INSTANCE;
            }
        }
        return content.length() > i ? new MessageManager$ContentValidationResult$MessageTooLong(i) : MessageManager$ContentValidationResult$Success.INSTANCE;
    }

    public static /* synthetic */ MessageManager$ContentValidationResult validateMessageContent$default(MessageManager messageManager, String str, List list, MeUser meUser, boolean z2, Integer num, int i, Object obj) {
        if ((i & 16) != 0) {
            num = null;
        }
        return messageManager.validateMessageContent(str, list, meUser, z2, num);
    }

    public final boolean editMessage(long messageId, long channelId, String content, Function2<? super Integer, ? super Integer, Unit> onMessageTooLong, Integer previousMessageLength) {
        m.checkNotNullParameter(content, "content");
        MessageManager$ContentValidationResult messageManager$ContentValidationResultValidateMessageContent = validateMessageContent(content, n.emptyList(), this.storeUser.getMeSnapshot(), true, previousMessageLength);
        if (messageManager$ContentValidationResultValidateMessageContent instanceof MessageManager$ContentValidationResult$MessageTooLong) {
            if (onMessageTooLong != null) {
                onMessageTooLong.invoke(Integer.valueOf(content.length()), Integer.valueOf(((MessageManager$ContentValidationResult$MessageTooLong) messageManager$ContentValidationResultValidateMessageContent).getMaxMessageLength()));
            }
            return false;
        }
        if (m.areEqual(messageManager$ContentValidationResultValidateMessageContent, MessageManager$ContentValidationResult$EmptyContent.INSTANCE)) {
            return false;
        }
        m.areEqual(messageManager$ContentValidationResultValidateMessageContent, MessageManager$ContentValidationResult$Success.INSTANCE);
        this.storeMessages.editMessage(messageId, channelId, content, getAllowedMentionsForMessageEdit(channelId, messageId));
        return true;
    }

    public final boolean isValidForumPostFirstMessage(String content, MessageManager$AttachmentsRequest attachmentsRequest, Function2<? super Integer, ? super Integer, Unit> onMessageTooLong, Function2<? super Integer, ? super Boolean, Unit> onFilesTooLarge) {
        m.checkNotNullParameter(content, "content");
        MeUser meSnapshot = this.storeUser.getMeSnapshot();
        MessageManager$ContentValidationResult messageManager$ContentValidationResultValidateMessageContent$default = validateMessageContent$default(this, content, n.emptyList(), meSnapshot, false, null, 16, null);
        if (messageManager$ContentValidationResultValidateMessageContent$default instanceof MessageManager$ContentValidationResult$MessageTooLong) {
            if (onMessageTooLong != null) {
                onMessageTooLong.invoke(Integer.valueOf(content.length()), Integer.valueOf(((MessageManager$ContentValidationResult$MessageTooLong) messageManager$ContentValidationResultValidateMessageContent$default).getMaxMessageLength()));
            }
            return false;
        }
        MessageManager$AttachmentValidationResult messageManager$AttachmentValidationResultValidateAttachments = validateAttachments(attachmentsRequest);
        if (!(messageManager$AttachmentValidationResultValidateAttachments instanceof MessageManager$AttachmentValidationResult$FilesTooLarge)) {
            return true;
        }
        if (onFilesTooLarge != null) {
            onFilesTooLarge.invoke(Integer.valueOf(((MessageManager$AttachmentValidationResult$FilesTooLarge) messageManager$AttachmentValidationResultValidateAttachments).getAttachmentsRequest().getMaxFileSizeMB()), Boolean.valueOf(UserUtils.INSTANCE.isPremium(meSnapshot)));
        }
        return false;
    }

    public final boolean sendCommand(long channelId, Long guildId, String version, ApplicationCommandData data, MessageManager$AttachmentsRequest attachmentRequest, Function0<Unit> onSuccess, Function1<? super Error, Unit> onFail, Function2<? super Integer, ? super Boolean, Unit> onFilesTooLarge) {
        m.checkNotNullParameter(data, "data");
        m.checkNotNullParameter(onSuccess, "onSuccess");
        m.checkNotNullParameter(onFail, "onFail");
        MeUser meSnapshot = this.storeUser.getMeSnapshot();
        MessageManager$AttachmentValidationResult messageManager$AttachmentValidationResultValidateAttachments = validateAttachments(attachmentRequest);
        if (!(messageManager$AttachmentValidationResultValidateAttachments instanceof MessageManager$AttachmentValidationResult$FilesTooLarge)) {
            this.storeApplicationInteractions.sendApplicationCommand(channelId, guildId, version, data, attachmentRequest != null ? attachmentRequest.getAttachments() : null, MessageManager$sendCommand$1.INSTANCE, MessageManager$sendCommand$2.INSTANCE);
            return true;
        }
        MessageManager$AttachmentsRequest attachmentsRequest = ((MessageManager$AttachmentValidationResult$FilesTooLarge) messageManager$AttachmentValidationResultValidateAttachments).getAttachmentsRequest();
        if (onFilesTooLarge == null) {
            return false;
        }
        onFilesTooLarge.invoke(Integer.valueOf(attachmentsRequest.getMaxFileSizeMB()), Boolean.valueOf(UserUtils.INSTANCE.isPremium(meSnapshot)));
        return false;
    }

    public final boolean sendMessage(String content, List<? extends com.discord.models.user.User> mentions, MessageManager$AttachmentsRequest attachmentsRequest, Long channelId, List<? extends BaseSticker> stickers, boolean consumePendingReply, Function2<? super Integer, ? super Integer, Unit> onMessageTooLong, Function2<? super Integer, ? super Boolean, Unit> onFilesTooLarge, Function1<? super MessageManager$MessageSendResult, Unit> messageSendResultHandler) {
        ShortcutManager shortcutManager;
        m.checkNotNullParameter(content, "content");
        m.checkNotNullParameter(stickers, "stickers");
        m.checkNotNullParameter(messageSendResultHandler, "messageSendResultHandler");
        MeUser meSnapshot = this.storeUser.getMeSnapshot();
        MessageManager$ContentValidationResult messageManager$ContentValidationResultValidateMessageContent$default = validateMessageContent$default(this, content, stickers, meSnapshot, false, null, 16, null);
        if (messageManager$ContentValidationResultValidateMessageContent$default instanceof MessageManager$ContentValidationResult$MessageTooLong) {
            if (onMessageTooLong != null) {
                onMessageTooLong.invoke(Integer.valueOf(content.length()), Integer.valueOf(((MessageManager$ContentValidationResult$MessageTooLong) messageManager$ContentValidationResultValidateMessageContent$default).getMaxMessageLength()));
            }
            return false;
        }
        MessageManager$AttachmentValidationResult messageManager$AttachmentValidationResultValidateAttachments = validateAttachments(attachmentsRequest);
        if (messageManager$AttachmentValidationResultValidateAttachments instanceof MessageManager$AttachmentValidationResult$FilesTooLarge) {
            MessageManager$AttachmentsRequest attachmentsRequest2 = ((MessageManager$AttachmentValidationResult$FilesTooLarge) messageManager$AttachmentValidationResultValidateAttachments).getAttachmentsRequest();
            if (onFilesTooLarge != null) {
                onFilesTooLarge.invoke(Integer.valueOf(attachmentsRequest2.getMaxFileSizeMB()), Boolean.valueOf(UserUtils.INSTANCE.isPremium(meSnapshot)));
            }
            return false;
        }
        List<Attachment<?>> attachments = attachmentsRequest != null ? attachmentsRequest.getAttachments() : null;
        long jLongValue = channelId != null ? channelId.longValue() : this.storeChannelsSelected.getId();
        if (Build$VERSION.SDK_INT >= 25) {
            List<ShortcutInfoCompat> dynamicShortcuts = ShortcutManagerCompat.getDynamicShortcuts(this.context);
            m.checkNotNullExpressionValue(dynamicShortcuts, "ShortcutManagerCompat.getDynamicShortcuts(context)");
            ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(dynamicShortcuts, 10));
            for (ShortcutInfoCompat shortcutInfoCompat : dynamicShortcuts) {
                m.checkNotNullExpressionValue(shortcutInfoCompat, "it");
                arrayList.add(shortcutInfoCompat.getId());
            }
            if (u.toSet(arrayList).contains(String.valueOf(jLongValue)) && (shortcutManager = (ShortcutManager) this.context.getSystemService(ShortcutManager.class)) != null) {
                shortcutManager.reportShortcutUsed(String.valueOf(jLongValue));
            }
        }
        StorePendingReplies$PendingReply pendingReply = consumePendingReply ? this.storePendingReplies.getPendingReply(jLongValue) : null;
        Observable observableZ = Observable.j(this.storeSlowMode.observeCooldownSecs(channelId, StoreSlowMode$Type$MessageSend.INSTANCE).Z(1).Y(new MessageManager$sendMessage$messageResultObservable$1(this, pendingReply, jLongValue, meSnapshot, content, mentions, attachments, stickers, (pendingReply == null || pendingReply.getShouldMention()) ? null : new MessageAllowedMentions(k.toList(MessageAllowedMentionsTypes.values()), null, null, Boolean.FALSE, 6))), this.storeGuilds.observeFromChannelId(jLongValue), MessageManager$sendMessage$1.INSTANCE).Z(1);
        m.checkNotNullExpressionValue(observableZ, "Observable.combineLatest…d)\n    }\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn$default(observableZ, false, 1, null)), MessageManager.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new MessageManager$sendMessage$2(messageSendResultHandler), 62, (Object) null);
        return true;
    }

    public /* synthetic */ MessageManager(Context context, StoreMessages storeMessages, StoreApplicationInteractions storeApplicationInteractions, StoreUser storeUser, StoreChannelsSelected storeChannelsSelected, StoreSlowMode storeSlowMode, StoreGuilds storeGuilds, StorePendingReplies storePendingReplies, StoreMessageReplies storeMessageReplies, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? StoreStream.Companion.getMessages() : storeMessages, (i & 4) != 0 ? StoreStream.Companion.getInteractions() : storeApplicationInteractions, (i & 8) != 0 ? StoreStream.Companion.getUsers() : storeUser, (i & 16) != 0 ? StoreStream.Companion.getChannelsSelected() : storeChannelsSelected, (i & 32) != 0 ? StoreStream.Companion.getSlowMode() : storeSlowMode, (i & 64) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds, (i & 128) != 0 ? StoreStream.Companion.getPendingReplies() : storePendingReplies, (i & 256) != 0 ? StoreStream.Companion.getRepliedMessages() : storeMessageReplies);
    }
}
