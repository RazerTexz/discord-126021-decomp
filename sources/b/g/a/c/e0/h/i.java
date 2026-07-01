package b.g.a.c.e0.h;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: StdSubtypeResolver.java */
/* JADX INFO: loaded from: classes3.dex */
public class i extends b.g.a.c.e0.d implements Serializable {
    private static final long serialVersionUID = 1;
    public LinkedHashSet<b.g.a.c.e0.b> _registeredSubtypes;

    @Override // b.g.a.c.e0.d
    public Collection<b.g.a.c.e0.b> a(b.g.a.c.z.l<?> lVar, b.g.a.c.c0.i iVar, b.g.a.c.j jVar) {
        List<b.g.a.c.e0.b> listN;
        b.g.a.c.b bVarE = lVar.e();
        Class<?> clsD = jVar == null ? iVar.d() : jVar._class;
        HashMap<b.g.a.c.e0.b, b.g.a.c.e0.b> map = new HashMap<>();
        LinkedHashSet<b.g.a.c.e0.b> linkedHashSet = this._registeredSubtypes;
        if (linkedHashSet != null) {
            for (b.g.a.c.e0.b bVar : linkedHashSet) {
                if (clsD.isAssignableFrom(bVar._class)) {
                    b(b.g.a.c.c0.d.h(lVar, bVar._class), bVar, lVar, bVarE, map);
                }
            }
        }
        if (iVar != null && (listN = bVarE.N(iVar)) != null) {
            for (b.g.a.c.e0.b bVar2 : listN) {
                b(b.g.a.c.c0.d.h(lVar, bVar2._class), bVar2, lVar, bVarE, map);
            }
        }
        b(b.g.a.c.c0.d.h(lVar, clsD), new b.g.a.c.e0.b(clsD, null), lVar, bVarE, map);
        return new ArrayList(map.values());
    }

    public void b(b.g.a.c.c0.c cVar, b.g.a.c.e0.b bVar, b.g.a.c.z.l<?> lVar, b.g.a.c.b bVar2, HashMap<b.g.a.c.e0.b, b.g.a.c.e0.b> map) {
        String strO;
        if (!bVar.a() && (strO = bVar2.O(cVar)) != null) {
            bVar = new b.g.a.c.e0.b(bVar._class, strO);
        }
        b.g.a.c.e0.b bVar3 = new b.g.a.c.e0.b(bVar._class, null);
        if (map.containsKey(bVar3)) {
            if (!bVar.a() || map.get(bVar3).a()) {
                return;
            }
            map.put(bVar3, bVar);
            return;
        }
        map.put(bVar3, bVar);
        List<b.g.a.c.e0.b> listN = bVar2.N(cVar);
        if (listN == null || listN.isEmpty()) {
            return;
        }
        for (b.g.a.c.e0.b bVar4 : listN) {
            b(b.g.a.c.c0.d.h(lVar, bVar4._class), bVar4, lVar, bVar2, map);
        }
    }
}
