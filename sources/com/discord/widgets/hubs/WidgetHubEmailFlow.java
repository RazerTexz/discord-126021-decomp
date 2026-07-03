package com.discord.widgets.hubs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.NotificationCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.api.hubs.EmailVerification;
import com.discord.api.hubs.GuildInfo;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetHubEmailFlowBinding;
import com.discord.stores.StoreNux;
import com.discord.stores.StoreStream;
import com.discord.stores.utilities.Loading;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.stores.utilities.Success;
import com.discord.utilities.error.Error;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.view.validators.ValidationManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.LoadingButton;
import com.discord.widgets.guilds.create.CreateGuildTrigger;
import com.discord.widgets.nux.WidgetGuildTemplates;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p025i.C0949e5;
import p007b.p008a.p025i.C1022o5;
import p007b.p008a.p025i.C1029p5;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetHubEmailFlow.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEmailFlow extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetHubEmailFlow.class, "binding", "getBinding()Lcom/discord/databinding/WidgetHubEmailFlowBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String NAME = WidgetHubEmailFlow.class.getName();
    private final ActivityResultLauncher<Intent> activityResultHandler;

    /* JADX INFO: renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final LoggingConfig loggingConfig;

    /* JADX INFO: renamed from: validationManager$delegate, reason: from kotlin metadata */
    private final Lazy validationManager;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetHubEmailFlow.kt */
    public static final class Companion {
        private Companion() {
        }

        public final String getNAME() {
            return WidgetHubEmailFlow.NAME;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            HubEmailEntryPoint.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            HubEmailEntryPoint hubEmailEntryPoint = HubEmailEntryPoint.Invite;
            iArr[hubEmailEntryPoint.ordinal()] = 1;
            HubEmailEntryPoint hubEmailEntryPoint2 = HubEmailEntryPoint.Onboarding;
            iArr[hubEmailEntryPoint2.ordinal()] = 2;
            HubEmailEntryPoint.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[hubEmailEntryPoint.ordinal()] = 1;
            iArr2[hubEmailEntryPoint2.ordinal()] = 2;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetHubEmailFlow.kt */
    public static final class C90341 extends AbstractC12240o implements Function1<HubEmailState, Unit> {
        public C90341() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(HubEmailState hubEmailState) {
            invoke2(hubEmailState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(HubEmailState hubEmailState) {
            WidgetHubEmailFlow widgetHubEmailFlow = WidgetHubEmailFlow.this;
            C12238m.checkNotNullExpressionValue(hubEmailState, "viewState");
            widgetHubEmailFlow.updateView(hubEmailState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$updateView$4 */
    /* JADX INFO: compiled from: WidgetHubEmailFlow.kt */
    public static final class C90414 extends AbstractC12240o implements Function1<Success<? extends EmailVerification>, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ String $email;
        public final /* synthetic */ HubEmailState $state;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C90414(HubEmailState hubEmailState, Context context, String str) {
            super(1);
            this.$state = hubEmailState;
            this.$context = context;
            this.$email = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Success<? extends EmailVerification> success) {
            invoke2((Success<EmailVerification>) success);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Success<EmailVerification> success) {
            C12238m.checkNotNullParameter(success, "it");
            StoreStream.INSTANCE.getDirectories().markDiscordHubClicked();
            if (!this.$state.getHasMultipleDomains()) {
                EmailVerification emailVerificationInvoke = this.$state.getVerifyEmailAsync().invoke();
                if (emailVerificationInvoke == null || emailVerificationInvoke.getHasMatchingGuild() || !GrowthTeamFeatures.INSTANCE.isMultiDomainEnabled()) {
                    return;
                }
                C0870j.f524g.m160f(this.$context, WidgetHubEmailFlow.this.activityResultHandler, WidgetHubWaitlist.class, new HubWaitlistArgs(this.$email));
                WidgetHubEmailFlow.this.getViewModel().reset();
                return;
            }
            C0870j c0870j = C0870j.f524g;
            Context context = this.$context;
            ActivityResultLauncher<Intent> activityResultLauncher = WidgetHubEmailFlow.this.activityResultHandler;
            String str = this.$email;
            List<GuildInfo> listM7998a = success.invoke().m7998a();
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(listM7998a, 10));
            Iterator<T> it = listM7998a.iterator();
            while (it.hasNext()) {
                arrayList.add(DomainGuildInfo.INSTANCE.from((GuildInfo) it.next()));
            }
            c0870j.m160f(context, activityResultLauncher, WidgetHubDomains.class, new HubDomainArgs(str, arrayList));
            WidgetHubEmailFlow.this.getViewModel().reset();
        }
    }

    public WidgetHubEmailFlow() {
        super(C5419R.layout.widget_hub_email_flow);
        this.args = C12083g.lazy(new WidgetHubEmailFlow$$special$$inlined$args$1(this, "intent_args_key"));
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetHubEmailFlow$binding$2.INSTANCE, null, 2, null);
        ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: com.discord.widgets.hubs.WidgetHubEmailFlow$activityResultHandler$1
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(ActivityResult activityResult) {
                Intent data;
                if (activityResult == null || (data = activityResult.getData()) == null) {
                    return;
                }
                if (!(activityResult.getResultCode() == -1)) {
                    data = null;
                }
                if (data != null) {
                    C12238m.checkNotNullParameter(data, "$this$getArgsFromIntent");
                    MultipleDomainResult multipleDomainResult = (MultipleDomainResult) data.getParcelableExtra("intent_args_key");
                    if (multipleDomainResult != null) {
                        if (multipleDomainResult instanceof HubWaitlistResult) {
                            this.this$0.getViewModel().setHubWaitlistResult((HubWaitlistResult) multipleDomainResult);
                            return;
                        }
                        if (!(multipleDomainResult instanceof AuthenticationResult)) {
                            FragmentActivity fragmentActivityM95e = this.this$0.m95e();
                            if (fragmentActivityM95e != null) {
                                fragmentActivityM95e.finish();
                                return;
                            }
                            return;
                        }
                        StoreStream.INSTANCE.getGuildSelected().set(((AuthenticationResult) multipleDomainResult).getGuildId());
                        FragmentActivity fragmentActivityM95e2 = this.this$0.m95e();
                        if (fragmentActivityM95e2 != null) {
                            fragmentActivityM95e2.finish();
                        }
                    }
                }
            }
        });
        C12238m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResul…  }\n            }\n      }");
        this.activityResultHandler = activityResultLauncherRegisterForActivityResult;
        WidgetHubEmailFlow$viewModel$2 widgetHubEmailFlow$viewModel$2 = WidgetHubEmailFlow$viewModel$2.INSTANCE;
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetHubEmailViewModel.class), new WidgetHubEmailFlow$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetHubEmailFlow$viewModel$2));
        this.validationManager = C12083g.lazy(new WidgetHubEmailFlow$validationManager$2(this));
        this.loggingConfig = new LoggingConfig(false, null, new WidgetHubEmailFlow$loggingConfig$1(this), 3);
    }

    private final HubEmailArgs getArgs() {
        return (HubEmailArgs) this.args.getValue();
    }

    private final WidgetHubEmailFlowBinding getBinding() {
        return (WidgetHubEmailFlowBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getEmail() {
        TextInputEditText textInputEditText = getBinding().f17175c.f819c;
        C12238m.checkNotNullExpressionValue(textInputEditText, "binding.discordHubEmailI…aderDescriptionEmailInput");
        return String.valueOf(textInputEditText.getText());
    }

    private final ValidationManager getValidationManager() {
        return (ValidationManager) this.validationManager.getValue();
    }

    private final WidgetHubEmailViewModel getViewModel() {
        return (WidgetHubEmailViewModel) this.viewModel.getValue();
    }

    private final void updateView(HubEmailState state) {
        String school;
        Context context = getContext();
        if (context != null) {
            C12238m.checkNotNullExpressionValue(context, "context ?: return");
            EmailVerification emailVerificationInvoke = state.getVerifyEmailAsync().invoke();
            boolean z2 = emailVerificationInvoke != null && emailVerificationInvoke.getHasMatchingGuild();
            boolean z3 = !(state.getVerifyEmailAsync() instanceof Success) && state.getWaitlistResult() == null;
            EmailVerification emailVerificationInvoke2 = state.getVerifyEmailAsync().invoke();
            boolean z4 = ((emailVerificationInvoke2 == null || emailVerificationInvoke2.getHasMatchingGuild()) && state.getWaitlistResult() == null) ? false : true;
            TextInputEditText textInputEditText = getBinding().f17175c.f819c;
            C12238m.checkNotNullExpressionValue(textInputEditText, "binding.discordHubEmailI…aderDescriptionEmailInput");
            String strValueOf = String.valueOf(textInputEditText.getText());
            C0949e5 c0949e5 = getBinding().f17175c;
            C12238m.checkNotNullExpressionValue(c0949e5, "binding.discordHubEmailInput");
            NestedScrollView nestedScrollView = c0949e5.f817a;
            C12238m.checkNotNullExpressionValue(nestedScrollView, "binding.discordHubEmailInput.root");
            nestedScrollView.setVisibility(z3 ? 0 : 8);
            MaterialButton materialButton = getBinding().f17176d;
            C12238m.checkNotNullExpressionValue(materialButton, "binding.discordHubEmailNo");
            materialButton.setVisibility(z3 ? 0 : 8);
            C1022o5 c1022o5 = getBinding().f17174b;
            C12238m.checkNotNullExpressionValue(c1022o5, "binding.discordHubEmailConfirmation");
            NestedScrollView nestedScrollView2 = c1022o5.f1117a;
            C12238m.checkNotNullExpressionValue(nestedScrollView2, "binding.discordHubEmailConfirmation.root");
            nestedScrollView2.setVisibility(z2 ? 0 : 8);
            TextView textView = getBinding().f17174b.f1119c;
            C12238m.checkNotNullExpressionValue(textView, "binding.discordHubEmailC…ilConfirmationHeaderTitle");
            textView.setText(C1107b.m213e(this, C5419R.string.member_verification_email_confirmation_title, new Object[]{strValueOf}, (4 & 4) != 0 ? C1107b.a.f1490j : null));
            C1029p5 c1029p5 = getBinding().f17178f;
            C12238m.checkNotNullExpressionValue(c1029p5, "binding.discordHubWaitlist");
            NestedScrollView nestedScrollView3 = c1029p5.f1139a;
            C12238m.checkNotNullExpressionValue(nestedScrollView3, "binding.discordHubWaitlist.root");
            nestedScrollView3.setVisibility(z4 ? 0 : 8);
            HubWaitlistResult waitlistResult = state.getWaitlistResult();
            if (waitlistResult != null && (school = waitlistResult.getSchool()) != null) {
                TextView textView2 = getBinding().f17178f.f1140b;
                C12238m.checkNotNullExpressionValue(textView2, "binding.discordHubWaitlist.hubWaitlistDescription");
                textView2.setText(C1107b.m213e(this, C5419R.string.hub_waitlist_modal_joined_description, new Object[]{school}, (4 & 4) != 0 ? C1107b.a.f1490j : null));
            }
            getBinding().f17177e.setOnClickListener(z4 ? new View.OnClickListener() { // from class: com.discord.widgets.hubs.WidgetHubEmailFlow.updateView.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FragmentActivity fragmentActivityM95e = WidgetHubEmailFlow.this.m95e();
                    if (fragmentActivityM95e != null) {
                        fragmentActivityM95e.finish();
                    }
                }
            } : new View.OnClickListener() { // from class: com.discord.widgets.hubs.WidgetHubEmailFlow.updateView.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetHubEmailFlow.this.verifyEmail();
                }
            });
            LoadingButton loadingButton = getBinding().f17177e;
            C12238m.checkNotNullExpressionValue(loadingButton, "binding.discordHubEmailYes");
            loadingButton.setVisibility(z2 ^ true ? 0 : 8);
            getBinding().f17177e.setText(z4 ? getString(C5419R.string.hub_add_server_confirmation_button) : getString(C5419R.string.hub_email_connection_content_button));
            getBinding().f17177e.setIsLoading(state.getVerifyEmailAsync() instanceof Loading);
            RestCallStateKt.handleResponse$default(state.getVerifyEmailAsync(), context, null, null, new C90414(state, context, strValueOf), 6, null);
        }
    }

    private final void verifyEmail() {
        boolean zValidate$default = ValidationManager.validate$default(getValidationManager(), false, 1, null);
        TextView textView = getBinding().f17175c.f822f;
        C12238m.checkNotNullExpressionValue(textView, "binding.discordHubEmailInput.discordHubEmailLabel");
        textView.setVisibility(zValidate$default ? 0 : 8);
        if (zValidate$default) {
            getViewModel().submitEmail(getEmail());
            hideKeyboard(getView());
        }
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<HubEmailState> observableM11112r = getViewModel().observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), (Class<?>) WidgetHubEmailFlow.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C90341());
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        CharSequence string;
        int i;
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().f17174b.f1120d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.hubs.WidgetHubEmailFlow.onViewCreated.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetHubEmailFlow.this.verifyEmail();
            }
        });
        getBinding().f17176d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.hubs.WidgetHubEmailFlow.onViewCreated.2

            /* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$onViewCreated$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetHubEmailFlow.kt */
            public static final class AnonymousClass1 extends AbstractC12240o implements Function1<StoreNux.NuxState, StoreNux.NuxState> {
                public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                public AnonymousClass1() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final StoreNux.NuxState invoke(StoreNux.NuxState nuxState) {
                    C12238m.checkNotNullParameter(nuxState, "it");
                    return StoreNux.NuxState.copy$default(nuxState, false, false, false, false, false, null, 62, null);
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentActivity fragmentActivityM95e = WidgetHubEmailFlow.this.m95e();
                if (fragmentActivityM95e != null) {
                    C12238m.checkNotNullExpressionValue(fragmentActivityM95e, "activity ?: return@setOnClickListener");
                    if (WidgetHubEmailFlow.this.getArgs().getEntryPoint() == HubEmailEntryPoint.Onboarding) {
                        StoreStream.INSTANCE.getNux().updateNux(AnonymousClass1.INSTANCE);
                        WidgetGuildTemplates.INSTANCE.launch(fragmentActivityM95e, CreateGuildTrigger.NUF, true);
                    }
                    fragmentActivityM95e.finish();
                }
            }
        });
        getBinding().f17174b.f1118b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.hubs.WidgetHubEmailFlow.onViewCreated.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetHubEmailFlow.this.getViewModel().reset();
            }
        });
        TextView textView = getBinding().f17175c.f821e;
        C12238m.checkNotNullExpressionValue(textView, "binding.discordHubEmailI…iscordHubEmailHeaderTitle");
        int iOrdinal = getArgs().getEntryPoint().ordinal();
        if (iOrdinal == 0) {
            string = getString(C5419R.string.hub_email_connection_nux_header);
        } else if (iOrdinal != 1) {
            string = getString(C5419R.string.hub_waitlist_modal_join_header);
        } else {
            Context context = view.getContext();
            C12238m.checkNotNullExpressionValue(context, "view.context");
            string = C1107b.m213e(this, C5419R.string.hub_email_connection_invite_header, new Object[]{StringResourceUtilsKt.getI18nPluralString(context, C5419R.plurals.hub_email_connection_invite_header_count, getArgs().getGuildMemberCount(), Integer.valueOf(getArgs().getGuildMemberCount())), getArgs().getGuildName()}, (4 & 4) != 0 ? C1107b.a.f1490j : null);
        }
        textView.setText(string);
        int iOrdinal2 = getArgs().getEntryPoint().ordinal();
        if (iOrdinal2 != 0) {
            i = iOrdinal2 != 1 ? C5419R.string.hub_waitlist_modal_join_subheader : C5419R.string.hub_email_connection_content_description;
        } else {
            i = C5419R.string.hub_email_connection_nux_content_description;
        }
        String string2 = getString(i);
        C12238m.checkNotNullExpressionValue(string2, "getString(\n        when …subheader\n        }\n    )");
        CharSequence charSequenceM213e = C1107b.m213e(this, C5419R.string.learn_more_link, new Object[0], new WidgetHubEmailFlow$onViewCreated$learnMore$1(this));
        LinkifiedTextView linkifiedTextView = getBinding().f17175c.f818b;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.discordHubEmailI…HubEmailHeaderDescription");
        linkifiedTextView.setText(new SpannableStringBuilder(string2).append((CharSequence) " ").append(charSequenceM213e));
    }
}
