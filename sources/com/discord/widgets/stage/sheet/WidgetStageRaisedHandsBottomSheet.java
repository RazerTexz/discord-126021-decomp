package com.discord.widgets.stage.sheet;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.DividerItemDecoration;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetStageRaisedHandsBottomSheetBinding;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textview.MaterialTextView;
import d0.g;
import d0.z.d.a0;
import d0.z.d.m;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetStageRaisedHandsBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetStageRaisedHandsBottomSheetBinding;", 0)};
    public static final WidgetStageRaisedHandsBottomSheet$Companion Companion = new WidgetStageRaisedHandsBottomSheet$Companion(null);

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;
    private boolean hasReceivedInitialRaisedHandsState;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetStageRaisedHandsBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetStageRaisedHandsBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.adapter = g.lazy(new WidgetStageRaisedHandsBottomSheet$adapter$2(this));
        this.channelId = g.lazy(new WidgetStageRaisedHandsBottomSheet$channelId$2(this));
        WidgetStageRaisedHandsBottomSheet$viewModel$2 widgetStageRaisedHandsBottomSheet$viewModel$2 = new WidgetStageRaisedHandsBottomSheet$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetStageRaisedHandsBottomSheetViewModel.class), new WidgetStageRaisedHandsBottomSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetStageRaisedHandsBottomSheet$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetStageRaisedHandsBottomSheet widgetStageRaisedHandsBottomSheet, WidgetStageRaisedHandsBottomSheetViewModel$ViewState widgetStageRaisedHandsBottomSheetViewModel$ViewState) {
        widgetStageRaisedHandsBottomSheet.configureUI(widgetStageRaisedHandsBottomSheetViewModel$ViewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetStageRaisedHandsBottomSheet widgetStageRaisedHandsBottomSheet) {
        return widgetStageRaisedHandsBottomSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ WidgetStageRaisedHandsBottomSheetBinding access$getBinding$p(WidgetStageRaisedHandsBottomSheet widgetStageRaisedHandsBottomSheet) {
        return widgetStageRaisedHandsBottomSheet.getBinding();
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetStageRaisedHandsBottomSheet widgetStageRaisedHandsBottomSheet) {
        return widgetStageRaisedHandsBottomSheet.getChannelId();
    }

    public static final /* synthetic */ WidgetStageRaisedHandsBottomSheetViewModel access$getViewModel$p(WidgetStageRaisedHandsBottomSheet widgetStageRaisedHandsBottomSheet) {
        return widgetStageRaisedHandsBottomSheet.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetStageRaisedHandsBottomSheet widgetStageRaisedHandsBottomSheet, WidgetStageRaisedHandsBottomSheetViewModel$Event widgetStageRaisedHandsBottomSheetViewModel$Event) {
        widgetStageRaisedHandsBottomSheet.handleEvent(widgetStageRaisedHandsBottomSheetViewModel$Event);
    }

    private final void configureToggleSpeakerState(WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded viewState) {
        String string;
        int i;
        getBinding().g.setOnClickListener(new WidgetStageRaisedHandsBottomSheet$configureToggleSpeakerState$1(this, viewState));
        MaterialTextView materialTextView = getBinding().g;
        m.checkNotNullExpressionValue(materialTextView, "binding.toggleSpeakerStateButton");
        boolean zIsSpeaker = viewState.isSpeaker();
        if (zIsSpeaker) {
            string = getString(2131893079);
        } else {
            if (zIsSpeaker) {
                throw new NoWhenBranchMatchedException();
            }
            string = getString(2131893066);
        }
        materialTextView.setText(string);
        ImageView imageView = getBinding().h;
        boolean zIsSpeaker2 = viewState.isSpeaker();
        if (zIsSpeaker2) {
            i = 2131232151;
        } else {
            if (zIsSpeaker2) {
                throw new NoWhenBranchMatchedException();
            }
            i = 2131232152;
        }
        imageView.setImageResource(i);
    }

    private final void configureUI(WidgetStageRaisedHandsBottomSheetViewModel$ViewState viewState) {
        if (viewState instanceof WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded) {
            WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded = (WidgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded) viewState;
            getBinding().f.setText(widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded.isRequestToSpeakEnabled() ? 2131894809 : 2131894810);
            SwitchMaterial switchMaterial = getBinding().d;
            switchMaterial.setEnabled(!widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded.isUpdatingRequestToSpeakPermissions());
            if (!widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded.isUpdatingRequestToSpeakPermissions()) {
                ViewExtensions.setProgrammaticChecked(switchMaterial, widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded.isRequestToSpeakEnabled(), new WidgetStageRaisedHandsBottomSheet$configureUI$$inlined$apply$lambda$1(this, viewState));
            }
            if (!this.hasReceivedInitialRaisedHandsState) {
                this.hasReceivedInitialRaisedHandsState = true;
                switchMaterial.jumpDrawablesToCurrentState();
            }
            Group group = getBinding().c;
            m.checkNotNullExpressionValue(group, "binding.raisedHandsEmptyGroup");
            group.setVisibility(widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded.getIsEmpty() ? 0 : 8);
            MaterialTextView materialTextView = getBinding().f2657b;
            m.checkNotNullExpressionValue(materialTextView, "binding.raisedHandsCountLabel");
            b.n(materialTextView, 2131894818, new Object[]{Integer.valueOf(widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded.getRaisedHandsParticipants().size())}, null, 4);
            configureToggleSpeakerState(widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded);
            getAdapter().setData(widgetStageRaisedHandsBottomSheetViewModel$ViewState$Loaded.getRaisedHandsParticipants());
        }
    }

    private final WidgetStageRaisedHandsBottomSheetAdapter getAdapter() {
        return (WidgetStageRaisedHandsBottomSheetAdapter) this.adapter.getValue();
    }

    private final WidgetStageRaisedHandsBottomSheetBinding getBinding() {
        return (WidgetStageRaisedHandsBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final WidgetStageRaisedHandsBottomSheetViewModel getViewModel() {
        return (WidgetStageRaisedHandsBottomSheetViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetStageRaisedHandsBottomSheetViewModel$Event event) {
        if (event instanceof WidgetStageRaisedHandsBottomSheetViewModel$Event$Dismiss) {
            dismiss();
        } else if (event instanceof WidgetStageRaisedHandsBottomSheetViewModel$Event$Error) {
            ((WidgetStageRaisedHandsBottomSheetViewModel$Event$Error) event).getError().showToasts(getContext());
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R$layout.widget_stage_raised_hands_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetStageRaisedHandsBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetStageRaisedHandsBottomSheet$onResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetStageRaisedHandsBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetStageRaisedHandsBottomSheet$onResume$2(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.hasReceivedInitialRaisedHandsState = false;
        MaxHeightRecyclerView maxHeightRecyclerView = getBinding().e;
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), 1);
        Drawable drawable = ContextCompat.getDrawable(view.getContext(), 2131232570);
        if (drawable != null) {
            dividerItemDecoration.setDrawable(drawable);
        }
        maxHeightRecyclerView.addItemDecoration(dividerItemDecoration);
        getAdapter().setOnViewProfile(new WidgetStageRaisedHandsBottomSheet$onViewCreated$2(this));
        getAdapter().setOnDismissRequest(new WidgetStageRaisedHandsBottomSheet$onViewCreated$3(getViewModel()));
        getAdapter().setOnInviteToSpeak(new WidgetStageRaisedHandsBottomSheet$onViewCreated$4(getViewModel()));
        MGRecyclerAdapter.Companion.configure(getAdapter());
    }
}
