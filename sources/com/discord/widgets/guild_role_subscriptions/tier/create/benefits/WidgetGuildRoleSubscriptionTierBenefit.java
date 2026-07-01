package com.discord.widgets.guild_role_subscriptions.tier.create.benefits;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetGuildRoleSubscriptionTierBenefitBinding;
import com.discord.models.domain.emoji.Emoji;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.WidgetChannelPickerBottomSheet;
import com.discord.widgets.channels.WidgetCreateChannel;
import com.discord.widgets.chat.input.emoji.EmojiPickerContextType;
import com.discord.widgets.chat.input.emoji.EmojiPickerListener;
import com.discord.widgets.chat.input.emoji.EmojiPickerNavigator;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionTierBenefitViewModel;
import com.discord.widgets.guild_role_subscriptions.tier.model.Benefit;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.LazyJVM;
import d0.d0._Ranges;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefit extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildRoleSubscriptionTierBenefit.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierBenefitBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
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

    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, ActivityResultLauncher<Intent> launcher, long guildId, GuildRoleSubscriptionBenefitType benefitType, String tierName, Benefit benefit) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(launcher, "launcher");
            Intrinsics3.checkNotNullParameter(benefitType, "benefitType");
            AppScreen2 appScreen2 = AppScreen2.g;
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            intent.putExtra(WidgetGuildRoleSubscriptionTierBenefit.INTENT_EXTRA_EXISTING_BENEFIT, benefit);
            intent.putExtra(WidgetGuildRoleSubscriptionTierBenefit.INTENT_EXTRA_BENEFIT_TYPE, benefitType);
            intent.putExtra(WidgetGuildRoleSubscriptionTierBenefit.INTENT_EXTRA_TIER_NAME, tierName);
            appScreen2.f(context, launcher, WidgetGuildRoleSubscriptionTierBenefit.class, intent);
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, final Function2<? super Benefit, ? super Benefit, Unit> onBenefitUpdate) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(onBenefitUpdate, "onBenefitUpdate");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$Companion$registerForResult$1
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(ActivityResult activityResult) {
                    Intrinsics3.checkNotNullExpressionValue(activityResult, "activityResult");
                    if (activityResult.getResultCode() == -1) {
                        Intent data = activityResult.getData();
                        Benefit benefit = data != null ? (Benefit) data.getParcelableExtra("RESULT_EXTRA_BENEFIT") : null;
                        Intent data2 = activityResult.getData();
                        Benefit benefit2 = data2 != null ? (Benefit) data2.getParcelableExtra("RESULT_EXTRA_EXISTING_BENEFIT") : null;
                        if (benefit == null && benefit2 == null) {
                            return;
                        }
                        onBenefitUpdate.invoke(benefit2, benefit);
                    }
                }
            });
            Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…  }\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            GuildRoleSubscriptionBenefitType.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[GuildRoleSubscriptionBenefitType.CHANNEL.ordinal()] = 1;
            iArr[GuildRoleSubscriptionBenefitType.INTANGIBLE.ordinal()] = 2;
            iArr[GuildRoleSubscriptionBenefitType.UNKNOWN.ordinal()] = 3;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$configureUIForChannelBenefit$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    public static final class AnonymousClass1 extends Lambda implements Function3<Long, String, Integer, Unit> {
        public AnonymousClass1() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str, Integer num) {
            invoke(l.longValue(), str, num.intValue());
            return Unit.a;
        }

        public final void invoke(long j, String str, int i) {
            Intrinsics3.checkNotNullParameter(str, "channelName");
            WidgetGuildRoleSubscriptionTierBenefit.this.getViewModel().updateChannel(j, str, Integer.valueOf(i));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$configureUIForChannelBenefit$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
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
            WidgetCreateChannel.INSTANCE.launch(WidgetGuildRoleSubscriptionTierBenefit.this.requireContext(), WidgetGuildRoleSubscriptionTierBenefit.this.createChannelLauncher, WidgetGuildRoleSubscriptionTierBenefit.this.getGuildId(), (24 & 8) != 0 ? 0 : 0, (24 & 16) != 0 ? null : null, (24 & 32) != 0 ? false : true, (24 & 64) != 0 ? false : true, (24 & 128) != 0 ? false : true, (24 & 256) != 0 ? false : true);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$configureUIForIntangibleBenefit$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            WidgetGuildRoleSubscriptionTierBenefit.this.getViewModel().updateName(editable.toString());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$onViewBound$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<Editable, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            WidgetGuildRoleSubscriptionTierBenefit.this.getViewModel().updateDescription(editable.toString());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<GuildRoleSubscriptionTierBenefitViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierBenefitViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierBenefitViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetGuildRoleSubscriptionTierBenefit.this.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<GuildRoleSubscriptionTierBenefitViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierBenefitViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierBenefitViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "it");
            WidgetGuildRoleSubscriptionTierBenefit.this.handleEvent(event);
        }
    }

    public WidgetGuildRoleSubscriptionTierBenefit() {
        super(R.layout.widget_guild_role_subscription_tier_benefit);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildRoleSubscriptionTierBenefit4.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetGuildRoleSubscriptionTierBenefit7(this));
        this.existingBenefit = LazyJVM.lazy(new WidgetGuildRoleSubscriptionTierBenefit6(this));
        this.benefitType = LazyJVM.lazy(new WidgetGuildRoleSubscriptionTierBenefit3(this));
        this.tierName = LazyJVM.lazy(new WidgetGuildRoleSubscriptionTierBenefit8(this));
        WidgetGuildRoleSubscriptionTierBenefit9 widgetGuildRoleSubscriptionTierBenefit9 = new WidgetGuildRoleSubscriptionTierBenefit9(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionTierBenefitViewModel.class), new WidgetGuildRoleSubscriptionTierBenefit$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildRoleSubscriptionTierBenefit9));
        this.createChannelLauncher = WidgetCreateChannel.INSTANCE.registerForResult(this, new WidgetGuildRoleSubscriptionTierBenefit5(this));
    }

    private final void cancel() {
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        fragmentActivityRequireActivity.setResult(0);
        AppFragment.hideKeyboard$default(this, null, 1, null);
        fragmentActivityRequireActivity.finish();
    }

    private final void configureUI(final GuildRoleSubscriptionTierBenefitViewModel.ViewState viewState) {
        String string;
        TextView textView = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionTierBenefitSubtitle");
        textView.setText(viewState.getTierName());
        Emoji emoji = viewState.getEmoji();
        String imageUri = emoji != null ? emoji.getImageUri(false, _Ranges.coerceAtMost(IconUtils.getMediaProxySize(getResources().getDimensionPixelSize(R.dimen.guild_role_subscription_create_benefit_emoji_size)), 64), requireContext()) : null;
        SimpleDraweeView simpleDraweeView = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildRoleSubscriptionTierBenefitEmoji");
        MGImages.setImage$default(simpleDraweeView, imageUri, 0, 0, true, null, null, 108, null);
        if (emoji == null || (string = emoji.getFirstName()) == null) {
            string = getString(R.string.guild_role_subscription_tier_benefits_emoji_placeholder);
            Intrinsics3.checkNotNullExpressionValue(string, "getString(R.string.guild…nefits_emoji_placeholder)");
        }
        TextView textView2 = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierBenefitEmojiName");
        textView2.setText(string);
        TextInputLayout textInputLayout = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.guildRoleSubscri…ionTierBenefitDescription");
        ViewExtensions.setTextIfDifferent(textInputLayout, viewState.getDescription());
        String name = viewState.getName();
        if (!(name == null || StringsJVM.isBlank(name))) {
            TextView textView3 = getBinding().j;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildRoleSubscriptionTierBenefitName");
            textView3.setText(viewState.getName());
            TextInputLayout textInputLayout2 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.guildRoleSubscri…tangibleBenefitNameLayout");
            ViewExtensions.setTextIfDifferent(textInputLayout2, viewState.getName());
        }
        TextView textView4 = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.guildRoleSubscriptionTierBenefitName");
        Integer leadingNameIconResId = viewState.getLeadingNameIconResId();
        ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView4, leadingNameIconResId != null ? leadingNameIconResId.intValue() : 0, 0, R.drawable.icon_carrot, 0, 10, null);
        if (getBenefitType() == GuildRoleSubscriptionBenefitType.CHANNEL) {
            getBinding().j.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit.configureUI.1

                /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$configureUI$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
                public static final class C02911 extends Lambda implements Function0<Unit> {
                    public C02911() {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        AppFragment.hideKeyboard$default(WidgetGuildRoleSubscriptionTierBenefit.this, null, 1, null);
                    }
                }

                /* JADX WARN: Type inference fix 'apply assigned field type' failed
                java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
                	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
                	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
                	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
                	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
                 */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetChannelPickerBottomSheet.Companion companion = WidgetChannelPickerBottomSheet.INSTANCE;
                    WidgetGuildRoleSubscriptionTierBenefit widgetGuildRoleSubscriptionTierBenefit = WidgetGuildRoleSubscriptionTierBenefit.this;
                    companion.launch(widgetGuildRoleSubscriptionTierBenefit, WidgetGuildRoleSubscriptionTierBenefit.REQUEST_KEY_CHANNEL_PICKER, widgetGuildRoleSubscriptionTierBenefit.getGuildId(), viewState.getChannelId(), new C02911(), true);
                }
            });
        }
        MaterialButton materialButton = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.guildRoleSubscriptionTierBenefitSave");
        materialButton.setEnabled(viewState.getCanSubmitResult());
    }

    private final void configureUIForChannelBenefit() {
        WidgetChannelPickerBottomSheet.INSTANCE.registerForResult(this, REQUEST_KEY_CHANNEL_PICKER, new AnonymousClass1(), new AnonymousClass2());
        TextView textView = getBinding().f2438b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionBenefitChannelLabel");
        textView.setVisibility(0);
        TextView textView2 = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierBenefitName");
        textView2.setVisibility(0);
        TextView textView3 = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildRoleSubscri…TierChannelBenefitWarning");
        textView3.setVisibility(0);
        TextView textView4 = getBinding().o;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.guildRoleSubscriptionTierBenefitTitle");
        textView4.setText(getString(R.string.guild_role_subscription_tier_exclusive_channel_title));
        TextInputEditText textInputEditText = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.guildRoleSubscri…enefitDescriptionEditText");
        textInputEditText.setHint(getString(R.string.guild_role_subscription_channel_benefit_description_placeholder));
    }

    private final void configureUIForIntangibleBenefit() {
        TextView textView = getBinding().f2438b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionBenefitChannelLabel");
        textView.setVisibility(8);
        TextView textView2 = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierBenefitName");
        textView2.setVisibility(8);
        TextView textView3 = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildRoleSubscri…TierChannelBenefitWarning");
        textView3.setVisibility(8);
        TextInputLayout textInputLayout = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.guildRoleSubscri…tangibleBenefitNameLayout");
        textInputLayout.setVisibility(0);
        TextView textView4 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.guildRoleSubscri…ntangibleBenefitNameLabel");
        textView4.setVisibility(0);
        TextInputLayout textInputLayout2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.guildRoleSubscri…tangibleBenefitNameLayout");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, this, new AnonymousClass1());
        TextView textView5 = getBinding().o;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.guildRoleSubscriptionTierBenefitTitle");
        textView5.setText(getString(R.string.guild_role_subscription_tier_additional_benefit_title));
        TextInputEditText textInputEditText = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.guildRoleSubscri…enefitDescriptionEditText");
        textInputEditText.setHint(getString(R.string.guild_role_subscription_intangible_benefit_description_placeholder));
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

    private final void handleEvent(GuildRoleSubscriptionTierBenefitViewModel.Event event) {
        if (event instanceof GuildRoleSubscriptionTierBenefitViewModel.Event.SendResult) {
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intent intent = new Intent();
            intent.putExtra(RESULT_EXTRA_EXISTING_BENEFIT, getExistingBenefit());
            intent.putExtra(RESULT_EXTRA_BENEFIT, ((GuildRoleSubscriptionTierBenefitViewModel.Event.SendResult) event).getBenefit());
            fragmentActivityRequireActivity.setResult(-1, intent);
            AppFragment.hideKeyboard$default(this, null, 1, null);
            fragmentActivityRequireActivity.finish();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        int iOrdinal = getBenefitType().ordinal();
        if (iOrdinal == 0) {
            AppLog appLog = AppLog.g;
            StringBuilder sbU = outline.U("Unknown benefit type: ");
            sbU.append(getBenefitType());
            Logger.e$default(appLog, sbU.toString(), null, null, 6, null);
            AppToast.i(this, R.string.default_failure_to_perform_action_message, 0, 4);
            cancel();
        } else if (iOrdinal == 1) {
            configureUIForChannelBenefit();
        } else if (iOrdinal == 2) {
            configureUIForIntangibleBenefit();
        }
        getBinding().l.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetGuildRoleSubscriptionTierBenefit.this.getViewModel().submitResult();
            }
        });
        getBinding().e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetGuildRoleSubscriptionTierBenefit.this.cancel();
            }
        });
        getBinding().m.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit.onViewBound.3

            /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$onViewBound$3$2, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
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
                    AppFragment.hideKeyboard$default(WidgetGuildRoleSubscriptionTierBenefit.this, null, 1, null);
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentManager parentFragmentManager = WidgetGuildRoleSubscriptionTierBenefit.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                EmojiPickerNavigator.launchBottomSheet(parentFragmentManager, new EmojiPickerListener() { // from class: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit.onViewBound.3.1
                    @Override // com.discord.widgets.chat.input.emoji.EmojiPickerListener
                    public void onEmojiPicked(Emoji emoji) {
                        Intrinsics3.checkNotNullParameter(emoji, "emoji");
                        WidgetGuildRoleSubscriptionTierBenefit.this.getViewModel().updateEmoji(emoji);
                        AppFragment.hideKeyboard$default(WidgetGuildRoleSubscriptionTierBenefit.this, null, 1, null);
                    }
                }, new EmojiPickerContextType.Guild(WidgetGuildRoleSubscriptionTierBenefit.this.getGuildId()), new AnonymousClass2());
            }
        });
        TextInputLayout textInputLayout = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.guildRoleSubscri…ionTierBenefitDescription");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new AnonymousClass4());
        getBinding().k.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit.onViewBound.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentActivity fragmentActivityRequireActivity = WidgetGuildRoleSubscriptionTierBenefit.this.requireActivity();
                Intent intent = new Intent();
                intent.putExtra(WidgetGuildRoleSubscriptionTierBenefit.RESULT_EXTRA_EXISTING_BENEFIT, WidgetGuildRoleSubscriptionTierBenefit.this.getExistingBenefit());
                fragmentActivityRequireActivity.setResult(-1, intent);
                AppFragment.hideKeyboard$default(WidgetGuildRoleSubscriptionTierBenefit.this, null, 1, null);
                fragmentActivityRequireActivity.finish();
            }
        });
        MaterialButton materialButton = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.guildRoleSubscriptionTierBenefitRemove");
        materialButton.setVisibility(getExistingBenefit() != null ? 0 : 8);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetGuildRoleSubscriptionTierBenefit.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetGuildRoleSubscriptionTierBenefit.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }
}
