package d0.e0.p.d.m0.i;

import d0.e0.p.d.m0.i.g$d;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;

/* JADX INFO: compiled from: GeneratedMessageLite.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g$d<MessageType extends g$d<MessageType>> extends g implements o {
    private final f<g$e> extensions;

    public g$d() {
        this.extensions = f.newFieldSet();
    }

    public static /* synthetic */ f a(g$d g_d) {
        return g_d.extensions;
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

    /* JADX WARN: Incorrect inner types in method signature: ()Ld0/e0/p/d/m0/i/g$d<TMessageType;>.a; */
    public g$d$a e() {
        return new g$d$a(this, false, null);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0040  */
    public boolean f(d dVar, CodedOutputStream codedOutputStream, e eVar, int i) throws IOException {
        boolean z2;
        boolean z3;
        Object objBuild;
        n nVar;
        f<g$e> fVar = this.extensions;
        int i2 = i & 7;
        g$f g_fFindLiteExtensionByNumber = eVar.findLiteExtensionByNumber(getDefaultInstanceForType(), w.getTagFieldNumber(i));
        if (g_fFindLiteExtensionByNumber == null) {
            z2 = true;
            z3 = false;
        } else if (i2 == f.c(g_fFindLiteExtensionByNumber.d.getLiteType(), false)) {
            z2 = false;
            z3 = false;
        } else {
            g$e g_e = g_fFindLiteExtensionByNumber.d;
            if (g_e.m && g_e.l.isPackable() && i2 == f.c(g_fFindLiteExtensionByNumber.d.getLiteType(), true)) {
                z2 = false;
                z3 = true;
            } else {
                z2 = true;
                z3 = false;
            }
        }
        if (z2) {
            return dVar.skipField(i, codedOutputStream);
        }
        if (z3) {
            int iPushLimit = dVar.pushLimit(dVar.readRawVarint32());
            if (g_fFindLiteExtensionByNumber.d.getLiteType() == w$b.w) {
                while (dVar.getBytesUntilLimit() > 0) {
                    h$a h_aFindValueByNumber = g_fFindLiteExtensionByNumber.d.getEnumType().findValueByNumber(dVar.readEnum());
                    if (h_aFindValueByNumber == null) {
                        return true;
                    }
                    fVar.addRepeatedField(g_fFindLiteExtensionByNumber.d, g_fFindLiteExtensionByNumber.b(h_aFindValueByNumber));
                }
            } else {
                while (dVar.getBytesUntilLimit() > 0) {
                    fVar.addRepeatedField(g_fFindLiteExtensionByNumber.d, f.readPrimitiveField(dVar, g_fFindLiteExtensionByNumber.d.getLiteType(), false));
                }
            }
            dVar.popLimit(iPushLimit);
            return true;
        }
        int iOrdinal = g_fFindLiteExtensionByNumber.d.getLiteJavaType().ordinal();
        if (iOrdinal == 7) {
            int i3 = dVar.readEnum();
            h$a h_aFindValueByNumber2 = g_fFindLiteExtensionByNumber.d.getEnumType().findValueByNumber(i3);
            if (h_aFindValueByNumber2 == null) {
                codedOutputStream.writeRawVarint32(i);
                codedOutputStream.writeUInt32NoTag(i3);
                return true;
            }
            objBuild = h_aFindValueByNumber2;
        } else if (iOrdinal != 8) {
            objBuild = f.readPrimitiveField(dVar, g_fFindLiteExtensionByNumber.d.getLiteType(), false);
        } else {
            n$a n_aNewBuilderForType = null;
            if (!g_fFindLiteExtensionByNumber.d.isRepeated() && (nVar = (n) fVar.getField(g_fFindLiteExtensionByNumber.d)) != null) {
                n_aNewBuilderForType = nVar.toBuilder();
            }
            if (n_aNewBuilderForType == null) {
                n_aNewBuilderForType = g_fFindLiteExtensionByNumber.getMessageDefaultInstance().newBuilderForType();
            }
            if (g_fFindLiteExtensionByNumber.d.getLiteType() == w$b.f3434s) {
                dVar.readGroup(g_fFindLiteExtensionByNumber.getNumber(), n_aNewBuilderForType, eVar);
            } else {
                dVar.readMessage(n_aNewBuilderForType, eVar);
            }
            objBuild = n_aNewBuilderForType.build();
        }
        if (g_fFindLiteExtensionByNumber.d.isRepeated()) {
            fVar.addRepeatedField(g_fFindLiteExtensionByNumber.d, g_fFindLiteExtensionByNumber.b(objBuild));
            return true;
        }
        fVar.setField(g_fFindLiteExtensionByNumber.d, g_fFindLiteExtensionByNumber.b(objBuild));
        return true;
    }

    public final void g(g$f<MessageType, ?> g_f) {
        if (g_f.getContainingTypeDefaultInstance() != getDefaultInstanceForType()) {
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [Type, java.util.ArrayList] */
    public final <Type> Type getExtension(g$f<MessageType, Type> g_f) {
        g(g_f);
        Type type = (Type) this.extensions.getField(g_f.d);
        if (type == null) {
            return g_f.f3431b;
        }
        if (!g_f.d.isRepeated()) {
            return (Type) g_f.a(type);
        }
        if (g_f.d.getLiteJavaType() != w$c.ENUM) {
            return type;
        }
        ?? r1 = (Type) new ArrayList();
        Iterator it = ((List) type).iterator();
        while (it.hasNext()) {
            r1.add(g_f.a(it.next()));
        }
        return r1;
    }

    public final <Type> int getExtensionCount(g$f<MessageType, List<Type>> g_f) {
        g(g_f);
        return this.extensions.getRepeatedFieldCount(g_f.d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <Type> boolean hasExtension(g$f<MessageType, Type> g_f) {
        g(g_f);
        return this.extensions.hasField(g_f.d);
    }

    public g$d(g$c<MessageType, ?> g_c) {
        g_c.k.makeImmutable();
        g_c.l = false;
        this.extensions = g_c.k;
    }

    public final <Type> Type getExtension(g$f<MessageType, List<Type>> g_f, int i) {
        g(g_f);
        return (Type) g_f.a(this.extensions.getRepeatedField(g_f.d, i));
    }
}
