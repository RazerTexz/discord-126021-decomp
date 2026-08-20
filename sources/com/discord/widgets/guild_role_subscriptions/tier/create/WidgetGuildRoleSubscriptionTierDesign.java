package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildRoleSubscriptionTierDesignBinding;
import com.discord.dialogs.ImageUploadDialog;
import com.discord.utilities.colors.ColorPickerUtils;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0863f0;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p440k.p441a.p442a.InterfaceC5079f;
import p507d0.C12083g;
import p507d0.C12116o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p600f0.p601e0.C12272c;
import p658rx.Subscription;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDesign.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierDesign extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGuildRoleSubscriptionTierDesign.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierDesignBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
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

    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDesign.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ WidgetGuildRoleSubscriptionTierDesign newInstance$default(Companion companion, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = false;
            }
            return companion.newInstance(z2);
        }

        public final WidgetGuildRoleSubscriptionTierDesign newInstance(boolean hideHeader) {
            WidgetGuildRoleSubscriptionTierDesign widgetGuildRoleSubscriptionTierDesign = new WidgetGuildRoleSubscriptionTierDesign();
            widgetGuildRoleSubscriptionTierDesign.setArguments(BundleKt.bundleOf(C12116o.m10073to(WidgetGuildRoleSubscriptionTierDesign.INTENT_EXTRA_HIDE_HEADER, Boolean.valueOf(hideHeader))));
            return widgetGuildRoleSubscriptionTierDesign;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDesign$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDesign.kt */
    public static final class C85031 extends AbstractC12240o implements Function0<Unit> {
        public static final C85031 INSTANCE = new C85031();

        public C85031() {
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

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDesign$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDesign.kt */
    public static final class C85042 extends AbstractC12240o implements Function0<Unit> {
        public C85042() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetGuildRoleSubscriptionTierDesign.this.openMediaChooser();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDesign$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDesign.kt */
    public static final class C85051 extends AbstractC12240o implements Function1<GuildRoleSubscriptionTierViewModel.ViewState, Unit> {
        public C85051() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "it");
            WidgetGuildRoleSubscriptionTierDesign.this.configureUI(viewState);
        }
    }

    public WidgetGuildRoleSubscriptionTierDesign() {
        super(C5419R.layout.widget_guild_role_subscription_tier_design);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildRoleSubscriptionTierDesign$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(GuildRoleSubscriptionTierViewModel.class), new C8499xc56e8221(this), new C0863f0(WidgetGuildRoleSubscriptionTierDesign$viewModel$2.INSTANCE));
        this.hideHeader = C12083g.lazy(new WidgetGuildRoleSubscriptionTierDesign$hideHeader$2(this));
        this.memberBadgeImageSelectedResult = new Action1<String>() { // from class: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDesign$memberBadgeImageSelectedResult$1
            @Override // p658rx.functions.Action1
            public final void call(String str) {
                this.this$0.getViewModel().updateMemberIcon(str);
            }
        };
        this.defaultColor = C12083g.lazy(new WidgetGuildRoleSubscriptionTierDesign$defaultColor$2(this));
    }

    private final void configureUI(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = viewState.getGuildRoleSubscriptionTier();
        Integer memberColor = guildRoleSubscriptionTier.getMemberColor();
        int iIntValue = memberColor != null ? memberColor.intValue() : getDefaultColor();
        setupMemberColor(iIntValue);
        getBinding().f16969g.updateImage(guildRoleSubscriptionTier.getMemberIcon(), guildRoleSubscriptionTier.getGuildRole());
        getBinding().f16971i.setMemberDesign(Integer.valueOf(iIntValue), guildRoleSubscriptionTier.getMemberIcon(), guildRoleSubscriptionTier.getGuildRole());
        getBinding().f16970h.setMemberDesign(Integer.valueOf(iIntValue), guildRoleSubscriptionTier.getMemberIcon(), guildRoleSubscriptionTier.getGuildRole());
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
        ColorPickerDialog colorPickerDialogBuildColorPickerDialog = ColorPickerUtils.INSTANCE.buildColorPickerDialog(requireContext(), C5419R.string.guild_role_subscription_tier_design_member_color_label, currentColor);
        colorPickerDialogBuildColorPickerDialog.f21719k = new InterfaceC5079f() { // from class: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDesign$launchColorPicker$$inlined$apply$lambda$1
            @Override // p007b.p440k.p441a.p442a.InterfaceC5079f
            public void onColorReset(int dialogId) {
                this.this$0.getViewModel().updateMemberColor(null);
            }

            @Override // p007b.p440k.p441a.p442a.InterfaceC5079f
            public void onColorSelected(int dialogId, int selectedColor) {
                this.this$0.getViewModel().updateMemberColor(Integer.valueOf(selectedColor));
            }

            @Override // p007b.p440k.p441a.p442a.InterfaceC5079f
            public void onDialogDismissed(int dialogId) {
            }
        };
        colorPickerDialogBuildColorPickerDialog.show(getParentFragmentManager(), DIALOG_TAG_COLOR_PICKER);
    }

    private final void setupMemberColor(@ColorInt final int currentColor) {
        View view = getBinding().f16964b;
        C12238m.checkNotNullExpressionValue(view, "binding.guildRoleSubscriptionTierAppearanceColor");
        Drawable drawable = ContextCompat.getDrawable(requireContext(), C5419R.drawable.rounded_rectangle_4dp_radius);
        if (drawable != null) {
            drawable.mutate();
            drawable.setColorFilter(new PorterDuffColorFilter(currentColor, PorterDuff.Mode.SRC_ATOP));
        } else {
            drawable = null;
        }
        if (drawable == null) {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        view.setBackground(drawable);
        getBinding().f16965c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDesign.setupMemberColor.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetGuildRoleSubscriptionTierDesign.this.launchColorPicker(currentColor);
            }
        });
        TextView textView = getBinding().f16966d;
        C12238m.checkNotNullExpressionValue(textView, "binding.guildRoleSubscri…onTierAppearanceColorText");
        StringBuilder sb = new StringBuilder();
        sb.append(MentionUtilsKt.CHANNELS_CHAR);
        String strM10143x = C12272c.m10143x(currentColor);
        Objects.requireNonNull(strM10143x, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = strM10143x.substring(2);
        C12238m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
        sb.append(strSubstring);
        textView.setText(sb.toString());
    }

    @Override // com.discord.app.AppFragment
    public void onImageChosen(Uri uri, String mimeType) {
        C12238m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        C12238m.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        MGImages.prepareImageUpload(uri, mimeType, parentFragmentManager, this, this.memberBadgeImageSelectedResult, ImageUploadDialog.PreviewType.GUILD_SUBSCRIPTION_ROLE_AVATAR);
    }

    @Override // com.discord.app.AppFragment
    public void onImageCropped(Uri uri, String mimeType) {
        C12238m.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        C12238m.checkNotNullParameter(mimeType, "mimeType");
        super.onImageCropped(uri, mimeType);
        MGImages.requestDataUrl(getContext(), uri, mimeType, this.memberBadgeImageSelectedResult);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f16969g.configureUI(C85031.INSTANCE, new C85042());
        getViewModel().setDefaultMemberColor(getDefaultColor());
        TextView textView = getBinding().f16968f;
        C12238m.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionTierAppearanceTitle");
        textView.setVisibility(getHideHeader() ^ true ? 0 : 8);
        if (getHideHeader()) {
            getBinding().f16967e.setPadding(0, DimenUtils.dpToPixels(16), 0, 0);
            return;
        }
        TextView textView2 = getBinding().f16967e;
        C12238m.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscri…ionTierAppearanceSubtitle");
        textView2.setPadding(0, 0, 0, 0);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetGuildRoleSubscriptionTierDesign.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C85051());
    }
}
