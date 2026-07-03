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
import com.discord.BuildConfig;
import com.discord.C5419R;
import com.discord.analytics.generated.traits.TrackImpressionMetadata;
import com.discord.analytics.utils.ImpressionGroups;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.app.LoggingConfig;
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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.views.LoadingButton;
import com.discord.widgets.captcha.WidgetCaptcha;
import com.discord.widgets.contact_sync.AddFriendsFailed;
import com.discord.widgets.contact_sync.ContactSyncPermissionsSheet;
import com.discord.widgets.contact_sync.WidgetContactSyncViewModel;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
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
import p007b.p008a.p018d.C0863f0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.functions.Action2;
import p658rx.functions.Func0;

/* JADX INFO: compiled from: WidgetContactSync.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetContactSync extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetContactSync.class, "binding", "getBinding()Lcom/discord/databinding/WidgetContactSyncBinding;", 0)};

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
    private final LoggingConfig loggingConfig;
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
            C12238m.checkNotNullParameter(appActivity, "appActivity");
            Serializable serializableExtra = appActivity.m8343c().getSerializableExtra(WidgetContactSync.INTENT_EXTRA_CONTACT_SYNC_MODE);
            Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.discord.widgets.contact_sync.ContactSyncMode");
            return (ContactSyncMode) serializableExtra;
        }

        public final boolean getEmailDiscoverableFromIntent(AppActivity appActivity) {
            C12238m.checkNotNullParameter(appActivity, "appActivity");
            return appActivity.m8343c().getBooleanExtra(WidgetContactSync.INTENT_EXTRA_CONTACT_SYNC_ALLOW_EMAIL, true);
        }

        public final boolean getPhoneDiscoverableFromIntent(AppActivity appActivity) {
            C12238m.checkNotNullParameter(appActivity, "appActivity");
            return appActivity.m8343c().getBooleanExtra(WidgetContactSync.INTENT_EXTRA_CONTACT_SYNC_ALLOW_PHONE, true);
        }

        public final void launch(Context context, ContactSyncMode mode, boolean immediatelyProceed, boolean discoverByPhone, boolean discoverByEmail) {
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(mode, "mode");
            Intent intent = new Intent();
            intent.putExtra(WidgetContactSync.INTENT_EXTRA_CONTACT_SYNC_MODE, mode);
            intent.putExtra(WidgetContactSync.INTENT_EXTRA_CONTACT_SYNC_IMMEDIATELY_PROCEED, immediatelyProceed);
            intent.putExtra(WidgetContactSync.INTENT_EXTRA_CONTACT_SYNC_ALLOW_PHONE, discoverByPhone);
            intent.putExtra(WidgetContactSync.INTENT_EXTRA_CONTACT_SYNC_ALLOW_EMAIL, discoverByEmail);
            C0870j.m156d(context, WidgetContactSync.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$4 */
    /* JADX INFO: compiled from: WidgetContactSync.kt */
    public static final class C82334 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public C82334() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetContactSync.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Hook, Unit> {

            /* JADX INFO: renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$4$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: WidgetContactSync.kt */
            public static final class C132851 extends AbstractC12240o implements Function1<View, Unit> {
                public C132851() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    C12238m.checkNotNullParameter(view, "it");
                    AnalyticsTracker.INSTANCE.openPopout("Contact Sync", new Traits.Location("Contact Sync Learn More", null, null, null, null, 30, null));
                    ContactSyncPermissionsSheet.Companion companion = ContactSyncPermissionsSheet.INSTANCE;
                    FragmentManager parentFragmentManager = WidgetContactSync.this.getParentFragmentManager();
                    C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    companion.show(parentFragmentManager);
                }
            }

            public AnonymousClass1() {
                super(1);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                C12238m.checkNotNullParameter(hook, "$receiver");
                hook.styles.add(new ClickableSpan(Integer.valueOf(ColorCompat.getColor(WidgetContactSync.this.getContext(), C5419R.color.link)), false, null, new C132851(), 4, null));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.f27425a;
            }
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.m8422a("learnMoreHook", new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$8 */
    /* JADX INFO: compiled from: WidgetContactSync.kt */
    public static final class C82378 extends AbstractC12240o implements Function0<Unit> {
        public C82378() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetContactSync.this.handlePhoneNumberTextChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.contact_sync.WidgetContactSync$configureUI$9 */
    /* JADX INFO: compiled from: WidgetContactSync.kt */
    public static final class C82389 extends AbstractC12240o implements Function1<String, Unit> {
        public C82389() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
            WidgetContactSync.this.getViewModel().onVerifyPhone(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.contact_sync.WidgetContactSync$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetContactSync.kt */
    public static final class C82392 extends AbstractC12240o implements Function2<Long, Boolean, Unit> {
        public C82392() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, Boolean bool) {
            invoke(l.longValue(), bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(long j, boolean z2) {
            WidgetContactSync.this.getViewModel().handleToggleFriendSuggestionSelected(j, z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.contact_sync.WidgetContactSync$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetContactSync.kt */
    public static final class C82401 extends AbstractC12240o implements Function1<WidgetContactSyncViewModel.ViewState, Unit> {
        public C82401() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetContactSyncViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetContactSyncViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "it");
            WidgetContactSync.this.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.contact_sync.WidgetContactSync$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetContactSync.kt */
    public static final class C82412 extends AbstractC12240o implements Function1<WidgetContactSyncViewModel.Event, Unit> {
        public C82412() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetContactSyncViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetContactSyncViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "it");
            WidgetContactSync.this.handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.contact_sync.WidgetContactSync$requestContactsPermissions$1 */
    /* JADX INFO: compiled from: WidgetContactSync.kt */
    public static final class C82421 extends AbstractC12240o implements Function0<Unit> {
        public C82421() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetContactSync.this.onPermissionsGranted();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.contact_sync.WidgetContactSync$requestContactsPermissions$2 */
    /* JADX INFO: compiled from: WidgetContactSync.kt */
    public static final class C82432 extends AbstractC12240o implements Function0<Unit> {
        public C82432() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetContactSync.this.onPermissionsDenied();
        }
    }

    public WidgetContactSync() {
        super(C5419R.layout.widget_contact_sync);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetContactSync$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetContactSyncViewModel.class), new C8223x884328d6(this), new C0863f0(new WidgetContactSync$viewModel$2(this)));
        this.contactSyncFlowMetadata = new TrackImpressionMetadata(null, null, null, ImpressionGroups.CONTACT_SYNC_FLOW, 7);
        this.captchaLauncher = WidgetCaptcha.INSTANCE.registerForResult(this, new WidgetContactSync$captchaLauncher$1(this));
        this.loggingConfig = new LoggingConfig(false, null, new WidgetContactSync$loggingConfig$1(this), 3);
    }

    private final void configureToolbar(final WidgetContactSyncViewModel.ToolbarConfig toolbarConfig) {
        setActionBarDisplayHomeAsUpEnabled(toolbarConfig.getShowBackButton());
        setActionBarOptionsMenu(C5419R.menu.menu_contact_sync, new Action2<MenuItem, Context>() { // from class: com.discord.widgets.contact_sync.WidgetContactSync.configureToolbar.1
            @Override // p658rx.functions.Action2
            public final void call(MenuItem menuItem, Context context) {
                C12238m.checkNotNullExpressionValue(menuItem, "menuItem");
                if (menuItem.getItemId() != C5419R.id.menu_contact_sync_skip) {
                    return;
                }
                WidgetContactSync.this.getViewModel().skip();
            }
        }, new Action1<Menu>() { // from class: com.discord.widgets.contact_sync.WidgetContactSync.configureToolbar.2
            @Override // p658rx.functions.Action1
            public final void call(Menu menu) {
                MenuItem menuItemFindItem = menu.findItem(C5419R.id.menu_contact_sync_skip);
                C12238m.checkNotNullExpressionValue(menuItemFindItem, "menu.findItem(R.id.menu_contact_sync_skip)");
                menuItemFindItem.setVisible(toolbarConfig.getShowSkip());
            }
        });
        AppFragment.setOnBackPressed$default(this, new Func0<Boolean>() { // from class: com.discord.widgets.contact_sync.WidgetContactSync.configureToolbar.3
            @Override // p658rx.functions.Func0, java.util.concurrent.Callable
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
        LoadingButton loadingButton = getBinding().f16413e.f993c;
        C12238m.checkNotNullExpressionValue(loadingButton, "binding.contactSyncLandi…tactSyncLandingNextButton");
        loadingButton.setEnabled(viewState.getLandingNextEnabled());
        getBinding().f16413e.f993c.setIsLoading(viewState.isSubmitting());
        getBinding().f16414f.f1015d.setIsLoading(viewState.isSubmitting());
        getBinding().f16411c.f1042c.setIsLoading(viewState.isSubmitting());
        if (viewState.getPermissionsDenied()) {
            TextView textView = getBinding().f16413e.f992b;
            C12238m.checkNotNullExpressionValue(textView, "binding.contactSyncLandi…ncLandingNeedsPermissions");
            textView.setVisibility(0);
            View view = getBinding().f16413e.f994d;
            C12238m.checkNotNullExpressionValue(view, "binding.contactSyncLandi…LandingPermissionsDivider");
            view.setVisibility(0);
            getBinding().f16413e.f993c.setText(C1107b.m213e(this, C5419R.string.password_manager_open_settings, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null));
            getBinding().f16413e.f993c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.contact_sync.WidgetContactSync.configureUI.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    C12238m.checkNotNullExpressionValue(view2, "view");
                    Context context = view2.getContext();
                    C12238m.checkNotNullExpressionValue(context, "view.context");
                    Uri uriFromParts = Uri.fromParts("package", context.getPackageName(), null);
                    C12238m.checkNotNullExpressionValue(uriFromParts, "Uri.fromParts(\"package\",…ontext.packageName, null)");
                    intent.setData(uriFromParts);
                    view2.getContext().startActivity(intent);
                }
            });
        } else {
            TextView textView2 = getBinding().f16413e.f992b;
            C12238m.checkNotNullExpressionValue(textView2, "binding.contactSyncLandi…ncLandingNeedsPermissions");
            textView2.setVisibility(8);
            View view2 = getBinding().f16413e.f994d;
            C12238m.checkNotNullExpressionValue(view2, "binding.contactSyncLandi…LandingPermissionsDivider");
            view2.setVisibility(8);
            getBinding().f16413e.f993c.setText(C1107b.m213e(this, C5419R.string.get_started, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null));
            getBinding().f16413e.f993c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.contact_sync.WidgetContactSync.configureUI.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    WidgetContactSync.this.getViewModel().onLandingNext();
                }
            });
        }
        CheckedSetting checkedSetting = getBinding().f16413e.f995e.f1096c;
        C12238m.checkNotNullExpressionValue(checkedSetting, "binding.contactSyncLandi…ontactSyncDiscoveryToggle");
        checkedSetting.setChecked(viewState.getAllowPhone() || viewState.getAllowEmail());
        getBinding().f16413e.f995e.f1096c.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.contact_sync.WidgetContactSync.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                CheckedSetting checkedSetting2 = WidgetContactSync.this.getBinding().f16413e.f995e.f1096c;
                C12238m.checkNotNullExpressionValue(checkedSetting2, "binding.contactSyncLandi…ontactSyncDiscoveryToggle");
                boolean zIsChecked = checkedSetting2.isChecked();
                WidgetContactSync.this.getViewModel().onPermissionsToggle(!zIsChecked, !zIsChecked);
            }
        });
        LinkifiedTextView linkifiedTextView = getBinding().f16413e.f995e.f1095b;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.contactSyncLandi…contactSyncDiscoveryInfo2");
        C1107b.m221m(linkifiedTextView, C5419R.string.contact_sync_permissions_description_android, new Object[0], new C82334());
        getBinding().f16414f.f1015d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.contact_sync.WidgetContactSync.configureUI.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                WidgetContactSyncViewModel viewModel = WidgetContactSync.this.getViewModel();
                TextInputLayout textInputLayout = WidgetContactSync.this.getBinding().f16414f.f1014c;
                C12238m.checkNotNullExpressionValue(textInputLayout, "binding.contactSyncName.contactSyncNameInputWrap");
                viewModel.onNameSubmitted(ViewExtensions.getTextOrEmpty(textInputLayout));
            }
        });
        ContactSyncFriendSuggestionListAdapter contactSyncFriendSuggestionListAdapter = this.friendSuggestionsAdapter;
        if (contactSyncFriendSuggestionListAdapter != null) {
            contactSyncFriendSuggestionListAdapter.setData(viewState.getFriendSuggestions());
        }
        getBinding().f16411c.f1042c.setText(C1107b.m213e(this, C5419R.string.next, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null));
        getBinding().f16411c.f1042c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.contact_sync.WidgetContactSync.configureUI.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                WidgetContactSync.this.getViewModel().onBulkAddFriends();
            }
        });
        getBinding().f16410b.f967b.m8600b(this);
        getBinding().f16410b.f967b.setCountryCode(viewState.getCountryCode());
        getBinding().f16410b.f968c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.contact_sync.WidgetContactSync.configureUI.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                WidgetContactSync.submitPhoneNumber$default(WidgetContactSync.this, null, 1, null);
            }
        });
        getBinding().f16410b.f967b.m8599a(this, new C82378());
        getBinding().f16415g.f1123b.setOnCodeEntered(new C82389());
        getBinding().f16412d.f1068b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.contact_sync.WidgetContactSync.configureUI.10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                AnalyticsTracker.INSTANCE.friendAddViewed("Invite");
                C12238m.checkNotNullExpressionValue(view3, "it");
                Context context = view3.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                IntentUtils.performChooserSendIntent(context, C1107b.m213e(WidgetContactSync.this, C5419R.string.friends_share_tabbar_title, new Object[]{BuildConfig.HOST, viewState.getUsername()}, (4 & 4) != 0 ? C1107b.a.f1490j : null).toString(), C1107b.m213e(WidgetContactSync.this, C5419R.string.tip_instant_invite_title3, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null));
            }
        });
        getBinding().f16412d.f1069c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.contact_sync.WidgetContactSync.configureUI.11
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
            AppViewFlipper appViewFlipper = getBinding().f16416h;
            C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.contactSyncViewFlipper");
            appViewFlipper.setInAnimation(AnimationUtils.loadAnimation(getContext(), C5419R.anim.anim_fade_in_fast));
            AppViewFlipper appViewFlipper2 = getBinding().f16416h;
            C12238m.checkNotNullExpressionValue(appViewFlipper2, "binding.contactSyncViewFlipper");
            appViewFlipper2.setOutAnimation(AnimationUtils.loadAnimation(getContext(), C5419R.anim.anim_fade_out_fast));
        } else {
            int i2 = this.displayedChildIndex;
            if (iOrdinal > i2 || z2) {
                AppViewFlipper appViewFlipper3 = getBinding().f16416h;
                C12238m.checkNotNullExpressionValue(appViewFlipper3, "binding.contactSyncViewFlipper");
                appViewFlipper3.setInAnimation(AnimationUtils.loadAnimation(getContext(), C5419R.anim.activity_slide_horizontal_open_in));
                AppViewFlipper appViewFlipper4 = getBinding().f16416h;
                C12238m.checkNotNullExpressionValue(appViewFlipper4, "binding.contactSyncViewFlipper");
                appViewFlipper4.setOutAnimation(AnimationUtils.loadAnimation(getContext(), C5419R.anim.activity_slide_horizontal_open_out));
            } else if (iOrdinal < i2) {
                AppViewFlipper appViewFlipper5 = getBinding().f16416h;
                C12238m.checkNotNullExpressionValue(appViewFlipper5, "binding.contactSyncViewFlipper");
                appViewFlipper5.setInAnimation(AnimationUtils.loadAnimation(getContext(), C5419R.anim.activity_slide_horizontal_close_in));
                AppViewFlipper appViewFlipper6 = getBinding().f16416h;
                C12238m.checkNotNullExpressionValue(appViewFlipper6, "binding.contactSyncViewFlipper");
                appViewFlipper6.setOutAnimation(AnimationUtils.loadAnimation(getContext(), C5419R.anim.activity_slide_horizontal_close_out));
            }
        }
        AppViewFlipper appViewFlipper7 = getBinding().f16416h;
        C12238m.checkNotNullExpressionValue(appViewFlipper7, "binding.contactSyncViewFlipper");
        appViewFlipper7.setDisplayedChild(iOrdinal);
        this.displayedChildIndex = iOrdinal;
        getAppLogger().m8371a(null);
    }

    private final WidgetContactSyncBinding getBinding() {
        return (WidgetContactSyncBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetContactSyncViewModel getViewModel() {
        return (WidgetContactSyncViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetContactSyncViewModel.Event event) {
        if (C12238m.areEqual(event, WidgetContactSyncViewModel.Event.MaybeProceedFromLanding.INSTANCE)) {
            if (getMostRecentIntent().getBooleanExtra(INTENT_EXTRA_CONTACT_SYNC_IMMEDIATELY_PROCEED, false)) {
                getViewModel().onLandingNext();
                return;
            }
            return;
        }
        if (C12238m.areEqual(event, WidgetContactSyncViewModel.Event.PermissionsNeeded.INSTANCE)) {
            requestContactsPermissions();
            return;
        }
        if (C12238m.areEqual(event, WidgetContactSyncViewModel.Event.ContactsEnabled.INSTANCE)) {
            getViewModel().onContactsFetched(ContactsProviderUtils.INSTANCE.getAllContactPhoneNumbers(requireContext()));
            return;
        }
        if (C12238m.areEqual(event, WidgetContactSyncViewModel.Event.RateLimited.INSTANCE)) {
            C0876m.m168f(this, C1107b.m213e(this, C5419R.string.contact_sync_failed_alert_title, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null), 1);
            return;
        }
        if (C12238m.areEqual(event, WidgetContactSyncViewModel.Event.UploadFailed.INSTANCE)) {
            C0876m.m168f(this, C1107b.m213e(this, C5419R.string.contact_sync_failed_alert_message, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null), 1);
            return;
        }
        if (C12238m.areEqual(event, WidgetContactSyncViewModel.Event.ContactsEnableFailed.INSTANCE)) {
            C0876m.m168f(this, C1107b.m213e(this, C5419R.string.contact_sync_failed_alert_title, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null), 1);
            return;
        }
        if (C12238m.areEqual(event, WidgetContactSyncViewModel.Event.AddFriendsFailed.INSTANCE)) {
            AddFriendsFailed.Companion companion = AddFriendsFailed.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager).setOnClose(new WidgetContactSync$handleEvent$$inlined$apply$lambda$1(this));
            return;
        }
        if (C12238m.areEqual(event, WidgetContactSyncViewModel.Event.AddFriendsFailedPartial.INSTANCE)) {
            AddFriendsFailed.Companion companion2 = AddFriendsFailed.INSTANCE;
            FragmentManager parentFragmentManager2 = getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            companion2.show(parentFragmentManager2).setOnClose(new WidgetContactSync$handleEvent$$inlined$apply$lambda$2(this));
            return;
        }
        if (C12238m.areEqual(event, WidgetContactSyncViewModel.Event.PhoneInvalid.INSTANCE)) {
            C0876m.m172j(this, C1107b.m213e(this, C5419R.string.phone_invalid, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null), 0, 4);
            return;
        }
        if (C12238m.areEqual(event, WidgetContactSyncViewModel.Event.VerificationCodeInvalid.INSTANCE)) {
            C0876m.m172j(this, C1107b.m213e(this, C5419R.string.application_entitlement_code_redemption_invalid, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null), 0, 4);
        } else if (C12238m.areEqual(event, WidgetContactSyncViewModel.Event.VerificationFailed.INSTANCE)) {
            C0876m.m172j(this, C1107b.m213e(this, C5419R.string.phone_failed_to_add, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null), 0, 4);
        } else if (C12238m.areEqual(event, WidgetContactSyncViewModel.Event.Completed.INSTANCE)) {
            requireAppActivity().finish();
        }
    }

    private final void handlePhoneNumberTextChanged() {
        String textOrEmpty = getBinding().f16410b.f967b.getTextOrEmpty();
        MaterialButton materialButton = getBinding().f16410b.f968c;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.contactSyncAddPh…e.contactSyncAddPhoneNext");
        materialButton.setEnabled((textOrEmpty.length() > 0) && C12103t.startsWith$default(textOrEmpty, BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX, false, 2, null));
    }

    private final void launchCaptchaFlow(Error error) {
        WidgetCaptcha.Companion companion = WidgetCaptcha.INSTANCE;
        Context contextRequireContext = requireContext();
        ActivityResultLauncher<Intent> activityResultLauncher = this.captchaLauncher;
        Error.Response response = error.getResponse();
        C12238m.checkNotNullExpressionValue(response, "error.response");
        companion.processErrorsForCaptcha(contextRequireContext, activityResultLauncher, C12163u.toMutableList((Collection) response.getMessages().keySet()), error);
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
            C12238m.checkNotNull(str);
            String ownName = contactsProviderUtils.getOwnName(contextRequireContext, str);
            if (ownName != null) {
                getBinding().f16414f.f1013b.setText(ownName);
                TextView textView = getBinding().f16414f.f1016e;
                C12238m.checkNotNullExpressionValue(textView, "binding.contactSyncName.contactSyncNamePrefillHint");
                textView.setVisibility(0);
            }
        }
    }

    private final void requestContactsPermissions() {
        if (!ContactsProviderUtils.INSTANCE.hasContactPermissions(requireContext())) {
            AnalyticsTracker.INSTANCE.permissionsRequested("contacts");
            getViewModel().requestingPermissions();
        }
        requestContacts(new C82421(), new C82432());
    }

    private final void submitPhoneNumber(CaptchaHelper.CaptchaPayload captchaPayload) {
        getViewModel().onPhoneNumberSubmitted(getBinding().f16410b.f967b.getTextOrEmpty(), captchaPayload);
    }

    public static /* synthetic */ void submitPhoneNumber$default(WidgetContactSync widgetContactSync, CaptchaHelper.CaptchaPayload captchaPayload, int i, Object obj) {
        if ((i & 1) != 0) {
            captchaPayload = null;
        }
        widgetContactSync.submitPhoneNumber(captchaPayload);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public LoggingConfig getLoggingConfig() {
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
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RecyclerView recyclerView = getBinding().f16411c.f1041b;
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        C12238m.checkNotNullExpressionValue(recyclerView, "it");
        ContactSyncFriendSuggestionListAdapter contactSyncFriendSuggestionListAdapter = (ContactSyncFriendSuggestionListAdapter) companion.configure(new ContactSyncFriendSuggestionListAdapter(recyclerView));
        this.friendSuggestionsAdapter = contactSyncFriendSuggestionListAdapter;
        if (contactSyncFriendSuggestionListAdapter != null) {
            contactSyncFriendSuggestionListAdapter.setOnClickFriendSuggestion(new C82392());
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetContactSync.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C82401());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetContactSync.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C82412());
    }
}
