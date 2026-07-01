package com.discord.widgets.settings.premium;

import b.a.k.b;
import com.discord.app.AppActivity;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.billing.GooglePlayInAppSku;
import com.discord.utilities.gifting.GiftingUtils;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSettingsGifting.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGifting$onViewBound$chooseGiftCallback$1 extends o implements Function1<GooglePlayInAppSku, Unit> {
    public final /* synthetic */ Traits$Location $locationTrait;
    public final /* synthetic */ WidgetSettingsGifting this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsGifting$onViewBound$chooseGiftCallback$1(WidgetSettingsGifting widgetSettingsGifting, Traits$Location traits$Location) {
        super(1);
        this.this$0 = widgetSettingsGifting;
        this.$locationTrait = traits$Location;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GooglePlayInAppSku googlePlayInAppSku) {
        invoke2(googlePlayInAppSku);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GooglePlayInAppSku googlePlayInAppSku) {
        m.checkNotNullParameter(googlePlayInAppSku, "inAppSku");
        try {
            GiftingUtils giftingUtils = GiftingUtils.INSTANCE;
            AppActivity appActivityRequireAppActivity = this.this$0.requireAppActivity();
            Traits$Location traits$Location = this.$locationTrait;
            if (traits$Location == null) {
                traits$Location = new Traits$Location("Gifting Settings", null, null, null, null, 30, null);
            }
            giftingUtils.buyGift(appActivityRequireAppActivity, googlePlayInAppSku, traits$Location, new WidgetSettingsGifting$onViewBound$chooseGiftCallback$1$1(this));
        } catch (Exception unused) {
            WidgetSettingsGifting widgetSettingsGifting = this.this$0;
            b.a.d.m.j(widgetSettingsGifting, b.k(widgetSettingsGifting, 2131888885, new Object[0], null, 4), 0, 4);
        }
    }
}
