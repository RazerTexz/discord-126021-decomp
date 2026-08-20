package com.discord.widgets.stage.sheet;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.DividerItemDecoration;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetStageRaisedHandsBottomSheetBinding;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textview.MaterialTextView;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.C12116o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageRaisedHandsBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetStageRaisedHandsBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetStageRaisedHandsBottomSheetBinding;", 0)};

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
            C12238m.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetStageRaisedHandsBottomSheet widgetStageRaisedHandsBottomSheet = new WidgetStageRaisedHandsBottomSheet();
            widgetStageRaisedHandsBottomSheet.setArguments(BundleKt.bundleOf(C12116o.m10073to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(channelId))));
            widgetStageRaisedHandsBottomSheet.show(fragmentManager, WidgetStageRaisedHandsBottomSheet.class.getSimpleName());
            return widgetStageRaisedHandsBottomSheet;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$onResume$1 */
    /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheet.kt */
    public static final class C100331 extends AbstractC12240o implements Function1<WidgetStageRaisedHandsBottomSheetViewModel.ViewState, Unit> {
        public C100331() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetStageRaisedHandsBottomSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetStageRaisedHandsBottomSheetViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "viewState");
            WidgetStageRaisedHandsBottomSheet.this.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$onResume$2 */
    /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheet.kt */
    public static final class C100342 extends AbstractC12240o implements Function1<WidgetStageRaisedHandsBottomSheetViewModel.Event, Unit> {
        public C100342() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetStageRaisedHandsBottomSheetViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetStageRaisedHandsBottomSheetViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "event");
            WidgetStageRaisedHandsBottomSheet.this.handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$onViewCreated$2 */
    /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheet.kt */
    public static final class C100352 extends AbstractC12240o implements Function1<StoreVoiceParticipants.VoiceUser, Unit> {
        public C100352() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
            invoke2(voiceUser);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
            C12238m.checkNotNullParameter(voiceUser, "voiceUser");
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            long id2 = voiceUser.getUser().getId();
            Long lValueOf = Long.valueOf(WidgetStageRaisedHandsBottomSheet.this.getChannelId());
            FragmentManager parentFragmentManager = WidgetStageRaisedHandsBottomSheet.this.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, id2, lValueOf, parentFragmentManager, null, null, null, null, 120, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$onViewCreated$3 */
    /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheet.kt */
    public static final /* synthetic */ class C100363 extends C12236k implements Function1<StoreVoiceParticipants.VoiceUser, Unit> {
        public C100363(WidgetStageRaisedHandsBottomSheetViewModel widgetStageRaisedHandsBottomSheetViewModel) {
            super(1, widgetStageRaisedHandsBottomSheetViewModel, WidgetStageRaisedHandsBottomSheetViewModel.class, "dismissRequestToSpeak", "dismissRequestToSpeak(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
            invoke2(voiceUser);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
            C12238m.checkNotNullParameter(voiceUser, "p1");
            ((WidgetStageRaisedHandsBottomSheetViewModel) this.receiver).dismissRequestToSpeak(voiceUser);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$onViewCreated$4 */
    /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheet.kt */
    public static final /* synthetic */ class C100374 extends C12236k implements Function1<StoreVoiceParticipants.VoiceUser, Unit> {
        public C100374(WidgetStageRaisedHandsBottomSheetViewModel widgetStageRaisedHandsBottomSheetViewModel) {
            super(1, widgetStageRaisedHandsBottomSheetViewModel, WidgetStageRaisedHandsBottomSheetViewModel.class, "inviteToSpeak", "inviteToSpeak(Lcom/discord/stores/StoreVoiceParticipants$VoiceUser;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
            invoke2(voiceUser);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
            C12238m.checkNotNullParameter(voiceUser, "p1");
            ((WidgetStageRaisedHandsBottomSheetViewModel) this.receiver).inviteToSpeak(voiceUser);
        }
    }

    public WidgetStageRaisedHandsBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetStageRaisedHandsBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.adapter = C12083g.lazy(new WidgetStageRaisedHandsBottomSheet$adapter$2(this));
        this.channelId = C12083g.lazy(new WidgetStageRaisedHandsBottomSheet$channelId$2(this));
        WidgetStageRaisedHandsBottomSheet$viewModel$2 widgetStageRaisedHandsBottomSheet$viewModel$2 = new WidgetStageRaisedHandsBottomSheet$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetStageRaisedHandsBottomSheetViewModel.class), new C10030x75d6cfc3(c0865g0), new C0869i0(widgetStageRaisedHandsBottomSheet$viewModel$2));
    }

    private final void configureToggleSpeakerState(final WidgetStageRaisedHandsBottomSheetViewModel.ViewState.Loaded viewState) {
        String string;
        int i;
        getBinding().f18171g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet.configureToggleSpeakerState.1

            /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$configureToggleSpeakerState$1$1, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheet.kt */
            public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    C0876m.m169g(WidgetStageRaisedHandsBottomSheet.this.getContext(), C5419R.string.stage_channel_permission_microphone_denied, 0, null, 12);
                }
            }

            /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageRaisedHandsBottomSheet$configureToggleSpeakerState$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: WidgetStageRaisedHandsBottomSheet.kt */
            public static final class AnonymousClass2 extends AbstractC12240o implements Function0<Unit> {
                public AnonymousClass2() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
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
                    WidgetStageRaisedHandsBottomSheet.this.requestMicrophone(new AnonymousClass1(), new AnonymousClass2());
                }
            }
        });
        MaterialTextView materialTextView = getBinding().f18171g;
        C12238m.checkNotNullExpressionValue(materialTextView, "binding.toggleSpeakerStateButton");
        boolean zIsSpeaker = viewState.isSpeaker();
        if (zIsSpeaker) {
            string = getString(C5419R.string.move_me_to_audience);
        } else {
            if (zIsSpeaker) {
                throw new NoWhenBranchMatchedException();
            }
            string = getString(C5419R.string.moderator_raise_own_hand);
        }
        materialTextView.setText(string);
        ImageView imageView = getBinding().f18172h;
        boolean zIsSpeaker2 = viewState.isSpeaker();
        if (zIsSpeaker2) {
            i = C5419R.drawable.ic_stage_move_to_audience;
        } else {
            if (zIsSpeaker2) {
                throw new NoWhenBranchMatchedException();
            }
            i = C5419R.drawable.ic_stage_move_to_speaker;
        }
        imageView.setImageResource(i);
    }

    private final void configureUI(final WidgetStageRaisedHandsBottomSheetViewModel.ViewState viewState) {
        if (viewState instanceof WidgetStageRaisedHandsBottomSheetViewModel.ViewState.Loaded) {
            WidgetStageRaisedHandsBottomSheetViewModel.ViewState.Loaded loaded = (WidgetStageRaisedHandsBottomSheetViewModel.ViewState.Loaded) viewState;
            getBinding().f18170f.setText(loaded.isRequestToSpeakEnabled() ? C5419R.string.request_to_speak_area_all_roles : C5419R.string.request_to_speak_area_all_roles_disabled);
            SwitchMaterial switchMaterial = getBinding().f18168d;
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
            Group group = getBinding().f18167c;
            C12238m.checkNotNullExpressionValue(group, "binding.raisedHandsEmptyGroup");
            group.setVisibility(loaded.getIsEmpty() ? 0 : 8);
            MaterialTextView materialTextView = getBinding().f18166b;
            C12238m.checkNotNullExpressionValue(materialTextView, "binding.raisedHandsCountLabel");
            C1107b.m221m(materialTextView, C5419R.string.request_to_speak_list_title, new Object[]{Integer.valueOf(loaded.getRaisedHandsParticipants().size())}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
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
        return C5419R.layout.widget_stage_raised_hands_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetStageRaisedHandsBottomSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C100331());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetStageRaisedHandsBottomSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C100342());
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.hasReceivedInitialRaisedHandsState = false;
        MaxHeightRecyclerView maxHeightRecyclerView = getBinding().f18169e;
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), 1);
        Drawable drawable = ContextCompat.getDrawable(view.getContext(), C5419R.drawable.widget_stage_raised_hands_divider);
        if (drawable != null) {
            dividerItemDecoration.setDrawable(drawable);
        }
        maxHeightRecyclerView.addItemDecoration(dividerItemDecoration);
        getAdapter().setOnViewProfile(new C100352());
        getAdapter().setOnDismissRequest(new C100363(getViewModel()));
        getAdapter().setOnInviteToSpeak(new C100374(getViewModel()));
        MGRecyclerAdapter.INSTANCE.configure(getAdapter());
    }
}
