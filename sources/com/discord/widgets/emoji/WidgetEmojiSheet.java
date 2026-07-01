package com.discord.widgets.emoji;

import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
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
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.guild.GuildFeature;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetEmojiSheetBinding;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.KotlinExtensions;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.locale.LocaleManager;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.emoji.EmojiSheetViewModel;
import com.discord.widgets.settings.premium.WidgetSettingsPremium;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.text.NumberFormat;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import org.objectweb.asm.Opcodes;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: WidgetEmojiSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetEmojiSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEmojiSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_EMOJI_ID_AND_TYPE = "EXTRA_EMOJI_ID_AND_TYPE";
    private static final int FLIPPER_INDEX_CONTENT = 0;
    private static final int FLIPPER_INDEX_LOADING = 1;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: emojiIdAndType$delegate, reason: from kotlin metadata */
    private final Lazy emojiIdAndType;
    private final int emojiSizePx;
    private final MGImages.DistinctChangeDetector imageChangeDetector;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetEmojiSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        private final String getNoticeName(EmojiNode.EmojiIdAndType emojiIdAndType) {
            String str = "Emoji Sheet: " + emojiIdAndType.toString();
            Intrinsics3.checkNotNullExpressionValue(str, "StringBuilder(\"Emoji She…)\n            .toString()");
            return str;
        }

        public final void enqueueNotice(EmojiNode.EmojiIdAndType emojiIdAndType) {
            Intrinsics3.checkNotNullParameter(emojiIdAndType, "emojiIdAndType");
            String noticeName = getNoticeName(emojiIdAndType);
            StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice(noticeName, null, 0L, 0, false, null, 0L, false, 0L, new WidgetEmojiSheet2(emojiIdAndType, noticeName), Opcodes.INVOKEVIRTUAL, null));
        }

        public final void show(FragmentManager fragmentManager, EmojiNode.EmojiIdAndType emojiIdAndType) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(emojiIdAndType, "emojiIdAndType");
            WidgetEmojiSheet widgetEmojiSheet = new WidgetEmojiSheet();
            Bundle bundle = new Bundle();
            bundle.putSerializable(WidgetEmojiSheet.EXTRA_EMOJI_ID_AND_TYPE, emojiIdAndType);
            widgetEmojiSheet.setArguments(bundle);
            widgetEmojiSheet.show(fragmentManager, WidgetEmojiSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.emoji.WidgetEmojiSheet$bindSubscriptions$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetEmojiSheet.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<EmojiSheetViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(EmojiSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(EmojiSheetViewModel.ViewState viewState) {
            Unit unit;
            Intrinsics3.checkNotNullParameter(viewState, "it");
            if (Intrinsics3.areEqual(viewState, EmojiSheetViewModel.ViewState.Loading.INSTANCE)) {
                WidgetEmojiSheet.this.showLoading();
                unit = Unit.a;
            } else if (viewState instanceof EmojiSheetViewModel.ViewState.EmojiCustom) {
                WidgetEmojiSheet.this.configureCustomEmoji((EmojiSheetViewModel.ViewState.EmojiCustom) viewState);
                unit = Unit.a;
            } else if (viewState instanceof EmojiSheetViewModel.ViewState.EmojiUnicode) {
                WidgetEmojiSheet.this.configureUnicodeEmoji((EmojiSheetViewModel.ViewState.EmojiUnicode) viewState);
                unit = Unit.a;
            } else {
                if (!Intrinsics3.areEqual(viewState, EmojiSheetViewModel.ViewState.Invalid.INSTANCE) && !Intrinsics3.areEqual(viewState, EmojiSheetViewModel.ViewState.Dismiss.INSTANCE)) {
                    throw new NoWhenBranchMatchedException();
                }
                WidgetEmojiSheet.this.dismiss();
                unit = Unit.a;
            }
            KotlinExtensions.getExhaustive(unit);
        }
    }

    public WidgetEmojiSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetEmojiSheet3.INSTANCE, null, 2, null);
        this.emojiSizePx = IconUtils.getMediaProxySize(DimenUtils.dpToPixels(48));
        this.imageChangeDetector = new MGImages.DistinctChangeDetector();
        WidgetEmojiSheet9 widgetEmojiSheet9 = new WidgetEmojiSheet9(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(EmojiSheetViewModel.class), new WidgetEmojiSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetEmojiSheet9));
        this.emojiIdAndType = LazyJVM.lazy(new WidgetEmojiSheet8(this));
    }

    private final void configureButtons(final boolean isUserPremium, final boolean isUserInGuild, final Guild guild) {
        WidgetEmojiSheetBinding binding = getBinding();
        if (guild == null) {
            FrameLayout frameLayout = binding.f2377b;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "buttonContainer");
            frameLayout.setVisibility(8);
            return;
        }
        if (!isUserPremium) {
            FrameLayout frameLayout2 = binding.f2377b;
            Intrinsics3.checkNotNullExpressionValue(frameLayout2, "buttonContainer");
            frameLayout2.setVisibility(0);
            MaterialButton materialButton = binding.q;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "premiumBtn");
            materialButton.setVisibility(0);
            MaterialButton materialButton2 = binding.o;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "joinBtn");
            materialButton2.setVisibility(8);
            binding.q.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.emoji.WidgetEmojiSheet$configureButtons$$inlined$with$lambda$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.this$0.dismiss();
                    WidgetSettingsPremium.Companion companion = WidgetSettingsPremium.INSTANCE;
                    Context contextRequireContext = this.this$0.requireContext();
                    Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                    WidgetSettingsPremium.Companion.launch$default(companion, contextRequireContext, null, Traits.Location.Section.EMOJI_SHEET_UPSELL, 2, null);
                }
            });
            return;
        }
        if (isUserInGuild) {
            FrameLayout frameLayout3 = binding.f2377b;
            Intrinsics3.checkNotNullExpressionValue(frameLayout3, "buttonContainer");
            frameLayout3.setVisibility(8);
            return;
        }
        FrameLayout frameLayout4 = binding.f2377b;
        Intrinsics3.checkNotNullExpressionValue(frameLayout4, "buttonContainer");
        frameLayout4.setVisibility(0);
        MaterialButton materialButton3 = binding.q;
        Intrinsics3.checkNotNullExpressionValue(materialButton3, "premiumBtn");
        materialButton3.setVisibility(8);
        MaterialButton materialButton4 = binding.o;
        Intrinsics3.checkNotNullExpressionValue(materialButton4, "joinBtn");
        materialButton4.setVisibility(0);
        binding.o.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.emoji.WidgetEmojiSheet$configureButtons$$inlined$with$lambda$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.this$0.getViewModel().joinGuild(guild, this.this$0);
            }
        });
    }

    private final void configureCustomEmoji(EmojiSheetViewModel.ViewState.EmojiCustom viewState) {
        WidgetEmojiSheetBinding binding = getBinding();
        Intrinsics3.checkNotNullExpressionValue(binding, "binding");
        AppViewFlipper appViewFlipper = binding.a;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.root");
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
        EmojiSheetViewModel.Companion.CustomEmojGuildInfo emojiGuildInfo = viewState.getEmojiGuildInfo();
        if (!(emojiGuildInfo instanceof EmojiSheetViewModel.Companion.CustomEmojGuildInfo.Known)) {
            emojiGuildInfo = null;
        }
        EmojiSheetViewModel.Companion.CustomEmojGuildInfo.Known known = (EmojiSheetViewModel.Companion.CustomEmojGuildInfo.Known) emojiGuildInfo;
        boolean zIsPublic = viewState.getEmojiGuildInfo().getIsPublic();
        boolean zIsUserInGuild = viewState.getEmojiGuildInfo().getIsUserInGuild();
        EmojiNode.EmojiIdAndType.Custom emojiCustom = viewState.getEmojiCustom();
        boolean zIsUserPremium = viewState.isUserPremium();
        boolean zIsCurrentGuild = viewState.isCurrentGuild();
        WidgetEmojiSheetBinding binding2 = getBinding();
        SimpleDraweeView simpleDraweeView = binding2.d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "emojiIv");
        MGImages.setImage$default(simpleDraweeView, ModelEmojiCustom.getImageUri(emojiCustom.getId(), emojiCustom.isAnimated(), this.emojiSizePx), 0, 0, false, null, this.imageChangeDetector, 60, null);
        TextView textView = binding2.p;
        Intrinsics3.checkNotNullExpressionValue(textView, "nameTv");
        textView.setText(MentionUtils.EMOJIS_AND_STICKERS_CHAR + emojiCustom.getName() + MentionUtils.EMOJIS_AND_STICKERS_CHAR);
        TextView textView2 = binding2.c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "emojiInfoTv");
        textView2.setText(getString(getCustomEmojiInfoText(zIsCurrentGuild, zIsUserInGuild, zIsPublic, zIsUserPremium)));
        configureButtons(zIsUserPremium, zIsUserInGuild, known != null ? known.getGuild() : null);
        configureGuildSection(known != null ? known.getGuild() : null, zIsCurrentGuild, zIsPublic, known != null ? known.getApproximateOnline() : null);
        configureFavorite(viewState.getCanFavorite(), viewState.isFavorite());
        AppViewFlipper appViewFlipper2 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.emojiSheetFlipper");
        appViewFlipper2.setDisplayedChild(0);
    }

    private final void configureFavorite(boolean canFavorite, final boolean isFavorite) {
        FrameLayout frameLayout = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.favoriteContainer");
        frameLayout.setVisibility(canFavorite ? 0 : 8);
        MaterialButton materialButton = getBinding().f;
        ViewExtensions.fadeBy(materialButton, !isFavorite, 200L);
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.emoji.WidgetEmojiSheet$configureFavorite$$inlined$apply$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.this$0.getViewModel().setFavorite(true);
            }
        });
        MaterialButton materialButton2 = getBinding().h;
        ViewExtensions.fadeBy(materialButton2, isFavorite, 200L);
        materialButton2.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.emoji.WidgetEmojiSheet$configureFavorite$$inlined$apply$lambda$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.this$0.getViewModel().setFavorite(false);
            }
        });
    }

    private final void configureGuildSection(Guild guild, boolean isCurrent, boolean isPublic, Integer approximateOnline) {
        int i;
        WidgetEmojiSheetBinding binding = getBinding();
        if (guild == null || isCurrent) {
            LinearLayout linearLayout = binding.k;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "guildContainer");
            linearLayout.setVisibility(8);
            return;
        }
        LinearLayout linearLayout2 = binding.k;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "guildContainer");
        linearLayout2.setVisibility(0);
        if (guild.hasIcon()) {
            SimpleDraweeView simpleDraweeView = binding.m;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "guildIv");
            IconUtils.setIcon$default((ImageView) simpleDraweeView, guild, 0, (MGImages.ChangeDetector) this.imageChangeDetector, true, 4, (Object) null);
        } else {
            binding.j.setBackgroundResource(R.drawable.drawable_circle_black);
            int themedColor = ColorCompat.getThemedColor(requireContext(), R.attr.colorBackgroundSecondary);
            FrameLayout frameLayout = binding.j;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "guildAvatarWrap");
            frameLayout.setBackgroundTintList(ColorStateList.valueOf(themedColor));
            TextView textView = binding.i;
            Intrinsics3.checkNotNullExpressionValue(textView, "guildAvatarText");
            textView.setText(guild.getShortName());
        }
        if (guild.getFeatures().contains(GuildFeature.PARTNERED)) {
            i = R.drawable.ic_partnered_badge_banner;
        } else {
            i = guild.getFeatures().contains(GuildFeature.VERIFIED) ? R.drawable.ic_verified_badge_banner : 0;
        }
        TextView textView2 = binding.n;
        Intrinsics3.checkNotNullExpressionValue(textView2, "guildNameTv");
        DrawableCompat.setCompoundDrawablesCompat(textView2, i, 0, 0, 0);
        TextView textView3 = binding.n;
        Intrinsics3.checkNotNullExpressionValue(textView3, "guildNameTv");
        textView3.setText(guild.getName());
        int i2 = isPublic ? R.string.emoji_popout_public_server : R.string.emoji_popout_private_server;
        String str = null;
        CharSequence charSequenceE = FormatUtils.e(this, i2, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null);
        if (approximateOnline != null) {
            str = FormatUtils.e(this, R.string.instant_invite_guild_members_online, new Object[]{NumberFormat.getNumberInstance(new LocaleManager().getPrimaryLocale(requireContext())).format(Integer.valueOf(approximateOnline.intValue()))}, (4 & 4) != 0 ? FormatUtils.a.j : null).toString() + " • ";
        }
        if (str == null) {
            str = "";
        }
        TextView textView4 = binding.l;
        Intrinsics3.checkNotNullExpressionValue(textView4, "guildInfoTv");
        textView4.setText(str + charSequenceE);
    }

    private final void configureUnicodeEmoji(EmojiSheetViewModel.ViewState.EmojiUnicode viewState) {
        WidgetEmojiSheetBinding binding = getBinding();
        SimpleDraweeView simpleDraweeView = binding.d;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "emojiIv");
        MGImages.setImage$default(simpleDraweeView, viewState.getEmojiUnicode().getImageUri(true, this.emojiSizePx, requireContext()), 0, 0, false, null, this.imageChangeDetector, 60, null);
        TextView textView = binding.p;
        Intrinsics3.checkNotNullExpressionValue(textView, "nameTv");
        textView.setText(MentionUtils.EMOJIS_AND_STICKERS_CHAR + viewState.getEmojiUnicode().getFirstName() + MentionUtils.EMOJIS_AND_STICKERS_CHAR);
        TextView textView2 = binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "emojiInfoTv");
        textView2.setText(getString(R.string.emoji_popout_standard_emoji_description));
        FrameLayout frameLayout = binding.f2377b;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "buttonContainer");
        frameLayout.setVisibility(8);
        LinearLayout linearLayout = binding.k;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "guildContainer");
        linearLayout.setVisibility(8);
        configureFavorite(viewState.getCanFavorite(), viewState.isFavorite());
        AppViewFlipper appViewFlipper = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.emojiSheetFlipper");
        appViewFlipper.setDisplayedChild(0);
    }

    private final WidgetEmojiSheetBinding getBinding() {
        return (WidgetEmojiSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final int getCustomEmojiInfoText(boolean isCurrentGuild, boolean isUserInGuild, boolean isGuildPublic, boolean isUserPremium) {
        if (isCurrentGuild && !isUserPremium) {
            return R.string.emoji_popout_current_guild_description;
        }
        if (isCurrentGuild && isUserPremium) {
            return R.string.emoji_popout_premium_current_guild_description;
        }
        if (isUserInGuild && !isUserPremium) {
            return R.string.emoji_popout_joined_guild_description;
        }
        if (isUserInGuild && isUserPremium) {
            return R.string.emoji_popout_premium_joined_guild_description;
        }
        if (!isGuildPublic || isUserPremium) {
            return (isGuildPublic && isUserPremium) ? R.string.emoji_popout_premium_unjoined_discoverable_guild_description : R.string.emoji_popout_premium_unjoined_private_guild_description;
        }
        return R.string.emoji_popout_unjoined_discoverable_guild_description;
    }

    private final EmojiNode.EmojiIdAndType getEmojiIdAndType() {
        return (EmojiNode.EmojiIdAndType) this.emojiIdAndType.getValue();
    }

    private final EmojiSheetViewModel getViewModel() {
        return (EmojiSheetViewModel) this.viewModel.getValue();
    }

    public static final void show(FragmentManager fragmentManager, EmojiNode.EmojiIdAndType emojiIdAndType) {
        INSTANCE.show(fragmentManager, emojiIdAndType);
    }

    private final void showLoading() {
        AppViewFlipper appViewFlipper = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.emojiSheetFlipper");
        appViewFlipper.setDisplayedChild(1);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        Intrinsics3.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetEmojiSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_emoji_sheet;
    }
}
