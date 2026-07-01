package d0.e0.p.d.m0.f;

import d0.e0.p.d.m0.f.q;
import d0.e0.p.d.m0.i.AbstractParser;
import d0.e0.p.d.m0.i.ByteString3;
import d0.e0.p.d.m0.i.CodedInputStream;
import d0.e0.p.d.m0.i.ExtensionRegistryLite;
import d0.e0.p.d.m0.i.GeneratedMessageLite;
import d0.e0.p.d.m0.i.Internal;
import d0.e0.p.d.m0.i.MessageLiteOrBuilder;
import d0.e0.p.d.m0.i.Parser2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static final h j;
    public static Parser2<h> k = new a();
    private List<h> andArgument_;
    private int bitField0_;
    private c constantValue_;
    private int flags_;
    private int isInstanceTypeId_;
    private q isInstanceType_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<h> orArgument_;
    private final ByteString3 unknownFields;
    private int valueParameterReference_;

    /* JADX INFO: compiled from: ProtoBuf.java */
    public static class a extends AbstractParser<h> {
        @Override // d0.e0.p.d.m0.i.Parser2
        public h parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new h(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends GeneratedMessageLite.b<h, b> implements MessageLiteOrBuilder {
        public int k;
        public int l;
        public int m;
        public int p;
        public c n = c.TRUE;
        public q o = q.getDefaultInstance();
        public List<h> q = Collections.emptyList();
        public List<h> r = Collections.emptyList();

        public h buildPartial() {
            h hVar = new h(this, null);
            int i = this.k;
            int i2 = (i & 1) != 1 ? 0 : 1;
            hVar.flags_ = this.l;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            hVar.valueParameterReference_ = this.m;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            hVar.constantValue_ = this.n;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            hVar.isInstanceType_ = this.o;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            hVar.isInstanceTypeId_ = this.p;
            if ((this.k & 32) == 32) {
                this.q = Collections.unmodifiableList(this.q);
                this.k &= -33;
            }
            hVar.andArgument_ = this.q;
            if ((this.k & 64) == 64) {
                this.r = Collections.unmodifiableList(this.r);
                this.k &= -65;
            }
            hVar.orArgument_ = this.r;
            hVar.bitField0_ = i2;
            return hVar;
        }

        public b mergeIsInstanceType(q qVar) {
            if ((this.k & 8) != 8 || this.o == q.getDefaultInstance()) {
                this.o = qVar;
            } else {
                this.o = q.newBuilder(this.o).mergeFrom(qVar).buildPartial();
            }
            this.k |= 8;
            return this;
        }

        public b setConstantValue(c cVar) {
            Objects.requireNonNull(cVar);
            this.k |= 4;
            this.n = cVar;
            return this;
        }

        public b setFlags(int i) {
            this.k |= 1;
            this.l = i;
            return this;
        }

        public b setIsInstanceTypeId(int i) {
            this.k |= 16;
            this.p = i;
            return this;
        }

        public b setValueParameterReference(int i) {
            this.k |= 2;
            this.m = i;
            return this;
        }

        @Override // d0.e0.p.d.m0.i.MessageLite.a
        public h build() {
            h hVarBuildPartial = buildPartial();
            if (hVarBuildPartial.isInitialized()) {
                return hVarBuildPartial;
            }
            throw new UninitializedMessageException(hVarBuildPartial);
        }

        @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
        /* JADX INFO: renamed from: clone */
        public b mo88clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
        public b mergeFrom(h hVar) {
            if (hVar == h.getDefaultInstance()) {
                return this;
            }
            if (hVar.hasFlags()) {
                setFlags(hVar.getFlags());
            }
            if (hVar.hasValueParameterReference()) {
                setValueParameterReference(hVar.getValueParameterReference());
            }
            if (hVar.hasConstantValue()) {
                setConstantValue(hVar.getConstantValue());
            }
            if (hVar.hasIsInstanceType()) {
                mergeIsInstanceType(hVar.getIsInstanceType());
            }
            if (hVar.hasIsInstanceTypeId()) {
                setIsInstanceTypeId(hVar.getIsInstanceTypeId());
            }
            if (!hVar.andArgument_.isEmpty()) {
                if (this.q.isEmpty()) {
                    this.q = hVar.andArgument_;
                    this.k &= -33;
                } else {
                    if ((this.k & 32) != 32) {
                        this.q = new ArrayList(this.q);
                        this.k |= 32;
                    }
                    this.q.addAll(hVar.andArgument_);
                }
            }
            if (!hVar.orArgument_.isEmpty()) {
                if (this.r.isEmpty()) {
                    this.r = hVar.orArgument_;
                    this.k &= -65;
                } else {
                    if ((this.k & 64) != 64) {
                        this.r = new ArrayList(this.r);
                        this.k |= 64;
                    }
                    this.r.addAll(hVar.orArgument_);
                }
            }
            setUnknownFields(getUnknownFields().concat(hVar.unknownFields));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // d0.e0.p.d.m0.i.AbstractMessageLite.a, d0.e0.p.d.m0.i.MessageLite.a
        public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            h hVar = null;
            try {
                try {
                    h partialFrom = h.k.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    h hVar2 = (h) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        hVar = hVar2;
                        if (hVar != null) {
                            mergeFrom(hVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (hVar != null) {
                    mergeFrom(hVar);
                }
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: ProtoBuf.java */
    public enum c implements Internal.a {
        TRUE(0),
        FALSE(1),
        NULL(2);

        private final int value;

        c(int i) {
            this.value = i;
        }

        @Override // d0.e0.p.d.m0.i.Internal.a
        public final int getNumber() {
            return this.value;
        }

        public static c valueOf(int i) {
            if (i == 0) {
                return TRUE;
            }
            if (i == 1) {
                return FALSE;
            }
            if (i != 2) {
                return null;
            }
            return NULL;
        }
    }

    static {
        h hVar = new h();
        j = hVar;
        hVar.l();
    }

    public h(GeneratedMessageLite.b bVar, d0.e0.p.d.m0.f.a aVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = bVar.getUnknownFields();
    }

    public static h getDefaultInstance() {
        return j;
    }

    public static b newBuilder(h hVar) {
        return newBuilder().mergeFrom(hVar);
    }

    public h getAndArgument(int i) {
        return this.andArgument_.get(i);
    }

    public int getAndArgumentCount() {
        return this.andArgument_.size();
    }

    public c getConstantValue() {
        return this.constantValue_;
    }

    public int getFlags() {
        return this.flags_;
    }

    public q getIsInstanceType() {
        return this.isInstanceType_;
    }

    public int getIsInstanceTypeId() {
        return this.isInstanceTypeId_;
    }

    public h getOrArgument(int i) {
        return this.orArgument_.get(i);
    }

    public int getOrArgumentCount() {
        return this.orArgument_.size();
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeInt32Size(1, this.flags_) + 0 : 0;
        if ((this.bitField0_ & 2) == 2) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.valueParameterReference_);
        }
        if ((this.bitField0_ & 4) == 4) {
            iComputeInt32Size += CodedOutputStream.computeEnumSize(3, this.constantValue_.getNumber());
        }
        if ((this.bitField0_ & 8) == 8) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(4, this.isInstanceType_);
        }
        if ((this.bitField0_ & 16) == 16) {
            iComputeInt32Size += CodedOutputStream.computeInt32Size(5, this.isInstanceTypeId_);
        }
        for (int i2 = 0; i2 < this.andArgument_.size(); i2++) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(6, this.andArgument_.get(i2));
        }
        for (int i3 = 0; i3 < this.orArgument_.size(); i3++) {
            iComputeInt32Size += CodedOutputStream.computeMessageSize(7, this.orArgument_.get(i3));
        }
        int size = this.unknownFields.size() + iComputeInt32Size;
        this.memoizedSerializedSize = size;
        return size;
    }

    public int getValueParameterReference() {
        return this.valueParameterReference_;
    }

    public boolean hasConstantValue() {
        return (this.bitField0_ & 4) == 4;
    }

    public boolean hasFlags() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasIsInstanceType() {
        return (this.bitField0_ & 8) == 8;
    }

    public boolean hasIsInstanceTypeId() {
        return (this.bitField0_ & 16) == 16;
    }

    public boolean hasValueParameterReference() {
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
        if (hasIsInstanceType() && !getIsInstanceType().isInitialized()) {
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }
        for (int i = 0; i < getAndArgumentCount(); i++) {
            if (!getAndArgument(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        for (int i2 = 0; i2 < getOrArgumentCount(); i2++) {
            if (!getOrArgument(i2).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    public final void l() {
        this.flags_ = 0;
        this.valueParameterReference_ = 0;
        this.constantValue_ = c.TRUE;
        this.isInstanceType_ = q.getDefaultInstance();
        this.isInstanceTypeId_ = 0;
        this.andArgument_ = Collections.emptyList();
        this.orArgument_ = Collections.emptyList();
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeInt32(1, this.flags_);
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeInt32(2, this.valueParameterReference_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeEnum(3, this.constantValue_.getNumber());
        }
        if ((this.bitField0_ & 8) == 8) {
            codedOutputStream.writeMessage(4, this.isInstanceType_);
        }
        if ((this.bitField0_ & 16) == 16) {
            codedOutputStream.writeInt32(5, this.isInstanceTypeId_);
        }
        for (int i = 0; i < this.andArgument_.size(); i++) {
            codedOutputStream.writeMessage(6, this.andArgument_.get(i));
        }
        for (int i2 = 0; i2 < this.orArgument_.size(); i2++) {
            codedOutputStream.writeMessage(7, this.orArgument_.get(i2));
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static b newBuilder() {
        return new b();
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public b newBuilderForType() {
        return newBuilder();
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public b toBuilder() {
        return newBuilder(this);
    }

    public h() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString3.j;
    }

    public h(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, d0.e0.p.d.m0.f.a aVar) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        l();
        ByteString3.b bVarNewOutput = ByteString3.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        boolean z2 = false;
        int i = 0;
        while (!z2) {
            try {
                try {
                    int tag = codedInputStream.readTag();
                    if (tag != 0) {
                        if (tag == 8) {
                            this.bitField0_ |= 1;
                            this.flags_ = codedInputStream.readInt32();
                        } else if (tag == 16) {
                            this.bitField0_ |= 2;
                            this.valueParameterReference_ = codedInputStream.readInt32();
                        } else if (tag == 24) {
                            int i2 = codedInputStream.readEnum();
                            c cVarValueOf = c.valueOf(i2);
                            if (cVarValueOf == null) {
                                codedOutputStreamNewInstance.writeRawVarint32(tag);
                                codedOutputStreamNewInstance.writeRawVarint32(i2);
                            } else {
                                this.bitField0_ |= 4;
                                this.constantValue_ = cVarValueOf;
                            }
                        } else if (tag == 34) {
                            q.c builder = (this.bitField0_ & 8) == 8 ? this.isInstanceType_.toBuilder() : null;
                            q qVar = (q) codedInputStream.readMessage(q.k, extensionRegistryLite);
                            this.isInstanceType_ = qVar;
                            if (builder != null) {
                                builder.mergeFrom(qVar);
                                this.isInstanceType_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 8;
                        } else if (tag == 40) {
                            this.bitField0_ |= 16;
                            this.isInstanceTypeId_ = codedInputStream.readInt32();
                        } else if (tag == 50) {
                            if ((i & 32) != 32) {
                                this.andArgument_ = new ArrayList();
                                i |= 32;
                            }
                            this.andArgument_.add((h) codedInputStream.readMessage(k, extensionRegistryLite));
                        } else if (tag != 58) {
                            if (!codedInputStream.skipField(tag, codedOutputStreamNewInstance)) {
                            }
                        } else {
                            if ((i & 64) != 64) {
                                this.orArgument_ = new ArrayList();
                                i |= 64;
                            }
                            this.orArgument_.add((h) codedInputStream.readMessage(k, extensionRegistryLite));
                        }
                    }
                    z2 = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                }
            } catch (Throwable th) {
                if ((i & 32) == 32) {
                    this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
                }
                if ((i & 64) == 64) {
                    this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
                }
                try {
                    codedOutputStreamNewInstance.flush();
                } catch (IOException unused) {
                } finally {
                    this.unknownFields = bVarNewOutput.toByteString();
                }
                throw th;
            }
        }
        if ((i & 32) == 32) {
            this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
        }
        if ((i & 64) == 64) {
            this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
        }
        try {
            codedOutputStreamNewInstance.flush();
        } catch (IOException unused2) {
        } finally {
            this.unknownFields = bVarNewOutput.toByteString();
        }
    }
}
