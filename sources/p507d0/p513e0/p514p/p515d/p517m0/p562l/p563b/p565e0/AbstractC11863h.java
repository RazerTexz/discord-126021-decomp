package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0;

import com.discord.models.domain.ModelAuditLogEntry;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p507d0.p512d0.C11226f;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11465t0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11475y0;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.InterfaceC11480b;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11684i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11689n;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11693r;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11721a;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11722b;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11790h;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11771j;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.C11765d;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.C11876l;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.C11885u;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.C11887w;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.C11896f;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.C11904n;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11898h;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11899i;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11900j;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11901k;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12033a;
import p507d0.p578f0.C12075n;
import p507d0.p578f0.C12078q;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12150o0;
import p507d0.p580t.C12153q;
import p507d0.p580t.C12160r;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.C12250y;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h */
/* JADX INFO: compiled from: DeserializedMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11863h extends AbstractC11771j {

    /* JADX INFO: renamed from: b */
    public static final /* synthetic */ KProperty<Object>[] f24567b = {C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(AbstractC11863h.class), "classNames", "getClassNames$deserialization()Ljava/util/Set;")), C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(AbstractC11863h.class), "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;"))};

    /* JADX INFO: renamed from: c */
    public final C11876l f24568c;

    /* JADX INFO: renamed from: d */
    public final a f24569d;

    /* JADX INFO: renamed from: e */
    public final InterfaceC11900j f24570e;

    /* JADX INFO: renamed from: f */
    public final InterfaceC11901k f24571f;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$a */
    /* JADX INFO: compiled from: DeserializedMemberScope.kt */
    public interface a {
        void addFunctionsAndPropertiesTo(Collection<InterfaceC11450m> collection, C11765d c11765d, Function1<? super C11716e, Boolean> function1, InterfaceC11480b interfaceC11480b);

        Collection<InterfaceC11465t0> getContributedFunctions(C11716e c11716e, InterfaceC11480b interfaceC11480b);

        Collection<InterfaceC11453n0> getContributedVariables(C11716e c11716e, InterfaceC11480b interfaceC11480b);

        Set<C11716e> getFunctionNames();

        InterfaceC11475y0 getTypeAliasByName(C11716e c11716e);

        Set<C11716e> getTypeAliasNames();

        Set<C11716e> getVariableNames();
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$b */
    /* JADX INFO: compiled from: DeserializedMemberScope.kt */
    public final class b implements a {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ KProperty<Object>[] f24572a = {C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(b.class), "declaredFunctions", "getDeclaredFunctions()Ljava/util/List;")), C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(b.class), "declaredProperties", "getDeclaredProperties()Ljava/util/List;")), C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(b.class), "allTypeAliases", "getAllTypeAliases()Ljava/util/List;")), C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(b.class), "allFunctions", "getAllFunctions()Ljava/util/List;")), C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(b.class), "allProperties", "getAllProperties()Ljava/util/List;")), C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(b.class), "typeAliasesByName", "getTypeAliasesByName()Ljava/util/Map;")), C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(b.class), "functionsByName", "getFunctionsByName()Ljava/util/Map;")), C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(b.class), "propertiesByName", "getPropertiesByName()Ljava/util/Map;")), C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(b.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(b.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};

        /* JADX INFO: renamed from: b */
        public final List<C11684i> f24573b;

        /* JADX INFO: renamed from: c */
        public final List<C11689n> f24574c;

        /* JADX INFO: renamed from: d */
        public final List<C11693r> f24575d;

        /* JADX INFO: renamed from: e */
        public final InterfaceC11900j f24576e;

        /* JADX INFO: renamed from: f */
        public final InterfaceC11900j f24577f;

        /* JADX INFO: renamed from: g */
        public final InterfaceC11900j f24578g;

        /* JADX INFO: renamed from: h */
        public final InterfaceC11900j f24579h;

        /* JADX INFO: renamed from: i */
        public final InterfaceC11900j f24580i;

        /* JADX INFO: renamed from: j */
        public final InterfaceC11900j f24581j;

        /* JADX INFO: renamed from: k */
        public final InterfaceC11900j f24582k;

        /* JADX INFO: renamed from: l */
        public final InterfaceC11900j f24583l;

        /* JADX INFO: renamed from: m */
        public final InterfaceC11900j f24584m;

        /* JADX INFO: renamed from: n */
        public final InterfaceC11900j f24585n;

        /* JADX INFO: renamed from: o */
        public final /* synthetic */ AbstractC11863h f24586o;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$b$a */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class a extends AbstractC12240o implements Function0<List<? extends InterfaceC11465t0>> {
            public a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends InterfaceC11465t0> invoke() {
                return C12163u.plus((Collection) b.access$getDeclaredFunctions(b.this), (Iterable) b.access$computeAllNonDeclaredFunctions(b.this));
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class C13332b extends AbstractC12240o implements Function0<List<? extends InterfaceC11453n0>> {
            public C13332b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends InterfaceC11453n0> invoke() {
                return C12163u.plus((Collection) b.access$getDeclaredProperties(b.this), (Iterable) b.access$computeAllNonDeclaredProperties(b.this));
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$b$c */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class c extends AbstractC12240o implements Function0<List<? extends InterfaceC11475y0>> {
            public c() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends InterfaceC11475y0> invoke() {
                return b.access$computeTypeAliases(b.this);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$b$d */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class d extends AbstractC12240o implements Function0<List<? extends InterfaceC11465t0>> {
            public d() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends InterfaceC11465t0> invoke() {
                return b.access$computeFunctions(b.this);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$b$e */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class e extends AbstractC12240o implements Function0<List<? extends InterfaceC11453n0>> {
            public e() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends InterfaceC11453n0> invoke() {
                return b.access$computeProperties(b.this);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$b$f */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class f extends AbstractC12240o implements Function0<Set<? extends C11716e>> {
            public final /* synthetic */ AbstractC11863h this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(AbstractC11863h abstractC11863h) {
                super(0);
                this.this$1 = abstractC11863h;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Set<? extends C11716e> invoke() {
                b bVar = b.this;
                List list = bVar.f24573b;
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                AbstractC11863h abstractC11863h = bVar.f24586o;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    linkedHashSet.add(C11887w.getName(abstractC11863h.f24568c.getNameResolver(), ((C11684i) ((InterfaceC11734n) it.next())).getName()));
                }
                return C12150o0.plus((Set) linkedHashSet, (Iterable) this.this$1.mo9960g());
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$b$g */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class g extends AbstractC12240o implements Function0<Map<C11716e, ? extends List<? extends InterfaceC11465t0>>> {
            public g() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Map<C11716e, ? extends List<? extends InterfaceC11465t0>> invoke() {
                List listAccess$getAllFunctions = b.access$getAllFunctions(b.this);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj : listAccess$getAllFunctions) {
                    C11716e name = ((InterfaceC11465t0) obj).getName();
                    C12238m.checkNotNullExpressionValue(name, "it.name");
                    Object arrayList = linkedHashMap.get(name);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        linkedHashMap.put(name, arrayList);
                    }
                    ((List) arrayList).add(obj);
                }
                return linkedHashMap;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$b$h */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class h extends AbstractC12240o implements Function0<Map<C11716e, ? extends List<? extends InterfaceC11453n0>>> {
            public h() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Map<C11716e, ? extends List<? extends InterfaceC11453n0>> invoke() {
                List listAccess$getAllProperties = b.access$getAllProperties(b.this);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj : listAccess$getAllProperties) {
                    C11716e name = ((InterfaceC11453n0) obj).getName();
                    C12238m.checkNotNullExpressionValue(name, "it.name");
                    Object arrayList = linkedHashMap.get(name);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        linkedHashMap.put(name, arrayList);
                    }
                    ((List) arrayList).add(obj);
                }
                return linkedHashMap;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$b$i */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class i extends AbstractC12240o implements Function0<Map<C11716e, ? extends InterfaceC11475y0>> {
            public i() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Map<C11716e, ? extends InterfaceC11475y0> invoke() {
                List listAccess$getAllTypeAliases = b.access$getAllTypeAliases(b.this);
                LinkedHashMap linkedHashMap = new LinkedHashMap(C11226f.coerceAtLeast(C12134g0.mapCapacity(C12149o.collectionSizeOrDefault(listAccess$getAllTypeAliases, 10)), 16));
                for (Object obj : listAccess$getAllTypeAliases) {
                    C11716e name = ((InterfaceC11475y0) obj).getName();
                    C12238m.checkNotNullExpressionValue(name, "it.name");
                    linkedHashMap.put(name, obj);
                }
                return linkedHashMap;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$b$j */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class j extends AbstractC12240o implements Function0<Set<? extends C11716e>> {
            public final /* synthetic */ AbstractC11863h this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public j(AbstractC11863h abstractC11863h) {
                super(0);
                this.this$1 = abstractC11863h;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Set<? extends C11716e> invoke() {
                b bVar = b.this;
                List list = bVar.f24574c;
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                AbstractC11863h abstractC11863h = bVar.f24586o;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    linkedHashSet.add(C11887w.getName(abstractC11863h.f24568c.getNameResolver(), ((C11689n) ((InterfaceC11734n) it.next())).getName()));
                }
                return C12150o0.plus((Set) linkedHashSet, (Iterable) this.this$1.mo9961h());
            }
        }

        public b(AbstractC11863h abstractC11863h, List<C11684i> list, List<C11689n> list2, List<C11693r> list3) {
            C12238m.checkNotNullParameter(abstractC11863h, "this$0");
            C12238m.checkNotNullParameter(list, "functionList");
            C12238m.checkNotNullParameter(list2, "propertyList");
            C12238m.checkNotNullParameter(list3, "typeAliasList");
            this.f24586o = abstractC11863h;
            this.f24573b = list;
            this.f24574c = list2;
            this.f24575d = abstractC11863h.f24568c.getComponents().getConfiguration().getTypeAliasesAllowed() ? list3 : C12147n.emptyList();
            this.f24576e = abstractC11863h.f24568c.getStorageManager().createLazyValue(new d());
            this.f24577f = abstractC11863h.f24568c.getStorageManager().createLazyValue(new e());
            this.f24578g = abstractC11863h.f24568c.getStorageManager().createLazyValue(new c());
            this.f24579h = abstractC11863h.f24568c.getStorageManager().createLazyValue(new a());
            this.f24580i = abstractC11863h.f24568c.getStorageManager().createLazyValue(new C13332b());
            this.f24581j = abstractC11863h.f24568c.getStorageManager().createLazyValue(new i());
            this.f24582k = abstractC11863h.f24568c.getStorageManager().createLazyValue(new g());
            this.f24583l = abstractC11863h.f24568c.getStorageManager().createLazyValue(new h());
            this.f24584m = abstractC11863h.f24568c.getStorageManager().createLazyValue(new f(abstractC11863h));
            this.f24585n = abstractC11863h.f24568c.getStorageManager().createLazyValue(new j(abstractC11863h));
        }

        public static final List access$computeAllNonDeclaredFunctions(b bVar) {
            Set<C11716e> setMo9960g = bVar.f24586o.mo9960g();
            ArrayList arrayList = new ArrayList();
            for (C11716e c11716e : setMo9960g) {
                List list = (List) C11904n.getValue(bVar.f24576e, bVar, (KProperty<?>) f24572a[0]);
                AbstractC11863h abstractC11863h = bVar.f24586o;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : list) {
                    if (C12238m.areEqual(((InterfaceC11450m) obj).getName(), c11716e)) {
                        arrayList2.add(obj);
                    }
                }
                int size = arrayList2.size();
                abstractC11863h.mo9956c(c11716e, arrayList2);
                C12160r.addAll(arrayList, arrayList2.subList(size, arrayList2.size()));
            }
            return arrayList;
        }

        public static final List access$computeAllNonDeclaredProperties(b bVar) {
            Set<C11716e> setMo9961h = bVar.f24586o.mo9961h();
            ArrayList arrayList = new ArrayList();
            for (C11716e c11716e : setMo9961h) {
                List list = (List) C11904n.getValue(bVar.f24577f, bVar, (KProperty<?>) f24572a[1]);
                AbstractC11863h abstractC11863h = bVar.f24586o;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : list) {
                    if (C12238m.areEqual(((InterfaceC11450m) obj).getName(), c11716e)) {
                        arrayList2.add(obj);
                    }
                }
                int size = arrayList2.size();
                abstractC11863h.mo9957d(c11716e, arrayList2);
                C12160r.addAll(arrayList, arrayList2.subList(size, arrayList2.size()));
            }
            return arrayList;
        }

        public static final List access$computeFunctions(b bVar) {
            List<C11684i> list = bVar.f24573b;
            AbstractC11863h abstractC11863h = bVar.f24586o;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                InterfaceC11465t0 interfaceC11465t0LoadFunction = abstractC11863h.f24568c.getMemberDeserializer().loadFunction((C11684i) ((InterfaceC11734n) it.next()));
                if (!abstractC11863h.mo9962j(interfaceC11465t0LoadFunction)) {
                    interfaceC11465t0LoadFunction = null;
                }
                if (interfaceC11465t0LoadFunction != null) {
                    arrayList.add(interfaceC11465t0LoadFunction);
                }
            }
            return arrayList;
        }

        public static final List access$computeProperties(b bVar) {
            List<C11689n> list = bVar.f24574c;
            AbstractC11863h abstractC11863h = bVar.f24586o;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                InterfaceC11453n0 interfaceC11453n0LoadProperty = abstractC11863h.f24568c.getMemberDeserializer().loadProperty((C11689n) ((InterfaceC11734n) it.next()));
                if (interfaceC11453n0LoadProperty != null) {
                    arrayList.add(interfaceC11453n0LoadProperty);
                }
            }
            return arrayList;
        }

        public static final List access$computeTypeAliases(b bVar) {
            List<C11693r> list = bVar.f24575d;
            AbstractC11863h abstractC11863h = bVar.f24586o;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                InterfaceC11475y0 interfaceC11475y0LoadTypeAlias = abstractC11863h.f24568c.getMemberDeserializer().loadTypeAlias((C11693r) ((InterfaceC11734n) it.next()));
                if (interfaceC11475y0LoadTypeAlias != null) {
                    arrayList.add(interfaceC11475y0LoadTypeAlias);
                }
            }
            return arrayList;
        }

        public static final List access$getAllFunctions(b bVar) {
            return (List) C11904n.getValue(bVar.f24579h, bVar, (KProperty<?>) f24572a[3]);
        }

        public static final List access$getAllProperties(b bVar) {
            return (List) C11904n.getValue(bVar.f24580i, bVar, (KProperty<?>) f24572a[4]);
        }

        public static final List access$getAllTypeAliases(b bVar) {
            return (List) C11904n.getValue(bVar.f24578g, bVar, (KProperty<?>) f24572a[2]);
        }

        public static final List access$getDeclaredFunctions(b bVar) {
            return (List) C11904n.getValue(bVar.f24576e, bVar, (KProperty<?>) f24572a[0]);
        }

        public static final List access$getDeclaredProperties(b bVar) {
            return (List) C11904n.getValue(bVar.f24577f, bVar, (KProperty<?>) f24572a[1]);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.AbstractC11863h.a
        public void addFunctionsAndPropertiesTo(Collection<InterfaceC11450m> collection, C11765d c11765d, Function1<? super C11716e, Boolean> function1, InterfaceC11480b interfaceC11480b) {
            C12238m.checkNotNullParameter(collection, "result");
            C12238m.checkNotNullParameter(c11765d, "kindFilter");
            C12238m.checkNotNullParameter(function1, "nameFilter");
            C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            if (c11765d.acceptsKinds(C11765d.f24339a.getVARIABLES_MASK())) {
                for (Object obj : (List) C11904n.getValue(this.f24580i, this, (KProperty<?>) f24572a[4])) {
                    C11716e name = ((InterfaceC11453n0) obj).getName();
                    C12238m.checkNotNullExpressionValue(name, "it.name");
                    if (function1.invoke(name).booleanValue()) {
                        collection.add(obj);
                    }
                }
            }
            if (c11765d.acceptsKinds(C11765d.f24339a.getFUNCTIONS_MASK())) {
                for (Object obj2 : (List) C11904n.getValue(this.f24579h, this, (KProperty<?>) f24572a[3])) {
                    C11716e name2 = ((InterfaceC11465t0) obj2).getName();
                    C12238m.checkNotNullExpressionValue(name2, "it.name");
                    if (function1.invoke(name2).booleanValue()) {
                        collection.add(obj2);
                    }
                }
            }
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.AbstractC11863h.a
        public Collection<InterfaceC11465t0> getContributedFunctions(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
            Collection<InterfaceC11465t0> collection;
            C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            return (getFunctionNames().contains(c11716e) && (collection = (Collection) ((Map) C11904n.getValue(this.f24582k, this, (KProperty<?>) f24572a[6])).get(c11716e)) != null) ? collection : C12147n.emptyList();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.AbstractC11863h.a
        public Collection<InterfaceC11453n0> getContributedVariables(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
            Collection<InterfaceC11453n0> collection;
            C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            return (getVariableNames().contains(c11716e) && (collection = (Collection) ((Map) C11904n.getValue(this.f24583l, this, (KProperty<?>) f24572a[7])).get(c11716e)) != null) ? collection : C12147n.emptyList();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.AbstractC11863h.a
        public Set<C11716e> getFunctionNames() {
            return (Set) C11904n.getValue(this.f24584m, this, (KProperty<?>) f24572a[8]);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.AbstractC11863h.a
        public InterfaceC11475y0 getTypeAliasByName(C11716e c11716e) {
            C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
            return (InterfaceC11475y0) ((Map) C11904n.getValue(this.f24581j, this, (KProperty<?>) f24572a[5])).get(c11716e);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.AbstractC11863h.a
        public Set<C11716e> getTypeAliasNames() {
            List<C11693r> list = this.f24575d;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            AbstractC11863h abstractC11863h = this.f24586o;
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(C11887w.getName(abstractC11863h.f24568c.getNameResolver(), ((C11693r) ((InterfaceC11734n) it.next())).getName()));
            }
            return linkedHashSet;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.AbstractC11863h.a
        public Set<C11716e> getVariableNames() {
            return (Set) C11904n.getValue(this.f24585n, this, (KProperty<?>) f24572a[9]);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$c */
    /* JADX INFO: compiled from: DeserializedMemberScope.kt */
    public final class c implements a {

        /* JADX INFO: renamed from: a */
        public static final /* synthetic */ KProperty<Object>[] f24587a = {C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(c.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), C12216a0.property1(new C12250y(C12216a0.getOrCreateKotlinClass(c.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};

        /* JADX INFO: renamed from: b */
        public final Map<C11716e, byte[]> f24588b;

        /* JADX INFO: renamed from: c */
        public final Map<C11716e, byte[]> f24589c;

        /* JADX INFO: renamed from: d */
        public final Map<C11716e, byte[]> f24590d;

        /* JADX INFO: renamed from: e */
        public final InterfaceC11898h<C11716e, Collection<InterfaceC11465t0>> f24591e;

        /* JADX INFO: renamed from: f */
        public final InterfaceC11898h<C11716e, Collection<InterfaceC11453n0>> f24592f;

        /* JADX INFO: renamed from: g */
        public final InterfaceC11899i<C11716e, InterfaceC11475y0> f24593g;

        /* JADX INFO: renamed from: h */
        public final InterfaceC11900j f24594h;

        /* JADX INFO: renamed from: i */
        public final InterfaceC11900j f24595i;

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ AbstractC11863h f24596j;

        /* JADX INFO: Add missing generic type declarations: [M] */
        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$c$a */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class a<M> extends AbstractC12240o implements Function0<M> {
            public final /* synthetic */ ByteArrayInputStream $inputStream;
            public final /* synthetic */ InterfaceC11736p<M> $parser;
            public final /* synthetic */ AbstractC11863h this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(InterfaceC11736p<M> interfaceC11736p, ByteArrayInputStream byteArrayInputStream, AbstractC11863h abstractC11863h) {
                super(0);
                this.$parser = interfaceC11736p;
                this.$inputStream = byteArrayInputStream;
                this.this$0 = abstractC11863h;
            }

            /* JADX WARN: Incorrect return type in method signature: ()TM; */
            @Override // kotlin.jvm.functions.Function0
            public final InterfaceC11734n invoke() {
                return (InterfaceC11734n) ((AbstractC11722b) this.$parser).m11466parseDelimitedFrom((InputStream) this.$inputStream, this.this$0.f24568c.getComponents().getExtensionRegistryLite());
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$c$b */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class b extends AbstractC12240o implements Function0<Set<? extends C11716e>> {
            public final /* synthetic */ AbstractC11863h this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(AbstractC11863h abstractC11863h) {
                super(0);
                this.this$1 = abstractC11863h;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Set<? extends C11716e> invoke() {
                return C12150o0.plus(c.this.f24588b.keySet(), (Iterable) this.this$1.mo9960g());
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class C13333c extends AbstractC12240o implements Function1<C11716e, Collection<? extends InterfaceC11465t0>> {
            public C13333c() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Collection<InterfaceC11465t0> invoke(C11716e c11716e) {
                C12238m.checkNotNullParameter(c11716e, "it");
                return c.access$computeFunctions(c.this, c11716e);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$c$d */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class d extends AbstractC12240o implements Function1<C11716e, Collection<? extends InterfaceC11453n0>> {
            public d() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Collection<InterfaceC11453n0> invoke(C11716e c11716e) {
                C12238m.checkNotNullParameter(c11716e, "it");
                return c.access$computeProperties(c.this, c11716e);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$c$e */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class e extends AbstractC12240o implements Function1<C11716e, InterfaceC11475y0> {
            public e() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final InterfaceC11475y0 invoke(C11716e c11716e) {
                C12238m.checkNotNullParameter(c11716e, "it");
                return c.access$createTypeAlias(c.this, c11716e);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$c$f */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class f extends AbstractC12240o implements Function0<Set<? extends C11716e>> {
            public final /* synthetic */ AbstractC11863h this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(AbstractC11863h abstractC11863h) {
                super(0);
                this.this$1 = abstractC11863h;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Set<? extends C11716e> invoke() {
                return C12150o0.plus(c.this.f24589c.keySet(), (Iterable) this.this$1.mo9961h());
            }
        }

        public c(AbstractC11863h abstractC11863h, List<C11684i> list, List<C11689n> list2, List<C11693r> list3) throws IOException {
            Map<C11716e, byte[]> mapEmptyMap;
            C12238m.checkNotNullParameter(abstractC11863h, "this$0");
            C12238m.checkNotNullParameter(list, "functionList");
            C12238m.checkNotNullParameter(list2, "propertyList");
            C12238m.checkNotNullParameter(list3, "typeAliasList");
            this.f24596j = abstractC11863h;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : list) {
                C11716e name = C11887w.getName(abstractC11863h.f24568c.getNameResolver(), ((C11684i) ((InterfaceC11734n) obj)).getName());
                Object arrayList = linkedHashMap.get(name);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(name, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            this.f24588b = m9966a(linkedHashMap);
            AbstractC11863h abstractC11863h2 = this.f24596j;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj2 : list2) {
                C11716e name2 = C11887w.getName(abstractC11863h2.f24568c.getNameResolver(), ((C11689n) ((InterfaceC11734n) obj2)).getName());
                Object arrayList2 = linkedHashMap2.get(name2);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    linkedHashMap2.put(name2, arrayList2);
                }
                ((List) arrayList2).add(obj2);
            }
            this.f24589c = m9966a(linkedHashMap2);
            if (this.f24596j.f24568c.getComponents().getConfiguration().getTypeAliasesAllowed()) {
                AbstractC11863h abstractC11863h3 = this.f24596j;
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                for (Object obj3 : list3) {
                    C11716e name3 = C11887w.getName(abstractC11863h3.f24568c.getNameResolver(), ((C11693r) ((InterfaceC11734n) obj3)).getName());
                    Object arrayList3 = linkedHashMap3.get(name3);
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                        linkedHashMap3.put(name3, arrayList3);
                    }
                    ((List) arrayList3).add(obj3);
                }
                mapEmptyMap = m9966a(linkedHashMap3);
            } else {
                mapEmptyMap = C12136h0.emptyMap();
            }
            this.f24590d = mapEmptyMap;
            this.f24591e = this.f24596j.f24568c.getStorageManager().createMemoizedFunction(new C13333c());
            this.f24592f = this.f24596j.f24568c.getStorageManager().createMemoizedFunction(new d());
            this.f24593g = this.f24596j.f24568c.getStorageManager().createMemoizedFunctionWithNullableValues(new e());
            this.f24594h = this.f24596j.f24568c.getStorageManager().createLazyValue(new b(this.f24596j));
            this.f24595i = this.f24596j.f24568c.getStorageManager().createLazyValue(new f(this.f24596j));
        }

        public static final Collection access$computeFunctions(c cVar, C11716e c11716e) {
            Map<C11716e, byte[]> map = cVar.f24588b;
            InterfaceC11736p<C11684i> interfaceC11736p = C11684i.f23831k;
            C12238m.checkNotNullExpressionValue(interfaceC11736p, "PARSER");
            AbstractC11863h abstractC11863h = cVar.f24596j;
            byte[] bArr = map.get(c11716e);
            List<C11684i> list = bArr == null ? null : C12078q.toList(C12075n.generateSequence(new a(interfaceC11736p, new ByteArrayInputStream(bArr), cVar.f24596j)));
            if (list == null) {
                list = C12147n.emptyList();
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (C11684i c11684i : list) {
                C11885u memberDeserializer = abstractC11863h.f24568c.getMemberDeserializer();
                C12238m.checkNotNullExpressionValue(c11684i, "it");
                InterfaceC11465t0 interfaceC11465t0LoadFunction = memberDeserializer.loadFunction(c11684i);
                if (!abstractC11863h.mo9962j(interfaceC11465t0LoadFunction)) {
                    interfaceC11465t0LoadFunction = null;
                }
                if (interfaceC11465t0LoadFunction != null) {
                    arrayList.add(interfaceC11465t0LoadFunction);
                }
            }
            abstractC11863h.mo9956c(c11716e, arrayList);
            return C12033a.compact(arrayList);
        }

        public static final Collection access$computeProperties(c cVar, C11716e c11716e) {
            Map<C11716e, byte[]> map = cVar.f24589c;
            InterfaceC11736p<C11689n> interfaceC11736p = C11689n.f23871k;
            C12238m.checkNotNullExpressionValue(interfaceC11736p, "PARSER");
            AbstractC11863h abstractC11863h = cVar.f24596j;
            byte[] bArr = map.get(c11716e);
            List<C11689n> list = bArr == null ? null : C12078q.toList(C12075n.generateSequence(new a(interfaceC11736p, new ByteArrayInputStream(bArr), cVar.f24596j)));
            if (list == null) {
                list = C12147n.emptyList();
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (C11689n c11689n : list) {
                C11885u memberDeserializer = abstractC11863h.f24568c.getMemberDeserializer();
                C12238m.checkNotNullExpressionValue(c11689n, "it");
                InterfaceC11453n0 interfaceC11453n0LoadProperty = memberDeserializer.loadProperty(c11689n);
                if (interfaceC11453n0LoadProperty != null) {
                    arrayList.add(interfaceC11453n0LoadProperty);
                }
            }
            abstractC11863h.mo9957d(c11716e, arrayList);
            return C12033a.compact(arrayList);
        }

        public static final InterfaceC11475y0 access$createTypeAlias(c cVar, C11716e c11716e) {
            C11693r delimitedFrom;
            byte[] bArr = cVar.f24590d.get(c11716e);
            if (bArr == null || (delimitedFrom = C11693r.parseDelimitedFrom(new ByteArrayInputStream(bArr), cVar.f24596j.f24568c.getComponents().getExtensionRegistryLite())) == null) {
                return null;
            }
            return cVar.f24596j.f24568c.getMemberDeserializer().loadTypeAlias(delimitedFrom);
        }

        /* JADX INFO: renamed from: a */
        public final Map<C11716e, byte[]> m9966a(Map<C11716e, ? extends Collection<? extends AbstractC11721a>> map) throws IOException {
            LinkedHashMap linkedHashMap = new LinkedHashMap(C12134g0.mapCapacity(map.size()));
            Iterator<T> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Iterable iterable = (Iterable) entry.getValue();
                ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(iterable, 10));
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    ((AbstractC11721a) it2.next()).writeDelimitedTo(byteArrayOutputStream);
                    arrayList.add(Unit.f27425a);
                }
                linkedHashMap.put(key, byteArrayOutputStream.toByteArray());
            }
            return linkedHashMap;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.AbstractC11863h.a
        public void addFunctionsAndPropertiesTo(Collection<InterfaceC11450m> collection, C11765d c11765d, Function1<? super C11716e, Boolean> function1, InterfaceC11480b interfaceC11480b) {
            C12238m.checkNotNullParameter(collection, "result");
            C12238m.checkNotNullParameter(c11765d, "kindFilter");
            C12238m.checkNotNullParameter(function1, "nameFilter");
            C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            if (c11765d.acceptsKinds(C11765d.f24339a.getVARIABLES_MASK())) {
                Set<C11716e> variableNames = getVariableNames();
                ArrayList arrayList = new ArrayList();
                for (C11716e c11716e : variableNames) {
                    if (function1.invoke(c11716e).booleanValue()) {
                        arrayList.addAll(getContributedVariables(c11716e, interfaceC11480b));
                    }
                }
                C11790h c11790h = C11790h.f24409j;
                C12238m.checkNotNullExpressionValue(c11790h, "INSTANCE");
                C12153q.sortWith(arrayList, c11790h);
                collection.addAll(arrayList);
            }
            if (c11765d.acceptsKinds(C11765d.f24339a.getFUNCTIONS_MASK())) {
                Set<C11716e> functionNames = getFunctionNames();
                ArrayList arrayList2 = new ArrayList();
                for (C11716e c11716e2 : functionNames) {
                    if (function1.invoke(c11716e2).booleanValue()) {
                        arrayList2.addAll(getContributedFunctions(c11716e2, interfaceC11480b));
                    }
                }
                C11790h c11790h2 = C11790h.f24409j;
                C12238m.checkNotNullExpressionValue(c11790h2, "INSTANCE");
                C12153q.sortWith(arrayList2, c11790h2);
                collection.addAll(arrayList2);
            }
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.AbstractC11863h.a
        public Collection<InterfaceC11465t0> getContributedFunctions(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
            C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            return !getFunctionNames().contains(c11716e) ? C12147n.emptyList() : (Collection) ((C11896f.m) this.f24591e).invoke(c11716e);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.AbstractC11863h.a
        public Collection<InterfaceC11453n0> getContributedVariables(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
            C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            return !getVariableNames().contains(c11716e) ? C12147n.emptyList() : (Collection) ((C11896f.m) this.f24592f).invoke(c11716e);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.AbstractC11863h.a
        public Set<C11716e> getFunctionNames() {
            return (Set) C11904n.getValue(this.f24594h, this, (KProperty<?>) f24587a[0]);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.AbstractC11863h.a
        public InterfaceC11475y0 getTypeAliasByName(C11716e c11716e) {
            C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
            return this.f24593g.invoke(c11716e);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.AbstractC11863h.a
        public Set<C11716e> getTypeAliasNames() {
            return this.f24590d.keySet();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.AbstractC11863h.a
        public Set<C11716e> getVariableNames() {
            return (Set) C11904n.getValue(this.f24595i, this, (KProperty<?>) f24587a[1]);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$d */
    /* JADX INFO: compiled from: DeserializedMemberScope.kt */
    public static final class d extends AbstractC12240o implements Function0<Set<? extends C11716e>> {
        public final /* synthetic */ Function0<Collection<C11716e>> $classNames;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(Function0<? extends Collection<C11716e>> function0) {
            super(0);
            this.$classNames = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Set<? extends C11716e> invoke() {
            return C12163u.toSet(this.$classNames.invoke());
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$e */
    /* JADX INFO: compiled from: DeserializedMemberScope.kt */
    public static final class e extends AbstractC12240o implements Function0<Set<? extends C11716e>> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Set<? extends C11716e> invoke() {
            Set<C11716e> setMo9959f = AbstractC11863h.this.mo9959f();
            if (setMo9959f == null) {
                return null;
            }
            return C12150o0.plus(C12150o0.plus((Set) AbstractC11863h.this.getClassNames$deserialization(), (Iterable) AbstractC11863h.this.f24569d.getTypeAliasNames()), (Iterable) setMo9959f);
        }
    }

    public AbstractC11863h(C11876l c11876l, List<C11684i> list, List<C11689n> list2, List<C11693r> list3, Function0<? extends Collection<C11716e>> function0) {
        C12238m.checkNotNullParameter(c11876l, "c");
        C12238m.checkNotNullParameter(list, "functionList");
        C12238m.checkNotNullParameter(list2, "propertyList");
        C12238m.checkNotNullParameter(list3, "typeAliasList");
        C12238m.checkNotNullParameter(function0, "classNames");
        this.f24568c = c11876l;
        this.f24569d = c11876l.getComponents().getConfiguration().getPreserveDeclarationsOrdering() ? new b(this, list, list2, list3) : new c(this, list, list2, list3);
        this.f24570e = c11876l.getStorageManager().createLazyValue(new d(function0));
        this.f24571f = c11876l.getStorageManager().createNullableLazyValue(new e());
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo9955a(Collection<InterfaceC11450m> collection, Function1<? super C11716e, Boolean> function1);

    /* JADX INFO: renamed from: b */
    public final Collection<InterfaceC11450m> m9964b(C11765d c11765d, Function1<? super C11716e, Boolean> function1, InterfaceC11480b interfaceC11480b) {
        C12238m.checkNotNullParameter(c11765d, "kindFilter");
        C12238m.checkNotNullParameter(function1, "nameFilter");
        C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        ArrayList arrayList = new ArrayList(0);
        C11765d.a aVar = C11765d.f24339a;
        if (c11765d.acceptsKinds(aVar.getSINGLETON_CLASSIFIERS_MASK())) {
            mo9955a(arrayList, function1);
        }
        this.f24569d.addFunctionsAndPropertiesTo(arrayList, c11765d, function1, interfaceC11480b);
        if (c11765d.acceptsKinds(aVar.getCLASSIFIERS_MASK())) {
            for (C11716e c11716e : getClassNames$deserialization()) {
                if (function1.invoke(c11716e).booleanValue()) {
                    C12033a.addIfNotNull(arrayList, this.f24568c.getComponents().deserializeClass(mo9958e(c11716e)));
                }
            }
        }
        if (c11765d.acceptsKinds(C11765d.f24339a.getTYPE_ALIASES_MASK())) {
            for (C11716e c11716e2 : this.f24569d.getTypeAliasNames()) {
                if (function1.invoke(c11716e2).booleanValue()) {
                    C12033a.addIfNotNull(arrayList, this.f24569d.getTypeAliasByName(c11716e2));
                }
            }
        }
        return C12033a.compact(arrayList);
    }

    /* JADX INFO: renamed from: c */
    public void mo9956c(C11716e c11716e, List<InterfaceC11465t0> list) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(list, "functions");
    }

    /* JADX INFO: renamed from: d */
    public void mo9957d(C11716e c11716e, List<InterfaceC11453n0> list) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(list, "descriptors");
    }

    /* JADX INFO: renamed from: e */
    public abstract C11712a mo9958e(C11716e c11716e);

    /* JADX INFO: renamed from: f */
    public abstract Set<C11716e> mo9959f();

    /* JADX INFO: renamed from: g */
    public abstract Set<C11716e> mo9960g();

    public final Set<C11716e> getClassNames$deserialization() {
        return (Set) C11904n.getValue(this.f24570e, this, (KProperty<?>) f24567b[0]);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11771j, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Set<C11716e> getClassifierNames() {
        return (Set) C11904n.getValue(this.f24571f, this, (KProperty<?>) f24567b[1]);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11771j, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11773l
    public InterfaceC11352h getContributedClassifier(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        if (mo9965i(c11716e)) {
            return this.f24568c.getComponents().deserializeClass(mo9958e(c11716e));
        }
        if (this.f24569d.getTypeAliasNames().contains(c11716e)) {
            return this.f24569d.getTypeAliasByName(c11716e);
        }
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11771j, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Collection<InterfaceC11465t0> getContributedFunctions(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return this.f24569d.getContributedFunctions(c11716e, interfaceC11480b);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11771j, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Collection<InterfaceC11453n0> getContributedVariables(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(interfaceC11480b, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return this.f24569d.getContributedVariables(c11716e, interfaceC11480b);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11771j, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Set<C11716e> getFunctionNames() {
        return this.f24569d.getFunctionNames();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.AbstractC11771j, p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
    public Set<C11716e> getVariableNames() {
        return this.f24569d.getVariableNames();
    }

    /* JADX INFO: renamed from: h */
    public abstract Set<C11716e> mo9961h();

    /* JADX INFO: renamed from: i */
    public boolean mo9965i(C11716e c11716e) {
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return getClassNames$deserialization().contains(c11716e);
    }

    /* JADX INFO: renamed from: j */
    public boolean mo9962j(InterfaceC11465t0 interfaceC11465t0) {
        C12238m.checkNotNullParameter(interfaceC11465t0, "function");
        return true;
    }
}
