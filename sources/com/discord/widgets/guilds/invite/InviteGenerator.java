package com.discord.widgets.guilds.invite;

import b.a.d.o;
import b.d.b.a.outline;
import com.discord.app.AppComponent;
import com.discord.app.AppFragment;
import com.discord.models.domain.ModelInvite;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.Closeable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.subjects.BehaviorSubject;

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
            Intrinsics3.checkNotNullParameter(generationState, "state");
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
            Intrinsics3.checkNotNullParameter(state, "state");
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
            return Intrinsics3.areEqual(this.lastGeneratedInvite, inviteGenerationState.lastGeneratedInvite) && Intrinsics3.areEqual(this.state, inviteGenerationState.state);
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
            StringBuilder sbU = outline.U("InviteGenerationState(lastGeneratedInvite=");
            sbU.append(this.lastGeneratedInvite);
            sbU.append(", state=");
            sbU.append(this.state);
            sbU.append(")");
            return sbU.toString();
        }

        public /* synthetic */ InviteGenerationState(ModelInvite modelInvite, GenerationState generationState, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : modelInvite, (i & 2) != 0 ? GenerationState.INIT : generationState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.InviteGenerator$generate$1, reason: invalid class name */
    /* JADX INFO: compiled from: InviteGenerator.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<ModelInvite, Unit> {
        public AnonymousClass1(InviteGenerator inviteGenerator) {
            super(1, inviteGenerator, InviteGenerator.class, "handleGeneratedInvite", "handleGeneratedInvite(Lcom/discord/models/domain/ModelInvite;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
            invoke2(modelInvite);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelInvite modelInvite) {
            Intrinsics3.checkNotNullParameter(modelInvite, "p1");
            ((InviteGenerator) this.receiver).handleGeneratedInvite(modelInvite);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.InviteGenerator$generateForAppComponent$1, reason: invalid class name */
    /* JADX INFO: compiled from: InviteGenerator.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelInvite, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
            invoke2(modelInvite);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelInvite modelInvite) {
            Intrinsics3.checkNotNullParameter(modelInvite, "invite");
            InviteGenerator.this.handleGeneratedInvite(modelInvite);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.InviteGenerator$generateForAppComponent$2, reason: invalid class name */
    /* JADX INFO: compiled from: InviteGenerator.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "<anonymous parameter 0>");
            InviteGenerator.this.handleRestCallFailed();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InviteGenerator() {
        BehaviorSubject<InviteGenerationState> behaviorSubjectL0 = BehaviorSubject.l0(new InviteGenerationState(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
        this.generationStateSubject = behaviorSubjectL0;
        Observable<InviteGenerationState> observableR = behaviorSubjectL0.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "generationStateSubject.distinctUntilChanged()");
        this.generationState = observableR;
    }

    private final void handleGeneratedInvite(ModelInvite invite) {
        this.generationStateSubject.onNext(new InviteGenerationState(invite, GenerationState.SUCCESS));
    }

    private final void handleRestCallFailed() {
        BehaviorSubject<InviteGenerationState> behaviorSubject = this.generationStateSubject;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "generationStateSubject");
        this.generationStateSubject.onNext(InviteGenerationState.copy$default(behaviorSubject.n0(), null, GenerationState.FAILURE, 1, null));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.generationStateSubject.onCompleted();
    }

    public final void generate(AppFragment fragment, long channelId) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        BehaviorSubject<InviteGenerationState> behaviorSubject = this.generationStateSubject;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "generationStateSubject");
        this.generationStateSubject.onNext(InviteGenerationState.copy$default(behaviorSubject.n0(), null, GenerationState.GENERATING, 1, null));
        ObservableExtensionsKt.ui$default(StoreInviteSettings.generateInvite$default(StoreStream.INSTANCE.getInviteSettings(), channelId, null, 2, null), fragment, null, 2, null).k(o.a.g(fragment.getContext(), new AnonymousClass1(this), new Action1<Error>() { // from class: com.discord.widgets.guilds.invite.InviteGenerator.generate.2
            @Override // rx.functions.Action1
            public final void call(Error error) {
                InviteGenerator.this.handleRestCallFailed();
            }
        }));
    }

    public final void generateForAppComponent(AppComponent appComponent, long channelId) {
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        BehaviorSubject<InviteGenerationState> behaviorSubject = this.generationStateSubject;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "generationStateSubject");
        this.generationStateSubject.onNext(InviteGenerationState.copy$default(behaviorSubject.n0(), null, GenerationState.GENERATING, 1, null));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationBuffered(StoreInviteSettings.generateInvite$default(StoreStream.INSTANCE.getInviteSettings(), channelId, null, 2, null)), appComponent, null, 2, null), (Class<?>) InviteGenerator.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass2()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    public final Observable<InviteGenerationState> getGenerationState() {
        return this.generationState;
    }
}
