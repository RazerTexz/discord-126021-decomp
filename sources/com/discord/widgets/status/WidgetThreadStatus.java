package com.discord.widgets.status;

import android.content.res.ColorStateList;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetThreadStatusBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPIAbortMessages;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.LoadingButton;
import com.discord.widgets.status.WidgetThreadStatusViewModel;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetThreadStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadStatus extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetThreadStatus.class, "binding", "getBinding()Lcom/discord/databinding/WidgetThreadStatusBinding;", 0)};

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
                return outline.B(outline.U("Error(code="), this.code, ")");
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.status.WidgetThreadStatus$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetThreadStatus.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetThreadStatusViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadStatusViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetThreadStatusViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetThreadStatus.this.updateView(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.status.WidgetThreadStatus$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetThreadStatus.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<Event, Unit> {
        public AnonymousClass2(WidgetThreadStatus widgetThreadStatus) {
            super(1, widgetThreadStatus, WidgetThreadStatus.class, "handleEvent", "handleEvent(Lcom/discord/widgets/status/WidgetThreadStatus$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            ((WidgetThreadStatus) this.receiver).handleEvent(event);
        }
    }

    public WidgetThreadStatus() {
        super(R.layout.widget_thread_status);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetThreadStatus2.INSTANCE, null, 2, null);
        WidgetThreadStatus3 widgetThreadStatus3 = WidgetThreadStatus3.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetThreadStatusViewModel.class), new WidgetThreadStatus$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetThreadStatus3));
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
            AppToast.i(this, abortCodeMessageResId != null ? abortCodeMessageResId.intValue() : R.string.network_error_bad_request, 0, 4);
        }
    }

    @MainThread
    private final void updateView(WidgetThreadStatusViewModel.ViewState viewState) {
        getBinding().c.setIsLoading(viewState.isLoading());
        WidgetThreadStatusViewModel.Status threadStatus = viewState.getThreadStatus();
        if (threadStatus instanceof WidgetThreadStatusViewModel.Status.Hide) {
            ConstraintLayout constraintLayout = getBinding().f2673b;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.threadStatus");
            constraintLayout.setVisibility(8);
            return;
        }
        if (threadStatus instanceof WidgetThreadStatusViewModel.Status.Archived) {
            ConstraintLayout constraintLayout2 = getBinding().f2673b;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.threadStatus");
            constraintLayout2.setVisibility(0);
            LoadingButton loadingButton = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(loadingButton, "binding.threadStatusButton");
            WidgetThreadStatusViewModel.Status.Archived archived = (WidgetThreadStatusViewModel.Status.Archived) threadStatus;
            loadingButton.setVisibility(archived.getCanArchive() ? 0 : 8);
            LinkifiedTextView linkifiedTextView = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.threadStatusText");
            linkifiedTextView.setText(archived.isLocked() ? getResources().getString(R.string.thread_header_notice_locked) : getResources().getString(R.string.thread_header_notice_archived));
            getBinding().c.setText(getResources().getString(R.string.unarchive));
            LoadingButton loadingButton2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(loadingButton2, "binding.threadStatusButton");
            loadingButton2.setBackgroundTintList(ColorStateList.valueOf(ColorCompat.getThemedColor(getContext(), R.attr.colorBackgroundAccent)));
            getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.status.WidgetThreadStatus.updateView.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetThreadStatus.this.getViewModel().onUnarchiveTapped();
                }
            });
            return;
        }
        if (threadStatus instanceof WidgetThreadStatusViewModel.Status.Unjoined) {
            ConstraintLayout constraintLayout3 = getBinding().f2673b;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout3, "binding.threadStatus");
            constraintLayout3.setVisibility(0);
            LoadingButton loadingButton3 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(loadingButton3, "binding.threadStatusButton");
            loadingButton3.setVisibility(0);
            LinkifiedTextView linkifiedTextView2 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView2, "binding.threadStatusText");
            linkifiedTextView2.setText(getResources().getString(R.string.thread_header_notice_join));
            getBinding().c.setText(getResources().getString(R.string.join));
            LoadingButton loadingButton4 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(loadingButton4, "binding.threadStatusButton");
            loadingButton4.setBackgroundTintList(ColorStateList.valueOf(ColorCompat.getThemedColor(getContext(), R.attr.color_brand_500)));
            getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.status.WidgetThreadStatus.updateView.2
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
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetThreadStatus.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetThreadStatus.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(this));
    }
}
