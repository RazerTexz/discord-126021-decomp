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
import b.a.i.x1;
import b.a.k.b;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.domain.premium.SubscriptionPlanType;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.time.TimeUtils;
import d0.z.d.m;
import java.text.DateFormat;

/* JADX INFO: compiled from: AccountCreditView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AccountCreditView extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final x1 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountCreditView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        m.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.view_account_credit, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R$id.credit_header;
        TextView textView = (TextView) viewInflate.findViewById(R$id.credit_header);
        if (textView != null) {
            i = R$id.credit_icon;
            ImageView imageView = (ImageView) viewInflate.findViewById(R$id.credit_icon);
            if (imageView != null) {
                i = R$id.credit_info;
                TextView textView2 = (TextView) viewInflate.findViewById(R$id.credit_info);
                if (textView2 != null) {
                    i = R$id.credit_info_container;
                    LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R$id.credit_info_container);
                    if (linearLayout != null) {
                        i = R$id.credit_time;
                        TextView textView3 = (TextView) viewInflate.findViewById(R$id.credit_time);
                        if (textView3 != null) {
                            x1 x1Var = new x1((ConstraintLayout) viewInflate, textView, imageView, textView2, linearLayout, textView3);
                            m.checkNotNullExpressionValue(x1Var, "ViewAccountCreditBinding…rom(context), this, true)");
                            this.binding = x1Var;
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void a(long planId, int monthsCredit, ModelSubscription currentSubscription) {
        Object objJ;
        setVisibility(monthsCredit > 0 ? 0 : 8);
        if (monthsCredit <= 0) {
            return;
        }
        if (planId == SubscriptionPlanType.PREMIUM_MONTH_TIER_1.getPlanId()) {
            objJ = b.j(this, 2131894441, new Object[0], null, 4);
            this.binding.c.setImageResource(2131231250);
            TextView textView = this.binding.f227b;
            m.checkNotNullExpressionValue(textView, "binding.creditHeader");
            b.n(textView, 2131894358, new Object[]{objJ}, null, 4);
        } else if (planId == SubscriptionPlanType.PREMIUM_MONTH_TIER_2.getPlanId()) {
            objJ = b.j(this, 2131894444, new Object[0], null, 4);
            this.binding.c.setImageResource(2131231249);
            TextView textView2 = this.binding.f227b;
            m.checkNotNullExpressionValue(textView2, "binding.creditHeader");
            b.n(textView2, 2131894358, new Object[]{objJ}, null, 4);
        } else {
            objJ = "";
        }
        if ((currentSubscription != null && currentSubscription.isGoogleSubscription()) || currentSubscription == null || !currentSubscription.hasPlan(planId)) {
            TextView textView3 = this.binding.d;
            m.checkNotNullExpressionValue(textView3, "binding.creditInfo");
            b.n(textView3, 2131894360, new Object[]{objJ}, null, 4);
        } else {
            TimeUtils timeUtils = TimeUtils.INSTANCE;
            String currentPeriodEnd = currentSubscription.getCurrentPeriodEnd();
            Context context = getContext();
            m.checkNotNullExpressionValue(context, "context");
            String strRenderUtcDate$default = TimeUtils.renderUtcDate$default(timeUtils, currentPeriodEnd, context, (String) null, (DateFormat) null, 0, 28, (Object) null);
            TextView textView4 = this.binding.d;
            m.checkNotNullExpressionValue(textView4, "binding.creditInfo");
            b.n(textView4, 2131894361, new Object[]{strRenderUtcDate$default}, null, 4);
        }
        TextView textView5 = this.binding.e;
        m.checkNotNullExpressionValue(textView5, "binding.creditTime");
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        Context context2 = getContext();
        m.checkNotNullExpressionValue(context2, "context");
        textView5.setText(StringResourceUtilsKt.getQuantityString(resources, context2, R$plurals.premium_subscription_credit_count_months_count, monthsCredit, Integer.valueOf(monthsCredit)));
    }
}
