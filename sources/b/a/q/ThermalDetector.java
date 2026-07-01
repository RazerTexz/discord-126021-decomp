package b.a.q;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import androidx.annotation.AnyThread;
import androidx.annotation.RequiresApi;
import b.c.a.a0.AnimatableValueParser;
import com.discord.rtcconnection.enums.ThermalStatus;
import com.discord.utilities.debug.DebugPrintable;
import com.discord.utilities.debug.DebugPrintable2;
import com.discord.utilities.lifecycle.ApplicationProvider;
import com.discord.utilities.logging.LoggingProvider;
import d0.Lazy5;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: b.a.q.i0, reason: use source file name */
/* JADX INFO: compiled from: ThermalDetector.kt */
/* JADX INFO: loaded from: classes.dex */
@AnyThread
@RequiresApi(29)
public final class ThermalDetector implements PowerManager.OnThermalStatusChangedListener, Runnable, DebugPrintable {
    public static boolean k;
    public static boolean l;
    public static boolean m;
    public static final ThermalDetector n = new ThermalDetector();
    public static final Lazy j = LazyJVM.lazy(Lazy5.NONE, a.j);

    /* JADX INFO: renamed from: b.a.q.i0$a */
    /* JADX INFO: compiled from: ThermalDetector.kt */
    public static final class a extends Lambda implements Function0<Handler> {
        public static final a j = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    }

    public final ThermalStatus a() {
        ThermalStatus.Companion companion = ThermalStatus.INSTANCE;
        Application application = ApplicationProvider.INSTANCE.get();
        Objects.requireNonNull(companion);
        Intrinsics3.checkNotNullParameter(application, "context");
        Object systemService = application.getSystemService("power");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        return companion.a(((PowerManager) systemService).getCurrentThermalStatus());
    }

    public final void b(ThermalStatus thermalStatus) {
        LoggingProvider.INSTANCE.get().recordBreadcrumb("thermalStatus = " + thermalStatus, "thermal");
        switch (thermalStatus.ordinal()) {
            case 0:
                if (!l) {
                    AnimatableValueParser.e1("ThermalDetector", "totally cool: thermal status is nominal");
                } else {
                    AnimatableValueParser.d1("ThermalDetector", "totally cool: no longer in thermal trouble");
                    l = false;
                    if (m) {
                        ((Handler) j.getValue()).removeCallbacks(this);
                        m = false;
                    }
                }
                break;
            case 1:
            case 2:
                if (!l) {
                    AnimatableValueParser.e1("ThermalDetector", "pretty warm: ignoring low priority thermal status = " + thermalStatus);
                } else {
                    AnimatableValueParser.d1("ThermalDetector", "cooling down: thermal status = " + thermalStatus);
                    c();
                }
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                if (!l) {
                    AnimatableValueParser.f1("ThermalDetector", "we're starting to be in thermal trouble");
                    l = true;
                }
                String str = "very toasty: thermal status = " + thermalStatus;
                if (thermalStatus.compareTo(ThermalStatus.Emergency) < 0) {
                    AnimatableValueParser.f1("ThermalDetector", str);
                } else {
                    AnimatableValueParser.c1("ThermalDetector", str, new RuntimeException(str));
                }
                c();
                break;
        }
    }

    public final void c() {
        if (m) {
            return;
        }
        ((Handler) j.getValue()).postDelayed(this, 1000L);
        m = true;
    }

    @Override // com.discord.utilities.debug.DebugPrintable
    @AnyThread
    public void debugPrint(DebugPrintable2 debugPrintable2) {
        Intrinsics3.checkNotNullParameter(debugPrintable2, "dp");
        debugPrintable2.appendKeyValue("registered", Boolean.valueOf(k));
        debugPrintable2.appendKeyValue("inThermalTrouble", Boolean.valueOf(l));
        debugPrintable2.appendKeyValue("updateScheduled", Boolean.valueOf(m));
        debugPrintable2.appendKeyValue("currentThermalStatus", a());
    }

    @Override // android.os.PowerManager.OnThermalStatusChangedListener
    public synchronized void onThermalStatusChanged(int i) {
        ThermalStatus thermalStatusA = ThermalStatus.INSTANCE.a(i);
        AnimatableValueParser.b1("ThermalDetector", "system update: onThermalStatusChanged( " + thermalStatusA + " )");
        b(thermalStatusA);
    }

    @Override // java.lang.Runnable
    public synchronized void run() {
        m = false;
        ThermalStatus thermalStatusA = a();
        AnimatableValueParser.b1("ThermalDetector", "scheduled update: current thermal status = " + thermalStatusA);
        b(thermalStatusA);
    }

    public synchronized String toString() {
        return "ThermalDetector(registered=" + k + ", inThermalTrouble=" + l + ", updateScheduled=" + m + ')';
    }
}
