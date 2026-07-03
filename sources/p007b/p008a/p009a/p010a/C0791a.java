package p007b.p008a.p009a.p010a;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.app.AppViewFlipper;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.premium.GuildBoostUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p000.C12788k;
import p007b.p008a.p009a.p010a.C0801k;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p025i.C1058u;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: renamed from: b.a.a.a.a */
/* JADX INFO: compiled from: GuildBoostUncancelDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0791a extends AppDialog {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f167j = {C1643a.m846d0(C0791a.class, "binding", "getBinding()Lcom/discord/databinding/GuildBoostUncancelDialogBinding;", 0)};

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final Lazy viewModel;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final Lazy slotId;

    /* JADX INFO: renamed from: b.a.a.a.a$a */
    /* JADX INFO: compiled from: java-style lambda group */
    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ int f172j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ Object f173k;

        public a(int i, Object obj) {
            this.f172j = i;
            this.f173k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i = this.f172j;
            if (i == 0) {
                C0801k c0801k = (C0801k) ((C0791a) this.f173k).viewModel.getValue();
                C0801k.c viewState = c0801k.getViewState();
                if (C12238m.areEqual(viewState, C0801k.c.C13205c.f222a)) {
                    return;
                }
                if ((viewState instanceof C0801k.c.b) || (viewState instanceof C0801k.c.a)) {
                    c0801k.updateViewState(new C0801k.c.a(null, 1));
                    return;
                }
                return;
            }
            if (i != 1) {
                throw null;
            }
            C0801k c0801k2 = (C0801k) ((C0791a) this.f173k).viewModel.getValue();
            C0801k.c viewState2 = c0801k2.getViewState();
            if (C12238m.areEqual(viewState2, C0801k.c.C13205c.f222a)) {
                return;
            }
            if (!(viewState2 instanceof C0801k.c.b)) {
                if ((viewState2 instanceof C0801k.c.d) || (viewState2 instanceof C0801k.c.a)) {
                    c0801k2.updateViewState(new C0801k.c.a(null, 1));
                    return;
                }
                return;
            }
            C0801k.c viewState3 = c0801k2.getViewState();
            Objects.requireNonNull(viewState3, "null cannot be cast to non-null type com.discord.dialogs.guildboost.GuildBoostUncancelViewModel.ViewState.Loaded");
            if (((C0801k.c.b) viewState3).f220b) {
                return;
            }
            C0801k.c viewState4 = c0801k2.getViewState();
            if (!(viewState4 instanceof C0801k.c.b)) {
                viewState4 = null;
            }
            C0801k.c.b bVar = (C0801k.c.b) viewState4;
            if (bVar != null) {
                c0801k2.updateViewState(C0801k.c.b.m102a(bVar, null, true, false, 5));
                ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(GuildBoostUtils.INSTANCE.uncancelGuildBoostSlot(c0801k2.f216n, c0801k2.f213k, bVar.f219a, c0801k2.f215m), c0801k2, null, 2, null), (Class<?>) C0801k.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C0802l(c0801k2, bVar));
            }
        }
    }

    /* JADX INFO: renamed from: b.a.a.a.a$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: GuildBoostUncancelDialog.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: b.a.a.a.a$c */
    /* JADX INFO: compiled from: GuildBoostUncancelDialog.kt */
    public static final /* synthetic */ class c extends C12236k implements Function1<View, C1058u> {

        /* JADX INFO: renamed from: j */
        public static final c f174j = new c();

        public c() {
            super(1, C1058u.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/GuildBoostUncancelDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public C1058u invoke(View view) {
            View view2 = view;
            C12238m.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.guild_boost_uncancel_body;
            TextView textView = (TextView) view2.findViewById(C5419R.id.guild_boost_uncancel_body);
            if (textView != null) {
                i = C5419R.id.guild_boost_uncancel_confirm;
                LoadingButton loadingButton = (LoadingButton) view2.findViewById(C5419R.id.guild_boost_uncancel_confirm);
                if (loadingButton != null) {
                    i = C5419R.id.guild_boost_uncancel_error;
                    TextView textView2 = (TextView) view2.findViewById(C5419R.id.guild_boost_uncancel_error);
                    if (textView2 != null) {
                        i = C5419R.id.guild_boost_uncancel_flipper;
                        AppViewFlipper appViewFlipper = (AppViewFlipper) view2.findViewById(C5419R.id.guild_boost_uncancel_flipper);
                        if (appViewFlipper != null) {
                            i = C5419R.id.guild_boost_uncancel_header;
                            TextView textView3 = (TextView) view2.findViewById(C5419R.id.guild_boost_uncancel_header);
                            if (textView3 != null) {
                                i = C5419R.id.guild_boost_uncancel_image;
                                ImageView imageView = (ImageView) view2.findViewById(C5419R.id.guild_boost_uncancel_image);
                                if (imageView != null) {
                                    i = C5419R.id.guild_boost_uncancel_nevermind;
                                    MaterialButton materialButton = (MaterialButton) view2.findViewById(C5419R.id.guild_boost_uncancel_nevermind);
                                    if (materialButton != null) {
                                        i = C5419R.id.notice_header_container;
                                        LinearLayout linearLayout = (LinearLayout) view2.findViewById(C5419R.id.notice_header_container);
                                        if (linearLayout != null) {
                                            return new C1058u((LinearLayout) view2, textView, loadingButton, textView2, appViewFlipper, textView3, imageView, materialButton, linearLayout);
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

    /* JADX INFO: renamed from: b.a.a.a.a$d */
    /* JADX INFO: compiled from: GuildBoostUncancelDialog.kt */
    public static final class d extends AbstractC12240o implements Function1<C0801k.c, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(C0801k.c cVar) {
            C0801k.c cVar2 = cVar;
            C0791a c0791a = C0791a.this;
            C12238m.checkNotNullExpressionValue(cVar2, "it");
            KProperty[] kPropertyArr = C0791a.f167j;
            AppViewFlipper appViewFlipper = c0791a.m98g().f1269e;
            C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.guildBoostUncancelFlipper");
            appViewFlipper.setDisplayedChild(!(cVar2 instanceof C0801k.c.C13205c) ? 1 : 0);
            TextView textView = c0791a.m98g().f1268d;
            C12238m.checkNotNullExpressionValue(textView, "binding.guildBoostUncancelError");
            boolean z2 = cVar2 instanceof C0801k.c.b;
            textView.setVisibility(z2 && ((C0801k.c.b) cVar2).f221c ? 0 : 8);
            MaterialButton materialButton = c0791a.m98g().f1272h;
            C12238m.checkNotNullExpressionValue(materialButton, "binding.guildBoostUncancelNevermind");
            materialButton.setVisibility(z2 ? 0 : 8);
            MaterialButton materialButton2 = c0791a.m98g().f1272h;
            C12238m.checkNotNullExpressionValue(materialButton2, "binding.guildBoostUncancelNevermind");
            ViewExtensions.setEnabledAndAlpha$default(materialButton2, z2 && !((C0801k.c.b) cVar2).f220b, 0.0f, 2, null);
            c0791a.m98g().f1267c.setIsLoading(z2 && ((C0801k.c.b) cVar2).f220b);
            C0801k.c.C13205c c13205c = C0801k.c.C13205c.f222a;
            c0791a.setCancelable((C12238m.areEqual(cVar2, c13205c) ^ true) && z2 && !((C0801k.c.b) cVar2).f220b);
            if (!C12238m.areEqual(cVar2, c13205c)) {
                if (z2) {
                    TextView textView2 = c0791a.m98g().f1270f;
                    C12238m.checkNotNullExpressionValue(textView2, "binding.guildBoostUncancelHeader");
                    textView2.setText(c0791a.getString(C5419R.string.premium_guild_subscription_inventory_uncancel_title_mobile));
                    TextView textView3 = c0791a.m98g().f1266b;
                    C12238m.checkNotNullExpressionValue(textView3, "binding.guildBoostUncancelBody");
                    textView3.setText(c0791a.getString(C5419R.string.premium_guild_subscription_inventory_uncancel_description));
                } else if (C12238m.areEqual(cVar2, C0801k.c.d.f223a)) {
                    TextView textView4 = c0791a.m98g().f1270f;
                    C12238m.checkNotNullExpressionValue(textView4, "binding.guildBoostUncancelHeader");
                    textView4.setText(c0791a.getString(C5419R.string.premium_guild_subscription_inventory_uncancel_confirm_title));
                    ImageView imageView = c0791a.m98g().f1271g;
                    C12238m.checkNotNullExpressionValue(imageView, "binding.guildBoostUncancelImage");
                    imageView.setVisibility(0);
                    TextView textView5 = c0791a.m98g().f1266b;
                    C12238m.checkNotNullExpressionValue(textView5, "binding.guildBoostUncancelBody");
                    textView5.setText(c0791a.getString(C5419R.string.f14786x8c928042));
                    c0791a.m98g().f1267c.setText(c0791a.getString(C5419R.string.okay));
                } else if (cVar2 instanceof C0801k.c.a) {
                    Integer num = ((C0801k.c.a) cVar2).f218a;
                    if (num != null) {
                        C0876m.m171i(c0791a, num.intValue(), 0, 4);
                    }
                    c0791a.dismiss();
                }
            }
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.a.a.a$e */
    /* JADX INFO: compiled from: GuildBoostUncancelDialog.kt */
    public static final class e extends AbstractC12240o implements Function0<Long> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Long invoke() {
            Bundle arguments = C0791a.this.getArguments();
            Long lValueOf = arguments != null ? Long.valueOf(arguments.getLong("extra_slot_id")) : null;
            Objects.requireNonNull(lValueOf, "null cannot be cast to non-null type com.discord.primitives.GuildBoostSlotId /* = kotlin.Long */");
            return Long.valueOf(lValueOf.longValue());
        }
    }

    /* JADX INFO: renamed from: b.a.a.a.a$f */
    /* JADX INFO: compiled from: GuildBoostUncancelDialog.kt */
    public static final class f extends AbstractC12240o implements Function0<C0801k> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public C0801k invoke() {
            return new C0801k(((Number) C0791a.this.slotId.getValue()).longValue(), null, null, null, null, 30);
        }
    }

    public C0791a() {
        super(C5419R.layout.guild_boost_uncancel_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, c.f174j, null, 2, null);
        f fVar = new f();
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(C0801k.class), new C12788k(3, c0865g0), new C0869i0(fVar));
        this.slotId = C12083g.lazy(new e());
    }

    /* JADX INFO: renamed from: g */
    public final C1058u m98g() {
        return (C1058u) this.binding.getValue((Fragment) this, f167j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        m98g().f1272h.setOnClickListener(new a(0, this));
        m98g().f1267c.setOnClickListener(new a(1, this));
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<C0801k.c> observableM11112r = ((C0801k) this.viewModel.getValue()).observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), (Class<?>) C0791a.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new d());
    }
}
