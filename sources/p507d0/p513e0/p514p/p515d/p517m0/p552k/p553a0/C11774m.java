package p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11333f;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11465t0;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.InterfaceC11480b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11786d;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.C11904n;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11900j;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12041i;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.C12250y;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.m */
/* JADX INFO: compiled from: StaticScopeForKotlinEnum.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11774m extends AbstractC11771j {

    /* JADX INFO: renamed from: b */
    public static final /* synthetic */ KProperty<Object>[] f24374b = {C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(C11774m.class), "functions", "getFunctions()Ljava/util/List;"))};

    /* JADX INFO: renamed from: c */
    public final InterfaceC11330e f24375c;

    /* JADX INFO: renamed from: d */
    public final InterfaceC11900j f24376d;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.m$a */
    /* JADX INFO: compiled from: StaticScopeForKotlinEnum.kt */
    public static final class a extends AbstractC12240o implements Function0<List<? extends InterfaceC11465t0>> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends InterfaceC11465t0> invoke() {
            return C12147n.listOf((Object[]) new InterfaceC11465t0[]{C11786d.createEnumValueOfMethod(C11774m.this.f24375c), C11786d.createEnumValuesMethod(C11774m.this.f24375c)});
        }
    }

    public C11774m(InterfaceC11905o interfaceC11905o, InterfaceC11330e interfaceC11330e) {
        C12238m.checkNotNullParameter(interfaceC11905o, "storageManager");
        C12238m.checkNotNullParameter(interfaceC11330e, "containingClass");
        this.f24375c = interfaceC11330e;
        interfaceC11330e.getKind();
        EnumC11333f enumC11333f = EnumC11333f.ENUM_CLASS;
        this.f24376d = interfaceC11905o.createLazyValue(new a());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11771j, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11773l
    public /* bridge */ /* synthetic */ InterfaceC11352h getContributedClassifier(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
        return (InterfaceC11352h) m11469getContributedClassifier(c11716e, interfaceC11480b);
    }

    /* JADX INFO: renamed from: getContributedClassifier, reason: collision with other method in class */
    public Void m11469getContributedClassifier(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11771j, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11773l
    public /* bridge */ /* synthetic */ Collection getContributedDescriptors(C11765d c11765d, Function1 function1) {
        return getContributedDescriptors(c11765d, (Function1<? super C11716e, Boolean>) function1);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11771j, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11773l
    public List<InterfaceC11465t0> getContributedDescriptors(C11765d c11765d, Function1<? super C11716e, Boolean> function1) {
        C12238m.checkNotNullParameter(c11765d, "kindFilter");
        C12238m.checkNotNullParameter(function1, "nameFilter");
        return (List) C11904n.getValue(this.f24376d, this, (KProperty<?>) f24374b[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11771j, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public C12041i<InterfaceC11465t0> getContributedFunctions(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        List list = (List) C11904n.getValue(this.f24376d, this, (KProperty<?>) f24374b[0]);
        C12041i<InterfaceC11465t0> c12041i = new C12041i<>();
        for (Object obj : list) {
            if (C12238m.areEqual(((InterfaceC11465t0) obj).getName(), c11716e)) {
                c12041i.add(obj);
            }
        }
        return c12041i;
    }
}
