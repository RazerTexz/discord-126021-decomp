package com.discord.widgets.chat.list.adapter;

import com.discord.app.AppLog;
import com.discord.stores.StoreMessageUploads;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rest.SendUtils$FileUpload;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.o;
import d0.z.d.m;
import j0.l.e.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Ref$LongRef;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChatListAdapterItemUploadProgress.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemUploadProgress$ModelProvider {
    public static final WidgetChatListAdapterItemUploadProgress$ModelProvider INSTANCE = new WidgetChatListAdapterItemUploadProgress$ModelProvider();
    private static final int MAX_DETAILED_UPLOADS = 3;

    private WidgetChatListAdapterItemUploadProgress$ModelProvider() {
    }

    public static final /* synthetic */ Observable access$getFewUploadsObservable(WidgetChatListAdapterItemUploadProgress$ModelProvider widgetChatListAdapterItemUploadProgress$ModelProvider, List list, long j) {
        return widgetChatListAdapterItemUploadProgress$ModelProvider.getFewUploadsObservable(list, j);
    }

    public static final /* synthetic */ Observable access$getManyUploadsObservable(WidgetChatListAdapterItemUploadProgress$ModelProvider widgetChatListAdapterItemUploadProgress$ModelProvider, List list, long j) {
        return widgetChatListAdapterItemUploadProgress$ModelProvider.getManyUploadsObservable(list, j);
    }

    public static final /* synthetic */ int access$getPercentage(WidgetChatListAdapterItemUploadProgress$ModelProvider widgetChatListAdapterItemUploadProgress$ModelProvider, long j, long j2) {
        return widgetChatListAdapterItemUploadProgress$ModelProvider.getPercentage(j, j2);
    }

    public static final /* synthetic */ Observable access$getSingleUploadObservable(WidgetChatListAdapterItemUploadProgress$ModelProvider widgetChatListAdapterItemUploadProgress$ModelProvider, SendUtils$FileUpload sendUtils$FileUpload, long j) {
        return widgetChatListAdapterItemUploadProgress$ModelProvider.getSingleUploadObservable(sendUtils$FileUpload, j);
    }

    private final Observable<WidgetChatListAdapterItemUploadProgress$Model$Few> getFewUploadsObservable(List<SendUtils$FileUpload> uploads, long throttleIntervalMs) {
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(uploads, 10));
        Iterator<T> it = uploads.iterator();
        while (it.hasNext()) {
            arrayList.add(INSTANCE.getSingleUploadObservable((SendUtils$FileUpload) it.next(), throttleIntervalMs));
        }
        Observable<WidgetChatListAdapterItemUploadProgress$Model$Few> observableB = Observable.b(arrayList, WidgetChatListAdapterItemUploadProgress$ModelProvider$getFewUploadsObservable$2.INSTANCE);
        m.checkNotNullExpressionValue(observableB, "Observable\n          .co…{ it as Model.Single }) }");
        return observableB;
    }

    private final Observable<WidgetChatListAdapterItemUploadProgress$Model$Many> getManyUploadsObservable(List<SendUtils$FileUpload> uploads, long throttleIntervalMs) {
        Ref$LongRef ref$LongRef = new Ref$LongRef();
        ref$LongRef.element = 0L;
        for (SendUtils$FileUpload sendUtils$FileUpload : uploads) {
            if (sendUtils$FileUpload.getContentLength() <= 0) {
                ref$LongRef.element = -1L;
            } else {
                ref$LongRef.element = sendUtils$FileUpload.getContentLength() + ref$LongRef.element;
            }
        }
        if (ref$LongRef.element <= 0) {
            k kVar = new k(new WidgetChatListAdapterItemUploadProgress$Model$Many(uploads.size(), -1L, -1));
            m.checkNotNullExpressionValue(kVar, "Observable\n            .…          )\n            )");
            return kVar;
        }
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(uploads, 10));
        Iterator<T> it = uploads.iterator();
        while (it.hasNext()) {
            arrayList.add(ObservableExtensionsKt.leadingEdgeThrottle(((SendUtils$FileUpload) it.next()).getBytesWrittenObservable(), throttleIntervalMs, TimeUnit.MILLISECONDS));
        }
        Observable<WidgetChatListAdapterItemUploadProgress$Model$Many> observableG = Observable.b(arrayList, WidgetChatListAdapterItemUploadProgress$ModelProvider$getManyUploadsObservable$3.INSTANCE).G(new WidgetChatListAdapterItemUploadProgress$ModelProvider$getManyUploadsObservable$4(ref$LongRef)).r().G(new WidgetChatListAdapterItemUploadProgress$ModelProvider$getManyUploadsObservable$5(uploads, ref$LongRef));
        m.checkNotNullExpressionValue(observableG, "Observable\n            .…essPercent)\n            }");
        return observableG;
    }

    private final int getPercentage(long bytesWritten, long contentLengthBytes) {
        float f = bytesWritten;
        if (contentLengthBytes > 0) {
            return (int) ((f / contentLengthBytes) * 100);
        }
        Logger.e$default(AppLog.g, "contentLengthBytes was not positive", new Exception(), null, 4, null);
        return 0;
    }

    private final Observable<WidgetChatListAdapterItemUploadProgress$Model$Single> getSingleUploadObservable(SendUtils$FileUpload upload, long throttleIntervalMs) {
        if (upload.getContentLength() <= 0) {
            k kVar = new k(new WidgetChatListAdapterItemUploadProgress$Model$Single(upload.getName(), upload.getMimeType(), -1L, -1));
            m.checkNotNullExpressionValue(kVar, "Observable.just(\n       …E\n            )\n        )");
            return kVar;
        }
        Observable<WidgetChatListAdapterItemUploadProgress$Model$Single> observableG = ObservableExtensionsKt.leadingEdgeThrottle(upload.getBytesWrittenObservable(), throttleIntervalMs, TimeUnit.MILLISECONDS).G(new WidgetChatListAdapterItemUploadProgress$ModelProvider$getSingleUploadObservable$1(upload)).r().G(new WidgetChatListAdapterItemUploadProgress$ModelProvider$getSingleUploadObservable$2(upload));
        m.checkNotNullExpressionValue(observableG, "upload\n            .byte…          )\n            }");
        return observableG;
    }

    public final Observable<? extends WidgetChatListAdapterItemUploadProgress$Model> get(String nonce, long throttleIntervalMs) {
        m.checkNotNullParameter(nonce, "nonce");
        StoreMessageUploads messageUploads = StoreStream.Companion.getMessageUploads();
        Observable<? extends WidgetChatListAdapterItemUploadProgress$Model> observableY = ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck$UpdateSource[]{messageUploads}, false, null, null, new WidgetChatListAdapterItemUploadProgress$ModelProvider$get$1(messageUploads, nonce), 14, null).Y(new WidgetChatListAdapterItemUploadProgress$ModelProvider$get$2(throttleIntervalMs));
        m.checkNotNullExpressionValue(observableY, "ObservationDeckProvider.…      }\n        }\n      }");
        return observableY;
    }
}
