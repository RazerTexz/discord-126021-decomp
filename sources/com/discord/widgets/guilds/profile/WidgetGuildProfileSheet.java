package com.discord.widgets.guilds.profile;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetGuildHubProfileActionsBinding;
import com.discord.databinding.WidgetGuildProfileActionsBinding;
import com.discord.databinding.WidgetGuildProfileSheetBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.user.MeUser;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompatKt;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.string.StringUtilsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare$Companion;
import com.discord.widgets.guilds.leave.WidgetLeaveGuildDialog;
import com.discord.widgets.guilds.leave.WidgetLeaveGuildDialog$Companion;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.List;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetGuildProfileSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildProfileSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildProfileSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildProfileSheetBinding;", 0)};
    public static final WidgetGuildProfileSheet$Companion Companion = new WidgetGuildProfileSheet$Companion(null);
    private static final String EXTRA_FROM_UPSELL = "EXTRA_FROM_UPSELL";
    private static final int LOADED_VIEW_INDEX = 1;
    private static final int LOADING_VIEW_INDEX = 0;
    private static final int NUM_ROWS_EMOJIS = 2;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Long channelId;
    private AlertDialog dialog;
    private final WidgetGuildProfileSheetEmojisAdapter emojisAdapter;

    /* JADX INFO: renamed from: fromGuildEventUpsell$delegate, reason: from kotlin metadata */
    private final Lazy fromGuildEventUpsell;
    private WidgetGuildProfileActionsBinding guildActionBinding;
    private WidgetGuildHubProfileActionsBinding guildHubActionBinding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetGuildProfileSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildProfileSheet$binding$2.INSTANCE, null, 2, null);
        WidgetGuildProfileSheet$viewModel$2 widgetGuildProfileSheet$viewModel$2 = new WidgetGuildProfileSheet$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetGuildProfileSheetViewModel.class), new WidgetGuildProfileSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildProfileSheet$viewModel$2));
        this.fromGuildEventUpsell = g.lazy(new WidgetGuildProfileSheet$fromGuildEventUpsell$2(this));
        this.emojisAdapter = new WidgetGuildProfileSheetEmojisAdapter();
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetGuildProfileSheet widgetGuildProfileSheet) {
        return widgetGuildProfileSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ WidgetGuildProfileActionsBinding access$getGuildActionBinding$p(WidgetGuildProfileSheet widgetGuildProfileSheet) {
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding = widgetGuildProfileSheet.guildActionBinding;
        if (widgetGuildProfileActionsBinding == null) {
            m.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        return widgetGuildProfileActionsBinding;
    }

    public static final /* synthetic */ WidgetGuildHubProfileActionsBinding access$getGuildHubActionBinding$p(WidgetGuildProfileSheet widgetGuildProfileSheet) {
        WidgetGuildHubProfileActionsBinding widgetGuildHubProfileActionsBinding = widgetGuildProfileSheet.guildHubActionBinding;
        if (widgetGuildHubProfileActionsBinding == null) {
            m.throwUninitializedPropertyAccessException("guildHubActionBinding");
        }
        return widgetGuildHubProfileActionsBinding;
    }

    public static final /* synthetic */ WidgetGuildProfileSheetViewModel access$getViewModel$p(WidgetGuildProfileSheet widgetGuildProfileSheet) {
        return widgetGuildProfileSheet.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetGuildProfileSheet widgetGuildProfileSheet, WidgetGuildProfileSheetViewModel$Event widgetGuildProfileSheetViewModel$Event) {
        widgetGuildProfileSheet.handleEvent(widgetGuildProfileSheetViewModel$Event);
    }

    public static final /* synthetic */ void access$handleViewState(WidgetGuildProfileSheet widgetGuildProfileSheet, WidgetGuildProfileSheetViewModel$ViewState widgetGuildProfileSheetViewModel$ViewState) {
        widgetGuildProfileSheet.handleViewState(widgetGuildProfileSheetViewModel$ViewState);
    }

    public static final /* synthetic */ void access$launchInvite(WidgetGuildProfileSheet widgetGuildProfileSheet, long j) {
        widgetGuildProfileSheet.launchInvite(j);
    }

    public static final /* synthetic */ void access$setGuildActionBinding$p(WidgetGuildProfileSheet widgetGuildProfileSheet, WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding) {
        widgetGuildProfileSheet.guildActionBinding = widgetGuildProfileActionsBinding;
    }

    public static final /* synthetic */ void access$setGuildHubActionBinding$p(WidgetGuildProfileSheet widgetGuildProfileSheet, WidgetGuildHubProfileActionsBinding widgetGuildHubProfileActionsBinding) {
        widgetGuildProfileSheet.guildHubActionBinding = widgetGuildHubProfileActionsBinding;
    }

    public static final /* synthetic */ void access$showLeaveServerDialog(WidgetGuildProfileSheet widgetGuildProfileSheet, long j) {
        widgetGuildProfileSheet.showLeaveServerDialog(j);
    }

    private final void configureBottomActions(long guildId, Long channelId, WidgetGuildProfileSheetViewModel$BottomActions bottomActions) {
        boolean showUploadEmoji = bottomActions.getShowUploadEmoji();
        boolean showJoinServer = bottomActions.getShowJoinServer();
        boolean showViewServer = bottomActions.getShowViewServer();
        if (!showUploadEmoji && !showJoinServer && !showViewServer) {
            WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding = this.guildActionBinding;
            if (widgetGuildProfileActionsBinding == null) {
                m.throwUninitializedPropertyAccessException("guildActionBinding");
            }
            LinearLayout linearLayout = widgetGuildProfileActionsBinding.e;
            m.checkNotNullExpressionValue(linearLayout, "guildActionBinding.guildProfileSheetBottomActions");
            linearLayout.setVisibility(8);
            return;
        }
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding2 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding2 == null) {
            m.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        LinearLayout linearLayout2 = widgetGuildProfileActionsBinding2.e;
        m.checkNotNullExpressionValue(linearLayout2, "guildActionBinding.guildProfileSheetBottomActions");
        linearLayout2.setVisibility(0);
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding3 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding3 == null) {
            m.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        View view = widgetGuildProfileActionsBinding3.f2429z;
        view.setVisibility(showUploadEmoji ? 0 : 8);
        setOnClickAndDismissListener(view, new WidgetGuildProfileSheet$configureBottomActions$$inlined$apply$lambda$1(this, showUploadEmoji, guildId));
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding4 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding4 == null) {
            m.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        MaterialButton materialButton = widgetGuildProfileActionsBinding4.r;
        materialButton.setVisibility(showJoinServer ? 0 : 8);
        setOnClickAndDismissListener(materialButton, new WidgetGuildProfileSheet$configureBottomActions$$inlined$apply$lambda$2(materialButton, this, showJoinServer, guildId));
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding5 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding5 == null) {
            m.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        View view2 = widgetGuildProfileActionsBinding5.A;
        view2.setVisibility(showViewServer ? 0 : 8);
        setOnClickAndDismissListener(view2, new WidgetGuildProfileSheet$configureBottomActions$$inlined$apply$lambda$3(this, showViewServer, guildId, channelId));
        m.checkNotNullExpressionValue(view2, "guildActionBinding.guild…dId, channelId) }\n      }");
    }

    private final void configureEmojis(WidgetGuildProfileSheetViewModel$EmojisData emojisData) {
        boolean zIsPremium = emojisData.isPremium();
        boolean zIsExpanded = emojisData.isExpanded();
        List<Emoji> emojis = emojisData.getEmojis();
        int size = emojis.size();
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding == null) {
            m.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        TextView textView = widgetGuildProfileActionsBinding.o;
        m.checkNotNullExpressionValue(textView, "guildActionBinding.guildProfileSheetEmojisCount");
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        textView.setText(StringResourceUtilsKt.getQuantityString(resources, R$plurals.emojis_title_count, 2131893248, size, Integer.valueOf(size)));
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding2 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding2 == null) {
            m.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        ImageView imageView = widgetGuildProfileActionsBinding2.w;
        m.checkNotNullExpressionValue(imageView, "guildActionBinding.guild…PremiumUpsellDotSeparator");
        imageView.setVisibility(zIsPremium ^ true ? 0 : 8);
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding3 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding3 == null) {
            m.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        TextView textView2 = widgetGuildProfileActionsBinding3.f2427x;
        m.checkNotNullExpressionValue(textView2, "guildActionBinding.guild…ileSheetPremiumUpsellText");
        textView2.setVisibility(zIsPremium ^ true ? 0 : 8);
        if (size == 0) {
            WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding4 = this.guildActionBinding;
            if (widgetGuildProfileActionsBinding4 == null) {
                m.throwUninitializedPropertyAccessException("guildActionBinding");
            }
            CardView cardView = widgetGuildProfileActionsBinding4.n;
            m.checkNotNullExpressionValue(cardView, "guildActionBinding.guildProfileSheetEmojisCard");
            cardView.setVisibility(8);
            return;
        }
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding5 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding5 == null) {
            m.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        CardView cardView2 = widgetGuildProfileActionsBinding5.n;
        m.checkNotNullExpressionValue(cardView2, "guildActionBinding.guildProfileSheetEmojisCard");
        cardView2.setVisibility(0);
        int iMaxEmojisPerRow = maxEmojisPerRow();
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding6 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding6 == null) {
            m.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        RecyclerView recyclerView = widgetGuildProfileActionsBinding6.m;
        m.checkNotNullExpressionValue(recyclerView, "guildActionBinding.guildProfileSheetEmojis");
        RecyclerView$LayoutManager layoutManager = recyclerView.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        ((GridLayoutManager) layoutManager).setSpanCount(iMaxEmojisPerRow);
        this.emojisAdapter.setData(emojis, zIsExpanded ? emojis.size() : iMaxEmojisPerRow * 2);
    }

    private final void configureGuildActions(long guildId, long userId, WidgetGuildProfileSheetViewModel$Actions actions) {
        if (actions == null) {
            WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding = this.guildActionBinding;
            if (widgetGuildProfileActionsBinding == null) {
                m.throwUninitializedPropertyAccessException("guildActionBinding");
            }
            LinearLayout linearLayout = widgetGuildProfileActionsBinding.c;
            m.checkNotNullExpressionValue(linearLayout, "guildActionBinding.guildProfileSheetActions");
            linearLayout.setVisibility(8);
            return;
        }
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding2 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding2 == null) {
            m.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        LinearLayout linearLayout2 = widgetGuildProfileActionsBinding2.c;
        m.checkNotNullExpressionValue(linearLayout2, "guildActionBinding.guildProfileSheetActions");
        linearLayout2.setVisibility(0);
        boolean zIsUnread = actions.isUnread();
        boolean canManageChannels = actions.getCanManageChannels();
        boolean canManageEvents = actions.getCanManageEvents();
        String nick = actions.getNick();
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding3 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding3 == null) {
            m.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        CardView cardView = widgetGuildProfileActionsBinding3.u;
        m.checkNotNullExpressionValue(cardView, "guildActionBinding.guild…fileSheetMarkAsReadAction");
        cardView.setVisibility(zIsUnread ? 0 : 8);
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding4 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding4 == null) {
            m.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        widgetGuildProfileActionsBinding4.t.setOnClickListener(new WidgetGuildProfileSheet$configureGuildActions$1(this, guildId));
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding5 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding5 == null) {
            m.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        CardView cardView2 = widgetGuildProfileActionsBinding5.f2428y;
        m.checkNotNullExpressionValue(cardView2, "guildActionBinding.guildProfileSheetPrimaryActions");
        cardView2.setVisibility(canManageChannels || canManageEvents ? 0 : 8);
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding6 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding6 == null) {
            m.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        TextView textView = widgetGuildProfileActionsBinding6.h;
        textView.setVisibility(canManageChannels ? 0 : 8);
        setOnClickAndDismissListener(textView, new WidgetGuildProfileSheet$configureGuildActions$$inlined$apply$lambda$1(textView, this, canManageChannels, guildId));
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding7 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding7 == null) {
            m.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        TextView textView2 = widgetGuildProfileActionsBinding7.i;
        textView2.setVisibility(canManageChannels ? 0 : 8);
        setOnClickAndDismissListener(textView2, new WidgetGuildProfileSheet$configureGuildActions$$inlined$apply$lambda$2(textView2, this, canManageChannels, guildId));
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding8 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding8 == null) {
            m.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        ConstraintLayout constraintLayout = widgetGuildProfileActionsBinding8.j;
        constraintLayout.setVisibility(canManageEvents ? 0 : 8);
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding9 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding9 == null) {
            m.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        TextView textView3 = widgetGuildProfileActionsBinding9.k;
        m.checkNotNullExpressionValue(textView3, "guildActionBinding.guildProfileSheetCreateEventNew");
        textView3.setVisibility(getFromGuildEventUpsell() ? 0 : 8);
        setOnClickAndDismissListener(constraintLayout, new WidgetGuildProfileSheet$configureGuildActions$$inlined$apply$lambda$3(constraintLayout, this, canManageEvents, guildId));
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding10 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding10 == null) {
            m.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        setOnClickAndDismissListener(widgetGuildProfileActionsBinding10.f2425b, new WidgetGuildProfileSheet$configureGuildActions$$inlined$apply$lambda$4(this, guildId));
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding11 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding11 == null) {
            m.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        TextView textView4 = widgetGuildProfileActionsBinding11.v;
        textView4.setVisibility(actions.getDisplayGuildIdentityRow() ? 0 : 8);
        if (nick == null) {
            nick = actions.getUsername();
        }
        textView4.setText(nick);
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding12 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding12 == null) {
            m.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        SimpleDraweeView simpleDraweeView = widgetGuildProfileActionsBinding12.p;
        String guildAvatar = actions.getGuildAvatar();
        simpleDraweeView.setVisibility((guildAvatar == null || guildAvatar.length() == 0) ^ true ? 0 : 8);
        simpleDraweeView.setImageURI(IconUtils.INSTANCE.getForGuildMember(actions.getGuildAvatar(), guildId, userId, Integer.valueOf(DimenUtils.dpToPixels(16)), false));
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding13 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding13 == null) {
            m.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        LinearLayout linearLayout3 = widgetGuildProfileActionsBinding13.B;
        m.checkNotNullExpressionValue(linearLayout3, "guildActionBinding.perGuildIdentityContainer");
        linearLayout3.setVisibility(actions.getDisplayGuildIdentityRow() ? 0 : 8);
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding14 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding14 == null) {
            m.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        CheckedSetting checkedSetting = widgetGuildProfileActionsBinding14.d;
        checkedSetting.setChecked(actions.isAllowDMChecked());
        checkedSetting.setOnCheckedListener(new WidgetGuildProfileSheet$configureGuildActions$$inlined$apply$lambda$5(this, actions, guildId));
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding15 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding15 == null) {
            m.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        CheckedSetting checkedSetting2 = widgetGuildProfileActionsBinding15.q;
        checkedSetting2.setChecked(actions.getHideMutedChannels());
        checkedSetting2.setOnCheckedListener(new WidgetGuildProfileSheet$configureGuildActions$$inlined$apply$lambda$6(this, actions, guildId));
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding16 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding16 == null) {
            m.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        View view = widgetGuildProfileActionsBinding16.f2426s;
        view.setVisibility(actions.getCanLeaveGuild() ? 0 : 8);
        setOnClickAndDismissListener(view, new WidgetGuildProfileSheet$configureGuildActions$$inlined$apply$lambda$7(this, actions, guildId));
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding17 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding17 == null) {
            m.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        CardView cardView3 = widgetGuildProfileActionsBinding17.l;
        m.checkNotNullExpressionValue(cardView3, "guildActionBinding.guild…fileSheetDeveloperActions");
        cardView3.setVisibility(actions.isDeveloper() ? 0 : 8);
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding18 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding18 == null) {
            m.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        widgetGuildProfileActionsBinding18.g.setOnClickListener(new WidgetGuildProfileSheet$configureGuildActions$11(this, guildId));
    }

    private final void configureGuildBanner(WidgetGuildProfileSheetViewModel$Banner guildBanner) {
        String bannerForGuild$default;
        if (guildBanner.getHash() == null) {
            SimpleDraweeView simpleDraweeView = getBinding().f2431b;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildProfileSheetBanner");
            simpleDraweeView.setVisibility(8);
            constrainIconToParent();
            return;
        }
        int iOrdinal = guildBanner.getType().ordinal();
        if (iOrdinal == 0) {
            bannerForGuild$default = IconUtils.getBannerForGuild$default(IconUtils.INSTANCE, Long.valueOf(guildBanner.getGuildId()), guildBanner.getHash(), Integer.valueOf(getResources().getDimensionPixelSize(2131165700)), false, 8, null);
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            bannerForGuild$default = IconUtils.INSTANCE.getGuildSplashUrl(guildBanner.getGuildId(), guildBanner.getHash(), Integer.valueOf(getResources().getDimensionPixelSize(2131165700)));
        }
        SimpleDraweeView simpleDraweeView2 = getBinding().f2431b;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.guildProfileSheetBanner");
        MGImages.setImage$default(simpleDraweeView2, bannerForGuild$default, 0, 0, false, null, null, 124, null);
        SimpleDraweeView simpleDraweeView3 = getBinding().f2431b;
        m.checkNotNullExpressionValue(simpleDraweeView3, "binding.guildProfileSheetBanner");
        simpleDraweeView3.setVisibility(0);
        constrainIconToBanner();
    }

    /* JADX WARN: Code duplicated, block: B:10:0x003a  */
    private final void configureGuildContent(String name, String description, Integer verifiedPartneredIconRes) {
        TextView textView = getBinding().o;
        m.checkNotNullExpressionValue(textView, "binding.guildProfileSheetName");
        textView.setText(name);
        if (description == null) {
            TextView textView2 = getBinding().f;
            m.checkNotNullExpressionValue(textView2, "binding.guildProfileSheetDescription");
            textView2.setVisibility(8);
        } else {
            if (description.length() > 0) {
                TextView textView3 = getBinding().f;
                m.checkNotNullExpressionValue(textView3, "binding.guildProfileSheetDescription");
                textView3.setText(description);
                TextView textView4 = getBinding().f;
                m.checkNotNullExpressionValue(textView4, "binding.guildProfileSheetDescription");
                textView4.setVisibility(0);
            } else {
                TextView textView5 = getBinding().f;
                m.checkNotNullExpressionValue(textView5, "binding.guildProfileSheetDescription");
                textView5.setVisibility(8);
            }
        }
        if (verifiedPartneredIconRes == null) {
            ImageView imageView = getBinding().h;
            m.checkNotNullExpressionValue(imageView, "binding.guildProfileSheetGuildVerifiedPremiumIcon");
            imageView.setVisibility(8);
        } else {
            getBinding().h.setImageResource(verifiedPartneredIconRes.intValue());
            ImageView imageView2 = getBinding().h;
            m.checkNotNullExpressionValue(imageView2, "binding.guildProfileSheetGuildVerifiedPremiumIcon");
            imageView2.setVisibility(0);
        }
    }

    private final void configureGuildHubActions(long guildId, long userId, WidgetGuildProfileSheetViewModel$Actions actions) {
        if (actions != null) {
            WidgetGuildHubProfileActionsBinding widgetGuildHubProfileActionsBinding = this.guildHubActionBinding;
            if (widgetGuildHubProfileActionsBinding == null) {
                m.throwUninitializedPropertyAccessException("guildHubActionBinding");
            }
            widgetGuildHubProfileActionsBinding.d.setOnClickListener(new WidgetGuildProfileSheet$configureGuildHubActions$1(this, guildId));
            WidgetGuildHubProfileActionsBinding widgetGuildHubProfileActionsBinding2 = this.guildHubActionBinding;
            if (widgetGuildHubProfileActionsBinding2 == null) {
                m.throwUninitializedPropertyAccessException("guildHubActionBinding");
            }
            View view = widgetGuildHubProfileActionsBinding2.f2414b;
            m.checkNotNullExpressionValue(view, "guildHubActionBinding.gu…rofileSheetChangeNickname");
            setOnClickAndDismissListener(view, new WidgetGuildProfileSheet$configureGuildHubActions$2(guildId));
            WidgetGuildHubProfileActionsBinding widgetGuildHubProfileActionsBinding3 = this.guildHubActionBinding;
            if (widgetGuildHubProfileActionsBinding3 == null) {
                m.throwUninitializedPropertyAccessException("guildHubActionBinding");
            }
            TextView textView = widgetGuildHubProfileActionsBinding3.f;
            textView.setVisibility(actions.getDisplayGuildIdentityRow() ? 0 : 8);
            String nick = actions.getNick();
            if (nick == null) {
                nick = actions.getUsername();
            }
            textView.setText(nick);
            WidgetGuildHubProfileActionsBinding widgetGuildHubProfileActionsBinding4 = this.guildHubActionBinding;
            if (widgetGuildHubProfileActionsBinding4 == null) {
                m.throwUninitializedPropertyAccessException("guildHubActionBinding");
            }
            SimpleDraweeView simpleDraweeView = widgetGuildHubProfileActionsBinding4.c;
            String guildAvatar = actions.getGuildAvatar();
            simpleDraweeView.setVisibility((guildAvatar == null || guildAvatar.length() == 0) ^ true ? 0 : 8);
            simpleDraweeView.setImageURI(IconUtils.INSTANCE.getForGuildMember(actions.getGuildAvatar(), guildId, userId, Integer.valueOf(DimenUtils.dpToPixels(16)), false));
            WidgetGuildHubProfileActionsBinding widgetGuildHubProfileActionsBinding5 = this.guildHubActionBinding;
            if (widgetGuildHubProfileActionsBinding5 == null) {
                m.throwUninitializedPropertyAccessException("guildHubActionBinding");
            }
            View view2 = widgetGuildHubProfileActionsBinding5.e;
            view2.setVisibility(actions.getCanLeaveGuild() ? 0 : 8);
            setOnClickAndDismissListener(view2, new WidgetGuildProfileSheet$configureGuildHubActions$$inlined$apply$lambda$1(this, actions, guildId));
            WidgetGuildHubProfileActionsBinding widgetGuildHubProfileActionsBinding6 = this.guildHubActionBinding;
            if (widgetGuildHubProfileActionsBinding6 == null) {
                m.throwUninitializedPropertyAccessException("guildHubActionBinding");
            }
            TextView textView2 = widgetGuildHubProfileActionsBinding6.g;
            textView2.setVisibility(0);
            setOnClickAndDismissListener(textView2, new WidgetGuildProfileSheet$configureGuildHubActions$$inlined$apply$lambda$2(textView2, this, guildId));
        }
    }

    private final void configureGuildIcon(long guildId, String iconHash, String shortName) {
        String forGuild$default = IconUtils.getForGuild$default(Long.valueOf(guildId), iconHash, null, true, Integer.valueOf(IconUtils.getMediaProxySize(getResources().getDimensionPixelSize(2131165302))), 4, null);
        if (forGuild$default != null) {
            TextView textView = getBinding().k;
            m.checkNotNullExpressionValue(textView, "binding.guildProfileSheetIconName");
            textView.setVisibility(8);
            SimpleDraweeView simpleDraweeView = getBinding().i;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildProfileSheetIcon");
            IconUtils.setIcon$default(simpleDraweeView, forGuild$default, 0, (Function1) null, (MGImages$ChangeDetector) null, 28, (Object) null);
            return;
        }
        SimpleDraweeView simpleDraweeView2 = getBinding().i;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.guildProfileSheetIcon");
        IconUtils.setIcon$default(simpleDraweeView2, IconUtils.DEFAULT_ICON_BLURPLE, 0, (Function1) null, (MGImages$ChangeDetector) null, 28, (Object) null);
        TextView textView2 = getBinding().k;
        m.checkNotNullExpressionValue(textView2, "binding.guildProfileSheetIconName");
        textView2.setVisibility(0);
        TextView textView3 = getBinding().k;
        m.checkNotNullExpressionValue(textView3, "binding.guildProfileSheetIconName");
        textView3.setText(shortName);
    }

    private final void configureMemberCount(Integer approximatePresenceCount, Integer approximateMemberCount) {
        if (approximatePresenceCount != null) {
            LinearLayout linearLayout = getBinding().q;
            m.checkNotNullExpressionValue(linearLayout, "binding.guildProfileSheetOnlineCount");
            linearLayout.setVisibility(0);
            TextView textView = getBinding().r;
            m.checkNotNullExpressionValue(textView, "binding.guildProfileSheetOnlineCountText");
            int iIntValue = approximatePresenceCount.intValue();
            LinearLayout linearLayout2 = getBinding().q;
            m.checkNotNullExpressionValue(linearLayout2, "binding.guildProfileSheetOnlineCount");
            Context context = linearLayout2.getContext();
            m.checkNotNullExpressionValue(context, "binding.guildProfileSheetOnlineCount.context");
            b.n(textView, 2131892068, new Object[]{StringUtilsKt.format(iIntValue, context)}, null, 4);
        } else {
            LinearLayout linearLayout3 = getBinding().q;
            m.checkNotNullExpressionValue(linearLayout3, "binding.guildProfileSheetOnlineCount");
            linearLayout3.setVisibility(8);
        }
        if (approximateMemberCount == null) {
            LinearLayout linearLayout4 = getBinding().m;
            m.checkNotNullExpressionValue(linearLayout4, "binding.guildProfileSheetMemberCount");
            linearLayout4.setVisibility(8);
            return;
        }
        LinearLayout linearLayout5 = getBinding().m;
        m.checkNotNullExpressionValue(linearLayout5, "binding.guildProfileSheetMemberCount");
        linearLayout5.setVisibility(0);
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        CharSequence quantityString = StringResourceUtilsKt.getQuantityString(resources, contextRequireContext, R$plurals.instant_invite_guild_members_total_count, approximateMemberCount.intValue(), approximateMemberCount);
        TextView textView2 = getBinding().n;
        m.checkNotNullExpressionValue(textView2, "binding.guildProfileSheetMemberCountText");
        b.n(textView2, 2131892069, new Object[]{quantityString}, null, 4);
    }

    private final void configureTabItems(long guildId, WidgetGuildProfileSheetViewModel$TabItems tabItems, boolean isGuildHub) {
        if (tabItems == null || isGuildHub) {
            LinearLayout linearLayout = getBinding().t;
            m.checkNotNullExpressionValue(linearLayout, "binding.guildProfileSheetTabItems");
            linearLayout.setVisibility(8);
            View view = getBinding().e;
            m.checkNotNullExpressionValue(view, "binding.guildProfileShee…entContainerBottomDivider");
            view.setVisibility(8);
            return;
        }
        boolean canAccessSettings = tabItems.getCanAccessSettings();
        boolean ableToInstantInvite = tabItems.getAbleToInstantInvite();
        int premiumSubscriptionCount = tabItems.getPremiumSubscriptionCount();
        LinearLayout linearLayout2 = getBinding().t;
        m.checkNotNullExpressionValue(linearLayout2, "binding.guildProfileSheetTabItems");
        linearLayout2.setVisibility(0);
        View view2 = getBinding().e;
        m.checkNotNullExpressionValue(view2, "binding.guildProfileShee…entContainerBottomDivider");
        view2.setVisibility(0);
        int themedColor = ColorCompat.getThemedColor(this, 2130969008);
        MaterialButton materialButton = getBinding().c;
        Resources resources = materialButton.getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        materialButton.setText(StringResourceUtilsKt.getQuantityString(resources, R$plurals.premium_guild_perks_modal_header_subscription_count_subscriptions, 2131894081, premiumSubscriptionCount, Integer.valueOf(premiumSubscriptionCount)));
        materialButton.setTextColor(themedColor);
        setOnClickAndDismissListener(materialButton, new WidgetGuildProfileSheet$configureTabItems$$inlined$apply$lambda$1(this, premiumSubscriptionCount, themedColor, guildId));
        MaterialButton materialButton2 = getBinding().p;
        ColorCompatKt.setDrawableColor(materialButton2, themedColor);
        materialButton2.setTextColor(themedColor);
        setOnClickAndDismissListener(materialButton2, new WidgetGuildProfileSheet$configureTabItems$$inlined$apply$lambda$2(this, themedColor, guildId));
        MaterialButton materialButton3 = getBinding().f2432s;
        materialButton3.setVisibility(canAccessSettings ? 0 : 8);
        ColorCompatKt.setDrawableColor(materialButton3, themedColor);
        materialButton3.setTextColor(themedColor);
        setOnClickAndDismissListener(materialButton3, new WidgetGuildProfileSheet$configureTabItems$$inlined$apply$lambda$3(this, canAccessSettings, themedColor, guildId));
        MaterialButton materialButton4 = getBinding().l;
        materialButton4.setVisibility(ableToInstantInvite ? 0 : 8);
        ColorCompatKt.setDrawableColor(materialButton4, themedColor);
        materialButton4.setTextColor(themedColor);
        setOnClickAndDismissListener(materialButton4, new WidgetGuildProfileSheet$configureTabItems$$inlined$apply$lambda$4(this, ableToInstantInvite, themedColor, guildId));
        m.checkNotNullExpressionValue(materialButton4, "binding.guildProfileShee…Invite(guildId) }\n      }");
    }

    /* JADX WARN: Code duplicated, block: B:127:0x0347  */
    /* JADX WARN: Code duplicated, block: B:128:0x0354  */
    private final void configureUI(WidgetGuildProfileSheetViewModel$ViewState$Loaded viewState) {
        WidgetGuildProfileSheetViewModel$Actions widgetGuildProfileSheetViewModel$Actions;
        int i;
        int i2;
        long guildId = viewState.getGuildId();
        String guildName = viewState.getGuildName();
        String guildShortName = viewState.getGuildShortName();
        String guildIcon = viewState.getGuildIcon();
        String guildDescription = viewState.getGuildDescription();
        Integer verifiedPartneredIconRes = viewState.getVerifiedPartneredIconRes();
        WidgetGuildProfileSheetViewModel$Banner banner = viewState.getBanner();
        Integer onlineCount = viewState.getOnlineCount();
        Integer memberCount = viewState.getMemberCount();
        WidgetGuildProfileSheetViewModel$TabItems tabItems = viewState.getTabItems();
        WidgetGuildProfileSheetViewModel$Actions actions = viewState.getActions();
        WidgetGuildProfileSheetViewModel$EmojisData emojisData = viewState.getEmojisData();
        WidgetGuildProfileSheetViewModel$BottomActions bottomActions = viewState.getBottomActions();
        boolean isGuildHub = viewState.getIsGuildHub();
        MeUser meUser = viewState.getMeUser();
        if (isGuildHub && this.guildHubActionBinding == null) {
            View viewInflate = getBinding().u.inflate();
            widgetGuildProfileSheetViewModel$Actions = actions;
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R$id.guild_profile_sheet_actions);
            if (linearLayout != null) {
                LinearLayout linearLayout2 = (LinearLayout) viewInflate;
                LinearLayout linearLayout3 = (LinearLayout) viewInflate.findViewById(R$id.guild_profile_sheet_change_nickname);
                if (linearLayout3 != null) {
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R$id.guild_profile_sheet_guild_avatar);
                    if (simpleDraweeView != null) {
                        i2 = R$id.guild_profile_sheet_invite;
                        TextView textView = (TextView) viewInflate.findViewById(R$id.guild_profile_sheet_invite);
                        if (textView != null) {
                            CardView cardView = (CardView) viewInflate.findViewById(R$id.guild_profile_sheet_invite_action);
                            if (cardView != null) {
                                TextView textView2 = (TextView) viewInflate.findViewById(R$id.guild_profile_sheet_leave_server);
                                if (textView2 != null) {
                                    TextView textView3 = (TextView) viewInflate.findViewById(R$id.guild_profile_sheet_nickname);
                                    if (textView3 != null) {
                                        TextView textView4 = (TextView) viewInflate.findViewById(R$id.guild_profile_sheet_notifications);
                                        if (textView4 != null) {
                                            CardView cardView2 = (CardView) viewInflate.findViewById(R$id.guild_profile_sheet_secondary_actions);
                                            if (cardView2 != null) {
                                                LinearLayout linearLayout4 = (LinearLayout) viewInflate.findViewById(R$id.per_guild_identity_container);
                                                if (linearLayout4 != null) {
                                                    WidgetGuildHubProfileActionsBinding widgetGuildHubProfileActionsBinding = new WidgetGuildHubProfileActionsBinding(linearLayout2, linearLayout, linearLayout2, linearLayout3, simpleDraweeView, textView, cardView, textView2, textView3, textView4, cardView2, linearLayout4);
                                                    m.checkNotNullExpressionValue(widgetGuildHubProfileActionsBinding, "WidgetGuildHubProfileActionsBinding.bind(view)");
                                                    this.guildHubActionBinding = widgetGuildHubProfileActionsBinding;
                                                } else {
                                                    i2 = R$id.per_guild_identity_container;
                                                }
                                            } else {
                                                i2 = R$id.guild_profile_sheet_secondary_actions;
                                            }
                                        } else {
                                            i2 = R$id.guild_profile_sheet_notifications;
                                        }
                                    } else {
                                        i2 = R$id.guild_profile_sheet_nickname;
                                    }
                                } else {
                                    i2 = R$id.guild_profile_sheet_leave_server;
                                }
                            } else {
                                i2 = R$id.guild_profile_sheet_invite_action;
                            }
                        }
                    } else {
                        i2 = R$id.guild_profile_sheet_guild_avatar;
                    }
                } else {
                    i2 = R$id.guild_profile_sheet_change_nickname;
                }
            } else {
                i2 = R$id.guild_profile_sheet_actions;
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
        }
        widgetGuildProfileSheetViewModel$Actions = actions;
        if (!isGuildHub && this.guildActionBinding == null) {
            View viewInflate2 = getBinding().v.inflate();
            LinearLayout linearLayout5 = (LinearLayout) viewInflate2.findViewById(R$id.change_identity);
            if (linearLayout5 != null) {
                TextView textView5 = (TextView) viewInflate2.findViewById(R$id.change_identity_header);
                if (textView5 != null) {
                    LinearLayout linearLayout6 = (LinearLayout) viewInflate2.findViewById(R$id.guild_profile_sheet_actions);
                    if (linearLayout6 != null) {
                        CheckedSetting checkedSetting = (CheckedSetting) viewInflate2.findViewById(R$id.guild_profile_sheet_allow_dm);
                        if (checkedSetting != null) {
                            LinearLayout linearLayout7 = (LinearLayout) viewInflate2.findViewById(R$id.guild_profile_sheet_bottom_actions);
                            if (linearLayout7 != null) {
                                LinearLayout linearLayout8 = (LinearLayout) viewInflate2;
                                TextView textView6 = (TextView) viewInflate2.findViewById(R$id.guild_profile_sheet_copy_id);
                                if (textView6 != null) {
                                    TextView textView7 = (TextView) viewInflate2.findViewById(R$id.guild_profile_sheet_create_category);
                                    if (textView7 != null) {
                                        TextView textView8 = (TextView) viewInflate2.findViewById(R$id.guild_profile_sheet_create_channel);
                                        if (textView8 != null) {
                                            ConstraintLayout constraintLayout = (ConstraintLayout) viewInflate2.findViewById(R$id.guild_profile_sheet_create_event);
                                            if (constraintLayout != null) {
                                                TextView textView9 = (TextView) viewInflate2.findViewById(R$id.guild_profile_sheet_create_event_label);
                                                if (textView9 != null) {
                                                    TextView textView10 = (TextView) viewInflate2.findViewById(R$id.guild_profile_sheet_create_event_new);
                                                    if (textView10 != null) {
                                                        CardView cardView3 = (CardView) viewInflate2.findViewById(R$id.guild_profile_sheet_developer_actions);
                                                        if (cardView3 != null) {
                                                            RecyclerView recyclerView = (RecyclerView) viewInflate2.findViewById(R$id.guild_profile_sheet_emojis);
                                                            if (recyclerView != null) {
                                                                i = R$id.guild_profile_sheet_emojis_card;
                                                                CardView cardView4 = (CardView) viewInflate2.findViewById(R$id.guild_profile_sheet_emojis_card);
                                                                if (cardView4 != null) {
                                                                    TextView textView11 = (TextView) viewInflate2.findViewById(R$id.guild_profile_sheet_emojis_count);
                                                                    if (textView11 != null) {
                                                                        i = R$id.guild_profile_sheet_guild_avatar;
                                                                        SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) viewInflate2.findViewById(R$id.guild_profile_sheet_guild_avatar);
                                                                        if (simpleDraweeView2 != null) {
                                                                            i = R$id.guild_profile_sheet_hide_muted_channels;
                                                                            CheckedSetting checkedSetting2 = (CheckedSetting) viewInflate2.findViewById(R$id.guild_profile_sheet_hide_muted_channels);
                                                                            if (checkedSetting2 != null) {
                                                                                MaterialButton materialButton = (MaterialButton) viewInflate2.findViewById(R$id.guild_profile_sheet_join_server);
                                                                                if (materialButton != null) {
                                                                                    i = R$id.guild_profile_sheet_leave_server;
                                                                                    TextView textView12 = (TextView) viewInflate2.findViewById(R$id.guild_profile_sheet_leave_server);
                                                                                    if (textView12 != null) {
                                                                                        i = R$id.guild_profile_sheet_mark_as_read;
                                                                                        TextView textView13 = (TextView) viewInflate2.findViewById(R$id.guild_profile_sheet_mark_as_read);
                                                                                        if (textView13 != null) {
                                                                                            CardView cardView5 = (CardView) viewInflate2.findViewById(R$id.guild_profile_sheet_mark_as_read_action);
                                                                                            if (cardView5 != null) {
                                                                                                i = R$id.guild_profile_sheet_nickname;
                                                                                                TextView textView14 = (TextView) viewInflate2.findViewById(R$id.guild_profile_sheet_nickname);
                                                                                                if (textView14 != null) {
                                                                                                    i = R$id.guild_profile_sheet_premium_upsell_dot_separator;
                                                                                                    ImageView imageView = (ImageView) viewInflate2.findViewById(R$id.guild_profile_sheet_premium_upsell_dot_separator);
                                                                                                    if (imageView != null) {
                                                                                                        i = R$id.guild_profile_sheet_premium_upsell_text;
                                                                                                        TextView textView15 = (TextView) viewInflate2.findViewById(R$id.guild_profile_sheet_premium_upsell_text);
                                                                                                        if (textView15 != null) {
                                                                                                            CardView cardView6 = (CardView) viewInflate2.findViewById(R$id.guild_profile_sheet_primary_actions);
                                                                                                            if (cardView6 != null) {
                                                                                                                i = R$id.guild_profile_sheet_secondary_actions;
                                                                                                                CardView cardView7 = (CardView) viewInflate2.findViewById(R$id.guild_profile_sheet_secondary_actions);
                                                                                                                if (cardView7 != null) {
                                                                                                                    i = R$id.guild_profile_sheet_upload_emoji;
                                                                                                                    MaterialButton materialButton2 = (MaterialButton) viewInflate2.findViewById(R$id.guild_profile_sheet_upload_emoji);
                                                                                                                    if (materialButton2 != null) {
                                                                                                                        MaterialButton materialButton3 = (MaterialButton) viewInflate2.findViewById(R$id.guild_profile_sheet_view_server);
                                                                                                                        if (materialButton3 != null) {
                                                                                                                            i = R$id.per_guild_identity_container;
                                                                                                                            LinearLayout linearLayout9 = (LinearLayout) viewInflate2.findViewById(R$id.per_guild_identity_container);
                                                                                                                            if (linearLayout9 != null) {
                                                                                                                                WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding = new WidgetGuildProfileActionsBinding(linearLayout8, linearLayout5, textView5, linearLayout6, checkedSetting, linearLayout7, linearLayout8, textView6, textView7, textView8, constraintLayout, textView9, textView10, cardView3, recyclerView, cardView4, textView11, simpleDraweeView2, checkedSetting2, materialButton, textView12, textView13, cardView5, textView14, imageView, textView15, cardView6, cardView7, materialButton2, materialButton3, linearLayout9);
                                                                                                                                m.checkNotNullExpressionValue(widgetGuildProfileActionsBinding, "WidgetGuildProfileActionsBinding.bind(view)");
                                                                                                                                this.guildActionBinding = widgetGuildProfileActionsBinding;
                                                                                                                                if (widgetGuildProfileActionsBinding == null) {
                                                                                                                                    m.throwUninitializedPropertyAccessException("guildActionBinding");
                                                                                                                                }
                                                                                                                                m.checkNotNullExpressionValue(recyclerView, "guildActionBinding.guildProfileSheetEmojis");
                                                                                                                                recyclerView.setAdapter(this.emojisAdapter);
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            i = R$id.guild_profile_sheet_view_server;
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            } else {
                                                                                                                i = R$id.guild_profile_sheet_primary_actions;
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            } else {
                                                                                                i = R$id.guild_profile_sheet_mark_as_read_action;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                } else {
                                                                                    i = R$id.guild_profile_sheet_join_server;
                                                                                }
                                                                            }
                                                                        }
                                                                    } else {
                                                                        i = R$id.guild_profile_sheet_emojis_count;
                                                                    }
                                                                }
                                                            } else {
                                                                i = R$id.guild_profile_sheet_emojis;
                                                            }
                                                        } else {
                                                            i = R$id.guild_profile_sheet_developer_actions;
                                                        }
                                                    } else {
                                                        i = R$id.guild_profile_sheet_create_event_new;
                                                    }
                                                } else {
                                                    i = R$id.guild_profile_sheet_create_event_label;
                                                }
                                            } else {
                                                i = R$id.guild_profile_sheet_create_event;
                                            }
                                        } else {
                                            i = R$id.guild_profile_sheet_create_channel;
                                        }
                                    } else {
                                        i = R$id.guild_profile_sheet_create_category;
                                    }
                                } else {
                                    i = R$id.guild_profile_sheet_copy_id;
                                }
                            } else {
                                i = R$id.guild_profile_sheet_bottom_actions;
                            }
                        } else {
                            i = R$id.guild_profile_sheet_allow_dm;
                        }
                    } else {
                        i = R$id.guild_profile_sheet_actions;
                    }
                } else {
                    i = R$id.change_identity_header;
                }
            } else {
                i = R$id.change_identity;
            }
            throw new NullPointerException("Missing required view with ID: ".concat(viewInflate2.getResources().getResourceName(i)));
        }
        configureGuildIcon(guildId, guildIcon, guildShortName);
        configureGuildBanner(banner);
        configureGuildContent(guildName, guildDescription, verifiedPartneredIconRes);
        configureMemberCount(onlineCount, memberCount);
        configureTabItems(guildId, tabItems, isGuildHub);
        if (isGuildHub) {
            configureGuildHubActions(guildId, meUser.getId(), widgetGuildProfileSheetViewModel$Actions);
            return;
        }
        configureGuildActions(guildId, meUser.getId(), widgetGuildProfileSheetViewModel$Actions);
        configureEmojis(emojisData);
        configureBottomActions(guildId, this.channelId, bottomActions);
        configureGuildIcon(guildId, guildIcon, guildShortName);
        configureGuildBanner(banner);
        configureGuildContent(guildName, guildDescription, verifiedPartneredIconRes);
        configureMemberCount(onlineCount, memberCount);
        configureTabItems(guildId, tabItems, isGuildHub);
        if (isGuildHub) {
            configureGuildHubActions(guildId, meUser.getId(), widgetGuildProfileSheetViewModel$Actions);
            return;
        }
        configureGuildActions(guildId, meUser.getId(), widgetGuildProfileSheetViewModel$Actions);
        configureEmojis(emojisData);
        configureBottomActions(guildId, this.channelId, bottomActions);
    }

    private final void constrainIconToBanner() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(getBinding().d);
        CardView cardView = getBinding().j;
        m.checkNotNullExpressionValue(cardView, "binding.guildProfileSheetIconCard");
        constraintSet.clear(cardView.getId(), 3);
        CardView cardView2 = getBinding().j;
        m.checkNotNullExpressionValue(cardView2, "binding.guildProfileSheetIconCard");
        constraintSet.clear(cardView2.getId(), 4);
        CardView cardView3 = getBinding().j;
        m.checkNotNullExpressionValue(cardView3, "binding.guildProfileSheetIconCard");
        int id2 = cardView3.getId();
        SimpleDraweeView simpleDraweeView = getBinding().f2431b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildProfileSheetBanner");
        constraintSet.connect(id2, 3, simpleDraweeView.getId(), 4);
        CardView cardView4 = getBinding().j;
        m.checkNotNullExpressionValue(cardView4, "binding.guildProfileSheetIconCard");
        int id3 = cardView4.getId();
        SimpleDraweeView simpleDraweeView2 = getBinding().f2431b;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.guildProfileSheetBanner");
        constraintSet.connect(id3, 4, simpleDraweeView2.getId(), 4);
        constraintSet.applyTo(getBinding().d);
    }

    private final void constrainIconToParent() {
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(getBinding().d);
        CardView cardView = getBinding().j;
        m.checkNotNullExpressionValue(cardView, "binding.guildProfileSheetIconCard");
        constraintSet.clear(cardView.getId(), 3);
        CardView cardView2 = getBinding().j;
        m.checkNotNullExpressionValue(cardView2, "binding.guildProfileSheetIconCard");
        constraintSet.clear(cardView2.getId(), 4);
        CardView cardView3 = getBinding().j;
        m.checkNotNullExpressionValue(cardView3, "binding.guildProfileSheetIconCard");
        int id2 = cardView3.getId();
        ConstraintLayout constraintLayout = getBinding().d;
        m.checkNotNullExpressionValue(constraintLayout, "binding.guildProfileSheetConstraintLayout");
        int id3 = constraintLayout.getId();
        CardView cardView4 = getBinding().j;
        m.checkNotNullExpressionValue(cardView4, "binding.guildProfileSheetIconCard");
        ViewGroup$LayoutParams layoutParams = cardView4.getLayoutParams();
        ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = layoutParams instanceof ViewGroup$MarginLayoutParams ? (ViewGroup$MarginLayoutParams) layoutParams : null;
        constraintSet.connect(id2, 3, id3, 3, viewGroup$MarginLayoutParams == null ? 0 : viewGroup$MarginLayoutParams.topMargin);
        constraintSet.applyTo(getBinding().d);
    }

    private final Unit dismissAlert() {
        Unit unit;
        AlertDialog alertDialog = this.dialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
            unit = Unit.a;
        } else {
            unit = null;
        }
        hideKeyboard(getView());
        return unit;
    }

    private final WidgetGuildProfileSheetBinding getBinding() {
        return (WidgetGuildProfileSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final boolean getFromGuildEventUpsell() {
        return ((Boolean) this.fromGuildEventUpsell.getValue()).booleanValue();
    }

    private final WidgetGuildProfileSheetViewModel getViewModel() {
        return (WidgetGuildProfileSheetViewModel) this.viewModel.getValue();
    }

    private final void handleDismissAndShowToast(WidgetGuildProfileSheetViewModel$Event$DismissAndShowToast event) {
        b.a.d.m.i(this, event.getStringRes(), 0, 4);
        dismiss();
    }

    private final void handleEvent(WidgetGuildProfileSheetViewModel$Event event) {
        if (event instanceof WidgetGuildProfileSheetViewModel$Event$DismissAndShowToast) {
            handleDismissAndShowToast((WidgetGuildProfileSheetViewModel$Event$DismissAndShowToast) event);
        }
    }

    private final void handleViewState(WidgetGuildProfileSheetViewModel$ViewState viewState) {
        if (viewState instanceof WidgetGuildProfileSheetViewModel$ViewState$Loading) {
            showLoadingView();
        } else if (viewState instanceof WidgetGuildProfileSheetViewModel$ViewState$Invalid) {
            dismiss();
        } else {
            if (!(viewState instanceof WidgetGuildProfileSheetViewModel$ViewState$Loaded)) {
                throw new NoWhenBranchMatchedException();
            }
            updateView((WidgetGuildProfileSheetViewModel$ViewState$Loaded) viewState);
        }
    }

    private final void launchInvite(long guildId) {
        WidgetGuildInviteShare$Companion widgetGuildInviteShare$Companion = WidgetGuildInviteShare.Companion;
        Context context = getContext();
        if (context != null) {
            m.checkNotNullExpressionValue(context, "context ?: return");
            FragmentManager parentFragmentManager = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetGuildInviteShare$Companion.launch$default(widgetGuildInviteShare$Companion, context, parentFragmentManager, guildId, null, false, null, null, "Guild Profile", 120, null);
        }
    }

    private final int maxEmojisPerRow() {
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        int i = resources.getDisplayMetrics().widthPixels;
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding == null) {
            m.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        CardView cardView = widgetGuildProfileActionsBinding.n;
        m.checkNotNullExpressionValue(cardView, "guildActionBinding.guildProfileSheetEmojisCard");
        int contentPaddingLeft = cardView.getContentPaddingLeft();
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding2 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding2 == null) {
            m.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        CardView cardView2 = widgetGuildProfileActionsBinding2.n;
        m.checkNotNullExpressionValue(cardView2, "guildActionBinding.guildProfileSheetEmojisCard");
        int contentPaddingRight = cardView2.getContentPaddingRight() + contentPaddingLeft;
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding3 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding3 == null) {
            m.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        LinearLayout linearLayout = widgetGuildProfileActionsBinding3.f;
        m.checkNotNullExpressionValue(linearLayout, "guildActionBinding.guild…ofileSheetBottomContainer");
        int paddingStart = linearLayout.getPaddingStart();
        WidgetGuildProfileActionsBinding widgetGuildProfileActionsBinding4 = this.guildActionBinding;
        if (widgetGuildProfileActionsBinding4 == null) {
            m.throwUninitializedPropertyAccessException("guildActionBinding");
        }
        LinearLayout linearLayout2 = widgetGuildProfileActionsBinding4.f;
        m.checkNotNullExpressionValue(linearLayout2, "guildActionBinding.guild…ofileSheetBottomContainer");
        return ((i - contentPaddingRight) - (linearLayout2.getPaddingEnd() + paddingStart)) / getResources().getDimensionPixelSize(2131165401);
    }

    public static final void show(FragmentManager fragmentManager, boolean z2, long j, long j2, boolean z3) {
        Companion.show(fragmentManager, z2, j, j2, z3);
    }

    private final void showLeaveServerDialog(long guildId) {
        WidgetLeaveGuildDialog$Companion widgetLeaveGuildDialog$Companion = WidgetLeaveGuildDialog.Companion;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetLeaveGuildDialog$Companion.show(parentFragmentManager, guildId);
        dismissAlert();
    }

    private final void showLoadingView() {
        AppViewFlipper appViewFlipper = getBinding().g;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.guildProfileSheetFlipper");
        appViewFlipper.setDisplayedChild(0);
    }

    private final void updateView(WidgetGuildProfileSheetViewModel$ViewState$Loaded viewState) {
        AppViewFlipper appViewFlipper = getBinding().g;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.guildProfileSheetFlipper");
        appViewFlipper.setDisplayedChild(1);
        configureUI(viewState);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_guild_profile_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.channelId = Long.valueOf(getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID"));
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildProfileSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildProfileSheet$onViewCreated$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetGuildProfileSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildProfileSheet$onViewCreated$2(this), 62, (Object) null);
        this.emojisAdapter.setOnClickEmoji(new WidgetGuildProfileSheet$onViewCreated$3(this));
    }
}
