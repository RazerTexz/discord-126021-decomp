package d0.e0.p.d.m0.f.z;

import d0.e0.p.d.m0.f.n;
import d0.e0.p.d.m0.f.q;
import d0.e0.p.d.m0.f.q$b;
import d0.e0.p.d.m0.f.r;
import d0.e0.p.d.m0.f.s;
import d0.e0.p.d.m0.f.u;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: protoTypeTableUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static final q abbreviatedType(q qVar, g gVar) {
        m.checkNotNullParameter(qVar, "<this>");
        m.checkNotNullParameter(gVar, "typeTable");
        if (qVar.hasAbbreviatedType()) {
            return qVar.getAbbreviatedType();
        }
        if (qVar.hasAbbreviatedTypeId()) {
            return gVar.get(qVar.getAbbreviatedTypeId());
        }
        return null;
    }

    public static final q expandedType(r rVar, g gVar) {
        m.checkNotNullParameter(rVar, "<this>");
        m.checkNotNullParameter(gVar, "typeTable");
        if (rVar.hasExpandedType()) {
            q expandedType = rVar.getExpandedType();
            m.checkNotNullExpressionValue(expandedType, "expandedType");
            return expandedType;
        }
        if (rVar.hasExpandedTypeId()) {
            return gVar.get(rVar.getExpandedTypeId());
        }
        throw new IllegalStateException("No expandedType in ProtoBuf.TypeAlias".toString());
    }

    public static final q flexibleUpperBound(q qVar, g gVar) {
        m.checkNotNullParameter(qVar, "<this>");
        m.checkNotNullParameter(gVar, "typeTable");
        if (qVar.hasFlexibleUpperBound()) {
            return qVar.getFlexibleUpperBound();
        }
        if (qVar.hasFlexibleUpperBoundId()) {
            return gVar.get(qVar.getFlexibleUpperBoundId());
        }
        return null;
    }

    public static final boolean hasReceiver(d0.e0.p.d.m0.f.i iVar) {
        m.checkNotNullParameter(iVar, "<this>");
        return iVar.hasReceiverType() || iVar.hasReceiverTypeId();
    }

    public static final q outerType(q qVar, g gVar) {
        m.checkNotNullParameter(qVar, "<this>");
        m.checkNotNullParameter(gVar, "typeTable");
        if (qVar.hasOuterType()) {
            return qVar.getOuterType();
        }
        if (qVar.hasOuterTypeId()) {
            return gVar.get(qVar.getOuterTypeId());
        }
        return null;
    }

    public static final q receiverType(d0.e0.p.d.m0.f.i iVar, g gVar) {
        m.checkNotNullParameter(iVar, "<this>");
        m.checkNotNullParameter(gVar, "typeTable");
        if (iVar.hasReceiverType()) {
            return iVar.getReceiverType();
        }
        if (iVar.hasReceiverTypeId()) {
            return gVar.get(iVar.getReceiverTypeId());
        }
        return null;
    }

    public static final q returnType(d0.e0.p.d.m0.f.i iVar, g gVar) {
        m.checkNotNullParameter(iVar, "<this>");
        m.checkNotNullParameter(gVar, "typeTable");
        if (iVar.hasReturnType()) {
            q returnType = iVar.getReturnType();
            m.checkNotNullExpressionValue(returnType, "returnType");
            return returnType;
        }
        if (iVar.hasReturnTypeId()) {
            return gVar.get(iVar.getReturnTypeId());
        }
        throw new IllegalStateException("No returnType in ProtoBuf.Function".toString());
    }

    public static final List<q> supertypes(d0.e0.p.d.m0.f.c cVar, g gVar) {
        m.checkNotNullParameter(cVar, "<this>");
        m.checkNotNullParameter(gVar, "typeTable");
        List<q> supertypeList = cVar.getSupertypeList();
        if (!(!supertypeList.isEmpty())) {
            supertypeList = null;
        }
        if (supertypeList == null) {
            List<Integer> supertypeIdList = cVar.getSupertypeIdList();
            m.checkNotNullExpressionValue(supertypeIdList, "supertypeIdList");
            supertypeList = new ArrayList<>(o.collectionSizeOrDefault(supertypeIdList, 10));
            for (Integer num : supertypeIdList) {
                m.checkNotNullExpressionValue(num, "it");
                supertypeList.add(gVar.get(num.intValue()));
            }
        }
        return supertypeList;
    }

    public static final q type(q$b q_b, g gVar) {
        m.checkNotNullParameter(q_b, "<this>");
        m.checkNotNullParameter(gVar, "typeTable");
        if (q_b.hasType()) {
            return q_b.getType();
        }
        if (q_b.hasTypeId()) {
            return gVar.get(q_b.getTypeId());
        }
        return null;
    }

    public static final q underlyingType(r rVar, g gVar) {
        m.checkNotNullParameter(rVar, "<this>");
        m.checkNotNullParameter(gVar, "typeTable");
        if (rVar.hasUnderlyingType()) {
            q underlyingType = rVar.getUnderlyingType();
            m.checkNotNullExpressionValue(underlyingType, "underlyingType");
            return underlyingType;
        }
        if (rVar.hasUnderlyingTypeId()) {
            return gVar.get(rVar.getUnderlyingTypeId());
        }
        throw new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias".toString());
    }

    public static final List<q> upperBounds(s sVar, g gVar) {
        m.checkNotNullParameter(sVar, "<this>");
        m.checkNotNullParameter(gVar, "typeTable");
        List<q> upperBoundList = sVar.getUpperBoundList();
        if (!(!upperBoundList.isEmpty())) {
            upperBoundList = null;
        }
        if (upperBoundList == null) {
            List<Integer> upperBoundIdList = sVar.getUpperBoundIdList();
            m.checkNotNullExpressionValue(upperBoundIdList, "upperBoundIdList");
            upperBoundList = new ArrayList<>(o.collectionSizeOrDefault(upperBoundIdList, 10));
            for (Integer num : upperBoundIdList) {
                m.checkNotNullExpressionValue(num, "it");
                upperBoundList.add(gVar.get(num.intValue()));
            }
        }
        return upperBoundList;
    }

    public static final q varargElementType(u uVar, g gVar) {
        m.checkNotNullParameter(uVar, "<this>");
        m.checkNotNullParameter(gVar, "typeTable");
        if (uVar.hasVarargElementType()) {
            return uVar.getVarargElementType();
        }
        if (uVar.hasVarargElementTypeId()) {
            return gVar.get(uVar.getVarargElementTypeId());
        }
        return null;
    }

    public static final boolean hasReceiver(n nVar) {
        m.checkNotNullParameter(nVar, "<this>");
        return nVar.hasReceiverType() || nVar.hasReceiverTypeId();
    }

    public static final q receiverType(n nVar, g gVar) {
        m.checkNotNullParameter(nVar, "<this>");
        m.checkNotNullParameter(gVar, "typeTable");
        if (nVar.hasReceiverType()) {
            return nVar.getReceiverType();
        }
        if (nVar.hasReceiverTypeId()) {
            return gVar.get(nVar.getReceiverTypeId());
        }
        return null;
    }

    public static final q type(u uVar, g gVar) {
        m.checkNotNullParameter(uVar, "<this>");
        m.checkNotNullParameter(gVar, "typeTable");
        if (uVar.hasType()) {
            q type = uVar.getType();
            m.checkNotNullExpressionValue(type, "type");
            return type;
        }
        if (uVar.hasTypeId()) {
            return gVar.get(uVar.getTypeId());
        }
        throw new IllegalStateException("No type in ProtoBuf.ValueParameter".toString());
    }

    public static final q returnType(n nVar, g gVar) {
        m.checkNotNullParameter(nVar, "<this>");
        m.checkNotNullParameter(gVar, "typeTable");
        if (nVar.hasReturnType()) {
            q returnType = nVar.getReturnType();
            m.checkNotNullExpressionValue(returnType, "returnType");
            return returnType;
        }
        if (nVar.hasReturnTypeId()) {
            return gVar.get(nVar.getReturnTypeId());
        }
        throw new IllegalStateException("No returnType in ProtoBuf.Property".toString());
    }
}
