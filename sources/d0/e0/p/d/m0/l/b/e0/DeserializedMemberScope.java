package d0.e0.p.d.m0.l.b.e0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.d0._Ranges;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.SimpleFunctionDescriptor;
import d0.e0.p.d.m0.c.TypeAliasDescriptor;
import d0.e0.p.d.m0.d.b.LookupLocation2;
import d0.e0.p.d.m0.f.r;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.i.AbstractMessageLite;
import d0.e0.p.d.m0.i.AbstractParser;
import d0.e0.p.d.m0.i.MessageLite;
import d0.e0.p.d.m0.i.Parser2;
import d0.e0.p.d.m0.k.MemberComparator;
import d0.e0.p.d.m0.k.a0.MemberScope2;
import d0.e0.p.d.m0.k.a0.MemberScopeImpl;
import d0.e0.p.d.m0.l.b.MemberDeserializer;
import d0.e0.p.d.m0.l.b.NameResolverUtil;
import d0.e0.p.d.m0.l.b.context6;
import d0.e0.p.d.m0.m.LockBasedStorageManager;
import d0.e0.p.d.m0.m.storage3;
import d0.e0.p.d.m0.m.storage4;
import d0.e0.p.d.m0.m.storage5;
import d0.e0.p.d.m0.m.storage6;
import d0.e0.p.d.m0.m.storage7;
import d0.e0.p.d.m0.p.collections;
import d0.f0._Sequences2;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t.MutableCollections;
import d0.t.MutableCollectionsJVM;
import d0.t._Collections;
import d0.t._Sets;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.PropertyReference1Impl;
import d0.z.d.Reflection2;
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

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h, reason: use source file name */
/* JADX INFO: compiled from: DeserializedMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DeserializedMemberScope extends MemberScopeImpl {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ KProperty<Object>[] f3492b = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DeserializedMemberScope.class), "classNames", "getClassNames$deserialization()Ljava/util/Set;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(DeserializedMemberScope.class), "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;"))};
    public final context6 c;
    public final a d;
    public final storage5 e;
    public final storage6 f;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$a */
    /* JADX INFO: compiled from: DeserializedMemberScope.kt */
    public interface a {
        void addFunctionsAndPropertiesTo(Collection<DeclarationDescriptor> collection, MemberScope2 memberScope2, Function1<? super Name, Boolean> function1, LookupLocation2 lookupLocation2);

        Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation2 lookupLocation2);

        Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation2 lookupLocation2);

        Set<Name> getFunctionNames();

        TypeAliasDescriptor getTypeAliasByName(Name name);

        Set<Name> getTypeAliasNames();

        Set<Name> getVariableNames();
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$b */
    /* JADX INFO: compiled from: DeserializedMemberScope.kt */
    public final class b implements a {
        public static final /* synthetic */ KProperty<Object>[] a = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(b.class), "declaredFunctions", "getDeclaredFunctions()Ljava/util/List;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(b.class), "declaredProperties", "getDeclaredProperties()Ljava/util/List;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(b.class), "allTypeAliases", "getAllTypeAliases()Ljava/util/List;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(b.class), "allFunctions", "getAllFunctions()Ljava/util/List;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(b.class), "allProperties", "getAllProperties()Ljava/util/List;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(b.class), "typeAliasesByName", "getTypeAliasesByName()Ljava/util/Map;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(b.class), "functionsByName", "getFunctionsByName()Ljava/util/Map;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(b.class), "propertiesByName", "getPropertiesByName()Ljava/util/Map;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(b.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(b.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<d0.e0.p.d.m0.f.i> f3493b;
        public final List<d0.e0.p.d.m0.f.n> c;
        public final List<r> d;
        public final storage5 e;
        public final storage5 f;
        public final storage5 g;
        public final storage5 h;
        public final storage5 i;
        public final storage5 j;
        public final storage5 k;
        public final storage5 l;
        public final storage5 m;
        public final storage5 n;
        public final /* synthetic */ DeserializedMemberScope o;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$b$a */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class a extends Lambda implements Function0<List<? extends SimpleFunctionDescriptor>> {
            public a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends SimpleFunctionDescriptor> invoke() {
                return _Collections.plus((Collection) b.access$getDeclaredFunctions(b.this), (Iterable) b.access$computeAllNonDeclaredFunctions(b.this));
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class C0408b extends Lambda implements Function0<List<? extends PropertyDescriptor>> {
            public C0408b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends PropertyDescriptor> invoke() {
                return _Collections.plus((Collection) b.access$getDeclaredProperties(b.this), (Iterable) b.access$computeAllNonDeclaredProperties(b.this));
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$b$c */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class c extends Lambda implements Function0<List<? extends TypeAliasDescriptor>> {
            public c() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends TypeAliasDescriptor> invoke() {
                return b.access$computeTypeAliases(b.this);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$b$d */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class d extends Lambda implements Function0<List<? extends SimpleFunctionDescriptor>> {
            public d() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends SimpleFunctionDescriptor> invoke() {
                return b.access$computeFunctions(b.this);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$b$e */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class e extends Lambda implements Function0<List<? extends PropertyDescriptor>> {
            public e() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends PropertyDescriptor> invoke() {
                return b.access$computeProperties(b.this);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$b$f */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class f extends Lambda implements Function0<Set<? extends Name>> {
            public final /* synthetic */ DeserializedMemberScope this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(DeserializedMemberScope deserializedMemberScope) {
                super(0);
                this.this$1 = deserializedMemberScope;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Set<? extends Name> invoke() {
                b bVar = b.this;
                List list = bVar.f3493b;
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                DeserializedMemberScope deserializedMemberScope = bVar.o;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    linkedHashSet.add(NameResolverUtil.getName(deserializedMemberScope.c.getNameResolver(), ((d0.e0.p.d.m0.f.i) ((MessageLite) it.next())).getName()));
                }
                return _Sets.plus((Set) linkedHashSet, (Iterable) this.this$1.g());
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$b$g */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class g extends Lambda implements Function0<Map<Name, ? extends List<? extends SimpleFunctionDescriptor>>> {
            public g() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Map<Name, ? extends List<? extends SimpleFunctionDescriptor>> invoke() {
                List listAccess$getAllFunctions = b.access$getAllFunctions(b.this);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj : listAccess$getAllFunctions) {
                    Name name = ((SimpleFunctionDescriptor) obj).getName();
                    Intrinsics3.checkNotNullExpressionValue(name, "it.name");
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
        public static final class h extends Lambda implements Function0<Map<Name, ? extends List<? extends PropertyDescriptor>>> {
            public h() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Map<Name, ? extends List<? extends PropertyDescriptor>> invoke() {
                List listAccess$getAllProperties = b.access$getAllProperties(b.this);
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj : listAccess$getAllProperties) {
                    Name name = ((PropertyDescriptor) obj).getName();
                    Intrinsics3.checkNotNullExpressionValue(name, "it.name");
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
        public static final class i extends Lambda implements Function0<Map<Name, ? extends TypeAliasDescriptor>> {
            public i() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Map<Name, ? extends TypeAliasDescriptor> invoke() {
                List listAccess$getAllTypeAliases = b.access$getAllTypeAliases(b.this);
                LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(listAccess$getAllTypeAliases, 10)), 16));
                for (Object obj : listAccess$getAllTypeAliases) {
                    Name name = ((TypeAliasDescriptor) obj).getName();
                    Intrinsics3.checkNotNullExpressionValue(name, "it.name");
                    linkedHashMap.put(name, obj);
                }
                return linkedHashMap;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$b$j */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class j extends Lambda implements Function0<Set<? extends Name>> {
            public final /* synthetic */ DeserializedMemberScope this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public j(DeserializedMemberScope deserializedMemberScope) {
                super(0);
                this.this$1 = deserializedMemberScope;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Set<? extends Name> invoke() {
                b bVar = b.this;
                List list = bVar.c;
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                DeserializedMemberScope deserializedMemberScope = bVar.o;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    linkedHashSet.add(NameResolverUtil.getName(deserializedMemberScope.c.getNameResolver(), ((d0.e0.p.d.m0.f.n) ((MessageLite) it.next())).getName()));
                }
                return _Sets.plus((Set) linkedHashSet, (Iterable) this.this$1.h());
            }
        }

        public b(DeserializedMemberScope deserializedMemberScope, List<d0.e0.p.d.m0.f.i> list, List<d0.e0.p.d.m0.f.n> list2, List<r> list3) {
            Intrinsics3.checkNotNullParameter(deserializedMemberScope, "this$0");
            Intrinsics3.checkNotNullParameter(list, "functionList");
            Intrinsics3.checkNotNullParameter(list2, "propertyList");
            Intrinsics3.checkNotNullParameter(list3, "typeAliasList");
            this.o = deserializedMemberScope;
            this.f3493b = list;
            this.c = list2;
            this.d = deserializedMemberScope.c.getComponents().getConfiguration().getTypeAliasesAllowed() ? list3 : Collections2.emptyList();
            this.e = deserializedMemberScope.c.getStorageManager().createLazyValue(new d());
            this.f = deserializedMemberScope.c.getStorageManager().createLazyValue(new e());
            this.g = deserializedMemberScope.c.getStorageManager().createLazyValue(new c());
            this.h = deserializedMemberScope.c.getStorageManager().createLazyValue(new a());
            this.i = deserializedMemberScope.c.getStorageManager().createLazyValue(new C0408b());
            this.j = deserializedMemberScope.c.getStorageManager().createLazyValue(new i());
            this.k = deserializedMemberScope.c.getStorageManager().createLazyValue(new g());
            this.l = deserializedMemberScope.c.getStorageManager().createLazyValue(new h());
            this.m = deserializedMemberScope.c.getStorageManager().createLazyValue(new f(deserializedMemberScope));
            this.n = deserializedMemberScope.c.getStorageManager().createLazyValue(new j(deserializedMemberScope));
        }

        public static final List access$computeAllNonDeclaredFunctions(b bVar) {
            Set<Name> setG = bVar.o.g();
            ArrayList arrayList = new ArrayList();
            for (Name name : setG) {
                List list = (List) storage7.getValue(bVar.e, bVar, (KProperty<?>) a[0]);
                DeserializedMemberScope deserializedMemberScope = bVar.o;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : list) {
                    if (Intrinsics3.areEqual(((DeclarationDescriptor) obj).getName(), name)) {
                        arrayList2.add(obj);
                    }
                }
                int size = arrayList2.size();
                deserializedMemberScope.c(name, arrayList2);
                MutableCollections.addAll(arrayList, arrayList2.subList(size, arrayList2.size()));
            }
            return arrayList;
        }

        public static final List access$computeAllNonDeclaredProperties(b bVar) {
            Set<Name> setH = bVar.o.h();
            ArrayList arrayList = new ArrayList();
            for (Name name : setH) {
                List list = (List) storage7.getValue(bVar.f, bVar, (KProperty<?>) a[1]);
                DeserializedMemberScope deserializedMemberScope = bVar.o;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : list) {
                    if (Intrinsics3.areEqual(((DeclarationDescriptor) obj).getName(), name)) {
                        arrayList2.add(obj);
                    }
                }
                int size = arrayList2.size();
                deserializedMemberScope.d(name, arrayList2);
                MutableCollections.addAll(arrayList, arrayList2.subList(size, arrayList2.size()));
            }
            return arrayList;
        }

        public static final List access$computeFunctions(b bVar) {
            List<d0.e0.p.d.m0.f.i> list = bVar.f3493b;
            DeserializedMemberScope deserializedMemberScope = bVar.o;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                SimpleFunctionDescriptor simpleFunctionDescriptorLoadFunction = deserializedMemberScope.c.getMemberDeserializer().loadFunction((d0.e0.p.d.m0.f.i) ((MessageLite) it.next()));
                if (!deserializedMemberScope.j(simpleFunctionDescriptorLoadFunction)) {
                    simpleFunctionDescriptorLoadFunction = null;
                }
                if (simpleFunctionDescriptorLoadFunction != null) {
                    arrayList.add(simpleFunctionDescriptorLoadFunction);
                }
            }
            return arrayList;
        }

        public static final List access$computeProperties(b bVar) {
            List<d0.e0.p.d.m0.f.n> list = bVar.c;
            DeserializedMemberScope deserializedMemberScope = bVar.o;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                PropertyDescriptor propertyDescriptorLoadProperty = deserializedMemberScope.c.getMemberDeserializer().loadProperty((d0.e0.p.d.m0.f.n) ((MessageLite) it.next()));
                if (propertyDescriptorLoadProperty != null) {
                    arrayList.add(propertyDescriptorLoadProperty);
                }
            }
            return arrayList;
        }

        public static final List access$computeTypeAliases(b bVar) {
            List<r> list = bVar.d;
            DeserializedMemberScope deserializedMemberScope = bVar.o;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                TypeAliasDescriptor typeAliasDescriptorLoadTypeAlias = deserializedMemberScope.c.getMemberDeserializer().loadTypeAlias((r) ((MessageLite) it.next()));
                if (typeAliasDescriptorLoadTypeAlias != null) {
                    arrayList.add(typeAliasDescriptorLoadTypeAlias);
                }
            }
            return arrayList;
        }

        public static final List access$getAllFunctions(b bVar) {
            return (List) storage7.getValue(bVar.h, bVar, (KProperty<?>) a[3]);
        }

        public static final List access$getAllProperties(b bVar) {
            return (List) storage7.getValue(bVar.i, bVar, (KProperty<?>) a[4]);
        }

        public static final List access$getAllTypeAliases(b bVar) {
            return (List) storage7.getValue(bVar.g, bVar, (KProperty<?>) a[2]);
        }

        public static final List access$getDeclaredFunctions(b bVar) {
            return (List) storage7.getValue(bVar.e, bVar, (KProperty<?>) a[0]);
        }

        public static final List access$getDeclaredProperties(b bVar) {
            return (List) storage7.getValue(bVar.f, bVar, (KProperty<?>) a[1]);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberScope.a
        public void addFunctionsAndPropertiesTo(Collection<DeclarationDescriptor> collection, MemberScope2 memberScope2, Function1<? super Name, Boolean> function1, LookupLocation2 lookupLocation2) {
            Intrinsics3.checkNotNullParameter(collection, "result");
            Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
            Intrinsics3.checkNotNullParameter(function1, "nameFilter");
            Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            if (memberScope2.acceptsKinds(MemberScope2.a.getVARIABLES_MASK())) {
                for (Object obj : (List) storage7.getValue(this.i, this, (KProperty<?>) a[4])) {
                    Name name = ((PropertyDescriptor) obj).getName();
                    Intrinsics3.checkNotNullExpressionValue(name, "it.name");
                    if (function1.invoke(name).booleanValue()) {
                        collection.add(obj);
                    }
                }
            }
            if (memberScope2.acceptsKinds(MemberScope2.a.getFUNCTIONS_MASK())) {
                for (Object obj2 : (List) storage7.getValue(this.h, this, (KProperty<?>) a[3])) {
                    Name name2 = ((SimpleFunctionDescriptor) obj2).getName();
                    Intrinsics3.checkNotNullExpressionValue(name2, "it.name");
                    if (function1.invoke(name2).booleanValue()) {
                        collection.add(obj2);
                    }
                }
            }
        }

        @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberScope.a
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation2 lookupLocation2) {
            Collection<SimpleFunctionDescriptor> collection;
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            return (getFunctionNames().contains(name) && (collection = (Collection) ((Map) storage7.getValue(this.k, this, (KProperty<?>) a[6])).get(name)) != null) ? collection : Collections2.emptyList();
        }

        @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberScope.a
        public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation2 lookupLocation2) {
            Collection<PropertyDescriptor> collection;
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            return (getVariableNames().contains(name) && (collection = (Collection) ((Map) storage7.getValue(this.l, this, (KProperty<?>) a[7])).get(name)) != null) ? collection : Collections2.emptyList();
        }

        @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberScope.a
        public Set<Name> getFunctionNames() {
            return (Set) storage7.getValue(this.m, this, (KProperty<?>) a[8]);
        }

        @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberScope.a
        public TypeAliasDescriptor getTypeAliasByName(Name name) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            return (TypeAliasDescriptor) ((Map) storage7.getValue(this.j, this, (KProperty<?>) a[5])).get(name);
        }

        @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberScope.a
        public Set<Name> getTypeAliasNames() {
            List<r> list = this.d;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            DeserializedMemberScope deserializedMemberScope = this.o;
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(NameResolverUtil.getName(deserializedMemberScope.c.getNameResolver(), ((r) ((MessageLite) it.next())).getName()));
            }
            return linkedHashSet;
        }

        @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberScope.a
        public Set<Name> getVariableNames() {
            return (Set) storage7.getValue(this.n, this, (KProperty<?>) a[9]);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$c */
    /* JADX INFO: compiled from: DeserializedMemberScope.kt */
    public final class c implements a {
        public static final /* synthetic */ KProperty<Object>[] a = {Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(c.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), Reflection2.property1(new PropertyReference1Impl(Reflection2.getOrCreateKotlinClass(c.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<Name, byte[]> f3494b;
        public final Map<Name, byte[]> c;
        public final Map<Name, byte[]> d;
        public final storage3<Name, Collection<SimpleFunctionDescriptor>> e;
        public final storage3<Name, Collection<PropertyDescriptor>> f;
        public final storage4<Name, TypeAliasDescriptor> g;
        public final storage5 h;
        public final storage5 i;
        public final /* synthetic */ DeserializedMemberScope j;

        /* JADX INFO: Add missing generic type declarations: [M] */
        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$c$a */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class a<M> extends Lambda implements Function0<M> {
            public final /* synthetic */ ByteArrayInputStream $inputStream;
            public final /* synthetic */ Parser2<M> $parser;
            public final /* synthetic */ DeserializedMemberScope this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Parser2<M> parser2, ByteArrayInputStream byteArrayInputStream, DeserializedMemberScope deserializedMemberScope) {
                super(0);
                this.$parser = parser2;
                this.$inputStream = byteArrayInputStream;
                this.this$0 = deserializedMemberScope;
            }

            /* JADX WARN: Incorrect return type in method signature: ()TM; */
            @Override // kotlin.jvm.functions.Function0
            public final MessageLite invoke() {
                return (MessageLite) ((AbstractParser) this.$parser).m89parseDelimitedFrom((InputStream) this.$inputStream, this.this$0.c.getComponents().getExtensionRegistryLite());
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$c$b */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class b extends Lambda implements Function0<Set<? extends Name>> {
            public final /* synthetic */ DeserializedMemberScope this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(DeserializedMemberScope deserializedMemberScope) {
                super(0);
                this.this$1 = deserializedMemberScope;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Set<? extends Name> invoke() {
                return _Sets.plus(c.this.f3494b.keySet(), (Iterable) this.this$1.g());
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class C0409c extends Lambda implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
            public C0409c() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Collection<SimpleFunctionDescriptor> invoke(Name name) {
                Intrinsics3.checkNotNullParameter(name, "it");
                return c.access$computeFunctions(c.this, name);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$c$d */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class d extends Lambda implements Function1<Name, Collection<? extends PropertyDescriptor>> {
            public d() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Collection<PropertyDescriptor> invoke(Name name) {
                Intrinsics3.checkNotNullParameter(name, "it");
                return c.access$computeProperties(c.this, name);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$c$e */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class e extends Lambda implements Function1<Name, TypeAliasDescriptor> {
            public e() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final TypeAliasDescriptor invoke(Name name) {
                Intrinsics3.checkNotNullParameter(name, "it");
                return c.access$createTypeAlias(c.this, name);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$c$f */
        /* JADX INFO: compiled from: DeserializedMemberScope.kt */
        public static final class f extends Lambda implements Function0<Set<? extends Name>> {
            public final /* synthetic */ DeserializedMemberScope this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(DeserializedMemberScope deserializedMemberScope) {
                super(0);
                this.this$1 = deserializedMemberScope;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Set<? extends Name> invoke() {
                return _Sets.plus(c.this.c.keySet(), (Iterable) this.this$1.h());
            }
        }

        public c(DeserializedMemberScope deserializedMemberScope, List<d0.e0.p.d.m0.f.i> list, List<d0.e0.p.d.m0.f.n> list2, List<r> list3) throws IOException {
            Map<Name, byte[]> mapEmptyMap;
            Intrinsics3.checkNotNullParameter(deserializedMemberScope, "this$0");
            Intrinsics3.checkNotNullParameter(list, "functionList");
            Intrinsics3.checkNotNullParameter(list2, "propertyList");
            Intrinsics3.checkNotNullParameter(list3, "typeAliasList");
            this.j = deserializedMemberScope;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : list) {
                Name name = NameResolverUtil.getName(deserializedMemberScope.c.getNameResolver(), ((d0.e0.p.d.m0.f.i) ((MessageLite) obj)).getName());
                Object arrayList = linkedHashMap.get(name);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(name, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            this.f3494b = a(linkedHashMap);
            DeserializedMemberScope deserializedMemberScope2 = this.j;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj2 : list2) {
                Name name2 = NameResolverUtil.getName(deserializedMemberScope2.c.getNameResolver(), ((d0.e0.p.d.m0.f.n) ((MessageLite) obj2)).getName());
                Object arrayList2 = linkedHashMap2.get(name2);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    linkedHashMap2.put(name2, arrayList2);
                }
                ((List) arrayList2).add(obj2);
            }
            this.c = a(linkedHashMap2);
            if (this.j.c.getComponents().getConfiguration().getTypeAliasesAllowed()) {
                DeserializedMemberScope deserializedMemberScope3 = this.j;
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                for (Object obj3 : list3) {
                    Name name3 = NameResolverUtil.getName(deserializedMemberScope3.c.getNameResolver(), ((r) ((MessageLite) obj3)).getName());
                    Object arrayList3 = linkedHashMap3.get(name3);
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                        linkedHashMap3.put(name3, arrayList3);
                    }
                    ((List) arrayList3).add(obj3);
                }
                mapEmptyMap = a(linkedHashMap3);
            } else {
                mapEmptyMap = Maps6.emptyMap();
            }
            this.d = mapEmptyMap;
            this.e = this.j.c.getStorageManager().createMemoizedFunction(new C0409c());
            this.f = this.j.c.getStorageManager().createMemoizedFunction(new d());
            this.g = this.j.c.getStorageManager().createMemoizedFunctionWithNullableValues(new e());
            this.h = this.j.c.getStorageManager().createLazyValue(new b(this.j));
            this.i = this.j.c.getStorageManager().createLazyValue(new f(this.j));
        }

        public static final Collection access$computeFunctions(c cVar, Name name) {
            Map<Name, byte[]> map = cVar.f3494b;
            Parser2<d0.e0.p.d.m0.f.i> parser2 = d0.e0.p.d.m0.f.i.k;
            Intrinsics3.checkNotNullExpressionValue(parser2, "PARSER");
            DeserializedMemberScope deserializedMemberScope = cVar.j;
            byte[] bArr = map.get(name);
            List<d0.e0.p.d.m0.f.i> list = bArr == null ? null : _Sequences2.toList(d0.f0.n.generateSequence(new a(parser2, new ByteArrayInputStream(bArr), cVar.j)));
            if (list == null) {
                list = Collections2.emptyList();
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (d0.e0.p.d.m0.f.i iVar : list) {
                MemberDeserializer memberDeserializer = deserializedMemberScope.c.getMemberDeserializer();
                Intrinsics3.checkNotNullExpressionValue(iVar, "it");
                SimpleFunctionDescriptor simpleFunctionDescriptorLoadFunction = memberDeserializer.loadFunction(iVar);
                if (!deserializedMemberScope.j(simpleFunctionDescriptorLoadFunction)) {
                    simpleFunctionDescriptorLoadFunction = null;
                }
                if (simpleFunctionDescriptorLoadFunction != null) {
                    arrayList.add(simpleFunctionDescriptorLoadFunction);
                }
            }
            deserializedMemberScope.c(name, arrayList);
            return collections.compact(arrayList);
        }

        public static final Collection access$computeProperties(c cVar, Name name) {
            Map<Name, byte[]> map = cVar.c;
            Parser2<d0.e0.p.d.m0.f.n> parser2 = d0.e0.p.d.m0.f.n.k;
            Intrinsics3.checkNotNullExpressionValue(parser2, "PARSER");
            DeserializedMemberScope deserializedMemberScope = cVar.j;
            byte[] bArr = map.get(name);
            List<d0.e0.p.d.m0.f.n> list = bArr == null ? null : _Sequences2.toList(d0.f0.n.generateSequence(new a(parser2, new ByteArrayInputStream(bArr), cVar.j)));
            if (list == null) {
                list = Collections2.emptyList();
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (d0.e0.p.d.m0.f.n nVar : list) {
                MemberDeserializer memberDeserializer = deserializedMemberScope.c.getMemberDeserializer();
                Intrinsics3.checkNotNullExpressionValue(nVar, "it");
                PropertyDescriptor propertyDescriptorLoadProperty = memberDeserializer.loadProperty(nVar);
                if (propertyDescriptorLoadProperty != null) {
                    arrayList.add(propertyDescriptorLoadProperty);
                }
            }
            deserializedMemberScope.d(name, arrayList);
            return collections.compact(arrayList);
        }

        public static final TypeAliasDescriptor access$createTypeAlias(c cVar, Name name) {
            r delimitedFrom;
            byte[] bArr = cVar.d.get(name);
            if (bArr == null || (delimitedFrom = r.parseDelimitedFrom(new ByteArrayInputStream(bArr), cVar.j.c.getComponents().getExtensionRegistryLite())) == null) {
                return null;
            }
            return cVar.j.c.getMemberDeserializer().loadTypeAlias(delimitedFrom);
        }

        public final Map<Name, byte[]> a(Map<Name, ? extends Collection<? extends AbstractMessageLite>> map) throws IOException {
            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsJVM.mapCapacity(map.size()));
            Iterator<T> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Iterable iterable = (Iterable) entry.getValue();
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(iterable, 10));
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    ((AbstractMessageLite) it2.next()).writeDelimitedTo(byteArrayOutputStream);
                    arrayList.add(Unit.a);
                }
                linkedHashMap.put(key, byteArrayOutputStream.toByteArray());
            }
            return linkedHashMap;
        }

        @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberScope.a
        public void addFunctionsAndPropertiesTo(Collection<DeclarationDescriptor> collection, MemberScope2 memberScope2, Function1<? super Name, Boolean> function1, LookupLocation2 lookupLocation2) {
            Intrinsics3.checkNotNullParameter(collection, "result");
            Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
            Intrinsics3.checkNotNullParameter(function1, "nameFilter");
            Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            if (memberScope2.acceptsKinds(MemberScope2.a.getVARIABLES_MASK())) {
                Set<Name> variableNames = getVariableNames();
                ArrayList arrayList = new ArrayList();
                for (Name name : variableNames) {
                    if (function1.invoke(name).booleanValue()) {
                        arrayList.addAll(getContributedVariables(name, lookupLocation2));
                    }
                }
                MemberComparator memberComparator = MemberComparator.j;
                Intrinsics3.checkNotNullExpressionValue(memberComparator, "INSTANCE");
                MutableCollectionsJVM.sortWith(arrayList, memberComparator);
                collection.addAll(arrayList);
            }
            if (memberScope2.acceptsKinds(MemberScope2.a.getFUNCTIONS_MASK())) {
                Set<Name> functionNames = getFunctionNames();
                ArrayList arrayList2 = new ArrayList();
                for (Name name2 : functionNames) {
                    if (function1.invoke(name2).booleanValue()) {
                        arrayList2.addAll(getContributedFunctions(name2, lookupLocation2));
                    }
                }
                MemberComparator memberComparator2 = MemberComparator.j;
                Intrinsics3.checkNotNullExpressionValue(memberComparator2, "INSTANCE");
                MutableCollectionsJVM.sortWith(arrayList2, memberComparator2);
                collection.addAll(arrayList2);
            }
        }

        @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberScope.a
        public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation2 lookupLocation2) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            return !getFunctionNames().contains(name) ? Collections2.emptyList() : (Collection) ((LockBasedStorageManager.m) this.e).invoke(name);
        }

        @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberScope.a
        public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation2 lookupLocation2) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
            return !getVariableNames().contains(name) ? Collections2.emptyList() : (Collection) ((LockBasedStorageManager.m) this.f).invoke(name);
        }

        @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberScope.a
        public Set<Name> getFunctionNames() {
            return (Set) storage7.getValue(this.h, this, (KProperty<?>) a[0]);
        }

        @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberScope.a
        public TypeAliasDescriptor getTypeAliasByName(Name name) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            return this.g.invoke(name);
        }

        @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberScope.a
        public Set<Name> getTypeAliasNames() {
            return this.d.keySet();
        }

        @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberScope.a
        public Set<Name> getVariableNames() {
            return (Set) storage7.getValue(this.i, this, (KProperty<?>) a[1]);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$d */
    /* JADX INFO: compiled from: DeserializedMemberScope.kt */
    public static final class d extends Lambda implements Function0<Set<? extends Name>> {
        public final /* synthetic */ Function0<Collection<Name>> $classNames;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public d(Function0<? extends Collection<Name>> function0) {
            super(0);
            this.$classNames = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Set<? extends Name> invoke() {
            return _Collections.toSet(this.$classNames.invoke());
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.h$e */
    /* JADX INFO: compiled from: DeserializedMemberScope.kt */
    public static final class e extends Lambda implements Function0<Set<? extends Name>> {
        public e() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Set<? extends Name> invoke() {
            Set<Name> setF = DeserializedMemberScope.this.f();
            if (setF == null) {
                return null;
            }
            return _Sets.plus(_Sets.plus((Set) DeserializedMemberScope.this.getClassNames$deserialization(), (Iterable) DeserializedMemberScope.this.d.getTypeAliasNames()), (Iterable) setF);
        }
    }

    public DeserializedMemberScope(context6 context6Var, List<d0.e0.p.d.m0.f.i> list, List<d0.e0.p.d.m0.f.n> list2, List<r> list3, Function0<? extends Collection<Name>> function0) {
        Intrinsics3.checkNotNullParameter(context6Var, "c");
        Intrinsics3.checkNotNullParameter(list, "functionList");
        Intrinsics3.checkNotNullParameter(list2, "propertyList");
        Intrinsics3.checkNotNullParameter(list3, "typeAliasList");
        Intrinsics3.checkNotNullParameter(function0, "classNames");
        this.c = context6Var;
        this.d = context6Var.getComponents().getConfiguration().getPreserveDeclarationsOrdering() ? new b(this, list, list2, list3) : new c(this, list, list2, list3);
        this.e = context6Var.getStorageManager().createLazyValue(new d(function0));
        this.f = context6Var.getStorageManager().createNullableLazyValue(new e());
    }

    public abstract void a(Collection<DeclarationDescriptor> collection, Function1<? super Name, Boolean> function1);

    public final Collection<DeclarationDescriptor> b(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(memberScope2, "kindFilter");
        Intrinsics3.checkNotNullParameter(function1, "nameFilter");
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        ArrayList arrayList = new ArrayList(0);
        MemberScope2.a aVar = MemberScope2.a;
        if (memberScope2.acceptsKinds(aVar.getSINGLETON_CLASSIFIERS_MASK())) {
            a(arrayList, function1);
        }
        this.d.addFunctionsAndPropertiesTo(arrayList, memberScope2, function1, lookupLocation2);
        if (memberScope2.acceptsKinds(aVar.getCLASSIFIERS_MASK())) {
            for (Name name : getClassNames$deserialization()) {
                if (function1.invoke(name).booleanValue()) {
                    collections.addIfNotNull(arrayList, this.c.getComponents().deserializeClass(e(name)));
                }
            }
        }
        if (memberScope2.acceptsKinds(MemberScope2.a.getTYPE_ALIASES_MASK())) {
            for (Name name2 : this.d.getTypeAliasNames()) {
                if (function1.invoke(name2).booleanValue()) {
                    collections.addIfNotNull(arrayList, this.d.getTypeAliasByName(name2));
                }
            }
        }
        return collections.compact(arrayList);
    }

    public void c(Name name, List<SimpleFunctionDescriptor> list) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(list, "functions");
    }

    public void d(Name name, List<PropertyDescriptor> list) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(list, "descriptors");
    }

    public abstract ClassId e(Name name);

    public abstract Set<Name> f();

    public abstract Set<Name> g();

    public final Set<Name> getClassNames$deserialization() {
        return (Set) storage7.getValue(this.e, this, (KProperty<?>) f3492b[0]);
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.MemberScope3
    public Set<Name> getClassifierNames() {
        return (Set) storage7.getValue(this.f, this, (KProperty<?>) f3492b[1]);
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.ResolutionScope
    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        if (i(name)) {
            return this.c.getComponents().deserializeClass(e(name));
        }
        if (this.d.getTypeAliasNames().contains(name)) {
            return this.d.getTypeAliasByName(name);
        }
        return null;
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.MemberScope3
    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return this.d.getContributedFunctions(name, lookupLocation2);
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.MemberScope3
    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation2 lookupLocation2) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(lookupLocation2, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        return this.d.getContributedVariables(name, lookupLocation2);
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.MemberScope3
    public Set<Name> getFunctionNames() {
        return this.d.getFunctionNames();
    }

    @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.MemberScope3
    public Set<Name> getVariableNames() {
        return this.d.getVariableNames();
    }

    public abstract Set<Name> h();

    public boolean i(Name name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return getClassNames$deserialization().contains(name);
    }

    public boolean j(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        Intrinsics3.checkNotNullParameter(simpleFunctionDescriptor, "function");
        return true;
    }
}
