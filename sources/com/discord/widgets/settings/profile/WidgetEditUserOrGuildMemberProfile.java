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
import com.discord.C5419R;
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
import com.discord.utilities.file.FileUtilsKt;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.AstRenderer;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.settings.profile.SettingsUserProfileViewModel;
import com.discord.widgets.settings.profile.WidgetEditProfileBannerSheet;
import com.discord.widgets.user.Badge;
import com.discord.widgets.user.profile.UserProfileHeaderView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p009a.p012b.C0811c;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p008a.p062y.C1322b0;
import p007b.p008a.p062y.C1324c0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.functions.Func0;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEditUserOrGuildMemberProfile extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetEditUserOrGuildMemberProfile.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsUserProfileBinding;", 0)};

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
            C12238m.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            if (transition != null) {
                intent.putExtra("transition", transition);
            }
            if (guildId != null) {
                intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId.longValue());
            }
            C0870j.m156d(context, WidgetEditUserOrGuildMemberProfile.class, intent);
            StoreAnalytics.onUserSettingsPaneViewed$default(StoreStream.INSTANCE.getAnalytics(), "User Profile", null, 2, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureAvatarSelect$1 */
    /* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    public static final class C99691 extends AbstractC12240o implements Function1<String, Unit> {
        public final /* synthetic */ SettingsUserProfileViewModel.ViewState.Loaded $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C99691(SettingsUserProfileViewModel.ViewState.Loaded loaded) {
            super(1);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            C12238m.checkNotNullParameter(str, "dataUrl");
            if (this.$viewState.getCanHaveAnimatedAvatars() || !IconUtils.INSTANCE.isDataUrlForGif(str)) {
                WidgetEditUserOrGuildMemberProfile.this.getViewModel().updateAvatar(str);
                return;
            }
            C0811c.Companion bVar = C0811c.INSTANCE;
            FragmentManager parentFragmentManager = WidgetEditUserOrGuildMemberProfile.this.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            C0811c.Companion.m114a(bVar, parentFragmentManager, 4, WidgetEditUserOrGuildMemberProfile.this.getString(C5419R.string.premium_upsell_animated_avatar_active_mobile), null, Traits.Location.Page.USER_SETTINGS, "User Profile", null, null, false, false, 968);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureAvatarSelect$2 */
    /* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    public static final class C99702 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ List $avatarSheetOptions;

        /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureAvatarSelect$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Integer, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.f27425a;
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
        public C99702(List list) {
            super(0);
            this.$avatarSheetOptions = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            C1322b0.Companion aVar = C1322b0.INSTANCE;
            FragmentManager childFragmentManager = WidgetEditUserOrGuildMemberProfile.this.getChildFragmentManager();
            C12238m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            aVar.m379a(childFragmentManager, "", this.$avatarSheetOptions, false, new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureBannerSelect$1 */
    /* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    public static final class C99711 extends AbstractC12240o implements Function1<String, Unit> {
        public C99711() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            C12238m.checkNotNullParameter(str, "dataUrl");
            WidgetEditUserOrGuildMemberProfile.this.getViewModel().updateBannerImage(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2 */
    /* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    public static final class C99722 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ SettingsUserProfileViewModel.ViewState.Loaded $viewState;

        /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<String, Unit> {

            /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
            public static final class C132931 extends AbstractC12240o implements Function0<Unit> {
                public C132931() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile = WidgetEditUserOrGuildMemberProfile.this;
                    widgetEditUserOrGuildMemberProfile.imageSelectedResult = widgetEditUserOrGuildMemberProfile.bannerSelectedResult;
                    WidgetEditUserOrGuildMemberProfile.this.openMediaChooser();
                }
            }

            /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
            public static final class AnonymousClass2 extends AbstractC12240o implements Function0<Unit> {
                public AnonymousClass2() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WidgetEditUserOrGuildMemberProfile.this.getViewModel().updateBannerImage(null);
                }
            }

            /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureBannerSelect$2$1$3, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
            public static final class AnonymousClass3 extends AbstractC12240o implements Function1<Integer, Unit> {
                public AnonymousClass3() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke2(num);
                    return Unit.f27425a;
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
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                WidgetEditProfileBannerSheet.Companion companion = WidgetEditProfileBannerSheet.INSTANCE;
                Long guildId = WidgetEditUserOrGuildMemberProfile.this.getGuildId();
                C12238m.checkNotNullExpressionValue(str, "avatarRepresentativeColorHex");
                String nonDefaultColorPreviewHex = C99722.this.$viewState.getNonDefaultColorPreviewHex();
                boolean hasBannerImageForDisplay = C99722.this.$viewState.getHasBannerImageForDisplay();
                FragmentManager parentFragmentManager = WidgetEditUserOrGuildMemberProfile.this.getParentFragmentManager();
                C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.show(guildId, str, nonDefaultColorPreviewHex, hasBannerImageForDisplay, parentFragmentManager, new C132931(), new AnonymousClass2(), new AnonymousClass3());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C99722(SettingsUserProfileViewModel.ViewState.Loaded loaded) {
            super(0);
            this.$viewState = loaded;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Observable observableM11086L = WidgetEditUserOrGuildMemberProfile.this.avatarRepresentativeColorHexSubject.m11100Z(1).m11086L();
            C12238m.checkNotNullExpressionValue(observableM11086L, "avatarRepresentativeColo…  .onBackpressureLatest()");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11086L, WidgetEditUserOrGuildMemberProfile.this, null, 2, null), (Class<?>) WidgetEditUserOrGuildMemberProfile.this.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    public static final class C99792 extends AbstractC12240o implements Function1<MotionEvent, Boolean> {
        public C99792() {
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
                TextInputLayout textInputLayout = WidgetEditUserOrGuildMemberProfile.this.getBinding().f18079d;
                C12238m.checkNotNullExpressionValue(textInputLayout, "binding.bioEditorTextInputFieldWrap");
                int width = textInputLayout.getWidth();
                TextInputLayout textInputLayout2 = WidgetEditUserOrGuildMemberProfile.this.getBinding().f18079d;
                C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.bioEditorTextInputFieldWrap");
                int height = textInputLayout2.getHeight();
                int[] iArr = new int[2];
                WidgetEditUserOrGuildMemberProfile.this.getBinding().f18079d.getLocationOnScreen(iArr);
                int i = iArr[0];
                int i2 = iArr[1];
                if (rawX < ((float) i) || rawX > ((float) (i + width)) || rawY < ((float) i2) || rawY > ((float) (i2 + height))) {
                    CardView cardView = WidgetEditUserOrGuildMemberProfile.this.getBinding().f18077b;
                    C12238m.checkNotNullExpressionValue(cardView, "binding.bioEditorCard");
                    if (cardView.getVisibility() == 0) {
                        WidgetEditUserOrGuildMemberProfile.this.setCurrentBioFromEditor();
                    }
                }
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$onViewBound$4 */
    /* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    public static final class C99814 extends AbstractC12240o implements Function1<Integer, Unit> {
        public C99814() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(int i) {
            WidgetEditUserOrGuildMemberProfile.this.avatarRepresentativeColorHexSubject.onNext(ColorCompat.INSTANCE.getColorHexFromColorInt(i));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$onViewBound$5 */
    /* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    public static final class C99825 extends AbstractC12240o implements Function1<Badge, Unit> {
        public C99825() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Badge badge) {
            invoke2(badge);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Badge badge) {
            C12238m.checkNotNullParameter(badge, "it");
            Badge.Companion companion = Badge.INSTANCE;
            FragmentManager parentFragmentManager = WidgetEditUserOrGuildMemberProfile.this.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.onBadgeClick(parentFragmentManager, WidgetEditUserOrGuildMemberProfile.this.requireContext());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    public static final class C99831 extends AbstractC12240o implements Function1<SettingsUserProfileViewModel.ViewState, Unit> {
        public C99831() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsUserProfileViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SettingsUserProfileViewModel.ViewState viewState) {
            WidgetEditUserOrGuildMemberProfile widgetEditUserOrGuildMemberProfile = WidgetEditUserOrGuildMemberProfile.this;
            C12238m.checkNotNullExpressionValue(viewState, "viewState");
            widgetEditUserOrGuildMemberProfile.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetEditUserOrGuildMemberProfile.kt */
    public static final class C99842 extends AbstractC12240o implements Function1<SettingsUserProfileViewModel.Event, Unit> {
        public C99842() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsUserProfileViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SettingsUserProfileViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "event");
            WidgetEditUserOrGuildMemberProfile.this.handleEvent(event);
        }
    }

    public WidgetEditUserOrGuildMemberProfile() {
        super(C5419R.layout.widget_settings_user_profile);
        this.avatarSelectedResult = WidgetEditUserOrGuildMemberProfile$avatarSelectedResult$1.INSTANCE;
        this.bannerSelectedResult = WidgetEditUserOrGuildMemberProfile$bannerSelectedResult$1.INSTANCE;
        this.imageSelectedResult = WidgetEditUserOrGuildMemberProfile$imageSelectedResult$1.INSTANCE;
        this.guildId = C12083g.lazy(new WidgetEditUserOrGuildMemberProfile$guildId$2(this));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetEditUserOrGuildMemberProfile$binding$2.INSTANCE, null, 2, null);
        WidgetEditUserOrGuildMemberProfile$viewModel$2 widgetEditUserOrGuildMemberProfile$viewModel$2 = new WidgetEditUserOrGuildMemberProfile$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(SettingsUserProfileViewModel.class), new C9968xa4470a79(c0865g0), new C0869i0(widgetEditUserOrGuildMemberProfile$viewModel$2));
        this.discardConfirmed = new AtomicBoolean(false);
        this.avatarRepresentativeColorHexSubject = BehaviorSubject.m11129k0();
    }

    private final void configureAvatarSelect(SettingsUserProfileViewModel.ViewState.Loaded viewState) {
        String string;
        this.avatarSelectedResult = new C99691(viewState);
        C1324c0[] c1324c0Arr = new C1324c0[1];
        if (viewState.getMeMember() != null) {
            string = viewState.getHasAvatarForDisplay() ? getString(C5419R.string.change_guild_member_avatar) : getString(C5419R.string.upload_guild_member_avatar);
        } else {
            string = viewState.getHasAvatarForDisplay() ? getString(C5419R.string.user_settings_change_avatar) : getString(C5419R.string.user_settings_upload_avatar);
        }
        c1324c0Arr[0] = new C1324c0(string, null, null, null, null, null, null, 116);
        List listMutableListOf = C12147n.mutableListOf(c1324c0Arr);
        if (viewState.getHasAvatarForDisplay()) {
            listMutableListOf.add(new C1324c0(viewState.getMeMember() != null ? getString(C5419R.string.change_identity_modal_reset_primary_avatar) : getString(C5419R.string.user_settings_remove_avatar), null, null, null, null, Integer.valueOf(ColorCompat.getColor(requireContext(), C5419R.color.status_red_500)), null, 84));
        }
        getBinding().f18090o.setOnAvatarEdit(new C99702(listMutableListOf));
    }

    private final void configureBannerSelect(SettingsUserProfileViewModel.ViewState.Loaded viewState) {
        this.bannerSelectedResult = new C99711();
        getBinding().f18090o.setOnBannerPress(new C99722(viewState));
    }

    private final void configureBio(SettingsUserProfileViewModel.ViewState.Loaded viewState) {
        Drawable drawable;
        List<Node<MessageRenderContext>> bioAst = viewState.getBioAst();
        boolean showBioEditor = viewState.getShowBioEditor();
        CardView cardView = getBinding().f18077b;
        C12238m.checkNotNullExpressionValue(cardView, "binding.bioEditorCard");
        boolean z2 = cardView.getVisibility() == 0;
        TextView textView = getBinding().f18081f;
        C12238m.checkNotNullExpressionValue(textView, "binding.bioHelpText");
        textView.setVisibility(viewState.getMeMember() != null ? 0 : 8);
        TextView textView2 = getBinding().f18080e;
        Drawable drawable2 = null;
        textView2.setText(viewState.getMeMember() != null ? C1107b.m212d(textView2, C5419R.string.change_identity_bio_header, new Object[0], (4 & 4) != 0 ? C1107b.c.f1492j : null) : C1107b.m212d(textView2, C5419R.string.user_profile_about_me, new Object[0], (4 & 4) != 0 ? C1107b.c.f1492j : null));
        if (viewState.getMeMember() != null && (drawable = ContextCompat.getDrawable(textView2.getContext(), C5419R.drawable.ic_nitro_wheel_16dp)) != null) {
            TextView textView3 = getBinding().f18080e;
            C12238m.checkNotNullExpressionValue(textView3, "binding.bioHeader");
            DrawableCompat.setTint(drawable, ColorCompat.getThemedColor(textView3, C5419R.attr.colorHeaderSecondary));
            drawable2 = drawable;
        }
        com.discord.utilities.drawable.DrawableCompat.setCompoundDrawablesCompat$default(textView2, (Drawable) null, (Drawable) null, drawable2, (Drawable) null, 11, (Object) null);
        CardView cardView2 = getBinding().f18082g;
        C12238m.checkNotNullExpressionValue(cardView2, "binding.bioPreviewCard");
        cardView2.setVisibility(showBioEditor ^ true ? 0 : 8);
        CardView cardView3 = getBinding().f18077b;
        C12238m.checkNotNullExpressionValue(cardView3, "binding.bioEditorCard");
        cardView3.setVisibility(showBioEditor ? 0 : 8);
        if (!showBioEditor) {
            if (bioAst != null) {
                LinkifiedTextView linkifiedTextView = getBinding().f18083h;
                C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.bioPreviewText");
                Context context = linkifiedTextView.getContext();
                C12238m.checkNotNullExpressionValue(context, "binding.bioPreviewText.context");
                getBinding().f18083h.setDraweeSpanStringBuilder(AstRenderer.render(bioAst, new MessageRenderContext(context, 0L, false, null, null, null, 0, null, null, 0, 0, new WidgetEditUserOrGuildMemberProfile$configureBio$renderContext$1(getViewModel()), null, null, 14328, null)));
                return;
            }
            return;
        }
        TextInputLayout textInputLayout = getBinding().f18079d;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.bioEditorTextInputFieldWrap");
        ViewExtensions.setText(textInputLayout, viewState.getCurrentBio());
        if (z2) {
            return;
        }
        getBinding().f18079d.requestFocus();
        TextInputLayout textInputLayout2 = getBinding().f18079d;
        C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.bioEditorTextInputFieldWrap");
        ViewExtensions.moveCursorToEnd(textInputLayout2);
        TextInputLayout textInputLayout3 = getBinding().f18079d;
        C12238m.checkNotNullExpressionValue(textInputLayout3, "binding.bioEditorTextInputFieldWrap");
        showKeyboard(textInputLayout3);
    }

    private final void configureFab(SettingsUserProfileViewModel.ViewState.Loaded viewState) {
        FloatingActionButton floatingActionButton = getBinding().f18088m;
        C12238m.checkNotNullExpressionValue(floatingActionButton, "binding.saveFab");
        floatingActionButton.setVisibility(viewState.getShowSaveFab() ? 0 : 8);
    }

    private final void configureNick(final SettingsUserProfileViewModel.ViewState.Loaded viewState) {
        boolean z2 = viewState.getGuild() != null;
        LinearLayout linearLayout = getBinding().f18087l;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.nickContainer");
        linearLayout.setVisibility(z2 ? 0 : 8);
        TextInputLayout textInputLayout = getBinding().f18089n;
        C12238m.checkNotNullExpressionValue(textInputLayout, "textInputLayout");
        String currentNickname = viewState.getCurrentNickname();
        textInputLayout.setEndIconVisible(!(currentNickname == null || currentNickname.length() == 0));
        ViewExtensions.setEnabledAndAlpha$default(textInputLayout, viewState.getCanEditNickname(), 0.0f, 2, null);
        textInputLayout.setHint(viewState.getCanEditNickname() ? getString(C5419R.string.nickname) : getString(C5419R.string.change_identity_modal_change_nickname_disabled));
        textInputLayout.setPlaceholderText(viewState.getUser().getUsername());
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new C9973x9758651b(this, viewState));
        textInputLayout.setEndIconOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile$configureNick$$inlined$also$lambda$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.this$0.getViewModel().updateNickname("");
            }
        });
        TextInputLayout textInputLayout2 = getBinding().f18089n;
        C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.setNicknameText");
        String textOrEmpty = ViewExtensions.getTextOrEmpty(textInputLayout2);
        if (!C12238m.areEqual(viewState.getCurrentNickname(), textOrEmpty)) {
            ViewExtensions.setText(textInputLayout, viewState.getCurrentNickname());
            if (textOrEmpty.length() == 0) {
                EditText editText = textInputLayout.getEditText();
                Selection.setSelection(editText != null ? editText.getText() : null, ViewExtensions.getTextOrEmpty(textInputLayout).length());
            }
        }
    }

    private final void configureUI(final SettingsUserProfileViewModel.ViewState viewState) {
        if (viewState instanceof SettingsUserProfileViewModel.ViewState.Loaded) {
            SettingsUserProfileViewModel.ViewState.Loaded loaded = (SettingsUserProfileViewModel.ViewState.Loaded) viewState;
            if (loaded.getGuild() != null) {
                setActionBarSubtitle(loaded.getGuild().getName());
            }
            configureNick(loaded);
            getBinding().f18086k.setVisibility(loaded.getGuild() != null ? 0 : 8);
            if (loaded.getGuild() != null) {
                TextView textView = getBinding().f18085j;
                C12238m.checkNotNullExpressionValue(textView, "binding.guildMemberProfileHelpTextOverall");
                textView.setText(C1107b.m213e(this, C5419R.string.change_identity_help_text_overall, new Object[]{loaded.getGuild().getName()}, (4 & 4) != 0 ? C1107b.a.f1490j : null));
            }
            configureBio(loaded);
            configureAvatarSelect(loaded);
            configureBannerSelect(loaded);
            configureFab(loaded);
            AppFragment.setOnBackPressed$default(this, new Func0<Boolean>() { // from class: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile.configureUI.3
                @Override // p658rx.functions.Func0, java.util.concurrent.Callable
                public final Boolean call() {
                    return Boolean.valueOf(WidgetEditUserOrGuildMemberProfile.this.handleBackPressed((SettingsUserProfileViewModel.ViewState.Loaded) viewState));
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

    private final SettingsUserProfileViewModel getViewModel() {
        return (SettingsUserProfileViewModel) this.viewModel.getValue();
    }

    private final boolean handleBackPressed(SettingsUserProfileViewModel.ViewState.Loaded viewState) {
        if (viewState.isEditingBio()) {
            setCurrentBioFromEditor();
            return true;
        }
        if (!viewState.getIsDirty() || this.discardConfirmed.get()) {
            return false;
        }
        ViewDialogConfirmationBinding viewDialogConfirmationBindingM8394b = ViewDialogConfirmationBinding.m8394b(LayoutInflater.from(m95e()));
        C12238m.checkNotNullExpressionValue(viewDialogConfirmationBindingM8394b, "ViewDialogConfirmationBi…tInflater.from(activity))");
        final AlertDialog alertDialogCreate = new AlertDialog.Builder(requireContext()).setView(viewDialogConfirmationBindingM8394b.f15420a).create();
        C12238m.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(requ…logBinding.root).create()");
        viewDialogConfirmationBindingM8394b.f15423d.setText(C5419R.string.discard_changes);
        viewDialogConfirmationBindingM8394b.f15424e.setText(C5419R.string.discard_changes_description);
        viewDialogConfirmationBindingM8394b.f15421b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile.handleBackPressed.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                alertDialogCreate.dismiss();
            }
        });
        viewDialogConfirmationBindingM8394b.f15422c.setText(C5419R.string.okay);
        viewDialogConfirmationBindingM8394b.f15422c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile.handleBackPressed.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetEditUserOrGuildMemberProfile.this.discardConfirmed.set(true);
                alertDialogCreate.dismiss();
                FragmentActivity fragmentActivityM95e = WidgetEditUserOrGuildMemberProfile.this.m95e();
                if (fragmentActivityM95e != null) {
                    fragmentActivityM95e.onBackPressed();
                }
            }
        });
        alertDialogCreate.show();
        return true;
    }

    private final void handleEvent(SettingsUserProfileViewModel.Event event) {
        if (C12238m.areEqual(event, SettingsUserProfileViewModel.Event.UserUpdateRequestCompleted.INSTANCE)) {
            DimmerView.setDimmed$default(getBinding().f18084i, false, false, 2, null);
        }
    }

    private final void setCurrentBioFromEditor() {
        TextInputEditText textInputEditText = getBinding().f18078c;
        C12238m.checkNotNullExpressionValue(textInputEditText, "binding.bioEditorTextInputField");
        getViewModel().updateBio(String.valueOf(textInputEditText.getText()));
        getViewModel().updateIsEditingBio(false);
        getBinding().f18079d.clearFocus();
        hideKeyboard(getBinding().f18079d);
    }

    @Override // com.discord.app.AppFragment
    public void onImageChosen(Uri uri, String mimeType) {
        C12238m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        C12238m.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        if (!C12103t.startsWith$default(mimeType, "image", false, 2, null)) {
            C0876m.m169g(getContext(), C5419R.string.user_settings_image_upload_filetype_error, 0, null, 12);
            return;
        }
        if (!C12238m.areEqual(mimeType, "image/gif")) {
            MGImages.requestImageCrop(requireContext(), this, uri, C12238m.areEqual(this.imageSelectedResult, this.bannerSelectedResult) ? 5.0f : 1.0f, C12238m.areEqual(this.imageSelectedResult, this.bannerSelectedResult) ? 2.0f : 1.0f, C12238m.areEqual(this.imageSelectedResult, this.bannerSelectedResult) ? MAX_BANNER_IMAGE_SIZE : 1024);
            return;
        }
        Long fileSizeBytes = FileUtilsKt.getFileSizeBytes(requireContext(), uri);
        if (fileSizeBytes != null && fileSizeBytes.longValue() >= 31457280) {
            C0876m.m170h(requireContext(), C1107b.m213e(this, C5419R.string.user_settings_image_upload_file_too_large, new Object[]{30}, (4 & 4) != 0 ? C1107b.a.f1490j : null), 0, null, 12);
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
        C12238m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        C12238m.checkNotNullParameter(mimeType, "mimeType");
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
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        if (getGuildId() != null) {
            setActionBarTitle(C5419R.string.change_identity);
        } else {
            setActionBarTitle(C5419R.string.user_settings_user_profile);
            setActionBarSubtitle(C5419R.string.user_settings);
        }
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        getBinding().f18088m.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                SettingsUserProfileViewModel viewModel = WidgetEditUserOrGuildMemberProfile.this.getViewModel();
                Context context = view.getContext();
                C12238m.checkNotNullExpressionValue(context, "view.context");
                viewModel.saveChanges(context);
                DimmerView.setDimmed$default(WidgetEditUserOrGuildMemberProfile.this.getBinding().f18084i, true, false, 2, null);
            }
        });
        ((TouchInterceptingCoordinatorLayout) view).setOnInterceptTouchEvent(new C99792());
        getBinding().f18078c.setRawInputType(1);
        getBinding().f18082g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.profile.WidgetEditUserOrGuildMemberProfile.onViewBound.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetEditUserOrGuildMemberProfile.this.getViewModel().updateIsEditingBio(true);
            }
        });
        getBinding().f18090o.setOnAvatarRepresentativeColorUpdated(new C99814());
        getBinding().f18090o.setOnBadgeClick(new C99825());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<SettingsUserProfileViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel.observeViewSta…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), (Class<?>) WidgetEditUserOrGuildMemberProfile.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C99831());
        UserProfileHeaderView.Companion companion = UserProfileHeaderView.INSTANCE;
        UserProfileHeaderView userProfileHeaderView = getBinding().f18090o;
        C12238m.checkNotNullExpressionValue(userProfileHeaderView, "binding.userSettingsProfileHeaderView");
        companion.bind(userProfileHeaderView, this, getViewModel().observeHeaderViewState());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetEditUserOrGuildMemberProfile.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C99842());
    }
}
