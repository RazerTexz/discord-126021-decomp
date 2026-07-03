package com.discord.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.discord.C5419R;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppComponent;
import com.discord.models.guild.Guild;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.audio.DiscordAudioManager;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.voice.VoiceViewUtils;
import com.discord.widgets.voice.model.CallModel;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p000.C13003q;
import p000.ViewOnClickListenerC12260f;
import p000.ViewOnClickListenerC12497i;
import p007b.p008a.p025i.C1047s2;
import p007b.p008a.p025i.C1054t2;
import p007b.p008a.p062y.C1379r;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.PublishSubject;
import p658rx.subjects.Subject;

/* JADX INFO: compiled from: OverlayMenuView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OverlayMenuView extends LinearLayout implements AppComponent {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ int f19098j = 0;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final C1047s2 binding;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final Subject<Void, Void> unsubscribeSignal;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public Function0<Unit> onDismissRequested;

    /* JADX INFO: renamed from: com.discord.views.OverlayMenuView$a */
    /* JADX INFO: compiled from: OverlayMenuView.kt */
    public static final class C7085a {

        /* JADX INFO: renamed from: a */
        public final Long f19102a;

        /* JADX INFO: renamed from: b */
        public final Guild f19103b;

        /* JADX INFO: renamed from: c */
        public final CallModel f19104c;

        /* JADX INFO: renamed from: d */
        public final RtcConnection.Quality f19105d;

        public C7085a(Long l, Guild guild, CallModel callModel, RtcConnection.Quality quality) {
            C12238m.checkNotNullParameter(quality, "rtcQuality");
            this.f19102a = l;
            this.f19103b = guild;
            this.f19104c = callModel;
            this.f19105d = quality;
        }
    }

    /* JADX INFO: renamed from: com.discord.views.OverlayMenuView$b */
    /* JADX INFO: compiled from: OverlayMenuView.kt */
    public static final class C7086b extends AbstractC12240o implements Function1<C7085a, Unit> {
        public C7086b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(C7085a c7085a) {
            C7085a c7085a2 = c7085a;
            if (c7085a2 != null) {
                OverlayMenuView overlayMenuView = OverlayMenuView.this;
                int i = OverlayMenuView.f19098j;
                Objects.requireNonNull(overlayMenuView);
                if (c7085a2.f19104c != null) {
                    overlayMenuView.binding.f1207b.f1246d.setOnClickListener(new ViewOnClickListenerC12260f(0, overlayMenuView, c7085a2));
                    TextView textView = overlayMenuView.binding.f1207b.f1246d;
                    C12238m.checkNotNullExpressionValue(textView, "binding.content.overlayInviteLink");
                    textView.setVisibility(PermissionUtils.can(1L, c7085a2.f19102a) ? 0 : 8);
                    overlayMenuView.binding.f1207b.f1249g.setOnClickListener(new ViewOnClickListenerC12497i(0, overlayMenuView));
                    overlayMenuView.binding.f1207b.f1248f.setOnClickListener(new ViewOnClickListenerC12260f(1, overlayMenuView, c7085a2));
                    ImageView imageView = overlayMenuView.binding.f1210e;
                    C12238m.checkNotNullExpressionValue(imageView, "binding.srcToggle");
                    ColorStateList colorStateListValueOf = c7085a2.f19104c.getAudioManagerState().getActiveAudioDevice() == DiscordAudioManager.DeviceTypes.SPEAKERPHONE ? ColorStateList.valueOf(-1) : ColorStateList.valueOf(ColorCompat.getColor(overlayMenuView.getContext(), C5419R.color.primary_dark_400));
                    C12238m.checkNotNullExpressionValue(colorStateListValueOf, "if (selectedOutputDevice…rimary_dark_400))\n      }");
                    imageView.setImageTintList(colorStateListValueOf);
                    overlayMenuView.binding.f1210e.setOnClickListener(new ViewOnClickListenerC12497i(1, c7085a2));
                    ImageView imageView2 = overlayMenuView.binding.f1209d;
                    C12238m.checkNotNullExpressionValue(imageView2, "binding.muteToggle");
                    imageView2.setActivated(c7085a2.f19104c.isMeMutedByAnySource());
                    overlayMenuView.binding.f1209d.setOnClickListener(new ViewOnClickListenerC12497i(2, c7085a2));
                    overlayMenuView.binding.f1208c.setOnClickListener(new ViewOnClickListenerC12497i(3, overlayMenuView));
                    overlayMenuView.binding.f1207b.f1247e.setImageResource(VoiceViewUtils.INSTANCE.getQualityIndicator(c7085a2.f19105d));
                    TextView textView2 = overlayMenuView.binding.f1207b.f1245c;
                    C12238m.checkNotNullExpressionValue(textView2, "binding.content.overlayGuildName");
                    Guild guild = c7085a2.f19103b;
                    String name = guild != null ? guild.getName() : null;
                    if (name == null) {
                        name = "";
                    }
                    textView2.setText(name);
                    TextView textView3 = overlayMenuView.binding.f1207b.f1244b;
                    C12238m.checkNotNullExpressionValue(textView3, "binding.content.overlayChannelName");
                    textView3.setText(ChannelUtils.m7679c(c7085a2.f19104c.getChannel()));
                }
            }
            return Unit.f27425a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(C5419R.layout.view_overlay_menu, this);
        int i = C5419R.id.content;
        View viewFindViewById = findViewById(C5419R.id.content);
        if (viewFindViewById != null) {
            int i2 = C5419R.id.overlay_channel_name;
            TextView textView = (TextView) viewFindViewById.findViewById(C5419R.id.overlay_channel_name);
            if (textView != null) {
                i2 = C5419R.id.overlay_guild_name;
                TextView textView2 = (TextView) viewFindViewById.findViewById(C5419R.id.overlay_guild_name);
                if (textView2 != null) {
                    i2 = C5419R.id.overlay_invite_link;
                    TextView textView3 = (TextView) viewFindViewById.findViewById(C5419R.id.overlay_invite_link);
                    if (textView3 != null) {
                        i2 = C5419R.id.overlay_network_icon;
                        ImageView imageView = (ImageView) viewFindViewById.findViewById(C5419R.id.overlay_network_icon);
                        if (imageView != null) {
                            i2 = C5419R.id.overlay_open_app;
                            TextView textView4 = (TextView) viewFindViewById.findViewById(C5419R.id.overlay_open_app);
                            if (textView4 != null) {
                                i2 = C5419R.id.overlay_switch_channels;
                                TextView textView5 = (TextView) viewFindViewById.findViewById(C5419R.id.overlay_switch_channels);
                                if (textView5 != null) {
                                    C1054t2 c1054t2 = new C1054t2((CardView) viewFindViewById, textView, textView2, textView3, imageView, textView4, textView5);
                                    i = C5419R.id.disconnect_btn;
                                    ImageView imageView2 = (ImageView) findViewById(C5419R.id.disconnect_btn);
                                    if (imageView2 != null) {
                                        i = C5419R.id.mute_toggle;
                                        ImageView imageView3 = (ImageView) findViewById(C5419R.id.mute_toggle);
                                        if (imageView3 != null) {
                                            i = C5419R.id.src_toggle;
                                            ImageView imageView4 = (ImageView) findViewById(C5419R.id.src_toggle);
                                            if (imageView4 != null) {
                                                C1047s2 c1047s2 = new C1047s2(this, c1054t2, imageView2, imageView3, imageView4);
                                                C12238m.checkNotNullExpressionValue(c1047s2, "ViewOverlayMenuBinding.i…ater.from(context), this)");
                                                this.binding = c1047s2;
                                                PublishSubject publishSubjectM11133k0 = PublishSubject.m11133k0();
                                                C12238m.checkNotNullExpressionValue(publishSubjectM11133k0, "PublishSubject.create()");
                                                this.unsubscribeSignal = publishSubjectM11133k0;
                                                this.onDismissRequested = C13003q.f27625j;
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
        Observable<R> observableM11099Y = StoreStream.INSTANCE.getVoiceChannelSelected().observeSelectedChannel().m11099Y(C1379r.f2068j);
        C12238m.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n            …        }\n              }");
        Observable observableM11112r = ObservableExtensionsKt.computationLatest(observableM11099Y).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "StoreStream\n            …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11112r, this, null, 2, null), (Class<?>) OverlayMenuView.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C7086b());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        getUnsubscribeSignal().onNext(null);
        super.onDetachedFromWindow();
    }

    public final void setOnDismissRequested$app_productionGoogleRelease(Function0<Unit> function0) {
        C12238m.checkNotNullParameter(function0, "<set-?>");
        this.onDismissRequested = function0;
    }
}
