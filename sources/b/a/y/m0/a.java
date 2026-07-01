package b.a.y.m0;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.utilities.billing.GooglePlayInAppSku;
import com.discord.views.premium.GiftSelectView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GiftSelectView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements View$OnClickListener {
    public final /* synthetic */ GiftSelectView j;

    public a(GiftSelectView giftSelectView) {
        this.j = giftSelectView;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Function1<? super GooglePlayInAppSku, Unit> function1;
        GiftSelectView giftSelectView = this.j;
        GooglePlayInAppSku googlePlayInAppSku = giftSelectView.inAppSku;
        if (googlePlayInAppSku != null && (function1 = giftSelectView.onClickPlan) != null) {
            function1.invoke(googlePlayInAppSku);
        }
        giftSelectView.binding.c.setOnClickListener(null);
    }
}
