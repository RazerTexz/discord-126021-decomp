package b.a.a.a;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.a.a.GuildBoostCancelViewModel3;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.i.GuildBoostCancelDialogBinding;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppDialog;
import com.discord.app.AppViewFlipper;
import com.discord.models.domain.ModelSubscription;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.premium.GuildBoostUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.LoadingButton;
import com.google.android.material.button.MaterialButton;
import d0.LazyJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.text.DateFormat;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: renamed from: b.a.a.a.b, reason: use source file name */
/* JADX INFO: compiled from: GuildBoostCancelDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildBoostCancelDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] j = {outline.d0(GuildBoostCancelDialog.class, "binding", "getBinding()Lcom/discord/databinding/GuildBoostCancelDialogBinding;", 0)};

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
        public final /* synthetic */ int j;
        public final /* synthetic */ Object k;

        public a(int i, Object obj) {
            this.j = i;
            this.k = obj;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ModelSubscription modelSubscription;
            int i = this.j;
            if (i == 0) {
                GuildBoostCancelViewModel3 guildBoostCancelViewModel3 = (GuildBoostCancelViewModel3) ((GuildBoostCancelDialog) this.k).viewModel.getValue();
                GuildBoostCancelViewModel3.c viewState = guildBoostCancelViewModel3.getViewState();
                if ((viewState instanceof GuildBoostCancelViewModel3.c.f) || (viewState instanceof GuildBoostCancelViewModel3.c.a)) {
                    return;
                }
                if ((viewState instanceof GuildBoostCancelViewModel3.c.e) || (viewState instanceof GuildBoostCancelViewModel3.c.d) || (viewState instanceof GuildBoostCancelViewModel3.c.b)) {
                    guildBoostCancelViewModel3.updateViewState(new GuildBoostCancelViewModel3.c.C0008c(null, 1));
                    return;
                }
                return;
            }
            if (i != 1) {
                throw null;
            }
            GuildBoostCancelViewModel3 guildBoostCancelViewModel4 = (GuildBoostCancelViewModel3) ((GuildBoostCancelDialog) this.k).viewModel.getValue();
            GuildBoostCancelViewModel3.c viewState2 = guildBoostCancelViewModel4.getViewState();
            if ((viewState2 instanceof GuildBoostCancelViewModel3.c.f) || (viewState2 instanceof GuildBoostCancelViewModel3.c.a)) {
                return;
            }
            if (!(viewState2 instanceof GuildBoostCancelViewModel3.c.e) && !(viewState2 instanceof GuildBoostCancelViewModel3.c.d)) {
                if (viewState2 instanceof GuildBoostCancelViewModel3.c.b) {
                    guildBoostCancelViewModel4.updateViewState(new GuildBoostCancelViewModel3.c.C0008c(null, 1));
                    return;
                }
                return;
            }
            GuildBoostCancelViewModel3.c viewState3 = guildBoostCancelViewModel4.getViewState();
            if (viewState3 instanceof GuildBoostCancelViewModel3.c.e) {
                modelSubscription = ((GuildBoostCancelViewModel3.c.e) viewState3).f;
            } else {
                modelSubscription = viewState3 instanceof GuildBoostCancelViewModel3.c.d ? ((GuildBoostCancelViewModel3.c.d) viewState3).f : null;
            }
            if (modelSubscription != null) {
                guildBoostCancelViewModel4.updateViewState(new GuildBoostCancelViewModel3.c.a(modelSubscription));
                ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(GuildBoostUtils.INSTANCE.cancelGuildBoostSlot(guildBoostCancelViewModel4.n, guildBoostCancelViewModel4.k, modelSubscription, guildBoostCancelViewModel4.l), guildBoostCancelViewModel4, null, 2, null), (Class<?>) GuildBoostCancelViewModel3.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new GuildBoostCancelViewModel4(guildBoostCancelViewModel4, modelSubscription));
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
    public static final /* synthetic */ class c extends FunctionReferenceImpl implements Function1<View, GuildBoostCancelDialogBinding> {
        public static final c j = new c();

        public c() {
            super(1, GuildBoostCancelDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/GuildBoostCancelDialogBinding;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public GuildBoostCancelDialogBinding invoke(View view) {
            View view2 = view;
            Intrinsics3.checkNotNullParameter(view2, "p1");
            int i = R.id.active_subscription_progress;
            ProgressBar progressBar = (ProgressBar) view2.findViewById(R.id.active_subscription_progress);
            if (progressBar != null) {
                i = R.id.guild_boost_cancel_body;
                TextView textView = (TextView) view2.findViewById(R.id.guild_boost_cancel_body);
                if (textView != null) {
                    i = R.id.guild_boost_cancel_confirm;
                    LoadingButton loadingButton = (LoadingButton) view2.findViewById(R.id.guild_boost_cancel_confirm);
                    if (loadingButton != null) {
                        i = R.id.guild_boost_cancel_error;
                        TextView textView2 = (TextView) view2.findViewById(R.id.guild_boost_cancel_error);
                        if (textView2 != null) {
                            i = R.id.guild_boost_cancel_flipper;
                            AppViewFlipper appViewFlipper = (AppViewFlipper) view2.findViewById(R.id.guild_boost_cancel_flipper);
                            if (appViewFlipper != null) {
                                i = R.id.guild_boost_cancel_header;
                                TextView textView3 = (TextView) view2.findViewById(R.id.guild_boost_cancel_header);
                                if (textView3 != null) {
                                    i = R.id.guild_boost_cancel_nevermind;
                                    MaterialButton materialButton = (MaterialButton) view2.findViewById(R.id.guild_boost_cancel_nevermind);
                                    if (materialButton != null) {
                                        i = R.id.notice_header_container;
                                        LinearLayout linearLayout = (LinearLayout) view2.findViewById(R.id.notice_header_container);
                                        if (linearLayout != null) {
                                            return new GuildBoostCancelDialogBinding((LinearLayout) view2, progressBar, textView, loadingButton, textView2, appViewFlipper, textView3, materialButton, linearLayout);
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
    public static final class d extends Lambda implements Function1<GuildBoostCancelViewModel3.c, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(GuildBoostCancelViewModel3.c cVar) {
            GuildBoostCancelViewModel3.c cVar2 = cVar;
            GuildBoostCancelDialog guildBoostCancelDialog = GuildBoostCancelDialog.this;
            Intrinsics3.checkNotNullExpressionValue(cVar2, "it");
            KProperty[] kPropertyArr = GuildBoostCancelDialog.j;
            TextView textView = guildBoostCancelDialog.g().d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildBoostCancelError");
            textView.setVisibility(cVar2.a ? 0 : 8);
            MaterialButton materialButton = guildBoostCancelDialog.g().g;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.guildBoostCancelNevermind");
            materialButton.setVisibility(cVar2.f42b ? 0 : 8);
            MaterialButton materialButton2 = guildBoostCancelDialog.g().g;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.guildBoostCancelNevermind");
            ViewExtensions.setEnabledAndAlpha$default(materialButton2, cVar2.c, 0.0f, 2, null);
            guildBoostCancelDialog.setCancelable(cVar2.e);
            guildBoostCancelDialog.g().c.setIsLoading(cVar2.d);
            AppViewFlipper appViewFlipper = guildBoostCancelDialog.g().e;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.guildBoostCancelFlipper");
            appViewFlipper.setDisplayedChild(!(cVar2 instanceof GuildBoostCancelViewModel3.c.f) ? 1 : 0);
            if (cVar2 instanceof GuildBoostCancelViewModel3.c.e) {
                TimeUtils timeUtils = TimeUtils.INSTANCE;
                GuildBoostCancelViewModel3.c.e eVar = (GuildBoostCancelViewModel3.c.e) cVar2;
                String currentPeriodEnd = eVar.f.getCurrentPeriodEnd();
                Context contextRequireContext = guildBoostCancelDialog.requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                String strRenderUtcDate$default = TimeUtils.renderUtcDate$default(timeUtils, currentPeriodEnd, contextRequireContext, (String) null, (DateFormat) null, 0, 28, (Object) null);
                if (eVar.g) {
                    TextView textView2 = guildBoostCancelDialog.g().f201b;
                    Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildBoostCancelBody");
                    FormatUtils.m(textView2, R.string.premium_guild_subscription_cancel_body_inventory, new Object[]{strRenderUtcDate$default}, (4 & 4) != 0 ? FormatUtils.g.j : null);
                } else {
                    TextView textView3 = guildBoostCancelDialog.g().f201b;
                    Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildBoostCancelBody");
                    FormatUtils.m(textView3, R.string.premium_guild_subscription_cancel_body_guild, new Object[]{strRenderUtcDate$default}, (4 & 4) != 0 ? FormatUtils.g.j : null);
                }
                guildBoostCancelDialog.g().c.setBackgroundColor(ColorCompat.getColor(guildBoostCancelDialog, R.color.status_red_500));
            } else if (cVar2 instanceof GuildBoostCancelViewModel3.c.b) {
                TextView textView4 = guildBoostCancelDialog.g().f;
                Intrinsics3.checkNotNullExpressionValue(textView4, "binding.guildBoostCancelHeader");
                textView4.setText(guildBoostCancelDialog.getString(R.string.premium_guild_subscription_cancel_title_pending_cancellation));
                TextView textView5 = guildBoostCancelDialog.g().f201b;
                Intrinsics3.checkNotNullExpressionValue(textView5, "binding.guildBoostCancelBody");
                TimeUtils timeUtils2 = TimeUtils.INSTANCE;
                String currentPeriodEnd2 = ((GuildBoostCancelViewModel3.c.b) cVar2).f.getCurrentPeriodEnd();
                Context contextRequireContext2 = guildBoostCancelDialog.requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
                FormatUtils.m(textView5, R.string.premium_guild_subscription_confirm_body, new Object[]{TimeUtils.renderUtcDate$default(timeUtils2, currentPeriodEnd2, contextRequireContext2, (String) null, (DateFormat) null, 0, 28, (Object) null)}, (4 & 4) != 0 ? FormatUtils.g.j : null);
                guildBoostCancelDialog.g().c.setText(guildBoostCancelDialog.getString(R.string.okay));
                guildBoostCancelDialog.g().c.setBackgroundColor(ColorCompat.getThemedColor(guildBoostCancelDialog, R.attr.color_brand_500));
            } else if (cVar2 instanceof GuildBoostCancelViewModel3.c.C0008c) {
                Integer num = ((GuildBoostCancelViewModel3.c.C0008c) cVar2).f;
                if (num != null) {
                    AppToast.g(guildBoostCancelDialog.requireContext(), num.intValue(), 0, null, 12);
                }
                guildBoostCancelDialog.dismiss();
            }
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.a.a.b$e */
    /* JADX INFO: compiled from: GuildBoostCancelDialog.kt */
    public static final class e extends Lambda implements Function0<Long> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Long invoke() {
            Bundle arguments = GuildBoostCancelDialog.this.getArguments();
            Long lValueOf = arguments != null ? Long.valueOf(arguments.getLong("extra_slot_id")) : null;
            Objects.requireNonNull(lValueOf, "null cannot be cast to non-null type com.discord.primitives.GuildBoostSlotId /* = kotlin.Long */");
            return Long.valueOf(lValueOf.longValue());
        }
    }

    /* JADX INFO: renamed from: b.a.a.a.b$f */
    /* JADX INFO: compiled from: GuildBoostCancelDialog.kt */
    public static final class f extends Lambda implements Function0<GuildBoostCancelViewModel3> {
        public f() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public GuildBoostCancelViewModel3 invoke() {
            return new GuildBoostCancelViewModel3(((Number) GuildBoostCancelDialog.this.slotId.getValue()).longValue(), null, null, null, null, 30);
        }
    }

    public GuildBoostCancelDialog() {
        super(R.layout.guild_boost_cancel_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, c.j, null, 2, null);
        f fVar = new f();
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildBoostCancelViewModel3.class), new defpackage.k(2, appViewModelDelegates3), new AppViewModelDelegates5(fVar));
        this.slotId = LazyJVM.lazy(new e());
    }

    public final GuildBoostCancelDialogBinding g() {
        return (GuildBoostCancelDialogBinding) this.binding.getValue((Fragment) this, j[0]);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        g().g.setOnClickListener(new a(0, this));
        g().c.setOnClickListener(new a(1, this));
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<GuildBoostCancelViewModel3.c> observableR = ((GuildBoostCancelViewModel3) this.viewModel.getValue()).observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), (Class<?>) GuildBoostCancelDialog.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new d());
    }
}
