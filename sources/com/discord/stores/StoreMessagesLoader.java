package com.discord.stores;

import a0.a.a.b;
import android.content.Context;
import b.a.d.o;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.user.User;
import com.discord.app.AppLog;
import com.discord.models.message.Message;
import com.discord.stores.StoreChat;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Iterables2;
import d0.t.Sets5;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: StoreMessagesLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreMessagesLoader extends Store {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final long SCROLL_TO_LAST_UNREAD = 0;
    public static final long SCROLL_TO_LATEST = 1;
    private boolean authed;
    private boolean backgrounded;
    private final SerializedSubject<Map<Long, ChannelLoadedState>, Map<Long, ChannelLoadedState>> channelLoadedStateSubject;
    private final HashMap<Long, ChannelLoadedState> channelLoadedStates;
    private final SerializedSubject<ChannelChunk, ChannelChunk> channelMessageChunksSubject;
    private final SerializedSubject<Boolean, Boolean> channelMessagesLoadingSubject;
    private Subscription delayLoadingMessagesSubscription;
    private Set<Long> detachedChannels;
    private final Dispatcher dispatcher;
    private boolean hasConnected;
    private StoreChat.InteractionState interactionState;
    private final long loadingMessagesRetryDelayDefault;
    private long loadingMessagesRetryDelayMillis;
    private final int loadingMessagesRetryJitter;
    private int loadingMessagesRetryMax;
    private Subscription loadingMessagesSubscription;
    private final int messageRequestSize;
    private final SerializedSubject<Long, Long> scrollToSubject;
    private long selectedChannelId;
    private final StoreStream stream;

    /* JADX INFO: compiled from: StoreMessagesLoader.kt */
    public static final /* data */ class ChannelChunk {
        private final long channelId;
        private final boolean isAppendingTop;
        private final boolean isInitial;
        private final boolean isJump;
        private final boolean isPresent;
        private final List<Message> messages;

        public ChannelChunk(long j, List<Message> list, boolean z2, boolean z3, boolean z4, boolean z5) {
            Intrinsics3.checkNotNullParameter(list, "messages");
            this.channelId = j;
            this.messages = list;
            this.isInitial = z2;
            this.isPresent = z3;
            this.isAppendingTop = z4;
            this.isJump = z5;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        public final List<Message> component2() {
            return this.messages;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsInitial() {
            return this.isInitial;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsPresent() {
            return this.isPresent;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsAppendingTop() {
            return this.isAppendingTop;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getIsJump() {
            return this.isJump;
        }

        public final ChannelChunk copy(long channelId, List<Message> messages, boolean isInitial, boolean isPresent, boolean isAppendingTop, boolean isJump) {
            Intrinsics3.checkNotNullParameter(messages, "messages");
            return new ChannelChunk(channelId, messages, isInitial, isPresent, isAppendingTop, isJump);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelChunk)) {
                return false;
            }
            ChannelChunk channelChunk = (ChannelChunk) other;
            return this.channelId == channelChunk.channelId && Intrinsics3.areEqual(this.messages, channelChunk.messages) && this.isInitial == channelChunk.isInitial && this.isPresent == channelChunk.isPresent && this.isAppendingTop == channelChunk.isAppendingTop && this.isJump == channelChunk.isJump;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final List<Message> getMessages() {
            return this.messages;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v16 */
        /* JADX WARN: Type inference failed for: r1v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v8, types: [int] */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public int hashCode() {
            int iA = b.a(this.channelId) * 31;
            List<Message> list = this.messages;
            int iHashCode = (iA + (list != null ? list.hashCode() : 0)) * 31;
            boolean z2 = this.isInitial;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            int i = (iHashCode + r1) * 31;
            boolean z3 = this.isPresent;
            ?? r2 = z3;
            if (z3) {
                r2 = 1;
            }
            int i2 = (i + r2) * 31;
            boolean z4 = this.isAppendingTop;
            ?? r3 = z4;
            if (z4) {
                r3 = 1;
            }
            int i3 = (i2 + r3) * 31;
            boolean z5 = this.isJump;
            return i3 + (z5 ? 1 : z5);
        }

        public final boolean isAppendingTop() {
            return this.isAppendingTop;
        }

        public final boolean isInitial() {
            return this.isInitial;
        }

        public final boolean isJump() {
            return this.isJump;
        }

        public final boolean isPresent() {
            return this.isPresent;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ChannelChunk(channelId=");
            sbU.append(this.channelId);
            sbU.append(", messages=");
            sbU.append(this.messages);
            sbU.append(", isInitial=");
            sbU.append(this.isInitial);
            sbU.append(", isPresent=");
            sbU.append(this.isPresent);
            sbU.append(", isAppendingTop=");
            sbU.append(this.isAppendingTop);
            sbU.append(", isJump=");
            return outline.O(sbU, this.isJump, ")");
        }
    }

    /* JADX INFO: compiled from: StoreMessagesLoader.kt */
    public static final /* data */ class ChannelLoadedState {
        private final boolean isInitialMessagesLoaded;
        private final boolean isLoadingMessages;
        private final boolean isOldestMessagesLoaded;
        private final boolean isTouchedSinceLastJump;
        private final Long newestSentByUserMessageId;

        public ChannelLoadedState() {
            this(false, false, false, false, null, 31, null);
        }

        public ChannelLoadedState(boolean z2, boolean z3, boolean z4, boolean z5, Long l) {
            this.isInitialMessagesLoaded = z2;
            this.isOldestMessagesLoaded = z3;
            this.isLoadingMessages = z4;
            this.isTouchedSinceLastJump = z5;
            this.newestSentByUserMessageId = l;
        }

        public static /* synthetic */ ChannelLoadedState copy$default(ChannelLoadedState channelLoadedState, boolean z2, boolean z3, boolean z4, boolean z5, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = channelLoadedState.isInitialMessagesLoaded;
            }
            if ((i & 2) != 0) {
                z3 = channelLoadedState.isOldestMessagesLoaded;
            }
            boolean z6 = z3;
            if ((i & 4) != 0) {
                z4 = channelLoadedState.isLoadingMessages;
            }
            boolean z7 = z4;
            if ((i & 8) != 0) {
                z5 = channelLoadedState.isTouchedSinceLastJump;
            }
            boolean z8 = z5;
            if ((i & 16) != 0) {
                l = channelLoadedState.newestSentByUserMessageId;
            }
            return channelLoadedState.copy(z2, z6, z7, z8, l);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsInitialMessagesLoaded() {
            return this.isInitialMessagesLoaded;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsOldestMessagesLoaded() {
            return this.isOldestMessagesLoaded;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsLoadingMessages() {
            return this.isLoadingMessages;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsTouchedSinceLastJump() {
            return this.isTouchedSinceLastJump;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Long getNewestSentByUserMessageId() {
            return this.newestSentByUserMessageId;
        }

        public final ChannelLoadedState copy(boolean isInitialMessagesLoaded, boolean isOldestMessagesLoaded, boolean isLoadingMessages, boolean isTouchedSinceLastJump, Long newestSentByUserMessageId) {
            return new ChannelLoadedState(isInitialMessagesLoaded, isOldestMessagesLoaded, isLoadingMessages, isTouchedSinceLastJump, newestSentByUserMessageId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChannelLoadedState)) {
                return false;
            }
            ChannelLoadedState channelLoadedState = (ChannelLoadedState) other;
            return this.isInitialMessagesLoaded == channelLoadedState.isInitialMessagesLoaded && this.isOldestMessagesLoaded == channelLoadedState.isOldestMessagesLoaded && this.isLoadingMessages == channelLoadedState.isLoadingMessages && this.isTouchedSinceLastJump == channelLoadedState.isTouchedSinceLastJump && Intrinsics3.areEqual(this.newestSentByUserMessageId, channelLoadedState.newestSentByUserMessageId);
        }

        public final Long getNewestSentByUserMessageId() {
            return this.newestSentByUserMessageId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3, types: [int] */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r2v6 */
        /* JADX WARN: Type inference failed for: r2v7 */
        /* JADX WARN: Type inference failed for: r2v8 */
        public int hashCode() {
            boolean z2 = this.isInitialMessagesLoaded;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            boolean z3 = this.isOldestMessagesLoaded;
            ?? r2 = z3;
            if (z3) {
                r2 = 1;
            }
            int i2 = (i + r2) * 31;
            boolean z4 = this.isLoadingMessages;
            ?? r3 = z4;
            if (z4) {
                r3 = 1;
            }
            int i3 = (i2 + r3) * 31;
            boolean z5 = this.isTouchedSinceLastJump;
            int i4 = (i3 + (z5 ? 1 : z5)) * 31;
            Long l = this.newestSentByUserMessageId;
            return i4 + (l != null ? l.hashCode() : 0);
        }

        public final boolean isInitialMessagesLoaded() {
            return this.isInitialMessagesLoaded;
        }

        public final boolean isLoadingMessages() {
            return this.isLoadingMessages;
        }

        public final boolean isOldestMessagesLoaded() {
            return this.isOldestMessagesLoaded;
        }

        public final boolean isTouchedSinceLastJump() {
            return this.isTouchedSinceLastJump;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ChannelLoadedState(isInitialMessagesLoaded=");
            sbU.append(this.isInitialMessagesLoaded);
            sbU.append(", isOldestMessagesLoaded=");
            sbU.append(this.isOldestMessagesLoaded);
            sbU.append(", isLoadingMessages=");
            sbU.append(this.isLoadingMessages);
            sbU.append(", isTouchedSinceLastJump=");
            sbU.append(this.isTouchedSinceLastJump);
            sbU.append(", newestSentByUserMessageId=");
            return outline.G(sbU, this.newestSentByUserMessageId, ")");
        }

        public /* synthetic */ ChannelLoadedState(boolean z2, boolean z3, boolean z4, boolean z5, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? false : z3, (i & 4) != 0 ? false : z4, (i & 8) == 0 ? z5 : false, (i & 16) != 0 ? null : l);
        }
    }

    /* JADX INFO: compiled from: StoreMessagesLoader.kt */
    public static final class Companion {
        private Companion() {
        }

        public final boolean isScrollToAction(long targetMessageId) {
            return targetMessageId == 0 || targetMessageId == 1;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessagesLoader$handleChannelSelected$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessagesLoader.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ChannelLoadedState, ChannelLoadedState> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final ChannelLoadedState invoke(ChannelLoadedState channelLoadedState) {
            Intrinsics3.checkNotNullParameter(channelLoadedState, "it");
            return ChannelLoadedState.copy$default(channelLoadedState, false, false, false, false, null, 23, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessagesLoader$handleLoadMessagesError$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessagesLoader.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ChannelLoadedState, ChannelLoadedState> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final ChannelLoadedState invoke(ChannelLoadedState channelLoadedState) {
            Intrinsics3.checkNotNullParameter(channelLoadedState, "it");
            return ChannelLoadedState.copy$default(channelLoadedState, false, false, false, false, null, 27, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessagesLoader$handleLoadedMessages$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessagesLoader.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ChannelLoadedState, ChannelLoadedState> {
        public final /* synthetic */ boolean $isAllLoaded;
        public final /* synthetic */ boolean $isAppendingTop;
        public final /* synthetic */ boolean $isInitial;
        public final /* synthetic */ List $messages;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2, boolean z3, boolean z4, List list) {
            super(1);
            this.$isInitial = z2;
            this.$isAppendingTop = z3;
            this.$isAllLoaded = z4;
            this.$messages = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public final ChannelLoadedState invoke(ChannelLoadedState channelLoadedState) {
            Object next;
            User author;
            Intrinsics3.checkNotNullParameter(channelLoadedState, "it");
            boolean zIsInitialMessagesLoaded = this.$isInitial ? true : channelLoadedState.isInitialMessagesLoaded();
            boolean zIsOldestMessagesLoaded = (this.$isInitial || this.$isAppendingTop) ? this.$isAllLoaded : channelLoadedState.isOldestMessagesLoaded();
            Iterator it = this.$messages.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                author = ((Message) next).getAuthor();
            } while (!(author != null && author.getId() == StoreMessagesLoader.this.stream.getUsers().getMeSnapshot().getId()));
            Message message = (Message) next;
            return ChannelLoadedState.copy$default(channelLoadedState, zIsInitialMessagesLoaded, zIsOldestMessagesLoaded, false, false, message != null ? Long.valueOf(message.getId()) : null, 8, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessagesLoader$init$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessagesLoader.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreChat.InteractionState, Unit> {
        public AnonymousClass1(StoreMessagesLoader storeMessagesLoader) {
            super(1, storeMessagesLoader, StoreMessagesLoader.class, "handleChatInteraction", "handleChatInteraction(Lcom/discord/stores/StoreChat$InteractionState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreChat.InteractionState interactionState) {
            invoke2(interactionState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreChat.InteractionState interactionState) {
            Intrinsics3.checkNotNullParameter(interactionState, "p1");
            ((StoreMessagesLoader) this.receiver).handleChatInteraction(interactionState);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessagesLoader$init$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessagesLoader.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Set<? extends Long>, Unit> {
        public AnonymousClass2(StoreMessagesLoader storeMessagesLoader) {
            super(1, storeMessagesLoader, StoreMessagesLoader.class, "handleChatDetached", "handleChatDetached(Ljava/util/Set;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Long> set) {
            invoke2((Set<Long>) set);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Set<Long> set) {
            Intrinsics3.checkNotNullParameter(set, "p1");
            ((StoreMessagesLoader) this.receiver).handleChatDetached(set);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessagesLoader$jumpToMessage$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessagesLoader.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Message, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $messageId;

        /* JADX INFO: renamed from: com.discord.stores.StoreMessagesLoader$jumpToMessage$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreMessagesLoader.kt */
        public static final class C01601 extends Lambda implements Function1<ChannelLoadedState, ChannelLoadedState> {
            public static final C01601 INSTANCE = new C01601();

            public C01601() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ChannelLoadedState invoke(ChannelLoadedState channelLoadedState) {
                Intrinsics3.checkNotNullParameter(channelLoadedState, "it");
                return ChannelLoadedState.copy$default(channelLoadedState, false, false, false, false, null, 29, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(1);
            this.$channelId = j;
            this.$messageId = j2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Message message) {
            invoke2(message);
            return Unit.a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final synchronized void invoke2(Message message) {
            try {
                if (message != null) {
                    StoreMessagesLoader.this.scrollToSubject.k.onNext((T) Long.valueOf(message.getId()));
                } else {
                    StoreMessagesLoader.this.channelLoadedStateUpdate(this.$channelId, C01601.INSTANCE);
                    StoreMessagesLoader.tryLoadMessages$default(StoreMessagesLoader.this, 0L, true, false, false, Long.valueOf(this.$channelId), Long.valueOf(this.$messageId), 9, null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessagesLoader$jumpToMessage$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessagesLoader.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Channel, Unit> {
        public final /* synthetic */ long $channelId;

        /* JADX INFO: renamed from: com.discord.stores.StoreMessagesLoader$jumpToMessage$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreMessagesLoader.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<ChannelLoadedState, ChannelLoadedState> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ChannelLoadedState invoke(ChannelLoadedState channelLoadedState) {
                Intrinsics3.checkNotNullParameter(channelLoadedState, "it");
                return ChannelLoadedState.copy$default(channelLoadedState, true, false, false, false, null, 30, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j) {
            super(1);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final synchronized void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            if (channel.getId() != StoreMessagesLoader.this.selectedChannelId) {
                StoreMessagesLoader.this.channelLoadedStateUpdate(this.$channelId, AnonymousClass1.INSTANCE);
                ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), channel, null, null, 6, null);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessagesLoader$jumpToMessage$3, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessagesLoader.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Long, Boolean> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(long j) {
            super(1);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Long l) {
            return Boolean.valueOf(invoke2(l));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(Long l) {
            return l != null && l.longValue() == this.$channelId;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessagesLoader$jumpToMessage$5, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessagesLoader.kt */
    public static final class AnonymousClass5 extends Lambda implements Function1<Message, Unit> {
        public final /* synthetic */ AnonymousClass1 $handleTargetChannelSelected$1;

        /* JADX INFO: renamed from: com.discord.stores.StoreMessagesLoader$jumpToMessage$5$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreMessagesLoader.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Message $message;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Message message) {
                super(0);
                this.$message = message;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass5.this.$handleTargetChannelSelected$1.invoke2(this.$message);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(AnonymousClass1 anonymousClass1) {
            super(1);
            this.$handleTargetChannelSelected$1 = anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Message message) {
            invoke2(message);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Message message) {
            StoreMessagesLoader.this.dispatcher.schedule(new AnonymousClass1(message));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessagesLoader$jumpToMessage$7, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessagesLoader.kt */
    public static final class AnonymousClass7 extends Lambda implements Function1<Error, Unit> {
        public static final AnonymousClass7 INSTANCE = new AnonymousClass7();

        public AnonymousClass7() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            Logger.w$default(AppLog.g, "Dropped message jump action", null, 2, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessagesLoader$jumpToMessage$8, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessagesLoader.kt */
    public static final /* synthetic */ class AnonymousClass8 extends FunctionReferenceImpl implements Function1<Channel, Unit> {
        public final /* synthetic */ AnonymousClass2 $handleTargetChannelResolved$2;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass8(AnonymousClass2 anonymousClass2) {
            super(1, null, "handleTargetChannelResolved", "invoke(Lcom/discord/api/channel/Channel;)V", 0);
            this.$handleTargetChannelResolved$2 = anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "p1");
            this.$handleTargetChannelResolved$2.invoke2(channel);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessagesLoader$requestNewestMessages$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessagesLoader.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ChannelLoadedState, ChannelLoadedState> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final ChannelLoadedState invoke(ChannelLoadedState channelLoadedState) {
            Intrinsics3.checkNotNullParameter(channelLoadedState, "it");
            return ChannelLoadedState.copy$default(channelLoadedState, false, false, false, false, null, 30, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessagesLoader$tryLoadMessages$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessagesLoader.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            StoreMessagesLoader.tryLoadMessages$default(StoreMessagesLoader.this, 0L, false, false, true, null, null, 55, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessagesLoader$tryLoadMessages$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessagesLoader.kt */
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
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            StoreMessagesLoader.this.delayLoadingMessagesSubscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessagesLoader$tryLoadMessages$3, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessagesLoader.kt */
    public static final class AnonymousClass3 extends Lambda implements Function4<Long, Long, Long, Long, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreMessagesLoader$tryLoadMessages$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreMessagesLoader.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<ChannelLoadedState, ChannelLoadedState> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ChannelLoadedState invoke(ChannelLoadedState channelLoadedState) {
                Intrinsics3.checkNotNullParameter(channelLoadedState, "it");
                return ChannelLoadedState.copy$default(channelLoadedState, false, false, true, false, null, 27, null);
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreMessagesLoader$tryLoadMessages$3$3, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: StoreMessagesLoader.kt */
        public static final class C01613 extends Lambda implements Function1<List<? extends Message>, Unit> {
            public final /* synthetic */ Long $after;
            public final /* synthetic */ Long $before;
            public final /* synthetic */ long $channelId;
            public final /* synthetic */ Long $messageId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01613(long j, Long l, Long l2, Long l3) {
                super(1);
                this.$channelId = j;
                this.$messageId = l;
                this.$before = l2;
                this.$after = l3;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Message> list) {
                invoke2((List<Message>) list);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<Message> list) {
                StoreMessagesLoader storeMessagesLoader = StoreMessagesLoader.this;
                Intrinsics3.checkNotNullExpressionValue(list, "it");
                long j = this.$channelId;
                Long l = this.$messageId;
                storeMessagesLoader.handleLoadedMessages(list, j, l != null ? l.longValue() : 0L, this.$before, this.$after);
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreMessagesLoader$tryLoadMessages$3$4, reason: invalid class name */
        /* JADX INFO: compiled from: StoreMessagesLoader.kt */
        public static final class AnonymousClass4 extends Lambda implements Function1<Error, Unit> {
            public final /* synthetic */ long $channelId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass4(long j) {
                super(1);
                this.$channelId = j;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                Intrinsics3.checkNotNullParameter(error, "it");
                StoreMessagesLoader.this.handleLoadMessagesError(this.$channelId);
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreMessagesLoader$tryLoadMessages$3$5, reason: invalid class name */
        /* JADX INFO: compiled from: StoreMessagesLoader.kt */
        public static final class AnonymousClass5 extends Lambda implements Function1<Subscription, Unit> {
            public AnonymousClass5() {
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
                StoreMessagesLoader.this.loadingMessagesSubscription = subscription;
            }
        }

        public AnonymousClass3() {
            super(4);
        }

        public static /* synthetic */ void invoke$default(AnonymousClass3 anonymousClass3, long j, Long l, Long l2, Long l3, int i, Object obj) {
            anonymousClass3.invoke(j, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : l2, (i & 8) != 0 ? null : l3);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2, Long l3, Long l4) {
            invoke(l.longValue(), l2, l3, l4);
            return Unit.a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final synchronized void invoke(long j, Long l, Long l2, Long l3) {
            Observable<List<com.discord.api.message.Message>> channelMessages;
            StoreMessagesLoader.this.channelLoadedStateUpdate(j, AnonymousClass1.INSTANCE);
            if (l == null || l.longValue() != 1) {
                if (l == null || l.longValue() != 0) {
                    if (l != null) {
                        channelMessages = RestAPI.INSTANCE.getApi().getChannelMessagesAround(j, StoreMessagesLoader.this.messageRequestSize, l.longValue());
                    }
                    StoreMessagesLoader.this.channelMessagesLoadingSubject.k.onNext((T) Boolean.TRUE);
                    Observable observableG = ObservableExtensionsKt.restSubscribeOn(channelMessages, false).G(new Func1<List<? extends com.discord.api.message.Message>, List<? extends Message>>() { // from class: com.discord.stores.StoreMessagesLoader.tryLoadMessages.3.2
                        @Override // j0.k.Func1
                        public /* bridge */ /* synthetic */ List<? extends Message> call(List<? extends com.discord.api.message.Message> list) {
                            return call2((List<com.discord.api.message.Message>) list);
                        }

                        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                        public final List<Message> call2(List<com.discord.api.message.Message> list) {
                            Intrinsics3.checkNotNullExpressionValue(list, "messages");
                            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                            Iterator<T> it = list.iterator();
                            while (it.hasNext()) {
                                arrayList.add(new Message((com.discord.api.message.Message) it.next()));
                            }
                            return arrayList;
                        }
                    });
                    Intrinsics3.checkNotNullExpressionValue(observableG, "messagesRequest\n        …messages.map(::Message) }");
                    Observable observableComputationLatest = ObservableExtensionsKt.computationLatest(observableG);
                    Class<?> cls = StoreMessagesLoader.this.getClass();
                    ObservableExtensionsKt.appSubscribe(observableComputationLatest, (Class<?>) cls, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass5()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass4(j)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new C01613(j, l, l2, l3));
                }
            }
            channelMessages = RestAPI.INSTANCE.getApi().getChannelMessages(j, l2, l3, Integer.valueOf(StoreMessagesLoader.this.messageRequestSize));
            StoreMessagesLoader.this.channelMessagesLoadingSubject.k.onNext((T) Boolean.TRUE);
            Observable observableG2 = ObservableExtensionsKt.restSubscribeOn(channelMessages, false).G(new Func1<List<? extends com.discord.api.message.Message>, List<? extends Message>>() { // from class: com.discord.stores.StoreMessagesLoader.tryLoadMessages.3.2
                @Override // j0.k.Func1
                public /* bridge */ /* synthetic */ List<? extends Message> call(List<? extends com.discord.api.message.Message> list) {
                    return call2((List<com.discord.api.message.Message>) list);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final List<Message> call2(List<com.discord.api.message.Message> list) {
                    Intrinsics3.checkNotNullExpressionValue(list, "messages");
                    ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new Message((com.discord.api.message.Message) it.next()));
                    }
                    return arrayList;
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableG2, "messagesRequest\n        …messages.map(::Message) }");
            Observable observableComputationLatest2 = ObservableExtensionsKt.computationLatest(observableG2);
            Class<?> cls2 = StoreMessagesLoader.this.getClass();
            ObservableExtensionsKt.appSubscribe(observableComputationLatest2, (Class<?>) cls2, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass5()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass4(j)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new C01613(j, l, l2, l3));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreMessagesLoader$tryLoadMessages$4, reason: invalid class name */
    /* JADX INFO: compiled from: StoreMessagesLoader.kt */
    public static final class AnonymousClass4 extends Lambda implements Function4<Long, List<? extends Message>, Boolean, Boolean, Unit> {
        public final /* synthetic */ AnonymousClass3 $loadMessages$3;

        /* JADX INFO: renamed from: com.discord.stores.StoreMessagesLoader$tryLoadMessages$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreMessagesLoader.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<ChannelLoadedState, ChannelLoadedState> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final ChannelLoadedState invoke(ChannelLoadedState channelLoadedState) {
                Intrinsics3.checkNotNullParameter(channelLoadedState, "it");
                return ChannelLoadedState.copy$default(channelLoadedState, false, false, false, false, null, 27, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(AnonymousClass3 anonymousClass3) {
            super(4);
            this.$loadMessages$3 = anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(Long l, List<? extends Message> list, Boolean bool, Boolean bool2) {
            invoke(l.longValue(), (List<Message>) list, bool.booleanValue(), bool2.booleanValue());
            return Unit.a;
        }

        public final synchronized void invoke(long j, List<Message> list, boolean z2, boolean z3) {
            Intrinsics3.checkNotNullParameter(list, "messages");
            if (list.isEmpty()) {
                StoreMessagesLoader.this.channelLoadedStateUpdate(j, AnonymousClass1.INSTANCE);
                return;
            }
            if (z2) {
                AnonymousClass3.invoke$default(this.$loadMessages$3, j, null, Long.valueOf(list.get(0).getId()), null, 10, null);
            } else if (z3) {
                AnonymousClass3.invoke$default(this.$loadMessages$3, j, null, null, Long.valueOf(list.get(list.size() - 1).getId()), 6, null);
            }
        }
    }

    public StoreMessagesLoader(StoreStream storeStream, Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.messageRequestSize = 50;
        this.channelMessageChunksSubject = new SerializedSubject<>(BehaviorSubject.k0());
        HashMap<Long, ChannelLoadedState> map = new HashMap<>();
        this.channelLoadedStates = map;
        this.channelLoadedStateSubject = new SerializedSubject<>(BehaviorSubject.l0(new HashMap(map)));
        this.scrollToSubject = new SerializedSubject<>(BehaviorSubject.l0(null));
        this.channelMessagesLoadingSubject = new SerializedSubject<>(BehaviorSubject.l0(Boolean.FALSE));
        this.detachedChannels = Sets5.emptySet();
        this.backgrounded = true;
        this.loadingMessagesRetryDelayDefault = 1500L;
        this.loadingMessagesRetryJitter = 2000;
        this.loadingMessagesRetryDelayMillis = 1500L;
        this.loadingMessagesRetryMax = 30000;
    }

    private final synchronized void channelLoadedStateUpdate(long channelId, Function1<? super ChannelLoadedState, ChannelLoadedState> updater) {
        ChannelLoadedState channelLoadedState = this.channelLoadedStates.get(Long.valueOf(channelId));
        if (channelLoadedState == null) {
            channelLoadedState = new ChannelLoadedState(false, false, false, false, null, 31, null);
        }
        Intrinsics3.checkNotNullExpressionValue(channelLoadedState, "channelLoadedStates[chan…] ?: ChannelLoadedState()");
        this.channelLoadedStates.put(Long.valueOf(channelId), updater.invoke(channelLoadedState));
        SerializedSubject<Map<Long, ChannelLoadedState>, Map<Long, ChannelLoadedState>> serializedSubject = this.channelLoadedStateSubject;
        serializedSubject.k.onNext(new HashMap(this.channelLoadedStates));
    }

    private final void channelLoadedStatesReset() {
        this.channelLoadedStates.clear();
        SerializedSubject<Map<Long, ChannelLoadedState>, Map<Long, ChannelLoadedState>> serializedSubject = this.channelLoadedStateSubject;
        serializedSubject.k.onNext(new HashMap(this.channelLoadedStates));
        Subscription subscription = this.loadingMessagesSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.loadingMessagesRetryDelayMillis = this.loadingMessagesRetryDelayDefault;
        log("Disconnected, resetting all message loaded states.");
    }

    private final synchronized void handleChatDetached(Set<Long> detachedChannels) {
        this.detachedChannels = detachedChannels;
        log("Loaded detached channel state: " + detachedChannels);
        tryLoadMessages$default(this, 0L, false, true, false, null, null, 59, null);
    }

    private final synchronized void handleChatInteraction(StoreChat.InteractionState interactionState) {
        channelLoadedStateUpdate(interactionState.getChannelId(), new StoreMessagesLoader2(interactionState));
        this.interactionState = interactionState;
        tryLoadMessages$default(this, 0L, false, true, false, null, null, 59, null);
    }

    private final synchronized void handleLoadMessagesError(long channelId) {
        channelLoadedStateUpdate(channelId, AnonymousClass1.INSTANCE);
        long j = this.loadingMessagesRetryDelayMillis;
        if (j < this.loadingMessagesRetryMax) {
            this.loadingMessagesRetryDelayMillis = (j * ((long) 2)) + ((long) new Random().nextInt(this.loadingMessagesRetryJitter));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to load messages for channel [" + channelId + "], ");
        sb.append("retrying in " + this.loadingMessagesRetryDelayMillis + "ms");
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder()\n        …}ms\")\n        .toString()");
        log(string);
        tryLoadMessages$default(this, this.loadingMessagesRetryDelayMillis, false, false, false, null, null, 58, null);
    }

    private final synchronized void handleLoadedMessages(List<Message> messages, long channelId, long messageId, Long before, Long after) {
        Object next;
        boolean z2 = messages.size() < this.messageRequestSize;
        boolean z3 = after != null;
        boolean z4 = before != null;
        boolean z5 = !INSTANCE.isScrollToAction(messageId);
        boolean z6 = (z5 || z3 || z4) ? false : true;
        boolean z7 = z6 || (z3 && z2);
        channelLoadedStateUpdate(channelId, new AnonymousClass1(z6, z4, z2, messages));
        this.channelMessagesLoadingSubject.k.onNext(Boolean.FALSE);
        this.channelMessageChunksSubject.k.onNext(new ChannelChunk(channelId, messages, z6, z7, z4, z5));
        boolean z8 = z6 && (messages.isEmpty() ^ true) && messageId == 1;
        if (z8) {
            this.scrollToSubject.k.onNext(1L);
        } else if (z6) {
            this.scrollToSubject.k.onNext(0L);
        }
        if (z5) {
            Iterator<T> it = messages.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!(((Message) next).getId() == messageId));
            Message message = (Message) next;
            if (message == null) {
                StoreStream.INSTANCE.getReadStates().markAsRead(Long.valueOf(channelId));
            } else {
                this.scrollToSubject.k.onNext(Long.valueOf(message.getId()));
            }
        }
        if (!z5 && !z8) {
            clearScrollTo();
        }
        log("Loaded " + messages.size() + " messages for channel [" + channelId + "], all loaded: " + z2 + '.');
        tryLoadMessages$default(this, this.loadingMessagesRetryDelayDefault, false, false, false, null, null, 58, null);
    }

    private final void log(String message) {
        AppLog.i("[MessageLoader] " + message);
    }

    private final synchronized void tryLoadMessages(long delay, boolean force, boolean resetRetry, boolean resetDelay, Long targetChannelId, Long targetMessageId) {
        try {
            long jLongValue = targetChannelId != null ? targetChannelId.longValue() : this.selectedChannelId;
            Subscription subscription = this.delayLoadingMessagesSubscription;
            if (subscription != null && resetDelay) {
                if (subscription != null) {
                    subscription.unsubscribe();
                }
                this.delayLoadingMessagesSubscription = null;
            }
            if (this.delayLoadingMessagesSubscription == null || force) {
                if (delay > 0) {
                    Observable<Long> observableD0 = Observable.d0(delay, TimeUnit.MILLISECONDS);
                    Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable\n          .ti…y, TimeUnit.MILLISECONDS)");
                    ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.computationBuffered(observableD0), (Class<?>) getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass2()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
                    return;
                }
                if (resetRetry) {
                    this.loadingMessagesRetryDelayMillis = this.loadingMessagesRetryDelayDefault;
                }
                ChannelLoadedState channelLoadedState = this.channelLoadedStates.get(Long.valueOf(jLongValue));
                if (channelLoadedState == null || !channelLoadedState.isLoadingMessages() || force) {
                    Subscription subscription2 = this.loadingMessagesSubscription;
                    if (subscription2 != null) {
                        subscription2.unsubscribe();
                    }
                    if (jLongValue > 0 && !this.backgrounded && this.authed) {
                        AnonymousClass3 anonymousClass3 = new AnonymousClass3();
                        AnonymousClass4 anonymousClass4 = new AnonymousClass4(anonymousClass3);
                        if (targetMessageId != null) {
                            AnonymousClass3.invoke$default(anonymousClass3, jLongValue, targetMessageId, null, null, 12, null);
                        } else if (channelLoadedState == null || !channelLoadedState.isInitialMessagesLoaded()) {
                            AnonymousClass3.invoke$default(anonymousClass3, jLongValue, 0L, null, null, 12, null);
                        } else {
                            this.channelMessagesLoadingSubject.k.onNext(Boolean.FALSE);
                            StoreChat.InteractionState interactionState = this.interactionState;
                            if (interactionState != null) {
                                boolean z2 = false;
                                boolean z3 = interactionState.getIsAtTop() && !channelLoadedState.isOldestMessagesLoaded();
                                if (interactionState.getIsAtBottom() && this.detachedChannels.contains(Long.valueOf(jLongValue))) {
                                    z2 = true;
                                }
                                if (interactionState.getChannelId() == jLongValue && (z3 || z2)) {
                                    channelLoadedStateUpdate(jLongValue, StoreMessagesLoader5.INSTANCE);
                                    ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.computationBuffered(ObservableExtensionsKt.takeSingleUntilTimeout$default(this.stream.getMessages().observeMessagesForChannel(jLongValue), 0L, false, 3, null)), (Class<?>) interactionState.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new StoreMessagesLoader4(this, channelLoadedState, jLongValue, anonymousClass4)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new StoreMessagesLoader3(z3, z2, this, channelLoadedState, jLongValue, anonymousClass4));
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static /* synthetic */ void tryLoadMessages$default(StoreMessagesLoader storeMessagesLoader, long j, boolean z2, boolean z3, boolean z4, Long l, Long l2, int i, Object obj) {
        storeMessagesLoader.tryLoadMessages((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) == 0 ? z4 : false, (i & 16) != 0 ? null : l, (i & 32) == 0 ? l2 : null);
    }

    public final void clearScrollTo() {
        this.scrollToSubject.k.onNext(null);
    }

    public final Observable<ChannelChunk> get() {
        return ObservableExtensionsKt.computationBuffered(this.channelMessageChunksSubject);
    }

    public final Observable<ChannelLoadedState> getMessagesLoadedState(final long channelId) {
        Observable<R> observableG = this.channelLoadedStateSubject.G(new Func1<Map<Long, ? extends ChannelLoadedState>, ChannelLoadedState>() { // from class: com.discord.stores.StoreMessagesLoader.getMessagesLoadedState.1
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ ChannelLoadedState call(Map<Long, ? extends ChannelLoadedState> map) {
                return call2((Map<Long, ChannelLoadedState>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final ChannelLoadedState call2(Map<Long, ChannelLoadedState> map) {
                ChannelLoadedState channelLoadedState = map.get(Long.valueOf(channelId));
                return channelLoadedState != null ? channelLoadedState : new ChannelLoadedState(false, false, false, false, null, 31, null);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableG, "channelLoadedStateSubjec…?: ChannelLoadedState() }");
        Observable<ChannelLoadedState> observableR = ObservableExtensionsKt.computationLatest(observableG).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "channelLoadedStateSubjec…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Long> getScrollTo() {
        Observable<R> observableG = this.scrollToSubject.y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        return ObservableExtensionsKt.computationLatest(observableG);
    }

    public final synchronized void handleAuthToken(String authToken) {
        this.authed = authToken != null;
        tryLoadMessages$default(this, 0L, false, true, false, null, null, 59, null);
    }

    public final synchronized void handleBackgrounded(boolean backgrounded) {
        this.backgrounded = backgrounded;
        tryLoadMessages$default(this, 0L, false, true, false, null, null, 59, null);
    }

    @Store3
    public final synchronized void handleChannelSelected(long selectedChannelId) {
        channelLoadedStateUpdate(this.selectedChannelId, AnonymousClass1.INSTANCE);
        this.selectedChannelId = selectedChannelId;
        tryLoadMessages$default(this, 0L, true, true, false, null, null, 57, null);
    }

    public final synchronized void handleConnected(boolean connected) {
        try {
            if (connected) {
                this.hasConnected = true;
            } else if (this.hasConnected) {
                channelLoadedStatesReset();
            }
            tryLoadMessages$default(this, 0L, false, true, this.hasConnected, null, null, 51, null);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Store3
    public final synchronized void handleVoiceChannelJoined(long selectedVoiceChannelId) {
        tryLoadMessages$default(this, 0L, true, true, false, Long.valueOf(selectedVoiceChannelId), null, 41, null);
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.computationLatest(this.stream.getChat().observeInteractionState()), (Class<?>) StoreMessagesLoader.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
        ObservableExtensionsKt.appSubscribe(this.stream.getMessages().getAllDetached(), (Class<?>) StoreMessagesLoader.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(this));
    }

    public final synchronized void jumpToMessage(final long channelId, final long messageId) {
        if (messageId <= 0) {
            return;
        }
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(channelId, messageId);
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(channelId);
        Observable observableY = this.stream.getChannelsSelected().observeId().k(o.c(new AnonymousClass3(channelId), -1L, 1000L, TimeUnit.MILLISECONDS)).Y(new Func1<Long, Observable<? extends Message>>() { // from class: com.discord.stores.StoreMessagesLoader.jumpToMessage.4
            @Override // j0.k.Func1
            public final Observable<? extends Message> call(Long l) {
                return StoreMessagesLoader.this.stream.getMessages().observeMessagesForChannel(channelId, messageId);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableY, "stream\n        .channels…lId, messageId)\n        }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableY, 0L, false, 3, null)), (Class<?>) getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass5(anonymousClass1));
        Observable observableA = StoreConnectionOpen.observeConnectionOpen$default(this.stream.getConnectionOpen(), false, 1, null).Z(1).A(new Func1<Boolean, Observable<? extends Channel>>() { // from class: com.discord.stores.StoreMessagesLoader.jumpToMessage.6
            @Override // j0.k.Func1
            public final Observable<? extends Channel> call(Boolean bool) {
                Intrinsics3.checkNotNullExpressionValue(bool, "isConnected");
                int i = bool.booleanValue() ? 1 : 3;
                Observable<R> observableG = StoreMessagesLoader.this.stream.getChannels().observeChannel(channelId).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
                return ObservableExtensionsKt.takeSingleUntilTimeout$default(observableG, 1000 * ((long) i), false, 2, null);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableA, "stream\n        .connecti…mes.ONE_SECOND)\n        }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.computationLatest(observableA), (Class<?>) getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : AnonymousClass7.INSTANCE), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass8(anonymousClass2));
    }

    public final Observable<Boolean> observeChannelMessagesLoading() {
        Observable<Boolean> observableR = ObservableExtensionsKt.computationBuffered(this.channelMessagesLoadingSubject).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "channelMessagesLoadingSu…  .distinctUntilChanged()");
        return observableR;
    }

    public final synchronized void requestNewestMessages() {
        ChannelLoadedState channelLoadedState;
        if (!this.detachedChannels.contains(Long.valueOf(this.selectedChannelId)) && (channelLoadedState = this.channelLoadedStates.get(Long.valueOf(this.selectedChannelId))) != null && channelLoadedState.isInitialMessagesLoaded()) {
            this.scrollToSubject.k.onNext(1L);
        } else {
            channelLoadedStateUpdate(this.selectedChannelId, AnonymousClass1.INSTANCE);
            tryLoadMessages$default(this, 0L, true, false, false, null, 1L, 25, null);
        }
    }
}
