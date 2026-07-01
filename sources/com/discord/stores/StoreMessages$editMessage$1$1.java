package com.discord.stores;

import com.discord.api.application.Application;
import com.discord.api.message.activity.MessageActivity;
import com.discord.api.message.attachment.MessageAttachment;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.message.Message;
import com.discord.utilities.message.LocalMessageCreatorsKt;
import com.discord.utilities.messagesend.MessageResult;
import com.discord.utilities.messagesend.MessageResult$AutoModBlock;
import com.discord.utilities.time.Clock;
import d0.t.n;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessages$editMessage$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ MessageResult $result;
    public final /* synthetic */ StoreMessages$editMessage$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreMessages$editMessage$1$1(StoreMessages$editMessage$1 storeMessages$editMessage$1, MessageResult messageResult) {
        super(0);
        this.this$0 = storeMessages$editMessage$1;
        this.$result = messageResult;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Message messageCreateLocalMessage$default;
        User author;
        if (this.$result instanceof MessageResult$AutoModBlock) {
            StoreMessages$editMessage$1 storeMessages$editMessage$1 = this.this$0;
            Message message = storeMessages$editMessage$1.this$0.getMessage(storeMessages$editMessage$1.$channelId, storeMessages$editMessage$1.$messageId);
            if (message == null || (author = message.getAuthor()) == null) {
                messageCreateLocalMessage$default = null;
            } else {
                StoreMessages$editMessage$1 storeMessages$editMessage$2 = this.this$0;
                String str = storeMessages$editMessage$2.$content;
                long j = storeMessages$editMessage$2.$channelId;
                List<User> mentions = message.getMentions();
                List<MessageAttachment> attachments = message.getAttachments();
                boolean z2 = true ^ (attachments == null || attachments.isEmpty());
                Application application = message.getApplication();
                MessageActivity activity = message.getActivity();
                Clock clockAccess$getClock$p = StoreMessages.access$getClock$p(this.this$0.this$0);
                List listEmptyList = n.emptyList();
                Long lValueOf = Long.valueOf(this.this$0.$attemptTimestamp);
                Long initialAttemptTimestamp = message.getInitialAttemptTimestamp();
                Long lValueOf2 = Long.valueOf(initialAttemptTimestamp != null ? initialAttemptTimestamp.longValue() : this.this$0.$attemptTimestamp);
                Integer numRetries = message.getNumRetries();
                messageCreateLocalMessage$default = LocalMessageCreatorsKt.createLocalMessage$default(str, j, author, mentions, false, z2, application, activity, clockAccess$getClock$p, listEmptyList, lValueOf, lValueOf2, Integer.valueOf(numRetries != null ? numRetries.intValue() : 0), message.getStickers(), message.getMessageReference(), this.this$0.$allowedMentions, null, 65536, null);
            }
            if (messageCreateLocalMessage$default != null) {
                StoreMessages storeMessages = this.this$0.this$0;
                StoreMessages.access$handleSendMessageFailureAutoMod(storeMessages, messageCreateLocalMessage$default, new UtcDateTime(StoreMessages.access$getClock$p(storeMessages).currentTimeMillis()));
            }
        }
    }
}
