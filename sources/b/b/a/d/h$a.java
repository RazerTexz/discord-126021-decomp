package b.b.a.d;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.View$OnClickListener;
import android.widget.FrameLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lytefast.flexinput.R$a;
import com.lytefast.flexinput.model.Media;
import com.lytefast.flexinput.utils.SelectionCoordinator;
import java.util.Objects;

/* JADX INFO: compiled from: MediaCursorAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$a extends i implements View$OnClickListener {
    public Media p;
    public final AnimatorSet q;
    public final AnimatorSet r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final b.b.a.e.c f320s;
    public final /* synthetic */ h t;

    /* JADX WARN: Illegal instructions before constructor call */
    public h$a(h hVar, b.b.a.e.c cVar) {
        d0.z.d.m.checkNotNullParameter(cVar, "binding");
        this.t = hVar;
        FrameLayout frameLayout = cVar.a;
        d0.z.d.m.checkNotNullExpressionValue(frameLayout, "binding.root");
        super(frameLayout);
        this.f320s = cVar;
        cVar.a.setOnClickListener(this);
        FrameLayout frameLayout2 = cVar.a;
        d0.z.d.m.checkNotNullExpressionValue(frameLayout2, "binding.root");
        Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(frameLayout2.getContext(), R$a.selection_shrink);
        Objects.requireNonNull(animatorLoadAnimator, "null cannot be cast to non-null type android.animation.AnimatorSet");
        AnimatorSet animatorSet = (AnimatorSet) animatorLoadAnimator;
        this.q = animatorSet;
        animatorSet.setTarget(cVar.f324b);
        FrameLayout frameLayout3 = cVar.a;
        d0.z.d.m.checkNotNullExpressionValue(frameLayout3, "binding.root");
        Animator animatorLoadAnimator2 = AnimatorInflater.loadAnimator(frameLayout3.getContext(), R$a.selection_grow);
        Objects.requireNonNull(animatorLoadAnimator2, "null cannot be cast to non-null type android.animation.AnimatorSet");
        AnimatorSet animatorSet2 = (AnimatorSet) animatorLoadAnimator2;
        this.r = animatorSet2;
        animatorSet2.setTarget(cVar.f324b);
    }

    @Override // b.b.a.d.i
    public SimpleDraweeView a() {
        SimpleDraweeView simpleDraweeView = this.f320s.c;
        d0.z.d.m.checkNotNullExpressionValue(simpleDraweeView, "binding.contentIv");
        return simpleDraweeView;
    }

    public final void d(boolean z2, boolean z3) {
        FrameLayout frameLayout = this.f320s.a;
        d0.z.d.m.checkNotNullExpressionValue(frameLayout, "binding.root");
        frameLayout.setSelected(z2);
        h$a$a h_a_a = new h$a$a(z3);
        if (z2) {
            SimpleDraweeView simpleDraweeView = this.f320s.d;
            d0.z.d.m.checkNotNullExpressionValue(simpleDraweeView, "binding.itemCheckIndicator");
            simpleDraweeView.setVisibility(0);
            FrameLayout frameLayout2 = this.f320s.f324b;
            d0.z.d.m.checkNotNullExpressionValue(frameLayout2, "binding.contentContainer");
            if (frameLayout2.getScaleX() == 1.0f) {
                h_a_a.a(this.q);
                return;
            }
            return;
        }
        SimpleDraweeView simpleDraweeView2 = this.f320s.d;
        d0.z.d.m.checkNotNullExpressionValue(simpleDraweeView2, "binding.itemCheckIndicator");
        simpleDraweeView2.setVisibility(8);
        FrameLayout frameLayout3 = this.f320s.f324b;
        d0.z.d.m.checkNotNullExpressionValue(frameLayout3, "binding.contentContainer");
        if (frameLayout3.getScaleX() != 1.0f) {
            h_a_a.a(this.r);
        }
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        d0.z.d.m.checkNotNullParameter(view, "v");
        SelectionCoordinator<?, Media> selectionCoordinator = this.t.a;
        Media media = this.p;
        int adapterPosition = getAdapterPosition();
        Objects.requireNonNull(selectionCoordinator);
        if (media == null || selectionCoordinator.d(media)) {
            return;
        }
        selectionCoordinator.c(media, adapterPosition);
    }
}
