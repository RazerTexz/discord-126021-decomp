package p007b.p225i.p226a.p341g.p346e;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import p007b.p225i.p226a.p341g.p346e.C4408f;

/* JADX INFO: renamed from: b.i.a.g.e.d */
/* JADX INFO: compiled from: FloatingActionButtonImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4406d extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a */
    public boolean f11645a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ boolean f11646b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ C4408f.f f11647c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ C4408f f11648d;

    public C4406d(C4408f c4408f, boolean z2, C4408f.f fVar) {
        this.f11648d = c4408f;
        this.f11646b = z2;
        this.f11647c = fVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f11645a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        C4408f c4408f = this.f11648d;
        c4408f.f11660B = 0;
        c4408f.f11685v = null;
        if (this.f11645a) {
            return;
        }
        FloatingActionButton floatingActionButton = c4408f.f11664F;
        boolean z2 = this.f11646b;
        floatingActionButton.internalSetVisibility(z2 ? 8 : 4, z2);
        C4408f.f fVar = this.f11647c;
        if (fVar != null) {
            FloatingActionButton.C10919a c10919a = (FloatingActionButton.C10919a) fVar;
            c10919a.f21018a.onHidden(FloatingActionButton.this);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f11648d.f11664F.internalSetVisibility(0, this.f11646b);
        C4408f c4408f = this.f11648d;
        c4408f.f11660B = 1;
        c4408f.f11685v = animator;
        this.f11645a = false;
    }
}
