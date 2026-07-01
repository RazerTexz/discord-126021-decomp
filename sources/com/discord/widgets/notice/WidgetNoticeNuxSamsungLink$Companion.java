package com.discord.widgets.notice;

import android.content.Context;
import android.content.pm.PackageManager$NameNotFoundException;
import android.os.Build;
import android.os.Build$VERSION;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.stores.StoreNotices$Notice;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import d0.g0.t;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetNoticeNuxSamsungLink.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNoticeNuxSamsungLink$Companion {
    private WidgetNoticeNuxSamsungLink$Companion() {
    }

    public static final /* synthetic */ void access$internalEnqueue(WidgetNoticeNuxSamsungLink$Companion widgetNoticeNuxSamsungLink$Companion) {
        widgetNoticeNuxSamsungLink$Companion.internalEnqueue();
    }

    private final void internalEnqueue() {
        StoreStream.Companion.getNotices().requestToShow(new StoreNotices$Notice("NUX/SamsungLink", null, 0L, 0, true, null, 0L, false, RecyclerView.FOREVER_NS, WidgetNoticeNuxSamsungLink$Companion$internalEnqueue$notice$1.INSTANCE, 230, null));
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0032  */
    public final void enqueue(Context context, Clock clock) {
        boolean z2;
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(clock, "clock");
        if (Build$VERSION.SDK_INT >= 28 && t.equals(Build.MANUFACTURER, "samsung", true)) {
            m.checkNotNullParameter(context, "context");
            try {
                try {
                    if (context.getPackageManager().getPackageInfo("com.samsung.android.game.gametools", 0) != null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } catch (PackageManager$NameNotFoundException unused) {
                    if (context.getPackageManager().getPackageInfo("com.samsung.android.game.gamehome", 0) == null) {
                        z2 = false;
                    }
                }
            } catch (PackageManager$NameNotFoundException unused2) {
            }
            if (z2) {
                StoreStream$Companion storeStream$Companion = StoreStream.Companion;
                Observable observableJ = Observable.j(storeStream$Companion.getAuthentication().observeIsAuthed$app_productionGoogleRelease(), StoreUser.observeMe$default(storeStream$Companion.getUsers(), false, 1, null), WidgetNoticeNuxSamsungLink$Companion$enqueue$1.INSTANCE);
                m.checkNotNullExpressionValue(observableJ, "Observable\n          .co…hed to meUser\n          }");
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableJ, 0L, false, 3, null)), WidgetNoticeNuxSamsungLink.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetNoticeNuxSamsungLink$Companion$enqueue$2(clock), 62, (Object) null);
            }
        }
    }

    public /* synthetic */ WidgetNoticeNuxSamsungLink$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
