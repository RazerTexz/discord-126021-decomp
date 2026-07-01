package d0.e0.p.d.m0.f.z;

import d0.e0.p.d.m0.f.n;
import d0.e0.p.d.m0.f.q;
import d0.e0.p.d.m0.f.r;
import d0.e0.p.d.m0.f.s;
import d0.e0.p.d.m0.f.u;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.f, reason: use source file name */
/* JADX INFO: compiled from: protoTypeTableUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class protoTypeTableUtil {
    public static final q abbreviatedType(q qVar, TypeTable typeTable) {
        Intrinsics3.checkNotNullParameter(qVar, "<this>");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        if (qVar.hasAbbreviatedType()) {
            return qVar.getAbbreviatedType();
        }
        if (qVar.hasAbbreviatedTypeId()) {
            return typeTable.get(qVar.getAbbreviatedTypeId());
        }
        return null;
    }

    public static final q expandedType(r rVar, TypeTable typeTable) {
        Intrinsics3.checkNotNullParameter(rVar, "<this>");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        if (rVar.hasExpandedType()) {
            q expandedType = rVar.getExpandedType();
            Intrinsics3.checkNotNullExpressionValue(expandedType, "expandedType");
            return expandedType;
        }
        if (rVar.hasExpandedTypeId()) {
            return typeTable.get(rVar.getExpandedTypeId());
        }
        throw new IllegalStateException("No expandedType in ProtoBuf.TypeAlias".toString());
    }

    public static final q flexibleUpperBound(q qVar, TypeTable typeTable) {
        Intrinsics3.checkNotNullParameter(qVar, "<this>");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        if (qVar.hasFlexibleUpperBound()) {
            return qVar.getFlexibleUpperBound();
        }
        if (qVar.hasFlexibleUpperBoundId()) {
            return typeTable.get(qVar.getFlexibleUpperBoundId());
        }
        return null;
    }

    public static final boolean hasReceiver(d0.e0.p.d.m0.f.i iVar) {
        Intrinsics3.checkNotNullParameter(iVar, "<this>");
        return iVar.hasReceiverType() || iVar.hasReceiverTypeId();
    }

    public static final q outerType(q qVar, TypeTable typeTable) {
        Intrinsics3.checkNotNullParameter(qVar, "<this>");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        if (qVar.hasOuterType()) {
            return qVar.getOuterType();
        }
        if (qVar.hasOuterTypeId()) {
            return typeTable.get(qVar.getOuterTypeId());
        }
        return null;
    }

    public static final q receiverType(d0.e0.p.d.m0.f.i iVar, TypeTable typeTable) {
        Intrinsics3.checkNotNullParameter(iVar, "<this>");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        if (iVar.hasReceiverType()) {
            return iVar.getReceiverType();
        }
        if (iVar.hasReceiverTypeId()) {
            return typeTable.get(iVar.getReceiverTypeId());
        }
        return null;
    }

    public static final q returnType(d0.e0.p.d.m0.f.i iVar, TypeTable typeTable) {
        Intrinsics3.checkNotNullParameter(iVar, "<this>");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        if (iVar.hasReturnType()) {
            q returnType = iVar.getReturnType();
            Intrinsics3.checkNotNullExpressionValue(returnType, "returnType");
            return returnType;
        }
        if (iVar.hasReturnTypeId()) {
            return typeTable.get(iVar.getReturnTypeId());
        }
        throw new IllegalStateException("No returnType in ProtoBuf.Function".toString());
    }

    public static final List<q> supertypes(d0.e0.p.d.m0.f.c cVar, TypeTable typeTable) {
        Intrinsics3.checkNotNullParameter(cVar, "<this>");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        List<q> supertypeList = cVar.getSupertypeList();
        if (!(!supertypeList.isEmpty())) {
            supertypeList = null;
        }
        if (supertypeList == null) {
            List<Integer> supertypeIdList = cVar.getSupertypeIdList();
            Intrinsics3.checkNotNullExpressionValue(supertypeIdList, "supertypeIdList");
            supertypeList = new ArrayList<>(Iterables2.collectionSizeOrDefault(supertypeIdList, 10));
            for (Integer num : supertypeIdList) {
                Intrinsics3.checkNotNullExpressionValue(num, "it");
                supertypeList.add(typeTable.get(num.intValue()));
            }
        }
        return supertypeList;
    }

    public static final q type(q.b bVar, TypeTable typeTable) {
        Intrinsics3.checkNotNullParameter(bVar, "<this>");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        if (bVar.hasType()) {
            return bVar.getType();
        }
        if (bVar.hasTypeId()) {
            return typeTable.get(bVar.getTypeId());
        }
        return null;
    }

    public static final q underlyingType(r rVar, TypeTable typeTable) {
        Intrinsics3.checkNotNullParameter(rVar, "<this>");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        if (rVar.hasUnderlyingType()) {
            q underlyingType = rVar.getUnderlyingType();
            Intrinsics3.checkNotNullExpressionValue(underlyingType, "underlyingType");
            return underlyingType;
        }
        if (rVar.hasUnderlyingTypeId()) {
            return typeTable.get(rVar.getUnderlyingTypeId());
        }
        throw new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias".toString());
    }

    public static final List<q> upperBounds(s sVar, TypeTable typeTable) {
        Intrinsics3.checkNotNullParameter(sVar, "<this>");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        List<q> upperBoundList = sVar.getUpperBoundList();
        if (!(!upperBoundList.isEmpty())) {
            upperBoundList = null;
        }
        if (upperBoundList == null) {
            List<Integer> upperBoundIdList = sVar.getUpperBoundIdList();
            Intrinsics3.checkNotNullExpressionValue(upperBoundIdList, "upperBoundIdList");
            upperBoundList = new ArrayList<>(Iterables2.collectionSizeOrDefault(upperBoundIdList, 10));
            for (Integer num : upperBoundIdList) {
                Intrinsics3.checkNotNullExpressionValue(num, "it");
                upperBoundList.add(typeTable.get(num.intValue()));
            }
        }
        return upperBoundList;
    }

    public static final q varargElementType(u uVar, TypeTable typeTable) {
        Intrinsics3.checkNotNullParameter(uVar, "<this>");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        if (uVar.hasVarargElementType()) {
            return uVar.getVarargElementType();
        }
        if (uVar.hasVarargElementTypeId()) {
            return typeTable.get(uVar.getVarargElementTypeId());
        }
        return null;
    }

    public static final boolean hasReceiver(n nVar) {
        Intrinsics3.checkNotNullParameter(nVar, "<this>");
        return nVar.hasReceiverType() || nVar.hasReceiverTypeId();
    }

    public static final q receiverType(n nVar, TypeTable typeTable) {
        Intrinsics3.checkNotNullParameter(nVar, "<this>");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        if (nVar.hasReceiverType()) {
            return nVar.getReceiverType();
        }
        if (nVar.hasReceiverTypeId()) {
            return typeTable.get(nVar.getReceiverTypeId());
        }
        return null;
    }

    public static final q type(u uVar, TypeTable typeTable) {
        Intrinsics3.checkNotNullParameter(uVar, "<this>");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        if (uVar.hasType()) {
            q type = uVar.getType();
            Intrinsics3.checkNotNullExpressionValue(type, "type");
            return type;
        }
        if (uVar.hasTypeId()) {
            return typeTable.get(uVar.getTypeId());
        }
        throw new IllegalStateException("No type in ProtoBuf.ValueParameter".toString());
    }

    public static final q returnType(n nVar, TypeTable typeTable) {
        Intrinsics3.checkNotNullParameter(nVar, "<this>");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        if (nVar.hasReturnType()) {
            q returnType = nVar.getReturnType();
            Intrinsics3.checkNotNullExpressionValue(returnType, "returnType");
            return returnType;
        }
        if (nVar.hasReturnTypeId()) {
            return typeTable.get(nVar.getReturnTypeId());
        }
        throw new IllegalStateException("No returnType in ProtoBuf.Property".toString());
    }
}
