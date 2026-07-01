package com.discord.widgets.auth;

import androidx.view.ViewModelKt;
import b.i.a.f.e.o.f;
import com.discord.models.domain.ModelRemoteAuthHandshake;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetRemoteAuthViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetRemoteAuthViewModel$1 extends o implements Function1<ModelRemoteAuthHandshake, Unit> {
    public final /* synthetic */ WidgetRemoteAuthViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetRemoteAuthViewModel$1(WidgetRemoteAuthViewModel widgetRemoteAuthViewModel) {
        super(1);
        this.this$0 = widgetRemoteAuthViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelRemoteAuthHandshake modelRemoteAuthHandshake) {
        invoke2(modelRemoteAuthHandshake);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelRemoteAuthHandshake modelRemoteAuthHandshake) {
        m.checkNotNullParameter(modelRemoteAuthHandshake, "handshakeData");
        WidgetRemoteAuthViewModel widgetRemoteAuthViewModel = this.this$0;
        String handshakeToken = modelRemoteAuthHandshake.getHandshakeToken();
        BehaviorSubject behaviorSubjectAccess$getTemporaryBehaviorSubject$p = WidgetRemoteAuthViewModel.access$getTemporaryBehaviorSubject$p(this.this$0);
        m.checkNotNullExpressionValue(behaviorSubjectAccess$getTemporaryBehaviorSubject$p, "temporaryBehaviorSubject");
        Object objN0 = behaviorSubjectAccess$getTemporaryBehaviorSubject$p.n0();
        m.checkNotNullExpressionValue(objN0, "temporaryBehaviorSubject.value");
        WidgetRemoteAuthViewModel.access$updateViewState(widgetRemoteAuthViewModel, new WidgetRemoteAuthViewModel$ViewState$Loaded(handshakeToken, ((Boolean) objN0).booleanValue(), false));
        f.H0(ViewModelKt.getViewModelScope(this.this$0), null, null, new WidgetRemoteAuthViewModel$1$1(this, modelRemoteAuthHandshake, null), 3, null);
    }
}
