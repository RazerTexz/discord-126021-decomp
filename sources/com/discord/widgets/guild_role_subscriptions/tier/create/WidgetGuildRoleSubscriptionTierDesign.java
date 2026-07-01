package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.content.Context;
import android.graphics.PorterDuff$Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.f0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildRoleSubscriptionTierDesignBinding;
import com.discord.dialogs.ImageUploadDialog$PreviewType;
import com.discord.utilities.colors.ColorPickerUtils;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import f0.e0.c;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDesign.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierDesign extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildRoleSubscriptionTierDesign.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierDesignBinding;", 0)};
    public static final WidgetGuildRoleSubscriptionTierDesign$Companion Companion = new WidgetGuildRoleSubscriptionTierDesign$Companion(null);
    private static final String DIALOG_TAG_COLOR_PICKER = "DIALOG_TAG_COLOR_PICKER";
    private static final String INTENT_EXTRA_HIDE_HEADER = "INTENT_EXTRA_HIDE_HEADER";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: defaultColor$delegate, reason: from kotlin metadata */
    private final Lazy defaultColor;

    /* JADX INFO: renamed from: hideHeader$delegate, reason: from kotlin metadata */
    private final Lazy hideHeader;
    private final Action1<String> memberBadgeImageSelectedResult;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetGuildRoleSubscriptionTierDesign() {
        super(R$layout.widget_guild_role_subscription_tier_design);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildRoleSubscriptionTierDesign$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GuildRoleSubscriptionTierViewModel.class), new WidgetGuildRoleSubscriptionTierDesign$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(WidgetGuildRoleSubscriptionTierDesign$viewModel$2.INSTANCE));
        this.hideHeader = g.lazy(new WidgetGuildRoleSubscriptionTierDesign$hideHeader$2(this));
        this.memberBadgeImageSelectedResult = new WidgetGuildRoleSubscriptionTierDesign$memberBadgeImageSelectedResult$1(this);
        this.defaultColor = g.lazy(new WidgetGuildRoleSubscriptionTierDesign$defaultColor$2(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildRoleSubscriptionTierDesign widgetGuildRoleSubscriptionTierDesign, GuildRoleSubscriptionTierViewModel$ViewState guildRoleSubscriptionTierViewModel$ViewState) {
        widgetGuildRoleSubscriptionTierDesign.configureUI(guildRoleSubscriptionTierViewModel$ViewState);
    }

    public static final /* synthetic */ GuildRoleSubscriptionTierViewModel access$getViewModel$p(WidgetGuildRoleSubscriptionTierDesign widgetGuildRoleSubscriptionTierDesign) {
        return widgetGuildRoleSubscriptionTierDesign.getViewModel();
    }

    public static final /* synthetic */ void access$launchColorPicker(WidgetGuildRoleSubscriptionTierDesign widgetGuildRoleSubscriptionTierDesign, int i) {
        widgetGuildRoleSubscriptionTierDesign.launchColorPicker(i);
    }

    private final void configureUI(GuildRoleSubscriptionTierViewModel$ViewState viewState) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = viewState.getGuildRoleSubscriptionTier();
        Integer memberColor = guildRoleSubscriptionTier.getMemberColor();
        int iIntValue = memberColor != null ? memberColor.intValue() : getDefaultColor();
        setupMemberColor(iIntValue);
        getBinding().g.updateImage(guildRoleSubscriptionTier.getMemberIcon(), guildRoleSubscriptionTier.getGuildRole());
        getBinding().i.setMemberDesign(Integer.valueOf(iIntValue), guildRoleSubscriptionTier.getMemberIcon(), guildRoleSubscriptionTier.getGuildRole());
        getBinding().h.setMemberDesign(Integer.valueOf(iIntValue), guildRoleSubscriptionTier.getMemberIcon(), guildRoleSubscriptionTier.getGuildRole());
    }

    private final WidgetGuildRoleSubscriptionTierDesignBinding getBinding() {
        return (WidgetGuildRoleSubscriptionTierDesignBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final int getDefaultColor() {
        return ((Number) this.defaultColor.getValue()).intValue();
    }

    private final boolean getHideHeader() {
        return ((Boolean) this.hideHeader.getValue()).booleanValue();
    }

    private final GuildRoleSubscriptionTierViewModel getViewModel() {
        return (GuildRoleSubscriptionTierViewModel) this.viewModel.getValue();
    }

    private final void launchColorPicker(@ColorInt int currentColor) {
        ColorPickerDialog colorPickerDialogBuildColorPickerDialog = ColorPickerUtils.INSTANCE.buildColorPickerDialog(requireContext(), 2131890661, currentColor);
        colorPickerDialogBuildColorPickerDialog.k = new WidgetGuildRoleSubscriptionTierDesign$launchColorPicker$$inlined$apply$lambda$1(this);
        colorPickerDialogBuildColorPickerDialog.show(getParentFragmentManager(), DIALOG_TAG_COLOR_PICKER);
    }

    private final void setupMemberColor(@ColorInt int currentColor) {
        View view = getBinding().f2440b;
        m.checkNotNullExpressionValue(view, "binding.guildRoleSubscriptionTierAppearanceColor");
        Drawable drawable = ContextCompat.getDrawable(requireContext(), 2131232520);
        if (drawable != null) {
            drawable.mutate();
            drawable.setColorFilter(new PorterDuffColorFilter(currentColor, PorterDuff$Mode.SRC_ATOP));
        } else {
            drawable = null;
        }
        if (drawable == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        view.setBackground(drawable);
        getBinding().c.setOnClickListener(new WidgetGuildRoleSubscriptionTierDesign$setupMemberColor$2(this, currentColor));
        TextView textView = getBinding().d;
        m.checkNotNullExpressionValue(textView, "binding.guildRoleSubscri…onTierAppearanceColorText");
        StringBuilder sb = new StringBuilder();
        sb.append(MentionUtilsKt.CHANNELS_CHAR);
        String strX = c.x(currentColor);
        Objects.requireNonNull(strX, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = strX.substring(2);
        m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
        sb.append(strSubstring);
        textView.setText(sb.toString());
    }

    @Override // com.discord.app.AppFragment
    public void onImageChosen(Uri uri, String mimeType) {
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        MGImages.prepareImageUpload(uri, mimeType, parentFragmentManager, this, this.memberBadgeImageSelectedResult, ImageUploadDialog$PreviewType.GUILD_SUBSCRIPTION_ROLE_AVATAR);
    }

    @Override // com.discord.app.AppFragment
    public void onImageCropped(Uri uri, String mimeType) {
        m.checkNotNullParameter(uri, NotificationCompat$MessagingStyle$Message.KEY_DATA_URI);
        m.checkNotNullParameter(mimeType, "mimeType");
        super.onImageCropped(uri, mimeType);
        MGImages.requestDataUrl(getContext(), uri, mimeType, this.memberBadgeImageSelectedResult);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().g.configureUI(WidgetGuildRoleSubscriptionTierDesign$onViewBound$1.INSTANCE, new WidgetGuildRoleSubscriptionTierDesign$onViewBound$2(this));
        getViewModel().setDefaultMemberColor(getDefaultColor());
        TextView textView = getBinding().f;
        m.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionTierAppearanceTitle");
        textView.setVisibility(getHideHeader() ^ true ? 0 : 8);
        if (getHideHeader()) {
            getBinding().e.setPadding(0, DimenUtils.dpToPixels(16), 0, 0);
            return;
        }
        TextView textView2 = getBinding().e;
        m.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscri…ionTierAppearanceSubtitle");
        textView2.setPadding(0, 0, 0, 0);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildRoleSubscriptionTierDesign.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildRoleSubscriptionTierDesign$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
