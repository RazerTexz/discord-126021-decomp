package p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z;

import java.util.ArrayList;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11678c;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11684i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11689n;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11692q;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11693r;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11694s;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11696u;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.z.f */
/* JADX INFO: compiled from: protoTypeTableUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11707f {
    public static final C11692q abbreviatedType(C11692q c11692q, C11708g c11708g) {
        C12238m.checkNotNullParameter(c11692q, "<this>");
        C12238m.checkNotNullParameter(c11708g, "typeTable");
        if (c11692q.hasAbbreviatedType()) {
            return c11692q.getAbbreviatedType();
        }
        if (c11692q.hasAbbreviatedTypeId()) {
            return c11708g.get(c11692q.getAbbreviatedTypeId());
        }
        return null;
    }

    public static final C11692q expandedType(C11693r c11693r, C11708g c11708g) {
        C12238m.checkNotNullParameter(c11693r, "<this>");
        C12238m.checkNotNullParameter(c11708g, "typeTable");
        if (c11693r.hasExpandedType()) {
            C11692q expandedType = c11693r.getExpandedType();
            C12238m.checkNotNullExpressionValue(expandedType, "expandedType");
            return expandedType;
        }
        if (c11693r.hasExpandedTypeId()) {
            return c11708g.get(c11693r.getExpandedTypeId());
        }
        throw new IllegalStateException("No expandedType in ProtoBuf.TypeAlias".toString());
    }

    public static final C11692q flexibleUpperBound(C11692q c11692q, C11708g c11708g) {
        C12238m.checkNotNullParameter(c11692q, "<this>");
        C12238m.checkNotNullParameter(c11708g, "typeTable");
        if (c11692q.hasFlexibleUpperBound()) {
            return c11692q.getFlexibleUpperBound();
        }
        if (c11692q.hasFlexibleUpperBoundId()) {
            return c11708g.get(c11692q.getFlexibleUpperBoundId());
        }
        return null;
    }

    public static final boolean hasReceiver(C11684i c11684i) {
        C12238m.checkNotNullParameter(c11684i, "<this>");
        return c11684i.hasReceiverType() || c11684i.hasReceiverTypeId();
    }

    public static final C11692q outerType(C11692q c11692q, C11708g c11708g) {
        C12238m.checkNotNullParameter(c11692q, "<this>");
        C12238m.checkNotNullParameter(c11708g, "typeTable");
        if (c11692q.hasOuterType()) {
            return c11692q.getOuterType();
        }
        if (c11692q.hasOuterTypeId()) {
            return c11708g.get(c11692q.getOuterTypeId());
        }
        return null;
    }

    public static final C11692q receiverType(C11684i c11684i, C11708g c11708g) {
        C12238m.checkNotNullParameter(c11684i, "<this>");
        C12238m.checkNotNullParameter(c11708g, "typeTable");
        if (c11684i.hasReceiverType()) {
            return c11684i.getReceiverType();
        }
        if (c11684i.hasReceiverTypeId()) {
            return c11708g.get(c11684i.getReceiverTypeId());
        }
        return null;
    }

    public static final C11692q returnType(C11684i c11684i, C11708g c11708g) {
        C12238m.checkNotNullParameter(c11684i, "<this>");
        C12238m.checkNotNullParameter(c11708g, "typeTable");
        if (c11684i.hasReturnType()) {
            C11692q returnType = c11684i.getReturnType();
            C12238m.checkNotNullExpressionValue(returnType, "returnType");
            return returnType;
        }
        if (c11684i.hasReturnTypeId()) {
            return c11708g.get(c11684i.getReturnTypeId());
        }
        throw new IllegalStateException("No returnType in ProtoBuf.Function".toString());
    }

    public static final List<C11692q> supertypes(C11678c c11678c, C11708g c11708g) {
        C12238m.checkNotNullParameter(c11678c, "<this>");
        C12238m.checkNotNullParameter(c11708g, "typeTable");
        List<C11692q> supertypeList = c11678c.getSupertypeList();
        if (!(!supertypeList.isEmpty())) {
            supertypeList = null;
        }
        if (supertypeList == null) {
            List<Integer> supertypeIdList = c11678c.getSupertypeIdList();
            C12238m.checkNotNullExpressionValue(supertypeIdList, "supertypeIdList");
            supertypeList = new ArrayList<>(C12149o.collectionSizeOrDefault(supertypeIdList, 10));
            for (Integer num : supertypeIdList) {
                C12238m.checkNotNullExpressionValue(num, "it");
                supertypeList.add(c11708g.get(num.intValue()));
            }
        }
        return supertypeList;
    }

    public static final C11692q type(C11692q.b bVar, C11708g c11708g) {
        C12238m.checkNotNullParameter(bVar, "<this>");
        C12238m.checkNotNullParameter(c11708g, "typeTable");
        if (bVar.hasType()) {
            return bVar.getType();
        }
        if (bVar.hasTypeId()) {
            return c11708g.get(bVar.getTypeId());
        }
        return null;
    }

    public static final C11692q underlyingType(C11693r c11693r, C11708g c11708g) {
        C12238m.checkNotNullParameter(c11693r, "<this>");
        C12238m.checkNotNullParameter(c11708g, "typeTable");
        if (c11693r.hasUnderlyingType()) {
            C11692q underlyingType = c11693r.getUnderlyingType();
            C12238m.checkNotNullExpressionValue(underlyingType, "underlyingType");
            return underlyingType;
        }
        if (c11693r.hasUnderlyingTypeId()) {
            return c11708g.get(c11693r.getUnderlyingTypeId());
        }
        throw new IllegalStateException("No underlyingType in ProtoBuf.TypeAlias".toString());
    }

    public static final List<C11692q> upperBounds(C11694s c11694s, C11708g c11708g) {
        C12238m.checkNotNullParameter(c11694s, "<this>");
        C12238m.checkNotNullParameter(c11708g, "typeTable");
        List<C11692q> upperBoundList = c11694s.getUpperBoundList();
        if (!(!upperBoundList.isEmpty())) {
            upperBoundList = null;
        }
        if (upperBoundList == null) {
            List<Integer> upperBoundIdList = c11694s.getUpperBoundIdList();
            C12238m.checkNotNullExpressionValue(upperBoundIdList, "upperBoundIdList");
            upperBoundList = new ArrayList<>(C12149o.collectionSizeOrDefault(upperBoundIdList, 10));
            for (Integer num : upperBoundIdList) {
                C12238m.checkNotNullExpressionValue(num, "it");
                upperBoundList.add(c11708g.get(num.intValue()));
            }
        }
        return upperBoundList;
    }

    public static final C11692q varargElementType(C11696u c11696u, C11708g c11708g) {
        C12238m.checkNotNullParameter(c11696u, "<this>");
        C12238m.checkNotNullParameter(c11708g, "typeTable");
        if (c11696u.hasVarargElementType()) {
            return c11696u.getVarargElementType();
        }
        if (c11696u.hasVarargElementTypeId()) {
            return c11708g.get(c11696u.getVarargElementTypeId());
        }
        return null;
    }

    public static final boolean hasReceiver(C11689n c11689n) {
        C12238m.checkNotNullParameter(c11689n, "<this>");
        return c11689n.hasReceiverType() || c11689n.hasReceiverTypeId();
    }

    public static final C11692q receiverType(C11689n c11689n, C11708g c11708g) {
        C12238m.checkNotNullParameter(c11689n, "<this>");
        C12238m.checkNotNullParameter(c11708g, "typeTable");
        if (c11689n.hasReceiverType()) {
            return c11689n.getReceiverType();
        }
        if (c11689n.hasReceiverTypeId()) {
            return c11708g.get(c11689n.getReceiverTypeId());
        }
        return null;
    }

    public static final C11692q type(C11696u c11696u, C11708g c11708g) {
        C12238m.checkNotNullParameter(c11696u, "<this>");
        C12238m.checkNotNullParameter(c11708g, "typeTable");
        if (c11696u.hasType()) {
            C11692q type = c11696u.getType();
            C12238m.checkNotNullExpressionValue(type, "type");
            return type;
        }
        if (c11696u.hasTypeId()) {
            return c11708g.get(c11696u.getTypeId());
        }
        throw new IllegalStateException("No type in ProtoBuf.ValueParameter".toString());
    }

    public static final C11692q returnType(C11689n c11689n, C11708g c11708g) {
        C12238m.checkNotNullParameter(c11689n, "<this>");
        C12238m.checkNotNullParameter(c11708g, "typeTable");
        if (c11689n.hasReturnType()) {
            C11692q returnType = c11689n.getReturnType();
            C12238m.checkNotNullExpressionValue(returnType, "returnType");
            return returnType;
        }
        if (c11689n.hasReturnTypeId()) {
            return c11708g.get(c11689n.getReturnTypeId());
        }
        throw new IllegalStateException("No returnType in ProtoBuf.Property".toString());
    }
}
