package d0.e0.p.d.m0.k;

import android.R;
import d0.t.u;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: overridingUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <H> Collection<H> selectMostSpecificInEachOverridableGroup(Collection<? extends H> collection, Function1<? super H, ? extends d0.e0.p.d.m0.c.a> function1) {
        d0.z.d.m.checkNotNullParameter(collection, "<this>");
        d0.z.d.m.checkNotNullParameter(function1, "descriptorByHandle");
        if (collection.size() <= 1) {
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        d0.e0.p.d.m0.p.j jVarCreate = d0.e0.p.d.m0.p.j.j.create();
        while (!linkedList.isEmpty()) {
            Object objFirst = u.first((List<? extends Object>) linkedList);
            d0.e0.p.d.m0.p.j jVarCreate2 = d0.e0.p.d.m0.p.j.j.create();
            Collection<R> collectionExtractMembersOverridableInBothWays = k.extractMembersOverridableInBothWays(objFirst, linkedList, function1, new p$a(jVarCreate2));
            d0.z.d.m.checkNotNullExpressionValue(collectionExtractMembersOverridableInBothWays, "val conflictedHandles = SmartSet.create<H>()\n\n        val overridableGroup =\n            OverridingUtil.extractMembersOverridableInBothWays(nextHandle, queue, descriptorByHandle) { conflictedHandles.add(it) }");
            if (collectionExtractMembersOverridableInBothWays.size() == 1 && jVarCreate2.isEmpty()) {
                Object objSingle = u.single(collectionExtractMembersOverridableInBothWays);
                d0.z.d.m.checkNotNullExpressionValue(objSingle, "overridableGroup.single()");
                jVarCreate.add(objSingle);
            } else {
                R r = (Object) k.selectMostSpecificMember(collectionExtractMembersOverridableInBothWays, function1);
                d0.z.d.m.checkNotNullExpressionValue(r, "selectMostSpecificMember(overridableGroup, descriptorByHandle)");
                d0.e0.p.d.m0.c.a aVarInvoke = function1.invoke(r);
                for (R r2 : collectionExtractMembersOverridableInBothWays) {
                    d0.z.d.m.checkNotNullExpressionValue(r2, "it");
                    if (!k.isMoreSpecific(aVarInvoke, function1.invoke(r2))) {
                        jVarCreate2.add(r2);
                    }
                }
                if (!jVarCreate2.isEmpty()) {
                    jVarCreate.addAll(jVarCreate2);
                }
                jVarCreate.add(r);
            }
        }
        return jVarCreate;
    }
}
