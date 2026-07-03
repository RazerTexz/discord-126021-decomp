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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rest.SendUtils;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.widgets.chat.MessageManager;
import com.lytefast.flexinput.model.Attachment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import okhttp3.MultipartBody;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: ForumPostCreateManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ForumPostCreateManager {
    public static final ForumPostCreateManager INSTANCE = new ForumPostCreateManager();
    private static final BehaviorSubject<Boolean> isCreateInProgressBehaviorSubject = BehaviorSubject.m11130l0(Boolean.FALSE);

    /* JADX INFO: renamed from: com.discord.widgets.forums.ForumPostCreateManager$createForumPostWithMessage$2 */
    /* JADX INFO: compiled from: ForumPostCreateManager.kt */
    public static final class C83232 extends AbstractC12240o implements Function1<Channel, Unit> {
        public final /* synthetic */ long $forumChannelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C83232(long j) {
            super(1);
            this.$forumChannelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            StoreStream.INSTANCE.getSlowMode().onThreadCreated(this.$forumChannelId);
            ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), channel, null, null, 6, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.forums.ForumPostCreateManager$createForumPostWithMessage$3 */
    /* JADX INFO: compiled from: ForumPostCreateManager.kt */
    public static final class C83243 extends AbstractC12240o implements Function1<Error, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ long $forumChannelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C83243(Context context, long j) {
            super(1);
            this.$context = context;
            this.$forumChannelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "error");
            ThreadUtils.INSTANCE.handleThreadCreateError(this.$context, error, this.$forumChannelId);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.forums.ForumPostCreateManager$createForumPostWithMessage$4 */
    /* JADX INFO: compiled from: ForumPostCreateManager.kt */
    public static final class C83254 extends AbstractC12240o implements Function0<Unit> {
        public static final C83254 INSTANCE = new C83254();

        public C83254() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
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
        C12238m.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
        Observable<R> observableM11083G = sendUtils.getSendPayload(contentResolver, message, attachments).m11118y(new InterfaceC12589b<Object, Boolean>() { // from class: com.discord.widgets.forums.ForumPostCreateManager$sendCreateForumPostWithMessageRequest$$inlined$filterIs$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // p637j0.p641k.InterfaceC12589b
            public final Boolean call(Object obj) {
                return Boolean.valueOf(obj instanceof SendUtils.SendPayload.ReadyToSend);
            }
        }).m11083G(new InterfaceC12589b<Object, T>() { // from class: com.discord.widgets.forums.ForumPostCreateManager$sendCreateForumPostWithMessageRequest$$inlined$filterIs$2
            @Override // p637j0.p641k.InterfaceC12589b
            public final T call(Object obj) {
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.discord.utilities.rest.SendUtils.SendPayload.ReadyToSend");
                return (T) ((SendUtils.SendPayload.ReadyToSend) obj);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11083G, "filter { it is T }.map { it as T }");
        Observable<Channel> observableM11082A = observableM11083G.m11100Z(1).m11082A(new InterfaceC12589b<SendUtils.SendPayload.ReadyToSend, Observable<? extends Channel>>() { // from class: com.discord.widgets.forums.ForumPostCreateManager.sendCreateForumPostWithMessageRequest.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends Channel> call(SendUtils.SendPayload.ReadyToSend readyToSend) {
                List<SendUtils.FileUpload> uploads = readyToSend.getUploads();
                ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(uploads, 10));
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
        C12238m.checkNotNullExpressionValue(observableM11082A, "SendUtils\n        .getSe…(),\n          )\n        }");
        return observableM11082A;
    }

    public final void createForumPostWithMessage(Context context, MessageManager messageManager, long forumChannelId, int autoArchiveDuration, String content, StoreThreadDraft.ThreadDraftState threadDraftState, MessageManager.AttachmentsRequest attachmentsRequest, Function2<? super Integer, ? super Integer, Unit> onMessageTooLong, Function2<? super Integer, ? super Boolean, Unit> onFilesTooLarge) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(messageManager, "messageManager");
        C12238m.checkNotNullParameter(content, "content");
        C12238m.checkNotNullParameter(threadDraftState, "threadDraftState");
        BehaviorSubject<Boolean> behaviorSubject = isCreateInProgressBehaviorSubject;
        C12238m.checkNotNullExpressionValue(behaviorSubject, "isCreateInProgressBehaviorSubject");
        Boolean boolM11132n0 = behaviorSubject.m11132n0();
        C12238m.checkNotNullExpressionValue(boolM11132n0, "isCreateInProgressBehaviorSubject.value");
        if (boolM11132n0.booleanValue()) {
            return;
        }
        String threadName = threadDraftState.getThreadName();
        if (threadName == null || threadName.length() == 0) {
            StoreStream.INSTANCE.getThreadDraft().setDraftState(StoreThreadDraft.ThreadDraftState.copy$default(threadDraftState, false, null, null, false, true, 15, null));
        } else if (messageManager.isValidForumPostFirstMessage(content, attachmentsRequest, onMessageTooLong, onFilesTooLarge)) {
            behaviorSubject.onNext(Boolean.TRUE);
            Observable observableM11082A = ObservableExtensionsKt.restSubscribeOn$default(sendCreateForumPostWithMessageRequest(context, forumChannelId, threadName, content, attachmentsRequest != null ? attachmentsRequest.getAttachments() : null, autoArchiveDuration, C12147n.emptyList(), C12147n.emptyList()), false, 1, null).m11082A(new InterfaceC12589b<Channel, Observable<? extends Channel>>() { // from class: com.discord.widgets.forums.ForumPostCreateManager.createForumPostWithMessage.1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends Channel> call(Channel channel) {
                    Observable<R> observableM11083G = StoreStream.INSTANCE.getChannels().observeChannel(channel.getId()).m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
                    C12238m.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
                    return ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11083G, 0L, false, 3, null));
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11082A, "sendCreateForumPostWithM…utationLatest()\n        }");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.m8518ui(observableM11082A), (Class<?>) ForumPostCreateManager.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C83243(context, forumChannelId)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : C83254.INSTANCE), new C83232(forumChannelId));
        }
    }

    public final Observable<Boolean> observeIsForumPostCreateInProgress(long guildId) {
        Observable<Boolean> observableM11076j = Observable.m11076j(ForumUtils.observeCanAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, guildId, null, null, 6, null), isCreateInProgressBehaviorSubject, new Func2<Boolean, Boolean, Boolean>() { // from class: com.discord.widgets.forums.ForumPostCreateManager.observeIsForumPostCreateInProgress.1
            /* JADX WARN: Code duplicated, block: B:7:0x0018  */
            @Override // p658rx.functions.Func2
            public final Boolean call(Boolean bool, Boolean bool2) {
                boolean z2;
                C12238m.checkNotNullExpressionValue(bool, "canAccess");
                if (bool.booleanValue()) {
                    C12238m.checkNotNullExpressionValue(bool2, "isCreateInProgress");
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
        C12238m.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest…s && isCreateInProgress }");
        return observableM11076j;
    }
}
