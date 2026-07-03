package p007b.p008a.p058v;

import com.discord.tooltips.TooltipManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: b.a.v.e */
/* JADX INFO: compiled from: TooltipManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1315e extends AbstractC12240o implements Function1<Integer, Unit> {
    public final /* synthetic */ TooltipManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1315e(TooltipManager tooltipManager) {
        super(1);
        this.this$0 = tooltipManager;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Integer num) {
        int iIntValue = num.intValue();
        TooltipManager tooltipManager = this.this$0;
        Map<String, Integer> map = tooltipManager.tooltipNameToTooltipViewIdMap;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue().intValue() != iIntValue) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        tooltipManager.tooltipNameToTooltipViewIdMap = C12136h0.toMutableMap(linkedHashMap);
        return Unit.f27425a;
    }
}
