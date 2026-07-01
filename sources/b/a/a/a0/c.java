package b.a.a.a0;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import androidx.fragment.app.Fragment;
import b.a.i.m4;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.api.application.Application;
import com.discord.api.premium.SubscriptionPlan;
import com.discord.app.AppDialog;
import com.discord.app.AppViewFlipper;
import com.discord.models.domain.ModelGift;
import com.discord.models.domain.ModelSku;
import com.discord.models.domain.ModelStoreListing;
import com.discord.rlottie.RLottieImageView;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.gifting.GiftStyle;
import com.discord.utilities.gifting.GiftStyleKt;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.ViewCoroutineScopeKt;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGiftAcceptDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {b.d.b.a.a.d0(c.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAcceptGiftDialogBinding;", 0)};
    public static final c$a k = new c$a(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    public c() {
        super(R$layout.widget_accept_gift_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, c$b.j, null, 2, null);
    }

    public final void g(ModelGift gift, c$a$a uiState) {
        ModelSku sku;
        Application application;
        String icon;
        ModelSku sku2;
        AppViewFlipper appViewFlipper = h().h;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.acceptGiftFlipper");
        appViewFlipper.setDisplayedChild(1);
        String applicationIcon$default = null;
        if (gift.isAnyNitroGift()) {
            GiftStyle customStyle = GiftStyleKt.getCustomStyle(gift);
            if (customStyle != null) {
                RLottieImageView rLottieImageView = h().c;
                m.checkNotNullExpressionValue(rLottieImageView, "binding.acceptGiftBodyLottie");
                rLottieImageView.setVisibility(0);
                SimpleDraweeView simpleDraweeView = h().f161b;
                m.checkNotNullExpressionValue(simpleDraweeView, "binding.acceptGiftBodyImage");
                simpleDraweeView.setVisibility(8);
                RLottieImageView rLottieImageView2 = h().c;
                if (uiState.f44b) {
                    rLottieImageView2.setImageResource(customStyle.getStaticRes());
                } else {
                    int animRes = customStyle.getAnimRes();
                    RLottieImageView rLottieImageView3 = h().c;
                    m.checkNotNullExpressionValue(rLottieImageView3, "binding.acceptGiftBodyLottie");
                    int iDpToPixels = DimenUtils.dpToPixels(rLottieImageView3.getLayoutParams().width);
                    RLottieImageView rLottieImageView4 = h().c;
                    m.checkNotNullExpressionValue(rLottieImageView4, "binding.acceptGiftBodyLottie");
                    rLottieImageView2.c(animRes, iDpToPixels, DimenUtils.dpToPixels(rLottieImageView4.getLayoutParams().height));
                    CoroutineScope coroutineScope = ViewCoroutineScopeKt.getCoroutineScope(rLottieImageView2);
                    if (coroutineScope != null) {
                        b.i.a.f.e.o.f.H0(coroutineScope, null, null, new c$c(rLottieImageView2, null), 3, null);
                    }
                }
                m.checkNotNullExpressionValue(rLottieImageView2, "binding.acceptGiftBodyLo…  }\n          }\n        }");
            } else {
                MGImages mGImages = MGImages.INSTANCE;
                SimpleDraweeView simpleDraweeView2 = h().f161b;
                m.checkNotNullExpressionValue(simpleDraweeView2, "binding.acceptGiftBodyImage");
                MGImages.setImage$default(mGImages, simpleDraweeView2, PremiumUtils.INSTANCE.getNitroGiftIcon(gift), (MGImages$ChangeDetector) null, 4, (Object) null);
            }
        } else {
            ModelStoreListing storeListing = gift.getStoreListing();
            if (storeListing != null && (sku = storeListing.getSku()) != null && (application = sku.getApplication()) != null && (icon = application.getIcon()) != null) {
                ModelStoreListing storeListing2 = gift.getStoreListing();
                applicationIcon$default = IconUtils.getApplicationIcon$default((storeListing2 == null || (sku2 = storeListing2.getSku()) == null) ? 0L : sku2.getApplicationId(), icon, 0, 4, (Object) null);
            }
            h().f161b.setImageURI(applicationIcon$default);
        }
        MaterialButton materialButton = h().e;
        m.checkNotNullExpressionValue(materialButton, "binding.acceptGiftConfirm");
        materialButton.setVisibility(0);
        ProgressBar progressBar = h().j;
        m.checkNotNullExpressionValue(progressBar, "binding.acceptGiftProgress");
        progressBar.setVisibility(8);
    }

    public final m4 h() {
        return (m4) this.binding.getValue((Fragment) this, j[0]);
    }

    public final CharSequence i(ModelGift gift) {
        int i;
        SubscriptionPlan subscriptionPlan = gift.getSubscriptionPlan();
        if (subscriptionPlan == null) {
            return "";
        }
        int iOrdinal = subscriptionPlan.getInterval().ordinal();
        if (iOrdinal == 0) {
            i = R$plurals.gift_confirmation_nitro_time_frame_months_time;
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            i = R$plurals.gift_confirmation_nitro_time_frame_years_time;
        }
        Context contextRequireContext = requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        CharSequence i18nPluralString = StringResourceUtilsKt.getI18nPluralString(contextRequireContext, i, subscriptionPlan.getIntervalCount(), Integer.valueOf(subscriptionPlan.getIntervalCount()));
        int iOrdinal2 = subscriptionPlan.getInterval().ordinal();
        if (iOrdinal2 == 0) {
            return b.a.k.b.k(this, 2131889691, new Object[]{i18nPluralString}, null, 4);
        }
        if (iOrdinal2 == 1) {
            return b.a.k.b.k(this, 2131889692, new Object[]{i18nPluralString}, null, 4);
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        String string;
        Bundle arguments = getArguments();
        if (arguments != null && (string = arguments.getString("ARG_GIFT_CODE")) != null) {
            c$a c_a = k;
            m.checkNotNullExpressionValue(string, "it");
            Objects.requireNonNull(c_a);
            m.checkNotNullParameter(string, "giftCode");
            String str = "gift:" + string;
            if (str != null) {
                StoreStream.Companion.getNotices().markDialogSeen(str);
            }
        }
        super.onDestroy();
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("ARG_GIFT_CODE") : null;
        if (string == null) {
            dismiss();
            return;
        }
        LinkifiedTextView linkifiedTextView = h().g;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.acceptGiftDisclaimerText");
        b.a.k.b.n(linkifiedTextView, 2131889658, new Object[]{b.a.d.f.a.a(360055386693L, null)}, null, 4);
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableJ = Observable.j(storeStream$Companion.getGifting().requestGift(string), storeStream$Companion.getAccessibility().observeReducedMotionEnabled(), c$d.j);
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…iftState, reduceMotion) }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableJ, this, null, 2, null), c.class, (Context) null, (Function1) null, new c$f(this), (Function0) null, (Function0) null, new c$e(this), 54, (Object) null);
    }
}
