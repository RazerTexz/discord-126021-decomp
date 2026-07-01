package d0.e0.p.d.m0.f;

import d0.e0.p.d.m0.f.t;
import d0.e0.p.d.m0.f.w;
import d0.e0.p.d.m0.i.AbstractParser;
import d0.e0.p.d.m0.i.ByteString3;
import d0.e0.p.d.m0.i.CodedInputStream;
import d0.e0.p.d.m0.i.ExtensionRegistryLite;
import d0.e0.p.d.m0.i.GeneratedMessageLite;
import d0.e0.p.d.m0.i.MessageLiteOrBuilder;
import d0.e0.p.d.m0.i.Parser2;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends GeneratedMessageLite.d<l> implements MessageLiteOrBuilder {
    public static final l j;
    public static Parser2<l> k = new a();
    private int bitField0_;
    private List<i> function_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<n> property_;
    private List<r> typeAlias_;
    private t typeTable_;
    private final ByteString3 unknownFields;
    private w versionRequirementTable_;

    /* JADX INFO: compiled from: ProtoBuf.java */
    public static class a extends AbstractParser<l> {
        @Override // d0.e0.p.d.m0.i.Parser2
        public l parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new l(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends GeneratedMessageLite.c<l, b> implements MessageLiteOrBuilder {
        public int m;
        public List<i> n = Collections.emptyList();
        public List<n> o = Collections.emptyList();
        public List<r> p = Collections.emptyList();
        public t q = t.getDefaultInstance();
        public w r = w.getDefaultInstance();

        public l buildPartial() {
            l lVar = new l(this, null);
            int i = this.m;
            if ((i & 1) == 1) {
                this.n = Collections.unmodifiableList(this.n);
                this.m &= -2;
            }
            lVar.function_ = this.n;
            if ((this.m & 2) == 2) {
                this.o = Collections.unmodifiableList(this.o);
                this.m &= -3;
            }
            lVar.property_ = this.o;
            if ((this.m & 4) == 4) {
                this.p = Collections.unmodifiableList(this.p);
                this.m &= -5;
            }
            lVar.typeAlias_ = this.p;
            int i2 = (i & 8) != 8 ? 0 : 1;
            lVar.typeTable_ = this.q;
            if ((i & 16) == 16) {
                i2 |= 2;
            }
            lVar.versionRequirementTable_ = this.r;
            lVar.bitField0_ = i2;
            return lVar;
        }

        public b mergeTypeTable(t tVar) {
            if ((this.m & 8) != 8 || this.q == t.getDefaultInstance()) {
                this.q = tVar;
            } else {
                this.q = t.newBuilder(this.q).mergeFrom(tVar).buildPartial();
            }
            this.m |= 8;
            return this;
        }

        public b mergeVersionRequirementTable(w wVar) {
            if ((this.m & 16) != 16 || this.r == w.getDefaultInstance()) {
                this.r = wVar;
            } else {
                this.r = w.newBuilder(this.r).mergeFrom(wVar).buildPartial();
            }
            this.m |= 16;
            return this;
        }

        @Override // d0.e0.p.d.m0.i.MessageLite.a
        public l build() {
            l lVarBuildPartial = buildPartial();
            if (lVarBuildPartial.isInitialized()) {
                return lVarBuildPartial;
            }
            throw new UninitializedMessageException(lVarBuildPartial);
        }

        @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
        /* JADX INFO: renamed from: clone */
        public b mo88clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
        public b mergeFrom(l lVar) {
            if (lVar == l.getDefaultInstance()) {
                return this;
            }
            if (!lVar.function_.isEmpty()) {
                if (this.n.isEmpty()) {
                    this.n = lVar.function_;
                    this.m &= -2;
                } else {
                    if ((this.m & 1) != 1) {
                        this.n = new ArrayList(this.n);
                        this.m |= 1;
                    }
                    this.n.addAll(lVar.function_);
                }
            }
            if (!lVar.property_.isEmpty()) {
                if (this.o.isEmpty()) {
                    this.o = lVar.property_;
                    this.m &= -3;
                } else {
                    if ((this.m & 2) != 2) {
                        this.o = new ArrayList(this.o);
                        this.m |= 2;
                    }
                    this.o.addAll(lVar.property_);
                }
            }
            if (!lVar.typeAlias_.isEmpty()) {
                if (this.p.isEmpty()) {
                    this.p = lVar.typeAlias_;
                    this.m &= -5;
                } else {
                    if ((this.m & 4) != 4) {
                        this.p = new ArrayList(this.p);
                        this.m |= 4;
                    }
                    this.p.addAll(lVar.typeAlias_);
                }
            }
            if (lVar.hasTypeTable()) {
                mergeTypeTable(lVar.getTypeTable());
            }
            if (lVar.hasVersionRequirementTable()) {
                mergeVersionRequirementTable(lVar.getVersionRequirementTable());
            }
            b(lVar);
            setUnknownFields(getUnknownFields().concat(lVar.unknownFields));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // d0.e0.p.d.m0.i.AbstractMessageLite.a, d0.e0.p.d.m0.i.MessageLite.a
        public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            l lVar = null;
            try {
                try {
                    l partialFrom = l.k.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    l lVar2 = (l) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        lVar = lVar2;
                        if (lVar != null) {
                            mergeFrom(lVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (lVar != null) {
                    mergeFrom(lVar);
                }
                throw th;
            }
        }
    }

    static {
        l lVar = new l();
        j = lVar;
        lVar.r();
    }

    public l(GeneratedMessageLite.c cVar, d0.e0.p.d.m0.f.a aVar) {
        super(cVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = cVar.getUnknownFields();
    }

    public static l getDefaultInstance() {
        return j;
    }

    public static b newBuilder(l lVar) {
        return newBuilder().mergeFrom(lVar);
    }

    public static l parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (l) ((AbstractParser) k).m90parseFrom(inputStream, extensionRegistryLite);
    }

    public i getFunction(int i) {
        return this.function_.get(i);
    }

    public int getFunctionCount() {
        return this.function_.size();
    }

    public List<i> getFunctionList() {
        return this.function_;
    }

    public n getProperty(int i) {
        return this.property_.get(i);
    }

    public int getPropertyCount() {
        return this.property_.size();
    }

    public List<n> getPropertyList() {
        return this.property_;
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeMessageSize = 0;
        for (int i2 = 0; i2 < this.function_.size(); i2++) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(3, this.function_.get(i2));
        }
        for (int i3 = 0; i3 < this.property_.size(); i3++) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(4, this.property_.get(i3));
        }
        for (int i4 = 0; i4 < this.typeAlias_.size(); i4++) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(5, this.typeAlias_.get(i4));
        }
        if ((this.bitField0_ & 1) == 1) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(30, this.typeTable_);
        }
        if ((this.bitField0_ & 2) == 2) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(32, this.versionRequirementTable_);
        }
        int size = this.unknownFields.size() + c() + iComputeMessageSize;
        this.memoizedSerializedSize = size;
        return size;
    }

    public r getTypeAlias(int i) {
        return this.typeAlias_.get(i);
    }

    public int getTypeAliasCount() {
        return this.typeAlias_.size();
    }

    public List<r> getTypeAliasList() {
        return this.typeAlias_;
    }

    public t getTypeTable() {
        return this.typeTable_;
    }

    public w getVersionRequirementTable() {
        return this.versionRequirementTable_;
    }

    public boolean hasTypeTable() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasVersionRequirementTable() {
        return (this.bitField0_ & 2) == 2;
    }

    @Override // d0.e0.p.d.m0.i.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.memoizedIsInitialized;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        for (int i = 0; i < getFunctionCount(); i++) {
            if (!getFunction(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i2 = 0; i2 < getPropertyCount(); i2++) {
            if (!getProperty(i2).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i3 = 0; i3 < getTypeAliasCount(); i3++) {
            if (!getTypeAlias(i3).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (hasTypeTable() && !getTypeTable().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        if (b()) {
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }
        this.memoizedIsInitialized = (byte) 0;
        return false;
    }

    public final void r() {
        this.function_ = Collections.emptyList();
        this.property_ = Collections.emptyList();
        this.typeAlias_ = Collections.emptyList();
        this.typeTable_ = t.getDefaultInstance();
        this.versionRequirementTable_ = w.getDefaultInstance();
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        GeneratedMessageLite.d<MessageType>.a aVarE = e();
        for (int i = 0; i < this.function_.size(); i++) {
            codedOutputStream.writeMessage(3, this.function_.get(i));
        }
        for (int i2 = 0; i2 < this.property_.size(); i2++) {
            codedOutputStream.writeMessage(4, this.property_.get(i2));
        }
        for (int i3 = 0; i3 < this.typeAlias_.size(); i3++) {
            codedOutputStream.writeMessage(5, this.typeAlias_.get(i3));
        }
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeMessage(30, this.typeTable_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeMessage(32, this.versionRequirementTable_);
        }
        aVarE.writeUntil(200, codedOutputStream);
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static b newBuilder() {
        return new b();
    }

    @Override // d0.e0.p.d.m0.i.MessageLiteOrBuilder
    public l getDefaultInstanceForType() {
        return j;
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public b newBuilderForType() {
        return newBuilder();
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public b toBuilder() {
        return newBuilder(this);
    }

    public l() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString3.j;
    }

    public l(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, d0.e0.p.d.m0.f.a aVar) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        r();
        ByteString3.b bVarNewOutput = ByteString3.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        boolean z2 = false;
        int i = 0;
        while (!z2) {
            try {
                try {
                    try {
                        int tag = codedInputStream.readTag();
                        if (tag != 0) {
                            if (tag == 26) {
                                if ((i & 1) != 1) {
                                    this.function_ = new ArrayList();
                                    i |= 1;
                                }
                                this.function_.add((i) codedInputStream.readMessage(i.k, extensionRegistryLite));
                            } else if (tag == 34) {
                                if ((i & 2) != 2) {
                                    this.property_ = new ArrayList();
                                    i |= 2;
                                }
                                this.property_.add((n) codedInputStream.readMessage(n.k, extensionRegistryLite));
                            } else if (tag != 42) {
                                if (tag == 242) {
                                    t.b builder = (this.bitField0_ & 1) == 1 ? this.typeTable_.toBuilder() : null;
                                    t tVar = (t) codedInputStream.readMessage(t.k, extensionRegistryLite);
                                    this.typeTable_ = tVar;
                                    if (builder != null) {
                                        builder.mergeFrom(tVar);
                                        this.typeTable_ = builder.buildPartial();
                                    }
                                    this.bitField0_ |= 1;
                                } else if (tag != 258) {
                                    if (!f(codedInputStream, codedOutputStreamNewInstance, extensionRegistryLite, tag)) {
                                    }
                                } else {
                                    w.b builder2 = (this.bitField0_ & 2) == 2 ? this.versionRequirementTable_.toBuilder() : null;
                                    w wVar = (w) codedInputStream.readMessage(w.k, extensionRegistryLite);
                                    this.versionRequirementTable_ = wVar;
                                    if (builder2 != null) {
                                        builder2.mergeFrom(wVar);
                                        this.versionRequirementTable_ = builder2.buildPartial();
                                    }
                                    this.bitField0_ |= 2;
                                }
                            } else {
                                if ((i & 4) != 4) {
                                    this.typeAlias_ = new ArrayList();
                                    i |= 4;
                                }
                                this.typeAlias_.add((r) codedInputStream.readMessage(r.k, extensionRegistryLite));
                            }
                        }
                        z2 = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    }
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                }
            } catch (Throwable th) {
                if ((i & 1) == 1) {
                    this.function_ = Collections.unmodifiableList(this.function_);
                }
                if ((i & 2) == 2) {
                    this.property_ = Collections.unmodifiableList(this.property_);
                }
                if ((i & 4) == 4) {
                    this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                }
                try {
                    codedOutputStreamNewInstance.flush();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.unknownFields = bVarNewOutput.toByteString();
                    throw th2;
                }
                this.unknownFields = bVarNewOutput.toByteString();
                d();
                throw th;
            }
        }
        if ((i & 1) == 1) {
            this.function_ = Collections.unmodifiableList(this.function_);
        }
        if ((i & 2) == 2) {
            this.property_ = Collections.unmodifiableList(this.property_);
        }
        if ((i & 4) == 4) {
            this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
        }
        try {
            codedOutputStreamNewInstance.flush();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.unknownFields = bVarNewOutput.toByteString();
            throw th3;
        }
        this.unknownFields = bVarNewOutput.toByteString();
        d();
    }
}
