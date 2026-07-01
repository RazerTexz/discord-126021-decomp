package com.discord.widgets.voice.call;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.DiscordConnectService;
import com.discord.databinding.WidgetVoiceCallIncomingBinding;
import com.discord.models.user.User;
import com.discord.stores.StoreCalls;
import com.discord.stores.StoreMediaEngine;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.media.AppSound;
import com.discord.utilities.media.AppSoundManager;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.user.calls.PrivateCallLauncher;
import com.discord.widgets.voice.call.WidgetVoiceCallIncoming;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import com.discord.widgets.voice.model.CallModel;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func0;

/* JADX INFO: compiled from: WidgetVoiceCallIncoming.kt */
/* JADX INFO: loaded from: classes.dex */
public class WidgetVoiceCallIncoming extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetVoiceCallIncoming.class, "binding", "getBinding()Lcom/discord/databinding/WidgetVoiceCallIncomingBinding;", 0)};

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetVoiceCallIncoming.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final CallModel callModel;
        private final int numIncomingCalls;
        private final List<StoreVoiceParticipants.VoiceUser> privateCallUserListItems;

        /* JADX INFO: compiled from: WidgetVoiceCallIncoming.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get() {
                Observable<R> observableY = StoreStream.INSTANCE.getCallsIncoming().observeIncoming().Y(new Func1<Set<? extends Long>, Observable<? extends Model>>() { // from class: com.discord.widgets.voice.call.WidgetVoiceCallIncoming$Model$Companion$get$1
                    @Override // j0.k.Func1
                    public /* bridge */ /* synthetic */ Observable<? extends WidgetVoiceCallIncoming.Model> call(Set<? extends Long> set) {
                        return call2((Set<Long>) set);
                    }

                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final Observable<? extends WidgetVoiceCallIncoming.Model> call2(final Set<Long> set) {
                        if (set.isEmpty()) {
                            return new ScalarSynchronousObservable(null);
                        }
                        CallModel.Companion companion = CallModel.INSTANCE;
                        Intrinsics3.checkNotNullExpressionValue(set, "incomingCalls");
                        return companion.get(((Number) _Collections.first(set)).longValue()).G(new Func1<CallModel, WidgetVoiceCallIncoming.Model>() { // from class: com.discord.widgets.voice.call.WidgetVoiceCallIncoming$Model$Companion$get$1.1

                            /* JADX INFO: renamed from: com.discord.widgets.voice.call.WidgetVoiceCallIncoming$Model$Companion$get$1$1$1, reason: invalid class name and collision with other inner class name */
                            /* JADX INFO: compiled from: WidgetVoiceCallIncoming.kt */
                            public static final class C03601 extends Lambda implements Function1<StoreVoiceParticipants.VoiceUser, Boolean> {
                                public final /* synthetic */ CallModel $callModel;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                public C03601(CallModel callModel) {
                                    super(1);
                                    this.$callModel = callModel;
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Boolean invoke(StoreVoiceParticipants.VoiceUser voiceUser) {
                                    return Boolean.valueOf(invoke2(voiceUser));
                                }

                                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final boolean invoke2(StoreVoiceParticipants.VoiceUser voiceUser) {
                                    Intrinsics3.checkNotNullParameter(voiceUser, "participant");
                                    if (ChannelUtils.z(this.$callModel.getChannel())) {
                                        if (voiceUser.isConnected() || voiceUser.isRinging()) {
                                            return true;
                                        }
                                    } else if (!voiceUser.isMe()) {
                                        return true;
                                    }
                                    return false;
                                }
                            }

                            @Override // j0.k.Func1
                            public final WidgetVoiceCallIncoming.Model call(CallModel callModel) {
                                if (callModel == null) {
                                    return null;
                                }
                                C03601 c03601 = new C03601(callModel);
                                Collection<StoreVoiceParticipants.VoiceUser> collectionValues = callModel.getParticipants().values();
                                ArrayList arrayList = new ArrayList();
                                for (T t : collectionValues) {
                                    if (c03601.invoke2((StoreVoiceParticipants.VoiceUser) t)) {
                                        arrayList.add(t);
                                    }
                                }
                                return new WidgetVoiceCallIncoming.Model(callModel, arrayList, set.size());
                            }
                        });
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n            …          }\n            }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream\n            …  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(CallModel callModel, List<StoreVoiceParticipants.VoiceUser> list, int i) {
            Intrinsics3.checkNotNullParameter(callModel, "callModel");
            Intrinsics3.checkNotNullParameter(list, "privateCallUserListItems");
            this.callModel = callModel;
            this.privateCallUserListItems = list;
            this.numIncomingCalls = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Model copy$default(Model model, CallModel callModel, List list, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                callModel = model.callModel;
            }
            if ((i2 & 2) != 0) {
                list = model.privateCallUserListItems;
            }
            if ((i2 & 4) != 0) {
                i = model.numIncomingCalls;
            }
            return model.copy(callModel, list, i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final CallModel getCallModel() {
            return this.callModel;
        }

        public final List<StoreVoiceParticipants.VoiceUser> component2() {
            return this.privateCallUserListItems;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final int getNumIncomingCalls() {
            return this.numIncomingCalls;
        }

        public final Model copy(CallModel callModel, List<StoreVoiceParticipants.VoiceUser> privateCallUserListItems, int numIncomingCalls) {
            Intrinsics3.checkNotNullParameter(callModel, "callModel");
            Intrinsics3.checkNotNullParameter(privateCallUserListItems, "privateCallUserListItems");
            return new Model(callModel, privateCallUserListItems, numIncomingCalls);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.callModel, model.callModel) && Intrinsics3.areEqual(this.privateCallUserListItems, model.privateCallUserListItems) && this.numIncomingCalls == model.numIncomingCalls;
        }

        public final CallModel getCallModel() {
            return this.callModel;
        }

        public final long getChannelId() {
            return this.callModel.getChannel().getId();
        }

        public final int getNumIncomingCalls() {
            return this.numIncomingCalls;
        }

        public final List<StoreVoiceParticipants.VoiceUser> getPrivateCallUserListItems() {
            return this.privateCallUserListItems;
        }

        public int hashCode() {
            CallModel callModel = this.callModel;
            int iHashCode = (callModel != null ? callModel.hashCode() : 0) * 31;
            List<StoreVoiceParticipants.VoiceUser> list = this.privateCallUserListItems;
            return ((iHashCode + (list != null ? list.hashCode() : 0)) * 31) + this.numIncomingCalls;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(callModel=");
            sbU.append(this.callModel);
            sbU.append(", privateCallUserListItems=");
            sbU.append(this.privateCallUserListItems);
            sbU.append(", numIncomingCalls=");
            return outline.B(sbU, this.numIncomingCalls, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetVoiceCallIncoming.kt */
    public static final class SystemCallIncoming extends WidgetVoiceCallIncoming {
        private AtomicLong cachedChannelId = new AtomicLong(0);

        @Override // com.discord.widgets.voice.call.WidgetVoiceCallIncoming
        public void configureUI(Model model) {
            if ((model != null ? Long.valueOf(model.getChannelId()) : null) != null) {
                this.cachedChannelId.set(model.getChannelId());
            }
            super.configureUI(model);
        }

        @Override // com.discord.widgets.voice.call.WidgetVoiceCallIncoming
        public void onConnect(Model model, boolean useVideo) {
            Intrinsics3.checkNotNullParameter(model, "model");
            NotificationClient.clear$default(NotificationClient.INSTANCE, model.getChannelId(), requireContext(), false, 4, null);
            DiscordConnectService.INSTANCE.b(requireContext(), model.getChannelId());
            WidgetCallFullscreen.Companion.launch$default(WidgetCallFullscreen.INSTANCE, requireContext(), model.getChannelId(), false, null, null, 28, null);
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
            }
        }

        @Override // com.discord.widgets.voice.call.WidgetVoiceCallIncoming
        public void onDecline(long channelId) {
            super.onDecline(channelId);
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
            }
        }

        @Override // com.discord.widgets.voice.call.WidgetVoiceCallIncoming
        public void onEmptyCallModel() {
            long j = this.cachedChannelId.get();
            if (j == 0) {
                return;
            }
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
            }
            NotificationClient.clear$default(NotificationClient.INSTANCE, j, requireContext(), false, 4, null);
        }

        @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
        public void onViewCreated(View view, Bundle savedInstanceState) {
            Intrinsics3.checkNotNullParameter(view, "view");
            super.onViewCreated(view, savedInstanceState);
            Observable<Long> observableD0 = Observable.d0(15L, TimeUnit.SECONDS);
            Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable.timer(15, TimeUnit.SECONDS)");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableD0, this, null, 2, null), (Class<?>) SystemCallIncoming.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new WidgetVoiceCallIncoming3(this));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.call.WidgetVoiceCallIncoming$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetVoiceCallIncoming.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetVoiceCallIncoming widgetVoiceCallIncoming) {
            super(1, widgetVoiceCallIncoming, WidgetVoiceCallIncoming.class, "configureUI", "configureUI(Lcom/discord/widgets/voice/call/WidgetVoiceCallIncoming$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            ((WidgetVoiceCallIncoming) this.receiver).configureUI(model);
        }
    }

    public WidgetVoiceCallIncoming() {
        super(R.layout.widget_voice_call_incoming);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetVoiceCallIncoming4.INSTANCE, null, 2, null);
    }

    private final WidgetVoiceCallIncomingBinding getBinding() {
        return (WidgetVoiceCallIncomingBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public void configureUI(final Model model) {
        User user;
        String username = null;
        if ((model != null ? model.getCallModel() : null) == null) {
            onEmptyCallModel();
            return;
        }
        CallModel callModel = model.getCallModel();
        List<StoreVoiceParticipants.VoiceUser> listComponent2 = model.component2();
        AppFragment.setOnBackPressed$default(this, new Func0<Boolean>() { // from class: com.discord.widgets.voice.call.WidgetVoiceCallIncoming.configureUI.1
            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public final Boolean call() {
                WidgetVoiceCallIncoming.this.onDecline(model.getChannelId());
                return Boolean.TRUE;
            }
        }, 0, 2, null);
        AppSoundManager.Provider.INSTANCE.get().play(AppSound.INSTANCE.getSOUND_CALL_RINGING());
        TextView textView = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.incomingCallStatusPrimary");
        if (ChannelUtils.z(callModel.getChannel())) {
            username = ChannelUtils.c(callModel.getChannel());
        } else {
            StoreVoiceParticipants.VoiceUser dmRecipient = callModel.getDmRecipient();
            if (dmRecipient != null && (user = dmRecipient.getUser()) != null) {
                username = user.getUsername();
            }
        }
        textView.setText(username);
        getBinding().h.setText(callModel.getIsVideoCall() ? R.string.incoming_video_call : R.string.incoming_call);
        getBinding().i.configure(listComponent2);
        getBinding().e.configure(listComponent2);
        LinearLayout linearLayout = getBinding().f2700b;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.incomingCallAcceptAltContainer");
        linearLayout.setVisibility(callModel.getIsVideoCall() ? 0 : 8);
        getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.call.WidgetVoiceCallIncoming.configureUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetVoiceCallIncoming.this.onConnect(model, true);
            }
        });
        getBinding().c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.call.WidgetVoiceCallIncoming.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetVoiceCallIncoming.this.onConnect(model, false);
            }
        });
        getBinding().f.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.voice.call.WidgetVoiceCallIncoming.configureUI.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetVoiceCallIncoming.this.onDecline(model.getChannelId());
            }
        });
    }

    public void onConnect(Model model, boolean useVideo) {
        Intrinsics3.checkNotNullParameter(model, "model");
        long channelId = model.getChannelId();
        if (model.getNumIncomingCalls() == 1) {
            Context contextRequireContext = requireContext();
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            PrivateCallLauncher privateCallLauncher = new PrivateCallLauncher(this, this, contextRequireContext, parentFragmentManager);
            if (useVideo) {
                privateCallLauncher.launchVideoCall(channelId);
            } else {
                privateCallLauncher.launchVoiceCall(channelId);
            }
        } else {
            if (useVideo) {
                StoreMediaEngine.selectDefaultVideoDevice$default(StoreStream.INSTANCE.getMediaEngine(), null, 1, null);
            }
            StoreStream.INSTANCE.getVoiceChannelSelected().selectVoiceChannel(channelId);
        }
        NotificationClient.clear$default(NotificationClient.INSTANCE, channelId, requireContext(), false, 4, null);
    }

    @MainThread
    public void onDecline(long channelId) {
        StoreCalls.stopRinging$default(StoreStream.INSTANCE.getCalls(), channelId, null, 2, null);
        NotificationClient.clear$default(NotificationClient.INSTANCE, channelId, requireContext(), false, 4, null);
    }

    public void onEmptyCallModel() {
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            appActivity.finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        AppSoundManager.Provider.INSTANCE.get().stop(AppSound.INSTANCE.getSOUND_CALL_RINGING());
        super.onStop();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
        Window window = fragmentActivityRequireActivity.getWindow();
        Intrinsics3.checkNotNullExpressionValue(window, "requireActivity().window");
        Intrinsics3.checkNotNullParameter(window, "window");
        if (Build.VERSION.SDK_INT >= 28) {
            window.getAttributes().layoutInDisplayCutoutMode = 1;
        }
        int color = ColorCompat.getColor(this, R.color.transparent);
        ColorCompat.setStatusBarTranslucent(this);
        ColorCompat.setStatusBarColor((Fragment) this, color, true);
        ViewCompat.setOnApplyWindowInsetsListener((ViewGroup) view, new OnApplyWindowInsetsListener() { // from class: com.discord.widgets.voice.call.WidgetVoiceCallIncoming.onViewBound.1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                return windowInsetsCompat;
            }
        });
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(), this, null, 2, null), (Class<?>) getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }
}
