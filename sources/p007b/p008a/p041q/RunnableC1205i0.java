package p007b.p008a.p041q;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import androidx.annotation.AnyThread;
import androidx.annotation.RequiresApi;
import com.discord.rtcconnection.enums.ThermalStatus;
import com.discord.utilities.debug.DebugPrintBuilder;
import com.discord.utilities.debug.DebugPrintable;
import com.discord.utilities.lifecycle.ApplicationProvider;
import com.discord.utilities.logging.LoggingProvider;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import p007b.p085c.p086a.p087a0.C1460d;
import p507d0.C12083g;
import p507d0.EnumC12110i;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.q.i0 */
/* JADX INFO: compiled from: ThermalDetector.kt */
/* JADX INFO: loaded from: classes.dex */
@AnyThread
@RequiresApi(29)
public final class RunnableC1205i0 implements PowerManager.OnThermalStatusChangedListener, Runnable, DebugPrintable {

    /* JADX INFO: renamed from: k */
    public static boolean f1630k;

    /* JADX INFO: renamed from: l */
    public static boolean f1631l;

    /* JADX INFO: renamed from: m */
    public static boolean f1632m;

    /* JADX INFO: renamed from: n */
    public static final RunnableC1205i0 f1633n = new RunnableC1205i0();

    /* JADX INFO: renamed from: j */
    public static final Lazy f1629j = C12083g.lazy(EnumC12110i.NONE, a.f1634j);

    /* JADX INFO: renamed from: b.a.q.i0$a */
    /* JADX INFO: compiled from: ThermalDetector.kt */
    public static final class a extends AbstractC12240o implements Function0<Handler> {

        /* JADX INFO: renamed from: j */
        public static final a f1634j = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    }

    /* JADX INFO: renamed from: a */
    public final ThermalStatus m278a() {
        ThermalStatus.Companion companion = ThermalStatus.INSTANCE;
        Application application = ApplicationProvider.INSTANCE.get();
        Objects.requireNonNull(companion);
        C12238m.checkNotNullParameter(application, "context");
        Object systemService = application.getSystemService("power");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        return companion.m8500a(((PowerManager) systemService).getCurrentThermalStatus());
    }

    /* JADX INFO: renamed from: b */
    public final void m279b(ThermalStatus thermalStatus) {
        LoggingProvider.INSTANCE.get().recordBreadcrumb("thermalStatus = " + thermalStatus, "thermal");
        switch (thermalStatus.ordinal()) {
            case 0:
                if (!f1631l) {
                    C1460d.m513e1("ThermalDetector", "totally cool: thermal status is nominal");
                } else {
                    C1460d.m509d1("ThermalDetector", "totally cool: no longer in thermal trouble");
                    f1631l = false;
                    if (f1632m) {
                        ((Handler) f1629j.getValue()).removeCallbacks(this);
                        f1632m = false;
                    }
                }
                break;
            case 1:
            case 2:
                if (!f1631l) {
                    C1460d.m513e1("ThermalDetector", "pretty warm: ignoring low priority thermal status = " + thermalStatus);
                } else {
                    C1460d.m509d1("ThermalDetector", "cooling down: thermal status = " + thermalStatus);
                    m280c();
                }
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                if (!f1631l) {
                    C1460d.m517f1("ThermalDetector", "we're starting to be in thermal trouble");
                    f1631l = true;
                }
                String str = "very toasty: thermal status = " + thermalStatus;
                if (thermalStatus.compareTo(ThermalStatus.Emergency) < 0) {
                    C1460d.m517f1("ThermalDetector", str);
                } else {
                    C1460d.m505c1("ThermalDetector", str, new RuntimeException(str));
                }
                m280c();
                break;
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m280c() {
        if (f1632m) {
            return;
        }
        ((Handler) f1629j.getValue()).postDelayed(this, 1000L);
        f1632m = true;
    }

    @Override // com.discord.utilities.debug.DebugPrintable
    @AnyThread
    public void debugPrint(DebugPrintBuilder debugPrintBuilder) {
        C12238m.checkNotNullParameter(debugPrintBuilder, "dp");
        debugPrintBuilder.appendKeyValue("registered", Boolean.valueOf(f1630k));
        debugPrintBuilder.appendKeyValue("inThermalTrouble", Boolean.valueOf(f1631l));
        debugPrintBuilder.appendKeyValue("updateScheduled", Boolean.valueOf(f1632m));
        debugPrintBuilder.appendKeyValue("currentThermalStatus", m278a());
    }

    @Override // android.os.PowerManager.OnThermalStatusChangedListener
    public synchronized void onThermalStatusChanged(int i) {
        ThermalStatus thermalStatusM8500a = ThermalStatus.INSTANCE.m8500a(i);
        C1460d.m501b1("ThermalDetector", "system update: onThermalStatusChanged( " + thermalStatusM8500a + " )");
        m279b(thermalStatusM8500a);
    }

    @Override // java.lang.Runnable
    public synchronized void run() {
        f1632m = false;
        ThermalStatus thermalStatusM278a = m278a();
        C1460d.m501b1("ThermalDetector", "scheduled update: current thermal status = " + thermalStatusM278a);
        m279b(thermalStatusM278a);
    }

    public synchronized String toString() {
        return "ThermalDetector(registered=" + f1630k + ", inThermalTrouble=" + f1631l + ", updateScheduled=" + f1632m + ')';
    }
}
