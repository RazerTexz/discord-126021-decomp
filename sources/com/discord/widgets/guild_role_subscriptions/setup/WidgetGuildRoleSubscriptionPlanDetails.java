package com.discord.widgets.guild_role_subscriptions.setup;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.Group;
import androidx.core.app.NotificationCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildRoleSubscriptionPlanDetailsBinding;
import com.discord.dialogs.ImageUploadDialog;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.TextWatcherKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.facebook.drawee.view.SimpleDraweeView;
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
import p507d0.C12116o;
import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanDetails.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionPlanDetails extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGuildRoleSubscriptionPlanDetails.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionPlanDetailsBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String INTENT_EXTRA_HIDE_HEADER = "INTENT_EXTRA_BENEFITS_HIDE_HEADER";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final Action1<String> coverImageSelectedResult;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanDetails.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ WidgetGuildRoleSubscriptionPlanDetails newInstance$default(Companion companion, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = false;
            }
            return companion.newInstance(z2);
        }

        public final WidgetGuildRoleSubscriptionPlanDetails newInstance(boolean hideHeader) {
            WidgetGuildRoleSubscriptionPlanDetails widgetGuildRoleSubscriptionPlanDetails = new WidgetGuildRoleSubscriptionPlanDetails();
            widgetGuildRoleSubscriptionPlanDetails.setArguments(BundleKt.bundleOf(C12116o.m10073to(WidgetGuildRoleSubscriptionPlanDetails.INTENT_EXTRA_HIDE_HEADER, Boolean.valueOf(hideHeader))));
            return widgetGuildRoleSubscriptionPlanDetails;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanDetails$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanDetails.kt */
    public static final class C84541 extends AbstractC12240o implements Function1<String, Unit> {
        public C84541() {
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
            WidgetGuildRoleSubscriptionPlanDetails.this.getViewModel().updateDescription(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanDetails$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanDetails.kt */
    public static final class C84561 extends AbstractC12240o implements Function1<GuildRoleSubscriptionPlanDetailsViewModel.ViewState, Unit> {
        public C84561() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionPlanDetailsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionPlanDetailsViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "it");
            WidgetGuildRoleSubscriptionPlanDetails.this.configureUI(viewState);
        }
    }

    public WidgetGuildRoleSubscriptionPlanDetails() {
        super(C5419R.layout.widget_guild_role_subscription_plan_details);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildRoleSubscriptionPlanDetails$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(GuildRoleSubscriptionPlanDetailsViewModel.class), new C8451x67b88db6(this), new C0863f0(WidgetGuildRoleSubscriptionPlanDetails$viewModel$2.INSTANCE));
        this.coverImageSelectedResult = new Action1<String>() { // from class: com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanDetails$coverImageSelectedResult$1
            @Override // p658rx.functions.Action1
            public final void call(String str) {
                this.this$0.getViewModel().updateCoverImage(str);
            }
        };
    }

    private final void configureUI(GuildRoleSubscriptionPlanDetailsViewModel.ViewState viewState) {
        String storeAssetImage;
        TextInputLayout textInputLayout = getBinding().f16930d;
        C12238m.checkNotNullExpressionValue(textInputLayout, "binding.guildRoleSubscriptionPlanDescriptionLayout");
        ViewExtensions.setTextIfDifferent(textInputLayout, viewState.getDescription());
        String coverImage = viewState.getCoverImage();
        if (!(coverImage == null || C12103t.isBlank(coverImage))) {
            storeAssetImage = viewState.getCoverImage();
        } else if (viewState.getCoverImageAssetId() != null) {
            IconUtils iconUtils = IconUtils.INSTANCE;
            Long applicationId = viewState.getApplicationId();
            String strValueOf = String.valueOf(viewState.getCoverImageAssetId().longValue());
            SimpleDraweeView simpleDraweeView = getBinding().f16928b;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildRoleSubscriptionPlanCoverImage");
            storeAssetImage = iconUtils.getStoreAssetImage(applicationId, strValueOf, IconUtils.getMediaProxySize(simpleDraweeView.getMeasuredWidth()));
        } else {
            storeAssetImage = null;
        }
        SimpleDraweeView simpleDraweeView2 = getBinding().f16928b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.guildRoleSubscriptionPlanCoverImage");
        MGImages.setImage$default(simpleDraweeView2, storeAssetImage, 0, 0, false, null, null, 124, null);
        ImageView imageView = getBinding().f16932f;
        C12238m.checkNotNullExpressionValue(imageView, "binding.guildSubscriptionPlanDetailsEditCoverImage");
        imageView.setVisibility((storeAssetImage == null || C12103t.isBlank(storeAssetImage)) ^ true ? 0 : 8);
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
        C12238m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        C12238m.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        MGImages.prepareImageUpload(uri, mimeType, parentFragmentManager, this, this.coverImageSelectedResult, ImageUploadDialog.PreviewType.GUILD_SUBSCRIPTION_ROLE_AVATAR);
    }

    @Override // com.discord.app.AppFragment
    public void onImageCropped(Uri uri, String mimeType) {
        C12238m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        C12238m.checkNotNullParameter(mimeType, "mimeType");
        super.onImageCropped(uri, mimeType);
        MGImages.requestDataUrl(getContext(), uri, mimeType, this.coverImageSelectedResult);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextInputEditText textInputEditText = getBinding().f16929c;
        C12238m.checkNotNullExpressionValue(textInputEditText, "binding.guildRoleSubscriptionPlanDescription");
        TextWatcherKt.addLifecycleAwareTextWatcher(textInputEditText, this, new C84541());
        getBinding().f16928b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanDetails.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetGuildRoleSubscriptionPlanDetails.this.openMediaChooser();
            }
        });
        Group group = getBinding().f16931e;
        C12238m.checkNotNullExpressionValue(group, "binding.guildRoleSubscri…ionPlanDetailsHeaderGroup");
        group.setVisibility(getHideHeader() ^ true ? 0 : 8);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetGuildRoleSubscriptionPlanDetails.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C84561());
    }
}
