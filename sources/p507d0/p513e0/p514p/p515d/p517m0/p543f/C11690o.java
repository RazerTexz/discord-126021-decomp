package p507d0.p513e0.p514p.p515d.p517m0.p543f;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11722b;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11723c;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11724d;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11725e;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11728h;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11735o;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.o */
/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11690o extends AbstractC11727g implements InterfaceC11735o {

    /* JADX INFO: renamed from: j */
    public static final C11690o f23885j;

    /* JADX INFO: renamed from: k */
    public static InterfaceC11736p<C11690o> f23886k = new a();
    private byte memoizedIsInitialized;
    private int memoizedSerializedSize;
    private List<c> qualifiedName_;
    private final AbstractC11723c unknownFields;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.o$a */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static class a extends AbstractC11722b<C11690o> {
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p
        public C11690o parsePartialFrom(C11724d c11724d, C11725e c11725e) throws InvalidProtocolBufferException {
            return new C11690o(c11724d, c11725e, null);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.o$b */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends AbstractC11727g.b<C11690o, b> implements InterfaceC11735o {

        /* JADX INFO: renamed from: k */
        public int f23887k;

        /* JADX INFO: renamed from: l */
        public List<c> f23888l = Collections.emptyList();

        public C11690o buildPartial() {
            C11690o c11690o = new C11690o(this, null);
            if ((this.f23887k & 1) == 1) {
                this.f23888l = Collections.unmodifiableList(this.f23888l);
                this.f23887k &= -2;
            }
            c11690o.qualifiedName_ = this.f23888l;
            return c11690o;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public C11690o build() {
            C11690o c11690oBuildPartial = buildPartial();
            if (c11690oBuildPartial.isInitialized()) {
                return c11690oBuildPartial;
            }
            throw new UninitializedMessageException(c11690oBuildPartial);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        /* JADX INFO: renamed from: clone */
        public b mo11465clone() {
            return new b().mergeFrom(buildPartial());
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
        public b mergeFrom(C11690o c11690o) {
            if (c11690o == C11690o.getDefaultInstance()) {
                return this;
            }
            if (!c11690o.qualifiedName_.isEmpty()) {
                if (this.f23888l.isEmpty()) {
                    this.f23888l = c11690o.qualifiedName_;
                    this.f23887k &= -2;
                } else {
                    if ((this.f23887k & 1) != 1) {
                        this.f23888l = new ArrayList(this.f23888l);
                        this.f23887k |= 1;
                    }
                    this.f23888l.addAll(c11690o.qualifiedName_);
                }
            }
            setUnknownFields(getUnknownFields().concat(c11690o.unknownFields));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11721a.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
        public b mergeFrom(C11724d c11724d, C11725e c11725e) throws Throwable {
            C11690o c11690o = null;
            try {
                try {
                    C11690o partialFrom = C11690o.f23886k.parsePartialFrom(c11724d, c11725e);
                    if (partialFrom != null) {
                        mergeFrom(partialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e) {
                    C11690o c11690o2 = (C11690o) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        c11690o = c11690o2;
                        if (c11690o != null) {
                            mergeFrom(c11690o);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (c11690o != null) {
                    mergeFrom(c11690o);
                }
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.o$c */
    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class c extends AbstractC11727g implements InterfaceC11735o {

        /* JADX INFO: renamed from: j */
        public static final c f23889j;

        /* JADX INFO: renamed from: k */
        public static InterfaceC11736p<c> f23890k = new a();
        private int bitField0_;
        private EnumC13322c kind_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int parentQualifiedName_;
        private int shortName_;
        private final AbstractC11723c unknownFields;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.f.o$c$a */
        /* JADX INFO: compiled from: ProtoBuf.java */
        public static class a extends AbstractC11722b<c> {
            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p
            public c parsePartialFrom(C11724d c11724d, C11725e c11725e) throws InvalidProtocolBufferException {
                return new c(c11724d, c11725e, null);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.f.o$c$b */
        /* JADX INFO: compiled from: ProtoBuf.java */
        public static final class b extends AbstractC11727g.b<c, b> implements InterfaceC11735o {

            /* JADX INFO: renamed from: k */
            public int f23891k;

            /* JADX INFO: renamed from: m */
            public int f23893m;

            /* JADX INFO: renamed from: l */
            public int f23892l = -1;

            /* JADX INFO: renamed from: n */
            public EnumC13322c f23894n = EnumC13322c.PACKAGE;

            public c buildPartial() {
                c cVar = new c(this, null);
                int i = this.f23891k;
                int i2 = (i & 1) != 1 ? 0 : 1;
                cVar.parentQualifiedName_ = this.f23892l;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                cVar.shortName_ = this.f23893m;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                cVar.kind_ = this.f23894n;
                cVar.bitField0_ = i2;
                return cVar;
            }

            public b setKind(EnumC13322c enumC13322c) {
                Objects.requireNonNull(enumC13322c);
                this.f23891k |= 4;
                this.f23894n = enumC13322c;
                return this;
            }

            public b setParentQualifiedName(int i) {
                this.f23891k |= 1;
                this.f23892l = i;
                return this;
            }

            public b setShortName(int i) {
                this.f23891k |= 2;
                this.f23893m = i;
                return this;
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
            public c build() {
                c cVarBuildPartial = buildPartial();
                if (cVarBuildPartial.isInitialized()) {
                    return cVarBuildPartial;
                }
                throw new UninitializedMessageException(cVarBuildPartial);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
            /* JADX INFO: renamed from: clone */
            public b mo11465clone() {
                return new b().mergeFrom(buildPartial());
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
            public b mergeFrom(c cVar) {
                if (cVar == c.getDefaultInstance()) {
                    return this;
                }
                if (cVar.hasParentQualifiedName()) {
                    setParentQualifiedName(cVar.getParentQualifiedName());
                }
                if (cVar.hasShortName()) {
                    setShortName(cVar.getShortName());
                }
                if (cVar.hasKind()) {
                    setKind(cVar.getKind());
                }
                setUnknownFields(getUnknownFields().concat(cVar.unknownFields));
                return this;
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11721a.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
            public b mergeFrom(C11724d c11724d, C11725e c11725e) throws Throwable {
                c cVar = null;
                try {
                    try {
                        c partialFrom = c.f23890k.parsePartialFrom(c11724d, c11725e);
                        if (partialFrom != null) {
                            mergeFrom(partialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        c cVar2 = (c) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            cVar = cVar2;
                            if (cVar != null) {
                                mergeFrom(cVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cVar != null) {
                        mergeFrom(cVar);
                    }
                    throw th;
                }
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.f.o$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ProtoBuf.java */
        public enum EnumC13322c implements C11728h.a {
            CLASS(0),
            PACKAGE(1),
            LOCAL(2);

            private final int value;

            EnumC13322c(int i) {
                this.value = i;
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.C11728h.a
            public final int getNumber() {
                return this.value;
            }

            public static EnumC13322c valueOf(int i) {
                if (i == 0) {
                    return CLASS;
                }
                if (i == 1) {
                    return PACKAGE;
                }
                if (i != 2) {
                    return null;
                }
                return LOCAL;
            }
        }

        static {
            c cVar = new c();
            f23889j = cVar;
            cVar.parentQualifiedName_ = -1;
            cVar.shortName_ = 0;
            cVar.kind_ = EnumC13322c.PACKAGE;
        }

        public c(AbstractC11727g.b bVar, C11666a c11666a) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.getUnknownFields();
        }

        public static c getDefaultInstance() {
            return f23889j;
        }

        public static b newBuilder(c cVar) {
            return newBuilder().mergeFrom(cVar);
        }

        public EnumC13322c getKind() {
            return this.kind_;
        }

        public int getParentQualifiedName() {
            return this.parentQualifiedName_;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.parentQualifiedName_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.shortName_);
            }
            if ((this.bitField0_ & 4) == 4) {
                iComputeInt32Size += CodedOutputStream.computeEnumSize(3, this.kind_.getNumber());
            }
            int size = this.unknownFields.size() + iComputeInt32Size;
            this.memoizedSerializedSize = size;
            return size;
        }

        public int getShortName() {
            return this.shortName_;
        }

        public boolean hasKind() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasParentQualifiedName() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasShortName() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11735o
        public final boolean isInitialized() {
            byte b2 = this.memoizedIsInitialized;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (hasShortName()) {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
            this.memoizedIsInitialized = (byte) 0;
            return false;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.parentQualifiedName_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.shortName_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeEnum(3, this.kind_.getNumber());
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static b newBuilder() {
            return new b();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
        public b toBuilder() {
            return newBuilder(this);
        }

        public c() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = AbstractC11723c.f24100j;
        }

        public c(C11724d c11724d, C11725e c11725e, C11666a c11666a) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.parentQualifiedName_ = -1;
            boolean z2 = false;
            this.shortName_ = 0;
            this.kind_ = EnumC13322c.PACKAGE;
            AbstractC11723c.b bVarNewOutput = AbstractC11723c.newOutput();
            CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
            while (!z2) {
                try {
                    try {
                        try {
                            int tag = c11724d.readTag();
                            if (tag != 0) {
                                if (tag == 8) {
                                    this.bitField0_ |= 1;
                                    this.parentQualifiedName_ = c11724d.readInt32();
                                } else if (tag == 16) {
                                    this.bitField0_ |= 2;
                                    this.shortName_ = c11724d.readInt32();
                                } else if (tag != 24) {
                                    if (!c11724d.skipField(tag, codedOutputStreamNewInstance)) {
                                    }
                                } else {
                                    int i = c11724d.readEnum();
                                    EnumC13322c enumC13322cValueOf = EnumC13322c.valueOf(i);
                                    if (enumC13322cValueOf == null) {
                                        codedOutputStreamNewInstance.writeRawVarint32(tag);
                                        codedOutputStreamNewInstance.writeRawVarint32(i);
                                    } else {
                                        this.bitField0_ |= 4;
                                        this.kind_ = enumC13322cValueOf;
                                    }
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
                    try {
                        codedOutputStreamNewInstance.flush();
                    } catch (IOException unused) {
                    } finally {
                        this.unknownFields = bVarNewOutput.toByteString();
                    }
                    throw th;
                }
            }
            try {
                codedOutputStreamNewInstance.flush();
            } catch (IOException unused2) {
            } finally {
                this.unknownFields = bVarNewOutput.toByteString();
            }
        }
    }

    static {
        C11690o c11690o = new C11690o();
        f23885j = c11690o;
        c11690o.qualifiedName_ = Collections.emptyList();
    }

    public C11690o(AbstractC11727g.b bVar, C11666a c11666a) {
        super(bVar);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = bVar.getUnknownFields();
    }

    public static C11690o getDefaultInstance() {
        return f23885j;
    }

    public static b newBuilder(C11690o c11690o) {
        return newBuilder().mergeFrom(c11690o);
    }

    public c getQualifiedName(int i) {
        return this.qualifiedName_.get(i);
    }

    public int getQualifiedNameCount() {
        return this.qualifiedName_.size();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeMessageSize = 0;
        for (int i2 = 0; i2 < this.qualifiedName_.size(); i2++) {
            iComputeMessageSize += CodedOutputStream.computeMessageSize(1, this.qualifiedName_.get(i2));
        }
        int size = this.unknownFields.size() + iComputeMessageSize;
        this.memoizedSerializedSize = size;
        return size;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11735o
    public final boolean isInitialized() {
        byte b2 = this.memoizedIsInitialized;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        for (int i = 0; i < getQualifiedNameCount(); i++) {
            if (!getQualifiedName(i).isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        for (int i = 0; i < this.qualifiedName_.size(); i++) {
            codedOutputStream.writeMessage(1, this.qualifiedName_.get(i));
        }
        codedOutputStream.writeRawBytes(this.unknownFields);
    }

    public static b newBuilder() {
        return new b();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public b newBuilderForType() {
        return newBuilder();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
    public b toBuilder() {
        return newBuilder(this);
    }

    public C11690o() {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.unknownFields = AbstractC11723c.f24100j;
    }

    public C11690o(C11724d c11724d, C11725e c11725e, C11666a c11666a) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        this.qualifiedName_ = Collections.emptyList();
        AbstractC11723c.b bVarNewOutput = AbstractC11723c.newOutput();
        CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
        boolean z2 = false;
        boolean z3 = false;
        while (!z2) {
            try {
                try {
                    int tag = c11724d.readTag();
                    if (tag != 0) {
                        if (tag != 10) {
                            if (!c11724d.skipField(tag, codedOutputStreamNewInstance)) {
                            }
                        } else {
                            if (!(z3 & true)) {
                                this.qualifiedName_ = new ArrayList();
                                z3 |= true;
                            }
                            this.qualifiedName_.add((c) c11724d.readMessage(c.f23890k, c11725e));
                        }
                    }
                    z2 = true;
                } catch (InvalidProtocolBufferException e) {
                    throw e.setUnfinishedMessage(this);
                } catch (IOException e2) {
                    throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                }
            } catch (Throwable th) {
                if (z3 & true) {
                    this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
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
        if (z3 & true) {
            this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
        }
        try {
            codedOutputStreamNewInstance.flush();
        } catch (IOException unused2) {
        } finally {
            this.unknownFields = bVarNewOutput.toByteString();
        }
    }
}
