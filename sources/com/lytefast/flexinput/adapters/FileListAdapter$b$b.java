package com.lytefast.flexinput.adapters;

import android.animation.AnimatorSet;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: FileListAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FileListAdapter$b$b extends o implements Function1<AnimatorSet, Unit> {
    public final /* synthetic */ boolean $isAnimationRequested;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileListAdapter$b$b(boolean z2) {
        super(1);
        this.$isAnimationRequested = z2;
    }

    public final void a(AnimatorSet animatorSet) {
        m.checkNotNullParameter(animatorSet, "animation");
        animatorSet.start();
        if (this.$isAnimationRequested) {
            return;
        }
        animatorSet.end();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AnimatorSet animatorSet) {
        a(animatorSet);
        return Unit.a;
    }
}
