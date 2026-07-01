package com.discord.widgets.voice.call;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import b.a.d.AppToast;
import b.a.d.o;
import b.c.a.a0.AnimatableValueParser;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.app.AppComponent;
import com.discord.app.AppPermissions2;
import com.discord.rtcconnection.RtcConnection;
import com.discord.stores.StoreCalls;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.notice.WidgetNoticeNuxOverlay;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;

/* JADX INFO: renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt, reason: use source file name */
/* JADX INFO: compiled from: PrivateCallLaunchUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PrivateCallLaunchUtils {

    /* JADX INFO: renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$1, reason: invalid class name */
    /* JADX INFO: compiled from: PrivateCallLaunchUtils.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AppComponent $appComponent;
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ FragmentManager $fragmentManager;
        public final /* synthetic */ boolean $isVideo;
        public final /* synthetic */ WeakReference $weakContext;

        /* JADX INFO: renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$1$4, reason: invalid class name */
        /* JADX INFO: compiled from: PrivateCallLaunchUtils.kt */
        public static final class AnonymousClass4 extends Lambda implements Function1<Long, Boolean> {
            public AnonymousClass4() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Long l) {
                return Boolean.valueOf(invoke2(l));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2(Long l) {
                return l != null && l.longValue() == AnonymousClass1.this.$channelId;
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$1$5, reason: invalid class name */
        /* JADX INFO: compiled from: PrivateCallLaunchUtils.kt */
        public static final class AnonymousClass5 extends Lambda implements Function1<Long, Unit> {
            public AnonymousClass5() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l) {
                invoke2(l);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long l) {
                Context context;
                if (l.longValue() <= 0 || (context = (Context) AnonymousClass1.this.$weakContext.get()) == null) {
                    return;
                }
                WidgetCallFullscreen.Companion companion = WidgetCallFullscreen.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(context, "it");
                Intrinsics3.checkNotNullExpressionValue(l, "voiceChannelId");
                WidgetCallFullscreen.Companion.launch$default(companion, context, l.longValue(), false, null, null, 28, null);
                if (StoreStream.INSTANCE.getUserSettings().getIsMobileOverlayEnabled()) {
                    return;
                }
                WidgetNoticeNuxOverlay.INSTANCE.enqueue();
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$1$6, reason: invalid class name */
        /* JADX INFO: compiled from: PrivateCallLaunchUtils.kt */
        public static final class AnonymousClass6 extends Lambda implements Function0<Unit> {

            /* JADX INFO: renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$1$6$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: PrivateCallLaunchUtils.kt */
            public static final class C03581 extends Lambda implements Function0<Unit> {
                public static final C03581 INSTANCE = new C03581();

                public C03581() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreStream.INSTANCE.getMediaEngine().selectVideoInputDevice(null);
                }
            }

            public AnonymousClass6() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreCalls calls = StoreStream.INSTANCE.getCalls();
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                calls.call(anonymousClass1.$appComponent, anonymousClass1.$context, anonymousClass1.$fragmentManager, anonymousClass1.$channelId, C03581.INSTANCE);
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$1$7, reason: invalid class name */
        /* JADX INFO: compiled from: PrivateCallLaunchUtils.kt */
        public static final class AnonymousClass7 extends Lambda implements Function1<String, Unit> {
            public final /* synthetic */ AnonymousClass6 $doCall$6;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass7(AnonymousClass6 anonymousClass6) {
                super(1);
                this.$doCall$6 = anonymousClass6;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                if (str != null) {
                    this.$doCall$6.invoke2();
                } else {
                    AppToast.g(AnonymousClass1.this.$context, R.string.no_video_devices, 0, null, 12);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, WeakReference weakReference, AppComponent appComponent, Context context, FragmentManager fragmentManager, boolean z2) {
            super(0);
            this.$channelId = j;
            this.$weakContext = weakReference;
            this.$appComponent = appComponent;
            this.$context = context;
            this.$fragmentManager = fragmentManager;
            this.$isVideo = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable observableZ = Observable.j(companion.getRtcConnection().getConnectionState().y(new Func1<RtcConnection.StateChange, Boolean>() { // from class: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt.callAndLaunch.1.1
                @Override // j0.k.Func1
                public final Boolean call(RtcConnection.StateChange stateChange) {
                    return Boolean.valueOf(stateChange.state == RtcConnection.State.f.a);
                }
            }), companion.getVoiceChannelSelected().observeSelectedChannel().G(new Func1<Channel, Long>() { // from class: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt.callAndLaunch.1.2
                @Override // j0.k.Func1
                public final Long call(Channel channel) {
                    return Long.valueOf(channel != null ? channel.getId() : -1L);
                }
            }), new Func2<RtcConnection.StateChange, Long, Long>() { // from class: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt.callAndLaunch.1.3
                @Override // rx.functions.Func2
                public final Long call(RtcConnection.StateChange stateChange, Long l) {
                    return l;
                }
            }).k(o.c(new AnonymousClass4(), -1L, 250L, TimeUnit.MILLISECONDS)).Z(1);
            Intrinsics3.checkNotNullExpressionValue(observableZ, "Observable\n        .comb…       )\n        .take(1)");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui(observableZ), (Class<?>) WidgetCallFullscreen.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass5());
            AnonymousClass6 anonymousClass6 = new AnonymousClass6();
            if (this.$isVideo) {
                companion.getMediaEngine().selectDefaultVideoDevice(new AnonymousClass7(anonymousClass6));
            } else {
                anonymousClass6.invoke2();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$2, reason: invalid class name */
    /* JADX INFO: compiled from: PrivateCallLaunchUtils.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function0<Unit> {
        public final /* synthetic */ AnonymousClass1 $onPermissionsGranted$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(AnonymousClass1 anonymousClass1) {
            super(0, null, "onPermissionsGranted", "invoke()V", 0);
            this.$onPermissionsGranted$1 = anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$onPermissionsGranted$1.invoke2();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt$callAndLaunch$3, reason: invalid class name */
    /* JADX INFO: compiled from: PrivateCallLaunchUtils.kt */
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function0<Unit> {
        public final /* synthetic */ AnonymousClass1 $onPermissionsGranted$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(AnonymousClass1 anonymousClass1) {
            super(0, null, "onPermissionsGranted", "invoke()V", 0);
            this.$onPermissionsGranted$1 = anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$onPermissionsGranted$1.invoke2();
        }
    }

    public static final void callAndLaunch(long j, boolean z2, AppPermissions2 appPermissions2, Context context, AppComponent appComponent, FragmentManager fragmentManager) {
        Intrinsics3.checkNotNullParameter(appPermissions2, "appPermissionsRequests");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(j, new WeakReference(context), appComponent, context, fragmentManager, z2);
        if (z2) {
            appPermissions2.requestVideoCallPermissions(new AnonymousClass2(anonymousClass1));
        } else {
            AnimatableValueParser.S1(appPermissions2, null, new AnonymousClass3(anonymousClass1), 1, null);
        }
    }
}
