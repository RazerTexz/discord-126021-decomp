package com.discord.stores;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: StoreNux.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNux extends Store {
    private final Dispatcher dispatcher;
    private NuxState nuxState;
    private final BehaviorSubject<NuxState> nuxStateSubject;

    /* JADX INFO: compiled from: StoreNux.kt */
    public static final /* data */ class NuxState {
        private final boolean addGuildHint;
        private final boolean contactSyncCompleted;
        private final boolean firstOpen;
        private final Long guildBoostHintGuildId;
        private final boolean postRegister;
        private final boolean postRegisterWithInvite;

        public NuxState() {
            this(false, false, false, false, false, null, 63, null);
        }

        public NuxState(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Long l) {
            this.postRegister = z2;
            this.postRegisterWithInvite = z3;
            this.contactSyncCompleted = z4;
            this.firstOpen = z5;
            this.addGuildHint = z6;
            this.guildBoostHintGuildId = l;
        }

        public static /* synthetic */ NuxState copy$default(NuxState nuxState, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = nuxState.postRegister;
            }
            if ((i & 2) != 0) {
                z3 = nuxState.postRegisterWithInvite;
            }
            boolean z7 = z3;
            if ((i & 4) != 0) {
                z4 = nuxState.contactSyncCompleted;
            }
            boolean z8 = z4;
            if ((i & 8) != 0) {
                z5 = nuxState.firstOpen;
            }
            boolean z9 = z5;
            if ((i & 16) != 0) {
                z6 = nuxState.addGuildHint;
            }
            boolean z10 = z6;
            if ((i & 32) != 0) {
                l = nuxState.guildBoostHintGuildId;
            }
            return nuxState.copy(z2, z7, z8, z9, z10, l);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getPostRegister() {
            return this.postRegister;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getPostRegisterWithInvite() {
            return this.postRegisterWithInvite;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getContactSyncCompleted() {
            return this.contactSyncCompleted;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getFirstOpen() {
            return this.firstOpen;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getAddGuildHint() {
            return this.addGuildHint;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Long getGuildBoostHintGuildId() {
            return this.guildBoostHintGuildId;
        }

        public final NuxState copy(boolean postRegister, boolean postRegisterWithInvite, boolean contactSyncCompleted, boolean firstOpen, boolean addGuildHint, Long guildBoostHintGuildId) {
            return new NuxState(postRegister, postRegisterWithInvite, contactSyncCompleted, firstOpen, addGuildHint, guildBoostHintGuildId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NuxState)) {
                return false;
            }
            NuxState nuxState = (NuxState) other;
            return this.postRegister == nuxState.postRegister && this.postRegisterWithInvite == nuxState.postRegisterWithInvite && this.contactSyncCompleted == nuxState.contactSyncCompleted && this.firstOpen == nuxState.firstOpen && this.addGuildHint == nuxState.addGuildHint && Intrinsics3.areEqual(this.guildBoostHintGuildId, nuxState.guildBoostHintGuildId);
        }

        public final boolean getAddGuildHint() {
            return this.addGuildHint;
        }

        public final boolean getContactSyncCompleted() {
            return this.contactSyncCompleted;
        }

        public final boolean getFirstOpen() {
            return this.firstOpen;
        }

        public final Long getGuildBoostHintGuildId() {
            return this.guildBoostHintGuildId;
        }

        public final boolean getPostRegister() {
            return this.postRegister;
        }

        public final boolean getPostRegisterWithInvite() {
            return this.postRegisterWithInvite;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v13 */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v3, types: [int] */
        /* JADX WARN: Type inference failed for: r2v5, types: [int] */
        /* JADX WARN: Type inference failed for: r2v7 */
        /* JADX WARN: Type inference failed for: r2v8 */
        /* JADX WARN: Type inference failed for: r2v9 */
        public int hashCode() {
            boolean z2 = this.postRegister;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            boolean z3 = this.postRegisterWithInvite;
            ?? r2 = z3;
            if (z3) {
                r2 = 1;
            }
            int i2 = (i + r2) * 31;
            boolean z4 = this.contactSyncCompleted;
            ?? r3 = z4;
            if (z4) {
                r3 = 1;
            }
            int i3 = (i2 + r3) * 31;
            boolean z5 = this.firstOpen;
            ?? r4 = z5;
            if (z5) {
                r4 = 1;
            }
            int i4 = (i3 + r4) * 31;
            boolean z6 = this.addGuildHint;
            int i5 = (i4 + (z6 ? 1 : z6)) * 31;
            Long l = this.guildBoostHintGuildId;
            return i5 + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("NuxState(postRegister=");
            sbU.append(this.postRegister);
            sbU.append(", postRegisterWithInvite=");
            sbU.append(this.postRegisterWithInvite);
            sbU.append(", contactSyncCompleted=");
            sbU.append(this.contactSyncCompleted);
            sbU.append(", firstOpen=");
            sbU.append(this.firstOpen);
            sbU.append(", addGuildHint=");
            sbU.append(this.addGuildHint);
            sbU.append(", guildBoostHintGuildId=");
            return outline.G(sbU, this.guildBoostHintGuildId, ")");
        }

        public /* synthetic */ NuxState(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? false : z3, (i & 4) != 0 ? false : z4, (i & 8) != 0 ? false : z5, (i & 16) == 0 ? z6 : false, (i & 32) != 0 ? null : l);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreNux$clearNux$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreNux.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreNux.this.nuxState = new NuxState(false, false, false, false, false, null, 63, null);
            StoreNux storeNux = StoreNux.this;
            storeNux.publishNuxUpdated(storeNux.nuxState);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreNux$setContactSyncCompleted$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreNux.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<NuxState, NuxState> {
        public final /* synthetic */ boolean $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(1);
            this.$value = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public final NuxState invoke(NuxState nuxState) {
            Intrinsics3.checkNotNullParameter(nuxState, "it");
            return NuxState.copy$default(nuxState, false, false, this.$value, false, false, null, 59, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreNux$setFirstOpen$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreNux.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<NuxState, NuxState> {
        public final /* synthetic */ boolean $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(1);
            this.$value = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public final NuxState invoke(NuxState nuxState) {
            Intrinsics3.checkNotNullParameter(nuxState, "it");
            return NuxState.copy$default(nuxState, false, false, false, this.$value, false, null, 55, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreNux$setPostRegister$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreNux.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<NuxState, NuxState> {
        public final /* synthetic */ boolean $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(1);
            this.$value = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public final NuxState invoke(NuxState nuxState) {
            Intrinsics3.checkNotNullParameter(nuxState, "it");
            return NuxState.copy$default(nuxState, this.$value, false, false, false, false, null, 62, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreNux$setPostRegisterWithInvite$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreNux.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<NuxState, NuxState> {
        public final /* synthetic */ boolean $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(1);
            this.$value = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public final NuxState invoke(NuxState nuxState) {
            Intrinsics3.checkNotNullParameter(nuxState, "it");
            return NuxState.copy$default(nuxState, false, this.$value, false, false, false, null, 61, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreNux$setPremiumGuildHintGuildId$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreNux.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<NuxState, NuxState> {
        public final /* synthetic */ Long $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Long l) {
            super(1);
            this.$value = l;
        }

        @Override // kotlin.jvm.functions.Function1
        public final NuxState invoke(NuxState nuxState) {
            Intrinsics3.checkNotNullParameter(nuxState, "it");
            return NuxState.copy$default(nuxState, false, false, false, false, false, this.$value, 31, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreNux$updateNux$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreNux.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Function1 $updateFunction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function1 function1) {
            super(0);
            this.$updateFunction = function1;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreNux storeNux = StoreNux.this;
            storeNux.nuxState = (NuxState) this.$updateFunction.invoke(storeNux.nuxState);
            StoreNux storeNux2 = StoreNux.this;
            storeNux2.publishNuxUpdated(storeNux2.nuxState);
        }
    }

    public StoreNux(Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        NuxState nuxState = new NuxState(false, false, false, false, false, null, 63, null);
        this.nuxState = nuxState;
        this.nuxStateSubject = BehaviorSubject.l0(nuxState);
    }

    private final void publishNuxUpdated(NuxState nuxState) {
        this.nuxStateSubject.onNext(nuxState);
    }

    public final void clearNux() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public final Observable<NuxState> getNuxState() {
        Observable<NuxState> observableR = this.nuxStateSubject.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "nuxStateSubject.distinctUntilChanged()");
        return observableR;
    }

    @Store3
    public final void handleGuildSelected(long guildId) {
        Long guildBoostHintGuildId = this.nuxState.getGuildBoostHintGuildId();
        if (guildBoostHintGuildId != null && guildBoostHintGuildId.longValue() == guildId) {
            return;
        }
        NuxState nuxStateCopy$default = NuxState.copy$default(this.nuxState, false, false, false, false, false, null, 31, null);
        this.nuxState = nuxStateCopy$default;
        publishNuxUpdated(nuxStateCopy$default);
    }

    @Store3
    public final void handleSamplePremiumGuildSelected(long guildId) {
        NuxState nuxStateCopy$default = NuxState.copy$default(this.nuxState, false, false, false, false, false, Long.valueOf(guildId), 31, null);
        this.nuxState = nuxStateCopy$default;
        publishNuxUpdated(nuxStateCopy$default);
    }

    public final void setContactSyncCompleted(boolean value) {
        updateNux(new AnonymousClass1(value));
    }

    public final void setFirstOpen(boolean value) {
        updateNux(new AnonymousClass1(value));
    }

    public final void setPostRegister(boolean value) {
        updateNux(new AnonymousClass1(value));
    }

    public final void setPostRegisterWithInvite(boolean value) {
        updateNux(new AnonymousClass1(value));
    }

    public final void setPremiumGuildHintGuildId(Long value) {
        updateNux(new AnonymousClass1(value));
    }

    public final void updateNux(Function1<? super NuxState, NuxState> updateFunction) {
        Intrinsics3.checkNotNullParameter(updateFunction, "updateFunction");
        this.dispatcher.schedule(new AnonymousClass1(updateFunction));
    }
}
