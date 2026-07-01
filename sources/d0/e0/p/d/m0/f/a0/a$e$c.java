package d0.e0.p.d.m0.f.a0;

import d0.e0.p.d.m0.i.c;
import d0.e0.p.d.m0.i.c$b;
import d0.e0.p.d.m0.i.d;
import d0.e0.p.d.m0.i.e;
import d0.e0.p.d.m0.i.g;
import d0.e0.p.d.m0.i.g$b;
import d0.e0.p.d.m0.i.n$a;
import d0.e0.p.d.m0.i.o;
import d0.e0.p.d.m0.i.p;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;

/* JADX INFO: compiled from: JvmProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$e$c extends g implements o {
    public static final a$e$c j;
    public static p<a$e$c> k = new a$e$c$a();
    private int bitField0_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private a$e$c$c operation_;
    private int predefinedIndex_;
    private int range_;
    private int replaceCharMemoizedSerializedSize;
    private List<Integer> replaceChar_;
    private Object string_;
    private int substringIndexMemoizedSerializedSize;
    private List<Integer> substringIndex_;
    private final c unknownFields;

    static {
        a$e$c a_e_c = new a$e$c();
        j = a_e_c;
        a_e_c.l();
    }

    public a$e$c(g$b g_b, a$a a_a) {
        super(g_b);
        this.substringIndexMemoizedSerializedSize = -1;
        this.replaceCharMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = g_b.getUnknownFields();
    }

    public static /* synthetic */ int a(a$e$c a_e_c, int i) {
        a_e_c.bitField0_ = i;
        return i;
    }

    public static /* synthetic */ c b(a$e$c a_e_c) {
        return a_e_c.unknownFields;
    }

    public static /* synthetic */ int c(a$e$c a_e_c, int i) {
        a_e_c.range_ = i;
        return i;
    }

    public static /* synthetic */ int d(a$e$c a_e_c, int i) {
        a_e_c.predefinedIndex_ = i;
        return i;
    }

    public static /* synthetic */ Object e(a$e$c a_e_c) {
        return a_e_c.string_;
    }

    public static /* synthetic */ Object f(a$e$c a_e_c, Object obj) {
        a_e_c.string_ = obj;
        return obj;
    }

    public static /* synthetic */ a$e$c$c g(a$e$c a_e_c, a$e$c$c a_e_c_c) {
        a_e_c.operation_ = a_e_c_c;
        return a_e_c_c;
    }

    public static a$e$c getDefaultInstance() {
        return j;
    }

    public static /* synthetic */ List h(a$e$c a_e_c) {
        return a_e_c.substringIndex_;
    }

    public static /* synthetic */ List i(a$e$c a_e_c, List list) {
        a_e_c.substringIndex_ = list;
        return list;
    }

    public static /* synthetic */ List j(a$e$c a_e_c) {
        return a_e_c.replaceChar_;
    }

    public static /* synthetic */ List k(a$e$c a_e_c, List list) {
        a_e_c.replaceChar_ = list;
        return list;
    }

    public static a$e$c$b newBuilder(a$e$c a_e_c) {
        return newBuilder().mergeFrom(a_e_c);
    }

    public a$e$c$c getOperation() {
        return this.operation_;
    }

    public int getPredefinedIndex() {
        return this.predefinedIndex_;
    }

    public int getRange() {
        return this.range_;
    }

    public int getReplaceCharCount() {
        return this.replaceChar_.size();
    }

    public List<Integer> getReplaceCharList() {
        return this.replaceChar_;
    }

    @Override // d0.e0.p.d.m0.i.n
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.range_) + 0 : 0;
        if ((this.bitField0_ & 2) == 2) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.predefinedIndex_);
        }
        if ((this.bitField0_ & 8) == 8) {
            iComputeInt32Size += CodedOutputStream.computeEnumSize(3, this.operation_.getNumber());
        }
        int iComputeInt32SizeNoTag = 0;
        for (int i2 = 0; i2 < this.substringIndex_.size(); i2++) {
            iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(this.substringIndex_.get(i2).intValue());
        }
        int iComputeInt32SizeNoTag2 = iComputeInt32Size + iComputeInt32SizeNoTag;
        if (!getSubstringIndexList().isEmpty()) {
            iComputeInt32SizeNoTag2 = iComputeInt32SizeNoTag2 + 1 + CodedOutputStream.computeInt32SizeNoTag(iComputeInt32SizeNoTag);
        }
        this.substringIndexMemoizedSerializedSize = iComputeInt32SizeNoTag;
        int iComputeInt32SizeNoTag3 = 0;
        for (int i3 = 0; i3 < this.replaceChar_.size(); i3++) {
            iComputeInt32SizeNoTag3 += CodedOutputStream.computeInt32SizeNoTag(this.replaceChar_.get(i3).intValue());
        }
        int iComputeBytesSize = iComputeInt32SizeNoTag2 + iComputeInt32SizeNoTag3;
        if (!getReplaceCharList().isEmpty()) {
            iComputeBytesSize = iComputeBytesSize + 1 + CodedOutputStream.computeInt32SizeNoTag(iComputeInt32SizeNoTag3);
        }
        this.replaceCharMemoizedSerializedSize = iComputeInt32SizeNoTag3;
        if ((this.bitField0_ & 4) == 4) {
            iComputeBytesSize += CodedOutputStream.computeBytesSize(6, getStringBytes());
        }
        int size = this.unknownFields.size() + iComputeBytesSize;
        this.memoizedSerializedSize = size;
        return size;
    }

    public String getString() {
        Object obj = this.string_;
        if (obj instanceof String) {
            return (String) obj;
        }
        c cVar = (c) obj;
        String stringUtf8 = cVar.toStringUtf8();
        if (cVar.isValidUtf8()) {
            this.string_ = stringUtf8;
        }
        return stringUtf8;
    }

    public c getStringBytes() {
        Object obj = this.string_;
        if (!(obj instanceof String)) {
            return (c) obj;
        }
        c cVarCopyFromUtf8 = c.copyFromUtf8((String) obj);
        this.string_ = cVarCopyFromUtf8;
        return cVarCopyFromUtf8;
    }

    public int getSubstringIndexCount() {
        return this.substringIndex_.size();
    }

    public List<Integer> getSubstringIndexList() {
        return this.substringIndex_;
    }

    public boolean hasOperation() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasPredefinedIndex() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasRange() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasString() {
        return (this.bitField0_ & 4) == 4;
    }

    @Override // d0.e0.p.d.m0.i.o
    public final boolean isInitialized() {
        byte b2 = this.memoizedIsInitialized;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    public final void l() {
        this.range_ = 1;
        this.predefinedIndex_ = 0;
        this.string_ = "";
        this.operation_ = a$e$c$c.NONE;
        this.substringIndex_ = Collections.emptyList();
        this.replaceChar_ = Collections.emptyList();
    }

    @Override // d0.e0.p.d.m0.i.n
    public /* bridge */ /* synthetic */ n$a newBuilderForType() {
        return newBuilderForType();
    }

    @Override // d0.e0.p.d.m0.i.n
    public /* bridge */ /* synthetic */ n$a toBuilder() {
        return toBuilder();
    }

    @Override // d0.e0.p.d.m0.i.n
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(1, this.range_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(2, this.predefinedIndex_);
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeEnum(3, this.operation_.getNumber());
        }
        if (getSubstringIndexList().size() > 0) {
            codedOutputStream.writeRawVarint32(34);
            codedOutputStream.writeRawVarint32(this.substringIndexMemoizedSerializedSize);
        }
        for (int i = 0; i < this.substringIndex_.size(); i++) {
            codedOutputStream.writeInt32NoTag(this.substringIndex_.get(i).intValue());
        }
        if (getReplaceCharList().size() > 0) {
            codedOutputStream.writeRawVarint32(42);
            codedOutputStream.writeRawVarint32(this.replaceCharMemoizedSerializedSize);
        }
        for (int i2 = 0; i2 < this.replaceChar_.size(); i2++) {
            codedOutputStream.writeInt32NoTag(this.replaceChar_.get(i2).intValue());
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeBytes(6, getStringBytes());
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static a$e$c$b newBuilder() {
        return new a$e$c$b();
    }

    @Override // d0.e0.p.d.m0.i.n
    public a$e$c$b newBuilderForType() {
        return newBuilder();
    }

    @Override // d0.e0.p.d.m0.i.n
    public a$e$c$b toBuilder() {
        return newBuilder(this);
    }

    public a$e$c() {
        this.substringIndexMemoizedSerializedSize = -1;
        this.replaceCharMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = c.j;
    }

    public a$e$c(d dVar, e eVar, a$a a_a) throws InvalidProtocolBufferException {
        this.substringIndexMemoizedSerializedSize = -1;
        this.replaceCharMemoizedSerializedSize = -1;
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        l();
        c$b c_bNewOutput = c.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(c_bNewOutput, 1);
        boolean z2 = false;
        int i = 0;
        while (!z2) {
            try {
                try {
                    int tag = dVar.readTag();
                    if (tag != 0) {
                        if (tag == 8) {
                            this.bitField0_ |= 1;
                            this.range_ = dVar.readInt32();
                        } else if (tag == 16) {
                            this.bitField0_ |= 2;
                            this.predefinedIndex_ = dVar.readInt32();
                        } else if (tag == 24) {
                            int i2 = dVar.readEnum();
                            a$e$c$c a_e_c_cValueOf = a$e$c$c.valueOf(i2);
                            if (a_e_c_cValueOf == null) {
                                codedOutputStreamNewInstance.writeRawVarint32(tag);
                                codedOutputStreamNewInstance.writeRawVarint32(i2);
                            } else {
                                this.bitField0_ |= 8;
                                this.operation_ = a_e_c_cValueOf;
                            }
                        } else if (tag == 32) {
                            if ((i & 16) != 16) {
                                this.substringIndex_ = new ArrayList();
                                i |= 16;
                            }
                            this.substringIndex_.add(Integer.valueOf(dVar.readInt32()));
                        } else if (tag == 34) {
                            int iPushLimit = dVar.pushLimit(dVar.readRawVarint32());
                            if ((i & 16) != 16 && dVar.getBytesUntilLimit() > 0) {
                                this.substringIndex_ = new ArrayList();
                                i |= 16;
                            }
                            while (dVar.getBytesUntilLimit() > 0) {
                                this.substringIndex_.add(Integer.valueOf(dVar.readInt32()));
                            }
                            dVar.popLimit(iPushLimit);
                        } else if (tag == 40) {
                            if ((i & 32) != 32) {
                                this.replaceChar_ = new ArrayList();
                                i |= 32;
                            }
                            this.replaceChar_.add(Integer.valueOf(dVar.readInt32()));
                        } else if (tag == 42) {
                            int iPushLimit2 = dVar.pushLimit(dVar.readRawVarint32());
                            if ((i & 32) != 32 && dVar.getBytesUntilLimit() > 0) {
                                this.replaceChar_ = new ArrayList();
                                i |= 32;
                            }
                            while (dVar.getBytesUntilLimit() > 0) {
                                this.replaceChar_.add(Integer.valueOf(dVar.readInt32()));
                            }
                            dVar.popLimit(iPushLimit2);
                        } else if (tag != 50) {
                            if (!dVar.skipField(tag, codedOutputStreamNewInstance)) {
                            }
                        } else {
                            c bytes = dVar.readBytes();
                            this.bitField0_ |= 4;
                            this.string_ = bytes;
                        }
                    }
                    z2 = true;
                } catch (Throwable th) {
                    if ((i & 16) == 16) {
                        this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
                    }
                    if ((i & 32) == 32) {
                        this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
                    }
                    try {
                        codedOutputStreamNewInstance.flush();
                    } catch (IOException unused) {
                    } finally {
                        this.unknownFields = c_bNewOutput.toByteString();
                    }
                    throw th;
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e2) {
                throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
            }
        }
        if ((i & 16) == 16) {
            this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
        }
        if ((i & 32) == 32) {
            this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
        }
        try {
            codedOutputStreamNewInstance.flush();
        } catch (IOException unused2) {
        } finally {
            this.unknownFields = c_bNewOutput.toByteString();
        }
    }
}
