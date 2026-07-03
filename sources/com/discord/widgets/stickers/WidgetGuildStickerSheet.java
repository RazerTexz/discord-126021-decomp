package com.discord.widgets.stickers;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.api.guild.GuildFeature;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerType;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGuildStickerSheetBinding;
import com.discord.models.guild.Guild;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.locale.LocaleManager;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.stickers.GuildStickerSheetViewModel;
import com.discord.widgets.stickers.StickerPremiumUpsellDialog;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import java.text.NumberFormat;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: WidgetGuildStickerSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGuildStickerSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGuildStickerSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildStickerSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int VIEW_CONTENT = 0;
    private static final int VIEW_LOADING = 1;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetGuildStickerSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, Sticker sticker) {
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            C12238m.checkNotNullParameter(sticker, "sticker");
            if (sticker.getType() != StickerType.GUILD) {
                return;
            }
            WidgetGuildStickerSheet widgetGuildStickerSheet = new WidgetGuildStickerSheet();
            Bundle bundle = new Bundle();
            bundle.putSerializable("com.discord.intent.extra.EXTRA_STICKER", sticker);
            widgetGuildStickerSheet.setArguments(bundle);
            widgetGuildStickerSheet.show(fragmentManager, WidgetGuildStickerSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stickers.WidgetGuildStickerSheet$bindSubscriptions$1 */
    /* JADX INFO: compiled from: WidgetGuildStickerSheet.kt */
    public static final class C101331 extends AbstractC12240o implements Function1<GuildStickerSheetViewModel.ViewState, Unit> {
        public C101331() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildStickerSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildStickerSheetViewModel.ViewState viewState) {
            if (C12238m.areEqual(viewState, GuildStickerSheetViewModel.ViewState.Loading.INSTANCE)) {
                WidgetGuildStickerSheet.this.showLoading();
            } else if (C12238m.areEqual(viewState, GuildStickerSheetViewModel.ViewState.Dismiss.INSTANCE)) {
                WidgetGuildStickerSheet.this.dismiss();
            } else if (viewState instanceof GuildStickerSheetViewModel.ViewState.Loaded) {
                WidgetGuildStickerSheet.this.configureUI((GuildStickerSheetViewModel.ViewState.Loaded) viewState);
            }
        }
    }

    public WidgetGuildStickerSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildStickerSheet$binding$2.INSTANCE, null, 2, null);
        WidgetGuildStickerSheet$viewModel$2 widgetGuildStickerSheet$viewModel$2 = new WidgetGuildStickerSheet$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(GuildStickerSheetViewModel.class), new WidgetGuildStickerSheet$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetGuildStickerSheet$viewModel$2));
    }

    private final void configureButtons(final boolean isUserPremium, final boolean isUserInGuild, final Guild guild) {
        WidgetGuildStickerSheetBinding binding = getBinding();
        if (guild == null) {
            FrameLayout frameLayout = binding.f17058b;
            C12238m.checkNotNullExpressionValue(frameLayout, "guildStickerSheetButtonContainer");
            frameLayout.setVisibility(8);
            return;
        }
        if (!isUserPremium) {
            FrameLayout frameLayout2 = binding.f17058b;
            C12238m.checkNotNullExpressionValue(frameLayout2, "guildStickerSheetButtonContainer");
            frameLayout2.setVisibility(0);
            MaterialButton materialButton = binding.f17068l;
            C12238m.checkNotNullExpressionValue(materialButton, "guildStickerSheetPremiumBtn");
            materialButton.setVisibility(0);
            MaterialButton materialButton2 = binding.f17067k;
            C12238m.checkNotNullExpressionValue(materialButton2, "guildStickerSheetJoinBtn");
            materialButton2.setVisibility(8);
            binding.f17068l.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.stickers.WidgetGuildStickerSheet$configureButtons$$inlined$with$lambda$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.this$0.dismiss();
                    StickerPremiumUpsellDialog.Companion companion = StickerPremiumUpsellDialog.INSTANCE;
                    FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
                    C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    companion.show(parentFragmentManager, new Traits.Location(null, Traits.Location.Section.STICKER_POPOUT, null, null, null, 29, null));
                }
            });
            return;
        }
        if (isUserInGuild) {
            FrameLayout frameLayout3 = binding.f17058b;
            C12238m.checkNotNullExpressionValue(frameLayout3, "guildStickerSheetButtonContainer");
            frameLayout3.setVisibility(8);
            return;
        }
        FrameLayout frameLayout4 = binding.f17058b;
        C12238m.checkNotNullExpressionValue(frameLayout4, "guildStickerSheetButtonContainer");
        frameLayout4.setVisibility(0);
        MaterialButton materialButton3 = binding.f17068l;
        C12238m.checkNotNullExpressionValue(materialButton3, "guildStickerSheetPremiumBtn");
        materialButton3.setVisibility(8);
        MaterialButton materialButton4 = binding.f17067k;
        C12238m.checkNotNullExpressionValue(materialButton4, "guildStickerSheetJoinBtn");
        materialButton4.setVisibility(0);
        binding.f17067k.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.stickers.WidgetGuildStickerSheet$configureButtons$$inlined$with$lambda$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.this$0.getViewModel().joinGuild(guild, this.this$0);
            }
        });
    }

    private final void configureGuildSection(Guild guild, boolean isCurrentGuild, boolean isGuildPublic, Integer approximateOnline) {
        int i;
        WidgetGuildStickerSheetBinding binding = getBinding();
        if (guild == null || isCurrentGuild) {
            LinearLayout linearLayout = binding.f17061e;
            C12238m.checkNotNullExpressionValue(linearLayout, "guildStickerSheetGuildContainer");
            linearLayout.setVisibility(8);
            return;
        }
        LinearLayout linearLayout2 = binding.f17061e;
        C12238m.checkNotNullExpressionValue(linearLayout2, "guildStickerSheetGuildContainer");
        linearLayout2.setVisibility(0);
        if (guild.hasIcon()) {
            SimpleDraweeView simpleDraweeView = binding.f17062f;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "guildStickerSheetGuildIcon");
            IconUtils.setIcon$default((ImageView) simpleDraweeView, guild, 0, (MGImages.ChangeDetector) null, true, 12, (Object) null);
        } else {
            binding.f17064h.setBackgroundResource(C5419R.drawable.drawable_circle_black);
            int themedColor = ColorCompat.getThemedColor(requireContext(), C5419R.attr.colorBackgroundSecondary);
            FrameLayout frameLayout = binding.f17064h;
            C12238m.checkNotNullExpressionValue(frameLayout, "guildStickerSheetGuildIconWrapper");
            frameLayout.setBackgroundTintList(ColorStateList.valueOf(themedColor));
            TextView textView = binding.f17063g;
            C12238m.checkNotNullExpressionValue(textView, "guildStickerSheetGuildIconText");
            textView.setText(guild.getShortName());
        }
        if (guild.getFeatures().contains(GuildFeature.PARTNERED)) {
            i = C5419R.drawable.ic_partnered_badge_banner;
        } else {
            i = guild.getFeatures().contains(GuildFeature.VERIFIED) ? C5419R.drawable.ic_verified_badge_banner : 0;
        }
        TextView textView2 = binding.f17066j;
        C12238m.checkNotNullExpressionValue(textView2, "guildStickerSheetGuildName");
        DrawableCompat.setCompoundDrawablesCompat(textView2, i, 0, 0, 0);
        TextView textView3 = binding.f17066j;
        C12238m.checkNotNullExpressionValue(textView3, "guildStickerSheetGuildName");
        textView3.setText(guild.getName());
        int i2 = isGuildPublic ? C5419R.string.sticker_popout_public_server : C5419R.string.sticker_popout_private_server;
        String str = null;
        CharSequence charSequenceM213e = C1107b.m213e(this, i2, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null);
        if (approximateOnline != null) {
            str = C1107b.m213e(this, C5419R.string.instant_invite_guild_members_online, new Object[]{NumberFormat.getNumberInstance(new LocaleManager().getPrimaryLocale(requireContext())).format(Integer.valueOf(approximateOnline.intValue()))}, (4 & 4) != 0 ? C1107b.a.f1490j : null).toString() + " • ";
        }
        if (str == null) {
            str = "";
        }
        TextView textView4 = binding.f17065i;
        C12238m.checkNotNullExpressionValue(textView4, "guildStickerSheetGuildInfo");
        textView4.setText(str + charSequenceM213e);
    }

    private final void configureUI(GuildStickerSheetViewModel.ViewState.Loaded viewState) {
        Sticker stickerComponent1 = viewState.getSticker();
        boolean zComponent2 = viewState.getIsUserPremium();
        boolean zComponent3 = viewState.getIsCurrentGuild();
        boolean zIsPublic = viewState.getGuildStickerGuildInfo().getIsPublic();
        boolean zIsUserInGuild = viewState.getGuildStickerGuildInfo().getIsUserInGuild();
        GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo guildStickerGuildInfo = viewState.getGuildStickerGuildInfo();
        if (!(guildStickerGuildInfo instanceof GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo.Known)) {
            guildStickerGuildInfo = null;
        }
        GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo.Known known = (GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo.Known) guildStickerGuildInfo;
        getBinding().f17069m.m8616d(stickerComponent1, 0);
        TextView textView = getBinding().f17070n;
        C12238m.checkNotNullExpressionValue(textView, "binding.guildStickerSheetStickerName");
        textView.setText(stickerComponent1.getName());
        TextView textView2 = getBinding().f17059c;
        C12238m.checkNotNullExpressionValue(textView2, "binding.guildStickerSheetDescription");
        textView2.setText(getString(getCustomStickerInfoText(zComponent3, zIsUserInGuild, zIsPublic, zComponent2)));
        configureButtons(zComponent2, zIsUserInGuild, known != null ? known.getGuild() : null);
        configureGuildSection(known != null ? known.getGuild() : null, zComponent3, zIsPublic, known != null ? known.getApproximateOnline() : null);
        AppViewFlipper appViewFlipper = getBinding().f17060d;
        C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.guildStickerSheetFlipper");
        appViewFlipper.setDisplayedChild(0);
    }

    private final WidgetGuildStickerSheetBinding getBinding() {
        return (WidgetGuildStickerSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final int getCustomStickerInfoText(boolean isCurrentGuild, boolean isUserInGuild, boolean isGuildPublic, boolean isUserPremium) {
        if (isCurrentGuild && !isUserPremium) {
            return C5419R.string.sticker_popout_current_guild_description;
        }
        if (isCurrentGuild && isUserPremium) {
            return C5419R.string.sticker_popout_premium_current_guild_description;
        }
        if (isUserInGuild && !isUserPremium) {
            return C5419R.string.sticker_popout_joined_guild_description;
        }
        if (isUserInGuild && isUserPremium) {
            return C5419R.string.sticker_popout_premium_joined_guild_description;
        }
        if (!isGuildPublic || isUserPremium) {
            return (isGuildPublic && isUserPremium) ? C5419R.string.sticker_popout_premium_unjoined_discoverable_guild_description : C5419R.string.sticker_popout_premium_unjoined_private_guild_description;
        }
        return C5419R.string.sticker_popout_unjoined_discoverable_guild_description;
    }

    private final GuildStickerSheetViewModel getViewModel() {
        return (GuildStickerSheetViewModel) this.viewModel.getValue();
    }

    public static final void show(FragmentManager fragmentManager, Sticker sticker) {
        INSTANCE.show(fragmentManager, sticker);
    }

    private final void showLoading() {
        AppViewFlipper appViewFlipper = getBinding().f17060d;
        C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.guildStickerSheetFlipper");
        appViewFlipper.setDisplayedChild(1);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        C12238m.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        Observable observableM11112r = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(observableM11112r, (Class<?>) WidgetGuildStickerSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C101331());
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_guild_sticker_sheet;
    }
}
