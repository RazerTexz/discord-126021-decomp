package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p537m;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.AbstractC11746c;
import p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11751h;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12009v;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC11931i0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12012w0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.InterfaceC11946f;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p571o1.C11992a;
import p507d0.p579g0.C12106w;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.m.g */
/* JADX INFO: compiled from: RawType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11559g extends AbstractC12009v implements InterfaceC11931i0 {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.m.g$a */
    /* JADX INFO: compiled from: RawType.kt */
    public static final class a extends AbstractC12240o implements Function1<String, CharSequence> {

        /* JADX INFO: renamed from: j */
        public static final a f23435j = new a();

        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final CharSequence invoke(String str) {
            C12238m.checkNotNullParameter(str, "it");
            return C12238m.stringPlus("(raw) ", str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11559g(AbstractC11934j0 abstractC11934j0, AbstractC11934j0 abstractC11934j1) {
        super(abstractC11934j0, abstractC11934j1);
        C12238m.checkNotNullParameter(abstractC11934j0, "lowerBound");
        C12238m.checkNotNullParameter(abstractC11934j1, "upperBound");
        InterfaceC11946f.f24806a.isSubtypeOf(abstractC11934j0, abstractC11934j1);
    }

    /* JADX INFO: renamed from: a */
    public static final List<String> m9503a(AbstractC11746c abstractC11746c, AbstractC11913c0 abstractC11913c0) {
        List<InterfaceC12012w0> arguments = abstractC11913c0.getArguments();
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(arguments, 10));
        Iterator<T> it = arguments.iterator();
        while (it.hasNext()) {
            arrayList.add(abstractC11746c.renderTypeProjection((InterfaceC12012w0) it.next()));
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: b */
    public static final String m9504b(String str, String str2) {
        if (!C12106w.contains$default((CharSequence) str, '<', false, 2, (Object) null)) {
            return str;
        }
        return C12106w.substringBefore$default(str, '<', (String) null, 2, (Object) null) + '<' + str2 + '>' + C12106w.substringAfterLast$default(str, '>', null, 2, null);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12009v
    public AbstractC11934j0 getDelegate() {
        return getLowerBound();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12009v, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public InterfaceC11770i getMemberScope() {
        InterfaceC11352h declarationDescriptor = getConstructor().getDeclarationDescriptor();
        InterfaceC11330e interfaceC11330e = declarationDescriptor instanceof InterfaceC11330e ? (InterfaceC11330e) declarationDescriptor : null;
        if (interfaceC11330e == null) {
            throw new IllegalStateException(C12238m.stringPlus("Incorrect classifier: ", getConstructor().getDeclarationDescriptor()).toString());
        }
        InterfaceC11770i memberScope = interfaceC11330e.getMemberScope(C11558f.f23432b);
        C12238m.checkNotNullExpressionValue(memberScope, "classDescriptor.getMemberScope(RawSubstitution)");
        return memberScope;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12009v
    public String render(AbstractC11746c abstractC11746c, InterfaceC11751h interfaceC11751h) {
        String str;
        String str2;
        C12238m.checkNotNullParameter(abstractC11746c, "renderer");
        C12238m.checkNotNullParameter(interfaceC11751h, "options");
        String strRenderType = abstractC11746c.renderType(getLowerBound());
        String strRenderType2 = abstractC11746c.renderType(getUpperBound());
        if (interfaceC11751h.getDebugMode()) {
            return "raw (" + strRenderType + ".." + strRenderType2 + ')';
        }
        if (getUpperBound().getArguments().isEmpty()) {
            return abstractC11746c.renderFlexibleType(strRenderType, strRenderType2, C11992a.getBuiltIns(this));
        }
        List<String> listM9503a = m9503a(abstractC11746c, getLowerBound());
        List<String> listM9503a2 = m9503a(abstractC11746c, getUpperBound());
        String strJoinToString$default = C12163u.joinToString$default(listM9503a, ", ", null, null, 0, null, a.f23435j, 30, null);
        List listZip = C12163u.zip(listM9503a, listM9503a2);
        boolean z2 = false;
        if (!(listZip instanceof Collection) || !listZip.isEmpty()) {
            Iterator it = listZip.iterator();
            do {
                if (!it.hasNext()) {
                    z2 = true;
                    break;
                }
                Pair pair = (Pair) it.next();
                str = (String) pair.getFirst();
                str2 = (String) pair.getSecond();
            } while (C12238m.areEqual(str, C12106w.removePrefix(str2, "out ")) || C12238m.areEqual(str2, "*"));
        } else {
            z2 = true;
            break;
        }
        if (z2) {
            strRenderType2 = m9504b(strRenderType2, strJoinToString$default);
        }
        String strM9504b = m9504b(strRenderType, strJoinToString$default);
        return C12238m.areEqual(strM9504b, strRenderType2) ? strM9504b : abstractC11746c.renderFlexibleType(strM9504b, strRenderType2, C11992a.getBuiltIns(this));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1
    public C11559g makeNullableAsSpecified(boolean z2) {
        return new C11559g(getLowerBound().makeNullableAsSpecified(z2), getUpperBound().makeNullableAsSpecified(z2));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1
    public C11559g replaceAnnotations(InterfaceC11344g interfaceC11344g) {
        C12238m.checkNotNullParameter(interfaceC11344g, "newAnnotations");
        return new C11559g(getLowerBound().replaceAnnotations(interfaceC11344g), getUpperBound().replaceAnnotations(interfaceC11344g));
    }

    public C11559g(AbstractC11934j0 abstractC11934j0, AbstractC11934j0 abstractC11934j1, boolean z2) {
        super(abstractC11934j0, abstractC11934j1);
        if (z2) {
            return;
        }
        InterfaceC11946f.f24806a.isSubtypeOf(abstractC11934j0, abstractC11934j1);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public AbstractC12009v refine(AbstractC11947g abstractC11947g) {
        C12238m.checkNotNullParameter(abstractC11947g, "kotlinTypeRefiner");
        return new C11559g((AbstractC11934j0) abstractC11947g.refineType(getLowerBound()), (AbstractC11934j0) abstractC11947g.refineType(getUpperBound()), true);
    }
}
