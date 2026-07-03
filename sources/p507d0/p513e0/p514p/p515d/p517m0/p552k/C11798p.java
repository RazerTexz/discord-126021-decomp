package p507d0.p513e0.p514p.p515d.p517m0.p552k;

import android.R;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11318a;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12042j;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.p */
/* JADX INFO: compiled from: overridingUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11798p {

    /* JADX INFO: Add missing generic type declarations: [H] */
    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.p$a */
    /* JADX INFO: compiled from: overridingUtils.kt */
    public static final class a<H> extends AbstractC12240o implements Function1<H, Unit> {
        public final /* synthetic */ C12042j<H> $conflictedHandles;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(C12042j<H> c12042j) {
            super(1);
            this.$conflictedHandles = c12042j;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2(obj);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(H h) {
            C12042j<H> c12042j = this.$conflictedHandles;
            C12238m.checkNotNullExpressionValue(h, "it");
            c12042j.add(h);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <H> Collection<H> selectMostSpecificInEachOverridableGroup(Collection<? extends H> collection, Function1<? super H, ? extends InterfaceC11318a> function1) {
        C12238m.checkNotNullParameter(collection, "<this>");
        C12238m.checkNotNullParameter(function1, "descriptorByHandle");
        if (collection.size() <= 1) {
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        C12042j c12042jCreate = C12042j.f25003j.create();
        while (!linkedList.isEmpty()) {
            Object objFirst = C12163u.first((List<? extends Object>) linkedList);
            C12042j c12042jCreate2 = C12042j.f25003j.create();
            Collection<R> collectionExtractMembersOverridableInBothWays = C11793k.extractMembersOverridableInBothWays(objFirst, linkedList, function1, new a(c12042jCreate2));
            C12238m.checkNotNullExpressionValue(collectionExtractMembersOverridableInBothWays, "val conflictedHandles = SmartSet.create<H>()\n\n        val overridableGroup =\n            OverridingUtil.extractMembersOverridableInBothWays(nextHandle, queue, descriptorByHandle) { conflictedHandles.add(it) }");
            if (collectionExtractMembersOverridableInBothWays.size() == 1 && c12042jCreate2.isEmpty()) {
                Object objSingle = C12163u.single(collectionExtractMembersOverridableInBothWays);
                C12238m.checkNotNullExpressionValue(objSingle, "overridableGroup.single()");
                c12042jCreate.add(objSingle);
            } else {
                R r = (Object) C11793k.selectMostSpecificMember(collectionExtractMembersOverridableInBothWays, function1);
                C12238m.checkNotNullExpressionValue(r, "selectMostSpecificMember(overridableGroup, descriptorByHandle)");
                InterfaceC11318a interfaceC11318aInvoke = function1.invoke(r);
                for (R r2 : collectionExtractMembersOverridableInBothWays) {
                    C12238m.checkNotNullExpressionValue(r2, "it");
                    if (!C11793k.isMoreSpecific(interfaceC11318aInvoke, function1.invoke(r2))) {
                        c12042jCreate2.add(r2);
                    }
                }
                if (!c12042jCreate2.isEmpty()) {
                    c12042jCreate.addAll(c12042jCreate2);
                }
                c12042jCreate.add(r);
            }
        }
        return c12042jCreate;
    }
}
