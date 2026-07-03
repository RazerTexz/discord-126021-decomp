package p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11677b;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11678c;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11679d;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11684i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11687l;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11689n;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11692q;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11694s;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11722b;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11723c;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11724d;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11725e;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11728h;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11743w;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11735o;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.a */
/* JADX INFO: compiled from: JvmProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11667a {

    /* JADX INFO: renamed from: a */
    public static final AbstractC11727g.f<C11679d, c> f23651a;

    /* JADX INFO: renamed from: b */
    public static final AbstractC11727g.f<C11684i, c> f23652b;

    /* JADX INFO: renamed from: c */
    public static final AbstractC11727g.f<C11684i, Integer> f23653c;

    /* JADX INFO: renamed from: d */
    public static final AbstractC11727g.f<C11689n, d> f23654d;

    /* JADX INFO: renamed from: e */
    public static final AbstractC11727g.f<C11689n, Integer> f23655e;

    /* JADX INFO: renamed from: f */
    public static final AbstractC11727g.f<C11692q, List<C11677b>> f23656f;

    /* JADX INFO: renamed from: g */
    public static final AbstractC11727g.f<C11692q, Boolean> f23657g;

    /* JADX INFO: renamed from: h */
    public static final AbstractC11727g.f<C11694s, List<C11677b>> f23658h;

    /* JADX INFO: renamed from: i */
    public static final AbstractC11727g.f<C11678c, Integer> f23659i;

    /* JADX INFO: renamed from: j */
    public static final AbstractC11727g.f<C11678c, List<C11689n>> f23660j;

    /* JADX INFO: renamed from: k */
    public static final AbstractC11727g.f<C11678c, Integer> f23661k;

    /* JADX INFO: renamed from: l */
    public static final AbstractC11727g.f<C11678c, Integer> f23662l;

    /* JADX INFO: renamed from: m */
    public static final AbstractC11727g.f<C11687l, Integer> f23663m;

    /* JADX INFO: renamed from: n */
    public static final AbstractC11727g.f<C11687l, List<C11689n>> f23664n;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.a$b */
    /* JADX INFO: compiled from: JvmProtoBuf.java */
    public static final class b extends AbstractC11727g implements InterfaceC11735o {

        /* JADX INFO: renamed from: j */
        public static final b f23665j;

        /* JADX INFO: renamed from: k */
        public static InterfaceC11736p<b> f23666k = new a();
        private int bitField0_;
        private int desc_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final AbstractC11723c unknownFields;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.a$b$a */
        /* JADX INFO: compiled from: JvmProtoBuf.java */
        public static class a extends AbstractC11722b<b> {
            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p
            public b parsePartialFrom(C11724d c11724d, C11725e c11725e) throws InvalidProtocolBufferException {
                return new b(c11724d, c11725e, null);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.a$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: JvmProtoBuf.java */
        public static final class C13317b extends AbstractC11727g.b<b, C13317b> implements InterfaceC11735o {

            /* JADX INFO: renamed from: k */
            public int f23667k;

            /* JADX INFO: renamed from: l */
            public int f23668l;

            /* JADX INFO: renamed from: m */
            public int f23669m;

            public b buildPartial() {
                b bVar = new b(this, null);
                int i = this.f23667k;
                int i2 = (i & 1) != 1 ? 0 : 1;
                bVar.name_ = this.f23668l;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                bVar.desc_ = this.f23669m;
                bVar.bitField0_ = i2;
                return bVar;
            }

            public C13317b setDesc(int i) {
                this.f23667k |= 2;
                this.f23669m = i;
                return this;
            }

            public C13317b setName(int i) {
                this.f23667k |= 1;
                this.f23668l = i;
                return this;
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
            public b build() {
                b bVarBuildPartial = buildPartial();
                if (bVarBuildPartial.isInitialized()) {
                    return bVarBuildPartial;
                }
                throw new UninitializedMessageException(bVarBuildPartial);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
            /* JADX INFO: renamed from: clone */
            public C13317b mo11465clone() {
                return new C13317b().mergeFrom(buildPartial());
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
            public C13317b mergeFrom(b bVar) {
                if (bVar == b.getDefaultInstance()) {
                    return this;
                }
                if (bVar.hasName()) {
                    setName(bVar.getName());
                }
                if (bVar.hasDesc()) {
                    setDesc(bVar.getDesc());
                }
                setUnknownFields(getUnknownFields().concat(bVar.unknownFields));
                return this;
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11721a.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
            public C13317b mergeFrom(C11724d c11724d, C11725e c11725e) throws Throwable {
                b bVar = null;
                try {
                    try {
                        b partialFrom = b.f23666k.parsePartialFrom(c11724d, c11725e);
                        if (partialFrom != null) {
                            mergeFrom(partialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        b bVar2 = (b) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            bVar = bVar2;
                            if (bVar != null) {
                                mergeFrom(bVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bVar != null) {
                        mergeFrom(bVar);
                    }
                    throw th;
                }
            }
        }

        static {
            b bVar = new b();
            f23665j = bVar;
            bVar.name_ = 0;
            bVar.desc_ = 0;
        }

        public b(AbstractC11727g.b bVar, a aVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.getUnknownFields();
        }

        public static b getDefaultInstance() {
            return f23665j;
        }

        public static C13317b newBuilder(b bVar) {
            return newBuilder().mergeFrom(bVar);
        }

        public int getDesc() {
            return this.desc_;
        }

        public int getName() {
            return this.name_;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.name_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.desc_);
            }
            int size = this.unknownFields.size() + iComputeInt32Size;
            this.memoizedSerializedSize = size;
            return size;
        }

        public boolean hasDesc() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
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
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.desc_);
            }
            codedOutputStream.writeRawBytes(this.unknownFields);
        }

        public static C13317b newBuilder() {
            return new C13317b();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
        public C13317b newBuilderForType() {
            return newBuilder();
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
        public C13317b toBuilder() {
            return newBuilder(this);
        }

        public b() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = AbstractC11723c.f24100j;
        }

        public b(C11724d c11724d, C11725e c11725e, a aVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            boolean z2 = false;
            this.name_ = 0;
            this.desc_ = 0;
            AbstractC11723c.b bVarNewOutput = AbstractC11723c.newOutput();
            CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
            while (!z2) {
                try {
                    try {
                        int tag = c11724d.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.bitField0_ |= 1;
                                this.name_ = c11724d.readInt32();
                            } else if (tag != 16) {
                                if (!c11724d.skipField(tag, codedOutputStreamNewInstance)) {
                                }
                            } else {
                                this.bitField0_ |= 2;
                                this.desc_ = c11724d.readInt32();
                            }
                        }
                        z2 = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
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

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.a$c */
    /* JADX INFO: compiled from: JvmProtoBuf.java */
    public static final class c extends AbstractC11727g implements InterfaceC11735o {

        /* JADX INFO: renamed from: j */
        public static final c f23670j;

        /* JADX INFO: renamed from: k */
        public static InterfaceC11736p<c> f23671k = new a();
        private int bitField0_;
        private int desc_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final AbstractC11723c unknownFields;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.a$c$a */
        /* JADX INFO: compiled from: JvmProtoBuf.java */
        public static class a extends AbstractC11722b<c> {
            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p
            public c parsePartialFrom(C11724d c11724d, C11725e c11725e) throws InvalidProtocolBufferException {
                return new c(c11724d, c11725e, null);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.a$c$b */
        /* JADX INFO: compiled from: JvmProtoBuf.java */
        public static final class b extends AbstractC11727g.b<c, b> implements InterfaceC11735o {

            /* JADX INFO: renamed from: k */
            public int f23672k;

            /* JADX INFO: renamed from: l */
            public int f23673l;

            /* JADX INFO: renamed from: m */
            public int f23674m;

            public c buildPartial() {
                c cVar = new c(this, null);
                int i = this.f23672k;
                int i2 = (i & 1) != 1 ? 0 : 1;
                cVar.name_ = this.f23673l;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                cVar.desc_ = this.f23674m;
                cVar.bitField0_ = i2;
                return cVar;
            }

            public b setDesc(int i) {
                this.f23672k |= 2;
                this.f23674m = i;
                return this;
            }

            public b setName(int i) {
                this.f23672k |= 1;
                this.f23673l = i;
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
                if (cVar.hasName()) {
                    setName(cVar.getName());
                }
                if (cVar.hasDesc()) {
                    setDesc(cVar.getDesc());
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
                        c partialFrom = c.f23671k.parsePartialFrom(c11724d, c11725e);
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

        static {
            c cVar = new c();
            f23670j = cVar;
            cVar.name_ = 0;
            cVar.desc_ = 0;
        }

        public c(AbstractC11727g.b bVar, a aVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.getUnknownFields();
        }

        public static c getDefaultInstance() {
            return f23670j;
        }

        public static b newBuilder(c cVar) {
            return newBuilder().mergeFrom(cVar);
        }

        public int getDesc() {
            return this.desc_;
        }

        public int getName() {
            return this.name_;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeInt32Size = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.name_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeInt32Size += CodedOutputStream.computeInt32Size(2, this.desc_);
            }
            int size = this.unknownFields.size() + iComputeInt32Size;
            this.memoizedSerializedSize = size;
            return size;
        }

        public boolean hasDesc() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
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
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeInt32(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeInt32(2, this.desc_);
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

        public c(C11724d c11724d, C11725e c11725e, a aVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            boolean z2 = false;
            this.name_ = 0;
            this.desc_ = 0;
            AbstractC11723c.b bVarNewOutput = AbstractC11723c.newOutput();
            CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
            while (!z2) {
                try {
                    try {
                        int tag = c11724d.readTag();
                        if (tag != 0) {
                            if (tag == 8) {
                                this.bitField0_ |= 1;
                                this.name_ = c11724d.readInt32();
                            } else if (tag != 16) {
                                if (!c11724d.skipField(tag, codedOutputStreamNewInstance)) {
                                }
                            } else {
                                this.bitField0_ |= 2;
                                this.desc_ = c11724d.readInt32();
                            }
                        }
                        z2 = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
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

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.a$d */
    /* JADX INFO: compiled from: JvmProtoBuf.java */
    public static final class d extends AbstractC11727g implements InterfaceC11735o {

        /* JADX INFO: renamed from: j */
        public static final d f23675j;

        /* JADX INFO: renamed from: k */
        public static InterfaceC11736p<d> f23676k = new a();
        private int bitField0_;
        private b field_;
        private c getter_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private c setter_;
        private c syntheticMethod_;
        private final AbstractC11723c unknownFields;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.a$d$a */
        /* JADX INFO: compiled from: JvmProtoBuf.java */
        public static class a extends AbstractC11722b<d> {
            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p
            public d parsePartialFrom(C11724d c11724d, C11725e c11725e) throws InvalidProtocolBufferException {
                return new d(c11724d, c11725e, null);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.a$d$b */
        /* JADX INFO: compiled from: JvmProtoBuf.java */
        public static final class b extends AbstractC11727g.b<d, b> implements InterfaceC11735o {

            /* JADX INFO: renamed from: k */
            public int f23677k;

            /* JADX INFO: renamed from: l */
            public b f23678l = b.getDefaultInstance();

            /* JADX INFO: renamed from: m */
            public c f23679m = c.getDefaultInstance();

            /* JADX INFO: renamed from: n */
            public c f23680n = c.getDefaultInstance();

            /* JADX INFO: renamed from: o */
            public c f23681o = c.getDefaultInstance();

            public d buildPartial() {
                d dVar = new d(this, null);
                int i = this.f23677k;
                int i2 = (i & 1) != 1 ? 0 : 1;
                dVar.field_ = this.f23678l;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                dVar.syntheticMethod_ = this.f23679m;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                dVar.getter_ = this.f23680n;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                dVar.setter_ = this.f23681o;
                dVar.bitField0_ = i2;
                return dVar;
            }

            public b mergeField(b bVar) {
                if ((this.f23677k & 1) != 1 || this.f23678l == b.getDefaultInstance()) {
                    this.f23678l = bVar;
                } else {
                    this.f23678l = b.newBuilder(this.f23678l).mergeFrom(bVar).buildPartial();
                }
                this.f23677k |= 1;
                return this;
            }

            public b mergeGetter(c cVar) {
                if ((this.f23677k & 4) != 4 || this.f23680n == c.getDefaultInstance()) {
                    this.f23680n = cVar;
                } else {
                    this.f23680n = c.newBuilder(this.f23680n).mergeFrom(cVar).buildPartial();
                }
                this.f23677k |= 4;
                return this;
            }

            public b mergeSetter(c cVar) {
                if ((this.f23677k & 8) != 8 || this.f23681o == c.getDefaultInstance()) {
                    this.f23681o = cVar;
                } else {
                    this.f23681o = c.newBuilder(this.f23681o).mergeFrom(cVar).buildPartial();
                }
                this.f23677k |= 8;
                return this;
            }

            public b mergeSyntheticMethod(c cVar) {
                if ((this.f23677k & 2) != 2 || this.f23679m == c.getDefaultInstance()) {
                    this.f23679m = cVar;
                } else {
                    this.f23679m = c.newBuilder(this.f23679m).mergeFrom(cVar).buildPartial();
                }
                this.f23677k |= 2;
                return this;
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
            public d build() {
                d dVarBuildPartial = buildPartial();
                if (dVarBuildPartial.isInitialized()) {
                    return dVarBuildPartial;
                }
                throw new UninitializedMessageException(dVarBuildPartial);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
            /* JADX INFO: renamed from: clone */
            public b mo11465clone() {
                return new b().mergeFrom(buildPartial());
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
            public b mergeFrom(d dVar) {
                if (dVar == d.getDefaultInstance()) {
                    return this;
                }
                if (dVar.hasField()) {
                    mergeField(dVar.getField());
                }
                if (dVar.hasSyntheticMethod()) {
                    mergeSyntheticMethod(dVar.getSyntheticMethod());
                }
                if (dVar.hasGetter()) {
                    mergeGetter(dVar.getGetter());
                }
                if (dVar.hasSetter()) {
                    mergeSetter(dVar.getSetter());
                }
                setUnknownFields(getUnknownFields().concat(dVar.unknownFields));
                return this;
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11721a.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
            public b mergeFrom(C11724d c11724d, C11725e c11725e) throws Throwable {
                d dVar = null;
                try {
                    try {
                        d partialFrom = d.f23676k.parsePartialFrom(c11724d, c11725e);
                        if (partialFrom != null) {
                            mergeFrom(partialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        d dVar2 = (d) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            dVar = dVar2;
                            if (dVar != null) {
                                mergeFrom(dVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (dVar != null) {
                        mergeFrom(dVar);
                    }
                    throw th;
                }
            }
        }

        static {
            d dVar = new d();
            f23675j = dVar;
            dVar.m9565g();
        }

        public d(AbstractC11727g.b bVar, a aVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.getUnknownFields();
        }

        public static d getDefaultInstance() {
            return f23675j;
        }

        public static b newBuilder(d dVar) {
            return newBuilder().mergeFrom(dVar);
        }

        /* JADX INFO: renamed from: g */
        public final void m9565g() {
            this.field_ = b.getDefaultInstance();
            this.syntheticMethod_ = c.getDefaultInstance();
            this.getter_ = c.getDefaultInstance();
            this.setter_ = c.getDefaultInstance();
        }

        public b getField() {
            return this.field_;
        }

        public c getGetter() {
            return this.getter_;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeMessageSize = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.computeMessageSize(1, this.field_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(2, this.syntheticMethod_);
            }
            if ((this.bitField0_ & 4) == 4) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(3, this.getter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(4, this.setter_);
            }
            int size = this.unknownFields.size() + iComputeMessageSize;
            this.memoizedSerializedSize = size;
            return size;
        }

        public c getSetter() {
            return this.setter_;
        }

        public c getSyntheticMethod() {
            return this.syntheticMethod_;
        }

        public boolean hasField() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasGetter() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasSetter() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasSyntheticMethod() {
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
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.writeMessage(1, this.field_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.writeMessage(2, this.syntheticMethod_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.writeMessage(3, this.getter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.writeMessage(4, this.setter_);
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

        public d() {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = AbstractC11723c.f24100j;
        }

        public d(C11724d c11724d, C11725e c11725e, a aVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            m9565g();
            AbstractC11723c.b bVarNewOutput = AbstractC11723c.newOutput();
            CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
            boolean z2 = false;
            while (!z2) {
                try {
                    try {
                        int tag = c11724d.readTag();
                        if (tag != 0) {
                            if (tag == 10) {
                                b.C13317b builder = (this.bitField0_ & 1) == 1 ? this.field_.toBuilder() : null;
                                b bVar = (b) c11724d.readMessage(b.f23666k, c11725e);
                                this.field_ = bVar;
                                if (builder != null) {
                                    builder.mergeFrom(bVar);
                                    this.field_ = builder.buildPartial();
                                }
                                this.bitField0_ |= 1;
                            } else if (tag == 18) {
                                c.b builder2 = (this.bitField0_ & 2) == 2 ? this.syntheticMethod_.toBuilder() : null;
                                c cVar = (c) c11724d.readMessage(c.f23671k, c11725e);
                                this.syntheticMethod_ = cVar;
                                if (builder2 != null) {
                                    builder2.mergeFrom(cVar);
                                    this.syntheticMethod_ = builder2.buildPartial();
                                }
                                this.bitField0_ |= 2;
                            } else if (tag == 26) {
                                c.b builder3 = (this.bitField0_ & 4) == 4 ? this.getter_.toBuilder() : null;
                                c cVar2 = (c) c11724d.readMessage(c.f23671k, c11725e);
                                this.getter_ = cVar2;
                                if (builder3 != null) {
                                    builder3.mergeFrom(cVar2);
                                    this.getter_ = builder3.buildPartial();
                                }
                                this.bitField0_ |= 4;
                            } else if (tag != 34) {
                                if (!c11724d.skipField(tag, codedOutputStreamNewInstance)) {
                                }
                            } else {
                                c.b builder4 = (this.bitField0_ & 8) == 8 ? this.setter_.toBuilder() : null;
                                c cVar3 = (c) c11724d.readMessage(c.f23671k, c11725e);
                                this.setter_ = cVar3;
                                if (builder4 != null) {
                                    builder4.mergeFrom(cVar3);
                                    this.setter_ = builder4.buildPartial();
                                }
                                this.bitField0_ |= 8;
                            }
                        }
                        z2 = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
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

    /* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.a$e */
    /* JADX INFO: compiled from: JvmProtoBuf.java */
    public static final class e extends AbstractC11727g implements InterfaceC11735o {

        /* JADX INFO: renamed from: j */
        public static final e f23682j;

        /* JADX INFO: renamed from: k */
        public static InterfaceC11736p<e> f23683k = new a();
        private int localNameMemoizedSerializedSize;
        private List<Integer> localName_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<c> record_;
        private final AbstractC11723c unknownFields;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.a$e$a */
        /* JADX INFO: compiled from: JvmProtoBuf.java */
        public static class a extends AbstractC11722b<e> {
            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p
            public e parsePartialFrom(C11724d c11724d, C11725e c11725e) throws InvalidProtocolBufferException {
                return new e(c11724d, c11725e, null);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.a$e$b */
        /* JADX INFO: compiled from: JvmProtoBuf.java */
        public static final class b extends AbstractC11727g.b<e, b> implements InterfaceC11735o {

            /* JADX INFO: renamed from: k */
            public int f23684k;

            /* JADX INFO: renamed from: l */
            public List<c> f23685l = Collections.emptyList();

            /* JADX INFO: renamed from: m */
            public List<Integer> f23686m = Collections.emptyList();

            public e buildPartial() {
                e eVar = new e(this, null);
                if ((this.f23684k & 1) == 1) {
                    this.f23685l = Collections.unmodifiableList(this.f23685l);
                    this.f23684k &= -2;
                }
                eVar.record_ = this.f23685l;
                if ((this.f23684k & 2) == 2) {
                    this.f23686m = Collections.unmodifiableList(this.f23686m);
                    this.f23684k &= -3;
                }
                eVar.localName_ = this.f23686m;
                return eVar;
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
            public e build() {
                e eVarBuildPartial = buildPartial();
                if (eVarBuildPartial.isInitialized()) {
                    return eVarBuildPartial;
                }
                throw new UninitializedMessageException(eVarBuildPartial);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
            /* JADX INFO: renamed from: clone */
            public b mo11465clone() {
                return new b().mergeFrom(buildPartial());
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g.b
            public b mergeFrom(e eVar) {
                if (eVar == e.getDefaultInstance()) {
                    return this;
                }
                if (!eVar.record_.isEmpty()) {
                    if (this.f23685l.isEmpty()) {
                        this.f23685l = eVar.record_;
                        this.f23684k &= -2;
                    } else {
                        if ((this.f23684k & 1) != 1) {
                            this.f23685l = new ArrayList(this.f23685l);
                            this.f23684k |= 1;
                        }
                        this.f23685l.addAll(eVar.record_);
                    }
                }
                if (!eVar.localName_.isEmpty()) {
                    if (this.f23686m.isEmpty()) {
                        this.f23686m = eVar.localName_;
                        this.f23684k &= -3;
                    } else {
                        if ((this.f23684k & 2) != 2) {
                            this.f23686m = new ArrayList(this.f23686m);
                            this.f23684k |= 2;
                        }
                        this.f23686m.addAll(eVar.localName_);
                    }
                }
                setUnknownFields(getUnknownFields().concat(eVar.unknownFields));
                return this;
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11721a.a, p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n.a
            public b mergeFrom(C11724d c11724d, C11725e c11725e) throws Throwable {
                e eVar = null;
                try {
                    try {
                        e partialFrom = e.f23683k.parsePartialFrom(c11724d, c11725e);
                        if (partialFrom != null) {
                            mergeFrom(partialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        e eVar2 = (e) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th) {
                            th = th;
                            eVar = eVar2;
                            if (eVar != null) {
                                mergeFrom(eVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (eVar != null) {
                        mergeFrom(eVar);
                    }
                    throw th;
                }
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.a$e$c */
        /* JADX INFO: compiled from: JvmProtoBuf.java */
        public static final class c extends AbstractC11727g implements InterfaceC11735o {

            /* JADX INFO: renamed from: j */
            public static final c f23687j;

            /* JADX INFO: renamed from: k */
            public static InterfaceC11736p<c> f23688k = new a();
            private int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private EnumC13318c operation_;
            private int predefinedIndex_;
            private int range_;
            private int replaceCharMemoizedSerializedSize;
            private List<Integer> replaceChar_;
            private Object string_;
            private int substringIndexMemoizedSerializedSize;
            private List<Integer> substringIndex_;
            private final AbstractC11723c unknownFields;

            /* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.a$e$c$a */
            /* JADX INFO: compiled from: JvmProtoBuf.java */
            public static class a extends AbstractC11722b<c> {
                @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11736p
                public c parsePartialFrom(C11724d c11724d, C11725e c11725e) throws InvalidProtocolBufferException {
                    return new c(c11724d, c11725e, null);
                }
            }

            /* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.a$e$c$b */
            /* JADX INFO: compiled from: JvmProtoBuf.java */
            public static final class b extends AbstractC11727g.b<c, b> implements InterfaceC11735o {

                /* JADX INFO: renamed from: k */
                public int f23689k;

                /* JADX INFO: renamed from: m */
                public int f23691m;

                /* JADX INFO: renamed from: l */
                public int f23690l = 1;

                /* JADX INFO: renamed from: n */
                public Object f23692n = "";

                /* JADX INFO: renamed from: o */
                public EnumC13318c f23693o = EnumC13318c.NONE;

                /* JADX INFO: renamed from: p */
                public List<Integer> f23694p = Collections.emptyList();

                /* JADX INFO: renamed from: q */
                public List<Integer> f23695q = Collections.emptyList();

                public c buildPartial() {
                    c cVar = new c(this, null);
                    int i = this.f23689k;
                    int i2 = (i & 1) != 1 ? 0 : 1;
                    cVar.range_ = this.f23690l;
                    if ((i & 2) == 2) {
                        i2 |= 2;
                    }
                    cVar.predefinedIndex_ = this.f23691m;
                    if ((i & 4) == 4) {
                        i2 |= 4;
                    }
                    cVar.string_ = this.f23692n;
                    if ((i & 8) == 8) {
                        i2 |= 8;
                    }
                    cVar.operation_ = this.f23693o;
                    if ((this.f23689k & 16) == 16) {
                        this.f23694p = Collections.unmodifiableList(this.f23694p);
                        this.f23689k &= -17;
                    }
                    cVar.substringIndex_ = this.f23694p;
                    if ((this.f23689k & 32) == 32) {
                        this.f23695q = Collections.unmodifiableList(this.f23695q);
                        this.f23689k &= -33;
                    }
                    cVar.replaceChar_ = this.f23695q;
                    cVar.bitField0_ = i2;
                    return cVar;
                }

                public b setOperation(EnumC13318c enumC13318c) {
                    Objects.requireNonNull(enumC13318c);
                    this.f23689k |= 8;
                    this.f23693o = enumC13318c;
                    return this;
                }

                public b setPredefinedIndex(int i) {
                    this.f23689k |= 2;
                    this.f23691m = i;
                    return this;
                }

                public b setRange(int i) {
                    this.f23689k |= 1;
                    this.f23690l = i;
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
                    if (cVar.hasRange()) {
                        setRange(cVar.getRange());
                    }
                    if (cVar.hasPredefinedIndex()) {
                        setPredefinedIndex(cVar.getPredefinedIndex());
                    }
                    if (cVar.hasString()) {
                        this.f23689k |= 4;
                        this.f23692n = cVar.string_;
                    }
                    if (cVar.hasOperation()) {
                        setOperation(cVar.getOperation());
                    }
                    if (!cVar.substringIndex_.isEmpty()) {
                        if (this.f23694p.isEmpty()) {
                            this.f23694p = cVar.substringIndex_;
                            this.f23689k &= -17;
                        } else {
                            if ((this.f23689k & 16) != 16) {
                                this.f23694p = new ArrayList(this.f23694p);
                                this.f23689k |= 16;
                            }
                            this.f23694p.addAll(cVar.substringIndex_);
                        }
                    }
                    if (!cVar.replaceChar_.isEmpty()) {
                        if (this.f23695q.isEmpty()) {
                            this.f23695q = cVar.replaceChar_;
                            this.f23689k &= -33;
                        } else {
                            if ((this.f23689k & 32) != 32) {
                                this.f23695q = new ArrayList(this.f23695q);
                                this.f23689k |= 32;
                            }
                            this.f23695q.addAll(cVar.replaceChar_);
                        }
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
                            c partialFrom = c.f23688k.parsePartialFrom(c11724d, c11725e);
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

            /* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.a$e$c$c, reason: collision with other inner class name */
            /* JADX INFO: compiled from: JvmProtoBuf.java */
            public enum EnumC13318c implements C11728h.a {
                NONE(0),
                INTERNAL_TO_CLASS_ID(1),
                DESC_TO_CLASS_ID(2);

                private final int value;

                EnumC13318c(int i) {
                    this.value = i;
                }

                @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.C11728h.a
                public final int getNumber() {
                    return this.value;
                }

                public static EnumC13318c valueOf(int i) {
                    if (i == 0) {
                        return NONE;
                    }
                    if (i == 1) {
                        return INTERNAL_TO_CLASS_ID;
                    }
                    if (i != 2) {
                        return null;
                    }
                    return DESC_TO_CLASS_ID;
                }
            }

            static {
                c cVar = new c();
                f23687j = cVar;
                cVar.m9582l();
            }

            public c(AbstractC11727g.b bVar, a aVar) {
                super(bVar);
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = bVar.getUnknownFields();
            }

            public static c getDefaultInstance() {
                return f23687j;
            }

            public static b newBuilder(c cVar) {
                return newBuilder().mergeFrom(cVar);
            }

            public EnumC13318c getOperation() {
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

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
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
                AbstractC11723c abstractC11723c = (AbstractC11723c) obj;
                String stringUtf8 = abstractC11723c.toStringUtf8();
                if (abstractC11723c.isValidUtf8()) {
                    this.string_ = stringUtf8;
                }
                return stringUtf8;
            }

            public AbstractC11723c getStringBytes() {
                Object obj = this.string_;
                if (!(obj instanceof String)) {
                    return (AbstractC11723c) obj;
                }
                AbstractC11723c abstractC11723cCopyFromUtf8 = AbstractC11723c.copyFromUtf8((String) obj);
                this.string_ = abstractC11723cCopyFromUtf8;
                return abstractC11723cCopyFromUtf8;
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

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11735o
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

            /* JADX INFO: renamed from: l */
            public final void m9582l() {
                this.range_ = 1;
                this.predefinedIndex_ = 0;
                this.string_ = "";
                this.operation_ = EnumC13318c.NONE;
                this.substringIndex_ = Collections.emptyList();
                this.replaceChar_ = Collections.emptyList();
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
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
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = AbstractC11723c.f24100j;
            }

            public c(C11724d c11724d, C11725e c11725e, a aVar) throws InvalidProtocolBufferException {
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                m9582l();
                AbstractC11723c.b bVarNewOutput = AbstractC11723c.newOutput();
                CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
                boolean z2 = false;
                int i = 0;
                while (!z2) {
                    try {
                        try {
                            int tag = c11724d.readTag();
                            if (tag != 0) {
                                if (tag == 8) {
                                    this.bitField0_ |= 1;
                                    this.range_ = c11724d.readInt32();
                                } else if (tag == 16) {
                                    this.bitField0_ |= 2;
                                    this.predefinedIndex_ = c11724d.readInt32();
                                } else if (tag == 24) {
                                    int i2 = c11724d.readEnum();
                                    EnumC13318c enumC13318cValueOf = EnumC13318c.valueOf(i2);
                                    if (enumC13318cValueOf == null) {
                                        codedOutputStreamNewInstance.writeRawVarint32(tag);
                                        codedOutputStreamNewInstance.writeRawVarint32(i2);
                                    } else {
                                        this.bitField0_ |= 8;
                                        this.operation_ = enumC13318cValueOf;
                                    }
                                } else if (tag == 32) {
                                    if ((i & 16) != 16) {
                                        this.substringIndex_ = new ArrayList();
                                        i |= 16;
                                    }
                                    this.substringIndex_.add(Integer.valueOf(c11724d.readInt32()));
                                } else if (tag == 34) {
                                    int iPushLimit = c11724d.pushLimit(c11724d.readRawVarint32());
                                    if ((i & 16) != 16 && c11724d.getBytesUntilLimit() > 0) {
                                        this.substringIndex_ = new ArrayList();
                                        i |= 16;
                                    }
                                    while (c11724d.getBytesUntilLimit() > 0) {
                                        this.substringIndex_.add(Integer.valueOf(c11724d.readInt32()));
                                    }
                                    c11724d.popLimit(iPushLimit);
                                } else if (tag == 40) {
                                    if ((i & 32) != 32) {
                                        this.replaceChar_ = new ArrayList();
                                        i |= 32;
                                    }
                                    this.replaceChar_.add(Integer.valueOf(c11724d.readInt32()));
                                } else if (tag == 42) {
                                    int iPushLimit2 = c11724d.pushLimit(c11724d.readRawVarint32());
                                    if ((i & 32) != 32 && c11724d.getBytesUntilLimit() > 0) {
                                        this.replaceChar_ = new ArrayList();
                                        i |= 32;
                                    }
                                    while (c11724d.getBytesUntilLimit() > 0) {
                                        this.replaceChar_.add(Integer.valueOf(c11724d.readInt32()));
                                    }
                                    c11724d.popLimit(iPushLimit2);
                                } else if (tag != 50) {
                                    if (!c11724d.skipField(tag, codedOutputStreamNewInstance)) {
                                    }
                                } else {
                                    AbstractC11723c bytes = c11724d.readBytes();
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
                    this.unknownFields = bVarNewOutput.toByteString();
                }
            }
        }

        static {
            e eVar = new e();
            f23682j = eVar;
            eVar.record_ = Collections.emptyList();
            eVar.localName_ = Collections.emptyList();
        }

        public e(AbstractC11727g.b bVar, a aVar) {
            super(bVar);
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.getUnknownFields();
        }

        public static e getDefaultInstance() {
            return f23682j;
        }

        public static b newBuilder(e eVar) {
            return newBuilder().mergeFrom(eVar);
        }

        public static e parseDelimitedFrom(InputStream inputStream, C11725e c11725e) throws IOException {
            return (e) ((AbstractC11722b) f23683k).m11466parseDelimitedFrom(inputStream, c11725e);
        }

        public List<Integer> getLocalNameList() {
            return this.localName_;
        }

        public List<c> getRecordList() {
            return this.record_;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int iComputeMessageSize = 0;
            for (int i2 = 0; i2 < this.record_.size(); i2++) {
                iComputeMessageSize += CodedOutputStream.computeMessageSize(1, this.record_.get(i2));
            }
            int iComputeInt32SizeNoTag = 0;
            for (int i3 = 0; i3 < this.localName_.size(); i3++) {
                iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(this.localName_.get(i3).intValue());
            }
            int iComputeInt32SizeNoTag2 = iComputeMessageSize + iComputeInt32SizeNoTag;
            if (!getLocalNameList().isEmpty()) {
                iComputeInt32SizeNoTag2 = iComputeInt32SizeNoTag2 + 1 + CodedOutputStream.computeInt32SizeNoTag(iComputeInt32SizeNoTag);
            }
            this.localNameMemoizedSerializedSize = iComputeInt32SizeNoTag;
            int size = this.unknownFields.size() + iComputeInt32SizeNoTag2;
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
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i = 0; i < this.record_.size(); i++) {
                codedOutputStream.writeMessage(1, this.record_.get(i));
            }
            if (getLocalNameList().size() > 0) {
                codedOutputStream.writeRawVarint32(42);
                codedOutputStream.writeRawVarint32(this.localNameMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.localName_.size(); i2++) {
                codedOutputStream.writeInt32NoTag(this.localName_.get(i2).intValue());
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

        public e() {
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = AbstractC11723c.f24100j;
        }

        public e(C11724d c11724d, C11725e c11725e, a aVar) throws InvalidProtocolBufferException {
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.record_ = Collections.emptyList();
            this.localName_ = Collections.emptyList();
            AbstractC11723c.b bVarNewOutput = AbstractC11723c.newOutput();
            CodedOutputStream codedOutputStreamNewInstance = CodedOutputStream.newInstance(bVarNewOutput, 1);
            boolean z2 = false;
            int i = 0;
            while (!z2) {
                try {
                    try {
                        int tag = c11724d.readTag();
                        if (tag != 0) {
                            if (tag == 10) {
                                if ((i & 1) != 1) {
                                    this.record_ = new ArrayList();
                                    i |= 1;
                                }
                                this.record_.add((c) c11724d.readMessage(c.f23688k, c11725e));
                            } else if (tag == 40) {
                                if ((i & 2) != 2) {
                                    this.localName_ = new ArrayList();
                                    i |= 2;
                                }
                                this.localName_.add(Integer.valueOf(c11724d.readInt32()));
                            } else if (tag != 42) {
                                if (!c11724d.skipField(tag, codedOutputStreamNewInstance)) {
                                }
                            } else {
                                int iPushLimit = c11724d.pushLimit(c11724d.readRawVarint32());
                                if ((i & 2) != 2 && c11724d.getBytesUntilLimit() > 0) {
                                    this.localName_ = new ArrayList();
                                    i |= 2;
                                }
                                while (c11724d.getBytesUntilLimit() > 0) {
                                    this.localName_.add(Integer.valueOf(c11724d.readInt32()));
                                }
                                c11724d.popLimit(iPushLimit);
                            }
                        }
                        z2 = true;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if ((i & 1) == 1) {
                        this.record_ = Collections.unmodifiableList(this.record_);
                    }
                    if ((i & 2) == 2) {
                        this.localName_ = Collections.unmodifiableList(this.localName_);
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
            if ((i & 1) == 1) {
                this.record_ = Collections.unmodifiableList(this.record_);
            }
            if ((i & 2) == 2) {
                this.localName_ = Collections.unmodifiableList(this.localName_);
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
        C11679d defaultInstance = C11679d.getDefaultInstance();
        c defaultInstance2 = c.getDefaultInstance();
        c defaultInstance3 = c.getDefaultInstance();
        C11743w.b bVar = C11743w.b.f24201t;
        f23651a = AbstractC11727g.newSingularGeneratedExtension(defaultInstance, defaultInstance2, defaultInstance3, null, 100, bVar, c.class);
        f23652b = AbstractC11727g.newSingularGeneratedExtension(C11684i.getDefaultInstance(), c.getDefaultInstance(), c.getDefaultInstance(), null, 100, bVar, c.class);
        C11684i defaultInstance4 = C11684i.getDefaultInstance();
        C11743w.b bVar2 = C11743w.b.f24195n;
        f23653c = AbstractC11727g.newSingularGeneratedExtension(defaultInstance4, 0, null, null, 101, bVar2, Integer.class);
        f23654d = AbstractC11727g.newSingularGeneratedExtension(C11689n.getDefaultInstance(), d.getDefaultInstance(), d.getDefaultInstance(), null, 100, bVar, d.class);
        f23655e = AbstractC11727g.newSingularGeneratedExtension(C11689n.getDefaultInstance(), 0, null, null, 101, bVar2, Integer.class);
        f23656f = AbstractC11727g.newRepeatedGeneratedExtension(C11692q.getDefaultInstance(), C11677b.getDefaultInstance(), null, 100, bVar, false, C11677b.class);
        f23657g = AbstractC11727g.newSingularGeneratedExtension(C11692q.getDefaultInstance(), Boolean.FALSE, null, null, 101, C11743w.b.f24198q, Boolean.class);
        f23658h = AbstractC11727g.newRepeatedGeneratedExtension(C11694s.getDefaultInstance(), C11677b.getDefaultInstance(), null, 100, bVar, false, C11677b.class);
        f23659i = AbstractC11727g.newSingularGeneratedExtension(C11678c.getDefaultInstance(), 0, null, null, 101, bVar2, Integer.class);
        f23660j = AbstractC11727g.newRepeatedGeneratedExtension(C11678c.getDefaultInstance(), C11689n.getDefaultInstance(), null, 102, bVar, false, C11689n.class);
        f23661k = AbstractC11727g.newSingularGeneratedExtension(C11678c.getDefaultInstance(), 0, null, null, 103, bVar2, Integer.class);
        f23662l = AbstractC11727g.newSingularGeneratedExtension(C11678c.getDefaultInstance(), 0, null, null, 104, bVar2, Integer.class);
        f23663m = AbstractC11727g.newSingularGeneratedExtension(C11687l.getDefaultInstance(), 0, null, null, 101, bVar2, Integer.class);
        f23664n = AbstractC11727g.newRepeatedGeneratedExtension(C11687l.getDefaultInstance(), C11689n.getDefaultInstance(), null, 102, bVar, false, C11689n.class);
    }

    public static void registerAllExtensions(C11725e c11725e) {
        c11725e.add(f23651a);
        c11725e.add(f23652b);
        c11725e.add(f23653c);
        c11725e.add(f23654d);
        c11725e.add(f23655e);
        c11725e.add(f23656f);
        c11725e.add(f23657g);
        c11725e.add(f23658h);
        c11725e.add(f23659i);
        c11725e.add(f23660j);
        c11725e.add(f23661k);
        c11725e.add(f23662l);
        c11725e.add(f23663m);
        c11725e.add(f23664n);
    }
}
