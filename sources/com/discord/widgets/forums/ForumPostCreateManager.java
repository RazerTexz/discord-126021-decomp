package com.discord.widgets.forums;

import android.content.ContentResolver;
import android.content.Context;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.NonceGenerator;
import com.discord.models.domain.NonceGenerator$Companion;
import com.discord.restapi.RestAPIParams$Message;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadDraft$ThreadDraftState;
import com.discord.utilities.rest.SendUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.MessageManager;
import com.discord.widgets.chat.MessageManager$AttachmentsRequest;
import com.lytefast.flexinput.model.Attachment;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: ForumPostCreateManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ForumPostCreateManager {
    public static final ForumPostCreateManager INSTANCE = new ForumPostCreateManager();
    private static final BehaviorSubject<Boolean> isCreateInProgressBehaviorSubject = BehaviorSubject.l0(Boolean.FALSE);

    private ForumPostCreateManager() {
    }

    public static final /* synthetic */ BehaviorSubject access$isCreateInProgressBehaviorSubject$p(ForumPostCreateManager forumPostCreateManager) {
        return isCreateInProgressBehaviorSubject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void createForumPostWithMessage$default(ForumPostCreateManager forumPostCreateManager, Context context, MessageManager messageManager, long j, int i, String str, StoreThreadDraft$ThreadDraftState storeThreadDraft$ThreadDraftState, MessageManager$AttachmentsRequest messageManager$AttachmentsRequest, Function2 function2, Function2 function3, int i2, Object obj) {
        forumPostCreateManager.createForumPostWithMessage(context, messageManager, j, i, str, storeThreadDraft$ThreadDraftState, (i2 & 64) != 0 ? null : messageManager$AttachmentsRequest, (i2 & 128) != 0 ? null : function2, (i2 & 256) != 0 ? null : function3);
    }

    private final Observable<Channel> sendCreateForumPostWithMessageRequest(Context context, long channelId, String name, String content, List<? extends Attachment<?>> attachments, int autoArchiveDuration, List<Long> appliedTags, List<Long> stickerIds) {
        RestAPIParams$Message restAPIParams$Message = new RestAPIParams$Message(content, String.valueOf(NonceGenerator$Companion.computeNonce$default(NonceGenerator.Companion, null, 1, null)), null, null, stickerIds, null, null, null, null);
        SendUtils sendUtils = SendUtils.INSTANCE;
        ContentResolver contentResolver = context.getContentResolver();
        m.checkNotNullExpressionValue(contentResolver, "context.contentResolver");
        Observable<R> observableG = sendUtils.getSendPayload(contentResolver, restAPIParams$Message, attachments).y(ForumPostCreateManager$sendCreateForumPostWithMessageRequest$$inlined$filterIs$1.INSTANCE).G(ForumPostCreateManager$sendCreateForumPostWithMessageRequest$$inlined$filterIs$2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it is T }.map { it as T }");
        Observable<Channel> observableA = observableG.Z(1).A(new ForumPostCreateManager$sendCreateForumPostWithMessageRequest$1(channelId, name, appliedTags, stickerIds, autoArchiveDuration));
        m.checkNotNullExpressionValue(observableA, "SendUtils\n        .getSe…(),\n          )\n        }");
        return observableA;
    }

    public final void createForumPostWithMessage(Context context, MessageManager messageManager, long forumChannelId, int autoArchiveDuration, String content, StoreThreadDraft$ThreadDraftState threadDraftState, MessageManager$AttachmentsRequest attachmentsRequest, Function2<? super Integer, ? super Integer, Unit> onMessageTooLong, Function2<? super Integer, ? super Boolean, Unit> onFilesTooLarge) {
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(messageManager, "messageManager");
        m.checkNotNullParameter(content, "content");
        m.checkNotNullParameter(threadDraftState, "threadDraftState");
        BehaviorSubject<Boolean> behaviorSubject = isCreateInProgressBehaviorSubject;
        m.checkNotNullExpressionValue(behaviorSubject, "isCreateInProgressBehaviorSubject");
        Boolean boolN0 = behaviorSubject.n0();
        m.checkNotNullExpressionValue(boolN0, "isCreateInProgressBehaviorSubject.value");
        if (boolN0.booleanValue()) {
            return;
        }
        String threadName = threadDraftState.getThreadName();
        if (threadName == null || threadName.length() == 0) {
            StoreStream.Companion.getThreadDraft().setDraftState(StoreThreadDraft$ThreadDraftState.copy$default(threadDraftState, false, null, null, false, true, 15, null));
        } else if (messageManager.isValidForumPostFirstMessage(content, attachmentsRequest, onMessageTooLong, onFilesTooLarge)) {
            behaviorSubject.onNext(Boolean.TRUE);
            Observable observableA = ObservableExtensionsKt.restSubscribeOn$default(sendCreateForumPostWithMessageRequest(context, forumChannelId, threadName, content, attachmentsRequest != null ? attachmentsRequest.getAttachments() : null, autoArchiveDuration, n.emptyList(), n.emptyList()), false, 1, null).A(ForumPostCreateManager$createForumPostWithMessage$1.INSTANCE);
            m.checkNotNullExpressionValue(observableA, "sendCreateForumPostWithM…utationLatest()\n        }");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observableA), ForumPostCreateManager.class, (Context) null, (Function1) null, new ForumPostCreateManager$createForumPostWithMessage$3(context, forumChannelId), (Function0) null, ForumPostCreateManager$createForumPostWithMessage$4.INSTANCE, new ForumPostCreateManager$createForumPostWithMessage$2(forumChannelId), 22, (Object) null);
        }
    }

    public final Observable<Boolean> observeIsForumPostCreateInProgress(long guildId) {
        Observable<Boolean> observableJ = Observable.j(ForumUtils.observeCanAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, guildId, null, null, 6, null), isCreateInProgressBehaviorSubject, ForumPostCreateManager$observeIsForumPostCreateInProgress$1.INSTANCE);
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…s && isCreateInProgress }");
        return observableJ;
    }
}
