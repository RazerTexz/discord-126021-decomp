package b.a.y;

import android.animation.Animator;
import android.content.Context;
import android.util.Log;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.discord.app.AppComponent;
import com.discord.overlay.views.OverlayDialog;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/* JADX INFO: renamed from: b.a.y.l, reason: use source file name */
/* JADX INFO: compiled from: OverlayAppDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class OverlayAppDialog2 extends OverlayDialog implements AppComponent {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Subject<Void, Void> f313x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Function1<? super OverlayDialog, Unit> f314y;

    /* JADX INFO: renamed from: b.a.y.l$a */
    /* JADX INFO: compiled from: Animator.kt */
    public static final class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Intrinsics3.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Intrinsics3.checkNotNullParameter(animator, "animator");
            OverlayAppDialog2.this.getOnDialogClosed().invoke(OverlayAppDialog2.this);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Intrinsics3.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Intrinsics3.checkNotNullParameter(animator, "animator");
        }
    }

    /* JADX INFO: renamed from: b.a.y.l$b */
    /* JADX INFO: compiled from: OverlayAppDialog.kt */
    public static final class b implements View.OnAttachStateChangeListener {
        public final /* synthetic */ Animator j;

        public b(Animator animator) {
            this.j = animator;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            this.j.end();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayAppDialog2(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        PublishSubject publishSubjectK0 = PublishSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.f313x = publishSubjectK0;
        setOnClickListener(new OverlayAppDialog(this));
        this.f314y = OverlayAppDialog3.j;
    }

    public final void g() {
        getUnsubscribeSignal().onNext(null);
        Log.i(getClass().getSimpleName(), "closing");
        if (!ViewCompat.isAttachedToWindow(this)) {
            this.f314y.invoke(this);
            return;
        }
        Animator closingAnimator = getClosingAnimator();
        closingAnimator.addListener(new a());
        closingAnimator.start();
        addOnAttachStateChangeListener(new b(closingAnimator));
    }

    public abstract Animator getClosingAnimator();

    public final Function1<OverlayDialog, Unit> getOnDialogClosed() {
        return this.f314y;
    }

    @Override // com.discord.app.AppComponent
    public Subject<Void, Void> getUnsubscribeSignal() {
        return this.f313x;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        getUnsubscribeSignal().onNext(null);
        super.onDetachedFromWindow();
    }

    public final void setOnDialogClosed(Function1<? super OverlayDialog, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "<set-?>");
        this.f314y = function1;
    }
}
