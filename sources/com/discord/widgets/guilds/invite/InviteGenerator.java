package com.discord.widgets.guilds.invite;

import android.content.Context;
import b.a.d.o;
import com.discord.app.AppComponent;
import com.discord.app.AppFragment;
import com.discord.models.domain.ModelInvite;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import java.io.Closeable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: InviteGenerator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InviteGenerator implements Closeable {
    private final Observable<InviteGenerator$InviteGenerationState> generationState;
    private final BehaviorSubject<InviteGenerator$InviteGenerationState> generationStateSubject;

    public InviteGenerator() {
        BehaviorSubject<InviteGenerator$InviteGenerationState> behaviorSubjectL0 = BehaviorSubject.l0(new InviteGenerator$InviteGenerationState(null, null, 3, null));
        this.generationStateSubject = behaviorSubjectL0;
        Observable<InviteGenerator$InviteGenerationState> observableR = behaviorSubjectL0.r();
        m.checkNotNullExpressionValue(observableR, "generationStateSubject.distinctUntilChanged()");
        this.generationState = observableR;
    }

    public static final /* synthetic */ void access$handleGeneratedInvite(InviteGenerator inviteGenerator, ModelInvite modelInvite) {
        inviteGenerator.handleGeneratedInvite(modelInvite);
    }

    public static final /* synthetic */ void access$handleRestCallFailed(InviteGenerator inviteGenerator) {
        inviteGenerator.handleRestCallFailed();
    }

    private final void handleGeneratedInvite(ModelInvite invite) {
        this.generationStateSubject.onNext(new InviteGenerator$InviteGenerationState(invite, InviteGenerator$GenerationState.SUCCESS));
    }

    private final void handleRestCallFailed() {
        BehaviorSubject<InviteGenerator$InviteGenerationState> behaviorSubject = this.generationStateSubject;
        m.checkNotNullExpressionValue(behaviorSubject, "generationStateSubject");
        this.generationStateSubject.onNext(InviteGenerator$InviteGenerationState.copy$default(behaviorSubject.n0(), null, InviteGenerator$GenerationState.FAILURE, 1, null));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.generationStateSubject.onCompleted();
    }

    public final void generate(AppFragment fragment, long channelId) {
        m.checkNotNullParameter(fragment, "fragment");
        BehaviorSubject<InviteGenerator$InviteGenerationState> behaviorSubject = this.generationStateSubject;
        m.checkNotNullExpressionValue(behaviorSubject, "generationStateSubject");
        this.generationStateSubject.onNext(InviteGenerator$InviteGenerationState.copy$default(behaviorSubject.n0(), null, InviteGenerator$GenerationState.GENERATING, 1, null));
        ObservableExtensionsKt.ui$default(StoreInviteSettings.generateInvite$default(StoreStream.Companion.getInviteSettings(), channelId, null, 2, null), fragment, null, 2, null).k(o.a.g(fragment.getContext(), new InviteGenerator$generate$1(this), new InviteGenerator$generate$2(this)));
    }

    public final void generateForAppComponent(AppComponent appComponent, long channelId) {
        m.checkNotNullParameter(appComponent, "appComponent");
        BehaviorSubject<InviteGenerator$InviteGenerationState> behaviorSubject = this.generationStateSubject;
        m.checkNotNullExpressionValue(behaviorSubject, "generationStateSubject");
        this.generationStateSubject.onNext(InviteGenerator$InviteGenerationState.copy$default(behaviorSubject.n0(), null, InviteGenerator$GenerationState.GENERATING, 1, null));
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationBuffered(StoreInviteSettings.generateInvite$default(StoreStream.Companion.getInviteSettings(), channelId, null, 2, null)), appComponent, null, 2, null), InviteGenerator.class, (Context) null, (Function1) null, new InviteGenerator$generateForAppComponent$2(this), (Function0) null, (Function0) null, new InviteGenerator$generateForAppComponent$1(this), 54, (Object) null);
    }

    public final Observable<InviteGenerator$InviteGenerationState> getGenerationState() {
        return this.generationState;
    }
}
