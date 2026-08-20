package p507d0.p513e0.p514p.p515d.p517m0.p550i;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11726f.a;

/* JADX INFO: renamed from: d0.e0.p.d.m0.i.f */
/* JADX INFO: compiled from: FieldSet.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11726f<FieldDescriptorType extends a<FieldDescriptorType>> {

    /* JADX INFO: renamed from: a */
    public static final C11726f f24121a = new C11726f(true);

    /* JADX INFO: renamed from: b */
    public final C11740t<FieldDescriptorType, Object> f24122b;

    /* JADX INFO: renamed from: c */
    public boolean f24123c;

    /* JADX INFO: renamed from: d */
    public boolean f24124d = false;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.f$a */
    /* JADX INFO: compiled from: FieldSet.java */
    public interface a<T extends a<T>> extends Comparable<T> {
        C11743w.c getLiteJavaType();

        C11743w.b getLiteType();

        int getNumber();

        InterfaceC11734n.a internalMergeFrom(InterfaceC11734n.a aVar, InterfaceC11734n interfaceC11734n);

        boolean isPacked();

        boolean isRepeated();
    }

    public C11726f() {
        int i = C11740t.f24167j;
        this.f24122b = new C11739s(16);
    }

    /* JADX INFO: renamed from: b */
    public static int m9838b(C11743w.b bVar, Object obj) {
        switch (bVar.ordinal()) {
            case 0:
                return CodedOutputStream.computeDoubleSizeNoTag(((Double) obj).doubleValue());
            case 1:
                return CodedOutputStream.computeFloatSizeNoTag(((Float) obj).floatValue());
            case 2:
                return CodedOutputStream.computeInt64SizeNoTag(((Long) obj).longValue());
            case 3:
                return CodedOutputStream.computeUInt64SizeNoTag(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.computeInt32SizeNoTag(((Integer) obj).intValue());
            case 5:
                return CodedOutputStream.computeFixed64SizeNoTag(((Long) obj).longValue());
            case 6:
                return CodedOutputStream.computeFixed32SizeNoTag(((Integer) obj).intValue());
            case 7:
                return CodedOutputStream.computeBoolSizeNoTag(((Boolean) obj).booleanValue());
            case 8:
                return CodedOutputStream.computeStringSizeNoTag((String) obj);
            case 9:
                return CodedOutputStream.computeGroupSizeNoTag((InterfaceC11734n) obj);
            case 10:
                return obj instanceof C11729i ? CodedOutputStream.computeLazyFieldSizeNoTag((C11729i) obj) : CodedOutputStream.computeMessageSizeNoTag((InterfaceC11734n) obj);
            case 11:
                return obj instanceof AbstractC11723c ? CodedOutputStream.computeBytesSizeNoTag((AbstractC11723c) obj) : CodedOutputStream.computeByteArraySizeNoTag((byte[]) obj);
            case 12:
                return CodedOutputStream.computeUInt32SizeNoTag(((Integer) obj).intValue());
            case 13:
                return obj instanceof C11728h.a ? CodedOutputStream.computeEnumSizeNoTag(((C11728h.a) obj).getNumber()) : CodedOutputStream.computeEnumSizeNoTag(((Integer) obj).intValue());
            case 14:
                return CodedOutputStream.computeSFixed32SizeNoTag(((Integer) obj).intValue());
            case 15:
                return CodedOutputStream.computeSFixed64SizeNoTag(((Long) obj).longValue());
            case 16:
                return CodedOutputStream.computeSInt32SizeNoTag(((Integer) obj).intValue());
            case 17:
                return CodedOutputStream.computeSInt64SizeNoTag(((Long) obj).longValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* JADX INFO: renamed from: c */
    public static int m9839c(C11743w.b bVar, boolean z2) {
        if (z2) {
            return 2;
        }
        return bVar.getWireType();
    }

    public static int computeFieldSize(a<?> aVar, Object obj) {
        int iComputeTagSize;
        int iM9838b;
        C11743w.b liteType = aVar.getLiteType();
        int number = aVar.getNumber();
        if (aVar.isRepeated()) {
            int iM9838b2 = 0;
            if (!aVar.isPacked()) {
                for (Object obj2 : (List) obj) {
                    int iComputeTagSize2 = CodedOutputStream.computeTagSize(number);
                    if (liteType == C11743w.b.f24200s) {
                        iComputeTagSize2 *= 2;
                    }
                    iM9838b2 += m9838b(liteType, obj2) + iComputeTagSize2;
                }
                return iM9838b2;
            }
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                iM9838b2 += m9838b(liteType, it.next());
            }
            iComputeTagSize = CodedOutputStream.computeTagSize(number) + iM9838b2;
            iM9838b = CodedOutputStream.computeRawVarint32Size(iM9838b2);
        } else {
            iComputeTagSize = CodedOutputStream.computeTagSize(number);
            if (liteType == C11743w.b.f24200s) {
                iComputeTagSize *= 2;
            }
            iM9838b = m9838b(liteType, obj);
        }
        return iM9838b + iComputeTagSize;
    }

    public static <T extends a<T>> C11726f<T> emptySet() {
        return f24121a;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x002c  */
    /* JADX INFO: renamed from: f */
    public static void m9840f(C11743w.b bVar, Object obj) {
        Objects.requireNonNull(obj);
        boolean z2 = true;
        boolean z3 = false;
        switch (bVar.getJavaType()) {
            case INT:
                z3 = obj instanceof Integer;
                break;
            case LONG:
                z3 = obj instanceof Long;
                break;
            case FLOAT:
                z3 = obj instanceof Float;
                break;
            case DOUBLE:
                z3 = obj instanceof Double;
                break;
            case BOOLEAN:
                z3 = obj instanceof Boolean;
                break;
            case STRING:
                z3 = obj instanceof String;
                break;
            case BYTE_STRING:
                if (!(obj instanceof AbstractC11723c) && !(obj instanceof byte[])) {
                    z2 = false;
                }
                z3 = z2;
                break;
            case ENUM:
                if (!(obj instanceof Integer) && !(obj instanceof C11728h.a)) {
                    z2 = false;
                }
                z3 = z2;
                break;
            case MESSAGE:
                if (!(obj instanceof InterfaceC11734n) && !(obj instanceof C11729i)) {
                    z2 = false;
                }
                z3 = z2;
                break;
        }
        if (!z3) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    /* JADX INFO: renamed from: g */
    public static void m9841g(CodedOutputStream codedOutputStream, C11743w.b bVar, int i, Object obj) throws IOException {
        if (bVar == C11743w.b.f24200s) {
            codedOutputStream.writeGroup(i, (InterfaceC11734n) obj);
        } else {
            codedOutputStream.writeTag(i, m9839c(bVar, false));
            m9842h(codedOutputStream, bVar, obj);
        }
    }

    /* JADX INFO: renamed from: h */
    public static void m9842h(CodedOutputStream codedOutputStream, C11743w.b bVar, Object obj) throws IOException {
        switch (bVar.ordinal()) {
            case 0:
                codedOutputStream.writeDoubleNoTag(((Double) obj).doubleValue());
                break;
            case 1:
                codedOutputStream.writeFloatNoTag(((Float) obj).floatValue());
                break;
            case 2:
                codedOutputStream.writeInt64NoTag(((Long) obj).longValue());
                break;
            case 3:
                codedOutputStream.writeUInt64NoTag(((Long) obj).longValue());
                break;
            case 4:
                codedOutputStream.writeInt32NoTag(((Integer) obj).intValue());
                break;
            case 5:
                codedOutputStream.writeFixed64NoTag(((Long) obj).longValue());
                break;
            case 6:
                codedOutputStream.writeFixed32NoTag(((Integer) obj).intValue());
                break;
            case 7:
                codedOutputStream.writeBoolNoTag(((Boolean) obj).booleanValue());
                break;
            case 8:
                codedOutputStream.writeStringNoTag((String) obj);
                break;
            case 9:
                codedOutputStream.writeGroupNoTag((InterfaceC11734n) obj);
                break;
            case 10:
                codedOutputStream.writeMessageNoTag((InterfaceC11734n) obj);
                break;
            case 11:
                if (!(obj instanceof AbstractC11723c)) {
                    codedOutputStream.writeByteArrayNoTag((byte[]) obj);
                } else {
                    codedOutputStream.writeBytesNoTag((AbstractC11723c) obj);
                }
                break;
            case 12:
                codedOutputStream.writeUInt32NoTag(((Integer) obj).intValue());
                break;
            case 13:
                if (!(obj instanceof C11728h.a)) {
                    codedOutputStream.writeEnumNoTag(((Integer) obj).intValue());
                } else {
                    codedOutputStream.writeEnumNoTag(((C11728h.a) obj).getNumber());
                }
                break;
            case 14:
                codedOutputStream.writeSFixed32NoTag(((Integer) obj).intValue());
                break;
            case 15:
                codedOutputStream.writeSFixed64NoTag(((Long) obj).longValue());
                break;
            case 16:
                codedOutputStream.writeSInt32NoTag(((Integer) obj).intValue());
                break;
            case 17:
                codedOutputStream.writeSInt64NoTag(((Long) obj).longValue());
                break;
        }
    }

    public static <T extends a<T>> C11726f<T> newFieldSet() {
        return new C11726f<>();
    }

    public static Object readPrimitiveField(C11724d c11724d, C11743w.b bVar, boolean z2) throws IOException {
        switch (bVar.ordinal()) {
            case 0:
                return Double.valueOf(c11724d.readDouble());
            case 1:
                return Float.valueOf(c11724d.readFloat());
            case 2:
                return Long.valueOf(c11724d.readInt64());
            case 3:
                return Long.valueOf(c11724d.readUInt64());
            case 4:
                return Integer.valueOf(c11724d.readInt32());
            case 5:
                return Long.valueOf(c11724d.readFixed64());
            case 6:
                return Integer.valueOf(c11724d.readFixed32());
            case 7:
                return Boolean.valueOf(c11724d.readBool());
            case 8:
                return z2 ? c11724d.readStringRequireUtf8() : c11724d.readString();
            case 9:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 10:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 11:
                return c11724d.readBytes();
            case 12:
                return Integer.valueOf(c11724d.readUInt32());
            case 13:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            case 14:
                return Integer.valueOf(c11724d.readSFixed32());
            case 15:
                return Long.valueOf(c11724d.readSFixed64());
            case 16:
                return Integer.valueOf(c11724d.readSInt32());
            case 17:
                return Long.valueOf(c11724d.readSInt64());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static void writeField(a<?> aVar, Object obj, CodedOutputStream codedOutputStream) throws IOException {
        C11743w.b liteType = aVar.getLiteType();
        int number = aVar.getNumber();
        if (!aVar.isRepeated()) {
            if (obj instanceof C11729i) {
                m9841g(codedOutputStream, liteType, number, ((C11729i) obj).getValue());
                return;
            } else {
                m9841g(codedOutputStream, liteType, number, obj);
                return;
            }
        }
        List list = (List) obj;
        if (!aVar.isPacked()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                m9841g(codedOutputStream, liteType, number, it.next());
            }
            return;
        }
        codedOutputStream.writeTag(number, 2);
        int iM9838b = 0;
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            iM9838b += m9838b(liteType, it2.next());
        }
        codedOutputStream.writeRawVarint32(iM9838b);
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            m9842h(codedOutputStream, liteType, it3.next());
        }
    }

    /* JADX INFO: renamed from: a */
    public final Object m9843a(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public void addRepeatedField(FieldDescriptorType fielddescriptortype, Object obj) {
        List arrayList;
        if (!fielddescriptortype.isRepeated()) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        m9840f(fielddescriptortype.getLiteType(), obj);
        Object field = getField(fielddescriptortype);
        if (field == null) {
            arrayList = new ArrayList();
            this.f24122b.put(fielddescriptortype, arrayList);
        } else {
            arrayList = (List) field;
        }
        arrayList.add(obj);
    }

    /* JADX INFO: renamed from: d */
    public final boolean m9844d(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.getLiteJavaType() == C11743w.c.MESSAGE) {
            if (key.isRepeated()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((InterfaceC11734n) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (!(value instanceof InterfaceC11734n)) {
                    if (value instanceof C11729i) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
                if (!((InterfaceC11734n) value).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: e */
    public final void m9845e(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof C11729i) {
            value = ((C11729i) value).getValue();
        }
        if (key.isRepeated()) {
            Object field = getField(key);
            if (field == null) {
                field = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) field).add(m9843a(it.next()));
            }
            this.f24122b.put(key, field);
            return;
        }
        if (key.getLiteJavaType() != C11743w.c.MESSAGE) {
            this.f24122b.put(key, m9843a(value));
            return;
        }
        Object field2 = getField(key);
        if (field2 == null) {
            this.f24122b.put(key, m9843a(value));
        } else {
            this.f24122b.put(key, key.internalMergeFrom(((InterfaceC11734n) field2).toBuilder(), (InterfaceC11734n) value).build());
        }
    }

    public Object getField(FieldDescriptorType fielddescriptortype) {
        Object obj = this.f24122b.get(fielddescriptortype);
        return obj instanceof C11729i ? ((C11729i) obj).getValue() : obj;
    }

    public Object getRepeatedField(FieldDescriptorType fielddescriptortype, int i) {
        if (!fielddescriptortype.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object field = getField(fielddescriptortype);
        if (field != null) {
            return ((List) field).get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public int getRepeatedFieldCount(FieldDescriptorType fielddescriptortype) {
        if (!fielddescriptortype.isRepeated()) {
            throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
        }
        Object field = getField(fielddescriptortype);
        if (field == null) {
            return 0;
        }
        return ((List) field).size();
    }

    public int getSerializedSize() {
        int iComputeFieldSize = 0;
        for (int i = 0; i < this.f24122b.getNumArrayEntries(); i++) {
            Map.Entry<K, Object> arrayEntryAt = this.f24122b.getArrayEntryAt(i);
            iComputeFieldSize += computeFieldSize((a) arrayEntryAt.getKey(), arrayEntryAt.getValue());
        }
        Iterator it = this.f24122b.getOverflowEntries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            iComputeFieldSize += computeFieldSize((a) entry.getKey(), entry.getValue());
        }
        return iComputeFieldSize;
    }

    public boolean hasField(FieldDescriptorType fielddescriptortype) {
        if (fielddescriptortype.isRepeated()) {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
        return this.f24122b.get(fielddescriptortype) != null;
    }

    public boolean isInitialized() {
        for (int i = 0; i < this.f24122b.getNumArrayEntries(); i++) {
            if (!m9844d(this.f24122b.getArrayEntryAt(i))) {
                return false;
            }
        }
        Iterator it = this.f24122b.getOverflowEntries().iterator();
        while (it.hasNext()) {
            if (!m9844d((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        return this.f24124d ? new C11729i.c(this.f24122b.entrySet().iterator()) : this.f24122b.entrySet().iterator();
    }

    public void makeImmutable() {
        if (this.f24123c) {
            return;
        }
        this.f24122b.makeImmutable();
        this.f24123c = true;
    }

    public void mergeFrom(C11726f<FieldDescriptorType> c11726f) {
        for (int i = 0; i < c11726f.f24122b.getNumArrayEntries(); i++) {
            m9845e(c11726f.f24122b.getArrayEntryAt(i));
        }
        Iterator it = c11726f.f24122b.getOverflowEntries().iterator();
        while (it.hasNext()) {
            m9845e((Map.Entry) it.next());
        }
    }

    public void setField(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.isRepeated()) {
            m9840f(fielddescriptortype.getLiteType(), obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                m9840f(fielddescriptortype.getLiteType(), it.next());
            }
            obj = arrayList;
        }
        if (obj instanceof C11729i) {
            this.f24124d = true;
        }
        this.f24122b.put(fielddescriptortype, obj);
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public C11726f<FieldDescriptorType> m11468clone() {
        C11726f<FieldDescriptorType> c11726fNewFieldSet = newFieldSet();
        for (int i = 0; i < this.f24122b.getNumArrayEntries(); i++) {
            Map.Entry<K, Object> arrayEntryAt = this.f24122b.getArrayEntryAt(i);
            c11726fNewFieldSet.setField((a) arrayEntryAt.getKey(), arrayEntryAt.getValue());
        }
        Iterator it = this.f24122b.getOverflowEntries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            c11726fNewFieldSet.setField((a) entry.getKey(), entry.getValue());
        }
        c11726fNewFieldSet.f24124d = this.f24124d;
        return c11726fNewFieldSet;
    }

    public C11726f(boolean z2) {
        int i = C11740t.f24167j;
        this.f24122b = new C11739s(0);
        makeImmutable();
    }
}
