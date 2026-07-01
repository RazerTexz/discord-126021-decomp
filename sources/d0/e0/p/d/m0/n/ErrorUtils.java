package d0.e0.p.d.m0.n;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.b.DefaultBuiltIns;
import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.c.CallableMemberDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassKind;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptorVisitor;
import d0.e0.p.d.m0.c.DescriptorVisibilities;
import d0.e0.p.d.m0.c.Modality;
import d0.e0.p.d.m0.c.ModuleCapability;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.PackageViewDescriptor;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.e0.p.d.m0.c.ReceiverParameterDescriptor;
import d0.e0.p.d.m0.c.SimpleFunctionDescriptor;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.c.i1.ClassConstructorDescriptorImpl;
import d0.e0.p.d.m0.c.i1.ClassDescriptorImpl;
import d0.e0.p.d.m0.c.i1.PropertyDescriptorImpl;
import d0.e0.p.d.m0.d.b.LookupLocation2;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.a0.MemberScope2;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.k.x.DescriptorUtils2;
import d0.e0.p.d.m0.m.LockBasedStorageManager;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.e0.p.d.m0.n.m1.ErrorSimpleFunctionDescriptorImpl;
import d0.t.Collections2;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.t, reason: use source file name */
/* JADX INFO: compiled from: ErrorUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class ErrorUtils {
    public static final ModuleDescriptor2 a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f3538b;
    public static final KotlinType4 c;
    public static final KotlinType d;
    public static final PropertyDescriptor e;
    public static final Set<PropertyDescriptor> f;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.t$a */
    /* JADX INFO: compiled from: ErrorUtils.java */
    public static class a implements ModuleDescriptor2 {
        /* JADX WARN: Code duplicated, block: B:11:0x001a  */
        /* JADX WARN: Code duplicated, block: B:21:0x002e  */
        public static /* synthetic */ void a(int i) {
            String str;
            int i2;
            if (i != 1 && i != 4 && i != 5 && i != 6 && i != 13 && i != 14) {
                switch (i) {
                    case 8:
                    case 9:
                    case 10:
                        str = "@NotNull method %s.%s must not return null";
                        break;
                    default:
                        str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                        break;
                }
            } else {
                str = "@NotNull method %s.%s must not return null";
            }
            if (i != 1 && i != 4 && i != 5 && i != 6 && i != 13 && i != 14) {
                switch (i) {
                    case 8:
                    case 9:
                    case 10:
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
                case 6:
                case 8:
                case 9:
                case 10:
                case 13:
                case 14:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1";
                    break;
                case 2:
                case 7:
                    objArr[0] = "fqName";
                    break;
                case 3:
                    objArr[0] = "nameFilter";
                    break;
                case 11:
                    objArr[0] = "visitor";
                    break;
                case 12:
                    objArr[0] = "targetModule";
                    break;
                default:
                    objArr[0] = "capability";
                    break;
            }
            if (i == 1) {
                objArr[1] = "getAnnotations";
            } else if (i == 4) {
                objArr[1] = "getSubPackagesOf";
            } else if (i == 5) {
                objArr[1] = "getName";
            } else if (i == 6) {
                objArr[1] = "getStableName";
            } else if (i == 13) {
                objArr[1] = "getOriginal";
            } else if (i != 14) {
                switch (i) {
                    case 8:
                        objArr[1] = "getAllDependencyModules";
                        break;
                    case 9:
                        objArr[1] = "getExpectedByModules";
                        break;
                    case 10:
                        objArr[1] = "getAllExpectedByModules";
                        break;
                    default:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$1";
                        break;
                }
            } else {
                objArr[1] = "getBuiltIns";
            }
            switch (i) {
                case 1:
                case 4:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 13:
                case 14:
                    break;
                case 2:
                case 3:
                    objArr[2] = "getSubPackagesOf";
                    break;
                case 7:
                    objArr[2] = "getPackage";
                    break;
                case 11:
                    objArr[2] = "accept";
                    break;
                case 12:
                    objArr[2] = "shouldSeeInternalsOf";
                    break;
                default:
                    objArr[2] = "getCapability";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i != 1 && i != 4 && i != 5 && i != 6 && i != 13 && i != 14) {
                switch (i) {
                    case 8:
                    case 9:
                    case 10:
                        break;
                    default:
                        throw new IllegalArgumentException(str2);
                }
            }
            throw new IllegalStateException(str2);
        }

        @Override // d0.e0.p.d.m0.c.DeclarationDescriptor
        public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
            if (declarationDescriptorVisitor != null) {
                return null;
            }
            a(11);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.g1.Annotations3
        public Annotations4 getAnnotations() {
            Annotations4 empty = Annotations4.f.getEMPTY();
            if (empty != null) {
                return empty;
            }
            a(1);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.ModuleDescriptor2
        public KotlinBuiltIns getBuiltIns() {
            DefaultBuiltIns defaultBuiltIns = DefaultBuiltIns.getInstance();
            if (defaultBuiltIns != null) {
                return defaultBuiltIns;
            }
            a(14);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.ModuleDescriptor2
        public <T> T getCapability(ModuleCapability<T> moduleCapability) {
            if (moduleCapability != null) {
                return null;
            }
            a(0);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.DeclarationDescriptor
        public DeclarationDescriptor getContainingDeclaration() {
            return null;
        }

        @Override // d0.e0.p.d.m0.c.ModuleDescriptor2
        public List<ModuleDescriptor2> getExpectedByModules() {
            List<ModuleDescriptor2> listEmptyList = Collections2.emptyList();
            if (listEmptyList != null) {
                return listEmptyList;
            }
            a(9);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.DeclarationDescriptor
        public Name getName() {
            Name nameSpecial = Name.special("<ERROR MODULE>");
            if (nameSpecial != null) {
                return nameSpecial;
            }
            a(5);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.DeclarationDescriptor
        public DeclarationDescriptor getOriginal() {
            return this;
        }

        @Override // d0.e0.p.d.m0.c.ModuleDescriptor2
        public PackageViewDescriptor getPackage(FqName fqName) {
            if (fqName != null) {
                throw new IllegalStateException("Should not be called!");
            }
            a(7);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.ModuleDescriptor2
        public Collection<FqName> getSubPackagesOf(FqName fqName, Function1<? super Name, Boolean> function1) {
            if (fqName == null) {
                a(2);
                throw null;
            }
            if (function1 == null) {
                a(3);
                throw null;
            }
            List listEmptyList = Collections2.emptyList();
            if (listEmptyList != null) {
                return listEmptyList;
            }
            a(4);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.ModuleDescriptor2
        public boolean shouldSeeInternalsOf(ModuleDescriptor2 moduleDescriptor2) {
            if (moduleDescriptor2 != null) {
                return false;
            }
            a(12);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.t$b */
    /* JADX INFO: compiled from: ErrorUtils.java */
    public static class b implements TypeConstructor {
        public final /* synthetic */ c a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f3539b;

        public b(c cVar, String str) {
            this.a = cVar;
            this.f3539b = str;
        }

        public static /* synthetic */ void a(int i) {
            String str = i != 3 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[i != 3 ? 2 : 3];
            if (i != 3) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$2";
            } else {
                objArr[0] = "kotlinTypeRefiner";
            }
            if (i == 1) {
                objArr[1] = "getSupertypes";
            } else if (i == 2) {
                objArr[1] = "getBuiltIns";
            } else if (i == 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$2";
            } else if (i != 4) {
                objArr[1] = "getParameters";
            } else {
                objArr[1] = "refine";
            }
            if (i == 3) {
                objArr[2] = "refine";
            }
            String str2 = String.format(str, objArr);
            if (i == 3) {
                throw new IllegalArgumentException(str2);
            }
        }

        @Override // d0.e0.p.d.m0.n.TypeConstructor
        public KotlinBuiltIns getBuiltIns() {
            DefaultBuiltIns defaultBuiltIns = DefaultBuiltIns.getInstance();
            if (defaultBuiltIns != null) {
                return defaultBuiltIns;
            }
            a(2);
            throw null;
        }

        @Override // d0.e0.p.d.m0.n.TypeConstructor
        public ClassifierDescriptor getDeclarationDescriptor() {
            return this.a;
        }

        @Override // d0.e0.p.d.m0.n.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            List<TypeParameterDescriptor> listEmptyList = Collections2.emptyList();
            if (listEmptyList != null) {
                return listEmptyList;
            }
            a(0);
            throw null;
        }

        @Override // d0.e0.p.d.m0.n.TypeConstructor
        public Collection<KotlinType> getSupertypes() {
            List listEmptyList = Collections2.emptyList();
            if (listEmptyList != null) {
                return listEmptyList;
            }
            a(1);
            throw null;
        }

        @Override // d0.e0.p.d.m0.n.TypeConstructor
        public boolean isDenotable() {
            return false;
        }

        @Override // d0.e0.p.d.m0.n.TypeConstructor
        public TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
            if (kotlinTypeRefiner != null) {
                return this;
            }
            a(3);
            throw null;
        }

        public String toString() {
            return this.f3539b;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.t$c */
    /* JADX INFO: compiled from: ErrorUtils.java */
    public static class c extends ClassDescriptorImpl {
        /* JADX WARN: Illegal instructions before constructor call */
        public c(Name name) {
            if (name == null) {
                a(0);
                throw null;
            }
            ModuleDescriptor2 errorModule = ErrorUtils.getErrorModule();
            Modality modality = Modality.OPEN;
            ClassKind classKind = ClassKind.CLASS;
            List listEmptyList = Collections.emptyList();
            SourceElement sourceElement = SourceElement.a;
            super(errorModule, name, modality, classKind, listEmptyList, sourceElement, false, LockBasedStorageManager.f3514b);
            ClassConstructorDescriptorImpl classConstructorDescriptorImplCreate = ClassConstructorDescriptorImpl.create(this, Annotations4.f.getEMPTY(), true, sourceElement);
            classConstructorDescriptorImplCreate.initialize(Collections.emptyList(), DescriptorVisibilities.d);
            MemberScope3 memberScope3CreateErrorScope = ErrorUtils.createErrorScope(getName().asString());
            classConstructorDescriptorImplCreate.setReturnType(new ErrorType2(ErrorUtils.b("<ERROR>", this), memberScope3CreateErrorScope));
            initialize(memberScope3CreateErrorScope, Collections.singleton(classConstructorDescriptorImplCreate), classConstructorDescriptorImplCreate);
        }

        public static /* synthetic */ void a(int i) {
            String str = (i == 2 || i == 5 || i == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 2 || i == 5 || i == 8) ? 2 : 3];
            switch (i) {
                case 1:
                    objArr[0] = "substitutor";
                    break;
                case 2:
                case 5:
                case 8:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor";
                    break;
                case 3:
                    objArr[0] = "typeArguments";
                    break;
                case 4:
                case 7:
                    objArr[0] = "kotlinTypeRefiner";
                    break;
                case 6:
                    objArr[0] = "typeSubstitution";
                    break;
                default:
                    objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                    break;
            }
            if (i == 2) {
                objArr[1] = "substitute";
            } else if (i == 5 || i == 8) {
                objArr[1] = "getMemberScope";
            } else {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorClassDescriptor";
            }
            switch (i) {
                case 1:
                    objArr[2] = "substitute";
                    break;
                case 2:
                case 5:
                case 8:
                    break;
                case 3:
                case 4:
                case 6:
                case 7:
                    objArr[2] = "getMemberScope";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i != 2 && i != 5 && i != 8) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        @Override // d0.e0.p.d.m0.c.i1.AbstractClassDescriptor, d0.e0.p.d.m0.c.i1.ModuleAwareClassDescriptor
        public MemberScope3 getMemberScope(TypeSubstitution5 typeSubstitution5, KotlinTypeRefiner kotlinTypeRefiner) {
            if (typeSubstitution5 == null) {
                a(6);
                throw null;
            }
            if (kotlinTypeRefiner == null) {
                a(7);
                throw null;
            }
            StringBuilder sbU = outline.U("Error scope for class ");
            sbU.append(getName());
            sbU.append(" with arguments: ");
            sbU.append(typeSubstitution5);
            MemberScope3 memberScope3CreateErrorScope = ErrorUtils.createErrorScope(sbU.toString());
            if (memberScope3CreateErrorScope != null) {
                return memberScope3CreateErrorScope;
            }
            a(8);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.i1.AbstractClassDescriptor, d0.e0.p.d.m0.c.Substitutable
        public ClassDescriptor substitute(TypeSubstitutor2 typeSubstitutor2) {
            if (typeSubstitutor2 != null) {
                return this;
            }
            a(1);
            throw null;
        }

        @Override // d0.e0.p.d.m0.c.i1.ClassDescriptorImpl
        public String toString() {
            return getName().asString();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.t$d */
    /* JADX INFO: compiled from: ErrorUtils.java */
    public static class d implements MemberScope3 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f3540b;

        public d(String str, a aVar) {
            if (str != null) {
                this.f3540b = str;
            } else {
                a(0);
                throw null;
            }
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0019  */
        /* JADX WARN: Code duplicated, block: B:7:0x000d  */
        public static /* synthetic */ void a(int i) {
            String str;
            int i2;
            if (i != 7 && i != 18) {
                switch (i) {
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        str = "@NotNull method %s.%s must not return null";
                        break;
                    default:
                        str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                        break;
                }
            } else {
                str = "@NotNull method %s.%s must not return null";
            }
            if (i != 7 && i != 18) {
                switch (i) {
                    case 10:
                    case 11:
                    case 12:
                    case 13:
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
                case 3:
                case 5:
                case 8:
                case 14:
                case 19:
                    objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                    break;
                case 2:
                case 4:
                case 6:
                case 9:
                case 15:
                    objArr[0] = ModelAuditLogEntry.CHANGE_KEY_LOCATION;
                    break;
                case 7:
                case 10:
                case 11:
                case 12:
                case 13:
                case 18:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope";
                    break;
                case 16:
                    objArr[0] = "kindFilter";
                    break;
                case 17:
                    objArr[0] = "nameFilter";
                    break;
                case 20:
                    objArr[0] = "p";
                    break;
                default:
                    objArr[0] = "debugMessage";
                    break;
            }
            if (i == 7) {
                objArr[1] = "getContributedVariables";
            } else if (i != 18) {
                switch (i) {
                    case 10:
                        objArr[1] = "getContributedFunctions";
                        break;
                    case 11:
                        objArr[1] = "getFunctionNames";
                        break;
                    case 12:
                        objArr[1] = "getVariableNames";
                        break;
                    case 13:
                        objArr[1] = "getClassifierNames";
                        break;
                    default:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ErrorScope";
                        break;
                }
            } else {
                objArr[1] = "getContributedDescriptors";
            }
            switch (i) {
                case 1:
                case 2:
                    objArr[2] = "getContributedClassifier";
                    break;
                case 3:
                case 4:
                    objArr[2] = "getContributedClassifierIncludeDeprecated";
                    break;
                case 5:
                case 6:
                    objArr[2] = "getContributedVariables";
                    break;
                case 7:
                case 10:
                case 11:
                case 12:
                case 13:
                case 18:
                    break;
                case 8:
                case 9:
                    objArr[2] = "getContributedFunctions";
                    break;
                case 14:
                case 15:
                    objArr[2] = "recordLookup";
                    break;
                case 16:
                case 17:
                    objArr[2] = "getContributedDescriptors";
                    break;
                case 19:
                    objArr[2] = "definitelyDoesNotContainName";
                    break;
                case 20:
                    objArr[2] = "printScopeStructure";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i != 7 && i != 18) {
                switch (i) {
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        break;
                    default:
                        throw new IllegalArgumentException(str2);
                }
            }
            throw new IllegalStateException(str2);
        }

        @Override // d0.e0.p.d.m0.k.a0.MemberScope3
        public Set<Name> getClassifierNames() {
            Set<Name> setEmptySet = Collections.emptySet();
            if (setEmptySet != null) {
                return setEmptySet;
            }
            a(13);
            throw null;
        }

        @Override // d0.e0.p.d.m0.k.a0.ResolutionScope
        public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation2 lookupLocation2) {
            if (name == null) {
                a(1);
                throw null;
            }
            if (lookupLocation2 != null) {
                return ErrorUtils.createErrorClass(name.asString());
            }
            a(2);
            throw null;
        }

        @Override // d0.e0.p.d.m0.k.a0.ResolutionScope
        public Collection<DeclarationDescriptor> getContributedDescriptors(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
            if (memberScope2 == null) {
                a(16);
                throw null;
            }
            if (function1 == null) {
                a(17);
                throw null;
            }
            List listEmptyList = Collections.emptyList();
            if (listEmptyList != null) {
                return listEmptyList;
            }
            a(18);
            throw null;
        }

        @Override // d0.e0.p.d.m0.k.a0.MemberScope3
        public Set<? extends PropertyDescriptor> getContributedVariables(Name name, LookupLocation2 lookupLocation2) {
            if (name == null) {
                a(5);
                throw null;
            }
            if (lookupLocation2 == null) {
                a(6);
                throw null;
            }
            Set<PropertyDescriptor> set = ErrorUtils.f;
            if (set != null) {
                return set;
            }
            a(7);
            throw null;
        }

        @Override // d0.e0.p.d.m0.k.a0.MemberScope3
        public Set<Name> getFunctionNames() {
            Set<Name> setEmptySet = Collections.emptySet();
            if (setEmptySet != null) {
                return setEmptySet;
            }
            a(11);
            throw null;
        }

        @Override // d0.e0.p.d.m0.k.a0.MemberScope3
        public Set<Name> getVariableNames() {
            Set<Name> setEmptySet = Collections.emptySet();
            if (setEmptySet != null) {
                return setEmptySet;
            }
            a(12);
            throw null;
        }

        public String toString() {
            return outline.H(outline.U("ErrorScope{"), this.f3540b, '}');
        }

        @Override // d0.e0.p.d.m0.k.a0.MemberScope3
        public Set<? extends SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation2 lookupLocation2) {
            if (name == null) {
                a(8);
                throw null;
            }
            if (lookupLocation2 == null) {
                a(9);
                throw null;
            }
            ErrorSimpleFunctionDescriptorImpl errorSimpleFunctionDescriptorImpl = new ErrorSimpleFunctionDescriptorImpl(ErrorUtils.f3538b, this);
            errorSimpleFunctionDescriptorImpl.initialize((ReceiverParameterDescriptor) null, (ReceiverParameterDescriptor) null, Collections.emptyList(), Collections.emptyList(), (KotlinType) ErrorUtils.createErrorType("<ERROR FUNCTION RETURN TYPE>"), Modality.OPEN, DescriptorVisibilities.e);
            Set<? extends SimpleFunctionDescriptor> setSingleton = Collections.singleton(errorSimpleFunctionDescriptorImpl);
            if (setSingleton != null) {
                return setSingleton;
            }
            a(10);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.t$e */
    /* JADX INFO: compiled from: ErrorUtils.java */
    public static class e implements MemberScope3 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f3541b;

        public e(String str, a aVar) {
            if (str != null) {
                this.f3541b = str;
            } else {
                a(0);
                throw null;
            }
        }

        public static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 11:
                case 13:
                    objArr[0] = ModelAuditLogEntry.CHANGE_KEY_NAME;
                    break;
                case 2:
                case 4:
                case 6:
                case 8:
                case 12:
                    objArr[0] = ModelAuditLogEntry.CHANGE_KEY_LOCATION;
                    break;
                case 9:
                    objArr[0] = "kindFilter";
                    break;
                case 10:
                    objArr[0] = "nameFilter";
                    break;
                case 14:
                    objArr[0] = "p";
                    break;
                default:
                    objArr[0] = "message";
                    break;
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$ThrowingScope";
            switch (i) {
                case 1:
                case 2:
                    objArr[2] = "getContributedClassifier";
                    break;
                case 3:
                case 4:
                    objArr[2] = "getContributedClassifierIncludeDeprecated";
                    break;
                case 5:
                case 6:
                    objArr[2] = "getContributedVariables";
                    break;
                case 7:
                case 8:
                    objArr[2] = "getContributedFunctions";
                    break;
                case 9:
                case 10:
                    objArr[2] = "getContributedDescriptors";
                    break;
                case 11:
                case 12:
                    objArr[2] = "recordLookup";
                    break;
                case 13:
                    objArr[2] = "definitelyDoesNotContainName";
                    break;
                case 14:
                    objArr[2] = "printScopeStructure";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // d0.e0.p.d.m0.k.a0.MemberScope3
        public Set<Name> getClassifierNames() {
            throw new IllegalStateException();
        }

        @Override // d0.e0.p.d.m0.k.a0.ResolutionScope
        public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation2 lookupLocation2) {
            if (name == null) {
                a(1);
                throw null;
            }
            if (lookupLocation2 == null) {
                a(2);
                throw null;
            }
            throw new IllegalStateException(this.f3541b + ", required name: " + name);
        }

        @Override // d0.e0.p.d.m0.k.a0.ResolutionScope
        public Collection<DeclarationDescriptor> getContributedDescriptors(MemberScope2 memberScope2, Function1<? super Name, Boolean> function1) {
            if (memberScope2 == null) {
                a(9);
                throw null;
            }
            if (function1 != null) {
                throw new IllegalStateException(this.f3541b);
            }
            a(10);
            throw null;
        }

        @Override // d0.e0.p.d.m0.k.a0.MemberScope3
        public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation2 lookupLocation2) {
            if (name == null) {
                a(7);
                throw null;
            }
            if (lookupLocation2 == null) {
                a(8);
                throw null;
            }
            throw new IllegalStateException(this.f3541b + ", required name: " + name);
        }

        @Override // d0.e0.p.d.m0.k.a0.MemberScope3
        public Collection<? extends PropertyDescriptor> getContributedVariables(Name name, LookupLocation2 lookupLocation2) {
            if (name == null) {
                a(5);
                throw null;
            }
            if (lookupLocation2 == null) {
                a(6);
                throw null;
            }
            throw new IllegalStateException(this.f3541b + ", required name: " + name);
        }

        @Override // d0.e0.p.d.m0.k.a0.MemberScope3
        public Set<Name> getFunctionNames() {
            throw new IllegalStateException();
        }

        @Override // d0.e0.p.d.m0.k.a0.MemberScope3
        public Set<Name> getVariableNames() {
            throw new IllegalStateException();
        }

        public String toString() {
            return outline.H(outline.U("ThrowingScope{"), this.f3541b, '}');
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.t$f */
    /* JADX INFO: compiled from: ErrorUtils.java */
    public static class f implements TypeConstructor {
        public static /* synthetic */ void a(int i) {
            String str = (i == 1 || i == 2 || i == 3 || i == 4 || i == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 1 || i == 2 || i == 3 || i == 4 || i == 6) ? 2 : 3];
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$UninferredParameterTypeConstructor";
                    break;
                case 5:
                    objArr[0] = "kotlinTypeRefiner";
                    break;
                default:
                    objArr[0] = "descriptor";
                    break;
            }
            if (i == 1) {
                objArr[1] = "getTypeParameterDescriptor";
            } else if (i == 2) {
                objArr[1] = "getParameters";
            } else if (i == 3) {
                objArr[1] = "getSupertypes";
            } else if (i == 4) {
                objArr[1] = "getBuiltIns";
            } else if (i != 6) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils$UninferredParameterTypeConstructor";
            } else {
                objArr[1] = "refine";
            }
            switch (i) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 6:
                    break;
                case 5:
                    objArr[2] = "refine";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String str2 = String.format(str, objArr);
            if (i != 1 && i != 2 && i != 3 && i != 4 && i != 6) {
                throw new IllegalArgumentException(str2);
            }
            throw new IllegalStateException(str2);
        }

        @Override // d0.e0.p.d.m0.n.TypeConstructor
        public KotlinBuiltIns getBuiltIns() {
            KotlinBuiltIns builtIns = DescriptorUtils2.getBuiltIns(null);
            if (builtIns != null) {
                return builtIns;
            }
            a(4);
            throw null;
        }

        @Override // d0.e0.p.d.m0.n.TypeConstructor
        public ClassifierDescriptor getDeclarationDescriptor() {
            throw null;
        }

        @Override // d0.e0.p.d.m0.n.TypeConstructor
        public List<TypeParameterDescriptor> getParameters() {
            throw null;
        }

        @Override // d0.e0.p.d.m0.n.TypeConstructor
        public Collection<KotlinType> getSupertypes() {
            throw null;
        }

        public TypeParameterDescriptor getTypeParameterDescriptor() {
            a(1);
            throw null;
        }

        @Override // d0.e0.p.d.m0.n.TypeConstructor
        public boolean isDenotable() {
            throw null;
        }

        @Override // d0.e0.p.d.m0.n.TypeConstructor
        public TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
            if (kotlinTypeRefiner != null) {
                return this;
            }
            a(5);
            throw null;
        }
    }

    static {
        c cVar = new c(Name.special("<ERROR CLASS>"));
        f3538b = cVar;
        c = createErrorType("<LOOP IN SUPERTYPES>");
        KotlinType4 kotlinType4CreateErrorType = createErrorType("<ERROR PROPERTY TYPE>");
        d = kotlinType4CreateErrorType;
        PropertyDescriptorImpl propertyDescriptorImplCreate = PropertyDescriptorImpl.create(cVar, Annotations4.f.getEMPTY(), Modality.OPEN, DescriptorVisibilities.e, true, Name.special("<ERROR PROPERTY>"), CallableMemberDescriptor.a.DECLARATION, SourceElement.a, false, false, false, false, false, false);
        propertyDescriptorImplCreate.setType(kotlinType4CreateErrorType, Collections.emptyList(), null, null);
        e = propertyDescriptorImplCreate;
        f = Collections.singleton(propertyDescriptorImplCreate);
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 4 || i == 6 || i == 19) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 4 || i == 6 || i == 19) ? 2 : 3];
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 7:
            case 11:
            case 15:
                objArr[0] = "debugMessage";
                break;
            case 4:
            case 6:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils";
                break;
            case 5:
                objArr[0] = "ownerScope";
                break;
            case 8:
            case 9:
            case 16:
            case 17:
                objArr[0] = "debugName";
                break;
            case 10:
                objArr[0] = "typeConstructor";
                break;
            case 12:
            case 14:
                objArr[0] = "arguments";
                break;
            case 13:
                objArr[0] = "presentableName";
                break;
            case 18:
                objArr[0] = "errorClass";
                break;
            case 20:
                objArr[0] = "typeParameterDescriptor";
                break;
            default:
                objArr[0] = "function";
                break;
        }
        if (i == 4) {
            objArr[1] = "createErrorProperty";
        } else if (i == 6) {
            objArr[1] = "createErrorFunction";
        } else if (i != 19) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ErrorUtils";
        } else {
            objArr[1] = "getErrorModule";
        }
        switch (i) {
            case 1:
                objArr[2] = "createErrorClass";
                break;
            case 2:
            case 3:
                objArr[2] = "createErrorScope";
                break;
            case 4:
            case 6:
            case 19:
                break;
            case 5:
                objArr[2] = "createErrorFunction";
                break;
            case 7:
                objArr[2] = "createErrorType";
                break;
            case 8:
                objArr[2] = "createErrorTypeWithCustomDebugName";
                break;
            case 9:
            case 10:
                objArr[2] = "createErrorTypeWithCustomConstructor";
                break;
            case 11:
            case 12:
                objArr[2] = "createErrorTypeWithArguments";
                break;
            case 13:
            case 14:
                objArr[2] = "createUnresolvedType";
                break;
            case 15:
                objArr[2] = "createErrorTypeConstructor";
                break;
            case 16:
            case 17:
            case 18:
                objArr[2] = "createErrorTypeConstructorWithCustomDebugName";
                break;
            case 20:
                objArr[2] = "createUninferredParameterType";
                break;
            default:
                objArr[2] = "containsErrorTypeInParameters";
                break;
        }
        String str2 = String.format(str, objArr);
        if (i != 4 && i != 6 && i != 19) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static TypeConstructor b(String str, c cVar) {
        if (str == null) {
            a(17);
            throw null;
        }
        if (cVar != null) {
            return new b(cVar, str);
        }
        a(18);
        throw null;
    }

    public static ClassDescriptor createErrorClass(String str) {
        if (str == null) {
            a(1);
            throw null;
        }
        return new c(Name.special("<ERROR CLASS: " + str + ">"));
    }

    public static MemberScope3 createErrorScope(String str) {
        if (str != null) {
            return createErrorScope(str, false);
        }
        a(2);
        throw null;
    }

    public static KotlinType4 createErrorType(String str) {
        if (str != null) {
            return createErrorTypeWithArguments(str, Collections.emptyList());
        }
        a(7);
        throw null;
    }

    public static TypeConstructor createErrorTypeConstructor(String str) {
        if (str != null) {
            return b(outline.y("[ERROR : ", str, "]"), f3538b);
        }
        a(15);
        throw null;
    }

    public static TypeConstructor createErrorTypeConstructorWithCustomDebugName(String str) {
        if (str != null) {
            return b(str, f3538b);
        }
        a(16);
        throw null;
    }

    public static KotlinType4 createErrorTypeWithArguments(String str, List<TypeProjection> list) {
        if (str == null) {
            a(11);
            throw null;
        }
        if (list != null) {
            return new ErrorType2(createErrorTypeConstructor(str), createErrorScope(str), list, false);
        }
        a(12);
        throw null;
    }

    public static KotlinType4 createErrorTypeWithCustomConstructor(String str, TypeConstructor typeConstructor) {
        if (str == null) {
            a(9);
            throw null;
        }
        if (typeConstructor != null) {
            return new ErrorType2(typeConstructor, createErrorScope(str));
        }
        a(10);
        throw null;
    }

    public static KotlinType4 createErrorTypeWithCustomDebugName(String str) {
        if (str != null) {
            return createErrorTypeWithCustomConstructor(str, createErrorTypeConstructorWithCustomDebugName(str));
        }
        a(8);
        throw null;
    }

    public static ModuleDescriptor2 getErrorModule() {
        return a;
    }

    public static boolean isError(DeclarationDescriptor declarationDescriptor) {
        if (declarationDescriptor == null) {
            return false;
        }
        return (declarationDescriptor instanceof c) || (declarationDescriptor.getContainingDeclaration() instanceof c) || declarationDescriptor == a;
    }

    public static boolean isUninferredParameter(KotlinType kotlinType) {
        return kotlinType != null && (kotlinType.getConstructor() instanceof f);
    }

    public static MemberScope3 createErrorScope(String str, boolean z2) {
        if (str == null) {
            a(3);
            throw null;
        }
        if (z2) {
            return new e(str, null);
        }
        return new d(str, null);
    }
}
