package com.discord.widgets.servers.member_verification;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import com.discord.R;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetMemberVerificationBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.models.guild.Guild;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.LoadingButton;
import com.discord.views.MemberVerificationAvatarView;
import com.discord.widgets.servers.member_verification.MemberVerificationPendingViewModel;
import com.discord.widgets.servers.member_verification.WidgetMemberVerificationViewModel;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import com.discord.widgets.user.email.WidgetUserEmailVerify;
import com.discord.widgets.user.phone.WidgetUserPhoneManage;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetMemberVerification.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMemberVerification extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetMemberVerification.class, "binding", "getBinding()Lcom/discord/databinding/WidgetMemberVerificationBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String INTENT_EXTRA_INVITE_GUILD = "INTENT_EXTRA_INVITE_GUILD";
    private static final String INTENT_EXTRA_LOCATION = "INTENT_EXTRA_LOCATION";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private MemberVerificationRulesAdapter rulesAdapter;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetMemberVerification.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void create$default(Companion companion, Context context, long j, String str, ModelInvite modelInvite, int i, Object obj) {
            if ((i & 8) != 0) {
                modelInvite = null;
            }
            companion.create(context, j, str, modelInvite);
        }

        public final void create(Context context, long guildId, String location, ModelInvite invite) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            Intent intent = new Intent();
            intent.putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            intent.putExtra(WidgetMemberVerification.INTENT_EXTRA_LOCATION, location);
            if ((invite != null ? invite.guild : null) != null) {
                intent.putExtra(WidgetMemberVerification.INTENT_EXTRA_INVITE_GUILD, new Gson().m(invite.guild));
            }
            AppScreen2.d(context, WidgetMemberVerification.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            ApplicationStatus.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[ApplicationStatus.PENDING.ordinal()] = 1;
            iArr[ApplicationStatus.APPROVED.ordinal()] = 2;
            WidgetMemberVerificationViewModel.VerificationType.values();
            int[] iArr2 = new int[2];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[WidgetMemberVerificationViewModel.VerificationType.EMAIL.ordinal()] = 1;
            iArr2[WidgetMemberVerificationViewModel.VerificationType.PHONE.ordinal()] = 2;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.WidgetMemberVerification$configureVerificationBanner$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetMemberVerification.kt */
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
            WidgetUserEmailVerify.INSTANCE.launch(WidgetMemberVerification.this.requireContext(), WidgetUserAccountVerifyBase.Mode.UNFORCED);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.WidgetMemberVerification$configureVerificationBanner$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetMemberVerification.kt */
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
            WidgetUserPhoneManage.INSTANCE.launch(WidgetMemberVerification.this.requireContext(), WidgetUserAccountVerifyBase.Mode.UNFORCED, WidgetUserPhoneManage.Companion.Source.GUILD_PHONE_REQUIRED);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.WidgetMemberVerification$onViewBound$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetMemberVerification.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            WidgetMemberVerification.this.getViewModel().updateTermsApproval(z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.WidgetMemberVerification$onViewBound$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetMemberVerification.kt */
    public static final class AnonymousClass2 extends Lambda implements Function2<Integer, Object, Unit> {
        public AnonymousClass2() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Object obj) {
            invoke(num.intValue(), obj);
            return Unit.a;
        }

        public final void invoke(int i, Object obj) {
            Intrinsics3.checkNotNullParameter(obj, "value");
            WidgetMemberVerification.this.getViewModel().updateFormValidation(i, obj);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.WidgetMemberVerification$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetMemberVerification.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<WidgetMemberVerificationViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetMemberVerification widgetMemberVerification) {
            super(1, widgetMemberVerification, WidgetMemberVerification.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/member_verification/WidgetMemberVerificationViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetMemberVerificationViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetMemberVerificationViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            ((WidgetMemberVerification) this.receiver).configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.WidgetMemberVerification$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetMemberVerification.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<WidgetMemberVerificationViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetMemberVerificationViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetMemberVerificationViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            if (!(event instanceof WidgetMemberVerificationViewModel.Event.Success)) {
                if (event instanceof WidgetMemberVerificationViewModel.Event.Error) {
                    AppToast.i(WidgetMemberVerification.this, R.string.guild_settings_public_update_failed, 0, 4);
                    return;
                }
                return;
            }
            WidgetMemberVerification.this.requireActivity().finish();
            WidgetMemberVerificationViewModel.Event.Success success = (WidgetMemberVerificationViewModel.Event.Success) event;
            int iOrdinal = success.getApplicationStatus().ordinal();
            if (iOrdinal == 1) {
                if (success.getGuildId() == null || success.getGuildName() == null) {
                    return;
                }
                MemberVerificationPendingDialog.INSTANCE.enqueue(success.getGuildId().longValue(), MemberVerificationPendingViewModel.DialogState.PENDING);
                return;
            }
            if (iOrdinal == 3 && success.getGuildId() != null && success.getGuildName() != null && success.getLastSeen() == null) {
                MemberVerificationSuccessDialog.INSTANCE.enqueue(success.getGuildId().longValue());
            }
        }
    }

    public WidgetMemberVerification() {
        super(R.layout.widget_member_verification);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetMemberVerification2.INSTANCE, null, 2, null);
        WidgetMemberVerification3 widgetMemberVerification3 = new WidgetMemberVerification3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetMemberVerificationViewModel.class), new WidgetMemberVerification$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetMemberVerification3));
    }

    private final void configureLoadedUI(WidgetMemberVerificationViewModel.ViewState.Loaded viewState) {
        NestedScrollView nestedScrollView = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(nestedScrollView, "binding.memberVerificationScrollview");
        nestedScrollView.setVisibility(0);
        getBinding().e.setIsLoading(viewState.getSubmitting());
        DimmerView.setDimmed$default(getBinding().f2488b, false, false, 2, null);
        LoadingButton loadingButton = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.memberVerificationRulesConfirm");
        loadingButton.setEnabled(!viewState.getDisabled());
        RecyclerView recyclerView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.memberVerificationRulesRecycler");
        recyclerView.setVisibility(viewState.isRulesListVisible() ? 0 : 8);
        MemberVerificationAvatarView memberVerificationAvatarView = getBinding().d;
        Guild guild = viewState.getGuild();
        Objects.requireNonNull(memberVerificationAvatarView);
        boolean z2 = guild != null && guild.hasIcon();
        TextView textView = memberVerificationAvatarView.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.memberVerificationText");
        textView.setVisibility(z2 ^ true ? 0 : 8);
        if (z2) {
            SimpleDraweeView simpleDraweeView = memberVerificationAvatarView.binding.f214b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.memberVerificationAvatar");
            IconUtils.setIcon$default(simpleDraweeView, IconUtils.getForGuild$default(guild, null, false, null, 14, null), 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
            TextView textView2 = memberVerificationAvatarView.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.memberVerificationText");
            textView2.setText("");
        } else {
            TextView textView3 = memberVerificationAvatarView.binding.c;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.memberVerificationText");
            textView3.setText(guild != null ? guild.getShortName() : null);
        }
        getBinding().e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.member_verification.WidgetMemberVerification.configureLoadedUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetMemberVerification.this.getViewModel().applyToJoinGuild();
            }
        });
        MemberVerificationRulesAdapter memberVerificationRulesAdapter = this.rulesAdapter;
        if (memberVerificationRulesAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("rulesAdapter");
        }
        memberVerificationRulesAdapter.setData(viewState.getFormItems());
        configureVerificationBanner(viewState);
    }

    private final void configureUI(WidgetMemberVerificationViewModel.ViewState viewState) {
        if (viewState instanceof WidgetMemberVerificationViewModel.ViewState.Invalid) {
            AppToast.i(this, R.string.default_failure_to_perform_action_message, 0, 4);
            requireActivity().finish();
        } else if (viewState instanceof WidgetMemberVerificationViewModel.ViewState.Loaded) {
            configureLoadedUI((WidgetMemberVerificationViewModel.ViewState.Loaded) viewState);
        } else {
            if (!(viewState instanceof WidgetMemberVerificationViewModel.ViewState.Loading)) {
                throw new NoWhenBranchMatchedException();
            }
            NestedScrollView nestedScrollView = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(nestedScrollView, "binding.memberVerificationScrollview");
            nestedScrollView.setVisibility(8);
            DimmerView.setDimmed$default(getBinding().f2488b, true, false, 2, null);
        }
    }

    private final void configureVerificationBanner(WidgetMemberVerificationViewModel.ViewState.Loaded viewState) {
        MemberVerificationView memberVerificationView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(memberVerificationView, "binding.memberVerificationContainer");
        memberVerificationView.setVisibility(viewState.getVerificationType() != null ? 0 : 8);
        WidgetMemberVerificationViewModel.VerificationType verificationType = viewState.getVerificationType();
        if (verificationType == null) {
            return;
        }
        int iOrdinal = verificationType.ordinal();
        if (iOrdinal == 0) {
            getBinding().c.configure(R.drawable.ic_phone_verification_24dp, R.string.member_verification_form_item_phone_verification_label, !viewState.getNeedsAdditionalVerification(), new AnonymousClass2());
        } else {
            if (iOrdinal != 1) {
                return;
            }
            getBinding().c.configure(R.drawable.ic_email_verification_24dp, R.string.member_verification_form_item_email_verification_label, !viewState.getNeedsAdditionalVerification(), new AnonymousClass1());
        }
    }

    public static final void create(Context context, long j, String str, ModelInvite modelInvite) {
        INSTANCE.create(context, j, str, modelInvite);
    }

    private final WidgetMemberVerificationBinding getBinding() {
        return (WidgetMemberVerificationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetMemberVerificationViewModel getViewModel() {
        return (WidgetMemberVerificationViewModel) this.viewModel.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Guild parseInviteGuild() {
        String stringExtra = getMostRecentIntent().getStringExtra(INTENT_EXTRA_INVITE_GUILD);
        if (stringExtra == 0) {
            return (Guild) stringExtra;
        }
        return (Guild) f.E1(Guild.class).cast(new Gson().g(stringExtra, Guild.class));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RecyclerView recyclerView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.memberVerificationRulesRecycler");
        this.rulesAdapter = new MemberVerificationRulesAdapter(recyclerView, this);
        getBinding().f.setHasFixedSize(false);
        RecyclerView recyclerView2 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.memberVerificationRulesRecycler");
        recyclerView2.setNestedScrollingEnabled(false);
        MemberVerificationRulesAdapter memberVerificationRulesAdapter = this.rulesAdapter;
        if (memberVerificationRulesAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("rulesAdapter");
        }
        memberVerificationRulesAdapter.setOnUpdateRulesApproval(new AnonymousClass1());
        MemberVerificationRulesAdapter memberVerificationRulesAdapter2 = this.rulesAdapter;
        if (memberVerificationRulesAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("rulesAdapter");
        }
        memberVerificationRulesAdapter2.setOnUserInputDataEntered(new AnonymousClass2());
        RecyclerView recyclerView3 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(recyclerView3, "binding.memberVerificationRulesRecycler");
        MemberVerificationRulesAdapter memberVerificationRulesAdapter3 = this.rulesAdapter;
        if (memberVerificationRulesAdapter3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("rulesAdapter");
        }
        recyclerView3.setAdapter(memberVerificationRulesAdapter3);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetMemberVerification.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetMemberVerification.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }
}
