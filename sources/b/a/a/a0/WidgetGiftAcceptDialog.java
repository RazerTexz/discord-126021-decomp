package b.a.a.a0;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import b.a.d.AppHelpDesk;
import b.a.i.WidgetAcceptGiftDialogBinding;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
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
import com.discord.utilities.gifting.GiftStyle3;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.premium.BlockRussianPurchasesUtils;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.ViewCoroutineScope;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.settings.premium.WidgetSettingsGifting;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import d0.Result3;
import d0.e0.KClass;
import d0.t.Collections2;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import defpackage.g;
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
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;

/* JADX INFO: renamed from: b.a.a.a0.c, reason: use source file name */
/* JADX INFO: compiled from: WidgetGiftAcceptDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGiftAcceptDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {outline.d0(WidgetGiftAcceptDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAcceptGiftDialogBinding;", 0)};

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: b.a.a.a0.c$a, reason: from kotlin metadata */
    /* JADX INFO: compiled from: WidgetGiftAcceptDialog.kt */
    public static final class Companion {

        /* JADX INFO: renamed from: b.a.a.a0.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: WidgetGiftAcceptDialog.kt */
        public static final class C0010a {
            public final StoreGifting.GiftState a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final boolean f44b;

            public C0010a(StoreGifting.GiftState giftState, boolean z2) {
                Intrinsics3.checkNotNullParameter(giftState, "giftState");
                this.a = giftState;
                this.f44b = z2;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0010a)) {
                    return false;
                }
                C0010a c0010a = (C0010a) obj;
                return Intrinsics3.areEqual(this.a, c0010a.a) && this.f44b == c0010a.f44b;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r1v3 */
            public int hashCode() {
                StoreGifting.GiftState giftState = this.a;
                int iHashCode = (giftState != null ? giftState.hashCode() : 0) * 31;
                boolean z2 = this.f44b;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                return iHashCode + r1;
            }

            public String toString() {
                StringBuilder sbU = outline.U("GiftUiState(giftState=");
                sbU.append(this.a);
                sbU.append(", reduceMotion=");
                return outline.O(sbU, this.f44b, ")");
            }
        }

        /* JADX INFO: renamed from: b.a.a.a0.c$a$b */
        /* JADX INFO: compiled from: WidgetGiftAcceptDialog.kt */
        public static final class b extends Lambda implements Function1<FragmentActivity, Boolean> {
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
                Intrinsics3.checkNotNullParameter(fragmentActivity2, "appActivity");
                StoreStream.INSTANCE.getAnalytics().trackOpenGiftAcceptModal(this.$giftCode, this.$source, this.$channelId);
                WidgetGiftAcceptDialog widgetGiftAcceptDialog = new WidgetGiftAcceptDialog();
                Bundle bundle = new Bundle();
                bundle.putString("ARG_GIFT_CODE", this.$giftCode);
                widgetGiftAcceptDialog.setArguments(bundle);
                FragmentManager supportFragmentManager = fragmentActivity2.getSupportFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "appActivity.supportFragmentManager");
                widgetGiftAcceptDialog.show(supportFragmentManager, Reflection2.getOrCreateKotlinClass(WidgetGiftAcceptDialog.class).toString());
                return Boolean.TRUE;
            }
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final void a(String str, String str2, long j) {
            Intrinsics3.checkNotNullParameter(str, "giftCode");
            Intrinsics3.checkNotNullParameter(str2, "source");
            if (BlockRussianPurchasesUtils.INSTANCE.getINSTANCE().showDialog()) {
                return;
            }
            Intrinsics3.checkNotNullParameter(str, "giftCode");
            StoreStream.INSTANCE.getNotices().requestToShow(new StoreNotices.Notice("gift:" + str, null, 0L, 0, false, Collections2.listOf((Object[]) new KClass[]{Reflection2.getOrCreateKotlinClass(WidgetSettingsGifting.class), Reflection2.getOrCreateKotlinClass(WidgetHome.class)}), 0L, false, 0L, new b(str, str2, j), 150, null));
        }
    }

    /* JADX INFO: renamed from: b.a.a.a0.c$b */
    /* JADX INFO: compiled from: WidgetGiftAcceptDialog.kt */
    public static final /* synthetic */ class b extends FunctionReferenceImpl implements Function1<View, WidgetAcceptGiftDialogBinding> {
        public static final b j = new b();

        public b() {
            super(1, WidgetAcceptGiftDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetAcceptGiftDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public WidgetAcceptGiftDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.id.accept_gift_body_container;
            LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.accept_gift_body_container);
            if (linearLayout != null) {
                i = R.id.accept_gift_body_image;
                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view2.findViewById(R.id.accept_gift_body_image);
                if (simpleDraweeView != null) {
                    i = R.id.accept_gift_body_lottie;
                    RLottieImageView rLottieImageView = (RLottieImageView) view2.findViewById(R.id.accept_gift_body_lottie);
                    if (rLottieImageView != null) {
                        i = R.id.accept_gift_body_text;
                        TextView textView = (TextView) view2.findViewById(R.id.accept_gift_body_text);
                        if (textView != null) {
                            i = R.id.accept_gift_confirm;
                            MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.accept_gift_confirm);
                            if (materialButton != null) {
                                i = R.id.accept_gift_disclaimer_container;
                                LinearLayout linearLayout2 = (LinearLayout) view2.findViewById(R.id.accept_gift_disclaimer_container);
                                if (linearLayout2 != null) {
                                    i = R.id.accept_gift_disclaimer_text;
                                    LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view2.findViewById(R.id.accept_gift_disclaimer_text);
                                    if (linkifiedTextView != null) {
                                        i = R.id.accept_gift_flipper;
                                        AppViewFlipper appViewFlipper = (AppViewFlipper) view2.findViewById(R.id.accept_gift_flipper);
                                        if (appViewFlipper != null) {
                                            i = R.id.accept_gift_header;
                                            TextView textView2 = (TextView) view2.findViewById(R.id.accept_gift_header);
                                            if (textView2 != null) {
                                                i = R.id.accept_gift_progress;
                                                ProgressBar progressBar = (ProgressBar) view2.findViewById(R.id.accept_gift_progress);
                                                if (progressBar != null) {
                                                    return new WidgetAcceptGiftDialogBinding((LinearLayout) view2, linearLayout, simpleDraweeView, rLottieImageView, textView, materialButton, linearLayout2, linkifiedTextView, appViewFlipper, textView2, progressBar);
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
    @DebugMetadata(c = "com.discord.dialogs.gifting.WidgetGiftAcceptDialog$configureUI$1$1", f = "WidgetGiftAcceptDialog.kt", l = {118}, m = "invokeSuspend")
    public static final class c extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ RLottieImageView $this_apply;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(RLottieImageView rLottieImageView, Continuation continuation) {
            super(2, continuation);
            this.$this_apply = rLottieImageView;
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new c(this.$this_apply, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics3.checkNotNullParameter(continuation2, "completion");
            return new c(this.$this_apply, continuation2).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                this.label = 1;
                if (b.i.a.f.e.o.f.P(200L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
            }
            this.$this_apply.b();
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.a.a0.c$d */
    /* JADX INFO: compiled from: WidgetGiftAcceptDialog.kt */
    public static final class d<T1, T2, R> implements Func2<StoreGifting.GiftState, Boolean, Companion.C0010a> {
        public static final d j = new d();

        @Override // rx.functions.Func2
        public Companion.C0010a call(StoreGifting.GiftState giftState, Boolean bool) {
            StoreGifting.GiftState giftState2 = giftState;
            Boolean bool2 = bool;
            Intrinsics3.checkNotNullExpressionValue(giftState2, "giftState");
            Intrinsics3.checkNotNullExpressionValue(bool2, "reduceMotion");
            return new Companion.C0010a(giftState2, bool2.booleanValue());
        }
    }

    /* JADX INFO: renamed from: b.a.a.a0.c$e */
    /* JADX INFO: compiled from: WidgetGiftAcceptDialog.kt */
    public static final class e extends Lambda implements Function1<Companion.C0010a, Unit> {
        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Companion.C0010a c0010a) {
            ModelSku sku;
            ModelSku sku2;
            String name;
            CharSequence charSequenceE;
            ModelSku sku3;
            Companion.C0010a c0010a2 = c0010a;
            Object obj = c0010a2.a;
            if (obj instanceof StoreGifting.GiftState.Loading) {
                WidgetGiftAcceptDialog widgetGiftAcceptDialog = WidgetGiftAcceptDialog.this;
                KProperty[] kPropertyArr = WidgetGiftAcceptDialog.j;
                AppViewFlipper appViewFlipper = widgetGiftAcceptDialog.h().h;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.acceptGiftFlipper");
                appViewFlipper.setDisplayedChild(0);
            } else {
                if (obj instanceof StoreGifting.GiftState.Resolved) {
                    StoreGifting.GiftState.Resolved resolved = (StoreGifting.GiftState.Resolved) obj;
                    if (resolved.getGift().getRedeemed()) {
                        WidgetGiftAcceptDialog widgetGiftAcceptDialog2 = WidgetGiftAcceptDialog.this;
                        Intrinsics3.checkNotNullExpressionValue(c0010a2, "giftUiState");
                        KProperty[] kPropertyArr2 = WidgetGiftAcceptDialog.j;
                        Objects.requireNonNull(widgetGiftAcceptDialog2);
                        ModelGift gift = resolved.getGift();
                        widgetGiftAcceptDialog2.g(gift, c0010a2);
                        ModelStoreListing storeListing = gift.getStoreListing();
                        if (storeListing == null || (sku3 = storeListing.getSku()) == null || (name = sku3.getName()) == null) {
                            name = "";
                        }
                        CharSequence charSequenceI = widgetGiftAcceptDialog2.i(gift);
                        CharSequence charSequenceE2 = gift.isAnyNitroGift() ? FormatUtils.e(widgetGiftAcceptDialog2, R.string.gift_confirmation_header_success_nitro, new Object[]{name}, (4 & 4) != 0 ? FormatUtils.a.j : null) : FormatUtils.e(widgetGiftAcceptDialog2, R.string.gift_confirmation_header_success, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null);
                        if (gift.isNitroClassicGift()) {
                            charSequenceE = FormatUtils.e(widgetGiftAcceptDialog2, R.string.gift_confirmation_body_success_nitro_classic_mobile, new Object[]{charSequenceI}, (4 & 4) != 0 ? FormatUtils.a.j : null);
                        } else {
                            charSequenceE = gift.isNitroGift() ? FormatUtils.e(widgetGiftAcceptDialog2, R.string.gift_confirmation_body_success_nitro_mobile, new Object[]{charSequenceI}, (4 & 4) != 0 ? FormatUtils.a.j : null) : FormatUtils.e(widgetGiftAcceptDialog2, R.string.gift_confirmation_body_success_mobile, new Object[]{name}, (4 & 4) != 0 ? FormatUtils.a.j : null);
                        }
                        LinearLayout linearLayout = outline.v0(outline.v0(widgetGiftAcceptDialog2.h().i, "binding.acceptGiftHeader", charSequenceE2, widgetGiftAcceptDialog2).d, "binding.acceptGiftBodyText", charSequenceE, widgetGiftAcceptDialog2).f;
                        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.acceptGiftDisclaimerContainer");
                        linearLayout.setVisibility(8);
                        MaterialButton materialButton = widgetGiftAcceptDialog2.h().e;
                        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.acceptGiftConfirm");
                        Context context = widgetGiftAcceptDialog2.getContext();
                        materialButton.setText(context != null ? context.getText(R.string.gift_confirmation_button_success_mobile) : null);
                        widgetGiftAcceptDialog2.h().e.setOnClickListener(new WidgetGiftAcceptDialog2(widgetGiftAcceptDialog2));
                    } else if (resolved.getGift().getMaxUses() == resolved.getGift().getUses()) {
                        WidgetGiftAcceptDialog widgetGiftAcceptDialog3 = WidgetGiftAcceptDialog.this;
                        Intrinsics3.checkNotNullExpressionValue(c0010a2, "giftUiState");
                        KProperty[] kPropertyArr3 = WidgetGiftAcceptDialog.j;
                        Objects.requireNonNull(widgetGiftAcceptDialog3);
                        widgetGiftAcceptDialog3.g(resolved.getGift(), c0010a2);
                        TextView textView = widgetGiftAcceptDialog3.h().i;
                        Intrinsics3.checkNotNullExpressionValue(textView, "binding.acceptGiftHeader");
                        FormatUtils.m(textView, R.string.gift_confirmation_header_fail, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
                        TextView textView2 = widgetGiftAcceptDialog3.h().d;
                        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.acceptGiftBodyText");
                        FormatUtils.m(textView2, R.string.gift_confirmation_body_claimed, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
                        LinearLayout linearLayout2 = widgetGiftAcceptDialog3.h().f;
                        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.acceptGiftDisclaimerContainer");
                        linearLayout2.setVisibility(8);
                        MaterialButton materialButton2 = widgetGiftAcceptDialog3.h().e;
                        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.acceptGiftConfirm");
                        FormatUtils.m(materialButton2, R.string.gift_confirmation_button_fail, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
                        widgetGiftAcceptDialog3.h().e.setOnClickListener(new WidgetGiftAcceptDialog3(widgetGiftAcceptDialog3));
                    } else {
                        WidgetGiftAcceptDialog widgetGiftAcceptDialog4 = WidgetGiftAcceptDialog.this;
                        Intrinsics3.checkNotNullExpressionValue(c0010a2, "giftUiState");
                        KProperty[] kPropertyArr4 = WidgetGiftAcceptDialog.j;
                        Objects.requireNonNull(widgetGiftAcceptDialog4);
                        ModelGift gift2 = ((StoreGifting.HasGift) obj).getGift();
                        widgetGiftAcceptDialog4.g(gift2, c0010a2);
                        ModelStoreListing storeListing2 = gift2.getStoreListing();
                        String name2 = (storeListing2 == null || (sku2 = storeListing2.getSku()) == null) ? null : sku2.getName();
                        LinearLayout linearLayout3 = outline.v0(outline.v0(widgetGiftAcceptDialog4.h().i, "binding.acceptGiftHeader", gift2.isAnyNitroGift() ? FormatUtils.e(widgetGiftAcceptDialog4, R.string.gift_confirmation_header_confirm_nitro, new Object[]{name2}, (4 & 4) != 0 ? FormatUtils.a.j : null) : FormatUtils.e(widgetGiftAcceptDialog4, R.string.gift_confirmation_header_confirm, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null), widgetGiftAcceptDialog4).d, "binding.acceptGiftBodyText", gift2.isAnyNitroGift() ? FormatUtils.e(widgetGiftAcceptDialog4, R.string.gift_confirmation_body_confirm_nitro, new Object[]{name2, widgetGiftAcceptDialog4.i(gift2)}, (4 & 4) != 0 ? FormatUtils.a.j : null) : FormatUtils.e(widgetGiftAcceptDialog4, R.string.gift_confirmation_body_confirm, new Object[]{name2}, (4 & 4) != 0 ? FormatUtils.a.j : null), widgetGiftAcceptDialog4).f;
                        Intrinsics3.checkNotNullExpressionValue(linearLayout3, "binding.acceptGiftDisclaimerContainer");
                        linearLayout3.setVisibility(gift2.isAnyNitroGift() ? 0 : 8);
                        MaterialButton materialButton3 = widgetGiftAcceptDialog4.h().e;
                        Intrinsics3.checkNotNullExpressionValue(materialButton3, "binding.acceptGiftConfirm");
                        FormatUtils.m(materialButton3, R.string.gift_confirmation_button_confirm_mobile, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
                        widgetGiftAcceptDialog4.h().e.setOnClickListener(new WidgetGiftAcceptDialog4(gift2));
                    }
                } else if (obj instanceof StoreGifting.GiftState.Redeeming) {
                    WidgetGiftAcceptDialog widgetGiftAcceptDialog5 = WidgetGiftAcceptDialog.this;
                    Intrinsics3.checkNotNullExpressionValue(c0010a2, "giftUiState");
                    KProperty[] kPropertyArr5 = WidgetGiftAcceptDialog.j;
                    Objects.requireNonNull(widgetGiftAcceptDialog5);
                    ModelGift gift3 = ((StoreGifting.GiftState.Redeeming) obj).getGift();
                    widgetGiftAcceptDialog5.g(gift3, c0010a2);
                    ModelStoreListing storeListing3 = gift3.getStoreListing();
                    String name3 = (storeListing3 == null || (sku = storeListing3.getSku()) == null) ? null : sku.getName();
                    MaterialButton materialButton4 = widgetGiftAcceptDialog5.h().e;
                    Intrinsics3.checkNotNullExpressionValue(materialButton4, "binding.acceptGiftConfirm");
                    materialButton4.setVisibility(8);
                    ProgressBar progressBar = widgetGiftAcceptDialog5.h().j;
                    Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.acceptGiftProgress");
                    progressBar.setVisibility(0);
                    LinearLayout linearLayout4 = outline.v0(outline.v0(widgetGiftAcceptDialog5.h().i, "binding.acceptGiftHeader", gift3.isAnyNitroGift() ? FormatUtils.e(widgetGiftAcceptDialog5, R.string.gift_confirmation_header_confirm_nitro, new Object[]{name3}, (4 & 4) != 0 ? FormatUtils.a.j : null) : FormatUtils.e(widgetGiftAcceptDialog5, R.string.gift_confirmation_header_confirm, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null), widgetGiftAcceptDialog5).d, "binding.acceptGiftBodyText", gift3.isAnyNitroGift() ? FormatUtils.e(widgetGiftAcceptDialog5, R.string.gift_confirmation_body_confirm_nitro, new Object[]{name3, widgetGiftAcceptDialog5.i(gift3)}, (4 & 4) != 0 ? FormatUtils.a.j : null) : FormatUtils.e(widgetGiftAcceptDialog5, R.string.gift_confirmation_body_confirm, new Object[]{name3}, (4 & 4) != 0 ? FormatUtils.a.j : null), widgetGiftAcceptDialog5).f;
                    Intrinsics3.checkNotNullExpressionValue(linearLayout4, "binding.acceptGiftDisclaimerContainer");
                    linearLayout4.setVisibility(gift3.isAnyNitroGift() ? 0 : 8);
                } else if (obj instanceof StoreGifting.GiftState.RedeemedFailed) {
                    WidgetGiftAcceptDialog widgetGiftAcceptDialog6 = WidgetGiftAcceptDialog.this;
                    StoreGifting.GiftState.RedeemedFailed redeemedFailed = (StoreGifting.GiftState.RedeemedFailed) obj;
                    Intrinsics3.checkNotNullExpressionValue(c0010a2, "giftUiState");
                    KProperty[] kPropertyArr6 = WidgetGiftAcceptDialog.j;
                    Objects.requireNonNull(widgetGiftAcceptDialog6);
                    widgetGiftAcceptDialog6.g(redeemedFailed.getGift(), c0010a2);
                    TextView textView3 = widgetGiftAcceptDialog6.h().i;
                    Intrinsics3.checkNotNullExpressionValue(textView3, "binding.acceptGiftHeader");
                    textView3.setText(FormatUtils.e(widgetGiftAcceptDialog6, R.string.gift_confirmation_header_fail, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null));
                    TextView textView4 = widgetGiftAcceptDialog6.h().d;
                    Intrinsics3.checkNotNullExpressionValue(textView4, "binding.acceptGiftBodyText");
                    FormatUtils.m(textView4, R.string.gift_confirmation_body_unknown_error, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
                    if (redeemedFailed.getCanRetry()) {
                        TextView textView5 = widgetGiftAcceptDialog6.h().d;
                        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.acceptGiftBodyText");
                        FormatUtils.m(textView5, R.string.gift_confirmation_body_unknown_error, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
                        MaterialButton materialButton5 = widgetGiftAcceptDialog6.h().e;
                        Intrinsics3.checkNotNullExpressionValue(materialButton5, "binding.acceptGiftConfirm");
                        Context context2 = widgetGiftAcceptDialog6.getContext();
                        materialButton5.setText(context2 != null ? context2.getText(R.string.retry) : null);
                        widgetGiftAcceptDialog6.h().e.setOnClickListener(new g(0, redeemedFailed));
                    } else {
                        Integer errorCode = redeemedFailed.getErrorCode();
                        if (errorCode != null && errorCode.intValue() == 50054) {
                            widgetGiftAcceptDialog6.h().d.setText(R.string.gift_confirmation_body_self_gift_no_payment);
                        } else if (errorCode != null && errorCode.intValue() == 100024) {
                            widgetGiftAcceptDialog6.h().d.setText(R.string.gift_confirmation_body_error_nitro_upgrade_downgrade);
                        } else if (errorCode != null && errorCode.intValue() == 100022) {
                            widgetGiftAcceptDialog6.h().d.setText(R.string.gift_confirmation_body_error_subscription_managed);
                        } else if (errorCode != null && errorCode.intValue() == 100025) {
                            widgetGiftAcceptDialog6.h().d.setText(R.string.gift_confirmation_body_error_invoice_open);
                        }
                        MaterialButton materialButton6 = widgetGiftAcceptDialog6.h().e;
                        Intrinsics3.checkNotNullExpressionValue(materialButton6, "binding.acceptGiftConfirm");
                        Context context3 = widgetGiftAcceptDialog6.getContext();
                        materialButton6.setText(context3 != null ? context3.getText(R.string.gift_confirmation_button_fail) : null);
                        widgetGiftAcceptDialog6.h().e.setOnClickListener(new g(1, widgetGiftAcceptDialog6));
                    }
                } else if ((obj instanceof StoreGifting.GiftState.Invalid) || (obj instanceof StoreGifting.GiftState.LoadFailed) || (obj instanceof StoreGifting.GiftState.Revoking)) {
                    WidgetGiftAcceptDialog.this.dismiss();
                }
            }
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.a.a0.c$f */
    /* JADX INFO: compiled from: WidgetGiftAcceptDialog.kt */
    public static final class f extends Lambda implements Function1<Error, Unit> {
        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetGiftAcceptDialog.this.dismiss();
            return Unit.a;
        }
    }

    public WidgetGiftAcceptDialog() {
        super(R.layout.widget_accept_gift_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, b.j, null, 2, null);
    }

    public final void g(ModelGift gift, Companion.C0010a uiState) {
        ModelSku sku;
        Application application;
        String icon;
        ModelSku sku2;
        AppViewFlipper appViewFlipper = h().h;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.acceptGiftFlipper");
        appViewFlipper.setDisplayedChild(1);
        String applicationIcon$default = null;
        if (gift.isAnyNitroGift()) {
            GiftStyle customStyle = GiftStyle3.getCustomStyle(gift);
            if (customStyle != null) {
                RLottieImageView rLottieImageView = h().c;
                Intrinsics3.checkNotNullExpressionValue(rLottieImageView, "binding.acceptGiftBodyLottie");
                rLottieImageView.setVisibility(0);
                SimpleDraweeView simpleDraweeView = h().f161b;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.acceptGiftBodyImage");
                simpleDraweeView.setVisibility(8);
                RLottieImageView rLottieImageView2 = h().c;
                if (uiState.f44b) {
                    rLottieImageView2.setImageResource(customStyle.getStaticRes());
                } else {
                    int animRes = customStyle.getAnimRes();
                    RLottieImageView rLottieImageView3 = h().c;
                    Intrinsics3.checkNotNullExpressionValue(rLottieImageView3, "binding.acceptGiftBodyLottie");
                    int iDpToPixels = DimenUtils.dpToPixels(rLottieImageView3.getLayoutParams().width);
                    RLottieImageView rLottieImageView4 = h().c;
                    Intrinsics3.checkNotNullExpressionValue(rLottieImageView4, "binding.acceptGiftBodyLottie");
                    rLottieImageView2.c(animRes, iDpToPixels, DimenUtils.dpToPixels(rLottieImageView4.getLayoutParams().height));
                    CoroutineScope coroutineScope = ViewCoroutineScope.getCoroutineScope(rLottieImageView2);
                    if (coroutineScope != null) {
                        b.i.a.f.e.o.f.H0(coroutineScope, null, null, new c(rLottieImageView2, null), 3, null);
                    }
                }
                Intrinsics3.checkNotNullExpressionValue(rLottieImageView2, "binding.acceptGiftBodyLo…  }\n          }\n        }");
            } else {
                MGImages mGImages = MGImages.INSTANCE;
                SimpleDraweeView simpleDraweeView2 = h().f161b;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.acceptGiftBodyImage");
                MGImages.setImage$default(mGImages, simpleDraweeView2, PremiumUtils.INSTANCE.getNitroGiftIcon(gift), (MGImages.ChangeDetector) null, 4, (Object) null);
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
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.acceptGiftConfirm");
        materialButton.setVisibility(0);
        ProgressBar progressBar = h().j;
        Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.acceptGiftProgress");
        progressBar.setVisibility(8);
    }

    public final WidgetAcceptGiftDialogBinding h() {
        return (WidgetAcceptGiftDialogBinding) this.binding.getValue((Fragment) this, j[0]);
    }

    public final CharSequence i(ModelGift gift) {
        int i;
        SubscriptionPlan subscriptionPlan = gift.getSubscriptionPlan();
        if (subscriptionPlan == null) {
            return "";
        }
        int iOrdinal = subscriptionPlan.getInterval().ordinal();
        if (iOrdinal == 0) {
            i = R.plurals.gift_confirmation_nitro_time_frame_months_time;
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            i = R.plurals.gift_confirmation_nitro_time_frame_years_time;
        }
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        CharSequence i18nPluralString = StringResourceUtils.getI18nPluralString(contextRequireContext, i, subscriptionPlan.getIntervalCount(), Integer.valueOf(subscriptionPlan.getIntervalCount()));
        int iOrdinal2 = subscriptionPlan.getInterval().ordinal();
        if (iOrdinal2 == 0) {
            return FormatUtils.e(this, R.string.gift_confirmation_nitro_time_frame_months, new Object[]{i18nPluralString}, (4 & 4) != 0 ? FormatUtils.a.j : null);
        }
        if (iOrdinal2 == 1) {
            return FormatUtils.e(this, R.string.gift_confirmation_nitro_time_frame_years, new Object[]{i18nPluralString}, (4 & 4) != 0 ? FormatUtils.a.j : null);
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        String string;
        Bundle arguments = getArguments();
        if (arguments != null && (string = arguments.getString("ARG_GIFT_CODE")) != null) {
            Companion companion = INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(string, "it");
            Objects.requireNonNull(companion);
            Intrinsics3.checkNotNullParameter(string, "giftCode");
            String str = "gift:" + string;
            if (str != null) {
                StoreStream.INSTANCE.getNotices().markDialogSeen(str);
            }
        }
        super.onDestroy();
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("ARG_GIFT_CODE") : null;
        if (string == null) {
            dismiss();
            return;
        }
        LinkifiedTextView linkifiedTextView = h().g;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.acceptGiftDisclaimerText");
        FormatUtils.m(linkifiedTextView, R.string.gift_confirmation_body_confirm_nitro_disclaimer, new Object[]{AppHelpDesk.a.a(360055386693L, null)}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable observableJ = Observable.j(companion.getGifting().requestGift(string), companion.getAccessibility().observeReducedMotionEnabled(), d.j);
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…iftState, reduceMotion) }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableJ, this, null, 2, null), (Class<?>) WidgetGiftAcceptDialog.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new f()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new e());
    }
}
