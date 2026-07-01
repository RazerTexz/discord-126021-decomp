package com.discord.widgets.settings.profile;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Selection;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.a.b.MultiValuePropPremiumUpsellDialog;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.a.y.SelectorBottomSheet;
import b.a.y.SelectorBottomSheet2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppTransitionActivity;
import com.discord.databinding.ViewDialogConfirmationBinding;
import com.discord.databinding.WidgetSettingsUserProfileBinding;
import com.discord.simpleast.core.node.Node;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.error.Error;
import com.discord.utilities.file.FileUtils2;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.settings.profile.EditUserOrGuildMemberProfileViewModel2;
import com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet;
import com.discord.widgets.user.Badge;
import com.discord.widgets.user.profile.UserProfileHeaderView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.LazyJVM;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEditUserOrGuildMemberProfile extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetEditUserOrGuildMemberProfile.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsUserProfileBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int MAX_AVATAR_SIZE = 1024;
    public static final int MAX_BANNER_FILE_SIZE_MB = 30;
    public static final int MAX_BANNER_IMAGE_SIZE = 1080;
    private final BehaviorSubject<String> avatarRepresentativeColorHexSubject;
    private Function1<? super String, Unit> avatarSelectedResult;
    private Function1<? super String, Unit> bannerSelectedResult;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final AtomicBoolean discardConfirmed;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private Function1<? super String, Unit> imageSelectedResult;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, AppTransitionActivity.Transition transition, Long l, int i, Object obj) {
            if ((i & 2) != 0) {
                transition = null;
            }
            if ((i & 4) != 0) {
                l = null;
            }
            companion.launch(context, transition, l);
        }

        public final void launch(Context context, AppTransitionActivity.Transition transition, Long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            if (transition != null) {
                intent.putExtra("transition", transition);
            }
            if (guildId != null) {
                intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId.longValue());
            }
            AppScreen2.d(context, WidgetEditUserOrGuildMemberProfile.class, intent);
            StoreAnalytics.onUserSettingsPaneViewed$default(StoreStream.INSTANCE.getAnalytics(), "User Profile", null, 2, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureAvatarSelect$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded loaded) {
            super(1);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "dataUrl");
            if (this.$viewState.getCanHaveAnimatedAvatars() || !IconUtils.INSTANCE.isDataUrlForGif(str)) {
                WidgetEditUserOrGuildMemberProfile.this.getViewModel().updateAvatar(str);
                return;
            }
            MultiValuePropPremiumUpsellDialog.Companion bVar = MultiValuePropPremiumUpsellDialog.INSTANCE;
            FragmentManager parentFragmentManager = WidgetEditUserOrGuildMemberProfile.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            MultiValuePropPremiumUpsellDialog.Companion.a(bVar, parentFragmentManager, 4, WidgetEditUserOrGuildMemberProfile.this.getString(R.string.premium_upsell_animated_avatar_active_mobile), null, Traits.Location.Page.USER_SETTINGS, "User Profile", null, null, false, false, 968);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureAvatarSelect$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ List $avatarSheetOptions;

        /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureAvatarSelect$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<Integer, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.a;
            }

            public final void invoke(int i) {
                if (i != 0) {
                    if (i != 1) {
                        return;
                    }
                    WidgetEditUserOrGuildMemberProfile.this.getViewModel().updateAvatar(null);
                } else {
                    WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile = WidgetEditUserOrGuildMemberProfile.this;
                    widgetEditUserOrGuildMemberProfile.imageSelectedResult = widgetEditUserOrGuildMemberProfile.avatarSelectedResult;
                    WidgetEditUserOrGuildMemberProfile.this.openMediaChooser();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(List list) {
            super(0);
            this.$avatarSheetOptions = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            SelectorBottomSheet.Companion aVar = SelectorBottomSheet.INSTANCE;
            FragmentManager childFragmentManager = WidgetEditUserOrGuildMemberProfile.this.getChildFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            aVar.a(childFragmentManager, "", this.$avatarSheetOptions, false, new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureBannerSelect$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "dataUrl");
            WidgetEditUserOrGuildMemberProfile.this.getViewModel().updateBannerImage(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded $viewState;

        /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {

            /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
            public static final class C03391 extends Lambda implements Function0<Unit> {
                public C03391() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile = WidgetEditUserOrGuildMemberProfile.this;
                    widgetEditUserOrGuildMemberProfile.imageSelectedResult = widgetEditUserOrGuildMemberProfile.bannerSelectedResult;
                    WidgetEditUserOrGuildMemberProfile.this.openMediaChooser();
                }
            }

            /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2$1$2, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
            public static final class C03402 extends Lambda implements Function0<Unit> {
                public C03402() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WidgetEditUserOrGuildMemberProfile.this.getViewModel().updateBannerImage(null);
                }
            }

            /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2$1$3, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
            public static final class AnonymousClass3 extends Lambda implements Function1<Integer, Unit> {
                public AnonymousClass3() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke2(num);
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Integer num) {
                    String colorHexFromColorInt;
                    if (num != null) {
                        colorHexFromColorInt = ColorCompat.INSTANCE.getColorHexFromColorInt(num.intValue());
                    } else {
                        colorHexFromColorInt = null;
                    }
                    WidgetEditUserOrGuildMemberProfile.this.getViewModel().updateBannerColor(colorHexFromColorInt);
                }
            }

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                WidgetEditProfileBannerSheet.Companion companion = WidgetEditProfileBannerSheet.INSTANCE;
                Long guildId = WidgetEditUserOrGuildMemberProfile.this.getGuildId();
                Intrinsics3.checkNotNullExpressionValue(str, "avatarRepresentativeColorHex");
                String nonDefaultColorPreviewHex = AnonymousClass2.this.$viewState.getNonDefaultColorPreviewHex();
                boolean hasBannerImageForDisplay = AnonymousClass2.this.$viewState.getHasBannerImageForDisplay();
                FragmentManager parentFragmentManager = WidgetEditUserOrGuildMemberProfile.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.show(guildId, str, nonDefaultColorPreviewHex, hasBannerImageForDisplay, parentFragmentManager, new C03391(), new C03402(), new AnonymousClass3());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded loaded) {
            super(0);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Observable observableL = WidgetEditUserOrGuildMemberProfile.this.avatarRepresentativeColorHexSubject.Z(1).L();
            Intrinsics3.checkNotNullExpressionValue(observableL, "avatarRepresentativeColo…  .onBackpressureLatest()");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableL, WidgetEditUserOrGuildMemberProfile.this, null, 2, null), (Class<?>) WidgetEditUserOrGuildMemberProfile.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$onViewBound$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<MotionEvent, Boolean> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(MotionEvent motionEvent) {
            return Boolean.valueOf(invoke2(motionEvent));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2(MotionEvent motionEvent) {
            if (motionEvent == null) {
                return false;
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 1 || actionMasked == 3) {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                TextInputLayout textInputLayout = WidgetEditUserOrGuildMemberProfile.this.getBinding().d;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.bioEditorTextInputFieldWrap");
                int width = textInputLayout.getWidth();
                TextInputLayout textInputLayout2 = WidgetEditUserOrGuildMemberProfile.this.getBinding().d;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.bioEditorTextInputFieldWrap");
                int height = textInputLayout2.getHeight();
                int[] iArr = new int[2];
                WidgetEditUserOrGuildMemberProfile.this.getBinding().d.getLocationOnScreen(iArr);
                int i = iArr[0];
                int i2 = iArr[1];
                if (rawX < ((float) i) || rawX > ((float) (i + width)) || rawY < ((float) i2) || rawY > ((float) (i2 + height))) {
                    CardView cardView = WidgetEditUserOrGuildMemberProfile.this.getBinding().f2640b;
                    Intrinsics3.checkNotNullExpressionValue(cardView, "binding.bioEditorCard");
                    if (cardView.getVisibility() == 0) {
                        WidgetEditUserOrGuildMemberProfile.this.setCurrentBioFromEditor();
                    }
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$onViewBound$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<Integer, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            WidgetEditUserOrGuildMemberProfile.this.avatarRepresentativeColorHexSubject.onNext(ColorCompat.INSTANCE.getColorHexFromColorInt(i));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$onViewBound$5, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    public static final class AnonymousClass5 extends Lambda implements Function1<Badge, Unit> {
        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Badge badge) {
            invoke2(badge);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Badge badge) {
            Intrinsics3.checkNotNullParameter(badge, "it");
            Badge.Companion companion = Badge.INSTANCE;
            FragmentManager parentFragmentManager = WidgetEditUserOrGuildMemberProfile.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.onBadgeClick(parentFragmentManager, WidgetEditUserOrGuildMemberProfile.this.requireContext());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<EditUserOrGuildMemberProfileViewModel2.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(EditUserOrGuildMemberProfileViewModel2.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(EditUserOrGuildMemberProfileViewModel2.ViewState viewState) {
            WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile = WidgetEditUserOrGuildMemberProfile.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "viewState");
            widgetEditUserOrGuildMemberProfile.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<EditUserOrGuildMemberProfileViewModel2.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(EditUserOrGuildMemberProfileViewModel2.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(EditUserOrGuildMemberProfileViewModel2.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            WidgetEditUserOrGuildMemberProfile.this.handleEvent(event);
        }
    }

    public WidgetEditUserOrGuildMemberProfile() {
        super(R.layout.widget_settings_user_profile);
        this.avatarSelectedResult = WidgetEditUserOrGuildMemberProfile$avatarSelectedResult$1.INSTANCE;
        this.bannerSelectedResult = WidgetEditUserOrGuildMemberProfile$bannerSelectedResult$1.INSTANCE;
        this.imageSelectedResult = WidgetEditUserOrGuildMemberProfile$imageSelectedResult$1.INSTANCE;
        this.guildId = LazyJVM.lazy(new WidgetEditUserOrGuildMemberProfile$guildId$2(this));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetEditUserOrGuildMemberProfile$binding$2.INSTANCE, null, 2, null);
        WidgetEditUserOrGuildMemberProfile$viewModel$2 widgetEditUserOrGuildMemberProfile$viewModel$2 = new WidgetEditUserOrGuildMemberProfile$viewModel$2(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(EditUserOrGuildMemberProfileViewModel2.class), new WidgetEditUserOrGuildMemberProfile$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetEditUserOrGuildMemberProfile$viewModel$2));
        this.discardConfirmed = new AtomicBoolean(false);
        this.avatarRepresentativeColorHexSubject = BehaviorSubject.k0();
    }

    private final void configureAvatarSelect(EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded viewState) {
        String string;
        this.avatarSelectedResult = new AnonymousClass1(viewState);
        SelectorBottomSheet2[] selectorBottomSheet2Arr = new SelectorBottomSheet2[1];
        if (viewState.getMeMember() != null) {
            string = viewState.getHasAvatarForDisplay() ? getString(R.string.change_guild_member_avatar) : getString(R.string.upload_guild_member_avatar);
        } else {
            string = viewState.getHasAvatarForDisplay() ? getString(R.string.user_settings_change_avatar) : getString(R.string.user_settings_upload_avatar);
        }
        selectorBottomSheet2Arr[0] = new SelectorBottomSheet2(string, null, null, null, null, null, null, 116);
        List listMutableListOf = Collections2.mutableListOf(selectorBottomSheet2Arr);
        if (viewState.getHasAvatarForDisplay()) {
            listMutableListOf.add(new SelectorBottomSheet2(viewState.getMeMember() != null ? getString(R.string.change_identity_modal_reset_primary_avatar) : getString(R.string.user_settings_remove_avatar), null, null, null, null, Integer.valueOf(ColorCompat.getColor(requireContext(), R.color.status_red_500)), null, 84));
        }
        getBinding().o.setOnAvatarEdit(new AnonymousClass2(listMutableListOf));
    }

    private final void configureBannerSelect(EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded viewState) {
        this.bannerSelectedResult = new AnonymousClass1();
        getBinding().o.setOnBannerPress(new AnonymousClass2(viewState));
    }

    private final void configureBio(EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded viewState) {
        Drawable drawable;
        List<Node<MessageRenderContext>> bioAst = viewState.getBioAst();
        boolean showBioEditor = viewState.getShowBioEditor();
        CardView cardView = getBinding().f2640b;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.bioEditorCard");
        boolean z2 = cardView.getVisibility() == 0;
        TextView textView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.bioHelpText");
        textView.setVisibility(viewState.getMeMember() != null ? 0 : 8);
        TextView textView2 = getBinding().e;
        Drawable drawable2 = null;
        textView2.setText(viewState.getMeMember() != null ? FormatUtils.d(textView2, R.string.change_identity_bio_header, new Object[0], (4 & 4) != 0 ? FormatUtils.c.j : null) : FormatUtils.d(textView2, R.string.user_profile_about_me, new Object[0], (4 & 4) != 0 ? FormatUtils.c.j : null));
        if (viewState.getMeMember() != null && (drawable = ContextCompat.getDrawable(textView2.getContext(), R.drawable.ic_nitro_wheel_16dp)) != null) {
            TextView textView3 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.bioHeader");
            DrawableCompat.setTint(drawable, ColorCompat.getThemedColor(textView3, R.attr.colorHeaderSecondary));
            drawable2 = drawable;
        }
        com.discord.utilities.drawable.DrawableCompat.setCompoundDrawablesCompat$default(textView2, (Drawable) null, (Drawable) null, drawable2, (Drawable) null, 11, (Object) null);
        CardView cardView2 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(cardView2, "binding.bioPreviewCard");
        cardView2.setVisibility(showBioEditor ^ true ? 0 : 8);
        CardView cardView3 = getBinding().f2640b;
        Intrinsics3.checkNotNullExpressionValue(cardView3, "binding.bioEditorCard");
        cardView3.setVisibility(showBioEditor ? 0 : 8);
        if (!showBioEditor) {
            if (bioAst != null) {
                LinkifiedTextView linkifiedTextView = getBinding().h;
                Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.bioPreviewText");
                Context context = linkifiedTextView.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "binding.bioPreviewText.context");
                getBinding().h.setDraweeSpanStringBuilder(AstRenderer.render(bioAst, new MessageRenderContext(context, 0L, false, null, null, null, 0, null, null, 0, 0, new WidgetEditUserOrGuildMemberProfile$configureBio$renderContext$1(getViewModel()), null, null, 14328, null)));
                return;
            }
            return;
        }
        TextInputLayout textInputLayout = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.bioEditorTextInputFieldWrap");
        ViewExtensions.setText(textInputLayout, viewState.getCurrentBio());
        if (z2) {
            return;
        }
        getBinding().d.requestFocus();
        TextInputLayout textInputLayout2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.bioEditorTextInputFieldWrap");
        ViewExtensions.moveCursorToEnd(textInputLayout2);
        TextInputLayout textInputLayout3 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout3, "binding.bioEditorTextInputFieldWrap");
        showKeyboard(textInputLayout3);
    }

    private final void configureFab(EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded viewState) {
        FloatingActionButton floatingActionButton = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(floatingActionButton, "binding.saveFab");
        floatingActionButton.setVisibility(viewState.getShowSaveFab() ? 0 : 8);
    }

    private final void configureNick(final EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded viewState) {
        boolean z2 = viewState.getGuild() != null;
        LinearLayout linearLayout = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.nickContainer");
        linearLayout.setVisibility(z2 ? 0 : 8);
        TextInputLayout textInputLayout = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "textInputLayout");
        String currentNickname = viewState.getCurrentNickname();
        textInputLayout.setEndIconVisible(!(currentNickname == null || currentNickname.length() == 0));
        ViewExtensions.setEnabledAndAlpha$default(textInputLayout, viewState.getCanEditNickname(), 0.0f, 2, null);
        textInputLayout.setHint(viewState.getCanEditNickname() ? getString(R.string.nickname) : getString(R.string.change_identity_modal_change_nickname_disabled));
        textInputLayout.setPlaceholderText(viewState.getUser().getUsername());
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new WidgetEditUserOrGuildMemberProfile$configureNick$$inlined$also$lambda$1(this, viewState));
        textInputLayout.setEndIconOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureNick$$inlined$also$lambda$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.this$0.getViewModel().updateNickname("");
            }
        });
        TextInputLayout textInputLayout2 = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.setNicknameText");
        String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout2);
        if (!Intrinsics3.areEqual(viewState.getCurrentNickname(), textOrEmpty)) {
            ViewExtensions.setText(textInputLayout, viewState.getCurrentNickname());
            if (textOrEmpty.length() == 0) {
                EditText editText = textInputLayout.getEditText();
                Selection.setSelection(editText != null ? editText.getText() : null, ViewExtensions.getTextOrEmpty(textInputLayout).length());
            }
        }
    }

    private final void configureUI(final EditUserOrGuildMemberProfileViewModel2.ViewState viewState) {
        if (viewState instanceof EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded) {
            EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded loaded = (EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded) viewState;
            if (loaded.getGuild() != null) {
                setActionBarSubtitle(loaded.getGuild().getName());
            }
            configureNick(loaded);
            getBinding().k.setVisibility(loaded.getGuild() != null ? 0 : 8);
            if (loaded.getGuild() != null) {
                TextView textView = getBinding().j;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildMemberProfileHelpTextOverall");
                textView.setText(FormatUtils.e(this, R.string.change_identity_help_text_overall, new Object[]{loaded.getGuild().getName()}, (4 & 4) != 0 ? FormatUtils.a.j : null));
            }
            configureBio(loaded);
            configureAvatarSelect(loaded);
            configureBannerSelect(loaded);
            configureFab(loaded);
            AppFragment.setOnBackPressed$default(this, new Func0<Boolean>() { // from class: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile.configureUI.3
                @Override // rx.functions.Func0, java.util.concurrent.Callable
                public final Boolean call() {
                    return Boolean.valueOf(WidgetEditUserOrGuildMemberProfile.this.handleBackPressed((EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded) viewState));
                }
            }, 0, 2, null);
        }
    }

    private final WidgetSettingsUserProfileBinding getBinding() {
        return (WidgetSettingsUserProfileBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final Long getGuildId() {
        return (Long) this.guildId.getValue();
    }

    private final EditUserOrGuildMemberProfileViewModel2 getViewModel() {
        return (EditUserOrGuildMemberProfileViewModel2) this.viewModel.getValue();
    }

    private final boolean handleBackPressed(EditUserOrGuildMemberProfileViewModel2.ViewState.Loaded viewState) {
        if (viewState.isEditingBio()) {
            setCurrentBioFromEditor();
            return true;
        }
        if (!viewState.getIsDirty() || this.discardConfirmed.get()) {
            return false;
        }
        ViewDialogConfirmationBinding viewDialogConfirmationBindingB = ViewDialogConfirmationBinding.b(LayoutInflater.from(e()));
        Intrinsics3.checkNotNullExpressionValue(viewDialogConfirmationBindingB, "ViewDialogConfirmationBi…tInflater.from(activity))");
        final AlertDialog alertDialogCreate = new AlertDialog.Builder(requireContext()).setView(viewDialogConfirmationBindingB.a).create();
        Intrinsics3.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(requ…logBinding.root).create()");
        viewDialogConfirmationBindingB.d.setText(R.string.discard_changes);
        viewDialogConfirmationBindingB.e.setText(R.string.discard_changes_description);
        viewDialogConfirmationBindingB.f2185b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile.handleBackPressed.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                alertDialogCreate.dismiss();
            }
        });
        viewDialogConfirmationBindingB.c.setText(R.string.okay);
        viewDialogConfirmationBindingB.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile.handleBackPressed.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetEditUserOrGuildMemberProfile.this.discardConfirmed.set(true);
                alertDialogCreate.dismiss();
                FragmentActivity fragmentActivityE = WidgetEditUserOrGuildMemberProfile.this.e();
                if (fragmentActivityE != null) {
                    fragmentActivityE.onBackPressed();
                }
            }
        });
        alertDialogCreate.show();
        return true;
    }

    private final void handleEvent(EditUserOrGuildMemberProfileViewModel2.Event event) {
        if (Intrinsics3.areEqual(event, EditUserOrGuildMemberProfileViewModel2.Event.UserUpdateRequestCompleted.INSTANCE)) {
            DimmerView.setDimmed$default(getBinding().i, false, false, 2, null);
        }
    }

    private final void setCurrentBioFromEditor() {
        TextInputEditText textInputEditText = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.bioEditorTextInputField");
        getViewModel().updateBio(String.valueOf(textInputEditText.getText()));
        getViewModel().updateIsEditingBio(false);
        getBinding().d.clearFocus();
        hideKeyboard(getBinding().d);
    }

    @Override // com.discord.app.AppFragment
    public void onImageChosen(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        if (!StringsJVM.startsWith$default(mimeType, "image", false, 2, null)) {
            AppToast.g(getContext(), R.string.user_settings_image_upload_filetype_error, 0, null, 12);
            return;
        }
        if (!Intrinsics3.areEqual(mimeType, "image/gif")) {
            MGImages.requestImageCrop(requireContext(), this, uri, Intrinsics3.areEqual(this.imageSelectedResult, this.bannerSelectedResult) ? 5.0f : 1.0f, Intrinsics3.areEqual(this.imageSelectedResult, this.bannerSelectedResult) ? 2.0f : 1.0f, Intrinsics3.areEqual(this.imageSelectedResult, this.bannerSelectedResult) ? MAX_BANNER_IMAGE_SIZE : 1024);
            return;
        }
        Long fileSizeBytes = FileUtils2.getFileSizeBytes(requireContext(), uri);
        if (fileSizeBytes != null && fileSizeBytes.longValue() >= 31457280) {
            AppToast.h(requireContext(), FormatUtils.e(this, R.string.user_settings_image_upload_file_too_large, new Object[]{30}, (4 & 4) != 0 ? FormatUtils.a.j : null), 0, null, 12);
            return;
        }
        Context context = getContext();
        Function1<? super String, Unit> function1 = this.imageSelectedResult;
        Object widgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0 = function1;
        if (function1 != null) {
            widgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0 = new WidgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0(function1);
        }
        MGImages.requestDataUrl(context, uri, mimeType, (Action1) widgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0);
    }

    @Override // com.discord.app.AppFragment
    public void onImageCropped(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageCropped(uri, mimeType);
        Context context = getContext();
        Function1<? super String, Unit> function1 = this.imageSelectedResult;
        Object widgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0 = function1;
        if (function1 != null) {
            widgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0 = new WidgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0(function1);
        }
        MGImages.requestDataUrl(context, uri, mimeType, (Action1) widgetEditUserOrGuildMemberProfile$sam$rx_functions_Action1$0);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(final View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        if (getGuildId() != null) {
            setActionBarTitle(R.string.change_identity);
        } else {
            setActionBarTitle(R.string.user_settings_user_profile);
            setActionBarSubtitle(R.string.user_settings);
        }
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        getBinding().m.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                EditUserOrGuildMemberProfileViewModel2 viewModel = WidgetEditUserOrGuildMemberProfile.this.getViewModel();
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "view.context");
                viewModel.saveChanges(context);
                DimmerView.setDimmed$default(WidgetEditUserOrGuildMemberProfile.this.getBinding().i, true, false, 2, null);
            }
        });
        ((TouchInterceptingCoordinatorLayout) view).setOnInterceptTouchEvent(new AnonymousClass2());
        getBinding().c.setRawInputType(1);
        getBinding().g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile.onViewBound.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetEditUserOrGuildMemberProfile.this.getViewModel().updateIsEditingBio(true);
            }
        });
        getBinding().o.setOnAvatarRepresentativeColorUpdated(new AnonymousClass4());
        getBinding().o.setOnBadgeClick(new AnonymousClass5());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<EditUserOrGuildMemberProfileViewModel2.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel.observeViewSta…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), (Class<?>) WidgetEditUserOrGuildMemberProfile.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        UserProfileHeaderView.Companion companion = UserProfileHeaderView.INSTANCE;
        UserProfileHeaderView userProfileHeaderView = getBinding().o;
        Intrinsics3.checkNotNullExpressionValue(userProfileHeaderView, "binding.userSettingsProfileHeaderView");
        companion.bind(userProfileHeaderView, this, getViewModel().observeHeaderViewState());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetEditUserOrGuildMemberProfile.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }
}
