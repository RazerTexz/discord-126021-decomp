package com.discord.widgets.stage.sheet;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.DividerItemDecoration;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetStageRaisedHandsBottomSheetBinding;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheetViewModel;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textview.MaterialTextView;
import d0.LazyJVM;
import d0.Tuples;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetStageRaisedHandsBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetStageRaisedHandsBottomSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;
    private boolean hasReceivedInitialRaisedHandsState;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final WidgetStageRaisedHandsBottomSheet show(FragmentManager fragmentManager, long channelId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetStageRaisedHandsBottomSheet widgetStageRaisedHandsBottomSheet = new WidgetStageRaisedHandsBottomSheet();
            widgetStageRaisedHandsBottomSheet.setArguments(Bundle2.bundleOf(Tuples.to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(channelId))));
            widgetStageRaisedHandsBottomSheet.show(fragmentManager, WidgetStageRaisedHandsBottomSheet.class.getSimpleName());
            return widgetStageRaisedHandsBottomSheet;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$onResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheet.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetStageRaisedHandsBottomSheetViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetStageRaisedHandsBottomSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetStageRaisedHandsBottomSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetStageRaisedHandsBottomSheet.this.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$onResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheet.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<WidgetStageRaisedHandsBottomSheetViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetStageRaisedHandsBottomSheetViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetStageRaisedHandsBottomSheetViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            WidgetStageRaisedHandsBottomSheet.this.handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$onViewCreated$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheet.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<StoreVoiceParticipants.VoiceUser, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
            invoke2(voiceUser);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
            Intrinsics3.checkNotNullParameter(voiceUser, "voiceUser");
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            long id2 = voiceUser.getUser().getId();
            Long lValueOf = Long.valueOf(WidgetStageRaisedHandsBottomSheet.this.getChannelId());
            FragmentManager parentFragmentManager = WidgetStageRaisedHandsBottomSheet.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, id2, lValueOf, parentFragmentManager, null, null, null, null, 120, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$onViewCreated$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheet.kt */
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<StoreVoiceParticipants.VoiceUser, Unit> {
        public AnonymousClass3(WidgetStageRaisedHandsBottomSheetViewModel widgetStageRaisedHandsBottomSheetViewModel) {
            super(1, widgetStageRaisedHandsBottomSheetViewModel, WidgetStageRaisedHandsBottomSheetViewModel.class, "dismissRequestToSpeak", "dismissRequestToSpeak(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
            invoke2(voiceUser);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
            Intrinsics3.checkNotNullParameter(voiceUser, "p1");
            ((WidgetStageRaisedHandsBottomSheetViewModel) this.receiver).dismissRequestToSpeak(voiceUser);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$onViewCreated$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheet.kt */
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<StoreVoiceParticipants.VoiceUser, Unit> {
        public AnonymousClass4(WidgetStageRaisedHandsBottomSheetViewModel widgetStageRaisedHandsBottomSheetViewModel) {
            super(1, widgetStageRaisedHandsBottomSheetViewModel, WidgetStageRaisedHandsBottomSheetViewModel.class, "inviteToSpeak", "inviteToSpeak(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
            invoke2(voiceUser);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
            Intrinsics3.checkNotNullParameter(voiceUser, "p1");
            ((WidgetStageRaisedHandsBottomSheetViewModel) this.receiver).inviteToSpeak(voiceUser);
        }
    }

    public WidgetStageRaisedHandsBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetStageRaisedHandsBottomSheet3.INSTANCE, null, 2, null);
        this.adapter = LazyJVM.lazy(new WidgetStageRaisedHandsBottomSheet2(this));
        this.channelId = LazyJVM.lazy(new WidgetStageRaisedHandsBottomSheet4(this));
        WidgetStageRaisedHandsBottomSheet6 widgetStageRaisedHandsBottomSheet6 = new WidgetStageRaisedHandsBottomSheet6(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetStageRaisedHandsBottomSheetViewModel.class), new WidgetStageRaisedHandsBottomSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetStageRaisedHandsBottomSheet6));
    }

    private final void configureToggleSpeakerState(final WidgetStageRaisedHandsBottomSheetViewModel.ViewState.Loaded viewState) {
        String string;
        int i;
        getBinding().g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet.configureToggleSpeakerState.1

            /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$configureToggleSpeakerState$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheet.kt */
            public static final class C03451 extends Lambda implements Function0<Unit> {
                public C03451() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AppToast.g(WidgetStageRaisedHandsBottomSheet.this.getContext(), R.string.stage_channel_permission_microphone_denied, 0, null, 12);
                }
            }

            /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$configureToggleSpeakerState$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheet.kt */
            public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
                public AnonymousClass2() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WidgetStageRaisedHandsBottomSheet.this.getViewModel().setSpeakingState(false);
                }
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                boolean zIsSpeaker = viewState.isSpeaker();
                if (zIsSpeaker) {
                    WidgetStageRaisedHandsBottomSheet.this.getViewModel().setSpeakingState(true);
                } else {
                    if (zIsSpeaker) {
                        return;
                    }
                    WidgetStageRaisedHandsBottomSheet.this.requestMicrophone(new C03451(), new AnonymousClass2());
                }
            }
        });
        MaterialTextView materialTextView = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(materialTextView, "binding.toggleSpeakerStateButton");
        boolean zIsSpeaker = viewState.isSpeaker();
        if (zIsSpeaker) {
            string = getString(R.string.move_me_to_audience);
        } else {
            if (zIsSpeaker) {
                throw new NoWhenBranchMatchedException();
            }
            string = getString(R.string.moderator_raise_own_hand);
        }
        materialTextView.setText(string);
        ImageView imageView = getBinding().h;
        boolean zIsSpeaker2 = viewState.isSpeaker();
        if (zIsSpeaker2) {
            i = R.drawable.ic_stage_move_to_audience;
        } else {
            if (zIsSpeaker2) {
                throw new NoWhenBranchMatchedException();
            }
            i = R.drawable.ic_stage_move_to_speaker;
        }
        imageView.setImageResource(i);
    }

    private final void configureUI(final WidgetStageRaisedHandsBottomSheetViewModel.ViewState viewState) {
        if (viewState instanceof WidgetStageRaisedHandsBottomSheetViewModel.ViewState.Loaded) {
            WidgetStageRaisedHandsBottomSheetViewModel.ViewState.Loaded loaded = (WidgetStageRaisedHandsBottomSheetViewModel.ViewState.Loaded) viewState;
            getBinding().f.setText(loaded.isRequestToSpeakEnabled() ? R.string.request_to_speak_area_all_roles : R.string.request_to_speak_area_all_roles_disabled);
            SwitchMaterial switchMaterial = getBinding().d;
            switchMaterial.setEnabled(!loaded.isUpdatingRequestToSpeakPermissions());
            if (!loaded.isUpdatingRequestToSpeakPermissions()) {
                ViewExtensions.setProgrammaticChecked(switchMaterial, loaded.isRequestToSpeakEnabled(), new CompoundButton.OnCheckedChangeListener() { // from class: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$configureUI$$inlined$apply$lambda$1
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                        this.this$0.getViewModel().setRequestToSpeakEnabled(z2);
                    }
                });
            }
            if (!this.hasReceivedInitialRaisedHandsState) {
                this.hasReceivedInitialRaisedHandsState = true;
                switchMaterial.jumpDrawablesToCurrentState();
            }
            Group group = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(group, "binding.raisedHandsEmptyGroup");
            group.setVisibility(loaded.getIsEmpty() ? 0 : 8);
            MaterialTextView materialTextView = getBinding().f2657b;
            Intrinsics3.checkNotNullExpressionValue(materialTextView, "binding.raisedHandsCountLabel");
            FormatUtils.m(materialTextView, R.string.request_to_speak_list_title, new Object[]{Integer.valueOf(loaded.getRaisedHandsParticipants().size())}, (4 & 4) != 0 ? FormatUtils.g.j : null);
            configureToggleSpeakerState(loaded);
            getAdapter().setData(loaded.getRaisedHandsParticipants());
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

    private final void handleEvent(WidgetStageRaisedHandsBottomSheetViewModel.Event event) {
        if (event instanceof WidgetStageRaisedHandsBottomSheetViewModel.Event.Dismiss) {
            dismiss();
        } else if (event instanceof WidgetStageRaisedHandsBottomSheetViewModel.Event.Error) {
            ((WidgetStageRaisedHandsBottomSheetViewModel.Event.Error) event).getError().showToasts(getContext());
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_stage_raised_hands_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetStageRaisedHandsBottomSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetStageRaisedHandsBottomSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.hasReceivedInitialRaisedHandsState = false;
        MaxHeightRecyclerView maxHeightRecyclerView = getBinding().e;
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), 1);
        Drawable drawable = ContextCompat.getDrawable(view.getContext(), R.drawable.widget_stage_raised_hands_divider);
        if (drawable != null) {
            dividerItemDecoration.setDrawable(drawable);
        }
        maxHeightRecyclerView.addItemDecoration(dividerItemDecoration);
        getAdapter().setOnViewProfile(new AnonymousClass2());
        getAdapter().setOnDismissRequest(new AnonymousClass3(getViewModel()));
        getAdapter().setOnInviteToSpeak(new AnonymousClass4(getViewModel()));
        MGRecyclerAdapter.INSTANCE.configure(getAdapter());
    }
}
