package com.discord.widgets.contact_sync;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates2;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.BuildConfig;
import com.discord.R;
import com.discord.analytics.generated.traits.TrackImpressionMetadata;
import com.discord.analytics.utils.ImpressionGroups;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetContactSyncBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.contacts.ContactsProviderUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.intent.IntentUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.views.LoadingButton;
import com.discord.widgets.captcha.WidgetCaptcha;
import com.discord.widgets.contact_sync.AddFriendsFailed;
import com.discord.widgets.contact_sync.ContactSyncPermissionsSheet;
import com.discord.widgets.contact_sync.WidgetContactSyncViewModel;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.StringsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Func0;

/* JADX INFO: compiled from: WidgetContactSync.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetContactSync extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetContactSync.class, "binding", "getBinding()Lcom/discord/databinding/WidgetContactSyncBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_CONTACT_SYNC_ALLOW_EMAIL = "INTENT_EXTRA_CONTACT_SYNC_ALLOW_EMAIL";
    private static final String INTENT_EXTRA_CONTACT_SYNC_ALLOW_PHONE = "INTENT_EXTRA_CONTACT_SYNC_ALLOW_PHONE";
    private static final String INTENT_EXTRA_CONTACT_SYNC_IMMEDIATELY_PROCEED = "INTENT_EXTRA_CONTACT_SYNC_IMMEDIATELY_PROCEED";
    private static final String INTENT_EXTRA_CONTACT_SYNC_MODE = "INTENT_EXTRA_CONTACT_SYNC_MODE";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> captchaLauncher;
    private final TrackImpressionMetadata contactSyncFlowMetadata;
    private int displayedChildIndex;
    private ContactSyncFriendSuggestionListAdapter friendSuggestionsAdapter;
    private final AppLogger2 loggingConfig;
    private String phoneNumber;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetContactSync.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, ContactSyncMode contactSyncMode, boolean z2, boolean z3, boolean z4, int i, Object obj) {
            if ((i & 2) != 0) {
                contactSyncMode = ContactSyncMode.DEFAULT;
            }
            companion.launch(context, contactSyncMode, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? true : z3, (i & 16) != 0 ? true : z4);
        }

        public final ContactSyncMode getContactSyncModeFromIntent(AppActivity appActivity) {
            Intrinsics3.checkNotNullParameter(appActivity, "appActivity");
            Serializable serializableExtra = appActivity.c().getSerializableExtra(WidgetContactSync.INTENT_EXTRA_CONTACT_SYNC_MODE);
            Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.discord.widgets.contact_sync.ContactSyncMode");
            return (ContactSyncMode) serializableExtra;
        }

        public final boolean getEmailDiscoverableFromIntent(AppActivity appActivity) {
            Intrinsics3.checkNotNullParameter(appActivity, "appActivity");
            return appActivity.c().getBooleanExtra(WidgetContactSync.INTENT_EXTRA_CONTACT_SYNC_ALLOW_EMAIL, true);
        }

        public final boolean getPhoneDiscoverableFromIntent(AppActivity appActivity) {
            Intrinsics3.checkNotNullParameter(appActivity, "appActivity");
            return appActivity.c().getBooleanExtra(WidgetContactSync.INTENT_EXTRA_CONTACT_SYNC_ALLOW_PHONE, true);
        }

        public final void launch(Context context, ContactSyncMode mode, boolean immediatelyProceed, boolean discoverByPhone, boolean discoverByEmail) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(mode, "mode");
            Intent intent = new Intent();
            intent.putExtra(WidgetContactSync.INTENT_EXTRA_CONTACT_SYNC_MODE, mode);
            intent.putExtra(WidgetContactSync.INTENT_EXTRA_CONTACT_SYNC_IMMEDIATELY_PROCEED, immediatelyProceed);
            intent.putExtra(WidgetContactSync.INTENT_EXTRA_CONTACT_SYNC_ALLOW_PHONE, discoverByPhone);
            intent.putExtra(WidgetContactSync.INTENT_EXTRA_CONTACT_SYNC_ALLOW_EMAIL, discoverByEmail);
            AppScreen2.d(context, WidgetContactSync.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetContactSync.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<RenderContext, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* JADX INFO: renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetContactSync.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<Hook, Unit> {

            /* JADX INFO: renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$4$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: WidgetContactSync.kt */
            public static final class C02871 extends Lambda implements Function1<View, Unit> {
                public C02871() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    Intrinsics3.checkNotNullParameter(view, "it");
                    AnalyticsTracker.INSTANCE.openPopout("Contact Sync", new Traits.Location("Contact Sync Learn More", null, null, null, null, 30, null));
                    ContactSyncPermissionsSheet.Companion companion = ContactSyncPermissionsSheet.INSTANCE;
                    FragmentManager parentFragmentManager = WidgetContactSync.this.getParentFragmentManager();
                    Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    companion.show(parentFragmentManager);
                }
            }

            public AnonymousClass1() {
                super(1);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                Intrinsics3.checkNotNullParameter(hook, "$receiver");
                hook.styles.add(new ClickableSpan(Integer.valueOf(ColorCompat.getColor(WidgetContactSync.this.getContext(), R.color.link)), false, null, new C02871(), 4, null));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.a;
            }
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.a("learnMoreHook", new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$8, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetContactSync.kt */
    public static final class AnonymousClass8 extends Lambda implements Function0<Unit> {
        public AnonymousClass8() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetContactSync.this.handlePhoneNumberTextChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$9, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetContactSync.kt */
    public static final class AnonymousClass9 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass9() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
            WidgetContactSync.this.getViewModel().onVerifyPhone(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.contact_sync.WidgetContactSync$onViewBound$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetContactSync.kt */
    public static final class AnonymousClass2 extends Lambda implements Function2<Long, Boolean, Unit> {
        public AnonymousClass2() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, Boolean bool) {
            invoke(l.longValue(), bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(long j, boolean z2) {
            WidgetContactSync.this.getViewModel().handleToggleFriendSuggestionSelected(j, z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.contact_sync.WidgetContactSync$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetContactSync.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetContactSyncViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetContactSyncViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetContactSyncViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetContactSync.this.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.contact_sync.WidgetContactSync$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetContactSync.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<WidgetContactSyncViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetContactSyncViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetContactSyncViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "it");
            WidgetContactSync.this.handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.contact_sync.WidgetContactSync$requestContactsPermissions$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetContactSync.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetContactSync.this.onPermissionsGranted();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.contact_sync.WidgetContactSync$requestContactsPermissions$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetContactSync.kt */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetContactSync.this.onPermissionsDenied();
        }
    }

    public WidgetContactSync() {
        super(R.layout.widget_contact_sync);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetContactSync2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetContactSyncViewModel.class), new WidgetContactSync$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(new WidgetContactSync7(this)));
        this.contactSyncFlowMetadata = new TrackImpressionMetadata(null, null, null, ImpressionGroups.CONTACT_SYNC_FLOW, 7);
        this.captchaLauncher = WidgetCaptcha.INSTANCE.registerForResult(this, new WidgetContactSync3(this));
        this.loggingConfig = new AppLogger2(false, null, new WidgetContactSync6(this), 3);
    }

    private final void configureToolbar(final WidgetContactSyncViewModel.ToolbarConfig toolbarConfig) {
        setActionBarDisplayHomeAsUpEnabled(toolbarConfig.getShowBackButton());
        setActionBarOptionsMenu(R.menu.menu_contact_sync, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.contact_sync.WidgetContactSync.configureToolbar.1
            @Override // rx.functions.Action2
            public final void call(MenuItem menuItem, Context context) {
                Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
                if (menuItem.getItemId() != R.id.menu_contact_sync_skip) {
                    return;
                }
                WidgetContactSync.this.getViewModel().skip();
            }
        }, new Action1<Menu>() { // from class: com.discord.widgets.contact_sync.WidgetContactSync.configureToolbar.2
            @Override // rx.functions.Action1
            public final void call(Menu menu) {
                MenuItem menuItemFindItem = menu.findItem(R.id.menu_contact_sync_skip);
                Intrinsics3.checkNotNullExpressionValue(menuItemFindItem, "menu.findItem(R.id.menu_contact_sync_skip)");
                menuItemFindItem.setVisible(toolbarConfig.getShowSkip());
            }
        });
        AppFragment.setOnBackPressed$default(this, new Func0<Boolean>() { // from class: com.discord.widgets.contact_sync.WidgetContactSync.configureToolbar.3
            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public final Boolean call() {
                if (!toolbarConfig.getShowBackButton()) {
                    return Boolean.FALSE;
                }
                WidgetContactSync.this.getViewModel().skip();
                return Boolean.TRUE;
            }
        }, 0, 2, null);
    }

    private final void configureUI(final WidgetContactSyncViewModel.ViewState viewState) {
        this.phoneNumber = viewState.getPhoneNumber();
        configureViewFlipper(viewState.getDisplayedChild());
        configureToolbar(viewState.getToolbarConfig());
        LoadingButton loadingButton = getBinding().e.c;
        Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.contactSyncLandi…tactSyncLandingNextButton");
        loadingButton.setEnabled(viewState.getLandingNextEnabled());
        getBinding().e.c.setIsLoading(viewState.isSubmitting());
        getBinding().f.d.setIsLoading(viewState.isSubmitting());
        getBinding().c.c.setIsLoading(viewState.isSubmitting());
        if (viewState.getPermissionsDenied()) {
            TextView textView = getBinding().e.f144b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.contactSyncLandi…ncLandingNeedsPermissions");
            textView.setVisibility(0);
            View view = getBinding().e.d;
            Intrinsics3.checkNotNullExpressionValue(view, "binding.contactSyncLandi…LandingPermissionsDivider");
            view.setVisibility(0);
            getBinding().e.c.setText(FormatUtils.e(this, R.string.password_manager_open_settings, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null));
            getBinding().e.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.contact_sync.WidgetContactSync.configureUI.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    Intrinsics3.checkNotNullExpressionValue(view2, "view");
                    Context context = view2.getContext();
                    Intrinsics3.checkNotNullExpressionValue(context, "view.context");
                    Uri uriFromParts = Uri.fromParts("package", context.getPackageName(), null);
                    Intrinsics3.checkNotNullExpressionValue(uriFromParts, "Uri.fromParts(\"package\",…ontext.packageName, null)");
                    intent.setData(uriFromParts);
                    view2.getContext().startActivity(intent);
                }
            });
        } else {
            TextView textView2 = getBinding().e.f144b;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.contactSyncLandi…ncLandingNeedsPermissions");
            textView2.setVisibility(8);
            View view2 = getBinding().e.d;
            Intrinsics3.checkNotNullExpressionValue(view2, "binding.contactSyncLandi…LandingPermissionsDivider");
            view2.setVisibility(8);
            getBinding().e.c.setText(FormatUtils.e(this, R.string.get_started, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null));
            getBinding().e.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.contact_sync.WidgetContactSync.configureUI.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    WidgetContactSync.this.getViewModel().onLandingNext();
                }
            });
        }
        CheckedSetting checkedSetting = getBinding().e.e.c;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.contactSyncLandi…ontactSyncDiscoveryToggle");
        checkedSetting.setChecked(viewState.getAllowPhone() || viewState.getAllowEmail());
        getBinding().e.e.c.e(new View.OnClickListener() { // from class: com.discord.widgets.contact_sync.WidgetContactSync.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                CheckedSetting checkedSetting2 = WidgetContactSync.this.getBinding().e.e.c;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.contactSyncLandi…ontactSyncDiscoveryToggle");
                boolean zIsChecked = checkedSetting2.isChecked();
                WidgetContactSync.this.getViewModel().onPermissionsToggle(!zIsChecked, !zIsChecked);
            }
        });
        LinkifiedTextView linkifiedTextView = getBinding().e.e.f171b;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.contactSyncLandi…contactSyncDiscoveryInfo2");
        FormatUtils.m(linkifiedTextView, R.string.contact_sync_permissions_description_android, new Object[0], new AnonymousClass4());
        getBinding().f.d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.contact_sync.WidgetContactSync.configureUI.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                WidgetContactSyncViewModel viewModel = WidgetContactSync.this.getViewModel();
                TextInputLayout textInputLayout = WidgetContactSync.this.getBinding().f.c;
                Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.contactSyncName.contactSyncNameInputWrap");
                viewModel.onNameSubmitted(ViewExtensions.getTextOrEmpty(textInputLayout));
            }
        });
        ContactSyncFriendSuggestionListAdapter contactSyncFriendSuggestionListAdapter = this.friendSuggestionsAdapter;
        if (contactSyncFriendSuggestionListAdapter != null) {
            contactSyncFriendSuggestionListAdapter.setData(viewState.getFriendSuggestions());
        }
        getBinding().c.c.setText(FormatUtils.e(this, R.string.next, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null));
        getBinding().c.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.contact_sync.WidgetContactSync.configureUI.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                WidgetContactSync.this.getViewModel().onBulkAddFriends();
            }
        });
        getBinding().f2355b.f138b.b(this);
        getBinding().f2355b.f138b.setCountryCode(viewState.getCountryCode());
        getBinding().f2355b.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.contact_sync.WidgetContactSync.configureUI.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                WidgetContactSync.submitPhoneNumber$default(WidgetContactSync.this, null, 1, null);
            }
        });
        getBinding().f2355b.f138b.a(this, new AnonymousClass8());
        getBinding().g.f177b.setOnCodeEntered(new AnonymousClass9());
        getBinding().d.f164b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.contact_sync.WidgetContactSync.configureUI.10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                AnalyticsTracker.INSTANCE.friendAddViewed("Invite");
                Intrinsics3.checkNotNullExpressionValue(view3, "it");
                Context context = view3.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                IntentUtils.performChooserSendIntent(context, FormatUtils.e(WidgetContactSync.this, R.string.friends_share_tabbar_title, new Object[]{BuildConfig.HOST, viewState.getUsername()}, (4 & 4) != 0 ? FormatUtils.a.j : null).toString(), FormatUtils.e(WidgetContactSync.this, R.string.tip_instant_invite_title3, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null));
            }
        });
        getBinding().d.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.contact_sync.WidgetContactSync.configureUI.11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                WidgetContactSync.this.getViewModel().skip();
            }
        });
    }

    private final void configureViewFlipper(WidgetContactSyncViewModel.Views displayedChild) {
        int i;
        int iOrdinal = displayedChild.ordinal();
        boolean z2 = true;
        if (iOrdinal != this.displayedChildIndex) {
            AppFragment.hideKeyboard$default(this, null, 1, null);
        }
        if (displayedChild != WidgetContactSyncViewModel.Views.VIEW_LANDING || ((i = this.displayedChildIndex) != 2 && i != 3)) {
            z2 = false;
        }
        if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
            AppViewFlipper appViewFlipper = getBinding().h;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.contactSyncViewFlipper");
            appViewFlipper.setInAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_fade_in_fast));
            AppViewFlipper appViewFlipper2 = getBinding().h;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.contactSyncViewFlipper");
            appViewFlipper2.setOutAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.anim_fade_out_fast));
        } else {
            int i2 = this.displayedChildIndex;
            if (iOrdinal > i2 || z2) {
                AppViewFlipper appViewFlipper3 = getBinding().h;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper3, "binding.contactSyncViewFlipper");
                appViewFlipper3.setInAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.activity_slide_horizontal_open_in));
                AppViewFlipper appViewFlipper4 = getBinding().h;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper4, "binding.contactSyncViewFlipper");
                appViewFlipper4.setOutAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.activity_slide_horizontal_open_out));
            } else if (iOrdinal < i2) {
                AppViewFlipper appViewFlipper5 = getBinding().h;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper5, "binding.contactSyncViewFlipper");
                appViewFlipper5.setInAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.activity_slide_horizontal_close_in));
                AppViewFlipper appViewFlipper6 = getBinding().h;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper6, "binding.contactSyncViewFlipper");
                appViewFlipper6.setOutAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.activity_slide_horizontal_close_out));
            }
        }
        AppViewFlipper appViewFlipper7 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper7, "binding.contactSyncViewFlipper");
        appViewFlipper7.setDisplayedChild(iOrdinal);
        this.displayedChildIndex = iOrdinal;
        getAppLogger().a(null);
    }

    private final WidgetContactSyncBinding getBinding() {
        return (WidgetContactSyncBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetContactSyncViewModel getViewModel() {
        return (WidgetContactSyncViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetContactSyncViewModel.Event event) {
        if (Intrinsics3.areEqual(event, WidgetContactSyncViewModel.Event.MaybeProceedFromLanding.INSTANCE)) {
            if (getMostRecentIntent().getBooleanExtra(INTENT_EXTRA_CONTACT_SYNC_IMMEDIATELY_PROCEED, false)) {
                getViewModel().onLandingNext();
                return;
            }
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetContactSyncViewModel.Event.PermissionsNeeded.INSTANCE)) {
            requestContactsPermissions();
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetContactSyncViewModel.Event.ContactsEnabled.INSTANCE)) {
            getViewModel().onContactsFetched(ContactsProviderUtils.INSTANCE.getAllContactPhoneNumbers(requireContext()));
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetContactSyncViewModel.Event.RateLimited.INSTANCE)) {
            AppToast.f(this, FormatUtils.e(this, R.string.contact_sync_failed_alert_title, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null), 1);
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetContactSyncViewModel.Event.UploadFailed.INSTANCE)) {
            AppToast.f(this, FormatUtils.e(this, R.string.contact_sync_failed_alert_message, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null), 1);
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetContactSyncViewModel.Event.ContactsEnableFailed.INSTANCE)) {
            AppToast.f(this, FormatUtils.e(this, R.string.contact_sync_failed_alert_title, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null), 1);
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetContactSyncViewModel.Event.AddFriendsFailed.INSTANCE)) {
            AddFriendsFailed.Companion companion = AddFriendsFailed.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager).setOnClose(new WidgetContactSync4(this));
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetContactSyncViewModel.Event.AddFriendsFailedPartial.INSTANCE)) {
            AddFriendsFailed.Companion companion2 = AddFriendsFailed.INSTANCE;
            FragmentManager parentFragmentManager2 = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            companion2.show(parentFragmentManager2).setOnClose(new WidgetContactSync5(this));
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetContactSyncViewModel.Event.PhoneInvalid.INSTANCE)) {
            AppToast.j(this, FormatUtils.e(this, R.string.phone_invalid, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null), 0, 4);
            return;
        }
        if (Intrinsics3.areEqual(event, WidgetContactSyncViewModel.Event.VerificationCodeInvalid.INSTANCE)) {
            AppToast.j(this, FormatUtils.e(this, R.string.application_entitlement_code_redemption_invalid, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null), 0, 4);
        } else if (Intrinsics3.areEqual(event, WidgetContactSyncViewModel.Event.VerificationFailed.INSTANCE)) {
            AppToast.j(this, FormatUtils.e(this, R.string.phone_failed_to_add, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null), 0, 4);
        } else if (Intrinsics3.areEqual(event, WidgetContactSyncViewModel.Event.Completed.INSTANCE)) {
            requireAppActivity().finish();
        }
    }

    private final void handlePhoneNumberTextChanged() {
        String textOrEmpty = getBinding().f2355b.f138b.getTextOrEmpty();
        MaterialButton materialButton = getBinding().f2355b.c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.contactSyncAddPh…e.contactSyncAddPhoneNext");
        materialButton.setEnabled((textOrEmpty.length() > 0) && StringsJVM.startsWith$default(textOrEmpty, BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX, false, 2, null));
    }

    private final void launchCaptchaFlow(Error error) {
        WidgetCaptcha.Companion companion = WidgetCaptcha.INSTANCE;
        Context contextRequireContext = requireContext();
        ActivityResultLauncher<Intent> activityResultLauncher = this.captchaLauncher;
        Error.Response response = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response, "error.response");
        companion.processErrorsForCaptcha(contextRequireContext, activityResultLauncher, _Collections.toMutableList((Collection) response.getMessages().keySet()), error);
    }

    private final void onPermissionsDenied() {
        getViewModel().onPermissionsDenied();
    }

    private final void onPermissionsGranted() {
        getViewModel().onPermissionsGranted();
        if (this.phoneNumber != null) {
            ContactsProviderUtils contactsProviderUtils = ContactsProviderUtils.INSTANCE;
            Context contextRequireContext = requireContext();
            String str = this.phoneNumber;
            Intrinsics3.checkNotNull(str);
            String ownName = contactsProviderUtils.getOwnName(contextRequireContext, str);
            if (ownName != null) {
                getBinding().f.f150b.setText(ownName);
                TextView textView = getBinding().f.e;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.contactSyncName.contactSyncNamePrefillHint");
                textView.setVisibility(0);
            }
        }
    }

    private final void requestContactsPermissions() {
        if (!ContactsProviderUtils.INSTANCE.hasContactPermissions(requireContext())) {
            AnalyticsTracker.INSTANCE.permissionsRequested("contacts");
            getViewModel().requestingPermissions();
        }
        requestContacts(new AnonymousClass1(), new AnonymousClass2());
    }

    private final void submitPhoneNumber(CaptchaHelper.CaptchaPayload captchaPayload) {
        getViewModel().onPhoneNumberSubmitted(getBinding().f2355b.f138b.getTextOrEmpty(), captchaPayload);
    }

    public static /* synthetic */ void submitPhoneNumber$default(WidgetContactSync widgetContactSync, CaptchaHelper.CaptchaPayload captchaPayload, int i, Object obj) {
        if ((i & 1) != 0) {
            captchaPayload = null;
        }
        widgetContactSync.submitPhoneNumber(captchaPayload);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (ContactsProviderUtils.INSTANCE.hasContactPermissions(requireContext())) {
            getViewModel().onPermissionsBecameAvailable();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RecyclerView recyclerView = getBinding().c.f157b;
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "it");
        ContactSyncFriendSuggestionListAdapter contactSyncFriendSuggestionListAdapter = (ContactSyncFriendSuggestionListAdapter) companion.configure(new ContactSyncFriendSuggestionListAdapter(recyclerView));
        this.friendSuggestionsAdapter = contactSyncFriendSuggestionListAdapter;
        if (contactSyncFriendSuggestionListAdapter != null) {
            contactSyncFriendSuggestionListAdapter.setOnClickFriendSuggestion(new AnonymousClass2());
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetContactSync.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetContactSync.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }
}
