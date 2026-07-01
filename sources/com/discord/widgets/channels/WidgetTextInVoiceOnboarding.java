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
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetTextInVoiceOnboardingBinding;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetTextInVoiceOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetTextInVoiceOnboarding extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetTextInVoiceOnboarding.class, "binding", "getBinding()Lcom/discord/databinding/WidgetTextInVoiceOnboardingBinding;", 0)};

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
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(onCtaClicked, "onCtaClicked");
            WidgetTextInVoiceOnboarding widgetTextInVoiceOnboarding = new WidgetTextInVoiceOnboarding();
            widgetTextInVoiceOnboarding.onCtaClicked = onCtaClicked;
            widgetTextInVoiceOnboarding.show(fragmentManager, "javaClass");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetTextInVoiceOnboarding$hideVideoOverlay$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetTextInVoiceOnboarding.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ViewPropertyAnimator, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewPropertyAnimator viewPropertyAnimator) {
            invoke2(viewPropertyAnimator);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewPropertyAnimator viewPropertyAnimator) {
            Intrinsics3.checkNotNullParameter(viewPropertyAnimator, "$receiver");
            viewPropertyAnimator.scaleX(2.0f);
            viewPropertyAnimator.scaleY(2.0f);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetTextInVoiceOnboarding$showVideoOverlay$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetTextInVoiceOnboarding.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "view");
            view.setScaleX(2.0f);
            view.setScaleY(2.0f);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetTextInVoiceOnboarding$showVideoOverlay$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetTextInVoiceOnboarding.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<ViewPropertyAnimator, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewPropertyAnimator viewPropertyAnimator) {
            invoke2(viewPropertyAnimator);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewPropertyAnimator viewPropertyAnimator) {
            Intrinsics3.checkNotNullParameter(viewPropertyAnimator, "$receiver");
            viewPropertyAnimator.scaleX(1.0f);
            viewPropertyAnimator.scaleY(1.0f);
        }
    }

    public WidgetTextInVoiceOnboarding() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetTextInVoiceOnboarding2.INSTANCE, null, 2, null);
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
                    View viewFindViewById = dialog != null ? dialog.findViewById(R.id.design_bottom_sheet) : null;
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
        FrameLayout frameLayout = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.textInVoiceOnboardingVideoContainer");
        frameLayout.setClipToOutline(true);
        getBinding().d.setVideoPath(videoUrl);
        hideVideoOverlay();
        getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.WidgetTextInVoiceOnboarding.configureMedia.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                VideoView videoView = WidgetTextInVoiceOnboarding.this.getBinding().d;
                Intrinsics3.checkNotNullExpressionValue(videoView, "binding.textInVoiceOnboardingVideo");
                if (videoView.isPlaying()) {
                    WidgetTextInVoiceOnboarding.this.showVideoOverlay();
                    WidgetTextInVoiceOnboarding.this.getBinding().d.pause();
                } else {
                    WidgetTextInVoiceOnboarding.this.hideVideoOverlay();
                    WidgetTextInVoiceOnboarding.this.getBinding().d.start();
                }
            }
        });
        getBinding().d.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.discord.widgets.channels.WidgetTextInVoiceOnboarding.configureMedia.3
            @Override // android.media.MediaPlayer.OnPreparedListener
            public final void onPrepared(MediaPlayer mediaPlayer) {
                Intrinsics3.checkNotNullParameter(mediaPlayer, "mp");
                mediaPlayer.start();
                mediaPlayer.setLooping(true);
                VideoView videoView = WidgetTextInVoiceOnboarding.this.getBinding().d;
                Intrinsics3.checkNotNullExpressionValue(videoView, "binding.textInVoiceOnboardingVideo");
                videoView.getLayoutParams().height = -2;
                WidgetTextInVoiceOnboarding.this.getBinding().d.requestLayout();
            }
        });
        getBinding().d.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.discord.widgets.channels.WidgetTextInVoiceOnboarding.configureMedia.4
            @Override // android.media.MediaPlayer.OnInfoListener
            public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                if (i != 3) {
                    return false;
                }
                ImageView imageView = WidgetTextInVoiceOnboarding.this.getBinding().g;
                Intrinsics3.checkNotNullExpressionValue(imageView, "binding.textInVoiceOnboardingVideoPlaceholder");
                imageView.setVisibility(4);
                VideoView videoView = WidgetTextInVoiceOnboarding.this.getBinding().d;
                Intrinsics3.checkNotNullExpressionValue(videoView, "binding.textInVoiceOnboardingVideo");
                videoView.getLayoutParams().height = -2;
                WidgetTextInVoiceOnboarding.this.getBinding().d.requestLayout();
                return false;
            }
        });
    }

    private final WidgetTextInVoiceOnboardingBinding getBinding() {
        return (WidgetTextInVoiceOnboardingBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void hideVideoOverlay() {
        ViewExtensions.fadeOut$default(getBinding().f, 200L, AnonymousClass1.INSTANCE, null, 4, null);
    }

    private final void showVideoOverlay() {
        ViewExtensions.fadeIn$default(getBinding().f, 200L, AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE, null, 8, null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_text_in_voice_onboarding;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetCollapsedStateDisabled();
        new TextInVoiceOnboardingManager().markSeen();
        getBinding().f2666b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.WidgetTextInVoiceOnboarding.onViewCreated.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetTextInVoiceOnboarding.this.dismiss();
            }
        });
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.channels.WidgetTextInVoiceOnboarding.onViewCreated.2
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
