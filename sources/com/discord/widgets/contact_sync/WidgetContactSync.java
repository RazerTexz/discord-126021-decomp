package com.discord.widgets.contact_sync;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.f0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$anim;
import com.discord.R$layout;
import com.discord.R$menu;
import com.discord.analytics.generated.traits.TrackImpressionMetadata;
import com.discord.analytics.utils.ImpressionGroups;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetContactSyncBinding;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.captcha.CaptchaHelper$CaptchaPayload;
import com.discord.utilities.contacts.ContactsProviderUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.error.Error$Response;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.views.LoadingButton;
import com.discord.widgets.captcha.WidgetCaptcha;
import com.discord.widgets.captcha.WidgetCaptcha$Companion;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.button.MaterialButton;
import d0.g0.t;
import d0.t.u;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.Collection;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetContactSync.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetContactSync extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetContactSync.class, "binding", "getBinding()Lcom/discord/databinding/WidgetContactSyncBinding;", 0)};
    public static final WidgetContactSync$Companion Companion = new WidgetContactSync$Companion(null);
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

    public WidgetContactSync() {
        super(R$layout.widget_contact_sync);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetContactSync$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetContactSyncViewModel.class), new WidgetContactSync$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(new WidgetContactSync$viewModel$2(this)));
        this.contactSyncFlowMetadata = new TrackImpressionMetadata(null, null, null, ImpressionGroups.CONTACT_SYNC_FLOW, 7);
        this.captchaLauncher = WidgetCaptcha.Companion.registerForResult(this, new WidgetContactSync$captchaLauncher$1(this));
        this.loggingConfig = new LoggingConfig(false, null, new WidgetContactSync$loggingConfig$1(this), 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetContactSync widgetContactSync, WidgetContactSyncViewModel$ViewState widgetContactSyncViewModel$ViewState) {
        widgetContactSync.configureUI(widgetContactSyncViewModel$ViewState);
    }

    public static final /* synthetic */ WidgetContactSyncBinding access$getBinding$p(WidgetContactSync widgetContactSync) {
        return widgetContactSync.getBinding();
    }

    public static final /* synthetic */ TrackImpressionMetadata access$getContactSyncFlowMetadata$p(WidgetContactSync widgetContactSync) {
        return widgetContactSync.contactSyncFlowMetadata;
    }

    public static final /* synthetic */ int access$getDisplayedChildIndex$p(WidgetContactSync widgetContactSync) {
        return widgetContactSync.displayedChildIndex;
    }

    public static final /* synthetic */ WidgetContactSyncViewModel access$getViewModel$p(WidgetContactSync widgetContactSync) {
        return widgetContactSync.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetContactSync widgetContactSync, WidgetContactSyncViewModel$Event widgetContactSyncViewModel$Event) {
        widgetContactSync.handleEvent(widgetContactSyncViewModel$Event);
    }

    public static final /* synthetic */ void access$handlePhoneNumberTextChanged(WidgetContactSync widgetContactSync) {
        widgetContactSync.handlePhoneNumberTextChanged();
    }

    public static final /* synthetic */ void access$launchCaptchaFlow(WidgetContactSync widgetContactSync, Error error) {
        widgetContactSync.launchCaptchaFlow(error);
    }

    public static final /* synthetic */ void access$onPermissionsDenied(WidgetContactSync widgetContactSync) {
        widgetContactSync.onPermissionsDenied();
    }

    public static final /* synthetic */ void access$onPermissionsGranted(WidgetContactSync widgetContactSync) {
        widgetContactSync.onPermissionsGranted();
    }

    public static final /* synthetic */ void access$setDisplayedChildIndex$p(WidgetContactSync widgetContactSync, int i) {
        widgetContactSync.displayedChildIndex = i;
    }

    public static final /* synthetic */ void access$submitPhoneNumber(WidgetContactSync widgetContactSync, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload) {
        widgetContactSync.submitPhoneNumber(captchaHelper$CaptchaPayload);
    }

    private final void configureToolbar(WidgetContactSyncViewModel$ToolbarConfig toolbarConfig) {
        setActionBarDisplayHomeAsUpEnabled(toolbarConfig.getShowBackButton());
        setActionBarOptionsMenu(R$menu.menu_contact_sync, new WidgetContactSync$configureToolbar$1(this), new WidgetContactSync$configureToolbar$2(toolbarConfig));
        AppFragment.setOnBackPressed$default(this, new WidgetContactSync$configureToolbar$3(this, toolbarConfig), 0, 2, null);
    }

    private final void configureUI(WidgetContactSyncViewModel$ViewState viewState) {
        this.phoneNumber = viewState.getPhoneNumber();
        configureViewFlipper(viewState.getDisplayedChild());
        configureToolbar(viewState.getToolbarConfig());
        LoadingButton loadingButton = getBinding().e.c;
        m.checkNotNullExpressionValue(loadingButton, "binding.contactSyncLandi…tactSyncLandingNextButton");
        loadingButton.setEnabled(viewState.getLandingNextEnabled());
        getBinding().e.c.setIsLoading(viewState.isSubmitting());
        getBinding().f.d.setIsLoading(viewState.isSubmitting());
        getBinding().c.c.setIsLoading(viewState.isSubmitting());
        if (viewState.getPermissionsDenied()) {
            TextView textView = getBinding().e.f144b;
            m.checkNotNullExpressionValue(textView, "binding.contactSyncLandi…ncLandingNeedsPermissions");
            textView.setVisibility(0);
            View view = getBinding().e.d;
            m.checkNotNullExpressionValue(view, "binding.contactSyncLandi…LandingPermissionsDivider");
            view.setVisibility(0);
            getBinding().e.c.setText(b.k(this, 2131893652, new Object[0], null, 4));
            getBinding().e.c.setOnClickListener(WidgetContactSync$configureUI$1.INSTANCE);
        } else {
            TextView textView2 = getBinding().e.f144b;
            m.checkNotNullExpressionValue(textView2, "binding.contactSyncLandi…ncLandingNeedsPermissions");
            textView2.setVisibility(8);
            View view2 = getBinding().e.d;
            m.checkNotNullExpressionValue(view2, "binding.contactSyncLandi…LandingPermissionsDivider");
            view2.setVisibility(8);
            getBinding().e.c.setText(b.k(this, 2131889621, new Object[0], null, 4));
            getBinding().e.c.setOnClickListener(new WidgetContactSync$configureUI$2(this));
        }
        CheckedSetting checkedSetting = getBinding().e.e.c;
        m.checkNotNullExpressionValue(checkedSetting, "binding.contactSyncLandi…ontactSyncDiscoveryToggle");
        checkedSetting.setChecked(viewState.getAllowPhone() || viewState.getAllowEmail());
        getBinding().e.e.c.e(new WidgetContactSync$configureUI$3(this));
        LinkifiedTextView linkifiedTextView = getBinding().e.e.f171b;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.contactSyncLandi…contactSyncDiscoveryInfo2");
        b.m(linkifiedTextView, 2131887901, new Object[0], new WidgetContactSync$configureUI$4(this));
        getBinding().f.d.setOnClickListener(new WidgetContactSync$configureUI$5(this));
        ContactSyncFriendSuggestionListAdapter contactSyncFriendSuggestionListAdapter = this.friendSuggestionsAdapter;
        if (contactSyncFriendSuggestionListAdapter != null) {
            contactSyncFriendSuggestionListAdapter.setData(viewState.getFriendSuggestions());
        }
        getBinding().c.c.setText(b.k(this, 2131893214, new Object[0], null, 4));
        getBinding().c.c.setOnClickListener(new WidgetContactSync$configureUI$6(this));
        getBinding().f2355b.f138b.b(this);
        getBinding().f2355b.f138b.setCountryCode(viewState.getCountryCode());
        getBinding().f2355b.c.setOnClickListener(new WidgetContactSync$configureUI$7(this));
        getBinding().f2355b.f138b.a(this, new WidgetContactSync$configureUI$8(this));
        getBinding().g.f177b.setOnCodeEntered(new WidgetContactSync$configureUI$9(this));
        getBinding().d.f164b.setOnClickListener(new WidgetContactSync$configureUI$10(this, viewState));
        getBinding().d.c.setOnClickListener(new WidgetContactSync$configureUI$11(this));
    }

    private final void configureViewFlipper(WidgetContactSyncViewModel$Views displayedChild) {
        int i;
        int iOrdinal = displayedChild.ordinal();
        boolean z2 = true;
        if (iOrdinal != this.displayedChildIndex) {
            AppFragment.hideKeyboard$default(this, null, 1, null);
        }
        if (displayedChild != WidgetContactSyncViewModel$Views.VIEW_LANDING || ((i = this.displayedChildIndex) != 2 && i != 3)) {
            z2 = false;
        }
        if (AccessibilityUtils.INSTANCE.isReducedMotionEnabled()) {
            AppViewFlipper appViewFlipper = getBinding().h;
            m.checkNotNullExpressionValue(appViewFlipper, "binding.contactSyncViewFlipper");
            appViewFlipper.setInAnimation(AnimationUtils.loadAnimation(getContext(), R$anim.anim_fade_in_fast));
            AppViewFlipper appViewFlipper2 = getBinding().h;
            m.checkNotNullExpressionValue(appViewFlipper2, "binding.contactSyncViewFlipper");
            appViewFlipper2.setOutAnimation(AnimationUtils.loadAnimation(getContext(), R$anim.anim_fade_out_fast));
        } else {
            int i2 = this.displayedChildIndex;
            if (iOrdinal > i2 || z2) {
                AppViewFlipper appViewFlipper3 = getBinding().h;
                m.checkNotNullExpressionValue(appViewFlipper3, "binding.contactSyncViewFlipper");
                appViewFlipper3.setInAnimation(AnimationUtils.loadAnimation(getContext(), R$anim.activity_slide_horizontal_open_in));
                AppViewFlipper appViewFlipper4 = getBinding().h;
                m.checkNotNullExpressionValue(appViewFlipper4, "binding.contactSyncViewFlipper");
                appViewFlipper4.setOutAnimation(AnimationUtils.loadAnimation(getContext(), R$anim.activity_slide_horizontal_open_out));
            } else if (iOrdinal < i2) {
                AppViewFlipper appViewFlipper5 = getBinding().h;
                m.checkNotNullExpressionValue(appViewFlipper5, "binding.contactSyncViewFlipper");
                appViewFlipper5.setInAnimation(AnimationUtils.loadAnimation(getContext(), R$anim.activity_slide_horizontal_close_in));
                AppViewFlipper appViewFlipper6 = getBinding().h;
                m.checkNotNullExpressionValue(appViewFlipper6, "binding.contactSyncViewFlipper");
                appViewFlipper6.setOutAnimation(AnimationUtils.loadAnimation(getContext(), R$anim.activity_slide_horizontal_close_out));
            }
        }
        AppViewFlipper appViewFlipper7 = getBinding().h;
        m.checkNotNullExpressionValue(appViewFlipper7, "binding.contactSyncViewFlipper");
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

    private final void handleEvent(WidgetContactSyncViewModel$Event event) {
        if (m.areEqual(event, WidgetContactSyncViewModel$Event$MaybeProceedFromLanding.INSTANCE)) {
            if (getMostRecentIntent().getBooleanExtra(INTENT_EXTRA_CONTACT_SYNC_IMMEDIATELY_PROCEED, false)) {
                getViewModel().onLandingNext();
                return;
            }
            return;
        }
        if (m.areEqual(event, WidgetContactSyncViewModel$Event$PermissionsNeeded.INSTANCE)) {
            requestContactsPermissions();
            return;
        }
        if (m.areEqual(event, WidgetContactSyncViewModel$Event$ContactsEnabled.INSTANCE)) {
            getViewModel().onContactsFetched(ContactsProviderUtils.INSTANCE.getAllContactPhoneNumbers(requireContext()));
            return;
        }
        if (m.areEqual(event, WidgetContactSyncViewModel$Event$RateLimited.INSTANCE)) {
            b.a.d.m.f(this, b.k(this, 2131887881, new Object[0], null, 4), 1);
            return;
        }
        if (m.areEqual(event, WidgetContactSyncViewModel$Event$UploadFailed.INSTANCE)) {
            b.a.d.m.f(this, b.k(this, 2131887880, new Object[0], null, 4), 1);
            return;
        }
        if (m.areEqual(event, WidgetContactSyncViewModel$Event$ContactsEnableFailed.INSTANCE)) {
            b.a.d.m.f(this, b.k(this, 2131887881, new Object[0], null, 4), 1);
            return;
        }
        if (m.areEqual(event, WidgetContactSyncViewModel$Event$AddFriendsFailed.INSTANCE)) {
            AddFriendsFailed$Companion addFriendsFailed$Companion = AddFriendsFailed.Companion;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            addFriendsFailed$Companion.show(parentFragmentManager).setOnClose(new WidgetContactSync$handleEvent$$inlined$apply$lambda$1(this));
            return;
        }
        if (m.areEqual(event, WidgetContactSyncViewModel$Event$AddFriendsFailedPartial.INSTANCE)) {
            AddFriendsFailed$Companion addFriendsFailed$Companion2 = AddFriendsFailed.Companion;
            FragmentManager parentFragmentManager2 = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            addFriendsFailed$Companion2.show(parentFragmentManager2).setOnClose(new WidgetContactSync$handleEvent$$inlined$apply$lambda$2(this));
            return;
        }
        if (m.areEqual(event, WidgetContactSyncViewModel$Event$PhoneInvalid.INSTANCE)) {
            b.a.d.m.j(this, b.k(this, 2131893782, new Object[0], null, 4), 0, 4);
            return;
        }
        if (m.areEqual(event, WidgetContactSyncViewModel$Event$VerificationCodeInvalid.INSTANCE)) {
            b.a.d.m.j(this, b.k(this, 2131886536, new Object[0], null, 4), 0, 4);
        } else if (m.areEqual(event, WidgetContactSyncViewModel$Event$VerificationFailed.INSTANCE)) {
            b.a.d.m.j(this, b.k(this, 2131893781, new Object[0], null, 4), 0, 4);
        } else if (m.areEqual(event, WidgetContactSyncViewModel$Event$Completed.INSTANCE)) {
            requireAppActivity().finish();
        }
    }

    private final void handlePhoneNumberTextChanged() {
        String textOrEmpty = getBinding().f2355b.f138b.getTextOrEmpty();
        MaterialButton materialButton = getBinding().f2355b.c;
        m.checkNotNullExpressionValue(materialButton, "binding.contactSyncAddPh…e.contactSyncAddPhoneNext");
        materialButton.setEnabled((textOrEmpty.length() > 0) && t.startsWith$default(textOrEmpty, BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX, false, 2, null));
    }

    private final void launchCaptchaFlow(Error error) {
        WidgetCaptcha$Companion widgetCaptcha$Companion = WidgetCaptcha.Companion;
        Context contextRequireContext = requireContext();
        ActivityResultLauncher<Intent> activityResultLauncher = this.captchaLauncher;
        Error$Response response = error.getResponse();
        m.checkNotNullExpressionValue(response, "error.response");
        widgetCaptcha$Companion.processErrorsForCaptcha(contextRequireContext, activityResultLauncher, u.toMutableList((Collection) response.getMessages().keySet()), error);
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
            m.checkNotNull(str);
            String ownName = contactsProviderUtils.getOwnName(contextRequireContext, str);
            if (ownName != null) {
                getBinding().f.f150b.setText(ownName);
                TextView textView = getBinding().f.e;
                m.checkNotNullExpressionValue(textView, "binding.contactSyncName.contactSyncNamePrefillHint");
                textView.setVisibility(0);
            }
        }
    }

    private final void requestContactsPermissions() {
        if (!ContactsProviderUtils.INSTANCE.hasContactPermissions(requireContext())) {
            AnalyticsTracker.INSTANCE.permissionsRequested("contacts");
            getViewModel().requestingPermissions();
        }
        requestContacts(new WidgetContactSync$requestContactsPermissions$1(this), new WidgetContactSync$requestContactsPermissions$2(this));
    }

    private final void submitPhoneNumber(CaptchaHelper$CaptchaPayload captchaPayload) {
        getViewModel().onPhoneNumberSubmitted(getBinding().f2355b.f138b.getTextOrEmpty(), captchaPayload);
    }

    public static /* synthetic */ void submitPhoneNumber$default(WidgetContactSync widgetContactSync, CaptchaHelper$CaptchaPayload captchaHelper$CaptchaPayload, int i, Object obj) {
        if ((i & 1) != 0) {
            captchaHelper$CaptchaPayload = null;
        }
        widgetContactSync.submitPhoneNumber(captchaHelper$CaptchaPayload);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger$a
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
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RecyclerView recyclerView = getBinding().c.f157b;
        MGRecyclerAdapter$Companion mGRecyclerAdapter$Companion = MGRecyclerAdapter.Companion;
        m.checkNotNullExpressionValue(recyclerView, "it");
        ContactSyncFriendSuggestionListAdapter contactSyncFriendSuggestionListAdapter = (ContactSyncFriendSuggestionListAdapter) mGRecyclerAdapter$Companion.configure(new ContactSyncFriendSuggestionListAdapter(recyclerView));
        this.friendSuggestionsAdapter = contactSyncFriendSuggestionListAdapter;
        if (contactSyncFriendSuggestionListAdapter != null) {
            contactSyncFriendSuggestionListAdapter.setOnClickFriendSuggestion(new WidgetContactSync$onViewBound$2(this));
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetContactSync.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetContactSync$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetContactSync.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetContactSync$onViewBoundOrOnResume$2(this), 62, (Object) null);
    }
}
