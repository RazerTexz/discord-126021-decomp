package com.discord.widgets.voice.call;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewKt;
import androidx.core.view.WindowInsetsCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import b.a.o.PanelsChildGestureRegionObserver;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetVoiceCallInlineBinding;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.press.OnPressListener;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.streams.StreamContextService;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.ViewVisibilityObserver;
import com.discord.utilities.views.ViewVisibilityObserverProvider;
import com.discord.widgets.voice.call.WidgetVoiceCallInline;
import com.google.android.material.button.MaterialButton;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceCallInline extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetVoiceCallInline.class, "binding", "getBinding()Lcom/discord/databinding/WidgetVoiceCallInlineBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final ViewVisibilityObserver inlineVoiceVisibilityObserver;

    /* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final VoiceConnected voiceConnected;

        /* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get() {
                Observable observableG = VoiceConnected.INSTANCE.get().G(new Func1<VoiceConnected, Model>() { // from class: com.discord.widgets.voice.call.WidgetVoiceCallInline$Model$Companion$get$1
                    @Override // j0.k.Func1
                    public final WidgetVoiceCallInline.Model call(WidgetVoiceCallInline.Model.VoiceConnected voiceConnected) {
                        return new WidgetVoiceCallInline.Model(voiceConnected);
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableG, "VoiceConnected\n         …eConnected)\n            }");
                return observableG;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
        public static final /* data */ class VoiceConnected {

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final MediaEngineConnection.InputMode inputMode;
            private final Channel selectedVoiceChannel;
            private final StreamContext streamContext;

            /* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
            public static final class Companion {
                private Companion() {
                }

                public final Observable<VoiceConnected> get() {
                    Observable<R> observableY = StoreStream.INSTANCE.getVoiceChannelSelected().observeSelectedChannel().Y(new Func1<Channel, Observable<? extends VoiceConnected>>() { // from class: com.discord.widgets.voice.call.WidgetVoiceCallInline$Model$VoiceConnected$Companion$get$1

                        /* JADX INFO: renamed from: com.discord.widgets.voice.call.WidgetVoiceCallInline$Model$VoiceConnected$Companion$get$1$1, reason: invalid class name */
                        /* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
                        public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<Channel, MediaEngineConnection.InputMode, StreamContext, WidgetVoiceCallInline.Model.VoiceConnected> {
                            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

                            public AnonymousClass1() {
                                super(3, WidgetVoiceCallInline.Model.VoiceConnected.class, "<init>", "<init>(Lcom/discord/api/channel/Channel;Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;Lcom/discord/utilities/streams/StreamContext;)V", 0);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final WidgetVoiceCallInline.Model.VoiceConnected invoke(Channel channel, MediaEngineConnection.InputMode inputMode, StreamContext streamContext) {
                                Intrinsics3.checkNotNullParameter(channel, "p1");
                                Intrinsics3.checkNotNullParameter(inputMode, "p2");
                                return new WidgetVoiceCallInline.Model.VoiceConnected(channel, inputMode, streamContext);
                            }
                        }

                        @Override // j0.k.Func1
                        public final Observable<? extends WidgetVoiceCallInline.Model.VoiceConnected> call(Channel channel) {
                            Object obj;
                            if (channel == null) {
                                return new ScalarSynchronousObservable(null);
                            }
                            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(channel);
                            Observable<MediaEngineConnection.InputMode> inputMode = StoreStream.INSTANCE.getMediaSettings().getInputMode();
                            Observable<StreamContext> forActiveStream = new StreamContextService(null, null, null, null, null, null, null, null, 255, null).getForActiveStream();
                            final AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
                            if (anonymousClass1 != null) {
                                obj = anonymousClass1;
                                obj = new Func3() { // from class: com.discord.widgets.voice.call.WidgetVoiceCallInline$sam$rx_functions_Func3$0
                                    @Override // rx.functions.Func3
                                    public final /* synthetic */ Object call(Object obj2, Object obj3, Object obj4) {
                                        return anonymousClass1.invoke(obj2, obj3, obj4);
                                    }
                                };
                            }
                            obj = anonymousClass1;
                            return Observable.i(scalarSynchronousObservable, inputMode, forActiveStream, (Func3) obj);
                        }
                    });
                    Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n            …        }\n              }");
                    return ObservableExtensionsKt.computationLatest(observableY);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            public VoiceConnected(Channel channel, MediaEngineConnection.InputMode inputMode, StreamContext streamContext) {
                Intrinsics3.checkNotNullParameter(channel, "selectedVoiceChannel");
                Intrinsics3.checkNotNullParameter(inputMode, "inputMode");
                this.selectedVoiceChannel = channel;
                this.inputMode = inputMode;
                this.streamContext = streamContext;
            }

            public static /* synthetic */ VoiceConnected copy$default(VoiceConnected voiceConnected, Channel channel, MediaEngineConnection.InputMode inputMode, StreamContext streamContext, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = voiceConnected.selectedVoiceChannel;
                }
                if ((i & 2) != 0) {
                    inputMode = voiceConnected.inputMode;
                }
                if ((i & 4) != 0) {
                    streamContext = voiceConnected.streamContext;
                }
                return voiceConnected.copy(channel, inputMode, streamContext);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Channel getSelectedVoiceChannel() {
                return this.selectedVoiceChannel;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final MediaEngineConnection.InputMode getInputMode() {
                return this.inputMode;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final StreamContext getStreamContext() {
                return this.streamContext;
            }

            public final VoiceConnected copy(Channel selectedVoiceChannel, MediaEngineConnection.InputMode inputMode, StreamContext streamContext) {
                Intrinsics3.checkNotNullParameter(selectedVoiceChannel, "selectedVoiceChannel");
                Intrinsics3.checkNotNullParameter(inputMode, "inputMode");
                return new VoiceConnected(selectedVoiceChannel, inputMode, streamContext);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof VoiceConnected)) {
                    return false;
                }
                VoiceConnected voiceConnected = (VoiceConnected) other;
                return Intrinsics3.areEqual(this.selectedVoiceChannel, voiceConnected.selectedVoiceChannel) && Intrinsics3.areEqual(this.inputMode, voiceConnected.inputMode) && Intrinsics3.areEqual(this.streamContext, voiceConnected.streamContext);
            }

            public final MediaEngineConnection.InputMode getInputMode() {
                return this.inputMode;
            }

            public final Channel getSelectedVoiceChannel() {
                return this.selectedVoiceChannel;
            }

            public final StreamContext getStreamContext() {
                return this.streamContext;
            }

            public int hashCode() {
                Channel channel = this.selectedVoiceChannel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                MediaEngineConnection.InputMode inputMode = this.inputMode;
                int iHashCode2 = (iHashCode + (inputMode != null ? inputMode.hashCode() : 0)) * 31;
                StreamContext streamContext = this.streamContext;
                return iHashCode2 + (streamContext != null ? streamContext.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("VoiceConnected(selectedVoiceChannel=");
                sbU.append(this.selectedVoiceChannel);
                sbU.append(", inputMode=");
                sbU.append(this.inputMode);
                sbU.append(", streamContext=");
                sbU.append(this.streamContext);
                sbU.append(")");
                return sbU.toString();
            }
        }

        public Model(VoiceConnected voiceConnected) {
            this.voiceConnected = voiceConnected;
        }

        public static /* synthetic */ Model copy$default(Model model, VoiceConnected voiceConnected, int i, Object obj) {
            if ((i & 1) != 0) {
                voiceConnected = model.voiceConnected;
            }
            return model.copy(voiceConnected);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final VoiceConnected getVoiceConnected() {
            return this.voiceConnected;
        }

        public final Model copy(VoiceConnected voiceConnected) {
            return new Model(voiceConnected);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Model) && Intrinsics3.areEqual(this.voiceConnected, ((Model) other).voiceConnected);
            }
            return true;
        }

        public final VoiceConnected getVoiceConnected() {
            return this.voiceConnected;
        }

        public int hashCode() {
            VoiceConnected voiceConnected = this.voiceConnected;
            if (voiceConnected != null) {
                return voiceConnected.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(voiceConnected=");
            sbU.append(this.voiceConnected);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.call.WidgetVoiceCallInline$onViewBound$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Boolean, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            StoreStream.INSTANCE.getMediaEngine().setPttActive(z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.call.WidgetVoiceCallInline$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Model, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "it");
            WidgetVoiceCallInline.this.configureUI(model);
        }
    }

    public WidgetVoiceCallInline() {
        super(R.layout.widget_voice_call_inline);
        this.binding = FragmentViewBindingDelegate3.viewBinding(this, WidgetVoiceCallInline4.INSTANCE, new WidgetVoiceCallInline5(this));
        this.inlineVoiceVisibilityObserver = ViewVisibilityObserverProvider.INSTANCE.get(ViewVisibilityObserverProvider.INLINE_VOICE_FEATURE);
    }

    private final void configureUI(Model data) {
        Model.VoiceConnected voiceConnected;
        boolean z2 = ((data == null || (voiceConnected = data.getVoiceConnected()) == null) ? null : voiceConnected.getInputMode()) == MediaEngineConnection.InputMode.PUSH_TO_TALK;
        View view = getView();
        if (view != null) {
            ViewKt.setVisible(view, z2);
        }
        this.inlineVoiceVisibilityObserver.updateVisibility(z2);
        if (data == null) {
        }
    }

    private final WidgetVoiceCallInlineBinding getBinding() {
        return (WidgetVoiceCallInlineBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void onViewBindingDestroy(WidgetVoiceCallInlineBinding binding) {
        PanelsChildGestureRegionObserver panelsChildGestureRegionObserverA = PanelsChildGestureRegionObserver.b.a();
        MaterialButton materialButton = binding.c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.voiceConnectedPtt");
        panelsChildGestureRegionObserverA.c(materialButton);
    }

    private final void setWindowInsetsListeners() {
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f2701b, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.voice.call.WidgetVoiceCallInline.setWindowInsetsListeners.1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                Intrinsics3.checkNotNullParameter(view, "v");
                Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.call.WidgetVoiceCallInline.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
            }
        });
        getBinding().c.setOnTouchListener(new OnPressListener(AnonymousClass2.INSTANCE));
        PanelsChildGestureRegionObserver panelsChildGestureRegionObserverA = PanelsChildGestureRegionObserver.b.a();
        MaterialButton materialButton = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.voiceConnectedPtt");
        panelsChildGestureRegionObserverA.b(materialButton);
        setWindowInsetsListeners();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(), this, null, 2, null), (Class<?>) WidgetVoiceCallInline.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
