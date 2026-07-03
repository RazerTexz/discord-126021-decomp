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
import com.discord.C5419R;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionBenefitType;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetGuildRoleSubscriptionTierBenefitBinding;
import com.discord.models.domain.emoji.Emoji;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
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
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p512d0.C11226f;
import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierBenefit extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGuildRoleSubscriptionTierBenefit.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierBenefitBinding;", 0)};

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
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(launcher, "launcher");
            C12238m.checkNotNullParameter(benefitType, "benefitType");
            C0870j c0870j = C0870j.f524g;
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            intent.putExtra(WidgetGuildRoleSubscriptionTierBenefit.INTENT_EXTRA_EXISTING_BENEFIT, benefit);
            intent.putExtra(WidgetGuildRoleSubscriptionTierBenefit.INTENT_EXTRA_BENEFIT_TYPE, benefitType);
            intent.putExtra(WidgetGuildRoleSubscriptionTierBenefit.INTENT_EXTRA_TIER_NAME, tierName);
            c0870j.m160f(context, launcher, WidgetGuildRoleSubscriptionTierBenefit.class, intent);
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, final Function2<? super Benefit, ? super Benefit, Unit> onBenefitUpdate) {
            C12238m.checkNotNullParameter(fragment, "fragment");
            C12238m.checkNotNullParameter(onBenefitUpdate, "onBenefitUpdate");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$Companion$registerForResult$1
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(ActivityResult activityResult) {
                    C12238m.checkNotNullExpressionValue(activityResult, "activityResult");
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
            C12238m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…  }\n          }\n        }");
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

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$configureUIForChannelBenefit$1 */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    public static final class C85291 extends AbstractC12240o implements Function3<Long, String, Integer, Unit> {
        public C85291() {
            super(3);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str, Integer num) {
            invoke(l.longValue(), str, num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(long j, String str, int i) {
            C12238m.checkNotNullParameter(str, "channelName");
            WidgetGuildRoleSubscriptionTierBenefit.this.getViewModel().updateChannel(j, str, Integer.valueOf(i));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$configureUIForChannelBenefit$2 */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    public static final class C85302 extends AbstractC12240o implements Function0<Unit> {
        public C85302() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetCreateChannel.INSTANCE.launch(WidgetGuildRoleSubscriptionTierBenefit.this.requireContext(), WidgetGuildRoleSubscriptionTierBenefit.this.createChannelLauncher, WidgetGuildRoleSubscriptionTierBenefit.this.getGuildId(), (24 & 8) != 0 ? 0 : 0, (24 & 16) != 0 ? null : null, (24 & 32) != 0 ? false : true, (24 & 64) != 0 ? false : true, (24 & 128) != 0 ? false : true, (24 & 256) != 0 ? false : true);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$configureUIForIntangibleBenefit$1 */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    public static final class C85311 extends AbstractC12240o implements Function1<Editable, Unit> {
        public C85311() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            C12238m.checkNotNullParameter(editable, "it");
            WidgetGuildRoleSubscriptionTierBenefit.this.getViewModel().updateName(editable.toString());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$onViewBound$4 */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    public static final class C85354 extends AbstractC12240o implements Function1<Editable, Unit> {
        public C85354() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            C12238m.checkNotNullParameter(editable, "it");
            WidgetGuildRoleSubscriptionTierBenefit.this.getViewModel().updateDescription(editable.toString());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    public static final class C85371 extends AbstractC12240o implements Function1<GuildRoleSubscriptionTierBenefitViewModel.ViewState, Unit> {
        public C85371() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierBenefitViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierBenefitViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "it");
            WidgetGuildRoleSubscriptionTierBenefit.this.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
    public static final class C85382 extends AbstractC12240o implements Function1<GuildRoleSubscriptionTierBenefitViewModel.Event, Unit> {
        public C85382() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierBenefitViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierBenefitViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "it");
            WidgetGuildRoleSubscriptionTierBenefit.this.handleEvent(event);
        }
    }

    public WidgetGuildRoleSubscriptionTierBenefit() {
        super(C5419R.layout.widget_guild_role_subscription_tier_benefit);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildRoleSubscriptionTierBenefit$binding$2.INSTANCE, null, 2, null);
        this.guildId = C12083g.lazy(new WidgetGuildRoleSubscriptionTierBenefit$guildId$2(this));
        this.existingBenefit = C12083g.lazy(new WidgetGuildRoleSubscriptionTierBenefit$existingBenefit$2(this));
        this.benefitType = C12083g.lazy(new WidgetGuildRoleSubscriptionTierBenefit$benefitType$2(this));
        this.tierName = C12083g.lazy(new WidgetGuildRoleSubscriptionTierBenefit$tierName$2(this));
        WidgetGuildRoleSubscriptionTierBenefit$viewModel$2 widgetGuildRoleSubscriptionTierBenefit$viewModel$2 = new WidgetGuildRoleSubscriptionTierBenefit$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(GuildRoleSubscriptionTierBenefitViewModel.class), new C8527x29c71454(c0865g0), new C0869i0(widgetGuildRoleSubscriptionTierBenefit$viewModel$2));
        this.createChannelLauncher = WidgetCreateChannel.INSTANCE.registerForResult(this, new WidgetGuildRoleSubscriptionTierBenefit$createChannelLauncher$1(this));
    }

    private final void cancel() {
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        fragmentActivityRequireActivity.setResult(0);
        AppFragment.hideKeyboard$default(this, null, 1, null);
        fragmentActivityRequireActivity.finish();
    }

    private final void configureUI(final GuildRoleSubscriptionTierBenefitViewModel.ViewState viewState) {
        String string;
        TextView textView = getBinding().f16952n;
        C12238m.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionTierBenefitSubtitle");
        textView.setText(viewState.getTierName());
        Emoji emoji = viewState.getEmoji();
        String imageUri = emoji != null ? emoji.getImageUri(false, C11226f.coerceAtMost(IconUtils.getMediaProxySize(getResources().getDimensionPixelSize(C5419R.dimen.guild_role_subscription_create_benefit_emoji_size)), 64), requireContext()) : null;
        SimpleDraweeView simpleDraweeView = getBinding().f16946h;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildRoleSubscriptionTierBenefitEmoji");
        MGImages.setImage$default(simpleDraweeView, imageUri, 0, 0, true, null, null, 108, null);
        if (emoji == null || (string = emoji.getFirstName()) == null) {
            string = getString(C5419R.string.guild_role_subscription_tier_benefits_emoji_placeholder);
            C12238m.checkNotNullExpressionValue(string, "getString(R.string.guild…nefits_emoji_placeholder)");
        }
        TextView textView2 = getBinding().f16947i;
        C12238m.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierBenefitEmojiName");
        textView2.setText(string);
        TextInputLayout textInputLayout = getBinding().f16944f;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.guildRoleSubscri…ionTierBenefitDescription");
        ViewExtensions.setTextIfDifferent(textInputLayout, viewState.getDescription());
        String name = viewState.getName();
        if (!(name == null || C12103t.isBlank(name))) {
            TextView textView3 = getBinding().f16948j;
            C12238m.checkNotNullExpressionValue(textView3, "binding.guildRoleSubscriptionTierBenefitName");
            textView3.setText(viewState.getName());
            TextInputLayout textInputLayout2 = getBinding().f16942d;
            C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.guildRoleSubscri…tangibleBenefitNameLayout");
            ViewExtensions.setTextIfDifferent(textInputLayout2, viewState.getName());
        }
        TextView textView4 = getBinding().f16948j;
        C12238m.checkNotNullExpressionValue(textView4, "binding.guildRoleSubscriptionTierBenefitName");
        Integer leadingNameIconResId = viewState.getLeadingNameIconResId();
        ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView4, leadingNameIconResId != null ? leadingNameIconResId.intValue() : 0, 0, C5419R.drawable.icon_carrot, 0, 10, null);
        if (getBenefitType() == GuildRoleSubscriptionBenefitType.CHANNEL) {
            getBinding().f16948j.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit.configureUI.1

                /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$configureUI$1$1, reason: invalid class name */
                /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
                public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
                    public AnonymousClass1() {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.f27425a;
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
                    companion.launch(widgetGuildRoleSubscriptionTierBenefit, WidgetGuildRoleSubscriptionTierBenefit.REQUEST_KEY_CHANNEL_PICKER, widgetGuildRoleSubscriptionTierBenefit.getGuildId(), viewState.getChannelId(), new AnonymousClass1(), true);
                }
            });
        }
        MaterialButton materialButton = getBinding().f16950l;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.guildRoleSubscriptionTierBenefitSave");
        materialButton.setEnabled(viewState.getCanSubmitResult());
    }

    private final void configureUIForChannelBenefit() {
        WidgetChannelPickerBottomSheet.INSTANCE.registerForResult(this, REQUEST_KEY_CHANNEL_PICKER, new C85291(), new C85302());
        TextView textView = getBinding().f16940b;
        C12238m.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionBenefitChannelLabel");
        textView.setVisibility(0);
        TextView textView2 = getBinding().f16948j;
        C12238m.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierBenefitName");
        textView2.setVisibility(0);
        TextView textView3 = getBinding().f16954p;
        C12238m.checkNotNullExpressionValue(textView3, "binding.guildRoleSubscri…TierChannelBenefitWarning");
        textView3.setVisibility(0);
        TextView textView4 = getBinding().f16953o;
        C12238m.checkNotNullExpressionValue(textView4, "binding.guildRoleSubscriptionTierBenefitTitle");
        textView4.setText(getString(C5419R.string.guild_role_subscription_tier_exclusive_channel_title));
        TextInputEditText textInputEditText = getBinding().f16945g;
        C12238m.checkNotNullExpressionValue(textInputEditText, "binding.guildRoleSubscri…enefitDescriptionEditText");
        textInputEditText.setHint(getString(C5419R.string.guild_role_subscription_channel_benefit_description_placeholder));
    }

    private final void configureUIForIntangibleBenefit() {
        TextView textView = getBinding().f16940b;
        C12238m.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionBenefitChannelLabel");
        textView.setVisibility(8);
        TextView textView2 = getBinding().f16948j;
        C12238m.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscriptionTierBenefitName");
        textView2.setVisibility(8);
        TextView textView3 = getBinding().f16954p;
        C12238m.checkNotNullExpressionValue(textView3, "binding.guildRoleSubscri…TierChannelBenefitWarning");
        textView3.setVisibility(8);
        TextInputLayout textInputLayout = getBinding().f16942d;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.guildRoleSubscri…tangibleBenefitNameLayout");
        textInputLayout.setVisibility(0);
        TextView textView4 = getBinding().f16941c;
        C12238m.checkNotNullExpressionValue(textView4, "binding.guildRoleSubscri…ntangibleBenefitNameLabel");
        textView4.setVisibility(0);
        TextInputLayout textInputLayout2 = getBinding().f16942d;
        C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.guildRoleSubscri…tangibleBenefitNameLayout");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, this, new C85311());
        TextView textView5 = getBinding().f16953o;
        C12238m.checkNotNullExpressionValue(textView5, "binding.guildRoleSubscriptionTierBenefitTitle");
        textView5.setText(getString(C5419R.string.guild_role_subscription_tier_additional_benefit_title));
        TextInputEditText textInputEditText = getBinding().f16945g;
        C12238m.checkNotNullExpressionValue(textInputEditText, "binding.guildRoleSubscri…enefitDescriptionEditText");
        textInputEditText.setHint(getString(C5419R.string.f14678xecdcb48b));
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
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        int iOrdinal = getBenefitType().ordinal();
        if (iOrdinal == 0) {
            AppLog appLog = AppLog.f14950g;
            StringBuilder sbM833U = C1643a.m833U("Unknown benefit type: ");
            sbM833U.append(getBenefitType());
            Logger.e$default(appLog, sbM833U.toString(), null, null, 6, null);
            C0876m.m171i(this, C5419R.string.default_failure_to_perform_action_message, 0, 4);
            cancel();
        } else if (iOrdinal == 1) {
            configureUIForChannelBenefit();
        } else if (iOrdinal == 2) {
            configureUIForIntangibleBenefit();
        }
        getBinding().f16950l.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetGuildRoleSubscriptionTierBenefit.this.getViewModel().submitResult();
            }
        });
        getBinding().f16943e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetGuildRoleSubscriptionTierBenefit.this.cancel();
            }
        });
        getBinding().f16951m.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit.onViewBound.3

            /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit$onViewBound$3$2, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierBenefit.kt */
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
                    AppFragment.hideKeyboard$default(WidgetGuildRoleSubscriptionTierBenefit.this, null, 1, null);
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                FragmentManager parentFragmentManager = WidgetGuildRoleSubscriptionTierBenefit.this.getParentFragmentManager();
                C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                EmojiPickerNavigator.launchBottomSheet(parentFragmentManager, new EmojiPickerListener() { // from class: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit.onViewBound.3.1
                    @Override // com.discord.widgets.chat.input.emoji.EmojiPickerListener
                    public void onEmojiPicked(Emoji emoji) {
                        C12238m.checkNotNullParameter(emoji, "emoji");
                        WidgetGuildRoleSubscriptionTierBenefit.this.getViewModel().updateEmoji(emoji);
                        AppFragment.hideKeyboard$default(WidgetGuildRoleSubscriptionTierBenefit.this, null, 1, null);
                    }
                }, new EmojiPickerContextType.Guild(WidgetGuildRoleSubscriptionTierBenefit.this.getGuildId()), new AnonymousClass2());
            }
        });
        TextInputLayout textInputLayout = getBinding().f16944f;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.guildRoleSubscri…ionTierBenefitDescription");
        ViewExtensions.addBindedTextWatcher(textInputLayout, this, new C85354());
        getBinding().f16949k.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefit.onViewBound.5
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
        MaterialButton materialButton = getBinding().f16949k;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.guildRoleSubscriptionTierBenefitRemove");
        materialButton.setVisibility(getExistingBenefit() != null ? 0 : 8);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetGuildRoleSubscriptionTierBenefit.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C85371());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetGuildRoleSubscriptionTierBenefit.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C85382());
    }
}
