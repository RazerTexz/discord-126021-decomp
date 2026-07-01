package com.discord.widgets.forums;

import android.content.ContentResolver;
import android.content.Context;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.NonceGenerator;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadDraft;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.SendUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.widgets.chat.MessageManager;
import com.lytefast.flexinput.model.Attachment;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import okhttp3.MultipartBody;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: ForumPostCreateManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ForumPostCreateManager {
    public static final ForumPostCreateManager INSTANCE = new ForumPostCreateManager();
    private static final BehaviorSubject<Boolean> isCreateInProgressBehaviorSubject = BehaviorSubject.l0(Boolean.FALSE);

    /* JADX INFO: renamed from: com.discord.widgets.forums.ForumPostCreateManager$createForumPostWithMessage$2, reason: invalid class name */
    /* JADX INFO: compiled from: ForumPostCreateManager.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Channel, Unit> {
        public final /* synthetic */ long $forumChannelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j) {
            super(1);
            this.$forumChannelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            StoreStream.INSTANCE.getSlowMode().onThreadCreated(this.$forumChannelId);
            ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), channel, null, null, 6, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.forums.ForumPostCreateManager$createForumPostWithMessage$3, reason: invalid class name */
    /* JADX INFO: compiled from: ForumPostCreateManager.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ long $forumChannelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Context context, long j) {
            super(1);
            this.$context = context;
            this.$forumChannelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            ThreadUtils.INSTANCE.handleThreadCreateError(this.$context, error, this.$forumChannelId);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.forums.ForumPostCreateManager$createForumPostWithMessage$4, reason: invalid class name */
    /* JADX INFO: compiled from: ForumPostCreateManager.kt */
    public static final class AnonymousClass4 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ForumPostCreateManager.access$isCreateInProgressBehaviorSubject$p(ForumPostCreateManager.INSTANCE).onNext(Boolean.FALSE);
        }
    }

    private ForumPostCreateManager() {
    }

    public static final /* synthetic */ BehaviorSubject access$isCreateInProgressBehaviorSubject$p(ForumPostCreateManager forumPostCreateManager) {
        return isCreateInProgressBehaviorSubject;
    }

    private final Observable<Channel> sendCreateForumPostWithMessageRequest(Context context, final long channelId, final String name, String content, List<? extends Attachment<?>> attachments, final int autoArchiveDuration, final List<Long> appliedTags, final List<Long> stickerIds) {
        RestAPIParams.Message message = new RestAPIParams.Message(content, String.valueOf(NonceGenerator.Companion.computeNonce$default(NonceGenerator.INSTANCE, null, 1, null)), null, null, stickerIds, null, null, null, null);
        SendUtils sendUtils = SendUtils.INSTANCE;
        ContentResolver contentResolver = context.getContentResolver();
        Intrinsics3.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
        Observable<R> observableG = sendUtils.getSendPayload(contentResolver, message, attachments).y(new Func1<Object, Boolean>() { // from class: com.discord.widgets.forums.ForumPostCreateManager$sendCreateForumPostWithMessageRequest$$inlined$filterIs$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // j0.k.Func1
            public final Boolean call(Object obj) {
                return Boolean.valueOf(obj instanceof SendUtils.SendPayload.ReadyToSend);
            }
        }).G(new Func1<Object, T>() { // from class: com.discord.widgets.forums.ForumPostCreateManager$sendCreateForumPostWithMessageRequest$$inlined$filterIs$2
            @Override // j0.k.Func1
            public final T call(Object obj) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.utilities.rest.SendUtils.SendPayload.ReadyToSend");
                return (T) ((SendUtils.SendPayload.ReadyToSend) obj);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        Observable<Channel> observableA = observableG.Z(1).A(new Func1<SendUtils.SendPayload.ReadyToSend, Observable<? extends Channel>>() { // from class: com.discord.widgets.forums.ForumPostCreateManager.sendCreateForumPostWithMessageRequest.1
            @Override // j0.k.Func1
            public final Observable<? extends Channel> call(SendUtils.SendPayload.ReadyToSend readyToSend) {
                List<SendUtils.FileUpload> uploads = readyToSend.getUploads();
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(uploads, 10));
                Iterator<T> it = uploads.iterator();
                while (it.hasNext()) {
                    arrayList.add(((SendUtils.FileUpload) it.next()).getPart());
                }
                RestAPI api = RestAPI.INSTANCE.getApi();
                long j = channelId;
                String str = name;
                String content2 = readyToSend.getMessage().getContent();
                if (content2 == null) {
                    content2 = "";
                }
                String str2 = content2;
                List<Long> list = appliedTags;
                List<Long> list2 = stickerIds;
                Integer numValueOf = Integer.valueOf(autoArchiveDuration);
                Object[] array = arrayList.toArray(new MultipartBody.Part[0]);
                Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                return api.createThreadWithMessage(j, str, str2, list, list2, 11, numValueOf, (MultipartBody.Part[]) array);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableA, "SendUtils\n        .getSe…(),\n          )\n        }");
        return observableA;
    }

    public final void createForumPostWithMessage(Context context, MessageManager messageManager, long forumChannelId, int autoArchiveDuration, String content, StoreThreadDraft.ThreadDraftState threadDraftState, MessageManager.AttachmentsRequest attachmentsRequest, Function2<? super Integer, ? super Integer, Unit> onMessageTooLong, Function2<? super Integer, ? super Boolean, Unit> onFilesTooLarge) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(messageManager, "messageManager");
        Intrinsics3.checkNotNullParameter(content, "content");
        Intrinsics3.checkNotNullParameter(threadDraftState, "threadDraftState");
        BehaviorSubject<Boolean> behaviorSubject = isCreateInProgressBehaviorSubject;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "isCreateInProgressBehaviorSubject");
        Boolean boolN0 = behaviorSubject.n0();
        Intrinsics3.checkNotNullExpressionValue(boolN0, "isCreateInProgressBehaviorSubject.value");
        if (boolN0.booleanValue()) {
            return;
        }
        String threadName = threadDraftState.getThreadName();
        if (threadName == null || threadName.length() == 0) {
            StoreStream.INSTANCE.getThreadDraft().setDraftState(StoreThreadDraft.ThreadDraftState.copy$default(threadDraftState, false, null, null, false, true, 15, null));
        } else if (messageManager.isValidForumPostFirstMessage(content, attachmentsRequest, onMessageTooLong, onFilesTooLarge)) {
            behaviorSubject.onNext(Boolean.TRUE);
            Observable observableA = ObservableExtensionsKt.restSubscribeOn$default(sendCreateForumPostWithMessageRequest(context, forumChannelId, threadName, content, attachmentsRequest != null ? attachmentsRequest.getAttachments() : null, autoArchiveDuration, Collections2.emptyList(), Collections2.emptyList()), false, 1, null).A(new Func1<Channel, Observable<? extends Channel>>() { // from class: com.discord.widgets.forums.ForumPostCreateManager.createForumPostWithMessage.1
                @Override // j0.k.Func1
                public final Observable<? extends Channel> call(Channel channel) {
                    Observable<R> observableG = StoreStream.INSTANCE.getChannels().observeChannel(channel.getId()).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
                    Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
                    return ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableG, 0L, false, 3, null));
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableA, "sendCreateForumPostWithM…utationLatest()\n        }");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui(observableA), (Class<?>) ForumPostCreateManager.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass3(context, forumChannelId)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : AnonymousClass4.INSTANCE), new AnonymousClass2(forumChannelId));
        }
    }

    public final Observable<Boolean> observeIsForumPostCreateInProgress(long guildId) {
        Observable<Boolean> observableJ = Observable.j(ForumUtils.observeCanAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, guildId, null, null, 6, null), isCreateInProgressBehaviorSubject, new Func2<Boolean, Boolean, Boolean>() { // from class: com.discord.widgets.forums.ForumPostCreateManager.observeIsForumPostCreateInProgress.1
            /* JADX WARN: Code duplicated, block: B:7:0x0018  */
            @Override // rx.functions.Func2
            public final Boolean call(Boolean bool, Boolean bool2) {
                boolean z2;
                Intrinsics3.checkNotNullExpressionValue(bool, "canAccess");
                if (bool.booleanValue()) {
                    Intrinsics3.checkNotNullExpressionValue(bool2, "isCreateInProgress");
                    if (bool2.booleanValue()) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    z2 = false;
                }
                return Boolean.valueOf(z2);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…s && isCreateInProgress }");
        return observableJ;
    }
}
