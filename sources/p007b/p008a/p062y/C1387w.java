package p007b.p008a.p062y;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.discord.C5419R;
import com.discord.app.AppComponent;
import com.discord.overlay.views.OverlayBubbleWrap;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p025i.C0913a1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.PublishSubject;
import p658rx.subjects.Subject;

/* JADX INFO: renamed from: b.a.y.w */
/* JADX INFO: compiled from: OverlayVoiceBubble.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1387w extends OverlayBubbleWrap implements AppComponent {

    /* JADX INFO: renamed from: x */
    public static final /* synthetic */ int f2073x = 0;

    /* JADX INFO: renamed from: y */
    public final C0913a1 f2074y;

    /* JADX INFO: renamed from: z */
    public final Subject<Void, Void> f2075z;

    /* JADX INFO: renamed from: b.a.y.w$a */
    /* JADX INFO: compiled from: OverlayVoiceBubble.kt */
    public static final class a<T, R> implements InterfaceC12589b<Long, Observable<? extends StoreVoiceParticipants.VoiceUser>> {

        /* JADX INFO: renamed from: j */
        public static final a f2076j = new a();

        @Override // p637j0.p641k.InterfaceC12589b
        public Observable<? extends StoreVoiceParticipants.VoiceUser> call(Long l) {
            Long l2 = l;
            if (l2 != null && l2.longValue() == 0) {
                return new C12721k(null);
            }
            StoreVoiceParticipants voiceParticipants = StoreStream.INSTANCE.getVoiceParticipants();
            C12238m.checkNotNullExpressionValue(l2, "channelId");
            return voiceParticipants.get(l2.longValue()).m11083G(C1386v.f2072j).m11112r();
        }
    }

    /* JADX INFO: renamed from: b.a.y.w$b */
    /* JADX INFO: compiled from: OverlayVoiceBubble.kt */
    public static final class b extends AbstractC12240o implements Function1<StoreVoiceParticipants.VoiceUser, Unit> {
        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
            StoreVoiceParticipants.VoiceUser voiceUser2 = voiceUser;
            C1387w c1387w = C1387w.this;
            int i = C1387w.f2073x;
            if (voiceUser2 == null) {
                c1387w.m392h();
            } else {
                IconUtils.setIcon$default(c1387w.getImageView$app_productionGoogleRelease(), voiceUser2.getUser(), 0, null, null, voiceUser2.getGuildMember(), 28, null);
                c1387w.m391g();
            }
            return Unit.f27425a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1387w(Context context) {
        super(context);
        C12238m.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(C5419R.layout.overlay_voice_bubble, (ViewGroup) this, false);
        addView(viewInflate);
        Objects.requireNonNull(viewInflate, "rootView");
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate;
        C0913a1 c0913a1 = new C0913a1(simpleDraweeView, simpleDraweeView);
        C12238m.checkNotNullExpressionValue(c0913a1, "OverlayVoiceBubbleBindin…rom(context), this, true)");
        this.f2074y = c0913a1;
        PublishSubject publishSubjectM11133k0 = PublishSubject.m11133k0();
        C12238m.checkNotNullExpressionValue(publishSubjectM11133k0, "PublishSubject.create()");
        this.f2075z = publishSubjectM11133k0;
    }

    @Override // com.discord.overlay.views.OverlayBubbleWrap
    /* JADX INFO: renamed from: a */
    public void mo389a(boolean z2) {
        m392h();
        super.mo389a(z2);
    }

    @Override // com.discord.overlay.views.OverlayBubbleWrap
    /* JADX INFO: renamed from: b */
    public void mo390b(View view) {
        C12238m.checkNotNullParameter(view, "targetView");
        super.mo390b(view);
        m391g();
    }

    /* JADX INFO: renamed from: g */
    public final void m391g() {
        getImageView$app_productionGoogleRelease().animate().setDuration(100L).alpha(1.0f).start();
    }

    public final SimpleDraweeView getImageView$app_productionGoogleRelease() {
        SimpleDraweeView simpleDraweeView = this.f2074y.f662b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.overlayBubbleIv");
        return simpleDraweeView;
    }

    @Override // com.discord.app.AppComponent
    public Subject<Void, Void> getUnsubscribeSignal() {
        return this.f2075z;
    }

    /* JADX INFO: renamed from: h */
    public final void m392h() {
        getImageView$app_productionGoogleRelease().animate().setDuration(200L).alpha(0.5f).start();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Observable<R> observableM11099Y = StoreStream.INSTANCE.getVoiceChannelSelected().observeSelectedVoiceChannelId().m11099Y(a.f2076j);
        C12238m.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n        .get…d()\n          }\n        }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableM11099Y), this, null, 2, null), (Class<?>) C1387w.class, (58 & 2) != 0 ? null : getContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new b());
    }

    @Override // com.discord.overlay.views.OverlayBubbleWrap, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        int i = getWindowLayoutParams().x;
        Context context = getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        int i2 = i > m8436e(context).centerX() ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        super.onConfigurationChanged(configuration);
        OverlayBubbleWrap.m8434c(this, i2, getWindowLayoutParams().y, null, 4, null);
        getSpringAnimationX().skipToEnd();
        getSpringAnimationY().skipToEnd();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        getUnsubscribeSignal().onNext(null);
        super.onDetachedFromWindow();
    }
}
