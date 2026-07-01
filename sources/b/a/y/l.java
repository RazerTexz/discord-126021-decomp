package b.a.y;

import android.animation.Animator;
import android.content.Context;
import android.util.Log;
import androidx.core.view.ViewCompat;
import com.discord.app.AppComponent;
import com.discord.overlay.views.OverlayDialog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/* JADX INFO: compiled from: OverlayAppDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class l extends OverlayDialog implements AppComponent {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Subject<Void, Void> f313x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Function1<? super OverlayDialog, Unit> f314y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Context context) {
        super(context);
        d0.z.d.m.checkNotNullParameter(context, "context");
        PublishSubject publishSubjectK0 = PublishSubject.k0();
        d0.z.d.m.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.f313x = publishSubjectK0;
        setOnClickListener(new k(this));
        this.f314y = m.j;
    }

    public final void g() {
        getUnsubscribeSignal().onNext(null);
        Log.i(getClass().getSimpleName(), "closing");
        if (!ViewCompat.isAttachedToWindow(this)) {
            this.f314y.invoke(this);
            return;
        }
        Animator closingAnimator = getClosingAnimator();
        closingAnimator.addListener(new l$a(this));
        closingAnimator.start();
        addOnAttachStateChangeListener(new l$b(closingAnimator));
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
        d0.z.d.m.checkNotNullParameter(function1, "<set-?>");
        this.f314y = function1;
    }
}
