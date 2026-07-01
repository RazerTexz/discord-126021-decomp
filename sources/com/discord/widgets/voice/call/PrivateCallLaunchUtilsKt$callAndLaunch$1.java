package com.discord.widgets.voice.call;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.discord.app.AppComponent;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
import d0.z.d.m;
import d0.z.d.o;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: PrivateCallLaunchUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PrivateCallLaunchUtilsKt$callAndLaunch$1 extends o implements Function0<Unit> {
    public final /* synthetic */ AppComponent $appComponent;
    public final /* synthetic */ long $channelId;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ FragmentManager $fragmentManager;
    public final /* synthetic */ boolean $isVideo;
    public final /* synthetic */ WeakReference $weakContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrivateCallLaunchUtilsKt$callAndLaunch$1(long j, WeakReference weakReference, AppComponent appComponent, Context context, FragmentManager fragmentManager, boolean z2) {
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
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableZ = Observable.j(storeStream$Companion.getRtcConnection().getConnectionState().y(PrivateCallLaunchUtilsKt$callAndLaunch$1$1.INSTANCE), storeStream$Companion.getVoiceChannelSelected().observeSelectedChannel().G(PrivateCallLaunchUtilsKt$callAndLaunch$1$2.INSTANCE), PrivateCallLaunchUtilsKt$callAndLaunch$1$3.INSTANCE).k(b.a.d.o.c(new PrivateCallLaunchUtilsKt$callAndLaunch$1$4(this), -1L, 250L, TimeUnit.MILLISECONDS)).Z(1);
        m.checkNotNullExpressionValue(observableZ, "Observable\n        .comb…       )\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui(observableZ), WidgetCallFullscreen.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new PrivateCallLaunchUtilsKt$callAndLaunch$1$5(this), 62, (Object) null);
        PrivateCallLaunchUtilsKt$callAndLaunch$1$6 privateCallLaunchUtilsKt$callAndLaunch$1$6 = new PrivateCallLaunchUtilsKt$callAndLaunch$1$6(this);
        if (this.$isVideo) {
            storeStream$Companion.getMediaEngine().selectDefaultVideoDevice(new PrivateCallLaunchUtilsKt$callAndLaunch$1$7(this, privateCallLaunchUtilsKt$callAndLaunch$1$6));
        } else {
            privateCallLaunchUtilsKt$callAndLaunch$1$6.invoke2();
        }
    }
}
