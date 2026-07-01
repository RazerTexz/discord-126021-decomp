package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.f0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildRoleSubscriptionDetailsBinding;
import com.discord.dialogs.ImageUploadDialog$PreviewType;
import com.discord.utilities.billing.PremiumUtilsKt;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.TextWatcherKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guild_role_subscriptions.WidgetPriceTierPickerBottomSheet;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDetails.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierDetails extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildRoleSubscriptionTierDetails.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionDetailsBinding;", 0)};
    public static final WidgetGuildRoleSubscriptionTierDetails$Companion Companion = new WidgetGuildRoleSubscriptionTierDetails$Companion(null);
    private static final String INTENT_IS_EDIT_MODE = "INTENT_IS_EDIT_MODE";
    private static final String REQUEST_KEY_PRICE_TIER_PICKER = "REQUEST_KEY_PRICE_TIER_PICKER";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: isEditMode$delegate, reason: from kotlin metadata */
    private final Lazy isEditMode;
    private final Action1<String> tierImageSelectedResult;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetGuildRoleSubscriptionTierDetails() {
        super(R$layout.widget_guild_role_subscription_details);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildRoleSubscriptionTierDetails$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GuildRoleSubscriptionTierViewModel.class), new WidgetGuildRoleSubscriptionTierDetails$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(WidgetGuildRoleSubscriptionTierDetails$viewModel$2.INSTANCE));
        this.tierImageSelectedResult = new WidgetGuildRoleSubscriptionTierDetails$tierImageSelectedResult$1(this);
        this.isEditMode = g.lazy(new WidgetGuildRoleSubscriptionTierDetails$isEditMode$2(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildRoleSubscriptionTierDetails widgetGuildRoleSubscriptionTierDetails, GuildRoleSubscriptionTierViewModel$ViewState guildRoleSubscriptionTierViewModel$ViewState) {
        widgetGuildRoleSubscriptionTierDetails.configureUI(guildRoleSubscriptionTierViewModel$ViewState);
    }

    public static final /* synthetic */ GuildRoleSubscriptionTierViewModel access$getViewModel$p(WidgetGuildRoleSubscriptionTierDetails widgetGuildRoleSubscriptionTierDetails) {
        return widgetGuildRoleSubscriptionTierDetails.getViewModel();
    }

    private final void configureUI(GuildRoleSubscriptionTierViewModel$ViewState viewState) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = viewState.getGuildRoleSubscriptionTier();
        TextInputLayout textInputLayout = getBinding().f;
        m.checkNotNullExpressionValue(textInputLayout, "binding.createSubscriptionTierNameLayout");
        ViewExtensions.setTextIfDifferent(textInputLayout, guildRoleSubscriptionTier.getName());
        TextInputLayout textInputLayout2 = getBinding().c;
        m.checkNotNullExpressionValue(textInputLayout2, "binding.createSubscriptionTierDescriptionLayout");
        ViewExtensions.setTextIfDifferent(textInputLayout2, guildRoleSubscriptionTier.getDescription());
        getBinding().d.updateImage(guildRoleSubscriptionTier);
        if (guildRoleSubscriptionTier.getPriceTier() == null) {
            getBinding().g.setText(2131890673);
        } else {
            TextView textView = getBinding().g;
            m.checkNotNullExpressionValue(textView, "binding.createSubscriptionTierPrice");
            int iIntValue = guildRoleSubscriptionTier.getPriceTier().intValue();
            WidgetGuildRoleSubscriptionDetailsBinding binding = getBinding();
            m.checkNotNullExpressionValue(binding, "binding");
            ConstraintLayout constraintLayout = binding.a;
            m.checkNotNullExpressionValue(constraintLayout, "binding.root");
            Context context = constraintLayout.getContext();
            m.checkNotNullExpressionValue(context, "binding.root.context");
            textView.setText(PremiumUtilsKt.getFormattedPriceUsd(iIntValue, context));
        }
        Boolean boolIsPublished = guildRoleSubscriptionTier.isPublished();
        Boolean bool = Boolean.TRUE;
        if (m.areEqual(boolIsPublished, bool)) {
            TextView textView2 = getBinding().g;
            m.checkNotNullExpressionValue(textView2, "binding.createSubscriptionTierPrice");
            ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView2, 0, 0, 2131231904, 0, 11, null);
        } else {
            getBinding().g.setOnClickListener(new WidgetGuildRoleSubscriptionTierDetails$configureUI$1(this));
        }
        TextView textView3 = getBinding().g;
        m.checkNotNullExpressionValue(textView3, "binding.createSubscriptionTierPrice");
        textView3.setSelected(guildRoleSubscriptionTier.getPriceTier() != null && (m.areEqual(guildRoleSubscriptionTier.isPublished(), bool) ^ true));
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
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        MGImages.prepareImageUpload(uri, mimeType, parentFragmentManager, this, this.tierImageSelectedResult, ImageUploadDialog$PreviewType.GUILD_SUBSCRIPTION_ROLE_AVATAR);
    }

    @Override // com.discord.app.AppFragment
    public void onImageCropped(Uri uri, String mimeType) {
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(mimeType, "mimeType");
        super.onImageCropped(uri, mimeType);
        MGImages.requestDataUrl(getContext(), uri, mimeType, this.tierImageSelectedResult);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        WidgetPriceTierPickerBottomSheet.Companion.registerForResult(this, REQUEST_KEY_PRICE_TIER_PICKER, new WidgetGuildRoleSubscriptionTierDetails$onViewBound$1(this));
        getBinding().d.configureUI(WidgetGuildRoleSubscriptionTierDetails$onViewBound$2.INSTANCE, new WidgetGuildRoleSubscriptionTierDetails$onViewBound$3(this));
        TextInputEditText textInputEditText = getBinding().e;
        m.checkNotNullExpressionValue(textInputEditText, "binding.createSubscriptionTierName");
        TextWatcherKt.addLifecycleAwareTextWatcher(textInputEditText, this, new WidgetGuildRoleSubscriptionTierDetails$onViewBound$4(this));
        TextInputEditText textInputEditText2 = getBinding().f2433b;
        m.checkNotNullExpressionValue(textInputEditText2, "binding.createSubscriptionTierDescription");
        TextWatcherKt.addLifecycleAwareTextWatcher(textInputEditText2, this, new WidgetGuildRoleSubscriptionTierDetails$onViewBound$5(this));
        TextView textView = getBinding().i;
        m.checkNotNullExpressionValue(textView, "binding.createSubscriptionTierTitle");
        textView.setVisibility(isEditMode() ^ true ? 0 : 8);
        TextView textView2 = getBinding().h;
        m.checkNotNullExpressionValue(textView2, "binding.createSubscriptionTierSubtitle");
        textView2.setVisibility(isEditMode() ^ true ? 0 : 8);
        View view2 = getBinding().j;
        m.checkNotNullExpressionValue(view2, "binding.guildRoleSubscriptionTierDetailDivider");
        view2.setVisibility(isEditMode() ^ true ? 0 : 8);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<GuildRoleSubscriptionTierViewModel$ViewState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel.observeViewSta…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetGuildRoleSubscriptionTierDetails.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildRoleSubscriptionTierDetails$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
