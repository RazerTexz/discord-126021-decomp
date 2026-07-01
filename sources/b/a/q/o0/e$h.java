package b.a.q.o0;

import com.discord.utilities.system.DeviceResourceUsageMonitor$ResourceUsage;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Iterator;
import java.util.List;
import java.util.Map$Entry;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: VideoQuality.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e$h extends o implements Function1<DeviceResourceUsageMonitor$ResourceUsage, Unit> {
    public final /* synthetic */ e this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$h(e eVar) {
        super(1);
        this.this$0 = eVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(DeviceResourceUsageMonitor$ResourceUsage deviceResourceUsageMonitor$ResourceUsage) {
        DeviceResourceUsageMonitor$ResourceUsage deviceResourceUsageMonitor$ResourceUsage2 = deviceResourceUsageMonitor$ResourceUsage;
        m.checkNotNullParameter(deviceResourceUsageMonitor$ResourceUsage2, "it");
        e eVar = this.this$0;
        List<Integer> list = e.a;
        synchronized (eVar) {
            Iterator<Map$Entry<String, e$e>> it = eVar.m.entrySet().iterator();
            while (it.hasNext()) {
                e$e value = it.next().getValue();
                value.f283b.addSample(deviceResourceUsageMonitor$ResourceUsage2.getCpuUsagePercent());
                value.c.addSample(deviceResourceUsageMonitor$ResourceUsage2.getMemoryRssBytes());
            }
            eVar.l.f283b.addSample(deviceResourceUsageMonitor$ResourceUsage2.getCpuUsagePercent());
            eVar.l.c.addSample(deviceResourceUsageMonitor$ResourceUsage2.getMemoryRssBytes());
        }
        return Unit.a;
    }
}
