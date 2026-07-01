package com.discord.widgets.emoji;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.transition.ChangeBounds;
import androidx.transition.TransitionManager;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.guild.GuildFeature;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetEmojiSheetBinding;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.guild.Guild;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.images.MGImages$DistinctChangeDetector;
import com.discord.utilities.locale.LocaleManager;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.node.EmojiNode$EmojiIdAndType;
import com.discord.utilities.textprocessing.node.EmojiNode$EmojiIdAndType$Custom;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import java.text.NumberFormat;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: WidgetEmojiSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetEmojiSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEmojiSheetBinding;", 0)};
    public static final WidgetEmojiSheet$Companion Companion = new WidgetEmojiSheet$Companion(null);
    private static final String EXTRA_EMOJI_ID_AND_TYPE = "EXTRA_EMOJI_ID_AND_TYPE";
    private static final int FLIPPER_INDEX_CONTENT = 0;
    private static final int FLIPPER_INDEX_LOADING = 1;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: emojiIdAndType$delegate, reason: from kotlin metadata */
    private final Lazy emojiIdAndType;
    private final int emojiSizePx;
    private final MGImages$DistinctChangeDetector imageChangeDetector;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetEmojiSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetEmojiSheet$binding$2.INSTANCE, null, 2, null);
        this.emojiSizePx = IconUtils.getMediaProxySize(DimenUtils.dpToPixels(48));
        this.imageChangeDetector = new MGImages$DistinctChangeDetector();
        WidgetEmojiSheet$viewModel$2 widgetEmojiSheet$viewModel$2 = new WidgetEmojiSheet$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(EmojiSheetViewModel.class), new WidgetEmojiSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetEmojiSheet$viewModel$2));
        this.emojiIdAndType = g.lazy(new WidgetEmojiSheet$emojiIdAndType$2(this));
    }

    public static final /* synthetic */ void access$configureCustomEmoji(WidgetEmojiSheet widgetEmojiSheet, EmojiSheetViewModel$ViewState$EmojiCustom emojiSheetViewModel$ViewState$EmojiCustom) {
        widgetEmojiSheet.configureCustomEmoji(emojiSheetViewModel$ViewState$EmojiCustom);
    }

    public static final /* synthetic */ void access$configureUnicodeEmoji(WidgetEmojiSheet widgetEmojiSheet, EmojiSheetViewModel$ViewState$EmojiUnicode emojiSheetViewModel$ViewState$EmojiUnicode) {
        widgetEmojiSheet.configureUnicodeEmoji(emojiSheetViewModel$ViewState$EmojiUnicode);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetEmojiSheet widgetEmojiSheet) {
        return widgetEmojiSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ EmojiNode$EmojiIdAndType access$getEmojiIdAndType$p(WidgetEmojiSheet widgetEmojiSheet) {
        return widgetEmojiSheet.getEmojiIdAndType();
    }

    public static final /* synthetic */ EmojiSheetViewModel access$getViewModel$p(WidgetEmojiSheet widgetEmojiSheet) {
        return widgetEmojiSheet.getViewModel();
    }

    public static final /* synthetic */ void access$showLoading(WidgetEmojiSheet widgetEmojiSheet) {
        widgetEmojiSheet.showLoading();
    }

    private final void configureButtons(boolean isUserPremium, boolean isUserInGuild, Guild guild) {
        WidgetEmojiSheetBinding binding = getBinding();
        if (guild == null) {
            FrameLayout frameLayout = binding.f2377b;
            m.checkNotNullExpressionValue(frameLayout, "buttonContainer");
            frameLayout.setVisibility(8);
            return;
        }
        if (!isUserPremium) {
            FrameLayout frameLayout2 = binding.f2377b;
            m.checkNotNullExpressionValue(frameLayout2, "buttonContainer");
            frameLayout2.setVisibility(0);
            MaterialButton materialButton = binding.q;
            m.checkNotNullExpressionValue(materialButton, "premiumBtn");
            materialButton.setVisibility(0);
            MaterialButton materialButton2 = binding.o;
            m.checkNotNullExpressionValue(materialButton2, "joinBtn");
            materialButton2.setVisibility(8);
            binding.q.setOnClickListener(new WidgetEmojiSheet$configureButtons$$inlined$with$lambda$1(this, guild, isUserPremium, isUserInGuild));
            return;
        }
        if (isUserInGuild) {
            FrameLayout frameLayout3 = binding.f2377b;
            m.checkNotNullExpressionValue(frameLayout3, "buttonContainer");
            frameLayout3.setVisibility(8);
            return;
        }
        FrameLayout frameLayout4 = binding.f2377b;
        m.checkNotNullExpressionValue(frameLayout4, "buttonContainer");
        frameLayout4.setVisibility(0);
        MaterialButton materialButton3 = binding.q;
        m.checkNotNullExpressionValue(materialButton3, "premiumBtn");
        materialButton3.setVisibility(8);
        MaterialButton materialButton4 = binding.o;
        m.checkNotNullExpressionValue(materialButton4, "joinBtn");
        materialButton4.setVisibility(0);
        binding.o.setOnClickListener(new WidgetEmojiSheet$configureButtons$$inlined$with$lambda$2(this, guild, isUserPremium, isUserInGuild));
    }

    private final void configureCustomEmoji(EmojiSheetViewModel$ViewState$EmojiCustom viewState) {
        WidgetEmojiSheetBinding binding = getBinding();
        m.checkNotNullExpressionValue(binding, "binding");
        AppViewFlipper appViewFlipper = binding.a;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.root");
        ViewParent parent = appViewFlipper.getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup != null) {
            ChangeBounds changeBounds = new ChangeBounds();
            changeBounds.setDuration(150L);
            TransitionManager.beginDelayedTransition(viewGroup, changeBounds);
        }
        EmojiSheetViewModel$Companion$CustomEmojGuildInfo emojiGuildInfo = viewState.getEmojiGuildInfo();
        if (!(emojiGuildInfo instanceof EmojiSheetViewModel$Companion$CustomEmojGuildInfo$Known)) {
            emojiGuildInfo = null;
        }
        EmojiSheetViewModel$Companion$CustomEmojGuildInfo$Known emojiSheetViewModel$Companion$CustomEmojGuildInfo$Known = (EmojiSheetViewModel$Companion$CustomEmojGuildInfo$Known) emojiGuildInfo;
        boolean isPublic = viewState.getEmojiGuildInfo().getIsPublic();
        boolean isUserInGuild = viewState.getEmojiGuildInfo().getIsUserInGuild();
        EmojiNode$EmojiIdAndType$Custom emojiCustom = viewState.getEmojiCustom();
        boolean zIsUserPremium = viewState.isUserPremium();
        boolean zIsCurrentGuild = viewState.isCurrentGuild();
        WidgetEmojiSheetBinding binding2 = getBinding();
        SimpleDraweeView simpleDraweeView = binding2.d;
        m.checkNotNullExpressionValue(simpleDraweeView, "emojiIv");
        MGImages.setImage$default(simpleDraweeView, ModelEmojiCustom.getImageUri(emojiCustom.getId(), emojiCustom.isAnimated(), this.emojiSizePx), 0, 0, false, null, this.imageChangeDetector, 60, null);
        TextView textView = binding2.p;
        m.checkNotNullExpressionValue(textView, "nameTv");
        textView.setText(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + emojiCustom.getName() + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
        TextView textView2 = binding2.c;
        m.checkNotNullExpressionValue(textView2, "emojiInfoTv");
        textView2.setText(getString(getCustomEmojiInfoText(zIsCurrentGuild, isUserInGuild, isPublic, zIsUserPremium)));
        configureButtons(zIsUserPremium, isUserInGuild, emojiSheetViewModel$Companion$CustomEmojGuildInfo$Known != null ? emojiSheetViewModel$Companion$CustomEmojGuildInfo$Known.getGuild() : null);
        configureGuildSection(emojiSheetViewModel$Companion$CustomEmojGuildInfo$Known != null ? emojiSheetViewModel$Companion$CustomEmojGuildInfo$Known.getGuild() : null, zIsCurrentGuild, isPublic, emojiSheetViewModel$Companion$CustomEmojGuildInfo$Known != null ? emojiSheetViewModel$Companion$CustomEmojGuildInfo$Known.getApproximateOnline() : null);
        configureFavorite(viewState.getCanFavorite(), viewState.isFavorite());
        AppViewFlipper appViewFlipper2 = getBinding().e;
        m.checkNotNullExpressionValue(appViewFlipper2, "binding.emojiSheetFlipper");
        appViewFlipper2.setDisplayedChild(0);
    }

    private final void configureFavorite(boolean canFavorite, boolean isFavorite) {
        FrameLayout frameLayout = getBinding().g;
        m.checkNotNullExpressionValue(frameLayout, "binding.favoriteContainer");
        frameLayout.setVisibility(canFavorite ? 0 : 8);
        MaterialButton materialButton = getBinding().f;
        ViewExtensions.fadeBy(materialButton, !isFavorite, 200L);
        materialButton.setOnClickListener(new WidgetEmojiSheet$configureFavorite$$inlined$apply$lambda$1(this, isFavorite));
        MaterialButton materialButton2 = getBinding().h;
        ViewExtensions.fadeBy(materialButton2, isFavorite, 200L);
        materialButton2.setOnClickListener(new WidgetEmojiSheet$configureFavorite$$inlined$apply$lambda$2(this, isFavorite));
    }

    private final void configureGuildSection(Guild guild, boolean isCurrent, boolean isPublic, Integer approximateOnline) {
        int i;
        WidgetEmojiSheetBinding binding = getBinding();
        if (guild == null || isCurrent) {
            LinearLayout linearLayout = binding.k;
            m.checkNotNullExpressionValue(linearLayout, "guildContainer");
            linearLayout.setVisibility(8);
            return;
        }
        LinearLayout linearLayout2 = binding.k;
        m.checkNotNullExpressionValue(linearLayout2, "guildContainer");
        linearLayout2.setVisibility(0);
        if (guild.hasIcon()) {
            SimpleDraweeView simpleDraweeView = binding.m;
            m.checkNotNullExpressionValue(simpleDraweeView, "guildIv");
            IconUtils.setIcon$default((ImageView) simpleDraweeView, guild, 0, (MGImages$ChangeDetector) this.imageChangeDetector, true, 4, (Object) null);
        } else {
            binding.j.setBackgroundResource(2131231172);
            int themedColor = ColorCompat.getThemedColor(requireContext(), 2130968912);
            FrameLayout frameLayout = binding.j;
            m.checkNotNullExpressionValue(frameLayout, "guildAvatarWrap");
            frameLayout.setBackgroundTintList(ColorStateList.valueOf(themedColor));
            TextView textView = binding.i;
            m.checkNotNullExpressionValue(textView, "guildAvatarText");
            textView.setText(guild.getShortName());
        }
        if (guild.getFeatures().contains(GuildFeature.PARTNERED)) {
            i = 2131231996;
        } else {
            i = guild.getFeatures().contains(GuildFeature.VERIFIED) ? 2131232242 : 0;
        }
        TextView textView2 = binding.n;
        m.checkNotNullExpressionValue(textView2, "guildNameTv");
        DrawableCompat.setCompoundDrawablesCompat(textView2, i, 0, 0, 0);
        TextView textView3 = binding.n;
        m.checkNotNullExpressionValue(textView3, "guildNameTv");
        textView3.setText(guild.getName());
        int i2 = isPublic ? 2131888790 : 2131888789;
        String str = null;
        CharSequence charSequenceK = b.k(this, i2, new Object[0], null, 4);
        if (approximateOnline != null) {
            str = b.k(this, 2131892068, new Object[]{NumberFormat.getNumberInstance(new LocaleManager().getPrimaryLocale(requireContext())).format(Integer.valueOf(approximateOnline.intValue()))}, null, 4).toString() + " • ";
        }
        if (str == null) {
            str = "";
        }
        TextView textView4 = binding.l;
        m.checkNotNullExpressionValue(textView4, "guildInfoTv");
        textView4.setText(str + charSequenceK);
    }

    private final void configureUnicodeEmoji(EmojiSheetViewModel$ViewState$EmojiUnicode viewState) {
        WidgetEmojiSheetBinding binding = getBinding();
        SimpleDraweeView simpleDraweeView = binding.d;
        m.checkNotNullExpressionValue(simpleDraweeView, "emojiIv");
        MGImages.setImage$default(simpleDraweeView, viewState.getEmojiUnicode().getImageUri(true, this.emojiSizePx, requireContext()), 0, 0, false, null, this.imageChangeDetector, 60, null);
        TextView textView = binding.p;
        m.checkNotNullExpressionValue(textView, "nameTv");
        textView.setText(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + viewState.getEmojiUnicode().getFirstName() + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
        TextView textView2 = binding.c;
        m.checkNotNullExpressionValue(textView2, "emojiInfoTv");
        textView2.setText(getString(2131888792));
        FrameLayout frameLayout = binding.f2377b;
        m.checkNotNullExpressionValue(frameLayout, "buttonContainer");
        frameLayout.setVisibility(8);
        LinearLayout linearLayout = binding.k;
        m.checkNotNullExpressionValue(linearLayout, "guildContainer");
        linearLayout.setVisibility(8);
        configureFavorite(viewState.getCanFavorite(), viewState.isFavorite());
        AppViewFlipper appViewFlipper = getBinding().e;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.emojiSheetFlipper");
        appViewFlipper.setDisplayedChild(0);
    }

    private final WidgetEmojiSheetBinding getBinding() {
        return (WidgetEmojiSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final int getCustomEmojiInfoText(boolean isCurrentGuild, boolean isUserInGuild, boolean isGuildPublic, boolean isUserPremium) {
        if (isCurrentGuild && !isUserPremium) {
            return 2131888781;
        }
        if (isCurrentGuild && isUserPremium) {
            return 2131888785;
        }
        if (isUserInGuild && !isUserPremium) {
            return 2131888782;
        }
        if (isUserInGuild && isUserPremium) {
            return 2131888786;
        }
        if (!isGuildPublic || isUserPremium) {
            return (isGuildPublic && isUserPremium) ? 2131888787 : 2131888788;
        }
        return 2131888793;
    }

    private final EmojiNode$EmojiIdAndType getEmojiIdAndType() {
        return (EmojiNode$EmojiIdAndType) this.emojiIdAndType.getValue();
    }

    private final EmojiSheetViewModel getViewModel() {
        return (EmojiSheetViewModel) this.viewModel.getValue();
    }

    public static final void show(FragmentManager fragmentManager, EmojiNode$EmojiIdAndType emojiNode$EmojiIdAndType) {
        Companion.show(fragmentManager, emojiNode$EmojiIdAndType);
    }

    private final void showLoading() {
        AppViewFlipper appViewFlipper = getBinding().e;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.emojiSheetFlipper");
        appViewFlipper.setDisplayedChild(1);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        m.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetEmojiSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetEmojiSheet$bindSubscriptions$1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_emoji_sheet;
    }
}
