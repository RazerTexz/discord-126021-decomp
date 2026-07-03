package p007b.p008a.p062y.p066m0;

import android.view.View;
import com.discord.utilities.billing.GooglePlayInAppSku;
import com.discord.views.premium.GiftSelectView;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: b.a.y.m0.a */
/* JADX INFO: compiled from: GiftSelectView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewOnClickListenerC1360a implements View.OnClickListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ GiftSelectView f2049j;

    public ViewOnClickListenerC1360a(GiftSelectView giftSelectView) {
        this.f2049j = giftSelectView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function1<? super GooglePlayInAppSku, Unit> function1;
        GiftSelectView giftSelectView = this.f2049j;
        GooglePlayInAppSku googlePlayInAppSku = giftSelectView.inAppSku;
        if (googlePlayInAppSku != null && (function1 = giftSelectView.onClickPlan) != null) {
            function1.invoke(googlePlayInAppSku);
        }
        giftSelectView.binding.f16378c.setOnClickListener(null);
    }
}
