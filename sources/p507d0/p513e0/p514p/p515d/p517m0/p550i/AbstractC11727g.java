package p507d0.p513e0.p514p.p515d.p517m0.p550i;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11721a;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11726f;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11728h;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11743w;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n;

/* JADX INFO: renamed from: d0.e0.p.d.m0.i.g */
/* JADX INFO: compiled from: GeneratedMessageLite.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11727g extends AbstractC11721a implements Serializable {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.g$b */
    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    public static abstract class b<MessageType extends AbstractC11727g, BuilderType extends b> extends AbstractC11721a.a<BuilderType> {

        /* JADX INFO: renamed from: j */
        public AbstractC11723c f24125j = AbstractC11723c.f24100j;

        public final AbstractC11723c getUnknownFields() {
            return this.f24125j;
        }

        public abstract BuilderType mergeFrom(MessageType messagetype);

        public final BuilderType setUnknownFields(AbstractC11723c abstractC11723c) {
            this.f24125j = abstractC11723c;
            return this;
        }

        @Override // 
        /* JADX INFO: renamed from: clone */
        public BuilderType mo11465clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.g$c */
    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    public static abstract class c<MessageType extends d<MessageType>, BuilderType extends c<MessageType, BuilderType>> extends b<MessageType, BuilderType> implements InterfaceC11735o {

        /* JADX INFO: renamed from: k */
        public C11726f<e> f24126k = C11726f.emptySet();

        /* JADX INFO: renamed from: l */
        public boolean f24127l;

        /* JADX INFO: renamed from: b */
        public final void m9846b(MessageType messagetype) {
            if (!this.f24127l) {
                this.f24126k = this.f24126k.m11468clone();
                this.f24127l = true;
            }
            this.f24126k.mergeFrom(((d) messagetype).extensions);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.g$e */
    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    public static final class e implements C11726f.a<e> {

        /* JADX INFO: renamed from: j */
        public final C11728h.b<?> f24132j;

        /* JADX INFO: renamed from: k */
        public final int f24133k;

        /* JADX INFO: renamed from: l */
        public final C11743w.b f24134l;

        /* JADX INFO: renamed from: m */
        public final boolean f24135m;

        /* JADX INFO: renamed from: n */
        public final boolean f24136n;

        public e(C11728h.b<?> bVar, int i, C11743w.b bVar2, boolean z2, boolean z3) {
            this.f24132j = bVar;
            this.f24133k = i;
            this.f24134l = bVar2;
            this.f24135m = z2;
            this.f24136n = z3;
        }

        public C11728h.b<?> getEnumType() {
            return this.f24132j;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.C11726f.a
        public C11743w.c getLiteJavaType() {
            return this.f24134l.getJavaType();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.C11726f.a
        public C11743w.b getLiteType() {
            return this.f24134l;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.C11726f.a
        public int getNumber() {
            return this.f24133k;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.C11726f.a
        public InterfaceC11734n.a internalMergeFrom(InterfaceC11734n.a aVar, InterfaceC11734n interfaceC11734n) {
            return ((b) aVar).mergeFrom((AbstractC11727g) interfaceC11734n);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.C11726f.a
        public boolean isPacked() {
            return this.f24136n;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.C11726f.a
        public boolean isRepeated() {
            return this.f24135m;
        }

        @Override // java.lang.Comparable
        public int compareTo(e eVar) {
            return this.f24133k - eVar.f24133k;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.g$f */
    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    public static class f<ContainingType extends InterfaceC11734n, Type> {

        /* JADX INFO: renamed from: a */
        public final ContainingType f24137a;

        /* JADX INFO: renamed from: b */
        public final Type f24138b;

        /* JADX INFO: renamed from: c */
        public final InterfaceC11734n f24139c;

        /* JADX INFO: renamed from: d */
        public final e f24140d;

        /* JADX INFO: renamed from: e */
        public final Method f24141e;

        public f(ContainingType containingtype, Type type, InterfaceC11734n interfaceC11734n, e eVar, Class cls) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            }
            if (eVar.getLiteType() == C11743w.b.f24201t && interfaceC11734n == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            }
            this.f24137a = containingtype;
            this.f24138b = type;
            this.f24139c = interfaceC11734n;
            this.f24140d = eVar;
            if (!C11728h.a.class.isAssignableFrom(cls)) {
                this.f24141e = null;
                return;
            }
            try {
                this.f24141e = cls.getMethod("valueOf", Integer.TYPE);
            } catch (NoSuchMethodException e) {
                String name = cls.getName();
                StringBuilder sb = new StringBuilder(name.length() + 45 + 7);
                C1643a.m876s0(sb, "Generated message class \"", name, "\" missing method \"", "valueOf");
                sb.append("\".");
                throw new RuntimeException(sb.toString(), e);
            }
        }

        /* JADX INFO: renamed from: a */
        public Object m9854a(Object obj) {
            if (this.f24140d.getLiteJavaType() != C11743w.c.ENUM) {
                return obj;
            }
            try {
                return this.f24141e.invoke(null, (Integer) obj);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
            } catch (InvocationTargetException e2) {
                Throwable cause = e2.getCause();
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }

        /* JADX INFO: renamed from: b */
        public Object m9855b(Object obj) {
            return this.f24140d.getLiteJavaType() == C11743w.c.ENUM ? Integer.valueOf(((C11728h.a) obj).getNumber()) : obj;
        }

        public ContainingType getContainingTypeDefaultInstance() {
            return this.f24137a;
        }

        public InterfaceC11734n getMessageDefaultInstance() {
            return this.f24139c;
        }

        public int getNumber() {
            return this.f24140d.getNumber();
        }
    }

    public AbstractC11727g() {
    }

    public static <ContainingType extends InterfaceC11734n, Type> f<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, InterfaceC11734n interfaceC11734n, C11728h.b<?> bVar, int i, C11743w.b bVar2, boolean z2, Class cls) {
        return new f<>(containingtype, Collections.emptyList(), interfaceC11734n, new e(bVar, i, bVar2, true, z2), cls);
    }

    public static <ContainingType extends InterfaceC11734n, Type> f<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, InterfaceC11734n interfaceC11734n, C11728h.b<?> bVar, int i, C11743w.b bVar2, Class cls) {
        return new f<>(containingtype, type, interfaceC11734n, new e(bVar, i, bVar2, false, false), cls);
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.g$d */
    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    public static abstract class d<MessageType extends d<MessageType>> extends AbstractC11727g implements InterfaceC11735o {
        private final C11726f<e> extensions;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.i.g$d$a */
        /* JADX INFO: compiled from: GeneratedMessageLite.java */
        public class a {

            /* JADX INFO: renamed from: a */
            public final Iterator<Map.Entry<e, Object>> f24128a;

            /* JADX INFO: renamed from: b */
            public Map.Entry<e, Object> f24129b;

            /* JADX INFO: renamed from: c */
            public final boolean f24130c;

            public a(boolean z2, a aVar) {
                Iterator<Map.Entry<e, Object>> it = d.this.extensions.iterator();
                this.f24128a = it;
                if (it.hasNext()) {
                    this.f24129b = it.next();
                }
                this.f24130c = z2;
            }

            public void writeUntil(int i, CodedOutputStream codedOutputStream) throws IOException {
                while (true) {
                    Map.Entry<e, Object> entry = this.f24129b;
                    if (entry == null || entry.getKey().getNumber() >= i) {
                        return;
                    }
                    e key = this.f24129b.getKey();
                    if (this.f24130c && key.getLiteJavaType() == C11743w.c.MESSAGE && !key.isRepeated()) {
                        codedOutputStream.writeMessageSetExtension(key.getNumber(), (InterfaceC11734n) this.f24129b.getValue());
                    } else {
                        C11726f.writeField(key, this.f24129b.getValue(), codedOutputStream);
                    }
                    if (this.f24128a.hasNext()) {
                        this.f24129b = this.f24128a.next();
                    } else {
                        this.f24129b = null;
                    }
                }
            }
        }

        public d() {
            this.extensions = C11726f.newFieldSet();
        }

        /* JADX INFO: renamed from: b */
        public boolean m9848b() {
            return this.extensions.isInitialized();
        }

        /* JADX INFO: renamed from: c */
        public int m9849c() {
            return this.extensions.getSerializedSize();
        }

        /* JADX INFO: renamed from: d */
        public void m9850d() {
            this.extensions.makeImmutable();
        }

        /* JADX INFO: renamed from: e */
        public d<MessageType>.a m9851e() {
            return new a(false, null);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0040  */
        /* JADX INFO: renamed from: f */
        public boolean m9852f(C11724d c11724d, CodedOutputStream codedOutputStream, C11725e c11725e, int i) throws IOException {
            boolean z2;
            boolean z3;
            Object objBuild;
            InterfaceC11734n interfaceC11734n;
            C11726f<e> c11726f = this.extensions;
            int i2 = i & 7;
            f fVarFindLiteExtensionByNumber = c11725e.findLiteExtensionByNumber(getDefaultInstanceForType(), C11743w.getTagFieldNumber(i));
            if (fVarFindLiteExtensionByNumber == null) {
                z2 = true;
                z3 = false;
            } else if (i2 == C11726f.m9839c(fVarFindLiteExtensionByNumber.f24140d.getLiteType(), false)) {
                z2 = false;
                z3 = false;
            } else {
                e eVar = fVarFindLiteExtensionByNumber.f24140d;
                if (eVar.f24135m && eVar.f24134l.isPackable() && i2 == C11726f.m9839c(fVarFindLiteExtensionByNumber.f24140d.getLiteType(), true)) {
                    z2 = false;
                    z3 = true;
                } else {
                    z2 = true;
                    z3 = false;
                }
            }
            if (z2) {
                return c11724d.skipField(i, codedOutputStream);
            }
            if (z3) {
                int iPushLimit = c11724d.pushLimit(c11724d.readRawVarint32());
                if (fVarFindLiteExtensionByNumber.f24140d.getLiteType() == C11743w.b.f24204w) {
                    while (c11724d.getBytesUntilLimit() > 0) {
                        C11728h.a aVarFindValueByNumber = fVarFindLiteExtensionByNumber.f24140d.getEnumType().findValueByNumber(c11724d.readEnum());
                        if (aVarFindValueByNumber == null) {
                            return true;
                        }
                        c11726f.addRepeatedField(fVarFindLiteExtensionByNumber.f24140d, fVarFindLiteExtensionByNumber.m9855b(aVarFindValueByNumber));
                    }
                } else {
                    while (c11724d.getBytesUntilLimit() > 0) {
                        c11726f.addRepeatedField(fVarFindLiteExtensionByNumber.f24140d, C11726f.readPrimitiveField(c11724d, fVarFindLiteExtensionByNumber.f24140d.getLiteType(), false));
                    }
                }
                c11724d.popLimit(iPushLimit);
                return true;
            }
            int iOrdinal = fVarFindLiteExtensionByNumber.f24140d.getLiteJavaType().ordinal();
            if (iOrdinal == 7) {
                int i3 = c11724d.readEnum();
                C11728h.a aVarFindValueByNumber2 = fVarFindLiteExtensionByNumber.f24140d.getEnumType().findValueByNumber(i3);
                if (aVarFindValueByNumber2 == null) {
                    codedOutputStream.writeRawVarint32(i);
                    codedOutputStream.writeUInt32NoTag(i3);
                    return true;
                }
                objBuild = aVarFindValueByNumber2;
            } else if (iOrdinal != 8) {
                objBuild = C11726f.readPrimitiveField(c11724d, fVarFindLiteExtensionByNumber.f24140d.getLiteType(), false);
            } else {
                InterfaceC11734n.a aVarNewBuilderForType = null;
                if (!fVarFindLiteExtensionByNumber.f24140d.isRepeated() && (interfaceC11734n = (InterfaceC11734n) c11726f.getField(fVarFindLiteExtensionByNumber.f24140d)) != null) {
                    aVarNewBuilderForType = interfaceC11734n.toBuilder();
                }
                if (aVarNewBuilderForType == null) {
                    aVarNewBuilderForType = fVarFindLiteExtensionByNumber.getMessageDefaultInstance().newBuilderForType();
                }
                if (fVarFindLiteExtensionByNumber.f24140d.getLiteType() == C11743w.b.f24200s) {
                    c11724d.readGroup(fVarFindLiteExtensionByNumber.getNumber(), aVarNewBuilderForType, c11725e);
                } else {
                    c11724d.readMessage(aVarNewBuilderForType, c11725e);
                }
                objBuild = aVarNewBuilderForType.build();
            }
            if (fVarFindLiteExtensionByNumber.f24140d.isRepeated()) {
                c11726f.addRepeatedField(fVarFindLiteExtensionByNumber.f24140d, fVarFindLiteExtensionByNumber.m9855b(objBuild));
                return true;
            }
            c11726f.setField(fVarFindLiteExtensionByNumber.f24140d, fVarFindLiteExtensionByNumber.m9855b(objBuild));
            return true;
        }

        /* JADX INFO: renamed from: g */
        public final void m9853g(f<MessageType, ?> fVar) {
            if (fVar.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v5, types: [Type, java.util.ArrayList] */
        public final <Type> Type getExtension(f<MessageType, Type> fVar) {
            m9853g(fVar);
            Type type = (Type) this.extensions.getField(fVar.f24140d);
            if (type == null) {
                return fVar.f24138b;
            }
            if (!fVar.f24140d.isRepeated()) {
                return (Type) fVar.m9854a(type);
            }
            if (fVar.f24140d.getLiteJavaType() != C11743w.c.ENUM) {
                return type;
            }
            ?? r1 = (Type) new ArrayList();
            Iterator it = ((List) type).iterator();
            while (it.hasNext()) {
                r1.add(fVar.m9854a(it.next()));
            }
            return r1;
        }

        public final <Type> int getExtensionCount(f<MessageType, List<Type>> fVar) {
            m9853g(fVar);
            return this.extensions.getRepeatedFieldCount(fVar.f24140d);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> boolean hasExtension(f<MessageType, Type> fVar) {
            m9853g(fVar);
            return this.extensions.hasField(fVar.f24140d);
        }

        public d(c<MessageType, ?> cVar) {
            cVar.f24126k.makeImmutable();
            cVar.f24127l = false;
            this.extensions = cVar.f24126k;
        }

        public final <Type> Type getExtension(f<MessageType, List<Type>> fVar, int i) {
            m9853g(fVar);
            return (Type) fVar.m9854a(this.extensions.getRepeatedField(fVar.f24140d, i));
        }
    }

    public AbstractC11727g(b bVar) {
    }
}
