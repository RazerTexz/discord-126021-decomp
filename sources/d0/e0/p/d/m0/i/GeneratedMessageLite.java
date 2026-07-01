package d0.e0.p.d.m0.i;

import b.d.b.a.outline;
import d0.e0.p.d.m0.i.AbstractMessageLite;
import d0.e0.p.d.m0.i.FieldSet;
import d0.e0.p.d.m0.i.Internal;
import d0.e0.p.d.m0.i.MessageLite;
import d0.e0.p.d.m0.i.WireFormat;
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

/* JADX INFO: renamed from: d0.e0.p.d.m0.i.g, reason: use source file name */
/* JADX INFO: compiled from: GeneratedMessageLite.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class GeneratedMessageLite extends AbstractMessageLite implements Serializable {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.g$b */
    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    public static abstract class b<MessageType extends GeneratedMessageLite, BuilderType extends b> extends AbstractMessageLite.a<BuilderType> {
        public ByteString3 j = ByteString3.j;

        public final ByteString3 getUnknownFields() {
            return this.j;
        }

        public abstract BuilderType mergeFrom(MessageType messagetype);

        public final BuilderType setUnknownFields(ByteString3 byteString3) {
            this.j = byteString3;
            return this;
        }

        @Override // 
        /* JADX INFO: renamed from: clone */
        public BuilderType mo88clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.g$c */
    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    public static abstract class c<MessageType extends d<MessageType>, BuilderType extends c<MessageType, BuilderType>> extends b<MessageType, BuilderType> implements MessageLiteOrBuilder {
        public FieldSet<e> k = FieldSet.emptySet();
        public boolean l;

        public final void b(MessageType messagetype) {
            if (!this.l) {
                this.k = this.k.m91clone();
                this.l = true;
            }
            this.k.mergeFrom(((d) messagetype).extensions);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.g$e */
    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    public static final class e implements FieldSet.a<e> {
        public final Internal.b<?> j;
        public final int k;
        public final WireFormat.b l;
        public final boolean m;
        public final boolean n;

        public e(Internal.b<?> bVar, int i, WireFormat.b bVar2, boolean z2, boolean z3) {
            this.j = bVar;
            this.k = i;
            this.l = bVar2;
            this.m = z2;
            this.n = z3;
        }

        public Internal.b<?> getEnumType() {
            return this.j;
        }

        @Override // d0.e0.p.d.m0.i.FieldSet.a
        public WireFormat.c getLiteJavaType() {
            return this.l.getJavaType();
        }

        @Override // d0.e0.p.d.m0.i.FieldSet.a
        public WireFormat.b getLiteType() {
            return this.l;
        }

        @Override // d0.e0.p.d.m0.i.FieldSet.a
        public int getNumber() {
            return this.k;
        }

        @Override // d0.e0.p.d.m0.i.FieldSet.a
        public MessageLite.a internalMergeFrom(MessageLite.a aVar, MessageLite messageLite) {
            return ((b) aVar).mergeFrom((GeneratedMessageLite) messageLite);
        }

        @Override // d0.e0.p.d.m0.i.FieldSet.a
        public boolean isPacked() {
            return this.n;
        }

        @Override // d0.e0.p.d.m0.i.FieldSet.a
        public boolean isRepeated() {
            return this.m;
        }

        @Override // java.lang.Comparable
        public int compareTo(e eVar) {
            return this.k - eVar.k;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.g$f */
    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    public static class f<ContainingType extends MessageLite, Type> {
        public final ContainingType a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Type f3431b;
        public final MessageLite c;
        public final e d;
        public final Method e;

        public f(ContainingType containingtype, Type type, MessageLite messageLite, e eVar, Class cls) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            }
            if (eVar.getLiteType() == WireFormat.b.t && messageLite == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            }
            this.a = containingtype;
            this.f3431b = type;
            this.c = messageLite;
            this.d = eVar;
            if (!Internal.a.class.isAssignableFrom(cls)) {
                this.e = null;
                return;
            }
            try {
                this.e = cls.getMethod("valueOf", Integer.TYPE);
            } catch (NoSuchMethodException e) {
                String name = cls.getName();
                StringBuilder sb = new StringBuilder(name.length() + 45 + 7);
                outline.s0(sb, "Generated message class \"", name, "\" missing method \"", "valueOf");
                sb.append("\".");
                throw new RuntimeException(sb.toString(), e);
            }
        }

        public Object a(Object obj) {
            if (this.d.getLiteJavaType() != WireFormat.c.ENUM) {
                return obj;
            }
            try {
                return this.e.invoke(null, (Integer) obj);
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

        public Object b(Object obj) {
            return this.d.getLiteJavaType() == WireFormat.c.ENUM ? Integer.valueOf(((Internal.a) obj).getNumber()) : obj;
        }

        public ContainingType getContainingTypeDefaultInstance() {
            return this.a;
        }

        public MessageLite getMessageDefaultInstance() {
            return this.c;
        }

        public int getNumber() {
            return this.d.getNumber();
        }
    }

    public GeneratedMessageLite() {
    }

    public static <ContainingType extends MessageLite, Type> f<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, MessageLite messageLite, Internal.b<?> bVar, int i, WireFormat.b bVar2, boolean z2, Class cls) {
        return new f<>(containingtype, Collections.emptyList(), messageLite, new e(bVar, i, bVar2, true, z2), cls);
    }

    public static <ContainingType extends MessageLite, Type> f<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, MessageLite messageLite, Internal.b<?> bVar, int i, WireFormat.b bVar2, Class cls) {
        return new f<>(containingtype, type, messageLite, new e(bVar, i, bVar2, false, false), cls);
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.g$d */
    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    public static abstract class d<MessageType extends d<MessageType>> extends GeneratedMessageLite implements MessageLiteOrBuilder {
        private final FieldSet<e> extensions;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.i.g$d$a */
        /* JADX INFO: compiled from: GeneratedMessageLite.java */
        public class a {
            public final Iterator<Map.Entry<e, Object>> a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Map.Entry<e, Object> f3430b;
            public final boolean c;

            public a(boolean z2, a aVar) {
                Iterator<Map.Entry<e, Object>> it = d.this.extensions.iterator();
                this.a = it;
                if (it.hasNext()) {
                    this.f3430b = it.next();
                }
                this.c = z2;
            }

            public void writeUntil(int i, CodedOutputStream codedOutputStream) throws IOException {
                while (true) {
                    Map.Entry<e, Object> entry = this.f3430b;
                    if (entry == null || entry.getKey().getNumber() >= i) {
                        return;
                    }
                    e key = this.f3430b.getKey();
                    if (this.c && key.getLiteJavaType() == WireFormat.c.MESSAGE && !key.isRepeated()) {
                        codedOutputStream.writeMessageSetExtension(key.getNumber(), (MessageLite) this.f3430b.getValue());
                    } else {
                        FieldSet.writeField(key, this.f3430b.getValue(), codedOutputStream);
                    }
                    if (this.a.hasNext()) {
                        this.f3430b = this.a.next();
                    } else {
                        this.f3430b = null;
                    }
                }
            }
        }

        public d() {
            this.extensions = FieldSet.newFieldSet();
        }

        public boolean b() {
            return this.extensions.isInitialized();
        }

        public int c() {
            return this.extensions.getSerializedSize();
        }

        public void d() {
            this.extensions.makeImmutable();
        }

        public d<MessageType>.a e() {
            return new a(false, null);
        }

        /* JADX WARN: Code duplicated, block: B:15:0x0040  */
        public boolean f(CodedInputStream codedInputStream, CodedOutputStream codedOutputStream, ExtensionRegistryLite extensionRegistryLite, int i) throws IOException {
            boolean z2;
            boolean z3;
            Object objBuild;
            MessageLite messageLite;
            FieldSet<e> fieldSet = this.extensions;
            int i2 = i & 7;
            f fVarFindLiteExtensionByNumber = extensionRegistryLite.findLiteExtensionByNumber(getDefaultInstanceForType(), WireFormat.getTagFieldNumber(i));
            if (fVarFindLiteExtensionByNumber == null) {
                z2 = true;
                z3 = false;
            } else if (i2 == FieldSet.c(fVarFindLiteExtensionByNumber.d.getLiteType(), false)) {
                z2 = false;
                z3 = false;
            } else {
                e eVar = fVarFindLiteExtensionByNumber.d;
                if (eVar.m && eVar.l.isPackable() && i2 == FieldSet.c(fVarFindLiteExtensionByNumber.d.getLiteType(), true)) {
                    z2 = false;
                    z3 = true;
                } else {
                    z2 = true;
                    z3 = false;
                }
            }
            if (z2) {
                return codedInputStream.skipField(i, codedOutputStream);
            }
            if (z3) {
                int iPushLimit = codedInputStream.pushLimit(codedInputStream.readRawVarint32());
                if (fVarFindLiteExtensionByNumber.d.getLiteType() == WireFormat.b.w) {
                    while (codedInputStream.getBytesUntilLimit() > 0) {
                        Internal.a aVarFindValueByNumber = fVarFindLiteExtensionByNumber.d.getEnumType().findValueByNumber(codedInputStream.readEnum());
                        if (aVarFindValueByNumber == null) {
                            return true;
                        }
                        fieldSet.addRepeatedField(fVarFindLiteExtensionByNumber.d, fVarFindLiteExtensionByNumber.b(aVarFindValueByNumber));
                    }
                } else {
                    while (codedInputStream.getBytesUntilLimit() > 0) {
                        fieldSet.addRepeatedField(fVarFindLiteExtensionByNumber.d, FieldSet.readPrimitiveField(codedInputStream, fVarFindLiteExtensionByNumber.d.getLiteType(), false));
                    }
                }
                codedInputStream.popLimit(iPushLimit);
                return true;
            }
            int iOrdinal = fVarFindLiteExtensionByNumber.d.getLiteJavaType().ordinal();
            if (iOrdinal == 7) {
                int i3 = codedInputStream.readEnum();
                Internal.a aVarFindValueByNumber2 = fVarFindLiteExtensionByNumber.d.getEnumType().findValueByNumber(i3);
                if (aVarFindValueByNumber2 == null) {
                    codedOutputStream.writeRawVarint32(i);
                    codedOutputStream.writeUInt32NoTag(i3);
                    return true;
                }
                objBuild = aVarFindValueByNumber2;
            } else if (iOrdinal != 8) {
                objBuild = FieldSet.readPrimitiveField(codedInputStream, fVarFindLiteExtensionByNumber.d.getLiteType(), false);
            } else {
                MessageLite.a aVarNewBuilderForType = null;
                if (!fVarFindLiteExtensionByNumber.d.isRepeated() && (messageLite = (MessageLite) fieldSet.getField(fVarFindLiteExtensionByNumber.d)) != null) {
                    aVarNewBuilderForType = messageLite.toBuilder();
                }
                if (aVarNewBuilderForType == null) {
                    aVarNewBuilderForType = fVarFindLiteExtensionByNumber.getMessageDefaultInstance().newBuilderForType();
                }
                if (fVarFindLiteExtensionByNumber.d.getLiteType() == WireFormat.b.f3434s) {
                    codedInputStream.readGroup(fVarFindLiteExtensionByNumber.getNumber(), aVarNewBuilderForType, extensionRegistryLite);
                } else {
                    codedInputStream.readMessage(aVarNewBuilderForType, extensionRegistryLite);
                }
                objBuild = aVarNewBuilderForType.build();
            }
            if (fVarFindLiteExtensionByNumber.d.isRepeated()) {
                fieldSet.addRepeatedField(fVarFindLiteExtensionByNumber.d, fVarFindLiteExtensionByNumber.b(objBuild));
                return true;
            }
            fieldSet.setField(fVarFindLiteExtensionByNumber.d, fVarFindLiteExtensionByNumber.b(objBuild));
            return true;
        }

        public final void g(f<MessageType, ?> fVar) {
            if (fVar.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v5, types: [Type, java.util.ArrayList] */
        public final <Type> Type getExtension(f<MessageType, Type> fVar) {
            g(fVar);
            Type type = (Type) this.extensions.getField(fVar.d);
            if (type == null) {
                return fVar.f3431b;
            }
            if (!fVar.d.isRepeated()) {
                return (Type) fVar.a(type);
            }
            if (fVar.d.getLiteJavaType() != WireFormat.c.ENUM) {
                return type;
            }
            ?? r1 = (Type) new ArrayList();
            Iterator it = ((List) type).iterator();
            while (it.hasNext()) {
                r1.add(fVar.a(it.next()));
            }
            return r1;
        }

        public final <Type> int getExtensionCount(f<MessageType, List<Type>> fVar) {
            g(fVar);
            return this.extensions.getRepeatedFieldCount(fVar.d);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> boolean hasExtension(f<MessageType, Type> fVar) {
            g(fVar);
            return this.extensions.hasField(fVar.d);
        }

        public d(c<MessageType, ?> cVar) {
            cVar.k.makeImmutable();
            cVar.l = false;
            this.extensions = cVar.k;
        }

        public final <Type> Type getExtension(f<MessageType, List<Type>> fVar, int i) {
            g(fVar);
            return (Type) fVar.a(this.extensions.getRepeatedField(fVar.d, i));
        }
    }

    public GeneratedMessageLite(b bVar) {
    }
}
