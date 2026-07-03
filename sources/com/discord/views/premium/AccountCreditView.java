package com.discord.views.premium;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.domain.premium.SubscriptionPlanType;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.time.TimeUtils;
import java.text.DateFormat;
import p007b.p008a.p025i.C1081x1;
import p007b.p008a.p027k.C1107b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: AccountCreditView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AccountCreditView extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final C1081x1 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountCreditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        C12238m.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(C5419R.layout.view_account_credit, (ViewGroup) this, false);
        addView(viewInflate);
        int i = C5419R.id.credit_header;
        TextView textView = (TextView) viewInflate.findViewById(C5419R.id.credit_header);
        if (textView != null) {
            i = C5419R.id.credit_icon;
            ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.credit_icon);
            if (imageView != null) {
                i = C5419R.id.credit_info;
                TextView textView2 = (TextView) viewInflate.findViewById(C5419R.id.credit_info);
                if (textView2 != null) {
                    i = C5419R.id.credit_info_container;
                    LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(C5419R.id.credit_info_container);
                    if (linearLayout != null) {
                        i = C5419R.id.credit_time;
                        TextView textView3 = (TextView) viewInflate.findViewById(C5419R.id.credit_time);
                        if (textView3 != null) {
                            C1081x1 c1081x1 = new C1081x1((ConstraintLayout) viewInflate, textView, imageView, textView2, linearLayout, textView3);
                            C12238m.checkNotNullExpressionValue(c1081x1, "ViewAccountCreditBinding…rom(context), this, true)");
                            this.binding = c1081x1;
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    /* JADX INFO: renamed from: a */
    public final void m8605a(long planId, int monthsCredit, ModelSubscription currentSubscription) {
        Object objM212d;
        setVisibility(monthsCredit > 0 ? 0 : 8);
        if (monthsCredit <= 0) {
            return;
        }
        if (planId == SubscriptionPlanType.PREMIUM_MONTH_TIER_1.getPlanId()) {
            objM212d = C1107b.m212d(this, C5419R.string.premium_tier_1, new Object[0], (4 & 4) != 0 ? C1107b.c.f1492j : null);
            this.binding.f1370c.setImageResource(C5419R.drawable.drawable_ic_nitro_classic);
            TextView textView = this.binding.f1369b;
            C12238m.checkNotNullExpressionValue(textView, "binding.creditHeader");
            C1107b.m221m(textView, C5419R.string.premium_subscription_credit, new Object[]{objM212d}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        } else if (planId == SubscriptionPlanType.PREMIUM_MONTH_TIER_2.getPlanId()) {
            objM212d = C1107b.m212d(this, C5419R.string.premium_tier_2, new Object[0], (4 & 4) != 0 ? C1107b.c.f1492j : null);
            this.binding.f1370c.setImageResource(C5419R.drawable.drawable_ic_nitro);
            TextView textView2 = this.binding.f1369b;
            C12238m.checkNotNullExpressionValue(textView2, "binding.creditHeader");
            C1107b.m221m(textView2, C5419R.string.premium_subscription_credit, new Object[]{objM212d}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        } else {
            objM212d = "";
        }
        if ((currentSubscription != null && currentSubscription.isGoogleSubscription()) || currentSubscription == null || !currentSubscription.hasPlan(planId)) {
            TextView textView3 = this.binding.f1371d;
            C12238m.checkNotNullExpressionValue(textView3, "binding.creditInfo");
            C1107b.m221m(textView3, C5419R.string.premium_subscription_credit_applied_mismatched_plan_android, new Object[]{objM212d}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        } else {
            TimeUtils timeUtils = TimeUtils.INSTANCE;
            String currentPeriodEnd = currentSubscription.getCurrentPeriodEnd();
            Context context = getContext();
            C12238m.checkNotNullExpressionValue(context, "context");
            String strRenderUtcDate$default = TimeUtils.renderUtcDate$default(timeUtils, currentPeriodEnd, context, (String) null, (DateFormat) null, 0, 28, (Object) null);
            TextView textView4 = this.binding.f1371d;
            C12238m.checkNotNullExpressionValue(textView4, "binding.creditInfo");
            C1107b.m221m(textView4, C5419R.string.premium_subscription_credit_applied_on, new Object[]{strRenderUtcDate$default}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        }
        TextView textView5 = this.binding.f1372e;
        C12238m.checkNotNullExpressionValue(textView5, "binding.creditTime");
        Resources resources = getResources();
        C12238m.checkNotNullExpressionValue(resources, "resources");
        Context context2 = getContext();
        C12238m.checkNotNullExpressionValue(context2, "context");
        textView5.setText(StringResourceUtilsKt.getQuantityString(resources, context2, C5419R.plurals.premium_subscription_credit_count_months_count, monthsCredit, Integer.valueOf(monthsCredit)));
    }
}
