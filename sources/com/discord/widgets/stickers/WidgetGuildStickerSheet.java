package com.discord.widgets.stickers;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.guild.GuildFeature;
import com.discord.api.sticker.Sticker;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGuildStickerSheetBinding;
import com.discord.models.guild.Guild;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.locale.LocaleManager;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.a0;
import d0.z.d.m;
import java.text.NumberFormat;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: WidgetGuildStickerSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildStickerSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildStickerSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildStickerSheetBinding;", 0)};
    public static final WidgetGuildStickerSheet$Companion Companion = new WidgetGuildStickerSheet$Companion(null);
    private static final int VIEW_CONTENT = 0;
    private static final int VIEW_LOADING = 1;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetGuildStickerSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildStickerSheet$binding$2.INSTANCE, null, 2, null);
        WidgetGuildStickerSheet$viewModel$2 widgetGuildStickerSheet$viewModel$2 = new WidgetGuildStickerSheet$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GuildStickerSheetViewModel.class), new WidgetGuildStickerSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildStickerSheet$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildStickerSheet widgetGuildStickerSheet, GuildStickerSheetViewModel$ViewState$Loaded guildStickerSheetViewModel$ViewState$Loaded) {
        widgetGuildStickerSheet.configureUI(guildStickerSheetViewModel$ViewState$Loaded);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetGuildStickerSheet widgetGuildStickerSheet) {
        return widgetGuildStickerSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ GuildStickerSheetViewModel access$getViewModel$p(WidgetGuildStickerSheet widgetGuildStickerSheet) {
        return widgetGuildStickerSheet.getViewModel();
    }

    public static final /* synthetic */ void access$showLoading(WidgetGuildStickerSheet widgetGuildStickerSheet) {
        widgetGuildStickerSheet.showLoading();
    }

    private final void configureButtons(boolean isUserPremium, boolean isUserInGuild, Guild guild) {
        WidgetGuildStickerSheetBinding binding = getBinding();
        if (guild == null) {
            FrameLayout frameLayout = binding.f2453b;
            m.checkNotNullExpressionValue(frameLayout, "guildStickerSheetButtonContainer");
            frameLayout.setVisibility(8);
            return;
        }
        if (!isUserPremium) {
            FrameLayout frameLayout2 = binding.f2453b;
            m.checkNotNullExpressionValue(frameLayout2, "guildStickerSheetButtonContainer");
            frameLayout2.setVisibility(0);
            MaterialButton materialButton = binding.l;
            m.checkNotNullExpressionValue(materialButton, "guildStickerSheetPremiumBtn");
            materialButton.setVisibility(0);
            MaterialButton materialButton2 = binding.k;
            m.checkNotNullExpressionValue(materialButton2, "guildStickerSheetJoinBtn");
            materialButton2.setVisibility(8);
            binding.l.setOnClickListener(new WidgetGuildStickerSheet$configureButtons$$inlined$with$lambda$1(this, guild, isUserPremium, isUserInGuild));
            return;
        }
        if (isUserInGuild) {
            FrameLayout frameLayout3 = binding.f2453b;
            m.checkNotNullExpressionValue(frameLayout3, "guildStickerSheetButtonContainer");
            frameLayout3.setVisibility(8);
            return;
        }
        FrameLayout frameLayout4 = binding.f2453b;
        m.checkNotNullExpressionValue(frameLayout4, "guildStickerSheetButtonContainer");
        frameLayout4.setVisibility(0);
        MaterialButton materialButton3 = binding.l;
        m.checkNotNullExpressionValue(materialButton3, "guildStickerSheetPremiumBtn");
        materialButton3.setVisibility(8);
        MaterialButton materialButton4 = binding.k;
        m.checkNotNullExpressionValue(materialButton4, "guildStickerSheetJoinBtn");
        materialButton4.setVisibility(0);
        binding.k.setOnClickListener(new WidgetGuildStickerSheet$configureButtons$$inlined$with$lambda$2(this, guild, isUserPremium, isUserInGuild));
    }

    private final void configureGuildSection(Guild guild, boolean isCurrentGuild, boolean isGuildPublic, Integer approximateOnline) {
        int i;
        WidgetGuildStickerSheetBinding binding = getBinding();
        if (guild == null || isCurrentGuild) {
            LinearLayout linearLayout = binding.e;
            m.checkNotNullExpressionValue(linearLayout, "guildStickerSheetGuildContainer");
            linearLayout.setVisibility(8);
            return;
        }
        LinearLayout linearLayout2 = binding.e;
        m.checkNotNullExpressionValue(linearLayout2, "guildStickerSheetGuildContainer");
        linearLayout2.setVisibility(0);
        if (guild.hasIcon()) {
            SimpleDraweeView simpleDraweeView = binding.f;
            m.checkNotNullExpressionValue(simpleDraweeView, "guildStickerSheetGuildIcon");
            IconUtils.setIcon$default((ImageView) simpleDraweeView, guild, 0, (MGImages$ChangeDetector) null, true, 12, (Object) null);
        } else {
            binding.h.setBackgroundResource(2131231172);
            int themedColor = ColorCompat.getThemedColor(requireContext(), 2130968912);
            FrameLayout frameLayout = binding.h;
            m.checkNotNullExpressionValue(frameLayout, "guildStickerSheetGuildIconWrapper");
            frameLayout.setBackgroundTintList(ColorStateList.valueOf(themedColor));
            TextView textView = binding.g;
            m.checkNotNullExpressionValue(textView, "guildStickerSheetGuildIconText");
            textView.setText(guild.getShortName());
        }
        if (guild.getFeatures().contains(GuildFeature.PARTNERED)) {
            i = 2131231996;
        } else {
            i = guild.getFeatures().contains(GuildFeature.VERIFIED) ? 2131232242 : 0;
        }
        TextView textView2 = binding.j;
        m.checkNotNullExpressionValue(textView2, "guildStickerSheetGuildName");
        DrawableCompat.setCompoundDrawablesCompat(textView2, i, 0, 0, 0);
        TextView textView3 = binding.j;
        m.checkNotNullExpressionValue(textView3, "guildStickerSheetGuildName");
        textView3.setText(guild.getName());
        int i2 = isGuildPublic ? 2131895973 : 2131895972;
        String str = null;
        CharSequence charSequenceK = b.k(this, i2, new Object[0], null, 4);
        if (approximateOnline != null) {
            str = b.k(this, 2131892068, new Object[]{NumberFormat.getNumberInstance(new LocaleManager().getPrimaryLocale(requireContext())).format(Integer.valueOf(approximateOnline.intValue()))}, null, 4).toString() + " • ";
        }
        if (str == null) {
            str = "";
        }
        TextView textView4 = binding.i;
        m.checkNotNullExpressionValue(textView4, "guildStickerSheetGuildInfo");
        textView4.setText(str + charSequenceK);
    }

    private final void configureUI(GuildStickerSheetViewModel$ViewState$Loaded viewState) {
        Sticker stickerComponent1 = viewState.getSticker();
        boolean zComponent2 = viewState.getIsUserPremium();
        boolean zComponent3 = viewState.getIsCurrentGuild();
        boolean isPublic = viewState.getGuildStickerGuildInfo().getIsPublic();
        boolean isUserInGuild = viewState.getGuildStickerGuildInfo().getIsUserInGuild();
        GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo guildStickerGuildInfo = viewState.getGuildStickerGuildInfo();
        if (!(guildStickerGuildInfo instanceof GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known)) {
            guildStickerGuildInfo = null;
        }
        GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known guildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known = (GuildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known) guildStickerGuildInfo;
        getBinding().m.d(stickerComponent1, 0);
        TextView textView = getBinding().n;
        m.checkNotNullExpressionValue(textView, "binding.guildStickerSheetStickerName");
        textView.setText(stickerComponent1.getName());
        TextView textView2 = getBinding().c;
        m.checkNotNullExpressionValue(textView2, "binding.guildStickerSheetDescription");
        textView2.setText(getString(getCustomStickerInfoText(zComponent3, isUserInGuild, isPublic, zComponent2)));
        configureButtons(zComponent2, isUserInGuild, guildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known != null ? guildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known.getGuild() : null);
        configureGuildSection(guildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known != null ? guildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known.getGuild() : null, zComponent3, isPublic, guildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known != null ? guildStickerSheetViewModel$Companion$GuildStickerGuildInfo$Known.getApproximateOnline() : null);
        AppViewFlipper appViewFlipper = getBinding().d;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.guildStickerSheetFlipper");
        appViewFlipper.setDisplayedChild(0);
    }

    private final WidgetGuildStickerSheetBinding getBinding() {
        return (WidgetGuildStickerSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final int getCustomStickerInfoText(boolean isCurrentGuild, boolean isUserInGuild, boolean isGuildPublic, boolean isUserPremium) {
        if (isCurrentGuild && !isUserPremium) {
            return 2131895960;
        }
        if (isCurrentGuild && isUserPremium) {
            return 2131895968;
        }
        if (isUserInGuild && !isUserPremium) {
            return 2131895962;
        }
        if (isUserInGuild && isUserPremium) {
            return 2131895969;
        }
        if (!isGuildPublic || isUserPremium) {
            return (isGuildPublic && isUserPremium) ? 2131895970 : 2131895971;
        }
        return 2131895975;
    }

    private final GuildStickerSheetViewModel getViewModel() {
        return (GuildStickerSheetViewModel) this.viewModel.getValue();
    }

    public static final void show(FragmentManager fragmentManager, Sticker sticker) {
        Companion.show(fragmentManager, sticker);
    }

    private final void showLoading() {
        AppViewFlipper appViewFlipper = getBinding().d;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.guildStickerSheetFlipper");
        appViewFlipper.setDisplayedChild(1);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        m.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        Observable observableR = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(observableR, WidgetGuildStickerSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildStickerSheet$bindSubscriptions$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_guild_sticker_sheet;
    }
}
