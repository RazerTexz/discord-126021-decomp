package com.discord.views;

import android.view.View;
import android.view.ViewGroup$LayoutParams;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: VoiceUserView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceUserView$b extends o implements Function1<View, Unit> {
    public final /* synthetic */ int $avatarSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceUserView$b(int i) {
        super(1);
        this.$avatarSize = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "$this$resizeLayoutParams");
        if (view.getLayoutParams().width == this.$avatarSize && view.getLayoutParams().height == this.$avatarSize) {
            return;
        }
        ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        int i = this.$avatarSize;
        layoutParams.width = i;
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
    }
}
