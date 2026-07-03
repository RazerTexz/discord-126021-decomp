package com.discord.widgets.guilds.invite;

import com.discord.app.AppComponent;
import com.discord.app.AppFragment;
import com.discord.models.domain.ModelInvite;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import java.io.Closeable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.C0879o;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: InviteGenerator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InviteGenerator implements Closeable {
    private final Observable<InviteGenerationState> generationState;
    private final BehaviorSubject<InviteGenerationState> generationStateSubject;

    /* JADX INFO: compiled from: InviteGenerator.kt */
    public enum GenerationState {
        INIT,
        GENERATING,
        SUCCESS,
        FAILURE
    }

    /* JADX INFO: compiled from: InviteGenerator.kt */
    public static final /* data */ class InviteGenerationState {
        private final ModelInvite lastGeneratedInvite;
        private final GenerationState state;

        /* JADX WARN: Multi-variable type inference failed */
        public InviteGenerationState() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public InviteGenerationState(ModelInvite modelInvite, GenerationState generationState) {
            C12238m.checkNotNullParameter(generationState, "state");
            this.lastGeneratedInvite = modelInvite;
            this.state = generationState;
        }

        public static /* synthetic */ InviteGenerationState copy$default(InviteGenerationState inviteGenerationState, ModelInvite modelInvite, GenerationState generationState, int i, Object obj) {
            if ((i & 1) != 0) {
                modelInvite = inviteGenerationState.lastGeneratedInvite;
            }
            if ((i & 2) != 0) {
                generationState = inviteGenerationState.state;
            }
            return inviteGenerationState.copy(modelInvite, generationState);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ModelInvite getLastGeneratedInvite() {
            return this.lastGeneratedInvite;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final GenerationState getState() {
            return this.state;
        }

        public final InviteGenerationState copy(ModelInvite lastGeneratedInvite, GenerationState state) {
            C12238m.checkNotNullParameter(state, "state");
            return new InviteGenerationState(lastGeneratedInvite, state);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InviteGenerationState)) {
                return false;
            }
            InviteGenerationState inviteGenerationState = (InviteGenerationState) other;
            return C12238m.areEqual(this.lastGeneratedInvite, inviteGenerationState.lastGeneratedInvite) && C12238m.areEqual(this.state, inviteGenerationState.state);
        }

        public final ModelInvite getLastGeneratedInvite() {
            return this.lastGeneratedInvite;
        }

        public final GenerationState getState() {
            return this.state;
        }

        public int hashCode() {
            ModelInvite modelInvite = this.lastGeneratedInvite;
            int iHashCode = (modelInvite != null ? modelInvite.hashCode() : 0) * 31;
            GenerationState generationState = this.state;
            return iHashCode + (generationState != null ? generationState.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("InviteGenerationState(lastGeneratedInvite=");
            sbM833U.append(this.lastGeneratedInvite);
            sbM833U.append(", state=");
            sbM833U.append(this.state);
            sbM833U.append(")");
            return sbM833U.toString();
        }

        public /* synthetic */ InviteGenerationState(ModelInvite modelInvite, GenerationState generationState, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : modelInvite, (i & 2) != 0 ? GenerationState.INIT : generationState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.InviteGenerator$generate$1 */
    /* JADX INFO: compiled from: InviteGenerator.kt */
    public static final /* synthetic */ class C86281 extends C12236k implements Function1<ModelInvite, Unit> {
        public C86281(InviteGenerator inviteGenerator) {
            super(1, inviteGenerator, InviteGenerator.class, "handleGeneratedInvite", "handleGeneratedInvite(Lcom/discord/models/domain/ModelInvite;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
            invoke2(modelInvite);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelInvite modelInvite) {
            C12238m.checkNotNullParameter(modelInvite, "p1");
            ((InviteGenerator) this.receiver).handleGeneratedInvite(modelInvite);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.InviteGenerator$generateForAppComponent$1 */
    /* JADX INFO: compiled from: InviteGenerator.kt */
    public static final class C86301 extends AbstractC12240o implements Function1<ModelInvite, Unit> {
        public C86301() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
            invoke2(modelInvite);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelInvite modelInvite) {
            C12238m.checkNotNullParameter(modelInvite, "invite");
            InviteGenerator.this.handleGeneratedInvite(modelInvite);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.InviteGenerator$generateForAppComponent$2 */
    /* JADX INFO: compiled from: InviteGenerator.kt */
    public static final class C86312 extends AbstractC12240o implements Function1<Error, Unit> {
        public C86312() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "<anonymous parameter 0>");
            InviteGenerator.this.handleRestCallFailed();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InviteGenerator() {
        BehaviorSubject<InviteGenerationState> behaviorSubjectM11130l0 = BehaviorSubject.m11130l0(new InviteGenerationState(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
        this.generationStateSubject = behaviorSubjectM11130l0;
        Observable<InviteGenerationState> observableM11112r = behaviorSubjectM11130l0.m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "generationStateSubject.distinctUntilChanged()");
        this.generationState = observableM11112r;
    }

    private final void handleGeneratedInvite(ModelInvite invite) {
        this.generationStateSubject.onNext(new InviteGenerationState(invite, GenerationState.SUCCESS));
    }

    private final void handleRestCallFailed() {
        BehaviorSubject<InviteGenerationState> behaviorSubject = this.generationStateSubject;
        C12238m.checkNotNullExpressionValue(behaviorSubject, "generationStateSubject");
        this.generationStateSubject.onNext(InviteGenerationState.copy$default(behaviorSubject.m11132n0(), null, GenerationState.FAILURE, 1, null));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.generationStateSubject.onCompleted();
    }

    public final void generate(AppFragment fragment, long channelId) {
        C12238m.checkNotNullParameter(fragment, "fragment");
        BehaviorSubject<InviteGenerationState> behaviorSubject = this.generationStateSubject;
        C12238m.checkNotNullExpressionValue(behaviorSubject, "generationStateSubject");
        this.generationStateSubject.onNext(InviteGenerationState.copy$default(behaviorSubject.m11132n0(), null, GenerationState.GENERATING, 1, null));
        ObservableExtensionsKt.ui$default(StoreInviteSettings.generateInvite$default(StoreStream.INSTANCE.getInviteSettings(), channelId, null, 2, null), fragment, null, 2, null).m11108k(C0879o.f566a.m184g(fragment.getContext(), new C86281(this), new Action1<Error>() { // from class: com.discord.widgets.guilds.invite.InviteGenerator.generate.2
            @Override // p658rx.functions.Action1
            public final void call(Error error) {
                InviteGenerator.this.handleRestCallFailed();
            }
        }));
    }

    public final void generateForAppComponent(AppComponent appComponent, long channelId) {
        C12238m.checkNotNullParameter(appComponent, "appComponent");
        BehaviorSubject<InviteGenerationState> behaviorSubject = this.generationStateSubject;
        C12238m.checkNotNullExpressionValue(behaviorSubject, "generationStateSubject");
        this.generationStateSubject.onNext(InviteGenerationState.copy$default(behaviorSubject.m11132n0(), null, GenerationState.GENERATING, 1, null));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationBuffered(StoreInviteSettings.generateInvite$default(StoreStream.INSTANCE.getInviteSettings(), channelId, null, 2, null)), appComponent, null, 2, null), (Class<?>) InviteGenerator.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C86312()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C86301());
    }

    public final Observable<InviteGenerationState> getGenerationState() {
        return this.generationState;
    }
}
