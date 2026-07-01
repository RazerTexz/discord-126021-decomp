package d0.e0.p.d.m0.i;

import d0.e0.p.d.m0.i.f$a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map$Entry;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;

/* JADX INFO: compiled from: FieldSet.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f<FieldDescriptorType extends f$a<FieldDescriptorType>> {
    public static final f a = new f(true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t<FieldDescriptorType, Object> f3429b;
    public boolean c;
    public boolean d = false;

    public f() {
        int i = t.j;
        this.f3429b = new s(16);
    }

    public static int b(w$b w_b, Object obj) {
        switch (w_b.ordinal()) {
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
                return CodedOutputStream.computeGroupSizeNoTag((n) obj);
            case 10:
                return obj instanceof i ? CodedOutputStream.computeLazyFieldSizeNoTag((i) obj) : CodedOutputStream.computeMessageSizeNoTag((n) obj);
            case 11:
                return obj instanceof c ? CodedOutputStream.computeBytesSizeNoTag((c) obj) : CodedOutputStream.computeByteArraySizeNoTag((byte[]) obj);
            case 12:
                return CodedOutputStream.computeUInt32SizeNoTag(((Integer) obj).intValue());
            case 13:
                return obj instanceof h$a ? CodedOutputStream.computeEnumSizeNoTag(((h$a) obj).getNumber()) : CodedOutputStream.computeEnumSizeNoTag(((Integer) obj).intValue());
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

    public static int c(w$b w_b, boolean z2) {
        if (z2) {
            return 2;
        }
        return w_b.getWireType();
    }

    public static int computeFieldSize(f$a<?> f_a, Object obj) {
        int iComputeTagSize;
        int iB;
        w$b liteType = f_a.getLiteType();
        int number = f_a.getNumber();
        if (f_a.isRepeated()) {
            int iB2 = 0;
            if (!f_a.isPacked()) {
                for (Object obj2 : (List) obj) {
                    int iComputeTagSize2 = CodedOutputStream.computeTagSize(number);
                    if (liteType == w$b.f3434s) {
                        iComputeTagSize2 *= 2;
                    }
                    iB2 += b(liteType, obj2) + iComputeTagSize2;
                }
                return iB2;
            }
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                iB2 += b(liteType, it.next());
            }
            iComputeTagSize = CodedOutputStream.computeTagSize(number) + iB2;
            iB = CodedOutputStream.computeRawVarint32Size(iB2);
        } else {
            iComputeTagSize = CodedOutputStream.computeTagSize(number);
            if (liteType == w$b.f3434s) {
                iComputeTagSize *= 2;
            }
            iB = b(liteType, obj);
        }
        return iB + iComputeTagSize;
    }

    public static <T extends f$a<T>> f<T> emptySet() {
        return a;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x002c  */
    public static void f(w$b w_b, Object obj) {
        Objects.requireNonNull(obj);
        boolean z2 = true;
        boolean z3 = false;
        switch (w_b.getJavaType()) {
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
                if (!(obj instanceof c) && !(obj instanceof byte[])) {
                    z2 = false;
                }
                z3 = z2;
                break;
            case ENUM:
                if (!(obj instanceof Integer) && !(obj instanceof h$a)) {
                    z2 = false;
                }
                z3 = z2;
                break;
            case MESSAGE:
                if (!(obj instanceof n) && !(obj instanceof i)) {
                    z2 = false;
                }
                z3 = z2;
                break;
        }
        if (!z3) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    public static void g(CodedOutputStream codedOutputStream, w$b w_b, int i, Object obj) throws IOException {
        if (w_b == w$b.f3434s) {
            codedOutputStream.writeGroup(i, (n) obj);
        } else {
            codedOutputStream.writeTag(i, c(w_b, false));
            h(codedOutputStream, w_b, obj);
        }
    }

    public static void h(CodedOutputStream codedOutputStream, w$b w_b, Object obj) throws IOException {
        switch (w_b.ordinal()) {
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
                codedOutputStream.writeGroupNoTag((n) obj);
                break;
            case 10:
                codedOutputStream.writeMessageNoTag((n) obj);
                break;
            case 11:
                if (!(obj instanceof c)) {
                    codedOutputStream.writeByteArrayNoTag((byte[]) obj);
                } else {
                    codedOutputStream.writeBytesNoTag((c) obj);
                }
                break;
            case 12:
                codedOutputStream.writeUInt32NoTag(((Integer) obj).intValue());
                break;
            case 13:
                if (!(obj instanceof h$a)) {
                    codedOutputStream.writeEnumNoTag(((Integer) obj).intValue());
                } else {
                    codedOutputStream.writeEnumNoTag(((h$a) obj).getNumber());
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

    public static <T extends f$a<T>> f<T> newFieldSet() {
        return new f<>();
    }

    public static Object readPrimitiveField(d dVar, w$b w_b, boolean z2) throws IOException {
        switch (w_b.ordinal()) {
            case 0:
                return Double.valueOf(dVar.readDouble());
            case 1:
                return Float.valueOf(dVar.readFloat());
            case 2:
                return Long.valueOf(dVar.readInt64());
            case 3:
                return Long.valueOf(dVar.readUInt64());
            case 4:
                return Integer.valueOf(dVar.readInt32());
            case 5:
                return Long.valueOf(dVar.readFixed64());
            case 6:
                return Integer.valueOf(dVar.readFixed32());
            case 7:
                return Boolean.valueOf(dVar.readBool());
            case 8:
                return z2 ? dVar.readStringRequireUtf8() : dVar.readString();
            case 9:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 10:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 11:
                return dVar.readBytes();
            case 12:
                return Integer.valueOf(dVar.readUInt32());
            case 13:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            case 14:
                return Integer.valueOf(dVar.readSFixed32());
            case 15:
                return Long.valueOf(dVar.readSFixed64());
            case 16:
                return Integer.valueOf(dVar.readSInt32());
            case 17:
                return Long.valueOf(dVar.readSInt64());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static void writeField(f$a<?> f_a, Object obj, CodedOutputStream codedOutputStream) throws IOException {
        w$b liteType = f_a.getLiteType();
        int number = f_a.getNumber();
        if (!f_a.isRepeated()) {
            if (obj instanceof i) {
                g(codedOutputStream, liteType, number, ((i) obj).getValue());
                return;
            } else {
                g(codedOutputStream, liteType, number, obj);
                return;
            }
        }
        List list = (List) obj;
        if (!f_a.isPacked()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                g(codedOutputStream, liteType, number, it.next());
            }
            return;
        }
        codedOutputStream.writeTag(number, 2);
        int iB = 0;
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            iB += b(liteType, it2.next());
        }
        codedOutputStream.writeRawVarint32(iB);
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            h(codedOutputStream, liteType, it3.next());
        }
    }

    public final Object a(Object obj) {
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
        f(fielddescriptortype.getLiteType(), obj);
        Object field = getField(fielddescriptortype);
        if (field == null) {
            arrayList = new ArrayList();
            this.f3429b.put(fielddescriptortype, arrayList);
        } else {
            arrayList = (List) field;
        }
        arrayList.add(obj);
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m91clone() throws CloneNotSupportedException {
        return clone();
    }

    public final boolean d(Map$Entry<FieldDescriptorType, Object> map$Entry) {
        FieldDescriptorType key = map$Entry.getKey();
        if (key.getLiteJavaType() == w$c.MESSAGE) {
            if (key.isRepeated()) {
                Iterator it = ((List) map$Entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((n) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = map$Entry.getValue();
                if (!(value instanceof n)) {
                    if (value instanceof i) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
                if (!((n) value).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void e(Map$Entry<FieldDescriptorType, Object> map$Entry) {
        FieldDescriptorType key = map$Entry.getKey();
        Object value = map$Entry.getValue();
        if (value instanceof i) {
            value = ((i) value).getValue();
        }
        if (key.isRepeated()) {
            Object field = getField(key);
            if (field == null) {
                field = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) field).add(a(it.next()));
            }
            this.f3429b.put(key, field);
            return;
        }
        if (key.getLiteJavaType() != w$c.MESSAGE) {
            this.f3429b.put(key, a(value));
            return;
        }
        Object field2 = getField(key);
        if (field2 == null) {
            this.f3429b.put(key, a(value));
        } else {
            this.f3429b.put(key, key.internalMergeFrom(((n) field2).toBuilder(), (n) value).build());
        }
    }

    public Object getField(FieldDescriptorType fielddescriptortype) {
        Object obj = this.f3429b.get(fielddescriptortype);
        return obj instanceof i ? ((i) obj).getValue() : obj;
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
        for (int i = 0; i < this.f3429b.getNumArrayEntries(); i++) {
            Map$Entry<K, Object> arrayEntryAt = this.f3429b.getArrayEntryAt(i);
            iComputeFieldSize += computeFieldSize((f$a) arrayEntryAt.getKey(), arrayEntryAt.getValue());
        }
        Iterator it = this.f3429b.getOverflowEntries().iterator();
        while (it.hasNext()) {
            Map$Entry map$Entry = (Map$Entry) it.next();
            iComputeFieldSize += computeFieldSize((f$a) map$Entry.getKey(), map$Entry.getValue());
        }
        return iComputeFieldSize;
    }

    public boolean hasField(FieldDescriptorType fielddescriptortype) {
        if (fielddescriptortype.isRepeated()) {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
        return this.f3429b.get(fielddescriptortype) != null;
    }

    public boolean isInitialized() {
        for (int i = 0; i < this.f3429b.getNumArrayEntries(); i++) {
            if (!d(this.f3429b.getArrayEntryAt(i))) {
                return false;
            }
        }
        Iterator it = this.f3429b.getOverflowEntries().iterator();
        while (it.hasNext()) {
            if (!d((Map$Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Map$Entry<FieldDescriptorType, Object>> iterator() {
        return this.d ? new i$c(this.f3429b.entrySet().iterator()) : this.f3429b.entrySet().iterator();
    }

    public void makeImmutable() {
        if (this.c) {
            return;
        }
        this.f3429b.makeImmutable();
        this.c = true;
    }

    public void mergeFrom(f<FieldDescriptorType> fVar) {
        for (int i = 0; i < fVar.f3429b.getNumArrayEntries(); i++) {
            e(fVar.f3429b.getArrayEntryAt(i));
        }
        Iterator it = fVar.f3429b.getOverflowEntries().iterator();
        while (it.hasNext()) {
            e((Map$Entry) it.next());
        }
    }

    public void setField(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.isRepeated()) {
            f(fielddescriptortype.getLiteType(), obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                f(fielddescriptortype.getLiteType(), it.next());
            }
            obj = arrayList;
        }
        if (obj instanceof i) {
            this.d = true;
        }
        this.f3429b.put(fielddescriptortype, obj);
    }

    public f<FieldDescriptorType> clone() {
        f<FieldDescriptorType> fVarNewFieldSet = newFieldSet();
        for (int i = 0; i < this.f3429b.getNumArrayEntries(); i++) {
            Map$Entry<K, Object> arrayEntryAt = this.f3429b.getArrayEntryAt(i);
            fVarNewFieldSet.setField((f$a) arrayEntryAt.getKey(), arrayEntryAt.getValue());
        }
        Iterator it = this.f3429b.getOverflowEntries().iterator();
        while (it.hasNext()) {
            Map$Entry map$Entry = (Map$Entry) it.next();
            fVarNewFieldSet.setField((f$a) map$Entry.getKey(), map$Entry.getValue());
        }
        fVarNewFieldSet.d = this.d;
        return fVarNewFieldSet;
    }

    public f(boolean z2) {
        int i = t.j;
        this.f3429b = new s(0);
        makeImmutable();
    }
}
