package com.discord.widgets.servers.member_verification;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.databinding.WidgetMemberVerificationSuccessBinding;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.servers.member_verification.MemberVerificationSuccessViewModel;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12145m;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: MemberVerificationSuccessDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MemberVerificationSuccessDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(MemberVerificationSuccessDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetMemberVerificationSuccessBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: MemberVerificationSuccessDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void enqueue(long guildId) {
            StoreNotices notices = StoreStream.INSTANCE.getNotices();
            String strM877t = C1643a.m877t("GUILD_JOIN_REQUEST_SUCCESS_", guildId);
            notices.requestToShow(new StoreNotices.Notice(strM877t, null, 0L, 0, false, C12145m.listOf(C12216a0.getOrCreateKotlinClass(WidgetHome.class)), 0L, false, 0L, new C9550x3988be99(guildId, notices, strM877t), 150, null));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationSuccessDialog$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: MemberVerificationSuccessDialog.kt */
    public static final /* synthetic */ class C95531 extends C12236k implements Function1<MemberVerificationSuccessViewModel.ViewState, Unit> {
        public C95531(MemberVerificationSuccessDialog memberVerificationSuccessDialog) {
            super(1, memberVerificationSuccessDialog, MemberVerificationSuccessDialog.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/member_verification/MemberVerificationSuccessViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MemberVerificationSuccessViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MemberVerificationSuccessViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((MemberVerificationSuccessDialog) this.receiver).configureUI(viewState);
        }
    }

    public MemberVerificationSuccessDialog() {
        super(C5419R.layout.widget_member_verification_success);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, MemberVerificationSuccessDialog$binding$2.INSTANCE, null, 2, null);
        MemberVerificationSuccessDialog$viewModel$2 memberVerificationSuccessDialog$viewModel$2 = new MemberVerificationSuccessDialog$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(MemberVerificationSuccessViewModel.class), new C9551x5c97b9d7(c0865g0), new C0869i0(memberVerificationSuccessDialog$viewModel$2));
    }

    private final void configureLoadedUI(MemberVerificationSuccessViewModel.ViewState.Loaded viewState) {
        TextView textView = getBinding().f17264c;
        C12238m.checkNotNullExpressionValue(textView, "binding.memberVerificationGuildName");
        textView.setText(C1107b.m213e(this, C5419R.string.lurker_mode_popout_success_header, new Object[]{viewState.getGuildName()}, (4 & 4) != 0 ? C1107b.a.f1490j : null));
        getBinding().f17263b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.member_verification.MemberVerificationSuccessDialog.configureLoadedUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), MemberVerificationSuccessDialog.this.getViewModel().getGuildId(), 0L, null, null, 12, null);
                MemberVerificationSuccessDialog.this.getViewModel().ackGuildJoinRequest();
            }
        });
    }

    private final void configureUI(MemberVerificationSuccessViewModel.ViewState viewState) {
        if (viewState instanceof MemberVerificationSuccessViewModel.ViewState.Loaded) {
            configureLoadedUI((MemberVerificationSuccessViewModel.ViewState.Loaded) viewState);
        } else {
            if (!(viewState instanceof MemberVerificationSuccessViewModel.ViewState.Acked)) {
                throw new NoWhenBranchMatchedException();
            }
            dismiss();
        }
    }

    private final WidgetMemberVerificationSuccessBinding getBinding() {
        return (WidgetMemberVerificationSuccessBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final MemberVerificationSuccessViewModel getViewModel() {
        return (MemberVerificationSuccessViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<MemberVerificationSuccessViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), (Class<?>) MemberVerificationSuccessDialog.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C95531(this));
    }
}
