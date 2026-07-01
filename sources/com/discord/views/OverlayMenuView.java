package com.discord.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import b.a.i.s2;
import b.a.i.t2;
import b.a.y.r;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.app.AppComponent;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import defpackage.q;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/* JADX INFO: compiled from: OverlayMenuView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OverlayMenuView extends LinearLayout implements AppComponent {
    public static final /* synthetic */ int j = 0;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final s2 binding;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final Subject<Void, Void> unsubscribeSignal;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public Function0<Unit> onDismissRequested;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R$layout.view_overlay_menu, this);
        int i = 2131362884;
        View viewFindViewById = findViewById(2131362884);
        if (viewFindViewById != null) {
            int i2 = R$id.overlay_channel_name;
            TextView textView = (TextView) viewFindViewById.findViewById(R$id.overlay_channel_name);
            if (textView != null) {
                i2 = R$id.overlay_guild_name;
                TextView textView2 = (TextView) viewFindViewById.findViewById(R$id.overlay_guild_name);
                if (textView2 != null) {
                    i2 = R$id.overlay_invite_link;
                    TextView textView3 = (TextView) viewFindViewById.findViewById(R$id.overlay_invite_link);
                    if (textView3 != null) {
                        i2 = R$id.overlay_network_icon;
                        ImageView imageView = (ImageView) viewFindViewById.findViewById(R$id.overlay_network_icon);
                        if (imageView != null) {
                            i2 = R$id.overlay_open_app;
                            TextView textView4 = (TextView) viewFindViewById.findViewById(R$id.overlay_open_app);
                            if (textView4 != null) {
                                i2 = R$id.overlay_switch_channels;
                                TextView textView5 = (TextView) viewFindViewById.findViewById(R$id.overlay_switch_channels);
                                if (textView5 != null) {
                                    t2 t2Var = new t2((CardView) viewFindViewById, textView, textView2, textView3, imageView, textView4, textView5);
                                    i = R$id.disconnect_btn;
                                    ImageView imageView2 = (ImageView) findViewById(R$id.disconnect_btn);
                                    if (imageView2 != null) {
                                        i = R$id.mute_toggle;
                                        ImageView imageView3 = (ImageView) findViewById(R$id.mute_toggle);
                                        if (imageView3 != null) {
                                            i = R$id.src_toggle;
                                            ImageView imageView4 = (ImageView) findViewById(R$id.src_toggle);
                                            if (imageView4 != null) {
                                                s2 s2Var = new s2(this, t2Var, imageView2, imageView3, imageView4);
                                                m.checkNotNullExpressionValue(s2Var, "ViewOverlayMenuBinding.i…ater.from(context), this)");
                                                this.binding = s2Var;
                                                PublishSubject publishSubjectK0 = PublishSubject.k0();
                                                m.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
                                                this.unsubscribeSignal = publishSubjectK0;
                                                this.onDismissRequested = q.j;
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewFindViewById.getResources().getResourceName(i2)));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    public final Function0<Unit> getOnDismissRequested$app_productionGoogleRelease() {
        return this.onDismissRequested;
    }

    @Override // com.discord.app.AppComponent
    public Subject<Void, Void> getUnsubscribeSignal() {
        return this.unsubscribeSignal;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Observable<R> observableY = StoreStream.Companion.getVoiceChannelSelected().observeSelectedChannel().Y(r.j);
        m.checkNotNullExpressionValue(observableY, "StoreStream\n            …        }\n              }");
        Observable observableR = ObservableExtensionsKt.computationLatest(observableY).r();
        m.checkNotNullExpressionValue(observableR, "StoreStream\n            …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableR, this, null, 2, null), OverlayMenuView.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new OverlayMenuView$b(this), 62, (Object) null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        getUnsubscribeSignal().onNext(null);
        super.onDetachedFromWindow();
    }

    public final void setOnDismissRequested$app_productionGoogleRelease(Function0<Unit> function0) {
        m.checkNotNullParameter(function0, "<set-?>");
        this.onDismissRequested = function0;
    }
}
