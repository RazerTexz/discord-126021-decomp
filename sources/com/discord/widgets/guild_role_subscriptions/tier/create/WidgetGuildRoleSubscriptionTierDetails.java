package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildRoleSubscriptionDetailsBinding;
import com.discord.dialogs.ImageUploadDialog;
import com.discord.utilities.billing.PremiumUtilsKt;
import com.discord.utilities.error.Error;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.TextWatcherKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guild_role_subscriptions.WidgetPriceTierPickerBottomSheet;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0863f0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.C12116o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierDetails extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGuildRoleSubscriptionTierDetails.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionDetailsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_IS_EDIT_MODE = "INTENT_IS_EDIT_MODE";
    private static final String REQUEST_KEY_PRICE_TIER_PICKER = "REQUEST_KEY_PRICE_TIER_PICKER";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: isEditMode$delegate, reason: from kotlin metadata */
    private final Lazy isEditMode;
    private final Action1<String> tierImageSelectedResult;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ WidgetGuildRoleSubscriptionTierDetails newInstance$default(Companion companion, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = false;
            }
            return companion.newInstance(z2);
        }

        public final WidgetGuildRoleSubscriptionTierDetails newInstance(boolean isEditMode) {
            WidgetGuildRoleSubscriptionTierDetails widgetGuildRoleSubscriptionTierDetails = new WidgetGuildRoleSubscriptionTierDetails();
            widgetGuildRoleSubscriptionTierDetails.setArguments(BundleKt.bundleOf(C12116o.m10073to(WidgetGuildRoleSubscriptionTierDetails.INTENT_IS_EDIT_MODE, Boolean.valueOf(isEditMode))));
            return widgetGuildRoleSubscriptionTierDetails;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$isEditMode$2 */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
    public static final class C85102 extends AbstractC12240o implements Function0<Boolean> {
        public C85102() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final boolean invoke2() {
            Bundle arguments = WidgetGuildRoleSubscriptionTierDetails.this.getArguments();
            if (arguments != null) {
                return arguments.getBoolean(WidgetGuildRoleSubscriptionTierDetails.INTENT_IS_EDIT_MODE, false);
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
    public static final class C85111 extends AbstractC12240o implements Function1<Integer, Unit> {
        public C85111() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(int i) {
            WidgetGuildRoleSubscriptionTierDetails.this.getViewModel().updatePriceTier(i);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
    public static final class C85122 extends AbstractC12240o implements Function0<Unit> {
        public static final C85122 INSTANCE = new C85122();

        public C85122() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$onViewBound$3 */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
    public static final class C85133 extends AbstractC12240o implements Function0<Unit> {
        public C85133() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetGuildRoleSubscriptionTierDetails.this.openMediaChooser();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$onViewBound$4 */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
    public static final class C85144 extends AbstractC12240o implements Function1<String, Unit> {
        public C85144() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            C12238m.checkNotNullParameter(str, "it");
            WidgetGuildRoleSubscriptionTierDetails.this.getViewModel().updateTierName(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$onViewBound$5 */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
    public static final class C85155 extends AbstractC12240o implements Function1<String, Unit> {
        public C85155() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            C12238m.checkNotNullParameter(str, "it");
            WidgetGuildRoleSubscriptionTierDetails.this.getViewModel().updateDescription(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
    public static final class C85161 extends AbstractC12240o implements Function1<GuildRoleSubscriptionTierViewModel.ViewState, Unit> {
        public C85161() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            WidgetGuildRoleSubscriptionTierDetails widgetGuildRoleSubscriptionTierDetails = WidgetGuildRoleSubscriptionTierDetails.this;
            C12238m.checkNotNullExpressionValue(viewState, "viewState");
            widgetGuildRoleSubscriptionTierDetails.configureUI(viewState);
        }
    }

    public WidgetGuildRoleSubscriptionTierDetails() {
        super(C5419R.layout.widget_guild_role_subscription_details);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildRoleSubscriptionTierDetails$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(GuildRoleSubscriptionTierViewModel.class), new C8507x7b20ff5d(this), new C0863f0(WidgetGuildRoleSubscriptionTierDetails$viewModel$2.INSTANCE));
        this.tierImageSelectedResult = new Action1<String>() { // from class: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$tierImageSelectedResult$1
            @Override // p658rx.functions.Action1
            public final void call(String str) {
                this.this$0.getViewModel().updateImage(str);
            }
        };
        this.isEditMode = C12083g.lazy(new C85102());
    }

    private final void configureUI(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = viewState.getGuildRoleSubscriptionTier();
        TextInputLayout textInputLayout = getBinding().f16916f;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.createSubscriptionTierNameLayout");
        ViewExtensions.setTextIfDifferent(textInputLayout, guildRoleSubscriptionTier.getName());
        TextInputLayout textInputLayout2 = getBinding().f16913c;
        C12238m.checkNotNullExpressionValue(textInputLayout2, "binding.createSubscriptionTierDescriptionLayout");
        ViewExtensions.setTextIfDifferent(textInputLayout2, guildRoleSubscriptionTier.getDescription());
        getBinding().f16914d.updateImage(guildRoleSubscriptionTier);
        if (guildRoleSubscriptionTier.getPriceTier() == null) {
            getBinding().f16917g.setText(C5419R.string.guild_role_subscription_tier_detail_price_placeholder);
        } else {
            TextView textView = getBinding().f16917g;
            C12238m.checkNotNullExpressionValue(textView, "binding.createSubscriptionTierPrice");
            int iIntValue = guildRoleSubscriptionTier.getPriceTier().intValue();
            WidgetGuildRoleSubscriptionDetailsBinding binding = getBinding();
            C12238m.checkNotNullExpressionValue(binding, "binding");
            ConstraintLayout constraintLayout = binding.f16911a;
            C12238m.checkNotNullExpressionValue(constraintLayout, "binding.root");
            Context context = constraintLayout.getContext();
            C12238m.checkNotNullExpressionValue(context, "binding.root.context");
            textView.setText(PremiumUtilsKt.getFormattedPriceUsd(iIntValue, context));
        }
        Boolean boolIsPublished = guildRoleSubscriptionTier.isPublished();
        Boolean bool = Boolean.TRUE;
        if (C12238m.areEqual(boolIsPublished, bool)) {
            TextView textView2 = getBinding().f16917g;
            C12238m.checkNotNullExpressionValue(textView2, "binding.createSubscriptionTierPrice");
            ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView2, 0, 0, C5419R.drawable.ic_lock_white_a60_16dp, 0, 11, null);
        } else {
            getBinding().f16917g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails.configureUI.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetPriceTierPickerBottomSheet.INSTANCE.launch(WidgetGuildRoleSubscriptionTierDetails.this, WidgetGuildRoleSubscriptionTierDetails.REQUEST_KEY_PRICE_TIER_PICKER);
                }
            });
        }
        TextView textView3 = getBinding().f16917g;
        C12238m.checkNotNullExpressionValue(textView3, "binding.createSubscriptionTierPrice");
        textView3.setSelected(guildRoleSubscriptionTier.getPriceTier() != null && (C12238m.areEqual(guildRoleSubscriptionTier.isPublished(), bool) ^ true));
    }

    private final WidgetGuildRoleSubscriptionDetailsBinding getBinding() {
        return (WidgetGuildRoleSubscriptionDetailsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final GuildRoleSubscriptionTierViewModel getViewModel() {
        return (GuildRoleSubscriptionTierViewModel) this.viewModel.getValue();
    }

    private final boolean isEditMode() {
        return ((Boolean) this.isEditMode.getValue()).booleanValue();
    }

    @Override // com.discord.app.AppFragment
    public void onImageChosen(Uri uri, String mimeType) {
        C12238m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        C12238m.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        MGImages.prepareImageUpload(uri, mimeType, parentFragmentManager, this, this.tierImageSelectedResult, ImageUploadDialog.PreviewType.GUILD_SUBSCRIPTION_ROLE_AVATAR);
    }

    @Override // com.discord.app.AppFragment
    public void onImageCropped(Uri uri, String mimeType) {
        C12238m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        C12238m.checkNotNullParameter(mimeType, "mimeType");
        super.onImageCropped(uri, mimeType);
        MGImages.requestDataUrl(getContext(), uri, mimeType, this.tierImageSelectedResult);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        WidgetPriceTierPickerBottomSheet.INSTANCE.registerForResult(this, REQUEST_KEY_PRICE_TIER_PICKER, new C85111());
        getBinding().f16914d.configureUI(C85122.INSTANCE, new C85133());
        TextInputEditText textInputEditText = getBinding().f16915e;
        C12238m.checkNotNullExpressionValue(textInputEditText, "binding.createSubscriptionTierName");
        TextWatcherKt.addLifecycleAwareTextWatcher(textInputEditText, this, new C85144());
        TextInputEditText textInputEditText2 = getBinding().f16912b;
        C12238m.checkNotNullExpressionValue(textInputEditText2, "binding.createSubscriptionTierDescription");
        TextWatcherKt.addLifecycleAwareTextWatcher(textInputEditText2, this, new C85155());
        TextView textView = getBinding().f16919i;
        C12238m.checkNotNullExpressionValue(textView, "binding.createSubscriptionTierTitle");
        textView.setVisibility(isEditMode() ^ true ? 0 : 8);
        TextView textView2 = getBinding().f16918h;
        C12238m.checkNotNullExpressionValue(textView2, "binding.createSubscriptionTierSubtitle");
        textView2.setVisibility(isEditMode() ^ true ? 0 : 8);
        View view2 = getBinding().f16920j;
        C12238m.checkNotNullExpressionValue(view2, "binding.guildRoleSubscriptionTierDetailDivider");
        view2.setVisibility(isEditMode() ^ true ? 0 : 8);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<GuildRoleSubscriptionTierViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel.observeViewSta…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), (Class<?>) WidgetGuildRoleSubscriptionTierDetails.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C85161());
    }
}
