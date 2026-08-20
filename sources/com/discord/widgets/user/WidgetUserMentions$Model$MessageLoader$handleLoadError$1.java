package com.discord.widgets.user;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMentions$Model$MessageLoader$handleLoadError$1 extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ WidgetUserMentions.Model.MessageLoader this$0;

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserMentions$Model$MessageLoader$handleLoadError$1$1 */
    /* JADX INFO: compiled from: WidgetUserMentions.kt */
    public static final class C102081 extends AbstractC12240o implements Function1<WidgetUserMentions.Model.MessageLoader.LoadingState, WidgetUserMentions.Model.MessageLoader.LoadingState> {
        public static final C102081 INSTANCE = new C102081();

        public C102081() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final WidgetUserMentions.Model.MessageLoader.LoadingState invoke(WidgetUserMentions.Model.MessageLoader.LoadingState loadingState) {
            C12238m.checkNotNullParameter(loadingState, "it");
            return WidgetUserMentions.Model.MessageLoader.LoadingState.copy$default(loadingState, false, false, null, 6, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserMentions$Model$MessageLoader$handleLoadError$1(WidgetUserMentions.Model.MessageLoader messageLoader) {
        super(0);
        this.this$0 = messageLoader;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.tryLoad(C102081.INSTANCE);
    }
}
