package com.discord.utilities.messagesend;

import androidx.core.app.NotificationCompat;
import com.discord.api.message.Message;
import com.discord.restapi.PayloadJSON;
import com.discord.restapi.RestAPIParams$Message;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.SendUtils$FileUpload;
import com.discord.utilities.rest.SendUtils$SendPayload$ReadyToSend;
import d0.t.o;
import j0.k.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import okhttp3.MultipartBody$Part;
import rx.Observable;

/* JADX INFO: compiled from: MessageQueue.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageQueue$doSend$2<T, R> implements b<SendUtils$SendPayload$ReadyToSend, Observable<? extends Message>> {
    public final /* synthetic */ com.discord.models.message.Message $message;

    public MessageQueue$doSend$2(com.discord.models.message.Message message) {
        this.$message = message;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Message> call(SendUtils$SendPayload$ReadyToSend sendUtils$SendPayload$ReadyToSend) {
        return call2(sendUtils$SendPayload$ReadyToSend);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Message> call2(SendUtils$SendPayload$ReadyToSend sendUtils$SendPayload$ReadyToSend) {
        List<SendUtils$FileUpload> uploads = sendUtils$SendPayload$ReadyToSend.getUploads();
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(uploads, 10));
        Iterator<T> it = uploads.iterator();
        while (it.hasNext()) {
            arrayList.add(((SendUtils$FileUpload) it.next()).getPart());
        }
        if (!(!arrayList.isEmpty())) {
            return RestAPI.Companion.getApi().sendMessage(this.$message.getChannelId(), sendUtils$SendPayload$ReadyToSend.getMessage());
        }
        RestAPI api = RestAPI.Companion.getApi();
        long channelId = this.$message.getChannelId();
        PayloadJSON<RestAPIParams$Message> payloadJSON = new PayloadJSON<>(sendUtils$SendPayload$ReadyToSend.getMessage());
        Object[] array = arrayList.toArray(new MultipartBody$Part[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return api.sendMessage(channelId, payloadJSON, (MultipartBody$Part[]) array);
    }
}
