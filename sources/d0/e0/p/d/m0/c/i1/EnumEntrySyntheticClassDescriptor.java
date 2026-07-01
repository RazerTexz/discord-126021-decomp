package d0.e0.p.d.m0.c.i1;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ClassConstructorDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassKind;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.DescriptorVisibilities;
import d0.e0.p.d.m0.c.DescriptorVisibility2;
import d0.e0.p.d.m0.c.Modality;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.SimpleFunctionDescriptor;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.d.b.LookupLocation2;
import d0.e0.p.d.m0.d.b.LookupLocation3;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.OverridingStrategy;
import d0.e0.p.d.m0.k.OverridingUtil;
import d0.e0.p.d.m0.k.a0.MemberScope2;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.k.a0.MemberScopeImpl;
import d0.e0.p.d.m0.m.LockBasedStorageManager;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.m.storage3;
import d0.e0.p.d.m0.m.storage5;
import d0.e0.p.d.m0.n.ClassTypeConstructorImpl;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.TypeConstructor;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.o, reason: use source file name */
/* JADX INFO: compiled from: EnumEntrySyntheticClassDescriptor.java */
/* JADX INFO: loaded from: classes3.dex */
public class EnumEntrySyntheticClassDescriptor extends ClassDescriptorBase {
    public final TypeConstructor r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final MemberScope3 f3269s;
    public final storage5<Set<Name>> t;
    public final Annotations4 u;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.o$a */
    /* JADX INFO: compiled from: EnumEntrySyntheticClassDescriptor.java */
    public class a extends MemberScopeImpl {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final storage3<Name, Collection<? extends SimpleFunctionDescriptor>> f3270b;
        public final storage3<Name, Collection<? extends PropertyDescriptor>> c;
        public final storage5<Collection<DeclarationDescriptor>> d;
        public final /* synthetic */ EnumEntrySyntheticClassDescriptor e;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.o$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: EnumEntrySyntheticClassDescriptor.java */
        public class C0381a implements Function1<Name, Collection<? extends SimpleFunctionDescriptor>> {
            public C0381a(EnumEntrySyntheticClassDescriptor enumEntrySyntheticClassDescriptor) {
            }

            @Override // kotlin.jvm.functions.Function1
            public Collection<? extends SimpleFunctionDescriptor> invoke(Name name) {
                a aVar = a.this;
                Objects.requireNonNull(aVar);
                if (name != null) {
                    return aVar.c(name, aVar.b().getContributedFunctions(name, LookupLocation3.FOR_NON_TRACKED_SCOPE));
                }
                a.a(8);
                throw null;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.o$a$b */
        /* JADX INFO: compiled from: EnumEntrySyntheticClassDescriptor.java */
        public class b implements Function1<Name, Collection<? extends PropertyDescriptor>> {
            public b(EnumEntrySyntheticClassDescriptor enumEntrySyntheticClassDescriptor) {
            }

            @Override // kotlin.jvm.functions.Function1
            public Collection<? extends PropertyDescriptor> invoke(Name name) {
                a aVar = a.this;
                Objects.requireNonNull(aVar);
                if (name != null) {
                    return aVar.c(name, aVar.b().getContributedVariables(name, LookupLocation3.FOR_NON_TRACKED_SCOPE));
                }
                a.a(4);
                throw null;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.o$a$c */
        /* JADX INFO: compiled from: EnumEntrySyntheticClassDescriptor.java */
        public class c implements Function0<Collection<DeclarationDescriptor>> {
            public c(EnumEntrySyntheticClassDescriptor enumEntrySyntheticClassDescriptor) {
            }

            @Override // kotlin.jvm.functions.Function0
            public Collection<DeclarationDescriptor> invoke() {
                a aVar = a.this;
                Objects.requireNonNull(aVar);
                HashSet hashSet = new HashSet();
                for (Name name : aVar.e.t.invoke()) {
                    LookupLocation3 lookupLocation3 = LookupLocation3.FOR_NON_TRACKED_SCOPE;
                    hashSet.addAll(aVar.getContributedFunctions(name, lookupLocation3));
                    hashSet.addAll(aVar.getContributedVariables(name, lookupLocation3));
                }
                return hashSet;
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.c.i1.o$a$d */
        /* JADX INFO: compiled from: EnumEntrySyntheticClassDescriptor.java */
        public class d extends OverridingStrategy {
            public final /* synthetic */ Set a;

            public d(a aVar, Set set) {
                this.a = set;
            }

            public static /* synthetic */ void a(int i) {
                Object[] objArr = new Object[3];
                if (i == 1) {
                    objArr[0] = "fromSuper";
                } else if (i != 2) {
                    objArr[0] = "fakeOverride";
                } else {
                    objArr[0] = "fromCurrent";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope$4";
                if (i == 1 || i == 2) {
                    objArr[2] = "conflict";
                } else {
                    objArr[2] = "addFakeOverride";
                }
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            @Override // d0.e0.p.d.m0.k.OverridingStrategy2
            public void addFakeOverride(CallableMemberDescriptor callableMemberDescriptor) {
                if (callableMemberDescriptor == null) {
                    a(0);
                    throw null;
                }
                OverridingUtil.resolveUnknownVisibilityForMember(callableMemberDescriptor, null);
                this.a.add(callableMemberDescriptor);
            }

            @Override // d0.e0.p.d.m0.k.OverridingStrategy
            public void conflict(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
                if (callableMemberDescriptor == null) {
                    a(1);
                    throw null;
                }
                if (callableMemberDescriptor2 != null) {
                    return;
                }
                a(2);
                throw null;
            }
        }

        public a(EnumEntrySyntheticClassDescriptor enumEntrySyntheticClassDescriptor, StorageManager storageManager) {
            if (storageManager == null) {
                a(0);
                throw null;
            }
            this.e = enumEntrySyntheticClassDescriptor;
            this.f3270b = storageManager.createMemoizedFunction(new C0381a(enumEntrySyntheticClassDescriptor));
            this.c = storageManager.createMemoizedFunction(new b(enumEntrySyntheticClassDescriptor));
            this.d = storageManager.createLazyValue(new c(enumEntrySyntheticClassDescriptor));
        }

        /* JADX WARN: Code duplicated, block: B:17:0x0024  */
        /* JADX WARN: Code duplicated, block: B:9:0x0014  */
        public static /* synthetic */ void a(int i) {
            String str;
            int i2;
            if (i != 3 && i != 7 && i != 9 && i != 12) {
                switch (i) {
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                        str = "@NotNull method %s.%s must not return null";
                        break;
                    default:
                        str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                        break;
                }
            } else {
                str = "@NotNull method %s.%s must not return null";
            }
            if (i != 3 && i != 7 && i != 9 && i != 12) {
                switch (i) {
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                        i2 = 2;
                        break;
                    default:
                        i2 = 3;
                        break;
                }
            } else {
                i2 = 2;
            }
            Object[] objArr = new Object[i2];
            switch (i) {
                case 1:
                case 4:
                case 5:
                case 8:
                case 10:
                    objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                    break;
                case 2:
                case 6:
                    objArr[0] = ModelAuditLogEntry.CHANGE_KEY_LOCATION;
                    break;
                case 3:
                case 7:
                case 9:
                case 12:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope";
                    break;
                case 11:
                    objArr[0] = "fromSupertypes";
                    break;
                case 13:
                    objArr[0] = "kindFilter";
                    break;
                case 14:
                    objArr[0] = "nameFilter";
                    break;
                case 20:
                    objArr[0] = "p";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            if (i == 3) {
                objArr[1] = "getContributedVariables";
            } else if (i == 7) {
                objArr[1] = "getContributedFunctions";
            } else if (i == 9) {
                objArr[1] = "getSupertypeScope";
            } else if (i != 12) {
                switch (i) {
                    case 15:
                        objArr[1] = "getContributedDescriptors";
                        break;
                    case 16:
                        objArr[1] = "computeAllDeclarations";
                        break;
                    case 17:
                        objArr[1] = "getFunctionNames";
                        break;
                    case 18:
                        objArr[1] = "getClassifierNames";
                        break;
                    case 19:
                        objArr[1] = "getVariableNames";
                        break;
                    default:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope";
                        break;
                }
            } else {
                objArr[1] = "resolveFakeOverrides";
            }
            switch (i) {
                case 1:
                case 2:
                    objArr[2] = "getContributedVariables";
                    break;
                case 3:
                case 7:
                case 9:
                case 12:
                case 15:
                case 16:
                case 17:
                case 18:
                case 19:
                    break;
                case 4:
                    objArr[2] = "computeProperties";
                    break;
                case 5:
                case 6:
                    objArr[2] = "getContributedFunctions";
                    break;
                case 8:
                    objArr[2] = "computeFunctions";
                    break;
                case 10:
                case 11:
                    objArr[2] = "resolveFakeOverrides";
                    break;
                case 13:
                case 14:
                    objArr[2] = "getContributedDescriptors";
                    break;
                case 20:
                    objArr[2] = "printScopeStructure";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i != 3 && i != 7 && i != 9 && i != 12) {
                switch (i) {
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                        break;
                    default:
                        throw new IllegalArgumentException(str2);
                }
            }
            throw new IllegalStateException(str2);
        }

        public final MemberScope3 b() {
            MemberScope3 memberScope = this.e.getTypeConstructor().getSupertypes().iterator().next().getMemberScope();
            if (memberScope != null) {
                return memberScope;
            }
            a(9);
            throw null;
        }

        public final <D extends CallableMemberDescriptor> Collection<? extends D> c(Name name, Collection<? extends D> collection) {
            if (name == null) {
                a(10);
                throw null;
            }
            if (collection == null) {
                a(11);
                throw null;
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            OverridingUtil.f3468b.generateOverridesInFunctionGroup(name, collection, Collections.emptySet(), this.e, new d(this, linkedHashSet));
            return linkedHashSet;
        }

        @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.MemberScope3
        public Set<Name> getClassifierNames() {
            Set<Name> setEmptySet = Collections.emptySet();
            if (setEmptySet != null) {
                return setEmptySet;
            }
            a(18);
            throw null;
        }

        @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.ResolutionScope
        public Collection<DeclarationDescriptor> getContributedDescriptors(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
            if (memberScope2 == null) {
                a(13);
                throw null;
            }
            if (function1 == null) {
                a(14);
                throw null;
            }
            Collection<DeclarationDescriptor> collectionInvoke = this.d.invoke();
            if (collectionInvoke != null) {
                return collectionInvoke;
            }
            a(15);
            throw null;
        }

        @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.MemberScope3
        public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation2 lookupLocation2) {
            if (name == null) {
                a(5);
                throw null;
            }
            if (lookupLocation2 == null) {
                a(6);
                throw null;
            }
            Collection<? extends SimpleFunctionDescriptor> collection = (Collection) ((LockBasedStorageManager.m) this.f3270b).invoke(name);
            if (collection != null) {
                return collection;
            }
            a(7);
            throw null;
        }

        @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.MemberScope3
        public Collection<? extends PropertyDescriptor> getContributedVariables(Name name, LookupLocation2 lookupLocation2) {
            if (name == null) {
                a(1);
                throw null;
            }
            if (lookupLocation2 == null) {
                a(2);
                throw null;
            }
            Collection<? extends PropertyDescriptor> collection = (Collection) ((LockBasedStorageManager.m) this.c).invoke(name);
            if (collection != null) {
                return collection;
            }
            a(3);
            throw null;
        }

        @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.MemberScope3
        public Set<Name> getFunctionNames() {
            Set<Name> setInvoke = this.e.t.invoke();
            if (setInvoke != null) {
                return setInvoke;
            }
            a(17);
            throw null;
        }

        @Override // d0.e0.p.d.m0.k.a0.MemberScopeImpl, d0.e0.p.d.m0.k.a0.MemberScope3
        public Set<Name> getVariableNames() {
            Set<Name> setInvoke = this.e.t.invoke();
            if (setInvoke != null) {
                return setInvoke;
            }
            a(19);
            throw null;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnumEntrySyntheticClassDescriptor(StorageManager storageManager, ClassDescriptor classDescriptor, KotlinType kotlinType, Name name, storage5<Set<Name>> storage5Var, Annotations4 annotations4, SourceElement sourceElement) {
        super(storageManager, classDescriptor, name, sourceElement, false);
        if (storageManager == null) {
            a(6);
            throw null;
        }
        if (kotlinType == null) {
            a(8);
            throw null;
        }
        if (name == null) {
            a(9);
            throw null;
        }
        if (storage5Var == null) {
            a(10);
            throw null;
        }
        if (annotations4 == null) {
            a(11);
            throw null;
        }
        if (sourceElement == null) {
            a(12);
            throw null;
        }
        this.u = annotations4;
        this.r = new ClassTypeConstructorImpl(this, Collections.emptyList(), Collections.singleton(kotlinType), storageManager);
        this.f3269s = new a(this, storageManager);
        this.t = storage5Var;
    }

    public static /* synthetic */ void a(int i) {
        String str;
        int i2;
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
                objArr[0] = "enumClass";
                break;
            case 2:
            case 9:
                objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                break;
            case 3:
            case 10:
                objArr[0] = "enumMemberNames";
                break;
            case 4:
            case 11:
                objArr[0] = "annotations";
                break;
            case 5:
            case 12:
                objArr[0] = "source";
                break;
            case 6:
            default:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "containingClass";
                break;
            case 8:
                objArr[0] = "supertype";
                break;
            case 13:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i) {
            case 14:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 15:
                objArr[1] = "getStaticScope";
                break;
            case 16:
                objArr[1] = "getConstructors";
                break;
            case 17:
                objArr[1] = "getTypeConstructor";
                break;
            case 18:
                objArr[1] = "getKind";
                break;
            case 19:
                objArr[1] = "getModality";
                break;
            case 20:
                objArr[1] = "getVisibility";
                break;
            case 21:
                objArr[1] = "getAnnotations";
                break;
            case 22:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 23:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "<init>";
                break;
            case 13:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                break;
            default:
                objArr[2] = "create";
                break;
        }
        String str2 = String.format(str, objArr);
        switch (i) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                throw new IllegalStateException(str2);
            default:
                throw new IllegalArgumentException(str2);
        }
    }

    public static EnumEntrySyntheticClassDescriptor create(StorageManager storageManager, ClassDescriptor classDescriptor, Name name, storage5<Set<Name>> storage5Var, Annotations4 annotations4, SourceElement sourceElement) {
        if (storageManager == null) {
            a(0);
            throw null;
        }
        if (classDescriptor == null) {
            a(1);
            throw null;
        }
        if (name == null) {
            a(2);
            throw null;
        }
        if (storage5Var == null) {
            a(3);
            throw null;
        }
        if (annotations4 == null) {
            a(4);
            throw null;
        }
        if (sourceElement != null) {
            return new EnumEntrySyntheticClassDescriptor(storageManager, classDescriptor, classDescriptor.getDefaultType(), name, storage5Var, annotations4, sourceElement);
        }
        a(5);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.g1.Annotations3
    public Annotations4 getAnnotations() {
        Annotations4 annotations4 = this.u;
        if (annotations4 != null) {
            return annotations4;
        }
        a(21);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public ClassDescriptor getCompanionObjectDescriptor() {
        return null;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public Collection<ClassConstructorDescriptor> getConstructors() {
        List listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        a(16);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor, d0.e0.p.d.m0.c.ClassifierDescriptorWithTypeParameters
    public List<TypeParameterDescriptor> getDeclaredTypeParameters() {
        List<TypeParameterDescriptor> listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        a(22);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public ClassKind getKind() {
        return ClassKind.ENUM_ENTRY;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor, d0.e0.p.d.m0.c.MemberDescriptor
    public Modality getModality() {
        return Modality.FINAL;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public Collection<ClassDescriptor> getSealedSubclasses() {
        List listEmptyList = Collections.emptyList();
        if (listEmptyList != null) {
            return listEmptyList;
        }
        a(23);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public MemberScope3 getStaticScope() {
        MemberScope3.b bVar = MemberScope3.b.f3461b;
        if (bVar != null) {
            return bVar;
        }
        a(15);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.ClassifierDescriptor
    public TypeConstructor getTypeConstructor() {
        TypeConstructor typeConstructor = this.r;
        if (typeConstructor != null) {
            return typeConstructor;
        }
        a(17);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.i1.ModuleAwareClassDescriptor
    public MemberScope3 getUnsubstitutedMemberScope(KotlinTypeRefiner kotlinTypeRefiner) {
        if (kotlinTypeRefiner == null) {
            a(13);
            throw null;
        }
        MemberScope3 memberScope3 = this.f3269s;
        if (memberScope3 != null) {
            return memberScope3;
        }
        a(14);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor() {
        return null;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor, d0.e0.p.d.m0.c.DeclarationDescriptorWithVisibility, d0.e0.p.d.m0.c.MemberDescriptor
    public DescriptorVisibility2 getVisibility() {
        DescriptorVisibility2 descriptorVisibility2 = DescriptorVisibilities.e;
        if (descriptorVisibility2 != null) {
            return descriptorVisibility2;
        }
        a(20);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.MemberDescriptor
    public boolean isActual() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public boolean isCompanionObject() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public boolean isData() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.MemberDescriptor
    public boolean isExpect() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public boolean isFun() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public boolean isInline() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.ClassifierDescriptorWithTypeParameters
    public boolean isInner() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.ClassDescriptor
    public boolean isValue() {
        return false;
    }

    public String toString() {
        StringBuilder sbU = outline.U("enum entry ");
        sbU.append(getName());
        return sbU.toString();
    }
}
