package com.discord.widgets.guild_role_subscriptions.setup;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.Group;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.f0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildRoleSubscriptionPlanDetailsBinding;
import com.discord.dialogs.ImageUploadDialog$PreviewType;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.TextWatcherKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import d0.g0.t;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanDetails.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionPlanDetails extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildRoleSubscriptionPlanDetails.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionPlanDetailsBinding;", 0)};
    public static final WidgetGuildRoleSubscriptionPlanDetails$Companion Companion = new WidgetGuildRoleSubscriptionPlanDetails$Companion(null);
    public static final String INTENT_EXTRA_HIDE_HEADER = "INTENT_EXTRA_BENEFITS_HIDE_HEADER";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final Action1<String> coverImageSelectedResult;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetGuildRoleSubscriptionPlanDetails() {
        super(R$layout.widget_guild_role_subscription_plan_details);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildRoleSubscriptionPlanDetails$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GuildRoleSubscriptionPlanDetailsViewModel.class), new WidgetGuildRoleSubscriptionPlanDetails$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(WidgetGuildRoleSubscriptionPlanDetails$viewModel$2.INSTANCE));
        this.coverImageSelectedResult = new WidgetGuildRoleSubscriptionPlanDetails$coverImageSelectedResult$1(this);
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildRoleSubscriptionPlanDetails widgetGuildRoleSubscriptionPlanDetails, GuildRoleSubscriptionPlanDetailsViewModel$ViewState guildRoleSubscriptionPlanDetailsViewModel$ViewState) {
        widgetGuildRoleSubscriptionPlanDetails.configureUI(guildRoleSubscriptionPlanDetailsViewModel$ViewState);
    }

    public static final /* synthetic */ GuildRoleSubscriptionPlanDetailsViewModel access$getViewModel$p(WidgetGuildRoleSubscriptionPlanDetails widgetGuildRoleSubscriptionPlanDetails) {
        return widgetGuildRoleSubscriptionPlanDetails.getViewModel();
    }

    private final void configureUI(GuildRoleSubscriptionPlanDetailsViewModel$ViewState viewState) {
        String storeAssetImage;
        TextInputLayout textInputLayout = getBinding().d;
        m.checkNotNullExpressionValue(textInputLayout, "binding.guildRoleSubscriptionPlanDescriptionLayout");
        ViewExtensions.setTextIfDifferent(textInputLayout, viewState.getDescription());
        String coverImage = viewState.getCoverImage();
        if (!(coverImage == null || t.isBlank(coverImage))) {
            storeAssetImage = viewState.getCoverImage();
        } else if (viewState.getCoverImageAssetId() != null) {
            IconUtils iconUtils = IconUtils.INSTANCE;
            Long applicationId = viewState.getApplicationId();
            String strValueOf = String.valueOf(viewState.getCoverImageAssetId().longValue());
            SimpleDraweeView simpleDraweeView = getBinding().f2436b;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildRoleSubscriptionPlanCoverImage");
            storeAssetImage = iconUtils.getStoreAssetImage(applicationId, strValueOf, IconUtils.getMediaProxySize(simpleDraweeView.getMeasuredWidth()));
        } else {
            storeAssetImage = null;
        }
        SimpleDraweeView simpleDraweeView2 = getBinding().f2436b;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.guildRoleSubscriptionPlanCoverImage");
        MGImages.setImage$default(simpleDraweeView2, storeAssetImage, 0, 0, false, null, null, 124, null);
        ImageView imageView = getBinding().f;
        m.checkNotNullExpressionValue(imageView, "binding.guildSubscriptionPlanDetailsEditCoverImage");
        imageView.setVisibility((storeAssetImage == null || t.isBlank(storeAssetImage)) ^ true ? 0 : 8);
    }

    private final WidgetGuildRoleSubscriptionPlanDetailsBinding getBinding() {
        return (WidgetGuildRoleSubscriptionPlanDetailsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final boolean getHideHeader() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getBoolean(INTENT_EXTRA_HIDE_HEADER);
        }
        return false;
    }

    private final GuildRoleSubscriptionPlanDetailsViewModel getViewModel() {
        return (GuildRoleSubscriptionPlanDetailsViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onImageChosen(Uri uri, String mimeType) {
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        MGImages.prepareImageUpload(uri, mimeType, parentFragmentManager, this, this.coverImageSelectedResult, ImageUploadDialog$PreviewType.GUILD_SUBSCRIPTION_ROLE_AVATAR);
    }

    @Override // com.discord.app.AppFragment
    public void onImageCropped(Uri uri, String mimeType) {
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(mimeType, "mimeType");
        super.onImageCropped(uri, mimeType);
        MGImages.requestDataUrl(getContext(), uri, mimeType, this.coverImageSelectedResult);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextInputEditText textInputEditText = getBinding().c;
        m.checkNotNullExpressionValue(textInputEditText, "binding.guildRoleSubscriptionPlanDescription");
        TextWatcherKt.addLifecycleAwareTextWatcher(textInputEditText, this, new WidgetGuildRoleSubscriptionPlanDetails$onViewBound$1(this));
        getBinding().f2436b.setOnClickListener(new WidgetGuildRoleSubscriptionPlanDetails$onViewBound$2(this));
        Group group = getBinding().e;
        m.checkNotNullExpressionValue(group, "binding.guildRoleSubscri…ionPlanDetailsHeaderGroup");
        group.setVisibility(getHideHeader() ^ true ? 0 : 8);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildRoleSubscriptionPlanDetails.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildRoleSubscriptionPlanDetails$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
