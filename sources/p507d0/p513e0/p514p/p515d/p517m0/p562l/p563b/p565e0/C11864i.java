package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11331e0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p523h1.InterfaceC11355b;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.C11478a;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.EnumC11482d;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.InterfaceC11480b;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11684i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11687l;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11689n;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11693r;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11695t;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11698w;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.AbstractC11702a;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11708g;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11710i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.InterfaceC11704c;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.C11765d;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.C11874j;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.C11876l;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12160r;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.i */
/* JADX INFO: compiled from: DeserializedPackageMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C11864i extends AbstractC11863h {

    /* JADX INFO: renamed from: g */
    public final InterfaceC11331e0 f24597g;

    /* JADX INFO: renamed from: h */
    public final C11713b f24598h;

    public C11864i(InterfaceC11331e0 interfaceC11331e0, C11687l c11687l, InterfaceC11704c interfaceC11704c, AbstractC11702a abstractC11702a, InterfaceC11861f interfaceC11861f, C11874j c11874j, Function0<? extends Collection<C11716e>> function0) {
        C12238m.checkNotNullParameter(interfaceC11331e0, "packageDescriptor");
        C12238m.checkNotNullParameter(c11687l, "proto");
        C12238m.checkNotNullParameter(interfaceC11704c, "nameResolver");
        C12238m.checkNotNullParameter(abstractC11702a, "metadataVersion");
        C12238m.checkNotNullParameter(c11874j, "components");
        C12238m.checkNotNullParameter(function0, "classNames");
        C11695t typeTable = c11687l.getTypeTable();
        C12238m.checkNotNullExpressionValue(typeTable, "proto.typeTable");
        C11708g c11708g = new C11708g(typeTable);
        C11710i.a aVar = C11710i.f24073a;
        C11698w versionRequirementTable = c11687l.getVersionRequirementTable();
        C12238m.checkNotNullExpressionValue(versionRequirementTable, "proto.versionRequirementTable");
        C11876l c11876lCreateContext = c11874j.createContext(interfaceC11331e0, interfaceC11704c, c11708g, aVar.create(versionRequirementTable), abstractC11702a, interfaceC11861f);
        List<C11684i> functionList = c11687l.getFunctionList();
        C12238m.checkNotNullExpressionValue(functionList, "proto.functionList");
        List<C11689n> propertyList = c11687l.getPropertyList();
        C12238m.checkNotNullExpressionValue(propertyList, "proto.propertyList");
        List<C11693r> typeAliasList = c11687l.getTypeAliasList();
        C12238m.checkNotNullExpressionValue(typeAliasList, "proto.typeAliasList");
        super(c11876lCreateContext, functionList, propertyList, typeAliasList, function0);
        this.f24597g = interfaceC11331e0;
        this.f24598h = interfaceC11331e0.getFqName();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.AbstractC11863h
    /* JADX INFO: renamed from: a */
    public void mo9955a(Collection<InterfaceC11450m> collection, Function1<? super C11716e, Boolean> function1) {
        C12238m.checkNotNullParameter(collection, "result");
        C12238m.checkNotNullParameter(function1, "nameFilter");
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.AbstractC11863h
    /* JADX INFO: renamed from: e */
    public C11712a mo9958e(C11716e c11716e) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new C11712a(this.f24598h, c11716e);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.AbstractC11863h
    /* JADX INFO: renamed from: f */
    public Set<C11716e> mo9959f() {
        return C12148n0.emptySet();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.AbstractC11863h
    /* JADX INFO: renamed from: g */
    public Set<C11716e> mo9960g() {
        return C12148n0.emptySet();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.AbstractC11863h, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11771j, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11773l
    public InterfaceC11352h getContributedClassifier(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        recordLookup(c11716e, interfaceC11480b);
        return super.getContributedClassifier(c11716e, interfaceC11480b);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11771j, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11773l
    public /* bridge */ /* synthetic */ Collection getContributedDescriptors(C11765d c11765d, Function1 function1) {
        return getContributedDescriptors(c11765d, (Function1<? super C11716e, Boolean>) function1);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.AbstractC11863h
    /* JADX INFO: renamed from: h */
    public Set<C11716e> mo9961h() {
        return C12148n0.emptySet();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.AbstractC11863h
    /* JADX INFO: renamed from: i */
    public boolean mo9965i(C11716e c11716e) {
        boolean z2;
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        if (getClassNames$deserialization().contains(c11716e)) {
            return true;
        }
        Iterable<InterfaceC11355b> fictitiousClassDescriptorFactories = this.f24568c.getComponents().getFictitiousClassDescriptorFactories();
        if ((fictitiousClassDescriptorFactories instanceof Collection) && ((Collection) fictitiousClassDescriptorFactories).isEmpty()) {
            z2 = false;
        } else {
            Iterator<InterfaceC11355b> it = fictitiousClassDescriptorFactories.iterator();
            while (it.hasNext()) {
                if (it.next().shouldCreateClass(this.f24598h, c11716e)) {
                    z2 = true;
                }
            }
            z2 = false;
        }
        return z2;
    }

    public void recordLookup(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        C11478a.record(this.f24568c.getComponents().getLookupTracker(), interfaceC11480b, this.f24597g, c11716e);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11771j, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11773l
    public List<InterfaceC11450m> getContributedDescriptors(C11765d c11765d, Function1<? super C11716e, Boolean> function1) {
        C12238m.checkNotNullParameter(c11765d, "kindFilter");
        C12238m.checkNotNullParameter(function1, "nameFilter");
        Collection<InterfaceC11450m> collectionM9964b = m9964b(c11765d, function1, EnumC11482d.WHEN_GET_ALL_DESCRIPTORS);
        Iterable<InterfaceC11355b> fictitiousClassDescriptorFactories = this.f24568c.getComponents().getFictitiousClassDescriptorFactories();
        ArrayList arrayList = new ArrayList();
        Iterator<InterfaceC11355b> it = fictitiousClassDescriptorFactories.iterator();
        while (it.hasNext()) {
            C12160r.addAll(arrayList, it.next().getAllContributedClassesIfPossible(this.f24598h));
        }
        return C12163u.plus((Collection) collectionM9964b, (Iterable) arrayList);
    }
}
