package com.discord.widgets.status;

import android.content.res.ColorStateList;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetThreadStatusBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPIAbortMessages;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.LoadingButton;
import com.discord.widgets.status.WidgetThreadStatusViewModel;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0876m;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetThreadStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadStatus extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetThreadStatus.class, "binding", "getBinding()Lcom/discord/databinding/WidgetThreadStatusBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetThreadStatus.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: WidgetThreadStatus.kt */
        public static final /* data */ class Error extends Event {
            private final int code;

            public Error(int i) {
                super(null);
                this.code = i;
            }

            public static /* synthetic */ Error copy$default(Error error, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = error.code;
                }
                return error.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getCode() {
                return this.code;
            }

            public final Error copy(int code) {
                return new Error(code);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Error) && this.code == ((Error) other).code;
                }
                return true;
            }

            public final int getCode() {
                return this.code;
            }

            public int hashCode() {
                return this.code;
            }

            public String toString() {
                return C1643a.m814B(C1643a.m833U("Error(code="), this.code, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.status.WidgetThreadStatus$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetThreadStatus.kt */
    public static final class C101111 extends AbstractC12240o implements Function1<WidgetThreadStatusViewModel.ViewState, Unit> {
        public C101111() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadStatusViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetThreadStatusViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "viewState");
            WidgetThreadStatus.this.updateView(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.status.WidgetThreadStatus$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetThreadStatus.kt */
    public static final /* synthetic */ class C101122 extends C12236k implements Function1<Event, Unit> {
        public C101122(WidgetThreadStatus widgetThreadStatus) {
            super(1, widgetThreadStatus, WidgetThreadStatus.class, "handleEvent", "handleEvent(Lcom/discord/widgets/status/WidgetThreadStatus$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Event event) {
            C12238m.checkNotNullParameter(event, "p1");
            ((WidgetThreadStatus) this.receiver).handleEvent(event);
        }
    }

    public WidgetThreadStatus() {
        super(C5419R.layout.widget_thread_status);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetThreadStatus$binding$2.INSTANCE, null, 2, null);
        WidgetThreadStatus$viewModel$2 widgetThreadStatus$viewModel$2 = WidgetThreadStatus$viewModel$2.INSTANCE;
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetThreadStatusViewModel.class), new WidgetThreadStatus$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetThreadStatus$viewModel$2));
    }

    private final WidgetThreadStatusBinding getBinding() {
        return (WidgetThreadStatusBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetThreadStatusViewModel getViewModel() {
        return (WidgetThreadStatusViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(Event event) {
        if (event instanceof Event.Error) {
            Integer abortCodeMessageResId = RestAPIAbortMessages.getAbortCodeMessageResId(((Event.Error) event).getCode());
            C0876m.m171i(this, abortCodeMessageResId != null ? abortCodeMessageResId.intValue() : C5419R.string.network_error_bad_request, 0, 4);
        }
    }

    @MainThread
    private final void updateView(WidgetThreadStatusViewModel.ViewState viewState) {
        getBinding().f18291c.setIsLoading(viewState.isLoading());
        WidgetThreadStatusViewModel.Status threadStatus = viewState.getThreadStatus();
        if (threadStatus instanceof WidgetThreadStatusViewModel.Status.Hide) {
            ConstraintLayout constraintLayout = getBinding().f18290b;
            C12238m.checkNotNullExpressionValue(constraintLayout, "binding.threadStatus");
            constraintLayout.setVisibility(8);
            return;
        }
        if (threadStatus instanceof WidgetThreadStatusViewModel.Status.Archived) {
            ConstraintLayout constraintLayout2 = getBinding().f18290b;
            C12238m.checkNotNullExpressionValue(constraintLayout2, "binding.threadStatus");
            constraintLayout2.setVisibility(0);
            LoadingButton loadingButton = getBinding().f18291c;
            C12238m.checkNotNullExpressionValue(loadingButton, "binding.threadStatusButton");
            WidgetThreadStatusViewModel.Status.Archived archived = (WidgetThreadStatusViewModel.Status.Archived) threadStatus;
            loadingButton.setVisibility(archived.getCanArchive() ? 0 : 8);
            LinkifiedTextView linkifiedTextView = getBinding().f18292d;
            C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.threadStatusText");
            linkifiedTextView.setText(archived.isLocked() ? getResources().getString(C5419R.string.thread_header_notice_locked) : getResources().getString(C5419R.string.thread_header_notice_archived));
            getBinding().f18291c.setText(getResources().getString(C5419R.string.unarchive));
            LoadingButton loadingButton2 = getBinding().f18291c;
            C12238m.checkNotNullExpressionValue(loadingButton2, "binding.threadStatusButton");
            loadingButton2.setBackgroundTintList(ColorStateList.valueOf(ColorCompat.getThemedColor(getContext(), C5419R.attr.colorBackgroundAccent)));
            getBinding().f18291c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.status.WidgetThreadStatus.updateView.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetThreadStatus.this.getViewModel().onUnarchiveTapped();
                }
            });
            return;
        }
        if (threadStatus instanceof WidgetThreadStatusViewModel.Status.Unjoined) {
            ConstraintLayout constraintLayout3 = getBinding().f18290b;
            C12238m.checkNotNullExpressionValue(constraintLayout3, "binding.threadStatus");
            constraintLayout3.setVisibility(0);
            LoadingButton loadingButton3 = getBinding().f18291c;
            C12238m.checkNotNullExpressionValue(loadingButton3, "binding.threadStatusButton");
            loadingButton3.setVisibility(0);
            LinkifiedTextView linkifiedTextView2 = getBinding().f18292d;
            C12238m.checkNotNullExpressionValue(linkifiedTextView2, "binding.threadStatusText");
            linkifiedTextView2.setText(getResources().getString(C5419R.string.thread_header_notice_join));
            getBinding().f18291c.setText(getResources().getString(C5419R.string.join));
            LoadingButton loadingButton4 = getBinding().f18291c;
            C12238m.checkNotNullExpressionValue(loadingButton4, "binding.threadStatusButton");
            loadingButton4.setBackgroundTintList(ColorStateList.valueOf(ColorCompat.getThemedColor(getContext(), C5419R.attr.color_brand_500)));
            getBinding().f18291c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.status.WidgetThreadStatus.updateView.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetThreadStatus.this.getViewModel().onJoinTapped();
                }
            });
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetThreadStatus.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C101111());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetThreadStatus.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C101122(this));
    }
}
