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
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates2;
import b.d.b.a.outline;
import b.k.a.a.ColorPickerDialogListener;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildRoleSubscriptionTierDesignBinding;
import com.discord.dialogs.ImageUploadDialog;
import com.discord.utilities.colors.ColorPickerUtils;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import com.jaredrummler.android.colorpicker.ColorPickerDialog;
import d0.LazyJVM;
import d0.Tuples;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import f0.e0.Util7;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;
import rx.functions.Action1;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDesign.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionTierDesign extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildRoleSubscriptionTierDesign.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierDesignBinding;", 0)};

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
            widgetGuildRoleSubscriptionTierDesign.setArguments(Bundle2.bundleOf(Tuples.to(WidgetGuildRoleSubscriptionTierDesign.INTENT_EXTRA_HIDE_HEADER, Boolean.valueOf(hideHeader))));
            return widgetGuildRoleSubscriptionTierDesign;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDesign$onViewBound$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDesign.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
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

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDesign$onViewBound$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDesign.kt */
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
            WidgetGuildRoleSubscriptionTierDesign.this.openMediaChooser();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDesign$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionTierDesign.kt */
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
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetGuildRoleSubscriptionTierDesign.this.configureUI(viewState);
        }
    }

    public WidgetGuildRoleSubscriptionTierDesign() {
        super(R.layout.widget_guild_role_subscription_tier_design);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildRoleSubscriptionTierDesign2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionTierViewModel.class), new WidgetGuildRoleSubscriptionTierDesign$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(WidgetGuildRoleSubscriptionTierDesign7.INSTANCE));
        this.hideHeader = LazyJVM.lazy(new WidgetGuildRoleSubscriptionTierDesign4(this));
        this.memberBadgeImageSelectedResult = new Action1<String>() { // from class: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDesign$memberBadgeImageSelectedResult$1
            @Override // rx.functions.Action1
            public final void call(String str) {
                this.this$0.getViewModel().updateMemberIcon(str);
            }
        };
        this.defaultColor = LazyJVM.lazy(new WidgetGuildRoleSubscriptionTierDesign3(this));
    }

    private final void configureUI(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
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
        ColorPickerDialog colorPickerDialogBuildColorPickerDialog = ColorPickerUtils.INSTANCE.buildColorPickerDialog(requireContext(), R.string.guild_role_subscription_tier_design_member_color_label, currentColor);
        colorPickerDialogBuildColorPickerDialog.k = new ColorPickerDialogListener() { // from class: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDesign$launchColorPicker$$inlined$apply$lambda$1
            @Override // b.k.a.a.ColorPickerDialogListener
            public void onColorReset(int dialogId) {
                this.this$0.getViewModel().updateMemberColor(null);
            }

            @Override // b.k.a.a.ColorPickerDialogListener
            public void onColorSelected(int dialogId, int selectedColor) {
                this.this$0.getViewModel().updateMemberColor(Integer.valueOf(selectedColor));
            }

            @Override // b.k.a.a.ColorPickerDialogListener
            public void onDialogDismissed(int dialogId) {
            }
        };
        colorPickerDialogBuildColorPickerDialog.show(getParentFragmentManager(), DIALOG_TAG_COLOR_PICKER);
    }

    private final void setupMemberColor(@ColorInt final int currentColor) {
        View view = getBinding().f2440b;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.guildRoleSubscriptionTierAppearanceColor");
        Drawable drawable = ContextCompat.getDrawable(requireContext(), R.drawable.rounded_rectangle_4dp_radius);
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
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDesign.setupMemberColor.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetGuildRoleSubscriptionTierDesign.this.launchColorPicker(currentColor);
            }
        });
        TextView textView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscri…onTierAppearanceColorText");
        StringBuilder sb = new StringBuilder();
        sb.append(MentionUtils.CHANNELS_CHAR);
        String strX = Util7.x(currentColor);
        Objects.requireNonNull(strX, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = strX.substring(2);
        Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
        sb.append(strSubstring);
        textView.setText(sb.toString());
    }

    @Override // com.discord.app.AppFragment
    public void onImageChosen(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageChosen(uri, mimeType);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        MGImages.prepareImageUpload(uri, mimeType, parentFragmentManager, this, this.memberBadgeImageSelectedResult, ImageUploadDialog.PreviewType.GUILD_SUBSCRIPTION_ROLE_AVATAR);
    }

    @Override // com.discord.app.AppFragment
    public void onImageCropped(Uri uri, String mimeType) {
        Intrinsics3.checkNotNullParameter(uri, NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        super.onImageCropped(uri, mimeType);
        MGImages.requestDataUrl(getContext(), uri, mimeType, this.memberBadgeImageSelectedResult);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().g.configureUI(AnonymousClass1.INSTANCE, new AnonymousClass2());
        getViewModel().setDefaultMemberColor(getDefaultColor());
        TextView textView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildRoleSubscriptionTierAppearanceTitle");
        textView.setVisibility(getHideHeader() ^ true ? 0 : 8);
        if (getHideHeader()) {
            getBinding().e.setPadding(0, DimenUtils.dpToPixels(16), 0, 0);
            return;
        }
        TextView textView2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildRoleSubscri…ionTierAppearanceSubtitle");
        textView2.setPadding(0, 0, 0, 0);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetGuildRoleSubscriptionTierDesign.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
