package com.discord.widgets.voice.call;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewKt;
import androidx.core.view.WindowInsetsCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetVoiceCallInlineBinding;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.press.OnPressListener;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.streams.StreamContextService;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.ViewVisibilityObserver;
import com.discord.utilities.views.ViewVisibilityObserverProvider;
import com.discord.widgets.voice.call.WidgetVoiceCallInline;
import com.google.android.material.button.MaterialButton;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p039o.ViewOnLayoutChangeListenerC1175b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func3;

/* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetVoiceCallInline extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetVoiceCallInline.class, "binding", "getBinding()Lcom/discord/databinding/WidgetVoiceCallInlineBinding;", 0)};

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
                Observable observableM11083G = VoiceConnected.INSTANCE.get().m11083G(new InterfaceC12589b<VoiceConnected, Model>() { // from class: com.discord.widgets.voice.call.WidgetVoiceCallInline$Model$Companion$get$1
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final WidgetVoiceCallInline.Model call(WidgetVoiceCallInline.Model.VoiceConnected voiceConnected) {
                        return new WidgetVoiceCallInline.Model(voiceConnected);
                    }
                });
                C12238m.checkNotNullExpressionValue(observableM11083G, "VoiceConnected\n         …eConnected)\n            }");
                return observableM11083G;
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
                    Observable<R> observableM11099Y = StoreStream.INSTANCE.getVoiceChannelSelected().observeSelectedChannel().m11099Y(new InterfaceC12589b<Channel, Observable<? extends VoiceConnected>>() { // from class: com.discord.widgets.voice.call.WidgetVoiceCallInline$Model$VoiceConnected$Companion$get$1

                        /* JADX INFO: renamed from: com.discord.widgets.voice.call.WidgetVoiceCallInline$Model$VoiceConnected$Companion$get$1$1 */
                        /* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
                        public static final /* synthetic */ class C104221 extends C12236k implements Function3<Channel, MediaEngineConnection.InputMode, StreamContext, WidgetVoiceCallInline.Model.VoiceConnected> {
                            public static final C104221 INSTANCE = new C104221();

                            public C104221() {
                                super(3, WidgetVoiceCallInline.Model.VoiceConnected.class, "<init>", "<init>(Lcom/discord/api/channel/Channel;Lcom/discord/rtcconnection/mediaengine/MediaEngineConnection$InputMode;Lcom/discord/utilities/streams/StreamContext;)V", 0);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final WidgetVoiceCallInline.Model.VoiceConnected invoke(Channel channel, MediaEngineConnection.InputMode inputMode, StreamContext streamContext) {
                                C12238m.checkNotNullParameter(channel, "p1");
                                C12238m.checkNotNullParameter(inputMode, "p2");
                                return new WidgetVoiceCallInline.Model.VoiceConnected(channel, inputMode, streamContext);
                            }
                        }

                        @Override // p637j0.p641k.InterfaceC12589b
                        public final Observable<? extends WidgetVoiceCallInline.Model.VoiceConnected> call(Channel channel) {
                            Object obj;
                            if (channel == null) {
                                return new C12721k(null);
                            }
                            C12721k c12721k = new C12721k(channel);
                            Observable<MediaEngineConnection.InputMode> inputMode = StoreStream.INSTANCE.getMediaSettings().getInputMode();
                            Observable<StreamContext> forActiveStream = new StreamContextService(null, null, null, null, null, null, null, null, 255, null).getForActiveStream();
                            final C104221 c104221 = C104221.INSTANCE;
                            if (c104221 != null) {
                                obj = c104221;
                                obj = new Func3() { // from class: com.discord.widgets.voice.call.WidgetVoiceCallInline$sam$rx_functions_Func3$0
                                    @Override // p658rx.functions.Func3
                                    public final /* synthetic */ Object call(Object obj2, Object obj3, Object obj4) {
                                        return c104221.invoke(obj2, obj3, obj4);
                                    }
                                };
                            }
                            obj = c104221;
                            return Observable.m11075i(c12721k, inputMode, forActiveStream, (Func3) obj);
                        }
                    });
                    C12238m.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n            …        }\n              }");
                    return ObservableExtensionsKt.computationLatest(observableM11099Y);
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            public VoiceConnected(Channel channel, MediaEngineConnection.InputMode inputMode, StreamContext streamContext) {
                C12238m.checkNotNullParameter(channel, "selectedVoiceChannel");
                C12238m.checkNotNullParameter(inputMode, "inputMode");
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
                C12238m.checkNotNullParameter(selectedVoiceChannel, "selectedVoiceChannel");
                C12238m.checkNotNullParameter(inputMode, "inputMode");
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
                return C12238m.areEqual(this.selectedVoiceChannel, voiceConnected.selectedVoiceChannel) && C12238m.areEqual(this.inputMode, voiceConnected.inputMode) && C12238m.areEqual(this.streamContext, voiceConnected.streamContext);
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
                StringBuilder sbM833U = C1643a.m833U("VoiceConnected(selectedVoiceChannel=");
                sbM833U.append(this.selectedVoiceChannel);
                sbM833U.append(", inputMode=");
                sbM833U.append(this.inputMode);
                sbM833U.append(", streamContext=");
                sbM833U.append(this.streamContext);
                sbM833U.append(")");
                return sbM833U.toString();
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
                return (other instanceof Model) && C12238m.areEqual(this.voiceConnected, ((Model) other).voiceConnected);
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
            StringBuilder sbM833U = C1643a.m833U("Model(voiceConnected=");
            sbM833U.append(this.voiceConnected);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.call.WidgetVoiceCallInline$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
    public static final class C104242 extends AbstractC12240o implements Function1<Boolean, Unit> {
        public static final C104242 INSTANCE = new C104242();

        public C104242() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(boolean z2) {
            StoreStream.INSTANCE.getMediaEngine().setPttActive(z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.call.WidgetVoiceCallInline$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetVoiceCallInline.kt */
    public static final class C104251 extends AbstractC12240o implements Function1<Model, Unit> {
        public C104251() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            C12238m.checkNotNullParameter(model, "it");
            WidgetVoiceCallInline.this.configureUI(model);
        }
    }

    public WidgetVoiceCallInline() {
        super(C5419R.layout.widget_voice_call_inline);
        this.binding = FragmentViewBindingDelegateKt.viewBinding(this, WidgetVoiceCallInline$binding$2.INSTANCE, new WidgetVoiceCallInline$binding$3(this));
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
        ViewOnLayoutChangeListenerC1175b viewOnLayoutChangeListenerC1175bM232a = ViewOnLayoutChangeListenerC1175b.b.m232a();
        MaterialButton materialButton = binding.f18457c;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.voiceConnectedPtt");
        viewOnLayoutChangeListenerC1175bM232a.m231c(materialButton);
    }

    private final void setWindowInsetsListeners() {
        ViewCompat.setOnApplyWindowInsetsListener(getBinding().f18456b, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.voice.call.WidgetVoiceCallInline.setWindowInsetsListeners.1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                C12238m.checkNotNullParameter(view, "v");
                C12238m.checkNotNullParameter(windowInsetsCompat, "insets");
                view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f18457c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.call.WidgetVoiceCallInline.onViewBound.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
            }
        });
        getBinding().f18457c.setOnTouchListener(new OnPressListener(C104242.INSTANCE));
        ViewOnLayoutChangeListenerC1175b viewOnLayoutChangeListenerC1175bM232a = ViewOnLayoutChangeListenerC1175b.b.m232a();
        MaterialButton materialButton = getBinding().f18457c;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.voiceConnectedPtt");
        viewOnLayoutChangeListenerC1175bM232a.m230b(materialButton);
        setWindowInsetsListeners();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(), this, null, 2, null), (Class<?>) WidgetVoiceCallInline.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C104251());
    }
}
