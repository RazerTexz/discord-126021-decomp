package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import androidx.exifinterface.media.ExifInterface;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11816h;
import p507d0.p579g0.C12106w;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.b */
/* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11635b implements InterfaceC11655p.d {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AbstractC11633a<A, C> f23543a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ HashMap<C11658s, List<A>> f23544b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ HashMap<C11658s, C> f23545c;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.b$a */
    /* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    public final class a extends b implements InterfaceC11655p.e {

        /* JADX INFO: renamed from: d */
        public final /* synthetic */ C11635b f23546d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(C11635b c11635b, C11658s c11658s) {
            super(c11635b, c11658s);
            C12238m.checkNotNullParameter(c11635b, "this$0");
            C12238m.checkNotNullParameter(c11658s, "signature");
            this.f23546d = c11635b;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.e
        public InterfaceC11655p.a visitParameterAnnotation(int i, C11712a c11712a, InterfaceC11467u0 interfaceC11467u0) {
            C12238m.checkNotNullParameter(c11712a, "classId");
            C12238m.checkNotNullParameter(interfaceC11467u0, "source");
            C11658s c11658sFromMethodSignatureAndParameterIndex = C11658s.f23633a.fromMethodSignatureAndParameterIndex(this.f23547a, i);
            List arrayList = (List) this.f23546d.f23544b.get(c11658sFromMethodSignatureAndParameterIndex);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.f23546d.f23544b.put(c11658sFromMethodSignatureAndParameterIndex, (List<A>) arrayList);
            }
            return AbstractC11633a.access$loadAnnotationIfNotSpecial(this.f23546d.f23543a, c11712a, interfaceC11467u0, arrayList);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.b$b */
    /* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    public class b implements InterfaceC11655p.c {

        /* JADX INFO: renamed from: a */
        public final C11658s f23547a;

        /* JADX INFO: renamed from: b */
        public final ArrayList<A> f23548b;

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ C11635b f23549c;

        public b(C11635b c11635b, C11658s c11658s) {
            C12238m.checkNotNullParameter(c11635b, "this$0");
            C12238m.checkNotNullParameter(c11658s, "signature");
            this.f23549c = c11635b;
            this.f23547a = c11658s;
            this.f23548b = new ArrayList<>();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.c
        public InterfaceC11655p.a visitAnnotation(C11712a c11712a, InterfaceC11467u0 interfaceC11467u0) {
            C12238m.checkNotNullParameter(c11712a, "classId");
            C12238m.checkNotNullParameter(interfaceC11467u0, "source");
            return AbstractC11633a.access$loadAnnotationIfNotSpecial(this.f23549c.f23543a, c11712a, interfaceC11467u0, this.f23548b);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.c
        public void visitEnd() {
            if (!this.f23548b.isEmpty()) {
                this.f23549c.f23544b.put(this.f23547a, (List<A>) this.f23548b);
            }
        }
    }

    public C11635b(AbstractC11633a<A, C> abstractC11633a, HashMap<C11658s, List<A>> map, HashMap<C11658s, C> map2) {
        this.f23543a = abstractC11633a;
        this.f23544b = map;
        this.f23545c = map2;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.d
    public InterfaceC11655p.c visitField(C11716e c11716e, String str, Object obj) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(str, "desc");
        C11658s.a aVar = C11658s.f23633a;
        String strAsString = c11716e.asString();
        C12238m.checkNotNullExpressionValue(strAsString, "name.asString()");
        C11658s c11658sFromFieldNameAndDesc = aVar.fromFieldNameAndDesc(strAsString, str);
        if (obj != null) {
            Objects.requireNonNull((C11642c) this.f23543a);
            C12238m.checkNotNullParameter(str, "desc");
            C12238m.checkNotNullParameter(obj, "initializer");
            if (C12106w.contains$default((CharSequence) "ZBCS", (CharSequence) str, false, 2, (Object) null)) {
                int iIntValue = ((Integer) obj).intValue();
                int iHashCode = str.hashCode();
                if (iHashCode == 66) {
                    if (str.equals("B")) {
                        obj = Byte.valueOf((byte) iIntValue);
                    }
                    throw new AssertionError(str);
                }
                if (iHashCode == 67) {
                    if (str.equals("C")) {
                        obj = Character.valueOf((char) iIntValue);
                    }
                    throw new AssertionError(str);
                }
                if (iHashCode == 83) {
                    if (str.equals(ExifInterface.LATITUDE_SOUTH)) {
                        obj = Short.valueOf((short) iIntValue);
                    }
                    throw new AssertionError(str);
                }
                if (iHashCode == 90 && str.equals("Z")) {
                    obj = Boolean.valueOf(iIntValue != 0);
                }
                throw new AssertionError(str);
            }
            Object objCreateConstantValue = C11816h.f24439a.createConstantValue(obj);
            if (objCreateConstantValue != null) {
                this.f23545c.put(c11658sFromFieldNameAndDesc, (C) objCreateConstantValue);
            }
        }
        return new b(this, c11658sFromFieldNameAndDesc);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.d
    public InterfaceC11655p.e visitMethod(C11716e c11716e, String str) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(str, "desc");
        C11658s.a aVar = C11658s.f23633a;
        String strAsString = c11716e.asString();
        C12238m.checkNotNullExpressionValue(strAsString, "name.asString()");
        return new a(this, aVar.fromMethodNameAndDesc(strAsString, str));
    }
}
