package com.discord.widgets.chat.list.adapter;

import a0.a.a.b;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetChatListAdapterItemUploadProgressBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreMessageUploads;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.file.FileUtils2;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rest.SendUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.views.UploadProgressView;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.UploadProgressEntry;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$LongRef;
import rx.Observable;
import rx.Subscription;
import rx.functions.FuncN;

/* JADX INFO: compiled from: WidgetChatListAdapterItemUploadProgress.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemUploadProgress extends WidgetChatListItem {
    private static final long MODEL_THROTTLE_MS = 100;
    private final WidgetChatListAdapterItemUploadProgressBinding binding;
    private Subscription subscription;

    /* JADX INFO: compiled from: WidgetChatListAdapterItemUploadProgress.kt */
    public static abstract class Model {
        public static final int PROGRESS_INDETERMINATE = -1;
        public static final long SIZE_UNKNOWN = -1;

        /* JADX INFO: compiled from: WidgetChatListAdapterItemUploadProgress.kt */
        public static final /* data */ class Few extends Model {
            private final List<Single> uploads;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Few(List<Single> list) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "uploads");
                this.uploads = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Few copy$default(Few few, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = few.uploads;
                }
                return few.copy(list);
            }

            public final List<Single> component1() {
                return this.uploads;
            }

            public final Few copy(List<Single> uploads) {
                Intrinsics3.checkNotNullParameter(uploads, "uploads");
                return new Few(uploads);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Few) && Intrinsics3.areEqual(this.uploads, ((Few) other).uploads);
                }
                return true;
            }

            public final List<Single> getUploads() {
                return this.uploads;
            }

            public int hashCode() {
                List<Single> list = this.uploads;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.L(outline.U("Few(uploads="), this.uploads, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetChatListAdapterItemUploadProgress.kt */
        public static final /* data */ class Many extends Model {
            private final int numFiles;
            private final int progress;
            private final long sizeBytes;

            public Many(int i, long j, int i2) {
                super(null);
                this.numFiles = i;
                this.sizeBytes = j;
                this.progress = i2;
            }

            public static /* synthetic */ Many copy$default(Many many, int i, long j, int i2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    i = many.numFiles;
                }
                if ((i3 & 2) != 0) {
                    j = many.sizeBytes;
                }
                if ((i3 & 4) != 0) {
                    i2 = many.progress;
                }
                return many.copy(i, j, i2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getNumFiles() {
                return this.numFiles;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final long getSizeBytes() {
                return this.sizeBytes;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final int getProgress() {
                return this.progress;
            }

            public final Many copy(int numFiles, long sizeBytes, int progress) {
                return new Many(numFiles, sizeBytes, progress);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Many)) {
                    return false;
                }
                Many many = (Many) other;
                return this.numFiles == many.numFiles && this.sizeBytes == many.sizeBytes && this.progress == many.progress;
            }

            public final int getNumFiles() {
                return this.numFiles;
            }

            public final int getProgress() {
                return this.progress;
            }

            public final long getSizeBytes() {
                return this.sizeBytes;
            }

            public int hashCode() {
                return ((b.a(this.sizeBytes) + (this.numFiles * 31)) * 31) + this.progress;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Many(numFiles=");
                sbU.append(this.numFiles);
                sbU.append(", sizeBytes=");
                sbU.append(this.sizeBytes);
                sbU.append(", progress=");
                return outline.B(sbU, this.progress, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetChatListAdapterItemUploadProgress.kt */
        public static final class None extends Model {
            public static final None INSTANCE = new None();

            private None() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetChatListAdapterItemUploadProgress.kt */
        public static final /* data */ class Preprocessing extends Model {
            private final String displayName;
            private final String mimeType;
            private final int numFiles;

            public Preprocessing(int i, String str, String str2) {
                super(null);
                this.numFiles = i;
                this.displayName = str;
                this.mimeType = str2;
            }

            public static /* synthetic */ Preprocessing copy$default(Preprocessing preprocessing, int i, String str, String str2, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = preprocessing.numFiles;
                }
                if ((i2 & 2) != 0) {
                    str = preprocessing.displayName;
                }
                if ((i2 & 4) != 0) {
                    str2 = preprocessing.mimeType;
                }
                return preprocessing.copy(i, str, str2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getNumFiles() {
                return this.numFiles;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getDisplayName() {
                return this.displayName;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getMimeType() {
                return this.mimeType;
            }

            public final Preprocessing copy(int numFiles, String displayName, String mimeType) {
                return new Preprocessing(numFiles, displayName, mimeType);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Preprocessing)) {
                    return false;
                }
                Preprocessing preprocessing = (Preprocessing) other;
                return this.numFiles == preprocessing.numFiles && Intrinsics3.areEqual(this.displayName, preprocessing.displayName) && Intrinsics3.areEqual(this.mimeType, preprocessing.mimeType);
            }

            public final String getDisplayName() {
                return this.displayName;
            }

            public final String getMimeType() {
                return this.mimeType;
            }

            public final int getNumFiles() {
                return this.numFiles;
            }

            public int hashCode() {
                int i = this.numFiles * 31;
                String str = this.displayName;
                int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.mimeType;
                return iHashCode + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Preprocessing(numFiles=");
                sbU.append(this.numFiles);
                sbU.append(", displayName=");
                sbU.append(this.displayName);
                sbU.append(", mimeType=");
                return outline.J(sbU, this.mimeType, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetChatListAdapterItemUploadProgress.kt */
        public static final /* data */ class Single extends Model {
            private final String mimeType;
            private final String name;
            private final int progress;
            private final long sizeBytes;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Single(String str, String str2, long j, int i) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
                Intrinsics3.checkNotNullParameter(str2, "mimeType");
                this.name = str;
                this.mimeType = str2;
                this.sizeBytes = j;
                this.progress = i;
            }

            public static /* synthetic */ Single copy$default(Single single, String str, String str2, long j, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = single.name;
                }
                if ((i2 & 2) != 0) {
                    str2 = single.mimeType;
                }
                String str3 = str2;
                if ((i2 & 4) != 0) {
                    j = single.sizeBytes;
                }
                long j2 = j;
                if ((i2 & 8) != 0) {
                    i = single.progress;
                }
                return single.copy(str, str3, j2, i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getName() {
                return this.name;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getMimeType() {
                return this.mimeType;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final long getSizeBytes() {
                return this.sizeBytes;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final int getProgress() {
                return this.progress;
            }

            public final Single copy(String name, String mimeType, long sizeBytes, int progress) {
                Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
                Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
                return new Single(name, mimeType, sizeBytes, progress);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Single)) {
                    return false;
                }
                Single single = (Single) other;
                return Intrinsics3.areEqual(this.name, single.name) && Intrinsics3.areEqual(this.mimeType, single.mimeType) && this.sizeBytes == single.sizeBytes && this.progress == single.progress;
            }

            public final String getMimeType() {
                return this.mimeType;
            }

            public final String getName() {
                return this.name;
            }

            public final int getProgress() {
                return this.progress;
            }

            public final long getSizeBytes() {
                return this.sizeBytes;
            }

            public int hashCode() {
                String str = this.name;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.mimeType;
                return ((b.a(this.sizeBytes) + ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31)) * 31) + this.progress;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Single(name=");
                sbU.append(this.name);
                sbU.append(", mimeType=");
                sbU.append(this.mimeType);
                sbU.append(", sizeBytes=");
                sbU.append(this.sizeBytes);
                sbU.append(", progress=");
                return outline.B(sbU, this.progress, ")");
            }
        }

        private Model() {
        }

        public /* synthetic */ Model(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetChatListAdapterItemUploadProgress.kt */
    public static final class ModelProvider {
        public static final ModelProvider INSTANCE = new ModelProvider();
        private static final int MAX_DETAILED_UPLOADS = 3;

        private ModelProvider() {
        }

        private final Observable<Model.Few> getFewUploadsObservable(List<SendUtils.FileUpload> uploads, long throttleIntervalMs) {
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(uploads, 10));
            Iterator<T> it = uploads.iterator();
            while (it.hasNext()) {
                arrayList.add(INSTANCE.getSingleUploadObservable((SendUtils.FileUpload) it.next(), throttleIntervalMs));
            }
            Observable<Model.Few> observableB = Observable.b(arrayList, new FuncN<Model.Few>() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress$ModelProvider$getFewUploadsObservable$2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // rx.functions.FuncN
                public final WidgetChatListAdapterItemUploadProgress.Model.Few call(Object[] objArr) {
                    Intrinsics3.checkNotNullExpressionValue(objArr, "singles");
                    ArrayList arrayList2 = new ArrayList(objArr.length);
                    for (Object obj : objArr) {
                        Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress.Model.Single");
                        arrayList2.add((WidgetChatListAdapterItemUploadProgress.Model.Single) obj);
                    }
                    return new WidgetChatListAdapterItemUploadProgress.Model.Few(arrayList2);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableB, "Observable\n          .co…{ it as Model.Single }) }");
            return observableB;
        }

        private final Observable<Model.Many> getManyUploadsObservable(final List<SendUtils.FileUpload> uploads, long throttleIntervalMs) {
            final Ref$LongRef ref$LongRef = new Ref$LongRef();
            ref$LongRef.element = 0L;
            for (SendUtils.FileUpload fileUpload : uploads) {
                if (fileUpload.getContentLength() <= 0) {
                    ref$LongRef.element = -1L;
                } else {
                    ref$LongRef.element = fileUpload.getContentLength() + ref$LongRef.element;
                }
            }
            if (ref$LongRef.element <= 0) {
                ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(new Model.Many(uploads.size(), -1L, -1));
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable\n            .…          )\n            )");
                return scalarSynchronousObservable;
            }
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(uploads, 10));
            Iterator<T> it = uploads.iterator();
            while (it.hasNext()) {
                arrayList.add(ObservableExtensionsKt.leadingEdgeThrottle(((SendUtils.FileUpload) it.next()).getBytesWrittenObservable(), throttleIntervalMs, TimeUnit.MILLISECONDS));
            }
            Observable<Model.Many> observableG = Observable.b(arrayList, new FuncN<Long>() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress$ModelProvider$getManyUploadsObservable$3
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // rx.functions.FuncN
                public final Long call(Object[] objArr) {
                    Intrinsics3.checkNotNullExpressionValue(objArr, "bytesWrittenPerUpload");
                    ArrayList arrayList2 = new ArrayList(objArr.length);
                    for (Object obj : objArr) {
                        Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.Long");
                        arrayList2.add(Long.valueOf(((Long) obj).longValue()));
                    }
                    return Long.valueOf(_Collections.sumOfLong(arrayList2));
                }
            }).G(new Func1<Long, Integer>() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress$ModelProvider$getManyUploadsObservable$4
                @Override // j0.k.Func1
                public final Integer call(Long l) {
                    WidgetChatListAdapterItemUploadProgress.ModelProvider modelProvider = WidgetChatListAdapterItemUploadProgress.ModelProvider.INSTANCE;
                    Intrinsics3.checkNotNullExpressionValue(l, "totalBytesWritten");
                    return Integer.valueOf(modelProvider.getPercentage(l.longValue(), ref$LongRef.element));
                }
            }).r().G(new Func1<Integer, Model.Many>() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress$ModelProvider$getManyUploadsObservable$5
                @Override // j0.k.Func1
                public final WidgetChatListAdapterItemUploadProgress.Model.Many call(Integer num) {
                    int size = uploads.size();
                    long j = ref$LongRef.element;
                    Intrinsics3.checkNotNullExpressionValue(num, "overallProgressPercent");
                    return new WidgetChatListAdapterItemUploadProgress.Model.Many(size, j, num.intValue());
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableG, "Observable\n            .…essPercent)\n            }");
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

        private final Observable<Model.Single> getSingleUploadObservable(final SendUtils.FileUpload upload, long throttleIntervalMs) {
            if (upload.getContentLength() <= 0) {
                ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(new Model.Single(upload.getName(), upload.getMimeType(), -1L, -1));
                Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(\n       …E\n            )\n        )");
                return scalarSynchronousObservable;
            }
            Observable<Model.Single> observableG = ObservableExtensionsKt.leadingEdgeThrottle(upload.getBytesWrittenObservable(), throttleIntervalMs, TimeUnit.MILLISECONDS).G(new Func1<Long, Integer>() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress$ModelProvider$getSingleUploadObservable$1
                @Override // j0.k.Func1
                public final Integer call(Long l) {
                    WidgetChatListAdapterItemUploadProgress.ModelProvider modelProvider = WidgetChatListAdapterItemUploadProgress.ModelProvider.INSTANCE;
                    Intrinsics3.checkNotNullExpressionValue(l, "bytesWritten");
                    return Integer.valueOf(modelProvider.getPercentage(l.longValue(), upload.getContentLength()));
                }
            }).r().G(new Func1<Integer, Model.Single>() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress$ModelProvider$getSingleUploadObservable$2
                @Override // j0.k.Func1
                public final WidgetChatListAdapterItemUploadProgress.Model.Single call(Integer num) {
                    String name = upload.getName();
                    String mimeType = upload.getMimeType();
                    long contentLength = upload.getContentLength();
                    Intrinsics3.checkNotNullExpressionValue(num, "progressPercent");
                    return new WidgetChatListAdapterItemUploadProgress.Model.Single(name, mimeType, contentLength, num.intValue());
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableG, "upload\n            .byte…          )\n            }");
            return observableG;
        }

        public final Observable<? extends Model> get(String nonce, final long throttleIntervalMs) {
            Intrinsics3.checkNotNullParameter(nonce, "nonce");
            StoreMessageUploads messageUploads = StoreStream.INSTANCE.getMessageUploads();
            Observable<? extends Model> observableY = ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{messageUploads}, false, null, null, new WidgetChatListAdapterItemUploadProgress$ModelProvider$get$1(messageUploads, nonce), 14, null).Y(new Func1<StoreMessageUploads.MessageUploadState, Observable<? extends Model>>() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress$ModelProvider$get$2
                @Override // j0.k.Func1
                public final Observable<? extends WidgetChatListAdapterItemUploadProgress.Model> call(StoreMessageUploads.MessageUploadState messageUploadState) {
                    if (messageUploadState instanceof StoreMessageUploads.MessageUploadState.None) {
                        return new ScalarSynchronousObservable(WidgetChatListAdapterItemUploadProgress.Model.None.INSTANCE);
                    }
                    if (messageUploadState instanceof StoreMessageUploads.MessageUploadState.Preprocessing) {
                        StoreMessageUploads.MessageUploadState.Preprocessing preprocessing = (StoreMessageUploads.MessageUploadState.Preprocessing) messageUploadState;
                        return new ScalarSynchronousObservable(new WidgetChatListAdapterItemUploadProgress.Model.Preprocessing(preprocessing.getNumFiles(), preprocessing.getDisplayName(), preprocessing.getMimeType()));
                    }
                    if (!(messageUploadState instanceof StoreMessageUploads.MessageUploadState.Uploading)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    List<SendUtils.FileUpload> uploads = ((StoreMessageUploads.MessageUploadState.Uploading) messageUploadState).getUploads();
                    if (uploads.size() == 1) {
                        return WidgetChatListAdapterItemUploadProgress.ModelProvider.INSTANCE.getSingleUploadObservable((SendUtils.FileUpload) _Collections.first((List) uploads), throttleIntervalMs);
                    }
                    return uploads.size() <= 3 ? WidgetChatListAdapterItemUploadProgress.ModelProvider.INSTANCE.getFewUploadsObservable(uploads, throttleIntervalMs) : WidgetChatListAdapterItemUploadProgress.ModelProvider.INSTANCE.getManyUploadsObservable(uploads, throttleIntervalMs);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableY, "ObservationDeckProvider.…      }\n        }\n      }");
            return observableY;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress$onConfigure$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemUploadProgress.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetChatListAdapterItemUploadProgress widgetChatListAdapterItemUploadProgress) {
            super(1, widgetChatListAdapterItemUploadProgress, WidgetChatListAdapterItemUploadProgress.class, "configureUI", "configureUI(Lcom/discord/widgets/chat/list/adapter/WidgetChatListAdapterItemUploadProgress$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "p1");
            ((WidgetChatListAdapterItemUploadProgress) this.receiver).configureUI(model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress$onConfigure$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatListAdapterItemUploadProgress.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            WidgetChatListAdapterItemUploadProgress.this.subscription = subscription;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemUploadProgress(WidgetChatListAdapter widgetChatListAdapter) {
        super(R.layout.widget_chat_list_adapter_item_upload_progress, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        int i = R.id.progress_cancel_centered;
        ImageView imageView = (ImageView) view.findViewById(R.id.progress_cancel_centered);
        if (imageView != null) {
            i = R.id.progress_cancel_top;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.progress_cancel_top);
            if (imageView2 != null) {
                i = R.id.upload_progress_1;
                UploadProgressView uploadProgressView = (UploadProgressView) view.findViewById(R.id.upload_progress_1);
                if (uploadProgressView != null) {
                    i = R.id.upload_progress_2;
                    UploadProgressView uploadProgressView2 = (UploadProgressView) view.findViewById(R.id.upload_progress_2);
                    if (uploadProgressView2 != null) {
                        i = R.id.upload_progress_3;
                        UploadProgressView uploadProgressView3 = (UploadProgressView) view.findViewById(R.id.upload_progress_3);
                        if (uploadProgressView3 != null) {
                            WidgetChatListAdapterItemUploadProgressBinding widgetChatListAdapterItemUploadProgressBinding = new WidgetChatListAdapterItemUploadProgressBinding((LinearLayout) view, imageView, imageView2, uploadProgressView, uploadProgressView2, uploadProgressView3);
                            Intrinsics3.checkNotNullExpressionValue(widgetChatListAdapterItemUploadProgressBinding, "WidgetChatListAdapterIte…essBinding.bind(itemView)");
                            this.binding = widgetChatListAdapterItemUploadProgressBinding;
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ec  */
    private final void configureUI(Model uploadState) {
        boolean z2;
        boolean z3;
        boolean z4 = uploadState instanceof Model.Few;
        if (z4) {
            UploadProgressView uploadProgressView = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(uploadProgressView, "binding.uploadProgress1");
            Model.Few few = (Model.Few) uploadState;
            setUploadState(uploadProgressView, few.getUploads().get(0));
            UploadProgressView uploadProgressView2 = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(uploadProgressView2, "binding.uploadProgress2");
            setUploadState(uploadProgressView2, few.getUploads().get(1));
            UploadProgressView uploadProgressView3 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(uploadProgressView3, "binding.uploadProgress3");
            uploadProgressView3.setVisibility(0);
            if (few.getUploads().size() == 3) {
                UploadProgressView uploadProgressView4 = this.binding.f;
                Intrinsics3.checkNotNullExpressionValue(uploadProgressView4, "binding.uploadProgress3");
                uploadProgressView4.setVisibility(0);
                UploadProgressView uploadProgressView5 = this.binding.f;
                Intrinsics3.checkNotNullExpressionValue(uploadProgressView5, "binding.uploadProgress3");
                setUploadState(uploadProgressView5, few.getUploads().get(2));
            } else {
                UploadProgressView uploadProgressView6 = this.binding.f;
                Intrinsics3.checkNotNullExpressionValue(uploadProgressView6, "binding.uploadProgress3");
                uploadProgressView6.setVisibility(8);
            }
        } else {
            UploadProgressView uploadProgressView7 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(uploadProgressView7, "binding.uploadProgress1");
            setUploadState(uploadProgressView7, uploadState);
            UploadProgressView uploadProgressView8 = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(uploadProgressView8, "binding.uploadProgress2");
            uploadProgressView8.setVisibility(8);
            UploadProgressView uploadProgressView9 = this.binding.f;
            Intrinsics3.checkNotNullExpressionValue(uploadProgressView9, "binding.uploadProgress3");
            uploadProgressView9.setVisibility(8);
        }
        if ((uploadState instanceof Model.Preprocessing) || ((uploadState instanceof Model.Single) && ((Model.Single) uploadState).getProgress() < 100)) {
            z2 = true;
        } else if (z4) {
            List<Model.Single> uploads = ((Model.Few) uploadState).getUploads();
            if (!(uploads instanceof Collection) || !uploads.isEmpty()) {
                Iterator<T> it = uploads.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z3 = false;
                        break;
                    } else {
                        if (((Model.Single) it.next()).getProgress() < 100) {
                            z3 = true;
                            break;
                        }
                    }
                }
            } else {
                z3 = false;
                break;
            }
            if (z3) {
                z2 = true;
            } else if ((uploadState instanceof Model.Many) || ((Model.Many) uploadState).getProgress() >= 100) {
                z2 = false;
            } else {
                z2 = true;
            }
        } else {
            if (uploadState instanceof Model.Many) {
            }
            z2 = false;
        }
        if (z2) {
            ImageView imageView = this.binding.c;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.progressCancelTop");
            imageView.setVisibility(z4 ? 0 : 8);
            ImageView imageView2 = this.binding.f2342b;
            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.progressCancelCentered");
            imageView2.setVisibility(z4 ^ true ? 0 : 8);
            return;
        }
        ImageView imageView3 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.progressCancelTop");
        imageView3.setVisibility(8);
        ImageView imageView4 = this.binding.f2342b;
        Intrinsics3.checkNotNullExpressionValue(imageView4, "binding.progressCancelCentered");
        imageView4.setVisibility(8);
    }

    private final void setUploadState(UploadProgressView uploadProgressView, Model model) {
        if (Intrinsics3.areEqual(model, Model.None.INSTANCE)) {
            CharSequence charSequenceD = FormatUtils.d(uploadProgressView, R.string.upload_queued, new Object[0], (4 & 4) != 0 ? FormatUtils.c.j : null);
            int i = UploadProgressView.j;
            uploadProgressView.a(charSequenceD, 0, null);
            Context context = uploadProgressView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            uploadProgressView.setIcon(DrawableCompat.getThemedDrawableRes$default(context, R.attr.ic_uploads_generic, 0, 2, (Object) null));
            return;
        }
        if (model instanceof Model.Preprocessing) {
            Model.Preprocessing preprocessing = (Model.Preprocessing) model;
            CharSequence displayName = preprocessing.getDisplayName();
            if (displayName == null) {
                Resources resources = uploadProgressView.getResources();
                Intrinsics3.checkNotNullExpressionValue(resources, "resources");
                Context context2 = uploadProgressView.getContext();
                Intrinsics3.checkNotNullExpressionValue(context2, "context");
                displayName = StringResourceUtils.getQuantityString(resources, context2, R.plurals.uploading_files_count, preprocessing.getNumFiles(), Integer.valueOf(preprocessing.getNumFiles()));
            }
            int i2 = UploadProgressView.j;
            uploadProgressView.a(displayName, -1, null);
            if (preprocessing.getMimeType() != null) {
                Context context3 = uploadProgressView.getContext();
                Intrinsics3.checkNotNullExpressionValue(context3, "context");
                uploadProgressView.setIcon(FileUtils2.getIconForFiletype(context3, preprocessing.getMimeType()));
                return;
            } else {
                Context context4 = uploadProgressView.getContext();
                Intrinsics3.checkNotNullExpressionValue(context4, "context");
                uploadProgressView.setIcon(DrawableCompat.getThemedDrawableRes$default(context4, R.attr.ic_uploads_generic, 0, 2, (Object) null));
                return;
            }
        }
        if (model instanceof Model.Single) {
            Model.Single single = (Model.Single) model;
            uploadProgressView.a(single.getName(), single.getProgress() != -1 ? single.getProgress() : -1, FileUtils2.getSizeSubtitle(single.getSizeBytes()));
            Context context5 = uploadProgressView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context5, "context");
            uploadProgressView.setIcon(FileUtils2.getIconForFiletype(context5, single.getMimeType()));
            return;
        }
        if (model instanceof Model.Many) {
            Resources resources2 = uploadProgressView.getResources();
            Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
            Context context6 = uploadProgressView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context6, "context");
            Model.Many many = (Model.Many) model;
            uploadProgressView.a(StringResourceUtils.getQuantityString(resources2, context6, R.plurals.uploading_files_count, many.getNumFiles(), Integer.valueOf(many.getNumFiles())), many.getProgress() != -1 ? many.getProgress() : -1, FileUtils2.getSizeSubtitle(many.getSizeBytes()));
            Context context7 = uploadProgressView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context7, "context");
            uploadProgressView.setIcon(DrawableCompat.getThemedDrawableRes$default(context7, R.attr.ic_uploads_generic, 0, 2, (Object) null));
        }
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.subscription;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        Observable<? extends Model> observableL = ModelProvider.INSTANCE.get(((UploadProgressEntry) data).getMessageNonce(), 100L).L();
        Intrinsics3.checkNotNullExpressionValue(observableL, "ModelProvider.get(data.m…  .onBackpressureLatest()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui(observableL), (Class<?>) WidgetChatListAdapterItemUploadProgress.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass2()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
        final WidgetChatListAdapterItemUploadProgress$onConfigure$cancel$1 widgetChatListAdapterItemUploadProgress$onConfigure$cancel$1 = new WidgetChatListAdapterItemUploadProgress$onConfigure$cancel$1(data);
        this.binding.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress.onConfigure.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                widgetChatListAdapterItemUploadProgress$onConfigure$cancel$1.invoke();
            }
        });
        this.binding.f2342b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemUploadProgress.onConfigure.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                widgetChatListAdapterItemUploadProgress$onConfigure$cancel$1.invoke();
            }
        });
    }
}
