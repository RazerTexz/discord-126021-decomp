package com.discord.widgets.channels;

import android.app.Dialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.VideoView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetTextInVoiceOnboardingBinding;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetTextInVoiceOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetTextInVoiceOnboarding extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetTextInVoiceOnboarding.class, "binding", "getBinding()Lcom/discord/databinding/WidgetTextInVoiceOnboardingBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String VIDEO_URL = "https://cdn.discordapp.com/attachments/727325253608538113/942859496601043024/Text_in_Voice_NUX_Mobile_In-App.mp4";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Function0<Unit> onCtaClicked;

    /* JADX INFO: compiled from: WidgetTextInVoiceOnboarding.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, Function0<Unit> onCtaClicked) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(onCtaClicked, "onCtaClicked");
            WidgetTextInVoiceOnboarding widgetTextInVoiceOnboarding = new WidgetTextInVoiceOnboarding();
            widgetTextInVoiceOnboarding.onCtaClicked = onCtaClicked;
            widgetTextInVoiceOnboarding.show(fragmentManager, "javaClass");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetTextInVoiceOnboarding$hideVideoOverlay$1 */
    /* JADX INFO: compiled from: WidgetTextInVoiceOnboarding.kt */
    public static final class C73971 extends AbstractC12240o implements Function1<ViewPropertyAnimator, Unit> {
        public static final C73971 INSTANCE = new C73971();

        public C73971() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewPropertyAnimator viewPropertyAnimator) {
            invoke2(viewPropertyAnimator);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewPropertyAnimator viewPropertyAnimator) {
            C12238m.checkNotNullParameter(viewPropertyAnimator, "$receiver");
            viewPropertyAnimator.scaleX(2.0f);
            viewPropertyAnimator.scaleY(2.0f);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetTextInVoiceOnboarding$showVideoOverlay$1 */
    /* JADX INFO: compiled from: WidgetTextInVoiceOnboarding.kt */
    public static final class C74001 extends AbstractC12240o implements Function1<View, Unit> {
        public static final C74001 INSTANCE = new C74001();

        public C74001() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "view");
            view.setScaleX(2.0f);
            view.setScaleY(2.0f);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetTextInVoiceOnboarding$showVideoOverlay$2 */
    /* JADX INFO: compiled from: WidgetTextInVoiceOnboarding.kt */
    public static final class C74012 extends AbstractC12240o implements Function1<ViewPropertyAnimator, Unit> {
        public static final C74012 INSTANCE = new C74012();

        public C74012() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewPropertyAnimator viewPropertyAnimator) {
            invoke2(viewPropertyAnimator);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewPropertyAnimator viewPropertyAnimator) {
            C12238m.checkNotNullParameter(viewPropertyAnimator, "$receiver");
            viewPropertyAnimator.scaleX(1.0f);
            viewPropertyAnimator.scaleY(1.0f);
        }
    }

    public WidgetTextInVoiceOnboarding() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetTextInVoiceOnboarding$binding$2.INSTANCE, null, 2, null);
    }

    private final void configureMedia(String videoUrl) {
        View view = getView();
        if (view != null) {
            view.post(new Runnable() { // from class: com.discord.widgets.channels.WidgetTextInVoiceOnboarding.configureMedia.1
                @Override // java.lang.Runnable
                public final void run() {
                    View view2 = WidgetTextInVoiceOnboarding.this.getView();
                    Integer numValueOf = view2 != null ? Integer.valueOf(view2.getMeasuredHeight()) : null;
                    Dialog dialog = WidgetTextInVoiceOnboarding.this.getDialog();
                    View viewFindViewById = dialog != null ? dialog.findViewById(C5419R.id.design_bottom_sheet) : null;
                    ViewGroup.LayoutParams layoutParams = viewFindViewById != null ? viewFindViewById.getLayoutParams() : null;
                    if (numValueOf == null || numValueOf.intValue() <= 0) {
                        return;
                    }
                    if (layoutParams != null) {
                        layoutParams.height = numValueOf.intValue() + 1;
                    }
                    if (viewFindViewById != null) {
                        viewFindViewById.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        FrameLayout frameLayout = getBinding().f18249e;
        C12238m.checkNotNullExpressionValue(frameLayout, "binding.textInVoiceOnboardingVideoContainer");
        frameLayout.setClipToOutline(true);
        getBinding().f18248d.setVideoPath(videoUrl);
        hideVideoOverlay();
        getBinding().f18248d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.WidgetTextInVoiceOnboarding.configureMedia.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VideoView videoView = WidgetTextInVoiceOnboarding.this.getBinding().f18248d;
                C12238m.checkNotNullExpressionValue(videoView, "binding.textInVoiceOnboardingVideo");
                if (videoView.isPlaying()) {
                    WidgetTextInVoiceOnboarding.this.showVideoOverlay();
                    WidgetTextInVoiceOnboarding.this.getBinding().f18248d.pause();
                } else {
                    WidgetTextInVoiceOnboarding.this.hideVideoOverlay();
                    WidgetTextInVoiceOnboarding.this.getBinding().f18248d.start();
                }
            }
        });
        getBinding().f18248d.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.discord.widgets.channels.WidgetTextInVoiceOnboarding.configureMedia.3
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer) {
                C12238m.checkNotNullParameter(mediaPlayer, "mp");
                mediaPlayer.start();
                mediaPlayer.setLooping(true);
                VideoView videoView = WidgetTextInVoiceOnboarding.this.getBinding().f18248d;
                C12238m.checkNotNullExpressionValue(videoView, "binding.textInVoiceOnboardingVideo");
                videoView.getLayoutParams().height = -2;
                WidgetTextInVoiceOnboarding.this.getBinding().f18248d.requestLayout();
            }
        });
        getBinding().f18248d.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.discord.widgets.channels.WidgetTextInVoiceOnboarding.configureMedia.4
            @Override // android.media.MediaPlayer.OnInfoListener
            public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                if (i != 3) {
                    return false;
                }
                ImageView imageView = WidgetTextInVoiceOnboarding.this.getBinding().f18251g;
                C12238m.checkNotNullExpressionValue(imageView, "binding.textInVoiceOnboardingVideoPlaceholder");
                imageView.setVisibility(4);
                VideoView videoView = WidgetTextInVoiceOnboarding.this.getBinding().f18248d;
                C12238m.checkNotNullExpressionValue(videoView, "binding.textInVoiceOnboardingVideo");
                videoView.getLayoutParams().height = -2;
                WidgetTextInVoiceOnboarding.this.getBinding().f18248d.requestLayout();
                return false;
            }
        });
    }

    private final WidgetTextInVoiceOnboardingBinding getBinding() {
        return (WidgetTextInVoiceOnboardingBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void hideVideoOverlay() {
        ViewExtensions.fadeOut$default(getBinding().f18250f, 200L, C73971.INSTANCE, null, 4, null);
    }

    private final void showVideoOverlay() {
        ViewExtensions.fadeIn$default(getBinding().f18250f, 200L, C74001.INSTANCE, C74012.INSTANCE, null, 8, null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_text_in_voice_onboarding;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetCollapsedStateDisabled();
        new TextInVoiceOnboardingManager().markSeen();
        getBinding().f18246b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.WidgetTextInVoiceOnboarding.onViewCreated.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetTextInVoiceOnboarding.this.dismiss();
            }
        });
        getBinding().f18247c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.WidgetTextInVoiceOnboarding.onViewCreated.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Function0 function0 = WidgetTextInVoiceOnboarding.this.onCtaClicked;
                if (function0 != null) {
                }
                WidgetTextInVoiceOnboarding.this.dismiss();
            }
        });
        configureMedia(VIDEO_URL);
    }
}
