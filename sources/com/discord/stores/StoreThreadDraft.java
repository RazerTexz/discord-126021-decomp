package com.discord.stores;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: StoreThreadDraft.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreThreadDraft extends StoreV2 {
    private final Dispatcher dispatcher;
    private final BehaviorSubject<ThreadDraftState> draftStateSubject;

    /* JADX INFO: compiled from: StoreThreadDraft.kt */
    public static final /* data */ class ThreadDraftState {
        private final Integer autoArchiveDuration;
        private final boolean isPrivate;
        private final boolean isSending;
        private final boolean shouldDisplayNameError;
        private final String threadName;

        public ThreadDraftState() {
            this(false, null, null, false, false, 31, null);
        }

        public ThreadDraftState(boolean z2, Integer num, String str, boolean z3, boolean z4) {
            this.isPrivate = z2;
            this.autoArchiveDuration = num;
            this.threadName = str;
            this.isSending = z3;
            this.shouldDisplayNameError = z4;
        }

        public static /* synthetic */ ThreadDraftState copy$default(ThreadDraftState threadDraftState, boolean z2, Integer num, String str, boolean z3, boolean z4, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = threadDraftState.isPrivate;
            }
            if ((i & 2) != 0) {
                num = threadDraftState.autoArchiveDuration;
            }
            Integer num2 = num;
            if ((i & 4) != 0) {
                str = threadDraftState.threadName;
            }
            String str2 = str;
            if ((i & 8) != 0) {
                z3 = threadDraftState.isSending;
            }
            boolean z5 = z3;
            if ((i & 16) != 0) {
                z4 = threadDraftState.shouldDisplayNameError;
            }
            return threadDraftState.copy(z2, num2, str2, z5, z4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsPrivate() {
            return this.isPrivate;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Integer getAutoArchiveDuration() {
            return this.autoArchiveDuration;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getThreadName() {
            return this.threadName;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsSending() {
            return this.isSending;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getShouldDisplayNameError() {
            return this.shouldDisplayNameError;
        }

        public final ThreadDraftState copy(boolean isPrivate, Integer autoArchiveDuration, String threadName, boolean isSending, boolean shouldDisplayNameError) {
            return new ThreadDraftState(isPrivate, autoArchiveDuration, threadName, isSending, shouldDisplayNameError);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ThreadDraftState)) {
                return false;
            }
            ThreadDraftState threadDraftState = (ThreadDraftState) other;
            return this.isPrivate == threadDraftState.isPrivate && C12238m.areEqual(this.autoArchiveDuration, threadDraftState.autoArchiveDuration) && C12238m.areEqual(this.threadName, threadDraftState.threadName) && this.isSending == threadDraftState.isSending && this.shouldDisplayNameError == threadDraftState.shouldDisplayNameError;
        }

        public final Integer getAutoArchiveDuration() {
            return this.autoArchiveDuration;
        }

        public final boolean getShouldDisplayNameError() {
            return this.shouldDisplayNameError;
        }

        public final String getThreadName() {
            return this.threadName;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r2v5, types: [int] */
        /* JADX WARN: Type inference failed for: r2v7 */
        /* JADX WARN: Type inference failed for: r2v9 */
        public int hashCode() {
            boolean z2 = this.isPrivate;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            Integer num = this.autoArchiveDuration;
            int iHashCode = (i + (num != null ? num.hashCode() : 0)) * 31;
            String str = this.threadName;
            int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
            boolean z3 = this.isSending;
            ?? r2 = z3;
            if (z3) {
                r2 = 1;
            }
            int i2 = (iHashCode2 + r2) * 31;
            boolean z4 = this.shouldDisplayNameError;
            return i2 + (z4 ? 1 : z4);
        }

        public final boolean isPrivate() {
            return this.isPrivate;
        }

        public final boolean isSending() {
            return this.isSending;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ThreadDraftState(isPrivate=");
            sbM833U.append(this.isPrivate);
            sbM833U.append(", autoArchiveDuration=");
            sbM833U.append(this.autoArchiveDuration);
            sbM833U.append(", threadName=");
            sbM833U.append(this.threadName);
            sbM833U.append(", isSending=");
            sbM833U.append(this.isSending);
            sbM833U.append(", shouldDisplayNameError=");
            return C1643a.m827O(sbM833U, this.shouldDisplayNameError, ")");
        }

        public /* synthetic */ ThreadDraftState(boolean z2, Integer num, String str, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? null : num, (i & 4) == 0 ? str : null, (i & 8) != 0 ? false : z3, (i & 16) != 0 ? false : z4);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreThreadDraft$clearDraftState$1 */
    /* JADX INFO: compiled from: StoreThreadDraft.kt */
    public static final class C65291 extends AbstractC12240o implements Function0<Unit> {
        public C65291() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreThreadDraft.this.draftStateSubject.onNext(new ThreadDraftState(false, null, null, false, false, 31, null));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreThreadDraft$setDraftSending$1 */
    /* JADX INFO: compiled from: StoreThreadDraft.kt */
    public static final class C65301 extends AbstractC12240o implements Function0<Unit> {
        public C65301() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            BehaviorSubject behaviorSubject = StoreThreadDraft.this.draftStateSubject;
            BehaviorSubject behaviorSubject2 = StoreThreadDraft.this.draftStateSubject;
            C12238m.checkNotNullExpressionValue(behaviorSubject2, "draftStateSubject");
            behaviorSubject.onNext(ThreadDraftState.copy$default((ThreadDraftState) behaviorSubject2.m11132n0(), false, null, null, true, false, 23, null));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreThreadDraft$setDraftState$1 */
    /* JADX INFO: compiled from: StoreThreadDraft.kt */
    public static final class C65311 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ ThreadDraftState $draftState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C65311(ThreadDraftState threadDraftState) {
            super(0);
            this.$draftState = threadDraftState;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreThreadDraft.this.draftStateSubject.onNext(this.$draftState);
        }
    }

    public StoreThreadDraft(Dispatcher dispatcher) {
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        this.draftStateSubject = BehaviorSubject.m11130l0(new ThreadDraftState(false, null, null, false, false, 31, null));
    }

    public final void clearDraftState() {
        this.dispatcher.schedule(new C65291());
    }

    public final Observable<ThreadDraftState> observeDraftState() {
        BehaviorSubject<ThreadDraftState> behaviorSubject = this.draftStateSubject;
        C12238m.checkNotNullExpressionValue(behaviorSubject, "draftStateSubject");
        return behaviorSubject;
    }

    public final void setDraftSending() {
        this.dispatcher.schedule(new C65301());
    }

    public final void setDraftState(ThreadDraftState draftState) {
        C12238m.checkNotNullParameter(draftState, "draftState");
        this.dispatcher.schedule(new C65311(draftState));
    }
}
