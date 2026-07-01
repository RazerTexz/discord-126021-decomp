package b.a.a.a0;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import b.a.i.r;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.api.premium.PremiumTier;
import com.discord.api.premium.SubscriptionInterval;
import com.discord.app.AppDialog;
import com.discord.models.domain.premium.SubscriptionPlanType;
import com.discord.utilities.billing.GooglePlayInAppSku;
import com.discord.utilities.billing.GooglePlayInAppSkus;
import com.discord.utilities.gifting.GiftingUtils;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: GiftPurchasedDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {b.d.b.a.a.d0(a.class, "binding", "getBinding()Lcom/discord/databinding/GiftPurchasedDialogBinding;", 0)};
    public static final a$a k = new a$a(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public Function0<Unit> onDismiss;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    public a() {
        super(R$layout.gift_purchased_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, a$b.j, null, 2, null);
    }

    public final r g() {
        return (r) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.onDismiss == null) {
            dismiss();
        }
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        g().f.setOnClickListener(new a$c(this));
        String string = getArgumentsOrDefault().getString("ARG_SKU_NAME");
        GooglePlayInAppSku inAppSku = string != null ? GooglePlayInAppSkus.INSTANCE.getInAppSku(string) : null;
        if ((inAppSku != null ? inAppSku.getSkuDetails() : null) == null) {
            g().f.callOnClick();
            return;
        }
        LinkifiedTextView linkifiedTextView = g().e;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.giftLinkSubtext");
        b.a.k.b.m(linkifiedTextView, 2131886670, new Object[0], new a$d(this));
        GiftingUtils giftingUtils = GiftingUtils.INSTANCE;
        Integer iconForSku = giftingUtils.getIconForSku(inAppSku);
        if (iconForSku != null) {
            g().h.setImageResource(iconForSku.intValue());
        }
        Pair pair = SubscriptionPlanType.Companion.from(inAppSku.getPaymentGatewaySkuId()).getInterval() == SubscriptionInterval.MONTHLY ? new Pair(2131886665, Integer.valueOf(R$plurals.application_store_gift_purchase_confirm_monthly_mobile_intervalCount)) : new Pair(2131886668, Integer.valueOf(R$plurals.application_store_gift_purchase_confirm_yearly_mobile_intervalCount));
        int iIntValue = ((Number) pair.component1()).intValue();
        int iIntValue2 = ((Number) pair.component2()).intValue();
        String string2 = getString(giftingUtils.getTierForSku(inAppSku.getSkuId()) == PremiumTier.TIER_1 ? 2131894441 : 2131894444);
        m.checkNotNullExpressionValue(string2, "getString(\n        if (G…ring.premium_tier_2\n    )");
        TextView textView = g().g;
        m.checkNotNullExpressionValue(textView, "binding.giftPurchasedDialogSubtext");
        Object[] objArr = new Object[2];
        Context context = getContext();
        objArr[0] = context != null ? StringResourceUtilsKt.getI18nPluralString(context, iIntValue2, 1, 1) : null;
        objArr[1] = string2;
        textView.setText(b.a.k.b.k(this, iIntValue, objArr, null, 4));
        String string3 = getArgumentsOrDefault().getString("ARG_GIFT_CODE", "");
        m.checkNotNullExpressionValue(string3, "giftCode");
        String strGenerateGiftUrl = giftingUtils.generateGiftUrl(string3);
        TextView textView2 = g().f189b;
        m.checkNotNullExpressionValue(textView2, "binding.giftEntitlementCode");
        textView2.setText(strGenerateGiftUrl);
        g().d.setOnClickListener(new a$e(this, strGenerateGiftUrl));
    }
}
