package com.discord.stores;

import a0.a.a.b;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import b.d.b.a.outline;
import com.discord.models.message.Message;
import com.discord.models.user.User;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: StoreChat.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChat extends StoreV2 {
    private final Dispatcher dispatcher;
    private EditingMessage editingMessage;
    private final PublishSubject<Event> eventSubject;
    private final List<Long> expandedBlockedMessageGroups;
    private List<Long> expandedBlockedMessageGroupsSnapshot;
    private InteractionState interactionState;
    private final ObservationDeck observationDeck;

    /* JADX INFO: compiled from: StoreChat.kt */
    public static final /* data */ class EditingMessage {
        private final CharSequence content;
        private final Message message;

        public EditingMessage(Message message, CharSequence charSequence) {
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(charSequence, "content");
            this.message = message;
            this.content = charSequence;
        }

        public static /* synthetic */ EditingMessage copy$default(EditingMessage editingMessage, Message message, CharSequence charSequence, int i, Object obj) {
            if ((i & 1) != 0) {
                message = editingMessage.message;
            }
            if ((i & 2) != 0) {
                charSequence = editingMessage.content;
            }
            return editingMessage.copy(message, charSequence);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Message getMessage() {
            return this.message;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final CharSequence getContent() {
            return this.content;
        }

        public final EditingMessage copy(Message message, CharSequence content) {
            Intrinsics3.checkNotNullParameter(message, "message");
            Intrinsics3.checkNotNullParameter(content, "content");
            return new EditingMessage(message, content);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EditingMessage)) {
                return false;
            }
            EditingMessage editingMessage = (EditingMessage) other;
            return Intrinsics3.areEqual(this.message, editingMessage.message) && Intrinsics3.areEqual(this.content, editingMessage.content);
        }

        public final CharSequence getContent() {
            return this.content;
        }

        public final Message getMessage() {
            return this.message;
        }

        public int hashCode() {
            Message message = this.message;
            int iHashCode = (message != null ? message.hashCode() : 0) * 31;
            CharSequence charSequence = this.content;
            return iHashCode + (charSequence != null ? charSequence.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("EditingMessage(message=");
            sbU.append(this.message);
            sbU.append(", content=");
            return outline.E(sbU, this.content, ")");
        }
    }

    /* JADX INFO: compiled from: StoreChat.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: StoreChat.kt */
        public static final /* data */ class AppendChatText extends Event {
            private final String text;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AppendChatText(String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                this.text = str;
            }

            public static /* synthetic */ AppendChatText copy$default(AppendChatText appendChatText, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = appendChatText.text;
                }
                return appendChatText.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getText() {
                return this.text;
            }

            public final AppendChatText copy(String text) {
                Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                return new AppendChatText(text);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof AppendChatText) && Intrinsics3.areEqual(this.text, ((AppendChatText) other).text);
                }
                return true;
            }

            public final String getText() {
                return this.text;
            }

            public int hashCode() {
                String str = this.text;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.J(outline.U("AppendChatText(text="), this.text, ")");
            }
        }

        /* JADX INFO: compiled from: StoreChat.kt */
        public static final /* data */ class ReplaceChatText extends Event {
            private final String text;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReplaceChatText(String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                this.text = str;
            }

            public static /* synthetic */ ReplaceChatText copy$default(ReplaceChatText replaceChatText, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = replaceChatText.text;
                }
                return replaceChatText.copy(str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getText() {
                return this.text;
            }

            public final ReplaceChatText copy(String text) {
                Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
                return new ReplaceChatText(text);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof ReplaceChatText) && Intrinsics3.areEqual(this.text, ((ReplaceChatText) other).text);
                }
                return true;
            }

            public final String getText() {
                return this.text;
            }

            public int hashCode() {
                String str = this.text;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            public String toString() {
                return outline.J(outline.U("ReplaceChatText(text="), this.text, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreChat$observeEditingMessage$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreChat.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<EditingMessage> {
        public AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final EditingMessage invoke() {
            return StoreChat.this.getEditingMessage();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreChat$observeExpandedBlockedMessageIds$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreChat.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<List<? extends Long>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends Long> invoke() {
            return StoreChat.this.getExpandedBlockedMessageGroups();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreChat$observeInteractionState$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreChat.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<InteractionState> {
        public AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final InteractionState invoke() {
            return StoreChat.this.getInteractionState();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreChat$setEditingMessage$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreChat.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ EditingMessage $editingMessage;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(EditingMessage editingMessage) {
            super(0);
            this.$editingMessage = editingMessage;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreChat.this.editingMessage = this.$editingMessage;
            StoreChat.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreChat$setInteractionState$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreChat.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ InteractionState $interactionState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(InteractionState interactionState) {
            super(0);
            this.$interactionState = interactionState;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreChat.this.interactionState = this.$interactionState;
            StoreChat.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreChat$toggleBlockedMessageGroup$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreChat.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $messageId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$messageId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreChat.this.expandedBlockedMessageGroups.contains(Long.valueOf(this.$messageId))) {
                StoreChat.this.expandedBlockedMessageGroups.remove(Long.valueOf(this.$messageId));
            } else {
                StoreChat.this.expandedBlockedMessageGroups.add(Long.valueOf(this.$messageId));
            }
            StoreChat.this.markChanged();
        }
    }

    public /* synthetic */ StoreChat(Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public final void appendMention(User user, long guildId) {
        if (user != null) {
            if (user.getUsername().length() == 0) {
                return;
            }
            StoreGatewayConnection.requestGuildMembers$default(StoreStream.INSTANCE.getGatewaySocket(), guildId, user.getUsername(), null, null, 12, null);
            StringBuilder sbU = outline.U("@");
            sbU.append(user.getUsername());
            sbU.append(UserUtils.INSTANCE.getDiscriminatorWithPadding(user));
            String string = sbU.toString();
            this.eventSubject.k.onNext(new Event.AppendChatText(string + ' '));
        }
    }

    public final EditingMessage getEditingMessage() {
        return this.editingMessage;
    }

    public final List<Long> getExpandedBlockedMessageGroups() {
        return this.expandedBlockedMessageGroupsSnapshot;
    }

    public final InteractionState getInteractionState() {
        return this.interactionState;
    }

    public final Observable<EditingMessage> observeEditingMessage() {
        Observable<EditingMessage> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final Observable<List<Long>> observeExpandedBlockedMessageIds() {
        Observable<List<Long>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<InteractionState> observeInteractionState() {
        Observable observableG = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable<InteractionState> observableR = observableG.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final void replaceChatText(String text) {
        Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        this.eventSubject.k.onNext(new Event.ReplaceChatText(text + ' '));
    }

    public final void setEditingMessage(EditingMessage editingMessage) {
        this.dispatcher.schedule(new AnonymousClass1(editingMessage));
    }

    public final void setInteractionState(InteractionState interactionState) {
        Intrinsics3.checkNotNullParameter(interactionState, "interactionState");
        this.dispatcher.schedule(new AnonymousClass1(interactionState));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.expandedBlockedMessageGroupsSnapshot = new ArrayList(this.expandedBlockedMessageGroups);
    }

    public final void toggleBlockedMessageGroup(long messageId) {
        this.dispatcher.schedule(new AnonymousClass1(messageId));
    }

    public StoreChat(Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.expandedBlockedMessageGroups = new ArrayList();
        this.expandedBlockedMessageGroupsSnapshot = Collections2.emptyList();
        this.eventSubject = PublishSubject.k0();
    }

    /* JADX INFO: compiled from: StoreChat.kt */
    public static final /* data */ class InteractionState {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final int NEAR_EDGE_THRESHOLD = 15;
        private static final int SCROLLED = 0;
        private static final int SCROLLED_BOTTOM = 1;
        private static final int SCROLLED_NEAR_BOTTOM = 4;
        private static final int SCROLLED_TOP = 2;
        private final long channelId;
        private final boolean isAtBottom;
        private final boolean isAtTop;
        private final boolean isTouchedSinceLastJump;
        private final long lastMessageId;

        /* JADX INFO: renamed from: scrollState$1, reason: from kotlin metadata */
        private final int scrollState;

        /* JADX INFO: compiled from: StoreChat.kt */
        public static final class Companion {
            private Companion() {
            }

            private final int getScrollState(LinearLayoutManager linearLayoutManager) {
                if (linearLayoutManager == null) {
                    return 0;
                }
                int itemCount = linearLayoutManager.getItemCount() - 1;
                int iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                int iMax = Math.max(0, itemCount - 15);
                int iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                boolean z2 = 1 <= iFindFirstVisibleItemPosition && 15 >= iFindFirstVisibleItemPosition;
                int i = iFindFirstVisibleItemPosition <= 0 ? 1 : 0;
                if (iFindLastVisibleItemPosition == itemCount || iFindLastVisibleItemPosition >= iMax) {
                    i |= 2;
                }
                return z2 ? i | 4 : i;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public InteractionState(long j, long j2, boolean z2, int i) {
            this.channelId = j;
            this.lastMessageId = j2;
            this.isTouchedSinceLastJump = z2;
            this.scrollState = i;
            this.isAtTop = z2 && isAtTopIgnoringTouch();
            this.isAtBottom = z2 && isAtBottomIgnoringTouch();
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        private final int getScrollState() {
            return this.scrollState;
        }

        public static /* synthetic */ InteractionState copy$default(InteractionState interactionState, long j, long j2, boolean z2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = interactionState.channelId;
            }
            long j3 = j;
            if ((i2 & 2) != 0) {
                j2 = interactionState.lastMessageId;
            }
            long j4 = j2;
            if ((i2 & 4) != 0) {
                z2 = interactionState.isTouchedSinceLastJump;
            }
            boolean z3 = z2;
            if ((i2 & 8) != 0) {
                i = interactionState.scrollState;
            }
            return interactionState.copy(j3, j4, z3, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final long getLastMessageId() {
            return this.lastMessageId;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsTouchedSinceLastJump() {
            return this.isTouchedSinceLastJump;
        }

        public final InteractionState copy(long channelId, long lastMessageId, boolean isTouchedSinceLastJump, int scrollState) {
            return new InteractionState(channelId, lastMessageId, isTouchedSinceLastJump, scrollState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InteractionState)) {
                return false;
            }
            InteractionState interactionState = (InteractionState) other;
            return this.channelId == interactionState.channelId && this.lastMessageId == interactionState.lastMessageId && this.isTouchedSinceLastJump == interactionState.isTouchedSinceLastJump && this.scrollState == interactionState.scrollState;
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final long getLastMessageId() {
            return this.lastMessageId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r1v4, types: [int] */
        public int hashCode() {
            int iA = (b.a(this.lastMessageId) + (b.a(this.channelId) * 31)) * 31;
            boolean z2 = this.isTouchedSinceLastJump;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            return ((iA + r0) * 31) + this.scrollState;
        }

        /* JADX INFO: renamed from: isAtBottom, reason: from getter */
        public final boolean getIsAtBottom() {
            return this.isAtBottom;
        }

        public final boolean isAtBottomIgnoringTouch() {
            return (this.scrollState & 1) != 0;
        }

        /* JADX INFO: renamed from: isAtTop, reason: from getter */
        public final boolean getIsAtTop() {
            return this.isAtTop;
        }

        public final boolean isAtTopIgnoringTouch() {
            return (this.scrollState & 2) != 0;
        }

        public final boolean isNearBottomIgnoringTouch() {
            return (this.scrollState & 4) != 0;
        }

        public final boolean isTouchedSinceLastJump() {
            return this.isTouchedSinceLastJump;
        }

        public String toString() {
            StringBuilder sbU = outline.U("InteractionState(channelId=");
            sbU.append(this.channelId);
            sbU.append(", lastMessageId=");
            sbU.append(this.lastMessageId);
            sbU.append(", isTouchedSinceLastJump=");
            sbU.append(this.isTouchedSinceLastJump);
            sbU.append(", scrollState=");
            return outline.B(sbU, this.scrollState, ")");
        }

        public InteractionState(long j, long j2, boolean z2, LinearLayoutManager linearLayoutManager) {
            this(j, j2, z2, INSTANCE.getScrollState(linearLayoutManager));
        }
    }
}
