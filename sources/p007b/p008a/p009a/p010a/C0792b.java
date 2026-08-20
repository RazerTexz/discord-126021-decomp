package p007b.p008a.p009a.p010a;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.app.AppViewFlipper;
import com.discord.models.domain.ModelSubscription;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.premium.GuildBoostUtils;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import java.text.DateFormat;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p000.C12788k;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p025i.C1051t;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: renamed from: b.a.a.a.b */
/* JADX INFO: compiled from: GuildBoostCancelDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0792b extends AppDialog {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ KProperty[] f175j = {C1643a.m846d0(C0792b.class, "binding", "getBinding()Lcom/discord/databinding/GuildBoostCancelDialogBinding;", 0)};

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final Lazy viewModel;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final Lazy slotId;

    /* JADX INFO: renamed from: b.a.a.a.b$a */
    /* JADX INFO: compiled from: java-style lambda group */
    /* JADX INFO: loaded from: classes2.dex */
    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ int f180j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ Object f181k;

        public a(int i, Object obj) {
            this.f180j = i;
            this.f181k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ModelSubscription modelSubscription;
            int i = this.f180j;
            if (i == 0) {
                C0796f c0796f = (C0796f) ((C0792b) this.f181k).viewModel.getValue();
                C0796f.c viewState = c0796f.getViewState();
                if ((viewState instanceof C0796f.c.f) || (viewState instanceof C0796f.c.a)) {
                    return;
                }
                if ((viewState instanceof C0796f.c.e) || (viewState instanceof C0796f.c.d) || (viewState instanceof C0796f.c.b)) {
                    c0796f.updateViewState(new C0796f.c.C13204c(null, 1));
                    return;
                }
                return;
            }
            if (i != 1) {
                throw null;
            }
            C0796f c0796f2 = (C0796f) ((C0792b) this.f181k).viewModel.getValue();
            C0796f.c viewState2 = c0796f2.getViewState();
            if ((viewState2 instanceof C0796f.c.f) || (viewState2 instanceof C0796f.c.a)) {
                return;
            }
            if (!(viewState2 instanceof C0796f.c.e) && !(viewState2 instanceof C0796f.c.d)) {
                if (viewState2 instanceof C0796f.c.b) {
                    c0796f2.updateViewState(new C0796f.c.C13204c(null, 1));
                    return;
                }
                return;
            }
            C0796f.c viewState3 = c0796f2.getViewState();
            if (viewState3 instanceof C0796f.c.e) {
                modelSubscription = ((C0796f.c.e) viewState3).f207f;
            } else {
                modelSubscription = viewState3 instanceof C0796f.c.d ? ((C0796f.c.d) viewState3).f206f : null;
            }
            if (modelSubscription != null) {
                c0796f2.updateViewState(new C0796f.c.a(modelSubscription));
                ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(GuildBoostUtils.INSTANCE.cancelGuildBoostSlot(c0796f2.f195n, c0796f2.f192k, modelSubscription, c0796f2.f193l), c0796f2, null, 2, null), (Class<?>) C0796f.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C0797g(c0796f2, modelSubscription));
            }
        }
    }

    /* JADX INFO: renamed from: b.a.a.a.b$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: GuildBoostCancelDialog.kt */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: b.a.a.a.b$c */
    /* JADX INFO: compiled from: GuildBoostCancelDialog.kt */
    public static final /* synthetic */ class c extends C12236k implements Function1<View, C1051t> {

        /* JADX INFO: renamed from: j */
        public static final c f182j = new c();

        public c() {
            super(1, C1051t.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/GuildBoostCancelDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public C1051t invoke(View view) {
            View view2 = view;
            C12238m.checkNotNullParameter(view2, "p1");
            int i = C5419R.id.active_subscription_progress;
            ProgressBar progressBar = (ProgressBar) view2.findViewById(C5419R.id.active_subscription_progress);
            if (progressBar != null) {
                i = C5419R.id.guild_boost_cancel_body;
                TextView textView = (TextView) view2.findViewById(C5419R.id.guild_boost_cancel_body);
                if (textView != null) {
                    i = C5419R.id.guild_boost_cancel_confirm;
                    LoadingButton loadingButton = (LoadingButton) view2.findViewById(C5419R.id.guild_boost_cancel_confirm);
                    if (loadingButton != null) {
                        i = C5419R.id.guild_boost_cancel_error;
                        TextView textView2 = (TextView) view2.findViewById(C5419R.id.guild_boost_cancel_error);
                        if (textView2 != null) {
                            i = C5419R.id.guild_boost_cancel_flipper;
                            AppViewFlipper appViewFlipper = (AppViewFlipper) view2.findViewById(C5419R.id.guild_boost_cancel_flipper);
                            if (appViewFlipper != null) {
                                i = C5419R.id.guild_boost_cancel_header;
                                TextView textView3 = (TextView) view2.findViewById(C5419R.id.guild_boost_cancel_header);
                                if (textView3 != null) {
                                    i = C5419R.id.guild_boost_cancel_nevermind;
                                    MaterialButton materialButton = (MaterialButton) view2.findViewById(C5419R.id.guild_boost_cancel_nevermind);
                                    if (materialButton != null) {
                                        i = C5419R.id.notice_header_container;
                                        LinearLayout linearLayout = (LinearLayout) view2.findViewById(C5419R.id.notice_header_container);
                                        if (linearLayout != null) {
                                            return new C1051t((LinearLayout) view2, progressBar, textView, loadingButton, textView2, appViewFlipper, textView3, materialButton, linearLayout);
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

    /* JADX INFO: renamed from: b.a.a.a.b$d */
    /* JADX INFO: compiled from: GuildBoostCancelDialog.kt */
    public static final class d extends AbstractC12240o implements Function1<C0796f.c, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(C0796f.c cVar) {
            C0796f.c cVar2 = cVar;
            C0792b c0792b = C0792b.this;
            C12238m.checkNotNullExpressionValue(cVar2, "it");
            KProperty[] kPropertyArr = C0792b.f175j;
            TextView textView = c0792b.m99g().f1234d;
            C12238m.checkNotNullExpressionValue(textView, "binding.guildBoostCancelError");
            textView.setVisibility(cVar2.f198a ? 0 : 8);
            MaterialButton materialButton = c0792b.m99g().f1237g;
            C12238m.checkNotNullExpressionValue(materialButton, "binding.guildBoostCancelNevermind");
            materialButton.setVisibility(cVar2.f199b ? 0 : 8);
            MaterialButton materialButton2 = c0792b.m99g().f1237g;
            C12238m.checkNotNullExpressionValue(materialButton2, "binding.guildBoostCancelNevermind");
            ViewExtensions.setEnabledAndAlpha$default(materialButton2, cVar2.f200c, 0.0f, 2, null);
            c0792b.setCancelable(cVar2.f202e);
            c0792b.m99g().f1233c.setIsLoading(cVar2.f201d);
            AppViewFlipper appViewFlipper = c0792b.m99g().f1235e;
            C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.guildBoostCancelFlipper");
            appViewFlipper.setDisplayedChild(!(cVar2 instanceof C0796f.c.f) ? 1 : 0);
            if (cVar2 instanceof C0796f.c.e) {
                TimeUtils timeUtils = TimeUtils.INSTANCE;
                C0796f.c.e eVar = (C0796f.c.e) cVar2;
                String currentPeriodEnd = eVar.f207f.getCurrentPeriodEnd();
                Context contextRequireContext = c0792b.requireContext();
                C12238m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                String strRenderUtcDate$default = TimeUtils.renderUtcDate$default(timeUtils, currentPeriodEnd, contextRequireContext, (String) null, (DateFormat) null, 0, 28, (Object) null);
                if (eVar.f208g) {
                    TextView textView2 = c0792b.m99g().f1232b;
                    C12238m.checkNotNullExpressionValue(textView2, "binding.guildBoostCancelBody");
                    C1107b.m221m(textView2, C5419R.string.premium_guild_subscription_cancel_body_inventory, new Object[]{strRenderUtcDate$default}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
                } else {
                    TextView textView3 = c0792b.m99g().f1232b;
                    C12238m.checkNotNullExpressionValue(textView3, "binding.guildBoostCancelBody");
                    C1107b.m221m(textView3, C5419R.string.premium_guild_subscription_cancel_body_guild, new Object[]{strRenderUtcDate$default}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
                }
                c0792b.m99g().f1233c.setBackgroundColor(ColorCompat.getColor(c0792b, C5419R.color.status_red_500));
            } else if (cVar2 instanceof C0796f.c.b) {
                TextView textView4 = c0792b.m99g().f1236f;
                C12238m.checkNotNullExpressionValue(textView4, "binding.guildBoostCancelHeader");
                textView4.setText(c0792b.getString(C5419R.string.premium_guild_subscription_cancel_title_pending_cancellation));
                TextView textView5 = c0792b.m99g().f1232b;
                C12238m.checkNotNullExpressionValue(textView5, "binding.guildBoostCancelBody");
                TimeUtils timeUtils2 = TimeUtils.INSTANCE;
                String currentPeriodEnd2 = ((C0796f.c.b) cVar2).f204f.getCurrentPeriodEnd();
                Context contextRequireContext2 = c0792b.requireContext();
                C12238m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                C1107b.m221m(textView5, C5419R.string.premium_guild_subscription_confirm_body, new Object[]{TimeUtils.renderUtcDate$default(timeUtils2, currentPeriodEnd2, contextRequireContext2, (String) null, (DateFormat) null, 0, 28, (Object) null)}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
                c0792b.m99g().f1233c.setText(c0792b.getString(C5419R.string.okay));
                c0792b.m99g().f1233c.setBackgroundColor(ColorCompat.getThemedColor(c0792b, C5419R.attr.color_brand_500));
            } else if (cVar2 instanceof C0796f.c.C13204c) {
                Integer num = ((C0796f.c.C13204c) cVar2).f205f;
                if (num != null) {
                    C0876m.m169g(c0792b.requireContext(), num.intValue(), 0, null, 12);
                }
                c0792b.dismiss();
            }
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.a.a.b$e */
    /* JADX INFO: compiled from: GuildBoostCancelDialog.kt */
    public static final class e extends AbstractC12240o implements Function0<Long> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Long invoke() {
            Bundle arguments = C0792b.this.getArguments();
            Long lValueOf = arguments != null ? Long.valueOf(arguments.getLong("extra_slot_id")) : null;
            Objects.requireNonNull(lValueOf, "null cannot be cast to non-null type com.discord.primitives.GuildBoostSlotId /* = kotlin.Long */");
            return Long.valueOf(lValueOf.longValue());
        }
    }

    /* JADX INFO: renamed from: b.a.a.a.b$f */
    /* JADX INFO: compiled from: GuildBoostCancelDialog.kt */
    public static final class f extends AbstractC12240o implements Function0<C0796f> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public C0796f invoke() {
            return new C0796f(((Number) C0792b.this.slotId.getValue()).longValue(), null, null, null, null, 30);
        }
    }

    public C0792b() {
        super(C5419R.layout.guild_boost_cancel_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, c.f182j, null, 2, null);
        f fVar = new f();
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(C0796f.class), new C12788k(2, c0865g0), new C0869i0(fVar));
        this.slotId = C12083g.lazy(new e());
    }

    /* JADX INFO: renamed from: g */
    public final C1051t m99g() {
        return (C1051t) this.binding.getValue((Fragment) this, f175j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        m99g().f1237g.setOnClickListener(new a(0, this));
        m99g().f1233c.setOnClickListener(new a(1, this));
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<C0796f.c> observableM11112r = ((C0796f) this.viewModel.getValue()).observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), (Class<?>) C0792b.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new d());
    }
}
