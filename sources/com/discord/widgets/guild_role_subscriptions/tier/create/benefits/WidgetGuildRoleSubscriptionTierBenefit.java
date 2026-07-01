package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetGuildRoleSubscriptionTierBenefitBinding;
import com.discord.models.domain.emoji.Emoji;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.channels.WidgetChannelPickerBottomSheet;
import com.discord.widgets.channels.WidgetCreateChannel;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.d0.f;
import d0.g;
import d0.g0.t;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefit extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildRoleSubscriptionTierBenefit.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierBenefitBinding;", 0)};
    public static final WidgetGuildRoleSubscriptionTierBenefit$Companion Companion = new WidgetGuildRoleSubscriptionTierBenefit$Companion(null);
    private static final String INTENT_EXTRA_BENEFIT_TYPE = "INTENT_EXTRA_BENEFIT_TYPE";
    private static final String INTENT_EXTRA_EXISTING_BENEFIT = "INTENT_EXTRA_EXISTING_BENEFIT";
    private static final String INTENT_EXTRA_TIER_NAME = "INTENT_EXTRA_TIER_NAME";
    private static final int MAX_EMOJI_SIZE = 64;
    private static final String REQUEST_KEY_CHANNEL_PICKER = "REQUEST_KEY_CHANNEL_PICKER";
    private static final String RESULT_EXTRA_BENEFIT = "RESULT_EXTRA_BENEFIT";
    private static final String RESULT_EXTRA_EXISTING_BENEFIT = "RESULT_EXTRA_EXISTING_BENEFIT";

    /* JADX INFO: renamed from: benefitType$delegate, reason: from kotlin metadata */
    private final Lazy benefitType;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ActivityResultLauncher<Intent> createChannelLauncher;

    /* JADX INFO: renamed from: existingBenefit$delegate, reason: from kotlin metadata */
    private final Lazy existingBenefit;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: tierName$delegate, reason: from kotlin metadata */
    private final Lazy tierName;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetGuildRoleSubscriptionTierBenefit() {
        super(R$layout.widget_guild_role_subscription_tier_benefit);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildRoleSubscriptionTierBenefit$binding$2.INSTANCE, null, 2, null);
        this.guildId = g.lazy(new WidgetGuildRoleSubscriptionTierBenefit$guildId$2(this));
        this.existingBenefit = g.lazy(new WidgetGuildRoleSubscriptionTierBenefit$existingBenefit$2(this));
        this.benefitType = g.lazy(new WidgetGuildRoleSubscriptionTierBenefit$benefitType$2(this));
        this.tierName = g.lazy(new WidgetGuildRoleSubscriptionTierBenefit$tierName$2(this));
        WidgetGuildRoleSubscriptionTierBenefit$viewModel$2 widgetGuildRoleSubscriptionTierBenefit$viewModel$2 = new WidgetGuildRoleSubscriptionTierBenefit$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GuildRoleSubscriptionTierBenefitViewModel.class), new WidgetGuildRoleSubscriptionTierBenefit$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildRoleSubscriptionTierBenefit$viewModel$2));
        this.createChannelLauncher = WidgetCreateChannel.Companion.registerForResult(this, new WidgetGuildRoleSubscriptionTierBenefit$createChannelLauncher$1(this));
    }

    public static final /* synthetic */ void access$cancel(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit) {
        widgetGuildRoleSubscriptionTierBenefit.cancel();
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit, GuildRoleSubscriptionTierBenefitViewModel$ViewState guildRoleSubscriptionTierBenefitViewModel$ViewState) {
        widgetGuildRoleSubscriptionTierBenefit.configureUI(guildRoleSubscriptionTierBenefitViewModel$ViewState);
    }

    public static final /* synthetic */ GuildRoleSubscriptionBenefitType access$getBenefitType$p(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit) {
        return widgetGuildRoleSubscriptionTierBenefit.getBenefitType();
    }

    public static final /* synthetic */ ActivityResultLauncher access$getCreateChannelLauncher$p(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit) {
        return widgetGuildRoleSubscriptionTierBenefit.createChannelLauncher;
    }

    public static final /* synthetic */ Benefit access$getExistingBenefit$p(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit) {
        return widgetGuildRoleSubscriptionTierBenefit.getExistingBenefit();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit) {
        return widgetGuildRoleSubscriptionTierBenefit.getGuildId();
    }

    public static final /* synthetic */ String access$getTierName$p(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit) {
        return widgetGuildRoleSubscriptionTierBenefit.getTierName();
    }

    public static final /* synthetic */ GuildRoleSubscriptionTierBenefitViewModel access$getViewModel$p(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit) {
        return widgetGuildRoleSubscriptionTierBenefit.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit, GuildRoleSubscriptionTierBenefitViewModel$Event guildRoleSubscriptionTierBenefitViewModel$Event) {
        widgetGuildRoleSubscriptionTierBenefit.handleEvent(guildRoleSubscriptionTierBenefitViewModel$Event);
    }

    private final void cancel() {
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        fragmentActivityRequireActivity.setResult(0);
        AppFragment.hideKeyboard$default(this, null, 1, null);
        fragmentActivityRequireActivity.finish();
    }

    private final void configureUI(GuildRoleSubscriptionTierBenefitViewModel$ViewState viewState) {
        String string;
        TextView textView = getBinding().n;
        m.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionTierBenefitSubtitle");
        textView.setText(viewState.getTierName());
        Emoji emoji = viewState.getEmoji();
        String imageUri = emoji != null ? emoji.getImageUri(false, f.coerceAtMost(IconUtils.getMediaProxySize(getResources().getDimensionPixelSize(2131165454)), 64), requireContext()) : null;
        SimpleDraweeView simpleDraweeView = getBinding().h;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildRoleSubscriptionTierBenefitEmoji");
        MGImages.setImage$default(simpleDraweeView, imageUri, 0, 0, true, null, null, 108, null);
        if (emoji == null || (string = emoji.getFirstName()) == null) {
            string = getString(2131890651);
            m.checkNotNullExpressionValue(string, "getString(R.string.guild…nefits_emoji_placeholder)");
        }
        TextView textView2 = getBinding().i;
        m.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierBenefitEmojiName");
        textView2.setText(string);
        TextInputLayout textInputLayout = getBinding().f;
        m.checkNotNullExpressionValue(textInputLayout, "binding.guildRoleSubscri…ionTierBenefitDescription");
        ViewExtensions.setTextIfDifferent(textInputLayout, viewState.getDescription());
        String name = viewState.getName();
        if (!(name == null || t.isBlank(name))) {
            TextView textView3 = getBinding().j;
            m.checkNotNullExpressionValue(textView3, "binding.guildRoleSubscriptionTierBenefitName");
            textView3.setText(viewState.getName());
            TextInputLayout textInputLayout2 = getBinding().d;
            m.checkNotNullExpressionValue(textInputLayout2, "binding.guildRoleSubscri…tangibleBenefitNameLayout");
            ViewExtensions.setTextIfDifferent(textInputLayout2, viewState.getName());
        }
        TextView textView4 = getBinding().j;
        m.checkNotNullExpressionValue(textView4, "binding.guildRoleSubscriptionTierBenefitName");
        Integer leadingNameIconResId = viewState.getLeadingNameIconResId();
        ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView4, leadingNameIconResId != null ? leadingNameIconResId.intValue() : 0, 0, 2131232268, 0, 10, null);
        if (getBenefitType() == GuildRoleSubscriptionBenefitType.CHANNEL) {
            getBinding().j.setOnClickListener(new WidgetGuildRoleSubscriptionTierBenefit$configureUI$1(this, viewState));
        }
        MaterialButton materialButton = getBinding().l;
        m.checkNotNullExpressionValue(materialButton, "binding.guildRoleSubscriptionTierBenefitSave");
        materialButton.setEnabled(viewState.getCanSubmitResult());
    }

    private final void configureUIForChannelBenefit() {
        WidgetChannelPickerBottomSheet.Companion.registerForResult(this, REQUEST_KEY_CHANNEL_PICKER, new WidgetGuildRoleSubscriptionTierBenefit$configureUIForChannelBenefit$1(this), new WidgetGuildRoleSubscriptionTierBenefit$configureUIForChannelBenefit$2(this));
        TextView textView = getBinding().f2438b;
        m.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionBenefitChannelLabel");
        textView.setVisibility(0);
        TextView textView2 = getBinding().j;
        m.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierBenefitName");
        textView2.setVisibility(0);
        TextView textView3 = getBinding().p;
        m.checkNotNullExpressionValue(textView3, "binding.guildRoleSubscri…TierChannelBenefitWarning");
        textView3.setVisibility(0);
        TextView textView4 = getBinding().o;
        m.checkNotNullExpressionValue(textView4, "binding.guildRoleSubscriptionTierBenefitTitle");
        textView4.setText(getString(2131890674));
        TextInputEditText textInputEditText = getBinding().g;
        m.checkNotNullExpressionValue(textInputEditText, "binding.guildRoleSubscri…enefitDescriptionEditText");
        textInputEditText.setHint(getString(2131890430));
    }

    private final void configureUIForIntangibleBenefit() {
        TextView textView = getBinding().f2438b;
        m.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionBenefitChannelLabel");
        textView.setVisibility(8);
        TextView textView2 = getBinding().j;
        m.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierBenefitName");
        textView2.setVisibility(8);
        TextView textView3 = getBinding().p;
        m.checkNotNullExpressionValue(textView3, "binding.guildRoleSubscri…TierChannelBenefitWarning");
        textView3.setVisibility(8);
        TextInputLayout textInputLayout = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout, "binding.guildRoleSubscri…tangibleBenefitNameLayout");
        textInputLayout.setVisibility(0);
        TextView textView4 = getBinding().c;
        m.checkNotNullExpressionValue(textView4, "binding.guildRoleSubscri…ntangibleBenefitNameLabel");
        textView4.setVisibility(0);
        TextInputLayout textInputLayout2 = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.guildRoleSubscri…tangibleBenefitNameLayout");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, this, new WidgetGuildRoleSubscriptionTierBenefit$configureUIForIntangibleBenefit$1(this));
        TextView textView5 = getBinding().o;
        m.checkNotNullExpressionValue(textView5, "binding.guildRoleSubscriptionTierBenefitTitle");
        textView5.setText(getString(2131890645));
        TextInputEditText textInputEditText = getBinding().g;
        m.checkNotNullExpressionValue(textInputEditText, "binding.guildRoleSubscri…enefitDescriptionEditText");
        textInputEditText.setHint(getString(2131890514));
    }

    private final GuildRoleSubscriptionBenefitType getBenefitType() {
        return (GuildRoleSubscriptionBenefitType) this.benefitType.getValue();
    }

    private final WidgetGuildRoleSubscriptionTierBenefitBinding getBinding() {
        return (WidgetGuildRoleSubscriptionTierBenefitBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final Benefit getExistingBenefit() {
        return (Benefit) this.existingBenefit.getValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final String getTierName() {
        return (String) this.tierName.getValue();
    }

    private final GuildRoleSubscriptionTierBenefitViewModel getViewModel() {
        return (GuildRoleSubscriptionTierBenefitViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(GuildRoleSubscriptionTierBenefitViewModel$Event event) {
        if (event instanceof GuildRoleSubscriptionTierBenefitViewModel$Event$SendResult) {
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intent intent = new Intent();
            intent.putExtra(RESULT_EXTRA_EXISTING_BENEFIT, getExistingBenefit());
            intent.putExtra(RESULT_EXTRA_BENEFIT, ((GuildRoleSubscriptionTierBenefitViewModel$Event$SendResult) event).getBenefit());
            fragmentActivityRequireActivity.setResult(-1, intent);
            AppFragment.hideKeyboard$default(this, null, 1, null);
            fragmentActivityRequireActivity.finish();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        int iOrdinal = getBenefitType().ordinal();
        if (iOrdinal == 0) {
            AppLog appLog = AppLog.g;
            StringBuilder sbU = a.U("Unknown benefit type: ");
            sbU.append(getBenefitType());
            Logger.e$default(appLog, sbU.toString(), null, null, 6, null);
            b.a.d.m.i(this, 2131888366, 0, 4);
            cancel();
        } else if (iOrdinal == 1) {
            configureUIForChannelBenefit();
        } else if (iOrdinal == 2) {
            configureUIForIntangibleBenefit();
        }
        getBinding().l.setOnClickListener(new WidgetGuildRoleSubscriptionTierBenefit$onViewBound$1(this));
        getBinding().e.setOnClickListener(new WidgetGuildRoleSubscriptionTierBenefit$onViewBound$2(this));
        getBinding().m.setOnClickListener(new WidgetGuildRoleSubscriptionTierBenefit$onViewBound$3(this));
        TextInputLayout textInputLayout = getBinding().f;
        m.checkNotNullExpressionValue(textInputLayout, "binding.guildRoleSubscri…ionTierBenefitDescription");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new WidgetGuildRoleSubscriptionTierBenefit$onViewBound$4(this));
        getBinding().k.setOnClickListener(new WidgetGuildRoleSubscriptionTierBenefit$onViewBound$5(this));
        MaterialButton materialButton = getBinding().k;
        m.checkNotNullExpressionValue(materialButton, "binding.guildRoleSubscriptionTierBenefitRemove");
        materialButton.setVisibility(getExistingBenefit() != null ? 0 : 8);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildRoleSubscriptionTierBenefit.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildRoleSubscriptionTierBenefit$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetGuildRoleSubscriptionTierBenefit.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildRoleSubscriptionTierBenefit$onViewBoundOrOnResume$2(this), 62, (Object) null);
    }
}
