package com.discord.widgets.servers.member_verification;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import b.i.a.f.e.o.f;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetMemberVerificationBinding;
import com.discord.models.domain.ModelInvite;
import com.discord.models.guild.Guild;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.LoadingButton;
import com.discord.views.MemberVerificationAvatarView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetMemberVerification.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetMemberVerification extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetMemberVerification.class, "binding", "getBinding()Lcom/discord/databinding/WidgetMemberVerificationBinding;", 0)};
    public static final WidgetMemberVerification$Companion Companion = new WidgetMemberVerification$Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String INTENT_EXTRA_INVITE_GUILD = "INTENT_EXTRA_INVITE_GUILD";
    private static final String INTENT_EXTRA_LOCATION = "INTENT_EXTRA_LOCATION";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private MemberVerificationRulesAdapter rulesAdapter;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetMemberVerification() {
        super(R$layout.widget_member_verification);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetMemberVerification$binding$2.INSTANCE, null, 2, null);
        WidgetMemberVerification$viewModel$2 widgetMemberVerification$viewModel$2 = new WidgetMemberVerification$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetMemberVerificationViewModel.class), new WidgetMemberVerification$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetMemberVerification$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetMemberVerification widgetMemberVerification, WidgetMemberVerificationViewModel$ViewState widgetMemberVerificationViewModel$ViewState) {
        widgetMemberVerification.configureUI(widgetMemberVerificationViewModel$ViewState);
    }

    public static final /* synthetic */ WidgetMemberVerificationViewModel access$getViewModel$p(WidgetMemberVerification widgetMemberVerification) {
        return widgetMemberVerification.getViewModel();
    }

    public static final /* synthetic */ Guild access$parseInviteGuild(WidgetMemberVerification widgetMemberVerification) {
        return widgetMemberVerification.parseInviteGuild();
    }

    private final void configureLoadedUI(WidgetMemberVerificationViewModel$ViewState$Loaded viewState) {
        NestedScrollView nestedScrollView = getBinding().g;
        m.checkNotNullExpressionValue(nestedScrollView, "binding.memberVerificationScrollview");
        nestedScrollView.setVisibility(0);
        getBinding().e.setIsLoading(viewState.getSubmitting());
        DimmerView.setDimmed$default(getBinding().f2488b, false, false, 2, null);
        LoadingButton loadingButton = getBinding().e;
        m.checkNotNullExpressionValue(loadingButton, "binding.memberVerificationRulesConfirm");
        loadingButton.setEnabled(!viewState.getDisabled());
        RecyclerView recyclerView = getBinding().f;
        m.checkNotNullExpressionValue(recyclerView, "binding.memberVerificationRulesRecycler");
        recyclerView.setVisibility(viewState.isRulesListVisible() ? 0 : 8);
        MemberVerificationAvatarView memberVerificationAvatarView = getBinding().d;
        Guild guild = viewState.getGuild();
        Objects.requireNonNull(memberVerificationAvatarView);
        boolean z2 = guild != null && guild.hasIcon();
        TextView textView = memberVerificationAvatarView.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.memberVerificationText");
        textView.setVisibility(z2 ^ true ? 0 : 8);
        if (z2) {
            SimpleDraweeView simpleDraweeView = memberVerificationAvatarView.binding.f214b;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.memberVerificationAvatar");
            IconUtils.setIcon$default(simpleDraweeView, IconUtils.getForGuild$default(guild, null, false, null, 14, null), 0, (Function1) null, (MGImages$ChangeDetector) null, 28, (Object) null);
            TextView textView2 = memberVerificationAvatarView.binding.c;
            m.checkNotNullExpressionValue(textView2, "binding.memberVerificationText");
            textView2.setText("");
        } else {
            TextView textView3 = memberVerificationAvatarView.binding.c;
            m.checkNotNullExpressionValue(textView3, "binding.memberVerificationText");
            textView3.setText(guild != null ? guild.getShortName() : null);
        }
        getBinding().e.setOnClickListener(new WidgetMemberVerification$configureLoadedUI$1(this));
        MemberVerificationRulesAdapter memberVerificationRulesAdapter = this.rulesAdapter;
        if (memberVerificationRulesAdapter == null) {
            m.throwUninitializedPropertyAccessException("rulesAdapter");
        }
        memberVerificationRulesAdapter.setData(viewState.getFormItems());
        configureVerificationBanner(viewState);
    }

    private final void configureUI(WidgetMemberVerificationViewModel$ViewState viewState) {
        if (viewState instanceof WidgetMemberVerificationViewModel$ViewState$Invalid) {
            b.a.d.m.i(this, 2131888366, 0, 4);
            requireActivity().finish();
        } else if (viewState instanceof WidgetMemberVerificationViewModel$ViewState$Loaded) {
            configureLoadedUI((WidgetMemberVerificationViewModel$ViewState$Loaded) viewState);
        } else {
            if (!(viewState instanceof WidgetMemberVerificationViewModel$ViewState$Loading)) {
                throw new NoWhenBranchMatchedException();
            }
            NestedScrollView nestedScrollView = getBinding().g;
            m.checkNotNullExpressionValue(nestedScrollView, "binding.memberVerificationScrollview");
            nestedScrollView.setVisibility(8);
            DimmerView.setDimmed$default(getBinding().f2488b, true, false, 2, null);
        }
    }

    private final void configureVerificationBanner(WidgetMemberVerificationViewModel$ViewState$Loaded viewState) {
        MemberVerificationView memberVerificationView = getBinding().c;
        m.checkNotNullExpressionValue(memberVerificationView, "binding.memberVerificationContainer");
        memberVerificationView.setVisibility(viewState.getVerificationType() != null ? 0 : 8);
        WidgetMemberVerificationViewModel$VerificationType verificationType = viewState.getVerificationType();
        if (verificationType == null) {
            return;
        }
        int iOrdinal = verificationType.ordinal();
        if (iOrdinal == 0) {
            getBinding().c.configure(2131232015, 2131892847, !viewState.getNeedsAdditionalVerification(), new WidgetMemberVerification$configureVerificationBanner$2(this));
        } else {
            if (iOrdinal != 1) {
                return;
            }
            getBinding().c.configure(2131231731, 2131892842, !viewState.getNeedsAdditionalVerification(), new WidgetMemberVerification$configureVerificationBanner$1(this));
        }
    }

    public static final void create(Context context, long j, String str, ModelInvite modelInvite) {
        Companion.create(context, j, str, modelInvite);
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
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RecyclerView recyclerView = getBinding().f;
        m.checkNotNullExpressionValue(recyclerView, "binding.memberVerificationRulesRecycler");
        this.rulesAdapter = new MemberVerificationRulesAdapter(recyclerView, this);
        getBinding().f.setHasFixedSize(false);
        RecyclerView recyclerView2 = getBinding().f;
        m.checkNotNullExpressionValue(recyclerView2, "binding.memberVerificationRulesRecycler");
        recyclerView2.setNestedScrollingEnabled(false);
        MemberVerificationRulesAdapter memberVerificationRulesAdapter = this.rulesAdapter;
        if (memberVerificationRulesAdapter == null) {
            m.throwUninitializedPropertyAccessException("rulesAdapter");
        }
        memberVerificationRulesAdapter.setOnUpdateRulesApproval(new WidgetMemberVerification$onViewBound$1(this));
        MemberVerificationRulesAdapter memberVerificationRulesAdapter2 = this.rulesAdapter;
        if (memberVerificationRulesAdapter2 == null) {
            m.throwUninitializedPropertyAccessException("rulesAdapter");
        }
        memberVerificationRulesAdapter2.setOnUserInputDataEntered(new WidgetMemberVerification$onViewBound$2(this));
        RecyclerView recyclerView3 = getBinding().f;
        m.checkNotNullExpressionValue(recyclerView3, "binding.memberVerificationRulesRecycler");
        MemberVerificationRulesAdapter memberVerificationRulesAdapter3 = this.rulesAdapter;
        if (memberVerificationRulesAdapter3 == null) {
            m.throwUninitializedPropertyAccessException("rulesAdapter");
        }
        recyclerView3.setAdapter(memberVerificationRulesAdapter3);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetMemberVerification.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetMemberVerification$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetMemberVerification.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetMemberVerification$onViewBoundOrOnResume$2(this), 62, (Object) null);
    }
}
