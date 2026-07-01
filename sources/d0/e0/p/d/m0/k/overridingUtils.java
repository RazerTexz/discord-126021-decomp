package d0.e0.p.d.m0.k;

import android.R;
import d0.e0.p.d.m0.c.CallableDescriptor;
import d0.e0.p.d.m0.p.SmartSet;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.p, reason: use source file name */
/* JADX INFO: compiled from: overridingUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class overridingUtils {

    /* JADX INFO: Add missing generic type declarations: [H] */
    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.p$a */
    /* JADX INFO: compiled from: overridingUtils.kt */
    public static final class a<H> extends Lambda implements Function1<H, Unit> {
        public final /* synthetic */ SmartSet<H> $conflictedHandles;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(SmartSet<H> smartSet) {
            super(1);
            this.$conflictedHandles = smartSet;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2(obj);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(H h) {
            SmartSet<H> smartSet = this.$conflictedHandles;
            Intrinsics3.checkNotNullExpressionValue(h, "it");
            smartSet.add(h);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <H> Collection<H> selectMostSpecificInEachOverridableGroup(Collection<? extends H> collection, Function1<? super H, ? extends CallableDescriptor> function1) {
        Intrinsics3.checkNotNullParameter(collection, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "descriptorByHandle");
        if (collection.size() <= 1) {
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        SmartSet smartSetCreate = SmartSet.j.create();
        while (!linkedList.isEmpty()) {
            Object objFirst = _Collections.first((List<? extends Object>) linkedList);
            SmartSet smartSetCreate2 = SmartSet.j.create();
            Collection<R> collectionExtractMembersOverridableInBothWays = OverridingUtil.extractMembersOverridableInBothWays(objFirst, linkedList, function1, new a(smartSetCreate2));
            Intrinsics3.checkNotNullExpressionValue(collectionExtractMembersOverridableInBothWays, "val conflictedHandles = SmartSet.create<H>()\n\n        val overridableGroup =\n            OverridingUtil.extractMembersOverridableInBothWays(nextHandle, queue, descriptorByHandle) { conflictedHandles.add(it) }");
            if (collectionExtractMembersOverridableInBothWays.size() == 1 && smartSetCreate2.isEmpty()) {
                Object objSingle = _Collections.single(collectionExtractMembersOverridableInBothWays);
                Intrinsics3.checkNotNullExpressionValue(objSingle, "overridableGroup.single()");
                smartSetCreate.add(objSingle);
            } else {
                R r = (Object) OverridingUtil.selectMostSpecificMember(collectionExtractMembersOverridableInBothWays, function1);
                Intrinsics3.checkNotNullExpressionValue(r, "selectMostSpecificMember(overridableGroup, descriptorByHandle)");
                CallableDescriptor callableDescriptorInvoke = function1.invoke(r);
                for (R r2 : collectionExtractMembersOverridableInBothWays) {
                    Intrinsics3.checkNotNullExpressionValue(r2, "it");
                    if (!OverridingUtil.isMoreSpecific(callableDescriptorInvoke, function1.invoke(r2))) {
                        smartSetCreate2.add(r2);
                    }
                }
                if (!smartSetCreate2.isEmpty()) {
                    smartSetCreate.addAll(smartSetCreate2);
                }
                smartSetCreate.add(r);
            }
        }
        return smartSetCreate;
    }
}
