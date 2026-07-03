package com.discord.utilities.messagesend;

import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.api.activity.Activity;
import com.discord.api.message.allowedmentions.MessageAllowedMentions;
import com.discord.models.commands.ApplicationCommandLocalSendData;
import com.discord.models.message.Message;
import com.discord.utilities.messagesend.MessageResult;
import com.discord.utilities.rest.SendUtils;
import com.lytefast.flexinput.model.Attachment;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: MessageQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class MessageRequest {
    private final long attemptTimestamp;
    private final Function2<MessageResult, Boolean, Unit> onCompleted;
    private final String requestId;

    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class Edit extends MessageRequest {
        private final MessageAllowedMentions allowedMentions;
        private final long channelId;
        private final String content;
        private final long messageId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Edit(long j, String str, long j2, MessageAllowedMentions messageAllowedMentions, long j3, Function2<? super MessageResult, ? super Boolean, Unit> function2) {
            super(String.valueOf(j2), function2, j3, null);
            C12238m.checkNotNullParameter(str, "content");
            C12238m.checkNotNullParameter(function2, "onCompleted");
            this.channelId = j;
            this.content = str;
            this.messageId = j2;
            this.allowedMentions = messageAllowedMentions;
        }

        public final MessageAllowedMentions getAllowedMentions() {
            return this.allowedMentions;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final String getContent() {
            return this.content;
        }

        public final long getMessageId() {
            return this.messageId;
        }
    }

    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class Send extends MessageRequest {
        private final Activity activity;
        private final List<Attachment<?>> attachments;
        private final Message message;
        private final Function1<SendUtils.SendPayload.Preprocessing, Unit> onPreprocessing;
        private final Function1<List<SendUtils.FileUpload>, Unit> onProgress;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Multi-variable type inference failed */
        public Send(Message message, Activity activity, List<? extends Attachment<?>> list, Function2<? super MessageResult, ? super Boolean, Unit> function2, Function1<? super SendUtils.SendPayload.Preprocessing, Unit> function1, Function1<? super List<SendUtils.FileUpload>, Unit> function3, long j) {
            C12238m.checkNotNullParameter(message, "message");
            C12238m.checkNotNullParameter(function2, "onCompleted");
            C12238m.checkNotNullParameter(function1, "onPreprocessing");
            C12238m.checkNotNullParameter(function3, "onProgress");
            String nonce = message.getNonce();
            C12238m.checkNotNull(nonce);
            super(nonce, function2, j, null);
            this.message = message;
            this.activity = activity;
            this.attachments = list;
            this.onPreprocessing = function1;
            this.onProgress = function3;
        }

        public final Activity getActivity() {
            return this.activity;
        }

        public final List<Attachment<?>> getAttachments() {
            return this.attachments;
        }

        public final Message getMessage() {
            return this.message;
        }

        public final Function1<SendUtils.SendPayload.Preprocessing, Unit> getOnPreprocessing() {
            return this.onPreprocessing;
        }

        public final Function1<List<SendUtils.FileUpload>, Unit> getOnProgress() {
            return this.onProgress;
        }

        public final MessageResult.ValidationError validateMessage() {
            if (this.message.getActivity() != null) {
                List<Attachment<?>> list = this.attachments;
                if (!(list == null || list.isEmpty())) {
                    return new MessageResult.ValidationError("Cannot send attachments with activity action");
                }
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: MessageQueue.kt */
    public static final class SendApplicationCommand extends MessageRequest {
        private final ApplicationCommandLocalSendData applicationCommandSendData;
        private final List<Attachment<?>> attachments;
        private final com.discord.api.message.Message message;
        private final Function1<SendUtils.SendPayload.Preprocessing, Unit> onPreprocessing;
        private final Function1<List<SendUtils.FileUpload>, Unit> onProgress;

        /* JADX WARN: Illegal instructions before constructor call */
        /* JADX WARN: Multi-variable type inference failed */
        public SendApplicationCommand(com.discord.api.message.Message message, ApplicationCommandLocalSendData applicationCommandLocalSendData, List<? extends Attachment<?>> list, Function1<? super SendUtils.SendPayload.Preprocessing, Unit> function1, Function1<? super List<SendUtils.FileUpload>, Unit> function2, Function2<? super MessageResult, ? super Boolean, Unit> function3, long j) {
            C12238m.checkNotNullParameter(message, "message");
            C12238m.checkNotNullParameter(applicationCommandLocalSendData, "applicationCommandSendData");
            C12238m.checkNotNullParameter(function1, "onPreprocessing");
            C12238m.checkNotNullParameter(function2, "onProgress");
            C12238m.checkNotNullParameter(function3, "onCompleted");
            String nonce = message.getNonce();
            super(nonce == null ? String.valueOf(applicationCommandLocalSendData.getNonce()) : nonce, function3, j, null);
            this.message = message;
            this.applicationCommandSendData = applicationCommandLocalSendData;
            this.attachments = list;
            this.onPreprocessing = function1;
            this.onProgress = function2;
        }

        public final ApplicationCommandLocalSendData getApplicationCommandSendData() {
            return this.applicationCommandSendData;
        }

        public final List<Attachment<?>> getAttachments() {
            return this.attachments;
        }

        public final com.discord.api.message.Message getMessage() {
            return this.message;
        }

        public final Function1<SendUtils.SendPayload.Preprocessing, Unit> getOnPreprocessing() {
            return this.onPreprocessing;
        }

        public final Function1<List<SendUtils.FileUpload>, Unit> getOnProgress() {
            return this.onProgress;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private MessageRequest(String str, Function2<? super MessageResult, ? super Boolean, Unit> function2, long j) {
        this.requestId = str;
        this.onCompleted = function2;
        this.attemptTimestamp = j;
    }

    public final long getAttemptTimestamp() {
        return this.attemptTimestamp;
    }

    public final Function2<MessageResult, Boolean, Unit> getOnCompleted() {
        return this.onCompleted;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public /* synthetic */ MessageRequest(String str, Function2 function2, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, function2, j);
    }
}
