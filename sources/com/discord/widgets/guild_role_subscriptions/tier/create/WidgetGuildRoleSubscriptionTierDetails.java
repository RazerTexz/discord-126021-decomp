package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildRoleSubscriptionDetailsBinding;
import com.discord.dialogs.ImageUploadDialog;
import com.discord.utilities.billing.PremiumUtils2;
import com.discord.utilities.error.Error;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.TextWatcher4;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guild_role_subscriptions.WidgetPriceTierPickerBottomSheet;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.LazyJVM;
import d0.Tuples;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierDetails extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildRoleSubscriptionTierDetails.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionDetailsBinding;", 0)};

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
            widgetGuildRoleSubscriptionTierDetails.setArguments(Bundle2.bundleOf(Tuples.to(WidgetGuildRoleSubscriptionTierDetails.INTENT_IS_EDIT_MODE, Boolean.valueOf(isEditMode))));
            return widgetGuildRoleSubscriptionTierDetails;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$isEditMode$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
    public static final class AnonymousClass2 extends Lambda implements Function0<Boolean> {
        public AnonymousClass2() {
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

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$onViewBound$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Integer, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            WidgetGuildRoleSubscriptionTierDetails.this.getViewModel().updatePriceTier(i);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$onViewBound$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

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
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$onViewBound$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public AnonymousClass3() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetGuildRoleSubscriptionTierDetails.this.openMediaChooser();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$onViewBound$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "it");
            WidgetGuildRoleSubscriptionTierDetails.this.getViewModel().updateTierName(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$onViewBound$5, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
    public static final class AnonymousClass5 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "it");
            WidgetGuildRoleSubscriptionTierDetails.this.getViewModel().updateDescription(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<GuildRoleSubscriptionTierViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            WidgetGuildRoleSubscriptionTierDetails widgetGuildRoleSubscriptionTierDetails = WidgetGuildRoleSubscriptionTierDetails.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "viewState");
            widgetGuildRoleSubscriptionTierDetails.configureUI(viewState);
        }
    }

    public WidgetGuildRoleSubscriptionTierDetails() {
        super(R.layout.widget_guild_role_subscription_details);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildRoleSubscriptionTierDetails2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionTierViewModel.class), new WidgetGuildRoleSubscriptionTierDetails$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(WidgetGuildRoleSubscriptionTierDetails4.INSTANCE));
        this.tierImageSelectedResult = new Action1<String>() { // from class: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails$tierImageSelectedResult$1
            @Override // rx.functions.Action1
            public final void call(String str) {
                this.this$0.getViewModel().updateImage(str);
            }
        };
        this.isEditMode = LazyJVM.lazy(new AnonymousClass2());
    }

    private final void configureUI(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = viewState.getGuildRoleSubscriptionTier();
        TextInputLayout textInputLayout = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.createSubscriptionTierNameLayout");
        ViewExtensions.setTextIfDifferent(textInputLayout, guildRoleSubscriptionTier.getName());
        TextInputLayout textInputLayout2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.createSubscriptionTierDescriptionLayout");
        ViewExtensions.setTextIfDifferent(textInputLayout2, guildRoleSubscriptionTier.getDescription());
        getBinding().d.updateImage(guildRoleSubscriptionTier);
        if (guildRoleSubscriptionTier.getPriceTier() == null) {
            getBinding().g.setText(R.string.guild_role_subscription_tier_detail_price_placeholder);
        } else {
            TextView textView = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.createSubscriptionTierPrice");
            int iIntValue = guildRoleSubscriptionTier.getPriceTier().intValue();
            WidgetGuildRoleSubscriptionDetailsBinding binding = getBinding();
            Intrinsics3.checkNotNullExpressionValue(binding, "binding");
            ConstraintLayout constraintLayout = binding.a;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.root");
            Context context = constraintLayout.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.root.context");
            textView.setText(PremiumUtils2.getFormattedPriceUsd(iIntValue, context));
        }
        Boolean boolIsPublished = guildRoleSubscriptionTier.isPublished();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics3.areEqual(boolIsPublished, bool)) {
            TextView textView2 = getBinding().g;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.createSubscriptionTierPrice");
            ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView2, 0, 0, R.drawable.ic_lock_white_a60_16dp, 0, 11, null);
        } else {
            getBinding().g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails.configureUI.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetPriceTierPickerBottomSheet.INSTANCE.launch(WidgetGuildRoleSubscriptionTierDetails.this, WidgetGuildRoleSubscriptionTierDetails.REQUEST_KEY_PRICE_TIER_PICKER);
                }
            });
        }
        TextView textView3 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.createSubscriptionTierPrice");
        textView3.setSelected(guildRoleSubscriptionTier.getPriceTier() != null && (Intrinsics3.areEqual(guildRoleSubscriptionTier.isPublished(), bool) ^ true));
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
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        MGImages.prepareImageUpload(uri, mimeType, parentFragmentManager, this, this.tierImageSelectedResult, ImageUploadDialog.PreviewType.GUILD_SUBSCRIPTION_ROLE_AVATAR);
    }

    @Override // com.discord.app.AppFragment
    public void onImageCropped(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageCropped(uri, mimeType);
        MGImages.requestDataUrl(getContext(), uri, mimeType, this.tierImageSelectedResult);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        WidgetPriceTierPickerBottomSheet.INSTANCE.registerForResult(this, REQUEST_KEY_PRICE_TIER_PICKER, new AnonymousClass1());
        getBinding().d.configureUI(AnonymousClass2.INSTANCE, new AnonymousClass3());
        TextInputEditText textInputEditText = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText, "binding.createSubscriptionTierName");
        TextWatcher4.addLifecycleAwareTextWatcher(textInputEditText, this, new AnonymousClass4());
        TextInputEditText textInputEditText2 = getBinding().f2433b;
        Intrinsics3.checkNotNullExpressionValue(textInputEditText2, "binding.createSubscriptionTierDescription");
        TextWatcher4.addLifecycleAwareTextWatcher(textInputEditText2, this, new AnonymousClass5());
        TextView textView = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.createSubscriptionTierTitle");
        textView.setVisibility(isEditMode() ^ true ? 0 : 8);
        TextView textView2 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.createSubscriptionTierSubtitle");
        textView2.setVisibility(isEditMode() ^ true ? 0 : 8);
        View view2 = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(view2, "binding.guildRoleSubscriptionTierDetailDivider");
        view2.setVisibility(isEditMode() ^ true ? 0 : 8);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<GuildRoleSubscriptionTierViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel.observeViewSta…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), (Class<?>) WidgetGuildRoleSubscriptionTierDetails.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
