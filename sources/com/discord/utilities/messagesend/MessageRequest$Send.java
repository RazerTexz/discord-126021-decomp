package com.discord.utilities.messagesend;

import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.api.activity.Activity;
import com.discord.models.message.Message;
import com.discord.utilities.rest.SendUtils$FileUpload;
import com.discord.utilities.rest.SendUtils$SendPayload$Preprocessing;
import com.lytefast.flexinput.model.Attachment;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: MessageQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageRequest$Send extends MessageRequest {
    private final Activity activity;
    private final List<Attachment<?>> attachments;
    private final Message message;
    private final Function1<SendUtils$SendPayload$Preprocessing, Unit> onPreprocessing;
    private final Function1<List<SendUtils$FileUpload>, Unit> onProgress;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public MessageRequest$Send(Message message, Activity activity, List<? extends Attachment<?>> list, Function2<? super MessageResult, ? super Boolean, Unit> function2, Function1<? super SendUtils$SendPayload$Preprocessing, Unit> function1, Function1<? super List<SendUtils$FileUpload>, Unit> function3, long j) {
        m.checkNotNullParameter(message, "message");
        m.checkNotNullParameter(function2, "onCompleted");
        m.checkNotNullParameter(function1, "onPreprocessing");
        m.checkNotNullParameter(function3, "onProgress");
        String nonce = message.getNonce();
        m.checkNotNull(nonce);
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

    public final Function1<SendUtils$SendPayload$Preprocessing, Unit> getOnPreprocessing() {
        return this.onPreprocessing;
    }

    public final Function1<List<SendUtils$FileUpload>, Unit> getOnProgress() {
        return this.onProgress;
    }

    public final MessageResult$ValidationError validateMessage() {
        if (this.message.getActivity() != null) {
            List<Attachment<?>> list = this.attachments;
            if (!(list == null || list.isEmpty())) {
                return new MessageResult$ValidationError("Cannot send attachments with activity action");
            }
        }
        return null;
    }
}
