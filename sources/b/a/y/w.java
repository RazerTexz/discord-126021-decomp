package b.a.y;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b.a.i.a1;
import com.discord.R$layout;
import com.discord.app.AppComponent;
import com.discord.overlay.views.OverlayBubbleWrap;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/* JADX INFO: compiled from: OverlayVoiceBubble.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class w extends OverlayBubbleWrap implements AppComponent {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f315x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final a1 f316y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Subject<Void, Void> f317z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(Context context) {
        super(context);
        d0.z.d.m.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.overlay_voice_bubble, (ViewGroup) this, false);
        addView(viewInflate);
        Objects.requireNonNull(viewInflate, "rootView");
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate;
        a1 a1Var = new a1(simpleDraweeView, simpleDraweeView);
        d0.z.d.m.checkNotNullExpressionValue(a1Var, "OverlayVoiceBubbleBindin…rom(context), this, true)");
        this.f316y = a1Var;
        PublishSubject publishSubjectK0 = PublishSubject.k0();
        d0.z.d.m.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.f317z = publishSubjectK0;
    }

    @Override // com.discord.overlay.views.OverlayBubbleWrap
    public void a(boolean z2) {
        h();
        super.a(z2);
    }

    @Override // com.discord.overlay.views.OverlayBubbleWrap
    public void b(View view) {
        d0.z.d.m.checkNotNullParameter(view, "targetView");
        super.b(view);
        g();
    }

    public final void g() {
        getImageView$app_productionGoogleRelease().animate().setDuration(100L).alpha(1.0f).start();
    }

    public final SimpleDraweeView getImageView$app_productionGoogleRelease() {
        SimpleDraweeView simpleDraweeView = this.f316y.f74b;
        d0.z.d.m.checkNotNullExpressionValue(simpleDraweeView, "binding.overlayBubbleIv");
        return simpleDraweeView;
    }

    @Override // com.discord.app.AppComponent
    public Subject<Void, Void> getUnsubscribeSignal() {
        return this.f317z;
    }

    public final void h() {
        getImageView$app_productionGoogleRelease().animate().setDuration(200L).alpha(0.5f).start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Observable<R> observableY = StoreStream.Companion.getVoiceChannelSelected().observeSelectedVoiceChannelId().Y(w$a.j);
        d0.z.d.m.checkNotNullExpressionValue(observableY, "StoreStream\n        .get…d()\n          }\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableY), this, null, 2, null), w.class, getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new w$b(this), 60, (Object) null);
    }

    @Override // com.discord.overlay.views.OverlayBubbleWrap, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        int i = getWindowLayoutParams().x;
        Context context = getContext();
        d0.z.d.m.checkNotNullExpressionValue(context, "context");
        int i2 = i > e(context).centerX() ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        super.onConfigurationChanged(configuration);
        OverlayBubbleWrap.c(this, i2, getWindowLayoutParams().y, null, 4, null);
        getSpringAnimationX().skipToEnd();
        getSpringAnimationY().skipToEnd();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        getUnsubscribeSignal().onNext(null);
        super.onDetachedFromWindow();
    }
}
