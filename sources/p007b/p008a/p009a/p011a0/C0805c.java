package p007b.p008a.p009a.p011a0;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.api.application.Application;
import com.discord.api.premium.SubscriptionPlan;
import com.discord.app.AppDialog;
import com.discord.app.AppViewFlipper;
import com.discord.models.domain.ModelGift;
import com.discord.models.domain.ModelSku;
import com.discord.models.domain.ModelStoreListing;
import com.discord.rlottie.RLottieImageView;
import com.discord.stores.StoreGifting;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.gifting.GiftStyle;
import com.discord.utilities.gifting.GiftStyleKt;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.premium.BlockRussianPurchasesUtils;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.ViewCoroutineScopeKt;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.settings.premium.WidgetSettingsGifting;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import p000.ViewOnClickListenerC12383g;
import p007b.p008a.p018d.C0862f;
import p007b.p008a.p025i.C1007m4;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12113l;
import p507d0.p513e0.InterfaceC11230c;
import p507d0.p580t.C12147n;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;

/* JADX INFO: renamed from: b.a.a.a0.c */
/* JADX INFO: compiled from: WidgetGiftAcceptDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0805c extends AppDialog {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f232j = {C1643a.m846d0(C0805c.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAcceptGiftDialogBinding;", 0)};

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: b.a.a.a0.c$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: WidgetGiftAcceptDialog.kt */
    public static final class Companion {

        /* JADX INFO: renamed from: b.a.a.a0.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: WidgetGiftAcceptDialog.kt */
        public static final class C13206a {

            /* JADX INFO: renamed from: a */
            public final StoreGifting.GiftState f235a;

            /* JADX INFO: renamed from: b */
            public final boolean f236b;

            public C13206a(StoreGifting.GiftState giftState, boolean z2) {
                C12238m.checkNotNullParameter(giftState, "giftState");
                this.f235a = giftState;
                this.f236b = z2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C13206a)) {
                    return false;
                }
                C13206a c13206a = (C13206a) obj;
                return C12238m.areEqual(this.f235a, c13206a.f235a) && this.f236b == c13206a.f236b;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r1v3 */
            public int hashCode() {
                StoreGifting.GiftState giftState = this.f235a;
                int iHashCode = (giftState != null ? giftState.hashCode() : 0) * 31;
                boolean z2 = this.f236b;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                return iHashCode + r1;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("GiftUiState(giftState=");
                sbM833U.append(this.f235a);
                sbM833U.append(", reduceMotion=");
                return C1643a.m827O(sbM833U, this.f236b, ")");
            }
        }

        /* JADX INFO: renamed from: b.a.a.a0.c$a$b */
        /* JADX INFO: compiled from: WidgetGiftAcceptDialog.kt */
        public static final class b extends AbstractC12240o implements Function1<FragmentActivity, Boolean> {
            public final /* synthetic */ long $channelId;
            public final /* synthetic */ String $giftCode;
            public final /* synthetic */ String $source;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str, String str2, long j) {
                super(1);
                this.$giftCode = str;
                this.$source = str2;
                this.$channelId = j;
            }

            @Override // kotlin.jvm.functions.Function1
            public Boolean invoke(FragmentActivity fragmentActivity) {
                FragmentActivity fragmentActivity2 = fragmentActivity;
                C12238m.checkNotNullParameter(fragmentActivity2, "appActivity");
                StoreStream.INSTANCE.getAnalytics().trackOpenGiftAcceptModal(this.$giftCode, this.$source, this.$channelId);
                C0805c c0805c = new C0805c();
                Bundle bundle = new Bundle();
                bundle.putString("ARG_GIFT_CODE", this.$giftCode);
                c0805c.setArguments(bundle);
                FragmentManager supportFragmentManager = fragmentActivity2.getSupportFragmentManager();
                C12238m.checkNotNullExpressionValue(supportFragmentManager, "appActivity.supportFragmentManager");
                c0805c.show(supportFragmentManager, C12216a0.getOrCreateKotlinClass(C0805c.class).toString());
                return Boolean.TRUE;
            }
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX INFO: renamed from: a */
        public final void m107a(String str, String str2, long j) {
            C12238m.checkNotNullParameter(str, "giftCode");
            C12238m.checkNotNullParameter(str2, "source");
            if (BlockRussianPurchasesUtils.INSTANCE.getINSTANCE().showDialog()) {
                return;
            }
            C12238m.checkNotNullParameter(str, "giftCode");
            StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice("gift:" + str, null, 0L, 0, false, C12147n.listOf((Object[]) new InterfaceC11230c[]{C12216a0.getOrCreateKotlinClass(WidgetSettingsGifting.class), C12216a0.getOrCreateKotlinClass(WidgetHome.class)}), 0L, false, 0L, new b(str, str2, j), 150, null));
        }
    }

    /* JADX INFO: renamed from: b.a.a.a0.c$b */
    /* JADX INFO: compiled from: WidgetGiftAcceptDialog.kt */
    public static final /* synthetic */ class b extends C12236k implements Function1<View, C1007m4> {

        /* JADX INFO: renamed from: j */
        public static final b f237j = new b();

        public b() {
            super(1, C1007m4.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAcceptGiftDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public C1007m4 invoke(View view) {
            View view2 = view;
            C12238m.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.accept_gift_body_container;
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(C5419R.id.accept_gift_body_container);
            if (linearLayout != null) {
                i = C5419R.id.accept_gift_body_image;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view2.findViewById(C5419R.id.accept_gift_body_image);
                if (simpleDraweeView != null) {
                    i = C5419R.id.accept_gift_body_lottie;
                    RLottieImageView rLottieImageView = (RLottieImageView) view2.findViewById(C5419R.id.accept_gift_body_lottie);
                    if (rLottieImageView != null) {
                        i = C5419R.id.accept_gift_body_text;
                        TextView textView = (TextView) view2.findViewById(C5419R.id.accept_gift_body_text);
                        if (textView != null) {
                            i = C5419R.id.accept_gift_confirm;
                            MaterialButton materialButton = (MaterialButton) view2.findViewById(C5419R.id.accept_gift_confirm);
                            if (materialButton != null) {
                                i = C5419R.id.accept_gift_disclaimer_container;
                                LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(C5419R.id.accept_gift_disclaimer_container);
                                if (linearLayout2 != null) {
                                    i = C5419R.id.accept_gift_disclaimer_text;
                                    LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view2.findViewById(C5419R.id.accept_gift_disclaimer_text);
                                    if (linkifiedTextView != null) {
                                        i = C5419R.id.accept_gift_flipper;
                                        AppViewFlipper appViewFlipper = (AppViewFlipper) view2.findViewById(C5419R.id.accept_gift_flipper);
                                        if (appViewFlipper != null) {
                                            i = C5419R.id.accept_gift_header;
                                            TextView textView2 = (TextView) view2.findViewById(C5419R.id.accept_gift_header);
                                            if (textView2 != null) {
                                                i = C5419R.id.accept_gift_progress;
                                                ProgressBar progressBar = (ProgressBar) view2.findViewById(C5419R.id.accept_gift_progress);
                                                if (progressBar != null) {
                                                    return new C1007m4((LinearLayout) view2, linearLayout, simpleDraweeView, rLottieImageView, textView, materialButton, linearLayout2, linkifiedTextView, appViewFlipper, textView2, progressBar);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
        }
    }

    /* JADX INFO: renamed from: b.a.a.a0.c$c */
    /* JADX INFO: compiled from: WidgetGiftAcceptDialog.kt */
    @InterfaceC12188e(m10084c = "com.discord.dialogs.gifting.WidgetGiftAcceptDialog$configureUI$1$1", m10085f = "WidgetGiftAcceptDialog.kt", m10086l = {118}, m10087m = "invokeSuspend")
    public static final class c extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ RLottieImageView $this_apply;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(RLottieImageView rLottieImageView, Continuation continuation) {
            super(2, continuation);
            this.$this_apply = rLottieImageView;
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            return new c(this.$this_apply, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            C12238m.checkNotNullParameter(continuation2, "completion");
            return new c(this.$this_apply, continuation2).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                C12113l.throwOnFailure(obj);
                this.label = 1;
                if (C3404f.m4234P(200L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C12113l.throwOnFailure(obj);
            }
            this.$this_apply.m8449b();
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.a.a0.c$d */
    /* JADX INFO: compiled from: WidgetGiftAcceptDialog.kt */
    public static final class d<T1, T2, R> implements Func2<StoreGifting.GiftState, Boolean, Companion.C13206a> {

        /* JADX INFO: renamed from: j */
        public static final d f238j = new d();

        @Override // p658rx.functions.Func2
        public Companion.C13206a call(StoreGifting.GiftState giftState, Boolean bool) {
            StoreGifting.GiftState giftState2 = giftState;
            Boolean bool2 = bool;
            C12238m.checkNotNullExpressionValue(giftState2, "giftState");
            C12238m.checkNotNullExpressionValue(bool2, "reduceMotion");
            return new Companion.C13206a(giftState2, bool2.booleanValue());
        }
    }

    /* JADX INFO: renamed from: b.a.a.a0.c$e */
    /* JADX INFO: compiled from: WidgetGiftAcceptDialog.kt */
    public static final class e extends AbstractC12240o implements Function1<Companion.C13206a, Unit> {
        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Companion.C13206a c13206a) {
            ModelSku sku;
            ModelSku sku2;
            String name;
            CharSequence charSequenceM213e;
            ModelSku sku3;
            Companion.C13206a c13206a2 = c13206a;
            Object obj = c13206a2.f235a;
            if (obj instanceof StoreGifting.GiftState.Loading) {
                C0805c c0805c = C0805c.this;
                KProperty[] kPropertyArr = C0805c.f232j;
                AppViewFlipper appViewFlipper = c0805c.m105h().f1060h;
                C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.acceptGiftFlipper");
                appViewFlipper.setDisplayedChild(0);
            } else {
                if (obj instanceof StoreGifting.GiftState.Resolved) {
                    StoreGifting.GiftState.Resolved resolved = (StoreGifting.GiftState.Resolved) obj;
                    if (resolved.getGift().getRedeemed()) {
                        C0805c c0805c2 = C0805c.this;
                        C12238m.checkNotNullExpressionValue(c13206a2, "giftUiState");
                        KProperty[] kPropertyArr2 = C0805c.f232j;
                        Objects.requireNonNull(c0805c2);
                        ModelGift gift = resolved.getGift();
                        c0805c2.m104g(gift, c13206a2);
                        ModelStoreListing storeListing = gift.getStoreListing();
                        if (storeListing == null || (sku3 = storeListing.getSku()) == null || (name = sku3.getName()) == null) {
                            name = "";
                        }
                        CharSequence charSequenceM106i = c0805c2.m106i(gift);
                        CharSequence charSequenceM213e2 = gift.isAnyNitroGift() ? C1107b.m213e(c0805c2, C5419R.string.gift_confirmation_header_success_nitro, new Object[]{name}, (4 & 4) != 0 ? C1107b.a.f1490j : null) : C1107b.m213e(c0805c2, C5419R.string.gift_confirmation_header_success, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null);
                        if (gift.isNitroClassicGift()) {
                            charSequenceM213e = C1107b.m213e(c0805c2, C5419R.string.gift_confirmation_body_success_nitro_classic_mobile, new Object[]{charSequenceM106i}, (4 & 4) != 0 ? C1107b.a.f1490j : null);
                        } else {
                            charSequenceM213e = gift.isNitroGift() ? C1107b.m213e(c0805c2, C5419R.string.gift_confirmation_body_success_nitro_mobile, new Object[]{charSequenceM106i}, (4 & 4) != 0 ? C1107b.a.f1490j : null) : C1107b.m213e(c0805c2, C5419R.string.gift_confirmation_body_success_mobile, new Object[]{name}, (4 & 4) != 0 ? C1107b.a.f1490j : null);
                        }
                        LinearLayout linearLayout = C1643a.m882v0(C1643a.m882v0(c0805c2.m105h().f1061i, "binding.acceptGiftHeader", charSequenceM213e2, c0805c2).f1056d, "binding.acceptGiftBodyText", charSequenceM213e, c0805c2).f1058f;
                        C12238m.checkNotNullExpressionValue(linearLayout, "binding.acceptGiftDisclaimerContainer");
                        linearLayout.setVisibility(8);
                        MaterialButton materialButton = c0805c2.m105h().f1057e;
                        C12238m.checkNotNullExpressionValue(materialButton, "binding.acceptGiftConfirm");
                        Context context = c0805c2.getContext();
                        materialButton.setText(context != null ? context.getText(C5419R.string.gift_confirmation_button_success_mobile) : null);
                        c0805c2.m105h().f1057e.setOnClickListener(new ViewOnClickListenerC0806d(c0805c2));
                    } else if (resolved.getGift().getMaxUses() == resolved.getGift().getUses()) {
                        C0805c c0805c3 = C0805c.this;
                        C12238m.checkNotNullExpressionValue(c13206a2, "giftUiState");
                        KProperty[] kPropertyArr3 = C0805c.f232j;
                        Objects.requireNonNull(c0805c3);
                        c0805c3.m104g(resolved.getGift(), c13206a2);
                        TextView textView = c0805c3.m105h().f1061i;
                        C12238m.checkNotNullExpressionValue(textView, "binding.acceptGiftHeader");
                        C1107b.m221m(textView, C5419R.string.gift_confirmation_header_fail, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
                        TextView textView2 = c0805c3.m105h().f1056d;
                        C12238m.checkNotNullExpressionValue(textView2, "binding.acceptGiftBodyText");
                        C1107b.m221m(textView2, C5419R.string.gift_confirmation_body_claimed, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
                        LinearLayout linearLayout2 = c0805c3.m105h().f1058f;
                        C12238m.checkNotNullExpressionValue(linearLayout2, "binding.acceptGiftDisclaimerContainer");
                        linearLayout2.setVisibility(8);
                        MaterialButton materialButton2 = c0805c3.m105h().f1057e;
                        C12238m.checkNotNullExpressionValue(materialButton2, "binding.acceptGiftConfirm");
                        C1107b.m221m(materialButton2, C5419R.string.gift_confirmation_button_fail, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
                        c0805c3.m105h().f1057e.setOnClickListener(new ViewOnClickListenerC0807e(c0805c3));
                    } else {
                        C0805c c0805c4 = C0805c.this;
                        C12238m.checkNotNullExpressionValue(c13206a2, "giftUiState");
                        KProperty[] kPropertyArr4 = C0805c.f232j;
                        Objects.requireNonNull(c0805c4);
                        ModelGift gift2 = ((StoreGifting.HasGift) obj).getGift();
                        c0805c4.m104g(gift2, c13206a2);
                        ModelStoreListing storeListing2 = gift2.getStoreListing();
                        String name2 = (storeListing2 == null || (sku2 = storeListing2.getSku()) == null) ? null : sku2.getName();
                        LinearLayout linearLayout3 = C1643a.m882v0(C1643a.m882v0(c0805c4.m105h().f1061i, "binding.acceptGiftHeader", gift2.isAnyNitroGift() ? C1107b.m213e(c0805c4, C5419R.string.gift_confirmation_header_confirm_nitro, new Object[]{name2}, (4 & 4) != 0 ? C1107b.a.f1490j : null) : C1107b.m213e(c0805c4, C5419R.string.gift_confirmation_header_confirm, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null), c0805c4).f1056d, "binding.acceptGiftBodyText", gift2.isAnyNitroGift() ? C1107b.m213e(c0805c4, C5419R.string.gift_confirmation_body_confirm_nitro, new Object[]{name2, c0805c4.m106i(gift2)}, (4 & 4) != 0 ? C1107b.a.f1490j : null) : C1107b.m213e(c0805c4, C5419R.string.gift_confirmation_body_confirm, new Object[]{name2}, (4 & 4) != 0 ? C1107b.a.f1490j : null), c0805c4).f1058f;
                        C12238m.checkNotNullExpressionValue(linearLayout3, "binding.acceptGiftDisclaimerContainer");
                        linearLayout3.setVisibility(gift2.isAnyNitroGift() ? 0 : 8);
                        MaterialButton materialButton3 = c0805c4.m105h().f1057e;
                        C12238m.checkNotNullExpressionValue(materialButton3, "binding.acceptGiftConfirm");
                        C1107b.m221m(materialButton3, C5419R.string.gift_confirmation_button_confirm_mobile, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
                        c0805c4.m105h().f1057e.setOnClickListener(new ViewOnClickListenerC0808f(gift2));
                    }
                } else if (obj instanceof StoreGifting.GiftState.Redeeming) {
                    C0805c c0805c5 = C0805c.this;
                    C12238m.checkNotNullExpressionValue(c13206a2, "giftUiState");
                    KProperty[] kPropertyArr5 = C0805c.f232j;
                    Objects.requireNonNull(c0805c5);
                    ModelGift gift3 = ((StoreGifting.GiftState.Redeeming) obj).getGift();
                    c0805c5.m104g(gift3, c13206a2);
                    ModelStoreListing storeListing3 = gift3.getStoreListing();
                    String name3 = (storeListing3 == null || (sku = storeListing3.getSku()) == null) ? null : sku.getName();
                    MaterialButton materialButton4 = c0805c5.m105h().f1057e;
                    C12238m.checkNotNullExpressionValue(materialButton4, "binding.acceptGiftConfirm");
                    materialButton4.setVisibility(8);
                    ProgressBar progressBar = c0805c5.m105h().f1062j;
                    C12238m.checkNotNullExpressionValue(progressBar, "binding.acceptGiftProgress");
                    progressBar.setVisibility(0);
                    LinearLayout linearLayout4 = C1643a.m882v0(C1643a.m882v0(c0805c5.m105h().f1061i, "binding.acceptGiftHeader", gift3.isAnyNitroGift() ? C1107b.m213e(c0805c5, C5419R.string.gift_confirmation_header_confirm_nitro, new Object[]{name3}, (4 & 4) != 0 ? C1107b.a.f1490j : null) : C1107b.m213e(c0805c5, C5419R.string.gift_confirmation_header_confirm, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null), c0805c5).f1056d, "binding.acceptGiftBodyText", gift3.isAnyNitroGift() ? C1107b.m213e(c0805c5, C5419R.string.gift_confirmation_body_confirm_nitro, new Object[]{name3, c0805c5.m106i(gift3)}, (4 & 4) != 0 ? C1107b.a.f1490j : null) : C1107b.m213e(c0805c5, C5419R.string.gift_confirmation_body_confirm, new Object[]{name3}, (4 & 4) != 0 ? C1107b.a.f1490j : null), c0805c5).f1058f;
                    C12238m.checkNotNullExpressionValue(linearLayout4, "binding.acceptGiftDisclaimerContainer");
                    linearLayout4.setVisibility(gift3.isAnyNitroGift() ? 0 : 8);
                } else if (obj instanceof StoreGifting.GiftState.RedeemedFailed) {
                    C0805c c0805c6 = C0805c.this;
                    StoreGifting.GiftState.RedeemedFailed redeemedFailed = (StoreGifting.GiftState.RedeemedFailed) obj;
                    C12238m.checkNotNullExpressionValue(c13206a2, "giftUiState");
                    KProperty[] kPropertyArr6 = C0805c.f232j;
                    Objects.requireNonNull(c0805c6);
                    c0805c6.m104g(redeemedFailed.getGift(), c13206a2);
                    TextView textView3 = c0805c6.m105h().f1061i;
                    C12238m.checkNotNullExpressionValue(textView3, "binding.acceptGiftHeader");
                    textView3.setText(C1107b.m213e(c0805c6, C5419R.string.gift_confirmation_header_fail, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null));
                    TextView textView4 = c0805c6.m105h().f1056d;
                    C12238m.checkNotNullExpressionValue(textView4, "binding.acceptGiftBodyText");
                    C1107b.m221m(textView4, C5419R.string.gift_confirmation_body_unknown_error, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
                    if (redeemedFailed.getCanRetry()) {
                        TextView textView5 = c0805c6.m105h().f1056d;
                        C12238m.checkNotNullExpressionValue(textView5, "binding.acceptGiftBodyText");
                        C1107b.m221m(textView5, C5419R.string.gift_confirmation_body_unknown_error, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
                        MaterialButton materialButton5 = c0805c6.m105h().f1057e;
                        C12238m.checkNotNullExpressionValue(materialButton5, "binding.acceptGiftConfirm");
                        Context context2 = c0805c6.getContext();
                        materialButton5.setText(context2 != null ? context2.getText(C5419R.string.retry) : null);
                        c0805c6.m105h().f1057e.setOnClickListener(new ViewOnClickListenerC12383g(0, redeemedFailed));
                    } else {
                        Integer errorCode = redeemedFailed.getErrorCode();
                        if (errorCode != null && errorCode.intValue() == 50054) {
                            c0805c6.m105h().f1056d.setText(C5419R.string.gift_confirmation_body_self_gift_no_payment);
                        } else if (errorCode != null && errorCode.intValue() == 100024) {
                            c0805c6.m105h().f1056d.setText(C5419R.string.gift_confirmation_body_error_nitro_upgrade_downgrade);
                        } else if (errorCode != null && errorCode.intValue() == 100022) {
                            c0805c6.m105h().f1056d.setText(C5419R.string.gift_confirmation_body_error_subscription_managed);
                        } else if (errorCode != null && errorCode.intValue() == 100025) {
                            c0805c6.m105h().f1056d.setText(C5419R.string.gift_confirmation_body_error_invoice_open);
                        }
                        MaterialButton materialButton6 = c0805c6.m105h().f1057e;
                        C12238m.checkNotNullExpressionValue(materialButton6, "binding.acceptGiftConfirm");
                        Context context3 = c0805c6.getContext();
                        materialButton6.setText(context3 != null ? context3.getText(C5419R.string.gift_confirmation_button_fail) : null);
                        c0805c6.m105h().f1057e.setOnClickListener(new ViewOnClickListenerC12383g(1, c0805c6));
                    }
                } else if ((obj instanceof StoreGifting.GiftState.Invalid) || (obj instanceof StoreGifting.GiftState.LoadFailed) || (obj instanceof StoreGifting.GiftState.Revoking)) {
                    C0805c.this.dismiss();
                }
            }
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.a.a0.c$f */
    /* JADX INFO: compiled from: WidgetGiftAcceptDialog.kt */
    public static final class f extends AbstractC12240o implements Function1<Error, Unit> {
        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            C0805c.this.dismiss();
            return Unit.f27425a;
        }
    }

    public C0805c() {
        super(C5419R.layout.widget_accept_gift_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, b.f237j, null, 2, null);
    }

    /* JADX INFO: renamed from: g */
    public final void m104g(ModelGift gift, Companion.C13206a uiState) {
        ModelSku sku;
        Application application;
        String icon;
        ModelSku sku2;
        AppViewFlipper appViewFlipper = m105h().f1060h;
        C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.acceptGiftFlipper");
        appViewFlipper.setDisplayedChild(1);
        String applicationIcon$default = null;
        if (gift.isAnyNitroGift()) {
            GiftStyle customStyle = GiftStyleKt.getCustomStyle(gift);
            if (customStyle != null) {
                RLottieImageView rLottieImageView = m105h().f1055c;
                C12238m.checkNotNullExpressionValue(rLottieImageView, "binding.acceptGiftBodyLottie");
                rLottieImageView.setVisibility(0);
                SimpleDraweeView simpleDraweeView = m105h().f1054b;
                C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.acceptGiftBodyImage");
                simpleDraweeView.setVisibility(8);
                RLottieImageView rLottieImageView2 = m105h().f1055c;
                if (uiState.f236b) {
                    rLottieImageView2.setImageResource(customStyle.getStaticRes());
                } else {
                    int animRes = customStyle.getAnimRes();
                    RLottieImageView rLottieImageView3 = m105h().f1055c;
                    C12238m.checkNotNullExpressionValue(rLottieImageView3, "binding.acceptGiftBodyLottie");
                    int iDpToPixels = DimenUtils.dpToPixels(rLottieImageView3.getLayoutParams().width);
                    RLottieImageView rLottieImageView4 = m105h().f1055c;
                    C12238m.checkNotNullExpressionValue(rLottieImageView4, "binding.acceptGiftBodyLottie");
                    rLottieImageView2.m8450c(animRes, iDpToPixels, DimenUtils.dpToPixels(rLottieImageView4.getLayoutParams().height));
                    CoroutineScope coroutineScope = ViewCoroutineScopeKt.getCoroutineScope(rLottieImageView2);
                    if (coroutineScope != null) {
                        C3404f.m4211H0(coroutineScope, null, null, new c(rLottieImageView2, null), 3, null);
                    }
                }
                C12238m.checkNotNullExpressionValue(rLottieImageView2, "binding.acceptGiftBodyLo…  }\n          }\n        }");
            } else {
                MGImages mGImages = MGImages.INSTANCE;
                SimpleDraweeView simpleDraweeView2 = m105h().f1054b;
                C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.acceptGiftBodyImage");
                MGImages.setImage$default(mGImages, simpleDraweeView2, PremiumUtils.INSTANCE.getNitroGiftIcon(gift), (MGImages.ChangeDetector) null, 4, (Object) null);
            }
        } else {
            ModelStoreListing storeListing = gift.getStoreListing();
            if (storeListing != null && (sku = storeListing.getSku()) != null && (application = sku.getApplication()) != null && (icon = application.getIcon()) != null) {
                ModelStoreListing storeListing2 = gift.getStoreListing();
                applicationIcon$default = IconUtils.getApplicationIcon$default((storeListing2 == null || (sku2 = storeListing2.getSku()) == null) ? 0L : sku2.getApplicationId(), icon, 0, 4, (Object) null);
            }
            m105h().f1054b.setImageURI(applicationIcon$default);
        }
        MaterialButton materialButton = m105h().f1057e;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.acceptGiftConfirm");
        materialButton.setVisibility(0);
        ProgressBar progressBar = m105h().f1062j;
        C12238m.checkNotNullExpressionValue(progressBar, "binding.acceptGiftProgress");
        progressBar.setVisibility(8);
    }

    /* JADX INFO: renamed from: h */
    public final C1007m4 m105h() {
        return (C1007m4) this.binding.getValue((Fragment) this, f232j[0]);
    }

    /* JADX INFO: renamed from: i */
    public final CharSequence m106i(ModelGift gift) {
        int i;
        SubscriptionPlan subscriptionPlan = gift.getSubscriptionPlan();
        if (subscriptionPlan == null) {
            return "";
        }
        int iOrdinal = subscriptionPlan.getInterval().ordinal();
        if (iOrdinal == 0) {
            i = C5419R.plurals.gift_confirmation_nitro_time_frame_months_time;
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            i = C5419R.plurals.gift_confirmation_nitro_time_frame_years_time;
        }
        Context contextRequireContext = requireContext();
        C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        CharSequence i18nPluralString = StringResourceUtilsKt.getI18nPluralString(contextRequireContext, i, subscriptionPlan.getIntervalCount(), Integer.valueOf(subscriptionPlan.getIntervalCount()));
        int iOrdinal2 = subscriptionPlan.getInterval().ordinal();
        if (iOrdinal2 == 0) {
            return C1107b.m213e(this, C5419R.string.gift_confirmation_nitro_time_frame_months, new Object[]{i18nPluralString}, (4 & 4) != 0 ? C1107b.a.f1490j : null);
        }
        if (iOrdinal2 == 1) {
            return C1107b.m213e(this, C5419R.string.gift_confirmation_nitro_time_frame_years, new Object[]{i18nPluralString}, (4 & 4) != 0 ? C1107b.a.f1490j : null);
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        String string;
        Bundle arguments = getArguments();
        if (arguments != null && (string = arguments.getString("ARG_GIFT_CODE")) != null) {
            Companion companion = INSTANCE;
            C12238m.checkNotNullExpressionValue(string, "it");
            Objects.requireNonNull(companion);
            C12238m.checkNotNullParameter(string, "giftCode");
            String str = "gift:" + string;
            if (str != null) {
                StoreStream.INSTANCE.getNotices().markDialogSeen(str);
            }
        }
        super.onDestroy();
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("ARG_GIFT_CODE") : null;
        if (string == null) {
            dismiss();
            return;
        }
        LinkifiedTextView linkifiedTextView = m105h().f1059g;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.acceptGiftDisclaimerText");
        C1107b.m221m(linkifiedTextView, C5419R.string.gift_confirmation_body_confirm_nitro_disclaimer, new Object[]{C0862f.f507a.m149a(360055386693L, null)}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableM11076j = Observable.m11076j(companion.getGifting().requestGift(string), companion.getAccessibility().observeReducedMotionEnabled(), d.f238j);
        C12238m.checkNotNullExpressionValue(observableM11076j, "Observable.combineLatest…iftState, reduceMotion) }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11076j, this, null, 2, null), (Class<?>) C0805c.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new f()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new e());
    }
}
