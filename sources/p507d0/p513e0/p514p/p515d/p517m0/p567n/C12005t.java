package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.AbstractC11288h;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11285e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11322b0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11464t;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11333f;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11476z;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11402j0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11459q0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11465t0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11366c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11373g;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11377i;
import p507d0.p513e0.p514p.p515d.p517m0.p529d.p530b.InterfaceC11480b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.C11765d;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p559x.C11836a;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.C11896f;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p569m1.C11969a;
import p507d0.p580t.C12147n;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.t */
/* JADX INFO: compiled from: ErrorUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12005t {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC11325c0 f24877a = new a();

    /* JADX INFO: renamed from: b */
    public static final c f24878b;

    /* JADX INFO: renamed from: c */
    public static final AbstractC11934j0 f24879c;

    /* JADX INFO: renamed from: d */
    public static final AbstractC11913c0 f24880d;

    /* JADX INFO: renamed from: e */
    public static final InterfaceC11453n0 f24881e;

    /* JADX INFO: renamed from: f */
    public static final Set<InterfaceC11453n0> f24882f;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.t$a */
    /* JADX INFO: compiled from: ErrorUtils.java */
    public static class a implements InterfaceC11325c0 {
        /* JADX WARN: Code duplicated, block: B:11:0x001a  */
        /* JADX WARN: Code duplicated, block: B:21:0x002e  */
        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m10032a(int i) {
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

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
        public <R, D> R accept(InterfaceC11454o<R, D> interfaceC11454o, D d) {
            if (interfaceC11454o != null) {
                return null;
            }
            m10032a(11);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11338a
        public InterfaceC11344g getAnnotations() {
            InterfaceC11344g empty = InterfaceC11344g.f22735f.getEMPTY();
            if (empty != null) {
                return empty;
            }
            m10032a(1);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0
        public AbstractC11288h getBuiltIns() {
            C11285e c11285e = C11285e.getInstance();
            if (c11285e != null) {
                return c11285e;
            }
            m10032a(14);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0
        public <T> T getCapability(C11322b0<T> c11322b0) {
            if (c11322b0 != null) {
                return null;
            }
            m10032a(0);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
        public InterfaceC11450m getContainingDeclaration() {
            return null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0
        public List<InterfaceC11325c0> getExpectedByModules() {
            List<InterfaceC11325c0> listEmptyList = C12147n.emptyList();
            if (listEmptyList != null) {
                return listEmptyList;
            }
            m10032a(9);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
        public C11716e getName() {
            C11716e c11716eSpecial = C11716e.special("<ERROR MODULE>");
            if (c11716eSpecial != null) {
                return c11716eSpecial;
            }
            m10032a(5);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m
        public InterfaceC11450m getOriginal() {
            return this;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0
        public InterfaceC11402j0 getPackage(C11713b c11713b) {
            if (c11713b != null) {
                throw new IllegalStateException("Should not be called!");
            }
            m10032a(7);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0
        public Collection<C11713b> getSubPackagesOf(C11713b c11713b, Function1<? super C11716e, Boolean> function1) {
            if (c11713b == null) {
                m10032a(2);
                throw null;
            }
            if (function1 == null) {
                m10032a(3);
                throw null;
            }
            List listEmptyList = C12147n.emptyList();
            if (listEmptyList != null) {
                return listEmptyList;
            }
            m10032a(4);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0
        public boolean shouldSeeInternalsOf(InterfaceC11325c0 interfaceC11325c0) {
            if (interfaceC11325c0 != null) {
                return false;
            }
            m10032a(12);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.t$b */
    /* JADX INFO: compiled from: ErrorUtils.java */
    public static class b implements InterfaceC12008u0 {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ c f24883a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ String f24884b;

        public b(c cVar, String str) {
            this.f24883a = cVar;
            this.f24884b = str;
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m10033a(int i) {
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

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
        public AbstractC11288h getBuiltIns() {
            C11285e c11285e = C11285e.getInstance();
            if (c11285e != null) {
                return c11285e;
            }
            m10033a(2);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
        public InterfaceC11352h getDeclarationDescriptor() {
            return this.f24883a;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
        public List<InterfaceC11477z0> getParameters() {
            List<InterfaceC11477z0> listEmptyList = C12147n.emptyList();
            if (listEmptyList != null) {
                return listEmptyList;
            }
            m10033a(0);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
        public Collection<AbstractC11913c0> getSupertypes() {
            List listEmptyList = C12147n.emptyList();
            if (listEmptyList != null) {
                return listEmptyList;
            }
            m10033a(1);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
        public boolean isDenotable() {
            return false;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
        public InterfaceC12008u0 refine(AbstractC11947g abstractC11947g) {
            if (abstractC11947g != null) {
                return this;
            }
            m10033a(3);
            throw null;
        }

        public String toString() {
            return this.f24884b;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.t$c */
    /* JADX INFO: compiled from: ErrorUtils.java */
    public static class c extends C11377i {
        /* JADX WARN: Illegal instructions before constructor call */
        public c(C11716e c11716e) {
            if (c11716e == null) {
                m10034a(0);
                throw null;
            }
            InterfaceC11325c0 errorModule = C12005t.getErrorModule();
            EnumC11476z enumC11476z = EnumC11476z.OPEN;
            EnumC11333f enumC11333f = EnumC11333f.CLASS;
            List listEmptyList = Collections.emptyList();
            InterfaceC11467u0 interfaceC11467u0 = InterfaceC11467u0.f23099a;
            super(errorModule, c11716e, enumC11476z, enumC11333f, listEmptyList, interfaceC11467u0, false, C11896f.f24710b);
            C11373g c11373gCreate = C11373g.create(this, InterfaceC11344g.f22735f.getEMPTY(), true, interfaceC11467u0);
            c11373gCreate.initialize(Collections.emptyList(), C11464t.f23086d);
            InterfaceC11770i interfaceC11770iCreateErrorScope = C12005t.createErrorScope(getName().asString());
            c11373gCreate.setReturnType(new C12003s(C12005t.m10031b("<ERROR>", this), interfaceC11770iCreateErrorScope));
            initialize(interfaceC11770iCreateErrorScope, Collections.singleton(c11373gCreate), c11373gCreate);
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m10034a(int i) {
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

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11361a, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11395u
        public InterfaceC11770i getMemberScope(AbstractC12018z0 abstractC12018z0, AbstractC11947g abstractC11947g) {
            if (abstractC12018z0 == null) {
                m10034a(6);
                throw null;
            }
            if (abstractC11947g == null) {
                m10034a(7);
                throw null;
            }
            StringBuilder sbM833U = C1643a.m833U("Error scope for class ");
            sbM833U.append(getName());
            sbM833U.append(" with arguments: ");
            sbM833U.append(abstractC12018z0);
            InterfaceC11770i interfaceC11770iCreateErrorScope = C12005t.createErrorScope(sbM833U.toString());
            if (interfaceC11770iCreateErrorScope != null) {
                return interfaceC11770iCreateErrorScope;
            }
            m10034a(8);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11361a, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11471w0
        public InterfaceC11330e substitute(C11914c1 c11914c1) {
            if (c11914c1 != null) {
                return this;
            }
            m10034a(1);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11377i
        public String toString() {
            return getName().asString();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.t$d */
    /* JADX INFO: compiled from: ErrorUtils.java */
    public static class d implements InterfaceC11770i {

        /* JADX INFO: renamed from: b */
        public final String f24885b;

        public d(String str, a aVar) {
            if (str != null) {
                this.f24885b = str;
            } else {
                m10035a(0);
                throw null;
            }
        }

        /* JADX WARN: Code duplicated, block: B:13:0x0019  */
        /* JADX WARN: Code duplicated, block: B:7:0x000d  */
        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m10035a(int i) {
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

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
        public Set<C11716e> getClassifierNames() {
            Set<C11716e> setEmptySet = Collections.emptySet();
            if (setEmptySet != null) {
                return setEmptySet;
            }
            m10035a(13);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11773l
        public InterfaceC11352h getContributedClassifier(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
            if (c11716e == null) {
                m10035a(1);
                throw null;
            }
            if (interfaceC11480b != null) {
                return C12005t.createErrorClass(c11716e.asString());
            }
            m10035a(2);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11773l
        public Collection<InterfaceC11450m> getContributedDescriptors(C11765d c11765d, Function1<? super C11716e, Boolean> function1) {
            if (c11765d == null) {
                m10035a(16);
                throw null;
            }
            if (function1 == null) {
                m10035a(17);
                throw null;
            }
            List listEmptyList = Collections.emptyList();
            if (listEmptyList != null) {
                return listEmptyList;
            }
            m10035a(18);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
        public Set<? extends InterfaceC11453n0> getContributedVariables(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
            if (c11716e == null) {
                m10035a(5);
                throw null;
            }
            if (interfaceC11480b == null) {
                m10035a(6);
                throw null;
            }
            Set<InterfaceC11453n0> set = C12005t.f24882f;
            if (set != null) {
                return set;
            }
            m10035a(7);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
        public Set<C11716e> getFunctionNames() {
            Set<C11716e> setEmptySet = Collections.emptySet();
            if (setEmptySet != null) {
                return setEmptySet;
            }
            m10035a(11);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
        public Set<C11716e> getVariableNames() {
            Set<C11716e> setEmptySet = Collections.emptySet();
            if (setEmptySet != null) {
                return setEmptySet;
            }
            m10035a(12);
            throw null;
        }

        public String toString() {
            return C1643a.m820H(C1643a.m833U("ErrorScope{"), this.f24885b, '}');
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
        public Set<? extends InterfaceC11465t0> getContributedFunctions(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
            if (c11716e == null) {
                m10035a(8);
                throw null;
            }
            if (interfaceC11480b == null) {
                m10035a(9);
                throw null;
            }
            C11969a c11969a = new C11969a(C12005t.f24878b, this);
            c11969a.initialize((InterfaceC11459q0) null, (InterfaceC11459q0) null, Collections.emptyList(), Collections.emptyList(), (AbstractC11913c0) C12005t.createErrorType("<ERROR FUNCTION RETURN TYPE>"), EnumC11476z.OPEN, C11464t.f23087e);
            Set<? extends InterfaceC11465t0> setSingleton = Collections.singleton(c11969a);
            if (setSingleton != null) {
                return setSingleton;
            }
            m10035a(10);
            throw null;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.t$e */
    /* JADX INFO: compiled from: ErrorUtils.java */
    public static class e implements InterfaceC11770i {

        /* JADX INFO: renamed from: b */
        public final String f24886b;

        public e(String str, a aVar) {
            if (str != null) {
                this.f24886b = str;
            } else {
                m10036a(0);
                throw null;
            }
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m10036a(int i) {
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

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
        public Set<C11716e> getClassifierNames() {
            throw new IllegalStateException();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11773l
        public InterfaceC11352h getContributedClassifier(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
            if (c11716e == null) {
                m10036a(1);
                throw null;
            }
            if (interfaceC11480b == null) {
                m10036a(2);
                throw null;
            }
            throw new IllegalStateException(this.f24886b + ", required name: " + c11716e);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11773l
        public Collection<InterfaceC11450m> getContributedDescriptors(C11765d c11765d, Function1<? super C11716e, Boolean> function1) {
            if (c11765d == null) {
                m10036a(9);
                throw null;
            }
            if (function1 != null) {
                throw new IllegalStateException(this.f24886b);
            }
            m10036a(10);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
        public Collection<? extends InterfaceC11465t0> getContributedFunctions(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
            if (c11716e == null) {
                m10036a(7);
                throw null;
            }
            if (interfaceC11480b == null) {
                m10036a(8);
                throw null;
            }
            throw new IllegalStateException(this.f24886b + ", required name: " + c11716e);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
        public Collection<? extends InterfaceC11453n0> getContributedVariables(C11716e c11716e, InterfaceC11480b interfaceC11480b) {
            if (c11716e == null) {
                m10036a(5);
                throw null;
            }
            if (interfaceC11480b == null) {
                m10036a(6);
                throw null;
            }
            throw new IllegalStateException(this.f24886b + ", required name: " + c11716e);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
        public Set<C11716e> getFunctionNames() {
            throw new IllegalStateException();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i
        public Set<C11716e> getVariableNames() {
            throw new IllegalStateException();
        }

        public String toString() {
            return C1643a.m820H(C1643a.m833U("ThrowingScope{"), this.f24886b, '}');
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.t$f */
    /* JADX INFO: compiled from: ErrorUtils.java */
    public static class f implements InterfaceC12008u0 {
        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m10037a(int i) {
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

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
        public AbstractC11288h getBuiltIns() {
            AbstractC11288h builtIns = C11836a.getBuiltIns(null);
            if (builtIns != null) {
                return builtIns;
            }
            m10037a(4);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
        public InterfaceC11352h getDeclarationDescriptor() {
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
        public List<InterfaceC11477z0> getParameters() {
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
        public Collection<AbstractC11913c0> getSupertypes() {
            throw null;
        }

        public InterfaceC11477z0 getTypeParameterDescriptor() {
            m10037a(1);
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
        public boolean isDenotable() {
            throw null;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0
        public InterfaceC12008u0 refine(AbstractC11947g abstractC11947g) {
            if (abstractC11947g != null) {
                return this;
            }
            m10037a(5);
            throw null;
        }
    }

    static {
        c cVar = new c(C11716e.special("<ERROR CLASS>"));
        f24878b = cVar;
        f24879c = createErrorType("<LOOP IN SUPERTYPES>");
        AbstractC11934j0 abstractC11934j0CreateErrorType = createErrorType("<ERROR PROPERTY TYPE>");
        f24880d = abstractC11934j0CreateErrorType;
        C11366c0 c11366c0Create = C11366c0.create(cVar, InterfaceC11344g.f22735f.getEMPTY(), EnumC11476z.OPEN, C11464t.f23087e, true, C11716e.special("<ERROR PROPERTY>"), InterfaceC11321b.a.DECLARATION, InterfaceC11467u0.f23099a, false, false, false, false, false, false);
        c11366c0Create.setType(abstractC11934j0CreateErrorType, Collections.emptyList(), null, null);
        f24881e = c11366c0Create;
        f24882f = Collections.singleton(c11366c0Create);
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m10030a(int i) {
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

    /* JADX INFO: renamed from: b */
    public static InterfaceC12008u0 m10031b(String str, c cVar) {
        if (str == null) {
            m10030a(17);
            throw null;
        }
        if (cVar != null) {
            return new b(cVar, str);
        }
        m10030a(18);
        throw null;
    }

    public static InterfaceC11330e createErrorClass(String str) {
        if (str == null) {
            m10030a(1);
            throw null;
        }
        return new c(C11716e.special("<ERROR CLASS: " + str + ">"));
    }

    public static InterfaceC11770i createErrorScope(String str) {
        if (str != null) {
            return createErrorScope(str, false);
        }
        m10030a(2);
        throw null;
    }

    public static AbstractC11934j0 createErrorType(String str) {
        if (str != null) {
            return createErrorTypeWithArguments(str, Collections.emptyList());
        }
        m10030a(7);
        throw null;
    }

    public static InterfaceC12008u0 createErrorTypeConstructor(String str) {
        if (str != null) {
            return m10031b(C1643a.m886y("[ERROR : ", str, "]"), f24878b);
        }
        m10030a(15);
        throw null;
    }

    public static InterfaceC12008u0 createErrorTypeConstructorWithCustomDebugName(String str) {
        if (str != null) {
            return m10031b(str, f24878b);
        }
        m10030a(16);
        throw null;
    }

    public static AbstractC11934j0 createErrorTypeWithArguments(String str, List<InterfaceC12012w0> list) {
        if (str == null) {
            m10030a(11);
            throw null;
        }
        if (list != null) {
            return new C12003s(createErrorTypeConstructor(str), createErrorScope(str), list, false);
        }
        m10030a(12);
        throw null;
    }

    public static AbstractC11934j0 createErrorTypeWithCustomConstructor(String str, InterfaceC12008u0 interfaceC12008u0) {
        if (str == null) {
            m10030a(9);
            throw null;
        }
        if (interfaceC12008u0 != null) {
            return new C12003s(interfaceC12008u0, createErrorScope(str));
        }
        m10030a(10);
        throw null;
    }

    public static AbstractC11934j0 createErrorTypeWithCustomDebugName(String str) {
        if (str != null) {
            return createErrorTypeWithCustomConstructor(str, createErrorTypeConstructorWithCustomDebugName(str));
        }
        m10030a(8);
        throw null;
    }

    public static InterfaceC11325c0 getErrorModule() {
        return f24877a;
    }

    public static boolean isError(InterfaceC11450m interfaceC11450m) {
        if (interfaceC11450m == null) {
            return false;
        }
        return (interfaceC11450m instanceof c) || (interfaceC11450m.getContainingDeclaration() instanceof c) || interfaceC11450m == f24877a;
    }

    public static boolean isUninferredParameter(AbstractC11913c0 abstractC11913c0) {
        return abstractC11913c0 != null && (abstractC11913c0.getConstructor() instanceof f);
    }

    public static InterfaceC11770i createErrorScope(String str, boolean z2) {
        if (str == null) {
            m10030a(3);
            throw null;
        }
        if (z2) {
            return new e(str, null);
        }
        return new d(str, null);
    }
}
