package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import androidx.annotation.Nullable;
import b.i.a.g.e.a;
import b.i.a.g.e.b;
import com.google.android.material.R$animator;

/* JADX INFO: loaded from: classes3.dex */
public class ExtendedFloatingActionButton$j extends b {
    public final /* synthetic */ ExtendedFloatingActionButton g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExtendedFloatingActionButton$j(ExtendedFloatingActionButton extendedFloatingActionButton, a aVar) {
        super(extendedFloatingActionButton, aVar);
        this.g = extendedFloatingActionButton;
    }

    @Override // b.i.a.g.e.j
    public int b() {
        return R$animator.mtrl_extended_fab_show_motion_spec;
    }

    @Override // b.i.a.g.e.j
    public void c() {
        this.g.setVisibility(0);
        this.g.setAlpha(1.0f);
        this.g.setScaleY(1.0f);
        this.g.setScaleX(1.0f);
    }

    @Override // b.i.a.g.e.j
    public boolean d() {
        return ExtendedFloatingActionButton.access$1000(this.g);
    }

    @Override // b.i.a.g.e.b, b.i.a.g.e.j
    public void e() {
        super.e();
        ExtendedFloatingActionButton.access$902(this.g, 0);
    }

    @Override // b.i.a.g.e.j
    public void g(@Nullable ExtendedFloatingActionButton$OnChangedCallback extendedFloatingActionButton$OnChangedCallback) {
        if (extendedFloatingActionButton$OnChangedCallback != null) {
            extendedFloatingActionButton$OnChangedCallback.onShown(this.g);
        }
    }

    @Override // b.i.a.g.e.b, b.i.a.g.e.j
    public void onAnimationStart(Animator animator) {
        a aVar = this.d;
        Animator animator2 = aVar.a;
        if (animator2 != null) {
            animator2.cancel();
        }
        aVar.a = animator;
        this.g.setVisibility(0);
        ExtendedFloatingActionButton.access$902(this.g, 2);
    }
}
