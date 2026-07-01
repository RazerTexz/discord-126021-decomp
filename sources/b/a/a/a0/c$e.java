package b.a.a.a0;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.discord.app.AppViewFlipper;
import com.discord.models.domain.ModelGift;
import com.discord.models.domain.ModelSku;
import com.discord.models.domain.ModelStoreListing;
import com.discord.stores.StoreGifting$GiftState$Invalid;
import com.discord.stores.StoreGifting$GiftState$LoadFailed;
import com.discord.stores.StoreGifting$GiftState$Loading;
import com.discord.stores.StoreGifting$GiftState$RedeemedFailed;
import com.discord.stores.StoreGifting$GiftState$Redeeming;
import com.discord.stores.StoreGifting$GiftState$Resolved;
import com.discord.stores.StoreGifting$GiftState$Revoking;
import com.discord.stores.StoreGifting$HasGift;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;
import d0.z.d.o;
import defpackage.g;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetGiftAcceptDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class c$e extends o implements Function1<c$a$a, Unit> {
    public final /* synthetic */ c this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c$e(c cVar) {
        super(1);
        this.this$0 = cVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(c$a$a c_a_a) {
        ModelSku sku;
        ModelSku sku2;
        String name;
        CharSequence charSequenceK;
        ModelSku sku3;
        c$a$a c_a_a2 = c_a_a;
        Object obj = c_a_a2.a;
        if (obj instanceof StoreGifting$GiftState$Loading) {
            c cVar = this.this$0;
            KProperty[] kPropertyArr = c.j;
            AppViewFlipper appViewFlipper = cVar.h().h;
            m.checkNotNullExpressionValue(appViewFlipper, "binding.acceptGiftFlipper");
            appViewFlipper.setDisplayedChild(0);
        } else {
            if (obj instanceof StoreGifting$GiftState$Resolved) {
                StoreGifting$GiftState$Resolved storeGifting$GiftState$Resolved = (StoreGifting$GiftState$Resolved) obj;
                if (storeGifting$GiftState$Resolved.getGift().getRedeemed()) {
                    c cVar2 = this.this$0;
                    m.checkNotNullExpressionValue(c_a_a2, "giftUiState");
                    KProperty[] kPropertyArr2 = c.j;
                    Objects.requireNonNull(cVar2);
                    ModelGift gift = storeGifting$GiftState$Resolved.getGift();
                    cVar2.g(gift, c_a_a2);
                    ModelStoreListing storeListing = gift.getStoreListing();
                    if (storeListing == null || (sku3 = storeListing.getSku()) == null || (name = sku3.getName()) == null) {
                        name = "";
                    }
                    CharSequence charSequenceI = cVar2.i(gift);
                    CharSequence charSequenceK2 = gift.isAnyNitroGift() ? b.a.k.b.k(cVar2, 2131889690, new Object[]{name}, null, 4) : b.a.k.b.k(cVar2, 2131889689, new Object[0], null, 4);
                    if (gift.isNitroClassicGift()) {
                        charSequenceK = b.a.k.b.k(cVar2, 2131889671, new Object[]{charSequenceI}, null, 4);
                    } else {
                        charSequenceK = gift.isNitroGift() ? b.a.k.b.k(cVar2, 2131889672, new Object[]{charSequenceI}, null, 4) : b.a.k.b.k(cVar2, 2131889670, new Object[]{name}, null, 4);
                    }
                    LinearLayout linearLayout = b.d.b.a.a.v0(b.d.b.a.a.v0(cVar2.h().i, "binding.acceptGiftHeader", charSequenceK2, cVar2).d, "binding.acceptGiftBodyText", charSequenceK, cVar2).f;
                    m.checkNotNullExpressionValue(linearLayout, "binding.acceptGiftDisclaimerContainer");
                    linearLayout.setVisibility(8);
                    MaterialButton materialButton = cVar2.h().e;
                    m.checkNotNullExpressionValue(materialButton, "binding.acceptGiftConfirm");
                    Context context = cVar2.getContext();
                    materialButton.setText(context != null ? context.getText(2131889685) : null);
                    cVar2.h().e.setOnClickListener(new d(cVar2));
                } else if (storeGifting$GiftState$Resolved.getGift().getMaxUses() == storeGifting$GiftState$Resolved.getGift().getUses()) {
                    c cVar3 = this.this$0;
                    m.checkNotNullExpressionValue(c_a_a2, "giftUiState");
                    KProperty[] kPropertyArr3 = c.j;
                    Objects.requireNonNull(cVar3);
                    cVar3.g(storeGifting$GiftState$Resolved.getGift(), c_a_a2);
                    TextView textView = cVar3.h().i;
                    m.checkNotNullExpressionValue(textView, "binding.acceptGiftHeader");
                    b.a.k.b.n(textView, 2131889688, new Object[0], null, 4);
                    TextView textView2 = cVar3.h().d;
                    m.checkNotNullExpressionValue(textView2, "binding.acceptGiftBodyText");
                    b.a.k.b.n(textView2, 2131889655, new Object[0], null, 4);
                    LinearLayout linearLayout2 = cVar3.h().f;
                    m.checkNotNullExpressionValue(linearLayout2, "binding.acceptGiftDisclaimerContainer");
                    linearLayout2.setVisibility(8);
                    MaterialButton materialButton2 = cVar3.h().e;
                    m.checkNotNullExpressionValue(materialButton2, "binding.acceptGiftConfirm");
                    b.a.k.b.n(materialButton2, 2131889681, new Object[0], null, 4);
                    cVar3.h().e.setOnClickListener(new e(cVar3));
                } else {
                    c cVar4 = this.this$0;
                    m.checkNotNullExpressionValue(c_a_a2, "giftUiState");
                    KProperty[] kPropertyArr4 = c.j;
                    Objects.requireNonNull(cVar4);
                    ModelGift gift2 = ((StoreGifting$HasGift) obj).getGift();
                    cVar4.g(gift2, c_a_a2);
                    ModelStoreListing storeListing2 = gift2.getStoreListing();
                    String name2 = (storeListing2 == null || (sku2 = storeListing2.getSku()) == null) ? null : sku2.getName();
                    LinearLayout linearLayout3 = b.d.b.a.a.v0(b.d.b.a.a.v0(cVar4.h().i, "binding.acceptGiftHeader", gift2.isAnyNitroGift() ? b.a.k.b.k(cVar4, 2131889687, new Object[]{name2}, null, 4) : b.a.k.b.k(cVar4, 2131889686, new Object[0], null, 4), cVar4).d, "binding.acceptGiftBodyText", gift2.isAnyNitroGift() ? b.a.k.b.k(cVar4, 2131889657, new Object[]{name2, cVar4.i(gift2)}, null, 4) : b.a.k.b.k(cVar4, 2131889656, new Object[]{name2}, null, 4), cVar4).f;
                    m.checkNotNullExpressionValue(linearLayout3, "binding.acceptGiftDisclaimerContainer");
                    linearLayout3.setVisibility(gift2.isAnyNitroGift() ? 0 : 8);
                    MaterialButton materialButton3 = cVar4.h().e;
                    m.checkNotNullExpressionValue(materialButton3, "binding.acceptGiftConfirm");
                    b.a.k.b.n(materialButton3, 2131889679, new Object[0], null, 4);
                    cVar4.h().e.setOnClickListener(new f(gift2));
                }
            } else if (obj instanceof StoreGifting$GiftState$Redeeming) {
                c cVar5 = this.this$0;
                m.checkNotNullExpressionValue(c_a_a2, "giftUiState");
                KProperty[] kPropertyArr5 = c.j;
                Objects.requireNonNull(cVar5);
                ModelGift gift3 = ((StoreGifting$GiftState$Redeeming) obj).getGift();
                cVar5.g(gift3, c_a_a2);
                ModelStoreListing storeListing3 = gift3.getStoreListing();
                String name3 = (storeListing3 == null || (sku = storeListing3.getSku()) == null) ? null : sku.getName();
                MaterialButton materialButton4 = cVar5.h().e;
                m.checkNotNullExpressionValue(materialButton4, "binding.acceptGiftConfirm");
                materialButton4.setVisibility(8);
                ProgressBar progressBar = cVar5.h().j;
                m.checkNotNullExpressionValue(progressBar, "binding.acceptGiftProgress");
                progressBar.setVisibility(0);
                LinearLayout linearLayout4 = b.d.b.a.a.v0(b.d.b.a.a.v0(cVar5.h().i, "binding.acceptGiftHeader", gift3.isAnyNitroGift() ? b.a.k.b.k(cVar5, 2131889687, new Object[]{name3}, null, 4) : b.a.k.b.k(cVar5, 2131889686, new Object[0], null, 4), cVar5).d, "binding.acceptGiftBodyText", gift3.isAnyNitroGift() ? b.a.k.b.k(cVar5, 2131889657, new Object[]{name3, cVar5.i(gift3)}, null, 4) : b.a.k.b.k(cVar5, 2131889656, new Object[]{name3}, null, 4), cVar5).f;
                m.checkNotNullExpressionValue(linearLayout4, "binding.acceptGiftDisclaimerContainer");
                linearLayout4.setVisibility(gift3.isAnyNitroGift() ? 0 : 8);
            } else if (obj instanceof StoreGifting$GiftState$RedeemedFailed) {
                c cVar6 = this.this$0;
                StoreGifting$GiftState$RedeemedFailed storeGifting$GiftState$RedeemedFailed = (StoreGifting$GiftState$RedeemedFailed) obj;
                m.checkNotNullExpressionValue(c_a_a2, "giftUiState");
                KProperty[] kPropertyArr6 = c.j;
                Objects.requireNonNull(cVar6);
                cVar6.g(storeGifting$GiftState$RedeemedFailed.getGift(), c_a_a2);
                TextView textView3 = cVar6.h().i;
                m.checkNotNullExpressionValue(textView3, "binding.acceptGiftHeader");
                textView3.setText(b.a.k.b.k(cVar6, 2131889688, new Object[0], null, 4));
                TextView textView4 = cVar6.h().d;
                m.checkNotNullExpressionValue(textView4, "binding.acceptGiftBodyText");
                b.a.k.b.n(textView4, 2131889677, new Object[0], null, 4);
                if (storeGifting$GiftState$RedeemedFailed.getCanRetry()) {
                    TextView textView5 = cVar6.h().d;
                    m.checkNotNullExpressionValue(textView5, "binding.acceptGiftBodyText");
                    b.a.k.b.n(textView5, 2131889677, new Object[0], null, 4);
                    MaterialButton materialButton5 = cVar6.h().e;
                    m.checkNotNullExpressionValue(materialButton5, "binding.acceptGiftConfirm");
                    Context context2 = cVar6.getContext();
                    materialButton5.setText(context2 != null ? context2.getText(2131894844) : null);
                    cVar6.h().e.setOnClickListener(new g(0, storeGifting$GiftState$RedeemedFailed));
                } else {
                    Integer errorCode = storeGifting$GiftState$RedeemedFailed.getErrorCode();
                    if (errorCode != null && errorCode.intValue() == 50054) {
                        cVar6.h().d.setText(2131889664);
                    } else if (errorCode != null && errorCode.intValue() == 100024) {
                        cVar6.h().d.setText(2131889660);
                    } else if (errorCode != null && errorCode.intValue() == 100022) {
                        cVar6.h().d.setText(2131889661);
                    } else if (errorCode != null && errorCode.intValue() == 100025) {
                        cVar6.h().d.setText(2131889659);
                    }
                    MaterialButton materialButton6 = cVar6.h().e;
                    m.checkNotNullExpressionValue(materialButton6, "binding.acceptGiftConfirm");
                    Context context3 = cVar6.getContext();
                    materialButton6.setText(context3 != null ? context3.getText(2131889681) : null);
                    cVar6.h().e.setOnClickListener(new g(1, cVar6));
                }
            } else if ((obj instanceof StoreGifting$GiftState$Invalid) || (obj instanceof StoreGifting$GiftState$LoadFailed) || (obj instanceof StoreGifting$GiftState$Revoking)) {
                this.this$0.dismiss();
            }
        }
        return Unit.a;
    }
}
