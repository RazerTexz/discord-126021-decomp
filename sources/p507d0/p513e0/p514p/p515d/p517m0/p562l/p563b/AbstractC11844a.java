package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.p520q.C11315o;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11331e0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11360i0;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p564d0.C11853c;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11899i;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12033a;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12148n0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.a */
/* JADX INFO: compiled from: AbstractDeserializedPackageFragmentProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11844a implements InterfaceC11360i0 {

    /* JADX INFO: renamed from: a */
    public final InterfaceC11905o f24490a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC11883s f24491b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC11325c0 f24492c;

    /* JADX INFO: renamed from: d */
    public C11874j f24493d;

    /* JADX INFO: renamed from: e */
    public final InterfaceC11899i<C11713b, InterfaceC11331e0> f24494e;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.a$a */
    /* JADX INFO: compiled from: AbstractDeserializedPackageFragmentProvider.kt */
    public static final class a extends AbstractC12240o implements Function1<C11713b, InterfaceC11331e0> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public final InterfaceC11331e0 invoke(C11713b c11713b) {
            C12238m.checkNotNullParameter(c11713b, "fqName");
            C11315o c11315o = (C11315o) AbstractC11844a.this;
            Objects.requireNonNull(c11315o);
            C12238m.checkNotNullParameter(c11713b, "fqName");
            InputStream inputStreamFindBuiltInsData = c11315o.f24491b.findBuiltInsData(c11713b);
            C11853c c11853cCreate = inputStreamFindBuiltInsData == null ? null : C11853c.f24517v.create(c11713b, c11315o.f24490a, c11315o.f24492c, inputStreamFindBuiltInsData, false);
            if (c11853cCreate == null) {
                return null;
            }
            C11874j c11874j = AbstractC11844a.this.f24493d;
            if (c11874j != null) {
                c11853cCreate.initialize(c11874j);
                return c11853cCreate;
            }
            C12238m.throwUninitializedPropertyAccessException("components");
            throw null;
        }
    }

    public AbstractC11844a(InterfaceC11905o interfaceC11905o, InterfaceC11883s interfaceC11883s, InterfaceC11325c0 interfaceC11325c0) {
        C12238m.checkNotNullParameter(interfaceC11905o, "storageManager");
        C12238m.checkNotNullParameter(interfaceC11883s, "finder");
        C12238m.checkNotNullParameter(interfaceC11325c0, "moduleDescriptor");
        this.f24490a = interfaceC11905o;
        this.f24491b = interfaceC11883s;
        this.f24492c = interfaceC11325c0;
        this.f24494e = interfaceC11905o.createMemoizedFunctionWithNullableValues(new a());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11360i0
    public void collectPackageFragments(C11713b c11713b, Collection<InterfaceC11331e0> collection) {
        C12238m.checkNotNullParameter(c11713b, "fqName");
        C12238m.checkNotNullParameter(collection, "packageFragments");
        C12033a.addIfNotNull(collection, this.f24494e.invoke(c11713b));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11334f0
    public List<InterfaceC11331e0> getPackageFragments(C11713b c11713b) {
        C12238m.checkNotNullParameter(c11713b, "fqName");
        return C12147n.listOfNotNull(this.f24494e.invoke(c11713b));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11334f0
    public Collection<C11713b> getSubPackagesOf(C11713b c11713b, Function1<? super C11716e, Boolean> function1) {
        C12238m.checkNotNullParameter(c11713b, "fqName");
        C12238m.checkNotNullParameter(function1, "nameFilter");
        return C12148n0.emptySet();
    }
}
