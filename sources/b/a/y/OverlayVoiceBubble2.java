package b.a.y;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import b.a.i.OverlayVoiceBubbleBinding;
import com.discord.R;
import com.discord.app.AppComponent;
import com.discord.overlay.views.OverlayBubbleWrap;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/* JADX INFO: renamed from: b.a.y.w, reason: use source file name */
/* JADX INFO: compiled from: OverlayVoiceBubble.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OverlayVoiceBubble2 extends OverlayBubbleWrap implements AppComponent {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final /* synthetic */ int f315x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final OverlayVoiceBubbleBinding f316y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Subject<Void, Void> f317z;

    /* JADX INFO: renamed from: b.a.y.w$a */
    /* JADX INFO: compiled from: OverlayVoiceBubble.kt */
    public static final class a<T, R> implements Func1<Long, Observable<? extends StoreVoiceParticipants.VoiceUser>> {
        public static final a j = new a();

        @Override // j0.k.Func1
        public Observable<? extends StoreVoiceParticipants.VoiceUser> call(Long l) {
            Long l2 = l;
            if (l2 != null && l2.longValue() == 0) {
                return new ScalarSynchronousObservable(null);
            }
            StoreVoiceParticipants voiceParticipants = StoreStream.INSTANCE.getVoiceParticipants();
            Intrinsics3.checkNotNullExpressionValue(l2, "channelId");
            return voiceParticipants.get(l2.longValue()).G(OverlayVoiceBubble.j).r();
        }
    }

    /* JADX INFO: renamed from: b.a.y.w$b */
    /* JADX INFO: compiled from: OverlayVoiceBubble.kt */
    public static final class b extends Lambda implements Function1<StoreVoiceParticipants.VoiceUser, Unit> {
        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
            StoreVoiceParticipants.VoiceUser voiceUser2 = voiceUser;
            OverlayVoiceBubble2 overlayVoiceBubble2 = OverlayVoiceBubble2.this;
            int i = OverlayVoiceBubble2.f315x;
            if (voiceUser2 == null) {
                overlayVoiceBubble2.h();
            } else {
                IconUtils.setIcon$default(overlayVoiceBubble2.getImageView$app_productionGoogleRelease(), voiceUser2.getUser(), 0, null, null, voiceUser2.getGuildMember(), 28, null);
                overlayVoiceBubble2.g();
            }
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayVoiceBubble2(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.overlay_voice_bubble, (ViewGroup) this, false);
        addView(viewInflate);
        Objects.requireNonNull(viewInflate, "rootView");
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate;
        OverlayVoiceBubbleBinding overlayVoiceBubbleBinding = new OverlayVoiceBubbleBinding(simpleDraweeView, simpleDraweeView);
        Intrinsics3.checkNotNullExpressionValue(overlayVoiceBubbleBinding, "OverlayVoiceBubbleBindin…rom(context), this, true)");
        this.f316y = overlayVoiceBubbleBinding;
        PublishSubject publishSubjectK0 = PublishSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.f317z = publishSubjectK0;
    }

    @Override // com.discord.overlay.views.OverlayBubbleWrap
    public void a(boolean z2) {
        h();
        super.a(z2);
    }

    @Override // com.discord.overlay.views.OverlayBubbleWrap
    public void b(View view) {
        Intrinsics3.checkNotNullParameter(view, "targetView");
        super.b(view);
        g();
    }

    public final void g() {
        getImageView$app_productionGoogleRelease().animate().setDuration(100L).alpha(1.0f).start();
    }

    public final SimpleDraweeView getImageView$app_productionGoogleRelease() {
        SimpleDraweeView simpleDraweeView = this.f316y.f74b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.overlayBubbleIv");
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
        Observable<R> observableY = StoreStream.INSTANCE.getVoiceChannelSelected().observeSelectedVoiceChannelId().Y(a.j);
        Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n        .get…d()\n          }\n        }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableY), this, null, 2, null), (Class<?>) OverlayVoiceBubble2.class, (58 & 2) != 0 ? null : getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new b());
    }

    @Override // com.discord.overlay.views.OverlayBubbleWrap, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        int i = getWindowLayoutParams().x;
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
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
