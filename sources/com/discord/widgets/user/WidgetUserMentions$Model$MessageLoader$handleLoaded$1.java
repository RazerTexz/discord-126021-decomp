package com.discord.widgets.user;

import com.discord.widgets.user.WidgetUserMentions;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMentions$Model$MessageLoader$handleLoaded$1 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ boolean $isAllLoaded;
    public final /* synthetic */ WidgetUserMentions.Model.MessageLoader this$0;

    /* JADX INFO: renamed from: com.discord.widgets.user.WidgetUserMentions$Model$MessageLoader$handleLoaded$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetUserMentions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetUserMentions.Model.MessageLoader.LoadingState, WidgetUserMentions.Model.MessageLoader.LoadingState> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final WidgetUserMentions.Model.MessageLoader.LoadingState invoke(WidgetUserMentions.Model.MessageLoader.LoadingState loadingState) {
            Intrinsics3.checkNotNullParameter(loadingState, "it");
            return WidgetUserMentions.Model.MessageLoader.LoadingState.copy$default(loadingState, false, WidgetUserMentions$Model$MessageLoader$handleLoaded$1.this.$isAllLoaded, null, 4, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserMentions$Model$MessageLoader$handleLoaded$1(WidgetUserMentions.Model.MessageLoader messageLoader, boolean z2) {
        super(0);
        this.this$0 = messageLoader;
        this.$isAllLoaded = z2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.tryLoad(new AnonymousClass1());
    }
}
