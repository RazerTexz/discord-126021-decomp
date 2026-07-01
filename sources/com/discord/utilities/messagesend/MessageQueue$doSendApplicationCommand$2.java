package com.discord.utilities.messagesend;

import androidx.core.app.NotificationCompat;
import com.discord.restapi.PayloadJSON;
import com.discord.restapi.RestAPIParams$ApplicationCommand;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.SendUtils$FileUpload;
import com.discord.utilities.rest.SendUtils$SendPayload$ReadyToSendCommand;
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
public final class MessageQueue$doSendApplicationCommand$2<T, R> implements b<SendUtils$SendPayload$ReadyToSendCommand, Observable<? extends Void>> {
    public static final MessageQueue$doSendApplicationCommand$2 INSTANCE = new MessageQueue$doSendApplicationCommand$2();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends Void> call(SendUtils$SendPayload$ReadyToSendCommand sendUtils$SendPayload$ReadyToSendCommand) {
        return call2(sendUtils$SendPayload$ReadyToSendCommand);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Void> call2(SendUtils$SendPayload$ReadyToSendCommand sendUtils$SendPayload$ReadyToSendCommand) {
        List<SendUtils$FileUpload> uploads = sendUtils$SendPayload$ReadyToSendCommand.getUploads();
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(uploads, 10));
        Iterator<T> it = uploads.iterator();
        while (it.hasNext()) {
            arrayList.add(((SendUtils$FileUpload) it.next()).getPart());
        }
        if (!(!arrayList.isEmpty())) {
            return RestAPI.Companion.getApi().sendApplicationCommand(sendUtils$SendPayload$ReadyToSendCommand.getCommand().toRestApiParam());
        }
        PayloadJSON<RestAPIParams$ApplicationCommand> payloadJSON = new PayloadJSON<>(sendUtils$SendPayload$ReadyToSendCommand.getCommand().toRestApiParam());
        RestAPI api = RestAPI.Companion.getApi();
        Object[] array = arrayList.toArray(new MultipartBody$Part[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return api.sendApplicationCommand(payloadJSON, (MultipartBody$Part[]) array);
    }
}
