package d0.e0.p.d.m0.f;

import d0.e0.p.d.m0.f.h;
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
public final class f extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static final f j;
    public static Parser2<f> k = new a();
    private int bitField0_;
    private h conclusionOfConditionalEffect_;
    private List<h> effectConstructorArgument_;
    private c effectType_;
    private d kind_;
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private final ByteString3 unknownFields;

    /* JADX INFO: compiled from: ProtoBuf.java */
    public static class a extends AbstractParser<f> {
        @Override // d0.e0.p.d.m0.i.Parser2
        public f parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new f(codedInputStream, extensionRegistryLite, null);
        }
    }

    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends GeneratedMessageLite.b<f, b> implements MessageLiteOrBuilder {
        public int k;
        public c l = c.RETURNS_CONSTANT;
        public List<h> m = Collections.emptyList();
        public h n = h.getDefaultInstance();
        public d o = d.AT_MOST_ONCE;

        public f buildPartial() {
            f fVar = new f(this, null);
            int i = this.k;
            int i2 = (i & 1) != 1 ? 0 : 1;
            fVar.effectType_ = this.l;
            if ((this.k & 2) == 2) {
                this.m = Collections.unmodifiableList(this.m);
                this.k &= -3;
            }
            fVar.effectConstructorArgument_ = this.m;
            if ((i & 4) == 4) {
                i2 |= 2;
            }
            fVar.conclusionOfConditionalEffect_ = this.n;
            if ((i & 8) == 8) {
                i2 |= 4;
            }
            fVar.kind_ = this.o;
            fVar.bitField0_ = i2;
            return fVar;
        }

        public b mergeConclusionOfConditionalEffect(h hVar) {
            if ((this.k & 4) != 4 || this.n == h.getDefaultInstance()) {
                this.n = hVar;
            } else {
                this.n = h.newBuilder(this.n).mergeFrom(hVar).buildPartial();
            }
            this.k |= 4;
            return this;
        }

        public b setEffectType(c cVar) {
            Objects.requireNonNull(cVar);
            this.k |= 1;
            this.l = cVar;
            return this;
        }

        public b setKind(d dVar) {
            Objects.requireNonNull(dVar);
            this.k |= 8;
            this.o = dVar;
            return this;
        }

        @Override // d0.e0.p.d.m0.i.MessageLite.a
        public f build() {
            f fVarBuildPartial = buildPartial();
            if (fVarBuildPartial.isInitialized()) {
                return fVarBuildPartial;
            }
            throw new UninitializedMessageException(fVarBuildPartial);
        }

        @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
        /* JADX INFO: renamed from: clone */
        public b mo88clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // d0.e0.p.d.m0.i.GeneratedMessageLite.b
        public b mergeFrom(f fVar) {
            if (fVar == f.getDefaultInstance()) {
                return this;
            }
            if (fVar.hasEffectType()) {
                setEffectType(fVar.getEffectType());
            }
            if (!fVar.effectConstructorArgument_.isEmpty()) {
                if (this.m.isEmpty()) {
                    this.m = fVar.effectConstructorArgument_;
                    this.k &= -3;
                } else {
                    if ((this.k & 2) != 2) {
                        this.m = new ArrayList(this.m);
                        this.k |= 2;
                    }
                    this.m.addAll(fVar.effectConstructorArgument_);
                }
            }
            if (fVar.hasConclusionOfConditionalEffect()) {
                mergeConclusionOfConditionalEffect(fVar.getConclusionOfConditionalEffect());
            }
            if (fVar.hasKind()) {
                setKind(fVar.getKind());
            }
            setUnknownFields(getUnknownFields().concat(fVar.unknownFields));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // d0.e0.p.d.m0.i.AbstractMessageLite.a, d0.e0.p.d.m0.i.MessageLite.a
        public b mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
            f fVar = null;
            try {
                try {
                    f partialFrom = f.k.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    f fVar2 = (f) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        fVar = fVar2;
                        if (fVar != null) {
                            mergeFrom(fVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (fVar != null) {
                    mergeFrom(fVar);
                }
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: ProtoBuf.java */
    public enum c implements Internal.a {
        RETURNS_CONSTANT(0),
        CALLS(1),
        RETURNS_NOT_NULL(2);

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
                return RETURNS_CONSTANT;
            }
            if (i == 1) {
                return CALLS;
            }
            if (i != 2) {
                return null;
            }
            return RETURNS_NOT_NULL;
        }
    }

    /* JADX INFO: compiled from: ProtoBuf.java */
    public enum d implements Internal.a {
        AT_MOST_ONCE(0),
        EXACTLY_ONCE(1),
        AT_LEAST_ONCE(2);

        private final int value;

        d(int i) {
            this.value = i;
        }

        @Override // d0.e0.p.d.m0.i.Internal.a
        public final int getNumber() {
            return this.value;
        }

        public static d valueOf(int i) {
            if (i == 0) {
                return AT_MOST_ONCE;
            }
            if (i == 1) {
                return EXACTLY_ONCE;
            }
            if (i != 2) {
                return null;
            }
            return AT_LEAST_ONCE;
        }
    }

    static {
        f fVar = new f();
        j = fVar;
        fVar.h();
    }

    public f(GeneratedMessageLite.b bVar, d0.e0.p.d.m0.f.a aVar) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = bVar.getUnknownFields();
    }

    public static f getDefaultInstance() {
        return j;
    }

    public static b newBuilder(f fVar) {
        return newBuilder().mergeFrom(fVar);
    }

    public h getConclusionOfConditionalEffect() {
        return this.conclusionOfConditionalEffect_;
    }

    public h getEffectConstructorArgument(int i) {
        return this.effectConstructorArgument_.get(i);
    }

    public int getEffectConstructorArgumentCount() {
        return this.effectConstructorArgument_.size();
    }

    public c getEffectType() {
        return this.effectType_;
    }

    public d getKind() {
        return this.kind_;
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeEnumSize = (this.bitField0_ & 1) == 1 ? CodedOutputStream.computeEnumSize(1, this.effectType_.getNumber()) + 0 : 0;
        for (int i2 = 0; i2 < this.effectConstructorArgument_.size(); i2++) {
            iComputeEnumSize += CodedOutputStream.computeMessageSize(2, this.effectConstructorArgument_.get(i2));
        }
        if ((this.bitField0_ & 2) == 2) {
            iComputeEnumSize += CodedOutputStream.computeMessageSize(3, this.conclusionOfConditionalEffect_);
        }
        if ((this.bitField0_ & 4) == 4) {
            iComputeEnumSize += CodedOutputStream.computeEnumSize(4, this.kind_.getNumber());
        }
        int size = this.unknownFields.size() + iComputeEnumSize;
        this.memoizedSerializedSize = size;
        return size;
    }

    public final void h() {
        this.effectType_ = c.RETURNS_CONSTANT;
        this.effectConstructorArgument_ = Collections.emptyList();
        this.conclusionOfConditionalEffect_ = h.getDefaultInstance();
        this.kind_ = d.AT_MOST_ONCE;
    }

    public boolean hasConclusionOfConditionalEffect() {
        return (this.bitField0_ & 2) == 2;
    }

    public boolean hasEffectType() {
        return (this.bitField0_ & 1) == 1;
    }

    public boolean hasKind() {
        return (this.bitField0_ & 4) == 4;
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
        for (int i = 0; i < getEffectConstructorArgumentCount(); i++) {
            if (!getEffectConstructorArgument(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        if (!hasConclusionOfConditionalEffect() || getConclusionOfConditionalEffect().isInitialized()) {
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }
        this.memoizedIsInitialized = (byte) 0;
        return false;
    }

    @Override // d0.e0.p.d.m0.i.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.bitField0_ & 1) == 1) {
            codedOutputStream.writeEnum(1, this.effectType_.getNumber());
        }
        for (int i = 0; i < this.effectConstructorArgument_.size(); i++) {
            codedOutputStream.writeMessage(2, this.effectConstructorArgument_.get(i));
        }
        if ((this.bitField0_ & 2) == 2) {
            codedOutputStream.writeMessage(3, this.conclusionOfConditionalEffect_);
        }
        if ((this.bitField0_ & 4) == 4) {
            codedOutputStream.writeEnum(4, this.kind_.getNumber());
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

    public f() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = ByteString3.j;
    }

    public f(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite, d0.e0.p.d.m0.f.a aVar) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        h();
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
                            int i2 = codedInputStream.readEnum();
                            c cVarValueOf = c.valueOf(i2);
                            if (cVarValueOf == null) {
                                codedOutputStreamNewInstance.writeRawVarint32(tag);
                                codedOutputStreamNewInstance.writeRawVarint32(i2);
                            } else {
                                this.bitField0_ |= 1;
                                this.effectType_ = cVarValueOf;
                            }
                        } else if (tag == 18) {
                            if ((i & 2) != 2) {
                                this.effectConstructorArgument_ = new ArrayList();
                                i |= 2;
                            }
                            this.effectConstructorArgument_.add((h) codedInputStream.readMessage(h.k, extensionRegistryLite));
                        } else if (tag == 26) {
                            h.b builder = (this.bitField0_ & 2) == 2 ? this.conclusionOfConditionalEffect_.toBuilder() : null;
                            h hVar = (h) codedInputStream.readMessage(h.k, extensionRegistryLite);
                            this.conclusionOfConditionalEffect_ = hVar;
                            if (builder != null) {
                                builder.mergeFrom(hVar);
                                this.conclusionOfConditionalEffect_ = builder.buildPartial();
                            }
                            this.bitField0_ |= 2;
                        } else if (tag != 32) {
                            if (!codedInputStream.skipField(tag, codedOutputStreamNewInstance)) {
                            }
                        } else {
                            int i3 = codedInputStream.readEnum();
                            d dVarValueOf = d.valueOf(i3);
                            if (dVarValueOf == null) {
                                codedOutputStreamNewInstance.writeRawVarint32(tag);
                                codedOutputStreamNewInstance.writeRawVarint32(i3);
                            } else {
                                this.bitField0_ |= 4;
                                this.kind_ = dVarValueOf;
                            }
                        }
                    }
                    z2 = true;
                } catch (Throwable th) {
                    if ((i & 2) == 2) {
                        this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
                    }
                    try {
                        codedOutputStreamNewInstance.flush();
                    } catch (IOException unused) {
                    } finally {
                        this.unknownFields = bVarNewOutput.toByteString();
                    }
                    throw th;
                }
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(this);
            } catch (IOException e2) {
                throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
            }
        }
        if ((i & 2) == 2) {
            this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
        }
        try {
            codedOutputStreamNewInstance.flush();
        } catch (IOException unused2) {
        } finally {
            this.unknownFields = bVarNewOutput.toByteString();
        }
    }
}
