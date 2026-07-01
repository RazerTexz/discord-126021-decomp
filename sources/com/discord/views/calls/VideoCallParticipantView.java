package com.discord.views.calls;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.core.content.ContextCompat;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.ViewGroupKt;
import b.a.i.h4;
import b.a.k.b;
import b.a.y.j0.j;
import b.a.y.j0.k;
import b.a.y.j0.l;
import b.a.y.j0.n;
import b.a.y.j0.o;
import com.discord.R$a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.stores.StoreApplicationStreamPreviews$StreamPreview;
import com.discord.stores.StoreApplicationStreamPreviews$StreamPreview$Resolved;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.utilities.colors.RepresentativeColorsKt;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1;
import com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.grid.FrameGridLayout$Data;
import com.discord.utilities.view.grid.FrameGridLayout$DataView;
import com.discord.utilities.view.grid.FrameGridLayout$DataView$DefaultImpls;
import com.discord.views.VoiceUserView;
import com.discord.widgets.voice.fullscreen.grid.VideoCallGridAdapter$CallUiInsets;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g0.w;
import d0.z.d.m;
import defpackage.r;
import defpackage.t;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: VideoCallParticipantView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VideoCallParticipantView extends ConstraintLayout implements FrameGridLayout$DataView {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final h4 binding;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final boolean matchVideoOrientation;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public VideoCallParticipantView$ParticipantData data;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public String userAvatarUrl;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public Function1<? super String, Unit> onWatchStreamClicked;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public Subscription representativeColorSubscription;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public boolean animateLabelFades;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public Subscription frameRenderedSubscription;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public DisplayCutoutCompat displayCutout;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    public boolean canOverlapTopCutout;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    public VideoCallGridAdapter$CallUiInsets callUiInsets;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    public boolean controlsVisible;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    public Drawable livePillBg;

    /* JADX INFO: renamed from: w, reason: from kotlin metadata */
    public Drawable liveSplitPillBg;

    /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
    public Function2<? super VideoCallParticipantView$StreamResolution, ? super VideoCallParticipantView$StreamFps, Unit> onStreamQualityIndicatorClicked;

    /* JADX INFO: renamed from: y, reason: collision with root package name and from kotlin metadata */
    public Function2<? super VideoCallParticipantView$StreamResolution, ? super VideoCallParticipantView$StreamFps, Unit> onStreamQualityIndicatorShown;

    public VideoCallParticipantView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public VideoCallParticipantView(Context context, AttributeSet attributeSet, int i, int i2) {
        boolean z2;
        AttributeSet attributeSet2 = (i2 & 2) != 0 ? null : attributeSet;
        int i3 = (i2 & 4) != 0 ? 0 : i;
        m.checkNotNullParameter(context, "context");
        super(context, attributeSet2, i3);
        LayoutInflater.from(context).inflate(R$layout.view_video_call_participant, this);
        int i4 = R$id.participant_bg_avatar;
        View viewFindViewById = findViewById(R$id.participant_bg_avatar);
        if (viewFindViewById != null) {
            i4 = R$id.participant_bg_letterbox;
            View viewFindViewById2 = findViewById(R$id.participant_bg_letterbox);
            if (viewFindViewById2 != null) {
                i4 = R$id.participant_deafen_status_indicator;
                ImageView imageView = (ImageView) findViewById(R$id.participant_deafen_status_indicator);
                if (imageView != null) {
                    i4 = R$id.participant_fullscreen_streamqual_container;
                    ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R$id.participant_fullscreen_streamqual_container);
                    if (constraintLayout != null) {
                        i4 = R$id.participant_fullscreen_streamqual_divider;
                        Space space = (Space) findViewById(R$id.participant_fullscreen_streamqual_divider);
                        if (space != null) {
                            i4 = R$id.participant_fullscreen_streamqual_icon;
                            ImageView imageView2 = (ImageView) findViewById(R$id.participant_fullscreen_streamqual_icon);
                            if (imageView2 != null) {
                                i4 = R$id.participant_fullscreen_streamqual_info;
                                TextView textView = (TextView) findViewById(R$id.participant_fullscreen_streamqual_info);
                                if (textView != null) {
                                    i4 = R$id.participant_fullscreen_streamqual_info_container;
                                    LinearLayout linearLayout = (LinearLayout) findViewById(R$id.participant_fullscreen_streamqual_info_container);
                                    if (linearLayout != null) {
                                        i4 = R$id.participant_fullscreen_streamqual_live_indicator;
                                        TextView textView2 = (TextView) findViewById(R$id.participant_fullscreen_streamqual_live_indicator);
                                        if (textView2 != null) {
                                            i4 = R$id.participant_live_indicator;
                                            TextView textView3 = (TextView) findViewById(R$id.participant_live_indicator);
                                            if (textView3 != null) {
                                                i4 = R$id.participant_mute_status_indicator;
                                                ImageView imageView3 = (ImageView) findViewById(R$id.participant_mute_status_indicator);
                                                if (imageView3 != null) {
                                                    i4 = R$id.participant_stream_ended;
                                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) findViewById(R$id.participant_stream_ended);
                                                    if (constraintLayout2 != null) {
                                                        i4 = R$id.participant_stream_ended_img;
                                                        ImageView imageView4 = (ImageView) findViewById(R$id.participant_stream_ended_img);
                                                        if (imageView4 != null) {
                                                            i4 = R$id.participant_stream_ended_label;
                                                            TextView textView4 = (TextView) findViewById(R$id.participant_stream_ended_label);
                                                            if (textView4 != null) {
                                                                i4 = R$id.participant_stream_paused;
                                                                TextView textView5 = (TextView) findViewById(R$id.participant_stream_paused);
                                                                if (textView5 != null) {
                                                                    i4 = R$id.participant_stream_preview_image;
                                                                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R$id.participant_stream_preview_image);
                                                                    if (simpleDraweeView != null) {
                                                                        i4 = R$id.participant_stream_preview_text;
                                                                        TextView textView6 = (TextView) findViewById(R$id.participant_stream_preview_text);
                                                                        if (textView6 != null) {
                                                                            i4 = R$id.participant_video_label;
                                                                            TextView textView7 = (TextView) findViewById(R$id.participant_video_label);
                                                                            if (textView7 != null) {
                                                                                i4 = R$id.participant_video_loading_indicator;
                                                                                ProgressBar progressBar = (ProgressBar) findViewById(R$id.participant_video_loading_indicator);
                                                                                if (progressBar != null) {
                                                                                    i4 = R$id.participant_video_stream_renderer;
                                                                                    AppVideoStreamRenderer appVideoStreamRenderer = (AppVideoStreamRenderer) findViewById(R$id.participant_video_stream_renderer);
                                                                                    if (appVideoStreamRenderer != null) {
                                                                                        i4 = R$id.participant_voice_indicators;
                                                                                        LinearLayout linearLayout2 = (LinearLayout) findViewById(R$id.participant_voice_indicators);
                                                                                        if (linearLayout2 != null) {
                                                                                            i4 = R$id.participant_voice_user_view;
                                                                                            VoiceUserView voiceUserView = (VoiceUserView) findViewById(R$id.participant_voice_user_view);
                                                                                            if (voiceUserView != null) {
                                                                                                AttributeSet attributeSet3 = attributeSet2;
                                                                                                h4 h4Var = new h4(this, viewFindViewById, viewFindViewById2, imageView, constraintLayout, space, imageView2, textView, linearLayout, textView2, textView3, imageView3, constraintLayout2, imageView4, textView4, textView5, simpleDraweeView, textView6, textView7, progressBar, appVideoStreamRenderer, linearLayout2, voiceUserView);
                                                                                                m.checkNotNullExpressionValue(h4Var, "ViewVideoCallParticipant…ater.from(context), this)");
                                                                                                this.binding = h4Var;
                                                                                                this.onWatchStreamClicked = j.j;
                                                                                                this.callUiInsets = new VideoCallGridAdapter$CallUiInsets(0, 0, 0, 0);
                                                                                                this.livePillBg = ContextCompat.getDrawable(context, 2131231038);
                                                                                                this.liveSplitPillBg = ContextCompat.getDrawable(context, 2131231039);
                                                                                                this.onStreamQualityIndicatorClicked = t.j;
                                                                                                this.onStreamQualityIndicatorShown = t.k;
                                                                                                if (attributeSet3 != null) {
                                                                                                    TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet3, R$a.VideoCallParticipantView, 0, 0);
                                                                                                    m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…            0\n          )");
                                                                                                    z2 = typedArrayObtainStyledAttributes.getBoolean(0, false);
                                                                                                    this.matchVideoOrientation = typedArrayObtainStyledAttributes.getBoolean(1, false);
                                                                                                    typedArrayObtainStyledAttributes.recycle();
                                                                                                } else {
                                                                                                    this.matchVideoOrientation = false;
                                                                                                    z2 = false;
                                                                                                }
                                                                                                r31.setIsOverlay(z2);
                                                                                                appVideoStreamRenderer.setMatchVideoOrientation(this.matchVideoOrientation);
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
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i4)));
    }

    public static /* synthetic */ void d(VideoCallParticipantView videoCallParticipantView, VideoCallParticipantView$ParticipantData videoCallParticipantView$ParticipantData, DisplayCutoutCompat displayCutoutCompat, boolean z2, VideoCallGridAdapter$CallUiInsets videoCallGridAdapter$CallUiInsets, boolean z3, int i) {
        DisplayCutoutCompat displayCutoutCompat2 = (i & 2) != 0 ? videoCallParticipantView.displayCutout : null;
        if ((i & 4) != 0) {
            z2 = videoCallParticipantView.canOverlapTopCutout;
        }
        boolean z4 = z2;
        VideoCallGridAdapter$CallUiInsets videoCallGridAdapter$CallUiInsets2 = (i & 8) != 0 ? videoCallParticipantView.callUiInsets : null;
        if ((i & 16) != 0) {
            z3 = videoCallParticipantView.controlsVisible;
        }
        videoCallParticipantView.c(videoCallParticipantView$ParticipantData, displayCutoutCompat2, z4, videoCallGridAdapter$CallUiInsets2, z3);
    }

    public final void a(VideoCallParticipantView$ParticipantData participantData) {
        CharSequence charSequenceH;
        VideoCallParticipantView$ParticipantData$a videoCallParticipantView$ParticipantData$a = participantData.streamQualityIndicatorData;
        if (!participantData.isFocused || !this.controlsVisible || videoCallParticipantView$ParticipantData$a == null) {
            b(false);
            return;
        }
        ConstraintLayout constraintLayout = this.binding.e;
        constraintLayout.setTranslationX(-this.callUiInsets.getRight());
        constraintLayout.setTranslationY(this.callUiInsets.getTop());
        constraintLayout.setOnClickListener(new VideoCallParticipantView$a(this, videoCallParticipantView$ParticipantData$a));
        ImageView imageView = this.binding.f;
        m.checkNotNullExpressionValue(imageView, "binding.participantFullscreenStreamqualIcon");
        imageView.setVisibility(videoCallParticipantView$ParticipantData$a.a ? 0 : 8);
        VideoCallParticipantView$StreamResolution videoCallParticipantView$StreamResolution = videoCallParticipantView$ParticipantData$a.f2841b;
        Context context = getContext();
        m.checkNotNullExpressionValue(context, "context");
        CharSequence charSequenceA = videoCallParticipantView$StreamResolution.a(context);
        VideoCallParticipantView$StreamFps videoCallParticipantView$StreamFps = videoCallParticipantView$ParticipantData$a.c;
        if (videoCallParticipantView$StreamFps != null) {
            Context context2 = getContext();
            m.checkNotNullExpressionValue(context2, "context");
            m.checkNotNullParameter(context2, "context");
            charSequenceH = b.h(context2, 2131895275, new Object[]{Integer.valueOf(videoCallParticipantView$StreamFps.fps)}, null, 4);
        } else {
            charSequenceH = "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(charSequenceA);
        sb.append(' ');
        sb.append(charSequenceH);
        String string = sb.toString();
        Objects.requireNonNull(string, "null cannot be cast to non-null type kotlin.CharSequence");
        String string2 = w.trim(string).toString();
        Drawable drawable = (!(string2.length() == 0) || videoCallParticipantView$ParticipantData$a.a) ? this.liveSplitPillBg : this.livePillBg;
        TextView textView = this.binding.h;
        m.checkNotNullExpressionValue(textView, "binding.participantFulls…enStreamqualLiveIndicator");
        textView.setBackground(drawable);
        int i = videoCallParticipantView$ParticipantData$a.d ? 2131100171 : 2131100487;
        TextView textView2 = this.binding.g;
        textView2.setText(string2);
        CharSequence text = textView2.getText();
        m.checkNotNullExpressionValue(text, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        textView2.setVisibility(text.length() > 0 ? 0 : 8);
        textView2.setTextColor(ContextCompat.getColor(textView2.getContext(), i));
        textView2.requestLayout();
        this.onStreamQualityIndicatorShown.invoke(videoCallParticipantView$ParticipantData$a.f2841b, videoCallParticipantView$ParticipantData$a.c);
        b(true);
    }

    public final void b(boolean visible) {
        ViewExtensions.fadeBy(this.binding.e, visible, 200L);
    }

    /* JADX WARN: Code duplicated, block: B:141:0x047e  */
    @MainThread
    public final void c(VideoCallParticipantView$ParticipantData data, DisplayCutoutCompat displayCutout, boolean canOverlapTopCutout, VideoCallGridAdapter$CallUiInsets callUiInsets, boolean controlsVisible) {
        VideoCallParticipantView$ParticipantData$Type videoCallParticipantView$ParticipantData$Type;
        boolean z2;
        int i;
        m.checkNotNullParameter(callUiInsets, "callUiInsets");
        this.displayCutout = displayCutout;
        this.canOverlapTopCutout = canOverlapTopCutout;
        this.callUiInsets = callUiInsets;
        this.controlsVisible = controlsVisible;
        StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser = data != null ? data.voiceParticipant : null;
        if (storeVoiceParticipants$VoiceUser != null) {
            String colorId = RepresentativeColorsKt.getColorId(storeVoiceParticipants$VoiceUser.getUser());
            this.binding.f128s.setOnBitmapLoadedListener(new k(colorId));
            this.binding.f128s.a(storeVoiceParticipants$VoiceUser, 2131165291);
            Subscription subscription = this.representativeColorSubscription;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            Observable<Integer> observableB0 = RepresentativeColorsKt.getUserRepresentativeColors().observeRepresentativeColor(colorId).b0(l.j);
            m.checkNotNullExpressionValue(observableB0, "UserRepresentativeColors….takeUntil { it != null }");
            ObservableExtensionsKt.appSubscribe$default(observableB0, VideoCallParticipantView.class, (Context) null, new r(1, this), (Function1) null, (Function0) null, (Function0) null, new b.a.y.j0.m(this), 58, (Object) null);
        }
        String forUser$default = IconUtils.getForUser$default(storeVoiceParticipants$VoiceUser != null ? storeVoiceParticipants$VoiceUser.getUser() : null, false, null, 6, null);
        if (!m.areEqual(forUser$default, this.userAvatarUrl)) {
            this.userAvatarUrl = forUser$default;
        }
        VideoCallParticipantView$ParticipantData videoCallParticipantView$ParticipantData = this.data;
        if (videoCallParticipantView$ParticipantData == null || (videoCallParticipantView$ParticipantData$Type = videoCallParticipantView$ParticipantData.type) == null) {
            videoCallParticipantView$ParticipantData$Type = VideoCallParticipantView$ParticipantData$Type.DEFAULT;
        }
        boolean z3 = videoCallParticipantView$ParticipantData != null && videoCallParticipantView$ParticipantData.isFocused;
        Integer numB = videoCallParticipantView$ParticipantData != null ? videoCallParticipantView$ParticipantData.b() : null;
        this.data = data;
        Integer numB2 = data != null ? data.b() : null;
        Integer numB3 = data != null ? data.b() : null;
        if (!m.areEqual(numB3, numB)) {
            if (numB3 != null) {
                AppVideoStreamRenderer appVideoStreamRenderer = this.binding.q;
                m.checkNotNullExpressionValue(appVideoStreamRenderer, "binding.participantVideoStreamRenderer");
                appVideoStreamRenderer.setVisibility(8);
                View view = this.binding.c;
                m.checkNotNullExpressionValue(view, "binding.participantBgLetterbox");
                SimpleDraweeView simpleDraweeView = this.binding.m;
                m.checkNotNullExpressionValue(simpleDraweeView, "binding.participantStreamPreviewImage");
                view.setVisibility((simpleDraweeView.getVisibility() == 0) ^ true ? 0 : 8);
                ProgressBar progressBar = this.binding.p;
                m.checkNotNullExpressionValue(progressBar, "binding.participantVideoLoadingIndicator");
                progressBar.setVisibility(0);
            } else {
                AppVideoStreamRenderer appVideoStreamRenderer2 = this.binding.q;
                m.checkNotNullExpressionValue(appVideoStreamRenderer2, "binding.participantVideoStreamRenderer");
                appVideoStreamRenderer2.setVisibility(8);
                View view2 = this.binding.c;
                m.checkNotNullExpressionValue(view2, "binding.participantBgLetterbox");
                view2.setVisibility(8);
                ProgressBar progressBar2 = this.binding.p;
                m.checkNotNullExpressionValue(progressBar2, "binding.participantVideoLoadingIndicator");
                progressBar2.setVisibility(8);
            }
        }
        boolean z4 = z3;
        VideoCallParticipantView$ParticipantData$Type videoCallParticipantView$ParticipantData$Type2 = videoCallParticipantView$ParticipantData$Type;
        Integer num = numB2;
        if ((data != null ? data.type : null) == VideoCallParticipantView$ParticipantData$Type.APPLICATION_STREAMING) {
            View view3 = this.binding.f127b;
            m.checkNotNullExpressionValue(view3, "binding.participantBgAvatar");
            view3.setVisibility(8);
            VoiceUserView voiceUserView = this.binding.f128s;
            m.checkNotNullExpressionValue(voiceUserView, "binding.participantVoiceUserView");
            voiceUserView.setVisibility(8);
            ImageView imageView = this.binding.j;
            m.checkNotNullExpressionValue(imageView, "binding.participantMuteStatusIndicator");
            imageView.setVisibility(8);
            ImageView imageView2 = this.binding.d;
            m.checkNotNullExpressionValue(imageView2, "binding.participantDeafenStatusIndicator");
            imageView2.setVisibility(8);
            VideoCallParticipantView$ParticipantData$ApplicationStreamState videoCallParticipantView$ParticipantData$ApplicationStreamState = data.applicationStreamState;
            if (videoCallParticipantView$ParticipantData$ApplicationStreamState != null) {
                int iOrdinal = videoCallParticipantView$ParticipantData$ApplicationStreamState.ordinal();
                if (iOrdinal == 0) {
                    ProgressBar progressBar3 = this.binding.p;
                    m.checkNotNullExpressionValue(progressBar3, "binding.participantVideoLoadingIndicator");
                    progressBar3.setVisibility(0);
                    TextView textView = this.binding.l;
                    m.checkNotNullExpressionValue(textView, "binding.participantStreamPaused");
                    textView.setVisibility(8);
                    ConstraintLayout constraintLayout = this.binding.k;
                    m.checkNotNullExpressionValue(constraintLayout, "binding.participantStreamEnded");
                    constraintLayout.setVisibility(8);
                    SimpleDraweeView simpleDraweeView2 = this.binding.m;
                    m.checkNotNullExpressionValue(simpleDraweeView2, "binding.participantStreamPreviewImage");
                    simpleDraweeView2.setVisibility(0);
                    TextView textView2 = this.binding.n;
                    m.checkNotNullExpressionValue(textView2, "binding.participantStreamPreviewText");
                    textView2.setVisibility(8);
                    TextView textView3 = this.binding.i;
                    m.checkNotNullExpressionValue(textView3, "binding.participantLiveIndicator");
                    textView3.setVisibility(data.isFocused ^ true ? 0 : 8);
                    b(false);
                } else if (iOrdinal == 1) {
                    TextView textView4 = this.binding.n;
                    m.checkNotNullExpressionValue(textView4, "binding.participantStreamPreviewText");
                    textView4.setVisibility(8);
                    TextView textView5 = this.binding.l;
                    m.checkNotNullExpressionValue(textView5, "binding.participantStreamPaused");
                    textView5.setVisibility(8);
                    ConstraintLayout constraintLayout2 = this.binding.k;
                    m.checkNotNullExpressionValue(constraintLayout2, "binding.participantStreamEnded");
                    constraintLayout2.setVisibility(8);
                    TextView textView6 = this.binding.i;
                    m.checkNotNullExpressionValue(textView6, "binding.participantLiveIndicator");
                    textView6.setVisibility(data.isFocused ^ true ? 0 : 8);
                    a(data);
                } else if (iOrdinal == 2) {
                    ProgressBar progressBar4 = this.binding.p;
                    m.checkNotNullExpressionValue(progressBar4, "binding.participantVideoLoadingIndicator");
                    progressBar4.setVisibility(8);
                    SimpleDraweeView simpleDraweeView3 = this.binding.m;
                    m.checkNotNullExpressionValue(simpleDraweeView3, "binding.participantStreamPreviewImage");
                    simpleDraweeView3.setVisibility(0);
                    TextView textView7 = this.binding.n;
                    m.checkNotNullExpressionValue(textView7, "binding.participantStreamPreviewText");
                    textView7.setVisibility(0);
                    TextView textView8 = this.binding.l;
                    m.checkNotNullExpressionValue(textView8, "binding.participantStreamPaused");
                    textView8.setVisibility(8);
                    ConstraintLayout constraintLayout3 = this.binding.k;
                    m.checkNotNullExpressionValue(constraintLayout3, "binding.participantStreamEnded");
                    constraintLayout3.setVisibility(8);
                    TextView textView9 = this.binding.i;
                    m.checkNotNullExpressionValue(textView9, "binding.participantLiveIndicator");
                    textView9.setVisibility(8);
                    this.binding.n.setOnClickListener(new n(this, data));
                    StreamContext streamContext = data.voiceParticipant.getStreamContext();
                    StoreApplicationStreamPreviews$StreamPreview preview = streamContext != null ? streamContext.getPreview() : null;
                    if (preview instanceof StoreApplicationStreamPreviews$StreamPreview$Resolved) {
                        this.binding.m.setImageURI(((StoreApplicationStreamPreviews$StreamPreview$Resolved) preview).getUrl());
                        SimpleDraweeView simpleDraweeView4 = this.binding.m;
                        m.checkNotNullExpressionValue(simpleDraweeView4, "binding.participantStreamPreviewImage");
                        ViewGroup$LayoutParams layoutParams = simpleDraweeView4.getLayoutParams();
                        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                        ConstraintLayout$LayoutParams constraintLayout$LayoutParams = (ConstraintLayout$LayoutParams) layoutParams;
                        constraintLayout$LayoutParams.dimensionRatio = "16:9";
                        simpleDraweeView4.setLayoutParams(constraintLayout$LayoutParams);
                    } else {
                        this.binding.m.setImageURI((String) null);
                        SimpleDraweeView simpleDraweeView5 = this.binding.m;
                        m.checkNotNullExpressionValue(simpleDraweeView5, "binding.participantStreamPreviewImage");
                        ViewGroup$LayoutParams layoutParams2 = simpleDraweeView5.getLayoutParams();
                        Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                        ConstraintLayout$LayoutParams constraintLayout$LayoutParams2 = (ConstraintLayout$LayoutParams) layoutParams2;
                        constraintLayout$LayoutParams2.dimensionRatio = null;
                        simpleDraweeView5.setLayoutParams(constraintLayout$LayoutParams2);
                    }
                    b(false);
                } else if (iOrdinal == 3) {
                    ProgressBar progressBar5 = this.binding.p;
                    m.checkNotNullExpressionValue(progressBar5, "binding.participantVideoLoadingIndicator");
                    progressBar5.setVisibility(8);
                    SimpleDraweeView simpleDraweeView6 = this.binding.m;
                    m.checkNotNullExpressionValue(simpleDraweeView6, "binding.participantStreamPreviewImage");
                    simpleDraweeView6.setVisibility(0);
                    TextView textView10 = this.binding.n;
                    m.checkNotNullExpressionValue(textView10, "binding.participantStreamPreviewText");
                    textView10.setVisibility(8);
                    TextView textView11 = this.binding.l;
                    m.checkNotNullExpressionValue(textView11, "binding.participantStreamPaused");
                    textView11.setVisibility(0);
                    ConstraintLayout constraintLayout4 = this.binding.k;
                    m.checkNotNullExpressionValue(constraintLayout4, "binding.participantStreamEnded");
                    constraintLayout4.setVisibility(8);
                    TextView textView12 = this.binding.i;
                    m.checkNotNullExpressionValue(textView12, "binding.participantLiveIndicator");
                    textView12.setVisibility(data.isFocused ^ true ? 0 : 8);
                    a(data);
                } else if (iOrdinal == 4) {
                    ProgressBar progressBar6 = this.binding.p;
                    m.checkNotNullExpressionValue(progressBar6, "binding.participantVideoLoadingIndicator");
                    progressBar6.setVisibility(8);
                    TextView textView13 = this.binding.n;
                    m.checkNotNullExpressionValue(textView13, "binding.participantStreamPreviewText");
                    textView13.setVisibility(8);
                    TextView textView14 = this.binding.l;
                    m.checkNotNullExpressionValue(textView14, "binding.participantStreamPaused");
                    textView14.setVisibility(8);
                    ConstraintLayout constraintLayout5 = this.binding.k;
                    m.checkNotNullExpressionValue(constraintLayout5, "binding.participantStreamEnded");
                    constraintLayout5.setVisibility(0);
                    TextView textView15 = this.binding.i;
                    m.checkNotNullExpressionValue(textView15, "binding.participantLiveIndicator");
                    textView15.setVisibility(8);
                    b(false);
                }
            }
        } else {
            SimpleDraweeView simpleDraweeView7 = this.binding.m;
            m.checkNotNullExpressionValue(simpleDraweeView7, "binding.participantStreamPreviewImage");
            simpleDraweeView7.setVisibility(8);
            TextView textView16 = this.binding.n;
            m.checkNotNullExpressionValue(textView16, "binding.participantStreamPreviewText");
            textView16.setVisibility(8);
            TextView textView17 = this.binding.l;
            m.checkNotNullExpressionValue(textView17, "binding.participantStreamPaused");
            textView17.setVisibility(8);
            ConstraintLayout constraintLayout6 = this.binding.k;
            m.checkNotNullExpressionValue(constraintLayout6, "binding.participantStreamEnded");
            constraintLayout6.setVisibility(8);
            b(false);
            ImageView imageView3 = this.binding.j;
            m.checkNotNullExpressionValue(imageView3, "binding.participantMuteStatusIndicator");
            imageView3.setVisibility(storeVoiceParticipants$VoiceUser != null ? storeVoiceParticipants$VoiceUser.getIsMuted() : false ? 0 : 8);
            ImageView imageView4 = this.binding.d;
            m.checkNotNullExpressionValue(imageView4, "binding.participantDeafenStatusIndicator");
            imageView4.setVisibility(storeVoiceParticipants$VoiceUser != null ? storeVoiceParticipants$VoiceUser.getIsDeafened() : false ? 0 : 8);
            if (num != null) {
                View view4 = this.binding.f127b;
                m.checkNotNullExpressionValue(view4, "binding.participantBgAvatar");
                view4.setVisibility(8);
                VoiceUserView voiceUserView2 = this.binding.f128s;
                m.checkNotNullExpressionValue(voiceUserView2, "binding.participantVoiceUserView");
                voiceUserView2.setVisibility(8);
            } else {
                View view5 = this.binding.f127b;
                m.checkNotNullExpressionValue(view5, "binding.participantBgAvatar");
                view5.setVisibility(0);
                VoiceUserView voiceUserView3 = this.binding.f128s;
                m.checkNotNullExpressionValue(voiceUserView3, "binding.participantVoiceUserView");
                voiceUserView3.setVisibility(0);
            }
            TextView textView18 = this.binding.i;
            m.checkNotNullExpressionValue(textView18, "binding.participantLiveIndicator");
            textView18.setVisibility(8);
        }
        LinearLayout linearLayout = this.binding.r;
        m.checkNotNullExpressionValue(linearLayout, "binding.participantVoiceIndicators");
        LinearLayout linearLayout2 = this.binding.r;
        m.checkNotNullExpressionValue(linearLayout2, "binding.participantVoiceIndicators");
        Iterator<View> it = ViewGroupKt.getChildren(linearLayout2).iterator();
        while (true) {
            if (!it.hasNext()) {
                z2 = false;
                break;
            } else {
                if (it.next().getVisibility() == 0) {
                    z2 = true;
                    break;
                }
            }
        }
        linearLayout.setVisibility(z2 ? 0 : 8);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this);
        DisplayCutoutCompat displayCutoutCompat = this.displayCutout;
        if ((displayCutoutCompat != null ? displayCutoutCompat.getSafeInsetTop() : 0) <= 0 || !this.canOverlapTopCutout) {
            TextView textView19 = this.binding.i;
            m.checkNotNullExpressionValue(textView19, "binding.participantLiveIndicator");
            constraintSet.connect(textView19.getId(), 2, 0, 2, DimenUtils.dpToPixels(8));
            TextView textView20 = this.binding.i;
            m.checkNotNullExpressionValue(textView20, "binding.participantLiveIndicator");
            constraintSet.connect(textView20.getId(), 3, 0, 3, DimenUtils.dpToPixels(8));
            TextView textView21 = this.binding.i;
            m.checkNotNullExpressionValue(textView21, "binding.participantLiveIndicator");
            constraintSet.clear(textView21.getId(), 4);
        } else {
            LinearLayout linearLayout3 = this.binding.r;
            m.checkNotNullExpressionValue(linearLayout3, "binding.participantVoiceIndicators");
            if (linearLayout3.getVisibility() == 0) {
                TextView textView110 = this.binding.i;
                m.checkNotNullExpressionValue(textView110, "binding.participantLiveIndicator");
                constraintSet.connect(textView110.getId(), 2, 0, 2, DimenUtils.dpToPixels(8));
                TextView textView22 = this.binding.i;
                m.checkNotNullExpressionValue(textView22, "binding.participantLiveIndicator");
                constraintSet.connect(textView22.getId(), 3, 0, 3, DimenUtils.dpToPixels(8));
                TextView textView23 = this.binding.i;
                m.checkNotNullExpressionValue(textView23, "binding.participantLiveIndicator");
                constraintSet.clear(textView23.getId(), 4);
            } else {
                TextView textView24 = this.binding.i;
                m.checkNotNullExpressionValue(textView24, "binding.participantLiveIndicator");
                constraintSet.connect(textView24.getId(), 2, 0, 2, DimenUtils.dpToPixels(8));
                TextView textView25 = this.binding.i;
                m.checkNotNullExpressionValue(textView25, "binding.participantLiveIndicator");
                constraintSet.connect(textView25.getId(), 4, 0, 4, DimenUtils.dpToPixels(8));
                TextView textView26 = this.binding.i;
                m.checkNotNullExpressionValue(textView26, "binding.participantLiveIndicator");
                constraintSet.clear(textView26.getId(), 3);
            }
        }
        this.binding.q.c(num, data != null ? data.scalingType : null, data != null ? data.scalingTypeMismatchOrientation : null, data != null ? data.mirrorVideo : false);
        Subscription subscription2 = this.frameRenderedSubscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        if (num != null) {
            BehaviorSubject<Point> behaviorSubject = this.binding.q.currentFrameResolutionSubject;
            m.checkNotNullExpressionValue(behaviorSubject, "currentFrameResolutionSubject");
            Observable<R> observableG = behaviorSubject.y(ObservableExtensionsKt$filterNull$1.INSTANCE).G(ObservableExtensionsKt$filterNull$2.INSTANCE);
            m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
            ObservableExtensionsKt.appSubscribe$default(observableG, VideoCallParticipantView.class, (Context) null, new r(0, this), (Function1) null, (Function0) null, (Function0) null, new o(this), 58, (Object) null);
        }
        VideoCallParticipantView$ParticipantData videoCallParticipantView$ParticipantData2 = this.data;
        VideoCallParticipantView$ParticipantData$Type videoCallParticipantView$ParticipantData$Type3 = videoCallParticipantView$ParticipantData2 != null ? videoCallParticipantView$ParticipantData2.type : null;
        boolean z5 = data != null && data.isFocused;
        if (videoCallParticipantView$ParticipantData$Type3 != null && (videoCallParticipantView$ParticipantData$Type3 != videoCallParticipantView$ParticipantData$Type2 || z5 != z4)) {
            if (videoCallParticipantView$ParticipantData$Type3 != VideoCallParticipantView$ParticipantData$Type.DEFAULT || z5) {
                ConstraintLayout$LayoutParams constraintLayout$LayoutParams3 = new ConstraintLayout$LayoutParams(-2, -2);
                AppVideoStreamRenderer appVideoStreamRenderer3 = this.binding.q;
                m.checkNotNullExpressionValue(appVideoStreamRenderer3, "binding.participantVideoStreamRenderer");
                appVideoStreamRenderer3.setLayoutParams(constraintLayout$LayoutParams3);
                AppVideoStreamRenderer appVideoStreamRenderer4 = this.binding.q;
                m.checkNotNullExpressionValue(appVideoStreamRenderer4, "binding.participantVideoStreamRenderer");
                constraintSet.constrainDefaultHeight(appVideoStreamRenderer4.getId(), 1);
                AppVideoStreamRenderer appVideoStreamRenderer5 = this.binding.q;
                m.checkNotNullExpressionValue(appVideoStreamRenderer5, "binding.participantVideoStreamRenderer");
                constraintSet.constrainDefaultWidth(appVideoStreamRenderer5.getId(), 1);
            } else {
                ConstraintLayout$LayoutParams constraintLayout$LayoutParams4 = new ConstraintLayout$LayoutParams(0, 0);
                AppVideoStreamRenderer appVideoStreamRenderer6 = this.binding.q;
                m.checkNotNullExpressionValue(appVideoStreamRenderer6, "binding.participantVideoStreamRenderer");
                appVideoStreamRenderer6.setLayoutParams(constraintLayout$LayoutParams4);
                AppVideoStreamRenderer appVideoStreamRenderer7 = this.binding.q;
                m.checkNotNullExpressionValue(appVideoStreamRenderer7, "binding.participantVideoStreamRenderer");
                constraintSet.constrainHeight(appVideoStreamRenderer7.getId(), 0);
                AppVideoStreamRenderer appVideoStreamRenderer8 = this.binding.q;
                m.checkNotNullExpressionValue(appVideoStreamRenderer8, "binding.participantVideoStreamRenderer");
                constraintSet.constrainWidth(appVideoStreamRenderer8.getId(), 0);
                AppVideoStreamRenderer appVideoStreamRenderer9 = this.binding.q;
                m.checkNotNullExpressionValue(appVideoStreamRenderer9, "binding.participantVideoStreamRenderer");
                constraintSet.constrainDefaultHeight(appVideoStreamRenderer9.getId(), 0);
                AppVideoStreamRenderer appVideoStreamRenderer10 = this.binding.q;
                m.checkNotNullExpressionValue(appVideoStreamRenderer10, "binding.participantVideoStreamRenderer");
                constraintSet.constrainDefaultWidth(appVideoStreamRenderer10.getId(), 0);
            }
        }
        constraintSet.applyTo(this);
        if (storeVoiceParticipants$VoiceUser != null) {
            TextView textView27 = this.binding.o;
            m.checkNotNullExpressionValue(textView27, "binding.participantVideoLabel");
            textView27.setText(storeVoiceParticipants$VoiceUser.getDisplayName());
            if (data.type == VideoCallParticipantView$ParticipantData$Type.APPLICATION_STREAMING) {
                Context context = getContext();
                m.checkNotNullExpressionValue(context, "context");
                i = 0;
                setContentDescription(b.h(context, 2131889785, new Object[]{storeVoiceParticipants$VoiceUser.getDisplayName()}, null, 4));
                this.binding.o.setCompoundDrawablesWithIntrinsicBounds(2131232095, 0, 0, 0);
            } else {
                i = 0;
                setContentDescription(storeVoiceParticipants$VoiceUser.getDisplayName());
                this.binding.o.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            if (this.animateLabelFades) {
                ViewExtensions.fadeBy(this.binding.o, data.showLabel, 200L);
                return;
            }
            TextView textView28 = this.binding.o;
            m.checkNotNullExpressionValue(textView28, "binding.participantVideoLabel");
            if (!data.showLabel) {
                i = 8;
            }
            textView28.setVisibility(i);
            this.animateLabelFades = true;
        }
    }

    public final VideoCallParticipantView$ParticipantData getData() {
        return this.data;
    }

    @Override // com.discord.utilities.view.grid.FrameGridLayout$DataView
    public String getDataId() {
        VideoCallParticipantView$ParticipantData videoCallParticipantView$ParticipantData = this.data;
        if (videoCallParticipantView$ParticipantData != null) {
            return videoCallParticipantView$ParticipantData.id;
        }
        return null;
    }

    @Override // com.discord.utilities.view.grid.FrameGridLayout$DataView
    public void onBind(FrameGridLayout$Data data) {
        m.checkNotNullParameter(data, "data");
        d(this, (VideoCallParticipantView$ParticipantData) data, null, false, null, false, 30);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Subscription subscription = this.representativeColorSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.animateLabelFades = false;
        this.binding.q.c(null, null, null, false);
    }

    @Override // com.discord.utilities.view.grid.FrameGridLayout$DataView
    public void onRemove() {
        FrameGridLayout$DataView$DefaultImpls.onRemove(this);
    }

    public final void setData(VideoCallParticipantView$ParticipantData videoCallParticipantView$ParticipantData) {
        this.data = videoCallParticipantView$ParticipantData;
    }

    public final void setOnWatchStreamClicked(Function1<? super String, Unit> onWatchStreamClicked) {
        m.checkNotNullParameter(onWatchStreamClicked, "onWatchStreamClicked");
        this.onWatchStreamClicked = onWatchStreamClicked;
    }
}
