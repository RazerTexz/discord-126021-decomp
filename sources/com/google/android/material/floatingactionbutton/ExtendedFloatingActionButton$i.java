package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import androidx.annotation.Nullable;
import b.i.a.g.e.a;
import b.i.a.g.e.b;
import com.google.android.material.R$animator;

/* JADX INFO: loaded from: classes3.dex */
public class ExtendedFloatingActionButton$i extends b {
    public boolean g;
    public final /* synthetic */ ExtendedFloatingActionButton h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExtendedFloatingActionButton$i(ExtendedFloatingActionButton extendedFloatingActionButton, a aVar) {
        super(extendedFloatingActionButton, aVar);
        this.h = extendedFloatingActionButton;
    }

    @Override // b.i.a.g.e.b, b.i.a.g.e.j
    public void a() {
        this.d.a = null;
        this.g = true;
    }

    @Override // b.i.a.g.e.j
    public int b() {
        return R$animator.mtrl_extended_fab_hide_motion_spec;
    }

    @Override // b.i.a.g.e.j
    public void c() {
        this.h.setVisibility(8);
    }

    @Override // b.i.a.g.e.j
    public boolean d() {
        return ExtendedFloatingActionButton.access$1100(this.h);
    }

    @Override // b.i.a.g.e.b, b.i.a.g.e.j
    public void e() {
        super.e();
        ExtendedFloatingActionButton.access$902(this.h, 0);
        if (this.g) {
            return;
        }
        this.h.setVisibility(8);
    }

    @Override // b.i.a.g.e.j
    public void g(@Nullable ExtendedFloatingActionButton$OnChangedCallback extendedFloatingActionButton$OnChangedCallback) {
        if (extendedFloatingActionButton$OnChangedCallback != null) {
            extendedFloatingActionButton$OnChangedCallback.onHidden(this.h);
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
        this.g = false;
        this.h.setVisibility(0);
        ExtendedFloatingActionButton.access$902(this.h, 1);
    }
}
