package b.a.v;

import com.discord.tooltips.TooltipManager;
import d0.t.h0;
import d0.z.d.o;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: TooltipManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e extends o implements Function1<Integer, Unit> {
    public final /* synthetic */ TooltipManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(TooltipManager tooltipManager) {
        super(1);
        this.this$0 = tooltipManager;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Integer num) {
        int iIntValue = num.intValue();
        TooltipManager tooltipManager = this.this$0;
        Map<String, Integer> map = tooltipManager.tooltipNameToTooltipViewIdMap;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map$Entry<String, Integer> map$Entry : map.entrySet()) {
            if (map$Entry.getValue().intValue() != iIntValue) {
                linkedHashMap.put(map$Entry.getKey(), map$Entry.getValue());
            }
        }
        tooltipManager.tooltipNameToTooltipViewIdMap = h0.toMutableMap(linkedHashMap);
        return Unit.a;
    }
}
